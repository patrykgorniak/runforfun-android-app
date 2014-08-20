package runforfun.activities;

import runforfun.fragments.EventListFragment;
import runforfun.interfaces.AbstractFragmentActivity;
import android.support.v4.app.Fragment;


public class MainRffActivity extends AbstractFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new EventListFragment();
	}
}
