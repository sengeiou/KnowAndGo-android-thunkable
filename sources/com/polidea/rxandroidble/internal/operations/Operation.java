package com.polidea.rxandroidble.internal.operations;

import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble.internal.Priority;
import com.polidea.rxandroidble.internal.serialization.QueueReleaseInterface;
import p033rx.Observable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface Operation<T> extends Comparable<Operation<?>> {
    Priority definedPriority();

    Observable<T> run(QueueReleaseInterface queueReleaseInterface);
}
