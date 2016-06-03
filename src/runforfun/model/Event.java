package runforfun.model;

import java.util.UUID;

import com.google.gson.annotations.Expose;

public class Event {

	@Expose(deserialize = true)
	private String location;
	@Expose(deserialize = true)
	private String website;
	@Expose(deserialize = true)
	private String results_page;
	@Expose(deserialize = true)
	private String name;
	@Expose(deserialize = true)
	private String date;
	@Expose(deserialize = true)
	private EventType type;
	@Expose(deserialize = true)
	private String entries;

	private UUID id;

	private Event() {
		id = UUID.randomUUID();
	}
	
	public UUID getId() {
		return id;
	}

	public String getLocation() {
		return location;
	}
	public String getWebsite() {
		return website;
	}
	public String getResults_page() {
		return results_page;
	}
	public String getName() {
		return name;
	}
	public String getDate() {
		return date;
	}
	public EventType getType() {
		return type;
	}
	public String getEntries() {
		return entries;
	}

	public enum EventType {
		RUNNING(0), BICYCLING(1), SKIING(2), DOG(3), BIATHLON(4), OTHER(5);
		private final int key;

		EventType(int key) {
			this.key = key;
		}
		public int getKey() {
			return this.key;
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
