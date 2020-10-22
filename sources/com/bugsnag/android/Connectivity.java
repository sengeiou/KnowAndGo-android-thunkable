package com.bugsnag.android;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, mo39786d2 = {"Lcom/bugsnag/android/Connectivity;", "", "hasNetworkConnection", "", "registerForNetworkChanges", "", "retrieveNetworkAccessState", "", "unregisterForNetworkChanges", "bugsnag-android-core_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
/* compiled from: ConnectivityCompat.kt */
public interface Connectivity {
    boolean hasNetworkConnection();

    void registerForNetworkChanges();

    @NotNull
    String retrieveNetworkAccessState();

    void unregisterForNetworkChanges();
}
