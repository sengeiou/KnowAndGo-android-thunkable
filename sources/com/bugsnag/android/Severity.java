package com.bugsnag.android;

import androidx.annotation.NonNull;
import com.bugsnag.android.JsonStream;
import java.io.IOException;

public enum Severity implements JsonStream.Streamable {
    ERROR("error"),
    WARNING("warning"),
    INFO("info");
    
    private final String name;

    private Severity(String str) {
        this.name = str;
    }

    public void toStream(@NonNull JsonStream jsonStream) throws IOException {
        jsonStream.value(this.name);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.bugsnag.android.Severity fromString(java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            r1 = 3237038(0x3164ae, float:4.536056E-39)
            if (r0 == r1) goto L_0x0029
            r1 = 96784904(0x5c4d208, float:1.8508905E-35)
            if (r0 == r1) goto L_0x001f
            r1 = 1124446108(0x4305af9c, float:133.68597)
            if (r0 == r1) goto L_0x0014
            goto L_0x0033
        L_0x0014:
            java.lang.String r0 = "warning"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0033
            r2 = 1
            goto L_0x0034
        L_0x001f:
            java.lang.String r0 = "error"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0033
            r2 = 0
            goto L_0x0034
        L_0x0029:
            java.lang.String r0 = "info"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0033
            r2 = 2
            goto L_0x0034
        L_0x0033:
            r2 = -1
        L_0x0034:
            switch(r2) {
                case 0: goto L_0x003f;
                case 1: goto L_0x003c;
                case 2: goto L_0x0039;
                default: goto L_0x0037;
            }
        L_0x0037:
            r2 = 0
            return r2
        L_0x0039:
            com.bugsnag.android.Severity r2 = INFO
            return r2
        L_0x003c:
            com.bugsnag.android.Severity r2 = WARNING
            return r2
        L_0x003f:
            com.bugsnag.android.Severity r2 = ERROR
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.Severity.fromString(java.lang.String):com.bugsnag.android.Severity");
    }

    static Severity fromChar(char c) {
        if (c == 'e') {
            return ERROR;
        }
        if (c == 'i') {
            return INFO;
        }
        if (c != 'w') {
            return null;
        }
        return WARNING;
    }

    @NonNull
    public String getName() {
        return this.name;
    }
}
