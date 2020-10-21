package com.google.android.play.core.internal;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* renamed from: com.google.android.play.core.internal.h */
public final class C2049h {
    /* renamed from: a */
    private static int m752a(int i) {
        if (i == 769) {
            return 1;
        }
        switch (i) {
            case InputDeviceCompat.SOURCE_KEYBOARD:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                switch (i) {
                    case InputDeviceCompat.SOURCE_DPAD:
                        return 1;
                    case 514:
                        return 2;
                    default:
                        String valueOf = String.valueOf(Long.toHexString((long) i));
                        throw new IllegalArgumentException(valueOf.length() != 0 ? "Unknown signature algorithm: 0x".concat(valueOf) : new String("Unknown signature algorithm: 0x"));
                }
        }
    }

    /* renamed from: a */
    public static long m753a(ByteBuffer byteBuffer) {
        m770c(byteBuffer);
        return m754a(byteBuffer, byteBuffer.position() + 16);
    }

    /* renamed from: a */
    private static long m754a(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }

    /* renamed from: a */
    static Pair<ByteBuffer, Long> m755a(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> a = m756a(randomAccessFile, 0);
        return a != null ? a : m756a(randomAccessFile, 65535);
    }

    /* renamed from: a */
    private static Pair<ByteBuffer, Long> m756a(RandomAccessFile randomAccessFile, int i) throws IOException {
        int i2;
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min((long) i, -22 + length)) + 22);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long capacity = length - ((long) allocate.capacity());
        randomAccessFile.seek(capacity);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        m770c(allocate);
        int capacity2 = allocate.capacity();
        if (capacity2 >= 22) {
            int i3 = capacity2 - 22;
            int min = Math.min(i3, 65535);
            int i4 = 0;
            while (true) {
                if (i4 >= min) {
                    break;
                }
                i2 = i3 - i4;
                if (allocate.getInt(i2) == 101010256 && ((char) allocate.getShort(i2 + 20)) == i4) {
                    break;
                }
                i4++;
            }
        }
        i2 = -1;
        if (i2 == -1) {
            return null;
        }
        allocate.position(i2);
        ByteBuffer slice = allocate.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(slice, Long.valueOf(capacity + ((long) i2)));
    }

    /* renamed from: a */
    public static String m757a(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m758a(String str, String str2, String str3) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 2 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(str2);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(str3);
        return sb.toString();
    }

    /* renamed from: a */
    private static void m759a(int i, byte[] bArr) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) (i >> 24);
    }

    /* renamed from: a */
    public static void m760a(ByteBuffer byteBuffer, long j) {
        m770c(byteBuffer);
        int position = byteBuffer.position() + 16;
        if (j < 0 || j > 4294967295L) {
            StringBuilder sb = new StringBuilder(47);
            sb.append("uint32 value of out range: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        byteBuffer.putInt(byteBuffer.position() + position, (int) j);
    }

    /* renamed from: a */
    private static void m761a(Map<Integer, byte[]> map, FileChannel fileChannel, long j, long j2, long j3, ByteBuffer byteBuffer) throws SecurityException {
        if (!map.isEmpty()) {
            C2030c cVar = new C2030c(fileChannel, 0, j);
            C2030c cVar2 = new C2030c(fileChannel, j2, j3 - j2);
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            long j4 = j;
            m760a(duplicate, j);
            C1976a aVar = new C1976a(duplicate);
            int[] iArr = new int[map.size()];
            int i = 0;
            int i2 = 0;
            for (Integer intValue : map.keySet()) {
                iArr[i2] = intValue.intValue();
                i2++;
            }
            try {
                byte[][] a = m763a(iArr, new C2003b[]{cVar, cVar2, aVar});
                while (i < iArr.length) {
                    int i3 = iArr[i];
                    Map<Integer, byte[]> map2 = map;
                    if (MessageDigest.isEqual(map.get(Integer.valueOf(i3)), a[i])) {
                        i++;
                    } else {
                        throw new SecurityException(m767b(i3).concat(" digest of contents did not verify"));
                    }
                }
            } catch (DigestException e) {
                throw new SecurityException("Failed to compute digest(s) of contents", e);
            }
        } else {
            throw new SecurityException("No digests provided");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x011d, code lost:
        r4 = android.util.Pair.create(r7, r4);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.security.cert.X509Certificate[] m762a(java.nio.ByteBuffer r20, java.util.Map<java.lang.Integer, byte[]> r21, java.security.cert.CertificateFactory r22) throws java.lang.SecurityException, java.io.IOException {
        /*
            java.nio.ByteBuffer r0 = m771d(r20)
            java.nio.ByteBuffer r1 = m771d(r20)
            byte[] r2 = m772e(r20)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = -1
            r5 = 0
            r6 = 0
            r9 = r6
            r7 = 0
            r8 = -1
        L_0x0017:
            boolean r10 = r1.hasRemaining()
            r11 = 8
            r12 = 769(0x301, float:1.078E-42)
            r13 = 1
            if (r10 == 0) goto L_0x007a
            int r7 = r7 + 1
            java.nio.ByteBuffer r10 = m771d(r1)     // Catch:{ IOException | BufferUnderflowException -> 0x0060 }
            int r14 = r10.remaining()     // Catch:{ IOException | BufferUnderflowException -> 0x0060 }
            if (r14 < r11) goto L_0x0058
            int r11 = r10.getInt()     // Catch:{ IOException | BufferUnderflowException -> 0x0060 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r11)     // Catch:{ IOException | BufferUnderflowException -> 0x0060 }
            r3.add(r14)     // Catch:{ IOException | BufferUnderflowException -> 0x0060 }
            if (r11 == r12) goto L_0x0042
            switch(r11) {
                case 257: goto L_0x0042;
                case 258: goto L_0x0042;
                case 259: goto L_0x0042;
                case 260: goto L_0x0042;
                default: goto L_0x003e;
            }     // Catch:{ IOException | BufferUnderflowException -> 0x0060 }
        L_0x003e:
            switch(r11) {
                case 513: goto L_0x0042;
                case 514: goto L_0x0042;
                default: goto L_0x0041;
            }     // Catch:{ IOException | BufferUnderflowException -> 0x0060 }
        L_0x0041:
            goto L_0x0017
        L_0x0042:
            if (r8 == r4) goto L_0x0051
            int r12 = m752a((int) r11)     // Catch:{ IOException | BufferUnderflowException -> 0x0060 }
            int r14 = m752a((int) r8)     // Catch:{ IOException | BufferUnderflowException -> 0x0060 }
            if (r12 == r13) goto L_0x0017
            if (r14 == r13) goto L_0x0051
            goto L_0x0017
        L_0x0051:
            byte[] r8 = m772e(r10)     // Catch:{ IOException | BufferUnderflowException -> 0x0060 }
            r9 = r8
            r8 = r11
            goto L_0x0017
        L_0x0058:
            java.lang.SecurityException r0 = new java.lang.SecurityException     // Catch:{ IOException | BufferUnderflowException -> 0x0060 }
            java.lang.String r1 = "Signature record too short"
            r0.<init>(r1)     // Catch:{ IOException | BufferUnderflowException -> 0x0060 }
            throw r0     // Catch:{ IOException | BufferUnderflowException -> 0x0060 }
        L_0x0060:
            r0 = move-exception
            java.lang.SecurityException r1 = new java.lang.SecurityException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 45
            r2.<init>(r3)
            java.lang.String r3 = "Failed to parse signature record #"
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x007a:
            if (r8 != r4) goto L_0x008e
            if (r7 != 0) goto L_0x0086
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = "No signatures found"
            r0.<init>(r1)
            throw r0
        L_0x0086:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = "No supported signatures found"
            r0.<init>(r1)
            throw r0
        L_0x008e:
            if (r8 == r12) goto L_0x00bd
            switch(r8) {
                case 257: goto L_0x00ba;
                case 258: goto L_0x00ba;
                case 259: goto L_0x00ba;
                case 260: goto L_0x00ba;
                default: goto L_0x0093;
            }
        L_0x0093:
            switch(r8) {
                case 513: goto L_0x00b7;
                case 514: goto L_0x00b7;
                default: goto L_0x0096;
            }
        L_0x0096:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            long r1 = (long) r8
            java.lang.String r1 = java.lang.Long.toHexString(r1)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "Unknown signature algorithm: 0x"
            int r3 = r1.length()
            if (r3 == 0) goto L_0x00ae
            java.lang.String r1 = r2.concat(r1)
            goto L_0x00b3
        L_0x00ae:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r2)
        L_0x00b3:
            r0.<init>(r1)
            throw r0
        L_0x00b7:
            java.lang.String r1 = "EC"
            goto L_0x00bf
        L_0x00ba:
            java.lang.String r1 = "RSA"
            goto L_0x00bf
        L_0x00bd:
            java.lang.String r1 = "DSA"
        L_0x00bf:
            if (r8 == r12) goto L_0x0122
            switch(r8) {
                case 257: goto L_0x010b;
                case 258: goto L_0x00f8;
                case 259: goto L_0x00f1;
                case 260: goto L_0x00ee;
                default: goto L_0x00c4;
            }
        L_0x00c4:
            switch(r8) {
                case 513: goto L_0x00eb;
                case 514: goto L_0x00e8;
                default: goto L_0x00c7;
            }
        L_0x00c7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            long r1 = (long) r8
            java.lang.String r1 = java.lang.Long.toHexString(r1)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "Unknown signature algorithm: 0x"
            int r3 = r1.length()
            if (r3 == 0) goto L_0x00df
            java.lang.String r1 = r2.concat(r1)
            goto L_0x00e4
        L_0x00df:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r2)
        L_0x00e4:
            r0.<init>(r1)
            throw r0
        L_0x00e8:
            java.lang.String r4 = "SHA512withECDSA"
            goto L_0x00f3
        L_0x00eb:
            java.lang.String r4 = "SHA256withECDSA"
            goto L_0x00f3
        L_0x00ee:
            java.lang.String r4 = "SHA512withRSA"
            goto L_0x00f3
        L_0x00f1:
            java.lang.String r4 = "SHA256withRSA"
        L_0x00f3:
            android.util.Pair r4 = android.util.Pair.create(r4, r6)
            goto L_0x0125
        L_0x00f8:
            java.security.spec.PSSParameterSpec r4 = new java.security.spec.PSSParameterSpec
            java.lang.String r15 = "SHA-512"
            java.lang.String r16 = "MGF1"
            java.security.spec.MGF1ParameterSpec r17 = java.security.spec.MGF1ParameterSpec.SHA512
            r18 = 64
            r19 = 1
            r14 = r4
            r14.<init>(r15, r16, r17, r18, r19)
            java.lang.String r7 = "SHA512withRSA/PSS"
            goto L_0x011d
        L_0x010b:
            java.security.spec.PSSParameterSpec r4 = new java.security.spec.PSSParameterSpec
            java.lang.String r15 = "SHA-256"
            java.lang.String r16 = "MGF1"
            java.security.spec.MGF1ParameterSpec r17 = java.security.spec.MGF1ParameterSpec.SHA256
            r18 = 32
            r19 = 1
            r14 = r4
            r14.<init>(r15, r16, r17, r18, r19)
            java.lang.String r7 = "SHA256withRSA/PSS"
        L_0x011d:
            android.util.Pair r4 = android.util.Pair.create(r7, r4)
            goto L_0x0125
        L_0x0122:
            java.lang.String r4 = "SHA256withDSA"
            goto L_0x00f3
        L_0x0125:
            java.lang.Object r7 = r4.first
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r4 = r4.second
            java.security.spec.AlgorithmParameterSpec r4 = (java.security.spec.AlgorithmParameterSpec) r4
            java.security.KeyFactory r1 = java.security.KeyFactory.getInstance(r1)     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException -> 0x0265 }
            java.security.spec.X509EncodedKeySpec r10 = new java.security.spec.X509EncodedKeySpec     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException -> 0x0265 }
            r10.<init>(r2)     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException -> 0x0265 }
            java.security.PublicKey r1 = r1.generatePublic(r10)     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException -> 0x0265 }
            java.security.Signature r10 = java.security.Signature.getInstance(r7)     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException -> 0x0265 }
            r10.initVerify(r1)     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException -> 0x0265 }
            if (r4 == 0) goto L_0x0146
            r10.setParameter(r4)     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException -> 0x0265 }
        L_0x0146:
            r10.update(r0)     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException -> 0x0265 }
            boolean r1 = r10.verify(r9)     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException -> 0x0265 }
            if (r1 == 0) goto L_0x0255
            r0.clear()
            java.nio.ByteBuffer r1 = m771d(r0)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r7 = r6
            r6 = 0
        L_0x015d:
            boolean r9 = r1.hasRemaining()
            if (r9 == 0) goto L_0x01a2
            int r6 = r6 + r13
            java.nio.ByteBuffer r9 = m771d(r1)     // Catch:{ IOException | BufferUnderflowException -> 0x0188 }
            int r10 = r9.remaining()     // Catch:{ IOException | BufferUnderflowException -> 0x0188 }
            if (r10 < r11) goto L_0x0180
            int r10 = r9.getInt()     // Catch:{ IOException | BufferUnderflowException -> 0x0188 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)     // Catch:{ IOException | BufferUnderflowException -> 0x0188 }
            r4.add(r12)     // Catch:{ IOException | BufferUnderflowException -> 0x0188 }
            if (r10 != r8) goto L_0x015d
            byte[] r7 = m772e(r9)     // Catch:{ IOException | BufferUnderflowException -> 0x0188 }
            goto L_0x015d
        L_0x0180:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException | BufferUnderflowException -> 0x0188 }
            java.lang.String r1 = "Record too short"
            r0.<init>(r1)     // Catch:{ IOException | BufferUnderflowException -> 0x0188 }
            throw r0     // Catch:{ IOException | BufferUnderflowException -> 0x0188 }
        L_0x0188:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 42
            r2.<init>(r3)
            java.lang.String r3 = "Failed to parse digest record #"
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x01a2:
            boolean r1 = r3.equals(r4)
            if (r1 == 0) goto L_0x024d
            int r1 = m752a((int) r8)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            r4 = r21
            java.lang.Object r3 = r4.put(r3, r7)
            byte[] r3 = (byte[]) r3
            if (r3 == 0) goto L_0x01d1
            boolean r3 = java.security.MessageDigest.isEqual(r3, r7)
            if (r3 == 0) goto L_0x01c1
            goto L_0x01d1
        L_0x01c1:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = m767b((int) r1)
            java.lang.String r2 = " contents digest does not match the digest specified by a preceding signer"
            java.lang.String r1 = r1.concat(r2)
            r0.<init>(r1)
            throw r0
        L_0x01d1:
            java.nio.ByteBuffer r0 = m771d(r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r3 = 0
        L_0x01db:
            boolean r4 = r0.hasRemaining()
            if (r4 == 0) goto L_0x0216
            int r3 = r3 + r13
            byte[] r4 = m772e(r0)
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch:{ CertificateException -> 0x01fc }
            r6.<init>(r4)     // Catch:{ CertificateException -> 0x01fc }
            r7 = r22
            java.security.cert.Certificate r6 = r7.generateCertificate(r6)     // Catch:{ CertificateException -> 0x01fc }
            java.security.cert.X509Certificate r6 = (java.security.cert.X509Certificate) r6     // Catch:{ CertificateException -> 0x01fc }
            com.google.android.play.core.internal.f r8 = new com.google.android.play.core.internal.f
            r8.<init>(r6, r4)
            r1.add(r8)
            goto L_0x01db
        L_0x01fc:
            r0 = move-exception
            java.lang.SecurityException r1 = new java.lang.SecurityException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r4 = 41
            r2.<init>(r4)
            java.lang.String r4 = "Failed to decode certificate #"
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x0216:
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x0245
            java.lang.Object r0 = r1.get(r5)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            java.security.PublicKey r0 = r0.getPublicKey()
            byte[] r0 = r0.getEncoded()
            boolean r0 = java.util.Arrays.equals(r2, r0)
            if (r0 == 0) goto L_0x023d
            int r0 = r1.size()
            java.security.cert.X509Certificate[] r0 = new java.security.cert.X509Certificate[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            java.security.cert.X509Certificate[] r0 = (java.security.cert.X509Certificate[]) r0
            return r0
        L_0x023d:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = "Public key mismatch between certificate and signature record"
            r0.<init>(r1)
            throw r0
        L_0x0245:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = "No certificates listed"
            r0.<init>(r1)
            throw r0
        L_0x024d:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = "Signature algorithms don't match between digests and signatures records"
            r0.<init>(r1)
            throw r0
        L_0x0255:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = java.lang.String.valueOf(r7)
            java.lang.String r2 = " signature did not verify"
            java.lang.String r1 = r1.concat(r2)
            r0.<init>(r1)
            throw r0
        L_0x0265:
            r0 = move-exception
            java.lang.SecurityException r1 = new java.lang.SecurityException
            java.lang.String r2 = java.lang.String.valueOf(r7)
            int r2 = r2.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r2 = r2 + 27
            r3.<init>(r2)
            java.lang.String r2 = "Failed to verify "
            r3.append(r2)
            r3.append(r7)
            java.lang.String r2 = " signature"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.internal.C2049h.m762a(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):java.security.cert.X509Certificate[]");
    }

    /* renamed from: a */
    private static byte[][] m763a(int[] iArr, C2003b[] bVarArr) throws DigestException {
        long j;
        int i;
        int length;
        int[] iArr2 = iArr;
        long j2 = 0;
        long j3 = 0;
        int i2 = 0;
        while (true) {
            j = 1048576;
            if (i2 >= 3) {
                break;
            }
            j3 += (bVarArr[i2].mo33542a() + 1048575) / 1048576;
            i2++;
        }
        if (j3 < 2097151) {
            int i3 = (int) j3;
            byte[][] bArr = new byte[iArr2.length][];
            int i4 = 0;
            while (true) {
                length = iArr2.length;
                if (i4 >= length) {
                    break;
                }
                byte[] bArr2 = new byte[((m769c(iArr2[i4]) * i3) + 5)];
                bArr2[0] = 90;
                m759a(i3, bArr2);
                bArr[i4] = bArr2;
                i4++;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            int i5 = 0;
            while (i5 < iArr2.length) {
                String b = m767b(iArr2[i5]);
                try {
                    messageDigestArr[i5] = MessageDigest.getInstance(b);
                    i5++;
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(b.concat(" digest not supported"), e);
                }
            }
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            for (i = 3; i6 < i; i = 3) {
                C2003b bVar = bVarArr[i6];
                int i9 = i6;
                int i10 = i7;
                long a = bVar.mo33542a();
                long j4 = j2;
                while (a > j2) {
                    int min = (int) Math.min(a, j);
                    m759a(min, bArr3);
                    for (MessageDigest update : messageDigestArr) {
                        update.update(bArr3);
                    }
                    try {
                        bVar.mo33543a(messageDigestArr, j4, min);
                        int i11 = 0;
                        while (i11 < iArr2.length) {
                            int i12 = iArr2[i11];
                            byte[] bArr4 = bArr[i11];
                            int c = m769c(i12);
                            MessageDigest messageDigest = messageDigestArr[i11];
                            byte[] bArr5 = bArr3;
                            int digest = messageDigest.digest(bArr4, (i10 * c) + 5, c);
                            if (digest == c) {
                                i11++;
                                bArr3 = bArr5;
                            } else {
                                String algorithm = messageDigest.getAlgorithm();
                                StringBuilder sb = new StringBuilder(String.valueOf(algorithm).length() + 46);
                                sb.append("Unexpected output size of ");
                                sb.append(algorithm);
                                sb.append(" digest: ");
                                sb.append(digest);
                                throw new RuntimeException(sb.toString());
                            }
                        }
                        byte[] bArr6 = bArr3;
                        long j5 = (long) min;
                        j4 += j5;
                        a -= j5;
                        i10++;
                        j2 = 0;
                        j = 1048576;
                    } catch (IOException e2) {
                        StringBuilder sb2 = new StringBuilder(59);
                        sb2.append("Failed to digest chunk #");
                        sb2.append(i10);
                        sb2.append(" of section #");
                        sb2.append(i8);
                        throw new DigestException(sb2.toString(), e2);
                    }
                }
                byte[] bArr7 = bArr3;
                i8++;
                i6 = i9 + 1;
                i7 = i10;
                j2 = 0;
                j = 1048576;
            }
            byte[][] bArr8 = new byte[iArr2.length][];
            int i13 = 0;
            while (i13 < iArr2.length) {
                int i14 = iArr2[i13];
                byte[] bArr9 = bArr[i13];
                String b2 = m767b(i14);
                try {
                    bArr8[i13] = MessageDigest.getInstance(b2).digest(bArr9);
                    i13++;
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(b2.concat(" digest not supported"), e3);
                }
            }
            return bArr8;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Too many chunks: ");
        sb3.append(j3);
        throw new DigestException(sb3.toString());
    }

    /* renamed from: a */
    public static X509Certificate[][] m764a(String str) throws C2046e, SecurityException, IOException {
        ByteBuffer byteBuffer;
        int limit;
        int position;
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair<ByteBuffer, Long> a = m755a(randomAccessFile);
            if (a != null) {
                ByteBuffer byteBuffer2 = (ByteBuffer) a.first;
                long longValue = ((Long) a.second).longValue();
                long j = -20 + longValue;
                if (j >= 0) {
                    randomAccessFile.seek(j);
                    if (randomAccessFile.readInt() == 1347094023) {
                        throw new C2046e("ZIP64 APK not supported");
                    }
                }
                long a2 = m753a(byteBuffer2);
                if (a2 >= longValue) {
                    StringBuilder sb = new StringBuilder(122);
                    sb.append("ZIP Central Directory offset out of range: ");
                    sb.append(a2);
                    sb.append(". ZIP End of Central Directory offset: ");
                    sb.append(longValue);
                    throw new C2046e(sb.toString());
                } else if (m766b(byteBuffer2) + a2 != longValue) {
                    throw new C2046e("ZIP Central Directory is not immediately followed by End of Central Directory");
                } else if (a2 >= 32) {
                    ByteBuffer allocate = ByteBuffer.allocate(24);
                    allocate.order(ByteOrder.LITTLE_ENDIAN);
                    randomAccessFile.seek(a2 - ((long) allocate.capacity()));
                    randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                    if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                        int i = 0;
                        long j2 = allocate.getLong(0);
                        if (j2 < ((long) allocate.capacity()) || j2 > 2147483639) {
                            StringBuilder sb2 = new StringBuilder(57);
                            sb2.append("APK Signing Block size out of range: ");
                            sb2.append(j2);
                            throw new C2046e(sb2.toString());
                        }
                        int i2 = (int) (8 + j2);
                        long j3 = a2 - ((long) i2);
                        if (j3 >= 0) {
                            ByteBuffer allocate2 = ByteBuffer.allocate(i2);
                            allocate2.order(ByteOrder.LITTLE_ENDIAN);
                            randomAccessFile.seek(j3);
                            randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                            long j4 = allocate2.getLong(0);
                            if (j4 == j2) {
                                Pair create = Pair.create(allocate2, Long.valueOf(j3));
                                byteBuffer = (ByteBuffer) create.first;
                                long longValue2 = ((Long) create.second).longValue();
                                if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
                                    int capacity = byteBuffer.capacity() - 24;
                                    if (capacity >= 8) {
                                        int capacity2 = byteBuffer.capacity();
                                        if (capacity <= byteBuffer.capacity()) {
                                            limit = byteBuffer.limit();
                                            position = byteBuffer.position();
                                            byteBuffer.position(0);
                                            byteBuffer.limit(capacity);
                                            byteBuffer.position(8);
                                            ByteBuffer slice = byteBuffer.slice();
                                            slice.order(byteBuffer.order());
                                            byteBuffer.position(0);
                                            byteBuffer.limit(limit);
                                            byteBuffer.position(position);
                                            while (slice.hasRemaining()) {
                                                i++;
                                                if (slice.remaining() >= 8) {
                                                    long j5 = slice.getLong();
                                                    if (j5 < 4 || j5 > 2147483647L) {
                                                        StringBuilder sb3 = new StringBuilder(76);
                                                        sb3.append("APK Signing Block entry #");
                                                        sb3.append(i);
                                                        sb3.append(" size out of range: ");
                                                        sb3.append(j5);
                                                        throw new C2046e(sb3.toString());
                                                    }
                                                    int i3 = (int) j5;
                                                    int position2 = slice.position() + i3;
                                                    if (i3 > slice.remaining()) {
                                                        int remaining = slice.remaining();
                                                        StringBuilder sb4 = new StringBuilder(91);
                                                        sb4.append("APK Signing Block entry #");
                                                        sb4.append(i);
                                                        sb4.append(" size out of range: ");
                                                        sb4.append(i3);
                                                        sb4.append(", available: ");
                                                        sb4.append(remaining);
                                                        throw new C2046e(sb4.toString());
                                                    } else if (slice.getInt() == 1896449818) {
                                                        X509Certificate[][] a3 = m765a(randomAccessFile.getChannel(), new C2045d(m768b(slice, i3 - 4), longValue2, a2, longValue, byteBuffer2));
                                                        randomAccessFile.close();
                                                        try {
                                                            randomAccessFile.close();
                                                        } catch (IOException unused) {
                                                        }
                                                        return a3;
                                                    } else {
                                                        slice.position(position2);
                                                    }
                                                } else {
                                                    StringBuilder sb5 = new StringBuilder(70);
                                                    sb5.append("Insufficient data to read size of APK Signing Block entry #");
                                                    sb5.append(i);
                                                    throw new C2046e(sb5.toString());
                                                }
                                            }
                                            throw new C2046e("No APK Signature Scheme v2 block in APK Signing Block");
                                        }
                                        StringBuilder sb6 = new StringBuilder(41);
                                        sb6.append("end > capacity: ");
                                        sb6.append(capacity);
                                        sb6.append(" > ");
                                        sb6.append(capacity2);
                                        throw new IllegalArgumentException(sb6.toString());
                                    }
                                    StringBuilder sb7 = new StringBuilder(38);
                                    sb7.append("end < start: ");
                                    sb7.append(capacity);
                                    sb7.append(" < ");
                                    sb7.append(8);
                                    throw new IllegalArgumentException(sb7.toString());
                                }
                                throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
                            }
                            StringBuilder sb8 = new StringBuilder(103);
                            sb8.append("APK Signing Block sizes in header and footer do not match: ");
                            sb8.append(j4);
                            sb8.append(" vs ");
                            sb8.append(j2);
                            throw new C2046e(sb8.toString());
                        }
                        StringBuilder sb9 = new StringBuilder(59);
                        sb9.append("APK Signing Block offset out of range: ");
                        sb9.append(j3);
                        throw new C2046e(sb9.toString());
                    }
                    throw new C2046e("No APK Signing Block before ZIP Central Directory");
                } else {
                    StringBuilder sb10 = new StringBuilder(87);
                    sb10.append("APK too small for APK Signing Block. ZIP Central Directory offset: ");
                    sb10.append(a2);
                    throw new C2046e(sb10.toString());
                }
            } else {
                long length = randomAccessFile.length();
                StringBuilder sb11 = new StringBuilder(102);
                sb11.append("Not an APK file: ZIP End of Central Directory record not found in file with ");
                sb11.append(length);
                sb11.append(" bytes");
                throw new C2046e(sb11.toString());
            }
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static X509Certificate[][] m765a(FileChannel fileChannel, C2045d dVar) throws SecurityException {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer d = m771d(dVar.f781a);
                int i = 0;
                while (d.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(m762a(m771d(d), (Map<Integer, byte[]>) hashMap, instance));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Failed to parse/verify signer #");
                        sb.append(i);
                        sb.append(" block");
                        throw new SecurityException(sb.toString(), e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                } else if (!hashMap.isEmpty()) {
                    m761a(hashMap, fileChannel, dVar.f782b, dVar.f783c, dVar.f784d, dVar.f785e);
                    return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                } else {
                    throw new SecurityException("No content digests found");
                }
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    /* renamed from: b */
    public static long m766b(ByteBuffer byteBuffer) {
        m770c(byteBuffer);
        return m754a(byteBuffer, byteBuffer.position() + 12);
    }

    /* renamed from: b */
    private static String m767b(int i) {
        switch (i) {
            case 1:
                return MessageDigestAlgorithms.SHA_256;
            case 2:
                return MessageDigestAlgorithms.SHA_512;
            default:
                StringBuilder sb = new StringBuilder(44);
                sb.append("Unknown content digest algorthm: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: b */
    private static ByteBuffer m768b(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i2 = i + position;
            if (i2 < position || i2 > limit) {
                throw new BufferUnderflowException();
            }
            byteBuffer.limit(i2);
            try {
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                byteBuffer.position(i2);
                return slice;
            } finally {
                byteBuffer.limit(limit);
            }
        } else {
            StringBuilder sb = new StringBuilder(17);
            sb.append("size: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: c */
    private static int m769c(int i) {
        switch (i) {
            case 1:
                return 32;
            case 2:
                return 64;
            default:
                StringBuilder sb = new StringBuilder(44);
                sb.append("Unknown content digest algorthm: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: c */
    private static void m770c(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* renamed from: d */
    private static ByteBuffer m771d(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i < 0) {
                throw new IllegalArgumentException("Negative length");
            } else if (i <= byteBuffer.remaining()) {
                return m768b(byteBuffer, i);
            } else {
                int remaining = byteBuffer.remaining();
                StringBuilder sb = new StringBuilder(101);
                sb.append("Length-prefixed field longer than remaining buffer. Field length: ");
                sb.append(i);
                sb.append(", remaining: ");
                sb.append(remaining);
                throw new IOException(sb.toString());
            }
        } else {
            int remaining2 = byteBuffer.remaining();
            StringBuilder sb2 = new StringBuilder(93);
            sb2.append("Remaining buffer too short to contain length of length-prefixed field. Remaining: ");
            sb2.append(remaining2);
            throw new IOException(sb2.toString());
        }
    }

    /* renamed from: e */
    private static byte[] m772e(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        } else if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        } else {
            int remaining = byteBuffer.remaining();
            StringBuilder sb = new StringBuilder(90);
            sb.append("Underflow while reading length-prefixed value. Length: ");
            sb.append(i);
            sb.append(", available: ");
            sb.append(remaining);
            throw new IOException(sb.toString());
        }
    }
}
