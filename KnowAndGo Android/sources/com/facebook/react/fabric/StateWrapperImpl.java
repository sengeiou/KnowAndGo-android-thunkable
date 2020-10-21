package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.StateWrapper;

@SuppressLint({"MissingNativeLoadLibrary"})
public class StateWrapperImpl implements StateWrapper {
    @DoNotStrip
    private final HybridData mHybridData = initHybrid();

    private static native HybridData initHybrid();

    public native ReadableNativeMap getState();

    public native void updateStateImpl(@NonNull NativeMap nativeMap);

    static {
        FabricSoLoader.staticInit();
    }

    private StateWrapperImpl() {
    }

    public void updateState(@NonNull WritableMap writableMap) {
        updateStateImpl((NativeMap) writableMap);
    }
}
