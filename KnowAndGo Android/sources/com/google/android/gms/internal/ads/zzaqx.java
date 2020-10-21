package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.p005os.EnvironmentCompat;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.ParametersAreNonnullByDefault;
import org.apache.commons.lang3.StringUtils;

@ParametersAreNonnullByDefault
@zzard
public final class zzaqx implements zzarb {
    private static final Object lock = new Object();
    @VisibleForTesting
    private static zzarb zzdkz = null;
    @VisibleForTesting
    private static zzarb zzdla = null;
    private final Context zzcko;
    private final Object zzdlb;
    private final WeakHashMap<Thread, Boolean> zzdlc;
    private final zzbai zzdld;
    private final ExecutorService zzxf;

    public static zzarb zzo(Context context) {
        synchronized (lock) {
            if (zzdkz == null) {
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcle)).booleanValue()) {
                    zzdkz = new zzaqx(context);
                } else {
                    zzdkz = new zzarc();
                }
            }
        }
        return zzdkz;
    }

    public static zzarb zzc(Context context, zzbai zzbai) {
        synchronized (lock) {
            if (zzdla == null) {
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcle)).booleanValue()) {
                    zzaqx zzaqx = new zzaqx(context, zzbai);
                    Thread thread = Looper.getMainLooper().getThread();
                    if (thread != null) {
                        synchronized (zzaqx.zzdlb) {
                            zzaqx.zzdlc.put(thread, true);
                        }
                        thread.setUncaughtExceptionHandler(new zzaqz(zzaqx, thread.getUncaughtExceptionHandler()));
                    }
                    Thread.setDefaultUncaughtExceptionHandler(new zzaqy(zzaqx, Thread.getDefaultUncaughtExceptionHandler()));
                    zzdla = zzaqx;
                } else {
                    zzdla = new zzarc();
                }
            }
        }
        return zzdla;
    }

    private zzaqx(Context context) {
        this(context, zzbai.zzxc());
    }

    private zzaqx(Context context, zzbai zzbai) {
        this.zzdlb = new Object();
        this.zzdlc = new WeakHashMap<>();
        this.zzxf = Executors.newCachedThreadPool();
        this.zzcko = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdld = zzbai;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r3 == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.Thread r10, java.lang.Throwable r11) {
        /*
            r9 = this;
            r10 = 1
            r0 = 0
            if (r11 == 0) goto L_0x0042
            r1 = r11
            r2 = 0
            r3 = 0
        L_0x0007:
            if (r1 == 0) goto L_0x003d
            java.lang.StackTraceElement[] r4 = r1.getStackTrace()
            int r5 = r4.length
            r6 = r3
            r3 = r2
            r2 = 0
        L_0x0011:
            if (r2 >= r5) goto L_0x0036
            r7 = r4[r2]
            java.lang.String r8 = r7.getClassName()
            boolean r8 = com.google.android.gms.internal.ads.zzazt.zzej(r8)
            if (r8 == 0) goto L_0x0020
            r3 = 1
        L_0x0020:
            java.lang.Class r8 = r9.getClass()
            java.lang.String r8 = r8.getName()
            java.lang.String r7 = r7.getClassName()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x0033
            r6 = 1
        L_0x0033:
            int r2 = r2 + 1
            goto L_0x0011
        L_0x0036:
            java.lang.Throwable r1 = r1.getCause()
            r2 = r3
            r3 = r6
            goto L_0x0007
        L_0x003d:
            if (r2 == 0) goto L_0x0042
            if (r3 != 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r10 = 0
        L_0x0043:
            if (r10 == 0) goto L_0x004c
            java.lang.String r10 = ""
            r0 = 1065353216(0x3f800000, float:1.0)
            r9.zza(r11, r10, r0)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqx.zza(java.lang.Thread, java.lang.Throwable):void");
    }

    public final void zza(Throwable th, String str) {
        zza(th, str, 1.0f);
    }

    public final void zza(Throwable th, String str, float f) {
        if (zzazt.zzc(th) != null) {
            String name = th.getClass().getName();
            StringWriter stringWriter = new StringWriter();
            zzdmb.zza(th, new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            int i = 0;
            int i2 = 1;
            boolean z = Math.random() < ((double) f);
            if (f > 0.0f) {
                i2 = (int) (1.0f / f);
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(zza(name, stringWriter2, str, i2).toString());
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    this.zzxf.submit(new zzara(this, new zzbah(), (String) obj));
                }
            }
        }
    }

    @VisibleForTesting
    private final Uri.Builder zza(String str, String str2, String str3, int i) {
        boolean z;
        try {
            z = Wrappers.packageManager(this.zzcko).isCallerInstantApp();
        } catch (Throwable th) {
            zzbad.zzc("Error fetching instant app info", th);
            z = false;
        }
        String str4 = EnvironmentCompat.MEDIA_UNKNOWN;
        try {
            str4 = this.zzcko.getPackageName();
        } catch (Throwable unused) {
            zzbad.zzep("Cannot obtain package name, proceeding.");
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme(UriUtil.HTTPS_SCHEME).path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        String str5 = Build.MANUFACTURER;
        String str6 = Build.MODEL;
        if (!str6.startsWith(str5)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str5).length() + 1 + String.valueOf(str6).length());
            sb.append(str5);
            sb.append(StringUtils.SPACE);
            sb.append(str6);
            str6 = sb.toString();
        }
        return appendQueryParameter.appendQueryParameter("device", str6).appendQueryParameter("js", this.zzdld.zzbsx).appendQueryParameter("appid", str4).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", zzacu.zzqn())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "248613007").appendQueryParameter("rc", "dev").appendQueryParameter("session_id", zzyt.zzpf()).appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzyt.zzpe().zzd(zzacu.zzcwf)));
    }
}
