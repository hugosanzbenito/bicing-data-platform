import java.util.List;

public class Stations {
	private List<Station> stations;
	
	public Stations() {
		
	}
	
	public Stations(List<Station> stations) {
		this.stations = stations;
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
	
	public String toString() {
    	
    	String message = "";
    	
    	for (int i = 0; i < stations.size(); i++) {
    		message = message + stations.get(i) + "\n";
    	}
    	
    	return message;
    }
	
}
