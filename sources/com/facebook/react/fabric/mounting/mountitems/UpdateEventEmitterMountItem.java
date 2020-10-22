package com.facebook.react.fabric.mounting.mountitems;

import androidx.annotation.NonNull;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;

public class UpdateEventEmitterMountItem implements MountItem {
    @NonNull
    private final EventEmitterWrapper mEventHandler;
    private final int mReactTag;

    public UpdateEventEmitterMountItem(int i, @NonNull EventEmitterWrapper eventEmitterWrapper) {
        this.mReactTag = i;
        this.mEventHandler = eventEmitterWrapper;
    }

    public void execute(@NonNull MountingManager mountingManager) {
        mountingManager.updateEventEmitter(this.mReactTag, this.mEventHandler);
    }

    public String toString() {
        return "UpdateEventEmitterMountItem [" + this.mReactTag + "]";
    }
}
