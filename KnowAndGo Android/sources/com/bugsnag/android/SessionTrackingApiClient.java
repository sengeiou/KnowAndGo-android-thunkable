package com.bugsnag.android;

import androidx.annotation.NonNull;
import java.util.Map;

@Deprecated
public interface SessionTrackingApiClient {
    void postSessionTrackingPayload(@NonNull String str, @NonNull SessionTrackingPayload sessionTrackingPayload, @NonNull Map<String, String> map) throws NetworkException, BadResponseException;
}
