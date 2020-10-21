package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;

public class ForwardingDrawable extends Drawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable, DrawableParent {
    private static final Matrix sTempTransform = new Matrix();
    @Nullable
    private Drawable mCurrentDelegate;
    private final DrawableProperties mDrawableProperties = new DrawableProperties();
    protected TransformCallback mTransformCallback;

    public ForwardingDrawable(@Nullable Drawable drawable) {
        this.mCurrentDelegate = drawable;
        DrawableUtils.setCallbacks(this.mCurrentDelegate, this, this);
    }

    @Nullable
    public Drawable setCurrent(@Nullable Drawable drawable) {
        Drawable currentWithoutInvalidate = setCurrentWithoutInvalidate(drawable);
        invalidateSelf();
        return currentWithoutInvalidate;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Drawable setCurrentWithoutInvalidate(@Nullable Drawable drawable) {
        Drawable drawable2 = this.mCurrentDelegate;
        DrawableUtils.setCallbacks(drawable2, (Drawable.Callback) null, (TransformCallback) null);
        DrawableUtils.setCallbacks(drawable, (Drawable.Callback) null, (TransformCallback) null);
        DrawableUtils.setDrawableProperties(drawable, this.mDrawableProperties);
        DrawableUtils.copyProperties(drawable, this);
        DrawableUtils.setCallbacks(drawable, this, this);
        this.mCurrentDelegate = drawable;
        return drawable2;
    }

    public int getOpacity() {
        if (this.mCurrentDelegate == null) {
            return 0;
        }
        return this.mCurrentDelegate.getOpacity();
    }

    public void setAlpha(int i) {
        this.mDrawableProperties.setAlpha(i);
        if (this.mCurrentDelegate != null) {
            this.mCurrentDelegate.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.mCurrentDelegate != null) {
            this.mCurrentDelegate.setColorFilter(colorFilter);
        }
    }

    public void setDither(boolean z) {
        this.mDrawableProperties.setDither(z);
        if (this.mCurrentDelegate != null) {
            this.mCurrentDelegate.setDither(z);
        }
    }

    public void setFilterBitmap(boolean z) {
        this.mDrawableProperties.setFilterBitmap(z);
        if (this.mCurrentDelegate != null) {
            this.mCurrentDelegate.setFilterBitmap(z);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.mCurrentDelegate == null) {
            return visible;
        }
        return this.mCurrentDelegate.setVisible(z, z2);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.mCurrentDelegate != null) {
            this.mCurrentDelegate.setBounds(rect);
        }
    }

    @Nullable
    public Drawable.ConstantState getConstantState() {
        if (this.mCurrentDelegate == null) {
            return super.getConstantState();
        }
        return this.mCurrentDelegate.getConstantState();
    }

    public boolean isStateful() {
        if (this.mCurrentDelegate == null) {
            return false;
        }
        return this.mCurrentDelegate.isStateful();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.mCurrentDelegate == null) {
            return super.onStateChange(iArr);
        }
        return this.mCurrentDelegate.setState(iArr);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        if (this.mCurrentDelegate == null) {
            return super.onLevelChange(i);
        }
        return this.mCurrentDelegate.setLevel(i);
    }

    public void draw(Canvas canvas) {
        if (this.mCurrentDelegate != null) {
            this.mCurrentDelegate.draw(canvas);
        }
    }

    public int getIntrinsicWidth() {
        if (this.mCurrentDelegate == null) {
            return super.getIntrinsicWidth();
        }
        return this.mCurrentDelegate.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.mCurrentDelegate == null) {
            return super.getIntrinsicHeight();
        }
        return this.mCurrentDelegate.getIntrinsicHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.mCurrentDelegate == null) {
            return super.getPadding(rect);
        }
        return this.mCurrentDelegate.getPadding(rect);
    }

    public Drawable mutate() {
        if (this.mCurrentDelegate != null) {
            this.mCurrentDelegate.mutate();
        }
        return this;
    }

    @Nullable
    public Drawable getCurrent() {
        return this.mCurrentDelegate;
    }

    public Drawable setDrawable(@Nullable Drawable drawable) {
        return setCurrent(drawable);
    }

    @Nullable
    public Drawable getDrawable() {
        return getCurrent();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public void setTransformCallback(TransformCallback transformCallback) {
        this.mTransformCallback = transformCallback;
    }

    /* access modifiers changed from: protected */
    public void getParentTransform(Matrix matrix) {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(matrix);
        } else {
            matrix.reset();
        }
    }

    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
    }

    public void getRootBounds(RectF rectF) {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getRootBounds(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    public void getTransformedBounds(RectF rectF) {
        getParentTransform(sTempTransform);
        rectF.set(getBounds());
        sTempTransform.mapRect(rectF);
    }

    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        if (this.mCurrentDelegate != null) {
            this.mCurrentDelegate.setHotspot(f, f2);
        }
    }
}
