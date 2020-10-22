package com.bugsnag.android;

import androidx.annotation.NonNull;

public interface Callback {
    void beforeNotify(@NonNull Report report);
}
