package com.fangdd.mobile.fddhouseownersell.demo.house.houseList;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;

import com.fangdd.mobile.fddhouseownersell.R;
import com.fangdd.mobile.fddhouseownersell.base.BaseActivity;
import com.fangdd.mobile.fddhouseownersell.base.di.HasComponent;
import com.fangdd.mobile.fddhouseownersell.base.di.component.ActivityComponent;
import com.fangdd.mobile.fddhouseownersell.base.di.component.DaggerActivityComponent;
import com.fangdd.mobile.fddhouseownersell.base.di.module.ActivityModule;
import com.fangdd.mobile.fddhouseownersell.databinding.ActivityHouseListBinding;

import javax.inject.Inject;

/**
 * Created by lee on 17/2/14.
 */

public class HouseListActivity extends BaseActivity implements HasComponent<ActivityComponent> {

    private ActivityComponent activityComponent;

    @Inject
    HouseListViewModel houseListViewModel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_house_list;
    }

    @Override
    public void initViews() {
        initializeInjector();
        generalCache.setUserId(1L);
        ActivityHouseListBinding binding = DataBindingUtil.bind(getContentView(this));
        houseListViewModel.setBinding(binding);
        binding.setHousesViewModel(new HouseListViewModel(this));
        binding.rcvHouseList.setLayoutManager(new LinearLayoutManager(this));
        houseListViewModel.requestData();
    }

    private void initializeInjector() {
        this.activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent()).activityModule(new ActivityModule(this))
                .build();
        activityComponent.inject(this);
    }

    @Override
    public ActivityComponent getComponent() {
        return activityComponent;
    }
}
