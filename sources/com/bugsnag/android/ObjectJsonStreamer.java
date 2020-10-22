package com.bugsnag.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

class ObjectJsonStreamer {
    private static final String FILTERED_PLACEHOLDER = "[FILTERED]";
    private static final String OBJECT_PLACEHOLDER = "[OBJECT]";
    String[] filters = {"password"};

    ObjectJsonStreamer() {
    }

    /* access modifiers changed from: package-private */
    public void objectToStream(@Nullable Object obj, @NonNull JsonStream jsonStream) throws IOException {
        if (obj == null) {
            jsonStream.nullValue();
        } else if (obj instanceof String) {
            jsonStream.value((String) obj);
        } else if (obj instanceof Number) {
            jsonStream.value((Number) obj);
        } else if (obj instanceof Boolean) {
            jsonStream.value((Boolean) obj);
        } else if (obj instanceof Map) {
            jsonStream.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    String str = (String) key;
                    jsonStream.name(str);
                    if (shouldFilter(str)) {
                        jsonStream.value(FILTERED_PLACEHOLDER);
                    } else {
                        objectToStream(entry.getValue(), jsonStream);
                    }
                }
            }
            jsonStream.endObject();
        } else if (obj instanceof Collection) {
            jsonStream.beginArray();
            for (Object objectToStream : (Collection) obj) {
                objectToStream(objectToStream, jsonStream);
            }
            jsonStream.endArray();
        } else if (obj.getClass().isArray()) {
            jsonStream.beginArray();
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                objectToStream(Array.get(obj, i), jsonStream);
            }
            jsonStream.endArray();
        } else {
            jsonStream.value(OBJECT_PLACEHOLDER);
        }
    }

    private boolean shouldFilter(@Nullable String str) {
        if (this.filters == null || str == null) {
            return false;
        }
        for (String contains : this.filters) {
            if (str.contains(contains)) {
                return true;
            }
        }
        return false;
    }
}
