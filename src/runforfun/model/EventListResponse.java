package runforfun.model;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class EventListResponse {

	@SerializedName("Status")
	private String status;

	@SerializedName("Data")
	private List<Event> mEvents = new ArrayList<Event>();
	
	
	public EventListResponse() {
		
	}
	
	public List<Event> getData() {
		return mEvents;
	}

	public String getStatus() {
		return status;
	}
}
