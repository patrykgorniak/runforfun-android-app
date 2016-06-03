package runforfun.activities;

import android.support.v4.app.Fragment;
import runforfun.fragments.EventFragment;
import runforfun.interfaces.AbstractFragmentActivity;

public class EventActivity extends AbstractFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new EventFragment();
	}

}
