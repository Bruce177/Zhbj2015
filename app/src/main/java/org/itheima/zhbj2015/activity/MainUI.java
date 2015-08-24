package org.itheima.zhbj2015.activity;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import org.itheima.zhbj2015.R;
import org.itheima.zhbj2015.fragment.ContentFragment;
import org.itheima.zhbj2015.fragment.LeftFragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

/**
 * Created by yuqiqi on 2015/8/13.
 */
public class MainUI extends SlidingFragmentActivity{

    private static final String	TAG_LEFT	= "left";
    private static final String	TAG_CONTENT	= "content";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //设置内容界面
        setContentView(R.layout.main_ui);
        //设置侧滑界面
        setBehindContentView(R.layout.main_left);

        SlidingMenu menu = getSlidingMenu();

        //设置从左滑出来
        menu.setMode(SlidingMenu.LEFT);

        //设置侧滑的宽度
        menu.setBehindWidth(140);

        //设置滑出来后，内容界面的宽度
//        menu.setBehindOffset(120);

        //设置滑出的触摸模式(在内容界面上，全屏可滑动)
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        //设置滑出的触摸模式(在侧滑界面上，全屏可滑动)
//        menu.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);

        //设置操作侧滑菜单时，侧滑菜单的阴影效果
        menu.setShadowDrawable(R.drawable.shadow);

        initFragment();
    }

    private void initFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_content, new ContentFragment(),TAG_CONTENT);
        ft.replace(R.id.main_left_container,new LeftFragment(),TAG_LEFT);
        ft.commit();
    }

    public LeftFragment getLeftFragment(){
        FragmentManager fm = getFragmentManager();
        return (LeftFragment) fm.findFragmentByTag(TAG_LEFT);
    }
    public ContentFragment getContentFragment(){
        FragmentManager fm = getFragmentManager();
        return (ContentFragment) fm.findFragmentByTag(TAG_CONTENT);
    }
}
