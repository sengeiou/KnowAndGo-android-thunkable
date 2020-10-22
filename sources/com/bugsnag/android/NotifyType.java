package com.bugsnag.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public enum NotifyType {
    ALL(1),
    USER(2),
    APP(3),
    DEVICE(4),
    CONTEXT(5),
    RELEASE_STAGES(6),
    FILTERS(7),
    BREADCRUMB(8),
    META(9);
    
    private final Integer intValue;

    private NotifyType(Integer num) {
        this.intValue = num;
    }

    @NonNull
    public Integer getValue() {
        return this.intValue;
    }

    @Nullable
    public static NotifyType fromInt(@Nullable Integer num) {
        if (num == null) {
            return null;
        }
        for (NotifyType notifyType : values()) {
            if (num.equals(notifyType.getValue())) {
                return notifyType;
            }
        }
        return null;
    }
}
