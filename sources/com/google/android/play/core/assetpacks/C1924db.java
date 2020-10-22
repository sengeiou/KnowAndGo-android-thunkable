package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import com.google.android.play.core.internal.C1998av;
import com.google.android.play.core.internal.C2039ci;
import com.google.android.play.core.splitcompat.C2096p;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipException;
import kotlin.UByte;

/* renamed from: com.google.android.play.core.assetpacks.db */
public final class C1924db {

    /* renamed from: a */
    private static C1841a f591a;

    /* renamed from: a */
    static int m466a(byte[] bArr, int i) {
        return (bArr[i + 3] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
    }

    @Nullable
    /* renamed from: a */
    static AssetLocation m467a(String str, String str2) throws IOException {
        Long l;
        int i;
        String str3 = str;
        String str4 = str2;
        C1998av.m631a(str3 != null, (Object) "Attempted to get file location from a null apk path.");
        C1998av.m631a(str4 != null, (Object) String.format("Attempted to get file location in apk %s with a null file path.", new Object[]{str3}));
        RandomAccessFile randomAccessFile = new RandomAccessFile(str3, "r");
        byte[] bArr = new byte[22];
        randomAccessFile.seek(randomAccessFile.length() - 22);
        randomAccessFile.readFully(bArr);
        C1878bj a = m466a(bArr, 0) == 1347093766 ? m469a(bArr) : null;
        if (a == null) {
            long length = randomAccessFile.length() - 22;
            long j = -65536 + length;
            if (j < 0) {
                j = 0;
            }
            int min = (int) Math.min(1024, randomAccessFile.length());
            byte[] bArr2 = new byte[min];
            byte[] bArr3 = new byte[22];
            do {
                length = Math.max((length - ((long) min)) + 3, j);
                randomAccessFile.seek(length);
                randomAccessFile.readFully(bArr2);
                int i2 = min - 4;
                while (i2 >= 0) {
                    byte b = bArr2[i2];
                    if (b == 75) {
                        i = 1;
                    } else if (b != 80) {
                        switch (b) {
                            case 5:
                                i = 2;
                                break;
                            case 6:
                                i = 3;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 0;
                    }
                    if (i < 0 || i2 < i || m466a(bArr2, i2 - i) != 1347093766) {
                        i2 -= 4;
                    } else {
                        randomAccessFile.seek((length + ((long) i2)) - ((long) i));
                        randomAccessFile.readFully(bArr3);
                        a = m469a(bArr3);
                    }
                }
            } while (length != j);
            throw new ZipException(String.format("End Of Central Directory signature not found in APK %s", new Object[]{str3}));
        }
        long j2 = a.f420a;
        byte[] bytes = str4.getBytes("UTF-8");
        byte[] bArr4 = new byte[46];
        byte[] bArr5 = new byte[str2.length()];
        long j3 = j2;
        int i3 = 0;
        while (true) {
            if (i3 < a.f421b) {
                randomAccessFile.seek(j3);
                randomAccessFile.readFully(bArr4);
                int a2 = m466a(bArr4, 0);
                if (a2 == 1347092738) {
                    randomAccessFile.seek(28 + j3);
                    int c = m475c(bArr4, 28);
                    if (c == str2.length()) {
                        randomAccessFile.seek(46 + j3);
                        randomAccessFile.read(bArr5);
                        if (Arrays.equals(bArr5, bytes)) {
                            l = Long.valueOf(m473b(bArr4, 42));
                        }
                    }
                    j3 += (long) (c + 46 + m475c(bArr4, 30) + m475c(bArr4, 32));
                    i3++;
                } else {
                    throw new ZipException(String.format("Missing central directory file header signature when looking for file %s in APK %s. Read %d entries out of %d. Found %d instead of the header signature %d.", new Object[]{str4, str3, Integer.valueOf(i3), Integer.valueOf(a.f421b), Integer.valueOf(a2), 1347092738}));
                }
            } else {
                l = null;
            }
        }
        if (l == null) {
            return null;
        }
        long longValue = l.longValue();
        byte[] bArr6 = new byte[8];
        randomAccessFile.seek(22 + longValue);
        randomAccessFile.readFully(bArr6);
        return AssetLocation.m254a(str3, longValue + 30 + ((long) m475c(bArr6, 4)) + ((long) m475c(bArr6, 6)), m473b(bArr6, 0));
    }

    /* renamed from: a */
    static synchronized C1841a m468a(Context context) {
        C1841a aVar;
        synchronized (C1924db.class) {
            if (f591a == null) {
                C1885bq bqVar = new C1885bq((byte[]) null);
                bqVar.mo33428a(new C1957n(C2096p.m907a(context)));
                f591a = bqVar.mo33427a();
            }
            aVar = f591a;
        }
        return aVar;
    }

    /* renamed from: a */
    private static C1878bj m469a(byte[] bArr) {
        int c = m475c(bArr, 10);
        m473b(bArr, 12);
        return new C1878bj(m473b(bArr, 16), c);
    }

    /* renamed from: a */
    static String m470a(List<File> list) throws NoSuchAlgorithmException, IOException {
        int read;
        MessageDigest instance = MessageDigest.getInstance("SHA256");
        byte[] bArr = new byte[8192];
        for (File fileInputStream : list) {
            FileInputStream fileInputStream2 = new FileInputStream(fileInputStream);
            do {
                try {
                    read = fileInputStream2.read(bArr);
                    if (read > 0) {
                        instance.update(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    C2039ci.m739a(th, th);
                }
            } while (read != -1);
            fileInputStream2.close();
        }
        return Base64.encodeToString(instance.digest(), 11);
        throw th;
    }

    /* renamed from: a */
    public static boolean m471a(@AssetPackStatus int i) {
        return i == 1 || i == 7 || i == 2 || i == 3;
    }

    /* renamed from: a */
    static boolean m472a(@AssetPackStatus int i, @AssetPackStatus int i2) {
        if (i == 5) {
            if (i2 != 5) {
                return true;
            }
            i = 5;
        }
        if (i == 6 && i2 != 6 && i2 != 5) {
            return true;
        }
        if (i == 4 && i2 != 4) {
            return true;
        }
        if (i == 3 && (i2 == 2 || i2 == 7 || i2 == 1 || i2 == 8)) {
            return true;
        }
        if (i == 2) {
            return i2 == 1 || i2 == 8;
        }
        return false;
    }

    /* renamed from: b */
    static long m473b(byte[] bArr, int i) {
        return ((long) ((m475c(bArr, i + 2) << 16) | m475c(bArr, i))) & 4294967295L;
    }

    /* renamed from: b */
    public static boolean m474b(@AssetPackStatus int i) {
        return i == 5 || i == 6 || i == 4;
    }

    /* renamed from: c */
    static int m475c(byte[] bArr, int i) {
        return ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | (bArr[i] & UByte.MAX_VALUE);
    }

    /* renamed from: c */
    public static boolean m476c(@AssetPackStatus int i) {
        return i == 2 || i == 7 || i == 3;
    }
}
