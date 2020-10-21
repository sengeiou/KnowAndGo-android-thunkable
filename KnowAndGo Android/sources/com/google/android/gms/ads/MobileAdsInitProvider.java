package com.google.android.gms.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.internal.ads.zzabh;

@KeepForSdkWithMembers
public class MobileAdsInitProvider extends ContentProvider {
    private final zzabh zzaau = new zzabh();

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.zzaau.attachInfo(context, providerInfo);
    }

    public boolean onCreate() {
        return this.zzaau.onCreate();
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.zzaau.query(uri, strArr, str, strArr2, str2);
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return this.zzaau.getType(uri);
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        return this.zzaau.insert(uri, contentValues);
    }

    public int delete(@NonNull Uri uri, String str, String[] strArr) {
        return this.zzaau.delete(uri, str, strArr);
    }

    public int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.zzaau.update(uri, contentValues, str, strArr);
    }
}
