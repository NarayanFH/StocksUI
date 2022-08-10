package com.example.stockui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockui.databinding.StocksRvListBinding;
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
        StocksRvListBinding stocksRvListBinding = StocksRvListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(stocksRvListBinding, stocksRvListBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StocksModel stocksModel = stocksModelArrayList.get(position);
        holder.binding.tvStocksName.setText(stocksModel.getStockName());
        holder.binding.tv1DayValue.setText(stocksModel.getDayChangeP());
        holder.binding.tv1YearValue.setText(stocksModel.getYearChangeP());
        holder.binding.tvCurrentPriceValue.setText(stocksModel.getCurrentPrice());
        holder.binding.tvSectorName.setText(stocksModel.getSectorName());
//        holder.circleStockNameInitial.setText(stocksModel.getStockName().substring(0,1));
    }

    public void updateDataSet(ArrayList<StocksModel> stocksModelList) {
        if (stocksModelList != null) {
            stocksModelArrayList = stocksModelList;
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return stocksModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final StocksRvListBinding binding;

        public ViewHolder(StocksRvListBinding stocksRvListBinding, @NonNull View itemView) {
            super(itemView);
            this.binding = stocksRvListBinding;
        }
    }
}
