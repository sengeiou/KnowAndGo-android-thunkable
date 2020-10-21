package expo.modules.lineargradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.TypedValue;
import android.view.View;
import java.util.ArrayList;

public class LinearGradientView extends View {
    private float[] mBorderRadii = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    private int[] mColors;
    private float[] mEndPos = {0.0f, 1.0f};
    private float[] mLocations;
    private final Paint mPaint = new Paint(1);
    private Path mPathForBorderRadius;
    private int[] mSize = {0, 0};
    private float[] mStartPos = {0.0f, 0.0f};
    private RectF mTempRectForBorderRadius;

    public LinearGradientView(Context context) {
        super(context);
    }

    public void setStartPosition(ArrayList<Double> arrayList) {
        this.mStartPos = new float[]{arrayList.get(0).floatValue(), arrayList.get(1).floatValue()};
        drawGradient();
    }

    public void setEndPosition(ArrayList<Double> arrayList) {
        this.mEndPos = new float[]{arrayList.get(0).floatValue(), arrayList.get(1).floatValue()};
        drawGradient();
    }

    public void setColors(ArrayList<Double> arrayList) {
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = arrayList.get(i).intValue();
        }
        this.mColors = iArr;
        drawGradient();
    }

    public void setLocations(ArrayList<Double> arrayList) {
        float[] fArr = new float[arrayList.size()];
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = arrayList.get(i).floatValue();
        }
        this.mLocations = fArr;
        drawGradient();
    }

    public void setBorderRadii(ArrayList<Double> arrayList) {
        float[] fArr = new float[arrayList.size()];
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = toPixelFromDIP(arrayList.get(i).floatValue());
        }
        this.mBorderRadii = fArr;
        updatePath();
        drawGradient();
    }

    private float toPixelFromDIP(float f) {
        return TypedValue.applyDimension(1, f, getContext().getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mSize = new int[]{i, i2};
        updatePath();
        drawGradient();
    }

    private void drawGradient() {
        if (this.mColors == null) {
            return;
        }
        if (this.mLocations == null || this.mColors.length == this.mLocations.length) {
            this.mPaint.setShader(new LinearGradient(((float) this.mSize[0]) * this.mStartPos[0], this.mStartPos[1] * ((float) this.mSize[1]), this.mEndPos[0] * ((float) this.mSize[0]), this.mEndPos[1] * ((float) this.mSize[1]), this.mColors, this.mLocations, Shader.TileMode.CLAMP));
            invalidate();
        }
    }

    private void updatePath() {
        if (this.mPathForBorderRadius == null) {
            this.mPathForBorderRadius = new Path();
            this.mTempRectForBorderRadius = new RectF();
        }
        this.mPathForBorderRadius.reset();
        this.mTempRectForBorderRadius.set(0.0f, 0.0f, (float) this.mSize[0], (float) this.mSize[1]);
        this.mPathForBorderRadius.addRoundRect(this.mTempRectForBorderRadius, this.mBorderRadii, Path.Direction.CW);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPathForBorderRadius == null) {
            canvas.drawPaint(this.mPaint);
        } else {
            canvas.drawPath(this.mPathForBorderRadius, this.mPaint);
        }
    }
}
