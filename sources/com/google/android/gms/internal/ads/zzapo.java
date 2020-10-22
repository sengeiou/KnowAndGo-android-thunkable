package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.exoplayer2.C1470C;
import com.google.android.gms.ads.impl.C1603R;
import com.google.android.gms.ads.internal.zzk;
import com.onesignal.OneSignalDbContract;
import java.util.Map;
import p024io.nlopez.smartlocation.geofencing.providers.GeofencingGooglePlayServicesProvider;

@zzard
public final class zzapo extends zzaqb {
    private final Map<String, String> zzcxs;
    private String zzdhr = zzdf("description");
    private long zzdhs = zzdg("start_ticks");
    private long zzdht = zzdg("end_ticks");
    private String zzdhu = zzdf("summary");
    private String zzdhv = zzdf(GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID);
    /* access modifiers changed from: private */
    public final Context zzlj;

    public zzapo(zzbgz zzbgz, Map<String, String> map) {
        super(zzbgz, "createCalendarEvent");
        this.zzcxs = map;
        this.zzlj = zzbgz.zzyd();
    }

    private final String zzdf(String str) {
        return TextUtils.isEmpty(this.zzcxs.get(str)) ? "" : this.zzcxs.get(str);
    }

    private final long zzdg(String str) {
        String str2 = this.zzcxs.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final void execute() {
        if (this.zzlj == null) {
            zzdh("Activity context is not available.");
            return;
        }
        zzk.zzlg();
        if (!zzaxi.zzao(this.zzlj).zzql()) {
            zzdh("This feature is not available on the device.");
            return;
        }
        zzk.zzlg();
        AlertDialog.Builder zzan = zzaxi.zzan(this.zzlj);
        Resources resources = zzk.zzlk().getResources();
        zzan.setTitle(resources != null ? resources.getString(C1603R.string.f171s5) : "Create calendar event");
        zzan.setMessage(resources != null ? resources.getString(C1603R.string.f172s6) : "Allow Ad to create a calendar event?");
        zzan.setPositiveButton(resources != null ? resources.getString(C1603R.string.f169s3) : "Accept", new zzapp(this));
        zzan.setNegativeButton(resources != null ? resources.getString(C1603R.string.f170s4) : "Decline", new zzapq(this));
        zzan.create().show();
    }

    /* access modifiers changed from: package-private */
    @TargetApi(14)
    public final Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra(OneSignalDbContract.NotificationTable.COLUMN_NAME_TITLE, this.zzdhr);
        data.putExtra("eventLocation", this.zzdhv);
        data.putExtra("description", this.zzdhu);
        if (this.zzdhs > -1) {
            data.putExtra("beginTime", this.zzdhs);
        }
        if (this.zzdht > -1) {
            data.putExtra("endTime", this.zzdht);
        }
        data.setFlags(C1470C.ENCODING_PCM_MU_LAW);
        return data;
    }
}
