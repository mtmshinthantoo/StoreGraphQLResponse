package org.example.definition;

import org.example.config.CsvExportConfig;

import static org.example.extract.Extractors.value;

public final class CustomerAddressesExportDefinition implements ShopifyCsvExportDefinition {
    @Override
    public String exportName() {
        return "CustomerAddresses";
    }

    @Override
    public String apiResponse() {
        return """
                {
                    "data": {
                        "customers": {
                            "edges": [
                                {
                                    "node": {
                                        "id": "gid://shopify/Customer/6162372624564",
                                        "addresses": [
                                            {
                                                "id": "gid://shopify/MailingAddress/7430383567028?model_name=CustomerAddress",
                                                "address1": "",
                                                "address2": "",
                                                "city": "",
                                                "company": "",
                                                "country": "Japan",
                                                "countryCodeV2": "JP",
                                                "firstName": "May Soe",
                                                "lastName": "Moe",
                                                "latitude": null,
                                                "longitude": null,
                                                "name": "May Soe Moe",
                                                "phone": "",
                                                "province": "Hokkaidō",
                                                "provinceCode": "JP-01",
                                                "zip": "",
                                                "formattedArea": "Hokkaido, Japan",
                                                "coordinatesValidated": false,
                                                "timeZone": "Asia/Tokyo"
                                            },
                                            {
                                                "id": "gid://shopify/MailingAddress/7601852776628?model_name=CustomerAddress",
                                                "address1": "",
                                                "address2": "",
                                                "city": "",
                                                "company": null,
                                                "country": "Japan",
                                                "countryCodeV2": "JP",
                                                "firstName": "a",
                                                "lastName": "a",
                                                "latitude": null,
                                                "longitude": null,
                                                "name": "a a",
                                                "phone": null,
                                                "province": "Iwate",
                                                "provinceCode": "JP-03",
                                                "zip": "",
                                                "formattedArea": "Iwate, Japan",
                                                "coordinatesValidated": false,
                                                "timeZone": "Asia/Tokyo"
                                            }
                                        ]
                                    }
                                }
                            ],
                            "pageInfo": {
                                "hasNextPage": false,
                                "hasPreviousPage": false,
                                "startCursor": "eyJsYXN0X2lkIjo2MTYyMzcyNjI0NTY0LCJsYXN0X3ZhbHVlIjoiNjE2MjM3MjYyNDU2NCJ9",
                                "endCursor": "eyJsYXN0X2lkIjo2MTYyMzcyNjI0NTY0LCJsYXN0X3ZhbHVlIjoiNjE2MjM3MjYyNDU2NCJ9"
                            }
                        }
                    },
                    "extensions": {
                        "cost": {
                            "requestedQueryCost": 13,
                            "actualQueryCost": 2,
                            "throttleStatus": {
                                "maximumAvailable": 2000.0,
                                "currentlyAvailable": 1998,
                                "restoreRate": 100.0
                            }
                        }
                    }
                }
                """;
    }

    @Override
    public CsvExportConfig config() {
        return CsvExportConfig.builder()
                .rootRows("data.customers.edges")
                .addColumn("Customer Id", value("node.id"))
                .explodeRows("node.addresses", address -> address
                        .skipWhenEmpty()
                        .addColumn("Id", value("id"))
                        .addColumn("Address 1", value("address1"))
                        .addColumn("Address 2", value("address2"))
                        .addColumn("City", value("city"))
                        .addColumn("Company", value("company"))
                        .addColumn("Country", value("country"))
                        .addColumn("Country Code V2", value("countryCodeV2"))
                        .addColumn("First Name", value("firstName"))
                        .addColumn("Last Name", value("lastName"))
                        .addColumn("Latitude", value("latitude"))
                        .addColumn("Longitude", value("longitude"))
                        .addColumn("Name", value("name"))
                        .addColumn("Phone", value("phone"))
                        .addColumn("Province", value("province"))
                        .addColumn("Province Code", value("provinceCode"))
                        .addColumn("Zip", value("zip"))
                        .addColumn("Formatted Area", value("formattedArea"))
                        .addColumn("Coordinates Validated", value("coordinatesValidated"))
                        .addColumn("Time Zone", value("timeZone")))
                .build();
    }
}
