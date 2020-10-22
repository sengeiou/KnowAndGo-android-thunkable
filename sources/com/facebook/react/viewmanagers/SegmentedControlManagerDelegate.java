package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.SegmentedControlManagerInterface;

public class SegmentedControlManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & SegmentedControlManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public SegmentedControlManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: boolean} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r4, java.lang.String r5, @androidx.annotation.Nullable java.lang.Object r6) {
        /*
            r3 = this;
            int r0 = r5.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1609594047: goto L_0x0033;
                case -823812830: goto L_0x0028;
                case 1327599912: goto L_0x001e;
                case 1436069623: goto L_0x0014;
                case 1684715624: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x003d
        L_0x000a:
            java.lang.String r0 = "momentary"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003d
            r0 = 4
            goto L_0x003e
        L_0x0014:
            java.lang.String r0 = "selectedIndex"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003d
            r0 = 1
            goto L_0x003e
        L_0x001e:
            java.lang.String r0 = "tintColor"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003d
            r0 = 3
            goto L_0x003e
        L_0x0028:
            java.lang.String r0 = "values"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003d
            r0 = 0
            goto L_0x003e
        L_0x0033:
            java.lang.String r0 = "enabled"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003d
            r0 = 2
            goto L_0x003e
        L_0x003d:
            r0 = -1
        L_0x003e:
            switch(r0) {
                case 0: goto L_0x008e;
                case 1: goto L_0x007d;
                case 2: goto L_0x006c;
                case 3: goto L_0x0056;
                case 4: goto L_0x0045;
                default: goto L_0x0041;
            }
        L_0x0041:
            super.setProperty(r4, r5, r6)
            goto L_0x0097
        L_0x0045:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r5 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r5
            if (r6 != 0) goto L_0x004c
            goto L_0x0052
        L_0x004c:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r2 = r6.booleanValue()
        L_0x0052:
            r5.setMomentary(r4, r2)
            goto L_0x0097
        L_0x0056:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r5 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r5
            if (r6 != 0) goto L_0x005e
            r6 = 0
            goto L_0x0068
        L_0x005e:
            java.lang.Double r6 = (java.lang.Double) r6
            int r6 = r6.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
        L_0x0068:
            r5.setTintColor(r4, r6)
            goto L_0x0097
        L_0x006c:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r5 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r5
            if (r6 != 0) goto L_0x0073
            goto L_0x0079
        L_0x0073:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x0079:
            r5.setEnabled(r4, r1)
            goto L_0x0097
        L_0x007d:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r5 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r5
            if (r6 != 0) goto L_0x0084
            goto L_0x008a
        L_0x0084:
            java.lang.Double r6 = (java.lang.Double) r6
            int r2 = r6.intValue()
        L_0x008a:
            r5.setSelectedIndex(r4, r2)
            goto L_0x0097
        L_0x008e:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.SegmentedControlManagerInterface r5 = (com.facebook.react.viewmanagers.SegmentedControlManagerInterface) r5
            com.facebook.react.bridge.ReadableArray r6 = (com.facebook.react.bridge.ReadableArray) r6
            r5.setValues(r4, r6)
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.SegmentedControlManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
