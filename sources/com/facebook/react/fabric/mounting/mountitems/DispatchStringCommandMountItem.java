package com.facebook.react.fabric.mounting.mountitems;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.fabric.mounting.MountingManager;

public class DispatchStringCommandMountItem implements MountItem {
    @Nullable
    private final ReadableArray mCommandArgs;
    @NonNull
    private final String mCommandId;
    private final int mReactTag;

    public DispatchStringCommandMountItem(int i, @NonNull String str, @Nullable ReadableArray readableArray) {
        this.mReactTag = i;
        this.mCommandId = str;
        this.mCommandArgs = readableArray;
    }

    public void execute(@NonNull MountingManager mountingManager) {
        mountingManager.receiveCommand(this.mReactTag, this.mCommandId, this.mCommandArgs);
    }

    public String toString() {
        return "DispatchStringCommandMountItem [" + this.mReactTag + "] " + this.mCommandId;
    }
}
