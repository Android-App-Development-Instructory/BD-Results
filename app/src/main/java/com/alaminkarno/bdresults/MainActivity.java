package com.alaminkarno.bdresults;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void openPSCWebView(View view) {
        Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
        intent.putExtra("URL","http://180.211.137.51/");
        startActivity(intent);
    }

    public void openJSCWebView(View view) {
        Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
        intent.putExtra("URL","https://eboardresults.com/v2/home");
        startActivity(intent);
    }
}