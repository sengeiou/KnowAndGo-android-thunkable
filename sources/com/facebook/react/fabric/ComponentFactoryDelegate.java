package com.facebook.react.fabric;

import androidx.annotation.NonNull;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class ComponentFactoryDelegate {
    @DoNotStrip
    @NonNull
    private final HybridData mHybridData = initHybrid();

    @DoNotStrip
    private static native HybridData initHybrid();

    static {
        FabricSoLoader.staticInit();
    }
}
