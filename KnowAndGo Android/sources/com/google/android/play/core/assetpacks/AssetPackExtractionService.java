package com.google.android.play.core.assetpacks;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.play.core.internal.C1982af;
import com.onesignal.OneSignalDbContract;

public class AssetPackExtractionService extends Service {

    /* renamed from: a */
    Context f294a;

    /* renamed from: b */
    C1952j f295b;

    /* renamed from: c */
    C1870bb f296c;

    /* renamed from: d */
    private final C1982af f297d = new C1982af("AssetPackExtractionService");

    /* renamed from: e */
    private C1868b f298e;

    /* renamed from: f */
    private NotificationManager f299f;

    /* renamed from: b */
    private final synchronized void m255b(Bundle bundle) {
        String string = bundle.getString("notification_title");
        String string2 = bundle.getString("notification_subtext");
        long j = bundle.getLong("notification_timeout");
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("notification_on_click_intent");
        Notification.Builder timeoutAfter = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(this.f294a, "playcore-assetpacks-service-notification-channel").setTimeoutAfter(j) : new Notification.Builder(this.f294a).setPriority(-2);
        if (pendingIntent != null) {
            timeoutAfter.setContentIntent(pendingIntent);
        }
        timeoutAfter.setSmallIcon(17301633).setOngoing(false).setContentTitle(string).setSubText(string2);
        if (Build.VERSION.SDK_INT >= 21) {
            timeoutAfter.setColor(bundle.getInt("notification_color")).setVisibility(-1);
        }
        Notification build = timeoutAfter.build();
        this.f297d.mo33553c("Starting foreground service.", new Object[0]);
        this.f295b.mo33522a(true);
        if (Build.VERSION.SDK_INT >= 26) {
            this.f299f.createNotificationChannel(new NotificationChannel("playcore-assetpacks-service-notification-channel", bundle.getString("notification_channel_name"), 2));
        }
        startForeground(-1883842196, build);
    }

    /* renamed from: a */
    public final synchronized Bundle mo33310a(Bundle bundle) {
        int i = bundle.getInt("action_type");
        C1982af afVar = this.f297d;
        Integer valueOf = Integer.valueOf(i);
        afVar.mo33550a("updateServiceState: %d", valueOf);
        if (i == 1) {
            m255b(bundle);
        } else if (i == 2) {
            mo33311a();
        } else {
            this.f297d.mo33552b("Unknown action type received: %d", valueOf);
        }
        return new Bundle();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo33311a() {
        this.f297d.mo33553c("Stopping service.", new Object[0]);
        this.f295b.mo33522a(false);
        stopForeground(true);
        stopSelf();
    }

    public final IBinder onBind(Intent intent) {
        return this.f298e;
    }

    public final void onCreate() {
        super.onCreate();
        this.f297d.mo33550a("onCreate", new Object[0]);
        C1924db.m468a(getApplicationContext()).mo33339a(this);
        this.f298e = new C1868b(this.f294a, this, this.f296c);
        this.f299f = (NotificationManager) this.f294a.getSystemService(OneSignalDbContract.NotificationTable.TABLE_NAME);
    }
}
