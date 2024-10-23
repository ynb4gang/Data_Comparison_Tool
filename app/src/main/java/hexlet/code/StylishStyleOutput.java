package hexlet.code;

import java.util.List;
import java.util.Map;

public class StylishStyleOutput {
    public static String formatStylish(List<Map<String, Object>> differences) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> diff : differences) {
            switch (diff.get("type").toString()) {
                case "removed":
                    result.append("  - ")
                            .append(diff.get("key"))
                            .append(": ")
                            .append(diff.get("oldValue"))
                            .append("\n");
                    break;
                case "added":
                    result.append("  + ")
                            .append(diff.get("key"))
                            .append(": ")
                            .append(diff.get("newValue"))
                            .append("\n");
                    break;
                case "unchanged":
                    result.append("    ")
                            .append(diff.get("key"))
                            .append(": ")
                            .append(diff.get("oldValue"))
                            .append("\n");
                    break;
                default:
                    result.append("  - ")
                            .append(diff.get("key"))
                            .append(": ")
                            .append(diff.get("oldValue"))
                            .append("\n");
                    result.append("  + ")
                            .append(diff.get("key"))
                            .append(": ")
                            .append(diff.get("newValue"))
                            .append("\n");
                    break;
            }
        }
        return result.append("}").toString();
    }
}
