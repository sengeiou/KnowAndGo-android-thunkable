package com.google.android.gms.internal.ads;

import androidx.core.view.PointerIconCompat;
import com.google.android.exoplayer2.C1470C;
import java.util.UUID;

public final class zzkt {
    public static final int CHANNEL_OUT_7POINT1_SURROUND = (zzsy.SDK_INT < 23 ? PointerIconCompat.TYPE_GRAB : 6396);
    public static final UUID zzarg = new UUID(0, 0);
    private static final UUID zzarh = new UUID(1186680826959645954L, -5988876978535335093L);
    private static final UUID zzari = new UUID(-1301668207276963122L, -6645017420763422227L);
    private static final UUID zzarj = new UUID(-7348484286925749626L, -6083546864340672619L);

    public static long zzdz(long j) {
        return j == C1470C.TIME_UNSET ? C1470C.TIME_UNSET : j / 1000;
    }

    public static long zzea(long j) {
        return j == C1470C.TIME_UNSET ? C1470C.TIME_UNSET : j * 1000;
    }
}
