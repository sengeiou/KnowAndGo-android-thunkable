package com.uxcam.internals;

import android.content.Context;
import android.content.SharedPreferences;
import com.amplitude.api.AmplitudeClient;

/* renamed from: com.uxcam.internals.fs */
public final class C3175fs {

    /* renamed from: a */
    public SharedPreferences f2294a;

    public C3175fs(Context context) {
        this.f2294a = context.getSharedPreferences("UXCamPreferences", 0);
    }

    /* renamed from: a */
    public final String mo38463a(String str) {
        return this.f2294a.getString(str, (String) null);
    }

    /* renamed from: a */
    public final void mo38464a() {
        this.f2294a.edit().putInt("recorded_session_count", this.f2294a.getInt("recorded_session_count", 0) + 1).apply();
    }

    /* renamed from: a */
    public final void mo38465a(String str, int i) {
        this.f2294a.edit().putInt(str, i).apply();
    }

    /* renamed from: a */
    public final void mo38466a(String str, String str2) {
        this.f2294a.edit().putString(str, str2).apply();
    }

    /* renamed from: a */
    public final void mo38467a(boolean z) {
        this.f2294a.edit().putBoolean(AmplitudeClient.OPT_OUT_KEY, z).apply();
    }

    /* renamed from: b */
    public final void mo38468b(String str) {
        this.f2294a.edit().putBoolean("override_mobile_data_data_only_setting_".concat(String.valueOf(str)), true).apply();
    }

    /* renamed from: b */
    public final void mo38469b(boolean z) {
        this.f2294a.edit().putBoolean("opt_out_of_video_recording", z).apply();
    }

    /* renamed from: b */
    public final boolean mo38470b() {
        return this.f2294a.getBoolean(AmplitudeClient.OPT_OUT_KEY, false);
    }

    /* renamed from: c */
    public final boolean mo38471c() {
        return this.f2294a.getBoolean("opt_out_of_video_recording", false);
    }

    /* renamed from: c */
    public final boolean mo38472c(String str) {
        return this.f2294a.getBoolean("override_mobile_data_data_only_setting_".concat(String.valueOf(str)), false);
    }

    /* renamed from: d */
    public final int mo38473d(String str) {
        return this.f2294a.getInt(str, 0);
    }

    /* renamed from: d */
    public final void mo38474d() {
        this.f2294a.edit().putLong("mobile_data_used_size", 0).apply();
    }

    /* renamed from: e */
    public final long mo38475e() {
        return this.f2294a.getLong("mobile_data_used_size", 0);
    }
}
