package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class BuildResult {
    public static List<Map<String, Object>> generateTree(Map<String, Object> map1, Map<String, Object> map2) {
        List<Map<String, Object>> result = new ArrayList<>();
        Set<String> keysSet = new TreeSet<>(map1.keySet());
        keysSet.addAll(map2.keySet());
        for (String key : keysSet) {
            Map<String, Object> map = new LinkedHashMap<>();
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                map.put("key", key);
                map.put("oldValue", map1.get(key));
                map.put("type", "removed");
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                map.put("key", key);
                map.put("newValue", map2.get(key));
                map.put("type", "added");
            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                map.put("key", key);
                map.put("oldValue", map1.get(key));
                map.put("newValue", map2.get(key));
                map.put("type", "updated");
            } else {
                map.put("key", key);
                map.put("oldValue", map1.get(key));
                map.put("type", "unchanged");
            }
            result.add(map);
        }
        return result;
    }
}
