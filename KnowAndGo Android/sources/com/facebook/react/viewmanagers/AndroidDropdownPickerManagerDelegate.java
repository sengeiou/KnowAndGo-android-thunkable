package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface;

public class AndroidDropdownPickerManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidDropdownPickerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidDropdownPickerManagerDelegate(U u) {
        super(u);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r4, java.lang.String r5, @androidx.annotation.Nullable java.lang.Object r6) {
        /*
            r3 = this;
            int r0 = r5.hashCode()
            r1 = 0
            r2 = 1
            switch(r0) {
                case -1609594047: goto L_0x0032;
                case -979805852: goto L_0x0028;
                case 94842723: goto L_0x001e;
                case 100526016: goto L_0x0014;
                case 1191572123: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x003c
        L_0x000a:
            java.lang.String r0 = "selected"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003c
            r0 = 4
            goto L_0x003d
        L_0x0014:
            java.lang.String r0 = "items"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003c
            r0 = 2
            goto L_0x003d
        L_0x001e:
            java.lang.String r0 = "color"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003c
            r0 = 0
            goto L_0x003d
        L_0x0028:
            java.lang.String r0 = "prompt"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003c
            r0 = 3
            goto L_0x003d
        L_0x0032:
            java.lang.String r0 = "enabled"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003c
            r0 = 1
            goto L_0x003d
        L_0x003c:
            r0 = -1
        L_0x003d:
            switch(r0) {
                case 0: goto L_0x007f;
                case 1: goto L_0x006e;
                case 2: goto L_0x0064;
                case 3: goto L_0x0055;
                case 4: goto L_0x0044;
                default: goto L_0x0040;
            }
        L_0x0040:
            super.setProperty(r4, r5, r6)
            goto L_0x0094
        L_0x0044:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface) r5
            if (r6 != 0) goto L_0x004b
            goto L_0x0051
        L_0x004b:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x0051:
            r5.setSelected(r4, r1)
            goto L_0x0094
        L_0x0055:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface) r5
            if (r6 != 0) goto L_0x005e
            java.lang.String r6 = ""
            goto L_0x0060
        L_0x005e:
            java.lang.String r6 = (java.lang.String) r6
        L_0x0060:
            r5.setPrompt(r4, r6)
            goto L_0x0094
        L_0x0064:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface) r5
            com.facebook.react.bridge.ReadableArray r6 = (com.facebook.react.bridge.ReadableArray) r6
            r5.setItems(r4, r6)
            goto L_0x0094
        L_0x006e:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface) r5
            if (r6 != 0) goto L_0x0075
            goto L_0x007b
        L_0x0075:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r2 = r6.booleanValue()
        L_0x007b:
            r5.setEnabled(r4, r2)
            goto L_0x0094
        L_0x007f:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface) r5
            if (r6 != 0) goto L_0x0087
            r6 = 0
            goto L_0x0091
        L_0x0087:
            java.lang.Double r6 = (java.lang.Double) r6
            int r6 = r6.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
        L_0x0091:
            r5.setColor(r4, r6)
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.AndroidDropdownPickerManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
