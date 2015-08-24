package org.itheima.zhbj2015.fragment;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.itheima.zhbj2015.R;
import org.itheima.zhbj2015.activity.MainUI;
import org.itheima.zhbj2015.bean.NewscenterBean;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yuqiqi on 2015/8/18.
 */
public class LeftFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private ListView mListView;

    private List<NewscenterBean.NewsMenuBean> mDatas;

    private int mCurrentPosition;
    private MenuAdapter mMenuAdapter;


    @Override
    protected View initView() {
        View view = View.inflate(mActivity, R.layout.menu, null);
        mListView = (ListView) view.findViewById(R.id.menu_listview);

        mListView.setOnItemClickListener(this);
        return mListView;
    }

    @Override
    protected void initData() {

    }

    public void setData(List<NewscenterBean.NewsMenuBean> data) {
        this.mDatas = data;
        mMenuAdapter = new MenuAdapter();
        mListView.setAdapter(mMenuAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (mCurrentPosition == position){
            return;
        }

        mCurrentPosition = position;

        //刷新界面
        mMenuAdapter.notifyDataSetChanged();
        //关闭菜单
        SlidingMenu slidingMenu = ((MainUI) mActivity).getSlidingMenu();
        slidingMenu.toggle();//开关，如果是开的就关，是关的就开

        ContentFragment contentFragment = ((MainUI) mActivity).getContentFragment();
        contentFragment.switchMenu(position);
    }

    private class MenuAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if (mDatas != null) {
                return mDatas.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            if (mDatas != null) {
                return mDatas.get(position);
            }
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, android.view.View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                //1 加载view
                convertView = View.inflate(mActivity, R.layout.item_menu, null);

                //2 初始化holder
                viewHolder = new ViewHolder();

                //3 设置标记
                convertView.setTag(viewHolder);

                //4 给holder加载view
                viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.item_menu_tv_title);

            } else {
                //如果不为空，则复用
                viewHolder = (ViewHolder) convertView.getTag();
            }

            //设置数据
            NewscenterBean.NewsMenuBean data = mDatas.get(position);
            viewHolder.tvTitle.setText(data.title);

            viewHolder.tvTitle.setEnabled(mCurrentPosition == position);
            return convertView;
        }
    }

    private class ViewHolder {

        TextView tvTitle;
    }
}
