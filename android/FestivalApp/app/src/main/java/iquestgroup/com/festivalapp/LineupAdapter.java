package iquestgroup.com.festivalapp;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.etsy.android.grid.util.DynamicHeightImageView;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Andreea Both
 */

public class LineupAdapter extends BaseAdapter {
    private ArrayList<String> artists;
    private LayoutInflater inflater;
    private Context context;
    private Random mRandom;
    private static final SparseArray<Double> sPositionHeightRatios = new SparseArray<Double>();

    public LineupAdapter(ArrayList<String> artists, Context context) {
        this.artists = artists;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.mRandom = new Random();
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.lineup_grid_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.artist_image);
            viewHolder.textView = convertView.findViewById(R.id.artist_name);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        switch (position) {
            case 0:
                viewHolder.imageView.setImageResource(R.drawable.t);
                break;
            case 1:
                viewHolder.imageView.setImageResource(R.drawable.t2);
                break;
            case 2:
                viewHolder.imageView.setImageResource(R.drawable.t3);
                break;
            case 3:
                viewHolder.imageView.setImageResource(R.drawable.t4);
                break;
            case 4:
                viewHolder.imageView.setImageResource(R.drawable.t6);
                break;
            case 5:
                viewHolder.imageView.setImageResource(R.drawable.t7);
                break;
            default:
                viewHolder.imageView.setImageResource(R.drawable.t5);
                break;
        }

        viewHolder.textView.setText(artists.get(position));
        double positionHeight = getPositionRatio(position);

        viewHolder.imageView.setHeightRatio(positionHeight);

        return convertView;
    }

    private class ViewHolder {
        public DynamicHeightImageView imageView;
        public TextView textView;
    }

    private double getPositionRatio(final int position) {
        double ratio = sPositionHeightRatios.get(position, 0.0);
        // if not yet done generate and stash the columns height
        // in our real world scenario this will be determined by
        // some match based on the known height and width of the image
        // and maybe a helpful way to get the column height!
        if (ratio == 0) {
            ratio = getRandomHeightRatio();
            sPositionHeightRatios.append(position, ratio);
        }
        return ratio;
    }

    private double getRandomHeightRatio() {
        return (mRandom.nextDouble() / 2.0) + 1.0; // height will be 1.0 - 1.5
        // the width
    }

}
