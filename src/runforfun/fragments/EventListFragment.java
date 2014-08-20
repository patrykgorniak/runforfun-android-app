package runforfun.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import runforfun.data.*;

public class EventListFragment extends ListFragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.d("RunForFun", "EventListFragment");
		new FetchItemsTask().execute();
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		
	}
	
	
	private class FetchItemsTask extends AsyncTask<Void, Void, String> {
		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub
			DataSportFetchr.fetchEvents();
			return "";
		}
		
		@Override
		protected void onPostExecute(String result) {
			Log.v("RunForFun", result);
		}
	}
}
