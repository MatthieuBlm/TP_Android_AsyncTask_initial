package com.bellamy.tpandroidasynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.URL;

public class LoadExtandedImage extends AsyncTask<URL, Void, Bitmap> {

    @Override
    protected Bitmap doInBackground(URL... urls) {
        try {
            return BitmapFactory.decodeStream(urls[0].openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
