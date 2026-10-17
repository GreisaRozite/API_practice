import java.net.URI;
import java.net.http.*;

class ApiPractice {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        //created through a helper function because it is protected
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.open-meteo.com/v1/forecast?latitude=41.9&longitude=12.5&current_weather=true"))
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
        //api response body is basically a dictionary (map), JSON
    }
}