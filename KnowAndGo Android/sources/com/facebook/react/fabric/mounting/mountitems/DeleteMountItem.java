package com.facebook.react.fabric.mounting.mountitems;

import androidx.annotation.NonNull;
import com.facebook.react.fabric.mounting.MountingManager;

public class DeleteMountItem implements MountItem {
    private int mReactTag;

    public DeleteMountItem(int i) {
        this.mReactTag = i;
    }

    public void execute(@NonNull MountingManager mountingManager) {
        mountingManager.deleteView(this.mReactTag);
    }

    public String toString() {
        return "DeleteMountItem [" + this.mReactTag + "]";
    }
}
