package com.bellamy.tpandroidasynctask;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button lauchExtandedOperation = (Button) findViewById(R.id.lauch_extanded_operation);
        lauchExtandedOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExtandedOperation ext = new ExtandedOperation(ScrollingActivity.this, ((ProgressBar)findViewById(R.id.progressBar)));
                ext.execute();
            }
        });

//        ImageView extandedImageView = (ImageView) findViewById(R.id.extanded_imageview);
/*        ((Button) findViewById(R.id.load_extanded_image)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    LoadExtandedImage imageLoader = new LoadExtandedImage();
                    imageLoader.execute(new URL("https://i.ytimg.com/vi/1UvEZPA_YzY/maxresdefault.jpg"));

                    Bitmap img = imageLoader.get();

                    ((ImageView) view.getRootView().findViewById(R.id.extanded_imageview)).setImageBitmap(img);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }); */

        findViewById(R.id.lauch_multiplier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Multiplier multiplier = new Multiplier(ScrollingActivity.this, ((ProgressBar) findViewById(R.id.progressBar2)));

                String [] listNumber = (((TextView) view.getRootView().findViewById(R.id.list_number)).getText()+"").split(" ");

                Integer [] listNumberInt = new Integer[listNumber.length];
                for (int i = 0; i < listNumber.length; i++) {
                    for (int j=0; j < 100000; j++){}
                    listNumberInt[i] = Integer.parseInt(listNumber[i]);
                }

                multiplier.execute(listNumberInt);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
