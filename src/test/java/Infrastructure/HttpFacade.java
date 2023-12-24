package Infrastructure;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class HttpFacade {
    public static WrapApiResponse sendHttpRequest(String url, HttpMethod method,
                                                  Map<String, String> queryParams,

                                                  String requestBody) throws IOException {
        // Log request details
        System.out.println("Sending Request:");
        System.out.println("URL: " + url);
        System.out.println("Method: " + method.getMethod());


        // create connection
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod(method.getMethod());
        // connection.setRequestProperty("X-HTTP-Method-Override", "PATCH");

//        // set headers
//        for (Map.Entry<String, String> entry : headers.entrySet()) {
//            connection.setRequestProperty(entry.getKey(), entry.getValue());
//        }
        connection.setRequestProperty("Content-type", "application/json;charset=UTF-8");
        connection.setRequestProperty("Ecomtoken", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3d3dy1hcGkucmFtaS1sZXZ5LmNvLmlsIiwiYXVkIjoiaHR0cHM6Ly93d3ctYXBpLnJhbWktbGV2eS5jby5pbCIsImlhdCI6MTcwMzQxODE3Ni44MTUxNTQsIm5iZiI6MTcwMzQxODIzNi44MTUxNTQsImV4cCI6MTcwODYwMjE3Ni44MTUxNTQsImlkIjo5MjEwNzUsImVtYWlsIjoiYXNocmFmLmVnYmFyaWFAZ21haWwuY29tIiwiY2lkIjoiOTkwMDE1NzkzMDEifQ.JwBvZp5quH0iO5cOpnY_jGLdCe5QodG2VpM5T3Gj-JM");
        connection.setRequestProperty("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjIxNzE5ZDM2NzI0OGYyZDAwY2RkMThmM2U5ZmJhNGYxYTU1OTRkYjZlYjI3ODY4ZTlmZmJhNWI0YTdmNTc2Y2IwNDg3N2FiNjY1ODMwYWNjIn0.eyJhdWQiOiIzIiwianRpIjoiMjE3MTlkMzY3MjQ4ZjJkMDBjZGQxOGYzZTlmYmE0ZjFhNTU5NGRiNmV$");

        // set query parameters
        if (queryParams != null) {
            String queryString = queryParams.entrySet().stream()
                    .map(entry -> entry.getKey() + "=" + entry.getValue())
                    .collect(Collectors.joining("&"));
            url += "?" + queryString;
        }

        if (requestBody != null && !requestBody.isEmpty()) {
            connection.setDoOutput(true);
            OutputStream os = connection.getOutputStream();
            os.write(requestBody.getBytes());
            os.flush();
            os.close();
        }

        // send request and handle response
        int status = connection.getResponseCode();
        String body = new String(connection.getInputStream().readAllBytes());
        Map<String, String> responseHeaders = connection.getHeaderFields().entrySet()
                .stream()
                .filter(entry -> entry.getKey() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getFirst()));

        return new WrapApiResponse(status, responseHeaders, body);
    }
    public static HttpResponse patchRequest(String url,String jsonBody) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

    }
}


