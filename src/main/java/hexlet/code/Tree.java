package hexlet.code;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.function.Function;

public class Tree {
    public static List<Map<String, Object>> buildTree(Map<String, Object> data1, Map<String, Object> data2) {

        var diff = new ArrayList<Map<String, Object>>();
        var sortedKeys = new TreeSet<String>(data1.keySet());
        sortedKeys.addAll(data2.keySet());

        Function<String, Map<String, Object>> buildNode = key -> {
            var value1 = data1.get(key);
            var value2 = data2.get(key);
            Map<String, Object> node = new HashMap<>();
            node.put("key", key);

            if (!data1.containsKey(key) && data2.containsKey(key)) {
                node.put("type", "added");
                node.put("value", value2);
            } else if (data1.containsKey(key) && !data2.containsKey(key)) {
                node.put("type", "deleted");
                node.put("value", value1);
            } else if (data1.containsKey(key) && data2.containsKey(key) && !isEqual(value1, value2)) {
                node.put("type", "changed");
                node.put("value1", value1);
                node.put("value2", value2);
            } else {
                node.put("type", "unchanged");
                node.put("value", value1);
            }

            return node;
        };
        System.out.println(sortedKeys.stream().map(buildNode).toList());

        return sortedKeys.stream().map(buildNode).toList();
    }

    private static boolean isEqual(Object value1, Object value2) {
        if (value2 == null || value1 == null) {
            return value1 == value2;
        }

        return value1.equals(value2);
    }
}
