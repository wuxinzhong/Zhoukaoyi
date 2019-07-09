package com.bawei.wuxinzhong20190709.view.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ScrollView;

import com.bawei.wuxinzhong20190709.R;
import com.bawei.wuxinzhong20190709.model.bean.Beans;
import com.bawei.wuxinzhong20190709.presenter.HomePresenter;
import com.bawei.wuxinzhong20190709.view.adapter.MyAdapter;
import com.bawei.wuxinzhong20190709.view.interfaces.IMainView;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.List;

/**
 * <p>文件描述：V层<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/9/009<p>
 * <p>更改时间：2019/7/9/009<p>
 */
public class MainActivity extends BaseActivity implements IMainView {


    private HomePresenter mHomePresenter;
    private GridView grid_view;
    private PullToRefreshScrollView pull;

    @Override
    protected void initData() {
        mHomePresenter = new HomePresenter();
        mHomePresenter.attachView(this);
        mHomePresenter.getData();
    }

    @Override
    protected void initView() {
        grid_view = findViewById(R.id.grid_view);
        pull = findViewById(R.id.pull);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void ok(final String str) {
        Gson gson = new Gson();
        Beans beans = gson.fromJson(str, Beans.class);
        List<Beans.ResultBean> result = beans.result;

        //创建适配器
        MyAdapter myAdapter = new MyAdapter(result, MainActivity.this);
        grid_view.setAdapter(myAdapter);

        pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                ok(str);
                Gson gson = new Gson();
                Beans beans = gson.fromJson(str, Beans.class);
                List<Beans.ResultBean> result = beans.result;

                //创建适配器
                MyAdapter myAdapter = new MyAdapter(result, MainActivity.this);
                grid_view.setAdapter(myAdapter);
                //停止刷新
                pull.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                ok(str);
                Gson gson = new Gson();
                Beans beans = gson.fromJson(str, Beans.class);
                List<Beans.ResultBean> result = beans.result;

                //创建适配器
                MyAdapter myAdapter = new MyAdapter(result, MainActivity.this);

                myAdapter.notifyDataSetChanged();
                //停止加载
                pull.onRefreshComplete();
            }
        });
    }


    @Override
    public void no(int a, String strs) {

    }

    //防止内存泄漏
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHomePresenter.detachData();
    }
}
