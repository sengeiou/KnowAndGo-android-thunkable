package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.image.EncodedImageOrigin;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;

public interface ProducerContext {

    public @interface ExtraKeys {
        public static final int ORIGIN = 1;
    }

    void addCallbacks(ProducerContextCallbacks producerContextCallbacks);

    Object getCallerContext();

    EncodedImageOrigin getEncodedImageOrigin();

    String getExtra(@ExtraKeys int i);

    String getId();

    ImagePipelineConfig getImagePipelineConfig();

    ImageRequest getImageRequest();

    ImageRequest.RequestLevel getLowestPermittedRequestLevel();

    Priority getPriority();

    ProducerListener2 getProducerListener();

    @Nullable
    String getUiComponentId();

    boolean isIntermediateResultExpected();

    boolean isPrefetch();

    void setEncodedImageOrigin(EncodedImageOrigin encodedImageOrigin);

    void setExtra(@ExtraKeys int i, String str);
}
