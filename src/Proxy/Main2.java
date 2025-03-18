package Proxy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


//proxy acting as a postman receives req from the client and forward it to the real httpclient and gets the response from it and gives it to the client
interface HttpClient {
    String sendRequest(String url);
}

class RealHttpClient implements HttpClient {
    @Override
    public String sendRequest(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}

class HttpClientProxy implements HttpClient {
    private RealHttpClient realHttpClient;

    public HttpClientProxy() {
        this.realHttpClient = new RealHttpClient();
    }

    @Override
    public String sendRequest(String url) {
        System.out.println("[Proxy] Logging Request: " + url);

        // You can add headers, cache requests, or validate requests here.

        String response = realHttpClient.sendRequest(url);

        System.out.println("[Proxy] Response Received");
        return response;
    }
}



//client
public class Main2 {
    public static void main(String[] args) {
        HttpClient proxy = new HttpClientProxy();

        // Example API request (replace with a real API)
        String response = proxy.sendRequest("https://jsonplaceholder.typicode.com/todos/1");

        System.out.println("Response from API: " + response);
    }
    }


