package com.example.administrator.eyepetizer.moduls.find.author;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.administrator.eyepetizer.Config;
import com.example.administrator.eyepetizer.R;
import com.example.administrator.eyepetizer.moduls.featured.interfaces.FeaturedInter;
import com.example.administrator.eyepetizer.moduls.find.author.adapter.AuthorAdapter;
import com.example.administrator.eyepetizer.moduls.find.author.adapter.AuthorHanderAdapter;
import com.example.administrator.eyepetizer.moduls.find.author.bean.AuthorInfo;

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
public class AuthorFragment extends Fragment implements ViewPager.OnPageChangeListener{

    //控件
    private ListView listView;
    private ViewPager viewPager;
    private View view1;

    //数据源
    private List<AuthorInfo.ItemListBean> data;

    //适配器
    private AuthorAdapter adapter;

    //头视图集合
    private List<ImageView> viewList;
    private List<String> imagList;

    private int curPosition = 1;


    public AuthorFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_author2, container, false);
        listView = (ListView) view.findViewById(R.id.fragment_author2_listview_id);

        //添加头视图
        view1 = inflater.inflate(R.layout.fragment_author_viewpager,null);
        viewPager = (ViewPager) view1.findViewById(R.id.fragment_author2_listview_header_id);

        //获取数据源
        getData();

        adapter = new AuthorAdapter(getActivity(), data);
        if (imagList!=null) {
            initImageView(imagList);

            listView.addHeaderView(view1);

            //添加适配器

            listView.setAdapter(adapter);
        }

        return view;
    }

    public void getData(){

        //声明Retrofit建造者
        Retrofit.Builder builder = new Retrofit.Builder();

        //设置公共地址
        builder.baseUrl(Config.ZHU_TI_PATH);

        //解析json数据
        builder.addConverterFactory(GsonConverterFactory.create());

        //得到Retrofit对象
        Retrofit retrofit = builder.build();

        //得到接口中的方法
        FeaturedInter featuredInter = retrofit.create(FeaturedInter.class);

        //得到Call方法
        Call<AuthorInfo> call = featuredInter.getAuthorInfo();

        //传入接口接口回调
        call.enqueue(new Callback<AuthorInfo>() {
            @Override
            public void onResponse(Call<AuthorInfo> call, Response<AuthorInfo> response) {
                AuthorInfo authorInfo = response.body();

                data = new ArrayList<AuthorInfo.ItemListBean>();
                data = authorInfo.getItemList();

                //头视图资源
                imagList = new ArrayList<String>();
                for (int i = 0; i < authorInfo.getItemList().get(0).getData().getItemList().size()+2; i++) {

                    if (i==authorInfo.getItemList().get(0).getData().getItemList().size()+1){
                        imagList.add(authorInfo.getItemList().get(0).getData().getItemList().get(0).getData().getImage());
                    }else if (i==0){
                        int j = authorInfo.getItemList().get(0).getData().getItemList().size() - 1;
                        imagList.add(authorInfo.getItemList().get(0).getData().getItemList().get(j).getData().getImage());
                    }else {
                        imagList.add(authorInfo.getItemList().get(0).getData().getItemList().get(i-1).getData().getImage());
                    }

                }

                Log.e("tag","热门数据"+authorInfo.getItemList().get(0).getData().getItemList().get(0).getData().getImage());



                initImageView(imagList);
                listView.addHeaderView(view1);
                adapter = new AuthorAdapter(getActivity(),data);
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<AuthorInfo> call, Throwable t) {

            }
        });

    }

    private void initImageView(List<String> imagUrl) {

        viewList = new ArrayList<>();
        for (int i = 0; i < imagUrl.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
//            imageView.setMaxWidth(200);
            imageView.setMaxHeight(200);
            Glide.with(getActivity()).load(imagUrl.get(i))
                    .placeholder(R.drawable.ic_notification)
                    .error(R.drawable.ic_notification)
                    .into(imageView);
            viewList.add(imageView);
        }
        viewPager.setAdapter(new AuthorHanderAdapter(viewList));
        viewPager.addOnPageChangeListener(this);
        //初始展示第一个位置的视图
        viewPager.setCurrentItem(1,false);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("1623","position---"+position);
        curPosition = position;

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state){
            case ViewPager.SCROLL_STATE_IDLE:
            Log.d("1623","idle");
                if (curPosition == 0){
                    viewPager.setCurrentItem(viewList.size()-2,false);
                }else if (curPosition == viewList.size() - 1){
                    viewPager.setCurrentItem(1,false);
                }
                break;

            case ViewPager.SCROLL_STATE_DRAGGING:
                Log.d("1623","dragging");

                break;

            case ViewPager.SCROLL_STATE_SETTLING:
                Log.d("1623","settling");

                break;


        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();


        viewPager.removeOnPageChangeListener(this);
    }
}
