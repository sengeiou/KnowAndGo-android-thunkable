package com.bugsnag.android;

import androidx.annotation.NonNull;

public interface BeforeNotify {
    boolean run(@NonNull Error error);
}
