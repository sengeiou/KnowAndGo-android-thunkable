package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.extractor.p012ts.TsExtractor;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    @NonNull
    private static final Paint DEBUG_DRAW_PAINT = null;
    private static final boolean USE_SCALING_TEXTURE = (Build.VERSION.SDK_INT < 18);
    private boolean boundsChanged;
    @NonNull
    private final Rect collapsedBounds;
    private float collapsedDrawX;
    private float collapsedDrawY;
    private CancelableFontCallback collapsedFontCallback;
    private ColorStateList collapsedShadowColor;
    private float collapsedShadowDx;
    private float collapsedShadowDy;
    private float collapsedShadowRadius;
    private ColorStateList collapsedTextColor;
    private int collapsedTextGravity = 16;
    private float collapsedTextSize = 15.0f;
    private Typeface collapsedTypeface;
    @NonNull
    private final RectF currentBounds;
    private float currentDrawX;
    private float currentDrawY;
    private float currentTextSize;
    private Typeface currentTypeface;
    private boolean drawTitle;
    @NonNull
    private final Rect expandedBounds;
    private float expandedDrawX;
    private float expandedDrawY;
    private CancelableFontCallback expandedFontCallback;
    private float expandedFraction;
    private ColorStateList expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private ColorStateList expandedTextColor;
    private int expandedTextGravity = 16;
    private float expandedTextSize = 15.0f;
    @Nullable
    private Bitmap expandedTitleTexture;
    private Typeface expandedTypeface;
    private boolean isRtl;
    private TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;
    @Nullable
    private CharSequence text;
    @NonNull
    private final TextPaint textPaint;
    private TimeInterpolator textSizeInterpolator;
    @Nullable
    private CharSequence textToDraw;
    private float textureAscent;
    private float textureDescent;
    private Paint texturePaint;
    @NonNull
    private final TextPaint tmpPaint;
    private boolean useTexture;
    private final View view;

    static {
        if (DEBUG_DRAW_PAINT != null) {
            DEBUG_DRAW_PAINT.setAntiAlias(true);
            DEBUG_DRAW_PAINT.setColor(-65281);
        }
    }

    public CollapsingTextHelper(View view2) {
        this.view = view2;
        this.textPaint = new TextPaint(TsExtractor.TS_STREAM_TYPE_AC3);
        this.tmpPaint = new TextPaint(this.textPaint);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) {
        this.textSizeInterpolator = timeInterpolator;
        recalculate();
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) {
        this.positionInterpolator = timeInterpolator;
        recalculate();
    }

    public void setExpandedTextSize(float f) {
        if (this.expandedTextSize != f) {
            this.expandedTextSize = f;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f) {
        if (this.collapsedTextSize != f) {
            this.collapsedTextSize = f;
            recalculate();
        }
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.expandedTextColor != colorStateList) {
            this.expandedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedBounds(int i, int i2, int i3, int i4) {
        if (!rectEquals(this.expandedBounds, i, i2, i3, i4)) {
            this.expandedBounds.set(i, i2, i3, i4);
            this.boundsChanged = true;
            onBoundsChanged();
        }
    }

    public void setExpandedBounds(@NonNull Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setCollapsedBounds(int i, int i2, int i3, int i4) {
        if (!rectEquals(this.collapsedBounds, i, i2, i3, i4)) {
            this.collapsedBounds.set(i, i2, i3, i4);
            this.boundsChanged = true;
            onBoundsChanged();
        }
    }

    public void setCollapsedBounds(@NonNull Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void getCollapsedTextActualBounds(@NonNull RectF rectF) {
        float f;
        boolean calculateIsRtl = calculateIsRtl(this.text);
        if (!calculateIsRtl) {
            f = (float) this.collapsedBounds.left;
        } else {
            f = ((float) this.collapsedBounds.right) - calculateCollapsedTextWidth();
        }
        rectF.left = f;
        rectF.top = (float) this.collapsedBounds.top;
        rectF.right = !calculateIsRtl ? rectF.left + calculateCollapsedTextWidth() : (float) this.collapsedBounds.right;
        rectF.bottom = ((float) this.collapsedBounds.top) + getCollapsedTextHeight();
    }

    public float calculateCollapsedTextWidth() {
        if (this.text == null) {
            return 0.0f;
        }
        getTextPaintCollapsed(this.tmpPaint);
        return this.tmpPaint.measureText(this.text, 0, this.text.length());
    }

    public float getExpandedTextHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getCollapsedTextHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    private void getTextPaintExpanded(@NonNull TextPaint textPaint2) {
        textPaint2.setTextSize(this.expandedTextSize);
        textPaint2.setTypeface(this.expandedTypeface);
    }

    private void getTextPaintCollapsed(@NonNull TextPaint textPaint2) {
        textPaint2.setTextSize(this.collapsedTextSize);
        textPaint2.setTypeface(this.collapsedTypeface);
    }

    /* access modifiers changed from: package-private */
    public void onBoundsChanged() {
        this.drawTitle = this.collapsedBounds.width() > 0 && this.collapsedBounds.height() > 0 && this.expandedBounds.width() > 0 && this.expandedBounds.height() > 0;
    }

    public void setExpandedTextGravity(int i) {
        if (this.expandedTextGravity != i) {
            this.expandedTextGravity = i;
            recalculate();
        }
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public void setCollapsedTextGravity(int i) {
        if (this.collapsedTextGravity != i) {
            this.collapsedTextGravity = i;
            recalculate();
        }
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public void setCollapsedTextAppearance(int i) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i);
        if (textAppearance.textColor != null) {
            this.collapsedTextColor = textAppearance.textColor;
        }
        if (textAppearance.textSize != 0.0f) {
            this.collapsedTextSize = textAppearance.textSize;
        }
        if (textAppearance.shadowColor != null) {
            this.collapsedShadowColor = textAppearance.shadowColor;
        }
        this.collapsedShadowDx = textAppearance.shadowDx;
        this.collapsedShadowDy = textAppearance.shadowDy;
        this.collapsedShadowRadius = textAppearance.shadowRadius;
        if (this.collapsedFontCallback != null) {
            this.collapsedFontCallback.cancel();
        }
        this.collapsedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() {
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setCollapsedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setExpandedTextAppearance(int i) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i);
        if (textAppearance.textColor != null) {
            this.expandedTextColor = textAppearance.textColor;
        }
        if (textAppearance.textSize != 0.0f) {
            this.expandedTextSize = textAppearance.textSize;
        }
        if (textAppearance.shadowColor != null) {
            this.expandedShadowColor = textAppearance.shadowColor;
        }
        this.expandedShadowDx = textAppearance.shadowDx;
        this.expandedShadowDy = textAppearance.shadowDy;
        this.expandedShadowRadius = textAppearance.shadowRadius;
        if (this.expandedFontCallback != null) {
            this.expandedFontCallback.cancel();
        }
        this.expandedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() {
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setExpandedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (setCollapsedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (setExpandedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setTypefaces(Typeface typeface) {
        boolean collapsedTypefaceInternal = setCollapsedTypefaceInternal(typeface);
        boolean expandedTypefaceInternal = setExpandedTypefaceInternal(typeface);
        if (collapsedTypefaceInternal || expandedTypefaceInternal) {
            recalculate();
        }
    }

    private boolean setCollapsedTypefaceInternal(Typeface typeface) {
        if (this.collapsedFontCallback != null) {
            this.collapsedFontCallback.cancel();
        }
        if (this.collapsedTypeface == typeface) {
            return false;
        }
        this.collapsedTypeface = typeface;
        return true;
    }

    private boolean setExpandedTypefaceInternal(Typeface typeface) {
        if (this.expandedFontCallback != null) {
            this.expandedFontCallback.cancel();
        }
        if (this.expandedTypeface == typeface) {
            return false;
        }
        this.expandedTypeface = typeface;
        return true;
    }

    public Typeface getCollapsedTypeface() {
        return this.collapsedTypeface != null ? this.collapsedTypeface : Typeface.DEFAULT;
    }

    public Typeface getExpandedTypeface() {
        return this.expandedTypeface != null ? this.expandedTypeface : Typeface.DEFAULT;
    }

    public void setExpansionFraction(float f) {
        float clamp = MathUtils.clamp(f, 0.0f, 1.0f);
        if (clamp != this.expandedFraction) {
            this.expandedFraction = clamp;
            calculateCurrentOffsets();
        }
    }

    public final boolean setState(int[] iArr) {
        this.state = iArr;
        if (!isStateful()) {
            return false;
        }
        recalculate();
        return true;
    }

    public final boolean isStateful() {
        return (this.collapsedTextColor != null && this.collapsedTextColor.isStateful()) || (this.expandedTextColor != null && this.expandedTextColor.isStateful());
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private void calculateOffsets(float f) {
        interpolateBounds(f);
        this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f, this.positionInterpolator);
        this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
        setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f, this.textSizeInterpolator));
        if (this.collapsedTextColor != this.expandedTextColor) {
            this.textPaint.setColor(blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), f));
        } else {
            this.textPaint.setColor(getCurrentCollapsedTextColor());
        }
        this.textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f, (TimeInterpolator) null), lerp(this.expandedShadowDx, this.collapsedShadowDx, f, (TimeInterpolator) null), lerp(this.expandedShadowDy, this.collapsedShadowDy, f, (TimeInterpolator) null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f));
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    @ColorInt
    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    @ColorInt
    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    @ColorInt
    private int getCurrentColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        if (this.state != null) {
            return colorStateList.getColorForState(this.state, 0);
        }
        return colorStateList.getDefaultColor();
    }

    private void calculateBaseOffsets() {
        float f = this.currentTextSize;
        calculateUsingTextSize(this.collapsedTextSize);
        float f2 = 0.0f;
        float measureText = this.textToDraw != null ? this.textPaint.measureText(this.textToDraw, 0, this.textToDraw.length()) : 0.0f;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        int i = absoluteGravity & 112;
        if (i == 48) {
            this.collapsedDrawY = ((float) this.collapsedBounds.top) - this.textPaint.ascent();
        } else if (i != 80) {
            this.collapsedDrawY = ((float) this.collapsedBounds.centerY()) + (((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f) - this.textPaint.descent());
        } else {
            this.collapsedDrawY = (float) this.collapsedBounds.bottom;
        }
        int i2 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i2 == 1) {
            this.collapsedDrawX = ((float) this.collapsedBounds.centerX()) - (measureText / 2.0f);
        } else if (i2 != 5) {
            this.collapsedDrawX = (float) this.collapsedBounds.left;
        } else {
            this.collapsedDrawX = ((float) this.collapsedBounds.right) - measureText;
        }
        calculateUsingTextSize(this.expandedTextSize);
        if (this.textToDraw != null) {
            f2 = this.textPaint.measureText(this.textToDraw, 0, this.textToDraw.length());
        }
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int i3 = absoluteGravity2 & 112;
        if (i3 == 48) {
            this.expandedDrawY = ((float) this.expandedBounds.top) - this.textPaint.ascent();
        } else if (i3 != 80) {
            this.expandedDrawY = ((float) this.expandedBounds.centerY()) + (((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f) - this.textPaint.descent());
        } else {
            this.expandedDrawY = (float) this.expandedBounds.bottom;
        }
        int i4 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i4 == 1) {
            this.expandedDrawX = ((float) this.expandedBounds.centerX()) - (f2 / 2.0f);
        } else if (i4 != 5) {
            this.expandedDrawX = (float) this.expandedBounds.left;
        } else {
            this.expandedDrawX = ((float) this.expandedBounds.right) - f2;
        }
        clearTexture();
        setInterpolatedTextSize(f);
    }

    private void interpolateBounds(float f) {
        this.currentBounds.left = lerp((float) this.expandedBounds.left, (float) this.collapsedBounds.left, f, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
        this.currentBounds.right = lerp((float) this.expandedBounds.right, (float) this.collapsedBounds.right, f, this.positionInterpolator);
        this.currentBounds.bottom = lerp((float) this.expandedBounds.bottom, (float) this.collapsedBounds.bottom, f, this.positionInterpolator);
    }

    public void draw(@NonNull Canvas canvas) {
        float f;
        int save = canvas.save();
        if (this.textToDraw != null && this.drawTitle) {
            float f2 = this.currentDrawX;
            float f3 = this.currentDrawY;
            boolean z = this.useTexture && this.expandedTitleTexture != null;
            if (z) {
                f = this.textureAscent * this.scale;
                float f4 = this.textureDescent;
                float f5 = this.scale;
            } else {
                f = this.textPaint.ascent() * this.scale;
                this.textPaint.descent();
                float f6 = this.scale;
            }
            if (z) {
                f3 += f;
            }
            float f7 = f3;
            if (this.scale != 1.0f) {
                canvas.scale(this.scale, this.scale, f2, f7);
            }
            if (z) {
                canvas.drawBitmap(this.expandedTitleTexture, f2, f7, this.texturePaint);
            } else {
                canvas.drawText(this.textToDraw, 0, this.textToDraw.length(), f2, f7, this.textPaint);
            }
        }
        canvas.restoreToCount(save);
    }

    private boolean calculateIsRtl(@NonNull CharSequence charSequence) {
        boolean z = true;
        if (ViewCompat.getLayoutDirection(this.view) != 1) {
            z = false;
        }
        return (z ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    private void setInterpolatedTextSize(float f) {
        calculateUsingTextSize(f);
        this.useTexture = USE_SCALING_TEXTURE && this.scale != 1.0f;
        if (this.useTexture) {
            ensureExpandedTexture();
        }
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private void calculateUsingTextSize(float f) {
        boolean z;
        float f2;
        boolean z2;
        if (this.text != null) {
            float width = (float) this.collapsedBounds.width();
            float width2 = (float) this.expandedBounds.width();
            boolean z3 = true;
            if (isClose(f, this.collapsedTextSize)) {
                float f3 = this.collapsedTextSize;
                this.scale = 1.0f;
                if (this.currentTypeface != this.collapsedTypeface) {
                    this.currentTypeface = this.collapsedTypeface;
                    z2 = true;
                } else {
                    z2 = false;
                }
                f2 = f3;
                z = z2;
            } else {
                f2 = this.expandedTextSize;
                if (this.currentTypeface != this.expandedTypeface) {
                    this.currentTypeface = this.expandedTypeface;
                    z = true;
                } else {
                    z = false;
                }
                if (isClose(f, this.expandedTextSize)) {
                    this.scale = 1.0f;
                } else {
                    this.scale = f / this.expandedTextSize;
                }
                float f4 = this.collapsedTextSize / this.expandedTextSize;
                width = width2 * f4 > width ? Math.min(width / f4, width2) : width2;
            }
            if (width > 0.0f) {
                z = this.currentTextSize != f2 || this.boundsChanged || z;
                this.currentTextSize = f2;
                this.boundsChanged = false;
            }
            if (this.textToDraw == null || z) {
                this.textPaint.setTextSize(this.currentTextSize);
                this.textPaint.setTypeface(this.currentTypeface);
                TextPaint textPaint2 = this.textPaint;
                if (this.scale == 1.0f) {
                    z3 = false;
                }
                textPaint2.setLinearText(z3);
                CharSequence ellipsize = TextUtils.ellipsize(this.text, this.textPaint, width, TextUtils.TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.textToDraw)) {
                    this.textToDraw = ellipsize;
                    this.isRtl = calculateIsRtl(this.textToDraw);
                }
            }
        }
    }

    private void ensureExpandedTexture() {
        if (this.expandedTitleTexture == null && !this.expandedBounds.isEmpty() && !TextUtils.isEmpty(this.textToDraw)) {
            calculateOffsets(0.0f);
            this.textureAscent = this.textPaint.ascent();
            this.textureDescent = this.textPaint.descent();
            int round = Math.round(this.textPaint.measureText(this.textToDraw, 0, this.textToDraw.length()));
            int round2 = Math.round(this.textureDescent - this.textureAscent);
            if (round > 0 && round2 > 0) {
                this.expandedTitleTexture = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                new Canvas(this.expandedTitleTexture).drawText(this.textToDraw, 0, this.textToDraw.length(), 0.0f, ((float) round2) - this.textPaint.descent(), this.textPaint);
                if (this.texturePaint == null) {
                    this.texturePaint = new Paint(3);
                }
            }
        }
    }

    public void recalculate() {
        if (this.view.getHeight() > 0 && this.view.getWidth() > 0) {
            calculateBaseOffsets();
            calculateCurrentOffsets();
        }
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textToDraw = null;
            clearTexture();
            recalculate();
        }
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    private void clearTexture() {
        if (this.expandedTitleTexture != null) {
            this.expandedTitleTexture.recycle();
            this.expandedTitleTexture = null;
        }
    }

    private static boolean isClose(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    private static int blendColors(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((((float) Color.blue(i)) * f2) + (((float) Color.blue(i2)) * f)));
    }

    private static float lerp(float f, float f2, float f3, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return AnimationUtils.lerp(f, f2, f3);
    }

    private static boolean rectEquals(@NonNull Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
