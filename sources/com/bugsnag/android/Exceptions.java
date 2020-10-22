package com.bugsnag.android;

import androidx.annotation.NonNull;
import com.bugsnag.android.JsonStream;
import com.onesignal.OneSignalDbContract;
import java.io.IOException;

class Exceptions implements JsonStream.Streamable {
    private final BugsnagException exception;
    private String exceptionType;
    private String[] projectPackages;

    Exceptions(Configuration configuration, BugsnagException bugsnagException) {
        this.exception = bugsnagException;
        this.exceptionType = bugsnagException.getType();
        this.projectPackages = configuration.getProjectPackages();
    }

    public void toStream(@NonNull JsonStream jsonStream) throws IOException {
        jsonStream.beginArray();
        for (Throwable th = this.exception; th != null; th = th.getCause()) {
            if (th instanceof JsonStream.Streamable) {
                ((JsonStream.Streamable) th).toStream(jsonStream);
            } else {
                exceptionToStream(jsonStream, th.getClass().getName(), th.getLocalizedMessage(), th.getStackTrace());
            }
        }
        jsonStream.endArray();
    }

    /* access modifiers changed from: package-private */
    public BugsnagException getException() {
        return this.exception;
    }

    /* access modifiers changed from: package-private */
    public String getExceptionType() {
        return this.exceptionType;
    }

    /* access modifiers changed from: package-private */
    public void setExceptionType(@NonNull String str) {
        this.exceptionType = str;
        this.exception.setType(this.exceptionType);
    }

    /* access modifiers changed from: package-private */
    public String[] getProjectPackages() {
        return this.projectPackages;
    }

    /* access modifiers changed from: package-private */
    public void setProjectPackages(String[] strArr) {
        this.projectPackages = strArr;
        this.exception.setProjectPackages(strArr);
    }

    private void exceptionToStream(@NonNull JsonStream jsonStream, String str, String str2, StackTraceElement[] stackTraceElementArr) throws IOException {
        jsonStream.beginObject();
        jsonStream.name("errorClass").value(str);
        jsonStream.name(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE).value(str2);
        jsonStream.name("type").value(this.exceptionType);
        jsonStream.name("stacktrace").value((JsonStream.Streamable) new Stacktrace(stackTraceElementArr, this.projectPackages));
        jsonStream.endObject();
    }
}
