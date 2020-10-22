package com.bugsnag.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bugsnag.android.JsonStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

class ThreadState implements JsonStream.Streamable {
    private static final String THREAD_TYPE = "android";
    private final CachedThread[] cachedThreads;

    public ThreadState(@NonNull Configuration configuration, @NonNull Thread thread, @NonNull Map<Thread, StackTraceElement[]> map, @Nullable Throwable th) {
        Thread thread2 = thread;
        Map<Thread, StackTraceElement[]> map2 = map;
        if (!map2.containsKey(thread2)) {
            map2.put(thread2, thread.getStackTrace());
        }
        if (th != null) {
            map2.put(thread2, th.getStackTrace());
        }
        long id = thread.getId();
        Thread[] sortThreadsById = sortThreadsById(map2);
        this.cachedThreads = new CachedThread[sortThreadsById.length];
        for (int i = 0; i < sortThreadsById.length; i++) {
            Thread thread3 = sortThreadsById[i];
            this.cachedThreads[i] = new CachedThread(configuration, thread3.getId(), thread3.getName(), "android", thread3.getId() == id, map2.get(thread3));
        }
    }

    ThreadState(@NonNull CachedThread[] cachedThreadArr) {
        this.cachedThreads = cachedThreadArr;
    }

    private Thread[] sortThreadsById(Map<Thread, StackTraceElement[]> map) {
        Thread[] threadArr = (Thread[]) map.keySet().toArray(new Thread[0]);
        Arrays.sort(threadArr, new Comparator<Thread>() {
            public int compare(@NonNull Thread thread, @NonNull Thread thread2) {
                return Long.valueOf(thread.getId()).compareTo(Long.valueOf(thread2.getId()));
            }
        });
        return threadArr;
    }

    public void toStream(@NonNull JsonStream jsonStream) throws IOException {
        jsonStream.beginArray();
        for (CachedThread value : this.cachedThreads) {
            jsonStream.value((JsonStream.Streamable) value);
        }
        jsonStream.endArray();
    }
}
