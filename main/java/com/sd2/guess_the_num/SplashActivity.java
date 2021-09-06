package com.sd2.guess_the_num;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private ImageView imageview;
    private TextView textView;
    Animation imageAnimation,textAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageview = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        imageAnimation = AnimationUtils.loadAnimation(this,R.anim.image_animation);
        textAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);

        imageview.setAnimation(imageAnimation);
        textView.setAnimation(textAnimation);

        new CountDownTimer(5000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                finish();
                startActivity(intent);
            }
        }.start();
    }
}