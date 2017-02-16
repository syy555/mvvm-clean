package com.fangdd.mobile.fddhouseownersell.base;

import android.databinding.BaseObservable;
import android.support.v4.app.FragmentActivity;


/**
 * Created by lee on 17/2/14.
 */

public class BaseViewModel extends BaseObservable {

    protected FragmentActivity activity;

    public BaseViewModel(FragmentActivity activity){
        this.activity = activity;
    }
}
