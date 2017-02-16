package com.fangdd.mobile.fddhouseownersell.base;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * Created by lee on 17/2/7.
 */

public interface IView<T> {
    void setPresenter(T presenter);
}
