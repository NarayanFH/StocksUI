//package com.example.stockui.adapters;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.stockui.R;
//import com.example.stockui.models.StocksModel;
//
//import java.util.ArrayList;
//
//public class StocksRVAdapter extends RecyclerView.Adapter<StocksRVAdapter.ViewHolder> {
//
//    // variable for our array list and context.
//    private ArrayList<StocksModel> userModalArrayList;
//    private Context context;
//
//    // creating a constructor.
//    public StocksRVAdapter(ArrayList<StocksModel> userModalArrayList, Context context) {
//        this.userModalArrayList = userModalArrayList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        // inflating our layout file on below line.
//        View view = LayoutInflater.from(context).inflate(R.layout.stocks_rv_list, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        // getting data from our array list in our modal class.
//        StocksModel stocksModel = userModalArrayList.get(position);
//        // on below line we are setting data to our text view.
//        holder.stockName.setText(stocksModel.data.stock_full_name);
//        holder.oneDayHigh.setText((int) stocksModel.data.one_day_high);
//    }
//
//    @Override
//    public int getItemCount() {
//        // returning the size of array list.
//        return userModalArrayList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        // creating a variable for our text view and image view.
//        private TextView stockName, oneDayHigh, oneDayLow;
//        private ImageView userIV;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            stockName = itemView.findViewById(R.id.tvStocksName);
//            oneDayHigh = itemView.findViewById(R.id.tv1DayValue);
//        }
//    }
//}
