package com.fangdd.mobile.fddhouseownersell;

import android.app.Application;

import com.fangdd.mobile.fddhouseownersell.base.di.component.ApplicationComponent;
import com.fangdd.mobile.fddhouseownersell.base.di.component.DaggerApplicationComponent;
import com.fangdd.mobile.fddhouseownersell.base.di.module.ApplicationModule;

/**
 * Created by lee on 17/2/14.
 */

public class CustomerApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

}
