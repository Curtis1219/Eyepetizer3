package com.example.administrator.eyepetizer.moduls.featured;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.administrator.eyepetizer.Config;
import com.example.administrator.eyepetizer.MyApp.MyApp;
import com.example.administrator.eyepetizer.R;
import com.example.administrator.eyepetizer.moduls.featured.adapter.FeaturedAdapter;
import com.example.administrator.eyepetizer.moduls.featured.bens.FeaturedInfo4;
import com.example.administrator.eyepetizer.moduls.featured.interfaces.FeaturedInter;
import com.example.administrator.eyepetizer.tools.view.PullToZoomListViewEx;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedFragment extends Fragment {

    //控件
    private PullToZoomListViewEx pullToZoomListViewEx;

    //数据
    private List<FeaturedInfo4.IssueListBean.ItemListBean> itemListBeen;
    private List<FeaturedInfo4.IssueListBean> day;

    //适配器
    private FeaturedAdapter adapter;

    private String textView1 = null;
    private String path = null;

    private boolean isLast = false;

    public FeaturedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       getData();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_featured, container, false);
        pullToZoomListViewEx = (PullToZoomListViewEx) view.findViewById(R.id.featured_fragment_list_id);
        //隐藏滚动条--配合XML中的：android:scrollbars="none"使用
        pullToZoomListViewEx.setVerticalScrollBarEnabled(false);

        final TextView textView = (TextView) view.findViewById(R.id.featured_fragment_text_id);
        textView.setVisibility(View.GONE);

        //添加头视图
        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.list_head_zoom_view,null,false);
        pullToZoomListViewEx.setHeaderView(view1);
        //获取屏幕的宽度并设置参数
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        pullToZoomListViewEx.setHeaderViewSize(width,height/3);

        getData();

        pullToZoomListViewEx.getPullRootView().setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

                if (isLast && scrollState == SCROLL_STATE_IDLE){
                    if (path!=textView1)
                    addData(path);
                    textView1 = path;
                }

            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem != 0) {
                    textView.setVisibility(View.VISIBLE);
//                    textView.setText("Today");
//                    if (!TextUtils.isEmpty(itemListBeen.get(firstVisibleItem).getData().getText())){
//                    for (int i = 0; i < day.size(); i++) {
//
//                        if (firstVisibleItem == day.get(i).getCount()+1){
//                                textView1 = itemListBeen.get(firstVisibleItem).getData().getText();
//                                textView.setText(itemListBeen.get(firstVisibleItem).getData().getText());

                            if (firstVisibleItem< day.get(0).getItemList().size()){
                                textView.setText("Today");

                            }else {
                                if (!TextUtils.isEmpty(itemListBeen.get(firstVisibleItem).getData().getText())){
                                    textView.setText(itemListBeen.get(firstVisibleItem).getData().getText());
                                }
                            }


//                            }
//                        }
//                    }


                }else {
                    textView.setVisibility(View.GONE);
                }
                //上拉加载跟多
                isLast = (firstVisibleItem + visibleItemCount == totalItemCount);
            }

        });

        return view;
    }


    //下载数据
    public void getData() {
        //声明Retrofit
        //建造者
        Retrofit.Builder builder = new Retrofit.Builder();

        //设置公共的地址
        builder.baseUrl(Config.ZHU_TI_PATH);

        //解析json数据，Gson解析
        builder.addConverterFactory(GsonConverterFactory.create());

        //得到Retrofit对象
        Retrofit retrofit = builder.build();

        //获得接口中的方法
        //得到接口
        FeaturedInter featuredInter = retrofit.create(FeaturedInter.class);

        //得到Call方法//num=1&vc=168&deviceModel=LT18i
        Call<FeaturedInfo4> call = featuredInter.getFeaturedInfo4();

        //传入接口回调，来获取数据
        call.enqueue(new Callback<FeaturedInfo4>() {
            @Override
            public void onResponse(Call<FeaturedInfo4> call, Response<FeaturedInfo4> response) {
                FeaturedInfo4 featuredInfo4 = response.body();
                day = featuredInfo4.getIssueList();
                path = featuredInfo4.getNextPageUrl();
                String nextPageUrl = featuredInfo4.getNextPageUrl();
                Log.e("tag:","网络请求数据444---111"+featuredInfo4.getIssueList().get(1).getType());
                Log.e("tag:","网络请求数据444---222"+featuredInfo4.getIssueList().get(1).getItemList().get(0).getType());
                Log.e("tag:","网络请求数据444---333"+featuredInfo4.getIssueList().get(1).getItemList().get(0).getData().getImage());

                itemListBeen = new ArrayList<FeaturedInfo4.IssueListBean.ItemListBean>();

                for (int i = 0; i < featuredInfo4.getIssueList().size(); i++) {
                    for (int j = 0; j < featuredInfo4.getIssueList().get(i).getItemList().size(); j++) {
                        itemListBeen.add(featuredInfo4.getIssueList().get(i).getItemList().get(j));
                    }
                }

                adapter = new FeaturedAdapter(getActivity(),itemListBeen);
                pullToZoomListViewEx.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<FeaturedInfo4> call, Throwable t) {

            }
        });
    }

    public void addData(String url){

        StringRequest request = new StringRequest(url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                FeaturedInfo4 featuredInfo4 = new Gson().fromJson(response, FeaturedInfo4.class);
                path = featuredInfo4.getNextPageUrl();
                for (int i = 0; i < featuredInfo4.getIssueList().size(); i++) {
                        itemListBeen.addAll(featuredInfo4.getIssueList().get(i).getItemList());
                }

                adapter.notifyDataSetChanged();

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("tag","加载更多数据请求失败");
            }
        });

        //3, 把请求对象添加到请求队列中
        MyApp.getHttpQueue().add(request);
    }
}
