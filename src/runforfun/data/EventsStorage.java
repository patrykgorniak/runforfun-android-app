package runforfun.data;

import java.util.List;
import java.util.UUID;

import runforfun.model.Event;

public class EventsStorage {
	private static List<Event> mEvents;
	
	public static void setEvents(List<Event> events) {
		mEvents = events;
	}
	
	public static List<Event> getEvents() {
		return mEvents;
	}
	
	public static Event getEvent(int location) {
		return mEvents.get(location);
	}
	
	public static Event getEvent(UUID id) {
		for(Event e: mEvents) {
			if(e.getId().equals(id))
				return e;
		}
		return null;
	}
}
