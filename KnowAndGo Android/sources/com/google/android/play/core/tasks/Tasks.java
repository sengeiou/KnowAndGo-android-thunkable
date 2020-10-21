package com.google.android.play.core.tasks;

import androidx.annotation.NonNull;
import com.google.android.play.core.internal.C1998av;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {
    private Tasks() {
    }

    /* renamed from: a */
    public static <ResultT> Task<ResultT> m1052a(Exception exc) {
        C2174m mVar = new C2174m();
        mVar.mo33812a(exc);
        return mVar;
    }

    /* renamed from: a */
    public static <ResultT> Task<ResultT> m1053a(ResultT resultt) {
        C2174m mVar = new C2174m();
        mVar.mo33813a(resultt);
        return mVar;
    }

    /* renamed from: a */
    private static <ResultT> ResultT m1054a(Task<ResultT> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    /* renamed from: a */
    private static void m1055a(Task<?> task, C2175n nVar) {
        task.addOnSuccessListener(TaskExecutors.f1014a, nVar);
        task.addOnFailureListener(TaskExecutors.f1014a, nVar);
    }

    public static <ResultT> ResultT await(@NonNull Task<ResultT> task) throws ExecutionException, InterruptedException {
        C1998av.m630a(task, (Object) "Task must not be null");
        if (task.isComplete()) {
            return m1054a(task);
        }
        C2175n nVar = new C2175n((byte[]) null);
        m1055a(task, nVar);
        nVar.mo33816a();
        return m1054a(task);
    }

    public static <ResultT> ResultT await(@NonNull Task<ResultT> task, long j, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        C1998av.m630a(task, (Object) "Task must not be null");
        C1998av.m630a(timeUnit, (Object) "TimeUnit must not be null");
        if (task.isComplete()) {
            return m1054a(task);
        }
        C2175n nVar = new C2175n((byte[]) null);
        m1055a(task, nVar);
        if (nVar.mo33817a(j, timeUnit)) {
            return m1054a(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }
}
