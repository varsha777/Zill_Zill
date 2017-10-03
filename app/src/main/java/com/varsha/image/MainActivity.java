package com.varsha.image;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends FragmentActivity implements LoadImageTask.Listener {

    private ImageView mImageView;

    public static final String IMAGE_URL = "https://r.sine.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mImageView = (ImageView) findViewById(R.id.image);
        new LoadImageTask(MainActivity.this).execute(IMAGE_URL);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LoadImageTask(MainActivity.this).execute(IMAGE_URL);
            }
        });
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {

        mImageView.setImageBitmap(bitmap);
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Error Loading Image !", Toast.LENGTH_SHORT).show();
    }
}
