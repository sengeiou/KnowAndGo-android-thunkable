package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.StatefulRunnable;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class StatefulProducerRunnable<T> extends StatefulRunnable<T> {
    private final Consumer<T> mConsumer;
    private final ProducerContext mProducerContext;
    private final ProducerListener2 mProducerListener;
    private final String mProducerName;

    /* access modifiers changed from: protected */
    public abstract void disposeResult(T t);

    /* access modifiers changed from: protected */
    @Nullable
    public Map<String, String> getExtraMapOnCancellation() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Map<String, String> getExtraMapOnFailure(Exception exc) {
        return null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Map<String, String> getExtraMapOnSuccess(T t) {
        return null;
    }

    public StatefulProducerRunnable(Consumer<T> consumer, ProducerListener2 producerListener2, ProducerContext producerContext, String str) {
        this.mConsumer = consumer;
        this.mProducerListener = producerListener2;
        this.mProducerName = str;
        this.mProducerContext = producerContext;
        this.mProducerListener.onProducerStart(this.mProducerContext, this.mProducerName);
    }

    /* access modifiers changed from: protected */
    public void onSuccess(T t) {
        this.mProducerListener.onProducerFinishWithSuccess(this.mProducerContext, this.mProducerName, this.mProducerListener.requiresExtraMap(this.mProducerContext, this.mProducerName) ? getExtraMapOnSuccess(t) : null);
        this.mConsumer.onNewResult(t, 1);
    }

    /* access modifiers changed from: protected */
    public void onFailure(Exception exc) {
        Map<String, String> map;
        ProducerListener2 producerListener2 = this.mProducerListener;
        ProducerContext producerContext = this.mProducerContext;
        String str = this.mProducerName;
        if (this.mProducerListener.requiresExtraMap(this.mProducerContext, this.mProducerName)) {
            map = getExtraMapOnFailure(exc);
        } else {
            map = null;
        }
        producerListener2.onProducerFinishWithFailure(producerContext, str, exc, map);
        this.mConsumer.onFailure(exc);
    }

    /* access modifiers changed from: protected */
    public void onCancellation() {
        this.mProducerListener.onProducerFinishWithCancellation(this.mProducerContext, this.mProducerName, this.mProducerListener.requiresExtraMap(this.mProducerContext, this.mProducerName) ? getExtraMapOnCancellation() : null);
        this.mConsumer.onCancellation();
    }
}
