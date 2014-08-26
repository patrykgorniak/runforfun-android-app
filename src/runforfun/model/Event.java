package runforfun.model;

import com.android.sport.runforfun.R;

public class Event {
	//	
	//	public enum SportType {
	//		RUNING
	//	}

	private String location;
	private String website;
	private String results_page;
	private String name;
	private String date;
	private EventType type;
	private String entries;

	public Event() {

	}
	//	
	public String getLocation() {
		return location;
	}
	//	public void setLocation(String location) {
	//		this.location = location;
	//	}
	public String getWebsite() {
		return website;
	}
	//	public void setWebsite(String website) {
	//		this.website = website;
	//	}
	public String getResults_page() {
		return results_page;
	}
	//	public void setResults_page(String results_page) {
	//		this.results_page = results_page;
	//	}
	public String getName() {
		return name;
	}
	//	public void setName(String name) {
	//		this.name = name;
	//	}
	public String getDate() {
		return date;
	}
	//	public void setDate(String date) {
	//		this.date = date;
	//	}
	public EventType getType() {
		return type;
	}
	//	public void setType(int type) {
	//		this.type = type;
	//	}
	public String getEntries() {
		return entries;
	}
	//	public void setEntries(String entries) {
	//		this.entries = entries;
	//	}

	public enum EventType {
		RUNNING(0), BICYCLING(1), SKIING(2), DOG(3), BIATHLON(4), RUNNING_2(5);
		private final int key;

		EventType(int key) {
			// TODO Auto-generated constructor stub
			this.key = key;
		}
		public int getKey() {
			return this.key;
		}

		public int getSrc() {
			switch (key) {
			case 0:
				return R.drawable.running;
			case 1:
				return R.drawable.bicycle;
			case 2:
			case 3:
			case 4:
			default:
				return R.drawable.skiing;
			}
		}

		public static EventType fromKey(int key) {
			for(EventType type : EventType.values()) {
				if(type.getKey() == key) {
					return type;
				}
			}
			return null;
		}

	}

}
