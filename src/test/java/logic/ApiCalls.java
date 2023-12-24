package logic;

import Infrastructure.HttpFacade;
import Infrastructure.HttpMethod;
import Infrastructure.WrapApiResponse;

import java.io.IOException;
import java.util.Map;

public class ApiCalls {


    private static final String BASE_URL = "https://www.rami-levy.co.il/api/v2/cart";

    public WrapApiResponse addNewProdect(String requestBody) throws IOException {

         String url = BASE_URL;
        HttpMethod method = HttpMethod.POST;
        Map<String, String> queryParams = null;  // You may add query parameters if needed

        // Use the HttpFacade class to send the HTTP request
        return HttpFacade.sendHttpRequest(url, method, queryParams, requestBody);
    }


}
