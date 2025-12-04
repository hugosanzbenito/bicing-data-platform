
public class waqiResponse {

	int idx;
	int aqi;
	waqiCity city;
	/**
	 * @param idx
	 * @param aqi
	 * @param city
	 */
	public waqiResponse(int idx, int aqi, waqiCity city) {
		super();
		this.idx = idx;
		this.aqi = aqi;
		this.city = city;
	}
	
	public waqiResponse() {}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getAqi() {
		return aqi;
	}

	public void setAqi(int aqi) {
		this.aqi = aqi;
	}

	public waqiCity getCity() {
		return city;
	}

	public void setCity(waqiCity city) {
		this.city = city;
	}
	
	
}
