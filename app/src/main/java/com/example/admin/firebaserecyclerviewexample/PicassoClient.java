package com.example.admin.firebaserecyclerviewexample;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Admin on 4/29/2017.
 */

public class PicassoClient {

    public  static  void downloadimg(Context c, String url, ImageView img)
    {
        if (url!=null && url.length()>0)
        {
            Picasso.with(c).load(url).placeholder(R.drawable.placeholder).into(img);

        }else
        {
            Picasso.with(c).load(R.drawable.placeholder).into(img);
        }
    }
}
