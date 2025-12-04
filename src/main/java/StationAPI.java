import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/") // Prefijo de la URL para los endpoints
public class StationAPI {
	// Controlador de Bicing
	static Bicing bicingAPI = new Bicing();
	
		// Método para obtener todas las estaciones (GET)
		@GET
		@Path("/")
		@Produces(MediaType.APPLICATION_JSON)
		public Data getStations() {
			Data stations = bicingAPI.getStations();
			return stations;
		}
}
