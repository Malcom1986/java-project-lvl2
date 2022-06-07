package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, Object>> tree) {
        var formatted = new StringBuilder("{\n");
        var indent = 2;
        for (Map<String, Object> node: tree) {
            var key = node.get("key");
            var nodeType = node.get("type").toString();
            switch (nodeType) {
                case "added":
                    formatted
                            .append(" ".repeat(indent))
                            .append("+ ").append(key).append(": ")
                            .append(node.get("value"))
                            .append("\n");
                    break;
                case "deleted":
                    formatted
                            .append(" ".repeat(indent))
                            .append("- ").append(key).append(": ")
                            .append(node.get("value"))
                            .append("\n");
                    break;
                case "unchanged":
                    formatted
                            .append(" ".repeat(indent))
                            .append("  ").append(key).append(": ")
                            .append(node.get("value"))
                            .append("\n");
                    break;
                case "changed":
                    formatted
                            .append(" ".repeat(indent))
                            .append("- ").append(key).append(": ")
                            .append(node.get("value1"))
                            .append("\n")
                            .append(" ".repeat(indent)).append("+ ").append(key).append(": ")
                            .append(node.get("value2"))
                            .append("\n");
                default:
                    break;
            }
        }
        formatted.append("}");
        return formatted.toString();
    }
}
