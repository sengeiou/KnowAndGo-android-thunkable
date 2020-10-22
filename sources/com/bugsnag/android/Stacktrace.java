package com.bugsnag.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bugsnag.android.JsonStream;
import com.facebook.common.util.UriUtil;
import com.facebook.react.devsupport.StackTraceHelper;
import com.polidea.multiplatformbleadapter.utils.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Stacktrace implements JsonStream.Streamable {
    private static final int STACKTRACE_TRIM_LENGTH = 200;
    private final List<Map<String, Object>> trace;

    Stacktrace(StackTraceElement[] stackTraceElementArr, String[] strArr) {
        this.trace = serializeStacktrace(stackTraceElementArr, sanitiseProjectPackages(strArr));
    }

    Stacktrace(List<Map<String, Object>> list) {
        if (list.size() >= 200) {
            this.trace = list.subList(0, 200);
        } else {
            this.trace = list;
        }
    }

    public void toStream(@NonNull JsonStream jsonStream) throws IOException {
        jsonStream.beginArray();
        for (Map<String, Object> value : this.trace) {
            jsonStream.value((Object) value);
        }
        jsonStream.endArray();
    }

    private List<Map<String, Object>> serializeStacktrace(StackTraceElement[] stackTraceElementArr, List<String> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < stackTraceElementArr.length && i < 200) {
            Map<String, Object> serializeStackframe = serializeStackframe(stackTraceElementArr[i], list);
            if (serializeStackframe != null) {
                arrayList.add(serializeStackframe);
            }
            i++;
        }
        return arrayList;
    }

    @Nullable
    private Map<String, Object> serializeStackframe(StackTraceElement stackTraceElement, List<String> list) {
        String str;
        HashMap hashMap = new HashMap();
        try {
            if (stackTraceElement.getClassName().length() > 0) {
                str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
            } else {
                str = stackTraceElement.getMethodName();
            }
            hashMap.put("method", str);
            hashMap.put(UriUtil.LOCAL_FILE_SCHEME, stackTraceElement.getFileName() == null ? Constants.BluetoothState.UNKNOWN : stackTraceElement.getFileName());
            hashMap.put(StackTraceHelper.LINE_NUMBER_KEY, Integer.valueOf(stackTraceElement.getLineNumber()));
            if (inProject(stackTraceElement.getClassName(), list)) {
                hashMap.put("inProject", true);
            }
            return hashMap;
        } catch (Exception e) {
            Logger.warn("Failed to serialize stacktrace", e);
            return null;
        }
    }

    private static List<String> sanitiseProjectPackages(String[] strArr) {
        if (strArr != null) {
            return Arrays.asList(strArr);
        }
        return Collections.emptyList();
    }

    static boolean inProject(String str, String[] strArr) {
        return inProject(str, sanitiseProjectPackages(strArr));
    }

    private static boolean inProject(String str, List<String> list) {
        for (String next : list) {
            if (next != null && str.startsWith(next)) {
                return true;
            }
        }
        return false;
    }
}
