package org.itheima.zhbj2015.bean;

import java.util.List;

/**
 * Created by yuqiqi on 2015/8/21.
 */
public class NewscenterBean {

    public List<NewsMenuBean> data;

    public List<Long> extend;

    public int retcode;

    public class NewsMenuBean {

        public List<NewsChildBean> children;

        public long id;

        public String title;

        public int type;

        public String url;

        public String url1;

        public String dayurl;

        public String excurl;

        public String weekurl;
    }

    public class NewsChildBean {

        public long id;

        public String title;

        public int type;

        public String url;
    }
}
