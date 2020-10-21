package com.polidea.multiplatformbleadapter.utils;

import kotlin.UByte;

public class ByteUtils {
    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & UByte.MAX_VALUE;
            int i2 = i * 2;
            cArr[i2] = hexArray[b >>> 4];
            cArr[i2 + 1] = hexArray[b & 15];
        }
        return new String(cArr);
    }
}
