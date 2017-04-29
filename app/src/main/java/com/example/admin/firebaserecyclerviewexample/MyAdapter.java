package com.example.admin.firebaserecyclerviewexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Admin on 4/29/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Beaches> beaches;

    public MyAdapter (Context c, ArrayList<Beaches> beaches){
        this.c= c;
        this.beaches=beaches;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.beach_layout,parent,false);
        MyHolder holder= new MyHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.nameTxt.setText(beaches.get(position).getName());
        PicassoClient.downloadimg(c, beaches.get(position).getUrl(),holder.img);


    }

    @Override
    public int getItemCount() {
        return beaches.size();
    }
}
