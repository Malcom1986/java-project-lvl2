package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> tree, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.format(tree);
            case "plain" -> Plain.format(tree);
            case  "json" -> Json.format(tree);
            default -> throw new RuntimeException("unknown format");
        };


    }

}
