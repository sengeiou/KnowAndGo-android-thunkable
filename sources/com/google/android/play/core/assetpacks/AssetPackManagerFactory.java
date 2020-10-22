package com.google.android.play.core.assetpacks;

import android.content.Context;
import androidx.annotation.NonNull;

public class AssetPackManagerFactory {
    @NonNull
    public static synchronized AssetPackManager getInstance(@NonNull Context context) {
        AssetPackManager a;
        synchronized (AssetPackManagerFactory.class) {
            a = C1924db.m468a(context).mo33338a();
        }
        return a;
    }
}
