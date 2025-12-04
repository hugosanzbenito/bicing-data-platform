import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Bicing {
	public String token = "444d3b1bf10a6602ac321e64ad68066ab4ab8fae50e2cfbe066f7a95eff2b21c";
	public String url = "https://opendata-ajuntament.barcelona.cat";
	public String path = "data/dataset/6aa3416d-ce1a-494d-861b-7bd07f069600/resource/1b215493-9e63-4a12-8980-2d7e0fa19f85/download";
	
	public static BicingCache cache;
	
	public Bicing() {
		// Create a LocalDateTime object with specific year, month, day, hour, minute, and second
		cache = new BicingCache(120, new Data(), LocalDateTime.of(2000, 1, 1, 00, 00, 00));
	}
	
	public Data getStations() {
		LocalDateTime now = LocalDateTime.now();
		long difference = Duration.between(cache.getLast_access(), now).toSeconds();
		if (difference > cache.getCached_time()) {
//			System.out.println("Cache caducada");
			//Get new list
			Client client = ClientBuilder.newClient();
			
			WebTarget targetGet = client.target(url).path(path);
			Data response = targetGet.request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", token).get(new GenericType<Data>() {});
			
//			System.out.println(response.getData().getStations().get(0).getStation_id());
			// System.out.println(response);
			cache.setCached_data(response);
			cache.setLast_access(now);
//			System.out.println(cache.getLast_access());
//			System.out.println(difference);
			return response;
		} else {
//			System.out.println("Cache no caducada");
//			System.out.println(cache.getLast_access());
//			System.out.println(Duration.between(cache.getLast_access(), now).toSeconds());
			return cache.getCached_data();
			//Return cached
			
		}
	}
}
