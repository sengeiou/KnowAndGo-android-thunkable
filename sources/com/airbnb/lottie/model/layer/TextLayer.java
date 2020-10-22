package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.utils.C0744Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.p032io.IOUtils;

public class TextLayer extends BaseLayer {
    private final LongSparseArray<String> codePointCache = new LongSparseArray<>();
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> colorCallbackAnimation;
    private final LottieComposition composition;
    private final Map<FontCharacter, List<ContentGroup>> contentsForCharacter = new HashMap();
    private final Paint fillPaint = new Paint(1) {
        {
            setStyle(Paint.Style.FILL);
        }
    };
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix = new Matrix();
    private final RectF rectF = new RectF();
    private final StringBuilder stringBuilder = new StringBuilder(2);
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> strokeColorAnimation;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> strokeColorCallbackAnimation;
    private final Paint strokePaint = new Paint(1) {
        {
            setStyle(Paint.Style.STROKE);
        }
    };
    @Nullable
    private BaseKeyframeAnimation<Float, Float> strokeWidthAnimation;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> strokeWidthCallbackAnimation;
    private final TextKeyframeAnimation textAnimation;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> textSizeAnimation;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> textSizeCallbackAnimation;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> trackingAnimation;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> trackingCallbackAnimation;

    TextLayer(LottieDrawable lottieDrawable2, Layer layer) {
        super(lottieDrawable2, layer);
        this.lottieDrawable = lottieDrawable2;
        this.composition = layer.getComposition();
        this.textAnimation = layer.getText().createAnimation();
        this.textAnimation.addUpdateListener(this);
        addAnimation(this.textAnimation);
        AnimatableTextProperties textProperties = layer.getTextProperties();
        if (!(textProperties == null || textProperties.color == null)) {
            this.colorAnimation = textProperties.color.createAnimation();
            this.colorAnimation.addUpdateListener(this);
            addAnimation(this.colorAnimation);
        }
        if (!(textProperties == null || textProperties.stroke == null)) {
            this.strokeColorAnimation = textProperties.stroke.createAnimation();
            this.strokeColorAnimation.addUpdateListener(this);
            addAnimation(this.strokeColorAnimation);
        }
        if (!(textProperties == null || textProperties.strokeWidth == null)) {
            this.strokeWidthAnimation = textProperties.strokeWidth.createAnimation();
            this.strokeWidthAnimation.addUpdateListener(this);
            addAnimation(this.strokeWidthAnimation);
        }
        if (textProperties != null && textProperties.tracking != null) {
            this.trackingAnimation = textProperties.tracking.createAnimation();
            this.trackingAnimation.addUpdateListener(this);
            addAnimation(this.trackingAnimation);
        }
    }

    public void getBounds(RectF rectF2, Matrix matrix2, boolean z) {
        super.getBounds(rectF2, matrix2, z);
        rectF2.set(0.0f, 0.0f, (float) this.composition.getBounds().width(), (float) this.composition.getBounds().height());
    }

