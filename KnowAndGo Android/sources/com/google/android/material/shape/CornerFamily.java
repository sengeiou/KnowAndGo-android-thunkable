package com.google.android.material.shape;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Retention(RetentionPolicy.SOURCE)
public @interface CornerFamily {
    public static final int CUT = 1;
    public static final int ROUNDED = 0;
}
