import java.util.List;

public class waqiCity {
	String name;
	String url;
	List<String> geo;
	/**
	 * @param name
	 * @param url
	 * @param geo
	 */
	public waqiCity(String name, String url, List<String> geo) {
		super();
		this.name = name;
		this.url = url;
		this.geo = geo;
	}
	
	public waqiCity() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getGeo() {
		return geo;
	}

	public void setGeo(List<String> geo) {
		this.geo = geo;
	}
	
	
}
