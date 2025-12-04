
public class DataWaqi {
	public waqiResponse data;

	/**
	 * @param data
	 */
	public DataWaqi(waqiResponse data) {
		super();
		this.data = data;
	}
	
	public DataWaqi() {
	}

	public waqiResponse getData() {
		return data;
	}

	public void setData(waqiResponse data) {
		this.data = data;
	}
	
}
