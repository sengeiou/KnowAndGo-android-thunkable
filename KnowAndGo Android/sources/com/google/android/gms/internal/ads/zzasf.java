package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;

public final class zzasf {
    private float zzbtx;
    private int zzdlt;
    private int zzdlu;
    private int zzdpe;
    private boolean zzdpf;
    private boolean zzdpg;
    private String zzdph;
    private String zzdpi;
    private boolean zzdpj;
    private final boolean zzdpk;
    private boolean zzdpl;
    private boolean zzdpm;
    private boolean zzdpn;
    private String zzdpo;
    private String zzdpp;
    private String zzdpq;
    private int zzdpr;
    private int zzdps;
    private int zzdpt;
    private int zzdpu;
    private int zzdpv;
    private int zzdpw;
    private double zzdpx;
    private boolean zzdpy;
    private boolean zzdpz;
    private int zzdqa;
    private String zzdqb;
    private String zzdqc;
    private boolean zzdqd;

    public zzasf(Context context) {
        DisplayMetrics displayMetrics;
        PackageManager packageManager = context.getPackageManager();
        zzp(context);
        zzq(context);
        zzr(context);
        Locale locale = Locale.getDefault();
        boolean z = false;
        this.zzdpf = zza(packageManager, "geo:0,0?q=donuts") != null;
        this.zzdpg = zza(packageManager, "http://www.google.com") != null ? true : z;
        this.zzdpi = locale.getCountry();
        zzyt.zzpa();
        this.zzdpj = zzazt.zzwx();
        this.zzdpk = DeviceProperties.isLatchsky(context);
        this.zzdpl = DeviceProperties.isSidewinder(context);
        this.zzdpo = locale.getLanguage();
        this.zzdpp = zza(context, packageManager);
        this.zzdpq = zzs(context);
        Resources resources = context.getResources();
        if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            this.zzbtx = displayMetrics.density;
            this.zzdlt = displayMetrics.widthPixels;
            this.zzdlu = displayMetrics.heightPixels;
        }
    }

    public zzasf(Context context, zzase zzase) {
        zzp(context);
        zzq(context);
        zzr(context);
        this.zzdqb = Build.FINGERPRINT;
        this.zzdqc = Build.DEVICE;
        this.zzdqd = PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzads.zzj(context);
        this.zzdpf = zzase.zzdpf;
        this.zzdpg = zzase.zzdpg;
        this.zzdpi = zzase.zzdpi;
        this.zzdpj = zzase.zzdpj;
        this.zzdpk = zzase.zzdpk;
        this.zzdpl = zzase.zzdpl;
        this.zzdpo = zzase.zzdpo;
        this.zzdpp = zzase.zzdpp;
        this.zzdpq = zzase.zzdpq;
        this.zzbtx = zzase.zzbtx;
        this.zzdlt = zzase.zzdlt;
        this.zzdlu = zzase.zzdlu;
    }

    private final void zzp(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager != null) {
            try {
                this.zzdpe = audioManager.getMode();
                this.zzdpm = audioManager.isMusicActive();
                this.zzdpn = audioManager.isSpeakerphoneOn();
                this.zzdpr = audioManager.getStreamVolume(3);
                this.zzdpv = audioManager.getRingerMode();
                this.zzdpw = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                zzk.zzlk().zza(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zzdpe = -2;
        this.zzdpm = false;
        this.zzdpn = false;
        this.zzdpr = 0;
        this.zzdpv = 2;
        this.zzdpw = 0;
    }

    @TargetApi(16)
    private final void zzq(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.zzdph = telephonyManager.getNetworkOperator();
        this.zzdpt = telephonyManager.getNetworkType();
        this.zzdpu = telephonyManager.getPhoneType();
        this.zzdps = -2;
        this.zzdpz = false;
        this.zzdqa = -1;
        zzk.zzlg();
        if (zzaxi.zzp(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.zzdps = activeNetworkInfo.getType();
                this.zzdqa = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                this.zzdps = -1;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.zzdpz = connectivityManager.isActiveNetworkMetered();
            }
        }
    }

    private final void zzr(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.zzdpx = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
            this.zzdpy = z;
            return;
        }
        this.zzdpx = -1.0d;
        this.zzdpy = false;
    }

    private static String zzs(Context context) {
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.vending", 128);
            if (packageInfo == null) {
                return null;
            }
            int i = packageInfo.versionCode;
            String str = packageInfo.packageName;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
            sb.append(i);
            sb.append(".");
            sb.append(str);
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private static String zza(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null || (activityInfo = zza.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo == null) {
                return null;
            }
            int i = packageInfo.versionCode;
            String str = activityInfo.packageName;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
            sb.append(i);
            sb.append(".");
            sb.append(str);
            return sb.toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            zzk.zzlk().zza(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    public final zzase zzty() {
        return new zzase(this.zzdpe, this.zzdpf, this.zzdpg, this.zzdph, this.zzdpi, this.zzdpj, this.zzdpk, this.zzdpl, this.zzdpm, this.zzdpn, this.zzdpo, this.zzdpp, this.zzdpq, this.zzdpr, this.zzdps, this.zzdpt, this.zzdpu, this.zzdpv, this.zzdpw, this.zzbtx, this.zzdlt, this.zzdlu, this.zzdpx, this.zzdpy, this.zzdpz, this.zzdqa, this.zzdqb, this.zzdqd, this.zzdqc);
    }
}
