package com.facebook.react.fabric.mounting.mountitems;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.uimanager.StateWrapper;

public class UpdateStateMountItem implements MountItem {
    private final int mReactTag;
    @Nullable
    private final StateWrapper mStateWrapper;

    public UpdateStateMountItem(int i, @Nullable StateWrapper stateWrapper) {
        this.mReactTag = i;
        this.mStateWrapper = stateWrapper;
    }

    public void execute(@NonNull MountingManager mountingManager) {
        mountingManager.updateState(this.mReactTag, this.mStateWrapper);
    }

    public String toString() {
        return "UpdateStateMountItem [" + this.mReactTag + "]";
    }
}
