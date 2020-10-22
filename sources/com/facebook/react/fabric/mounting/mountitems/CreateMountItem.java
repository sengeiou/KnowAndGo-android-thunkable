package com.facebook.react.fabric.mounting.mountitems;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;

public class CreateMountItem implements MountItem {
    @NonNull
    private final String mComponent;
    @NonNull
    private final ThemedReactContext mContext;
    private final boolean mIsLayoutable;
    @Nullable
    private final ReadableMap mProps;
    private final int mReactTag;
    private final int mRootTag;
    @Nullable
    private final StateWrapper mStateWrapper;

    public CreateMountItem(@NonNull ThemedReactContext themedReactContext, int i, int i2, @NonNull String str, @Nullable ReadableMap readableMap, @NonNull StateWrapper stateWrapper, boolean z) {
        this.mContext = themedReactContext;
        this.mComponent = str;
        this.mRootTag = i;
        this.mReactTag = i2;
        this.mProps = readableMap;
        this.mStateWrapper = stateWrapper;
        this.mIsLayoutable = z;
    }

    public void execute(@NonNull MountingManager mountingManager) {
        mountingManager.createView(this.mContext, this.mComponent, this.mReactTag, this.mProps, this.mStateWrapper, this.mIsLayoutable);
    }

    public String toString() {
        return "CreateMountItem [" + this.mReactTag + "] - component: " + this.mComponent + " - rootTag: " + this.mRootTag + " - isLayoutable: " + this.mIsLayoutable;
    }
}
