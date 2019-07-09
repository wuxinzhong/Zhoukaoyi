package com.bawei.wuxinzhong20190709.presenter;

import android.widget.ImageView;

import com.bawei.wuxinzhong20190709.model.http.CallBackData;
import com.bawei.wuxinzhong20190709.model.http.HttpUtils;
import com.bawei.wuxinzhong20190709.utils.Constant;
import com.bawei.wuxinzhong20190709.view.activity.MainActivity;
import com.bawei.wuxinzhong20190709.view.interfaces.IMainView;

/**
 * <p>文件描述：P层<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/9/009<p>
 * <p>更改时间：2019/7/9/009<p>
 */
public class HomePresenter {
    private HttpUtils mHttpUtils;
    private IMainView mIMainView;

    public void attachView(IMainView iMainView) {
        mHttpUtils = HttpUtils.getInstance();
        mIMainView = iMainView;
    }

    public void detachData() {
        mIMainView = null;
    }

    public void getData() {
        mHttpUtils.getData(Constant.BASE_URL, new CallBackData() {
            @Override
            public void success(String data) {
                mIMainView.ok(data);
            }

            @Override
            public void error(int code, String datas) {

            }
        });
    }
}
