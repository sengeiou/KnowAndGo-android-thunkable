package org.unimodules.adapters.react.apploader;

import com.facebook.react.ReactInstanceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39786d2 = {"<anonymous>", "", "run"}, mo39787k = 3, mo39788mv = {1, 1, 15})
/* compiled from: RNHeadlessAppLoader.kt */
final class RNHeadlessAppLoader$invalidateApp$1 implements Runnable {
    final /* synthetic */ String $appId;
    final /* synthetic */ ReactInstanceManager $appRecord;

    RNHeadlessAppLoader$invalidateApp$1(ReactInstanceManager reactInstanceManager, String str) {
        this.$appRecord = reactInstanceManager;
        this.$appId = str;
    }

    public final void run() {
        this.$appRecord.destroy();
        HeadlessAppLoaderNotifier.INSTANCE.notifyAppDestroyed(this.$appId);
        Map access$getAppRecords$p = RNHeadlessAppLoaderKt.appRecords;
        String str = this.$appId;
        if (access$getAppRecords$p != null) {
            TypeIntrinsics.asMutableMap(access$getAppRecords$p).remove(str);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }
}
