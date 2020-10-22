package com.facebook.imagepipeline.producers;

import java.util.Map;
import javax.annotation.Nullable;

public class InternalProducerListener implements ProducerListener2 {
    private final ProducerListener mProducerListener;
    @Nullable
    private final ProducerListener2 mProducerListener2;

    public InternalProducerListener(ProducerListener producerListener, @Nullable ProducerListener2 producerListener2) {
        this.mProducerListener = producerListener;
        this.mProducerListener2 = producerListener2;
    }

    public ProducerListener getProducerListener() {
        return this.mProducerListener;
    }

    @Nullable
    public ProducerListener2 getProducerListener2() {
        return this.mProducerListener2;
    }

    public void onProducerStart(ProducerContext producerContext, String str) {
        if (this.mProducerListener != null) {
            this.mProducerListener.onProducerStart(producerContext.getId(), str);
        }
        if (this.mProducerListener2 != null) {
            this.mProducerListener2.onProducerStart(producerContext, str);
        }
    }

    public void onProducerEvent(ProducerContext producerContext, String str, String str2) {
        if (this.mProducerListener != null) {
            this.mProducerListener.onProducerEvent(producerContext.getId(), str, str2);
        }
        if (this.mProducerListener2 != null) {
            this.mProducerListener2.onProducerEvent(producerContext, str, str2);
        }
    }

    public void onProducerFinishWithSuccess(ProducerContext producerContext, String str, @Nullable Map<String, String> map) {
        if (this.mProducerListener != null) {
            this.mProducerListener.onProducerFinishWithSuccess(producerContext.getId(), str, map);
        }
        if (this.mProducerListener2 != null) {
            this.mProducerListener2.onProducerFinishWithSuccess(producerContext, str, map);
        }
    }

    public void onProducerFinishWithFailure(ProducerContext producerContext, String str, Throwable th, @Nullable Map<String, String> map) {
        if (this.mProducerListener != null) {
            this.mProducerListener.onProducerFinishWithFailure(producerContext.getId(), str, th, map);
        }
        if (this.mProducerListener2 != null) {
            this.mProducerListener2.onProducerFinishWithFailure(producerContext, str, th, map);
        }
    }

    public void onProducerFinishWithCancellation(ProducerContext producerContext, String str, @Nullable Map<String, String> map) {
        if (this.mProducerListener != null) {
            this.mProducerListener.onProducerFinishWithCancellation(producerContext.getId(), str, map);
        }
        if (this.mProducerListener2 != null) {
            this.mProducerListener2.onProducerFinishWithCancellation(producerContext, str, map);
        }
    }

    public void onUltimateProducerReached(ProducerContext producerContext, String str, boolean z) {
        if (this.mProducerListener != null) {
            this.mProducerListener.onUltimateProducerReached(producerContext.getId(), str, z);
        }
        if (this.mProducerListener2 != null) {
            this.mProducerListener2.onUltimateProducerReached(producerContext, str, z);
        }
    }

    public boolean requiresExtraMap(ProducerContext producerContext, String str) {
        boolean requiresExtraMap = this.mProducerListener != null ? this.mProducerListener.requiresExtraMap(producerContext.getId()) : false;
        return (requiresExtraMap || this.mProducerListener2 == null) ? requiresExtraMap : this.mProducerListener2.requiresExtraMap(producerContext, str);
    }
}
