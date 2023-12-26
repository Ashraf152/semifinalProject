package logic;

import Infrastructure.HttpFacade;
import Infrastructure.HttpMethod;
import Infrastructure.WrapApiResponse;
import Utils.DateTimeFormat;
import java.io.IOException;
import java.util.HashMap;

import static Utils.ApiResponseParser.getJsonData;

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

    public static void main(String[]args)throws IOException{

        //add new address
        ApiCalls apiCalls=new ApiCalls();
        WrapApiResponse<AdressApiResponse> result=null;
        AdressBodyRequest adressBodyRequest=new AdressBodyRequest(null,2779,"חיפה","12","12","12","12",null,"12");
        result=ApiCalls.addNewAdress(adressBodyRequest.toString());
        System.out.println(result);
        result.setData(getJsonData(result.getData()));
       Object[] arr = result.getData().getData().getAllAddresses().keySet().toArray();
        System.out.println(arr[arr.length-1]);

        //delete address
   //     deleteaddress();

       // add item to cart
//        ApiCalls apiCalls=new ApiCalls();
//        WrapApiResponse<ApiResponse>result=null;
//        String store="331";
//        int inClub=0;
//        String supplyAt= DateTimeFormat.getCurrentDateTime();
//        HashMap<String,String> items= new HashMap<>();
//        items.put("357141","3.00");
//        ItemBodyRequest jsonBody=new ItemBodyRequest(store,inClub,supplyAt,items,null);
//        System.out.println(jsonBody);
//        result=ApiCalls.addNewProduct(jsonBody.toString());
//        System.out.println(result);

        ItemBodyRequest jsonbody=new ItemBodyRequest("331",0,DateTimeFormat.getCurrentDateTime(),new HashMap<String,String>(),null);
        emptyCart(jsonbody.toString());
    }
}
