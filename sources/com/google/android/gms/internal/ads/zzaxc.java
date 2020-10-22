package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public final class zzaxc implements zzaxb {
    private final Object lock = new Object();
    @GuardedBy("lock")
    @Nullable
    private SharedPreferences zzckn;
    @GuardedBy("lock")
    private boolean zzdls = true;
    @GuardedBy("lock")
    private boolean zzdmh = false;
    @GuardedBy("lock")
    private String zzdmk = "";
    @GuardedBy("lock")
    private boolean zzdnt = true;
    @GuardedBy("lock")
    private boolean zzdoe = true;
    private boolean zzduw;
    private final List<Runnable> zzdux = new ArrayList();
    private zzbbh<?> zzduy;
    @GuardedBy("lock")
    @Nullable
    private zzuu zzduz = null;
    @GuardedBy("lock")
    @Nullable
    private SharedPreferences.Editor zzdva;
    @GuardedBy("lock")
    private boolean zzdvb = false;
    @GuardedBy("lock")
    @Nullable
    private String zzdvc;
    @GuardedBy("lock")
    @Nullable
    private String zzdvd;
    @GuardedBy("lock")
    private long zzdve = 0;
    @GuardedBy("lock")
    private long zzdvf = 0;
    @GuardedBy("lock")
    private long zzdvg = 0;
    @GuardedBy("lock")
    private int zzdvh = -1;
    @GuardedBy("lock")
    private int zzdvi = 0;
    @GuardedBy("lock")
    private Set<String> zzdvj = Collections.emptySet();
    @GuardedBy("lock")
    private JSONObject zzdvk = new JSONObject();
    @GuardedBy("lock")
    private String zzdvl = null;

    public final void zza(Context context, String str, boolean z) {
        String str2;
        if (str == null) {
            str2 = "admob";
        } else {
            String valueOf = String.valueOf("admob__");
            String valueOf2 = String.valueOf(str);
            str2 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.zzduy = zzaxg.zzc(new zzaxd(this, context, str2));
        this.zzduw = z;
    }

    private final void zzvy() {
        if (this.zzduy != null && !this.zzduy.isDone()) {
            try {
                this.zzduy.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                zzawz.zzd("Interrupted while waiting for preferences loaded.", e);
            } catch (CancellationException | ExecutionException | TimeoutException e2) {
                zzawz.zzc("Fail to initialize AdSharedPreferenceManager.", e2);
            }
        }
    }

    private final Bundle zzvz() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("listener_registration_bundle", true);
        synchronized (this.lock) {
            bundle.putBoolean("use_https", this.zzdls);
            bundle.putBoolean("content_url_opted_out", this.zzdnt);
            bundle.putBoolean("content_vertical_opted_out", this.zzdoe);
            bundle.putBoolean("auto_collect_location", this.zzdmh);
            bundle.putInt("version_code", this.zzdvi);
            bundle.putStringArray("never_pool_slots", (String[]) this.zzdvj.toArray(new String[0]));
            bundle.putString("app_settings_json", this.zzdmk);
            bundle.putLong("app_settings_last_update_ms", this.zzdve);
            bundle.putLong("app_last_background_time_ms", this.zzdvf);
            bundle.putInt("request_in_session_count", this.zzdvh);
            bundle.putLong("first_ad_req_time_ms", this.zzdvg);
            bundle.putString("native_advanced_settings", this.zzdvk.toString());
            bundle.putString("display_cutout", this.zzdvl);
            if (this.zzdvc != null) {
                bundle.putString("content_url_hashes", this.zzdvc);
            }
            if (this.zzdvd != null) {
                bundle.putString("content_vertical_hashes", this.zzdvd);
            }
        }
        return bundle;
    }

    private final void zzc(Bundle bundle) {
        zzaxg.zzdvp.execute(new zzaxe(this));
    }

    @Nullable
    public final zzuu zzvk() {
        if (!this.zzduw || !PlatformVersion.isAtLeastIceCreamSandwich()) {
            return null;
        }
        if (zzvl() && zzvn()) {
            return null;
        }
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcna)).booleanValue()) {
            return null;
        }
        synchronized (this.lock) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zzduz == null) {
                this.zzduz = new zzuu();
            }
            this.zzduz.zzmv();
            zzawz.zzeo("start fetching content...");
            zzuu zzuu = this.zzduz;
            return zzuu;
        }
    }

    public final void zzai(boolean z) {
        zzvy();
        synchronized (this.lock) {
            if (this.zzdnt != z) {
                this.zzdnt = z;
                if (this.zzdva != null) {
                    this.zzdva.putBoolean("content_url_opted_out", z);
                    this.zzdva.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", this.zzdnt);
                bundle.putBoolean("content_vertical_opted_out", this.zzdoe);
                zzc(bundle);
            }
        }
    }

    public final boolean zzvl() {
        boolean z;
        zzvy();
        synchronized (this.lock) {
            z = this.zzdnt;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzdt(@javax.annotation.Nullable java.lang.String r4) {
        /*
            r3 = this;
            r3.zzvy()
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0034
            java.lang.String r1 = r3.zzdvc     // Catch:{ all -> 0x0032 }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0011
            goto L_0x0034
        L_0x0011:
            r3.zzdvc = r4     // Catch:{ all -> 0x0032 }
            android.content.SharedPreferences$Editor r1 = r3.zzdva     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0023
            android.content.SharedPreferences$Editor r1 = r3.zzdva     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = "content_url_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0032 }
            android.content.SharedPreferences$Editor r1 = r3.zzdva     // Catch:{ all -> 0x0032 }
            r1.apply()     // Catch:{ all -> 0x0032 }
        L_0x0023:
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x0032 }
            r1.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = "content_url_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0032 }
            r3.zzc(r1)     // Catch:{ all -> 0x0032 }
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0032:
            r4 = move-exception
            goto L_0x0036
        L_0x0034:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0036:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxc.zzdt(java.lang.String):void");
    }

    @Nullable
    public final String zzvm() {
        String str;
        zzvy();
        synchronized (this.lock) {
            str = this.zzdvc;
        }
        return str;
    }

    public final void zzaj(boolean z) {
        zzvy();
        synchronized (this.lock) {
            if (this.zzdoe != z) {
                this.zzdoe = z;
                if (this.zzdva != null) {
                    this.zzdva.putBoolean("content_vertical_opted_out", z);
                    this.zzdva.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", this.zzdnt);
                bundle.putBoolean("content_vertical_opted_out", this.zzdoe);
                zzc(bundle);
            }
        }
    }

    public final boolean zzvn() {
        boolean z;
        zzvy();
        synchronized (this.lock) {
            z = this.zzdoe;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzdu(@javax.annotation.Nullable java.lang.String r4) {
        /*
            r3 = this;
            r3.zzvy()
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0034
            java.lang.String r1 = r3.zzdvd     // Catch:{ all -> 0x0032 }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0011
            goto L_0x0034
        L_0x0011:
            r3.zzdvd = r4     // Catch:{ all -> 0x0032 }
            android.content.SharedPreferences$Editor r1 = r3.zzdva     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0023
            android.content.SharedPreferences$Editor r1 = r3.zzdva     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = "content_vertical_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0032 }
            android.content.SharedPreferences$Editor r1 = r3.zzdva     // Catch:{ all -> 0x0032 }
            r1.apply()     // Catch:{ all -> 0x0032 }
        L_0x0023:
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x0032 }
            r1.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = "content_vertical_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0032 }
            r3.zzc(r1)     // Catch:{ all -> 0x0032 }
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0032:
            r4 = move-exception
            goto L_0x0036
        L_0x0034:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0036:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxc.zzdu(java.lang.String):void");
    }

    @Nullable
    public final String zzvo() {
        String str;
        zzvy();
        synchronized (this.lock) {
            str = this.zzdvd;
        }
        return str;
    }

    public final void zzak(boolean z) {
        zzvy();
        synchronized (this.lock) {
            if (this.zzdmh != z) {
                this.zzdmh = z;
                if (this.zzdva != null) {
                    this.zzdva.putBoolean("auto_collect_location", z);
                    this.zzdva.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("auto_collect_location", z);
                zzc(bundle);
            }
        }
    }

    public final boolean zzvp() {
        boolean z;
        zzvy();
        synchronized (this.lock) {
            z = this.zzdmh;
        }
        return z;
    }

    public final void zzct(int i) {
        zzvy();
        synchronized (this.lock) {
            if (this.zzdvi != i) {
                this.zzdvi = i;
                if (this.zzdva != null) {
                    this.zzdva.putInt("version_code", i);
                    this.zzdva.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("version_code", i);
                zzc(bundle);
            }
        }
    }

    public final int zzvq() {
        int i;
        zzvy();
        synchronized (this.lock) {
            i = this.zzdvi;
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzdv(java.lang.String r6) {
        /*
            r5 = this;
            r5.zzvy()
            java.lang.Object r0 = r5.lock
            monitor-enter(r0)
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzk.zzln()     // Catch:{ all -> 0x0060 }
            long r1 = r1.currentTimeMillis()     // Catch:{ all -> 0x0060 }
            r5.zzdve = r1     // Catch:{ all -> 0x0060 }
            if (r6 == 0) goto L_0x005e
            java.lang.String r3 = r5.zzdmk     // Catch:{ all -> 0x0060 }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x001b
            goto L_0x005e
        L_0x001b:
            r5.zzdmk = r6     // Catch:{ all -> 0x0060 }
            android.content.SharedPreferences$Editor r3 = r5.zzdva     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0034
            android.content.SharedPreferences$Editor r3 = r5.zzdva     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "app_settings_json"
            r3.putString(r4, r6)     // Catch:{ all -> 0x0060 }
            android.content.SharedPreferences$Editor r3 = r5.zzdva     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "app_settings_last_update_ms"
            r3.putLong(r4, r1)     // Catch:{ all -> 0x0060 }
            android.content.SharedPreferences$Editor r3 = r5.zzdva     // Catch:{ all -> 0x0060 }
            r3.apply()     // Catch:{ all -> 0x0060 }
        L_0x0034:
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x0060 }
            r3.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "app_settings_json"
            r3.putString(r4, r6)     // Catch:{ all -> 0x0060 }
            java.lang.String r6 = "app_settings_last_update_ms"
            r3.putLong(r6, r1)     // Catch:{ all -> 0x0060 }
            r5.zzc(r3)     // Catch:{ all -> 0x0060 }
            java.util.List<java.lang.Runnable> r6 = r5.zzdux     // Catch:{ all -> 0x0060 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0060 }
        L_0x004c:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x005c
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x0060 }
            java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ all -> 0x0060 }
            r1.run()     // Catch:{ all -> 0x0060 }
            goto L_0x004c
        L_0x005c:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x005e:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x0060:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxc.zzdv(java.lang.String):void");
    }

    public final zzawl zzvr() {
        zzawl zzawl;
        zzvy();
        synchronized (this.lock) {
            zzawl = new zzawl(this.zzdmk, this.zzdve);
        }
        return zzawl;
    }

    public final void zzb(Runnable runnable) {
        this.zzdux.add(runnable);
    }

    public final void zzfc(long j) {
        zzvy();
        synchronized (this.lock) {
            if (this.zzdvf != j) {
                this.zzdvf = j;
                if (this.zzdva != null) {
                    this.zzdva.putLong("app_last_background_time_ms", j);
                    this.zzdva.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("app_last_background_time_ms", j);
                zzc(bundle);
            }
        }
    }

    public final long zzvs() {
        long j;
        zzvy();
        synchronized (this.lock) {
            j = this.zzdvf;
        }
        return j;
    }

    public final void zzcu(int i) {
        zzvy();
        synchronized (this.lock) {
            if (this.zzdvh != i) {
                this.zzdvh = i;
                if (this.zzdva != null) {
                    this.zzdva.putInt("request_in_session_count", i);
                    this.zzdva.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("request_in_session_count", i);
                zzc(bundle);
            }
        }
    }

    public final int zzvt() {
        int i;
        zzvy();
        synchronized (this.lock) {
            i = this.zzdvh;
        }
        return i;
    }

    public final void zzfd(long j) {
        zzvy();
        synchronized (this.lock) {
            if (this.zzdvg != j) {
                this.zzdvg = j;
                if (this.zzdva != null) {
                    this.zzdva.putLong("first_ad_req_time_ms", j);
                    this.zzdva.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("first_ad_req_time_ms", j);
                zzc(bundle);
            }
        }
    }

    public final long zzvu() {
        long j;
        zzvy();
        synchronized (this.lock) {
            j = this.zzdvg;
        }
        return j;
    }

    public final void zzc(String str, String str2, boolean z) {
        zzvy();
        synchronized (this.lock) {
            JSONArray optJSONArray = this.zzdvk.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i = 0;
            while (true) {
                if (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        if (!str2.equals(optJSONObject.optString("template_id"))) {
                            i++;
                        } else if (!z || !optJSONObject.optBoolean("uses_media_view", false)) {
                            length = i;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzk.zzln().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.zzdvk.put(str, optJSONArray);
            } catch (JSONException e) {
                zzawz.zzd("Could not update native advanced settings", e);
            }
            if (this.zzdva != null) {
                this.zzdva.putString("native_advanced_settings", this.zzdvk.toString());
                this.zzdva.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", this.zzdvk.toString());
            zzc(bundle);
        }
    }

    public final JSONObject zzvv() {
        JSONObject jSONObject;
        zzvy();
        synchronized (this.lock) {
            jSONObject = this.zzdvk;
        }
        return jSONObject;
    }

    public final void zzvw() {
        zzvy();
        synchronized (this.lock) {
            this.zzdvk = new JSONObject();
            if (this.zzdva != null) {
                this.zzdva.remove("native_advanced_settings");
                this.zzdva.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", "{}");
            zzc(bundle);
        }
    }

    public final String zzvx() {
        String str;
        zzvy();
        synchronized (this.lock) {
            str = this.zzdvl;
        }
        return str;
    }

    public final void zzdw(String str) {
        zzvy();
        synchronized (this.lock) {
            if (!TextUtils.equals(this.zzdvl, str)) {
                this.zzdvl = str;
                if (this.zzdva != null) {
                    this.zzdva.putString("display_cutout", str);
                    this.zzdva.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putString("display_cutout", str);
                zzc(bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.lock) {
            this.zzckn = sharedPreferences;
            this.zzdva = edit;
            if (PlatformVersion.isAtLeastM() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                z = true;
            }
            this.zzdvb = z;
            this.zzdls = this.zzckn.getBoolean("use_https", this.zzdls);
            this.zzdnt = this.zzckn.getBoolean("content_url_opted_out", this.zzdnt);
            this.zzdvc = this.zzckn.getString("content_url_hashes", this.zzdvc);
            this.zzdmh = this.zzckn.getBoolean("auto_collect_location", this.zzdmh);
            this.zzdoe = this.zzckn.getBoolean("content_vertical_opted_out", this.zzdoe);
            this.zzdvd = this.zzckn.getString("content_vertical_hashes", this.zzdvd);
            this.zzdvi = this.zzckn.getInt("version_code", this.zzdvi);
            this.zzdmk = this.zzckn.getString("app_settings_json", this.zzdmk);
            this.zzdve = this.zzckn.getLong("app_settings_last_update_ms", this.zzdve);
            this.zzdvf = this.zzckn.getLong("app_last_background_time_ms", this.zzdvf);
            this.zzdvh = this.zzckn.getInt("request_in_session_count", this.zzdvh);
            this.zzdvg = this.zzckn.getLong("first_ad_req_time_ms", this.zzdvg);
            this.zzdvj = this.zzckn.getStringSet("never_pool_slots", this.zzdvj);
            this.zzdvl = this.zzckn.getString("display_cutout", this.zzdvl);
            try {
                this.zzdvk = new JSONObject(this.zzckn.getString("native_advanced_settings", "{}"));
            } catch (JSONException e) {
                zzawz.zzd("Could not convert native advanced settings to json object", e);
            }
            zzc(zzvz());
        }
    }
}
