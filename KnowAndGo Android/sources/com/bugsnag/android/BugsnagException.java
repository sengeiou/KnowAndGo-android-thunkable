package com.bugsnag.android;

import androidx.annotation.NonNull;
import com.amplitude.api.DeviceInfo;
import com.bugsnag.android.JsonStream;
import com.onesignal.OneSignalDbContract;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BugsnagException extends Throwable implements JsonStream.Streamable {
    private static final long serialVersionUID = 5068182621179433346L;
    private final List<Map<String, Object>> customStackframes;
    private String message;
    private String name;
    private String[] projectPackages;
    private JsonStream.Streamable streamable;
    private String type = DeviceInfo.OS_NAME;

    public BugsnagException(@NonNull String str, @NonNull String str2, @NonNull StackTraceElement[] stackTraceElementArr) {
        super(str2);
        setStackTrace(stackTraceElementArr);
        this.name = str;
        this.customStackframes = null;
    }

    BugsnagException(@NonNull Throwable th) {
        super(th.getMessage());
        if (th instanceof JsonStream.Streamable) {
            this.streamable = (JsonStream.Streamable) th;
            this.name = "";
        } else {
            this.name = th.getClass().getName();
        }
        setStackTrace(th.getStackTrace());
        initCause(th.getCause());
        this.customStackframes = null;
    }

    BugsnagException(@NonNull String str, @NonNull String str2, @NonNull List<Map<String, Object>> list) {
        super(str2);
        setStackTrace(new StackTraceElement[0]);
        this.name = str;
        this.customStackframes = list;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    public void setName(@NonNull String str) {
        this.name = str;
    }

    @NonNull
    public String getMessage() {
        return this.message != null ? this.message : super.getMessage();
    }

    public void setMessage(@NonNull String str) {
        this.message = str;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public String getType() {
        return this.type;
    }

    /* access modifiers changed from: package-private */
    public void setType(@NonNull String str) {
        this.type = str;
    }

    public void toStream(@NonNull JsonStream jsonStream) throws IOException {
        Stacktrace stacktrace;
        if (this.streamable != null) {
            this.streamable.toStream(jsonStream);
            return;
        }
        List<Map<String, Object>> list = this.customStackframes;
        if (list != null) {
            stacktrace = new Stacktrace(list);
        } else {
            stacktrace = new Stacktrace(getStackTrace(), this.projectPackages);
        }
        jsonStream.beginObject();
        jsonStream.name("errorClass").value(getName());
        jsonStream.name(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE).value(getLocalizedMessage());
        jsonStream.name("type").value(this.type);
        jsonStream.name("stacktrace").value((JsonStream.Streamable) stacktrace);
        jsonStream.endObject();
    }

    /* access modifiers changed from: package-private */
    public void setProjectPackages(String[] strArr) {
        this.projectPackages = strArr;
    }
}
