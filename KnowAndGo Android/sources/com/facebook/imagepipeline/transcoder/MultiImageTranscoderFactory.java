package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.core.NativeCodeSetup;
import com.facebook.imagepipeline.nativecode.NativeImageTranscoderFactory;
import javax.annotation.Nullable;

public class MultiImageTranscoderFactory implements ImageTranscoderFactory {
    @Nullable
    private final Integer mImageTranscoderType;
    private final int mMaxBitmapSize;
    @Nullable
    private final ImageTranscoderFactory mPrimaryImageTranscoderFactory;
    private final boolean mUseDownSamplingRatio;

    public MultiImageTranscoderFactory(int i, boolean z, @Nullable ImageTranscoderFactory imageTranscoderFactory, @Nullable Integer num) {
        this.mMaxBitmapSize = i;
        this.mUseDownSamplingRatio = z;
        this.mPrimaryImageTranscoderFactory = imageTranscoderFactory;
        this.mImageTranscoderType = num;
    }

    public ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z) {
        ImageTranscoder customImageTranscoder = getCustomImageTranscoder(imageFormat, z);
        if (customImageTranscoder == null) {
            customImageTranscoder = getImageTranscoderWithType(imageFormat, z);
        }
        if (customImageTranscoder == null && NativeCodeSetup.getUseNativeCode()) {
            customImageTranscoder = getNativeImageTranscoder(imageFormat, z);
        }
        return customImageTranscoder == null ? getSimpleImageTranscoder(imageFormat, z) : customImageTranscoder;
    }

    @Nullable
    private ImageTranscoder getCustomImageTranscoder(ImageFormat imageFormat, boolean z) {
        if (this.mPrimaryImageTranscoderFactory == null) {
            return null;
        }
        return this.mPrimaryImageTranscoderFactory.createImageTranscoder(imageFormat, z);
    }

    @Nullable
    private ImageTranscoder getNativeImageTranscoder(ImageFormat imageFormat, boolean z) {
        return NativeImageTranscoderFactory.getNativeImageTranscoderFactory(this.mMaxBitmapSize, this.mUseDownSamplingRatio).createImageTranscoder(imageFormat, z);
    }

    private ImageTranscoder getSimpleImageTranscoder(ImageFormat imageFormat, boolean z) {
        return new SimpleImageTranscoderFactory(this.mMaxBitmapSize).createImageTranscoder(imageFormat, z);
    }

    @Nullable
    private ImageTranscoder getImageTranscoderWithType(ImageFormat imageFormat, boolean z) {
        if (this.mImageTranscoderType == null) {
            return null;
        }
        switch (this.mImageTranscoderType.intValue()) {
            case 0:
                return getNativeImageTranscoder(imageFormat, z);
            case 1:
                return getSimpleImageTranscoder(imageFormat, z);
            default:
                throw new IllegalArgumentException("Invalid ImageTranscoderType");
        }
    }
}
