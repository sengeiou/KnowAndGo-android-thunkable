package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.ActivityIndicatorViewManagerInterface;

public class ActivityIndicatorViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & ActivityIndicatorViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public ActivityIndicatorViewManagerDelegate(U u) {
        super(u);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r4, java.lang.String r5, @androidx.annotation.Nullable java.lang.Object r6) {
        /*
            r3 = this;
            int r0 = r5.hashCode()
            r1 = 3530753(0x35e001, float:4.947639E-39)
            r2 = 0
            if (r0 == r1) goto L_0x0038
            r1 = 94842723(0x5a72f63, float:1.5722012E-35)
            if (r0 == r1) goto L_0x002e
            r1 = 865748226(0x339a4502, float:7.183736E-8)
            if (r0 == r1) goto L_0x0024
            r1 = 1118509918(0x42ab1b5e, float:85.55345)
            if (r0 == r1) goto L_0x001a
            goto L_0x0042
        L_0x001a:
            java.lang.String r0 = "animating"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0042
            r0 = 1
            goto L_0x0043
        L_0x0024:
            java.lang.String r0 = "hidesWhenStopped"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0042
            r0 = 0
            goto L_0x0043
        L_0x002e:
            java.lang.String r0 = "color"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0042
            r0 = 2
            goto L_0x0043
        L_0x0038:
            java.lang.String r0 = "size"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0042
            r0 = 3
            goto L_0x0043
        L_0x0042:
            r0 = -1
        L_0x0043:
            switch(r0) {
                case 0: goto L_0x007b;
                case 1: goto L_0x006a;
                case 2: goto L_0x0054;
                case 3: goto L_0x004a;
                default: goto L_0x0046;
            }
        L_0x0046:
            super.setProperty(r4, r5, r6)
            goto L_0x008b
        L_0x004a:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ActivityIndicatorViewManagerInterface r5 = (com.facebook.react.viewmanagers.ActivityIndicatorViewManagerInterface) r5
            java.lang.String r6 = (java.lang.String) r6
            r5.setSize(r4, r6)
            goto L_0x008b
        L_0x0054:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ActivityIndicatorViewManagerInterface r5 = (com.facebook.react.viewmanagers.ActivityIndicatorViewManagerInterface) r5
            if (r6 != 0) goto L_0x005c
            r6 = 0
            goto L_0x0066
        L_0x005c:
            java.lang.Double r6 = (java.lang.Double) r6
            int r6 = r6.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
        L_0x0066:
            r5.setColor(r4, r6)
            goto L_0x008b
        L_0x006a:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ActivityIndicatorViewManagerInterface r5 = (com.facebook.react.viewmanagers.ActivityIndicatorViewManagerInterface) r5
            if (r6 != 0) goto L_0x0071
            goto L_0x0077
        L_0x0071:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r2 = r6.booleanValue()
        L_0x0077:
            r5.setAnimating(r4, r2)
            goto L_0x008b
        L_0x007b:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.ActivityIndicatorViewManagerInterface r5 = (com.facebook.react.viewmanagers.ActivityIndicatorViewManagerInterface) r5
            if (r6 != 0) goto L_0x0082
            goto L_0x0088
        L_0x0082:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r2 = r6.booleanValue()
        L_0x0088:
            r5.setHidesWhenStopped(r4, r2)
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.ActivityIndicatorViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
