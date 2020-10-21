package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AssetPackStates {
    /* renamed from: a */
    public static AssetPackStates m262a(long j, Map<String, AssetPackState> map) {
        return new C1877bi(j, map);
    }

    /* renamed from: a */
    public static AssetPackStates m263a(Bundle bundle, C1894bz bzVar) {
        return m265a(bundle, bzVar, (List<String>) new ArrayList());
    }

    /* renamed from: a */
    public static AssetPackStates m264a(Bundle bundle, C1894bz bzVar, C1867az azVar) {
        return m266a(bundle, bzVar, new ArrayList(), azVar);
    }

    /* renamed from: a */
    public static AssetPackStates m265a(Bundle bundle, C1894bz bzVar, List<String> list) {
        return m266a(bundle, bzVar, list, C1869ba.f393a);
    }

    /* renamed from: a */
    private static AssetPackStates m266a(Bundle bundle, C1894bz bzVar, List<String> list, C1867az azVar) {
        Bundle bundle2 = bundle;
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        HashMap hashMap = new HashMap();
        int size = stringArrayList.size();
        for (int i = 0; i < size; i++) {
            String str = stringArrayList.get(i);
            hashMap.put(str, AssetPackState.m260a(bundle, str, bzVar, azVar));
        }
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String str2 = list.get(i2);
            hashMap.put(str2, AssetPackState.m261a(str2, 4, 0, 0, 0, 0.0d));
        }
        return m262a(bundle.getLong("total_bytes_to_download"), (Map<String, AssetPackState>) hashMap);
    }

    public abstract Map<String, AssetPackState> packStates();

    public abstract long totalBytes();
}
