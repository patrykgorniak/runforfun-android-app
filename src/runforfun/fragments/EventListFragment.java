package runforfun.fragments;

import java.util.List;

import com.android.sport.runforfun.R;

import android.location.Address;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import runforfun.data.*;
import runforfun.model.*;

public class EventListFragment extends ListFragment {
	private List<Event> mEvents;
	
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
	
	
	private class EventAdapter extends ArrayAdapter<Event> {
		public EventAdapter(List<Event> mEvents) {
			super(getActivity(),0, mEvents);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if( convertView == null) {
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.list_item_event, null);	
			}
			Event mEvent = mEvents.get(position);
			
			ImageView icon = (ImageView)convertView.findViewById(R.id.list_item_event_icon);
			icon.setImageResource(mEvent.getType().getSrc());
			
			TextView name = (TextView)convertView.findViewById(R.id.list_item_event_name);
			name.setText(mEvent.getName());
			TextView date = (TextView)convertView.findViewById(R.id.list_item_event_date);
			date.setText(mEvent.getDate());
			TextView location = (TextView)convertView.findViewById(R.id.list_item_event_location);
			location.setText(mEvent.getLocation());
			
			return convertView;
		}
	}
	
	private class FetchItemsTask extends AsyncTask<Void, Void, List<Event>> {
		@Override
		protected List<Event> doInBackground(Void... params) {
			DataSportFetchr dsFetch = new DataSportFetchr();
			return dsFetch.fetchEvents();
		}
		
		@Override
		protected void onPostExecute(List<Event> results) {
			mEvents = results;
			setListAdapter(new EventAdapter(results));
		}
	}
}
