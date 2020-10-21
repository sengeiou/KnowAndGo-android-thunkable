package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class zzcmn<AdT> implements zzcjv<AdT> {
    /* access modifiers changed from: protected */
    public abstract zzbbh<AdT> zza(zzcxv zzcxv, Bundle bundle);

    public final boolean zza(zzcxu zzcxu, zzcxm zzcxm) {
        return !TextUtils.isEmpty(zzcxm.zzgkh.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    public final zzbbh<AdT> zzb(zzcxu zzcxu, zzcxm zzcxm) {
        zzcxm zzcxm2 = zzcxm;
        String optString = zzcxm2.zzgkh.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzcxv zzcxv = zzcxu.zzgkx.zzfjp;
        zzcxx zzft = new zzcxx().zzg(zzcxv.zzghg).zzd(zzcxv.zzdll).zzd(zzcxv.zzgkz).zzft(zzcxv.zzglb).zzc(zzcxv.zzgla).zzb(zzcxv.zzglc).zzc(zzcxv.zzgld).zzb(zzcxv.zzdgs).zzfu(zzcxv.zzgle).zzb(zzcxv.zzglh).zzfv(zzcxv.zzglf).zzft(optString);
        Bundle zzm = zzm(zzcxv.zzghg.zzcgv);
        Bundle zzm2 = zzm(zzm.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzm2.putInt("gw", 1);
        String optString2 = zzcxm2.zzgkh.optString("mad_hac", (String) null);
        if (optString2 != null) {
            zzm2.putString("mad_hac", optString2);
        }
        String optString3 = zzcxm2.zzgkh.optString("adJson", (String) null);
        if (optString3 != null) {
            zzm2.putString("_ad", optString3);
        }
        zzm2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzcxm2.zzgkk.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzcxm2.zzgkk.optString(next, (String) null);
            if (next != null) {
                zzm2.putString(next, optString4);
            }
        }
        zzm.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzm2);
        zzxz zzxz = r5;
        zzxz zzxz2 = new zzxz(zzcxv.zzghg.versionCode, zzcxv.zzghg.zzcgn, zzm2, zzcxv.zzghg.zzcgo, zzcxv.zzghg.zzcgp, zzcxv.zzghg.zzcgq, zzcxv.zzghg.zzcgr, zzcxv.zzghg.zzbqn, zzcxv.zzghg.zzcgs, zzcxv.zzghg.zzcgt, zzcxv.zzghg.zzmw, zzcxv.zzghg.zzcgu, zzm, zzcxv.zzghg.zzcgw, zzcxv.zzghg.zzcgx, zzcxv.zzghg.zzcgy, zzcxv.zzghg.zzcgz, zzcxv.zzghg.zzcha, zzcxv.zzghg.zzchb, zzcxv.zzghg.zzchc, zzcxv.zzghg.zzchd);
        zzcxv zzamq = zzft.zzg(zzxz).zzamq();
        Bundle bundle = new Bundle();
        zzcxu zzcxu2 = zzcxu;
        zzcxo zzcxo = zzcxu2.zzgky.zzgku;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList(zzcxo.zzdfh));
        bundle2.putInt("refresh_interval", zzcxo.zzgkr);
        bundle2.putString("gws_query_id", zzcxo.zzcep);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzcxu2.zzgkx.zzfjp.zzglb;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        zzcxm zzcxm3 = zzcxm;
        bundle3.putString("allocation_id", zzcxm3.zzdej);
        bundle3.putStringArrayList("click_urls", new ArrayList(zzcxm3.zzdfe));
        bundle3.putStringArrayList("imp_urls", new ArrayList(zzcxm3.zzdff));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList(zzcxm3.zzdnl));
        bundle3.putStringArrayList("fill_urls", new ArrayList(zzcxm3.zzgkc));
        bundle3.putStringArrayList("video_start_urls", new ArrayList(zzcxm3.zzdny));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList(zzcxm3.zzdnz));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList(zzcxm3.zzgkb));
        bundle3.putString("transaction_id", zzcxm3.zzdeu);
        bundle3.putString("valid_from_timestamp", zzcxm3.zzdev);
        bundle3.putBoolean("is_closable_area_disabled", zzcxm3.zzbrm);
        if (zzcxm3.zzdnx != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzcxm3.zzdnx.zzdqm);
            bundle4.putString("rb_type", zzcxm3.zzdnx.type);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zza(zzamq, bundle);
    }

    private static Bundle zzm(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }
}
