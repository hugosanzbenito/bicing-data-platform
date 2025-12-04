import java.util.ArrayList;
import java.util.List;

public class Client {
	public int id;
	public int phone;
	public String name;
	private List<Station> stations;
	
	public Client() {
        this.stations = new ArrayList<>();
    }

    public Client(int id, int phone, String name, List<Station> stations) {
        this.id=id;
        this.phone=phone;
        this.name = name;
        if (stations != null) {
            this.stations=stations;
        } else {
        	this.stations = new ArrayList<>();
        }
        this.stations = (stations != null) ? stations : new ArrayList<>();
    }

    public List<Station> getStations() {
        return stations;
    }
    
    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public void addStation(Station station) {
        this.stations.add(station);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String message = "Client id: " + id + ", phone: " + phone + ", name: " + name + ", stations:\n";
		for (int i = 0; i < stations.size(); i++) {
			message += stations.get(i).toString() + "\n";
		}

		return message;
	}
}

