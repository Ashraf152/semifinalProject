package logic;

import Infrastructure.HttpFacade;
import Infrastructure.HttpMethod;
import Infrastructure.WrapApiResponse;
import Utils.DateTimeFormat;
import Utils.TestContext;
import org.junit.Test;

import javax.swing.text.AbstractDocument;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import static Utils.ApiResponseParser.getJsonData;

public class ApiCalls {

    private static final String BASE_URL = "https://www.rami-levy.co.il/api/v2";

    public static WrapApiResponse addNewProduct(String requestBody) throws IOException {
        String url = BASE_URL+"/cart";
        HashMap<String,String> tokenMap = new HashMap<>();
        tokenMap.put("Ecomtoken","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3d3dy1hcGkucmFtaS1sZXZ5LmNvLmlsIiwiYXVkIjoiaHR0cHM6Ly93d3ctYXBpLnJhbWktbGV2eS5jby5pbCIsImlhdCI6MTcwMzQ1MjA4MS41NjIwNjgsIm5iZiI6MTcwMzQ1MjE0MS41NjIwNjgsImV4cCI6MTcwODYzNjA4MS41NjIwNjgsImlkIjo5MjEwNzUsImVtYWlsIjoiYXNocmFmLmVnYmFyaWFAZ21haWwuY29tIiwiY2lkIjoiOTkwMDE1NzkzMDEifQ.DgY2uM2GlpfC2KrLSDHBF8WoW4lx9PKeKgU7mBV45oc");
        // Use the HttpFacade class to send the HTTP request
        return HttpFacade.sendHttpRequest(url, HttpMethod.POST,null,tokenMap,requestBody);
    }
    public static WrapApiResponse addNewAdress(String requestBody)throws IOException{
        String url = "https://www-api.rami-levy.co.il/api/v2/site/clubs/addresses";
        HashMap<String,String> tokenMap = new HashMap<>();
        tokenMap.put("Ecomtoken","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3d3dy1hcGkucmFtaS1sZXZ5LmNvLmlsIiwiYXVkIjoiaHR0cHM6Ly93d3ctYXBpLnJhbWktbGV2eS5jby5pbCIsImlhdCI6MTcwMzQ0NTg2Ni44NDQ3MDQsIm5iZiI6MTcwMzQ0NTkyNi44NDQ3MDQsImV4cCI6MTcwODYyOTg2Ni44NDQ3MDQsImlkIjo5MjEwODcsImVtYWlsIjoia21pcmF0MTIzQGdtYWlsLmNvbSIsImNpZCI6Ijk5MDAxNTc5MzEzIn0.vCLMsYEtYOxmR8Udj-UgVqa2ZU2UqfMF4nt8E1VTbuQ");
        return HttpFacade.sendHttpRequest(url,HttpMethod.POST,null,tokenMap,requestBody);
    }

    public static WrapApiResponse deleteaddress()throws IOException{
        String url = "https://www-api.rami-levy.co.il/api/v2/site/clubs/addresses/663488";
        HashMap<String,String> tokenMap = new HashMap<>();
        tokenMap.put("Ecomtoken","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3d3dy1hcGkucmFtaS1sZXZ5LmNvLmlsIiwiYXVkIjoiaHR0cHM6Ly93d3ctYXBpLnJhbWktbGV2eS5jby5pbCIsImlhdCI6MTcwMzQ1MjA4MS41NjIwNjgsIm5iZiI6MTcwMzQ1MjE0MS41NjIwNjgsImV4cCI6MTcwODYzNjA4MS41NjIwNjgsImlkIjo5MjEwNzUsImVtYWlsIjoiYXNocmFmLmVnYmFyaWFAZ21haWwuY29tIiwiY2lkIjoiOTkwMDE1NzkzMDEifQ.DgY2uM2GlpfC2KrLSDHBF8WoW4lx9PKeKgU7mBV45oc");
        return HttpFacade.sendHttpRequest(url,HttpMethod.DELETE,null,tokenMap,null);
    }

    public static WrapApiResponse updatePhoneNumber(String requestBody)throws IOException{
        String url = "https://www-api.rami-levy.co.il/api/v2/site/clubs/customer/921087";
        HashMap<String,String> tokenMap = new HashMap<>();
        tokenMap.put("Ecomtoken","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3d3dy1hcGkucmFtaS1sZXZ5LmNvLmlsIiwiYXVkIjoiaHR0cHM6Ly93d3ctYXBpLnJhbWktbGV2eS5jby5pbCIsImlhdCI6MTcwMzQ0NTg2Ni44NDQ3MDQsIm5iZiI6MTcwMzQ0NTkyNi44NDQ3MDQsImV4cCI6MTcwODYyOTg2Ni44NDQ3MDQsImlkIjo5MjEwODcsImVtYWlsIjoia21pcmF0MTIzQGdtYWlsLmNvbSIsImNpZCI6Ijk5MDAxNTc5MzEzIn0.vCLMsYEtYOxmR8Udj-UgVqa2ZU2UqfMF4nt8E1VTbuQ");
        return HttpFacade.sendHttpRequest(url,HttpMethod.PUT,null,tokenMap,requestBody);
    }

    public static void main(String[]args)throws IOException{

        //add new Adress
        ApiCalls apiCalls=new ApiCalls();
        WrapApiResponse result=null;
        UpdateUserRequest updateUserRequest=new UpdateUserRequest("abeer","kmirat","0502055874",null,null,null);
        result=ApiCalls.updatePhoneNumber(updateUserRequest.toString());
        System.out.println(result);
        result.setData(getJsonData(result.getData()));
//        System.out.println(result.getData().getData().getAllAddresses().keySet());
//        Object[] arr = result.getData().getData().getAllAddresses().keySet().toArray();
//        System.out.println(arr[arr.length-1]);

        //delete address
      //  deleteaddress();

        //add item to cart
//        ApiCalls apiCalls=new ApiCalls();
//        WrapApiResponse<ApiResponse>result=null;
//        String store="331";
//        int inClub=0;
//        String supplyAt= DateTimeFormat.getCurrentDateTime();
//        HashMap<String,String> items= new HashMap<>();
//        items.put("164854","1.00");
//        items.put("410017","3.00");
//        ItemBodyRequest jsonBody=new ItemBodyRequest(store,inClub,supplyAt,items,null);
//        System.out.println(jsonBody);
//        result=ApiCalls.addNewProduct(jsonBody.toString());
//        System.out.println(result);

    }
}
