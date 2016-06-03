package runforfun.model;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventListResponse {

	@SerializedName("Status")
	@Expose private String status;

	@SerializedName("Data")
	@Expose private List<Event> mEvents;
	
	
	public EventListResponse() {
		
	}
	
	public List<Event> getEvents() {
		return mEvents;
	}

	public String getStatus() {
		return status;
	}
}
