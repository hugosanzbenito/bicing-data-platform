// Clients.java
import java.util.ArrayList;
import java.util.List;

public class Clients {
    private List<Client> clientList;
    private int currentId = 0;

    public Clients() {
        this.clientList = new ArrayList<>();
    }

    public List<Client> getClients() {
        return new ArrayList<>(clientList);
    }

    public void addClient(Client client) {
        clientList.add(client);
    }

    public int getNextId() {
        return currentId++;
    }
}
