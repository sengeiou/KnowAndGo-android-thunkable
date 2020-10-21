package com.facebook.react.fabric.mounting.mountitems;

import android.annotation.TargetApi;
import androidx.annotation.NonNull;
import com.facebook.react.fabric.mounting.MountingManager;

public class UpdateLayoutMountItem implements MountItem {
    private final int mHeight;
    private final int mLayoutDirection;
    private final int mReactTag;
    private final int mWidth;

    /* renamed from: mX */
    private final int f111mX;

    /* renamed from: mY */
    private final int f112mY;

    public UpdateLayoutMountItem(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mReactTag = i;
        this.f111mX = i2;
        this.f112mY = i3;
        this.mWidth = i4;
        this.mHeight = i5;
        this.mLayoutDirection = convertLayoutDirection(i6);
    }

    @TargetApi(19)
    private static int convertLayoutDirection(int i) {
        switch (i) {
            case 0:
                return 2;
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                throw new IllegalArgumentException("Unsupported layout direction: " + i);
        }
    }

    public void execute(@NonNull MountingManager mountingManager) {
        mountingManager.updateLayout(this.mReactTag, this.f111mX, this.f112mY, this.mWidth, this.mHeight);
    }

    public int getX() {
        return this.f111mX;
    }

    public int getY() {
        return this.f112mY;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getLayoutDirection() {
        return this.mLayoutDirection;
    }

    public String toString() {
        return "UpdateLayoutMountItem [" + this.mReactTag + "] - x: " + this.f111mX + " - y: " + this.f112mY + " - height: " + this.mHeight + " - width: " + this.mWidth + " - layoutDirection: " + this.mLayoutDirection;
    }
}
