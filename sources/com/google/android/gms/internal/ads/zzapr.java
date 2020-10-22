package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;

@zzard
public final class zzapr extends zzaqb {
    private static final Set<String> zzdhx = CollectionUtils.setOf("top-left", "top-right", "top-center", TtmlNode.CENTER, "bottom-left", "bottom-right", "bottom-center");
    private int height = -1;
    private final Object lock = new Object();
    private int width = -1;
    private zzaqc zzdal;
    private final zzbgz zzdbs;
    private final Activity zzdhn;
    private String zzdhy = "top-right";
    private boolean zzdhz = true;
    private int zzdia = 0;
    private int zzdib = 0;
    private int zzdic = 0;
    private int zzdid = 0;
    private zzbin zzdie;
    private ImageView zzdif;
    private LinearLayout zzdig;
    private PopupWindow zzdih;
    private RelativeLayout zzdii;
    private ViewGroup zzdij;

    public zzapr(zzbgz zzbgz, zzaqc zzaqc) {
        super(zzbgz, "resize");
        this.zzdbs = zzbgz;
        this.zzdhn = zzbgz.zzyd();
        this.zzdal = zzaqc;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01da, code lost:
        r5 = ((r1.zzdia + r1.zzdic) + (r1.width / 2)) - 25;
        r8 = ((r1.zzdib + r1.zzdid) + (r1.height / 2)) - 25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01f1, code lost:
        r5 = ((r1.zzdia + r1.zzdic) + (r1.width / 2)) - 25;
        r8 = r1.zzdib + r1.zzdid;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0202, code lost:
        r5 = r1.zzdia + r1.zzdic;
        r8 = r1.zzdib + r1.zzdid;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x020d, code lost:
        r5 = ((r1.zzdia + r1.zzdic) + r1.width) - 50;
        r8 = r1.zzdib + r1.zzdid;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0219, code lost:
        if (r5 < 0) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x021c, code lost:
        if ((r5 + 50) > r7) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0220, code lost:
        if (r8 < r6[0]) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0225, code lost:
        if ((r8 + 50) <= r6[1]) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x019c, code lost:
        r5 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x019d, code lost:
        switch(r5) {
            case 0: goto L_0x0202;
            case 1: goto L_0x01f1;
            case 2: goto L_0x01da;
            case 3: goto L_0x01cb;
            case 4: goto L_0x01b6;
            case 5: goto L_0x01a3;
            default: goto L_0x01a0;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01a3, code lost:
        r5 = ((r1.zzdia + r1.zzdic) + r1.width) - 50;
        r8 = ((r1.zzdib + r1.zzdid) + r1.height) - 50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01b6, code lost:
        r5 = ((r1.zzdia + r1.zzdic) + (r1.width / 2)) - 25;
        r8 = ((r1.zzdib + r1.zzdid) + r1.height) - 50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01cb, code lost:
        r5 = r1.zzdia + r1.zzdic;
        r8 = ((r1.zzdib + r1.zzdid) + r1.height) - 50;
     */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0238 A[Catch:{ RuntimeException -> 0x0466 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x023a A[Catch:{ RuntimeException -> 0x0466 }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x029a A[Catch:{ RuntimeException -> 0x0466 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02a1 A[Catch:{ RuntimeException -> 0x0466 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(java.util.Map<java.lang.String, java.lang.String> r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.Object r2 = r1.lock
            monitor-enter(r2)
            android.app.Activity r3 = r1.zzdhn     // Catch:{ all -> 0x04bc }
            if (r3 != 0) goto L_0x0012
            java.lang.String r0 = "Not an activity context. Cannot resize."
            r1.zzdh(r0)     // Catch:{ all -> 0x04bc }
            monitor-exit(r2)     // Catch:{ all -> 0x04bc }
            return
        L_0x0012:
            com.google.android.gms.internal.ads.zzbgz r3 = r1.zzdbs     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzbin r3 = r3.zzaag()     // Catch:{ all -> 0x04bc }
            if (r3 != 0) goto L_0x0021
            java.lang.String r0 = "Webview is not yet available, size is not set."
            r1.zzdh(r0)     // Catch:{ all -> 0x04bc }
            monitor-exit(r2)     // Catch:{ all -> 0x04bc }
            return
        L_0x0021:
            com.google.android.gms.internal.ads.zzbgz r3 = r1.zzdbs     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzbin r3 = r3.zzaag()     // Catch:{ all -> 0x04bc }
            boolean r3 = r3.zzabx()     // Catch:{ all -> 0x04bc }
            if (r3 == 0) goto L_0x0034
            java.lang.String r0 = "Is interstitial. Cannot resize an interstitial."
            r1.zzdh(r0)     // Catch:{ all -> 0x04bc }
            monitor-exit(r2)     // Catch:{ all -> 0x04bc }
            return
        L_0x0034:
            com.google.android.gms.internal.ads.zzbgz r3 = r1.zzdbs     // Catch:{ all -> 0x04bc }
            boolean r3 = r3.zzaan()     // Catch:{ all -> 0x04bc }
            if (r3 == 0) goto L_0x0043
            java.lang.String r0 = "Cannot resize an expanded banner."
            r1.zzdh(r0)     // Catch:{ all -> 0x04bc }
            monitor-exit(r2)     // Catch:{ all -> 0x04bc }
            return
        L_0x0043:
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bc }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04bc }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04bc }
            if (r3 != 0) goto L_0x0062
            com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04bc }
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bc }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04bc }
            int r3 = com.google.android.gms.internal.ads.zzaxi.zzdy(r3)     // Catch:{ all -> 0x04bc }
            r1.width = r3     // Catch:{ all -> 0x04bc }
        L_0x0062:
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bc }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04bc }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04bc }
            if (r3 != 0) goto L_0x0081
            com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04bc }
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bc }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04bc }
            int r3 = com.google.android.gms.internal.ads.zzaxi.zzdy(r3)     // Catch:{ all -> 0x04bc }
            r1.height = r3     // Catch:{ all -> 0x04bc }
        L_0x0081:
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bc }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04bc }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04bc }
            if (r3 != 0) goto L_0x00a0
            com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04bc }
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bc }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04bc }
            int r3 = com.google.android.gms.internal.ads.zzaxi.zzdy(r3)     // Catch:{ all -> 0x04bc }
            r1.zzdic = r3     // Catch:{ all -> 0x04bc }
        L_0x00a0:
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bc }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04bc }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04bc }
            if (r3 != 0) goto L_0x00bf
            com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04bc }
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bc }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04bc }
            int r3 = com.google.android.gms.internal.ads.zzaxi.zzdy(r3)     // Catch:{ all -> 0x04bc }
            r1.zzdid = r3     // Catch:{ all -> 0x04bc }
        L_0x00bf:
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bc }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04bc }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04bc }
            if (r3 != 0) goto L_0x00db
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04bc }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04bc }
            boolean r3 = java.lang.Boolean.parseBoolean(r3)     // Catch:{ all -> 0x04bc }
            r1.zzdhz = r3     // Catch:{ all -> 0x04bc }
        L_0x00db:
            java.lang.String r3 = "customClosePosition"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x04bc }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x04bc }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x04bc }
            if (r3 != 0) goto L_0x00eb
            r1.zzdhy = r0     // Catch:{ all -> 0x04bc }
        L_0x00eb:
            int r0 = r1.width     // Catch:{ all -> 0x04bc }
            r3 = 1
            r4 = 0
            if (r0 < 0) goto L_0x00f7
            int r0 = r1.height     // Catch:{ all -> 0x04bc }
            if (r0 < 0) goto L_0x00f7
            r0 = 1
            goto L_0x00f8
        L_0x00f7:
            r0 = 0
        L_0x00f8:
            if (r0 != 0) goto L_0x0101
            java.lang.String r0 = "Invalid width and height options. Cannot resize."
            r1.zzdh(r0)     // Catch:{ all -> 0x04bc }
            monitor-exit(r2)     // Catch:{ all -> 0x04bc }
            return
        L_0x0101:
            android.app.Activity r0 = r1.zzdhn     // Catch:{ all -> 0x04bc }
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x04bc }
            if (r0 == 0) goto L_0x04b5
            android.view.View r5 = r0.getDecorView()     // Catch:{ all -> 0x04bc }
            if (r5 != 0) goto L_0x0111
            goto L_0x04b5
        L_0x0111:
            com.google.android.gms.internal.ads.zzaxi r5 = com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04bc }
            android.app.Activity r6 = r1.zzdhn     // Catch:{ all -> 0x04bc }
            int[] r5 = r5.zze(r6)     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzaxi r6 = com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04bc }
            android.app.Activity r7 = r1.zzdhn     // Catch:{ all -> 0x04bc }
            int[] r6 = r6.zzf(r7)     // Catch:{ all -> 0x04bc }
            r7 = r5[r4]     // Catch:{ all -> 0x04bc }
            r5 = r5[r3]     // Catch:{ all -> 0x04bc }
            int r8 = r1.width     // Catch:{ all -> 0x04bc }
            r10 = 5
            r11 = 3
            r12 = -1
            r13 = 2
            r14 = 50
            if (r8 < r14) goto L_0x0230
            int r8 = r1.width     // Catch:{ all -> 0x04bc }
            if (r8 <= r7) goto L_0x0139
            goto L_0x0230
        L_0x0139:
            int r8 = r1.height     // Catch:{ all -> 0x04bc }
            if (r8 < r14) goto L_0x022a
            int r8 = r1.height     // Catch:{ all -> 0x04bc }
            if (r8 <= r5) goto L_0x0143
            goto L_0x022a
        L_0x0143:
            int r8 = r1.height     // Catch:{ all -> 0x04bc }
            if (r8 != r5) goto L_0x0152
            int r5 = r1.width     // Catch:{ all -> 0x04bc }
            if (r5 != r7) goto L_0x0152
            java.lang.String r5 = "Cannot resize to a full-screen ad."
            com.google.android.gms.internal.ads.zzawz.zzep(r5)     // Catch:{ all -> 0x04bc }
            goto L_0x0235
        L_0x0152:
            boolean r5 = r1.zzdhz     // Catch:{ all -> 0x04bc }
            if (r5 == 0) goto L_0x0228
            java.lang.String r5 = r1.zzdhy     // Catch:{ all -> 0x04bc }
            int r8 = r5.hashCode()     // Catch:{ all -> 0x04bc }
            switch(r8) {
                case -1364013995: goto L_0x0192;
                case -1012429441: goto L_0x0188;
                case -655373719: goto L_0x017e;
                case 1163912186: goto L_0x0174;
                case 1288627767: goto L_0x016a;
                case 1755462605: goto L_0x0160;
                default: goto L_0x015f;
            }     // Catch:{ all -> 0x04bc }
        L_0x015f:
            goto L_0x019c
        L_0x0160:
            java.lang.String r8 = "top-center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04bc }
            if (r5 == 0) goto L_0x019c
            r5 = 1
            goto L_0x019d
        L_0x016a:
            java.lang.String r8 = "bottom-center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04bc }
            if (r5 == 0) goto L_0x019c
            r5 = 4
            goto L_0x019d
        L_0x0174:
            java.lang.String r8 = "bottom-right"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04bc }
            if (r5 == 0) goto L_0x019c
            r5 = 5
            goto L_0x019d
        L_0x017e:
            java.lang.String r8 = "bottom-left"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04bc }
            if (r5 == 0) goto L_0x019c
            r5 = 3
            goto L_0x019d
        L_0x0188:
            java.lang.String r8 = "top-left"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04bc }
            if (r5 == 0) goto L_0x019c
            r5 = 0
            goto L_0x019d
        L_0x0192:
            java.lang.String r8 = "center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04bc }
            if (r5 == 0) goto L_0x019c
            r5 = 2
            goto L_0x019d
        L_0x019c:
            r5 = -1
        L_0x019d:
            switch(r5) {
                case 0: goto L_0x0202;
                case 1: goto L_0x01f1;
                case 2: goto L_0x01da;
                case 3: goto L_0x01cb;
                case 4: goto L_0x01b6;
                case 5: goto L_0x01a3;
                default: goto L_0x01a0;
            }     // Catch:{ all -> 0x04bc }
        L_0x01a0:
            int r5 = r1.zzdia     // Catch:{ all -> 0x04bc }
            goto L_0x020d
        L_0x01a3:
            int r5 = r1.zzdia     // Catch:{ all -> 0x04bc }
            int r8 = r1.zzdic     // Catch:{ all -> 0x04bc }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04bc }
            int r5 = r5 + r8
            int r5 = r5 - r14
            int r8 = r1.zzdib     // Catch:{ all -> 0x04bc }
            int r15 = r1.zzdid     // Catch:{ all -> 0x04bc }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04bc }
            int r8 = r8 + r15
            int r8 = r8 - r14
            goto L_0x0219
        L_0x01b6:
            int r5 = r1.zzdia     // Catch:{ all -> 0x04bc }
            int r8 = r1.zzdic     // Catch:{ all -> 0x04bc }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04bc }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdib     // Catch:{ all -> 0x04bc }
            int r15 = r1.zzdid     // Catch:{ all -> 0x04bc }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04bc }
            int r8 = r8 + r15
            int r8 = r8 - r14
            goto L_0x0219
        L_0x01cb:
            int r5 = r1.zzdia     // Catch:{ all -> 0x04bc }
            int r8 = r1.zzdic     // Catch:{ all -> 0x04bc }
            int r5 = r5 + r8
            int r8 = r1.zzdib     // Catch:{ all -> 0x04bc }
            int r15 = r1.zzdid     // Catch:{ all -> 0x04bc }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04bc }
            int r8 = r8 + r15
            int r8 = r8 - r14
            goto L_0x0219
        L_0x01da:
            int r5 = r1.zzdia     // Catch:{ all -> 0x04bc }
            int r8 = r1.zzdic     // Catch:{ all -> 0x04bc }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04bc }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdib     // Catch:{ all -> 0x04bc }
            int r15 = r1.zzdid     // Catch:{ all -> 0x04bc }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x04bc }
            int r15 = r15 / r13
            int r8 = r8 + r15
            int r8 = r8 + -25
            goto L_0x0219
        L_0x01f1:
            int r5 = r1.zzdia     // Catch:{ all -> 0x04bc }
            int r8 = r1.zzdic     // Catch:{ all -> 0x04bc }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04bc }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdib     // Catch:{ all -> 0x04bc }
            int r15 = r1.zzdid     // Catch:{ all -> 0x04bc }
            int r8 = r8 + r15
            goto L_0x0219
        L_0x0202:
            int r5 = r1.zzdia     // Catch:{ all -> 0x04bc }
            int r8 = r1.zzdic     // Catch:{ all -> 0x04bc }
            int r5 = r5 + r8
            int r8 = r1.zzdib     // Catch:{ all -> 0x04bc }
            int r15 = r1.zzdid     // Catch:{ all -> 0x04bc }
            int r8 = r8 + r15
            goto L_0x0219
        L_0x020d:
            int r8 = r1.zzdic     // Catch:{ all -> 0x04bc }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x04bc }
            int r5 = r5 + r8
            int r5 = r5 - r14
            int r8 = r1.zzdib     // Catch:{ all -> 0x04bc }
            int r15 = r1.zzdid     // Catch:{ all -> 0x04bc }
            int r8 = r8 + r15
        L_0x0219:
            if (r5 < 0) goto L_0x0235
            int r5 = r5 + r14
            if (r5 > r7) goto L_0x0235
            r5 = r6[r4]     // Catch:{ all -> 0x04bc }
            if (r8 < r5) goto L_0x0235
            int r8 = r8 + r14
            r5 = r6[r3]     // Catch:{ all -> 0x04bc }
            if (r8 <= r5) goto L_0x0228
            goto L_0x0235
        L_0x0228:
            r5 = 1
            goto L_0x0236
        L_0x022a:
            java.lang.String r5 = "Height is too small or too large."
            com.google.android.gms.internal.ads.zzawz.zzep(r5)     // Catch:{ all -> 0x04bc }
            goto L_0x0235
        L_0x0230:
            java.lang.String r5 = "Width is too small or too large."
            com.google.android.gms.internal.ads.zzawz.zzep(r5)     // Catch:{ all -> 0x04bc }
        L_0x0235:
            r5 = 0
        L_0x0236:
            if (r5 != 0) goto L_0x023a
            r5 = 0
            goto L_0x0298
        L_0x023a:
            boolean r5 = r1.zzdhz     // Catch:{ all -> 0x04bc }
            if (r5 == 0) goto L_0x024f
            int[] r5 = new int[r13]     // Catch:{ all -> 0x04bc }
            int r6 = r1.zzdia     // Catch:{ all -> 0x04bc }
            int r7 = r1.zzdic     // Catch:{ all -> 0x04bc }
            int r6 = r6 + r7
            r5[r4] = r6     // Catch:{ all -> 0x04bc }
            int r6 = r1.zzdib     // Catch:{ all -> 0x04bc }
            int r7 = r1.zzdid     // Catch:{ all -> 0x04bc }
            int r6 = r6 + r7
            r5[r3] = r6     // Catch:{ all -> 0x04bc }
            goto L_0x0298
        L_0x024f:
            com.google.android.gms.internal.ads.zzaxi r5 = com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04bc }
            android.app.Activity r6 = r1.zzdhn     // Catch:{ all -> 0x04bc }
            int[] r5 = r5.zze(r6)     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzaxi r6 = com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04bc }
            android.app.Activity r7 = r1.zzdhn     // Catch:{ all -> 0x04bc }
            int[] r6 = r6.zzf(r7)     // Catch:{ all -> 0x04bc }
            r5 = r5[r4]     // Catch:{ all -> 0x04bc }
            int r7 = r1.zzdia     // Catch:{ all -> 0x04bc }
            int r8 = r1.zzdic     // Catch:{ all -> 0x04bc }
            int r7 = r7 + r8
            int r8 = r1.zzdib     // Catch:{ all -> 0x04bc }
            int r15 = r1.zzdid     // Catch:{ all -> 0x04bc }
            int r8 = r8 + r15
            if (r7 >= 0) goto L_0x0273
            r5 = 0
            goto L_0x027d
        L_0x0273:
            int r15 = r1.width     // Catch:{ all -> 0x04bc }
            int r15 = r15 + r7
            if (r15 <= r5) goto L_0x027c
            int r7 = r1.width     // Catch:{ all -> 0x04bc }
            int r5 = r5 - r7
            goto L_0x027d
        L_0x027c:
            r5 = r7
        L_0x027d:
            r7 = r6[r4]     // Catch:{ all -> 0x04bc }
            if (r8 >= r7) goto L_0x0284
            r8 = r6[r4]     // Catch:{ all -> 0x04bc }
            goto L_0x0291
        L_0x0284:
            int r7 = r1.height     // Catch:{ all -> 0x04bc }
            int r7 = r7 + r8
            r15 = r6[r3]     // Catch:{ all -> 0x04bc }
            if (r7 <= r15) goto L_0x0291
            r6 = r6[r3]     // Catch:{ all -> 0x04bc }
            int r7 = r1.height     // Catch:{ all -> 0x04bc }
            int r8 = r6 - r7
        L_0x0291:
            int[] r6 = new int[r13]     // Catch:{ all -> 0x04bc }
            r6[r4] = r5     // Catch:{ all -> 0x04bc }
            r6[r3] = r8     // Catch:{ all -> 0x04bc }
            r5 = r6
        L_0x0298:
            if (r5 != 0) goto L_0x02a1
            java.lang.String r0 = "Resize location out of screen or close button is not visible."
            r1.zzdh(r0)     // Catch:{ all -> 0x04bc }
            monitor-exit(r2)     // Catch:{ all -> 0x04bc }
            return
        L_0x02a1:
            com.google.android.gms.internal.ads.zzyt.zzpa()     // Catch:{ all -> 0x04bc }
            android.app.Activity r6 = r1.zzdhn     // Catch:{ all -> 0x04bc }
            int r7 = r1.width     // Catch:{ all -> 0x04bc }
            int r6 = com.google.android.gms.internal.ads.zzazt.zza((android.content.Context) r6, (int) r7)     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzyt.zzpa()     // Catch:{ all -> 0x04bc }
            android.app.Activity r7 = r1.zzdhn     // Catch:{ all -> 0x04bc }
            int r8 = r1.height     // Catch:{ all -> 0x04bc }
            int r7 = com.google.android.gms.internal.ads.zzazt.zza((android.content.Context) r7, (int) r8)     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzbgz r8 = r1.zzdbs     // Catch:{ all -> 0x04bc }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x04bc }
            android.view.ViewParent r8 = r8.getParent()     // Catch:{ all -> 0x04bc }
            if (r8 == 0) goto L_0x04ae
            boolean r15 = r8 instanceof android.view.ViewGroup     // Catch:{ all -> 0x04bc }
            if (r15 == 0) goto L_0x04ae
            r15 = r8
            android.view.ViewGroup r15 = (android.view.ViewGroup) r15     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzbgz r9 = r1.zzdbs     // Catch:{ all -> 0x04bc }
            android.view.View r9 = r9.getView()     // Catch:{ all -> 0x04bc }
            r15.removeView(r9)     // Catch:{ all -> 0x04bc }
            android.widget.PopupWindow r9 = r1.zzdih     // Catch:{ all -> 0x04bc }
            if (r9 != 0) goto L_0x0306
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8     // Catch:{ all -> 0x04bc }
            r1.zzdij = r8     // Catch:{ all -> 0x04bc }
            com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzbgz r8 = r1.zzdbs     // Catch:{ all -> 0x04bc }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x04bc }
            android.graphics.Bitmap r8 = com.google.android.gms.internal.ads.zzaxi.zzk(r8)     // Catch:{ all -> 0x04bc }
            android.widget.ImageView r9 = new android.widget.ImageView     // Catch:{ all -> 0x04bc }
            android.app.Activity r15 = r1.zzdhn     // Catch:{ all -> 0x04bc }
            r9.<init>(r15)     // Catch:{ all -> 0x04bc }
            r1.zzdif = r9     // Catch:{ all -> 0x04bc }
            android.widget.ImageView r9 = r1.zzdif     // Catch:{ all -> 0x04bc }
            r9.setImageBitmap(r8)     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzbgz r8 = r1.zzdbs     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzbin r8 = r8.zzaag()     // Catch:{ all -> 0x04bc }
            r1.zzdie = r8     // Catch:{ all -> 0x04bc }
            android.view.ViewGroup r8 = r1.zzdij     // Catch:{ all -> 0x04bc }
            android.widget.ImageView r9 = r1.zzdif     // Catch:{ all -> 0x04bc }
            r8.addView(r9)     // Catch:{ all -> 0x04bc }
            goto L_0x030b
        L_0x0306:
            android.widget.PopupWindow r8 = r1.zzdih     // Catch:{ all -> 0x04bc }
            r8.dismiss()     // Catch:{ all -> 0x04bc }
        L_0x030b:
            android.widget.RelativeLayout r8 = new android.widget.RelativeLayout     // Catch:{ all -> 0x04bc }
            android.app.Activity r9 = r1.zzdhn     // Catch:{ all -> 0x04bc }
            r8.<init>(r9)     // Catch:{ all -> 0x04bc }
            r1.zzdii = r8     // Catch:{ all -> 0x04bc }
            android.widget.RelativeLayout r8 = r1.zzdii     // Catch:{ all -> 0x04bc }
            r8.setBackgroundColor(r4)     // Catch:{ all -> 0x04bc }
            android.widget.RelativeLayout r8 = r1.zzdii     // Catch:{ all -> 0x04bc }
            android.view.ViewGroup$LayoutParams r9 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x04bc }
            r9.<init>(r6, r7)     // Catch:{ all -> 0x04bc }
            r8.setLayoutParams(r9)     // Catch:{ all -> 0x04bc }
            com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04bc }
            android.widget.RelativeLayout r8 = r1.zzdii     // Catch:{ all -> 0x04bc }
            android.widget.PopupWindow r8 = com.google.android.gms.internal.ads.zzaxi.zza((android.view.View) r8, (int) r6, (int) r7, (boolean) r4)     // Catch:{ all -> 0x04bc }
            r1.zzdih = r8     // Catch:{ all -> 0x04bc }
            android.widget.PopupWindow r8 = r1.zzdih     // Catch:{ all -> 0x04bc }
            r8.setOutsideTouchable(r3)     // Catch:{ all -> 0x04bc }
            android.widget.PopupWindow r8 = r1.zzdih     // Catch:{ all -> 0x04bc }
            r8.setTouchable(r3)     // Catch:{ all -> 0x04bc }
            android.widget.PopupWindow r8 = r1.zzdih     // Catch:{ all -> 0x04bc }
            boolean r9 = r1.zzdhz     // Catch:{ all -> 0x04bc }
            r9 = r9 ^ r3
            r8.setClippingEnabled(r9)     // Catch:{ all -> 0x04bc }
            android.widget.RelativeLayout r8 = r1.zzdii     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzbgz r9 = r1.zzdbs     // Catch:{ all -> 0x04bc }
            android.view.View r9 = r9.getView()     // Catch:{ all -> 0x04bc }
            r8.addView(r9, r12, r12)     // Catch:{ all -> 0x04bc }
            android.widget.LinearLayout r8 = new android.widget.LinearLayout     // Catch:{ all -> 0x04bc }
            android.app.Activity r9 = r1.zzdhn     // Catch:{ all -> 0x04bc }
            r8.<init>(r9)     // Catch:{ all -> 0x04bc }
            r1.zzdig = r8     // Catch:{ all -> 0x04bc }
            android.widget.RelativeLayout$LayoutParams r8 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzyt.zzpa()     // Catch:{ all -> 0x04bc }
            android.app.Activity r9 = r1.zzdhn     // Catch:{ all -> 0x04bc }
            int r9 = com.google.android.gms.internal.ads.zzazt.zza((android.content.Context) r9, (int) r14)     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzyt.zzpa()     // Catch:{ all -> 0x04bc }
            android.app.Activity r15 = r1.zzdhn     // Catch:{ all -> 0x04bc }
            int r14 = com.google.android.gms.internal.ads.zzazt.zza((android.content.Context) r15, (int) r14)     // Catch:{ all -> 0x04bc }
            r8.<init>(r9, r14)     // Catch:{ all -> 0x04bc }
            java.lang.String r9 = r1.zzdhy     // Catch:{ all -> 0x04bc }
            int r14 = r9.hashCode()     // Catch:{ all -> 0x04bc }
            switch(r14) {
                case -1364013995: goto L_0x03ac;
                case -1012429441: goto L_0x03a1;
                case -655373719: goto L_0x0396;
                case 1163912186: goto L_0x038b;
                case 1288627767: goto L_0x0380;
                case 1755462605: goto L_0x0375;
                default: goto L_0x0374;
            }     // Catch:{ all -> 0x04bc }
        L_0x0374:
            goto L_0x03b7
        L_0x0375:
            java.lang.String r10 = "top-center"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x04bc }
            if (r9 == 0) goto L_0x03b7
            r16 = 1
            goto L_0x03b9
        L_0x0380:
            java.lang.String r10 = "bottom-center"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x04bc }
            if (r9 == 0) goto L_0x03b7
            r16 = 4
            goto L_0x03b9
        L_0x038b:
            java.lang.String r11 = "bottom-right"
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x04bc }
            if (r9 == 0) goto L_0x03b7
            r16 = 5
            goto L_0x03b9
        L_0x0396:
            java.lang.String r10 = "bottom-left"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x04bc }
            if (r9 == 0) goto L_0x03b7
            r16 = 3
            goto L_0x03b9
        L_0x03a1:
            java.lang.String r10 = "top-left"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x04bc }
            if (r9 == 0) goto L_0x03b7
            r16 = 0
            goto L_0x03b9
        L_0x03ac:
            java.lang.String r10 = "center"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x04bc }
            if (r9 == 0) goto L_0x03b7
            r16 = 2
            goto L_0x03b9
        L_0x03b7:
            r16 = -1
        L_0x03b9:
            r9 = 14
            r10 = 9
            r11 = 11
            r12 = 12
            r13 = 10
            switch(r16) {
                case 0: goto L_0x03ec;
                case 1: goto L_0x03e5;
                case 2: goto L_0x03df;
                case 3: goto L_0x03d8;
                case 4: goto L_0x03d1;
                case 5: goto L_0x03ca;
                default: goto L_0x03c6;
            }     // Catch:{ all -> 0x04bc }
        L_0x03c6:
            r8.addRule(r13)     // Catch:{ all -> 0x04bc }
            goto L_0x03f3
        L_0x03ca:
            r8.addRule(r12)     // Catch:{ all -> 0x04bc }
            r8.addRule(r11)     // Catch:{ all -> 0x04bc }
            goto L_0x03f6
        L_0x03d1:
            r8.addRule(r12)     // Catch:{ all -> 0x04bc }
            r8.addRule(r9)     // Catch:{ all -> 0x04bc }
            goto L_0x03f6
        L_0x03d8:
            r8.addRule(r12)     // Catch:{ all -> 0x04bc }
            r8.addRule(r10)     // Catch:{ all -> 0x04bc }
            goto L_0x03f6
        L_0x03df:
            r9 = 13
            r8.addRule(r9)     // Catch:{ all -> 0x04bc }
            goto L_0x03f6
        L_0x03e5:
            r8.addRule(r13)     // Catch:{ all -> 0x04bc }
            r8.addRule(r9)     // Catch:{ all -> 0x04bc }
            goto L_0x03f6
        L_0x03ec:
            r8.addRule(r13)     // Catch:{ all -> 0x04bc }
            r8.addRule(r10)     // Catch:{ all -> 0x04bc }
            goto L_0x03f6
        L_0x03f3:
            r8.addRule(r11)     // Catch:{ all -> 0x04bc }
        L_0x03f6:
            android.widget.LinearLayout r9 = r1.zzdig     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzaps r10 = new com.google.android.gms.internal.ads.zzaps     // Catch:{ all -> 0x04bc }
            r10.<init>(r1)     // Catch:{ all -> 0x04bc }
            r9.setOnClickListener(r10)     // Catch:{ all -> 0x04bc }
            android.widget.LinearLayout r9 = r1.zzdig     // Catch:{ all -> 0x04bc }
            java.lang.String r10 = "Close button"
            r9.setContentDescription(r10)     // Catch:{ all -> 0x04bc }
            android.widget.RelativeLayout r9 = r1.zzdii     // Catch:{ all -> 0x04bc }
            android.widget.LinearLayout r10 = r1.zzdig     // Catch:{ all -> 0x04bc }
            r9.addView(r10, r8)     // Catch:{ all -> 0x04bc }
            android.widget.PopupWindow r8 = r1.zzdih     // Catch:{ RuntimeException -> 0x0466 }
            android.view.View r0 = r0.getDecorView()     // Catch:{ RuntimeException -> 0x0466 }
            com.google.android.gms.internal.ads.zzyt.zzpa()     // Catch:{ RuntimeException -> 0x0466 }
            android.app.Activity r9 = r1.zzdhn     // Catch:{ RuntimeException -> 0x0466 }
            r10 = r5[r4]     // Catch:{ RuntimeException -> 0x0466 }
            int r9 = com.google.android.gms.internal.ads.zzazt.zza((android.content.Context) r9, (int) r10)     // Catch:{ RuntimeException -> 0x0466 }
            com.google.android.gms.internal.ads.zzyt.zzpa()     // Catch:{ RuntimeException -> 0x0466 }
            android.app.Activity r10 = r1.zzdhn     // Catch:{ RuntimeException -> 0x0466 }
            r11 = r5[r3]     // Catch:{ RuntimeException -> 0x0466 }
            int r10 = com.google.android.gms.internal.ads.zzazt.zza((android.content.Context) r10, (int) r11)     // Catch:{ RuntimeException -> 0x0466 }
            r8.showAtLocation(r0, r4, r9, r10)     // Catch:{ RuntimeException -> 0x0466 }
            r0 = r5[r4]     // Catch:{ all -> 0x04bc }
            r8 = r5[r3]     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzaqc r9 = r1.zzdal     // Catch:{ all -> 0x04bc }
            if (r9 == 0) goto L_0x043e
            com.google.android.gms.internal.ads.zzaqc r9 = r1.zzdal     // Catch:{ all -> 0x04bc }
            int r10 = r1.width     // Catch:{ all -> 0x04bc }
            int r11 = r1.height     // Catch:{ all -> 0x04bc }
            r9.zzc(r0, r8, r10, r11)     // Catch:{ all -> 0x04bc }
        L_0x043e:
            com.google.android.gms.internal.ads.zzbgz r0 = r1.zzdbs     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzbin r6 = com.google.android.gms.internal.ads.zzbin.zzr(r6, r7)     // Catch:{ all -> 0x04bc }
            r0.zza((com.google.android.gms.internal.ads.zzbin) r6)     // Catch:{ all -> 0x04bc }
            r0 = r5[r4]     // Catch:{ all -> 0x04bc }
            r3 = r5[r3]     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzaxi r5 = com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04bc }
            android.app.Activity r6 = r1.zzdhn     // Catch:{ all -> 0x04bc }
            int[] r5 = r5.zzf(r6)     // Catch:{ all -> 0x04bc }
            r4 = r5[r4]     // Catch:{ all -> 0x04bc }
            int r3 = r3 - r4
            int r4 = r1.width     // Catch:{ all -> 0x04bc }
            int r5 = r1.height     // Catch:{ all -> 0x04bc }
            r1.zza(r0, r3, r4, r5)     // Catch:{ all -> 0x04bc }
            java.lang.String r0 = "resized"
            r1.zzdj(r0)     // Catch:{ all -> 0x04bc }
            monitor-exit(r2)     // Catch:{ all -> 0x04bc }
            return
        L_0x0466:
            r0 = move-exception
            java.lang.String r3 = "Cannot show popup window: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x04bc }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x04bc }
            int r4 = r0.length()     // Catch:{ all -> 0x04bc }
            if (r4 == 0) goto L_0x047c
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x04bc }
            goto L_0x0481
        L_0x047c:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x04bc }
            r0.<init>(r3)     // Catch:{ all -> 0x04bc }
        L_0x0481:
            r1.zzdh(r0)     // Catch:{ all -> 0x04bc }
            android.widget.RelativeLayout r0 = r1.zzdii     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzbgz r3 = r1.zzdbs     // Catch:{ all -> 0x04bc }
            android.view.View r3 = r3.getView()     // Catch:{ all -> 0x04bc }
            r0.removeView(r3)     // Catch:{ all -> 0x04bc }
            android.view.ViewGroup r0 = r1.zzdij     // Catch:{ all -> 0x04bc }
            if (r0 == 0) goto L_0x04ac
            android.view.ViewGroup r0 = r1.zzdij     // Catch:{ all -> 0x04bc }
            android.widget.ImageView r3 = r1.zzdif     // Catch:{ all -> 0x04bc }
            r0.removeView(r3)     // Catch:{ all -> 0x04bc }
            android.view.ViewGroup r0 = r1.zzdij     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzbgz r3 = r1.zzdbs     // Catch:{ all -> 0x04bc }
            android.view.View r3 = r3.getView()     // Catch:{ all -> 0x04bc }
            r0.addView(r3)     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzbgz r0 = r1.zzdbs     // Catch:{ all -> 0x04bc }
            com.google.android.gms.internal.ads.zzbin r3 = r1.zzdie     // Catch:{ all -> 0x04bc }
            r0.zza((com.google.android.gms.internal.ads.zzbin) r3)     // Catch:{ all -> 0x04bc }
        L_0x04ac:
            monitor-exit(r2)     // Catch:{ all -> 0x04bc }
            return
        L_0x04ae:
            java.lang.String r0 = "Webview is detached, probably in the middle of a resize or expand."
            r1.zzdh(r0)     // Catch:{ all -> 0x04bc }
            monitor-exit(r2)     // Catch:{ all -> 0x04bc }
            return
        L_0x04b5:
            java.lang.String r0 = "Activity context is not ready, cannot get window or decor view."
            r1.zzdh(r0)     // Catch:{ all -> 0x04bc }
            monitor-exit(r2)     // Catch:{ all -> 0x04bc }
            return
        L_0x04bc:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x04bc }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapr.zzg(java.util.Map):void");
    }

    public final void zzw(boolean z) {
        synchronized (this.lock) {
            if (this.zzdih != null) {
                this.zzdih.dismiss();
                this.zzdii.removeView(this.zzdbs.getView());
                if (this.zzdij != null) {
                    this.zzdij.removeView(this.zzdif);
                    this.zzdij.addView(this.zzdbs.getView());
                    this.zzdbs.zza(this.zzdie);
                }
                if (z) {
                    zzdj("default");
                    if (this.zzdal != null) {
                        this.zzdal.zztc();
                    }
                }
                this.zzdih = null;
                this.zzdii = null;
                this.zzdij = null;
                this.zzdig = null;
            }
        }
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.lock) {
            this.zzdia = i;
            this.zzdib = i2;
        }
    }

    public final boolean zztb() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdih != null;
        }
        return z;
    }

    public final void zzi(int i, int i2) {
        this.zzdia = i;
        this.zzdib = i2;
    }
}
