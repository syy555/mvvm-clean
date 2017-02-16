package com.fangdd.mobile.fddhouseownersell.demo.house.houseList;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fangdd.mobile.fddhouseownersell.HouseItemBinding;
import com.fangdd.mobile.fddhouseownersell.R;

import java.util.List;

/**
 * Created by lee on 17/2/15.
 */

public class HouseListAdapter extends RecyclerView.Adapter {

    List<HouseItemViewModel> houseItemViewModels;

    public void setHouseItemViewModels(List<HouseItemViewModel> houseItemViewModels) {
        this.houseItemViewModels = houseItemViewModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_house_list, parent, false);
        HouseItemBinding houseItemBinding = DataBindingUtil.bind(view);
        HouseItemHolder houseItemHolder = new HouseItemHolder(view, houseItemBinding);
        return houseItemHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HouseItemViewModel houseItemViewModel = houseItemViewModels.get(position);
        ((HouseItemHolder) holder).binding(houseItemViewModel);
    }

    @Override
    public int getItemCount() {
        if (houseItemViewModels == null || houseItemViewModels.size() == 0) {
            return 0;
        }
        return houseItemViewModels.size();
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<HouseItemViewModel> items) {
        HouseListAdapter adapter = (HouseListAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setHouseItemViewModels(items);
        }else{
            adapter = new HouseListAdapter();
            adapter.setHouseItemViewModels(items);
            recyclerView.setAdapter(adapter);
        }
    }


}
