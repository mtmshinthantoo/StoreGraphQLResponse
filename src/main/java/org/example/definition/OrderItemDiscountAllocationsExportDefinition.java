package org.example.definition;

import org.example.config.CsvExportConfig;

import static org.example.extract.Extractors.value;

public final class OrderItemDiscountAllocationsExportDefinition implements ShopifyCsvExportDefinition {
    @Override
    public String exportName() {
        return "OrderItemDiscountAllocations";
    }

    @Override
    public String apiResponse() {
        return """
                {
                  "data": {
                    "orders": {
                      "edges": [
                        {
                          "node": {
                            "id": "gid://shopify/Order/5785577849077",
                            "updatedAt": "2024-07-09T03:13:20Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/14660799496437",
                                    "discountAllocations": []
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/5993276965109",
                            "updatedAt": "2024-07-09T08:41:34Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/15077243617525",
                                    "discountAllocations": []
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/5993326248181",
                            "updatedAt": "2024-07-09T03:21:45Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/15077340086517",
                                    "discountAllocations": []
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/5993330475253",
                            "updatedAt": "2024-07-09T03:27:27Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/15077348049141",
                                    "discountAllocations": []
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/5993342501109",
                            "updatedAt": "2025-09-04T02:44:37Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/15077376065781",
                                    "discountAllocations": []
                                  }
                                },
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/15077376098549",
                                    "discountAllocations": []
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/5993543139573",
                            "updatedAt": "2024-07-09T09:00:04Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/15077698699509",
                                    "discountAllocations": []
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/5993561227509",
                            "updatedAt": "2024-07-09T09:00:10Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/15077729763573",
                                    "discountAllocations": []
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/5993561981173",
                            "updatedAt": "2025-09-09T07:47:02Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/15077730975989",
                                    "discountAllocations": []
                                  }
                                },
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16314187481333",
                                    "discountAllocations": []
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/5993563750645",
                            "updatedAt": "2025-08-25T03:50:11Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/15077733499125",
                                    "discountAllocations": []
                                  }
                                },
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16314195345653",
                                    "discountAllocations": []
                                  }
                                },
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16540371222773",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "2000.0",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "2000.0",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "2000.0"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      }
                                    ]
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/6621555917045",
                            "updatedAt": "2025-08-27T04:40:21Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16314194755829",
                                    "discountAllocations": []
                                  }
                                },
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16540334620917",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "24.6",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "24.6",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "24.6"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      }
                                    ]
                                  }
                                },
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16547360112885",
                                    "discountAllocations": []
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/6736369385717",
                            "updatedAt": "2025-09-09T07:52:50Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16547696836853",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "4000.0",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "4000.0",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "4000.0"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      }
                                    ]
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/6745244598517",
                            "updatedAt": "2025-09-01T02:50:55Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16566801989877",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "1000.0",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "1000.0",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "1000.0"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      },
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "17000.0",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "17000.0",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "17000.0"
                                        },
                                        "discountApplication": {
                                          "index": 1
                                        }
                                      }
                                    ]
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/6745246499061",
                            "updatedAt": "2025-09-01T02:52:34Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16566806872309",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "17000.0",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "17000.0",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "17000.0"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      }
                                    ]
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/6745248760053",
                            "updatedAt": "2025-09-01T02:54:49Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16566812279029",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "1000.0",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "1000.0",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "1000.0"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      },
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "17000.0",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "17000.0",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "17000.0"
                                        },
                                        "discountApplication": {
                                          "index": 1
                                        }
                                      }
                                    ]
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/6745261375733",
                            "updatedAt": "2025-09-01T03:07:00Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16566845079797",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "115.79",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "115.79",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "115.79"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      },
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "22500.0",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "22500.0",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "22500.0"
                                        },
                                        "discountApplication": {
                                          "index": 1
                                        }
                                      }
                                    ]
                                  }
                                },
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16566845112565",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "84.21",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "84.21",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "84.21"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      }
                                    ]
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/6745294045429",
                            "updatedAt": "2025-09-01T03:40:21Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16566924083445",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "49500.0",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "49500.0",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "49500.0"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      }
                                    ]
                                  }
                                },
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16566924116213",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "19800.0",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "19800.0",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "19800.0"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      }
                                    ]
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/6745299353845",
                            "updatedAt": "2025-09-01T03:45:39Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16566937256181",
                                    "discountAllocations": []
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/6745465389301",
                            "updatedAt": "2025-09-01T04:47:43Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16567190225141",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "200.0",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "200.0",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "200.0"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      }
                                    ]
                                  }
                                },
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16567190257909",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "100.0",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "100.0",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "100.0"
                                        },
                                        "discountApplication": {
                                          "index": 1
                                        }
                                      }
                                    ]
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/6745502286069",
                            "updatedAt": "2025-09-04T02:49:08Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16567263396085",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "1.13",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "1.13",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "1.13"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      },
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "2.0",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "2.0",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "2.0"
                                        },
                                        "discountApplication": {
                                          "index": 3
                                        }
                                      }
                                    ]
                                  }
                                },
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16567263428853",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "62.57",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "62.57",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "62.57"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      }
                                    ]
                                  }
                                },
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16567263461621",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "24.9",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "24.9",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "24.9"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      },
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "100.0",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "100.0",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "100.0"
                                        },
                                        "discountApplication": {
                                          "index": 1
                                        }
                                      }
                                    ]
                                  }
                                },
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16567263494389",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "0.15",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "0.15",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "0.15"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      },
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "1.0",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "1.0",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "1.0"
                                        },
                                        "discountApplication": {
                                          "index": 4
                                        }
                                      }
                                    ]
                                  }
                                },
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16567263527157",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "6.25",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "6.25",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "6.25"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      },
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "1.88",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "1.88",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "1.88"
                                        },
                                        "discountApplication": {
                                          "index": 2
                                        }
                                      }
                                    ]
                                  }
                                },
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16567263559925",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "3.75",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "3.75",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "3.75"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      },
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "1.12",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "1.12",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "1.12"
                                        },
                                        "discountApplication": {
                                          "index": 2
                                        }
                                      }
                                    ]
                                  }
                                },
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16567263592693",
                                    "discountAllocations": [
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "1.25",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "1.25",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "1.25"
                                        },
                                        "discountApplication": {
                                          "index": 0
                                        }
                                      },
                                      {
                                        "allocatedAmountSet": {
                                          "shopMoney": {
                                            "amount": "1.0",
                                            "currencyCode": "MMK"
                                          },
                                          "presentmentMoney": {
                                            "amount": "1.0",
                                            "currencyCode": "MMK"
                                          }
                                        },
                                        "allocatedAmount": {
                                          "amount": "1.0"
                                        },
                                        "discountApplication": {
                                          "index": 5
                                        }
                                      }
                                    ]
                                  }
                                }
                              ]
                            }
                          }
                        },
                        {
                          "node": {
                            "id": "gid://shopify/Order/6745739526389",
                            "updatedAt": "2025-09-01T08:34:28Z",
                            "lineItems": {
                              "edges": [
                                {
                                  "node": {
                                    "id": "gid://shopify/LineItem/16567612276981",
                                    "discountAllocations": []
                                  }
                                }
                              ]
                            }
                          }
                        }
                      ],
                      "pageInfo": {
                        "hasNextPage": false,
                        "endCursor": "eyJsYXN0X2lkIjo2NzQ1NzM5NTI2Mzg5LCJsYXN0X3ZhbHVlIjoiMjAyNS0wOS0wMSAwODozNDoyNC4zNDk3MjQifQ=="
                      }
                    }
                  },
                  "extensions": {
                    "cost": {
                      "requestedQueryCost": 398,
                      "actualQueryCost": 6,
                      "throttleStatus": {
                        "maximumAvailable": 2000,
                        "currentlyAvailable": 1994,
                        "restoreRate": 100
                      }
                    }
                  }
                }
                """;
    }

    @Override
    public CsvExportConfig config() {
        return CsvExportConfig.builder()
                .rootRows("data.orders.edges")
                .addColumn("Order ID", value("node.id"))
                .addColumn("Order Updated At", value("node.updatedAt"))
                .explodeRows("node.lineItems.edges", lineItem -> lineItem
                        .skipWhenEmpty()
                        .addColumn("Line Item ID", value("node.id")))
                .explodeRows("node.discountAllocations", discountAllocation -> discountAllocation
                        .skipWhenEmpty()
                        .addColumn("Allocated Shop Amount", value("allocatedAmountSet.shopMoney.amount"))
                        .addColumn("Allocated Shop Currency", value("allocatedAmountSet.shopMoney.currencyCode"))
                        .addColumn("Allocated Presentment Amount", value("allocatedAmountSet.presentmentMoney.amount"))
                        .addColumn("Allocated Presentment Currency", value("allocatedAmountSet.presentmentMoney.currencyCode"))
                        .addColumn("Allocated Amount", value("allocatedAmount.amount"))
                        .addColumn("Discount Application Index", value("discountApplication.index")))
                .build();
    }
}
