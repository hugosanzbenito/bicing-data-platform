import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PublicIp {
	
	public PublicIp() {
		
	}
	
    public String getIP() {
        String apiUrl = "https://api64.ipify.org?format=text"; // También puedes usar "https://checkip.amazonaws.com"

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String publicIP = reader.readLine();
            reader.close();

            System.out.println("Tu IP pública es: " + publicIP);
            return ("Tu IP pública es: " + publicIP);
        } catch (Exception e) {
            System.err.println("Error al obtener la IP pública: " + e.getMessage());
            return ("Error al obtener la IP pública: " + e.getMessage());
        }
    }
}