package com.facebook.react.animated;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableMap;

class ValueAnimatedNode extends AnimatedNode {
    Object mAnimatedObject = null;
    double mOffset = 0.0d;
    double mValue = Double.NaN;
    @Nullable
    private AnimatedNodeValueListener mValueListener;

    public ValueAnimatedNode() {
    }

    public ValueAnimatedNode(ReadableMap readableMap) {
        this.mValue = readableMap.getDouble("value");
        this.mOffset = readableMap.getDouble("offset");
    }

    public double getValue() {
        if (Double.isNaN(this.mOffset + this.mValue)) {
            update();
        }
        return this.mOffset + this.mValue;
    }

    public Object getAnimatedObject() {
        return this.mAnimatedObject;
    }

    public void flattenOffset() {
        this.mValue += this.mOffset;
        this.mOffset = 0.0d;
    }

    public void extractOffset() {
        this.mOffset += this.mValue;
        this.mValue = 0.0d;
    }

    public void onValueUpdate() {
        if (this.mValueListener != null) {
            this.mValueListener.onValueUpdate(getValue());
        }
    }

    public void setValueListener(@Nullable AnimatedNodeValueListener animatedNodeValueListener) {
        this.mValueListener = animatedNodeValueListener;
    }
}
