package steps;

import Infrastructure.DriverSetup;
import Infrastructure.WrapApiResponse;
import logic.ApiCalls;
import logic.ApiResponse;
import logic.ApiResponseParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddNew {
    private static DriverSetup newDriver = null;
    private static WrapApiResponse<ApiResponse> result = null;

    private ApiCalls apiCalls = null;

    @BeforeEach
    public void setup(){
        newDriver= new DriverSetup();
        newDriver.setupDriver("chrome"); // get from configuration file
        newDriver.navigateToURL("https://www.rami-levy.co.il/he"); // get from configuration file
        apiCalls=new ApiCalls();
    }

    @Test
    public void addNewProduct() throws IOException {
        // ARRANGE
        String jsonInputString="{\"productId\":product-7290104501661,\"quantity\":\"1\"}";
        // ACT
        result = apiCalls.addNewProdect(jsonInputString);
        result.setData(getJsonData(result.getData()));
        // ASSERT
        assertTrue(result.getData().isSuccess());
    }

    private static ApiResponse getJsonData(Object data){
        String jsonData=String.valueOf(data);
        return ApiResponseParser.parseJson(String.valueOf(jsonData));
    }

}
