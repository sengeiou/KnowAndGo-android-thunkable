package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Arrays;

public abstract class RoundedDrawable extends Drawable implements Rounded, TransformAwareDrawable {
    @VisibleForTesting
    final RectF mBitmapBounds = new RectF();
    protected int mBorderColor = 0;
    protected final Path mBorderPath = new Path();
    @VisibleForTesting
    final float[] mBorderRadii = new float[8];
    protected float mBorderWidth = 0.0f;
    @VisibleForTesting
    final Matrix mBoundsTransform = new Matrix();
    private final float[] mCornerRadii = new float[8];
    private final Drawable mDelegate;
    @VisibleForTesting
    final RectF mDrawableBounds = new RectF();
    @VisibleForTesting
    @Nullable
    RectF mInsideBorderBounds;
    @VisibleForTesting
    @Nullable
    float[] mInsideBorderRadii;
    @VisibleForTesting
    @Nullable
    Matrix mInsideBorderTransform;
    @VisibleForTesting
    final Matrix mInverseParentTransform = new Matrix();
    protected boolean mIsCircle = false;
    private boolean mIsPathDirty = true;
    protected boolean mIsShaderTransformDirty = true;
    private float mPadding = 0.0f;
    private boolean mPaintFilterBitmap = false;
    @VisibleForTesting
    final Matrix mParentTransform = new Matrix();
    protected final Path mPath = new Path();
    @VisibleForTesting
    final Matrix mPrevBoundsTransform = new Matrix();
    @VisibleForTesting
    @Nullable
    Matrix mPrevInsideBorderTransform;
    @VisibleForTesting
    final Matrix mPrevParentTransform = new Matrix();
    @VisibleForTesting
    final RectF mPrevRootBounds = new RectF();
    protected boolean mRadiiNonZero = false;
    @VisibleForTesting
    final RectF mRootBounds = new RectF();
    private boolean mScaleDownInsideBorders = false;
    @VisibleForTesting
    final Matrix mTransform = new Matrix();
    @Nullable
    private TransformCallback mTransformCallback;

    RoundedDrawable(Drawable drawable) {
        this.mDelegate = drawable;
    }

    public void setCircle(boolean z) {
        this.mIsCircle = z;
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    public boolean isCircle() {
        return this.mIsCircle;
    }

    public void setRadius(float f) {
        boolean z = false;
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        Preconditions.checkState(i >= 0);
        Arrays.fill(this.mCornerRadii, f);
        if (i != 0) {
            z = true;
        }
        this.mRadiiNonZero = z;
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    public void setRadii(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.mCornerRadii, 0.0f);
            this.mRadiiNonZero = false;
        } else {
            Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mCornerRadii, 0, 8);
            this.mRadiiNonZero = false;
            for (int i = 0; i < 8; i++) {
                this.mRadiiNonZero |= fArr[i] > 0.0f;
            }
        }
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    public float[] getRadii() {
        return this.mCornerRadii;
    }

