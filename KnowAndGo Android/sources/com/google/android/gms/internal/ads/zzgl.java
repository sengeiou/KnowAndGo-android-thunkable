package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@TargetApi(16)
@Deprecated
public final class zzgl implements zzhn {
    private final Uri uri;
    private final Map<String, String> zzab;
    private final FileDescriptor zzacn;
    private final long zzaco;
    private final long zzacp;
    private MediaExtractor zzacq;
    private zzho[] zzacr;
    private boolean zzacs;
    private int zzact;
    private int[] zzacu;
    private boolean[] zzacv;
    private long zzacw;
    private final Context zzlj;

    public zzgl(Context context, Uri uri2, Map<String, String> map, int i) {
        zzkh.checkState(zzkq.SDK_INT >= 16);
        this.zzact = 2;
        this.zzlj = (Context) zzkh.checkNotNull(context);
        this.uri = (Uri) zzkh.checkNotNull(uri2);
        this.zzab = null;
        this.zzacn = null;
        this.zzaco = 0;
        this.zzacp = 0;
    }

    public final boolean zzdh(long j) {
        return true;
    }

    public final boolean zzdg(long j) throws IOException {
        if (!this.zzacs) {
            this.zzacq = new MediaExtractor();
            if (this.zzlj != null) {
                this.zzacq.setDataSource(this.zzlj, this.uri, (Map) null);
            } else {
                this.zzacq.setDataSource((FileDescriptor) null, 0, 0);
            }
            this.zzacu = new int[this.zzacq.getTrackCount()];
            this.zzacv = new boolean[this.zzacu.length];
            this.zzacr = new zzho[this.zzacu.length];
            for (int i = 0; i < this.zzacu.length; i++) {
                MediaFormat trackFormat = this.zzacq.getTrackFormat(i);
                this.zzacr[i] = new zzho(trackFormat.getString("mime"), trackFormat.containsKey("durationUs") ? trackFormat.getLong("durationUs") : -1);
            }
            this.zzacs = true;
        }
        return true;
    }

    public final int getTrackCount() {
        zzkh.checkState(this.zzacs);
        return this.zzacu.length;
    }

    public final zzho zzo(int i) {
        zzkh.checkState(this.zzacs);
        return this.zzacr[i];
    }

    public final void zza(int i, long j) {
        zzkh.checkState(this.zzacs);
        boolean z = false;
        zzkh.checkState(this.zzacu[i] == 0);
        this.zzacu[i] = 1;
        this.zzacq.selectTrack(i);
        if (j != 0) {
            z = true;
        }
        zza(j, z);
    }

    public final int zza(int i, long j, zzhk zzhk, zzhm zzhm, boolean z) {
        Map<UUID, byte[]> psshInfo;
        zzkh.checkState(this.zzacs);
        zzkh.checkState(this.zzacu[i] != 0);
        if (this.zzacv[i]) {
            this.zzacv[i] = false;
            return -5;
        } else if (z) {
            return -2;
        } else {
            if (this.zzacu[i] != 2) {
                zzhk.zzado = zzhj.zza(this.zzacq.getTrackFormat(i));
                zzhx zzhx = null;
                if (zzkq.SDK_INT >= 18 && (psshInfo = this.zzacq.getPsshInfo()) != null && !psshInfo.isEmpty()) {
                    zzhx = new zzhx(MimeTypes.VIDEO_MP4);
                    zzhx.putAll(psshInfo);
                }
                zzhk.zzadp = zzhx;
                this.zzacu[i] = 2;
                return -4;
            }
            int sampleTrackIndex = this.zzacq.getSampleTrackIndex();
            if (sampleTrackIndex == i) {
                if (zzhm.zzde != null) {
                    int position = zzhm.zzde.position();
                    zzhm.size = this.zzacq.readSampleData(zzhm.zzde, position);
                    zzhm.zzde.position(position + zzhm.size);
                } else {
                    zzhm.size = 0;
                }
                zzhm.zzaga = this.zzacq.getSampleTime();
                zzhm.flags = this.zzacq.getSampleFlags() & 3;
                if (zzhm.zzeo()) {
                    zzhm.zzafz.zza(this.zzacq);
                }
                this.zzacw = -1;
                this.zzacq.advance();
                return -3;
            } else if (sampleTrackIndex < 0) {
                return -1;
            } else {
                return -2;
            }
        }
    }

    public final void zzp(int i) {
        zzkh.checkState(this.zzacs);
        zzkh.checkState(this.zzacu[i] != 0);
        this.zzacq.unselectTrack(i);
        this.zzacv[i] = false;
        this.zzacu[i] = 0;
    }

    public final void zzdi(long j) {
        zzkh.checkState(this.zzacs);
        zza(j, false);
    }

    public final long zzdu() {
        zzkh.checkState(this.zzacs);
        long cachedDuration = this.zzacq.getCachedDuration();
        if (cachedDuration == -1) {
            return -1;
        }
        long sampleTime = this.zzacq.getSampleTime();
        if (sampleTime == -1) {
            return -3;
        }
        return sampleTime + cachedDuration;
    }

    public final void release() {
        zzkh.checkState(this.zzact > 0);
        int i = this.zzact - 1;
        this.zzact = i;
        if (i == 0 && this.zzacq != null) {
            this.zzacq.release();
            this.zzacq = null;
        }
    }

    private final void zza(long j, boolean z) {
        if (z || this.zzacw != j) {
            this.zzacw = j;
            this.zzacq.seekTo(j, 0);
            for (int i = 0; i < this.zzacu.length; i++) {
                if (this.zzacu[i] != 0) {
                    this.zzacv[i] = true;
                }
            }
        }
    }
}
