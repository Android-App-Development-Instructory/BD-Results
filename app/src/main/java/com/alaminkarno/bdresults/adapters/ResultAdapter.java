package com.alaminkarno.bdresults.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.alaminkarno.bdresults.R;
import com.alaminkarno.bdresults.model.ResultCard;
import com.alaminkarno.bdresults.view.activity.MainActivity;
import com.alaminkarno.bdresults.view.activity.WebViewActivity;
import com.alaminkarno.bdresults.view.utils.Constant;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder> {

    List<ResultCard> resultCards;
    Context context;

    public ResultAdapter(List<ResultCard> resultCards, Context context) {
        this.resultCards = resultCards;
        this.context = context;
    }

    @NonNull
    @Override
    public ResultAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_design_result_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultAdapter.ViewHolder holder, int position) {

        ResultCard resultCard = resultCards.get(position);

        holder.cardView.setCardBackgroundColor(resultCard.getColor());
        holder.imageView.setImageDrawable(resultCard.getImageView());
        holder.titleTV.setText(resultCard.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOnline()){
                    openWebView(resultCard.getSiteLink());
                }
                else{
                    showPopUpMessage();
                }
            }
        });

    }

    private void showPopUpMessage() {
        new AlertDialog.Builder(context)
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

    private void openWebView(String siteURL) {

        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(Constant.URL,siteURL);
        context.startActivity(intent);
    }

    private boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    @Override
    public int getItemCount() {
        return resultCards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        CardView cardView;
        TextView titleTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.model_imageView);
            cardView = itemView.findViewById(R.id.model_cardView);
            titleTV = itemView.findViewById(R.id.model_textView);
        }
    }
}
