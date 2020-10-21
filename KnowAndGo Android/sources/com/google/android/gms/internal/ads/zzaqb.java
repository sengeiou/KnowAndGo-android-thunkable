package com.google.android.gms.internal.ads;

import com.facebook.react.uimanager.ViewProps;
import com.onesignal.OneSignalDbContract;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
public class zzaqb {
    private final zzbgz zzdbs;
    private final String zzdjd;

    public zzaqb(zzbgz zzbgz) {
        this(zzbgz, "");
    }

    public zzaqb(zzbgz zzbgz, String str) {
        this.zzdbs = zzbgz;
        this.zzdjd = str;
    }

    public final void zzdh(String str) {
        try {
            JSONObject put = new JSONObject().put(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, str).put("action", this.zzdjd);
            if (this.zzdbs != null) {
                this.zzdbs.zza("onError", put);
            }
        } catch (JSONException e) {
            zzawz.zzc("Error occurred while dispatching error event.", e);
        }
    }

    public final void zzdi(String str) {
        try {
            this.zzdbs.zza("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzawz.zzc("Error occured while dispatching ready Event.", e);
        }
    }

    public final void zza(int i, int i2, int i3, int i4) {
        try {
            this.zzdbs.zza("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzawz.zzc("Error occured while dispatching size change.", e);
        }
    }

    public final void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzdbs.zza("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzawz.zzc("Error occured while dispatching default position.", e);
        }
    }

    public final void zzdj(String str) {
        try {
            this.zzdbs.zza("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzawz.zzc("Error occured while dispatching state change.", e);
        }
    }

    public final void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zzdbs.zza("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put(ViewProps.ROTATION, i5));
        } catch (JSONException e) {
            zzawz.zzc("Error occured while obtaining screen information.", e);
        }
    }
}
