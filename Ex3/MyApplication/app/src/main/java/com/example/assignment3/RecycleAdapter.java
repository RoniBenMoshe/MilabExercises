package com.example.assignment3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by RoniBM on 14/11/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>{
    private List<ListItem> listItems;
    private Context context;

    public RecycleAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    };

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);

        holder.headTextView.setText(listItem.getHead());
        holder.descriptionTextView.setText(listItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView headTextView;
        public TextView descriptionTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            headTextView = (TextView)itemView.findViewById(R.id.headTextView);
            descriptionTextView = (TextView)itemView.findViewById(R.id.descriptionTextView);

        }
    }
}
