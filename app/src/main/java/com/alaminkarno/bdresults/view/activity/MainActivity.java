package com.alaminkarno.bdresults.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alaminkarno.bdresults.R;
import com.alaminkarno.bdresults.adapters.ResultAdapter;
import com.alaminkarno.bdresults.model.ResultCard;
import com.alaminkarno.bdresults.view.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ResultCard> resultCardList;
    private ResultAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        setData();
    }

    private void setData() {

        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.PSC_LOGO),Constant.COLOR1,Constant.PSC_TITLE,Constant.PSC_PDC_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.MADRASA_LOGO),Constant.COLOR2,Constant.PDC_TITLE,Constant.PSC_PDC_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.JSC_SSC_HSC_LOGO),Constant.COLOR3,Constant.JSC_TITLE,Constant.JSC_JDC_SSC_DAKHIL_BOKESIONAL_HSC_ALIM_DIBS_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.MADRASA_LOGO),Constant.COLOR4,Constant.JDC_TITLE,Constant.JSC_JDC_SSC_DAKHIL_BOKESIONAL_HSC_ALIM_DIBS_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.JSC_SSC_HSC_LOGO),Constant.COLOR5,Constant.SSC_TITLE,Constant.JSC_JDC_SSC_DAKHIL_BOKESIONAL_HSC_ALIM_DIBS_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.MADRASA_LOGO),Constant.COLOR6,Constant.DAKHIL_TITLE,Constant.JSC_JDC_SSC_DAKHIL_BOKESIONAL_HSC_ALIM_DIBS_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.JSC_SSC_HSC_LOGO),Constant.COLOR7,Constant.HSC_TITLE,Constant.JSC_JDC_SSC_DAKHIL_BOKESIONAL_HSC_ALIM_DIBS_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.VOKESIONAL_LOGO),Constant.COLOR1,Constant.VOKESIONAL_TITLE,Constant.JSC_JDC_SSC_DAKHIL_BOKESIONAL_HSC_ALIM_DIBS_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.MADRASA_LOGO),Constant.COLOR2,Constant.ALIM_TITLE,Constant.JSC_JDC_SSC_DAKHIL_BOKESIONAL_HSC_ALIM_DIBS_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.VOKESIONAL_LOGO),Constant.COLOR3,Constant.DIBS_TITLE,Constant.JSC_JDC_SSC_DAKHIL_BOKESIONAL_HSC_ALIM_DIBS_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.DEGREE_HONOURS_MASTERS_PROFESSIONAL_LOGO),Constant.COLOR4,Constant.DEGREE_TITlE,Constant.DEGREE_HONOURS_MASTERS_PROFESSIONAL_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.DEGREE_HONOURS_MASTERS_PROFESSIONAL_LOGO),Constant.COLOR5,Constant.HONOURS_TITlE,Constant.DEGREE_HONOURS_MASTERS_PROFESSIONAL_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.DEGREE_HONOURS_MASTERS_PROFESSIONAL_LOGO),Constant.COLOR6,Constant.MASTERS_TITlE,Constant.DEGREE_HONOURS_MASTERS_PROFESSIONAL_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.DEGREE_HONOURS_MASTERS_PROFESSIONAL_LOGO),Constant.COLOR7,Constant.PROFESSIONAL_TITlE,Constant.DEGREE_HONOURS_MASTERS_PROFESSIONAL_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.DEGREE_HONOURS_MASTERS_PROFESSIONAL_LOGO),Constant.COLOR1,Constant.DEGREE_ADMISSION_TITlE,Constant.DEGREE_HONOURS_MASTERS_PROFESSIONAL_ADMISSION_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.DEGREE_HONOURS_MASTERS_PROFESSIONAL_LOGO),Constant.COLOR2,Constant.HONOURS_ADMISSION_TITlE,Constant.DEGREE_HONOURS_MASTERS_PROFESSIONAL_ADMISSION_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.DEGREE_HONOURS_MASTERS_PROFESSIONAL_LOGO),Constant.COLOR3,Constant.MASTERS_ADMISSION_TITlE,Constant.DEGREE_HONOURS_MASTERS_PROFESSIONAL_ADMISSION_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.DEGREE_HONOURS_MASTERS_PROFESSIONAL_LOGO),Constant.COLOR4,Constant.PROFESSIONAL_ADMISSION_TITlE,Constant.DEGREE_HONOURS_MASTERS_PROFESSIONAL_ADMISSION_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.BOU_LOGO),Constant.COLOR5,Constant.BOU_TITLE,Constant.BOU_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.XI_LOGO),Constant.COLOR6,Constant.XI_TITLE,Constant.XI_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.BEBT_LOGO),Constant.COLOR7,Constant.BEBT_TITLE,Constant.BEBT_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.MBBS_LOGO),Constant.COLOR1,Constant.MBBS_TITLE,Constant.MBBS_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.BDS_LOGO),Constant.COLOR2,Constant.BDS_TITLE,Constant.BDS_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.BCPS_LOGO),Constant.COLOR3,Constant.BCPS_TITLE,Constant.BCPS_SITE));
        resultCardList.add(new ResultCard(getResources().getDrawable(Constant.NTRCA_LOGO),Constant.COLOR4,Constant.NTRCA_TITLE,Constant.NTRCA_SITE));

        adapter.notifyDataSetChanged();
    }

    private void initialize() {

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        resultCardList = new ArrayList<>();
        adapter = new ResultAdapter(resultCardList,this);
        recyclerView.setAdapter(adapter);
    }


    /*public void openPSCWebView(View view) {

        if(isOnline()){
            openWebView(Constant.PSC_PDC_SITE);
        }
        else{
            showPopUpMessage();
        }


    }

    public void openJSCWebView(View view) {

        if(isOnline()){
            openWebView(Constant.JSC_JDC_SSC_DAKHIL_BOKESIONAL_HSC_ALIM_DIBS_SITE);
        }
        else{
            showPopUpMessage();
        }


    }

    private void showPopUpMessage() {
        new AlertDialog.Builder(this)
                .setTitle("No Internet!")
                .setMessage("Please connect your device with internet.")
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
    }*/


}