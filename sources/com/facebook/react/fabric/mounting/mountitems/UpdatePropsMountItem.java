package com.facebook.react.fabric.mounting.mountitems;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.mounting.MountingManager;

public class UpdatePropsMountItem implements MountItem {
    private final int mReactTag;
    @NonNull
    private final ReadableMap mUpdatedProps;

    public UpdatePropsMountItem(int i, @NonNull ReadableMap readableMap) {
        this.mReactTag = i;
        this.mUpdatedProps = readableMap;
    }

    public void execute(@NonNull MountingManager mountingManager) {
        mountingManager.updateProps(this.mReactTag, this.mUpdatedProps);
    }

    public String toString() {
        return "UpdatePropsMountItem [" + this.mReactTag + "]";
    }
}
