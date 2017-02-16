package com.fangdd.mobile.fddhouseownersell.demo.house.houseList;

import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.fangdd.mobile.domin.general.cache.GeneralCache;
import com.fangdd.mobile.domin.preownedhouse.entity.HouseEntity;
import com.fangdd.mobile.domin.preownedhouse.usecase.GetHouseList;
import com.fangdd.mobile.fddhouseownersell.BR;
import com.fangdd.mobile.fddhouseownersell.base.BaseViewModel;
import com.fangdd.mobile.fddhouseownersell.base.di.PerActivity;
import com.fangdd.mobile.fddhouseownersell.databinding.ActivityHouseListBinding;

import java.util.List;
import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by lee on 17/2/15.
 */
@PerActivity
public class HouseListViewModel extends BaseViewModel {

    @Inject
    GetHouseList getHouseListUseCase;


    ActivityHouseListBinding binding;

    public void setBinding(ActivityHouseListBinding binding) {
        this.binding = binding;
    }

    @Bindable
    public ObservableArrayList<HouseItemViewModel> houses;

    @Inject
    public HouseListViewModel(FragmentActivity activity) {
        super(activity);
        this.houses = new ObservableArrayList<>();
    }

    private void setHouses(ObservableArrayList<HouseItemViewModel> houseItemViewModels) {
        this.houses = houseItemViewModels;
//        notifyPropertyChanged(BR.houses);
        ((HouseListAdapter)binding.rcvHouseList.getAdapter()).setHouseItemViewModels(houses);
    }

    public void requestData() {
        getHouseListUseCase.execute(new DisposableObserver<List<HouseEntity>>() {

            @Override
            protected void onStart() {
                Toast.makeText(activity, "加载开始", Toast.LENGTH_SHORT);
            }

            @Override
            public void onNext(List<HouseEntity> value) {
                ObservableArrayList<HouseItemViewModel> houseItemViewModels = new ObservableArrayList<>();
                for (HouseEntity houseEntity : value) {
                    HouseItemViewModel itemViewModel = new HouseItemViewModel(activity, houseEntity);
                    houseItemViewModels.add(itemViewModel);
                }
                setHouses(houseItemViewModels);
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(activity, "加载失败", Toast.LENGTH_SHORT);
            }

            @Override
            public void onComplete() {
                Toast.makeText(activity, "加载开始", Toast.LENGTH_SHORT);
            }
        }, GetHouseList.Params.setHouse(1, 1, 1, ""));
    }
}
