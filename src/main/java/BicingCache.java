import java.time.LocalDateTime;

public class BicingCache {
	/**
	 * @param cached_time
	 * @param cached_data
	 */
	public BicingCache(int cached_time, Data cached_data, LocalDateTime last_access) {
		super();
		this.cached_time = cached_time;
		this.cached_data = cached_data;
		this.last_access = last_access;
	}
	public BicingCache() {
		cached_time = 120;
		last_access = LocalDateTime.of(2000, 1, 1, 00, 00, 00);
	}
	
	public int cached_time;
	public Data cached_data;
	public LocalDateTime last_access;
	
	public int getCached_time() {
		return cached_time;
	}
	public void setCached_time(int cached_time) {
		this.cached_time = cached_time;
	}
	public Data getCached_data() {
		return cached_data;
	}
	public void setCached_data(Data cached_data) {
		this.cached_data = cached_data;
	}
	public LocalDateTime getLast_access() {
		return last_access;
	}
	public void setLast_access(LocalDateTime last_access) {
		this.last_access = last_access;
	}
	
	
}
