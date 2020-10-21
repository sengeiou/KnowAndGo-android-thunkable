package org.apache.logging.log4j.message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.apache.logging.log4j.status.StatusLogger;

public class LocalizedMessage implements Message, LoggerNameAwareMessage {
    private static final long serialVersionUID = 3893703791567290742L;
    private transient Object[] argArray;
    private String baseName;
    private String formattedMessage;
    private String key;
    private final Locale locale;
    private transient StatusLogger logger;
    private String loggerName;
    private transient ResourceBundle resourceBundle;
    private String[] stringArgs;
    private transient Throwable throwable;

    public LocalizedMessage(String str, Object[] objArr) {
        this((ResourceBundle) null, (Locale) null, str, objArr);
    }

    public LocalizedMessage(String str, String str2, Object[] objArr) {
        this(str, (Locale) null, str2, objArr);
    }

    public LocalizedMessage(ResourceBundle resourceBundle2, String str, Object[] objArr) {
        this(resourceBundle2, (Locale) null, str, objArr);
    }

    public LocalizedMessage(String str, Locale locale2, String str2, Object[] objArr) {
        this.logger = StatusLogger.getLogger();
        this.key = str2;
        this.argArray = objArr;
        this.throwable = null;
        this.baseName = str;
        this.resourceBundle = null;
        this.locale = locale2;
    }

    public LocalizedMessage(ResourceBundle resourceBundle2, Locale locale2, String str, Object[] objArr) {
        this.logger = StatusLogger.getLogger();
        this.key = str;
        this.argArray = objArr;
        this.throwable = null;
        this.baseName = null;
        this.resourceBundle = resourceBundle2;
        this.locale = locale2;
    }

    public LocalizedMessage(Locale locale2, String str, Object[] objArr) {
        this((ResourceBundle) null, locale2, str, objArr);
    }

    public LocalizedMessage(String str, Object obj) {
        this((ResourceBundle) null, (Locale) null, str, new Object[]{obj});
    }

    public LocalizedMessage(String str, String str2, Object obj) {
        this(str, (Locale) null, str2, new Object[]{obj});
    }

    public LocalizedMessage(ResourceBundle resourceBundle2, String str, Object obj) {
        this(resourceBundle2, (Locale) null, str, new Object[]{obj});
    }

    public LocalizedMessage(String str, Locale locale2, String str2, Object obj) {
        this(str, locale2, str2, new Object[]{obj});
    }

    public LocalizedMessage(ResourceBundle resourceBundle2, Locale locale2, String str, Object obj) {
        this(resourceBundle2, locale2, str, new Object[]{obj});
    }

    public LocalizedMessage(Locale locale2, String str, Object obj) {
        this((ResourceBundle) null, locale2, str, new Object[]{obj});
    }

    public LocalizedMessage(String str, Object obj, Object obj2) {
        this((ResourceBundle) null, (Locale) null, str, new Object[]{obj, obj2});
    }

    public LocalizedMessage(String str, String str2, Object obj, Object obj2) {
        this(str, (Locale) null, str2, new Object[]{obj, obj2});
    }

    public LocalizedMessage(ResourceBundle resourceBundle2, String str, Object obj, Object obj2) {
        this(resourceBundle2, (Locale) null, str, new Object[]{obj, obj2});
    }

    public LocalizedMessage(String str, Locale locale2, String str2, Object obj, Object obj2) {
        this(str, locale2, str2, new Object[]{obj, obj2});
    }

    public LocalizedMessage(ResourceBundle resourceBundle2, Locale locale2, String str, Object obj, Object obj2) {
        this(resourceBundle2, locale2, str, new Object[]{obj, obj2});
    }

    public LocalizedMessage(Locale locale2, String str, Object obj, Object obj2) {
        this((ResourceBundle) null, locale2, str, new Object[]{obj, obj2});
    }

    public void setLoggerName(String str) {
        this.loggerName = str;
    }

    public String getLoggerName() {
        return this.loggerName;
    }

    public String getFormattedMessage() {
        if (this.formattedMessage != null) {
            return this.formattedMessage;
        }
        ResourceBundle resourceBundle2 = this.resourceBundle;
        if (resourceBundle2 == null) {
            if (this.baseName != null) {
                resourceBundle2 = getResourceBundle(this.baseName, this.locale, false);
            } else {
                resourceBundle2 = getResourceBundle(this.loggerName, this.locale, true);
            }
        }
        String format = getFormat();
        if (resourceBundle2 != null && resourceBundle2.containsKey(format)) {
            format = resourceBundle2.getString(format);
        }
        FormattedMessage formattedMessage2 = new FormattedMessage(format, this.argArray == null ? this.stringArgs : this.argArray);
        this.formattedMessage = formattedMessage2.getFormattedMessage();
        this.throwable = formattedMessage2.getThrowable();
        return this.formattedMessage;
    }

    public String getFormat() {
        return this.key;
    }

    public Object[] getParameters() {
        if (this.argArray != null) {
            return this.argArray;
        }
        return this.stringArgs;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    /* access modifiers changed from: protected */
    public ResourceBundle getResourceBundle(String str, Locale locale2, boolean z) {
        ResourceBundle bundle;
        ResourceBundle bundle2;
        ResourceBundle resourceBundle2 = null;
        if (str == null) {
            return null;
        }
        if (locale2 != null) {
            try {
                bundle2 = ResourceBundle.getBundle(str, locale2);
            } catch (MissingResourceException unused) {
                if (!z) {
                    StatusLogger statusLogger = this.logger;
                    statusLogger.debug("Unable to locate ResourceBundle " + str);
                    return null;
                }
            }
        } else {
            bundle2 = ResourceBundle.getBundle(str);
        }
        resourceBundle2 = bundle2;
        while (resourceBundle2 == null) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf <= 0) {
                break;
            }
            str = str.substring(0, lastIndexOf);
            if (locale2 != null) {
                try {
                    bundle = ResourceBundle.getBundle(str, locale2);
                } catch (MissingResourceException unused2) {
                    StatusLogger statusLogger2 = this.logger;
                    statusLogger2.debug("Unable to locate ResourceBundle " + str);
                }
            } else {
                bundle = ResourceBundle.getBundle(str);
            }
            resourceBundle2 = bundle;
        }
        return resourceBundle2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        getFormattedMessage();
        objectOutputStream.writeUTF(this.formattedMessage);
        objectOutputStream.writeUTF(this.key);
        objectOutputStream.writeUTF(this.baseName);
        objectOutputStream.writeInt(this.argArray.length);
        this.stringArgs = new String[this.argArray.length];
        int i = 0;
        for (Object obj : this.argArray) {
            this.stringArgs[i] = obj.toString();
            i++;
        }
        objectOutputStream.writeObject(this.stringArgs);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.formattedMessage = objectInputStream.readUTF();
        this.key = objectInputStream.readUTF();
        this.baseName = objectInputStream.readUTF();
        objectInputStream.readInt();
        this.stringArgs = (String[]) objectInputStream.readObject();
        this.logger = StatusLogger.getLogger();
        this.resourceBundle = null;
        this.argArray = null;
    }
}
