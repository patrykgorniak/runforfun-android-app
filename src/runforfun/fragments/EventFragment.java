package runforfun.fragments;

import java.util.UUID;

import com.android.sport.runforfun.R;

import runforfun.data.EventsStorage;
import runforfun.model.Event;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EventFragment extends Fragment {
	public static final String EXTRA_EVENT_ID = "runforfun.event_id";
	private Event mEvent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		getActivity().getIntent().getSerializableExtra(EXTRA_EVENT_ID)
		UUID event_id = (UUID)getActivity().getIntent().getSerializableExtra(EXTRA_EVENT_ID);
		mEvent = EventsStorage.getEvent(event_id);
		getActivity().setTitle(mEvent.getName());
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.item_event_details , container, false);
		TextView title = (TextView)v.findViewById(R.id.item_event_details_date);
		title.setText(mEvent.getName());
		
		return v;
	}

}
