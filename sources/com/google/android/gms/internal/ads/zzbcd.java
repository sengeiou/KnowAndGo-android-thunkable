package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.zzk;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.message.ParameterizedMessage;

@TargetApi(14)
@zzard
public final class zzbcd extends zzbco implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzeav = new HashMap();
    private final zzbdg zzeaw;
    private final boolean zzeax;
    private int zzeay = 0;
    private int zzeaz = 0;
    private MediaPlayer zzeba;
    private Uri zzebb;
    private int zzebc;
    private int zzebd;
    private int zzebe;
    private int zzebf;
    private int zzebg;
    private zzbdd zzebh;
    private boolean zzebi;
    private int zzebj;
    /* access modifiers changed from: private */
    public zzbcn zzebk;

    public zzbcd(Context context, boolean z, boolean z2, zzbde zzbde, zzbdg zzbdg) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzeaw = zzbdg;
        this.zzebi = z;
        this.zzeax = z2;
        this.zzeaw.zzb(this);
    }

    public final String zzxg() {
        String valueOf = String.valueOf(this.zzebi ? " spherical" : "");
        return valueOf.length() != 0 ? "MediaPlayer".concat(valueOf) : new String("MediaPlayer");
    }

    public final void zza(zzbcn zzbcn) {
        this.zzebk = zzbcn;
    }

    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzvv zze = zzvv.zze(parse);
        if (zze == null || zze.url != null) {
            if (zze != null) {
                parse = Uri.parse(zze.url);
            }
            this.zzebb = parse;
            this.zzebj = 0;
            zzxh();
            requestLayout();
            invalidate();
        }
    }

    public final void stop() {
        zzawz.zzds("AdMediaPlayerView stop");
        if (this.zzeba != null) {
            this.zzeba.stop();
            this.zzeba.release();
            this.zzeba = null;
            zzcw(0);
            this.zzeaz = 0;
        }
        this.zzeaw.onStop();
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzawz.zzds(sb.toString());
        this.zzebc = mediaPlayer.getVideoWidth();
        this.zzebd = mediaPlayer.getVideoHeight();
        if (this.zzebc != 0 && this.zzebd != 0) {
            requestLayout();
        }
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzawz.zzds("AdMediaPlayerView prepared");
        zzcw(2);
        this.zzeaw.zzhd();
        zzaxi.zzdvv.post(new zzbcf(this));
        this.zzebc = mediaPlayer.getVideoWidth();
        this.zzebd = mediaPlayer.getVideoHeight();
        if (this.zzebj != 0) {
            seekTo(this.zzebj);
        }
        zzxi();
        int i = this.zzebc;
        int i2 = this.zzebd;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzawz.zzeo(sb.toString());
        if (this.zzeaz == 3) {
            play();
        }
        zzxk();
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzawz.zzds("AdMediaPlayerView completion");
        zzcw(5);
        this.zzeaz = 5;
        zzaxi.zzdvv.post(new zzbcg(this));
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzeav.get(Integer.valueOf(i));
        String str2 = zzeav.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(str2);
        zzawz.zzds(sb.toString());
        return true;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzeav.get(Integer.valueOf(i));
        String str2 = zzeav.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(str2);
        zzawz.zzep(sb.toString());
        zzcw(-1);
        this.zzeaz = -1;
        zzaxi.zzdvv.post(new zzbch(this, str, str2));
        return true;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzebe = i;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzawz.zzds("AdMediaPlayerView surface created");
        zzxh();
        zzaxi.zzdvv.post(new zzbci(this));
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzawz.zzds("AdMediaPlayerView surface changed");
        boolean z = false;
        boolean z2 = this.zzeaz == 3;
        if (this.zzebc == i && this.zzebd == i2) {
            z = true;
        }
        if (this.zzeba != null && z2 && z) {
            if (this.zzebj != 0) {
                seekTo(this.zzebj);
            }
            play();
        }
        if (this.zzebh != null) {
            this.zzebh.zzm(i, i2);
        }
        zzaxi.zzdvv.post(new zzbcj(this, i, i2));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzawz.zzds("AdMediaPlayerView surface destroyed");
        if (this.zzeba != null && this.zzebj == 0) {
            this.zzebj = this.zzeba.getCurrentPosition();
        }
        if (this.zzebh != null) {
            this.zzebh.zzxx();
        }
        zzaxi.zzdvv.post(new zzbck(this));
        zzam(true);
        return true;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzeaw.zzc(this);
        this.zzebr.zza(surfaceTexture, this.zzebk);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zzawz.zzds(sb.toString());
        zzaxi.zzdvv.post(new zzbce(this, i));
        super.onWindowVisibilityChanged(i);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0072, code lost:
        if (r1 > r6) goto L_0x0098;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.zzebc
            int r0 = getDefaultSize(r0, r6)
            int r1 = r5.zzebd
            int r1 = getDefaultSize(r1, r7)
            int r2 = r5.zzebc
            if (r2 <= 0) goto L_0x0096
            int r2 = r5.zzebd
            if (r2 <= 0) goto L_0x0096
            com.google.android.gms.internal.ads.zzbdd r2 = r5.zzebh
            if (r2 != 0) goto L_0x0096
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L_0x0055
            if (r1 != r2) goto L_0x0055
            int r0 = r5.zzebc
            int r0 = r0 * r7
            int r1 = r5.zzebd
            int r1 = r1 * r6
            if (r0 >= r1) goto L_0x0042
            int r6 = r5.zzebc
            int r6 = r6 * r7
            int r0 = r5.zzebd
            int r0 = r6 / r0
            r6 = r0
            goto L_0x0098
        L_0x0042:
            int r0 = r5.zzebc
            int r0 = r0 * r7
            int r1 = r5.zzebd
            int r1 = r1 * r6
            if (r0 <= r1) goto L_0x0098
            int r7 = r5.zzebd
            int r7 = r7 * r6
            int r0 = r5.zzebc
            int r1 = r7 / r0
            goto L_0x0097
        L_0x0055:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L_0x0067
            int r0 = r5.zzebd
            int r0 = r0 * r6
            int r2 = r5.zzebc
            int r0 = r0 / r2
            if (r1 != r3) goto L_0x0065
            if (r0 <= r7) goto L_0x0065
            goto L_0x0098
        L_0x0065:
            r7 = r0
            goto L_0x0098
        L_0x0067:
            if (r1 != r2) goto L_0x0077
            int r1 = r5.zzebc
            int r1 = r1 * r7
            int r2 = r5.zzebd
            int r1 = r1 / r2
            if (r0 != r3) goto L_0x0075
            if (r1 <= r6) goto L_0x0075
            goto L_0x0098
        L_0x0075:
            r6 = r1
            goto L_0x0098
        L_0x0077:
            int r2 = r5.zzebc
            int r4 = r5.zzebd
            if (r1 != r3) goto L_0x0087
            if (r4 <= r7) goto L_0x0087
            int r1 = r5.zzebc
            int r1 = r1 * r7
            int r2 = r5.zzebd
            int r1 = r1 / r2
            goto L_0x0089
        L_0x0087:
            r1 = r2
            r7 = r4
        L_0x0089:
            if (r0 != r3) goto L_0x0075
            if (r1 <= r6) goto L_0x0075
            int r7 = r5.zzebd
            int r7 = r7 * r6
            int r0 = r5.zzebc
            int r1 = r7 / r0
            goto L_0x0097
        L_0x0096:
            r6 = r0
        L_0x0097:
            r7 = r1
        L_0x0098:
            r5.setMeasuredDimension(r6, r7)
            com.google.android.gms.internal.ads.zzbdd r0 = r5.zzebh
            if (r0 == 0) goto L_0x00a4
            com.google.android.gms.internal.ads.zzbdd r0 = r5.zzebh
            r0.zzm(r6, r7)
        L_0x00a4:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 16
            if (r0 != r1) goto L_0x00c1
            int r0 = r5.zzebf
            if (r0 <= 0) goto L_0x00b2
            int r0 = r5.zzebf
            if (r0 != r6) goto L_0x00ba
        L_0x00b2:
            int r0 = r5.zzebg
            if (r0 <= 0) goto L_0x00bd
            int r0 = r5.zzebg
            if (r0 == r7) goto L_0x00bd
        L_0x00ba:
            r5.zzxi()
        L_0x00bd:
            r5.zzebf = r6
            r5.zzebg = r7
        L_0x00c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcd.onMeasure(int, int):void");
    }

    public final String toString() {
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    private final void zzxh() {
        zzawz.zzds("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzebb != null && surfaceTexture != null) {
            zzam(false);
            try {
                zzk.zzlw();
                this.zzeba = new MediaPlayer();
                this.zzeba.setOnBufferingUpdateListener(this);
                this.zzeba.setOnCompletionListener(this);
                this.zzeba.setOnErrorListener(this);
                this.zzeba.setOnInfoListener(this);
                this.zzeba.setOnPreparedListener(this);
                this.zzeba.setOnVideoSizeChangedListener(this);
                this.zzebe = 0;
                if (this.zzebi) {
                    this.zzebh = new zzbdd(getContext());
                    this.zzebh.zza(surfaceTexture, getWidth(), getHeight());
                    this.zzebh.start();
                    SurfaceTexture zzxy = this.zzebh.zzxy();
                    if (zzxy != null) {
                        surfaceTexture = zzxy;
                    } else {
                        this.zzebh.zzxx();
                        this.zzebh = null;
                    }
                }
                this.zzeba.setDataSource(getContext(), this.zzebb);
                zzk.zzlx();
                this.zzeba.setSurface(new Surface(surfaceTexture));
                this.zzeba.setAudioStreamType(3);
                this.zzeba.setScreenOnWhilePlaying(true);
                this.zzeba.prepareAsync();
                zzcw(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                String valueOf = String.valueOf(this.zzebb);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
                sb.append("Failed to initialize MediaPlayer at ");
                sb.append(valueOf);
                zzawz.zzd(sb.toString(), e);
                onError(this.zzeba, 1, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034 A[LOOP:0: B:10:0x0034->B:15:0x004f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzxi() {
        /*
            r7 = this;
            boolean r0 = r7.zzeax
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r7.zzxj()
            if (r0 == 0) goto L_0x0059
            android.media.MediaPlayer r0 = r7.zzeba
            int r0 = r0.getCurrentPosition()
            if (r0 <= 0) goto L_0x0059
            int r0 = r7.zzeaz
            r1 = 3
            if (r0 == r1) goto L_0x0059
            java.lang.String r0 = "AdMediaPlayerView nudging MediaPlayer"
            com.google.android.gms.internal.ads.zzawz.zzds(r0)
            r0 = 0
            r7.zzd(r0)
            android.media.MediaPlayer r0 = r7.zzeba
            r0.start()
            android.media.MediaPlayer r0 = r7.zzeba
            int r0 = r0.getCurrentPosition()
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzk.zzln()
            long r1 = r1.currentTimeMillis()
        L_0x0034:
            boolean r3 = r7.zzxj()
            if (r3 == 0) goto L_0x0051
            android.media.MediaPlayer r3 = r7.zzeba
            int r3 = r3.getCurrentPosition()
            if (r3 != r0) goto L_0x0051
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzk.zzln()
            long r3 = r3.currentTimeMillis()
            long r3 = r3 - r1
            r5 = 250(0xfa, double:1.235E-321)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x0034
        L_0x0051:
            android.media.MediaPlayer r0 = r7.zzeba
            r0.pause()
            r7.zzxk()
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcd.zzxi():void");
    }

    private final void zzam(boolean z) {
        zzawz.zzds("AdMediaPlayerView release");
        if (this.zzebh != null) {
            this.zzebh.zzxx();
            this.zzebh = null;
        }
        if (this.zzeba != null) {
            this.zzeba.reset();
            this.zzeba.release();
            this.zzeba = null;
            zzcw(0);
            if (z) {
                this.zzeaz = 0;
                this.zzeaz = 0;
            }
        }
    }

    public final void play() {
        zzawz.zzds("AdMediaPlayerView play");
        if (zzxj()) {
            this.zzeba.start();
            zzcw(3);
            this.zzebr.zzxm();
            zzaxi.zzdvv.post(new zzbcl(this));
        }
        this.zzeaz = 3;
    }

    public final void pause() {
        zzawz.zzds("AdMediaPlayerView pause");
        if (zzxj() && this.zzeba.isPlaying()) {
            this.zzeba.pause();
            zzcw(4);
            zzaxi.zzdvv.post(new zzbcm(this));
        }
        this.zzeaz = 4;
    }

    public final int getDuration() {
        if (zzxj()) {
            return this.zzeba.getDuration();
        }
        return -1;
    }

    public final int getCurrentPosition() {
        if (zzxj()) {
            return this.zzeba.getCurrentPosition();
        }
        return 0;
    }

    public final void seekTo(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zzawz.zzds(sb.toString());
        if (zzxj()) {
            this.zzeba.seekTo(i);
            this.zzebj = 0;
            return;
        }
        this.zzebj = i;
    }

    private final boolean zzxj() {
        return (this.zzeba == null || this.zzeay == -1 || this.zzeay == 0 || this.zzeay == 1) ? false : true;
    }

    public final void zza(float f, float f2) {
        if (this.zzebh != null) {
            this.zzebh.zzb(f, f2);
        }
    }

    public final int getVideoWidth() {
        if (this.zzeba != null) {
            return this.zzeba.getVideoWidth();
        }
        return 0;
    }

    public final int getVideoHeight() {
        if (this.zzeba != null) {
            return this.zzeba.getVideoHeight();
        }
        return 0;
    }

    public final void zzxk() {
        zzd(this.zzebs.getVolume());
    }

    private final void zzd(float f) {
        if (this.zzeba != null) {
            try {
                this.zzeba.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        } else {
            zzawz.zzep("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private final void zzcw(int i) {
        if (i == 3) {
            this.zzeaw.zzyl();
            this.zzebs.zzyl();
        } else if (this.zzeay == 3) {
            this.zzeaw.zzym();
            this.zzebs.zzym();
        }
        this.zzeay = i;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzcx(int i) {
        if (this.zzebk != null) {
            this.zzebk.onWindowVisibilityChanged(i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            zzeav.put(-1004, "MEDIA_ERROR_IO");
            zzeav.put(-1007, "MEDIA_ERROR_MALFORMED");
            zzeav.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            zzeav.put(-110, "MEDIA_ERROR_TIMED_OUT");
            zzeav.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        zzeav.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzeav.put(1, "MEDIA_ERROR_UNKNOWN");
        zzeav.put(1, "MEDIA_INFO_UNKNOWN");
        zzeav.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzeav.put(701, "MEDIA_INFO_BUFFERING_START");
        zzeav.put(702, "MEDIA_INFO_BUFFERING_END");
        zzeav.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzeav.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzeav.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT >= 19) {
            zzeav.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            zzeav.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }
}
