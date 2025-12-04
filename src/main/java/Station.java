
public class Station {
	/**
	 * @param station_id
	 * @param num_bikes_available
	 * @param num_docks_available
	 * @param last_reported
	 * @param is_charging_station
	 * @param status
	 */
	public Station(int station_id, int num_bikes_available, int num_docks_available, long last_reported,
			boolean is_charging_station, String status) {
		super();
		this.station_id = station_id;
		this.num_bikes_available = num_bikes_available;
		this.num_docks_available = num_docks_available;
		this.last_reported = last_reported;
		this.is_charging_station = is_charging_station;
		this.status = status;
	}
	
	public Station() {
		
	}
	
	private int station_id;
	private int num_bikes_available;
	private int num_docks_available;
	private long last_reported;
	private boolean is_charging_station;
	private String status;
	
	public int getStation_id() {
		return station_id;
	}
	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}
	public int getNum_bikes_available() {
		return num_bikes_available;
	}
	public void setNum_bikes_available(int num_bikes_available) {
		this.num_bikes_available = num_bikes_available;
	}
	public int getNum_docks_available() {
		return num_docks_available;
	}
	public void setNum_docks_available(int num_docks_available) {
		this.num_docks_available = num_docks_available;
	}
	public long getLast_reported() {
		return last_reported;
	}
	public void setLast_reported(long last_reported) {
		this.last_reported = last_reported;
	}
	public boolean isIs_charging_station() {
		return is_charging_station;
	}
	public void setIs_charging_station(boolean is_charging_station) {
		this.is_charging_station = is_charging_station;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
    @Override
    public String toString() {
    	
    	String message = "Station " + station_id 
    			+ " has " + num_bikes_available
    			+ " bikes available and " + num_docks_available
    			+ " docks available. ";
    	if (is_charging_station) {
    		message = message + "It is a charging station. ";
    	} else {
    		message = message + "It is not a charging station. ";
    	}
    	
    	message = message + status;
    	
//    	if (status == "IN_SERVICE") {
//    		message = message + "It is in service.";
//    	} else {
//    		message = message + "It is not in service.";
//    	}
    	
    	return message;
    }
}
