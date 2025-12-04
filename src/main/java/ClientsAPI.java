import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/") // Prefijo de la URL para los endpoints
public class ClientsAPI {
	// Controlador de Clients
	static Clients clientsAPI = new Clients();

	// Método para obtener todos los clientes (GET)
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> getClients() {
		List<Client> clients = clientsAPI.getClients();
		return clients;
	}

	// Método para subscribir cliente (POST)
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createClient(Client client) {
		client.setId(clientsAPI.getNextId());
        clientsAPI.addClient(client);
		return Response.status(200).entity(client).build();
	}
}
