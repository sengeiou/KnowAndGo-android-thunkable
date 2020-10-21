package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
@ParametersAreNonnullByDefault
@zzard
public final class zzuu extends Thread {
    private final Object lock;
    private boolean started;
    private final int zzbtz;
    private final int zzbub;
    private final boolean zzbuc;
    private boolean zzbuz;
    private boolean zzbva;
    private final zzup zzbvb;
    private final int zzbvc;
    private final int zzbvd;
    private final int zzbve;
    private final int zzbvf;
    private final int zzbvg;
    private final int zzbvh;
    private final String zzbvi;
    private final boolean zzbvj;
    private final boolean zzbvk;

    public zzuu() {
        this(new zzup());
    }

    @VisibleForTesting
    private zzuu(zzup zzup) {
        this.started = false;
        this.zzbuz = false;
        this.zzbva = false;
        this.zzbvb = zzup;
        this.lock = new Object();
        this.zzbtz = ((Integer) zzyt.zzpe().zzd(zzacu.zzcnb)).intValue();
        this.zzbvd = ((Integer) zzyt.zzpe().zzd(zzacu.zzcnc)).intValue();
        this.zzbub = ((Integer) zzyt.zzpe().zzd(zzacu.zzcnd)).intValue();
        this.zzbve = ((Integer) zzyt.zzpe().zzd(zzacu.zzcne)).intValue();
        this.zzbvf = ((Integer) zzyt.zzpe().zzd(zzacu.zzcng)).intValue();
        this.zzbvg = ((Integer) zzyt.zzpe().zzd(zzacu.zzcnh)).intValue();
        this.zzbvh = ((Integer) zzyt.zzpe().zzd(zzacu.zzcni)).intValue();
        this.zzbvc = ((Integer) zzyt.zzpe().zzd(zzacu.zzcnf)).intValue();
        this.zzbvi = (String) zzyt.zzpe().zzd(zzacu.zzcnk);
        this.zzbvj = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcnl)).booleanValue();
        this.zzbuc = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcnp)).booleanValue();
        this.zzbvk = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcnq)).booleanValue();
        setName("ContentFetchTask");
    }

    public final void zzmv() {
        synchronized (this.lock) {
            if (this.started) {
                zzawz.zzdp("Content hash thread already started, quiting...");
                return;
            }
            this.started = true;
            start();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        com.google.android.gms.ads.internal.zzk.zzlk().zza(r0, "ContentFetchTask.extractContent");
        com.google.android.gms.internal.ads.zzawz.zzdp("Failed getting root view of activity. Content not extracted.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007b, code lost:
        com.google.android.gms.internal.ads.zzawz.zzc("Error in ContentFetchTask", r0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0083 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007a A[ExcHandler: InterruptedException (r0v1 'e' java.lang.InterruptedException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0083 A[LOOP:1: B:29:0x0083->B:41:0x0083, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r4 = this;
        L_0x0000:
            boolean r0 = zzmw()     // Catch:{ InterruptedException -> 0x007a, Exception -> 0x006a }
            if (r0 == 0) goto L_0x0059
            com.google.android.gms.internal.ads.zzuq r0 = com.google.android.gms.ads.internal.zzk.zzlj()     // Catch:{ InterruptedException -> 0x007a, Exception -> 0x006a }
            android.app.Activity r0 = r0.getActivity()     // Catch:{ InterruptedException -> 0x007a, Exception -> 0x006a }
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = "ContentFetchThread: no activity. Sleeping."
            com.google.android.gms.internal.ads.zzawz.zzdp(r0)     // Catch:{ InterruptedException -> 0x007a, Exception -> 0x006a }
            r4.zzmy()     // Catch:{ InterruptedException -> 0x007a, Exception -> 0x006a }
            goto L_0x0061
        L_0x0019:
            if (r0 == 0) goto L_0x0061
            r1 = 0
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007a }
            if (r2 == 0) goto L_0x004c
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007a }
            android.view.View r2 = r2.getDecorView()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007a }
            if (r2 == 0) goto L_0x004c
            android.view.Window r0 = r0.getWindow()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007a }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007a }
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007a }
            r1 = r0
            goto L_0x004c
        L_0x003d:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzawm r2 = com.google.android.gms.ads.internal.zzk.zzlk()     // Catch:{ InterruptedException -> 0x007a, Exception -> 0x006a }
            java.lang.String r3 = "ContentFetchTask.extractContent"
            r2.zza(r0, r3)     // Catch:{ InterruptedException -> 0x007a, Exception -> 0x006a }
            java.lang.String r0 = "Failed getting root view of activity. Content not extracted."
            com.google.android.gms.internal.ads.zzawz.zzdp(r0)     // Catch:{ InterruptedException -> 0x007a, Exception -> 0x006a }
        L_0x004c:
            if (r1 == 0) goto L_0x0061
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.ads.zzuv r0 = new com.google.android.gms.internal.ads.zzuv     // Catch:{ InterruptedException -> 0x007a, Exception -> 0x006a }
            r0.<init>(r4, r1)     // Catch:{ InterruptedException -> 0x007a, Exception -> 0x006a }
            r1.post(r0)     // Catch:{ InterruptedException -> 0x007a, Exception -> 0x006a }
            goto L_0x0061
        L_0x0059:
            java.lang.String r0 = "ContentFetchTask: sleeping"
            com.google.android.gms.internal.ads.zzawz.zzdp(r0)     // Catch:{ InterruptedException -> 0x007a, Exception -> 0x006a }
            r4.zzmy()     // Catch:{ InterruptedException -> 0x007a, Exception -> 0x006a }
        L_0x0061:
            int r0 = r4.zzbvc     // Catch:{ InterruptedException -> 0x007a, Exception -> 0x006a }
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x007a, Exception -> 0x006a }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x007a, Exception -> 0x006a }
            goto L_0x0080
        L_0x006a:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzawz.zzc(r1, r0)
            com.google.android.gms.internal.ads.zzawm r1 = com.google.android.gms.ads.internal.zzk.zzlk()
            java.lang.String r2 = "ContentFetchTask.run"
            r1.zza(r0, r2)
            goto L_0x0080
        L_0x007a:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzawz.zzc(r1, r0)
        L_0x0080:
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
        L_0x0083:
            boolean r1 = r4.zzbuz     // Catch:{ all -> 0x0095 }
            if (r1 == 0) goto L_0x0092
            java.lang.String r1 = "ContentFetchTask: waiting"
            com.google.android.gms.internal.ads.zzawz.zzdp(r1)     // Catch:{ InterruptedException -> 0x0083 }
            java.lang.Object r1 = r4.lock     // Catch:{ InterruptedException -> 0x0083 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0083 }
            goto L_0x0083
        L_0x0092:
            monitor-exit(r0)     // Catch:{ all -> 0x0095 }
            goto L_0x0000
        L_0x0095:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0095 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuu.run():void");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzi(View view) {
        try {
            zzuo zzuo = new zzuo(this.zzbtz, this.zzbvd, this.zzbub, this.zzbve, this.zzbvf, this.zzbvg, this.zzbvh, this.zzbuc);
            Context context = zzk.zzlj().getContext();
            if (context != null && !TextUtils.isEmpty(this.zzbvi)) {
                String str = (String) view.getTag(context.getResources().getIdentifier((String) zzyt.zzpe().zzd(zzacu.zzcnj), "id", context.getPackageName()));
                if (str != null && str.equals(this.zzbvi)) {
                    return;
                }
            }
            zzuy zza = zza(view, zzuo);
            zzuo.zzmt();
            if (zza.zzbvs != 0 || zza.zzbvt != 0) {
                if (zza.zzbvt != 0 || zzuo.zzmu() != 0) {
                    if (zza.zzbvt != 0 || !this.zzbvb.zza(zzuo)) {
                        this.zzbvb.zzc(zzuo);
                    }
                }
            }
        } catch (Exception e) {
            zzawz.zzc("Exception in fetchContentOnUIThread", e);
            zzk.zzlk().zza(e, "ContentFetchTask.fetchContent");
        }
    }

    @VisibleForTesting
    private static boolean zzmw() {
        boolean z;
        try {
            Context context = zzk.zzlj().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager != null) {
                if (keyguardManager != null) {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses == null) {
                        return false;
                    }
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (Process.myPid() == next.pid) {
                            if (next.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode()) {
                                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                                if (powerManager == null) {
                                    z = false;
                                } else {
                                    z = powerManager.isScreenOn();
                                }
                                if (z) {
                                    return true;
                                }
                            }
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            zzk.zzlk().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    @VisibleForTesting
    private final zzuy zza(@Nullable View view, zzuo zzuo) {
        boolean z;
        if (view == null) {
            return new zzuy(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzuy(this, 0, 0);
            }
            zzuo.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new zzuy(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzbgz)) {
            WebView webView = (WebView) view;
            if (!PlatformVersion.isAtLeastKitKat()) {
                z = false;
            } else {
                zzuo.zzmr();
                webView.post(new zzuw(this, zzuo, webView, globalVisibleRect));
                z = true;
            }
            if (z) {
                return new zzuy(this, 0, 1);
            }
            return new zzuy(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zzuy(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zzuy zza = zza(viewGroup.getChildAt(i3), zzuo);
                i += zza.zzbvs;
                i2 += zza.zzbvt;
            }
            return new zzuy(this, i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(zzuo zzuo, WebView webView, String str, boolean z) {
        zzuo.zzmq();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (this.zzbvj || TextUtils.isEmpty(webView.getTitle())) {
                    zzuo.zza(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzuo.zza(sb.toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (zzuo.zzml()) {
                this.zzbvb.zzb(zzuo);
            }
        } catch (JSONException unused) {
            zzawz.zzdp("Json string may be malformed.");
        } catch (Throwable th) {
            zzawz.zzb("Failed to get webview content.", th);
            zzk.zzlk().zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final zzuo zzmx() {
        return this.zzbvb.zzo(this.zzbvk);
    }

    public final void wakeup() {
        synchronized (this.lock) {
            this.zzbuz = false;
            this.lock.notifyAll();
            zzawz.zzdp("ContentFetchThread: wakeup");
        }
    }

    private final void zzmy() {
        synchronized (this.lock) {
            this.zzbuz = true;
            boolean z = this.zzbuz;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(z);
            zzawz.zzdp(sb.toString());
        }
    }

    public final boolean zzmz() {
        return this.zzbuz;
    }
}
