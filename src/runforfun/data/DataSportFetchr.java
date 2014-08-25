package runforfun.data;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.util.Log;
import runforfun.authenticator.Session;
import runforfun.model.Event;
import runforfun.model.EventListResponse;

public class DataSportFetchr {

	private static String tag = "RunForFun";
//	private Session mSession;
//	
//	public DataSportFetchr(Session mSession) {
//		this.mSession = mSession;
//	}
//	
	public static List<Event> fetchEvents() {
		String data = Utils.readHttpData("http://rff.pgorniak.mydevil.net/rff/?action=get_events&service=datasport").toString();
//		Utils.writeToExternalCard("debug.txt", data);
		
		Gson gson = new GsonBuilder().create();
		EventListResponse p = gson.fromJson(data, EventListResponse.class);
		return p.getData();
	}
}
