package org.example.extract;

@FunctionalInterface
public interface ValueExtractor {
    String extract(JsonValue context);
}