    /* access modifiers changed from: package-private */
    public void drawLayer(Canvas canvas, Matrix matrix2, int i) {
        canvas.save();
        if (!this.lottieDrawable.useTextGlyphs()) {
            canvas.setMatrix(matrix2);
        }
        DocumentData documentData = (DocumentData) this.textAnimation.getValue();
        Font font = this.composition.getFonts().get(documentData.fontName);
        if (font == null) {
            canvas.restore();
            return;
        }
        if (this.colorCallbackAnimation != null) {
            this.fillPaint.setColor(this.colorCallbackAnimation.getValue().intValue());
        } else if (this.colorAnimation != null) {
            this.fillPaint.setColor(this.colorAnimation.getValue().intValue());
        } else {
            this.fillPaint.setColor(documentData.color);
        }
        if (this.strokeColorCallbackAnimation != null) {
            this.strokePaint.setColor(this.strokeColorCallbackAnimation.getValue().intValue());
        } else if (this.strokeColorAnimation != null) {
            this.strokePaint.setColor(this.strokeColorAnimation.getValue().intValue());
        } else {
            this.strokePaint.setColor(documentData.strokeColor);
        }
        int intValue = ((this.transform.getOpacity() == null ? 100 : this.transform.getOpacity().getValue().intValue()) * 255) / 100;
        this.fillPaint.setAlpha(intValue);
        this.strokePaint.setAlpha(intValue);
        if (this.strokeWidthCallbackAnimation != null) {
            this.strokePaint.setStrokeWidth(this.strokeWidthCallbackAnimation.getValue().floatValue());
        } else if (this.strokeWidthAnimation != null) {
            this.strokePaint.setStrokeWidth(this.strokeWidthAnimation.getValue().floatValue());
        } else {
            this.strokePaint.setStrokeWidth(documentData.strokeWidth * C0744Utils.dpScale() * C0744Utils.getScale(matrix2));
        }
        if (this.lottieDrawable.useTextGlyphs()) {
            drawTextGlyphs(documentData, matrix2, font, canvas);
        } else {
            drawTextWithFont(documentData, font, matrix2, canvas);
        }
        canvas.restore();
    }

    private void drawTextGlyphs(DocumentData documentData, Matrix matrix2, Font font, Canvas canvas) {
        float f;
        DocumentData documentData2 = documentData;
        Canvas canvas2 = canvas;
        if (this.textSizeCallbackAnimation != null) {
            f = this.textSizeCallbackAnimation.getValue().floatValue();
        } else if (this.textSizeAnimation != null) {
            f = this.textSizeAnimation.getValue().floatValue();
        } else {
            f = documentData2.size;
        }
        float f2 = f / 100.0f;
        float scale = C0744Utils.getScale(matrix2);
        String str = documentData2.text;
        float dpScale = documentData2.lineHeight * C0744Utils.dpScale();
        List<String> textLines = getTextLines(str);
        int size = textLines.size();
        for (int i = 0; i < size; i++) {
            String str2 = textLines.get(i);
            float textLineWidthForGlyphs = getTextLineWidthForGlyphs(str2, font, f2, scale);
            canvas.save();
            applyJustification(documentData2.justification, canvas2, textLineWidthForGlyphs);
            canvas2.translate(0.0f, (((float) i) * dpScale) - ((((float) (size - 1)) * dpScale) / 2.0f));
            drawGlyphTextLine(str2, documentData, matrix2, font, canvas, scale, f2);
            canvas.restore();
        }
    }

    private void drawGlyphTextLine(String str, DocumentData documentData, Matrix matrix2, Font font, Canvas canvas, float f, float f2) {
        for (int i = 0; i < str.length(); i++) {
            FontCharacter fontCharacter = this.composition.getCharacters().get(FontCharacter.hashFor(str.charAt(i), font.getFamily(), font.getStyle()));
            if (fontCharacter != null) {
                drawCharacterAsGlyph(fontCharacter, matrix2, f2, documentData, canvas);
                float width = ((float) fontCharacter.getWidth()) * f2 * C0744Utils.dpScale() * f;
                float f3 = ((float) documentData.tracking) / 10.0f;
                if (this.trackingCallbackAnimation != null) {
                    f3 += this.trackingCallbackAnimation.getValue().floatValue();
                } else if (this.trackingAnimation != null) {
                    f3 += this.trackingAnimation.getValue().floatValue();
                }
                canvas.translate(width + (f3 * f), 0.0f);
            }
        }
    }

