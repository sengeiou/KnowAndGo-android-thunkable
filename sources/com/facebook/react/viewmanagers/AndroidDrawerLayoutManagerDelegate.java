package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface;

public class AndroidDrawerLayoutManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidDrawerLayoutManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidDrawerLayoutManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r3, java.lang.String r4, @androidx.annotation.Nullable java.lang.Object r5) {
        /*
            r2 = this;
            int r0 = r4.hashCode()
            switch(r0) {
                case -2082382380: goto L_0x003a;
                case -1233873500: goto L_0x0030;
                case -764307226: goto L_0x0026;
                case 268251989: goto L_0x001c;
                case 695891258: goto L_0x0012;
                case 1857208703: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0044
        L_0x0008:
            java.lang.String r0 = "drawerLockMode"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 4
            goto L_0x0045
        L_0x0012:
            java.lang.String r0 = "drawerPosition"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 2
            goto L_0x0045
        L_0x001c:
            java.lang.String r0 = "drawerWidth"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 3
            goto L_0x0045
        L_0x0026:
            java.lang.String r0 = "keyboardDismissMode"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 0
            goto L_0x0045
        L_0x0030:
            java.lang.String r0 = "drawerBackgroundColor"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 1
            goto L_0x0045
        L_0x003a:
            java.lang.String r0 = "statusBarBackgroundColor"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 5
            goto L_0x0045
        L_0x0044:
            r0 = -1
        L_0x0045:
            r1 = 0
            switch(r0) {
                case 0: goto L_0x00a0;
                case 1: goto L_0x008b;
                case 2: goto L_0x0081;
                case 3: goto L_0x006c;
                case 4: goto L_0x0062;
                case 5: goto L_0x004d;
                default: goto L_0x0049;
            }
        L_0x0049:
            super.setProperty(r3, r4, r5)
            goto L_0x00a9
        L_0x004d:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface r4 = (com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface) r4
            if (r5 != 0) goto L_0x0054
            goto L_0x005e
        L_0x0054:
            java.lang.Double r5 = (java.lang.Double) r5
            int r5 = r5.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
        L_0x005e:
            r4.setStatusBarBackgroundColor(r3, r1)
            goto L_0x00a9
        L_0x0062:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface r4 = (com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface) r4
            java.lang.String r5 = (java.lang.String) r5
            r4.setDrawerLockMode(r3, r5)
            goto L_0x00a9
        L_0x006c:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface r4 = (com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface) r4
            if (r5 != 0) goto L_0x0073
            goto L_0x007d
        L_0x0073:
            java.lang.Double r5 = (java.lang.Double) r5
            float r5 = r5.floatValue()
            java.lang.Float r1 = java.lang.Float.valueOf(r5)
        L_0x007d:
            r4.setDrawerWidth(r3, r1)
            goto L_0x00a9
        L_0x0081:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface r4 = (com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface) r4
            java.lang.String r5 = (java.lang.String) r5
            r4.setDrawerPosition(r3, r5)
            goto L_0x00a9
        L_0x008b:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface r4 = (com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface) r4
            if (r5 != 0) goto L_0x0092
            goto L_0x009c
        L_0x0092:
            java.lang.Double r5 = (java.lang.Double) r5
            int r5 = r5.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
        L_0x009c:
            r4.setDrawerBackgroundColor(r3, r1)
            goto L_0x00a9
        L_0x00a0:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface r4 = (com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface) r4
            java.lang.String r5 = (java.lang.String) r5
            r4.setKeyboardDismissMode(r3, r5)
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveCommand(com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface<T> r2, T r3, java.lang.String r4, com.facebook.react.bridge.ReadableArray r5) {
        /*
            r1 = this;
            int r5 = r4.hashCode()
            r0 = -258774775(0xfffffffff0936909, float:-3.649702E29)
            if (r5 == r0) goto L_0x0019
            r0 = -83186725(0xfffffffffb0aabdb, float:-7.200226E35)
            if (r5 == r0) goto L_0x000f
            goto L_0x0023
        L_0x000f:
            java.lang.String r5 = "openDrawer"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0023
            r4 = 0
            goto L_0x0024
        L_0x0019:
            java.lang.String r5 = "closeDrawer"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0023
            r4 = 1
            goto L_0x0024
        L_0x0023:
            r4 = -1
        L_0x0024:
            switch(r4) {
                case 0: goto L_0x002c;
                case 1: goto L_0x0028;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x002f
        L_0x0028:
            r2.closeDrawer(r3)
            goto L_0x002f
        L_0x002c:
            r2.openDrawer(r3)
        L_0x002f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerDelegate.receiveCommand(com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface, android.view.View, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }
}
