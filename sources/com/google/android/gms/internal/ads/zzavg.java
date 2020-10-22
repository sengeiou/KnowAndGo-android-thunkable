package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@zzard
public final class zzavg {
    private final AtomicReference<ThreadPoolExecutor> zzdsd = new AtomicReference<>((Object) null);
    private final Object zzdse = new Object();
    @GuardedBy("gmpAppIdLock")
    @Nullable
    private String zzdsf = null;
    @GuardedBy("gmpAppIdLock")
    @Nullable
    private String zzdsg = null;
    @VisibleForTesting
    private final AtomicBoolean zzdsh = new AtomicBoolean(false);
    @VisibleForTesting
    private final AtomicInteger zzdsi = new AtomicInteger(-1);
    private final AtomicReference<Object> zzdsj = new AtomicReference<>((Object) null);
    private final AtomicReference<Object> zzdsk = new AtomicReference<>((Object) null);
    private final ConcurrentMap<String, Method> zzdsl = new ConcurrentHashMap(9);
    private final AtomicReference<zzbjf> zzdsm = new AtomicReference<>((Object) null);
    @GuardedBy("proxyReference")
    private final List<FutureTask> zzdsn = new ArrayList();

    public final boolean zzx(Context context) {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcns)).booleanValue() || this.zzdsh.get()) {
            return false;
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcoc)).booleanValue()) {
            return true;
        }
        if (this.zzdsi.get() == -1) {
            zzyt.zzpa();
            if (!zzazt.zzc(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzyt.zzpa();
                if (zzazt.zzbg(context)) {
                    zzawz.zzep("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                    this.zzdsi.set(0);
                }
            }
            this.zzdsi.set(1);
        }
        if (this.zzdsi.get() == 1) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    private static boolean zzy(Context context) {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcnz)).booleanValue()) {
            if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcoa)).booleanValue()) {
                return false;
            }
        }
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcob)).booleanValue()) {
            return true;
        }
        try {
            context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        }
    }

    public final void zzd(Context context, String str) {
        if (zzx(context)) {
            if (zzy(context)) {
                zza("beginAdUnitExposure", (zzavw) new zzavh(str));
            } else {
                zza(context, str, "beginAdUnitExposure");
            }
        }
    }

    public final void zze(Context context, String str) {
        if (zzx(context)) {
            if (zzy(context)) {
                zza("endAdUnitExposure", (zzavw) new zzavi(str));
            } else {
                zza(context, str, "endAdUnitExposure");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzz(android.content.Context r5) {
        /*
            r4 = this;
            boolean r0 = r4.zzx(r5)
            if (r0 != 0) goto L_0x0009
            java.lang.String r5 = ""
            return r5
        L_0x0009:
            boolean r0 = zzy(r5)
            if (r0 == 0) goto L_0x001c
            java.lang.String r5 = "getCurrentScreenNameOrScreenClass"
            java.lang.String r0 = ""
            com.google.android.gms.internal.ads.zzavv r1 = com.google.android.gms.internal.ads.zzavm.zzdst
            java.lang.Object r5 = r4.zza((java.lang.String) r5, r0, r1)
            java.lang.String r5 = (java.lang.String) r5
            return r5
        L_0x001c:
            java.lang.String r0 = "com.google.android.gms.measurement.AppMeasurement"
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r4.zzdsj
            r2 = 1
            boolean r0 = r4.zza((android.content.Context) r5, (java.lang.String) r0, (java.util.concurrent.atomic.AtomicReference<java.lang.Object>) r1, (boolean) r2)
            if (r0 != 0) goto L_0x002a
            java.lang.String r5 = ""
            return r5
        L_0x002a:
            r0 = 0
            java.lang.String r1 = "getCurrentScreenName"
            java.lang.reflect.Method r1 = r4.zzl(r5, r1)     // Catch:{ Exception -> 0x005c }
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r2 = r4.zzdsj     // Catch:{ Exception -> 0x005c }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x005c }
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x005c }
            java.lang.Object r1 = r1.invoke(r2, r3)     // Catch:{ Exception -> 0x005c }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x005c }
            if (r1 != 0) goto L_0x0056
            java.lang.String r1 = "getCurrentScreenClass"
            java.lang.reflect.Method r5 = r4.zzl(r5, r1)     // Catch:{ Exception -> 0x005c }
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r4.zzdsj     // Catch:{ Exception -> 0x005c }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x005c }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x005c }
            java.lang.Object r5 = r5.invoke(r1, r2)     // Catch:{ Exception -> 0x005c }
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x005c }
        L_0x0056:
            if (r1 == 0) goto L_0x0059
            return r1
        L_0x0059:
            java.lang.String r5 = ""
            return r5
        L_0x005c:
            r5 = move-exception
            java.lang.String r1 = "getCurrentScreenName"
            r4.zza((java.lang.Exception) r5, (java.lang.String) r1, (boolean) r0)
            java.lang.String r5 = ""
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavg.zzz(android.content.Context):java.lang.String");
    }

    public final void zzf(Context context, String str) {
        if (!zzx(context) || !(context instanceof Activity)) {
            return;
        }
        if (zzy(context)) {
            zza("setScreenName", (zzavw) new zzavn(context, str));
        } else if (zza(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzdsk, false)) {
            Method zzm = zzm(context, "setCurrentScreen");
            try {
                zzm.invoke(this.zzdsk.get(), new Object[]{(Activity) context, str, context.getPackageName()});
            } catch (Exception e) {
                zza(e, "setCurrentScreen", false);
            }
        }
    }

    @Nullable
    public final String zzaa(Context context) {
        if (!zzx(context)) {
            return null;
        }
        synchronized (this.zzdse) {
            if (this.zzdsf != null) {
                String str = this.zzdsf;
                return str;
            }
            if (zzy(context)) {
                this.zzdsf = (String) zza("getGmpAppId", this.zzdsf, zzavo.zzdst);
            } else {
                this.zzdsf = (String) zza("getGmpAppId", context);
            }
            String str2 = this.zzdsf;
            return str2;
        }
    }

    @Nullable
    public final String zzab(Context context) {
        if (!zzx(context)) {
            return null;
        }
        long longValue = ((Long) zzyt.zzpe().zzd(zzacu.zzcnx)).longValue();
        if (zzy(context)) {
            if (longValue >= 0) {
                return (String) zza("getAppInstanceId", zzavq.zzdst).get(longValue, TimeUnit.MILLISECONDS);
            }
            try {
                return (String) zza("getAppInstanceId", zzavp.zzdst).get();
            } catch (Exception e) {
                if (e instanceof TimeoutException) {
                    return "TIME_OUT";
                }
                return null;
            }
        } else if (longValue < 0) {
            return (String) zza("getAppInstanceId", context);
        } else {
            Future submit = zzui().submit(new zzavr(this, context));
            try {
                return (String) submit.get(longValue, TimeUnit.MILLISECONDS);
            } catch (Exception e2) {
                submit.cancel(true);
                if (e2 instanceof TimeoutException) {
                    return "TIME_OUT";
                }
                return null;
            }
        }
    }

    @Nullable
    public final String zzac(Context context) {
        if (!zzx(context)) {
            return null;
        }
        if (zzy(context)) {
            Long l = (Long) zza("getAdEventId", (Object) null, zzavs.zzdst);
            if (l != null) {
                return Long.toString(l.longValue());
            }
            return null;
        }
        Object zza = zza("generateEventId", context);
        if (zza != null) {
            return zza.toString();
        }
        return null;
    }

    @Nullable
    public final String zzad(Context context) {
        if (!zzx(context)) {
            return null;
        }
        synchronized (this.zzdse) {
            if (this.zzdsg != null) {
                String str = this.zzdsg;
                return str;
            }
            if (zzy(context)) {
                this.zzdsg = (String) zza("getAppIdOrigin", this.zzdsg, zzavt.zzdst);
            } else {
                this.zzdsg = "fa";
            }
            String str2 = this.zzdsg;
            return str2;
        }
    }

    public final void zzg(Context context, String str) {
        zza(context, "_ac", str, (Bundle) null);
    }

    public final void zzh(Context context, String str) {
        zza(context, "_ai", str, (Bundle) null);
    }

    public final void zzi(Context context, String str) {
        zza(context, "_aq", str, (Bundle) null);
    }

    public final void zzj(Context context, String str) {
        zza(context, "_aa", str, (Bundle) null);
    }

    public final void zza(Context context, String str, String str2, String str3, int i) {
        if (zzx(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("type", str3);
            bundle.putInt("value", i);
            zza(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 75);
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            zzawz.zzds(sb.toString());
        }
    }

    private final void zza(Context context, String str, String str2, @Nullable Bundle bundle) {
        if (zzx(context)) {
            Bundle zzj = zzj(str2, str);
            if (bundle != null) {
                zzj.putAll(bundle);
            }
            if (zzy(context)) {
                zza("logEventInternal", (zzavw) new zzavj(str, zzj));
            } else if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdsj, true)) {
                Method zzae = zzae(context);
                try {
                    zzae.invoke(this.zzdsj.get(), new Object[]{"am", str, zzj});
                } catch (Exception e) {
                    zza(e, "logEventInternal", true);
                }
            }
        }
    }

    private static Bundle zzj(String str, String str2) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e) {
            String valueOf = String.valueOf(str);
            zzawz.zzc(valueOf.length() != 0 ? "Invalid event ID: ".concat(valueOf) : new String("Invalid event ID: "), e);
        }
        if ("_ac".equals(str2)) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    @Nullable
    private final Method zzae(Context context) {
        Method method = (Method) this.zzdsl.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", new Class[]{String.class, String.class, Bundle.class});
            this.zzdsl.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, "logEventInternal", true);
            return null;
        }
    }

    @Nullable
    private final Method zzk(Context context, String str) {
        Method method = (Method) this.zzdsl.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[]{String.class});
            this.zzdsl.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    @Nullable
    private final Method zzl(Context context, String str) {
        Method method = (Method) this.zzdsl.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzdsl.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final Method zzm(Context context, String str) {
        Method method = (Method) this.zzdsl.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, new Class[]{Activity.class, String.class, String.class});
            this.zzdsl.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final void zza(Context context, String str, String str2) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdsj, true)) {
            Method zzk = zzk(context, str2);
            try {
                zzk.invoke(this.zzdsj.get(), new Object[]{str});
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                zzawz.zzds(sb.toString());
            } catch (Exception e) {
                zza(e, str2, false);
            }
        }
    }

    private final Object zza(String str, Context context) {
        if (!zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdsj, true)) {
            return null;
        }
        try {
            return zzl(context, str).invoke(this.zzdsj.get(), new Object[0]);
        } catch (Exception e) {
            zza(e, str, true);
            return null;
        }
    }

    private final void zza(Exception exc, String str, boolean z) {
        if (!this.zzdsh.get()) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
            sb.append("Invoke Firebase method ");
            sb.append(str);
            sb.append(" error.");
            zzawz.zzep(sb.toString());
            if (z) {
                zzawz.zzep("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
                this.zzdsh.set(true);
            }
        }
    }

    private final ThreadPoolExecutor zzui() {
        if (this.zzdsd.get() == null) {
            this.zzdsd.compareAndSet((Object) null, new ThreadPoolExecutor(((Integer) zzyt.zzpe().zzd(zzacu.zzcny)).intValue(), ((Integer) zzyt.zzpe().zzd(zzacu.zzcny)).intValue(), 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), new zzavu(this)));
        }
        return this.zzdsd.get();
    }

    private final boolean zza(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet((Object) null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context}));
            } catch (Exception e) {
                zza(e, "getInstance", z);
                return false;
            }
        }
        return true;
    }

    private final void zza(String str, zzavw zzavw) {
        synchronized (this.zzdsm) {
            FutureTask futureTask = new FutureTask(new zzavk(this, zzavw, str), (Object) null);
            if (this.zzdsm.get() != null) {
                futureTask.run();
            } else {
                this.zzdsn.add(futureTask);
            }
        }
    }

    private final <T> Future<T> zza(String str, zzavv<T> zzavv) {
        FutureTask futureTask;
        synchronized (this.zzdsm) {
            futureTask = new FutureTask(new zzavl(this, zzavv, str));
            if (this.zzdsm.get() != null) {
                zzui().submit(futureTask);
            } else {
                this.zzdsn.add(futureTask);
            }
        }
        return futureTask;
    }

    private final <T> T zza(String str, @Nullable T t, zzavv<T> zzavv) {
        synchronized (this.zzdsm) {
            if (this.zzdsm.get() != null) {
                try {
                    T zzb = zzavv.zzb(this.zzdsm.get());
                    return zzb;
                } catch (Exception e) {
                    zza(e, str, false);
                    return t;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(zzavv zzavv, String str) throws Exception {
        try {
            return zzavv.zzb(this.zzdsm.get());
        } catch (Exception e) {
            zza(e, str, false);
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzavw zzavw, String str) {
        if (this.zzdsm.get() != null) {
            try {
                zzavw.zza(this.zzdsm.get());
            } catch (Exception e) {
                zza(e, str, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzaf(Context context) throws Exception {
        return (String) zza("getAppInstanceId", context);
    }
}
