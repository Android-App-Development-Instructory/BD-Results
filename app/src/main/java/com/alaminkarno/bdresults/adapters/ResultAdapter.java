package com.alaminkarno.bdresults.adapters;

import android.content.Context;
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
