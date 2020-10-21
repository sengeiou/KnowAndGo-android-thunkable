package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.CircularRevealFrameLayout;

public class TransformationChildLayout extends CircularRevealFrameLayout {
    public TransformationChildLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public TransformationChildLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
