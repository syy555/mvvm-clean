package com.fangdd.mobile.fddhouseownersell.base.di.component;

import android.support.v4.app.FragmentActivity;
import com.fangdd.mobile.fddhouseownersell.base.di.module.ActivityModule;
import com.fangdd.mobile.fddhouseownersell.base.di.PerActivity;
import com.fangdd.mobile.fddhouseownersell.demo.house.houseDetails.HouseDetailsActivity;
import com.fangdd.mobile.fddhouseownersell.demo.house.houseList.HouseListActivity;

import dagger.Component;

/**
 * Created by lee on 17/2/16.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    FragmentActivity activity();
    void inject(HouseListActivity houseListActivity);
    void inject(HouseDetailsActivity houseDetailsActivity);
}