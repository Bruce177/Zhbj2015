package org.itheima.zhbj2015.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by yuqiqi on 2015/8/13.
 */
public class PreferenceUtils {
    private static SharedPreferences mSp;
    //即在/data/data/包名/shared_prefs目录下生成了一个config.xml文件
    private static final String SP_NAME = "config";

    public static SharedPreferences getSp(Context context) {
        if (mSp == null){
            mSp = context.getSharedPreferences(SP_NAME,context.MODE_PRIVATE);
        }
        return mSp;
    }

    public static boolean getBoolean(Context context,String key, boolean defValue){

        SharedPreferences sp = getSp(context);
        return sp.getBoolean(key,true);
    }

    public static void setBoolean(Context context,String key,boolean value){
        SharedPreferences sp = getSp(context);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(key,value);
        edit.commit();
    }
}
