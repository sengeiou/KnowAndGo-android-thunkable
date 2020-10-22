package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(11)
@ThreadSafe
public abstract class DefaultDecoder implements PlatformDecoder {
    private static final int DECODE_BUFFER_SIZE = 16384;
    private static final byte[] EOI_TAIL = {-1, -39};
    private static final Class<?> TAG = DefaultDecoder.class;
    private final BitmapPool mBitmapPool;
    @VisibleForTesting
    final Pools.SynchronizedPool<ByteBuffer> mDecodeBuffers;
    @Nullable
    private final PreverificationHelper mPreverificationHelper;

    public abstract int getBitmapSize(int i, int i2, BitmapFactory.Options options);

    public DefaultDecoder(BitmapPool bitmapPool, int i, Pools.SynchronizedPool synchronizedPool) {
        this.mPreverificationHelper = Build.VERSION.SDK_INT >= 26 ? new PreverificationHelper() : null;
        this.mBitmapPool = bitmapPool;
        this.mDecodeBuffers = synchronizedPool;
        for (int i2 = 0; i2 < i; i2++) {
            this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
        }
    }

    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect) {
        return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, (ColorSpace) null);
    }

    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i) {
        return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i, (ColorSpace) null);
    }

    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, @Nullable ColorSpace colorSpace) {
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        boolean z = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return decodeFromStream(encodedImage.getInputStream(), decodeOptionsForStream, rect, colorSpace);
        } catch (RuntimeException e) {
            if (z) {
                return decodeFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, colorSpace);
            }
            throw e;
        }
    }

    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i, @Nullable ColorSpace colorSpace) {
        boolean isCompleteAt = encodedImage.isCompleteAt(i);
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        InputStream inputStream = encodedImage.getInputStream();
        Preconditions.checkNotNull(inputStream);
        if (encodedImage.getSize() > i) {
            inputStream = new LimitedInputStream(inputStream, i);
        }
        InputStream tailAppendingInputStream = !isCompleteAt ? new TailAppendingInputStream(inputStream, EOI_TAIL) : inputStream;
        boolean z = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return decodeFromStream(tailAppendingInputStream, decodeOptionsForStream, rect, colorSpace);
        } catch (RuntimeException e) {
            if (z) {
                return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, i, colorSpace);
            }
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect) {
        return decodeFromStream(inputStream, options, rect, (ColorSpace) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        com.facebook.common.logging.FLog.m60e(TAG, "Could not decode region %s, decoding full bitmap instead.", r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a1, code lost:
        if (r0 != null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r0.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a7, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00aa, code lost:
        r0.recycle();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0096 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x00ff */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00aa A[Catch:{ IllegalArgumentException -> 0x00df, RuntimeException -> 0x00d6, all -> 0x00d4, IOException -> 0x00ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b1 A[Catch:{ IllegalArgumentException -> 0x00df, RuntimeException -> 0x00d6, all -> 0x00d4, IOException -> 0x00ff }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeFromStream(java.io.InputStream r9, android.graphics.BitmapFactory.Options r10, @javax.annotation.Nullable android.graphics.Rect r11, @javax.annotation.Nullable android.graphics.ColorSpace r12) {
        /*
            r8 = this;
            com.facebook.common.internal.Preconditions.checkNotNull(r9)
            int r0 = r10.outWidth
            int r1 = r10.outHeight
            if (r11 == 0) goto L_0x0017
            int r0 = r11.width()
            int r1 = r10.inSampleSize
            int r0 = r0 / r1
            int r1 = r11.height()
            int r2 = r10.inSampleSize
            int r1 = r1 / r2
        L_0x0017:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            r4 = 1
            r5 = 0
            if (r2 < r3) goto L_0x002f
            com.facebook.imagepipeline.platform.PreverificationHelper r2 = r8.mPreverificationHelper
            if (r2 == 0) goto L_0x002f
            com.facebook.imagepipeline.platform.PreverificationHelper r2 = r8.mPreverificationHelper
            android.graphics.Bitmap$Config r6 = r10.inPreferredConfig
            boolean r2 = r2.shouldUseHardwareBitmapConfig(r6)
            if (r2 == 0) goto L_0x002f
            r2 = 1
            goto L_0x0030
        L_0x002f:
            r2 = 0
        L_0x0030:
            r6 = 0
            if (r11 != 0) goto L_0x0039
            if (r2 == 0) goto L_0x0039
            r10.inMutable = r5
            r2 = r6
            goto L_0x004f
        L_0x0039:
            if (r11 == 0) goto L_0x0041
            if (r2 == 0) goto L_0x0041
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
            r10.inPreferredConfig = r2
        L_0x0041:
            int r2 = r8.getBitmapSize(r0, r1, r10)
            com.facebook.imagepipeline.memory.BitmapPool r7 = r8.mBitmapPool
            java.lang.Object r2 = r7.get(r2)
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            if (r2 == 0) goto L_0x0106
        L_0x004f:
            r10.inBitmap = r2
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r3) goto L_0x005f
            if (r12 != 0) goto L_0x005d
            android.graphics.ColorSpace$Named r12 = android.graphics.ColorSpace.Named.SRGB
            android.graphics.ColorSpace r12 = android.graphics.ColorSpace.get(r12)
        L_0x005d:
            r10.inPreferredColorSpace = r12
        L_0x005f:
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r12 = r8.mDecodeBuffers
            java.lang.Object r12 = r12.acquire()
            java.nio.ByteBuffer r12 = (java.nio.ByteBuffer) r12
            if (r12 != 0) goto L_0x006f
            r12 = 16384(0x4000, float:2.2959E-41)
            java.nio.ByteBuffer r12 = java.nio.ByteBuffer.allocate(r12)
        L_0x006f:
            byte[] r3 = r12.array()     // Catch:{ IllegalArgumentException -> 0x00df, RuntimeException -> 0x00d6 }
            r10.inTempStorage = r3     // Catch:{ IllegalArgumentException -> 0x00df, RuntimeException -> 0x00d6 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ IllegalArgumentException -> 0x00df, RuntimeException -> 0x00d6 }
            r7 = 19
            if (r3 < r7) goto L_0x00ae
            if (r11 == 0) goto L_0x00ae
            if (r2 == 0) goto L_0x00ae
            android.graphics.Bitmap$Config r3 = r10.inPreferredConfig     // Catch:{ IOException -> 0x0095, all -> 0x0092 }
            r2.reconfigure(r0, r1, r3)     // Catch:{ IOException -> 0x0095, all -> 0x0092 }
            android.graphics.BitmapRegionDecoder r0 = android.graphics.BitmapRegionDecoder.newInstance(r9, r4)     // Catch:{ IOException -> 0x0095, all -> 0x0092 }
            android.graphics.Bitmap r1 = r0.decodeRegion(r11, r10)     // Catch:{ IOException -> 0x0096 }
            if (r0 == 0) goto L_0x00af
            r0.recycle()     // Catch:{ IllegalArgumentException -> 0x00df, RuntimeException -> 0x00d6 }
            goto L_0x00af
        L_0x0092:
            r10 = move-exception
            r0 = r6
            goto L_0x00a8
        L_0x0095:
            r0 = r6
        L_0x0096:
            java.lang.Class<?> r1 = TAG     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = "Could not decode region %s, decoding full bitmap instead."
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00a7 }
            r4[r5] = r11     // Catch:{ all -> 0x00a7 }
            com.facebook.common.logging.FLog.m60e((java.lang.Class<?>) r1, (java.lang.String) r3, (java.lang.Object[]) r4)     // Catch:{ all -> 0x00a7 }
            if (r0 == 0) goto L_0x00ae
            r0.recycle()     // Catch:{ IllegalArgumentException -> 0x00df, RuntimeException -> 0x00d6 }
            goto L_0x00ae
        L_0x00a7:
            r10 = move-exception
        L_0x00a8:
            if (r0 == 0) goto L_0x00ad
            r0.recycle()     // Catch:{ IllegalArgumentException -> 0x00df, RuntimeException -> 0x00d6 }
        L_0x00ad:
            throw r10     // Catch:{ IllegalArgumentException -> 0x00df, RuntimeException -> 0x00d6 }
        L_0x00ae:
            r1 = r6
        L_0x00af:
            if (r1 != 0) goto L_0x00b5
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r9, r6, r10)     // Catch:{ IllegalArgumentException -> 0x00df, RuntimeException -> 0x00d6 }
        L_0x00b5:
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r9 = r8.mDecodeBuffers
            r9.release(r12)
            if (r2 == 0) goto L_0x00cd
            if (r2 != r1) goto L_0x00bf
            goto L_0x00cd
        L_0x00bf:
            com.facebook.imagepipeline.memory.BitmapPool r9 = r8.mBitmapPool
            r9.release(r2)
            r1.recycle()
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L_0x00cd:
            com.facebook.imagepipeline.memory.BitmapPool r9 = r8.mBitmapPool
            com.facebook.common.references.CloseableReference r9 = com.facebook.common.references.CloseableReference.m128of(r1, r9)
            return r9
        L_0x00d4:
            r9 = move-exception
            goto L_0x0100
        L_0x00d6:
            r9 = move-exception
            if (r2 == 0) goto L_0x00de
            com.facebook.imagepipeline.memory.BitmapPool r10 = r8.mBitmapPool     // Catch:{ all -> 0x00d4 }
            r10.release(r2)     // Catch:{ all -> 0x00d4 }
        L_0x00de:
            throw r9     // Catch:{ all -> 0x00d4 }
        L_0x00df:
            r10 = move-exception
            if (r2 == 0) goto L_0x00e7
            com.facebook.imagepipeline.memory.BitmapPool r11 = r8.mBitmapPool     // Catch:{ all -> 0x00d4 }
            r11.release(r2)     // Catch:{ all -> 0x00d4 }
        L_0x00e7:
            r9.reset()     // Catch:{ IOException -> 0x00ff }
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeStream(r9)     // Catch:{ IOException -> 0x00ff }
            if (r9 == 0) goto L_0x00fe
            com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser r11 = com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.getInstance()     // Catch:{ IOException -> 0x00ff }
            com.facebook.common.references.CloseableReference r9 = com.facebook.common.references.CloseableReference.m128of(r9, r11)     // Catch:{ IOException -> 0x00ff }
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r10 = r8.mDecodeBuffers
            r10.release(r12)
            return r9
        L_0x00fe:
            throw r10     // Catch:{ IOException -> 0x00ff }
        L_0x00ff:
            throw r10     // Catch:{ all -> 0x00d4 }
        L_0x0100:
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r10 = r8.mDecodeBuffers
            r10.release(r12)
            throw r9
        L_0x0106:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            java.lang.String r10 = "BitmapPool.get returned null"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.platform.DefaultDecoder.decodeFromStream(java.io.InputStream, android.graphics.BitmapFactory$Options, android.graphics.Rect, android.graphics.ColorSpace):com.facebook.common.references.CloseableReference");
    }

    private static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage encodedImage, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage.getSampleSize();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedImage.getInputStream(), (Rect) null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException();
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }
}
