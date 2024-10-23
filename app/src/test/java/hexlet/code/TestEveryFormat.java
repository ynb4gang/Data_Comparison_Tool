package hexlet.code;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
class FileUtils {
    @Test
    public void testJsonStylish() throws IOException {
        Path filePath = Paths.get("src/test/resources/fixtures/StylishCorrectOutput.txt");
        String expectedOutput = Files.readString(filePath).trim();

        String fileFirst = "src/test/resources/fixtures/file1.json";
        String fileSecond = "src/test/resources/fixtures/file2.json";
        String outputJsonStylish = Differ.generate(fileFirst, fileSecond, "stylish");
        expectedOutput = expectedOutput.replaceAll("\\r\\n", "\n");
        outputJsonStylish = outputJsonStylish.replaceAll("\\r\\n", "\n");

        assertEquals(expectedOutput, outputJsonStylish);
    }
    @Test
    public void testYamlStylish() throws IOException {
        Path filePath = Paths.get("src/test/resources/fixtures/StylishCorrectOutput.txt");
        String expectedOutput = Files.readString(filePath).trim();

        String fileFirst = "src/test/resources/fixtures/file1.yml";
        String fileSecond = "src/test/resources/fixtures/file2.yml";

        String outputJsonStylish = Differ.generate(fileFirst, fileSecond, "stylish");

        expectedOutput = expectedOutput.replaceAll("\\r\\n", "\n");
        outputJsonStylish = outputJsonStylish.replaceAll("\\r\\n", "\n");

        assertEquals(outputJsonStylish, expectedOutput);
    }
    @Test
    public void testJsonOutputJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("src/test/resources/fixtures/JsonCorrectOutput.json");
        JsonNode expectedOutput = objectMapper.readTree(file);

        String fileFirst = "src/test/resources/fixtures/file1.json";
        String fileSecond = "src/test/resources/fixtures/file2.json";

        String outputJsonStylish = Differ.generate(fileFirst, fileSecond, "json");

        assertEquals(expectedOutput.toPrettyString(), outputJsonStylish);
    }
    @Test
    public void testJsonOutputYaml() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("src/test/resources/fixtures/JsonCorrectOutput.json");
        JsonNode expectedOutput = objectMapper.readTree(file);

        String fileFirst = "src/test/resources/fixtures/file1.yml";
        String fileSecond = "src/test/resources/fixtures/file2.yml";

        String outputJsonStylish = Differ.generate(fileFirst, fileSecond, "json");

        assertEquals(expectedOutput.toPrettyString(), outputJsonStylish);
    }
    @Test
    public void testJsonPlain() throws IOException {
        Path filePath = Paths.get("src/test/resources/fixtures/PlainCorrectOutput.txt");

        String expectedOutput = Files.readString(filePath).trim();

        String fileFirst = "src/test/resources/fixtures/file1.json";
        String fileSecond = "src/test/resources/fixtures/file2.json";

        String outputJsonStylish = Differ.generate(fileFirst, fileSecond, "plain");

        expectedOutput = expectedOutput.replaceAll("\\r\\n", "\n");
        outputJsonStylish = outputJsonStylish.replaceAll("\\r\\n", "\n");

        assertEquals(expectedOutput, outputJsonStylish);
    }
    @Test
    public void testYamlPlain() throws IOException {
        Path filePath = Paths.get("src/test/resources/fixtures/PlainCorrectOutput.txt");
        String expectedOutput = Files.readString(filePath).trim();

        String fileFirst = "src/test/resources/fixtures/file1.yml";
        String fileSecond = "src/test/resources/fixtures/file2.yml";

        String outputJsonStylish = Differ.generate(fileFirst, fileSecond, "plain");

        expectedOutput = expectedOutput.replaceAll("\\r\\n", "\n");
        outputJsonStylish = outputJsonStylish.replaceAll("\\r\\n", "\n");

        assertEquals(outputJsonStylish, expectedOutput);
    }
    @Test
    public void testDifferGenerateWithDefaultFormatterJson() throws IOException {
        Path filePath = Paths.get("src/test/resources/fixtures/StylishCorrectOutput.txt");
        String expectedOutput = Files.readString(filePath).trim();

        String file1 = "src/test/resources/fixtures/file1.json";
        String file2 = "src/test/resources/fixtures/file2.json";

        String diff = Differ.generate(file1, file2, "stylish");

        expectedOutput = expectedOutput.replaceAll("\\r\\n", "\n");
        diff = diff.replaceAll("\\r\\n", "\n");

        assertEquals(expectedOutput, diff);
    }
    @Test
    public void testDifferGenerateWithAnotherFormatterYaml() throws IOException {
        Path filePath = Paths.get("src/test/resources/fixtures/StylishCorrectOutput.txt");

        String expectedOutput = Files.readString(filePath).trim();

        String file1 = "src/test/resources/fixtures/file1.yml";
        String file2 = "src/test/resources/fixtures/file2.yml";

        String diff = Differ.generate(file1, file2, "stylish");


        expectedOutput = expectedOutput.replaceAll("\\r\\n", "\n");
        diff = diff.replaceAll("\\r\\n", "\n");
        assertEquals(expectedOutput, diff);
    }
}

