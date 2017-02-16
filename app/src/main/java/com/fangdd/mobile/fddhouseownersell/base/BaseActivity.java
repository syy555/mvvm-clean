package com.fangdd.mobile.fddhouseownersell.base;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.fangdd.mobile.domin.general.cache.GeneralCache;
import com.fangdd.mobile.fddhouseownersell.CustomerApplication;
import com.fangdd.mobile.fddhouseownersell.base.di.module.ActivityModule;
import com.fangdd.mobile.fddhouseownersell.base.di.component.ApplicationComponent;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

import javax.inject.Inject;

/**
 * The base activity for all the activities in this application which implement some common methods.
 * Created by lee on 17/2/9.
 */

public class BaseActivity extends RxFragmentActivity {

    @Inject
    protected GeneralCache generalCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
        setContentView(getLayoutId());
    }


    /**
     * return the layout for this activity.
     *
     * @return
     */
    public int getLayoutId() {
        return 0;
    }

    /**
     * init views
     */
    public void initViews() {
    }

    /**
     * after view inited.
     */
    public void afterViews() {
    }

    public static View getContentView(Activity ac){
        ViewGroup view;
        view = (ViewGroup)ac.getWindow().getDecorView();
        FrameLayout content = (FrameLayout)view.findViewById(android.R.id.content);
        return content.getChildAt(0);
    }

    @Override
    public void setContentView(int resourceId) {
        super.setContentView(resourceId);
        initViews();
        afterViews();
    }

    /**
     * @param key The key of the needed extra data.
     * @param <T> The type of the extra data.
     * @return the needed object.
     */
    public <T> T getExtras(String key) {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.containsKey(key)) {
                try {
                    return (T) extras.get(key);
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link ApplicationComponent}
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((CustomerApplication) getApplication()).getApplicationComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     *
     * @return {@link ActivityModule}
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
