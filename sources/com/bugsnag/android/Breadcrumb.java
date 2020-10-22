package com.bugsnag.android;

import androidx.annotation.NonNull;
import com.bugsnag.android.JsonStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class Breadcrumb implements JsonStream.Streamable {
    private static final String DEFAULT_NAME = "manual";
    private static final int MAX_MESSAGE_LENGTH = 140;
    private static final String MESSAGE_METAKEY = "message";
    private static final String METADATA_KEY = "metaData";
    private static final String NAME_KEY = "name";
    private static final String TIMESTAMP_KEY = "timestamp";
    private static final String TYPE_KEY = "type";
    @NonNull
    private final Map<String, String> metadata;
    @NonNull
    private final String name;
    @NonNull
    private final String timestamp;
    @NonNull
    private final BreadcrumbType type;

    Breadcrumb(@NonNull String str) {
        this(DEFAULT_NAME, BreadcrumbType.MANUAL, Collections.singletonMap("message", str.substring(0, Math.min(str.length(), MAX_MESSAGE_LENGTH))));
    }

    Breadcrumb(@NonNull String str, @NonNull BreadcrumbType breadcrumbType, @NonNull Map<String, String> map) {
        this(str, breadcrumbType, new Date(), map);
    }

    Breadcrumb(@NonNull String str, @NonNull BreadcrumbType breadcrumbType, @NonNull Date date, @NonNull Map<String, String> map) {
        date = date == null ? new Date() : date;
        map = map == null ? new HashMap<>() : map;
        this.timestamp = DateUtils.toIso8601(date);
        this.type = breadcrumbType;
        this.name = str;
        this.metadata = new HashMap(map);
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    @NonNull
    public BreadcrumbType getType() {
        return this.type;
    }

    @NonNull
    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    @NonNull
    public String getTimestamp() {
        return this.timestamp;
    }

    public void toStream(@NonNull JsonStream jsonStream) throws IOException {
        jsonStream.beginObject();
        jsonStream.name(TIMESTAMP_KEY).value(this.timestamp);
        jsonStream.name("name").value(this.name);
        jsonStream.name(TYPE_KEY).value(this.type.toString());
        jsonStream.name(METADATA_KEY);
        jsonStream.beginObject();
        ArrayList<String> arrayList = new ArrayList<>(this.metadata.keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        for (String str : arrayList) {
            jsonStream.name(str).value(this.metadata.get(str));
        }
        jsonStream.endObject();
        jsonStream.endObject();
    }

    /* access modifiers changed from: package-private */
    public int payloadSize() throws IOException {
        StringWriter stringWriter = new StringWriter();
        toStream(new JsonStream(stringWriter));
        return stringWriter.toString().length();
    }
}
