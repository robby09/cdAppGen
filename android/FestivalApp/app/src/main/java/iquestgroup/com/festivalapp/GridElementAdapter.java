package iquestgroup.com.festivalapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andreea Both
 */

public class GridElementAdapter extends RecyclerView.Adapter<GridElementAdapter.SimpleViewHolder> {

    private Context context;
    private ArrayList<Artist> elements;

    public GridElementAdapter(Context context, ArrayList<Artist> artists) {
        this.context = context;
        this.elements = artists;

    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageView;
        public final TextView name;
        public final TextView time;

        public SimpleViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imagea);
            name = view.findViewById(R.id.namea);
            time = view.findViewById(R.id.timea);
        }
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(this.context).inflate(R.layout.grid_element, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, final int position) {

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return this.elements.size();
    }
}