    private void drawTextWithFont(DocumentData documentData, Font font, Matrix matrix2, Canvas canvas) {
        float f;
        float scale = C0744Utils.getScale(matrix2);
        Typeface typeface = this.lottieDrawable.getTypeface(font.getFamily(), font.getStyle());
        if (typeface != null) {
            String str = documentData.text;
            TextDelegate textDelegate = this.lottieDrawable.getTextDelegate();
            if (textDelegate != null) {
                str = textDelegate.getTextInternal(str);
            }
            this.fillPaint.setTypeface(typeface);
            if (this.textSizeCallbackAnimation != null) {
                f = this.textSizeCallbackAnimation.getValue().floatValue();
            } else if (this.textSizeAnimation != null) {
                f = this.textSizeAnimation.getValue().floatValue();
            } else {
                f = documentData.size;
            }
            this.fillPaint.setTextSize(f * C0744Utils.dpScale());
            this.strokePaint.setTypeface(this.fillPaint.getTypeface());
            this.strokePaint.setTextSize(this.fillPaint.getTextSize());
            float dpScale = documentData.lineHeight * C0744Utils.dpScale();
            List<String> textLines = getTextLines(str);
            int size = textLines.size();
            for (int i = 0; i < size; i++) {
                String str2 = textLines.get(i);
                applyJustification(documentData.justification, canvas, this.strokePaint.measureText(str2));
                canvas.translate(0.0f, (((float) i) * dpScale) - ((((float) (size - 1)) * dpScale) / 2.0f));
                drawFontTextLine(str2, documentData, canvas, scale);
                canvas.setMatrix(matrix2);
            }
        }
    }

