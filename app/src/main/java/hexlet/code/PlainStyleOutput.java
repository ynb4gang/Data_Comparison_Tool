package hexlet.code;


import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.stream.Collectors;


public class PlainStyleOutput {
    public static String format(Map<String, Object> parseFileOne, Map<String, Object> parseFileTwo) {
        StringBuilder result = new StringBuilder();

        Set<String> allKeys = new TreeSet<>(parseFileOne.keySet());
        allKeys.addAll(parseFileTwo.keySet());
        for (String key : allKeys) {
            buildResult(key, parseFileOne, parseFileTwo, result);
        }
        return result.toString();
    }

    private static void buildResult(String key, Map<String, Object> parseFileOne,
                                    Map<String, Object> parseFileTwo, StringBuilder result) {
        Object valueOne = parseFileOne.get(key);
        Object valueTwo = parseFileTwo.get(key);

        if (!parseFileOne.containsKey(key) && parseFileTwo.containsKey(key)) {
            addPropertyAdded(key, valueTwo, result);
        } else if (parseFileOne.containsKey(key) && !parseFileTwo.containsKey(key)) {
            addPropertyRemoved(key, result);
        } else if (parseFileOne.containsKey(key) && parseFileTwo.containsKey(key) && !Objects.equals(valueOne, valueTwo)) {
            addPropertyUpdated(key, valueOne, valueTwo, result);
        }
    }

    private static void addPropertyAdded(String key, Object value, StringBuilder result) {
        if (value instanceof Map || value instanceof List || value.getClass().isArray()) {
            result.append("Property '").append(key).append("' was added with value: [complex value]\n");
        } else {
            if (value instanceof String) {
                result.append("Property '").append(key).append("' was added with value: '").append(value).append("'\n");
            } else result.append("Property '").append(key).append("' was added with value: ").append(value).append("\n");
        }
    }

    private static void addPropertyRemoved(String key, StringBuilder result) {
        result.append("Property '").append(key).append("' was removed\n");
    }

    private static void addPropertyUpdated(String key, Object valueOne, Object valueTwo, StringBuilder result) {
        if ((valueOne instanceof Map || valueOne instanceof List || (valueOne != null && valueOne.getClass().isArray()))
                && (valueTwo instanceof Map || valueTwo instanceof List || valueTwo.getClass().isArray())) {
            result.append("Property '").append(key).append("' was updated. From [complex value] to [complex value]\n");
        } else if (valueOne instanceof Map || valueOne instanceof List || (valueOne != null && valueOne.getClass().isArray())) {
            result.append("Property '").append(key).append("' was updated. From ")
                    .append("[complex value]").append(" to ")
                    .append(valueTwo).append("\n");
        } else if (valueTwo instanceof Map || valueTwo instanceof List || (valueTwo != null && valueTwo.getClass().isArray())) {
            result.append("Property '").append(key).append("' was updated. From ")
                    .append(valueOne).append(" to ")
                    .append("[complex value]").append("\n");
        } else {
            if (valueOne instanceof String && valueTwo instanceof String) {
                result.append("Property '").append(key).append("' was updated. From '")
                        .append(valueOne).append("' to '").append(valueTwo).append("'\n");
            } else if (valueOne instanceof String && !(valueTwo instanceof  String)) {
                result.append("Property '").append(key).append("' was updated. From '")
                        .append(valueOne).append("' to ").append(valueTwo).append("\n");
            } else if (!(valueOne instanceof String) && valueTwo instanceof  String) {
                result.append("Property '").append(key).append("' was updated. From ")
                        .append(valueOne).append(" to '").append(valueTwo).append("'\n");
            } else {
                result.append("Property '").append(key).append("' was updated. From ")
                        .append(valueOne).append(" to ").append(valueTwo).append("\n");
            }
        }
    }
}
