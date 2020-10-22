package com.uxcam.internals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* renamed from: com.uxcam.internals.fr */
public final class C3174fr {
    /* renamed from: a */
    public static String m2007a(File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (IOException e) {
                        throw new RuntimeException("Unable to process file for MD5", e);
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            Object[] objArr = {"Exception on closing MD5 input stream", e2};
                            C2970bc.m1237b();
                        }
                        throw th;
                    }
                }
                String replace = String.format("%32s", new Object[]{new BigInteger(1, instance.digest()).toString(16)}).replace(' ', '0');
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    Object[] objArr2 = {"Exception on closing MD5 input stream", e3};
                    C2970bc.m1237b();
                }
                return replace;
            } catch (FileNotFoundException e4) {
                Object[] objArr3 = {"Exception while getting FileInputStream", e4};
                C2970bc.m1237b();
                return null;
            }
        } catch (NoSuchAlgorithmException e5) {
            Object[] objArr4 = {"Exception while getting digest", e5};
            C2970bc.m1237b();
            return null;
        }
    }
}
