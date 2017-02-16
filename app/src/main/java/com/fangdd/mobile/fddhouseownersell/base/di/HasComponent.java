package com.fangdd.mobile.fddhouseownersell.base.di;


/**
 * Interface representing a contract for clients that contains a component for dependency injection.
 * Created by lee on 17/2/14.
 */
public interface HasComponent<C> {
    C getComponent();
}