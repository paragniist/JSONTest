package com.test.vinove.jsontest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vinove on 28/3/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<SpecialistModel> list;

    public MyAdapter(Context context, ArrayList<SpecialistModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.indiview, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name_id.setText(list.get(position).getName());
        holder.id_id.setText(list.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name_id;
        public TextView id_id;

        public MyViewHolder(View view) {
            super(view);
            name_id = view.findViewById(R.id.name_id);
            id_id = view.findViewById(R.id.id);


/*
            name_id.setOnClickListener(new View.OnClickListener() */
/*{
                @Override
                public void onClick(View v) {
                    list.get(getLayoutPosition()).getId();
                }
            }*//*
);
*/
        }
    }
}
