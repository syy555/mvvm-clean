package com.fangdd.mobile.fddhouseownersell.demo.house.houseList;

import android.content.Intent;
import android.databinding.Bindable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.fangdd.mobile.domin.preownedhouse.entity.HouseEntity;
import com.fangdd.mobile.fddhouseownersell.BR;
import com.fangdd.mobile.fddhouseownersell.base.BaseViewModel;
import com.fangdd.mobile.fddhouseownersell.demo.house.houseDetails.HouseDetailsActivity;

/**
 * Created by lee on 17/2/14.
 */


public class HouseItemViewModel extends BaseViewModel {
    String houseName;

    Long houseId;


    HouseItemViewModel(FragmentActivity activity, HouseEntity houseEntity) {
        super(activity);
        initViewModel(houseEntity);
    }

    private void initViewModel(HouseEntity houseEntity) {
        this.houseName = houseEntity.getName();
        this.houseId = houseEntity.getId();
    }

    @Bindable
    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
        notifyPropertyChanged(BR.houseName);
    }

    @Bindable
    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
        notifyPropertyChanged(BR.houseId);
    }

    /**
     * Called by the Data Binding library when the house item view is clicked.
     */
    public void houseClick() {
        Intent intent = new Intent(activity, HouseDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putLong(HouseDetailsActivity.HOUSE_ID, houseId);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }
}
