package Infrastructure;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpFacade {

    public static WrapApiResponse sendHttpRequest(String url, HttpMethod method,
                                                  Map<String, String> queryParams, Map<String, String> headers,
                                                  String requestBody) throws IOException {

                // Log request details
                System.out.println("Sending Request:");
                System.out.println("URL: " + url);
                System.out.println("Method: " + method.getMethod());

                // create connection
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod(method.getMethod());

                // set headers
                connection.setRequestProperty("Content-type", "application/json;charset=UTF-8");
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }


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
                        .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get(0)));

                return new WrapApiResponse(status, responseHeaders, body);

    }
}
