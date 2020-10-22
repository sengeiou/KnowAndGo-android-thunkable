package com.bugsnag.android;

import androidx.annotation.NonNull;
import java.util.Locale;

@Deprecated
public class BadResponseException extends Exception {
    private static final long serialVersionUID = -870190454845379171L;

    public BadResponseException(@NonNull String str, int i) {
        super(String.format(Locale.US, "%s (%d)", new Object[]{str, Integer.valueOf(i)}));
    }
}
