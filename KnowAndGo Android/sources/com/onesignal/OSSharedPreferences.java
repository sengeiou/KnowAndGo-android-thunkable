package com.onesignal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Set;

public interface OSSharedPreferences {
    boolean getBool(String str, String str2, boolean z);

    int getInt(String str, String str2, int i);

    long getLong(String str, String str2, long j);

    Object getObject(String str, String str2, Object obj);

    String getOutcomesV2KeyName();

    String getPreferencesName();

    String getString(String str, String str2, String str3);

    @Nullable
    Set<String> getStringSet(@NonNull String str, @NonNull String str2, @Nullable Set<String> set);

    void saveBool(String str, String str2, boolean z);

    void saveInt(String str, String str2, int i);

    void saveLong(String str, String str2, long j);

    void saveObject(String str, String str2, Object obj);

    void saveString(String str, String str2, String str3);

    void saveStringSet(@NonNull String str, @NonNull String str2, @NonNull Set<String> set);
}
