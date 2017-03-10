package com.kaneki.done.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import org.greenrobot.eventbus.EventBus;

/**
 * @author yueqian
 * @Desctription
 * @date 2017/3/10
 * @email yueqian@mogujie.com
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(getContentView());
        findViews();
        initDatas();
        initViews();
        setListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public abstract int getContentView();

    public abstract void findViews();

    public abstract void initDatas();

    public abstract void initViews();

    public abstract void setListeners();
}
