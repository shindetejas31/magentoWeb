import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TestDataReader {

    public static JsonNode getSignUpData(String scenario) {
        return getData("src/test/resources/signupData.json", scenario);
    }

    public static JsonNode getSignInData(String scenario) {
        return getData("src/test/resources/signinData.json", scenario);
    }

    private static JsonNode getData(String filePath, String scenario) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(new File(filePath));
            return rootNode.get(scenario);
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON file: " + filePath + ". Details: " + e.getMessage());
        }
    }
}
