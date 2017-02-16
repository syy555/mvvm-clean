package com.fangdd.mobile.fddhouseownersell.base.di;


import java.lang.annotation.Retention;
import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the activity to be memorized in the
 * correct component.
 * Created by lee on 17/2/14.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {}