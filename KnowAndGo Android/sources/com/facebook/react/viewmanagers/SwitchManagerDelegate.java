package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.SwitchManagerInterface;

public class SwitchManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & SwitchManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public SwitchManagerDelegate(U u) {
        super(u);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r4, java.lang.String r5, @androidx.annotation.Nullable java.lang.Object r6) {
        /*
            r3 = this;
            int r0 = r5.hashCode()
            r1 = 0
            switch(r0) {
                case -1742453971: goto L_0x0050;
                case 111972721: goto L_0x0045;
                case 270940796: goto L_0x003b;
                case 1084662482: goto L_0x0031;
                case 1296813577: goto L_0x0027;
                case 1327599912: goto L_0x001d;
                case 1912319986: goto L_0x0013;
                case 2113632767: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x005a
        L_0x0009:
            java.lang.String r0 = "trackColorForTrue"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x005a
            r0 = 7
            goto L_0x005b
        L_0x0013:
            java.lang.String r0 = "thumbTintColor"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x005a
            r0 = 4
            goto L_0x005b
        L_0x001d:
            java.lang.String r0 = "tintColor"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x005a
            r0 = 2
            goto L_0x005b
        L_0x0027:
            java.lang.String r0 = "onTintColor"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x005a
            r0 = 3
            goto L_0x005b
        L_0x0031:
            java.lang.String r0 = "trackColorForFalse"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x005a
            r0 = 6
            goto L_0x005b
        L_0x003b:
            java.lang.String r0 = "disabled"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x005a
            r0 = 0
            goto L_0x005b
        L_0x0045:
            java.lang.String r0 = "value"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x005a
            r0 = 1
            goto L_0x005b
        L_0x0050:
            java.lang.String r0 = "thumbColor"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x005a
            r0 = 5
            goto L_0x005b
        L_0x005a:
            r0 = -1
        L_0x005b:
            r2 = 0
            switch(r0) {
                case 0: goto L_0x00f5;
                case 1: goto L_0x00e4;
                case 2: goto L_0x00cf;
                case 3: goto L_0x00ba;
                case 4: goto L_0x00a5;
                case 5: goto L_0x0090;
                case 6: goto L_0x007a;
                case 7: goto L_0x0064;
                default: goto L_0x005f;
            }
        L_0x005f:
            super.setProperty(r4, r5, r6)
            goto L_0x0105
        L_0x0064:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.SwitchManagerInterface r5 = (com.facebook.react.viewmanagers.SwitchManagerInterface) r5
            if (r6 != 0) goto L_0x006b
            goto L_0x0075
        L_0x006b:
            java.lang.Double r6 = (java.lang.Double) r6
            int r6 = r6.intValue()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
        L_0x0075:
            r5.setTrackColorForTrue(r4, r2)
            goto L_0x0105
        L_0x007a:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.SwitchManagerInterface r5 = (com.facebook.react.viewmanagers.SwitchManagerInterface) r5
            if (r6 != 0) goto L_0x0081
            goto L_0x008b
        L_0x0081:
            java.lang.Double r6 = (java.lang.Double) r6
            int r6 = r6.intValue()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
        L_0x008b:
            r5.setTrackColorForFalse(r4, r2)
            goto L_0x0105
        L_0x0090:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.SwitchManagerInterface r5 = (com.facebook.react.viewmanagers.SwitchManagerInterface) r5
            if (r6 != 0) goto L_0x0097
            goto L_0x00a1
        L_0x0097:
            java.lang.Double r6 = (java.lang.Double) r6
            int r6 = r6.intValue()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
        L_0x00a1:
            r5.setThumbColor(r4, r2)
            goto L_0x0105
        L_0x00a5:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.SwitchManagerInterface r5 = (com.facebook.react.viewmanagers.SwitchManagerInterface) r5
            if (r6 != 0) goto L_0x00ac
            goto L_0x00b6
        L_0x00ac:
            java.lang.Double r6 = (java.lang.Double) r6
            int r6 = r6.intValue()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
        L_0x00b6:
            r5.setThumbTintColor(r4, r2)
            goto L_0x0105
        L_0x00ba:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.SwitchManagerInterface r5 = (com.facebook.react.viewmanagers.SwitchManagerInterface) r5
            if (r6 != 0) goto L_0x00c1
            goto L_0x00cb
        L_0x00c1:
            java.lang.Double r6 = (java.lang.Double) r6
            int r6 = r6.intValue()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
        L_0x00cb:
            r5.setOnTintColor(r4, r2)
            goto L_0x0105
        L_0x00cf:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.SwitchManagerInterface r5 = (com.facebook.react.viewmanagers.SwitchManagerInterface) r5
            if (r6 != 0) goto L_0x00d6
            goto L_0x00e0
        L_0x00d6:
            java.lang.Double r6 = (java.lang.Double) r6
            int r6 = r6.intValue()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
        L_0x00e0:
            r5.setTintColor(r4, r2)
            goto L_0x0105
        L_0x00e4:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.SwitchManagerInterface r5 = (com.facebook.react.viewmanagers.SwitchManagerInterface) r5
            if (r6 != 0) goto L_0x00eb
            goto L_0x00f1
        L_0x00eb:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00f1:
            r5.setValue(r4, r1)
            goto L_0x0105
        L_0x00f5:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.SwitchManagerInterface r5 = (com.facebook.react.viewmanagers.SwitchManagerInterface) r5
            if (r6 != 0) goto L_0x00fc
            goto L_0x0102
        L_0x00fc:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x0102:
            r5.setDisabled(r4, r1)
        L_0x0105:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.SwitchManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
