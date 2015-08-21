package org.itheima.zhbj2015.fragment;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.itheima.zhbj2015.R;
import org.itheima.zhbj2015.activity.MainUI;
import org.itheima.zhbj2015.controller.TabController;
import org.itheima.zhbj2015.controller.tab.GovController;
import org.itheima.zhbj2015.controller.tab.HomeController;
import org.itheima.zhbj2015.controller.tab.NewscenterController;
import org.itheima.zhbj2015.controller.tab.SettingController;
import org.itheima.zhbj2015.controller.tab.SmartServiceController;
import org.itheima.zhbj2015.utils.LogUtils;
import org.itheima.zhbj2015.view.NoScrollViewPager;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuqiqi on 2015/8/18.
 */
public class ContentFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {
    public static final String	TAG	= "CONTENTFRAGMENT";

    //页面中上部分的viewpager，新闻真正显示的地方，包括title
    private NoScrollViewPager mViewPager;

    //    private List<TextView> mPagerDatas;虚拟的数据
    private List<TabController> mPagerDatas;

    private RadioGroup mRadioGroup;

    @Override
    protected View initView() {
        View view = View.inflate(mActivity, R.layout.content, null);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.content_rg);
        mViewPager = (NoScrollViewPager) view.findViewById(R.id.content_viewpager);
        //不能再这里写setAdapter方法，要在list加载数据之后，不然会报错
        //error:The application's PagerAdapter changed the adapter's contents without calling PagerAdapter
//        mViewPager.setAdapter(new ContentPagerAdapter());
        return view;
    }

    @Override
    protected void initData() {
//        mPagerDatas = new ArrayList<TextView>();
//        for (int i=0;i<5;i++){
//            TextView textView = new TextView(mActivity);
//            textView.setText("pager:"+i);
//            textView.setGravity(Gravity.CENTER);
//            mPagerDatas.add(textView);
//        }
        mPagerDatas = new ArrayList<TabController>();
        mPagerDatas.add(new HomeController(mActivity));
        mPagerDatas.add(new NewscenterController(mActivity));
        mPagerDatas.add(new SmartServiceController(mActivity));
        mPagerDatas.add(new GovController(mActivity));
        mPagerDatas.add(new SettingController(mActivity));

        mViewPager.setAdapter(new ContentPagerAdapter());

        mRadioGroup.setOnCheckedChangeListener(this);
        mRadioGroup.check(R.id.content_tab_home);//该语句必须写在setOnCheckedChangeListener的后面，否则会造成，初始化首页时，仍能滑出侧滑菜单
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int currentItem = 0;
        switch (checkedId) {
            case R.id.content_tab_home:
                setSlidingMenuEnable(false);
                currentItem = 0;
                break;
            case R.id.content_tab_news:
                setSlidingMenuEnable(true);
                currentItem = 1;
                break;
            case R.id.content_tab_service:
                setSlidingMenuEnable(false);
                currentItem = 2;
                break;
            case R.id.content_tab_gov:
                setSlidingMenuEnable(false);
                currentItem = 3;
                break;
            case R.id.content_tab_setting:
                setSlidingMenuEnable(false);
                currentItem = 4;
                break;
        }
        //viewpager直接设置当前页的方法
        mViewPager.setCurrentItem(currentItem);
    }

    public void setSlidingMenuEnable(boolean enable){
        MainUI ui = (MainUI) mActivity;
        ui.getSlidingMenu().setTouchModeAbove(enable ? SlidingMenu.TOUCHMODE_FULLSCREEN : SlidingMenu.TOUCHMODE_NONE);
    }

    protected class ContentPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            if (mPagerDatas != null) {
                return mPagerDatas.size();
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.d(TAG, "销毁" + position + "页面");
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LogUtils.d(TAG,"初始化"+position+"页面");
//            TextView textView = mPagerDatas.get(position);
//            container.addView(textView);

            TabController tabController = mPagerDatas.get(position);
            View view = tabController.gerRootView();
            container.addView(view);
            tabController.initData();
            return view;
        }
    }
}
