package com.example.prueba2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Info extends AppCompatActivity {
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        videoView = (VideoView)findViewById(R.id.vd);

        //pasar nuestro video a tarves de la ruta

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;//Ruta del video

        Uri uri = Uri.parse(ruta);
        videoView. setVideoURI(uri);

        //cotroles de navegacion

        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
    }
    public void Maps(View v)
    {
        Intent i = new Intent (this, Maps.class);
        startActivity(i);
    }
}