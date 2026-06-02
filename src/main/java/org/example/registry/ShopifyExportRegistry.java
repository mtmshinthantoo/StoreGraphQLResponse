package org.example.registry;

import org.example.definition.*;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ShopifyExportRegistry {
    private ShopifyExportRegistry() {
    }

    public static Map<String, ShopifyCsvExportDefinition> defaultDefinitions() {
        Map<String, ShopifyCsvExportDefinition> definitions = new LinkedHashMap<>();
        register(definitions, new ProductExportDefinition());
        register(definitions, new ArticleExportDefinition());
        registerAlias(definitions, "Atricles", "Articles");
        register(definitions, new OrderDiscountCodesExportDefinition());
        registerAlias(definitions, "OrderDiscountCoeds", "OrderDiscountCodes");
        registerAlias(definitions, "OrderDiscountCode", "OrderDiscountCodes");
        register(definitions, new OrdersItemsExportDefinition());
        registerAlias(definitions, "OrderItems", "OrdersItems");
        register(definitions, new CustomerAddressesExportDefinition());
        return Collections.unmodifiableMap(definitions);
    }

    private static void register(Map<String, ShopifyCsvExportDefinition> definitions,
                                 ShopifyCsvExportDefinition definition) {
        if (definitions.containsKey(definition.exportName())) {
            throw new IllegalStateException("Duplicate export name: " + definition.exportName());
        }
        definitions.put(definition.exportName(), definition);
    }

    private static void registerAlias(Map<String, ShopifyCsvExportDefinition> definitions,
                                      String alias,
                                      String exportName) {
        ShopifyCsvExportDefinition definition = definitions.get(exportName);
        if (definition == null) {
            throw new IllegalStateException("Cannot register alias for unknown export: " + exportName);
        }
        definitions.put(alias, definition);
    }
}
