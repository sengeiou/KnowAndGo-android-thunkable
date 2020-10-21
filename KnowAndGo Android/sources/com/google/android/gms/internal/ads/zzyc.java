package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzard
public final class zzyc {
    public static final zzyc zzche = new zzyc();

    @VisibleForTesting
    protected zzyc() {
    }

    public static zzxz zza(Context context, zzaaz zzaaz) {
        List list;
        Context context2;
        String str;
        zzaaz zzaaz2 = zzaaz;
        Date birthday = zzaaz.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = zzaaz.getContentUrl();
        int gender = zzaaz.getGender();
        Set<String> keywords = zzaaz.getKeywords();
        if (!keywords.isEmpty()) {
            list = Collections.unmodifiableList(new ArrayList(keywords));
            context2 = context;
        } else {
            context2 = context;
            list = null;
        }
        boolean isTestDevice = zzaaz2.isTestDevice(context2);
        int zzqc = zzaaz.zzqc();
        Location location = zzaaz.getLocation();
        Bundle networkExtrasBundle = zzaaz2.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = zzaaz.getManualImpressionsEnabled();
        String publisherProvidedId = zzaaz.getPublisherProvidedId();
        SearchAdRequest zzpz = zzaaz.zzpz();
        zzaca zzaca = zzpz != null ? new zzaca(zzpz) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzyt.zzpa();
            str = zzazt.zza(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        return new zzxz(8, time, networkExtrasBundle, gender, list, isTestDevice, zzqc, manualImpressionsEnabled, publisherProvidedId, zzaca, location, contentUrl, zzaaz.zzqb(), zzaaz.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzaaz.zzqd())), zzaaz.zzpy(), str, zzaaz.isDesignedForFamilies(), (zzxt) null, zzaaz.zzqe(), zzaaz.getMaxAdContentRating());
    }
}
