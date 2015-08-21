package org.itheima.zhbj2015.controller.tab;

import org.itheima.zhbj2015.controller.TabController;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by yuqiqi on 2015/8/21.
 */
public class SettingController extends TabController{

    public SettingController(Context context) {
        super(context);
    }

    @Override
    protected View initContentView(Context context) {
        TextView textView = new TextView(context);
        textView.setText("设置");
        textView.setTextColor(Color.RED);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void initData() {
        mTabName.setText("设置");
        mIvMenu.setVisibility(View.GONE);
    }
}
