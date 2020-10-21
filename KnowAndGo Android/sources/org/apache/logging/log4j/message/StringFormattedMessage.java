package org.apache.logging.log4j.message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.IllegalFormatException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.status.StatusLogger;

public class StringFormattedMessage implements Message {
    private static final int HASHVAL = 31;
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final long serialVersionUID = -665975803997290697L;
    private transient Object[] argArray;
    private transient String formattedMessage;
    private String messagePattern;
    private String[] stringArgs;
    private transient Throwable throwable;

    public StringFormattedMessage(String str, Object... objArr) {
        this.messagePattern = str;
        this.argArray = objArr;
        if (objArr != null && objArr.length > 0 && (objArr[objArr.length - 1] instanceof Throwable)) {
            this.throwable = objArr[objArr.length - 1];
        }
    }

    public String getFormattedMessage() {
        if (this.formattedMessage == null) {
            this.formattedMessage = formatMessage(this.messagePattern, this.argArray);
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
    public String formatMessage(String str, Object... objArr) {
        try {
            return String.format(str, objArr);
        } catch (IllegalFormatException e) {
            Logger logger = LOGGER;
            logger.error("Unable to format msg: " + str, (Throwable) e);
            return str;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StringFormattedMessage stringFormattedMessage = (StringFormattedMessage) obj;
        if (this.messagePattern == null ? stringFormattedMessage.messagePattern == null : this.messagePattern.equals(stringFormattedMessage.messagePattern)) {
            return Arrays.equals(this.stringArgs, stringFormattedMessage.stringArgs);
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
        return "StringFormatMessage[messagePattern=" + this.messagePattern + ", args=" + Arrays.toString(this.argArray) + ']';
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
        return this.throwable;
    }
}
