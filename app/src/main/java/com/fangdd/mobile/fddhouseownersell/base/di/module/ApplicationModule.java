package com.fangdd.mobile.fddhouseownersell.base.di.module;


import android.content.Context;

import com.fangdd.mobile.data.executor.UseCaseExecutor;
import com.fangdd.mobile.data.general.cache.GeneralDataCache;
import com.fangdd.mobile.data.preownedhouse.repository.HouseDataRepository;
import com.fangdd.mobile.domin.excutor.PostExecutionThread;
import com.fangdd.mobile.domin.excutor.ThreadExecutor;
import com.fangdd.mobile.domin.general.cache.GeneralCache;
import com.fangdd.mobile.domin.preownedhouse.repository.HouseRepository;
import com.fangdd.mobile.fddhouseownersell.CustomerApplication;
import com.fangdd.mobile.fddhouseownersell.base.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle. Created by lee on 17/2/14.
 */
@Module
public class ApplicationModule {
    private final CustomerApplication application;

    public ApplicationModule(CustomerApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor() {
        return new UseCaseExecutor();
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread() {
        return new UIThread();
    }

    @Provides
    @Singleton
    GeneralCache provideGeneralCache(GeneralDataCache generalDataCache) {
        return generalDataCache;
    }

    @Provides
    @Singleton
    HouseRepository provideHouseRepository() {
        return new HouseDataRepository();
    }
}