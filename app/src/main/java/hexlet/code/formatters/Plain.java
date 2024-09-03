package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Plain {
    public  static String format(List<Map<String, Object>> tree) {
        Function<Map<String, Object>, String> formatNode = node -> {
            var type = node.get("type").toString();
            var key = node.get("key");
            var value = node.get("value");
            var value1 = node.get("value1");
            var value2 = node.get("value2");
            return switch (type) {
                case "added" -> String.format("Property '%s' was added with value: %s", key, stringify(value));
                case "deleted" -> String.format("Property '%s' was removed", key);
                case "changed" -> String.format(
                        "Property '%s' was updated. From %s to %s",
                        key, stringify(value1), stringify(value2));
                default -> throw new RuntimeException();
            };
        };

        return tree.stream()
                .filter(node -> !node.get("type").equals("unchanged"))
                .map(formatNode)
                .collect(Collectors.joining("\n"));
    }

    private  static String stringify(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return String.format("'%s'", value);
        }
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }
        return value.toString();
    }

}
