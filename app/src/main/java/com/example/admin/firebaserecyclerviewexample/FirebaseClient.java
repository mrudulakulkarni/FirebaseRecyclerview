package com.example.admin.firebaserecyclerviewexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

/**
 * Created by Admin on 4/29/2017.
 */

public class FirebaseClient {

    Context c;
    String DB_URL;
    RecyclerView recyclerView;

    Firebase firebase;
    ArrayList<Beaches> beaches= new ArrayList<>();
    MyAdapter adapter;


    public  FirebaseClient(Context c, String DB_URL, RecyclerView recyclerView)
    {
        this.c= c;
        this.DB_URL= DB_URL;
        this.recyclerView= recyclerView;


        Firebase.setAndroidContext(c);
        firebase=new Firebase(DB_URL);
    }

    public  void savedata (String name, String url)
    {
        Beaches b= new Beaches();
        b.setName(name);
        b.setUrl(url);

        firebase.child("Beaches").push().setValue(b);


    }

    public  void refreshdata()
    {
        firebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
             getupdates(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                 getupdates(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void getupdates(DataSnapshot dataSnapshot){
        beaches.clear();
        for(DataSnapshot ds :dataSnapshot.getChildren()){
            Beaches b= new Beaches();
            b.setName(ds.getValue(Beaches.class).getName());
            b.setUrl(ds.getValue(Beaches.class).getUrl());
            beaches.add(b);

        }
        if(beaches.size()>0)
        {
            adapter=new MyAdapter(c, beaches);
            recyclerView.setAdapter(adapter);
        }else
        {
            Toast.makeText(c, "No data", Toast.LENGTH_SHORT).show();
        }
    }
}
