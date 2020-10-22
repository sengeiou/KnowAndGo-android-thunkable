package com.facebook.react.views.drawer;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerDelegate;
import com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface;
import com.facebook.react.views.drawer.events.DrawerClosedEvent;
import com.facebook.react.views.drawer.events.DrawerOpenedEvent;
import com.facebook.react.views.drawer.events.DrawerSlideEvent;
import com.facebook.react.views.drawer.events.DrawerStateChangedEvent;
import java.util.Map;

@ReactModule(name = "AndroidDrawerLayout")
public class ReactDrawerLayoutManager extends ViewGroupManager<ReactDrawerLayout> implements AndroidDrawerLayoutManagerInterface<ReactDrawerLayout> {
    public static final int CLOSE_DRAWER = 2;
    public static final int OPEN_DRAWER = 1;
    public static final String REACT_CLASS = "AndroidDrawerLayout";
    private final ViewManagerDelegate<ReactDrawerLayout> mDelegate = new AndroidDrawerLayoutManagerDelegate(this);

    @NonNull
    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public void setDrawerBackgroundColor(ReactDrawerLayout reactDrawerLayout, @Nullable Integer num) {
    }

    public void setKeyboardDismissMode(ReactDrawerLayout reactDrawerLayout, @Nullable String str) {
    }

    public void setStatusBarBackgroundColor(ReactDrawerLayout reactDrawerLayout, @Nullable Integer num) {
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, ReactDrawerLayout reactDrawerLayout) {
        reactDrawerLayout.addDrawerListener(new DrawerEventEmitter(reactDrawerLayout, ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher()));
    }

    /* access modifiers changed from: protected */
    @NonNull
    public ReactDrawerLayout createViewInstance(@NonNull ThemedReactContext themedReactContext) {
        return new ReactDrawerLayout(themedReactContext);
    }

    public void setDrawerPosition(ReactDrawerLayout reactDrawerLayout, @Nullable String str) {
        if (str == null) {
            reactDrawerLayout.setDrawerPosition(GravityCompat.START);
        } else {
            setDrawerPositionInternal(reactDrawerLayout, str);
        }
    }

    @ReactProp(name = "drawerPosition")
    public void setDrawerPosition(ReactDrawerLayout reactDrawerLayout, Dynamic dynamic) {
        if (dynamic.isNull()) {
            reactDrawerLayout.setDrawerPosition(GravityCompat.START);
        } else if (dynamic.getType() == ReadableType.Number) {
            int asInt = dynamic.asInt();
            if (8388611 == asInt || 8388613 == asInt) {
                reactDrawerLayout.setDrawerPosition(asInt);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Unknown drawerPosition " + asInt);
        } else if (dynamic.getType() == ReadableType.String) {
            setDrawerPositionInternal(reactDrawerLayout, dynamic.asString());
        } else {
            throw new JSApplicationIllegalArgumentException("drawerPosition must be a string or int");
        }
    }

    private void setDrawerPositionInternal(ReactDrawerLayout reactDrawerLayout, String str) {
        if (str.equals("left")) {
            reactDrawerLayout.setDrawerPosition(GravityCompat.START);
        } else if (str.equals("right")) {
            reactDrawerLayout.setDrawerPosition(GravityCompat.END);
        } else {
            throw new JSApplicationIllegalArgumentException("drawerPosition must be 'left' or 'right', received" + str);
        }
    }

    @ReactProp(defaultFloat = Float.NaN, name = "drawerWidth")
    public void setDrawerWidth(ReactDrawerLayout reactDrawerLayout, float f) {
        int i;
        if (Float.isNaN(f)) {
            i = -1;
        } else {
            i = Math.round(PixelUtil.toPixelFromDIP(f));
        }
        reactDrawerLayout.setDrawerWidth(i);
    }

    public void setDrawerWidth(ReactDrawerLayout reactDrawerLayout, @Nullable Float f) {
        reactDrawerLayout.setDrawerWidth(f == null ? -1 : Math.round(PixelUtil.toPixelFromDIP(f.floatValue())));
    }

    @ReactProp(name = "drawerLockMode")
    public void setDrawerLockMode(ReactDrawerLayout reactDrawerLayout, @Nullable String str) {
        if (str == null || "unlocked".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(0);
        } else if ("locked-closed".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(1);
        } else if ("locked-open".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(2);
        } else {
            throw new JSApplicationIllegalArgumentException("Unknown drawerLockMode " + str);
        }
    }

    public void openDrawer(ReactDrawerLayout reactDrawerLayout) {
        reactDrawerLayout.openDrawer();
    }

    public void closeDrawer(ReactDrawerLayout reactDrawerLayout) {
        reactDrawerLayout.closeDrawer();
    }

    public void setElevation(@NonNull ReactDrawerLayout reactDrawerLayout, float f) {
        reactDrawerLayout.setDrawerElevation(PixelUtil.toPixelFromDIP(f));
    }

    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.m139of("openDrawer", 1, "closeDrawer", 2);
    }

