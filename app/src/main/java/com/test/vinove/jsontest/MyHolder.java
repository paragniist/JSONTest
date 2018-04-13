package com.test.vinove.jsontest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by vinove on 28/3/18.
 */

public class MyHolder extends RecyclerView.ViewHolder {

    TextView name;

    public MyHolder(View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name_id);
    }
}
