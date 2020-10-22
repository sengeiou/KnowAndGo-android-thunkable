package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ARTShapeShadowNode extends ARTVirtualNode {
    private static final int CAP_BUTT = 0;
    private static final int CAP_ROUND = 1;
    private static final int CAP_SQUARE = 2;
    private static final int COLOR_TYPE_LINEAR_GRADIENT = 1;
    private static final int COLOR_TYPE_PATTERN = 3;
    private static final int COLOR_TYPE_RADIAL_GRADIENT = 2;
    private static final int COLOR_TYPE_SOLID_COLOR = 0;
    private static final int JOIN_BEVEL = 2;
    private static final int JOIN_MITER = 0;
    private static final int JOIN_ROUND = 1;
    private static final int PATH_TYPE_ARC = 4;
    private static final int PATH_TYPE_CLOSE = 1;
    private static final int PATH_TYPE_CURVETO = 3;
    private static final int PATH_TYPE_LINETO = 2;
    private static final int PATH_TYPE_MOVETO = 0;
    @Nullable
    private float[] mBrushData;
    @Nullable
    protected Path mPath;
    private int mStrokeCap = 1;
    @Nullable
    private float[] mStrokeColor;
    @Nullable
    private float[] mStrokeDash;
    private int mStrokeJoin = 1;
    private float mStrokeWidth = 1.0f;

    private float modulus(float f, float f2) {
        float f3 = f % f2;
        return f3 < 0.0f ? f3 + f2 : f3;
    }

    @ReactProp(name = "d")
    public void setShapePath(@Nullable ReadableArray readableArray) {
        this.mPath = createPath(PropHelper.toFloatArray(readableArray));
        markUpdated();
    }

    @ReactProp(name = "stroke")
    public void setStroke(@Nullable ReadableArray readableArray) {
        this.mStrokeColor = PropHelper.toFloatArray(readableArray);
        markUpdated();
    }

    @ReactProp(name = "strokeDash")
    public void setStrokeDash(@Nullable ReadableArray readableArray) {
        this.mStrokeDash = PropHelper.toFloatArray(readableArray);
        markUpdated();
    }

    @ReactProp(name = "fill")
    public void setFill(@Nullable ReadableArray readableArray) {
        this.mBrushData = PropHelper.toFloatArray(readableArray);
        markUpdated();
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
        markUpdated();
    }

    @ReactProp(defaultInt = 1, name = "strokeCap")
    public void setStrokeCap(int i) {
        this.mStrokeCap = i;
        markUpdated();
    }

    @ReactProp(defaultInt = 1, name = "strokeJoin")
    public void setStrokeJoin(int i) {
        this.mStrokeJoin = i;
        markUpdated();
    }

    public void draw(Canvas canvas, Paint paint, float f) {
        float f2 = f * this.mOpacity;
        if (f2 > 0.01f) {
            saveAndSetupCanvas(canvas);
            if (this.mPath != null) {
                if (setupFillPaint(paint, f2)) {
                    canvas.drawPath(this.mPath, paint);
                }
                if (setupStrokePaint(paint, f2)) {
                    canvas.drawPath(this.mPath, paint);
                }
                restoreCanvas(canvas);
            } else {
                throw new JSApplicationIllegalArgumentException("Shapes should have a valid path (d) prop");
            }
        }
        markUpdateSeen();
    }

    /* access modifiers changed from: protected */
    public boolean setupStrokePaint(Paint paint, float f) {
        if (this.mStrokeWidth == 0.0f || this.mStrokeColor == null || this.mStrokeColor.length == 0) {
            return false;
        }
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.STROKE);
        switch (this.mStrokeCap) {
            case 0:
                paint.setStrokeCap(Paint.Cap.BUTT);
                break;
            case 1:
                paint.setStrokeCap(Paint.Cap.ROUND);
                break;
            case 2:
                paint.setStrokeCap(Paint.Cap.SQUARE);
                break;
            default:
                throw new JSApplicationIllegalArgumentException("strokeCap " + this.mStrokeCap + " unrecognized");
        }
        switch (this.mStrokeJoin) {
            case 0:
                paint.setStrokeJoin(Paint.Join.MITER);
                break;
            case 1:
                paint.setStrokeJoin(Paint.Join.ROUND);
                break;
            case 2:
                paint.setStrokeJoin(Paint.Join.BEVEL);
                break;
            default:
                throw new JSApplicationIllegalArgumentException("strokeJoin " + this.mStrokeJoin + " unrecognized");
        }
        paint.setStrokeWidth(this.mStrokeWidth * this.mScale);
        paint.setARGB((int) (this.mStrokeColor.length > 3 ? this.mStrokeColor[3] * f * 255.0f : f * 255.0f), (int) (this.mStrokeColor[0] * 255.0f), (int) (this.mStrokeColor[1] * 255.0f), (int) (this.mStrokeColor[2] * 255.0f));
        if (this.mStrokeDash != null && this.mStrokeDash.length > 0) {
            paint.setPathEffect(new DashPathEffect(this.mStrokeDash, 0.0f));
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setupFillPaint(Paint paint, float f) {
        float f2;
        float f3;
        float[] fArr;
        int[] iArr;
        Paint paint2 = paint;
        int i = 0;
        if (this.mBrushData == null || this.mBrushData.length <= 0) {
            return false;
        }
        paint.reset();
        paint2.setFlags(1);
        paint2.setStyle(Paint.Style.FILL);
        int i2 = (int) this.mBrushData[0];
        float f4 = 255.0f;
        switch (i2) {
            case 0:
                if (this.mBrushData.length > 4) {
                    f2 = 255.0f;
                    f3 = this.mBrushData[4] * f * 255.0f;
                } else {
                    f2 = 255.0f;
                    f3 = f * 255.0f;
                }
                paint2.setARGB((int) f3, (int) (this.mBrushData[1] * f2), (int) (this.mBrushData[2] * f2), (int) (this.mBrushData[3] * f2));
                return true;
            case 1:
                int i3 = 5;
                if (this.mBrushData.length < 5) {
                    FLog.m102w(ReactConstants.TAG, "[ARTShapeShadowNode setupFillPaint] expects 5 elements, received " + this.mBrushData.length);
                    return false;
                }
                float f5 = this.mBrushData[1] * this.mScale;
                float f6 = this.mBrushData[2] * this.mScale;
                float f7 = this.mBrushData[3] * this.mScale;
                float f8 = this.mBrushData[4] * this.mScale;
                int length = (this.mBrushData.length - 5) / 5;
                if (length > 0) {
                    int[] iArr2 = new int[length];
                    float[] fArr2 = new float[length];
                    while (i < length) {
                        fArr2[i] = this.mBrushData[(length * 4) + i3 + i];
                        int i4 = (i * 4) + i3;
                        iArr2[i] = Color.argb((int) (this.mBrushData[i4 + 3] * 255.0f), (int) (this.mBrushData[i4 + 0] * f4), (int) (this.mBrushData[i4 + 1] * f4), (int) (this.mBrushData[i4 + 2] * f4));
                        i++;
                        i3 = 5;
                        f4 = 255.0f;
                    }
                    iArr = iArr2;
                    fArr = fArr2;
                } else {
                    iArr = null;
                    fArr = null;
                }
                paint2.setShader(new LinearGradient(f5, f6, f7, f8, iArr, fArr, Shader.TileMode.CLAMP));
                return true;
            default:
                FLog.m102w(ReactConstants.TAG, "ART: Color type " + i2 + " not supported!");
                return true;
        }
    }

    private Path createPath(float[] fArr) {
        int i;
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        int i2 = 0;
        while (i2 < fArr.length) {
            int i3 = i2 + 1;
            int i4 = (int) fArr[i2];
            switch (i4) {
                case 0:
                    int i5 = i3 + 1;
                    i = i5 + 1;
                    path.moveTo(fArr[i3] * this.mScale, fArr[i5] * this.mScale);
                    break;
                case 1:
                    path.close();
                    i2 = i3;
                    continue;
                case 2:
                    int i6 = i3 + 1;
                    i = i6 + 1;
                    path.lineTo(fArr[i3] * this.mScale, fArr[i6] * this.mScale);
                    break;
                case 3:
                    int i7 = i3 + 1;
                    float f = fArr[i3] * this.mScale;
                    int i8 = i7 + 1;
                    float f2 = this.mScale * fArr[i7];
                    int i9 = i8 + 1;
                    float f3 = this.mScale * fArr[i8];
                    int i10 = i9 + 1;
                    float f4 = this.mScale * fArr[i9];
                    int i11 = i10 + 1;
                    path.cubicTo(f, f2, f3, f4, this.mScale * fArr[i10], fArr[i11] * this.mScale);
                    i2 = i11 + 1;
                    continue;
                case 4:
                    int i12 = i3 + 1;
                    float f5 = fArr[i3] * this.mScale;
                    int i13 = i12 + 1;
                    float f6 = fArr[i12] * this.mScale;
                    int i14 = i13 + 1;
                    float f7 = fArr[i13] * this.mScale;
                    int i15 = i14 + 1;
                    float degrees = (float) Math.toDegrees((double) fArr[i14]);
                    int i16 = i15 + 1;
                    float degrees2 = (float) Math.toDegrees((double) fArr[i15]);
                    int i17 = i16 + 1;
                    boolean z = fArr[i16] != 1.0f;
                    float f8 = degrees2 - degrees;
                    if (Math.abs(f8) >= 360.0f) {
                        path.addCircle(f5, f6, f7, z ? Path.Direction.CCW : Path.Direction.CW);
                    } else {
                        float modulus = modulus(f8, 360.0f);
                        if (z && modulus < 360.0f) {
                            modulus = (360.0f - modulus) * -1.0f;
                        }
                        path.arcTo(new RectF(f5 - f7, f6 - f7, f5 + f7, f6 + f7), degrees, modulus);
                    }
                    i2 = i17;
                    continue;
                default:
                    throw new JSApplicationIllegalArgumentException("Unrecognized drawing instruction " + i4);
            }
            i2 = i;
        }
        return path;
    }
}
