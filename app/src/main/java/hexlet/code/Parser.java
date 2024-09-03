package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String content, String dataType) throws Exception {

        ObjectMapper objectMapper;
        switch (dataType) {
            case "json":
                objectMapper = new ObjectMapper();
                break;
            case "yml":
            case "yaml":
                objectMapper = new ObjectMapper(new YAMLFactory());
                break;
            default:
                throw new RuntimeException("Format is not supported");
        }

        return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() { });
    }
}
