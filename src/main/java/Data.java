public class Data {
	private Stations data;
	
	public Data() {
			
	}
	
	public Data(Stations data) {
		this.data = data;
	}
	
	public Stations getData() {
		return data;
	}

	public void setData(Stations stations) {
		this.data = stations;
	}
	
	public String toString() {
		return data.toString();
	}
	
}

