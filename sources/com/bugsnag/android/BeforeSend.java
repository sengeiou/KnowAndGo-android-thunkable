package com.bugsnag.android;

import androidx.annotation.NonNull;

public interface BeforeSend {
    boolean run(@NonNull Report report);
}
