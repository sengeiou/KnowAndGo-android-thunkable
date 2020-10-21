package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.zzk;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.apache.logging.log4j.message.ParameterizedMessage;

@TargetApi(16)
@zzard
public final class zzbek extends zzbco implements TextureView.SurfaceTextureListener, zzbfi {
    private Surface zzaez;
    private final zzbdg zzeaw;
    private final boolean zzeax;
    private int zzebc;
    private int zzebd;
    private int zzebf;
    private int zzebg;
    private zzbdd zzebh;
    private final boolean zzebi;
    private zzbcn zzebk;
    private final zzbdf zzebt;
    private String[] zzecg;
    private float zzefn;
    private final zzbde zzefp;
    private String zzefr;
    private boolean zzefs;
    private int zzeft = 1;
    private boolean zzefu;
    private boolean zzefv;
    private zzbfa zzegj;

    public zzbek(Context context, zzbdg zzbdg, zzbdf zzbdf, boolean z, boolean z2, zzbde zzbde) {
        super(context);
        this.zzeax = z2;
        this.zzebt = zzbdf;
        this.zzeaw = zzbdg;
        this.zzebi = z;
        this.zzefp = zzbde;
        setSurfaceTextureListener(this);
        this.zzeaw.zzb(this);
    }

    private final zzbfa zzzh() {
        return new zzbfa(this.zzebt.getContext(), this.zzefp);
    }

    private final String zzzi() {
        return zzk.zzlg().zzq(this.zzebt.getContext(), this.zzebt.zzyh().zzbsx);
    }

    private final boolean zzyv() {
        return this.zzegj != null && !this.zzefs;
    }

    private final boolean zzyw() {
        return zzyv() && this.zzeft != 1;
    }

    private final void zzzj() {
        if (this.zzegj == null && this.zzefr != null && this.zzaez != null) {
            if (this.zzefr.startsWith("cache:")) {
                zzbft zzet = this.zzebt.zzet(this.zzefr);
                if (zzet instanceof zzbgp) {
                    this.zzegj = ((zzbgp) zzet).zzaaa();
                } else if (zzet instanceof zzbgo) {
                    zzbgo zzbgo = (zzbgo) zzet;
                    String zzzi = zzzi();
                    ByteBuffer byteBuffer = zzbgo.getByteBuffer();
                    boolean zzzv = zzbgo.zzzv();
                    String url = zzbgo.getUrl();
                    if (url == null) {
                        zzawz.zzep("Stream cache URL is null.");
                        return;
                    } else {
                        this.zzegj = zzzh();
                        this.zzegj.zza(new Uri[]{Uri.parse(url)}, zzzi, byteBuffer, zzzv);
                    }
                } else {
                    String valueOf = String.valueOf(this.zzefr);
                    zzawz.zzep(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                    return;
                }
            } else {
                this.zzegj = zzzh();
                String zzzi2 = zzzi();
                Uri[] uriArr = new Uri[this.zzecg.length];
                for (int i = 0; i < this.zzecg.length; i++) {
                    uriArr[i] = Uri.parse(this.zzecg[i]);
                }
                this.zzegj.zza(uriArr, zzzi2);
            }
            this.zzegj.zza((zzbfi) this);
            zza(this.zzaez, false);
            this.zzeft = this.zzegj.zzzt().getPlaybackState();
            if (this.zzeft == 3) {
                zzyy();
            }
        }
    }

    private final void zza(Surface surface, boolean z) {
        if (this.zzegj != null) {
            this.zzegj.zza(surface, z);
        } else {
            zzawz.zzep("Trying to set surface before player is initalized.");
        }
    }

    private final void zza(float f, boolean z) {
        if (this.zzegj != null) {
            this.zzegj.zzb(f, z);
        } else {
            zzawz.zzep("Trying to set volume before player is initalized.");
        }
    }

    public final void zzxk() {
        zza(this.zzebs.getVolume(), false);
    }

    private final void zzyy() {
        if (!this.zzefu) {
            this.zzefu = true;
            zzaxi.zzdvv.post(new zzbel(this));
            zzxk();
            this.zzeaw.zzhd();
            if (this.zzefv) {
                play();
            }
        }
    }

    public final String zzxg() {
        String valueOf = String.valueOf("ExoPlayer/3");
        String valueOf2 = String.valueOf(this.zzebi ? " spherical" : "");
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final void zza(zzbcn zzbcn) {
        this.zzebk = zzbcn;
    }

    public final void setVideoPath(String str) {
        if (str != null) {
            this.zzefr = str;
            this.zzecg = new String[]{str};
            zzzj();
        }
    }

    public final void zzb(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                setVideoPath(str);
            }
            this.zzefr = str;
            this.zzecg = (String[]) Arrays.copyOf(strArr, strArr.length);
            zzzj();
        }
    }

