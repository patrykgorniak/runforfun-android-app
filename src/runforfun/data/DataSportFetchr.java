package runforfun.data;

import java.util.ArrayList;

import runforfun.authenticator.Session;
import runforfun.model.Event;

public class DataSportFetchr {
	private Session mSession;
	
	public DataSportFetchr(Session mSession) {
		this.mSession = mSession;
	}
	
	public ArrayList<Event> fetchEvents() {
		ArrayList<Event> items = new ArrayList<Event>();
		return items;
	}
}
