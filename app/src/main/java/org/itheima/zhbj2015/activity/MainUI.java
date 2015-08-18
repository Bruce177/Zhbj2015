package org.itheima.zhbj2015.activity;

import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;

import org.itheima.zhbj2015.R;

import android.os.Bundle;

/**
 * Created by yuqiqi on 2015/8/13.
 */
public class MainUI extends SlidingActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_ui);
        setBehindContentView(R.layout.main_left);
    }
}
