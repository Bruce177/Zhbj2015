package org.itheima.zhbj2015.fragment;

import android.view.View;
import android.widget.TextView;

/**
 * Created by yuqiqi on 2015/8/18.
 */
public class LeftFragment extends BaseFragment{


    @Override
    protected View initView() {
        TextView textView = new TextView(getActivity());
        textView.setText("杀杀杀");
        return textView;
    }

    @Override
    protected void initData() {

    }
}
