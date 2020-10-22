package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ARTTextShadowNode extends ARTShapeShadowNode {
    private static final int DEFAULT_FONT_SIZE = 12;
    private static final String PROP_FONT = "font";
    private static final String PROP_FONT_FAMILY = "fontFamily";
    private static final String PROP_FONT_SIZE = "fontSize";
    private static final String PROP_FONT_STYLE = "fontStyle";
    private static final String PROP_FONT_WEIGHT = "fontWeight";
    private static final String PROP_LINES = "lines";
    private static final int TEXT_ALIGNMENT_CENTER = 2;
    private static final int TEXT_ALIGNMENT_LEFT = 0;
    private static final int TEXT_ALIGNMENT_RIGHT = 1;
    @Nullable
    private ReadableMap mFrame;
    private int mTextAlignment = 0;

    @ReactProp(name = "frame")
    public void setFrame(@Nullable ReadableMap readableMap) {
        this.mFrame = readableMap;
    }

    @ReactProp(defaultInt = 0, name = "alignment")
    public void setAlignment(int i) {
        this.mTextAlignment = i;
    }

    public void draw(Canvas canvas, Paint paint, float f) {
        ReadableArray array;
        if (this.mFrame != null) {
            float f2 = f * this.mOpacity;
            if (f2 > 0.01f && this.mFrame.hasKey(PROP_LINES) && (array = this.mFrame.getArray(PROP_LINES)) != null && array.size() != 0) {
                saveAndSetupCanvas(canvas);
                String[] strArr = new String[array.size()];
                for (int i = 0; i < strArr.length; i++) {
                    strArr[i] = array.getString(i);
                }
                String join = TextUtils.join("\n", strArr);
                if (setupStrokePaint(paint, f2)) {
                    applyTextPropertiesToPaint(paint);
                    if (this.mPath == null) {
                        canvas.drawText(join, 0.0f, -paint.ascent(), paint);
                    } else {
                        canvas.drawTextOnPath(join, this.mPath, 0.0f, 0.0f, paint);
                    }
                }
                if (setupFillPaint(paint, f2)) {
                    applyTextPropertiesToPaint(paint);
                    if (this.mPath == null) {
                        canvas.drawText(join, 0.0f, -paint.ascent(), paint);
                    } else {
                        canvas.drawTextOnPath(join, this.mPath, 0.0f, 0.0f, paint);
                    }
                }
                restoreCanvas(canvas);
                markUpdateSeen();
            }
        }
    }

    private void applyTextPropertiesToPaint(Paint paint) {
        ReadableMap map;
        switch (this.mTextAlignment) {
            case 0:
                paint.setTextAlign(Paint.Align.LEFT);
                break;
            case 1:
                paint.setTextAlign(Paint.Align.RIGHT);
                break;
            case 2:
                paint.setTextAlign(Paint.Align.CENTER);
                break;
        }
        if (this.mFrame != null && this.mFrame.hasKey(PROP_FONT) && (map = this.mFrame.getMap(PROP_FONT)) != null) {
            float f = 12.0f;
            if (map.hasKey("fontSize")) {
                f = (float) map.getDouble("fontSize");
            }
            paint.setTextSize(f * this.mScale);
            int i = 1;
            boolean z = map.hasKey("fontWeight") && TtmlNode.BOLD.equals(map.getString("fontWeight"));
            boolean z2 = map.hasKey("fontStyle") && TtmlNode.ITALIC.equals(map.getString("fontStyle"));
            if (z && z2) {
                i = 3;
            } else if (!z) {
                i = z2 ? 2 : 0;
            }
            paint.setTypeface(Typeface.create(map.getString("fontFamily"), i));
        }
    }
}
