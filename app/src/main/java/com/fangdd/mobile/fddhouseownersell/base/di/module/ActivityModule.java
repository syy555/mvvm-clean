package com.fangdd.mobile.fddhouseownersell.base.di.module;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;

import com.fangdd.mobile.fddhouseownersell.base.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * A module to wrap the Activity state and expose it to the graph.
 * Created by lee on 17/2/16.
 */
@Module
public class ActivityModule {
    private final FragmentActivity activity;

    public ActivityModule(FragmentActivity activity) {
        this.activity = activity;
    }

    /**
     * Expose the fragmentactivity to dependents in the graph.
     */
    @Provides
    @PerActivity
    FragmentActivity activity() {
        return this.activity;
    }
}