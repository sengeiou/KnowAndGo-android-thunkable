package com.bugsnag.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bugsnag.android.JsonStream;
import java.io.File;
import java.io.IOException;

public class Report implements JsonStream.Streamable {
    @NonNull
    private String apiKey;
    private transient boolean cachingDisabled;
    @Nullable
    private final Error error;
    @Nullable
    private final File errorFile;
    @NonNull
    private final Notifier notifier;

    Report(@NonNull String str, @NonNull Error error2) {
        this(str, (File) null, error2);
    }

    Report(@NonNull String str, @Nullable File file) {
        this(str, file, (Error) null);
    }

    private Report(@NonNull String str, @Nullable File file, @Nullable Error error2) {
        this.error = error2;
        this.errorFile = file;
        this.notifier = Notifier.getInstance();
        this.apiKey = str;
    }

    public void toStream(@NonNull JsonStream jsonStream) throws IOException {
        jsonStream.beginObject();
        jsonStream.name("apiKey").value(this.apiKey);
        jsonStream.name("payloadVersion").value("4.0");
        jsonStream.name("notifier").value((JsonStream.Streamable) this.notifier);
        jsonStream.name("events").beginArray();
        if (this.error != null) {
            jsonStream.value((JsonStream.Streamable) this.error);
        } else if (this.errorFile != null) {
            jsonStream.value(this.errorFile);
        } else {
            Logger.warn("Expected error or errorFile, found empty payload instead");
        }
        jsonStream.endArray();
        jsonStream.endObject();
    }

    @NonNull
    public Error getError() {
        return this.error;
    }

    public void setApiKey(@NonNull String str) {
        this.apiKey = str;
    }

    @NonNull
    public String getApiKey() {
        return this.apiKey;
    }

    @Deprecated
    public void setNotifierVersion(@NonNull String str) {
        this.notifier.setVersion(str);
    }

    @Deprecated
    public void setNotifierName(@NonNull String str) {
        this.notifier.setName(str);
    }

    @Deprecated
    public void setNotifierURL(@NonNull String str) {
        this.notifier.setURL(str);
    }

    @NonNull
    public Notifier getNotifier() {
        return this.notifier;
    }

    /* access modifiers changed from: package-private */
    public boolean isCachingDisabled() {
        return this.cachingDisabled;
    }

    /* access modifiers changed from: package-private */
    public void setCachingDisabled(boolean z) {
        this.cachingDisabled = z;
    }
}
