package com.fangdd.mobile.fddhouseownersell.base.di.component;

/**
 *
 */

import android.content.Context;

import com.fangdd.mobile.domin.excutor.PostExecutionThread;
import com.fangdd.mobile.domin.excutor.ThreadExecutor;
import com.fangdd.mobile.domin.general.cache.GeneralCache;
import com.fangdd.mobile.domin.preownedhouse.repository.HouseRepository;
import com.fangdd.mobile.fddhouseownersell.base.BaseActivity;
import com.fangdd.mobile.fddhouseownersell.base.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 * Created by lee on 17/2/14.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    GeneralCache generalCache();
    HouseRepository houseRepository();
}