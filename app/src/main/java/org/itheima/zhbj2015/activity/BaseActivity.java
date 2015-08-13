package org.itheima.zhbj2015.activity;

import org.itheima.zhbj2015.utils.ActivityCollectorUtils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by yuqiqi on 2015/8/13.
 */
public class BaseActivity  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());
        ActivityCollectorUtils.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollectorUtils.removeActivity(this);
    }

}