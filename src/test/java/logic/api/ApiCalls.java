package logic.api;

import Infrastructure.HttpFacade;
import Infrastructure.HttpMethod;
import Infrastructure.WrapApiResponse;
import java.io.IOException;
import java.util.HashMap;

public class ApiCalls {

    private static final String BASE_URL = "https://www.rami-levy.co.il/api/v2";
    private static final String ecomTocen="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3d3dy1hcGkucmFtaS1sZXZ5LmNvLmlsIiwiYXVkIjoiaHR0cHM6Ly93d3ctYXBpLnJhbWktbGV2eS5jby5pbCIsImlhdCI6MTcwMzU3NTkyMi44MDUzMiwibmJmIjoxNzAzNTc1OTgyLjgwNTMyLCJleHAiOjE3MDg3NTk5MjIuODA1MzIsImlkIjo5MjEwNzUsImVtYWlsIjoiYXNocmFmLmVnYmFyaWFAZ21haWwuY29tIiwiY2lkIjoiOTkwMDE1NzkzMDEifQ.KzXZx5V0IKF8hu6GVIdW9W3LziSApuMIgIDdxsAvYkk";

    public static WrapApiResponse addNewProduct(String requestBody) throws IOException {
        String url = BASE_URL+"/cart";
        HashMap<String,String> tokenMap = new HashMap<>();
        tokenMap.put("Ecomtoken",ecomTocen);
        // Use the HttpFacade class to send the HTTP request
        return HttpFacade.sendHttpRequest(url, HttpMethod.POST,null,tokenMap,requestBody);
    }
    public static WrapApiResponse addNewAdress(String requestBody)throws IOException{
        String url = "https://www-api.rami-levy.co.il/api/v2/site/clubs/addresses";
        HashMap<String,String> tokenMap = new HashMap<>();
        tokenMap.put("Ecomtoken",ecomTocen);
        return HttpFacade.sendHttpRequest(url,HttpMethod.POST,null,tokenMap,requestBody);
    }

    public static WrapApiResponse deleteaddress(String id)throws IOException{
        String url = "https://www-api.rami-levy.co.il/api/v2/site/clubs/addresses/"+id;
        HashMap<String,String> tokenMap = new HashMap<>();
        tokenMap.put("Ecomtoken",ecomTocen);
        return HttpFacade.sendHttpRequest(url,HttpMethod.DELETE,null,tokenMap,null);
    }
    public static WrapApiResponse emptyCart(String requestBody)throws IOException{
        String url = BASE_URL+"/cart";
        HashMap<String,String> tokenMap = new HashMap<>();
        tokenMap.put("Ecomtoken",ecomTocen);
        // Use the HttpFacade class to send the HTTP request
        return HttpFacade.sendHttpRequest(url, HttpMethod.POST,null,tokenMap,requestBody);
    }


}
