import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


public class TelegramBot {
    private static final String TOKEN = "7152118886:AAGiu1N1DJlEv6S5UyYfYw1NZS1f767VwGE";
    private static final long CHAT_ID = 1519512610;

    
    public void sendMessage() {
    	Message message = new Message(CHAT_ID, "Hello from Java!");
    	//Message message = new Message("Hello from Java!");

        // Create a Jersey HTTP client
        Client client = ClientBuilder.newClient();
        WebTarget targetSendMessage = client.target("https://api.telegram.org").path("/bot" + TOKEN + "/sendMessage");

        // Send POST request
        String response = targetSendMessage.request().post(Entity.entity(message, MediaType.APPLICATION_JSON), String.class);

        // Print API response
        System.out.println("Response: " + response);
    }
    
    public void sendMessage(String text) {
    	Message message = new Message(CHAT_ID, text);
    	//Message message = new Message(text);

        // Create a Jersey HTTP client
        Client client = ClientBuilder.newClient();
        WebTarget targetSendMessage = client.target("https://api.telegram.org").path("/bot" + TOKEN + "/sendMessage");

        // Send POST request
        String response = targetSendMessage.request().post(Entity.entity(message, MediaType.APPLICATION_JSON), String.class);

        // Print API response
        System.out.println("Response: " + response);
    }
    
    
    
}