    public void setBorder(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.mIsPathDirty = true;
            invalidateSelf();
        }
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public void setPadding(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.mIsPathDirty = true;
            invalidateSelf();
        }
    }

    public float getPadding() {
        return this.mPadding;
    }

    public void setScaleDownInsideBorders(boolean z) {
        if (this.mScaleDownInsideBorders != z) {
            this.mScaleDownInsideBorders = z;
            this.mIsPathDirty = true;
            invalidateSelf();
        }
    }

    public boolean getScaleDownInsideBorders() {
        return this.mScaleDownInsideBorders;
    }

    public void setPaintFilterBitmap(boolean z) {
        if (this.mPaintFilterBitmap != z) {
            this.mPaintFilterBitmap = z;
            invalidateSelf();
        }
    }

    public boolean getPaintFilterBitmap() {
        return this.mPaintFilterBitmap;
    }

    public void setTransformCallback(@Nullable TransformCallback transformCallback) {
        this.mTransformCallback = transformCallback;
    }

    /* access modifiers changed from: protected */
    public void updateTransform() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.mParentTransform);
            this.mTransformCallback.getRootBounds(this.mRootBounds);
        } else {
            this.mParentTransform.reset();
            this.mRootBounds.set(getBounds());
        }
        this.mBitmapBounds.set(0.0f, 0.0f, (float) getIntrinsicWidth(), (float) getIntrinsicHeight());
        this.mDrawableBounds.set(this.mDelegate.getBounds());
        this.mBoundsTransform.setRectToRect(this.mBitmapBounds, this.mDrawableBounds, Matrix.ScaleToFit.FILL);
        if (this.mScaleDownInsideBorders) {
            if (this.mInsideBorderBounds == null) {
                this.mInsideBorderBounds = new RectF(this.mRootBounds);
            } else {
                this.mInsideBorderBounds.set(this.mRootBounds);
            }
            this.mInsideBorderBounds.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.mInsideBorderTransform == null) {
                this.mInsideBorderTransform = new Matrix();
            }
            this.mInsideBorderTransform.setRectToRect(this.mRootBounds, this.mInsideBorderBounds, Matrix.ScaleToFit.FILL);
        } else if (this.mInsideBorderTransform != null) {
            this.mInsideBorderTransform.reset();
        }
        if (!this.mParentTransform.equals(this.mPrevParentTransform) || !this.mBoundsTransform.equals(this.mPrevBoundsTransform) || (this.mInsideBorderTransform != null && !this.mInsideBorderTransform.equals(this.mPrevInsideBorderTransform))) {
            this.mIsShaderTransformDirty = true;
            this.mParentTransform.invert(this.mInverseParentTransform);
            this.mTransform.set(this.mParentTransform);
            if (this.mScaleDownInsideBorders) {
                this.mTransform.postConcat(this.mInsideBorderTransform);
            }
            this.mTransform.preConcat(this.mBoundsTransform);
            this.mPrevParentTransform.set(this.mParentTransform);
            this.mPrevBoundsTransform.set(this.mBoundsTransform);
            if (this.mScaleDownInsideBorders) {
                if (this.mPrevInsideBorderTransform == null) {
                    this.mPrevInsideBorderTransform = new Matrix(this.mInsideBorderTransform);
                } else {
                    this.mPrevInsideBorderTransform.set(this.mInsideBorderTransform);
                }
            } else if (this.mPrevInsideBorderTransform != null) {
                this.mPrevInsideBorderTransform.reset();
            }
        }
        if (!this.mRootBounds.equals(this.mPrevRootBounds)) {
            this.mIsPathDirty = true;
            this.mPrevRootBounds.set(this.mRootBounds);
        }
    }

    /* access modifiers changed from: protected */
    public void updatePath() {
        if (this.mIsPathDirty) {
            this.mBorderPath.reset();
            this.mRootBounds.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.mIsCircle) {
                this.mBorderPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.mBorderRadii.length; i++) {
                    this.mBorderRadii[i] = (this.mCornerRadii[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.mBorderPath.addRoundRect(this.mRootBounds, this.mBorderRadii, Path.Direction.CW);
            }
            this.mRootBounds.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.mScaleDownInsideBorders ? this.mBorderWidth : 0.0f);
            this.mRootBounds.inset(f, f);
            if (this.mIsCircle) {
                this.mPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0f, Path.Direction.CW);
            } else if (this.mScaleDownInsideBorders) {
                if (this.mInsideBorderRadii == null) {
                    this.mInsideBorderRadii = new float[8];
                }
                for (int i2 = 0; i2 < this.mBorderRadii.length; i2++) {
                    this.mInsideBorderRadii[i2] = this.mCornerRadii[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.mRootBounds, this.mInsideBorderRadii, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.mRootBounds, this.mCornerRadii, Path.Direction.CW);
            }
            float f2 = -f;
            this.mRootBounds.inset(f2, f2);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.mIsPathDirty = false;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean shouldRound() {
        return this.mIsCircle || this.mRadiiNonZero || this.mBorderWidth > 0.0f;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.mDelegate.setBounds(rect);
    }

    public int getIntrinsicWidth() {
        return this.mDelegate.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.mDelegate.getIntrinsicHeight();
    }

    public int getOpacity() {
        return this.mDelegate.getOpacity();
    }

    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.mDelegate.setColorFilter(i, mode);
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mDelegate.setColorFilter(colorFilter);
    }

    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.mDelegate.getColorFilter();
    }

    public void clearColorFilter() {
        this.mDelegate.clearColorFilter();
    }

    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.mDelegate.getAlpha();
    }

    public void setAlpha(int i) {
        this.mDelegate.setAlpha(i);
    }

    public void draw(@NonNull Canvas canvas) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("RoundedDrawable#draw");
        }
        this.mDelegate.draw(canvas);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }
}
