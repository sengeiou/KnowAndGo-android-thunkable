package org.apache.logging.log4j.message;

import java.util.Map;
import org.apache.logging.log4j.util.EnglishEnums;

public class StructuredDataMessage extends MapMessage {
    private static final int HASHVAL = 31;
    private static final int MAX_LENGTH = 32;
    private static final long serialVersionUID = 1703221292892071920L;

    /* renamed from: id */
    private StructuredDataId f3046id;
    private String message;
    private String type;

    public enum Format {
        XML,
        FULL
    }

    public StructuredDataMessage(String str, String str2, String str3) {
        this.f3046id = new StructuredDataId(str, (String[]) null, (String[]) null);
        this.message = str2;
        this.type = str3;
    }

    public StructuredDataMessage(String str, String str2, String str3, Map<String, String> map) {
        super(map);
        this.f3046id = new StructuredDataId(str, (String[]) null, (String[]) null);
        this.message = str2;
        this.type = str3;
    }

    public StructuredDataMessage(StructuredDataId structuredDataId, String str, String str2) {
        this.f3046id = structuredDataId;
        this.message = str;
        this.type = str2;
    }

    public StructuredDataMessage(StructuredDataId structuredDataId, String str, String str2, Map<String, String> map) {
        super(map);
        this.f3046id = structuredDataId;
        this.message = str;
        this.type = str2;
    }

    private StructuredDataMessage(StructuredDataMessage structuredDataMessage, Map<String, String> map) {
        super(map);
        this.f3046id = structuredDataMessage.f3046id;
        this.message = structuredDataMessage.message;
        this.type = structuredDataMessage.type;
    }

    protected StructuredDataMessage() {
    }

    public String[] getFormats() {
        String[] strArr = new String[Format.values().length];
        Format[] values = Format.values();
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

    public StructuredDataId getId() {
        return this.f3046id;
    }

    /* access modifiers changed from: protected */
    public void setId(String str) {
        this.f3046id = new StructuredDataId(str, (String[]) null, (String[]) null);
    }

    /* access modifiers changed from: protected */
    public void setId(StructuredDataId structuredDataId) {
        this.f3046id = structuredDataId;
    }

    public String getType() {
        return this.type;
    }

    /* access modifiers changed from: protected */
    public void setType(String str) {
        if (str.length() <= 32) {
            this.type = str;
            return;
        }
        throw new IllegalArgumentException("structured data type exceeds maximum length of 32 characters: " + str);
    }

    public String getFormat() {
        return this.message;
    }

    /* access modifiers changed from: protected */
    public void setMessageFormat(String str) {
        this.message = str;
    }

    /* access modifiers changed from: protected */
    public void validate(String str, String str2) {
        validateKey(str);
    }

    private void validateKey(String str) {
        if (str.length() <= 32) {
            for (char c : str.toCharArray()) {
                if (c < '!' || c > '~' || c == '=' || c == ']' || c == '\"') {
                    throw new IllegalArgumentException("Structured data keys must contain printable US ASCII charactersand may not contain a space, =, ], or \"");
                }
            }
            return;
        }
        throw new IllegalArgumentException("Structured data keys are limited to 32 characters. key: " + str);
    }

    public String asString() {
        return asString(Format.FULL, (StructuredDataId) null);
    }

    public String asString(String str) {
        try {
            return asString((Format) EnglishEnums.valueOf(Format.class, str), (StructuredDataId) null);
        } catch (IllegalArgumentException unused) {
            return asString();
        }
    }

    public final String asString(Format format, StructuredDataId structuredDataId) {
        String format2;
        StringBuilder sb = new StringBuilder();
        boolean equals = Format.FULL.equals(format);
        if (equals) {
            if (getType() == null) {
                return sb.toString();
            }
            sb.append(getType());
            sb.append(' ');
        }
        StructuredDataId id = getId();
        if (id != null) {
            structuredDataId = id.makeId(structuredDataId);
        }
        if (structuredDataId == null || structuredDataId.getName() == null) {
            return sb.toString();
        }
        sb.append('[');
        sb.append(structuredDataId);
        sb.append(' ');
        appendMap(sb);
        sb.append(']');
        if (equals && (format2 = getFormat()) != null) {
            sb.append(' ');
            sb.append(format2);
        }
        return sb.toString();
    }

    public String getFormattedMessage() {
        return asString(Format.FULL, (StructuredDataId) null);
    }

    public String getFormattedMessage(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return asString(Format.FULL, (StructuredDataId) null);
        }
        for (String str : strArr) {
            if (Format.XML.name().equalsIgnoreCase(str)) {
                return asXml();
            }
            if (Format.FULL.name().equalsIgnoreCase(str)) {
                return asString(Format.FULL, (StructuredDataId) null);
            }
        }
        return asString((Format) null, (StructuredDataId) null);
    }

    private String asXml() {
        StringBuilder sb = new StringBuilder();
        StructuredDataId id = getId();
        if (id == null || id.getName() == null || this.type == null) {
            return sb.toString();
        }
        sb.append("<StructuredData>\n");
        sb.append("<type>");
        sb.append(this.type);
        sb.append("</type>\n");
        sb.append("<id>");
        sb.append(id);
        sb.append("</id>\n");
        super.asXml(sb);
        sb.append("</StructuredData>\n");
        return sb.toString();
    }

    public String toString() {
        return asString((Format) null, (StructuredDataId) null);
    }

    public MapMessage newInstance(Map<String, String> map) {
        return new StructuredDataMessage(this, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StructuredDataMessage structuredDataMessage = (StructuredDataMessage) obj;
        if (!super.equals(obj)) {
            return false;
        }
        if (this.type == null ? structuredDataMessage.type != null : !this.type.equals(structuredDataMessage.type)) {
            return false;
        }
        if (this.f3046id == null ? structuredDataMessage.f3046id == null : this.f3046id.equals(structuredDataMessage.f3046id)) {
            return this.message == null ? structuredDataMessage.message == null : this.message.equals(structuredDataMessage.message);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((super.hashCode() * 31) + (this.type != null ? this.type.hashCode() : 0)) * 31) + (this.f3046id != null ? this.f3046id.hashCode() : 0)) * 31;
        if (this.message != null) {
            i = this.message.hashCode();
        }
        return hashCode + i;
    }
}
