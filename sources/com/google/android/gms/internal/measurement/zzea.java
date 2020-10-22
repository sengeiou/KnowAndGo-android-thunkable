package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzcx;
import com.google.android.gms.measurement.internal.zzcy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class zzea {
    private static volatile zzea zzadk;
    /* access modifiers changed from: private */
    public final String zzadh;
    private final ExecutorService zzadl;
    private final AppMeasurementSdk zzadm;
    /* access modifiers changed from: private */
    public Map<zzcy, zzd> zzadn;
    private int zzado;
    /* access modifiers changed from: private */
    public boolean zzadp;
    private String zzadq;
    /* access modifiers changed from: private */
    public zzdn zzadr;
    protected final Clock zzrz;

    class zze implements Application.ActivityLifecycleCallbacks {
        zze() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzea.this.zza((zzb) new zzex(this, activity, bundle));
        }

        public final void onActivityStarted(Activity activity) {
            zzea.this.zza((zzb) new zzey(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            zzea.this.zza((zzb) new zzez(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            zzea.this.zza((zzb) new zzfa(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            zzea.this.zza((zzb) new zzfb(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zza zza = new zza();
            zzea.this.zza((zzb) new zzfc(this, activity, zza));
            Bundle zzl = zza.zzl(50);
            if (zzl != null) {
                bundle.putAll(zzl);
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            zzea.this.zza((zzb) new zzfd(this, activity));
        }
    }

    public static zzea zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzadk == null) {
            synchronized (zzea.class) {
                if (zzadk == null) {
                    zzadk = new zzea(context, str, str2, str3, bundle);
                }
            }
        }
        return zzadk;
    }

    class zza extends zzdr {
        private final AtomicReference<Bundle> zzaet = new AtomicReference<>();
        private boolean zzaeu;

        zza() {
        }

        public final void zzb(Bundle bundle) {
            synchronized (this.zzaet) {
                try {
                    this.zzaet.set(bundle);
                    this.zzaeu = true;
                    this.zzaet.notify();
                } catch (Throwable th) {
                    this.zzaet.notify();
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final String zzk(long j) {
            return (String) zza(zzl(j), String.class);
        }

        /* access modifiers changed from: package-private */
        public final Bundle zzl(long j) {
            Bundle bundle;
            synchronized (this.zzaet) {
                if (!this.zzaeu) {
                    try {
                        this.zzaet.wait(j);
                    } catch (InterruptedException unused) {
                        return null;
                    }
                }
                bundle = this.zzaet.get();
            }
            return bundle;
        }

        /* access modifiers changed from: package-private */
        public final <T> T zza(Bundle bundle, Class<T> cls) {
            Object obj;
            if (bundle == null || (obj = bundle.get("r")) == null) {
                return null;
            }
            try {
                return cls.cast(obj);
            } catch (ClassCastException e) {
                String canonicalName = cls.getCanonicalName();
                String canonicalName2 = obj.getClass().getCanonicalName();
                zzea.this.zzc(5, "Unexpected object type. Expected, Received", canonicalName, canonicalName2, e);
                Log.w(zzea.this.zzadh, String.format(String.valueOf("Unexpected object type. Expected, Received").concat(": %s, %s"), new Object[]{canonicalName, canonicalName2}), e);
                throw e;
            }
        }
    }

    abstract class zzb implements Runnable {
        final long timestamp;
        final long zzaev;
        private final boolean zzaew;

        zzb(zzea zzea) {
            this(true);
        }

        /* access modifiers changed from: package-private */
        public abstract void zzgd() throws RemoteException;

        /* access modifiers changed from: protected */
        public void zzge() {
        }

        zzb(boolean z) {
            this.timestamp = zzea.this.zzrz.currentTimeMillis();
            this.zzaev = zzea.this.zzrz.elapsedRealtime();
            this.zzaew = z;
        }

        public void run() {
            if (zzea.this.zzadp) {
                zzge();
                return;
            }
            try {
                zzgd();
            } catch (Exception e) {
                zzea.this.zza(e, false, this.zzaew);
                zzge();
            }
        }
    }

    static class zzc extends zzdu {
        private final zzcx zzaex;

        zzc(zzcx zzcx) {
            this.zzaex = zzcx;
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            this.zzaex.interceptEvent(str, str2, bundle, j);
        }

        /* renamed from: id */
        public final int mo28355id() {
            return this.zzaex.hashCode();
        }
    }

    static class zzd extends zzdu {
        private final zzcy zzaey;

        zzd(zzcy zzcy) {
            this.zzaey = zzcy;
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            this.zzaey.onEvent(str, str2, bundle, j);
        }

        /* renamed from: id */
        public final int mo28355id() {
            return this.zzaey.hashCode();
        }
    }

    public final AppMeasurementSdk zzga() {
        return this.zzadm;
    }

    private zzea(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zze(str2, str3)) {
            this.zzadh = "FA";
        } else {
            this.zzadh = str;
        }
        this.zzrz = DefaultClock.getInstance();
        this.zzadl = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzadh, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zze());
        }
        this.zzadm = new AppMeasurementSdk(this);
        boolean z = false;
        if (!(!zzf(context) || zzgb())) {
            this.zzadq = null;
            this.zzadp = true;
            Log.w(this.zzadh, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!zze(str2, str3)) {
            this.zzadq = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null ? true : z)) {
                    Log.w(this.zzadh, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzadh, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
                this.zzadp = true;
                return;
            }
        } else {
            this.zzadq = str2;
        }
        zza((zzb) new zzeb(this, context, str2, str3, bundle));
    }

    private static boolean zzf(Context context) {
        try {
            GoogleServices.initialize(context);
            if (GoogleServices.getGoogleAppId() != null) {
                return true;
            }
            return false;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static boolean zze(String str, String str2) {
        return (str2 == null || str == null || zzgb()) ? false : true;
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        this.zzadl.execute(zzb2);
    }

    /* access modifiers changed from: protected */
    public final zzdn zzg(Context context) {
        try {
            return zzdo.asInterface(DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION, "com.google.android.gms.measurement.dynamite").instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            zza((Exception) e, true, false);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static int zzh(Context context) {
        return DynamiteModule.getRemoteVersion(context, "com.google.android.gms.measurement.dynamite");
    }

    /* access modifiers changed from: private */
    public static int zzi(Context context) {
        return DynamiteModule.getLocalVersion(context, "com.google.android.gms.measurement.dynamite");
    }

    /* access modifiers changed from: private */
    public final void zza(Exception exc, boolean z, boolean z2) {
        this.zzadp |= z;
        if (z) {
            Log.w(this.zzadh, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zzc(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.zzadh, "Error with data collection. Data lost.", exc);
    }

    private static boolean zzgb() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void zza(zzcx zzcx) {
        zza((zzb) new zzei(this, zzcx));
    }

    public final void zza(zzcy zzcy) {
        zza((zzb) new zzes(this, zzcy));
    }

    public final void zzb(zzcy zzcy) {
        zza((zzb) new zzet(this, zzcy));
    }

    public final void logEventInternal(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, (Long) null);
    }

    public final void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, Long.valueOf(j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zza((zzb) new zzeu(this, l, str, str2, bundle, true, z2));
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza((zzb) new zzev(this, str, str2, obj, true));
    }

    public final void setConditionalUserProperty(Bundle bundle) {
        zza((zzb) new zzew(this, bundle));
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zza((zzb) new zzec(this, str, str2, bundle));
    }

    public final List<Bundle> getConditionalUserProperties(String str, String str2) {
        zza zza2 = new zza();
        zza((zzb) new zzed(this, str, str2, zza2));
        List<Bundle> list = (List) zza2.zza(zza2.zzl(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void setCurrentScreen(Activity activity, String str, String str2) {
        zza((zzb) new zzee(this, activity, str, str2));
    }

    public final void setMeasurementEnabled(boolean z) {
        zza((zzb) new zzef(this, z));
    }

    public final void beginAdUnitExposure(String str) {
        zza((zzb) new zzeg(this, str));
    }

    public final void endAdUnitExposure(String str) {
        zza((zzb) new zzeh(this, str));
    }

    public final String getGmpAppId() {
        zza zza2 = new zza();
        zza((zzb) new zzej(this, zza2));
        return zza2.zzk(500);
    }

    public final String zzgc() {
        zza zza2 = new zza();
        zza((zzb) new zzek(this, zza2));
        return zza2.zzk(50);
    }

    public final long generateEventId() {
        zza zza2 = new zza();
        zza((zzb) new zzel(this, zza2));
        Long l = (Long) zza2.zza(zza2.zzl(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zzrz.currentTimeMillis()).nextLong();
        int i = this.zzado + 1;
        this.zzado = i;
        return nextLong + ((long) i);
    }

    public final String getCurrentScreenName() {
        zza zza2 = new zza();
        zza((zzb) new zzem(this, zza2));
        return zza2.zzk(500);
    }

    public final String getCurrentScreenClass() {
        zza zza2 = new zza();
        zza((zzb) new zzen(this, zza2));
        return zza2.zzk(500);
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zza zza2 = new zza();
        zza((zzb) new zzeo(this, str, str2, z, zza2));
        Bundle zzl = zza2.zzl(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        if (zzl == null || zzl.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzl.size());
        for (String str3 : zzl.keySet()) {
            Object obj = zzl.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zzc(int i, String str, Object obj, Object obj2, Object obj3) {
        zza((zzb) new zzep(this, false, 5, str, obj, obj2, obj3));
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        zza zza2 = new zza();
        zza((zzb) new zzeq(this, bundle, zza2));
        if (z) {
            return zza2.zzl(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        }
        return null;
    }

    public final int getMaxUserProperties(String str) {
        zza zza2 = new zza();
        zza((zzb) new zzer(this, str, zza2));
        Integer num = (Integer) zza2.zza(zza2.zzl(10000), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final String getAppIdOrigin() {
        return this.zzadq;
    }
}
