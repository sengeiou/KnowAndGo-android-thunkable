package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

final class zzazo implements Callable<String> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ Context zzdyc;

    zzazo(zzazm zzazm, Context context, Context context2) {
        this.zzdyc = context;
        this.val$context = context2;
    }

    public final /* synthetic */ Object call() throws Exception {
        SharedPreferences sharedPreferences;
        boolean z = false;
        if (this.zzdyc != null) {
            zzawz.zzds("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.zzdyc.getSharedPreferences("admob_user_agent", 0);
        } else {
            zzawz.zzds("Attempting to read user agent from local cache.");
            sharedPreferences = this.val$context.getSharedPreferences("admob_user_agent", 0);
            z = true;
        }
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zzawz.zzds("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.val$context);
            if (z) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zzawz.zzds("Persisting user agent.");
            }
        }
        return string;
    }
}
