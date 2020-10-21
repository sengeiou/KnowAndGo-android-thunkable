package com.bugsnag.android;

import com.bugsnag.BugsnagReactNative;
import com.bugsnag.android.JsonStream;
import com.facebook.common.util.UriUtil;
import com.facebook.react.devsupport.StackTraceHelper;
import com.onesignal.OneSignalDbContract;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;

public class JavaScriptException extends BugsnagException implements JsonStream.Streamable {
    private static final String EXCEPTION_TYPE = "browserjs";
    private static final long serialVersionUID = 1175784680140218622L;
    private final String rawStacktrace;

    public JavaScriptException(String str, String str2, String str3) {
        super(str, str2, new StackTraceElement[0]);
        super.setType(EXCEPTION_TYPE);
        this.rawStacktrace = str3;
    }

    public void toStream(JsonStream jsonStream) throws IOException {
        jsonStream.beginObject();
        jsonStream.name("errorClass").value(getName());
        jsonStream.name(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE).value(getMessage());
        jsonStream.name("type").value(getType());
        jsonStream.name("stacktrace");
        jsonStream.beginArray();
        boolean matches = this.rawStacktrace.matches("(?s).*\\sat .* \\(.*\\d+:\\d+\\)\\s.*");
        for (String str : this.rawStacktrace.split("\\n")) {
            if (matches) {
                serialiseHermesFrame(jsonStream, str.trim());
            } else {
                serialiseJsCoreFrame(jsonStream, str.trim());
            }
        }
        jsonStream.endArray();
        jsonStream.endObject();
    }

    private void serialiseJsCoreFrame(JsonStream jsonStream, String str) throws IOException {
        jsonStream.beginObject();
        String[] split = str.split("@", 2);
        String str2 = split[0];
        if (split.length == 2) {
            jsonStream.name("method").value(split[0]);
            str2 = split[1];
        }
        int lastIndexOf = str2.lastIndexOf(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        if (lastIndexOf != -1) {
            Integer parseIntSafe = parseIntSafe(str2.substring(lastIndexOf + 1));
            if (parseIntSafe != null) {
                jsonStream.name("columnNumber").value((Number) parseIntSafe);
            }
            str2 = str2.substring(0, lastIndexOf);
        }
        int lastIndexOf2 = str2.lastIndexOf(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        if (lastIndexOf2 != -1) {
            Integer parseIntSafe2 = parseIntSafe(str2.substring(lastIndexOf2 + 1));
            if (parseIntSafe2 != null) {
                jsonStream.name(StackTraceHelper.LINE_NUMBER_KEY).value((Number) parseIntSafe2);
            }
            str2 = str2.substring(0, lastIndexOf2);
        }
        jsonStream.name(UriUtil.LOCAL_FILE_SCHEME).value(str2);
        jsonStream.endObject();
    }

    private void serialiseHermesFrame(JsonStream jsonStream, String str) throws IOException {
        int max = Math.max(str.lastIndexOf(StringUtils.SPACE), str.lastIndexOf("("));
        int lastIndexOf = str.lastIndexOf(")");
        boolean z = false;
        boolean z2 = max > -1 && max < lastIndexOf;
        int length = "at ".length();
        int indexOf = str.indexOf(" (");
        if (length < indexOf) {
            z = true;
        }
        if (z2 || z) {
            jsonStream.beginObject();
            jsonStream.name("method").value(str.substring(length, indexOf));
            if (z2) {
                String substring = str.substring(max + 1, lastIndexOf);
                jsonStream.name(UriUtil.LOCAL_FILE_SCHEME).value(substring.replaceFirst(":\\d+:\\d+$", ""));
                String[] split = substring.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
                if (split.length >= 2) {
                    Integer parseIntSafe = parseIntSafe(split[split.length - 2]);
                    Integer parseIntSafe2 = parseIntSafe(split[split.length - 1]);
                    if (parseIntSafe != null) {
                        jsonStream.name(StackTraceHelper.LINE_NUMBER_KEY).value((Number) parseIntSafe);
                    }
                    if (parseIntSafe2 != null) {
                        jsonStream.name("columnNumber").value((Number) parseIntSafe2);
                    }
                }
            }
            jsonStream.endObject();
        }
    }

    private Integer parseIntSafe(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            BugsnagReactNative.logger.info(String.format("Expected an integer, got: '%s'", new Object[]{str}));
            return null;
        }
    }
}
