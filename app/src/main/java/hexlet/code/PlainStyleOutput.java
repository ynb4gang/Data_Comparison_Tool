package hexlet.code;

import java.util.Map;
import java.util.List;

public class PlainStyleOutput {
    public static String formatPlain(List<Map<String, Object>> differences) {
        StringBuilder result = new StringBuilder();
        for (Map<String, Object> diff : differences) {
            switch (diff.get("type").toString()) {
                case "removed":
                    result.append("Property '")
                            .append(diff.get("key"))
                            .append("' was removed")
                            .append("\n");
                    break;
                case "added":
                    result.append("Property '")
                            .append(diff.get("key"))
                            .append("' was added with value: ")
                            .append(complexValue(diff.get("newValue")))
                            .append("\n");
                    break;
                case "updated":
                    result.append("Property '")
                            .append(diff.get("key"))
                            .append("' was updated. From ")
                            .append(complexValue(diff.get("oldValue")))
                            .append(" to ")
                            .append(complexValue(diff.get("newValue")))
                            .append("\n");
                    break;
                default:
                    result.append("");
                    break;
            }
        }
        return result.toString().trim();
    }

    public static String complexValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        } else if (value == null) {
            return "null";
        } else {
            return value.toString();
        }
    }
}
