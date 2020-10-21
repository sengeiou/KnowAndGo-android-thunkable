package com.bugsnag.android;

import androidx.annotation.NonNull;

public interface BeforeRecordBreadcrumb {
    boolean shouldRecord(@NonNull Breadcrumb breadcrumb);
}
