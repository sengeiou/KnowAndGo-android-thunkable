package org.apache.logging.log4j.message;

import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.text.Typography;
import org.apache.logging.log4j.util.EnglishEnums;

public class MapMessage implements MultiformatMessage {
    private static final long serialVersionUID = -5031471831131487120L;
    private final SortedMap<String, String> data;

    public enum MapFormat {
        XML,
        JSON,
        JAVA
    }

    public String getFormat() {
        return "";
    }

    public Throwable getThrowable() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void validate(String str, String str2) {
    }

    public MapMessage() {
        this.data = new TreeMap();
    }

    public MapMessage(Map<String, String> map) {
        this.data = map instanceof SortedMap ? (SortedMap) map : new TreeMap<>(map);
    }

    public String[] getFormats() {
        String[] strArr = new String[MapFormat.values().length];
        MapFormat[] values = MapFormat.values();
        int length = values.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            strArr[i2] = values[i].name();
            i++;
            i2++;
        }
        return strArr;
    }

    public Object[] getParameters() {
        return this.data.values().toArray();
    }

    public Map<String, String> getData() {
        return Collections.unmodifiableMap(this.data);
    }

    public void clear() {
        this.data.clear();
    }

    public void put(String str, String str2) {
        if (str2 != null) {
            validate(str, str2);
            this.data.put(str, str2);
            return;
        }
        throw new IllegalArgumentException("No value provided for key " + str);
    }

    public void putAll(Map<String, String> map) {
        this.data.putAll(map);
    }

    public String get(String str) {
        return (String) this.data.get(str);
    }

    public String remove(String str) {
        return (String) this.data.remove(str);
    }

    public String asString() {
        return asString((MapFormat) null);
    }

    public String asString(String str) {
        try {
            return asString((MapFormat) EnglishEnums.valueOf(MapFormat.class, str));
        } catch (IllegalArgumentException unused) {
            return asString();
        }
    }

    private String asString(MapFormat mapFormat) {
        StringBuilder sb = new StringBuilder();
        if (mapFormat != null) {
            switch (mapFormat) {
                case XML:
                    asXml(sb);
                    break;
                case JSON:
                    asJson(sb);
                    break;
                case JAVA:
                    asJava(sb);
                    break;
                default:
                    appendMap(sb);
                    break;
            }
        } else {
            appendMap(sb);
        }
        return sb.toString();
    }

    public void asXml(StringBuilder sb) {
        sb.append("<Map>\n");
        for (Map.Entry next : this.data.entrySet()) {
            sb.append("  <Entry key=\"");
            sb.append((String) next.getKey());
            sb.append("\">");
            sb.append((String) next.getValue());
            sb.append("</Entry>\n");
        }
        sb.append("</Map>");
    }

    public String getFormattedMessage() {
        return asString();
    }

    public String getFormattedMessage(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return asString();
        }
        for (String str : strArr) {
            for (MapFormat mapFormat : MapFormat.values()) {
                if (mapFormat.name().equalsIgnoreCase(str)) {
                    return asString(mapFormat);
                }
            }
        }
        return asString();
    }

    /* access modifiers changed from: protected */
    public void appendMap(StringBuilder sb) {
        boolean z = true;
        for (Map.Entry next : this.data.entrySet()) {
            if (!z) {
                sb.append(' ');
            }
            z = false;
            sb.append((String) next.getKey());
            sb.append("=\"");
            sb.append((String) next.getValue());
            sb.append(Typography.quote);
        }
    }

    /* access modifiers changed from: protected */
    public void asJson(StringBuilder sb) {
        sb.append('{');
        boolean z = true;
        for (Map.Entry next : this.data.entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            z = false;
            sb.append(Typography.quote);
            sb.append((String) next.getKey());
            sb.append("\":");
            sb.append(Typography.quote);
            sb.append((String) next.getValue());
            sb.append(Typography.quote);
        }
        sb.append('}');
    }

    /* access modifiers changed from: protected */
    public void asJava(StringBuilder sb) {
        sb.append('{');
        boolean z = true;
        for (Map.Entry next : this.data.entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            z = false;
            sb.append((String) next.getKey());
            sb.append("=\"");
            sb.append((String) next.getValue());
            sb.append(Typography.quote);
        }
        sb.append('}');
    }

    public MapMessage newInstance(Map<String, String> map) {
        return new MapMessage(map);
    }

    public String toString() {
        return asString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.data.equals(((MapMessage) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }
}
