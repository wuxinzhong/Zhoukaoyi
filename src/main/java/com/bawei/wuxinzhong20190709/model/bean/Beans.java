package com.bawei.wuxinzhong20190709.model.bean;

import java.util.List;

/**
 * <p>文件描述：封装类<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/9/009<p>
 * <p>更改时间：2019/7/9/009<p>
 */
public class Beans {

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {

        public int commodityId;
        public String commodityName;
        public String masterPic;
        public String price;
        public int saleNum;
    }
}
