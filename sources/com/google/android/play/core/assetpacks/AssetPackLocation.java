package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import com.google.android.play.core.assetpacks.model.AssetPackStorageMethod;

public abstract class AssetPackLocation {

    /* renamed from: a */
    private static final AssetPackLocation f300a = new C1875bg(1, (String) null, (String) null);

    /* renamed from: a */
    static AssetPackLocation m258a() {
        return f300a;
    }

    /* renamed from: a */
    static AssetPackLocation m259a(String str, String str2) {
        return new C1875bg(0, str, str2);
    }

    @Nullable
    public abstract String assetsPath();

    @AssetPackStorageMethod
    public abstract int packStorageMethod();

    @Nullable
    public abstract String path();
}
