package runforfun.fragments;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.android.sport.runforfun.R;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import runforfun.activities.EventActivity;
import runforfun.data.*;
import runforfun.model.*;

public class EventListFragment extends ListFragment {
	private HashMap<Event.EventType, Integer> eventTypeToIconMap = new HashMap<Event.EventType, Integer>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		init();
		Log.d("RunForFun", "EventListFragment");
		
		if(EventsStorage.getEvents()==null) {
			new FetchItemsTask().execute();
		}
		else {
			setListAdapter(new EventAdapter(EventsStorage.getEvents()));
		}
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		UUID mEventId = EventsStorage.getEvent(position).getId();
		Intent i = new Intent(getActivity(), EventActivity.class);
		i.putExtra(EventFragment.EXTRA_EVENT_ID, mEventId);
		startActivity(i);
	}

	private void init() {
		// Initialization maping EventType to icon resource
		eventTypeToIconMap.put(Event.EventType.RUNNING, R.drawable.run);
		eventTypeToIconMap.put(Event.EventType.BICYCLING, R.drawable.bicycle);
		eventTypeToIconMap.put(Event.EventType.SKIING, R.drawable.ski);
		eventTypeToIconMap.put(Event.EventType.DOG, R.drawable.dog);
		eventTypeToIconMap.put(Event.EventType.BIATHLON, R.drawable.biathlon);
		eventTypeToIconMap.put(Event.EventType.OTHER, R.drawable.other);
	}


	private class EventAdapter extends ArrayAdapter<Event> {
		public EventAdapter(List<Event> mEvents) {
			super(getActivity(),0, mEvents);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if( convertView == null) {
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.list_item_event, null);	
			}
			Event mEvent = EventsStorage.getEvent(position);
			ImageView icon = (ImageView)convertView.findViewById(R.id.list_item_event_icon);
			icon.setImageResource(eventTypeToIconMap.get(mEvent.getType()));
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
		protected void onPostExecute(List<Event> events) {
			EventsStorage.setEvents(events);
			setListAdapter(new EventAdapter(EventsStorage.getEvents()));
		}
	}
}
