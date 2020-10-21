package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidSwitchManagerInterface;

public class AndroidSwitchManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidSwitchManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidSwitchManagerDelegate(U u) {
        super(u);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, @androidx.annotation.Nullable java.lang.Object r7) {
        /*
            r4 = this;
            int r0 = r6.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1742453971: goto L_0x005c;
                case -1609594047: goto L_0x0052;
                case -287374307: goto L_0x0047;
                case 3551: goto L_0x003d;
                case 111972721: goto L_0x0032;
                case 270940796: goto L_0x0028;
                case 1084662482: goto L_0x001e;
                case 1912319986: goto L_0x0014;
                case 2113632767: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0066
        L_0x000a:
            java.lang.String r0 = "trackColorForTrue"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 4
            goto L_0x0067
        L_0x0014:
            java.lang.String r0 = "thumbTintColor"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 7
            goto L_0x0067
        L_0x001e:
            java.lang.String r0 = "trackColorForFalse"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 3
            goto L_0x0067
        L_0x0028:
            java.lang.String r0 = "disabled"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 0
            goto L_0x0067
        L_0x0032:
            java.lang.String r0 = "value"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 5
            goto L_0x0067
        L_0x003d:
            java.lang.String r0 = "on"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 6
            goto L_0x0067
        L_0x0047:
            java.lang.String r0 = "trackTintColor"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 8
            goto L_0x0067
        L_0x0052:
            java.lang.String r0 = "enabled"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 1
            goto L_0x0067
        L_0x005c:
            java.lang.String r0 = "thumbColor"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 2
            goto L_0x0067
        L_0x0066:
            r0 = -1
        L_0x0067:
            r3 = 0
            switch(r0) {
                case 0: goto L_0x010f;
                case 1: goto L_0x00fe;
                case 2: goto L_0x00e9;
                case 3: goto L_0x00d4;
                case 4: goto L_0x00bf;
                case 5: goto L_0x00ae;
                case 6: goto L_0x009c;
                case 7: goto L_0x0086;
                case 8: goto L_0x0070;
                default: goto L_0x006b;
            }
        L_0x006b:
            super.setProperty(r5, r6, r7)
            goto L_0x011f
        L_0x0070:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r6
            if (r7 != 0) goto L_0x0077
            goto L_0x0081
        L_0x0077:
            java.lang.Double r7 = (java.lang.Double) r7
            int r7 = r7.intValue()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
        L_0x0081:
            r6.setTrackTintColor(r5, r3)
            goto L_0x011f
        L_0x0086:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r6
            if (r7 != 0) goto L_0x008d
            goto L_0x0097
        L_0x008d:
            java.lang.Double r7 = (java.lang.Double) r7
            int r7 = r7.intValue()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
        L_0x0097:
            r6.setThumbTintColor(r5, r3)
            goto L_0x011f
        L_0x009c:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r6
            if (r7 != 0) goto L_0x00a3
            goto L_0x00a9
        L_0x00a3:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x00a9:
            r6.setOn(r5, r2)
            goto L_0x011f
        L_0x00ae:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r6
            if (r7 != 0) goto L_0x00b5
            goto L_0x00bb
        L_0x00b5:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x00bb:
            r6.setValue(r5, r2)
            goto L_0x011f
        L_0x00bf:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r6
            if (r7 != 0) goto L_0x00c6
            goto L_0x00d0
        L_0x00c6:
            java.lang.Double r7 = (java.lang.Double) r7
            int r7 = r7.intValue()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
        L_0x00d0:
            r6.setTrackColorForTrue(r5, r3)
            goto L_0x011f
        L_0x00d4:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r6
            if (r7 != 0) goto L_0x00db
            goto L_0x00e5
        L_0x00db:
            java.lang.Double r7 = (java.lang.Double) r7
            int r7 = r7.intValue()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
        L_0x00e5:
            r6.setTrackColorForFalse(r5, r3)
            goto L_0x011f
        L_0x00e9:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r6
            if (r7 != 0) goto L_0x00f0
            goto L_0x00fa
        L_0x00f0:
            java.lang.Double r7 = (java.lang.Double) r7
            int r7 = r7.intValue()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
        L_0x00fa:
            r6.setThumbColor(r5, r3)
            goto L_0x011f
        L_0x00fe:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r6
            if (r7 != 0) goto L_0x0105
            goto L_0x010b
        L_0x0105:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x010b:
            r6.setEnabled(r5, r1)
            goto L_0x011f
        L_0x010f:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r6
            if (r7 != 0) goto L_0x0116
            goto L_0x011c
        L_0x0116:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x011c:
            r6.setDisabled(r5, r2)
        L_0x011f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.AndroidSwitchManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }

    public void receiveCommand(AndroidSwitchManagerInterface<T> androidSwitchManagerInterface, T t, String str, ReadableArray readableArray) {
        if (((str.hashCode() == -669744680 && str.equals("setNativeValue")) ? (char) 0 : 65535) == 0) {
            androidSwitchManagerInterface.setNativeValue(t, readableArray.getBoolean(0));
        }
    }
}