    public final void play() {
        if (zzyw()) {
            if (this.zzefp.zzeec) {
                zzzl();
            }
            this.zzegj.zzzt().zzd(true);
            this.zzeaw.zzyl();
            this.zzebs.zzyl();
            this.zzebr.zzxm();
            zzaxi.zzdvv.post(new zzbeo(this));
            return;
        }
        this.zzefv = true;
    }

    public final void stop() {
        if (zzyv()) {
            this.zzegj.zzzt().stop();
            if (this.zzegj != null) {
                zza((Surface) null, true);
                if (this.zzegj != null) {
                    this.zzegj.zza((zzbfi) null);
                    this.zzegj.release();
                    this.zzegj = null;
                }
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
                zzzm();
            }
            this.zzegj.zzzt().zzd(false);
            this.zzeaw.zzym();
            this.zzebs.zzym();
            zzaxi.zzdvv.post(new zzbep(this));
        }
    }

    public final void seekTo(int i) {
        if (zzyw()) {
            this.zzegj.zzzt().seekTo((long) i);
        }
    }

    public final void zzcy(int i) {
        if (this.zzegj != null) {
            this.zzegj.zzzu().zzdg(i);
        }
    }

    public final void zzcz(int i) {
        if (this.zzegj != null) {
            this.zzegj.zzzu().zzdh(i);
        }
    }

    public final void zzda(int i) {
        if (this.zzegj != null) {
            this.zzegj.zzzu().zzda(i);
        }
    }

    public final void zzdb(int i) {
        if (this.zzegj != null) {
            this.zzegj.zzzu().zzdb(i);
        }
    }

    public final void zzdc(int i) {
        if (this.zzegj != null) {
            this.zzegj.zzdc(i);
        }
    }

    public final void zza(float f, float f2) {
        if (this.zzebh != null) {
            this.zzebh.zzb(f, f2);
        }
    }

    public final int getCurrentPosition() {
        if (zzyw()) {
            return (int) this.zzegj.zzzt().zzdn();
        }
        return 0;
    }

