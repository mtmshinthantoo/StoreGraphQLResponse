package org.example.extract;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class JsonParser {
    private final String json;
    private int position;

    private JsonParser(String json) {
        this.json = json == null ? "" : json;
    }

    static JsonValue parse(String json) {
        JsonParser parser = new JsonParser(json);
        JsonValue value = parser.parseValue();
        parser.skipWhitespace();
        if (!parser.isAtEnd()) {
            throw parser.error("Unexpected trailing content.");
        }
        return value;
    }

    private JsonValue parseValue() {
        skipWhitespace();
        if (isAtEnd()) {
            throw error("Expected JSON value.");
        }

        char current = peek();
        return switch (current) {
            case '{' -> parseObject();
            case '[' -> parseArray();
            case '"' -> JsonValue.string(parseString());
            case 't' -> parseLiteral("true", JsonValue.bool(true));
            case 'f' -> parseLiteral("false", JsonValue.bool(false));
            case 'n' -> parseLiteral("null", JsonValue.nullValue());
            default -> {
                if (current == '-' || Character.isDigit(current)) {
                    yield parseNumber();
                }
                throw error("Unexpected character '" + current + "'.");
            }
        };
    }

    private JsonValue parseObject() {
        expect('{');
        skipWhitespace();

        Map<String, JsonValue> values = new LinkedHashMap<>();
        if (tryConsume('}')) {
            return JsonValue.object(values);
        }

        while (true) {
            skipWhitespace();
            String key = parseString();
            skipWhitespace();
            expect(':');
            values.put(key, parseValue());
            skipWhitespace();

            if (tryConsume('}')) {
                return JsonValue.object(values);
            }
            expect(',');
        }
    }

    private JsonValue parseArray() {
        expect('[');
        skipWhitespace();

        List<JsonValue> values = new ArrayList<>();
        if (tryConsume(']')) {
            return JsonValue.array(values);
        }

        while (true) {
            values.add(parseValue());
            skipWhitespace();

            if (tryConsume(']')) {
                return JsonValue.array(values);
            }
            expect(',');
        }
    }

    private String parseString() {
        expect('"');
        StringBuilder value = new StringBuilder();

        while (!isAtEnd()) {
            char current = advance();
            if (current == '"') {
                return value.toString();
            }
            if (current != '\\') {
                value.append(current);
                continue;
            }

            if (isAtEnd()) {
                throw error("Unfinished escape sequence.");
            }
            char escaped = advance();
            switch (escaped) {
                case '"' -> value.append('"');
                case '\\' -> value.append('\\');
                case '/' -> value.append('/');
                case 'b' -> value.append('\b');
                case 'f' -> value.append('\f');
                case 'n' -> value.append('\n');
                case 'r' -> value.append('\r');
                case 't' -> value.append('\t');
                case 'u' -> value.append(parseUnicodeEscape());
                default -> throw error("Unsupported escape sequence '\\" + escaped + "'.");
            }
        }

        throw error("Unterminated string.");
    }

    private char parseUnicodeEscape() {
        if (position + 4 > json.length()) {
            throw error("Incomplete unicode escape.");
        }
        String hex = json.substring(position, position + 4);
        position += 4;
        try {
            return (char) Integer.parseInt(hex, 16);
        } catch (NumberFormatException e) {
            throw error("Invalid unicode escape.");
        }
    }

    private JsonValue parseNumber() {
        int start = position;
        tryConsume('-');
        consumeDigits();
        if (tryConsume('.')) {
            consumeDigits();
        }
        if (tryConsume('e') || tryConsume('E')) {
            if (!tryConsume('+')) {
                tryConsume('-');
            }
            consumeDigits();
        }
        return JsonValue.number(json.substring(start, position));
    }

    private void consumeDigits() {
        int start = position;
        while (!isAtEnd() && Character.isDigit(peek())) {
            position++;
        }
        if (start == position) {
            throw error("Expected digit.");
        }
    }

    private JsonValue parseLiteral(String literal, JsonValue value) {
        if (!json.startsWith(literal, position)) {
            throw error("Expected '" + literal + "'.");
        }
        position += literal.length();
        return value;
    }

    private void skipWhitespace() {
        while (!isAtEnd() && Character.isWhitespace(peek())) {
            position++;
        }
    }

    private void expect(char expected) {
        if (isAtEnd() || advance() != expected) {
            throw error("Expected '" + expected + "'.");
        }
    }

    private boolean tryConsume(char expected) {
        if (!isAtEnd() && peek() == expected) {
            position++;
            return true;
        }
        return false;
    }

    private char peek() {
        return json.charAt(position);
    }

    private char advance() {
        return json.charAt(position++);
    }

    private boolean isAtEnd() {
        return position >= json.length();
    }

    private IllegalArgumentException error(String message) {
        return new IllegalArgumentException(message + " At JSON character " + position + ".");
    }
}
