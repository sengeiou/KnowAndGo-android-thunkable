package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
@zzard
public final class zzacr implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Object lock = new Object();
    private Bundle metaData = new Bundle();
    private final ConditionVariable zzckl = new ConditionVariable();
    @VisibleForTesting
    private volatile boolean zzckm = false;
    /* access modifiers changed from: private */
    @Nullable
    public SharedPreferences zzckn = null;
    private Context zzcko;
    private JSONObject zzckp = new JSONObject();
    private volatile boolean zzxs = false;

    public final void initialize(Context context) {
        if (!this.zzxs) {
            synchronized (this.lock) {
                if (!this.zzxs) {
                    if (!this.zzckm) {
                        this.zzckm = true;
                    }
                    this.zzcko = context.getApplicationContext() == null ? context : context.getApplicationContext();
                    try {
                        this.metaData = Wrappers.packageManager(this.zzcko).getApplicationInfo(this.zzcko.getPackageName(), 128).metaData;
                    } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                    }
                    try {
                        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                        if (remoteContext == null && context != null && (remoteContext = context.getApplicationContext()) == null) {
                            remoteContext = context;
                        }
                        if (remoteContext != null) {
                            zzyt.zzpc();
                            this.zzckn = remoteContext.getSharedPreferences("google_ads_flags", 0);
                            if (this.zzckn != null) {
                                this.zzckn.registerOnSharedPreferenceChangeListener(this);
                            }
                            zzqp();
                            this.zzxs = true;
                            this.zzckm = false;
                            this.zzckl.open();
                        }
                    } finally {
                        this.zzckm = false;
                        this.zzckl.open();
                    }
                }
            }
        }
    }

    public final <T> T zzd(zzacj<T> zzacj) {
        if (!this.zzckl.block(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS)) {
            synchronized (this.lock) {
                if (!this.zzckm) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzxs || this.zzckn == null) {
            synchronized (this.lock) {
                if (this.zzxs) {
                    if (this.zzckn == null) {
                    }
                }
                T zzqm = zzacj.zzqm();
                return zzqm;
            }
        }
        if (zzacj.getSource() == 2) {
            if (this.metaData == null) {
                return zzacj.zzqm();
            }
            return zzacj.zza(this.metaData);
        } else if (zzacj.getSource() != 1 || !this.zzckp.has(zzacj.getKey())) {
            return zzazl.zza(this.zzcko, new zzact(this, zzacj));
        } else {
            return zzacj.zza(this.zzckp);
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzqp();
        }
    }

    private final void zzqp() {
        if (this.zzckn != null) {
            try {
                this.zzckp = new JSONObject((String) zzazl.zza(this.zzcko, new zzacs(this)));
            } catch (JSONException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzqq() throws Exception {
        return this.zzckn.getString("flag_configuration", "{}");
    }
}
