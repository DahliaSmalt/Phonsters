package storb.phonsters;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Don't call requestFeature before setContentView
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        findViewById(R.id.homeButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                PlaceholderFragment placeholderFragment = new PlaceholderFragment();
                placeholderFragment.setFragment(R.layout.fragment_home);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, placeholderFragment)
                        .commit();
            }
        });

        findViewById(R.id.helpButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                PlaceholderFragment placeholderFragment = new PlaceholderFragment();
                placeholderFragment.setFragment(R.layout.fragment_help);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, placeholderFragment)
                        .commit();
            }
        });
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private int fragment = R.layout.fragment_home;

        public PlaceholderFragment() {

        }

        public void setFragment(int fragment) {
            this.fragment = fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(fragment, container, false);
        }
    }
}