    public void receiveCommand(ReactDrawerLayout reactDrawerLayout, int i, @Nullable ReadableArray readableArray) {
        switch (i) {
            case 1:
                reactDrawerLayout.openDrawer();
                return;
            case 2:
                reactDrawerLayout.closeDrawer();
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveCommand(@androidx.annotation.NonNull com.facebook.react.views.drawer.ReactDrawerLayout r2, java.lang.String r3, @androidx.annotation.Nullable com.facebook.react.bridge.ReadableArray r4) {
        /*
            r1 = this;
            int r4 = r3.hashCode()
            r0 = -258774775(0xfffffffff0936909, float:-3.649702E29)
            if (r4 == r0) goto L_0x0019
            r0 = -83186725(0xfffffffffb0aabdb, float:-7.200226E35)
            if (r4 == r0) goto L_0x000f
            goto L_0x0023
        L_0x000f:
            java.lang.String r4 = "openDrawer"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0023
            r3 = 0
            goto L_0x0024
        L_0x0019:
            java.lang.String r4 = "closeDrawer"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0023
            r3 = 1
            goto L_0x0024
        L_0x0023:
            r3 = -1
        L_0x0024:
            switch(r3) {
                case 0: goto L_0x002c;
                case 1: goto L_0x0028;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x002f
        L_0x0028:
            r2.closeDrawer()
            goto L_0x002f
        L_0x002c:
            r2.openDrawer()
        L_0x002f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.drawer.ReactDrawerLayoutManager.receiveCommand(com.facebook.react.views.drawer.ReactDrawerLayout, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }

    @Nullable
    public Map getExportedViewConstants() {
        return MapBuilder.m138of("DrawerPosition", MapBuilder.m139of("Left", Integer.valueOf(GravityCompat.START), "Right", Integer.valueOf(GravityCompat.END)));
    }

    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.m141of(DrawerSlideEvent.EVENT_NAME, MapBuilder.m138of("registrationName", "onDrawerSlide"), DrawerOpenedEvent.EVENT_NAME, MapBuilder.m138of("registrationName", "onDrawerOpen"), DrawerClosedEvent.EVENT_NAME, MapBuilder.m138of("registrationName", "onDrawerClose"), DrawerStateChangedEvent.EVENT_NAME, MapBuilder.m138of("registrationName", "onDrawerStateChanged"));
    }

    public void addView(ReactDrawerLayout reactDrawerLayout, View view, int i) {
        if (getChildCount(reactDrawerLayout) >= 2) {
            throw new JSApplicationIllegalArgumentException("The Drawer cannot have more than two children");
        } else if (i == 0 || i == 1) {
            reactDrawerLayout.addView(view, i);
            reactDrawerLayout.setDrawerProperties();
        } else {
            throw new JSApplicationIllegalArgumentException("The only valid indices for drawer's child are 0 or 1. Got " + i + " instead.");
        }
    }

    public ViewManagerDelegate<ReactDrawerLayout> getDelegate() {
        return this.mDelegate;
    }

    public static class DrawerEventEmitter implements DrawerLayout.DrawerListener {
        private final DrawerLayout mDrawerLayout;
        private final EventDispatcher mEventDispatcher;

        public DrawerEventEmitter(DrawerLayout drawerLayout, EventDispatcher eventDispatcher) {
            this.mDrawerLayout = drawerLayout;
            this.mEventDispatcher = eventDispatcher;
        }

        public void onDrawerSlide(@NonNull View view, float f) {
            this.mEventDispatcher.dispatchEvent(new DrawerSlideEvent(this.mDrawerLayout.getId(), f));
        }

        public void onDrawerOpened(@NonNull View view) {
            this.mEventDispatcher.dispatchEvent(new DrawerOpenedEvent(this.mDrawerLayout.getId()));
        }

        public void onDrawerClosed(@NonNull View view) {
            this.mEventDispatcher.dispatchEvent(new DrawerClosedEvent(this.mDrawerLayout.getId()));
        }

        public void onDrawerStateChanged(int i) {
            this.mEventDispatcher.dispatchEvent(new DrawerStateChangedEvent(this.mDrawerLayout.getId(), i));
        }
    }
}
