package com.example.thedanileron.howtobeslugabed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    RecyclerView recyclerView;
    Context c;
    ArrayList<String> items;
    private final View.OnClickListener mOnClickListener = new MyOnClickListener();

    public MyAdapter(Context c, ArrayList<String> items, RecyclerView recyclerView) {
        this.c = c;
        this.items = items;
        this.recyclerView = recyclerView;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.list_item, parent, false);
        v.setOnClickListener(mOnClickListener);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nameTxt.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private class MyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            int itemPosition = recyclerView.getChildLayoutPosition(view);
            Intent intent = new Intent(c, StepDescription.class);
            intent.putExtra("STEP_TITLE", items.get(itemPosition));
            c.startActivity(intent);
        }
    }
}
