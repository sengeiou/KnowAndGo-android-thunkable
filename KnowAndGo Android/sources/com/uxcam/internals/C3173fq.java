package com.uxcam.internals;

/* renamed from: com.uxcam.internals.fq */
public final class C3173fq {
    /* renamed from: a */
    public static String m2006a(int i) {
        switch (i) {
            case 0:
                return "SINGLE_TAP";
            case 1:
                return "DOUBLE_TAP";
            case 2:
                return "SWIPE_UP";
            case 3:
                return "SWIPE_DOWN";
            case 4:
                return "SWIPE_LEFT";
            case 5:
                return "SWIPE_RIGHT";
            case 6:
                return "LONG_PRESS";
            case 10:
                return "ORIENTATION_CHANGE";
            case 11:
                return "TRAIL";
            case 12:
                return "SCROLL";
            default:
                return Integer.toString(i);
        }
    }
}
