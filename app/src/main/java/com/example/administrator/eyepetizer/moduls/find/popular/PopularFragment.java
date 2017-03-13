package com.example.administrator.eyepetizer.moduls.find.popular;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.administrator.eyepetizer.Config;
import com.example.administrator.eyepetizer.MyApp.MyApp;
import com.example.administrator.eyepetizer.R;
import com.example.administrator.eyepetizer.moduls.attention.bean.CricleTransformation;
import com.example.administrator.eyepetizer.moduls.attention.bean.ZuozheData;
import com.example.administrator.eyepetizer.moduls.find.classification.adapter.MyRcyViewAdapter2;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jp on 2017/3/5.
 */

public class PopularFragment extends Fragment {
    private PullToRefreshListView plv;
    private List<ZuozheData.ItemListBeanX>list;
    private MyGzZzPlvAdapter adapter;
    private String nextPage;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_zuozhe,container,false);
        plv = (PullToRefreshListView)view.findViewById(R.id.plv_fx_zz);




        list=new ArrayList<>();
        volleyGet(Config.FX_ZZ);
        adapter=new MyGzZzPlvAdapter();
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
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ZuozheData data=new Gson().fromJson(response,ZuozheData.class);

                nextPage=data.getNextPageUrl();
                for(int i=0;i<data.getItemList().size();i++){
                    list.add(data.getItemList().get(i));
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

    class MyGzZzPlvAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public int getViewTypeCount() {
            return 4;
        }

        @Override
        public int getItemViewType(int position) {
            if(list.get(position).getType().equals("leftAlignTextHeader")){
                return 0;
            }else if(list.get(position).getType().equals("briefCard")){
                return 1;
            }else if(list.get(position).getType().equals("blankCard")){
                return 2;
            }else {
                return 3;
            }
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {



            if(getItemViewType(i)==0){
                view=LayoutInflater.from(getContext()).inflate(R.layout.faxian_zz_plv_1,viewGroup,false);
                TextView tv= (TextView) view.findViewById(R.id.tv_fx_zz_1);
                tv.setText(list.get(i).getData().getText());
                return view;
            }else if(getItemViewType(i)==1){
                view=LayoutInflater.from(getContext()).inflate(R.layout.faxian_zz_plv_2,viewGroup,false);
                TextView tv= (TextView) view.findViewById(R.id.tv_fx_zz_2);
                TextView tv2= (TextView) view.findViewById(R.id.tv_fx_zz_3);
                ImageView iv= (ImageView) view.findViewById(R.id.iv_fx_plv_1);
                Picasso.with(getContext()).load(list.get(i).getData().getIcon()).transform(new CricleTransformation()).into(iv);
                tv.setText(list.get(i).getData().getTitle());
                tv2.setText(list.get(i).getData().getDescription());
                return view;


            }else if(getItemViewType(i)==2){
                view=LayoutInflater.from(getContext()).inflate(R.layout.blankview,viewGroup,false);
                return view;

            }else {
                ViewHolder viewHolder;
                if (view == null) {
                    view = LayoutInflater.from(getContext()).inflate(R.layout.guznzhu_plv_item, viewGroup, false);
                    viewHolder = new ViewHolder(view);
                    view.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) view.getTag();
                }
                Picasso.with(getContext()).load(list.get(i).getData().getHeader().getIcon()).transform(new CricleTransformation()).into(viewHolder.iv);
                viewHolder.tv1.setText(list.get(i).getData().getHeader().getTitle());
                viewHolder.tv2.setText(list.get(i).getData().getHeader().getDescription());

                MyRcyViewAdapter2 adapter = new MyRcyViewAdapter2(getContext(), list.get(i).getData().getItemList());
                viewHolder.ryv.setAdapter(adapter);
                StaggeredGridLayoutManager sg = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
                viewHolder.ryv.setLayoutManager(sg);
                return view;
            }



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
    }


}
