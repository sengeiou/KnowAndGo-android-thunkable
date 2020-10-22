package org.apache.logging.log4j.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.status.StatusLogger;

public final class PropertiesUtil {
    private static final PropertiesUtil LOG4J_PROPERTIES = new PropertiesUtil("log4j2.component.properties");
    private static final Logger LOGGER = StatusLogger.getLogger();
    private final Properties props;

    public PropertiesUtil(Properties properties) {
        this.props = properties;
    }

    static Properties loadClose(InputStream inputStream, Object obj) {
        Logger logger;
        String str;
        Object[] objArr;
        Properties properties = new Properties();
        if (inputStream != null) {
            try {
                properties.load(inputStream);
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger = LOGGER;
                    str = "Unable to close {}";
                    objArr = new Object[]{obj, e};
                }
            } catch (IOException e2) {
                LOGGER.error("Unable to read {}", obj, e2);
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    logger = LOGGER;
                    str = "Unable to close {}";
                    objArr = new Object[]{obj, e3};
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    LOGGER.error("Unable to close {}", obj, e4);
                }
                throw th;
            }
        }
        return properties;
        logger.error(str, objArr);
        return properties;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e A[SYNTHETIC, Splitter:B:23:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074 A[SYNTHETIC, Splitter:B:28:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0010 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PropertiesUtil(java.lang.String r13) {
        /*
            r12 = this;
            r12.<init>()
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            java.util.Collection r13 = org.apache.logging.log4j.util.LoaderUtil.findResources(r13)
            java.util.Iterator r13 = r13.iterator()
        L_0x0010:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x008b
            java.lang.Object r1 = r13.next()
            java.net.URL r1 = (java.net.URL) r1
            r2 = 0
            r3 = 1
            r4 = 0
            r5 = 2
            java.io.InputStream r6 = r1.openStream()     // Catch:{ IOException -> 0x0047, all -> 0x0044 }
            r0.load(r6)     // Catch:{ IOException -> 0x0042 }
            if (r6 == 0) goto L_0x0010
            r6.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0010
        L_0x002d:
            r2 = move-exception
            org.apache.logging.log4j.Logger r6 = LOGGER
            java.lang.String r7 = "Unable to close {}"
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r1 = r1.toString()
            r5[r4] = r1
            r5[r3] = r2
        L_0x003c:
            r6.error((java.lang.String) r7, (java.lang.Object[]) r5)
            goto L_0x0010
        L_0x0040:
            r13 = move-exception
            goto L_0x0072
        L_0x0042:
            r2 = move-exception
            goto L_0x004b
        L_0x0044:
            r13 = move-exception
            r6 = r2
            goto L_0x0072
        L_0x0047:
            r6 = move-exception
            r11 = r6
            r6 = r2
            r2 = r11
        L_0x004b:
            org.apache.logging.log4j.Logger r7 = LOGGER     // Catch:{ all -> 0x0040 }
            java.lang.String r8 = "Unable to read {}"
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ all -> 0x0040 }
            java.lang.String r10 = r1.toString()     // Catch:{ all -> 0x0040 }
            r9[r4] = r10     // Catch:{ all -> 0x0040 }
            r9[r3] = r2     // Catch:{ all -> 0x0040 }
            r7.error((java.lang.String) r8, (java.lang.Object[]) r9)     // Catch:{ all -> 0x0040 }
            if (r6 == 0) goto L_0x0010
            r6.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0010
        L_0x0062:
            r2 = move-exception
            org.apache.logging.log4j.Logger r6 = LOGGER
            java.lang.String r7 = "Unable to close {}"
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r1 = r1.toString()
            r5[r4] = r1
            r5[r3] = r2
            goto L_0x003c
        L_0x0072:
            if (r6 == 0) goto L_0x008a
            r6.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x008a
        L_0x0078:
            r0 = move-exception
            org.apache.logging.log4j.Logger r2 = LOGGER
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r1 = r1.toString()
            r5[r4] = r1
            r5[r3] = r0
            java.lang.String r0 = "Unable to close {}"
            r2.error((java.lang.String) r0, (java.lang.Object[]) r5)
        L_0x008a:
            throw r13
        L_0x008b:
            r12.props = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.logging.log4j.util.PropertiesUtil.<init>(java.lang.String):void");
    }

    public static PropertiesUtil getProperties() {
        return LOG4J_PROPERTIES;
    }

    public String getStringProperty(String str) {
        String str2;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException unused) {
            str2 = null;
        }
        return str2 == null ? this.props.getProperty(str) : str2;
    }

    public int getIntegerProperty(String str, int i) {
        String str2;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException unused) {
            str2 = null;
        }
        if (str2 == null) {
            str2 = this.props.getProperty(str);
        }
        if (str2 == null) {
            return i;
        }
        try {
            return Integer.parseInt(str2);
        } catch (Exception unused2) {
            return i;
        }
    }

    public long getLongProperty(String str, long j) {
        String str2;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException unused) {
            str2 = null;
        }
        if (str2 == null) {
            str2 = this.props.getProperty(str);
        }
        if (str2 == null) {
            return j;
        }
        try {
            return Long.parseLong(str2);
        } catch (Exception unused2) {
            return j;
        }
    }

    public String getStringProperty(String str, String str2) {
        String stringProperty = getStringProperty(str);
        return stringProperty == null ? str2 : stringProperty;
    }

    public boolean getBooleanProperty(String str) {
        return getBooleanProperty(str, false);
    }

    public boolean getBooleanProperty(String str, boolean z) {
        String stringProperty = getStringProperty(str);
        return stringProperty == null ? z : "true".equalsIgnoreCase(stringProperty);
    }

    public static Properties getSystemProperties() {
        try {
            return new Properties(System.getProperties());
        } catch (SecurityException e) {
            LOGGER.error("Unable to access system properties.", (Throwable) e);
            return new Properties();
        }
    }
}
