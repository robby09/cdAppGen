package iquestgroup.com.festivalapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Andreea Both
 */

public class LineupFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lineup, container);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        createAdapter();
    }

    private void createAdapter() {

    }
}
