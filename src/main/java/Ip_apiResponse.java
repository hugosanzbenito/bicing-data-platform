
public class Ip_apiResponse {
	String query;
	String status;
	String country;
	String countryCode;
	String region;
	String regionName;
	String city;
	String zip;
	float lat;
	float lon;
	String timezone;
	String isp;
	String org;
	String as;
	/**
	 * @param query
	 * @param status
	 * @param country
	 * @param countryCode
	 * @param region
	 * @param regionName
	 * @param city
	 * @param zip
	 * @param lat
	 * @param lon
	 * @param timezone
	 * @param isp
	 * @param org
	 * @param as
	 */
	public Ip_apiResponse(String query, String status, String country, String countryCode, String region,
			String regionName, String city, String zip, float lat, float lon, String timezone, String isp, String org,
			String as) {
		this.query = query;
		this.status = status;
		this.country = country;
		this.countryCode = countryCode;
		this.region = region;
		this.regionName = regionName;
		this.city = city;
		this.zip = zip;
		this.lat = lat;
		this.lon = lon;
		this.timezone = timezone;
		this.isp = isp;
		this.org = org;
		this.as = as;
	}
	
	public Ip_apiResponse() {}
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLon() {
		return lon;
	}
	public void setLon(float lon) {
		this.lon = lon;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getIsp() {
		return isp;
	}
	public void setIsp(String isp) {
		this.isp = isp;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getAs() {
		return as;
	}
	public void setAs(String as) {
		this.as = as;
	}
	
	
}
