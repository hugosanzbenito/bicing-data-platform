import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class Waqi {
	public String url = "https://api.waqi.info";
	public String path = "feed";
	public String token = "28f4c435532e4db6bd0e4e69735640038d9a5fa1";
	public String city;
	
	public Waqi() {
		
	}
	
	public Waqi(String url, String path, String token, String city) {
		this.url = url;
		this.path = path;
		this.token = token;
		this.city = city;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public waqiResponse getAir_quality() {
		Client client = ClientBuilder.newClient();
		//WebTarget targetGet = client.target(url).path(path).queryParam("ip", ip);
		
		WebTarget targetGet = client.target(url).path(path + "/" + city).queryParam("token", token);
		DataWaqi response = targetGet.request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<DataWaqi>() {});
		return response.getData();
	}
	
}
