package org.itheima.zhbj2015.activity;

import org.itheima.zhbj2015.R;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by yuqiqi on 2015/8/13.
 */
public class GuideUI extends BaseActivity implements ViewPager.OnPageChangeListener{

    private ViewPager mVp;
    private Button mButton;

    private int[] iconRes = new int[]{
            R.mipmap.guide_1,
            R.mipmap.guide_2,
            R.mipmap.guide_3,
    };

    private ArrayList<ImageView> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_ui);
        initView();
        initData();
    }

    private void initData() {
        mDatas = new ArrayList<ImageView>();
        for (int i = 0; i < iconRes.length; i++) {
            ImageView imageView = new ImageView(GuideUI.this);
            imageView.setImageResource(iconRes[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mDatas.add(imageView);
        }
        mVp.setAdapter(new GuideAdapter());
        mVp.setOnPageChangeListener(this);
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.guideViewpager);
        mButton = (Button) findViewById(R.id.guideBt);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position==mDatas.size()-1){
            mButton.setVisibility(View.VISIBLE);
        }else{
            mButton.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {

            if (mDatas != null) {
                return mDatas.size();
            }
            return 0;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = mDatas.get(position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
