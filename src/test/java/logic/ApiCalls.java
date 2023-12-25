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
        tokenMap.put("Ecomtoken","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3d3dy1hcGkucmFtaS1sZXZ5LmNvLmlsIiwiYXVkIjoiaHR0cHM6Ly93d3ctYXBpLnJhbWktbGV2eS5jby5pbCIsImlhdCI6MTcwMzQ1MjA4MS41NjIwNjgsIm5iZiI6MTcwMzQ1MjE0MS41NjIwNjgsImV4cCI6MTcwODYzNjA4MS41NjIwNjgsImlkIjo5MjEwNzUsImVtYWlsIjoiYXNocmFmLmVnYmFyaWFAZ21haWwuY29tIiwiY2lkIjoiOTkwMDE1NzkzMDEifQ.DgY2uM2GlpfC2KrLSDHBF8WoW4lx9PKeKgU7mBV45oc");
        return HttpFacade.sendHttpRequest(url,HttpMethod.POST,null,tokenMap,requestBody);
    }

    public static WrapApiResponse deleteaddress()throws IOException{
        String url = "https://www-api.rami-levy.co.il/api/v2/site/clubs/addresses/663488";
        HashMap<String,String> tokenMap = new HashMap<>();
        tokenMap.put("Ecomtoken","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3d3dy1hcGkucmFtaS1sZXZ5LmNvLmlsIiwiYXVkIjoiaHR0cHM6Ly93d3ctYXBpLnJhbWktbGV2eS5jby5pbCIsImlhdCI6MTcwMzQ1MjA4MS41NjIwNjgsIm5iZiI6MTcwMzQ1MjE0MS41NjIwNjgsImV4cCI6MTcwODYzNjA4MS41NjIwNjgsImlkIjo5MjEwNzUsImVtYWlsIjoiYXNocmFmLmVnYmFyaWFAZ21haWwuY29tIiwiY2lkIjoiOTkwMDE1NzkzMDEifQ.DgY2uM2GlpfC2KrLSDHBF8WoW4lx9PKeKgU7mBV45oc");
        return HttpFacade.sendHttpRequest(url,HttpMethod.DELETE,null,tokenMap,null);
    }
    public static WrapApiResponse emptyCart(String requestBody)throws IOException{
        String url = BASE_URL+"/cart";
        HashMap<String,String> tokenMap = new HashMap<>();
        tokenMap.put("Ecomtoken","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3d3dy1hcGkucmFtaS1sZXZ5LmNvLmlsIiwiYXVkIjoiaHR0cHM6Ly93d3ctYXBpLnJhbWktbGV2eS5jby5pbCIsImlhdCI6MTcwMzQ1MjA4MS41NjIwNjgsIm5iZiI6MTcwMzQ1MjE0MS41NjIwNjgsImV4cCI6MTcwODYzNjA4MS41NjIwNjgsImlkIjo5MjEwNzUsImVtYWlsIjoiYXNocmFmLmVnYmFyaWFAZ21haWwuY29tIiwiY2lkIjoiOTkwMDE1NzkzMDEifQ.DgY2uM2GlpfC2KrLSDHBF8WoW4lx9PKeKgU7mBV45oc");
        // Use the HttpFacade class to send the HTTP request
        return HttpFacade.sendHttpRequest(url, HttpMethod.POST,null,tokenMap,requestBody);

    }

    public static void main(String[]args)throws IOException{

        //add new address
//        ApiCalls apiCalls=new ApiCalls();
//        WrapApiResponse<AdressApiResponse> result=null;
//        AdressBodyRequest adressBodyRequest=new AdressBodyRequest(null,2779,"חיפה","12","12","12","12",null,"12");
//        result=ApiCalls.addNewAdress(adressBodyRequest.toString());
//        System.out.println(result);
//        result.setData(getJsonData(result.getData()));
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

        ItemBodyRequest jsonbody=new ItemBodyRequest("331",0,DateTimeFormat.getCurrentDateTime(),new HashMap<String,String>(),null);
        emptyCart(jsonbody.toString());
    }
}
