package com.bawei.wuxinzhong20190709.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.wuxinzhong20190709.R;

/**
 * <p>文件描述：activity的基类<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/9/009<p>
 * <p>更改时间：2019/7/9/009<p>
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int initLayout();
}
