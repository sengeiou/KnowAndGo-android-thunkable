package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzwt;
import java.util.ArrayList;

final /* synthetic */ class zzcjo implements zzczc {
    private final boolean zzecm;
    private final zzcjn zzfzc;
    private final ArrayList zzfzd;
    private final zzwt.zzg zzfze;
    private final zzwt.zzi.zzc zzfzf;

    zzcjo(zzcjn zzcjn, boolean z, ArrayList arrayList, zzwt.zzg zzg, zzwt.zzi.zzc zzc) {
        this.zzfzc = zzcjn;
        this.zzecm = z;
        this.zzfzd = arrayList;
        this.zzfze = zzg;
        this.zzfzf = zzc;
    }

    public final Object apply(Object obj) {
        zzcjn zzcjn = this.zzfzc;
        boolean z = this.zzecm;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        byte[] zza = zzcjn.zzfzb.zza(z, this.zzfzd, this.zzfze, this.zzfzf);
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzk.zzln().currentTimeMillis()));
        contentValues.put("serialized_proto_data", zza);
        sQLiteDatabase.insert("offline_signal_contents", (String) null, contentValues);
        sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET total = total+1 WHERE statistic_name = '%s'", new Object[]{"total_requests"}));
        if (!z) {
            sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET total = total+1 WHERE statistic_name = '%s'", new Object[]{"failed_requests"}));
        }
        return null;
    }
}
