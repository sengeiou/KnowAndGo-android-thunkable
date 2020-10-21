package com.uxcam.internals;

import android.util.Base64;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.uxcam.internals.at */
public final class C2959at {

    /* renamed from: a */
    byte[] f1366a = new byte[16];

    /* renamed from: b */
    private final String f1367b = "AES/CBC/PKCS5Padding";

    /* renamed from: c */
    private SecretKeySpec f1368c;

    /* renamed from: d */
    private IvParameterSpec f1369d;

    public C2959at() {
        new SecureRandom().nextBytes(this.f1366a);
        this.f1368c = new SecretKeySpec(this.f1366a, "AES");
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        this.f1369d = new IvParameterSpec(bArr);
    }

    /* renamed from: a */
    public final String mo38055a() {
        byte[] bArr = new byte[0];
        try {
            bArr = C2960au.m1210a(this.f1366a, C2960au.f1370a);
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e2) {
            e2.printStackTrace();
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
        } catch (NoSuchPaddingException e4) {
            e4.printStackTrace();
        } catch (NoSuchAlgorithmException e5) {
            e5.printStackTrace();
        }
        return Base64.encodeToString(bArr, 0).replaceAll("\\s", "");
    }

    /* renamed from: a */
    public final CipherOutputStream mo38056a(OutputStream outputStream) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, this.f1368c, this.f1369d);
            return new CipherOutputStream(outputStream, instance);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public final String mo38057b() {
        byte[] bArr = new byte[0];
        try {
            bArr = C2960au.m1210a(this.f1369d.getIV(), C2960au.f1370a);
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e2) {
            e2.printStackTrace();
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
        } catch (NoSuchPaddingException e4) {
            e4.printStackTrace();
        } catch (NoSuchAlgorithmException e5) {
            e5.printStackTrace();
        }
        return Base64.encodeToString(bArr, 0).replaceAll("\\s", "");
    }
}
