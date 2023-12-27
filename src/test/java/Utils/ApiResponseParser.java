package Utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import logic.api.AdressApiResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponseParser {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static AdressApiResponse parseJson(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, AdressApiResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static AdressApiResponse getJsonData(Object data){
        String jsonData=String.valueOf(data);
        return ApiResponseParser.parseJson(String.valueOf(jsonData));
    }

}