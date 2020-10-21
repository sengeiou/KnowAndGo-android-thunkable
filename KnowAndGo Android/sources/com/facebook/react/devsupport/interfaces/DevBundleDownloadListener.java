package com.facebook.react.devsupport.interfaces;

import androidx.annotation.Nullable;

public interface DevBundleDownloadListener {
    void onFailure(Exception exc);

    void onProgress(@Nullable String str, @Nullable Integer num, @Nullable Integer num2);

    void onSuccess();
}
