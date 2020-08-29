package com.example.video_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class video_view extends AppCompatActivity {
    TextView textView1;
    VideoView videoView;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        videoView=findViewById(R.id.video);
        textView1=findViewById(R.id.txt2);
        textView2=findViewById(R.id.dis);
        String title1=getIntent().getStringExtra("title");
        String image=getIntent().getStringExtra("imageurl");
        String dic=getIntent().getStringExtra("dis");
        videoView.setVideoURI(Uri.parse(image));
        MediaController mediaController = new
                MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
        textView1.setText(title1);
        textView2.setText(dic);
    }
}