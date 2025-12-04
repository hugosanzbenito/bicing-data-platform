import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/") // Prefijo de la URL para los endpoints
public class NotificationsAPI {
	static TelegramBot telegramAPI = new TelegramBot();
	static IpApi ipAPI = new IpApi();
	static Waqi waqiAPI = new Waqi();
	
	static PublicIp pruebaip = new PublicIp();
	
	// Método para obtener todas las estaciones (GET)
	@POST
	@Path("/message/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getTest(String message) {
		telegramAPI.sendMessage(message);
		return Response.status(200).entity(message).build();
	}
	
	@GET
	@Path("/airquality")
	@Produces(MediaType.APPLICATION_JSON)
	public waqiResponse getAir_quality(@QueryParam("ip") String ip) {
		ipAPI.setIp(ip);
		Ip_apiResponse response = ipAPI.getCity();
		System.out.println(response.getCity());
		waqiAPI.setCity(response.getCity());
		waqiResponse response2 = waqiAPI.getAir_quality();
		return response2;
	}
}
