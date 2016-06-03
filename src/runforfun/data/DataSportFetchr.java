package runforfun.data;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import android.util.Log;
import runforfun.authenticator.Session;
import runforfun.model.Event;
import runforfun.model.Event.EventType;
import runforfun.model.EventListResponse;

public class DataSportFetchr {

	private static String tag = "RunForFun";

	public List<Event> fetchEvents() {
		String data = Utils.readHttpData("http://rff.pgorniak.mydevil.net/rff/?action=get_events&service=datasport&date_from=2014-08-01").toString();

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Event.EventType.class, new EventTypeDeserializer());
		Gson gson = gsonBuilder.excludeFieldsWithoutExposeAnnotation().create();
		EventListResponse mEvents = gson.fromJson(data, EventListResponse.class);
		return mEvents.getEvents();
	}



	// Deserializer Implamentation
	public class EventTypeDeserializer implements JsonDeserializer<Event.EventType> {
		@Override
		public EventType deserialize(JsonElement element, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
			int key = element.getAsInt();
			return EventType.fromKey(key);
		}
	}
}
