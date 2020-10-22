package com.theartofdev.edmodo.cropper;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;

final class CropImageAnimation extends Animation implements Animation.AnimationListener {
    private final float[] mAnimMatrix = new float[9];
    private final float[] mAnimPoints = new float[8];
    private final RectF mAnimRect = new RectF();
    private final CropOverlayView mCropOverlayView;
    private final float[] mEndBoundPoints = new float[8];
    private final RectF mEndCropWindowRect = new RectF();
    private final float[] mEndImageMatrix = new float[9];
    private final ImageView mImageView;
    private final float[] mStartBoundPoints = new float[8];
    private final RectF mStartCropWindowRect = new RectF();
    private final float[] mStartImageMatrix = new float[9];

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }

    public CropImageAnimation(ImageView imageView, CropOverlayView cropOverlayView) {
        this.mImageView = imageView;
        this.mCropOverlayView = cropOverlayView;
        setDuration(300);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
    }

    public void setStartState(float[] fArr, Matrix matrix) {
        reset();
        System.arraycopy(fArr, 0, this.mStartBoundPoints, 0, 8);
        this.mStartCropWindowRect.set(this.mCropOverlayView.getCropWindowRect());
        matrix.getValues(this.mStartImageMatrix);
    }

    public void setEndState(float[] fArr, Matrix matrix) {
        System.arraycopy(fArr, 0, this.mEndBoundPoints, 0, 8);
        this.mEndCropWindowRect.set(this.mCropOverlayView.getCropWindowRect());
        matrix.getValues(this.mEndImageMatrix);
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f, Transformation transformation) {
        this.mAnimRect.left = this.mStartCropWindowRect.left + ((this.mEndCropWindowRect.left - this.mStartCropWindowRect.left) * f);
        this.mAnimRect.top = this.mStartCropWindowRect.top + ((this.mEndCropWindowRect.top - this.mStartCropWindowRect.top) * f);
        this.mAnimRect.right = this.mStartCropWindowRect.right + ((this.mEndCropWindowRect.right - this.mStartCropWindowRect.right) * f);
        this.mAnimRect.bottom = this.mStartCropWindowRect.bottom + ((this.mEndCropWindowRect.bottom - this.mStartCropWindowRect.bottom) * f);
        this.mCropOverlayView.setCropWindowRect(this.mAnimRect);
        for (int i = 0; i < this.mAnimPoints.length; i++) {
            this.mAnimPoints[i] = this.mStartBoundPoints[i] + ((this.mEndBoundPoints[i] - this.mStartBoundPoints[i]) * f);
        }
        this.mCropOverlayView.setBounds(this.mAnimPoints, this.mImageView.getWidth(), this.mImageView.getHeight());
        for (int i2 = 0; i2 < this.mAnimMatrix.length; i2++) {
            this.mAnimMatrix[i2] = this.mStartImageMatrix[i2] + ((this.mEndImageMatrix[i2] - this.mStartImageMatrix[i2]) * f);
        }
        Matrix imageMatrix = this.mImageView.getImageMatrix();
        imageMatrix.setValues(this.mAnimMatrix);
        this.mImageView.setImageMatrix(imageMatrix);
        this.mImageView.invalidate();
        this.mCropOverlayView.invalidate();
    }

    public void onAnimationEnd(Animation animation) {
        this.mImageView.clearAnimation();
    }
}
