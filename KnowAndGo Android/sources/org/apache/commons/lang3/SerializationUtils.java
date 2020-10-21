package org.apache.commons.lang3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SerializationUtils {
    public static <T extends Serializable> T clone(T t) {
        ClassLoaderAwareObjectInputStream classLoaderAwareObjectInputStream;
        if (t == null) {
            return null;
        }
        try {
            classLoaderAwareObjectInputStream = new ClassLoaderAwareObjectInputStream(new ByteArrayInputStream(serialize(t)), t.getClass().getClassLoader());
            T t2 = (Serializable) classLoaderAwareObjectInputStream.readObject();
            classLoaderAwareObjectInputStream.close();
            return t2;
        } catch (ClassNotFoundException e) {
            throw new SerializationException("ClassNotFoundException while reading cloned object data", e);
        } catch (IOException e2) {
            throw new SerializationException("IOException while reading or closing cloned object data", e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static <T extends Serializable> T roundtrip(T t) {
        return (Serializable) deserialize(serialize(t));
    }

    public static void serialize(Serializable serializable, OutputStream outputStream) {
        ObjectOutputStream objectOutputStream;
        Validate.isTrue(outputStream != null, "The OutputStream must not be null", new Object[0]);
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return;
        } catch (IOException e) {
            throw new SerializationException((Throwable) e);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static byte[] serialize(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        serialize(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0023, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0024, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002a, code lost:
        throw new org.apache.commons.lang3.SerializationException(r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0024 A[ExcHandler: IOException | ClassNotFoundException (r3v1 'e' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:5:0x000d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T deserialize(java.io.InputStream r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0005
            r1 = 1
            goto L_0x0006
        L_0x0005:
            r1 = 0
        L_0x0006:
            java.lang.String r2 = "The InputStream must not be null"
            java.lang.Object[] r0 = new java.lang.Object[r0]
            org.apache.commons.lang3.Validate.isTrue((boolean) r1, (java.lang.String) r2, (java.lang.Object[]) r0)
            java.io.ObjectInputStream r0 = new java.io.ObjectInputStream     // Catch:{ IOException | ClassNotFoundException -> 0x0024 }
            r0.<init>(r3)     // Catch:{ IOException | ClassNotFoundException -> 0x0024 }
            java.lang.Object r3 = r0.readObject()     // Catch:{ Throwable -> 0x001a, IOException | ClassNotFoundException -> 0x0024 }
            r0.close()     // Catch:{ IOException | ClassNotFoundException -> 0x0024 }
            return r3
        L_0x001a:
            r3 = move-exception
            r0.close()     // Catch:{ Throwable -> 0x001f, IOException | ClassNotFoundException -> 0x0024 }
            goto L_0x0023
        L_0x001f:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch:{ IOException | ClassNotFoundException -> 0x0024 }
        L_0x0023:
            throw r3     // Catch:{ IOException | ClassNotFoundException -> 0x0024 }
        L_0x0024:
            r3 = move-exception
            org.apache.commons.lang3.SerializationException r0 = new org.apache.commons.lang3.SerializationException
            r0.<init>((java.lang.Throwable) r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.SerializationUtils.deserialize(java.io.InputStream):java.lang.Object");
    }

    public static <T> T deserialize(byte[] bArr) {
        Validate.isTrue(bArr != null, "The byte[] must not be null", new Object[0]);
        return deserialize((InputStream) new ByteArrayInputStream(bArr));
    }

    static class ClassLoaderAwareObjectInputStream extends ObjectInputStream {
        private static final Map<String, Class<?>> primitiveTypes = new HashMap();
        private final ClassLoader classLoader;

        static {
            primitiveTypes.put("byte", Byte.TYPE);
            primitiveTypes.put("short", Short.TYPE);
            primitiveTypes.put("int", Integer.TYPE);
            primitiveTypes.put("long", Long.TYPE);
            primitiveTypes.put("float", Float.TYPE);
            primitiveTypes.put("double", Double.TYPE);
            primitiveTypes.put("boolean", Boolean.TYPE);
            primitiveTypes.put("char", Character.TYPE);
            primitiveTypes.put("void", Void.TYPE);
        }

        ClassLoaderAwareObjectInputStream(InputStream inputStream, ClassLoader classLoader2) throws IOException {
            super(inputStream);
            this.classLoader = classLoader2;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
            return java.lang.Class.forName(r3, false, java.lang.Thread.currentThread().getContextClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
            r3 = primitiveTypes.get(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
            if (r3 != null) goto L_0x0024;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Class<?> resolveClass(java.io.ObjectStreamClass r3) throws java.io.IOException, java.lang.ClassNotFoundException {
            /*
                r2 = this;
                java.lang.String r3 = r3.getName()
                r0 = 0
                java.lang.ClassLoader r1 = r2.classLoader     // Catch:{ ClassNotFoundException -> 0x000c }
                java.lang.Class r1 = java.lang.Class.forName(r3, r0, r1)     // Catch:{ ClassNotFoundException -> 0x000c }
                return r1
            L_0x000c:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ ClassNotFoundException -> 0x0019 }
                java.lang.ClassLoader r1 = r1.getContextClassLoader()     // Catch:{ ClassNotFoundException -> 0x0019 }
                java.lang.Class r0 = java.lang.Class.forName(r3, r0, r1)     // Catch:{ ClassNotFoundException -> 0x0019 }
                return r0
            L_0x0019:
                r0 = move-exception
                java.util.Map<java.lang.String, java.lang.Class<?>> r1 = primitiveTypes
                java.lang.Object r3 = r1.get(r3)
                java.lang.Class r3 = (java.lang.Class) r3
                if (r3 == 0) goto L_0x0025
                return r3
            L_0x0025:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream.resolveClass(java.io.ObjectStreamClass):java.lang.Class");
        }
    }
}
