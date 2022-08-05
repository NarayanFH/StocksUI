package com.example.stockui.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockui.R;
import com.example.stockui.models.StocksModel;

import java.util.ArrayList;

public class StocksRVAdapter extends RecyclerView.Adapter<StocksRVAdapter.ViewHolder> {

    private ArrayList<StocksModel> stocksModelArrayList;
    private Context context;

    public StocksRVAdapter(ArrayList<StocksModel> stocksModelArrayList, Context context) {
        this.stocksModelArrayList = stocksModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.stocks_rv_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StocksModel stocksModel = stocksModelArrayList.get(position);
        holder.stockName.setText(stocksModel.data.get(position).stockName);
        holder.oneDayHigh.setText(stocksModel.data.get(position).dayChangeP);
        holder.oneYearHigh.setText(stocksModel.data.get(position).yearChangeP);
        holder.currentPrice.setText(stocksModel.data.get(position).currentPrice);
    }

    @Override
    public int getItemCount() {
        return stocksModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView stockName, oneDayHigh, oneYearHigh,currentPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stockName = itemView.findViewById(R.id.tvStocksName);
            oneDayHigh = itemView.findViewById(R.id.tv1DayValue);
            oneYearHigh = itemView.findViewById(R.id.tv1YearValue);
            currentPrice = itemView.findViewById(R.id.tvCurrentPriceValue);
        }
    }
}
