package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdSizeParcelCreator")
@SafeParcelable.Reserved({1})
@zzard
public final class zzyd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyd> CREATOR = new zzye();
    @SafeParcelable.Field(mo22648id = 3)
    public final int height;
    @SafeParcelable.Field(mo22648id = 4)
    public final int heightPixels;
    @SafeParcelable.Field(mo22648id = 6)
    public final int width;
    @SafeParcelable.Field(mo22648id = 7)
    public final int widthPixels;
    @SafeParcelable.Field(mo22648id = 2)
    public final String zzaap;
    @SafeParcelable.Field(mo22648id = 9)
    public final boolean zzbsz;
    @SafeParcelable.Field(mo22648id = 5)
    public final boolean zzchf;
    @SafeParcelable.Field(mo22648id = 8)
    public final zzyd[] zzchg;
    @SafeParcelable.Field(mo22648id = 10)
    public final boolean zzchh;
    @SafeParcelable.Field(mo22648id = 11)
    public boolean zzchi;

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (((float) zzd(displayMetrics)) * displayMetrics.density);
    }

    private static int zzd(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static zzyd zzg(Context context) {
        return new zzyd("320x50_mb", 0, 0, false, 0, 0, (zzyd[]) null, true, false, false);
    }

    public static zzyd zzou() {
        return new zzyd("reward_mb", 0, 0, true, 0, 0, (zzyd[]) null, false, false, false);
    }

    public zzyd() {
        this("interstitial_mb", 0, 0, true, 0, 0, (zzyd[]) null, false, false, false);
    }

    public zzyd(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzyd(android.content.Context r12, com.google.android.gms.ads.AdSize[] r13) {
        /*
            r11 = this;
            r11.<init>()
            r0 = 0
            r1 = r13[r0]
            r11.zzchf = r0
            boolean r2 = r1.isFluid()
            r11.zzchh = r2
            boolean r2 = r11.zzchh
            if (r2 == 0) goto L_0x0023
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r2 = r2.getWidth()
            r11.width = r2
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r2 = r2.getHeight()
            r11.height = r2
            goto L_0x002f
        L_0x0023:
            int r2 = r1.getWidth()
            r11.width = r2
            int r2 = r1.getHeight()
            r11.height = r2
        L_0x002f:
            int r2 = r11.width
            r3 = -1
            r4 = 1
            if (r2 != r3) goto L_0x0037
            r2 = 1
            goto L_0x0038
        L_0x0037:
            r2 = 0
        L_0x0038:
            int r3 = r11.height
            r5 = -2
            if (r3 != r5) goto L_0x003f
            r3 = 1
            goto L_0x0040
        L_0x003f:
            r3 = 0
        L_0x0040:
            android.content.res.Resources r5 = r12.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            if (r2 == 0) goto L_0x0083
            com.google.android.gms.internal.ads.zzyt.zzpa()
            boolean r6 = com.google.android.gms.internal.ads.zzazt.zzbh(r12)
            if (r6 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzyt.zzpa()
            boolean r6 = com.google.android.gms.internal.ads.zzazt.zzbi(r12)
            if (r6 == 0) goto L_0x0069
            int r6 = r5.widthPixels
            com.google.android.gms.internal.ads.zzyt.zzpa()
            int r7 = com.google.android.gms.internal.ads.zzazt.zzbj(r12)
            int r6 = r6 - r7
            r11.widthPixels = r6
            goto L_0x006d
        L_0x0069:
            int r6 = r5.widthPixels
            r11.widthPixels = r6
        L_0x006d:
            int r6 = r11.widthPixels
            float r6 = (float) r6
            float r7 = r5.density
            float r6 = r6 / r7
            double r6 = (double) r6
            int r8 = (int) r6
            double r9 = (double) r8
            double r6 = r6 - r9
            r9 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 < 0) goto L_0x0090
            int r8 = r8 + 1
            goto L_0x0090
        L_0x0083:
            int r8 = r11.width
            com.google.android.gms.internal.ads.zzyt.zzpa()
            int r6 = r11.width
            int r6 = com.google.android.gms.internal.ads.zzazt.zza((android.util.DisplayMetrics) r5, (int) r6)
            r11.widthPixels = r6
        L_0x0090:
            if (r3 == 0) goto L_0x0097
            int r6 = zzd(r5)
            goto L_0x0099
        L_0x0097:
            int r6 = r11.height
        L_0x0099:
            com.google.android.gms.internal.ads.zzyt.zzpa()
            int r5 = com.google.android.gms.internal.ads.zzazt.zza((android.util.DisplayMetrics) r5, (int) r6)
            r11.heightPixels = r5
            if (r2 != 0) goto L_0x00b7
            if (r3 == 0) goto L_0x00a7
            goto L_0x00b7
        L_0x00a7:
            boolean r2 = r11.zzchh
            if (r2 == 0) goto L_0x00b0
            java.lang.String r1 = "320x50_mb"
            r11.zzaap = r1
            goto L_0x00d4
        L_0x00b0:
            java.lang.String r1 = r1.toString()
            r11.zzaap = r1
            goto L_0x00d4
        L_0x00b7:
            r1 = 26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r8)
            java.lang.String r1 = "x"
            r2.append(r1)
            r2.append(r6)
            java.lang.String r1 = "_as"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r11.zzaap = r1
        L_0x00d4:
            int r1 = r13.length
            if (r1 <= r4) goto L_0x00ee
            int r1 = r13.length
            com.google.android.gms.internal.ads.zzyd[] r1 = new com.google.android.gms.internal.ads.zzyd[r1]
            r11.zzchg = r1
            r1 = 0
        L_0x00dd:
            int r2 = r13.length
            if (r1 >= r2) goto L_0x00f1
            com.google.android.gms.internal.ads.zzyd[] r2 = r11.zzchg
            com.google.android.gms.internal.ads.zzyd r3 = new com.google.android.gms.internal.ads.zzyd
            r4 = r13[r1]
            r3.<init>((android.content.Context) r12, (com.google.android.gms.ads.AdSize) r4)
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x00dd
        L_0x00ee:
            r12 = 0
            r11.zzchg = r12
        L_0x00f1:
            r11.zzbsz = r0
            r11.zzchi = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyd.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    @SafeParcelable.Constructor
    zzyd(@SafeParcelable.Param(mo22651id = 2) String str, @SafeParcelable.Param(mo22651id = 3) int i, @SafeParcelable.Param(mo22651id = 4) int i2, @SafeParcelable.Param(mo22651id = 5) boolean z, @SafeParcelable.Param(mo22651id = 6) int i3, @SafeParcelable.Param(mo22651id = 7) int i4, @SafeParcelable.Param(mo22651id = 8) zzyd[] zzydArr, @SafeParcelable.Param(mo22651id = 9) boolean z2, @SafeParcelable.Param(mo22651id = 10) boolean z3, @SafeParcelable.Param(mo22651id = 11) boolean z4) {
        this.zzaap = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzchf = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzchg = zzydArr;
        this.zzbsz = z2;
        this.zzchh = z3;
        this.zzchi = z4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzaap, false);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.writeInt(parcel, 4, this.heightPixels);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzchf);
        SafeParcelWriter.writeInt(parcel, 6, this.width);
        SafeParcelWriter.writeInt(parcel, 7, this.widthPixels);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzchg, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbsz);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzchh);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzchi);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
