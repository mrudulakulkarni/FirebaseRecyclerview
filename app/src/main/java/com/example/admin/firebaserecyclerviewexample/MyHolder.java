package com.example.admin.firebaserecyclerviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Admin on 4/29/2017.
 */

public class MyHolder  extends RecyclerView.ViewHolder {

    TextView nameTxt;
    ImageView img;
    public MyHolder(View itemView) {
        super(itemView);

        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        img=(ImageView) itemView.findViewById(R.id.beachImage);


    }
}
