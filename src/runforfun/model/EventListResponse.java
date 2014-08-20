package runforfun.model;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class EventListResponse {

	@SerializedName("Status")
	private String status;
	
	@SerializedName("Data")
	private Data data;
	
	
	public EventListResponse() {
		
	}
	
	public Data getData() {
		return data;
	}

	public String getStatus() {
		return status;
	}
	
	
	public class Data {
		private List<Event> listData;
		
		public Data(){
			
		}

		public List<Event> getListData() {
			return listData;
		}
	}
}
