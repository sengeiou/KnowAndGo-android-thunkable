package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.annotations.ReactProp;

public abstract class ARTVirtualNode extends ReactShadowNodeImpl {
    protected static final float MIN_OPACITY_FOR_DRAW = 0.01f;
    private static final float[] sMatrixData = new float[9];
    private static final float[] sRawMatrix = new float[9];
    @Nullable
    private Matrix mMatrix = new Matrix();
    protected float mOpacity = 1.0f;
    protected final float mScale = DisplayMetricsHolder.getWindowDisplayMetrics().density;

    public abstract void draw(Canvas canvas, Paint paint, float f);

    public boolean isVirtual() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void saveAndSetupCanvas(Canvas canvas) {
        canvas.save();
        if (this.mMatrix != null) {
            canvas.concat(this.mMatrix);
        }
    }

    /* access modifiers changed from: protected */
    public void restoreCanvas(Canvas canvas) {
        canvas.restore();
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(float f) {
        this.mOpacity = f;
        markUpdated();
    }

    @ReactProp(name = "transform")
    public void setTransform(@Nullable ReadableArray readableArray) {
        if (readableArray != null) {
            int floatArray = PropHelper.toFloatArray(readableArray, sMatrixData);
            if (floatArray == 6) {
                setupMatrix();
            } else if (floatArray != -1) {
                throw new JSApplicationIllegalArgumentException("Transform matrices must be of size 6");
            }
        } else {
            this.mMatrix = null;
        }
        markUpdated();
    }

    /* access modifiers changed from: protected */
    public void setupMatrix() {
        sRawMatrix[0] = sMatrixData[0];
        sRawMatrix[1] = sMatrixData[2];
        sRawMatrix[2] = sMatrixData[4] * this.mScale;
        sRawMatrix[3] = sMatrixData[1];
        sRawMatrix[4] = sMatrixData[3];
        sRawMatrix[5] = sMatrixData[5] * this.mScale;
        sRawMatrix[6] = 0.0f;
        sRawMatrix[7] = 0.0f;
        sRawMatrix[8] = 1.0f;
        if (this.mMatrix == null) {
            this.mMatrix = new Matrix();
        }
        this.mMatrix.setValues(sRawMatrix);
    }
}
