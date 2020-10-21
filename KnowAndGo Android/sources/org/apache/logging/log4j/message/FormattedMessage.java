package org.apache.logging.log4j.message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FormattedMessage implements Message {
    private static final String FORMAT_SPECIFIER = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])";
    private static final int HASHVAL = 31;
    private static final Pattern MSG_PATTERN = Pattern.compile(FORMAT_SPECIFIER);
    private static final long serialVersionUID = -665975803997290697L;
    private transient Object[] argArray;
    private transient String formattedMessage;
    private Message message;
    private String messagePattern;
    private String[] stringArgs;
    private final Throwable throwable;

    public FormattedMessage(String str, Object[] objArr, Throwable th) {
        this.messagePattern = str;
        this.argArray = objArr;
        this.throwable = th;
    }

    public FormattedMessage(String str, Object[] objArr) {
        this(str, objArr, (Throwable) null);
    }

    public FormattedMessage(String str, Object obj) {
        this(str, new Object[]{obj}, (Throwable) null);
    }

    public FormattedMessage(String str, Object obj, Object obj2) {
        this(str, new Object[]{obj, obj2});
    }

    public String getFormattedMessage() {
        if (this.formattedMessage == null) {
            if (this.message == null) {
                this.message = getMessage(this.messagePattern, this.argArray, this.throwable);
            }
            this.formattedMessage = this.message.getFormattedMessage();
        }
        return this.formattedMessage;
    }

    public String getFormat() {
        return this.messagePattern;
    }

    public Object[] getParameters() {
        if (this.argArray != null) {
            return this.argArray;
        }
        return this.stringArgs;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|(2:5|6)|7|8|(2:10|11)|12|14) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0014 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020 A[Catch:{ Exception -> 0x0026 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.logging.log4j.message.Message getMessage(java.lang.String r2, java.lang.Object[] r3, java.lang.Throwable r4) {
        /*
            r1 = this;
            java.text.MessageFormat r0 = new java.text.MessageFormat     // Catch:{ Exception -> 0x0014 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0014 }
            java.text.Format[] r0 = r0.getFormats()     // Catch:{ Exception -> 0x0014 }
            if (r0 == 0) goto L_0x0014
            int r0 = r0.length     // Catch:{ Exception -> 0x0014 }
            if (r0 <= 0) goto L_0x0014
            org.apache.logging.log4j.message.MessageFormatMessage r0 = new org.apache.logging.log4j.message.MessageFormatMessage     // Catch:{ Exception -> 0x0014 }
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x0014 }
            return r0
        L_0x0014:
            java.util.regex.Pattern r0 = MSG_PATTERN     // Catch:{ Exception -> 0x0026 }
            java.util.regex.Matcher r0 = r0.matcher(r2)     // Catch:{ Exception -> 0x0026 }
            boolean r0 = r0.find()     // Catch:{ Exception -> 0x0026 }
            if (r0 == 0) goto L_0x0026
            org.apache.logging.log4j.message.StringFormattedMessage r0 = new org.apache.logging.log4j.message.StringFormattedMessage     // Catch:{ Exception -> 0x0026 }
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x0026 }
            return r0
        L_0x0026:
            org.apache.logging.log4j.message.ParameterizedMessage r0 = new org.apache.logging.log4j.message.ParameterizedMessage
            r0.<init>((java.lang.String) r2, (java.lang.Object[]) r3, (java.lang.Throwable) r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.logging.log4j.message.FormattedMessage.getMessage(java.lang.String, java.lang.Object[], java.lang.Throwable):org.apache.logging.log4j.message.Message");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FormattedMessage formattedMessage2 = (FormattedMessage) obj;
        if (this.messagePattern == null ? formattedMessage2.messagePattern == null : this.messagePattern.equals(formattedMessage2.messagePattern)) {
            return Arrays.equals(this.stringArgs, formattedMessage2.stringArgs);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.messagePattern != null ? this.messagePattern.hashCode() : 0) * 31;
        if (this.stringArgs != null) {
            i = Arrays.hashCode(this.stringArgs);
        }
        return hashCode + i;
    }

    public String toString() {
        return "FormattedMessage[messagePattern=" + this.messagePattern + ", args=" + Arrays.toString(this.argArray) + ']';
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        getFormattedMessage();
        objectOutputStream.writeUTF(this.formattedMessage);
        objectOutputStream.writeUTF(this.messagePattern);
        objectOutputStream.writeInt(this.argArray.length);
        this.stringArgs = new String[this.argArray.length];
        int i = 0;
        for (Object obj : this.argArray) {
            this.stringArgs[i] = obj.toString();
            i++;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.formattedMessage = objectInputStream.readUTF();
        this.messagePattern = objectInputStream.readUTF();
        int readInt = objectInputStream.readInt();
        this.stringArgs = new String[readInt];
        for (int i = 0; i < readInt; i++) {
            this.stringArgs[i] = objectInputStream.readUTF();
        }
    }

    public Throwable getThrowable() {
        if (this.throwable != null) {
            return this.throwable;
        }
        if (this.message == null) {
            this.message = getMessage(this.messagePattern, this.argArray, (Throwable) null);
        }
        return this.message.getThrowable();
    }
}
