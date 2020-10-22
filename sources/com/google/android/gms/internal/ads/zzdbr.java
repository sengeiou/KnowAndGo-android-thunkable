package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import com.google.android.gms.internal.ads.zzdha;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdbr implements zzdbv {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final InputStream zzapv;
    private final JSONObject zzgpb;
    private boolean zzgpc = false;

    private zzdbr(InputStream inputStream) {
        this.zzapv = inputStream;
        this.zzgpb = null;
    }

    public static zzdbv zzf(InputStream inputStream) throws IOException {
        return new zzdbr(inputStream);
    }

    public final zzdha zzanq() throws IOException {
        zzdgu zzdgu;
        zzdhm zzdhm;
        zzdgr.zzb zzb;
        try {
            JSONObject jSONObject = new JSONObject(new String(zzdch.zzg(this.zzapv), UTF_8));
            if (!jSONObject.has("key") || jSONObject.getJSONArray("key").length() == 0) {
                throw new JSONException("invalid keyset");
            }
            zzdha.zza zzask = zzdha.zzask();
            if (jSONObject.has("primaryKeyId")) {
                zzask.zzes(jSONObject.getInt("primaryKeyId"));
            }
            JSONArray jSONArray = jSONObject.getJSONArray("key");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (!jSONObject2.has("keyData") || !jSONObject2.has("status") || !jSONObject2.has("keyId") || !jSONObject2.has("outputPrefixType")) {
                    throw new JSONException("invalid key");
                }
                zzdha.zzb.zza zzasq = zzdha.zzb.zzasq();
                String string = jSONObject2.getString("status");
                if (string.equals("ENABLED")) {
                    zzdgu = zzdgu.ENABLED;
                } else if (string.equals("DISABLED")) {
                    zzdgu = zzdgu.DISABLED;
                } else {
                    String valueOf = String.valueOf(string);
                    throw new JSONException(valueOf.length() != 0 ? "unknown status: ".concat(valueOf) : new String("unknown status: "));
                }
                zzdha.zzb.zza zzeu = zzasq.zzb(zzdgu).zzeu(jSONObject2.getInt("keyId"));
                String string2 = jSONObject2.getString("outputPrefixType");
                if (string2.equals("TINK")) {
                    zzdhm = zzdhm.TINK;
                } else if (string2.equals("RAW")) {
                    zzdhm = zzdhm.RAW;
                } else if (string2.equals("LEGACY")) {
                    zzdhm = zzdhm.LEGACY;
                } else if (string2.equals("CRUNCHY")) {
                    zzdhm = zzdhm.CRUNCHY;
                } else {
                    String valueOf2 = String.valueOf(string2);
                    throw new JSONException(valueOf2.length() != 0 ? "unknown output prefix type: ".concat(valueOf2) : new String("unknown output prefix type: "));
                }
                zzdha.zzb.zza zzb2 = zzeu.zzb(zzdhm);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("keyData");
                if (!jSONObject3.has("typeUrl") || !jSONObject3.has("value") || !jSONObject3.has("keyMaterialType")) {
                    throw new JSONException("invalid keyData");
                }
                zzdgr.zza zzbo = zzdgr.zzarw().zzgk(jSONObject3.getString("typeUrl")).zzbo(zzdmr.zzz(zzdjp.decode(jSONObject3.getString("value"))));
                String string3 = jSONObject3.getString("keyMaterialType");
                if (string3.equals("SYMMETRIC")) {
                    zzb = zzdgr.zzb.SYMMETRIC;
                } else if (string3.equals("ASYMMETRIC_PRIVATE")) {
                    zzb = zzdgr.zzb.ASYMMETRIC_PRIVATE;
                } else if (string3.equals("ASYMMETRIC_PUBLIC")) {
                    zzb = zzdgr.zzb.ASYMMETRIC_PUBLIC;
                } else if (string3.equals("REMOTE")) {
                    zzb = zzdgr.zzb.REMOTE;
                } else {
                    String valueOf3 = String.valueOf(string3);
                    throw new JSONException(valueOf3.length() != 0 ? "unknown key material type: ".concat(valueOf3) : new String("unknown key material type: "));
                }
                zzask.zzb((zzdha.zzb) ((zzdob) zzb2.zzb((zzdgr) ((zzdob) zzbo.zzb(zzb).zzaya())).zzaya()));
            }
            return (zzdha) ((zzdob) zzask.zzaya());
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }
}
