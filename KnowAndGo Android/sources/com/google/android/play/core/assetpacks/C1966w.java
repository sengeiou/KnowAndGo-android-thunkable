package com.google.android.play.core.assetpacks;

import android.os.ParcelFileDescriptor;
import com.google.android.play.core.tasks.Task;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.w */
interface C1966w {
    /* renamed from: a */
    Task<AssetPackStates> mo33353a(List<String> list, C1867az azVar, Map<String, Long> map);

    /* renamed from: a */
    Task<AssetPackStates> mo33354a(List<String> list, List<String> list2, Map<String, Long> map);

    /* renamed from: a */
    Task<List<String>> mo33355a(Map<String, Long> map);

    /* renamed from: a */
    void mo33356a();

    /* renamed from: a */
    void mo33357a(int i);

    /* renamed from: a */
    void mo33358a(int i, String str);

    /* renamed from: a */
    void mo33359a(int i, String str, String str2, int i2);

    /* renamed from: a */
    void mo33360a(String str);

    /* renamed from: a */
    void mo33361a(List<String> list);

    /* renamed from: b */
    Task<ParcelFileDescriptor> mo33362b(int i, String str, String str2, int i2);
}
