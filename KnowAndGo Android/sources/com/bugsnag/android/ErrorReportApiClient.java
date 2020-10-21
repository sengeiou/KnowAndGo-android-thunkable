package com.bugsnag.android;

import androidx.annotation.NonNull;
import java.util.Map;

@Deprecated
public interface ErrorReportApiClient {
    void postReport(@NonNull String str, @NonNull Report report, @NonNull Map<String, String> map) throws NetworkException, BadResponseException;
}
