package com.example.administrator.eyepetizer.tools.view.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/10.
 */

public class Timesf {

    public List<String> time(int time){

        String time1 = (time/60)+"";
        String time2 = (time%60)+"";

        List<String> timeList = new ArrayList<>();
        timeList.add(time1);
        timeList.add(time2);

        return timeList;
    }
}
