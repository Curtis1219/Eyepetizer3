package com.example.administrator.eyepetizer.moduls.featured.interfaces;

import com.example.administrator.eyepetizer.moduls.featured.bens.FeaturedInfo4;
import com.example.administrator.eyepetizer.moduls.find.author.bean.AuthorInfo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/3/7.
 */

//v2/feed?num=1&vc=168&deviceModel=LT18i
public interface FeaturedInter {

    //v2/feed?num=3&udid=6a40437f5d294759b25bfc05c5644d023f29d3df&vc=168&vn=3.3.1&deviceModel=Redmi%204&first_channel=eyepetizer_baidu_market&last_channel=eyepetizer_baidu_market&system_version_code=23


    //v4/tabs/selected?&num=2&vc=168&vn=3.3.1&deviceModel=LT18i
    @GET("v2/feed?num=3&udid=6a40437f5d294759b25bfc05c5644d023f29d3df&vc=168&vn=3.3.1&deviceModel=Redmi%204&first_channel=eyepetizer_baidu_market&last_channel=eyepetizer_baidu_market&system_version_code=23")
    Call<FeaturedInfo4> getFeaturedInfo4();

    @GET("v4/discovery/hot?udid=57a3d1b969d1494c8debb4758ef74f33de581ead&vc=168&vn=3.3.1&deviceModel=LT18i&first_channel=eyepetizer_baidu_market&last_channel=eyepetizer_baidu_market&system_version_code=15")
    Call<AuthorInfo> getAuthorInfo();

}
