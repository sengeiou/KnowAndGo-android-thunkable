package com.bugsnag.android;

import androidx.annotation.NonNull;
import com.bugsnag.android.JsonStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

class CachedThread implements JsonStream.Streamable {

    /* renamed from: id */
    private final long f58id;
    private final boolean isErrorReportingThread;
    private final String name;
    private Stacktrace stacktrace;
    private final String type;

    CachedThread(Configuration configuration, long j, String str, String str2, boolean z, StackTraceElement[] stackTraceElementArr) {
        this(j, str, str2, z, new Stacktrace(stackTraceElementArr, configuration.getProjectPackages()));
    }

    CachedThread(long j, String str, String str2, boolean z, List<Map<String, Object>> list) {
        this(j, str, str2, z, new Stacktrace(list));
    }

    private CachedThread(long j, String str, String str2, boolean z, Stacktrace stacktrace2) {
        this.f58id = j;
        this.name = str;
        this.type = str2;
        this.isErrorReportingThread = z;
        this.stacktrace = stacktrace2;
    }

    public void toStream(@NonNull JsonStream jsonStream) throws IOException {
        jsonStream.beginObject();
        jsonStream.name("id").value(this.f58id);
        jsonStream.name("name").value(this.name);
        jsonStream.name("type").value(this.type);
        jsonStream.name("stacktrace").value((JsonStream.Streamable) this.stacktrace);
        if (this.isErrorReportingThread) {
            jsonStream.name("errorReportingThread").value(true);
        }
        jsonStream.endObject();
    }
}
