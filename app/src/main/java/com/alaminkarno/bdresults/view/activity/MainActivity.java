package com.alaminkarno.bdresults.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alaminkarno.bdresults.R;
import com.alaminkarno.bdresults.view.utils.Constant;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void openPSCWebView(View view) {

        if(isOnline()){
            openWebView(Constant.PSC_SITE);
        }
        else{
            showPopUpMessage();
        }


    }


    public void openJSCWebView(View view) {

        if(isOnline()){
            openWebView(Constant.JSC_SITE);
        }
        else{
            showPopUpMessage();
        }


    }

    private void showPopUpMessage() {
        new AlertDialog.Builder(this)
                .setTitle("No Internet!")
                .setMessage("Please connect your device with internet...")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel",null)
                .setIcon(R.drawable.ic_baseline_signal_cellular_connected_no_internet_4_bar_24)
                .show();
    }

    private boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    private void openWebView(String siteURL) {

        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
        intent.putExtra(Constant.URL,siteURL);
        startActivity(intent);
    }


}