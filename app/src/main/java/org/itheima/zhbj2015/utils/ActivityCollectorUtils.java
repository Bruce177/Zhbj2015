package org.itheima.zhbj2015.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuqiqi on 2015/8/13.
 * 在需要一键退出时,调用finishAll()方法即可
 */
public class ActivityCollectorUtils {

    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
