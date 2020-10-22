package com.swmansion.rnscreens;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.swmansion.rnscreens.Screen;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name = "RNSScreen")
public class ScreenViewManager extends ViewGroupManager<Screen> {
    protected static final String REACT_CLASS = "RNSScreen";

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public Screen createViewInstance(ThemedReactContext themedReactContext) {
        return new Screen(themedReactContext);
    }

    @ReactProp(defaultFloat = 0.0f, name = "active")
    public void setActive(Screen screen, float f) {
        screen.setActive(f != 0.0f);
    }

    @ReactProp(name = "stackPresentation")
    public void setStackPresentation(Screen screen, String str) {
        if ("push".equals(str)) {
            screen.setStackPresentation(Screen.StackPresentation.PUSH);
        } else if ("modal".equals(str) || "containedModal".equals(str) || "fullScreenModal".equals(str) || "formSheet".equals(str)) {
            screen.setStackPresentation(Screen.StackPresentation.MODAL);
        } else if ("transparentModal".equals(str) || "containedTransparentModal".equals(str)) {
            screen.setStackPresentation(Screen.StackPresentation.TRANSPARENT_MODAL);
        } else {
            throw new JSApplicationIllegalArgumentException("Unknown presentation type " + str);
        }
    }

    @ReactProp(name = "stackAnimation")
    public void setStackAnimation(Screen screen, String str) {
        if (str == null || "default".equals(str)) {
            screen.setStackAnimation(Screen.StackAnimation.DEFAULT);
        } else if (ViewProps.NONE.equals(str)) {
            screen.setStackAnimation(Screen.StackAnimation.NONE);
        } else if ("fade".equals(str)) {
            screen.setStackAnimation(Screen.StackAnimation.FADE);
        }
    }

    @ReactProp(defaultBoolean = true, name = "gestureEnabled")
    public void setGestureEnabled(Screen screen, boolean z) {
        screen.setGestureEnabled(z);
    }

    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.m140of(ScreenDismissedEvent.EVENT_NAME, MapBuilder.m138of("registrationName", "onDismissed"), ScreenAppearEvent.EVENT_NAME, MapBuilder.m138of("registrationName", "onAppear"), StackFinishTransitioningEvent.EVENT_NAME, MapBuilder.m138of("registrationName", "onFinishTransitioning"));
    }
}
