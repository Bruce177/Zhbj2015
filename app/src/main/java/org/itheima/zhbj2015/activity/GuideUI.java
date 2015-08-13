package org.itheima.zhbj2015.activity;

import org.itheima.zhbj2015.R;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yuqiqi on 2015/8/13.
 */
public class GuideUI extends BaseActivity {

    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_ui);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.guideViewpager);
        mVp.setAdapter(new GuideAdapter());
    }

    private class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
