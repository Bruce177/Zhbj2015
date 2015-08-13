package org.itheima.zhbj2015.activity;


import org.itheima.zhbj2015.R;
import org.itheima.zhbj2015.utils.LogUtils;
import org.itheima.zhbj2015.utils.PreferenceUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

/**
 * Created by yuqiqi on 2015/8/12.
 */
public class WelcomeUI extends BaseActivity {


    private static final String KEY_IS_FIRST = "is_first";

    private static final String TAG = "WelcomeUI";

    private RelativeLayout mRootView;
    private final static int durationMillis = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_ui);
        mRootView = (RelativeLayout) findViewById(R.id.rootView);
        initAnim();
    }

    private void initAnim() {
        //这里参数为true时，表示该animationSet.setInterpolator是否生效，并共享于set集合中的所有animation
        AnimationSet animationSet = new AnimationSet(true);
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,
                RotateAnimation.RELATIVE_TO_SELF,0.5f,
                RotateAnimation.RELATIVE_TO_SELF,0.5f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1,
                ScaleAnimation.RELATIVE_TO_SELF,0.5f,
                ScaleAnimation.RELATIVE_TO_SELF,0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);

        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(alphaAnimation);
//        animationSet.setInterpolator(new CycleInterpolator(10));

        animationSet.setDuration(durationMillis);
        animationSet.setAnimationListener(new WelcomeAnimationListener());
        mRootView.startAnimation(animationSet);

    }

    private class WelcomeAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            boolean is_first = PreferenceUtils.getBoolean(WelcomeUI.this,KEY_IS_FIRST,true);

            if (is_first){
                LogUtils.d(TAG, "进入向导界面");
                Intent intent = new Intent(WelcomeUI.this,GuideUI.class);
                startActivity(intent);
            }else{
                LogUtils.d(TAG, "进入主页");
                Intent intent = new Intent(WelcomeUI.this,MainUI.class);
                startActivity(intent);

            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
