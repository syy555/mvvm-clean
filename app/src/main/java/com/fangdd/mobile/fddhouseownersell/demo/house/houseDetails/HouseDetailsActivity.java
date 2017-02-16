package com.fangdd.mobile.fddhouseownersell.demo.house.houseDetails;

import android.databinding.DataBindingUtil;

import com.fangdd.mobile.fddhouseownersell.R;
import com.fangdd.mobile.fddhouseownersell.base.BaseActivity;
import com.fangdd.mobile.fddhouseownersell.base.di.HasComponent;
import com.fangdd.mobile.fddhouseownersell.base.di.component.ActivityComponent;
import com.fangdd.mobile.fddhouseownersell.base.di.component.DaggerActivityComponent;
import com.fangdd.mobile.fddhouseownersell.base.di.module.ActivityModule;
import com.fangdd.mobile.fddhouseownersell.databinding.ActivityHouseDetailsBinding;

import javax.inject.Inject;

/**
 * Created by lee on 17/2/14.
 */

public class HouseDetailsActivity extends BaseActivity implements HasComponent<ActivityComponent> {
    public static final String HOUSE_ID = "house_id";

    private ActivityComponent activityComponent;

    @Inject
    HouseDetailsViewModel houseDetailsViewModel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_house_details;
    }

    @Override
    public void initViews() {
        initializeInjector();
        Long houseId = getExtras(HOUSE_ID);
        ActivityHouseDetailsBinding binding = DataBindingUtil.bind(getContentView(this));
        binding.setHouse(houseDetailsViewModel);
        houseDetailsViewModel.setHouseId(houseId);
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
