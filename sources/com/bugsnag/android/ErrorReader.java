package com.bugsnag.android;

import android.util.JsonReader;
import android.util.JsonToken;
import com.amplitude.api.DeviceInfo;
import com.onesignal.OneSignalDbContract;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

class ErrorReader {
    ErrorReader() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01cb A[SYNTHETIC, Splitter:B:102:0x01cb] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.bugsnag.android.Error readError(@androidx.annotation.NonNull com.bugsnag.android.Configuration r21, @androidx.annotation.NonNull java.io.File r22) throws java.io.IOException {
        /*
            r0 = r21
            com.bugsnag.android.Severity r2 = com.bugsnag.android.Severity.ERROR     // Catch:{ all -> 0x01c7 }
            java.util.List r3 = java.util.Collections.emptyList()     // Catch:{ all -> 0x01c7 }
            android.util.JsonReader r8 = new android.util.JsonReader     // Catch:{ all -> 0x01c7 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x01c7 }
            java.io.FileReader r5 = new java.io.FileReader     // Catch:{ all -> 0x01c7 }
            r6 = r22
            r5.<init>(r6)     // Catch:{ all -> 0x01c7 }
            r4.<init>(r5)     // Catch:{ all -> 0x01c7 }
            r8.<init>(r4)     // Catch:{ all -> 0x01c7 }
            r8.beginObject()     // Catch:{ all -> 0x01c3 }
            r5 = r2
            r11 = r3
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x002c:
            boolean r18 = r8.hasNext()     // Catch:{ all -> 0x01c3 }
            if (r18 == 0) goto L_0x014f
            java.lang.String r9 = r8.nextName()     // Catch:{ all -> 0x014c }
            r18 = -1
            int r19 = r9.hashCode()     // Catch:{ all -> 0x014c }
            switch(r19) {
                case -1890362749: goto L_0x00cd;
                case -1337936983: goto L_0x00c2;
                case -1335157162: goto L_0x00b8;
                case -1314244092: goto L_0x00ae;
                case -450957489: goto L_0x00a4;
                case -68904783: goto L_0x009a;
                case -51457840: goto L_0x0090;
                case 96801: goto L_0x0086;
                case 3599307: goto L_0x007a;
                case 358603558: goto L_0x0070;
                case 398106529: goto L_0x0064;
                case 951530927: goto L_0x0059;
                case 1478300413: goto L_0x004d;
                case 1984987798: goto L_0x0041;
                default: goto L_0x003f;
            }     // Catch:{ all -> 0x014c }
        L_0x003f:
            goto L_0x00d9
        L_0x0041:
            java.lang.String r1 = "session"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x014c }
            if (r1 == 0) goto L_0x00d9
            r9 = 8
            goto L_0x00da
        L_0x004d:
            java.lang.String r1 = "severity"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x014c }
            if (r1 == 0) goto L_0x00d9
            r9 = 9
            goto L_0x00da
        L_0x0059:
            java.lang.String r1 = "context"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x014c }
            if (r1 == 0) goto L_0x00d9
            r9 = 2
            goto L_0x00da
        L_0x0064:
            java.lang.String r1 = "severityReason"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x014c }
            if (r1 == 0) goto L_0x00d9
            r9 = 10
            goto L_0x00da
        L_0x0070:
            java.lang.String r1 = "projectPackages"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x014c }
            if (r1 == 0) goto L_0x00d9
            r9 = 4
            goto L_0x00da
        L_0x007a:
            java.lang.String r1 = "user"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x014c }
            if (r1 == 0) goto L_0x00d9
            r9 = 13
            goto L_0x00da
        L_0x0086:
            java.lang.String r1 = "app"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x014c }
            if (r1 == 0) goto L_0x00d9
            r9 = 0
            goto L_0x00da
        L_0x0090:
            java.lang.String r1 = "breadcrumbs"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x014c }
            if (r1 == 0) goto L_0x00d9
            r9 = 1
            goto L_0x00da
        L_0x009a:
            java.lang.String r1 = "groupingHash"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x014c }
            if (r1 == 0) goto L_0x00d9
            r9 = 6
            goto L_0x00da
        L_0x00a4:
            java.lang.String r1 = "metaData"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x014c }
            if (r1 == 0) goto L_0x00d9
            r9 = 7
            goto L_0x00da
        L_0x00ae:
            java.lang.String r1 = "exceptions"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x014c }
            if (r1 == 0) goto L_0x00d9
            r9 = 5
            goto L_0x00da
        L_0x00b8:
            java.lang.String r1 = "device"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x014c }
            if (r1 == 0) goto L_0x00d9
            r9 = 3
            goto L_0x00da
        L_0x00c2:
            java.lang.String r1 = "threads"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x014c }
            if (r1 == 0) goto L_0x00d9
            r9 = 11
            goto L_0x00da
        L_0x00cd:
            java.lang.String r1 = "unhandled"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x014c }
            if (r1 == 0) goto L_0x00d9
            r9 = 12
            goto L_0x00da
        L_0x00d9:
            r9 = -1
        L_0x00da:
            switch(r9) {
                case 0: goto L_0x0145;
                case 1: goto L_0x013d;
                case 2: goto L_0x0136;
                case 3: goto L_0x012e;
                case 4: goto L_0x0127;
                case 5: goto L_0x0120;
                case 6: goto L_0x0119;
                case 7: goto L_0x010d;
                case 8: goto L_0x0107;
                case 9: goto L_0x00fd;
                case 10: goto L_0x00f6;
                case 11: goto L_0x00f0;
                case 12: goto L_0x00e9;
                case 13: goto L_0x00e2;
                default: goto L_0x00dd;
            }     // Catch:{ all -> 0x014c }
        L_0x00dd:
            r8.skipValue()     // Catch:{ all -> 0x014c }
            goto L_0x002c
        L_0x00e2:
            com.bugsnag.android.User r1 = readUser(r8)     // Catch:{ all -> 0x014c }
            r12 = r1
            goto L_0x002c
        L_0x00e9:
            boolean r1 = r8.nextBoolean()     // Catch:{ all -> 0x014c }
            r3 = r1
            goto L_0x002c
        L_0x00f0:
            com.bugsnag.android.ThreadState r7 = readThreadState(r8)     // Catch:{ all -> 0x014c }
            goto L_0x002c
        L_0x00f6:
            java.util.ArrayList r1 = readSeverityReason(r8)     // Catch:{ all -> 0x014c }
            r2 = r1
            goto L_0x002c
        L_0x00fd:
            java.lang.String r1 = r8.nextString()     // Catch:{ all -> 0x014c }
            com.bugsnag.android.Severity r5 = com.bugsnag.android.Severity.fromString(r1)     // Catch:{ all -> 0x014c }
            goto L_0x002c
        L_0x0107:
            com.bugsnag.android.Session r6 = readSession(r8)     // Catch:{ all -> 0x014c }
            goto L_0x002c
        L_0x010d:
            com.bugsnag.android.MetaData r1 = new com.bugsnag.android.MetaData     // Catch:{ all -> 0x014c }
            java.util.Map r4 = jsonObjectToMap(r8)     // Catch:{ all -> 0x014c }
            r1.<init>(r4)     // Catch:{ all -> 0x014c }
            r4 = r1
            goto L_0x002c
        L_0x0119:
            java.lang.String r1 = r8.nextString()     // Catch:{ all -> 0x014c }
            r14 = r1
            goto L_0x002c
        L_0x0120:
            com.bugsnag.android.Exceptions r1 = readExceptions(r0, r8)     // Catch:{ all -> 0x014c }
            r10 = r1
            goto L_0x002c
        L_0x0127:
            java.util.List r1 = jsonArrayToList(r8)     // Catch:{ all -> 0x014c }
            r11 = r1
            goto L_0x002c
        L_0x012e:
            java.util.Map r1 = jsonObjectToMap(r8)     // Catch:{ all -> 0x014c }
            r16 = r1
            goto L_0x002c
        L_0x0136:
            java.lang.String r1 = r8.nextString()     // Catch:{ all -> 0x014c }
            r13 = r1
            goto L_0x002c
        L_0x013d:
            com.bugsnag.android.Breadcrumbs r1 = readBreadcrumbs(r0, r8)     // Catch:{ all -> 0x014c }
            r17 = r1
            goto L_0x002c
        L_0x0145:
            java.util.Map r1 = jsonObjectToMap(r8)     // Catch:{ all -> 0x014c }
            r15 = r1
            goto L_0x002c
        L_0x014c:
            r0 = move-exception
            goto L_0x01c9
        L_0x014f:
            r8.endObject()     // Catch:{ all -> 0x01c3 }
            if (r2 == 0) goto L_0x01b5
            if (r10 == 0) goto L_0x01b5
            int r1 = r2.size()     // Catch:{ all -> 0x01c3 }
            r9 = 1
            if (r1 <= r9) goto L_0x0164
            java.lang.Object r1 = r2.get(r9)     // Catch:{ all -> 0x014c }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x014c }
            goto L_0x0165
        L_0x0164:
            r1 = 0
        L_0x0165:
            com.bugsnag.android.HandledState r9 = new com.bugsnag.android.HandledState     // Catch:{ all -> 0x01c3 }
            r0 = 0
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x01c3 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x01c3 }
            r9.<init>(r2, r5, r3, r1)     // Catch:{ all -> 0x01c3 }
            com.bugsnag.android.Error r0 = new com.bugsnag.android.Error     // Catch:{ all -> 0x01c3 }
            com.bugsnag.android.BugsnagException r3 = r10.getException()     // Catch:{ all -> 0x01c3 }
            r1 = r0
            r2 = r21
            r20 = r8
            r8 = r4
            r4 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x01bf }
            com.bugsnag.android.Exceptions r1 = r0.getExceptions()     // Catch:{ all -> 0x01bf }
            java.lang.String r2 = r10.getExceptionType()     // Catch:{ all -> 0x01bf }
            r1.setExceptionType(r2)     // Catch:{ all -> 0x01bf }
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ all -> 0x01bf }
            java.lang.Object[] r1 = r11.toArray(r1)     // Catch:{ all -> 0x01bf }
            java.lang.String[] r1 = (java.lang.String[]) r1     // Catch:{ all -> 0x01bf }
            r0.setProjectPackages(r1)     // Catch:{ all -> 0x01bf }
            r0.setUser(r12)     // Catch:{ all -> 0x01bf }
            r0.setContext(r13)     // Catch:{ all -> 0x01bf }
            r0.setGroupingHash(r14)     // Catch:{ all -> 0x01bf }
            r0.setAppData(r15)     // Catch:{ all -> 0x01bf }
            r0.setMetaData(r8)     // Catch:{ all -> 0x01bf }
            r1 = r16
            r0.setDeviceData(r1)     // Catch:{ all -> 0x01bf }
            r1 = r17
            r0.setBreadcrumbs(r1)     // Catch:{ all -> 0x01bf }
            r20.close()     // Catch:{ Exception -> 0x01b4 }
        L_0x01b4:
            return r0
        L_0x01b5:
            r20 = r8
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01bf }
            java.lang.String r1 = "File did not contain a valid error"
            r0.<init>(r1)     // Catch:{ all -> 0x01bf }
            throw r0     // Catch:{ all -> 0x01bf }
        L_0x01bf:
            r0 = move-exception
            r8 = r20
            goto L_0x01c9
        L_0x01c3:
            r0 = move-exception
            r20 = r8
            goto L_0x01c9
        L_0x01c7:
            r0 = move-exception
            r8 = 0
        L_0x01c9:
            if (r8 == 0) goto L_0x01ce
            r8.close()     // Catch:{ Exception -> 0x01ce }
        L_0x01ce:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.ErrorReader.readError(com.bugsnag.android.Configuration, java.io.File):com.bugsnag.android.Error");
    }

    private static Breadcrumbs readBreadcrumbs(Configuration configuration, JsonReader jsonReader) throws IOException {
        Breadcrumbs breadcrumbs = new Breadcrumbs(configuration);
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            Breadcrumb readBreadcrumb = readBreadcrumb(jsonReader);
            if (readBreadcrumb != null) {
                breadcrumbs.add(readBreadcrumb);
            }
        }
        jsonReader.endArray();
        return breadcrumbs;
    }

    private static Breadcrumb readBreadcrumb(JsonReader jsonReader) throws IOException {
        HashMap hashMap = new HashMap();
        jsonReader.beginObject();
        String str = null;
        Date date = null;
        String str2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -450957489) {
                if (hashCode != 3373707) {
                    if (hashCode != 3575610) {
                        if (hashCode == 55126294 && nextName.equals("timestamp")) {
                            c = 1;
                        }
                    } else if (nextName.equals("type")) {
                        c = 2;
                    }
                } else if (nextName.equals("name")) {
                    c = 0;
                }
            } else if (nextName.equals("metaData")) {
                c = 3;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    try {
                        date = DateUtils.fromIso8601(jsonReader.nextString());
                        break;
                    } catch (Exception e) {
                        throw new IOException("Failed to parse breadcrumb timestamp: ", e);
                    }
                case 2:
                    str2 = jsonReader.nextString().toUpperCase(Locale.US);
                    break;
                case 3:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        hashMap.put(jsonReader.nextName(), jsonReader.nextString());
                    }
                    jsonReader.endObject();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (str == null || date == null || str2 == null) {
            return null;
        }
        return new Breadcrumb(str, BreadcrumbType.valueOf(str2), date, hashMap);
    }

    private static Exceptions readExceptions(Configuration configuration, JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        BugsnagException readException = readException(jsonReader);
        BugsnagException bugsnagException = readException;
        while (jsonReader.hasNext()) {
            BugsnagException readException2 = readException(jsonReader);
            bugsnagException.initCause(readException2);
            bugsnagException = readException2;
        }
        jsonReader.endArray();
        Exceptions exceptions = new Exceptions(configuration, readException);
        if (readException != null) {
            exceptions.setExceptionType(readException.getType());
        }
        return exceptions;
    }

    private static BugsnagException readException(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        List<Map<String, Object>> arrayList = new ArrayList<>();
        String str = null;
        String str2 = DeviceInfo.OS_NAME;
        String str3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3575610) {
                if (hashCode != 954925063) {
                    if (hashCode != 1610083408) {
                        if (hashCode == 2055832509 && nextName.equals("stacktrace")) {
                            c = 2;
                        }
                    } else if (nextName.equals("errorClass")) {
                        c = 0;
                    }
                } else if (nextName.equals(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE)) {
                    c = 1;
                }
            } else if (nextName.equals("type")) {
                c = 3;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    str3 = jsonReader.nextString();
                    break;
                case 2:
                    arrayList = readStackFrames(jsonReader);
                    break;
                case 3:
                    str2 = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        BugsnagException bugsnagException = new BugsnagException(str, str3, arrayList);
        bugsnagException.setType(str2);
        return bugsnagException;
    }

    private static List<Map<String, Object>> readStackFrames(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(readStackFrame(jsonReader));
        }
        jsonReader.endArray();
        return arrayList;
    }

    private static Map<String, Object> readStackFrame(JsonReader jsonReader) throws IOException {
        HashMap hashMap = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            try {
                String nextName = jsonReader.nextName();
                switch (C08361.$SwitchMap$android$util$JsonToken[jsonReader.peek().ordinal()]) {
                    case 1:
                        hashMap.put(nextName, jsonReader.nextString());
                        break;
                    case 2:
                        hashMap.put(nextName, deserializeNumber(jsonReader));
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } catch (IllegalStateException e) {
                Logger.warn("Failed to read stackframe", e);
            }
        }
        jsonReader.endObject();
        return hashMap;
    }

    /* renamed from: com.bugsnag.android.ErrorReader$1 */
    static /* synthetic */ class C08361 {
        static final /* synthetic */ int[] $SwitchMap$android$util$JsonToken = new int[JsonToken.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                android.util.JsonToken[] r0 = android.util.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$util$JsonToken = r0
                int[] r0 = $SwitchMap$android$util$JsonToken     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.util.JsonToken r1 = android.util.JsonToken.STRING     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$android$util$JsonToken     // Catch:{ NoSuchFieldError -> 0x001f }
                android.util.JsonToken r1 = android.util.JsonToken.NUMBER     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$android$util$JsonToken     // Catch:{ NoSuchFieldError -> 0x002a }
                android.util.JsonToken r1 = android.util.JsonToken.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$android$util$JsonToken     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.util.JsonToken r1 = android.util.JsonToken.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$android$util$JsonToken     // Catch:{ NoSuchFieldError -> 0x0040 }
                android.util.JsonToken r1 = android.util.JsonToken.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.ErrorReader.C08361.<clinit>():void");
        }
    }

    private static ArrayList<String> readSeverityReason(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3575610) {
                if (hashCode == 405645655 && nextName.equals("attributes")) {
                    c = 1;
                }
            } else if (nextName.equals("type")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    jsonReader.beginObject();
                    jsonReader.nextName();
                    str2 = jsonReader.nextString();
                    jsonReader.endObject();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        ArrayList<String> arrayList = new ArrayList<>();
        if (str != null) {
            arrayList.add(str);
            if (str2 != null) {
                arrayList.add(str2);
            }
            return arrayList;
        }
        throw new IOException("Severity Reason type is required");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00af A[SYNTHETIC, Splitter:B:46:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.bugsnag.android.Session readSession(android.util.JsonReader r11) throws java.io.IOException {
        /*
            r11.beginObject()
            r0 = 0
            r1 = 0
            r3 = r0
            r4 = r3
            r5 = r4
            r6 = 0
            r7 = 0
        L_0x000a:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x00ca
            java.lang.String r0 = r11.nextName()
            int r2 = r0.hashCode()
            r8 = -2128794476(0xffffffff811d2c94, float:-2.886833E-38)
            r9 = 1
            r10 = -1
            if (r2 == r8) goto L_0x004d
            r8 = -1291329255(0xffffffffb307e119, float:-3.1636862E-8)
            if (r2 == r8) goto L_0x0043
            r8 = 3355(0xd1b, float:4.701E-42)
            if (r2 == r8) goto L_0x0039
            r8 = 3599307(0x36ebcb, float:5.043703E-39)
            if (r2 == r8) goto L_0x002e
            goto L_0x0057
        L_0x002e:
            java.lang.String r2 = "user"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0057
            r0 = 3
            goto L_0x0058
        L_0x0039:
            java.lang.String r2 = "id"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0057
            r0 = 0
            goto L_0x0058
        L_0x0043:
            java.lang.String r2 = "events"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0057
            r0 = 2
            goto L_0x0058
        L_0x004d:
            java.lang.String r2 = "startedAt"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0057
            r0 = 1
            goto L_0x0058
        L_0x0057:
            r0 = -1
        L_0x0058:
            switch(r0) {
                case 0: goto L_0x00c3;
                case 1: goto L_0x00af;
                case 2: goto L_0x0065;
                case 3: goto L_0x005f;
                default: goto L_0x005b;
            }
        L_0x005b:
            r11.skipValue()
            goto L_0x000a
        L_0x005f:
            com.bugsnag.android.User r0 = readUser(r11)
            r5 = r0
            goto L_0x000a
        L_0x0065:
            r11.beginObject()
        L_0x0068:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x00aa
            java.lang.String r0 = r11.nextName()
            int r2 = r0.hashCode()
            r8 = -1890362749(0xffffffff8f535a83, float:-1.0420535E-29)
            if (r2 == r8) goto L_0x008b
            r8 = 692803388(0x294b573c, float:4.515072E-14)
            if (r2 == r8) goto L_0x0081
            goto L_0x0096
        L_0x0081:
            java.lang.String r2 = "handled"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0096
            r0 = 1
            goto L_0x0097
        L_0x008b:
            java.lang.String r2 = "unhandled"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0096
            r0 = 0
            goto L_0x0097
        L_0x0096:
            r0 = -1
        L_0x0097:
            switch(r0) {
                case 0: goto L_0x00a4;
                case 1: goto L_0x009e;
                default: goto L_0x009a;
            }
        L_0x009a:
            r11.skipValue()
            goto L_0x0068
        L_0x009e:
            int r0 = r11.nextInt()
            r7 = r0
            goto L_0x0068
        L_0x00a4:
            int r0 = r11.nextInt()
            r6 = r0
            goto L_0x0068
        L_0x00aa:
            r11.endObject()
            goto L_0x000a
        L_0x00af:
            java.lang.String r0 = r11.nextString()     // Catch:{ Exception -> 0x00ba }
            java.util.Date r0 = com.bugsnag.android.DateUtils.fromIso8601(r0)     // Catch:{ Exception -> 0x00ba }
            r4 = r0
            goto L_0x000a
        L_0x00ba:
            r11 = move-exception
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Unable to parse session startedAt: "
            r0.<init>(r1, r11)
            throw r0
        L_0x00c3:
            java.lang.String r0 = r11.nextString()
            r3 = r0
            goto L_0x000a
        L_0x00ca:
            r11.endObject()
            if (r3 == 0) goto L_0x00d8
            if (r4 == 0) goto L_0x00d8
            com.bugsnag.android.Session r11 = new com.bugsnag.android.Session
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7)
            return r11
        L_0x00d8:
            java.io.IOException r11 = new java.io.IOException
            java.lang.String r0 = "Session data missing required fields"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.ErrorReader.readSession(android.util.JsonReader):com.bugsnag.android.Session");
    }

    private static User readUser(JsonReader jsonReader) throws IOException {
        User user = new User();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3355) {
                if (hashCode != 3373707) {
                    if (hashCode == 96619420 && nextName.equals("email")) {
                        c = 2;
                    }
                } else if (nextName.equals("name")) {
                    c = 0;
                }
            } else if (nextName.equals("id")) {
                c = 1;
            }
            switch (c) {
                case 0:
                    user.setName(jsonReader.nextString());
                    break;
                case 1:
                    user.setId(jsonReader.nextString());
                    break;
                case 2:
                    user.setEmail(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return user;
    }

    private static ThreadState readThreadState(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            CachedThread readThread = readThread(jsonReader);
            if (readThread != null) {
                arrayList.add(readThread);
            }
        }
        jsonReader.endArray();
        return new ThreadState((CachedThread[]) arrayList.toArray(new CachedThread[0]));
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.bugsnag.android.CachedThread readThread(android.util.JsonReader r12) throws java.io.IOException {
        /*
            r12.beginObject()
            r0 = 0
            r1 = 0
            r2 = 0
            r7 = r1
            r8 = r7
            r10 = r8
            r5 = r2
            r9 = 0
        L_0x000c:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L_0x008d
            java.lang.String r2 = r12.nextName()
            r3 = -1
            int r4 = r2.hashCode()
            r11 = -767067472(0xffffffffd2477ab0, float:-2.14189212E11)
            if (r4 == r11) goto L_0x005d
            r11 = 3355(0xd1b, float:4.701E-42)
            if (r4 == r11) goto L_0x0053
            r11 = 3373707(0x337a8b, float:4.72757E-39)
            if (r4 == r11) goto L_0x0049
            r11 = 3575610(0x368f3a, float:5.010497E-39)
            if (r4 == r11) goto L_0x003e
            r11 = 2055832509(0x7a8983bd, float:3.570083E35)
            if (r4 == r11) goto L_0x0034
            goto L_0x0067
        L_0x0034:
            java.lang.String r4 = "stacktrace"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0067
            r2 = 3
            goto L_0x0068
        L_0x003e:
            java.lang.String r4 = "type"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0067
            r2 = 2
            goto L_0x0068
        L_0x0049:
            java.lang.String r4 = "name"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0067
            r2 = 1
            goto L_0x0068
        L_0x0053:
            java.lang.String r4 = "id"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0067
            r2 = 0
            goto L_0x0068
        L_0x005d:
            java.lang.String r4 = "errorReportingThread"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0067
            r2 = 4
            goto L_0x0068
        L_0x0067:
            r2 = -1
        L_0x0068:
            switch(r2) {
                case 0: goto L_0x0087;
                case 1: goto L_0x0081;
                case 2: goto L_0x007b;
                case 3: goto L_0x0075;
                case 4: goto L_0x006f;
                default: goto L_0x006b;
            }
        L_0x006b:
            r12.skipValue()
            goto L_0x000c
        L_0x006f:
            boolean r2 = r12.nextBoolean()
            r9 = r2
            goto L_0x000c
        L_0x0075:
            java.util.List r2 = readStackFrames(r12)
            r10 = r2
            goto L_0x000c
        L_0x007b:
            java.lang.String r2 = r12.nextString()
            r8 = r2
            goto L_0x000c
        L_0x0081:
            java.lang.String r2 = r12.nextString()
            r7 = r2
            goto L_0x000c
        L_0x0087:
            long r2 = r12.nextLong()
            r5 = r2
            goto L_0x000c
        L_0x008d:
            r12.endObject()
            if (r8 == 0) goto L_0x009b
            if (r10 == 0) goto L_0x009b
            com.bugsnag.android.CachedThread r12 = new com.bugsnag.android.CachedThread
            r4 = r12
            r4.<init>((long) r5, (java.lang.String) r7, (java.lang.String) r8, (boolean) r9, (java.util.List<java.util.Map<java.lang.String, java.lang.Object>>) r10)
            return r12
        L_0x009b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.ErrorReader.readThread(android.util.JsonReader):com.bugsnag.android.CachedThread");
    }

    private static Map<String, Object> jsonObjectToMap(JsonReader jsonReader) throws IOException {
        HashMap hashMap = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object coerceSerializableFromJSON = coerceSerializableFromJSON(jsonReader);
            if (coerceSerializableFromJSON != null) {
                hashMap.put(nextName, coerceSerializableFromJSON);
            }
        }
        jsonReader.endObject();
        return hashMap;
    }

    private static <T> List<T> jsonArrayToList(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            Object coerceSerializableFromJSON = coerceSerializableFromJSON(jsonReader);
            if (coerceSerializableFromJSON != null) {
                arrayList.add(coerceSerializableFromJSON);
            }
        }
        jsonReader.endArray();
        return arrayList;
    }

    private static <T> T coerceSerializableFromJSON(JsonReader jsonReader) throws IOException {
        switch (C08361.$SwitchMap$android$util$JsonToken[jsonReader.peek().ordinal()]) {
            case 1:
                return jsonReader.nextString();
            case 2:
                return deserializeNumber(jsonReader);
            case 3:
                return jsonObjectToMap(jsonReader);
            case 4:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 5:
                return jsonArrayToList(jsonReader);
            default:
                return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        return java.lang.Long.valueOf(r2.nextLong());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        return java.lang.Double.valueOf(r2.nextDouble());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T deserializeNumber(android.util.JsonReader r2) throws java.io.IOException {
        /*
            int r0 = r2.nextInt()     // Catch:{ NumberFormatException -> 0x0009 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0009 }
            return r0
        L_0x0009:
            long r0 = r2.nextLong()     // Catch:{ NumberFormatException -> 0x0012 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0012 }
            return r0
        L_0x0012:
            double r0 = r2.nextDouble()
            java.lang.Double r2 = java.lang.Double.valueOf(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.ErrorReader.deserializeNumber(android.util.JsonReader):java.lang.Object");
    }
}
