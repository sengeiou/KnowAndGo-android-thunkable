package com.bugsnag;

import com.bugsnag.android.Callback;
import com.bugsnag.android.MetaData;
import com.bugsnag.android.Report;
import com.bugsnag.android.Severity;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.Map;

class DiagnosticsCallback implements Callback {
    static final String NOTIFIER_NAME = "Bugsnag for React Native";
    static final String NOTIFIER_URL = "https://github.com/bugsnag/bugsnag-react-native";
    private final String bugsnagAndroidVersion;
    private final String context;
    private final String groupingHash;
    private final String libraryVersion;
    private final Map<String, Object> metadata;
    private final Severity severity;

    DiagnosticsCallback(String str, String str2, ReadableMap readableMap) {
        this.libraryVersion = str;
        this.bugsnagAndroidVersion = str2;
        this.severity = parseSeverity(readableMap.getString("severity"));
        this.metadata = readObjectMap(readableMap.getMap(TtmlNode.TAG_METADATA));
        if (readableMap.hasKey("context")) {
            this.context = readableMap.getString("context");
        } else {
            this.context = null;
        }
        if (readableMap.hasKey("groupingHash")) {
            this.groupingHash = readableMap.getString("groupingHash");
        } else {
            this.groupingHash = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bugsnag.android.Severity parseSeverity(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = 3237038(0x3164ae, float:4.536056E-39)
            if (r0 == r1) goto L_0x0029
            r1 = 96784904(0x5c4d208, float:1.8508905E-35)
            if (r0 == r1) goto L_0x001f
            r1 = 1124446108(0x4305af9c, float:133.68597)
            if (r0 == r1) goto L_0x0014
            goto L_0x0033
        L_0x0014:
            java.lang.String r0 = "warning"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0033
            r3 = 2
            goto L_0x0034
        L_0x001f:
            java.lang.String r0 = "error"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0033
            r3 = 0
            goto L_0x0034
        L_0x0029:
            java.lang.String r0 = "info"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0033
            r3 = 1
            goto L_0x0034
        L_0x0033:
            r3 = -1
        L_0x0034:
            switch(r3) {
                case 0: goto L_0x003d;
                case 1: goto L_0x003a;
                default: goto L_0x0037;
            }
        L_0x0037:
            com.bugsnag.android.Severity r3 = com.bugsnag.android.Severity.WARNING
            return r3
        L_0x003a:
            com.bugsnag.android.Severity r3 = com.bugsnag.android.Severity.INFO
            return r3
        L_0x003d:
            com.bugsnag.android.Severity r3 = com.bugsnag.android.Severity.ERROR
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.DiagnosticsCallback.parseSeverity(java.lang.String):com.bugsnag.android.Severity");
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> readObjectMap(ReadableMap readableMap) {
        HashMap hashMap = new HashMap();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            ReadableMap map = readableMap.getMap(nextKey);
            String string = map.getString("type");
            char c = 65535;
            int hashCode = string.hashCode();
            if (hashCode != -1034364087) {
                if (hashCode != -891985903) {
                    if (hashCode != 107868) {
                        if (hashCode == 64711720 && string.equals("boolean")) {
                            c = 0;
                        }
                    } else if (string.equals("map")) {
                        c = 3;
                    }
                } else if (string.equals("string")) {
                    c = 2;
                }
            } else if (string.equals("number")) {
                c = 1;
            }
            switch (c) {
                case 0:
                    hashMap.put(nextKey, Boolean.valueOf(map.getBoolean("value")));
                    break;
                case 1:
                    hashMap.put(nextKey, Double.valueOf(map.getDouble("value")));
                    break;
                case 2:
                    hashMap.put(nextKey, map.getString("value"));
                    break;
                case 3:
                    hashMap.put(nextKey, readObjectMap(map.getMap("value")));
                    break;
            }
        }
        return hashMap;
    }

    public void beforeNotify(Report report) {
        report.getNotifier().setName(NOTIFIER_NAME);
        report.getNotifier().setURL(NOTIFIER_URL);
        report.getNotifier().setVersion(String.format("%s (Android %s)", new Object[]{this.libraryVersion, this.bugsnagAndroidVersion}));
        if (this.groupingHash != null && this.groupingHash.length() > 0) {
            report.getError().setGroupingHash(this.groupingHash);
        }
        if (this.context != null && this.context.length() > 0) {
            report.getError().setContext(this.context);
        }
        if (this.metadata != null) {
            MetaData metaData = report.getError().getMetaData();
            for (String next : this.metadata.keySet()) {
                Object obj = this.metadata.get(next);
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    for (String str : map.keySet()) {
                        metaData.addToTab(next, str, map.get(str));
                    }
                }
            }
        }
    }
}
