package com.facebook.imagepipeline.listener;

import androidx.annotation.NonNull;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.util.Map;
import javax.annotation.Nullable;

public class BaseRequestListener2 implements RequestListener2 {
    public void onProducerEvent(@NonNull ProducerContext producerContext, @NonNull String str, @NonNull String str2) {
    }

    public void onProducerFinishWithCancellation(@NonNull ProducerContext producerContext, @NonNull String str, @Nullable Map<String, String> map) {
    }

    public void onProducerFinishWithFailure(@NonNull ProducerContext producerContext, String str, Throwable th, @Nullable Map<String, String> map) {
    }

    public void onProducerFinishWithSuccess(@NonNull ProducerContext producerContext, @NonNull String str, @Nullable Map<String, String> map) {
    }

    public void onProducerStart(@NonNull ProducerContext producerContext, @NonNull String str) {
    }

    public void onRequestCancellation(@NonNull ProducerContext producerContext) {
    }

    public void onRequestFailure(@NonNull ProducerContext producerContext, Throwable th) {
    }

    public void onRequestStart(@NonNull ProducerContext producerContext) {
    }

    public void onRequestSuccess(@NonNull ProducerContext producerContext) {
    }

    public void onUltimateProducerReached(@NonNull ProducerContext producerContext, @NonNull String str, boolean z) {
    }

    public boolean requiresExtraMap(@NonNull ProducerContext producerContext, @NonNull String str) {
        return false;
    }
}
