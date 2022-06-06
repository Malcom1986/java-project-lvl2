package hexlet.code;

import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> diff, String format) {
        return switch (format) {
            case "stylish" -> Stylish.format(diff);
            default -> throw new RuntimeException("unknown format");
        };


    }

}
