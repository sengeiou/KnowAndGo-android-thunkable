package com.facebook.react.fabric.mounting.mountitems;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.facebook.react.fabric.mounting.MountingManager;

public interface MountItem {
    @UiThread
    void execute(@NonNull MountingManager mountingManager);
}
