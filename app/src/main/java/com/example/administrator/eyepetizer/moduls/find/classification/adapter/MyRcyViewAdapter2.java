package com.example.administrator.eyepetizer.moduls.find.classification.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.eyepetizer.R;
import com.example.administrator.eyepetizer.moduls.attention.bean.ZuozheData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/7 0007.
 */

public class MyRcyViewAdapter2 extends RecyclerView.Adapter<MyRcyViewAdapter2.ViewHolder>{

    private Context context;
    private List<ZuozheData.ItemListBeanX.DataBeanX.ItemListBean>list;



    public MyRcyViewAdapter2(Context context, List<ZuozheData.ItemListBeanX.DataBeanX.ItemListBean> list) {
        this.context = context;
        this.list = list;
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.guanzhu_recyview_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv1.setText(list.get(position).getData().getTitle());
        holder.tv2.setText("#"+list.get(position).getData().getCategory());
        int duration=list.get(position).getData().getDuration();
        List<String> a=time(duration);
        holder.tv3.setText(a.get(0)+"'"+a.get(1)+"''");

        Picasso.with(context).load(list.get(position).getData().getCover().getFeed()).into(holder.iv);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
         TextView tv1,tv2,tv3;
         ImageView iv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1= (TextView) itemView.findViewById(R.id.tv_gz_rcv1);
            tv2= (TextView) itemView.findViewById(R.id.tv_gz_rcv2);
            tv3= (TextView) itemView.findViewById(R.id.tv_gz_rcv3);
            iv= (ImageView) itemView.findViewById(R.id.iv_gz_recyview);
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
