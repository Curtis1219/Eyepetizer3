package com.example.administrator.eyepetizer.moduls.attention;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.example.administrator.eyepetizer.moduls.attention.adapter.MyRcyViewAdapter;
import com.example.administrator.eyepetizer.moduls.attention.bean.CricleTransformation;
import com.example.administrator.eyepetizer.moduls.attention.bean.Data;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jp on 2017/3/5.
 */

public class AttentionFragment extends Fragment {
    private PullToRefreshListView plv;
    private List<Data.ItemListBeanX> totall;
    private MyPullAdapter adapter;
    private String nextPage;
    private MyPagerAdapter adapter2;
    private List<View> viewList;

    private LinearLayout layout;
    private ImageView[] icons;
    private Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            adapter.notifyDataSetChanged();
            plv.onRefreshComplete();
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guanzhu, container, false);
        plv = (PullToRefreshListView) view.findViewById(R.id.pullLv);



        totall = new ArrayList<>();
        volleyGet(Config.GUANZHU);
        adapter = new MyPullAdapter(totall);
        plv.setAdapter(adapter);
        plv.setMode(PullToRefreshBase.Mode.BOTH);
        plv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

                handler.sendEmptyMessageDelayed(1,1000);
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                volleyGet(nextPage);
                plv.onRefreshComplete();
            }
        });
        return view;
    }
    private void initViewList(List<Data.ItemListBeanX.DataBeanX.ItemListBean> list) {
        viewList = new ArrayList<>();
        icons=new ImageView[list.size()];
        for (int i = 0; i < list.size(); i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.guanzhu_viewpager_item, null);
            ImageView iv= (ImageView) view.findViewById(R.id.iv_gz_viewpager);
            TextView tv= (TextView) view.findViewById(R.id.tv_gz_viewpager1);
            TextView tv2= (TextView) view.findViewById(R.id.tv_gz_viewpager2);
            TextView tv3= (TextView) view.findViewById(R.id.tv_gz_viewpager3);
            Picasso.with(getContext()).load(list.get(i).getData().getCover().getFeed()).into(iv);
            tv.setText(list.get(i).getData().getTitle());
            tv2.setText("#"+list.get(i).getData().getCategory());
            int durtion=list.get(i).getData().getDuration();
            List<String> a= time(durtion);
            tv3.setText(a.get(0)+"'"+a.get(1)+"''");

            viewList.add(view);
            icons[i]=new ImageView(getContext());
            icons[i].setImageResource(R.mipmap.icon01);
            icons[i].setLayoutParams(new ViewGroup.LayoutParams(15,15));
            layout.addView(icons[i]);

        }
        icons[0].setImageResource(R.mipmap.icon02);
        adapter2 = new MyPagerAdapter(viewList);

    }

    private void volleyGet(String url) {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Data data = new Gson().fromJson(response, Data.class);
                nextPage=data.getNextPageUrl();
                for (int i = 0; i < data.getItemList().size(); i++) {
                    totall.add(data.getItemList().get(i));
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

    class MyPullAdapter extends BaseAdapter {
        private List<Data.ItemListBeanX> totall;

        public MyPullAdapter(List<Data.ItemListBeanX> totall) {
            this.totall = totall;
        }

        @Override
        public int getCount() {
            return totall.size();
        }

        @Override
        public Object getItem(int i) {
            return totall.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            if (totall.get(position).getType().equals("videoCollectionWithBrief")) {
                return 0;
            } else {
                return 1;
            }
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Data.ItemListBeanX.DataBeanX dataBean = totall.get(i).getData();
            List<Data.ItemListBeanX.DataBeanX.ItemListBean> list = totall.get(i).getData().getItemList();
            if (getItemViewType(i) == 0) {
                ViewHolder viewHolder;
                if (view == null) {
                    view = LayoutInflater.from(getContext()).inflate(R.layout.guznzhu_plv_item, viewGroup, false);
                    viewHolder = new ViewHolder(view);
                    view.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) view.getTag();
                }
                Picasso.with(getContext()).load(dataBean.getHeader().getIcon()).transform(new CricleTransformation()).into(viewHolder.iv);
                viewHolder.tv1.setText(dataBean.getHeader().getTitle());
                viewHolder.tv2.setText(dataBean.getHeader().getDescription());


                MyRcyViewAdapter adapter = new MyRcyViewAdapter(getContext(), list);
                viewHolder.ryv.setAdapter(adapter);
                StaggeredGridLayoutManager sg = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
                viewHolder.ryv.setLayoutManager(sg);


            } else if (getItemViewType(i) == 1) {
                ViewHolder2 viewHolder2;
                if (view == null) {
                    view = LayoutInflater.from(getContext()).inflate(R.layout.guanzhu_plv_item2, viewGroup, false);
                    layout= (LinearLayout) view.findViewById(R.id.lyout_zhishiqi);
                    viewHolder2 = new ViewHolder2(view);
                    view.setTag(viewHolder2);
                } else {
                    viewHolder2 = (ViewHolder2) view.getTag();
                }

                viewHolder2.tv1.setText(dataBean.getHeader().getTitle());
                viewHolder2.tv2.setText("" + dataBean.getHeader().getSubTitle());


                initViewList(list);
                viewHolder2.vp.setAdapter(adapter2);
//                int currentItem = Integer.MAX_VALUE / 2;
//                viewHolder2.vp.setCurrentItem(currentItem);

                viewHolder2.vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {

                        for(int i=0;i<icons.length;i++)
                        {
                            icons[i].setImageResource(R.mipmap.icon01);

                        }
                        icons[position].setImageResource(R.mipmap.icon02);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });

            }
            return view;
        }

        class ViewHolder {
            private ImageView iv;
            private TextView tv1, tv2;
            private RecyclerView ryv;

            public ViewHolder(View view) {
                iv = (ImageView) view.findViewById(R.id.iv_gz_plv_it);
                tv1 = (TextView) view.findViewById(R.id.tv1_gz_plv_it);
                tv2 = (TextView) view.findViewById(R.id.tv12_gz_plv_it);
                ryv = (RecyclerView) view.findViewById(R.id.rcy_plv_item);
            }
        }

        class ViewHolder2 {

            private TextView tv1, tv2;
            private ViewPager vp;

            public ViewHolder2(View view) {
                tv1 = (TextView) view.findViewById(R.id.tv3_gz_plv_item);
                tv2 = (TextView) view.findViewById(R.id.tv4_gz_plv_item);
                vp = (ViewPager) view.findViewById(R.id.vp_gz_plv_item);

            }
        }

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
