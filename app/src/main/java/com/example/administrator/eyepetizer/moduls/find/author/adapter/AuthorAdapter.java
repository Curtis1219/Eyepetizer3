package com.example.administrator.eyepetizer.moduls.find.author.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.eyepetizer.R;
import com.example.administrator.eyepetizer.moduls.find.author.bean.AuthorInfo;
import com.example.administrator.eyepetizer.tools.view.utils.Timesf;

import java.util.List;

/**
 * Created by Administrator on 2017/3/10.
 */
public class AuthorAdapter extends BaseAdapter{

    private Context context;
    private List<AuthorInfo.ItemListBean> data;

    private AuthorRecyclerAdapter adapter;

    public AuthorAdapter( Context context,List<AuthorInfo.ItemListBean> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public int getItemViewType(int position) {

        String type = data.get(position).getType();

        if (type.equals("textHeader")){
            return 0;
        }else if (type.equals("video")){
            return 1;
        }else if (type.equals("squareCardCollection")){
            return 2;
        }else {
            return 3;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HeaderViewHolder headerViewHolder;
        VideoViewHolder videoViewHolder;
        SquareViewHolder squareViewHolder;

        switch (getItemViewType(position)){

            case 0:
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.author_fragment_list_item_herder,parent,false);
                    headerViewHolder = new HeaderViewHolder();
                    headerViewHolder.textView = (TextView) convertView.findViewById(R.id.author_fragment_list_item_header_text);
                    convertView.setTag(headerViewHolder);
                }else {
                    headerViewHolder = (HeaderViewHolder) convertView.getTag();
                }

                headerViewHolder.textView.setText(data.get(position).getData().getText());

                break;


            case 1:

                if (convertView == null){

                    convertView = LayoutInflater.from(context).inflate(R.layout.author_fragment_list_item_video,parent,false);

                    int height = convertView.getLayoutParams().height;

                    convertView.setMinimumHeight(height/3);

                    videoViewHolder = new VideoViewHolder();

                    videoViewHolder.imageView = (ImageView) convertView.findViewById(R.id.author_fragment_list_item_video_image);
                    videoViewHolder.textView1 = (TextView) convertView.findViewById(R.id.author_fragment_list_item_video_text1);
                    videoViewHolder.textView2 = (TextView) convertView.findViewById(R.id.author_fragment_list_item_video_text2);
                    videoViewHolder.textView3 = (TextView) convertView.findViewById(R.id.author_fragment_list_item_video_text3);
                    videoViewHolder.textView4 = (TextView) convertView.findViewById(R.id.author_fragment_list_item_video_text4);
                    videoViewHolder.textView5 = (TextView) convertView.findViewById(R.id.author_fragment_list_item_video_text5);

                    convertView.setTag(videoViewHolder);
                }else {
                    videoViewHolder = (VideoViewHolder) convertView.getTag();
                }

                Glide.with(context).load(data.get(position).getData().getCover().getFeed())
                        .placeholder(R.drawable.ic_notification)
                        .error(R.drawable.ic_tab_strip_icon_category)
                        .into(videoViewHolder.imageView);

                Timesf timesf = new Timesf();
                List<String> time = timesf.time(data.get(position).getData().getDuration());

                videoViewHolder.textView1.setText(data.get(position).getData().getTitle());
                videoViewHolder.textView2.setText(data.get(position).getData().getCategory());
                videoViewHolder.textView4.setText(time.get(0));
                videoViewHolder.textView5.setText(time.get(1));

                int measuredWidth = parent.getMeasuredWidth();
                convertView.setMinimumHeight(measuredWidth/2);

                if (data.get(position).getData().getAuthor()==null){
                    videoViewHolder.textView3.setVisibility(View.INVISIBLE);
                }else{
                    videoViewHolder.textView3.setText(data.get(position).getData().getAuthor().getName());
                }

                break;


            case 2:

                if (convertView == null){
                    convertView = LayoutInflater.from(context).inflate(R.layout.author_fragment_list_item_square,parent,false);
                    squareViewHolder = new SquareViewHolder(convertView,R.id.author_fragment_list_item_square_text,R.id.author_fragment_list_item_square_recycler);
                    convertView.setTag(squareViewHolder);
                }else {
                    squareViewHolder = (SquareViewHolder) convertView.getTag();
                }

                squareViewHolder.textView.setText(data.get(position).getData().getHeader().getTitle());

                Log.e("tag","recycle的数据"+data.get(position).getData().getItemList().get(0).getData().getImage());

                adapter = new AuthorRecyclerAdapter(context,data.get(position).getData().getItemList());
                squareViewHolder.recyclerView.setAdapter(adapter);

                StaggeredGridLayoutManager sManger = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);

                squareViewHolder.recyclerView.setLayoutManager(sManger);

                break;

            case 3:

                convertView = LayoutInflater.from(context).inflate(R.layout.author_fragment_list_item_null,parent,false);

                break;


        }

        return convertView;
    }

    class HeaderViewHolder{
        TextView textView;

    }

    class VideoViewHolder{
        ImageView imageView;
        TextView textView1,textView2,textView3,textView4,textView5;

    }

    class SquareViewHolder{
        TextView textView;
        RecyclerView recyclerView;
        public SquareViewHolder(View view,int textid,int recyceid){
            textView = (TextView) view.findViewById(textid);
            recyclerView = (RecyclerView) view.findViewById(recyceid);
        }
    }

}
