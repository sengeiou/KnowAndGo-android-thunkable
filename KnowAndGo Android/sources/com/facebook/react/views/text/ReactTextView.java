package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.p005os.EnvironmentCompat;
import androidx.core.view.GravityCompat;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewBackgroundManager;

public class ReactTextView extends AppCompatTextView implements ReactCompoundView {
    private static final ViewGroup.LayoutParams EMPTY_LAYOUT_PARAMS = new ViewGroup.LayoutParams(0, 0);
    private boolean mAdjustsFontSizeToFit = false;
    private boolean mContainsImages;
    private int mDefaultGravityHorizontal = (getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK);
    private int mDefaultGravityVertical = (getGravity() & 112);
    private TextUtils.TruncateAt mEllipsizeLocation = TextUtils.TruncateAt.END;
    private int mLinkifyMaskType = 0;
    private boolean mNotifyOnInlineViewLayout;
    private int mNumberOfLines = Integer.MAX_VALUE;
    private ReactViewBackgroundManager mReactBackgroundManager = new ReactViewBackgroundManager(this);
    private Spannable mSpanned;
    private int mTextAlign = 0;

    public boolean hasOverlappingRendering() {
        return false;
    }

    public ReactTextView(Context context) {
        super(context);
    }

    private WritableMap inlineViewJson(int i, int i2, int i3, int i4, int i5, int i6) {
        WritableMap createMap = Arguments.createMap();
        if (i == 8) {
            createMap.putString("visibility", "gone");
            createMap.putInt("index", i2);
        } else if (i == 0) {
            createMap.putString("visibility", ViewProps.VISIBLE);
            createMap.putInt("index", i2);
            createMap.putDouble("left", (double) PixelUtil.toDIPFromPixel((float) i3));
            createMap.putDouble(ViewProps.TOP, (double) PixelUtil.toDIPFromPixel((float) i4));
            createMap.putDouble("right", (double) PixelUtil.toDIPFromPixel((float) i5));
            createMap.putDouble(ViewProps.BOTTOM, (double) PixelUtil.toDIPFromPixel((float) i6));
        } else {
            createMap.putString("visibility", EnvironmentCompat.MEDIA_UNKNOWN);
            createMap.putInt("index", i2);
        }
        return createMap;
    }

