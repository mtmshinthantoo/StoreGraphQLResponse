package org.example.definition;

import org.example.config.CsvExportConfig;

import static org.example.extract.Extractors.join;
import static org.example.extract.Extractors.value;

public final class ProductExportDefinition implements ShopifyCsvExportDefinition {
    @Override
    public String exportName() {
        return "products";
    }

    @Override
    public String apiResponse() {
        return """
            {
              "data": {
                "products": {
                  "edges": [
                    {
                      "node": {
                        "id": "gid://shopify/Product/1001",
                        "title": "Everyday T-Shirt",
                        "vendor": "ACME, Inc.",
                        "status": "ACTIVE",
                        "tags": ["summer", "cotton", "featured"],
                        "variants": {
                          "edges": [
                            {
                              "node": {
                                "id": "gid://shopify/ProductVariant/2001",
                                "sku": "TSHIRT-S-BLK",
                                "title": "Small / Black",
                                "price": "19.99",
                                "selectedOptions": [
                                  { "name": "Size", "value": "Small" },
                                  { "name": "Color", "value": "Black" }
                                ]
                              }
                            },
                            {
                              "node": {
                                "id": "gid://shopify/ProductVariant/2002",
                                "sku": "TSHIRT-M-BLK",
                                "title": "Medium / Black",
                                "price": "19.99",
                                "selectedOptions": [
                                  { "name": "Size", "value": "Medium" },
                                  { "name": "Color", "value": "Black" }
                                ]
                              }
                            }
                          ]
                        }
                      }
                    },
                    {
                      "node": {
                        "id": "gid://shopify/Product/1002",
                        "title": "Ceramic Mug",
                        "vendor": "ACME, Inc.",
                        "status": "DRAFT",
                        "tags": ["kitchen", "gift"],
                        "variants": {
                          "edges": [
                            {
                              "node": {
                                "id": "gid://shopify/ProductVariant/3001",
                                "sku": "MUG-WHT",
                                "title": "White",
                                "price": "12.50",
                                "selectedOptions": [
                                  { "name": "Color", "value": "White" }
                                ]
                              }
                            }
                          ]
                        }
                      }
                    }
                  ]
                }
              }
            }
            """;
    }

    @Override
    public CsvExportConfig config() {
        return CsvExportConfig.builder()
                .rootRows("data.products.edges")
                .addColumn("Product ID", value("node.id"))
                .addColumn("Product Title", value("node.title"))
                .addColumn("Vendor", value("node.vendor"))
                .addColumn("Status", value("node.status"))
                .addColumn("Tags", join("node.tags", ","))
                .explodeRows("node.variants.edges", variant -> variant
                        .addColumn("Variant ID", value("node.id"))
                        .addColumn("Variant SKU", value("node.sku"))
                        .addColumn("Variant Title", value("node.title"))
                        .addColumn("Variant Price", value("node.price"))
                        .addColumn("Variant Options", join("node.selectedOptions", "value", ",")))
                .build();
    }
}
