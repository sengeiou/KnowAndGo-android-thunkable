package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import javax.annotation.Nullable;

public class InternalRequestListener extends InternalProducerListener implements RequestListener2 {
    @Nullable
    private final RequestListener mRequestListener;
    @Nullable
    private final RequestListener2 mRequestListener2;

    public InternalRequestListener(@Nullable RequestListener requestListener, @Nullable RequestListener2 requestListener2) {
        super(requestListener, requestListener2);
        this.mRequestListener = requestListener;
        this.mRequestListener2 = requestListener2;
    }

    public void onRequestStart(ProducerContext producerContext) {
        if (this.mRequestListener != null) {
            this.mRequestListener.onRequestStart(producerContext.getImageRequest(), producerContext.getCallerContext(), producerContext.getId(), producerContext.isPrefetch());
        }
        if (this.mRequestListener2 != null) {
            this.mRequestListener2.onRequestStart(producerContext);
        }
    }

    public void onRequestSuccess(ProducerContext producerContext) {
        if (this.mRequestListener != null) {
            this.mRequestListener.onRequestSuccess(producerContext.getImageRequest(), producerContext.getId(), producerContext.isPrefetch());
        }
        if (this.mRequestListener2 != null) {
            this.mRequestListener2.onRequestSuccess(producerContext);
        }
    }

    public void onRequestFailure(ProducerContext producerContext, Throwable th) {
        if (this.mRequestListener != null) {
            this.mRequestListener.onRequestFailure(producerContext.getImageRequest(), producerContext.getId(), th, producerContext.isPrefetch());
        }
        if (this.mRequestListener2 != null) {
            this.mRequestListener2.onRequestFailure(producerContext, th);
        }
    }

    public void onRequestCancellation(ProducerContext producerContext) {
        if (this.mRequestListener != null) {
            this.mRequestListener.onRequestCancellation(producerContext.getId());
        }
        if (this.mRequestListener2 != null) {
            this.mRequestListener2.onRequestCancellation(producerContext);
        }
    }
}
