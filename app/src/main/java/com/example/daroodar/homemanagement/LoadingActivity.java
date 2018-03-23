package com.example.daroodar.homemanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class LoadingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Timer timer = new Timer();
        RunAnimation();
        timer.schedule(new TimerTask() {

            public void run() {

                Intent myIntent = new Intent(LoadingActivity.this, MainActivity.class);
                LoadingActivity.this.startActivity(myIntent);
            }

        }, 4000);
    }
    private void RunAnimation()
    {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.titleanim);
        a.reset();
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.clearAnimation();
        tv.startAnimation(a);
    }
}
