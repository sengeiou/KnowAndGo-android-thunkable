package com.polidea.multiplatformbleadapter.utils;

import com.polidea.multiplatformbleadapter.utils.Constants;

public class LogLevel {
    public static String fromLogLevel(int i) {
        switch (i) {
            case 2:
                return Constants.BluetoothLogLevel.VERBOSE;
            case 3:
                return Constants.BluetoothLogLevel.DEBUG;
            case 4:
                return Constants.BluetoothLogLevel.INFO;
            case 5:
                return Constants.BluetoothLogLevel.WARNING;
            case 6:
                return Constants.BluetoothLogLevel.ERROR;
            default:
                return Constants.BluetoothLogLevel.NONE;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int toLogLevel(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            switch(r0) {
                case -1505867908: goto L_0x003e;
                case 2283726: goto L_0x0034;
                case 2433880: goto L_0x002a;
                case 65906227: goto L_0x0020;
                case 67232232: goto L_0x0016;
                case 2015760738: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0048
        L_0x000c:
            java.lang.String r0 = "Verbose"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0048
            r5 = 0
            goto L_0x0049
        L_0x0016:
            java.lang.String r0 = "Error"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0048
            r5 = 4
            goto L_0x0049
        L_0x0020:
            java.lang.String r0 = "Debug"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0048
            r5 = 1
            goto L_0x0049
        L_0x002a:
            java.lang.String r0 = "None"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0048
            r5 = 5
            goto L_0x0049
        L_0x0034:
            java.lang.String r0 = "Info"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0048
            r5 = 2
            goto L_0x0049
        L_0x003e:
            java.lang.String r0 = "Warning"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0048
            r5 = 3
            goto L_0x0049
        L_0x0048:
            r5 = -1
        L_0x0049:
            switch(r5) {
                case 0: goto L_0x0055;
                case 1: goto L_0x0054;
                case 2: goto L_0x0053;
                case 3: goto L_0x0052;
                case 4: goto L_0x0050;
                default: goto L_0x004c;
            }
        L_0x004c:
            r5 = 2147483647(0x7fffffff, float:NaN)
            return r5
        L_0x0050:
            r5 = 6
            return r5
        L_0x0052:
            return r1
        L_0x0053:
            return r2
        L_0x0054:
            return r3
        L_0x0055:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.polidea.multiplatformbleadapter.utils.LogLevel.toLogLevel(java.lang.String):int");
    }
}
