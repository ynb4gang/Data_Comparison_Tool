package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;


public class UniversalParser {
    public static Map<String, Object> parseData(InputStream dataStream, String dataType) {
        try {
            ObjectMapper objectMapper;
            if ("json".equalsIgnoreCase(dataType)) {
                objectMapper = new ObjectMapper();
            } else if (("yaml".equalsIgnoreCase(dataType)) || ("yml".equalsIgnoreCase(dataType))) {
                objectMapper = new ObjectMapper(new YAMLFactory());
            } else {
                throw new IllegalArgumentException("Unexpected data type: " + dataType);
            }
            return objectMapper.readValue(dataStream, new TypeReference<TreeMap<String, Object>>() { });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
