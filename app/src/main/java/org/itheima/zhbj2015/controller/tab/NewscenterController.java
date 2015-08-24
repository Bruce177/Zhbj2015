package org.itheima.zhbj2015.controller.tab;

import com.google.gson.Gson;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.itheima.zhbj2015.activity.MainUI;
import org.itheima.zhbj2015.bean.NewscenterBean;
import org.itheima.zhbj2015.controller.TabController;
import org.itheima.zhbj2015.fragment.LeftFragment;
import org.itheima.zhbj2015.utils.Constants;
import org.itheima.zhbj2015.utils.LogUtils;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by yuqiqi on 2015/8/21.
 */
public class NewscenterController extends TabController {

    private static final String TAG = "NewscenterController";

    public NewscenterController(Context context) {
        super(context);
    }

    @Override
    protected View initContentView(Context context) {
        TextView textView = new TextView(context);
        textView.setText("新闻");
        textView.setTextColor(Color.RED);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void initData() {
        mTabName.setText("新闻");
        mIvMenu.setVisibility(View.VISIBLE);

        //去网络加载数据
        /*
       1 请求的方法
       2 请求的地址
       3 自定义头
       4 Post传输的数据
         */
        HttpUtils httpUtils = new HttpUtils();

        String url = Constants.NEWSCENTER_URL;

//        RequestParams params = new RequestParams();
        //GET请求
//        params.addQueryStringParameter("aa", "bb");
        //POST请求
//        params.addBodyParameter("aa","bb");
        //自定义头
//        params.addHeader("mayheder","xxx");

        httpUtils.send(HttpRequest.HttpMethod.GET, url, null, new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                //1 响应码
//                int statusCode = responseInfo.statusCode;
//                if (200 == statusCode){
//                    //访问服务器成功
//
//                    //自定义的头
//                    responseInfo.getHeaders("xxx");
//                }

                String result = responseInfo.result;
                LogUtils.d(TAG, "json: " + result);

                processJson(result);
            }

            @Override
            public void onFailure(HttpException e, String s) {

                e.printStackTrace();
                LogUtils.d(TAG, "访问网络失败");
            }
        });
    }

    private void processJson(String json) {
        Gson gson = new Gson();
        NewscenterBean bean = gson.fromJson(json, NewscenterBean.class);
        LogUtils.d(TAG,bean.data.get(0).children.get(0).title);

        MainUI mainUI = (MainUI) mContext;
        LeftFragment leftFragment = mainUI.getLeftFragment();
        leftFragment.setData(bean.data);
    }
}
