package com.facebook.device.yearclass;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

public class DeviceInfo {
    private static final FileFilter CPU_FILTER = new FileFilter() {
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    };
    public static final int DEVICEINFO_UNKNOWN = -1;

    public static int getNumberOfCPUCores() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            int coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
            if (coresFromFileInfo == -1) {
                coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/present");
            }
            if (coresFromFileInfo == -1) {
                coresFromFileInfo = getCoresFromCPUFileList();
            }
            return coresFromFileInfo;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027 A[SYNTHETIC, Splitter:B:14:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002f A[SYNTHETIC, Splitter:B:22:0x002f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getCoresFromFileInfo(java.lang.String r2) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x002b, all -> 0x0023 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x002b, all -> 0x0023 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0021, all -> 0x001f }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0021, all -> 0x001f }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0021, all -> 0x001f }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0021, all -> 0x001f }
            java.lang.String r0 = r2.readLine()     // Catch:{ IOException -> 0x0021, all -> 0x001f }
            r2.close()     // Catch:{ IOException -> 0x0021, all -> 0x001f }
            int r2 = getCoresFromFileString(r0)     // Catch:{ IOException -> 0x0021, all -> 0x001f }
            r1.close()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            return r2
        L_0x001f:
            r2 = move-exception
            goto L_0x0025
        L_0x0021:
            goto L_0x002c
        L_0x0023:
            r2 = move-exception
            r1 = r0
        L_0x0025:
            if (r1 == 0) goto L_0x002a
            r1.close()     // Catch:{ IOException -> 0x002a }
        L_0x002a:
            throw r2
        L_0x002b:
            r1 = r0
        L_0x002c:
            r2 = -1
            if (r1 == 0) goto L_0x0032
            r1.close()     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.yearclass.DeviceInfo.getCoresFromFileInfo(java.lang.String):int");
    }

    static int getCoresFromFileString(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    private static int getCoresFromCPUFileList() {
        return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0064 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getCPUMaxFreqKHz() {
        /*
            r0 = 0
            r1 = -1
            r2 = 0
            r3 = -1
        L_0x0004:
            int r4 = getNumberOfCPUCores()     // Catch:{ IOException -> 0x0090 }
            if (r2 >= r4) goto L_0x0070
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0090 }
            r4.<init>()     // Catch:{ IOException -> 0x0090 }
            java.lang.String r5 = "/sys/devices/system/cpu/cpu"
            r4.append(r5)     // Catch:{ IOException -> 0x0090 }
            r4.append(r2)     // Catch:{ IOException -> 0x0090 }
            java.lang.String r5 = "/cpufreq/cpuinfo_max_freq"
            r4.append(r5)     // Catch:{ IOException -> 0x0090 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0090 }
            java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x0090 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0090 }
            boolean r4 = r5.exists()     // Catch:{ IOException -> 0x0090 }
            if (r4 == 0) goto L_0x006d
            boolean r4 = r5.canRead()     // Catch:{ IOException -> 0x0090 }
            if (r4 == 0) goto L_0x006d
            r4 = 128(0x80, float:1.794E-43)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0090 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0090 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x0090 }
            r6.read(r4)     // Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
            r5 = 0
        L_0x003e:
            byte r7 = r4[r5]     // Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
            boolean r7 = java.lang.Character.isDigit(r7)     // Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
            if (r7 == 0) goto L_0x004c
            int r7 = r4.length     // Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
            if (r5 >= r7) goto L_0x004c
            int r5 = r5 + 1
            goto L_0x003e
        L_0x004c:
            java.lang.String r7 = new java.lang.String     // Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
            r7.<init>(r4, r0, r5)     // Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
            int r4 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
            int r5 = r4.intValue()     // Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
            if (r5 <= r3) goto L_0x0064
            int r4 = r4.intValue()     // Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
            r3 = r4
        L_0x0064:
            r6.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x006d
        L_0x0068:
            r0 = move-exception
            r6.close()     // Catch:{ IOException -> 0x0090 }
            throw r0     // Catch:{ IOException -> 0x0090 }
        L_0x006d:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x0070:
            if (r3 != r1) goto L_0x008f
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0090 }
            java.lang.String r2 = "/proc/cpuinfo"
            r0.<init>(r2)     // Catch:{ IOException -> 0x0090 }
            java.lang.String r2 = "cpu MHz"
            int r2 = parseFileForValue(r2, r0)     // Catch:{ all -> 0x008a }
            int r2 = r2 * 1000
            if (r2 <= r3) goto L_0x0084
            goto L_0x0085
        L_0x0084:
            r2 = r3
        L_0x0085:
            r0.close()     // Catch:{ IOException -> 0x0090 }
            r1 = r2
            goto L_0x0090
        L_0x008a:
            r2 = move-exception
            r0.close()     // Catch:{ IOException -> 0x0090 }
            throw r2     // Catch:{ IOException -> 0x0090 }
        L_0x008f:
            r1 = r3
        L_0x0090:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.yearclass.DeviceInfo.getCPUMaxFreqKHz():int");
    }

    @TargetApi(16)
    public static long getTotalMemory(Context context) {
        FileInputStream fileInputStream;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        long j = -1;
        try {
            fileInputStream = new FileInputStream("/proc/meminfo");
            j = ((long) parseFileForValue("MemTotal", fileInputStream)) * 1024;
            fileInputStream.close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
        return j;
    }

    private static int parseFileForValue(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == 10 || i == 0) {
                    if (bArr[i] == 10) {
                        i++;
                    }
                    int i2 = i;
                    while (true) {
                        if (i2 >= read) {
                            continue;
                            break;
                        }
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            break;
                        } else if (i3 == str.length() - 1) {
                            return extractValue(bArr, i2);
                        } else {
                            i2++;
                        }
                    }
                }
                i++;
            }
            return -1;
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }

    private static int extractValue(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != 10) {
            if (Character.isDigit(bArr[i])) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }
}
