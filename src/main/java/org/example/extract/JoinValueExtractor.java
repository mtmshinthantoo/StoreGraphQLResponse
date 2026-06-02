package org.example.extract;

import java.util.ArrayList;
import java.util.List;

final class JoinValueExtractor implements ValueExtractor {
    private final String path;
    private final String itemValuePath;
    private final String delimiter;

    JoinValueExtractor(String path, String itemValuePath, String delimiter) {
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Join path is required.");
        }
        this.path = path;
        this.itemValuePath = itemValuePath;
        this.delimiter = delimiter == null ? "," : delimiter;
    }

    @Override
    public String extract(JsonValue context) {
        List<JsonValue> values = JsonPath.findMany(context, path);
        if (values.isEmpty()) {
            return "";
        }

        List<String> parts = new ArrayList<>();
        for (JsonValue value : values) {
            JsonValue finalValue = itemValuePath == null || itemValuePath.isBlank()
                    ? value
                    : JsonPath.findOne(value, itemValuePath);
            String text = JsonValues.toCellValue(finalValue);
            if (!text.isBlank()) {
                parts.add(text);
            }
        }
        return String.join(delimiter, parts);
    }
}
