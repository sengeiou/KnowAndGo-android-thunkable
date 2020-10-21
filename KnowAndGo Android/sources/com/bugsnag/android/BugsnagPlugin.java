package com.bugsnag.android;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\tH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, mo39786d2 = {"Lcom/bugsnag/android/BugsnagPlugin;", "", "loaded", "", "getLoaded", "()Z", "setLoaded", "(Z)V", "loadPlugin", "", "client", "Lcom/bugsnag/android/Client;", "unloadPlugin", "bugsnag-android-core_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
/* compiled from: BugsnagPluginInterface.kt */
public interface BugsnagPlugin {
    boolean getLoaded();

    void loadPlugin(@NotNull Client client);

    void setLoaded(boolean z);

    void unloadPlugin();
}
