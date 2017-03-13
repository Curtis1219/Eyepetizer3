package com.example.administrator.eyepetizer.moduls.featured.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.eyepetizer.R;
import com.example.administrator.eyepetizer.moduls.featured.bens.FeaturedInfo4;
import com.example.administrator.eyepetizer.tools.view.utils.Timesf;

import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */
public class FeaturedAdapter extends BaseAdapter{

    private Context context;
    private List<FeaturedInfo4.IssueListBean.ItemListBean> data;

    public FeaturedAdapter(Context context, List<FeaturedInfo4.IssueListBean.ItemListBean> data) {
        this.context = context;
        this.data = data;
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

        if (type.equals("video")){
            return 0;
        }else if (type.equals("textHeader")){
            return 1;
        }else {
            //banner
            return 2;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        VideoViewHolder videoViewHolder;
        FooterViewHolder footerViewHolder;
        BannerViewHolder bannerViewHolder;

        switch (getItemViewType(position)){

            case 0:

                if (convertView == null){
                    convertView = LayoutInflater.from(context).inflate(R.layout.featured_fragment_list_item_video,parent,false);
                    videoViewHolder = new VideoViewHolder();
                    videoViewHolder.imageView = (ImageView) convertView.findViewById(R.id.featured_fragment_list_item_video_image1);
                    videoViewHolder.textView1 = (TextView) convertView.findViewById(R.id.featured_fragment_list_item_video_text1);
                    videoViewHolder.textView2 = (TextView) convertView.findViewById(R.id.featured_fragment_list_item_video_text2);
                    videoViewHolder.textView3 = (TextView) convertView.findViewById(R.id.featured_fragment_list_item_video_text3);
                    videoViewHolder.textView4 = (TextView) convertView.findViewById(R.id.featured_fragment_list_item_video_text4);
                    videoViewHolder.textView5 = (TextView) convertView.findViewById(R.id.featured_fragment_list_item_video_text5);

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

            case 1:

                if (convertView == null){
                    convertView = LayoutInflater.from(context).inflate(R.layout.featured_fragment_list_item_footer,parent,false);
                    footerViewHolder = new FooterViewHolder();
                    footerViewHolder.textView = (TextView) convertView.findViewById(R.id.featured_fragment_list_item_footer_text1);
                    convertView.setTag(footerViewHolder);
                }else {
                    footerViewHolder = (FooterViewHolder) convertView.getTag();
                }

//                int id = footerViewHolder.textView.findFocus().getId();

//                ListView listView = (ListView) parent;
//                listView.setOnScrollListener(new AbsListView.OnScrollListener() {
//                    @Override
//                    public void onScrollStateChanged(AbsListView view, int scrollState) {
//                    }
//
//                    @Override
//                    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                        if (firstVisibleItem==1) {
//
//                        }
//                    }
//                });


                footerViewHolder.textView.setText(data.get(position).getData().getText());
                break;

            case 2:

                if (convertView == null){
                    convertView = LayoutInflater.from(context).inflate(R.layout.featured_fragment_list_item_banner,parent,false);
                    bannerViewHolder = new BannerViewHolder();
                    bannerViewHolder.imageView = (ImageView) convertView.findViewById(R.id.featured_fragment_list_item_banner_image);
                    convertView.setTag(bannerViewHolder);
                }else {
                    bannerViewHolder = (BannerViewHolder) convertView.getTag();
                }

                Glide.with(context).load(data.get(position).getData().getImage())
                        .placeholder(R.drawable.ic_notification)
                        .error(R.drawable.ic_tab_strip_icon_category)
                        .into(bannerViewHolder.imageView);

                break;
        }

        return convertView;
    }



    class VideoViewHolder{

        ImageView imageView;
        TextView textView1,textView2,textView3,textView4,textView5;


    }

    class FooterViewHolder{
        TextView textView;

    }


    class BannerViewHolder{
        ImageView imageView;
    }


}
