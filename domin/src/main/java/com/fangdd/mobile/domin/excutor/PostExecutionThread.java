package com.fangdd.mobile.domin.excutor;

import io.reactivex.Scheduler;

/**
 * Thread abstraction created to change the execution context from any thread to any other thread. Useful to encapsulate
 * a UI Thread for example, since some job will be done in background, an implementation of this interface will change
 * context and update the UI.
 * Created by lee on 17/2/10.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
