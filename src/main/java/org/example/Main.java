package org.example;

import org.example.definition.ShopifyCsvExportDefinition;
import org.example.extract.CsvExtractor;
import org.example.registry.ShopifyExportRegistry;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, ShopifyCsvExportDefinition> definitions = ShopifyExportRegistry.defaultDefinitions();
        if (args.length == 0 || args[0].isBlank()) {
            System.out.println("Please provide an export name.");
            System.out.println("Available exports: " + String.join(", ", uniqueExportNames(definitions)));
            return;
        }

        String exportName = args[0].trim();
        ShopifyCsvExportDefinition definition = findDefinition(definitions, exportName);

        if (definition == null) {
            System.err.println("Unknown export: " + exportName);
            System.err.println("Available exports: " + String.join(", ", uniqueExportNames(definitions)));
            return;
        }

        String csv = new CsvExtractor().extract(definition);
        System.out.println(csv);
    }

    private static ShopifyCsvExportDefinition findDefinition(Map<String, ShopifyCsvExportDefinition> definitions,
                                                             String exportName) {
        ShopifyCsvExportDefinition exactMatch = definitions.get(exportName);
        if (exactMatch != null) {
            return exactMatch;
        }

        return definitions.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(exportName))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }

    private static java.util.List<String> uniqueExportNames(Map<String, ShopifyCsvExportDefinition> definitions) {
        return definitions.values().stream()
                .map(ShopifyCsvExportDefinition::exportName)
                .distinct()
                .toList();
    }
}
