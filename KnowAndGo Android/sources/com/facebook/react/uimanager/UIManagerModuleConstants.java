package com.facebook.react.uimanager;

import android.widget.ImageView;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.events.TouchEventType;
import com.facebook.react.views.picker.events.PickerItemSelectEvent;
import com.reactnativecommunity.webview.events.TopLoadingErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingFinishEvent;
import com.reactnativecommunity.webview.events.TopLoadingStartEvent;
import com.reactnativecommunity.webview.events.TopMessageEvent;
import java.util.HashMap;
import java.util.Map;

class UIManagerModuleConstants {
    public static final String ACTION_DISMISSED = "dismissed";
    public static final String ACTION_ITEM_SELECTED = "itemSelected";

    UIManagerModuleConstants() {
    }

    static Map getBubblingEventTypeConstants() {
        return MapBuilder.builder().put("topChange", MapBuilder.m138of("phasedRegistrationNames", MapBuilder.m139of("bubbled", "onChange", "captured", "onChangeCapture"))).put(PickerItemSelectEvent.EVENT_NAME, MapBuilder.m138of("phasedRegistrationNames", MapBuilder.m139of("bubbled", "onSelect", "captured", "onSelectCapture"))).put(TouchEventType.getJSEventName(TouchEventType.START), MapBuilder.m138of("phasedRegistrationNames", MapBuilder.m139of("bubbled", "onTouchStart", "captured", "onTouchStartCapture"))).put(TouchEventType.getJSEventName(TouchEventType.MOVE), MapBuilder.m138of("phasedRegistrationNames", MapBuilder.m139of("bubbled", "onTouchMove", "captured", "onTouchMoveCapture"))).put(TouchEventType.getJSEventName(TouchEventType.END), MapBuilder.m138of("phasedRegistrationNames", MapBuilder.m139of("bubbled", "onTouchEnd", "captured", "onTouchEndCapture"))).put(TouchEventType.getJSEventName(TouchEventType.CANCEL), MapBuilder.m138of("phasedRegistrationNames", MapBuilder.m139of("bubbled", "onTouchCancel", "captured", "onTouchCancelCapture"))).build();
    }

    static Map getDirectEventTypeConstants() {
        return MapBuilder.builder().put("topContentSizeChange", MapBuilder.m138of("registrationName", "onContentSizeChange")).put("topLayout", MapBuilder.m138of("registrationName", ViewProps.ON_LAYOUT)).put(TopLoadingErrorEvent.EVENT_NAME, MapBuilder.m138of("registrationName", "onLoadingError")).put(TopLoadingFinishEvent.EVENT_NAME, MapBuilder.m138of("registrationName", "onLoadingFinish")).put(TopLoadingStartEvent.EVENT_NAME, MapBuilder.m138of("registrationName", "onLoadingStart")).put("topSelectionChange", MapBuilder.m138of("registrationName", "onSelectionChange")).put(TopMessageEvent.EVENT_NAME, MapBuilder.m138of("registrationName", "onMessage")).put("topClick", MapBuilder.m138of("registrationName", "onClick")).put("topScrollBeginDrag", MapBuilder.m138of("registrationName", "onScrollBeginDrag")).put("topScrollEndDrag", MapBuilder.m138of("registrationName", "onScrollEndDrag")).put("topScroll", MapBuilder.m138of("registrationName", "onScroll")).put("topMomentumScrollBegin", MapBuilder.m138of("registrationName", "onMomentumScrollBegin")).put("topMomentumScrollEnd", MapBuilder.m138of("registrationName", "onMomentumScrollEnd")).build();
    }

    public static Map<String, Object> getConstants() {
        HashMap newHashMap = MapBuilder.newHashMap();
        newHashMap.put("UIView", MapBuilder.m138of("ContentMode", MapBuilder.m140of("ScaleAspectFit", Integer.valueOf(ImageView.ScaleType.FIT_CENTER.ordinal()), "ScaleAspectFill", Integer.valueOf(ImageView.ScaleType.CENTER_CROP.ordinal()), "ScaleAspectCenter", Integer.valueOf(ImageView.ScaleType.CENTER_INSIDE.ordinal()))));
        newHashMap.put("StyleConstants", MapBuilder.m138of("PointerEventsValues", MapBuilder.m141of(ViewProps.NONE, Integer.valueOf(PointerEvents.NONE.ordinal()), "boxNone", Integer.valueOf(PointerEvents.BOX_NONE.ordinal()), "boxOnly", Integer.valueOf(PointerEvents.BOX_ONLY.ordinal()), "unspecified", Integer.valueOf(PointerEvents.AUTO.ordinal()))));
        newHashMap.put("PopupMenu", MapBuilder.m139of("dismissed", "dismissed", ACTION_ITEM_SELECTED, ACTION_ITEM_SELECTED));
        newHashMap.put("AccessibilityEventTypes", MapBuilder.m140of("typeWindowStateChanged", 32, "typeViewFocused", 8, "typeViewClicked", 1));
        return newHashMap;
    }
}
