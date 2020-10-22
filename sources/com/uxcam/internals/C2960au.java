package com.uxcam.internals;

import android.util.Base64;
import androidx.annotation.RequiresApi;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

@RequiresApi(api = 8)
/* renamed from: com.uxcam.internals.au */
public final class C2960au {

    /* renamed from: a */
    public static String f1370a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNUf8CVU/4PRJebkLWYKQIMAiN\nl8n/7/F76ExbRAC8B9SxjU+weoDH25P41j3NWAV6K1t3R5Ws7NPre524akdwFqTH\nhJzkFTHpvSqjxfqTbLepDkhInppZDMvpX6INOBGZQwEdaV37QgLp6cgfsK2oRhur\nUGCDTwVQhY8SdO6riQIDAQAB";

    /* renamed from: b */
    public static String f1371b = "UNDEFINED";

    @RequiresApi(api = 8)
    /* renamed from: a */
    private static PublicKey m1209a(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m1210a(byte[] bArr, String str) {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, m1209a(str));
        return instance.doFinal(bArr);
    }
}
