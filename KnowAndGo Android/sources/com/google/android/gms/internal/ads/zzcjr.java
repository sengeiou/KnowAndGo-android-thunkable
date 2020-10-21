package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzwl;
import com.google.android.gms.internal.ads.zzwt;

public final class zzcjr {
    private zzbai zzdld;
    private zzcjc zzfyx;
    private zzwj zzfzh;
    private Context zzlj;

    public zzcjr(Context context, zzbai zzbai, zzwj zzwj, zzcjc zzcjc) {
        this.zzlj = context;
        this.zzdld = zzbai;
        this.zzfzh = zzwj;
        this.zzfyx = zzcjc;
    }

    public final void zzakp() {
        try {
            this.zzfyx.zza(new zzcjs(this));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzawz.zzen(valueOf.length() != 0 ? "Error in offline signals database startup: ".concat(valueOf) : new String("Error in offline signals database startup: "));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzb(SQLiteDatabase sQLiteDatabase) throws Exception {
        int i = 2;
        this.zzfzh.zza((zzwk) new zzcjt((zzwt.zzi) ((zzdob) zzwt.zzi.zzny().zzbq(this.zzlj.getPackageName()).zzbr(Build.MODEL).zzch(zzcjq.zza(sQLiteDatabase, 1)).zzd(zzcjq.zza(sQLiteDatabase)).zzci(zzcjq.zza(sQLiteDatabase, 2)).zzez(zzk.zzln().currentTimeMillis()).zzaya())));
        zzxo zzxo = new zzxo();
        zzxo.zzcfo = Integer.valueOf(this.zzdld.zzdzc);
        zzxo.zzcfp = Integer.valueOf(this.zzdld.zzdzd);
        if (this.zzdld.zzdze) {
            i = 0;
        }
        zzxo.zzcfq = Integer.valueOf(i);
        this.zzfzh.zza((zzwk) new zzcju(zzxo));
        this.zzfzh.zza(zzwl.zza.zzb.OFFLINE_UPLOAD);
        sQLiteDatabase.delete("offline_signal_contents", (String) null, (String[]) null);
        ContentValues contentValues = new ContentValues();
        contentValues.put("total", 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = ?", new String[]{"failed_requests"});
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("total", 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues2, "statistic_name = ?", new String[]{"total_requests"});
        return null;
    }
}
