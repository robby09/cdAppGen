package iquestgroup.com.festivalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * @author Andreea Both
 */

public class LineupAdapter extends BaseAdapter {
    private ArrayList<String> artists;
    private LayoutInflater inflater;
    private Context context;

    public LineupAdapter(ArrayList<String> artists, Context context) {
        this.artists = artists;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return artists.size();
    }

    @Override
    public Object getItem(int position) {
        return artists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater.inflate(R.layout.lineup_grid_item, null);
        if (convertView == null) {

        } else {

        }


        return convertView;
    }
}
