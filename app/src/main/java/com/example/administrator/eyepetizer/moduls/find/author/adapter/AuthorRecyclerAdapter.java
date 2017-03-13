package com.example.administrator.eyepetizer.moduls.find.author.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.eyepetizer.R;
import com.example.administrator.eyepetizer.moduls.find.author.bean.AuthorInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/3/10.
 */
public class AuthorRecyclerAdapter extends RecyclerView.Adapter<AuthorRecyclerAdapter.ListViewHolder>{

    private Context context;
    private List<AuthorInfo.ItemListBean.DataBean.ItemListBeanX> data;

    public AuthorRecyclerAdapter(Context context, List<AuthorInfo.ItemListBean.DataBean.ItemListBeanX> data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.author_fragment_list_item_square_item_recycle,parent,false);
        ListViewHolder listViewHolder = new ListViewHolder(view);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        Log.e("tag","recycle的数据"+data.get(position).getData().getImage());

        if (position==data.size()-1){
            holder.textView1.setVisibility(View.INVISIBLE);
            holder.imageView.setVisibility(View.INVISIBLE);
            holder.textView.setText("查看全部");
        }else {
            Glide.with(context).load(data.get(position).getData().getImage())
                    .placeholder(R.drawable.ic_notification)
                    .error(R.drawable.ic_notification)
                    .into(holder.imageView);

        }


    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        TextView textView1;

        public ListViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.author_fragment_list_item_square_item_recycle_image);
            textView = (TextView) itemView.findViewById(R.id.author_fragment_list_item_square_item_recycle_text);
            textView1 = (TextView) itemView.findViewById(R.id.author_fragment_list_item_square_item_recycle_text1);
        }
    }
}
