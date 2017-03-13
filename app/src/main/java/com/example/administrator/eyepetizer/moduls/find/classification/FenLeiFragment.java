package com.example.administrator.eyepetizer.moduls.find.classification;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.administrator.eyepetizer.Config;
import com.example.administrator.eyepetizer.MyApp.MyApp;
import com.example.administrator.eyepetizer.R;
import com.example.administrator.eyepetizer.moduls.attention.adapter.MyPagerAdapter;
import com.example.administrator.eyepetizer.moduls.attention.bean.FenLeiData;
import com.example.administrator.eyepetizer.moduls.find.classification.adapter.MyFXFLAdapter;
import com.example.administrator.eyepetizer.moduls.find.classification.adapter.MyFxFlVpAdapter;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jp on 2017/3/5.
 */
public class FenLeiFragment extends Fragment {
    private PullToRefreshListView plv;

    private List<FenLeiData.ItemListBeanX> tatall;
    private MyFLAdapter adapter;
    private MyPagerAdapter adapter2;
    private String nextPage;
    private List<ImageView> imagList;
    private List<View>viewList;


    private LinearLayout layout;
    private ImageView[] icon;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fenlei, container, false);
        plv = (PullToRefreshListView) view.findViewById(R.id.plv_fx_fl);

        tatall = new ArrayList<>();
        volleyGet(Config.FX_FL);
        adapter = new MyFLAdapter();
        plv.setAdapter(adapter);
        plv.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        plv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                volleyGet(nextPage);
                plv.onRefreshComplete();
            }
        });
        return view;
    }
    private void volleyGet(String url) {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                FenLeiData data = new Gson().fromJson(response, FenLeiData.class);
                nextPage = data.getNextPageUrl();
                for (int i = 0; i < data.getItemList().size(); i++) {
                    tatall.add(data.getItemList().get(i));
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        MyApp.getHttpQueue().add(request);
    }
    class MyFLAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return tatall.size();
        }

        @Override
        public Object getItem(int i) {
            return tatall.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }


        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            FenLeiData.ItemListBeanX.DataBeanX.HeaderBean bean = tatall.get(i).getData().getHeader();
            List<FenLeiData.ItemListBeanX.DataBeanX.ItemListBean> list = tatall.get(i).getData().getItemList();
            if (i == 0) {
                View view1 = LayoutInflater.from(getContext()).inflate(R.layout.faxian_fl_plv_it1, viewGroup, false);
                ViewHolder1 viewHolder1 = new ViewHolder1(view1);
                viewHolder1.tv.setText(bean.getTitle());
                MyFXFLAdapter adapter2 = new MyFXFLAdapter(getContext(), list);
                viewHolder1.ryv.setAdapter(adapter2);
                StaggeredGridLayoutManager sg = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
                viewHolder1.ryv.setLayoutManager(sg);
                return view1;
            } else if (i == 1) {
                View view2 = LayoutInflater.from(getContext()).inflate(R.layout.faxian_fl_plv_it2, viewGroup, false);
                ViewHolder2 viewHolder2 = new ViewHolder2(view2);
                viewHolder2.tv.setText(bean.getTitle());

                imagList = new ArrayList<>();
                for (int i1 = 0; i1 < list.size(); i1++) {
                    ImageView iv = new ImageView(getContext());
                    Picasso.with(getContext()).load(list.get(i1).getData().getImage()).into(iv);
                    imagList.add(iv);
                }
                MyFxFlVpAdapter adapter = new MyFxFlVpAdapter(imagList);
                viewHolder2.vp.setAdapter(adapter);
                return view2;

            } else {
                view = LayoutInflater.from(getContext()).inflate(R.layout.guanzhu_plv_item2, viewGroup, false);
                ViewHolder3 viewHolder3 = new ViewHolder3(view);
                viewHolder3.tv1.setText(bean.getTitle());
                viewHolder3.tv2.setText(bean.getSubTitle());
                initViewList(list);
                viewHolder3.vp.setAdapter(adapter2);
                int currentItem=Integer.MAX_VALUE/2;
                viewHolder3.vp.setCurrentItem(currentItem);

                return view;
            }
        }
        class ViewHolder1 {
            private TextView tv;
            private RecyclerView ryv;
            public ViewHolder1(View view) {
                tv = (TextView) view.findViewById(R.id.tv_fx_fl_1);
                ryv = (RecyclerView) view.findViewById(R.id.fx_fl_ryv);
            }
        }
        class ViewHolder2 {
            private TextView tv;
            private ViewPager vp;
            public ViewHolder2(View view) {
                tv = (TextView) view.findViewById(R.id.tv_fx_fl_2);
                vp = (ViewPager) view.findViewById(R.id.fx_fl_vp);
            }
        }
        class ViewHolder3 {
            private TextView tv1, tv2;
            private ViewPager vp;

            public ViewHolder3(View view) {
                tv1 = (TextView) view.findViewById(R.id.tv3_gz_plv_item);
                tv2 = (TextView) view.findViewById(R.id.tv4_gz_plv_item);

                vp = (ViewPager) view.findViewById(R.id.vp_gz_plv_item);
            }
        }
    }
    private void initViewList(List<FenLeiData.ItemListBeanX.DataBeanX.ItemListBean> list) {
        viewList=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.guanzhu_viewpager_item, null);
            ImageView iv= (ImageView) view.findViewById(R.id.iv_gz_viewpager);
            TextView tv= (TextView) view.findViewById(R.id.tv_gz_viewpager1);
            TextView tv2= (TextView) view.findViewById(R.id.tv_gz_viewpager2);
            TextView tv3= (TextView) view.findViewById(R.id.tv_gz_viewpager3);


            Picasso.with(getContext()).load(list.get(i).getData().getCover().getFeed()).into(iv);
            tv.setText(list.get(i).getData().getTitle());
            tv2.setText("#"+list.get(i).getData().getCategory());

            int duration=list.get(i).getData().getDuration();
            List<String> a=time(duration);
            tv3.setText(a.get(0)+"'"+a.get(1)+"''");
            viewList.add(view);
        }

         adapter2=new MyPagerAdapter(viewList);
    }

    public List<String> time(int time){

        String time1 = (time/60)+"";
        String time2 = (time%60)+"";
        List<String> timeList = new ArrayList<>();
        timeList.add(time1);
        timeList.add(time2);
        return timeList;
    }


}
