package com.bugsnag.android;

import androidx.annotation.NonNull;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Async {
    private static final int CORE_POOL_SIZE = Math.max(1, Math.min(CPU_COUNT - 1, 4));
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30, TimeUnit.SECONDS, POOL_WORK_QUEUE, THREAD_FACTORY);
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int MAXIMUM_POOL_SIZE = ((CPU_COUNT * 2) + 1);
    static final BlockingQueue<Runnable> POOL_WORK_QUEUE = new LinkedBlockingQueue(128);
    private static final ThreadFactory THREAD_FACTORY = new ThreadFactory() {
        private final AtomicInteger count = new AtomicInteger(1);

        @NonNull
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "Bugsnag Thread #" + this.count.getAndIncrement());
        }
    };

    Async() {
    }

    static void run(@NonNull Runnable runnable) throws RejectedExecutionException {
        EXECUTOR.execute(runnable);
    }

    static void cancelTasks() throws InterruptedException {
        Logger.info("Cancelling tasks");
        EXECUTOR.shutdown();
        EXECUTOR.awaitTermination(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, TimeUnit.MILLISECONDS);
        Logger.info("Finishing cancelling tasks");
    }
}
