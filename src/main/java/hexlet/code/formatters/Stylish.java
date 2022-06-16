package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stylish {
    public static String format(List<Map<String, Object>> tree) {
        Function<Map<String, Object>, String> formatNode = node -> {
            var type = node.get("type").toString();
            var key = node.get("key");
            var value = node.get("value");
            var value1 = node.get("value1");
            var value2 = node.get("value2");
            var indent = "  ";
            return switch (type) {
                case "added" -> String.format("%s+ %s: %s", indent, key, stringify(value));
                case "deleted" -> String.format("%s- %s: %s", indent, key, stringify(value));
                case "changed" -> String.format("%s- %s: %s\n", indent, key, stringify(value1))
                        + String.format("%s+ %s: %s", indent, key, stringify(value2));
                case  "unchanged" -> String.format("%s  %s: %s", indent, key, stringify(value));
                default -> throw new RuntimeException();
            };
        };

        var items = tree.stream()
                .map(formatNode)
                .collect(Collectors.joining("\n"));
        return "{\n" + items + "\n}";
    }

    private static String stringify(Object value) {
        if (value == null) {
            return "null";
        }

        return value.toString();
    }
}
