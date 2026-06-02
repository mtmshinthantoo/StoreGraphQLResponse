package org.example.extract;

public final class Extractors {
    private Extractors() {
    }

    public static ValueExtractor value(String path) {
        return new PathValueExtractor(path);
    }

    public static ValueExtractor singleLine(String path) {
        return new SingleLineValueExtractor(value(path));
    }

    public static ValueExtractor join(String path, String delimiter) {
        return new JoinValueExtractor(path, null, delimiter);
    }

    public static ValueExtractor join(String path, String itemValuePath, String delimiter) {
        return new JoinValueExtractor(path, itemValuePath, delimiter);
    }

    public static ValueExtractor joinKeyValue(String path, String keyPath, String valuePath, String delimiter) {
        return new KeyValueJoinValueExtractor(path, keyPath, valuePath, delimiter);
    }

    public static ValueExtractor coalesce(String... paths) {
        return new CoalesceValueExtractor(paths);
    }
}
