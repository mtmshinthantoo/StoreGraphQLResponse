package org.example.extract;

final class SingleLineValueExtractor implements ValueExtractor {
    private final ValueExtractor extractor;

    SingleLineValueExtractor(ValueExtractor extractor) {
        if (extractor == null) {
            throw new IllegalArgumentException("Extractor is required.");
        }
        this.extractor = extractor;
    }

    @Override
    public String extract(JsonValue context) {
        return extractor.extract(context)
                .replace("\r\n", " ")
                .replace("\r", " ")
                .replace("\n", " ")
                .replaceAll("\\s+", " ")
                .trim();
    }
}
