package com.fangdd.mobile.fddhouseownersell.demo.house.houseList;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fangdd.mobile.fddhouseownersell.HouseItemBinding;

/**
 * Created by lee on 17/2/15.
 */

public class HouseItemHolder extends RecyclerView.ViewHolder {

    HouseItemBinding houseItemBinding;

    public HouseItemHolder(View itemView,  HouseItemBinding houseItemBinding) {
        super(itemView);
        this.houseItemBinding = houseItemBinding;
    }

    public HouseItemBinding getHouseItemBinding() {
        return houseItemBinding;
    }

    public void binding(HouseItemViewModel houseItemViewModel){
        houseItemBinding.setHouse(houseItemViewModel);
    }
}
