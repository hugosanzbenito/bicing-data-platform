import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class IpApi {
	public String url = "http://ip-api.com";
	public String path = "json/";
	public String ip;
	
	public IpApi() {
		
	}
	
	public IpApi(String url, String path, String ip) {
		this.url = url;
		this.path = path;
		this.ip = ip;
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public Ip_apiResponse getCity() {
		Client client = ClientBuilder.newClient();
		//WebTarget targetGet = client.target(url).path(path).queryParam("ip", ip);
		WebTarget targetGet = client.target(url).path(path + "/" + ip);
		Ip_apiResponse response = targetGet.request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<Ip_apiResponse>() {});
		return response;
		
	}
}
