package org.example.extract;

import java.util.ArrayList;
import java.util.List;

final class JsonPath {
    private JsonPath() {
    }

    static JsonValue findOne(JsonValue context, String path) {
        List<JsonValue> matches = findMany(context, path);
        return matches.isEmpty() ? JsonValue.nullValue() : matches.get(0);
    }

    static List<JsonValue> findMany(JsonValue context, String path) {
        if (context == null || context.isNull()) {
            return List.of();
        }
        if (path == null || path.isBlank()) {
            return List.of(context);
        }

        List<JsonValue> current = List.of(context);
        for (String segment : path.split("\\.")) {
            List<JsonValue> next = new ArrayList<>();
            for (JsonValue node : current) {
                collectSegment(node, segment, next);
            }
            current = next;
            if (current.isEmpty()) {
                return List.of();
            }
        }
        return current;
    }

    private static void collectSegment(JsonValue node, String segment, List<JsonValue> results) {
        if (node == null || node.isNull()) {
            return;
        }
        if (node.isArray()) {
            for (JsonValue item : node.asArray()) {
                collectSegment(item, segment, results);
            }
            return;
        }

        JsonValue child = node.get(segment);
        if (child.isNull()) {
            return;
        }
        if (child.isArray()) {
            results.addAll(child.asArray());
            return;
        }
        results.add(child);
    }
}
