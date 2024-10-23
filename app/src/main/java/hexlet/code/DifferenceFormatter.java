package hexlet.code;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DifferenceFormatter {
    public static String format(Map<String, Object> parsedFirstFile,
                                Map<String, Object> parsedSecondFile, String format) throws IOException {
        List<Map<String, Object>> differences = BuildResult.generateTree(parsedFirstFile, parsedSecondFile);
        switch (format) {
            case "stylish" -> {
                StringBuilder result = new StringBuilder(StylishStyleOutput
                        .formatStylish(differences));
                if (!result.isEmpty() && result.charAt(result.length() - 1) == '\n') {
                    result.deleteCharAt(result.length() - 1);
                }
                return result.toString();
            }
            case "plain" -> {
                return PlainStyleOutput.formatPlain(differences);
            }
            case "json" -> {
                return JsonStyleOutput.formatJson(differences);

            }
            default -> {
                return "Unknown format";
            }
        }
    }
}

