package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.dataflow.qual.SideEffectFree;

@TargetApi(16)
@ParametersAreNonnullByDefault
@zzard
public final class zzbdq extends zzbco implements TextureView.SurfaceTextureListener {
    @Nullable
    private Surface zzaez;
    /* access modifiers changed from: private */
    public float zzaft;
    private final zzbdg zzeaw;
    private final boolean zzeax;
    /* access modifiers changed from: private */
    public int zzebc;
    /* access modifiers changed from: private */
    public int zzebd;
    private int zzebf;
    private int zzebg;
    @Nullable
    private zzbdd zzebh;
    private boolean zzebi;
    private zzbcn zzebk;
    private final zzbdf zzebt;
    @Nullable
    private zzge zzefe;
    @Nullable
    private zzhd zzeff;
    @Nullable
    private zzgn zzefg;
    private float zzefn;
    private final int zzefo;
    private final zzbde zzefp;
    @Nullable
    private zzbdk zzefq;
    private String zzefr;
    private boolean zzefs;
    /* access modifiers changed from: private */
    public int zzeft = 1;
    private boolean zzefu;
    private boolean zzefv;
    private final zzgh zzefw = new zzbee(this);
    private final zzhh zzefx = new zzbef(this);
    private final zzgq zzefy = new zzbeg(this);
    private final Context zzlj;

    public zzbdq(Context context, zzbdg zzbdg, zzbdf zzbdf, int i, boolean z, boolean z2, zzbde zzbde) {
        super(context);
        this.zzlj = context;
        this.zzeax = z2;
        this.zzebt = zzbdf;
        this.zzefo = i;
        this.zzeaw = zzbdg;
        this.zzebi = z;
        this.zzefp = zzbde;
        setSurfaceTextureListener(this);
        this.zzeaw.zzb(this);
    }

    @EnsuresNonNullIf(expression = {"mPlayer"}, result = true)
    private final boolean zzyv() {
        return this.zzefe != null && !this.zzefs;
    }

