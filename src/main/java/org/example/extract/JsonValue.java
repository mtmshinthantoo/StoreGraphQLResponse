package org.example.extract;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class JsonValue {
    private enum Type {
        OBJECT,
        ARRAY,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL
    }

    private static final JsonValue NULL = new JsonValue(Type.NULL, null);

    private final Type type;
    private final Object value;

    private JsonValue(Type type, Object value) {
        this.type = type;
        this.value = value;
    }

    static JsonValue object(Map<String, JsonValue> value) {
        return new JsonValue(Type.OBJECT, Collections.unmodifiableMap(new LinkedHashMap<>(value)));
    }

    static JsonValue array(List<JsonValue> value) {
        return new JsonValue(Type.ARRAY, List.copyOf(value));
    }

    static JsonValue string(String value) {
        return new JsonValue(Type.STRING, value);
    }

    static JsonValue number(String value) {
        return new JsonValue(Type.NUMBER, value);
    }

    static JsonValue bool(boolean value) {
        return new JsonValue(Type.BOOLEAN, value);
    }

    static JsonValue nullValue() {
        return NULL;
    }

    public boolean isObject() {
        return type == Type.OBJECT;
    }

    public boolean isArray() {
        return type == Type.ARRAY;
    }

    public boolean isString() {
        return type == Type.STRING;
    }

    public boolean isNumber() {
        return type == Type.NUMBER;
    }

    public boolean isBoolean() {
        return type == Type.BOOLEAN;
    }

    public boolean isNull() {
        return type == Type.NULL;
    }

    public JsonValue get(String key) {
        if (!isObject()) {
            return NULL;
        }
        return asObject().getOrDefault(key, NULL);
    }

    @SuppressWarnings("unchecked")
    public Map<String, JsonValue> asObject() {
        if (!isObject()) {
            throw new IllegalStateException("JSON value is not an object.");
        }
        return (Map<String, JsonValue>) value;
    }

    @SuppressWarnings("unchecked")
    public List<JsonValue> asArray() {
        if (!isArray()) {
            throw new IllegalStateException("JSON value is not an array.");
        }
        return (List<JsonValue>) value;
    }

    public String asScalarText() {
        if (isNull()) {
            return "";
        }
        if (isString() || isNumber() || isBoolean()) {
            return String.valueOf(value);
        }
        return toCompactJson();
    }

    public String toCompactJson() {
        StringBuilder json = new StringBuilder();
        appendJson(json);
        return json.toString();
    }

    private void appendJson(StringBuilder json) {
        switch (type) {
            case OBJECT -> {
                json.append('{');
                int index = 0;
                for (Map.Entry<String, JsonValue> entry : asObject().entrySet()) {
                    if (index++ > 0) {
                        json.append(',');
                    }
                    appendQuoted(json, entry.getKey());
                    json.append(':');
                    entry.getValue().appendJson(json);
                }
                json.append('}');
            }
            case ARRAY -> {
                json.append('[');
                for (int i = 0; i < asArray().size(); i++) {
                    if (i > 0) {
                        json.append(',');
                    }
                    asArray().get(i).appendJson(json);
                }
                json.append(']');
            }
            case STRING -> appendQuoted(json, String.valueOf(value));
            case NUMBER, BOOLEAN -> json.append(value);
            case NULL -> json.append("null");
        }
    }

    private static void appendQuoted(StringBuilder json, String text) {
        json.append('"');
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            switch (character) {
                case '"' -> json.append("\\\"");
                case '\\' -> json.append("\\\\");
                case '\b' -> json.append("\\b");
                case '\f' -> json.append("\\f");
                case '\n' -> json.append("\\n");
                case '\r' -> json.append("\\r");
                case '\t' -> json.append("\\t");
                default -> {
                    if (character < 0x20) {
                        json.append(String.format("\\u%04x", (int) character));
                    } else {
                        json.append(character);
                    }
                }
            }
        }
        json.append('"');
    }
}
