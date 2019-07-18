package com.example.project_mp1;

import android.animation.ObjectAnimator;
import android.app.ListActivity;

import android.os.Bundle;
import android.content.Intent;

import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.git);
        ObjectAnimator animator = ObjectAnimator.ofFloat(img,"rotationY",0.0f,360.0f);
        animator.setDuration(3000);
        animator.setRepeatCount(Animation.INFINITE);
        animator.start();
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, listview.class);
                startActivity(intent);
                finish();
            }
        },5000);


    }
}

