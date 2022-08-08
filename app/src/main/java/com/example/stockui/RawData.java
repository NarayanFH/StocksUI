package com.example.stockui;

public class RawData {

    ///**** Old main bindings
    //    ActivityMainBinding mBinding;
//    private ArrayList<StocksModel> stocksModelList;
//    StocksRVAdapter stocksRVAdapter;
//    int page = 1;
//    int savedPage =1;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
//        View view = mBinding.getRoot();
//        setContentView(view);
//        getDataFromAPI(page);
//        stocksModelList = new ArrayList<>();
//
//        mBinding.idNestedSV.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
//                    page++;
//                    getDataFromAPI(page);
//                    System.out.println(savedPage);
//                    System.out.println("Page Number" + page);
//                } else if (scrollY == 0 & page >1) {
//                    page --;
//                    getDataFromAPI(page);
//                    System.out.println("Page Number" + page);
//                }
//            }
//        });
//    }
//
//    private void getDataFromAPI(int page) {
//        StocksModel stocksModel = new StocksModel();
//        stocksModel.setPage(page);
//
//        NetworkClass.apiClient().create(RetrofitAPI.class).getPageStocks(stocksModel)
//                .enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                mBinding.idPBLoading.setVisibility(View.VISIBLE);
//                System.out.println("Response body:" + response.body());
//                Log.e("Stock Rwspnseo:--", response.body().toString());
//                try {
//                    JSONObject jsonObject = new JSONObject(response.body().string());
//                    JSONArray dataArray = jsonObject.getJSONArray("data");
//                    Log.e("jsonObjectasset", jsonObject.toString());
//                    String value = jsonObject.optString("data", "");
//                    Gson gson = new Gson();
//                    Type typeToken = new TypeToken<List<StocksModel>>() {
//                    }.getType();
//                    stocksModelList = gson.fromJson(value, typeToken);
//                    for (int i = 0; i < dataArray.length(); i++) {
//                        stocksModelList.add(new StocksModel(stocksModelList.get(i).getStockName(), stocksModelList.get(i).getCurrentPrice(), stocksModelList.get(i).getDayChangeP(), stocksModelList.get(i).getYearChangeP()));
//                        stocksRVAdapter = new StocksRVAdapter(stocksModelList, MainActivity.this);
//                        mBinding.idRVUsers.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//                        mBinding.idRVUsers.setAdapter(stocksRVAdapter);
//
//                    }
//                    System.out.println(savedPage);
//                } catch (IOException | JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                System.out.println("Error From APi  ......" + t.getMessage());
//            }
//        });
//
//    }
}
