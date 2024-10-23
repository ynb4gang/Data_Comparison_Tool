package hexlet.code;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        Path path1 = Paths.get(filePath1).toAbsolutePath();
        Path path2 = Paths.get(filePath2).toAbsolutePath();

        if (!Files.exists(path1) || !Files.exists(path2)) {
            return "One or both files do not exist.";
        }

        FileInputStream fileInputStream1 = new FileInputStream(path1.toFile());
        FileInputStream fileInputStream2 = new FileInputStream(path2.toFile());
        Map<String, Object> parsedFirstFile = UniversalParser.parseData(fileInputStream1, getFileExtension(filePath1));
        Map<String, Object> parsedSecondFile = UniversalParser.parseData(fileInputStream2, getFileExtension(filePath2));

        return DifferenceFormatter.format(parsedFirstFile, parsedSecondFile, format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }
    private static String getFileExtension(String filePath) {
        int lastDotIndex = filePath.lastIndexOf('.');
        if (lastDotIndex != -1) {
            return filePath.substring(lastDotIndex + 1);
        }
        return "";
    }
}
