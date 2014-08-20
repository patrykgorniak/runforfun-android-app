package runforfun.data;

import java.util.ArrayList;

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
	public static ArrayList<Event> fetchEvents() {
		ArrayList<Event> items = new ArrayList<Event>();
		String data = Utils.readHttpData("http://rff.pgorniak.mydevil.net/rff/?action=get_events&service=datasport").toString();
		Utils.writeToExternalCard("debug.txt", data);
		
		Gson gson = new GsonBuilder().create();
		EventListResponse p = gson.fromJson(data, EventListResponse.class);
		Log.i(tag, p.getData().getListData().get(0).getName() );
//	    try {
//	        JSONObject jsonArray = new JSONObject(data);
//	        Log.i("RunForFun", "Number of entries " + jsonArray.length());
//	        for (int i = 0; i < jsonArray.length(); i++) {
//	          JSONObject jsonObject = jsonArray.get;
//	          Log.i("RunForFun", jsonObject.getString("text"));
////	        }
//	      } catch (Exception e) {
//	        e.printStackTrace();
//	      }
		return items;
	}
}
