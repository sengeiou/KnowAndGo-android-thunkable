package com.facebook.react.fabric.mounting.mountitems;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.mounting.MountingManager;

public class UpdateLocalDataMountItem implements MountItem {
    @NonNull
    private final ReadableMap mNewLocalData;
    private final int mReactTag;

    public UpdateLocalDataMountItem(int i, @NonNull ReadableMap readableMap) {
        this.mReactTag = i;
        this.mNewLocalData = readableMap;
    }

    public void execute(@NonNull MountingManager mountingManager) {
        mountingManager.updateLocalData(this.mReactTag, this.mNewLocalData);
    }

    @NonNull
    public ReadableMap getNewLocalData() {
        return this.mNewLocalData;
    }

    public String toString() {
        return "UpdateLocalDataMountItem [" + this.mReactTag + "]";
    }
}