    @EnsuresNonNullIf(expression = {"mPlayer"}, result = true)
    private final boolean zzyw() {
        return zzyv() && this.zzeft != 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: com.google.android.gms.internal.ads.zzbej} */
    /* JADX WARNING: type inference failed for: r0v39, types: [com.google.android.gms.internal.ads.zzgl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzyx() {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzge r0 = r12.zzefe
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.String r0 = r12.zzefr
            if (r0 == 0) goto L_0x022a
            android.view.Surface r0 = r12.zzaez
            if (r0 == 0) goto L_0x022a
            java.lang.String r0 = r12.zzefr
            java.lang.String r1 = "cache:"
            boolean r0 = r0.startsWith(r1)
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x0131
            com.google.android.gms.internal.ads.zzbdf r0 = r12.zzebt
            java.lang.String r3 = r12.zzefr
            com.google.android.gms.internal.ads.zzbft r0 = r0.zzet(r3)
            if (r0 == 0) goto L_0x003b
            boolean r3 = r0 instanceof com.google.android.gms.internal.ads.zzbgl
            if (r3 == 0) goto L_0x003b
            com.google.android.gms.internal.ads.zzbgl r0 = (com.google.android.gms.internal.ads.zzbgl) r0
            r0.zzzx()
            com.google.android.gms.internal.ads.zzbdk r2 = r0.zzzy()
            com.google.android.gms.internal.ads.zzgh r0 = r12.zzefw
            com.google.android.gms.internal.ads.zzhh r3 = r12.zzefx
            com.google.android.gms.internal.ads.zzgq r4 = r12.zzefy
            r2.zza((com.google.android.gms.internal.ads.zzgh) r0, (com.google.android.gms.internal.ads.zzhh) r3, (com.google.android.gms.internal.ads.zzgq) r4)
            goto L_0x01d6
        L_0x003b:
            boolean r3 = r0 instanceof com.google.android.gms.internal.ads.zzbgg
            if (r3 == 0) goto L_0x0113
            com.google.android.gms.internal.ads.zzbgg r0 = (com.google.android.gms.internal.ads.zzbgg) r0
            java.nio.ByteBuffer r3 = r0.getByteBuffer()
            java.lang.String r4 = r0.getUrl()
            boolean r0 = r0.zzzv()
            com.google.android.gms.internal.ads.zzbdk r5 = new com.google.android.gms.internal.ads.zzbdk
            r5.<init>()
            java.lang.String r6 = "video/webm"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x0061
            com.google.android.gms.internal.ads.zzjg r2 = new com.google.android.gms.internal.ads.zzjg
            r2.<init>()
        L_0x005f:
            r9 = r2
            goto L_0x0067
        L_0x0061:
            com.google.android.gms.internal.ads.zziv r2 = new com.google.android.gms.internal.ads.zziv
            r2.<init>()
            goto L_0x005f
        L_0x0067:
            if (r0 == 0) goto L_0x008d
            int r0 = r3.limit()
            if (r0 <= 0) goto L_0x008d
            int r0 = r3.limit()
            byte[] r0 = new byte[r0]
            r3.get(r0)
            com.google.android.gms.internal.ads.zzjo r8 = new com.google.android.gms.internal.ads.zzjo
            r8.<init>(r0)
            com.google.android.gms.internal.ads.zzig r0 = new com.google.android.gms.internal.ads.zzig
            android.net.Uri r7 = android.net.Uri.parse(r4)
            r10 = 2
            com.google.android.gms.internal.ads.zzbde r2 = r12.zzefp
            int r11 = r2.zzeee
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            goto L_0x00fa
        L_0x008d:
            com.google.android.gms.internal.ads.zzaxi r0 = com.google.android.gms.ads.internal.zzk.zzlg()
            com.google.android.gms.internal.ads.zzbdf r2 = r12.zzebt
            android.content.Context r2 = r2.getContext()
            com.google.android.gms.internal.ads.zzbdf r6 = r12.zzebt
            com.google.android.gms.internal.ads.zzbai r6 = r6.zzyh()
            java.lang.String r6 = r6.zzbsx
            java.lang.String r0 = r0.zzq(r2, r6)
            com.google.android.gms.internal.ads.zzjt r2 = new com.google.android.gms.internal.ads.zzjt
            com.google.android.gms.internal.ads.zzbdf r6 = r12.zzebt
            android.content.Context r6 = r6.getContext()
            r2.<init>(r6, r0)
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.zzctr
            com.google.android.gms.internal.ads.zzacr r6 = com.google.android.gms.internal.ads.zzyt.zzpe()
            java.lang.Object r0 = r6.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00cd
            com.google.android.gms.internal.ads.zzbeh r0 = new com.google.android.gms.internal.ads.zzbeh
            android.content.Context r6 = r12.zzlj
            com.google.android.gms.internal.ads.zzbds r7 = new com.google.android.gms.internal.ads.zzbds
            r7.<init>(r12)
            r0.<init>(r6, r2, r7)
            goto L_0x00ce
        L_0x00cd:
            r0 = r2
        L_0x00ce:
            int r2 = r3.limit()
            if (r2 <= 0) goto L_0x00ea
            int r2 = r3.limit()
            byte[] r2 = new byte[r2]
            r3.get(r2)
            com.google.android.gms.internal.ads.zzjo r3 = new com.google.android.gms.internal.ads.zzjo
            r3.<init>(r2)
            com.google.android.gms.internal.ads.zzbej r6 = new com.google.android.gms.internal.ads.zzbej
            int r2 = r2.length
            r6.<init>(r3, r2, r0)
            r8 = r6
            goto L_0x00eb
        L_0x00ea:
            r8 = r0
        L_0x00eb:
            com.google.android.gms.internal.ads.zzig r0 = new com.google.android.gms.internal.ads.zzig
            android.net.Uri r7 = android.net.Uri.parse(r4)
            r10 = 2
            com.google.android.gms.internal.ads.zzbde r2 = r12.zzefp
            int r11 = r2.zzeee
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
        L_0x00fa:
            com.google.android.gms.internal.ads.zzgh r2 = r12.zzefw
            com.google.android.gms.internal.ads.zzhh r3 = r12.zzefx
            com.google.android.gms.internal.ads.zzgq r4 = r12.zzefy
            r5.zza((com.google.android.gms.internal.ads.zzgh) r2, (com.google.android.gms.internal.ads.zzhh) r3, (com.google.android.gms.internal.ads.zzgq) r4)
            boolean r0 = r5.zza((com.google.android.gms.internal.ads.zzhn) r0)
            if (r0 != 0) goto L_0x0110
            java.lang.String r0 = "AdExoPlayerHelper Error"
            java.lang.String r2 = "Prepare from ByteBuffer failed."
            r12.zzn((java.lang.String) r0, (java.lang.String) r2)
        L_0x0110:
            r2 = r5
            goto L_0x01d6
        L_0x0113:
            java.lang.String r0 = "Source is MD5 but not found in cache. Source: "
            java.lang.String r3 = r12.zzefr
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x0126
            java.lang.String r0 = r0.concat(r3)
            goto L_0x012c
        L_0x0126:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r0)
            r0 = r3
        L_0x012c:
            com.google.android.gms.internal.ads.zzawz.zzep(r0)
            goto L_0x01d6
        L_0x0131:
            int r0 = r12.zzefo
            r3 = 2
            r4 = 1
            if (r0 != r4) goto L_0x014a
            com.google.android.gms.internal.ads.zzgl r0 = new com.google.android.gms.internal.ads.zzgl
            com.google.android.gms.internal.ads.zzbdf r4 = r12.zzebt
            android.content.Context r4 = r4.getContext()
            java.lang.String r5 = r12.zzefr
            android.net.Uri r5 = android.net.Uri.parse(r5)
            r0.<init>(r4, r5, r2, r3)
            goto L_0x01bb
        L_0x014a:
            int r0 = r12.zzefo
            if (r0 != r3) goto L_0x014f
            goto L_0x0150
        L_0x014f:
            r4 = 0
        L_0x0150:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r4)
            com.google.android.gms.internal.ads.zzaxi r0 = com.google.android.gms.ads.internal.zzk.zzlg()
            com.google.android.gms.internal.ads.zzbdf r3 = r12.zzebt
            android.content.Context r3 = r3.getContext()
            com.google.android.gms.internal.ads.zzbdf r4 = r12.zzebt
            com.google.android.gms.internal.ads.zzbai r4 = r4.zzyh()
            java.lang.String r4 = r4.zzbsx
            java.lang.String r0 = r0.zzq(r3, r4)
            com.google.android.gms.internal.ads.zzjt r3 = new com.google.android.gms.internal.ads.zzjt
            com.google.android.gms.internal.ads.zzbdf r4 = r12.zzebt
            android.content.Context r4 = r4.getContext()
            r3.<init>(r4, r0)
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.zzctr
            com.google.android.gms.internal.ads.zzacr r4 = com.google.android.gms.internal.ads.zzyt.zzpe()
            java.lang.Object r0 = r4.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0194
            com.google.android.gms.internal.ads.zzbeh r0 = new com.google.android.gms.internal.ads.zzbeh
            android.content.Context r4 = r12.zzlj
            com.google.android.gms.internal.ads.zzbdr r5 = new com.google.android.gms.internal.ads.zzbdr
            r5.<init>(r12)
            r0.<init>(r4, r3, r5)
            r8 = r0
            goto L_0x0195
        L_0x0194:
            r8 = r3
        L_0x0195:
            java.lang.String r0 = "video/webm"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x01a4
            com.google.android.gms.internal.ads.zzjg r0 = new com.google.android.gms.internal.ads.zzjg
            r0.<init>()
        L_0x01a2:
            r9 = r0
            goto L_0x01aa
        L_0x01a4:
            com.google.android.gms.internal.ads.zziv r0 = new com.google.android.gms.internal.ads.zziv
            r0.<init>()
            goto L_0x01a2
        L_0x01aa:
            com.google.android.gms.internal.ads.zzig r0 = new com.google.android.gms.internal.ads.zzig
            java.lang.String r2 = r12.zzefr
            android.net.Uri r7 = android.net.Uri.parse(r2)
            r10 = 2
            com.google.android.gms.internal.ads.zzbde r2 = r12.zzefp
            int r11 = r2.zzeee
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
        L_0x01bb:
            com.google.android.gms.internal.ads.zzbdk r2 = new com.google.android.gms.internal.ads.zzbdk
            r2.<init>()
            com.google.android.gms.internal.ads.zzgh r3 = r12.zzefw
            com.google.android.gms.internal.ads.zzhh r4 = r12.zzefx
            com.google.android.gms.internal.ads.zzgq r5 = r12.zzefy
            r2.zza((com.google.android.gms.internal.ads.zzgh) r3, (com.google.android.gms.internal.ads.zzhh) r4, (com.google.android.gms.internal.ads.zzgq) r5)
            boolean r0 = r2.zza((com.google.android.gms.internal.ads.zzhn) r0)
            if (r0 != 0) goto L_0x01d6
            java.lang.String r0 = "AdExoPlayerHelper Error"
            java.lang.String r3 = "Prepare failed."
            r12.zzn((java.lang.String) r0, (java.lang.String) r3)
        L_0x01d6:
            r12.zzefq = r2
            com.google.android.gms.internal.ads.zzbdk r0 = r12.zzefq
            if (r0 != 0) goto L_0x01f9
            java.lang.String r0 = "AdExoPlayerHelper is null. Source: "
            java.lang.String r1 = r12.zzefr
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            if (r2 == 0) goto L_0x01ef
            java.lang.String r0 = r0.concat(r1)
            goto L_0x01f5
        L_0x01ef:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0)
            r0 = r1
        L_0x01f5:
            com.google.android.gms.internal.ads.zzawz.zzep(r0)
            return
        L_0x01f9:
            com.google.android.gms.internal.ads.zzbdk r0 = r12.zzefq
            com.google.android.gms.internal.ads.zzge r0 = r0.zzys()
            r12.zzefe = r0
            com.google.android.gms.internal.ads.zzbdk r0 = r12.zzefq
            com.google.android.gms.internal.ads.zzhd r0 = r0.zzyt()
            r12.zzeff = r0
            com.google.android.gms.internal.ads.zzbdk r0 = r12.zzefq
            com.google.android.gms.internal.ads.zzgn r0 = r0.zzyu()
            r12.zzefg = r0
            com.google.android.gms.internal.ads.zzge r0 = r12.zzefe
            if (r0 == 0) goto L_0x022a
            android.view.Surface r0 = r12.zzaez
            r12.zza((android.view.Surface) r0, (boolean) r1)
            com.google.android.gms.internal.ads.zzge r0 = r12.zzefe
            int r0 = r0.getPlaybackState()
            r12.zzeft = r0
            int r0 = r12.zzeft
            r1 = 4
            if (r0 != r1) goto L_0x022a
            r12.zzyy()
        L_0x022a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdq.zzyx():void");
    }

    @SideEffectFree
    private final void zza(@Nullable Surface surface, boolean z) {
        if (this.zzefe == null || this.zzeff == null) {
            zzawz.zzep("Trying to set surface before player and renderers are initalized.");
        } else if (z) {
            this.zzefe.zzb(this.zzeff, 1, surface);
        } else {
            this.zzefe.zza(this.zzeff, 1, surface);
        }
    }

    @SideEffectFree
    private final void zza(float f, boolean z) {
        if (this.zzefe == null || this.zzefg == null) {
            zzawz.zzep("Trying to set volume before player and renderers are initalized.");
        } else if (z) {
            this.zzefe.zzb(this.zzefg, 1, Float.valueOf(f));
        } else {
            this.zzefe.zza(this.zzefg, 1, Float.valueOf(f));
        }
    }

    public final void zzxk() {
        zza(this.zzebs.getVolume(), false);
    }

    /* access modifiers changed from: private */
    public final void zzb(int i, int i2, float f) {
        float f2 = i2 == 0 ? 1.0f : (((float) i) * f) / ((float) i2);
        if (this.zzefn != f2) {
            this.zzefn = f2;
            requestLayout();
        }
    }

