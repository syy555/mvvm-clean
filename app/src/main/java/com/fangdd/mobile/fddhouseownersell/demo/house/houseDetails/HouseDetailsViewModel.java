package com.fangdd.mobile.fddhouseownersell.demo.house.houseDetails;

import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.fangdd.mobile.domin.preownedhouse.entity.HouseEntity;
import com.fangdd.mobile.domin.preownedhouse.usecase.GetHouseDetail;
import com.fangdd.mobile.fddhouseownersell.BR;
import com.fangdd.mobile.fddhouseownersell.base.BaseViewModel;
import com.fangdd.mobile.fddhouseownersell.base.di.PerActivity;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by lee on 17/2/14.
 */

@PerActivity
public class HouseDetailsViewModel extends BaseViewModel {
    String houseName;

    Long houseId;


    @Inject
    GetHouseDetail getHouseDetailUseCase;

    @Inject
    public HouseDetailsViewModel(FragmentActivity activity) {
        super(activity);
    }

    @Bindable
    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
        notifyPropertyChanged(BR.houseName);
    }

    private void initViewModel(HouseEntity entity){
        this.setHouseName(entity.getName());
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
        getHouseDetailUseCase.execute(new DisposableObserver<HouseEntity>() {
            @Override
            public void onNext(HouseEntity value) {
                initViewModel(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, GetHouseDetail.Params.setHouse(houseId));
    }

    /**
     * Called by the Data Binding library when the house item view is clicked.
     */
    public void houseClick(View view) {
        Snackbar.make(view, "this is a test", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