    private List<String> getTextLines(String str) {
        return Arrays.asList(str.replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, StringUtils.f3031CR).replaceAll("\n", StringUtils.f3031CR).split(StringUtils.f3031CR));
    }

    private void drawFontTextLine(String str, DocumentData documentData, Canvas canvas, float f) {
        int i = 0;
        while (i < str.length()) {
            String codePointToString = codePointToString(str, i);
            i += codePointToString.length();
            drawCharacterFromFont(codePointToString, documentData, canvas);
            float measureText = this.fillPaint.measureText(codePointToString, 0, 1);
            float f2 = ((float) documentData.tracking) / 10.0f;
            if (this.trackingCallbackAnimation != null) {
                f2 += this.trackingCallbackAnimation.getValue().floatValue();
            } else if (this.trackingAnimation != null) {
                f2 += this.trackingAnimation.getValue().floatValue();
            }
            canvas.translate(measureText + (f2 * f), 0.0f);
        }
    }

    private float getTextLineWidthForGlyphs(String str, Font font, float f, float f2) {
        float f3 = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            FontCharacter fontCharacter = this.composition.getCharacters().get(FontCharacter.hashFor(str.charAt(i), font.getFamily(), font.getStyle()));
            if (fontCharacter != null) {
                f3 = (float) (((double) f3) + (fontCharacter.getWidth() * ((double) f) * ((double) C0744Utils.dpScale()) * ((double) f2)));
            }
        }
        return f3;
    }

    private void applyJustification(DocumentData.Justification justification, Canvas canvas, float f) {
        switch (justification) {
            case RIGHT_ALIGN:
                canvas.translate(-f, 0.0f);
                return;
            case CENTER:
                canvas.translate((-f) / 2.0f, 0.0f);
                return;
            default:
                return;
        }
    }

    private void drawCharacterAsGlyph(FontCharacter fontCharacter, Matrix matrix2, float f, DocumentData documentData, Canvas canvas) {
        List<ContentGroup> contentsForCharacter2 = getContentsForCharacter(fontCharacter);
        for (int i = 0; i < contentsForCharacter2.size(); i++) {
            Path path = contentsForCharacter2.get(i).getPath();
            path.computeBounds(this.rectF, false);
            this.matrix.set(matrix2);
            this.matrix.preTranslate(0.0f, (-documentData.baselineShift) * C0744Utils.dpScale());
            this.matrix.preScale(f, f);
            path.transform(this.matrix);
            if (documentData.strokeOverFill) {
                drawGlyph(path, this.fillPaint, canvas);
                drawGlyph(path, this.strokePaint, canvas);
            } else {
                drawGlyph(path, this.strokePaint, canvas);
                drawGlyph(path, this.fillPaint, canvas);
            }
        }
    }

    private void drawGlyph(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private void drawCharacterFromFont(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.strokeOverFill) {
            drawCharacter(str, this.fillPaint, canvas);
            drawCharacter(str, this.strokePaint, canvas);
            return;
        }
        drawCharacter(str, this.strokePaint, canvas);
        drawCharacter(str, this.fillPaint, canvas);
    }

    private void drawCharacter(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
            }
        }
    }

    private List<ContentGroup> getContentsForCharacter(FontCharacter fontCharacter) {
        if (this.contentsForCharacter.containsKey(fontCharacter)) {
            return this.contentsForCharacter.get(fontCharacter);
        }
        List<ShapeGroup> shapes = fontCharacter.getShapes();
        int size = shapes.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new ContentGroup(this.lottieDrawable, this, shapes.get(i)));
        }
        this.contentsForCharacter.put(fontCharacter, arrayList);
        return arrayList;
    }

    private String codePointToString(String str, int i) {
        int codePointAt = str.codePointAt(i);
        int charCount = Character.charCount(codePointAt) + i;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!isModifier(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j = (long) codePointAt;
        if (this.codePointCache.containsKey(j)) {
            return this.codePointCache.get(j);
        }
        this.stringBuilder.setLength(0);
        while (i < charCount) {
            int codePointAt3 = str.codePointAt(i);
            this.stringBuilder.appendCodePoint(codePointAt3);
            i += Character.charCount(codePointAt3);
        }
        String sb = this.stringBuilder.toString();
        this.codePointCache.put(j, sb);
        return sb;
    }

    private boolean isModifier(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 19;
    }

    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.COLOR) {
            if (this.colorCallbackAnimation != null) {
                removeAnimation(this.colorCallbackAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorCallbackAnimation = null;
                return;
            }
            this.colorCallbackAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.colorCallbackAnimation.addUpdateListener(this);
            addAnimation(this.colorCallbackAnimation);
        } else if (t == LottieProperty.STROKE_COLOR) {
            if (this.strokeColorCallbackAnimation != null) {
                removeAnimation(this.strokeColorCallbackAnimation);
            }
            if (lottieValueCallback == null) {
                this.strokeColorCallbackAnimation = null;
                return;
            }
            this.strokeColorCallbackAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.strokeColorCallbackAnimation.addUpdateListener(this);
            addAnimation(this.strokeColorCallbackAnimation);
        } else if (t == LottieProperty.STROKE_WIDTH) {
            if (this.strokeWidthCallbackAnimation != null) {
                removeAnimation(this.strokeWidthCallbackAnimation);
            }
            if (lottieValueCallback == null) {
                this.strokeWidthCallbackAnimation = null;
                return;
            }
            this.strokeWidthCallbackAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.strokeWidthCallbackAnimation.addUpdateListener(this);
            addAnimation(this.strokeWidthCallbackAnimation);
        } else if (t == LottieProperty.TEXT_TRACKING) {
            if (this.trackingCallbackAnimation != null) {
                removeAnimation(this.trackingCallbackAnimation);
            }
            if (lottieValueCallback == null) {
                this.trackingCallbackAnimation = null;
                return;
            }
            this.trackingCallbackAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.trackingCallbackAnimation.addUpdateListener(this);
            addAnimation(this.trackingCallbackAnimation);
        } else if (t == LottieProperty.TEXT_SIZE) {
            if (this.textSizeCallbackAnimation != null) {
                removeAnimation(this.textSizeCallbackAnimation);
            }
            if (lottieValueCallback == null) {
                this.textSizeCallbackAnimation = null;
                return;
            }
            this.textSizeCallbackAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.textSizeCallbackAnimation.addUpdateListener(this);
            addAnimation(this.textSizeCallbackAnimation);
        }
    }
}
