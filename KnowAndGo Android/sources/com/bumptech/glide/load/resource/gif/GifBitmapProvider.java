package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public final class GifBitmapProvider implements GifDecoder.BitmapProvider {
    @Nullable
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;

    public GifBitmapProvider(BitmapPool bitmapPool2) {
        this(bitmapPool2, (ArrayPool) null);
    }

    public GifBitmapProvider(BitmapPool bitmapPool2, @Nullable ArrayPool arrayPool2) {
        this.bitmapPool = bitmapPool2;
        this.arrayPool = arrayPool2;
    }

    @NonNull
    public Bitmap obtain(int i, int i2, @NonNull Bitmap.Config config) {
        return this.bitmapPool.getDirty(i, i2, config);
    }

    public void release(@NonNull Bitmap bitmap) {
        this.bitmapPool.put(bitmap);
    }

    @NonNull
    public byte[] obtainByteArray(int i) {
        if (this.arrayPool == null) {
            return new byte[i];
        }
        return (byte[]) this.arrayPool.get(i, byte[].class);
    }

    public void release(@NonNull byte[] bArr) {
        if (this.arrayPool != null) {
            this.arrayPool.put(bArr);
        }
    }

    @NonNull
    public int[] obtainIntArray(int i) {
        if (this.arrayPool == null) {
            return new int[i];
        }
        return (int[]) this.arrayPool.get(i, int[].class);
    }

    public void release(@NonNull int[] iArr) {
        if (this.arrayPool != null) {
            this.arrayPool.put(iArr);
        }
    }
}
