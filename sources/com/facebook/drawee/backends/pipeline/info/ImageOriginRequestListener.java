package com.facebook.drawee.backends.pipeline.info;

import com.facebook.imagepipeline.listener.BaseRequestListener;
import javax.annotation.Nullable;

public class ImageOriginRequestListener extends BaseRequestListener {
    private String mControllerId;
    @Nullable
    private final ImageOriginListener mImageOriginLister;

    public ImageOriginRequestListener(String str, @Nullable ImageOriginListener imageOriginListener) {
        this.mImageOriginLister = imageOriginListener;
        init(str);
    }

    public void init(String str) {
        this.mControllerId = str;
    }

    public void onUltimateProducerReached(String str, String str2, boolean z) {
        if (this.mImageOriginLister != null) {
            this.mImageOriginLister.onImageLoaded(this.mControllerId, ImageOriginUtils.mapProducerNameToImageOrigin(str2), z, str2);
        }
    }
}
