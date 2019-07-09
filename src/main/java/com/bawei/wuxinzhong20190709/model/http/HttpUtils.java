package com.bawei.wuxinzhong20190709.model.http;

import android.os.Handler;
import android.os.Message;
import android.os.WorkSource;

import com.bawei.wuxinzhong20190709.view.interfaces.IMainView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <p>文件描述：工具类<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/9/009<p>
 * <p>更改时间：2019/7/9/009<p>
 */
public class HttpUtils {
    //单例
    private HttpUtils() {
    }

    private static HttpUtils sHttpUtils;

    public static HttpUtils getInstance() {
        if (sHttpUtils == null) {
            sHttpUtils = new HttpUtils();
        }
        return sHttpUtils;
    }

    //获取数据
    private CallBackData mCallBackData;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String s = (String) msg.obj;
            mCallBackData.success(s);
        }
    };

    public void getData(final String s, CallBackData callBackData) {
        this.mCallBackData = callBackData;
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(s);
                    HttpURLConnection h = (HttpURLConnection) url.openConnection();
                    h.setRequestMethod("GET");
                    h.setConnectTimeout(3000);
                    h.setReadTimeout(3000);
                    int code = h.getResponseCode();
                    if (code == 200) {
                        InputStream inputStream = h.getInputStream();

                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        StringBuffer stringBuffer = new StringBuffer();
                        String str = "";
                        while ((str = bufferedReader.readLine()) != null) {
                            stringBuffer.append(str);
                        }
                        h.disconnect();
                        bufferedReader.close();
                        Message message = handler.obtainMessage();
                        message.obj = stringBuffer.toString();
                        handler.sendMessage(message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
