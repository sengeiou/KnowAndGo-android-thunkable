package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

@KeepForSdk
public class ProcessUtils {
    private static String zzhf;
    private static int zzhg;

    private ProcessUtils() {
    }

    @KeepForSdk
    @Nullable
    public static String getMyProcessName() {
        if (zzhf == null) {
            if (zzhg == 0) {
                zzhg = Process.myPid();
            }
            zzhf = zzd(zzhg);
        }
        return zzhf;
    }

    @Nullable
    private static String zzd(int i) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (i <= 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("/proc/");
            sb.append(i);
            sb.append("/cmdline");
            bufferedReader = zzk(sb.toString());
            try {
                String trim = bufferedReader.readLine().trim();
                IOUtils.closeQuietly((Closeable) bufferedReader);
                return trim;
            } catch (IOException unused) {
                IOUtils.closeQuietly((Closeable) bufferedReader);
                return null;
            } catch (Throwable th) {
                Throwable th2 = th;
                bufferedReader2 = bufferedReader;
                th = th2;
                IOUtils.closeQuietly((Closeable) bufferedReader2);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
            IOUtils.closeQuietly((Closeable) bufferedReader);
            return null;
        } catch (Throwable th3) {
            th = th3;
            IOUtils.closeQuietly((Closeable) bufferedReader2);
            throw th;
        }
    }

    private static BufferedReader zzk(String str) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
