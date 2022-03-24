package Yaml;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
public class YamlReaderExample {
    public static void main(String[] args) throws Exception {
        File file = new File("src/test/java/Yaml/data2.yml");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        ApplicationConfig config = objectMapper.readValue(file, ApplicationConfig.class);
        System.out.println("Application config info " + config.toString());
        System.out.println(config.getDatabase());
    }
}