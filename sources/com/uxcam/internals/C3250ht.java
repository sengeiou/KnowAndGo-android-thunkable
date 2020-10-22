package com.uxcam.internals;

import java.util.Calendar;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;

/* renamed from: com.uxcam.internals.ht */
public final class C3250ht {

    /* renamed from: a */
    public static final long f2562a;

    static {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone(TimeZones.GMT_ID));
        instance.set(1904, 0, 1, 0, 0, 0);
        instance.set(14, 0);
        f2562a = instance.getTimeInMillis();
    }

    /* renamed from: a */
    public static int m2235a(long j) {
        return (int) ((j - f2562a) / 1000);
    }
}
