package com.bugsnag.android;

import androidx.annotation.NonNull;
import com.bugsnag.android.JsonStream;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;

public class Notifier implements JsonStream.Streamable {
    private static final String NOTIFIER_NAME = "Android Bugsnag Notifier";
    private static final String NOTIFIER_URL = "https://bugsnag.com";
    private static final String NOTIFIER_VERSION = "4.22.3";
    private static final Notifier instance = new Notifier();
    @NonNull
    private String name = NOTIFIER_NAME;
    @NonNull
    private String url = NOTIFIER_URL;
    @NonNull
    private String version = NOTIFIER_VERSION;

    @NonNull
    public static Notifier getInstance() {
        return instance;
    }

    public void toStream(@NonNull JsonStream jsonStream) throws IOException {
        jsonStream.beginObject();
        jsonStream.name("name").value(this.name);
        jsonStream.name("version").value(this.version);
        jsonStream.name(ImagesContract.URL).value(this.url);
        jsonStream.endObject();
    }

    public void setVersion(@NonNull String str) {
        this.version = str;
    }

    public void setURL(@NonNull String str) {
        this.url = str;
    }

    public void setName(@NonNull String str) {
        this.name = str;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    @NonNull
    public String getVersion() {
        return this.version;
    }

    @NonNull
    public String getURL() {
        return this.url;
    }
}