    private ReactContext getReactContext() {
        Context context = getContext();
        if (context instanceof TintContextWrapper) {
            context = ((TintContextWrapper) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x016c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            r22 = this;
            r7 = r22
            java.lang.CharSequence r0 = r22.getText()
            boolean r0 = r0 instanceof android.text.Spanned
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            com.facebook.react.bridge.ReactContext r8 = r22.getReactContext()
            boolean r0 = r8.hasCatalystInstance()
            if (r0 != 0) goto L_0x0016
            return
        L_0x0016:
            java.lang.Class<com.facebook.react.uimanager.UIManagerModule> r0 = com.facebook.react.uimanager.UIManagerModule.class
            com.facebook.react.bridge.NativeModule r0 = r8.getNativeModule(r0)
            r9 = r0
            com.facebook.react.uimanager.UIManagerModule r9 = (com.facebook.react.uimanager.UIManagerModule) r9
            java.lang.CharSequence r0 = r22.getText()
            r10 = r0
            android.text.Spanned r10 = (android.text.Spanned) r10
            android.text.Layout r11 = r22.getLayout()
            int r0 = r10.length()
            java.lang.Class<com.facebook.react.views.text.TextInlineViewPlaceholderSpan> r1 = com.facebook.react.views.text.TextInlineViewPlaceholderSpan.class
            r12 = 0
            java.lang.Object[] r0 = r10.getSpans(r12, r0, r1)
            r13 = r0
            com.facebook.react.views.text.TextInlineViewPlaceholderSpan[] r13 = (com.facebook.react.views.text.TextInlineViewPlaceholderSpan[]) r13
            boolean r0 = r7.mNotifyOnInlineViewLayout
            if (r0 == 0) goto L_0x0044
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r13.length
            r0.<init>(r1)
        L_0x0042:
            r6 = r0
            goto L_0x0046
        L_0x0044:
            r0 = 0
            goto L_0x0042
        L_0x0046:
            int r5 = r26 - r24
            int r4 = r27 - r25
            int r3 = r13.length
            r2 = 0
        L_0x004c:
            if (r2 >= r3) goto L_0x017a
            r0 = r13[r2]
            int r1 = r0.getReactTag()
            android.view.View r1 = r9.resolveView(r1)
            int r12 = r10.getSpanStart(r0)
            r14 = r2
            int r2 = r11.getLineForOffset(r12)
            int r15 = r11.getEllipsisCount(r2)
            r16 = 1
            if (r15 <= 0) goto L_0x006d
            r17 = r3
            r15 = 1
            goto L_0x0070
        L_0x006d:
            r17 = r3
            r15 = 0
        L_0x0070:
            if (r15 == 0) goto L_0x008e
            int r15 = r11.getLineStart(r2)
            int r18 = r11.getEllipsisStart(r2)
            int r3 = r15 + r18
            if (r12 >= r3) goto L_0x007f
            goto L_0x008e
        L_0x007f:
            r16 = r4
            r20 = r9
            r21 = r13
            r9 = r14
            r15 = r17
            r0 = 8
            r14 = r5
            r13 = r6
            goto L_0x0155
        L_0x008e:
            int r3 = r7.mNumberOfLines
            if (r2 >= r3) goto L_0x0148
            int r3 = r11.getLineEnd(r2)
            if (r12 < r3) goto L_0x0099
            goto L_0x007f
        L_0x0099:
            int r3 = r0.getWidth()
            int r0 = r0.getHeight()
            r19 = r6
            boolean r6 = r11.isRtlCharAt(r12)
            r20 = r9
            int r9 = r11.getParagraphDirection(r2)
            r21 = r13
            r13 = -1
            if (r9 != r13) goto L_0x00b4
            r9 = 1
            goto L_0x00b5
        L_0x00b4:
            r9 = 0
        L_0x00b5:
            int r13 = r10.length()
            int r13 = r13 + -1
            if (r12 != r13) goto L_0x00ce
            if (r9 == 0) goto L_0x00c7
            float r9 = r11.getLineWidth(r2)
            int r9 = (int) r9
            int r9 = r5 - r9
            goto L_0x00ef
        L_0x00c7:
            float r9 = r11.getLineRight(r2)
            int r9 = (int) r9
            int r9 = r9 - r3
            goto L_0x00ef
        L_0x00ce:
            if (r9 != r6) goto L_0x00d2
            r13 = 1
            goto L_0x00d3
        L_0x00d2:
            r13 = 0
        L_0x00d3:
            if (r13 == 0) goto L_0x00db
            float r13 = r11.getPrimaryHorizontal(r12)
            int r13 = (int) r13
            goto L_0x00e0
        L_0x00db:
            float r13 = r11.getSecondaryHorizontal(r12)
            int r13 = (int) r13
        L_0x00e0:
            if (r9 == 0) goto L_0x00eb
            float r9 = r11.getLineRight(r2)
            int r9 = (int) r9
            int r9 = r9 - r13
            int r9 = r5 - r9
            goto L_0x00ec
        L_0x00eb:
            r9 = r13
        L_0x00ec:
            if (r6 == 0) goto L_0x00ef
            int r9 = r9 - r3
        L_0x00ef:
            if (r6 == 0) goto L_0x00f7
            int r6 = r22.getTotalPaddingRight()
            int r9 = r9 + r6
            goto L_0x00fc
        L_0x00f7:
            int r6 = r22.getTotalPaddingLeft()
            int r9 = r9 + r6
        L_0x00fc:
            int r6 = r24 + r9
            int r13 = r22.getTotalPaddingTop()
            int r2 = r11.getLineBaseline(r2)
            int r13 = r13 + r2
            int r13 = r13 - r0
            int r2 = r25 + r13
            if (r5 <= r9) goto L_0x0111
            if (r4 > r13) goto L_0x010f
            goto L_0x0111
        L_0x010f:
            r16 = 0
        L_0x0111:
            if (r16 == 0) goto L_0x0116
            r9 = 8
            goto L_0x0117
        L_0x0116:
            r9 = 0
        L_0x0117:
            int r13 = r6 + r3
            int r3 = r2 + r0
            r1.setVisibility(r9)
            r1.layout(r6, r2, r13, r3)
            boolean r0 = r7.mNotifyOnInlineViewLayout
            if (r0 == 0) goto L_0x013f
            r0 = r22
            r1 = r9
            r9 = r14
            r14 = r2
            r2 = r12
            r12 = r3
            r15 = r17
            r3 = r6
            r16 = r4
            r4 = r14
            r14 = r5
            r5 = r13
            r13 = r19
            r6 = r12
            com.facebook.react.bridge.WritableMap r0 = r0.inlineViewJson(r1, r2, r3, r4, r5, r6)
            r13.add(r0)
            goto L_0x016c
        L_0x013f:
            r16 = r4
            r9 = r14
            r15 = r17
            r13 = r19
            r14 = r5
            goto L_0x016c
        L_0x0148:
            r16 = r4
            r20 = r9
            r21 = r13
            r9 = r14
            r15 = r17
            r14 = r5
            r13 = r6
            r0 = 8
        L_0x0155:
            r1.setVisibility(r0)
            boolean r0 = r7.mNotifyOnInlineViewLayout
            if (r0 == 0) goto L_0x016c
            r1 = 8
            r3 = -1
            r4 = -1
            r5 = -1
            r6 = -1
            r0 = r22
            r2 = r12
            com.facebook.react.bridge.WritableMap r0 = r0.inlineViewJson(r1, r2, r3, r4, r5, r6)
            r13.add(r0)
        L_0x016c:
            int r2 = r9 + 1
            r6 = r13
            r5 = r14
            r3 = r15
            r4 = r16
            r9 = r20
            r13 = r21
            r12 = 0
            goto L_0x004c
        L_0x017a:
            r13 = r6
            boolean r0 = r7.mNotifyOnInlineViewLayout
            if (r0 == 0) goto L_0x01b9
            com.facebook.react.views.text.ReactTextView$1 r0 = new com.facebook.react.views.text.ReactTextView$1
            r0.<init>()
            java.util.Collections.sort(r13, r0)
            com.facebook.react.bridge.WritableArray r0 = com.facebook.react.bridge.Arguments.createArray()
            java.util.Iterator r1 = r13.iterator()
        L_0x018f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x019f
            java.lang.Object r2 = r1.next()
            com.facebook.react.bridge.WritableMap r2 = (com.facebook.react.bridge.WritableMap) r2
            r0.pushMap(r2)
            goto L_0x018f
        L_0x019f:
            com.facebook.react.bridge.WritableMap r1 = com.facebook.react.bridge.Arguments.createMap()
            java.lang.String r2 = "inlineViews"
            r1.putArray(r2, r0)
            java.lang.Class<com.facebook.react.uimanager.events.RCTEventEmitter> r0 = com.facebook.react.uimanager.events.RCTEventEmitter.class
            com.facebook.react.bridge.JavaScriptModule r0 = r8.getJSModule(r0)
            com.facebook.react.uimanager.events.RCTEventEmitter r0 = (com.facebook.react.uimanager.events.RCTEventEmitter) r0
            int r2 = r22.getId()
            java.lang.String r3 = "topInlineViewLayout"
            r0.receiveEvent(r2, r3, r1)
        L_0x01b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextView.onLayout(boolean, int, int, int, int):void");
    }

    public void setText(ReactTextUpdate reactTextUpdate) {
        int i;
        this.mContainsImages = reactTextUpdate.containsImages();
        if (getLayoutParams() == null) {
            setLayoutParams(EMPTY_LAYOUT_PARAMS);
        }
        Spannable text = reactTextUpdate.getText();
        if (this.mLinkifyMaskType > 0) {
            Linkify.addLinks(text, this.mLinkifyMaskType);
            setMovementMethod(LinkMovementMethod.getInstance());
        }
        setText(text);
        float paddingLeft = reactTextUpdate.getPaddingLeft();
        float paddingTop = reactTextUpdate.getPaddingTop();
        float paddingRight = reactTextUpdate.getPaddingRight();
        float paddingBottom = reactTextUpdate.getPaddingBottom();
        if (!(paddingLeft == -1.0f || paddingBottom == -1.0f || paddingRight == -1.0f || i == 0)) {
            setPadding((int) Math.floor((double) paddingLeft), (int) Math.floor((double) paddingTop), (int) Math.floor((double) paddingRight), (int) Math.floor((double) paddingBottom));
        }
        int textAlign = reactTextUpdate.getTextAlign();
        if (this.mTextAlign != textAlign) {
            this.mTextAlign = textAlign;
        }
        setGravityHorizontal(this.mTextAlign);
        if (Build.VERSION.SDK_INT >= 23 && getBreakStrategy() != reactTextUpdate.getTextBreakStrategy()) {
            setBreakStrategy(reactTextUpdate.getTextBreakStrategy());
        }
        if (Build.VERSION.SDK_INT >= 26 && getJustificationMode() != reactTextUpdate.getJustificationMode()) {
            setJustificationMode(reactTextUpdate.getJustificationMode());
        }
        requestLayout();
    }

    public int reactTagForTouch(float f, float f2) {
        int i;
        CharSequence text = getText();
        int id = getId();
        int i2 = (int) f;
        int i3 = (int) f2;
        Layout layout = getLayout();
        if (layout == null) {
            return id;
        }
        int lineForVertical = layout.getLineForVertical(i3);
        int lineLeft = (int) layout.getLineLeft(lineForVertical);
        int lineRight = (int) layout.getLineRight(lineForVertical);
        if ((text instanceof Spanned) && i2 >= lineLeft && i2 <= lineRight) {
            Spanned spanned = (Spanned) text;
            try {
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, (float) i2);
                ReactTagSpan[] reactTagSpanArr = (ReactTagSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ReactTagSpan.class);
                if (reactTagSpanArr != null) {
                    int length = text.length();
                    for (int i4 = 0; i4 < reactTagSpanArr.length; i4++) {
                        int spanStart = spanned.getSpanStart(reactTagSpanArr[i4]);
                        int spanEnd = spanned.getSpanEnd(reactTagSpanArr[i4]);
                        if (spanEnd > offsetForHorizontal && (i = spanEnd - spanStart) <= length) {
                            id = reactTagSpanArr[i4].getReactTag();
                            length = i;
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                FLog.m62e(ReactConstants.TAG, "Crash in HorizontalMeasurementProvider: " + e.getMessage());
                return id;
            }
        }
        return id;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan drawable2 : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (drawable2.getDrawable() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan drawable2 : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (drawable2.getDrawable() == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onDetachedFromWindow : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onDetachedFromWindow.onDetachedFromWindow();
            }
        }
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onStartTemporaryDetach : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onStartTemporaryDetach.onStartTemporaryDetach();
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onAttachedToWindow : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onAttachedToWindow.onAttachedToWindow();
            }
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onFinishTemporaryDetach : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onFinishTemporaryDetach.onFinishTemporaryDetach();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setGravityHorizontal(int i) {
        if (i == 0) {
            i = this.mDefaultGravityHorizontal;
        }
        setGravity(i | (getGravity() & -8 & -8388616));
    }

    /* access modifiers changed from: package-private */
    public void setGravityVertical(int i) {
        if (i == 0) {
            i = this.mDefaultGravityVertical;
        }
        setGravity(i | (getGravity() & -113));
    }

    public void setNumberOfLines(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        this.mNumberOfLines = i;
        boolean z = true;
        if (this.mNumberOfLines != 1) {
            z = false;
        }
        setSingleLine(z);
        setMaxLines(this.mNumberOfLines);
    }

    public void setAdjustFontSizeToFit(boolean z) {
        this.mAdjustsFontSizeToFit = z;
    }

    public void setEllipsizeLocation(TextUtils.TruncateAt truncateAt) {
        this.mEllipsizeLocation = truncateAt;
    }

    public void setNotifyOnInlineViewLayout(boolean z) {
        this.mNotifyOnInlineViewLayout = z;
    }

    public void updateView() {
        setEllipsize((this.mNumberOfLines == Integer.MAX_VALUE || this.mAdjustsFontSizeToFit) ? null : this.mEllipsizeLocation);
    }

    public void setBackgroundColor(int i) {
        this.mReactBackgroundManager.setBackgroundColor(i);
    }

    public void setBorderWidth(int i, float f) {
        this.mReactBackgroundManager.setBorderWidth(i, f);
    }

    public void setBorderColor(int i, float f, float f2) {
        this.mReactBackgroundManager.setBorderColor(i, f, f2);
    }

    public void setBorderRadius(float f) {
        this.mReactBackgroundManager.setBorderRadius(f);
    }

    public void setBorderRadius(float f, int i) {
        this.mReactBackgroundManager.setBorderRadius(f, i);
    }

    public void setBorderStyle(@Nullable String str) {
        this.mReactBackgroundManager.setBorderStyle(str);
    }

    public void setSpanned(Spannable spannable) {
        this.mSpanned = spannable;
    }

    public Spannable getSpanned() {
        return this.mSpanned;
    }

    public void setLinkifyMask(int i) {
        this.mLinkifyMaskType = i;
    }
}
