package org.example.registry;

import org.example.definition.ArticleExportDefinition;
import org.example.definition.CustomerAddressesExportDefinition;
import org.example.definition.OrderDiscountCodesExportDefinition;
import org.example.definition.OrderItemDiscountAllocationsExportDefinition;
import org.example.definition.OrdersItemsExportDefinition;
import org.example.definition.ProductExportDefinition;
import org.example.definition.ShopifyCsvExportDefinition;

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
        register(definitions, new OrderDiscountCodesExportDefinition());
        register(definitions, new OrdersItemsExportDefinition());
        register(definitions, new CustomerAddressesExportDefinition());
        register(definitions, new OrderItemDiscountAllocationsExportDefinition());
        registerAliases(definitions);
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

    private static void registerAliases(Map<String, ShopifyCsvExportDefinition> definitions) {
        registerAlias(definitions, "Atricles", "Articles");
        registerAlias(definitions, "OrderDiscountCoeds", "OrderDiscountCodes");
        registerAlias(definitions, "OrderDiscountCode", "OrderDiscountCodes");
        registerAlias(definitions, "OrderItems", "OrdersItems");
        registerAlias(definitions, "OrderItemDIscountAllocations", "OrderItemDiscountAllocations");
        registerAlias(definitions, "OrderItemDiscountAllocation", "OrderItemDiscountAllocations");
    }
}
