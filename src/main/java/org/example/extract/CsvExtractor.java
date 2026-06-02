package org.example.extract;

import org.example.config.ColumnMapping;
import org.example.config.CsvExportConfig;
import org.example.config.EmptyExplosionBehavior;
import org.example.config.RowExplosion;
import org.example.definition.ShopifyCsvExportDefinition;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class CsvExtractor {
    private record RowState(JsonValue context, Map<String, String> values) {
    }

    public String extract(ShopifyCsvExportDefinition definition) {
        JsonValue response = JsonParser.parse(definition.apiResponse());
        CsvExportConfig config = definition.config();
        List<JsonValue> rootRows = JsonPath.findMany(response, config.rootRowsPath());
        List<String> headers = headers(config);
        List<List<String>> records = new ArrayList<>();

        for (JsonValue rootRow : rootRows) {
            List<Map<String, String>> rows = expandRows(rootRow, config);
            for (Map<String, String> row : rows) {
                records.add(headers.stream().map(header -> row.getOrDefault(header, "")).toList());
            }
        }

        return CsvWriter.write(headers, records);
    }

    private List<String> headers(CsvExportConfig config) {
        List<String> headers = new ArrayList<>();
        config.columns().forEach(column -> headers.add(column.columnName()));
        config.rowExplosions().forEach(explosion ->
                explosion.columns().forEach(column -> headers.add(column.columnName())));
        return headers;
    }

    private List<Map<String, String>> expandRows(JsonValue rootRow, CsvExportConfig config) {
        Map<String, String> parentValues = extractColumns(rootRow, config.columns());
        if (config.rowExplosions().isEmpty()) {
            return List.of(parentValues);
        }

        List<RowState> rows = new ArrayList<>();
        rows.add(new RowState(rootRow, parentValues));

        for (RowExplosion explosion : config.rowExplosions()) {
            List<RowState> nextRows = new ArrayList<>();

            for (RowState existingRow : rows) {
                List<JsonValue> children = JsonPath.findMany(existingRow.context(), explosion.path());
                if (children.isEmpty()) {
                    if (explosion.emptyBehavior() == EmptyExplosionBehavior.SKIP_ROW) {
                        continue;
                    }
                    Map<String, String> rowWithBlankChildColumns = new LinkedHashMap<>(existingRow.values());
                    explosion.columns().forEach(column -> rowWithBlankChildColumns.put(column.columnName(), ""));
                    nextRows.add(new RowState(existingRow.context(), rowWithBlankChildColumns));
                    continue;
                }

                for (JsonValue child : children) {
                    Map<String, String> explodedRow = new LinkedHashMap<>(existingRow.values());
                    explodedRow.putAll(extractColumns(child, explosion.columns()));
                    nextRows.add(new RowState(child, explodedRow));
                }
            }
            rows = nextRows;
        }

        return rows.stream().map(RowState::values).toList();
    }

    private Map<String, String> extractColumns(JsonValue row, List<ColumnMapping> columns) {
        Map<String, String> values = new LinkedHashMap<>();
        columns.forEach(column -> values.put(column.columnName(), column.extractor().extract(row)));
        return values;
    }
}
