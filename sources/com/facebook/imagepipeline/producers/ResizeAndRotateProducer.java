package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class ResizeAndRotateProducer implements Producer<EncodedImage> {
    private static final String INPUT_IMAGE_FORMAT = "Image format";
    @VisibleForTesting
    static final int MIN_TRANSFORM_INTERVAL_MS = 100;
    private static final String ORIGINAL_SIZE_KEY = "Original size";
    private static final String PRODUCER_NAME = "ResizeAndRotateProducer";
    private static final String REQUESTED_SIZE_KEY = "Requested size";
    private static final String TRANSCODER_ID = "Transcoder id";
    private static final String TRANSCODING_RESULT = "Transcoding result";
    /* access modifiers changed from: private */
    public final Executor mExecutor;
    private final ImageTranscoderFactory mImageTranscoderFactory;
    private final Producer<EncodedImage> mInputProducer;
    private final boolean mIsResizingEnabled;
    /* access modifiers changed from: private */
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    /* JADX WARNING: type inference failed for: r3v0, types: [com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ResizeAndRotateProducer(java.util.concurrent.Executor r1, com.facebook.common.memory.PooledByteBufferFactory r2, com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> r3, boolean r4, com.facebook.imagepipeline.transcoder.ImageTranscoderFactory r5) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r1)
            java.util.concurrent.Executor r1 = (java.util.concurrent.Executor) r1
            r0.mExecutor = r1
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r2)
            com.facebook.common.memory.PooledByteBufferFactory r1 = (com.facebook.common.memory.PooledByteBufferFactory) r1
            r0.mPooledByteBufferFactory = r1
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r3)
            com.facebook.imagepipeline.producers.Producer r1 = (com.facebook.imagepipeline.producers.Producer) r1
            r0.mInputProducer = r1
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r5)
            com.facebook.imagepipeline.transcoder.ImageTranscoderFactory r1 = (com.facebook.imagepipeline.transcoder.ImageTranscoderFactory) r1
            r0.mImageTranscoderFactory = r1
            r0.mIsResizingEnabled = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.<init>(java.util.concurrent.Executor, com.facebook.common.memory.PooledByteBufferFactory, com.facebook.imagepipeline.producers.Producer, boolean, com.facebook.imagepipeline.transcoder.ImageTranscoderFactory):void");
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new TransformingConsumer(consumer, producerContext, this.mIsResizingEnabled, this.mImageTranscoderFactory), producerContext);
    }

    private class TransformingConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        /* access modifiers changed from: private */
        public final ImageTranscoderFactory mImageTranscoderFactory;
        /* access modifiers changed from: private */
        public boolean mIsCancelled = false;
        /* access modifiers changed from: private */
        public final boolean mIsResizingEnabled;
        /* access modifiers changed from: private */
        public final JobScheduler mJobScheduler;
        /* access modifiers changed from: private */
        public final ProducerContext mProducerContext;

        TransformingConsumer(final Consumer<EncodedImage> consumer, ProducerContext producerContext, boolean z, ImageTranscoderFactory imageTranscoderFactory) {
            super(consumer);
            this.mProducerContext = producerContext;
            Boolean resizingAllowedOverride = this.mProducerContext.getImageRequest().getResizingAllowedOverride();
            this.mIsResizingEnabled = resizingAllowedOverride != null ? resizingAllowedOverride.booleanValue() : z;
            this.mImageTranscoderFactory = imageTranscoderFactory;
            this.mJobScheduler = new JobScheduler(ResizeAndRotateProducer.this.mExecutor, new JobScheduler.JobRunnable(ResizeAndRotateProducer.this) {
                public void run(EncodedImage encodedImage, int i) {
                    TransformingConsumer.this.doTransform(encodedImage, i, (ImageTranscoder) Preconditions.checkNotNull(TransformingConsumer.this.mImageTranscoderFactory.createImageTranscoder(encodedImage.getImageFormat(), TransformingConsumer.this.mIsResizingEnabled)));
                }
            }, 100);
            this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks(ResizeAndRotateProducer.this) {
                public void onIsIntermediateResultExpectedChanged() {
                    if (TransformingConsumer.this.mProducerContext.isIntermediateResultExpected()) {
                        TransformingConsumer.this.mJobScheduler.scheduleJob();
                    }
                }

                public void onCancellationRequested() {
                    TransformingConsumer.this.mJobScheduler.clearJob();
                    boolean unused = TransformingConsumer.this.mIsCancelled = true;
                    consumer.onCancellation();
                }
            });
        }

        /* access modifiers changed from: protected */
        public void onNewResultImpl(@Nullable EncodedImage encodedImage, int i) {
            if (!this.mIsCancelled) {
                boolean isLast = isLast(i);
                if (encodedImage != null) {
                    ImageFormat imageFormat = encodedImage.getImageFormat();
                    TriState access$700 = ResizeAndRotateProducer.shouldTransform(this.mProducerContext.getImageRequest(), encodedImage, (ImageTranscoder) Preconditions.checkNotNull(this.mImageTranscoderFactory.createImageTranscoder(imageFormat, this.mIsResizingEnabled)));
                    if (!isLast && access$700 == TriState.UNSET) {
                        return;
                    }
                    if (access$700 != TriState.YES) {
                        forwardNewResult(encodedImage, i, imageFormat);
                    } else if (this.mJobScheduler.updateJob(encodedImage, i)) {
                        if (isLast || this.mProducerContext.isIntermediateResultExpected()) {
                            this.mJobScheduler.scheduleJob();
                        }
                    }
                } else if (isLast) {
                    getConsumer().onNewResult(null, 1);
                }
            }
        }

        private void forwardNewResult(EncodedImage encodedImage, int i, ImageFormat imageFormat) {
            EncodedImage encodedImage2;
            if (imageFormat == DefaultImageFormats.JPEG || imageFormat == DefaultImageFormats.HEIF) {
                encodedImage2 = getNewResultsForJpegOrHeif(encodedImage);
            } else {
                encodedImage2 = getNewResultForImagesWithoutExifData(encodedImage);
            }
            getConsumer().onNewResult(encodedImage2, i);
        }

        @Nullable
        private EncodedImage getNewResultForImagesWithoutExifData(EncodedImage encodedImage) {
            RotationOptions rotationOptions = this.mProducerContext.getImageRequest().getRotationOptions();
            return (rotationOptions.useImageMetadata() || !rotationOptions.rotationEnabled()) ? encodedImage : getCloneWithRotationApplied(encodedImage, rotationOptions.getForcedAngle());
        }

        @Nullable
        private EncodedImage getNewResultsForJpegOrHeif(EncodedImage encodedImage) {
            return (this.mProducerContext.getImageRequest().getRotationOptions().canDeferUntilRendered() || encodedImage.getRotationAngle() == 0 || encodedImage.getRotationAngle() == -1) ? encodedImage : getCloneWithRotationApplied(encodedImage, 0);
        }

        @Nullable
        private EncodedImage getCloneWithRotationApplied(EncodedImage encodedImage, int i) {
            EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
            if (cloneOrNull != null) {
                cloneOrNull.setRotationAngle(i);
            }
            return cloneOrNull;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00ae A[Catch:{ all -> 0x0098 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void doTransform(com.facebook.imagepipeline.image.EncodedImage r11, int r12, com.facebook.imagepipeline.transcoder.ImageTranscoder r13) {
            /*
                r10 = this;
                com.facebook.imagepipeline.producers.ProducerContext r0 = r10.mProducerContext
                com.facebook.imagepipeline.producers.ProducerListener2 r0 = r0.getProducerListener()
                com.facebook.imagepipeline.producers.ProducerContext r1 = r10.mProducerContext
                java.lang.String r2 = "ResizeAndRotateProducer"
                r0.onProducerStart(r1, r2)
                com.facebook.imagepipeline.producers.ProducerContext r0 = r10.mProducerContext
                com.facebook.imagepipeline.request.ImageRequest r0 = r0.getImageRequest()
                com.facebook.imagepipeline.producers.ResizeAndRotateProducer r1 = com.facebook.imagepipeline.producers.ResizeAndRotateProducer.this
                com.facebook.common.memory.PooledByteBufferFactory r1 = r1.mPooledByteBufferFactory
                com.facebook.common.memory.PooledByteBufferOutputStream r1 = r1.newOutputStream()
                r9 = 0
                com.facebook.imagepipeline.common.RotationOptions r5 = r0.getRotationOptions()     // Catch:{ Exception -> 0x009a }
                com.facebook.imagepipeline.common.ResizeOptions r6 = r0.getResizeOptions()     // Catch:{ Exception -> 0x009a }
                r7 = 0
                r2 = 85
                java.lang.Integer r8 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x009a }
                r2 = r13
                r3 = r11
                r4 = r1
                com.facebook.imagepipeline.transcoder.ImageTranscodeResult r2 = r2.transcode(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x009a }
                int r3 = r2.getTranscodeStatus()     // Catch:{ Exception -> 0x009a }
                r4 = 2
                if (r3 == r4) goto L_0x0090
                com.facebook.imagepipeline.common.ResizeOptions r0 = r0.getResizeOptions()     // Catch:{ Exception -> 0x009a }
                java.lang.String r13 = r13.getIdentifier()     // Catch:{ Exception -> 0x009a }
                java.util.Map r11 = r10.getExtraMap(r11, r0, r2, r13)     // Catch:{ Exception -> 0x009a }
                com.facebook.common.memory.PooledByteBuffer r13 = r1.toByteBuffer()     // Catch:{ Exception -> 0x008d }
                com.facebook.common.references.CloseableReference r13 = com.facebook.common.references.CloseableReference.m126of(r13)     // Catch:{ Exception -> 0x008d }
                com.facebook.imagepipeline.image.EncodedImage r0 = new com.facebook.imagepipeline.image.EncodedImage     // Catch:{ all -> 0x0088 }
                r0.<init>((com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>) r13)     // Catch:{ all -> 0x0088 }
                com.facebook.imageformat.ImageFormat r3 = com.facebook.imageformat.DefaultImageFormats.JPEG     // Catch:{ all -> 0x0088 }
                r0.setImageFormat(r3)     // Catch:{ all -> 0x0088 }
                r0.parseMetaData()     // Catch:{ all -> 0x0083 }
                com.facebook.imagepipeline.producers.ProducerContext r3 = r10.mProducerContext     // Catch:{ all -> 0x0083 }
                com.facebook.imagepipeline.producers.ProducerListener2 r3 = r3.getProducerListener()     // Catch:{ all -> 0x0083 }
                com.facebook.imagepipeline.producers.ProducerContext r4 = r10.mProducerContext     // Catch:{ all -> 0x0083 }
                java.lang.String r5 = "ResizeAndRotateProducer"
                r3.onProducerFinishWithSuccess(r4, r5, r11)     // Catch:{ all -> 0x0083 }
                int r2 = r2.getTranscodeStatus()     // Catch:{ all -> 0x0083 }
                r3 = 1
                if (r2 == r3) goto L_0x0072
                r12 = r12 | 16
            L_0x0072:
                com.facebook.imagepipeline.producers.Consumer r2 = r10.getConsumer()     // Catch:{ all -> 0x0083 }
                r2.onNewResult(r0, r12)     // Catch:{ all -> 0x0083 }
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(r0)     // Catch:{ all -> 0x0088 }
                com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r13)     // Catch:{ Exception -> 0x008d }
                r1.close()
                return
            L_0x0083:
                r2 = move-exception
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(r0)     // Catch:{ all -> 0x0088 }
                throw r2     // Catch:{ all -> 0x0088 }
            L_0x0088:
                r0 = move-exception
                com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r13)     // Catch:{ Exception -> 0x008d }
                throw r0     // Catch:{ Exception -> 0x008d }
            L_0x008d:
                r13 = move-exception
                r9 = r11
                goto L_0x009b
            L_0x0090:
                java.lang.RuntimeException r11 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x009a }
                java.lang.String r13 = "Error while transcoding the image"
                r11.<init>(r13)     // Catch:{ Exception -> 0x009a }
                throw r11     // Catch:{ Exception -> 0x009a }
            L_0x0098:
                r11 = move-exception
                goto L_0x00b9
            L_0x009a:
                r13 = move-exception
            L_0x009b:
                com.facebook.imagepipeline.producers.ProducerContext r11 = r10.mProducerContext     // Catch:{ all -> 0x0098 }
                com.facebook.imagepipeline.producers.ProducerListener2 r11 = r11.getProducerListener()     // Catch:{ all -> 0x0098 }
                com.facebook.imagepipeline.producers.ProducerContext r0 = r10.mProducerContext     // Catch:{ all -> 0x0098 }
                java.lang.String r2 = "ResizeAndRotateProducer"
                r11.onProducerFinishWithFailure(r0, r2, r13, r9)     // Catch:{ all -> 0x0098 }
                boolean r11 = isLast(r12)     // Catch:{ all -> 0x0098 }
                if (r11 == 0) goto L_0x00b5
                com.facebook.imagepipeline.producers.Consumer r11 = r10.getConsumer()     // Catch:{ all -> 0x0098 }
                r11.onFailure(r13)     // Catch:{ all -> 0x0098 }
            L_0x00b5:
                r1.close()
                return
            L_0x00b9:
                r1.close()
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.doTransform(com.facebook.imagepipeline.image.EncodedImage, int, com.facebook.imagepipeline.transcoder.ImageTranscoder):void");
        }

        @Nullable
        private Map<String, String> getExtraMap(EncodedImage encodedImage, @Nullable ResizeOptions resizeOptions, @Nullable ImageTranscodeResult imageTranscodeResult, @Nullable String str) {
            String str2;
            if (!this.mProducerContext.getProducerListener().requiresExtraMap(this.mProducerContext, ResizeAndRotateProducer.PRODUCER_NAME)) {
                return null;
            }
            String str3 = encodedImage.getWidth() + "x" + encodedImage.getHeight();
            if (resizeOptions != null) {
                str2 = resizeOptions.width + "x" + resizeOptions.height;
            } else {
                str2 = "Unspecified";
            }
            HashMap hashMap = new HashMap();
            hashMap.put(ResizeAndRotateProducer.INPUT_IMAGE_FORMAT, String.valueOf(encodedImage.getImageFormat()));
            hashMap.put(ResizeAndRotateProducer.ORIGINAL_SIZE_KEY, str3);
            hashMap.put(ResizeAndRotateProducer.REQUESTED_SIZE_KEY, str2);
            hashMap.put("queueTime", String.valueOf(this.mJobScheduler.getQueuedTime()));
            hashMap.put(ResizeAndRotateProducer.TRANSCODER_ID, str);
            hashMap.put(ResizeAndRotateProducer.TRANSCODING_RESULT, String.valueOf(imageTranscodeResult));
            return ImmutableMap.copyOf(hashMap);
        }
    }

    /* access modifiers changed from: private */
    public static TriState shouldTransform(ImageRequest imageRequest, EncodedImage encodedImage, ImageTranscoder imageTranscoder) {
        if (encodedImage == null || encodedImage.getImageFormat() == ImageFormat.UNKNOWN) {
            return TriState.UNSET;
        }
        if (!imageTranscoder.canTranscode(encodedImage.getImageFormat())) {
            return TriState.NO;
        }
        return TriState.valueOf(shouldRotate(imageRequest.getRotationOptions(), encodedImage) || imageTranscoder.canResize(encodedImage, imageRequest.getRotationOptions(), imageRequest.getResizeOptions()));
    }

    private static boolean shouldRotate(RotationOptions rotationOptions, EncodedImage encodedImage) {
        return !rotationOptions.canDeferUntilRendered() && (JpegTranscoderUtils.getRotationAngle(rotationOptions, encodedImage) != 0 || shouldRotateUsingExifOrientation(rotationOptions, encodedImage));
    }

    private static boolean shouldRotateUsingExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        if (rotationOptions.rotationEnabled() && !rotationOptions.canDeferUntilRendered()) {
            return JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()));
        }
        encodedImage.setExifOrientation(0);
        return false;
    }
}
