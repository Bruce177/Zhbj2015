package org.itheima.zhbj2015.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by yuqiqi on 2015/8/21.
 */
public class NoScrollViewPager extends LazyViewPager {

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollViewPager(Context context) {
        super(context);
    }

    //取消该viewpager的点击事件
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    //不组织点击事件传递给子view
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
