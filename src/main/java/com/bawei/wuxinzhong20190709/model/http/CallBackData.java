package com.bawei.wuxinzhong20190709.model.http;

/**
 * <p>文件描述：判断接口<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/9/009<p>
 * <p>更改时间：2019/7/9/009<p>
 */
public interface CallBackData {
    void success(String data);

    void error(int code, String datas);
}
