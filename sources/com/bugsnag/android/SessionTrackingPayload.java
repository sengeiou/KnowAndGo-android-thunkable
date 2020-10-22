package com.bugsnag.android;

import androidx.annotation.NonNull;
import com.bugsnag.android.JsonStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SessionTrackingPayload implements JsonStream.Streamable {
    private final Map<String, Object> appDataSummary;
    private final Map<String, Object> deviceDataSummary;
    private final List<File> files;
    private final Notifier notifier = Notifier.getInstance();
    private final Session session;

    SessionTrackingPayload(Session session2, List<File> list, AppData appData, DeviceData deviceData) {
        this.appDataSummary = appData.getAppDataSummary();
        this.deviceDataSummary = deviceData.getDeviceDataSummary();
        this.session = session2;
        this.files = list;
    }

    public void toStream(@NonNull JsonStream jsonStream) throws IOException {
        jsonStream.beginObject();
        jsonStream.name("notifier").value((JsonStream.Streamable) this.notifier);
        jsonStream.name("app").value((Object) this.appDataSummary);
        jsonStream.name("device").value((Object) this.deviceDataSummary);
        jsonStream.name("sessions").beginArray();
        if (this.session == null) {
            for (File value : this.files) {
                jsonStream.value(value);
            }
        } else {
            jsonStream.value((JsonStream.Streamable) this.session);
        }
        jsonStream.endArray();
        jsonStream.endObject();
    }

    /* access modifiers changed from: package-private */
    public Session getSession() {
        return this.session;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getDevice() {
        return this.deviceDataSummary;
    }
}