    /* access modifiers changed from: private */
    public final void zzyy() {
        if (!this.zzefu) {
            this.zzefu = true;
            zzawz.zzds("Video is ready.");
            zzaxi.zzdvv.post(new zzbdw(this));
            zzxk();
            this.zzeaw.zzhd();
            if (this.zzefv) {
                play();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzyk() {
        zzawz.zzds("Video ended.");
        if (this.zzefp.zzeec) {
            zzza();
        }
        this.zzeaw.zzym();
        this.zzebs.zzym();
        zzaxi.zzdvv.post(new zzbdx(this));
    }

    /* access modifiers changed from: private */
    public final void zzn(String str, @Nullable String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 19 + String.valueOf(str2).length());
        sb.append("Error received: ");
        sb.append(str);
        sb.append(" : ");
        sb.append(str2);
        zzawz.zzep(sb.toString());
        this.zzefs = true;
        if (this.zzefp.zzeec) {
            zzza();
        }
        zzaxi.zzdvv.post(new zzbdy(this, str, str2));
    }

    public final String zzxg() {
        String str;
        if (this.zzefo == 1) {
            str = "/Framework";
        } else if (this.zzefo == 2) {
            StringBuilder sb = new StringBuilder(String.valueOf((Object) null).length() + 12);
            sb.append("/Extractor(");
            sb.append((String) null);
            sb.append(")");
            str = sb.toString();
        } else {
            str = "/Unknown";
        }
        String str2 = this.zzebi ? " spherical" : "";
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(str2).length());
        sb2.append("ExoPlayer/1");
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    public final void zza(zzbcn zzbcn) {
        this.zzebk = zzbcn;
    }

    public final void setVideoPath(String str) {
        if (str != null) {
            this.zzefr = str;
            zzyx();
            return;
        }
        zzawz.zzep("Path is null.");
    }

    public final void play() {
        if (zzyw()) {
            if (this.zzefp.zzeec) {
                zzyz();
            }
            this.zzefe.zzd(true);
            this.zzeaw.zzyl();
            this.zzebs.zzyl();
            this.zzebr.zzxm();
            zzaxi.zzdvv.post(new zzbdz(this));
            return;
        }
        this.zzefv = true;
    }

    public final void stop() {
        if (zzyv()) {
            this.zzefe.stop();
            if (this.zzefe != null) {
                zza((Surface) null, true);
                if (this.zzefq != null) {
                    this.zzefq.zzyr();
                    this.zzefq = null;
                }
                this.zzefe = null;
                this.zzeff = null;
                this.zzefg = null;
                this.zzeft = 1;
                this.zzefs = false;
                this.zzefu = false;
                this.zzefv = false;
            }
        }
        this.zzeaw.zzym();
        this.zzebs.zzym();
        this.zzeaw.onStop();
    }

    public final void pause() {
        if (zzyw()) {
            if (this.zzefp.zzeec) {
                zzza();
            }
            this.zzefe.zzd(false);
            this.zzeaw.zzym();
            this.zzebs.zzym();
            zzaxi.zzdvv.post(new zzbea(this));
        }
    }

    public final void seekTo(int i) {
        if (zzyw()) {
            this.zzefe.seekTo((long) i);
        }
    }

    public final void zza(float f, float f2) {
        if (this.zzebh != null) {
            this.zzebh.zzb(f, f2);
        }
    }

    public final int getCurrentPosition() {
        if (zzyw()) {
            return (int) this.zzefe.zzdn();
        }
        return 0;
    }

    public final int getDuration() {
        if (zzyw()) {
            return (int) this.zzefe.getDuration();
        }
        return 0;
    }

    public final int getVideoWidth() {
        return this.zzebc;
    }

    public final int getVideoHeight() {
        return this.zzebd;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008f A[LOOP:0: B:32:0x008f->B:37:0x00ac, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            super.onMeasure(r9, r10)
            int r9 = r8.getMeasuredWidth()
            int r10 = r8.getMeasuredHeight()
            float r0 = r8.zzefn
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzbdd r0 = r8.zzebh
            if (r0 != 0) goto L_0x0038
            float r0 = (float) r9
            float r2 = (float) r10
            float r3 = r0 / r2
            float r4 = r8.zzefn
            float r4 = r4 / r3
            r3 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 - r3
            r3 = 1008981770(0x3c23d70a, float:0.01)
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x002c
            float r10 = r8.zzefn
            float r0 = r0 / r10
            int r10 = (int) r0
            goto L_0x0038
        L_0x002c:
            r0 = -1138501878(0xffffffffbc23d70a, float:-0.01)
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0038
            float r9 = r8.zzefn
            float r2 = r2 * r9
            int r9 = (int) r2
        L_0x0038:
            r8.setMeasuredDimension(r9, r10)
            com.google.android.gms.internal.ads.zzbdd r0 = r8.zzebh
            if (r0 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzbdd r0 = r8.zzebh
            r0.zzm(r9, r10)
        L_0x0044:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 != r2) goto L_0x00c1
            int r0 = r8.zzebf
            if (r0 <= 0) goto L_0x0052
            int r0 = r8.zzebf
            if (r0 != r9) goto L_0x005a
        L_0x0052:
            int r0 = r8.zzebg
            if (r0 <= 0) goto L_0x00bd
            int r0 = r8.zzebg
            if (r0 == r10) goto L_0x00bd
        L_0x005a:
            boolean r0 = r8.zzeax
            if (r0 == 0) goto L_0x00bd
            boolean r0 = r8.zzyv()
            if (r0 == 0) goto L_0x00bd
            com.google.android.gms.internal.ads.zzge r0 = r8.zzefe
            long r2 = r0.zzdn()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x00bd
            com.google.android.gms.internal.ads.zzge r0 = r8.zzefe
            boolean r0 = r0.zzdm()
            if (r0 != 0) goto L_0x00bd
            r0 = 1
            r8.zza((float) r1, (boolean) r0)
            com.google.android.gms.internal.ads.zzge r1 = r8.zzefe
            r1.zzd(r0)
            com.google.android.gms.internal.ads.zzge r0 = r8.zzefe
            long r0 = r0.zzdn()
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzk.zzln()
            long r2 = r2.currentTimeMillis()
        L_0x008f:
            boolean r4 = r8.zzyv()
            if (r4 == 0) goto L_0x00ae
            com.google.android.gms.internal.ads.zzge r4 = r8.zzefe
            long r4 = r4.zzdn()
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 != 0) goto L_0x00ae
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzk.zzln()
            long r4 = r4.currentTimeMillis()
            long r4 = r4 - r2
            r6 = 250(0xfa, double:1.235E-321)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x008f
        L_0x00ae:
            boolean r0 = r8.zzyv()
            if (r0 == 0) goto L_0x00ba
            com.google.android.gms.internal.ads.zzge r0 = r8.zzefe
            r1 = 0
            r0.zzd(r1)
        L_0x00ba:
            r8.zzxk()
        L_0x00bd:
            r8.zzebf = r9
            r8.zzebg = r10
        L_0x00c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdq.onMeasure(int, int):void");
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzebi) {
            this.zzebh = new zzbdd(getContext());
            this.zzebh.zza(surfaceTexture, i, i2);
            this.zzebh.start();
            SurfaceTexture zzxy = this.zzebh.zzxy();
            if (zzxy != null) {
                surfaceTexture = zzxy;
            } else {
                this.zzebh.zzxx();
                this.zzebh = null;
            }
        }
        this.zzaez = new Surface(surfaceTexture);
        if (this.zzefe == null) {
            zzyx();
        } else {
            zza(this.zzaez, true);
            if (!this.zzefp.zzeec) {
                zzyz();
            }
        }
        float f = 1.0f;
        if (!(this.zzebc == 0 || this.zzebd == 0)) {
            i = this.zzebc;
            i2 = this.zzebd;
            f = this.zzaft;
        }
        zzb(i, i2, f);
        zzaxi.zzdvv.post(new zzbeb(this));
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzebh != null) {
            this.zzebh.zzm(i, i2);
        }
        zzaxi.zzdvv.post(new zzbec(this, i, i2));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzawz.zzds("Surface destroyed");
        pause();
        if (this.zzebh != null) {
            this.zzebh.zzxx();
            this.zzebh = null;
        }
        if (this.zzefe != null) {
            zzza();
            if (this.zzaez != null) {
                this.zzaez.release();
            }
            this.zzaez = null;
            zza((Surface) null, true);
        }
        zzaxi.zzdvv.post(new zzbed(this));
        return true;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzeaw.zzc(this);
        this.zzebr.zza(surfaceTexture, this.zzebk);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView1 window visibility changed to ");
        sb.append(i);
        zzawz.zzds(sb.toString());
        zzaxi.zzdvv.post(new zzbdt(this, i));
        super.onWindowVisibilityChanged(i);
    }

    private final void zzyz() {
        if (this.zzefe != null) {
            this.zzefe.zzc(0, true);
        }
    }

    private final void zzza() {
        if (this.zzefe != null) {
            this.zzefe.zzc(0, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdd(int i) {
        if (this.zzebk != null) {
            this.zzebk.onWindowVisibilityChanged(i);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzzb() {
        if (this.zzebk != null) {
            this.zzebk.zzxo();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(int i, int i2) {
        if (this.zzebk != null) {
            this.zzebk.zzk(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzzc() {
        if (this.zzebk != null) {
            this.zzebk.zzxl();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzzd() {
        if (this.zzebk != null) {
            this.zzebk.onPaused();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzze() {
        if (this.zzebk != null) {
            this.zzebk.zzxm();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(String str, String str2) {
        if (this.zzebk != null) {
            this.zzebk.zzl(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzzf() {
        if (this.zzebk != null) {
            this.zzebk.zzxn();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzzg() {
        if (this.zzebk != null) {
            this.zzebk.zzhd();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(boolean z, long j) {
        this.zzebt.zza(z, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(boolean z, long j) {
        this.zzebt.zza(z, j);
    }
}
