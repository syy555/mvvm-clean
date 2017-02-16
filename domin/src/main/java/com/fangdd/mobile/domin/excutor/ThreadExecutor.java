package com.fangdd.mobile.domin.excutor;

/**
 * Executor implementation can be based on different frameworks or techniques of asynchronous execution, but every
 * implementation will execute the {@link com.fangdd.mobile.domin.BaseUseCase} out of the UI thread.
 * Created by lee on 17/2/10.
 */

import java.util.concurrent.Executor;


public interface ThreadExecutor extends Executor {
}
