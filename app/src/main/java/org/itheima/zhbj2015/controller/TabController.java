package org.itheima.zhbj2015.controller;

import org.itheima.zhbj2015.R;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yuqiqi on 2015/8/21.
 * 主页内容对应的控制器，基类
 */
public abstract class TabController {

    private View mRootView;
    private FrameLayout mContentContainer;
    protected TextView mTabName;
    protected ImageView mIvMenu;

    public TabController(Context context) {
        mRootView = initView(context);
    }

    private View initView(Context context) {
        View view = View.inflate(context, R.layout.base_tab,null);
        mTabName = (TextView) view.findViewById(R.id.tab_tv);
        mIvMenu = (ImageView) view.findViewById(R.id.tab_iv);
        mContentContainer = (FrameLayout) view.findViewById(R.id.content_container);
        mContentContainer.addView(initContentView(context));
        return view;
    }

    protected abstract View initContentView(Context context);


    public View gerRootView() {
        return mRootView;
    }

    //初始化数据，写成public，不写成抽象，可以让子类想复写就复写，不想就算了
    public void initData(){

    }
}
