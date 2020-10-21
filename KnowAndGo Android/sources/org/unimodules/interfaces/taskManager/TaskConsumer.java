package org.unimodules.interfaces.taskManager;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.unimodules.core.interfaces.DoNotStrip;

public abstract class TaskConsumer implements TaskConsumerInterface {
    @DoNotStrip
    public static int VERSION;
    private WeakReference<Context> mContextRef;
    private TaskManagerUtilsInterface mTaskManagerUtils;

    public boolean canReceiveCustomBroadcast(String str) {
        return false;
    }

    public boolean didCancelJob(JobService jobService, JobParameters jobParameters) {
        return false;
    }

    public boolean didExecuteJob(JobService jobService, JobParameters jobParameters) {
        return false;
    }

    public void didReceiveBroadcast(Intent intent) {
    }

    public void setOptions(Map<String, Object> map) {
    }

    public TaskConsumer(Context context, TaskManagerUtilsInterface taskManagerUtilsInterface) {
        this.mContextRef = new WeakReference<>(context);
        this.mTaskManagerUtils = taskManagerUtilsInterface;
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        if (this.mContextRef != null) {
            return (Context) this.mContextRef.get();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public TaskManagerUtilsInterface getTaskManagerUtils() {
        return this.mTaskManagerUtils;
    }
}
