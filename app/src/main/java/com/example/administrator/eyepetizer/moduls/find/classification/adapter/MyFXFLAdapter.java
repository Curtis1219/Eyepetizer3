package com.example.administrator.eyepetizer.moduls.find.classification.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.eyepetizer.R;
import com.example.administrator.eyepetizer.moduls.attention.bean.FenLeiData;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2017/3/8 0008.
 */

public class MyFXFLAdapter extends RecyclerView.Adapter<MyFXFLAdapter.ViewHolder> {
    private Context context;
    private List<FenLeiData.ItemListBeanX.DataBeanX.ItemListBean> list;

    public MyFXFLAdapter(Context context, List<FenLeiData.ItemListBeanX.DataBeanX.ItemListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faxian_fl_reyv_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == list.size() - 1) {
            holder.tv.setText("查看全部");
            holder.iv.setImageResource(R.mipmap.kongbai);

        } else {

            holder.tv.setText(list.get(position).getData().getTitle());
            Picasso.with(context).load(list.get(position).getData().getImage()).into(holder.iv);

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.tv_fx_fl_rv_item);
            iv = (ImageView) itemView.findViewById(R.id.iv_fx_fl_rv_item);
        }
    }
}
