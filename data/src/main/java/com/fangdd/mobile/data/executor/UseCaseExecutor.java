package com.fangdd.mobile.data.executor;

import android.support.annotation.NonNull;

import com.fangdd.mobile.domin.excutor.ThreadExecutor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * The implementation of ThreadExecutor for use cases.
 * Created by lee on 17/2/10.
 */

public class UseCaseExecutor implements ThreadExecutor {

    private final ThreadPoolExecutor threadPoolExecutor;

    public UseCaseExecutor() {
        this.threadPoolExecutor = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(), new UseCaseThreadFactory());
    }

    @Override
    public void execute(Runnable runnable) {
        this.threadPoolExecutor.execute(runnable);
    }

    private static class UseCaseThreadFactory implements ThreadFactory {
        private int counter = 0;

        @Override
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "android_use_case_" + counter++);
        }
    }
}