    public final int getDuration() {
        if (zzyw()) {
            return (int) this.zzegj.zzzt().getDuration();
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
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0086 A[LOOP:0: B:32:0x0086->B:37:0x00a1, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r10, int r11) {
        /*
            r9 = this;
            super.onMeasure(r10, r11)
            int r10 = r9.getMeasuredWidth()
            int r11 = r9.getMeasuredHeight()
            float r0 = r9.zzefn
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0030
            com.google.android.gms.internal.ads.zzbdd r0 = r9.zzebh
            if (r0 != 0) goto L_0x0030
            float r0 = (float) r10
            float r2 = (float) r11
            float r2 = r0 / r2
            float r3 = r9.zzefn
            int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0024
            float r11 = r9.zzefn
            float r0 = r0 / r11
            int r11 = (int) r0
        L_0x0024:
            float r0 = r9.zzefn
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0030
            float r10 = (float) r11
            float r0 = r9.zzefn
            float r10 = r10 * r0
            int r10 = (int) r10
        L_0x0030:
            r9.setMeasuredDimension(r10, r11)
            com.google.android.gms.internal.ads.zzbdd r0 = r9.zzebh
            if (r0 == 0) goto L_0x003c
            com.google.android.gms.internal.ads.zzbdd r0 = r9.zzebh
            r0.zzm(r10, r11)
        L_0x003c:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 != r2) goto L_0x00ae
            int r0 = r9.zzebf
            if (r0 <= 0) goto L_0x004a
            int r0 = r9.zzebf
            if (r0 != r10) goto L_0x0052
        L_0x004a:
            int r0 = r9.zzebg
            if (r0 <= 0) goto L_0x00aa
            int r0 = r9.zzebg
            if (r0 == r11) goto L_0x00aa
        L_0x0052:
            boolean r0 = r9.zzeax
            if (r0 == 0) goto L_0x00aa
            boolean r0 = r9.zzyv()
            if (r0 == 0) goto L_0x00aa
            com.google.android.gms.internal.ads.zzbfa r0 = r9.zzegj
            com.google.android.gms.internal.ads.zzkv r0 = r0.zzzt()
            long r2 = r0.zzdn()
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x00aa
            boolean r2 = r0.zzdm()
            if (r2 == 0) goto L_0x0073
            goto L_0x00aa
        L_0x0073:
            r2 = 1
            r9.zza((float) r1, (boolean) r2)
            r0.zzd(r2)
            long r1 = r0.zzdn()
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzk.zzln()
            long r3 = r3.currentTimeMillis()
        L_0x0086:
            boolean r5 = r9.zzyv()
            if (r5 == 0) goto L_0x00a3
            long r5 = r0.zzdn()
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x00a3
            com.google.android.gms.common.util.Clock r5 = com.google.android.gms.ads.internal.zzk.zzln()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            r7 = 250(0xfa, double:1.235E-321)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0086
        L_0x00a3:
            r1 = 0
            r0.zzd(r1)
            r9.zzxk()
        L_0x00aa:
            r9.zzebf = r10
            r9.zzebg = r11
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbek.onMeasure(int, int):void");
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
        if (this.zzegj == null) {
            zzzj();
        } else {
            zza(this.zzaez, true);
            if (!this.zzefp.zzeec) {
                zzzl();
            }
        }
        if (this.zzebc == 0 || this.zzebd == 0) {
            zzp(i, i2);
        } else {
            zzzk();
        }
        zzaxi.zzdvv.post(new zzbeq(this));
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzebh != null) {
            this.zzebh.zzm(i, i2);
        }
        zzaxi.zzdvv.post(new zzber(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzeaw.zzc(this);
        this.zzebr.zza(surfaceTexture, this.zzebk);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        if (this.zzebh != null) {
            this.zzebh.zzxx();
            this.zzebh = null;
        }
        if (this.zzegj != null) {
            zzzm();
            if (this.zzaez != null) {
                this.zzaez.release();
            }
            this.zzaez = null;
            zza((Surface) null, true);
        }
        zzaxi.zzdvv.post(new zzbes(this));
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zzawz.zzds(sb.toString());
        zzaxi.zzdvv.post(new zzbet(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void zzd(boolean z, long j) {
        if (this.zzebt != null) {
            zzbbm.zzeae.execute(new zzbeu(this, z, j));
        }
    }

    public final void zzde(int i) {
        if (this.zzeft != i) {
            this.zzeft = i;
            switch (i) {
                case 3:
                    zzyy();
                    return;
                case 4:
                    if (this.zzefp.zzeec) {
                        zzzm();
                    }
                    this.zzeaw.zzym();
                    this.zzebs.zzym();
                    zzaxi.zzdvv.post(new zzbem(this));
                    return;
                default:
                    return;
            }
        }
    }

    public final void zzo(int i, int i2) {
        this.zzebc = i;
        this.zzebd = i2;
        zzzk();
    }

    public final void zza(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(message);
        String sb2 = sb.toString();
        String valueOf = String.valueOf(sb2);
        zzawz.zzep(valueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(valueOf) : new String("ExoPlayerAdapter error: "));
        this.zzefs = true;
        if (this.zzefp.zzeec) {
            zzzm();
        }
        zzaxi.zzdvv.post(new zzben(this, sb2));
    }

    private final void zzzk() {
        zzp(this.zzebc, this.zzebd);
    }

    private final void zzp(int i, int i2) {
        float f = i2 > 0 ? ((float) i) / ((float) i2) : 1.0f;
        if (this.zzefn != f) {
            this.zzefn = f;
            requestLayout();
        }
    }

    private final void zzzl() {
        if (this.zzegj != null) {
            this.zzegj.zzap(true);
        }
    }

    private final void zzzm() {
        if (this.zzegj != null) {
            this.zzegj.zzap(false);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(boolean z, long j) {
        this.zzebt.zza(z, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdf(int i) {
        if (this.zzebk != null) {
            this.zzebk.onWindowVisibilityChanged(i);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzzn() {
        if (this.zzebk != null) {
            this.zzebk.zzxo();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(int i, int i2) {
        if (this.zzebk != null) {
            this.zzebk.zzk(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzzo() {
        if (this.zzebk != null) {
            this.zzebk.zzxl();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzzp() {
        if (this.zzebk != null) {
            this.zzebk.onPaused();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzzq() {
        if (this.zzebk != null) {
            this.zzebk.zzxm();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzeu(String str) {
        if (this.zzebk != null) {
            this.zzebk.zzl("ExoPlayerAdapter error", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzzr() {
        if (this.zzebk != null) {
            this.zzebk.zzxn();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzzs() {
        if (this.zzebk != null) {
            this.zzebk.zzhd();
        }
    }
}
