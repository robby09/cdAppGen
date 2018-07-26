package iquestgroup.com.festivalapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.etsy.android.grid.StaggeredGridView;

import java.util.ArrayList;

/**
 * @author Andreea Both
 */

public class LineupFragment extends Fragment {

    private StaggeredGridView grid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lineup, null);
        grid = view.findViewById(R.id.grid_view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        createAdapter();
    }

    private void createAdapter() {
        ArrayList<String> artists = new ArrayList<>();
        artists.add("Taylor swift");
        artists.add("A2");
        artists.add("A3");
        artists.add("A4");
        artists.add("A5");

        LineupAdapter adapter = new LineupAdapter(artists, getContext());
        grid.setAdapter(adapter);
    }
}
