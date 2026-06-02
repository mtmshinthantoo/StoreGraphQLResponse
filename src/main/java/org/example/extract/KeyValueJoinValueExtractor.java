package org.example.extract;

import java.util.ArrayList;
import java.util.List;

final class KeyValueJoinValueExtractor implements ValueExtractor {
    private final String path;
    private final String keyPath;
    private final String valuePath;
    private final String delimiter;

    KeyValueJoinValueExtractor(String path, String keyPath, String valuePath, String delimiter) {
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Join path is required.");
        }
        if (keyPath == null || keyPath.isBlank()) {
            throw new IllegalArgumentException("Key path is required.");
        }
        if (valuePath == null || valuePath.isBlank()) {
            throw new IllegalArgumentException("Value path is required.");
        }
        this.path = path;
        this.keyPath = keyPath;
        this.valuePath = valuePath;
        this.delimiter = delimiter == null ? "," : delimiter;
    }

    @Override
    public String extract(JsonValue context) {
        List<JsonValue> items = JsonPath.findMany(context, path);
        if (items.isEmpty()) {
            return "";
        }

        List<String> parts = new ArrayList<>();
        for (JsonValue item : items) {
            String key = JsonValues.toCellValue(JsonPath.findOne(item, keyPath));
            String value = JsonValues.toCellValue(JsonPath.findOne(item, valuePath));
            if (!key.isBlank() || !value.isBlank()) {
                parts.add(key + "=" + value);
            }
        }
        return String.join(delimiter, parts);
    }
}
