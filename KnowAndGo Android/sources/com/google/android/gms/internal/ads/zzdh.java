package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

public final class zzdh {
    private static final String[] zzwo = {"/aclk", "/pcs/click", "/dbm/clk"};
    private String zzwk = "googleads.g.doubleclick.net";
    private String zzwl = "/pagead/ads";
    private String zzwm = "ad.doubleclick.net";
    private String[] zzwn = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzdc zzwp;

    public zzdh(zzdc zzdc) {
        this.zzwp = zzdc;
    }

    public final void zzb(String str, String str2) {
        this.zzwk = str;
        this.zzwl = str2;
    }

    public final boolean zza(Uri uri) {
        if (uri != null) {
            try {
                if (!uri.getHost().equals(this.zzwk) || !uri.getPath().equals(this.zzwl)) {
                    return false;
                }
                return true;
            } catch (NullPointerException unused) {
                return false;
            }
        } else {
            throw new NullPointerException();
        }
    }

    private final boolean zzb(Uri uri) {
        if (uri != null) {
            try {
                return uri.getHost().equals(this.zzwm);
            } catch (NullPointerException unused) {
                return false;
            }
        } else {
            throw new NullPointerException();
        }
    }

    public final boolean zzc(Uri uri) {
        if (uri != null) {
            try {
                String host = uri.getHost();
                for (String endsWith : this.zzwn) {
                    if (host.endsWith(endsWith)) {
                        return true;
                    }
                }
                return false;
            } catch (NullPointerException unused) {
                return false;
            }
        } else {
            throw new NullPointerException();
        }
    }

    public final void zzam(String str) {
        this.zzwn = str.split(",");
    }

    public final zzdc zzcg() {
        return this.zzwp;
    }

    public final Uri zza(Uri uri, Context context) throws zzdi {
        return zza(uri, context, (String) null, false, (View) null, (Activity) null);
    }

    public final void zza(MotionEvent motionEvent) {
        this.zzwp.zza(motionEvent);
    }

    public final Uri zza(Uri uri, Context context, View view, Activity activity) throws zzdi {
        try {
            return zza(uri, context, uri.getQueryParameter("ai"), true, view, activity);
        } catch (UnsupportedOperationException unused) {
            throw new zzdi("Provided Uri is not in a valid state");
        }
    }

    public final boolean zzd(Uri uri) {
        if (zzc(uri)) {
            for (String endsWith : zzwo) {
                if (uri.getPath().endsWith(endsWith)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final Uri zza(Uri uri, Context context, String str, boolean z, View view, Activity activity) throws zzdi {
        String str2;
        try {
            boolean zzb = zzb(uri);
            if (zzb) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzdi("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzdi("Query parameter already exists: ms");
            }
            if (z) {
                str2 = this.zzwp.zza(context, str, view, activity);
            } else {
                str2 = this.zzwp.zza(context);
            }
            if (zzb) {
                String uri2 = uri.toString();
                int indexOf = uri2.indexOf(";adurl");
                if (indexOf != -1) {
                    int i = indexOf + 1;
                    return Uri.parse(uri2.substring(0, i) + "dc_ms" + "=" + str2 + ";" + uri2.substring(i));
                }
                String encodedPath = uri.getEncodedPath();
                int indexOf2 = uri2.indexOf(encodedPath);
                return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";" + "dc_ms" + "=" + str2 + ";" + uri2.substring(indexOf2 + encodedPath.length()));
            }
            String uri3 = uri.toString();
            int indexOf3 = uri3.indexOf("&adurl");
            if (indexOf3 == -1) {
                indexOf3 = uri3.indexOf("?adurl");
            }
            if (indexOf3 == -1) {
                return uri.buildUpon().appendQueryParameter("ms", str2).build();
            }
            int i2 = indexOf3 + 1;
            return Uri.parse(uri3.substring(0, i2) + "ms" + "=" + str2 + "&" + uri3.substring(i2));
        } catch (UnsupportedOperationException unused) {
            throw new zzdi("Provided Uri is not in a valid state");
        }
    }
}
