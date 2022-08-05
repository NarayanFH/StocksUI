//package com.example.stockui.fragments;
//
//import android.os.Bundle;
//
//import androidx.annotation.Nullable;
//import androidx.core.widget.NestedScrollView;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ProgressBar;
//import android.widget.Toast;
//
//import com.example.stockui.R;
//import com.example.stockui.adapters.StocksRVAdapter;
//import com.example.stockui.models.StocksModel;
//
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//
//public class AllStocks extends Fragment {
//
//    public AllStocks() {
//    }
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_all_stocks, container, false);
//    }
//
//    private ArrayList<StocksModel> userModalArrayList;
//    private StocksRVAdapter userRVAdapter;
//    private RecyclerView userRV;
//    private ProgressBar loadingPB;
//    private NestedScrollView nestedSV;
//
//    // creating a variable for our page and limit as 2
//    // as our api is having highest limit as 2 so
//    // we are setting a limit = 2
//    int page = 0, limit = 2;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // creating a new array list.
//        userModalArrayList = new ArrayList<>();
//
//        // initializing our views.
//        userRV = findViewById(R.id.idRVUsers);
//        loadingPB = findViewById(R.id.idPBLoading);
//        nestedSV = findViewById(R.id.idNestedSV);
//
//        // calling a method to load our api.
//        getDataFromAPI(page, limit);
//
//        // adding on scroll change listener method for our nested scroll view.
//        nestedSV.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                // on scroll change we are checking when users scroll as bottom.
//                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
//                    // in this method we are incrementing page number,
//                    // making progress bar visible and calling get data method.
//                    page++;
//                    loadingPB.setVisibility(View.VISIBLE);
//                    getDataFromAPI(page, limit);
//                }
//            }
//        });
//    }
//
//    private void getDataFromAPI(int page, int limit) {
//        if (page > limit) {
//            // checking if the page number is greater than limit.
//            // displaying toast message in this case when page>limit.
////            Toast.makeText(, "That's all the data..", Toast.LENGTH_SHORT).show();
//
//            // hiding our progress bar.
//            loadingPB.setVisibility(View.GONE);
//            return;
//        }
//        // creating a string variable for url .
//        String url = "https://reqres.in/api/users?page=" + page;
//
//        // creating a new variable for our request queue
//        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
//
//        // creating a variable for our json object request and passing our url to it.
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//
//                    // on below line we are extracting data from our json array.
//                    JSONArray dataArray = response.getJSONArray("data");
//
//                    // passing data from our json array in our array list.
//                    for (int i = 0; i < dataArray.length(); i++) {
//                        JSONObject jsonObject = dataArray.getJSONObject(i);
//
//                        // on below line we are extracting data from our json object.
//                        userModalArrayList.add(new UserModal(jsonObject.getString("first_name"), jsonObject.getString("last_name"), jsonObject.getString("email"), jsonObject.getString("avatar")));
//
//                        // passing array list to our adapter class.
//                        userRVAdapter = new UserRVAdapter(userModalArrayList, MainActivity.this);
//
//                        // setting layout manager to our recycler view.
//                        userRV.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//
//                        // setting adapter to our recycler view.
//                        userRV.setAdapter(userRVAdapter);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // handling on error listener method.
//                Toast.makeText(MainActivity.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
//            }
//        });
//        // calling a request queue method
//        // and passing our json object
//        queue.add(jsonObjectRequest);
//    }
//}