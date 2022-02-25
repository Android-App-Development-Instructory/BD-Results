package com.alaminkarno.bdresults;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    private ImageView appLogoIV;
    private TextView appTitleTV,appTagLineTv;

    Animation topAnimation,bottomAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        initialize();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        },2000);
    }

    private void initialize() {

        appLogoIV = findViewById(R.id.app_logoIV);
        appTitleTV = findViewById(R.id.app_titleTV);
        appTagLineTv = findViewById(R.id.app_tagLineTV);

        topAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bottom_animation);

        appLogoIV.setAnimation(topAnimation);
        appTitleTV.setAnimation(bottomAnimation);
        appTagLineTv.setAnimation(bottomAnimation);
    }
}