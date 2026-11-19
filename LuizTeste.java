import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public static void main(String[] args) {

    Scanner leitor = new Scanner(System.in);
    System.out.println("Digite o local que quer ir: ");
    String local = leitor.nextLine();

    String key = "pk.5a0e08402d895799391678b1f5a76c24";
    
    local = local.replace(" ", "%20");

    try{
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://us1.locationiq.com/v1/search?key="+key+"&q="+local+",&format=json"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }catch (Exception e){
        e.printStackTrace();
    }

}