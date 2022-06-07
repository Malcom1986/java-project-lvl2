package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Tree {
    public static List<Map<String, Object>> buildTree(Map<String, Object> data1, Map<String, Object> data2) {

        var diff = new ArrayList<Map<String, Object>>();
        var sortedKeys = new TreeSet<String>(data1.keySet());
        sortedKeys.addAll(data2.keySet());

        for (var key : sortedKeys) {
            var value1 = data1.get(key);
            var value2 = data2.get(key);

            if (!data1.containsKey(key) && data2.containsKey(key)) {
                diff.add(Map.of("key", key, "type", "added", "value", value2));
            } else if (data1.containsKey(key) && !data2.containsKey(key)) {
                diff.add(Map.of("key", key, "type", "deleted", "value", value1));
            } else if (data1.containsKey(key) && data2.containsKey(key) && !value1.equals(value2)) {
                diff.add(Map.of("key", key, "type", "changed", "value1", value1, "value2", value2));
            } else {
                diff.add(Map.of("key", key, "type", "unchanged", "value", value1));
            }
        }

        return diff;
    }
}
