package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface;

public class AndroidViewPagerManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidViewPagerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidViewPagerManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: boolean} */
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
                case -1151046732: goto L_0x0032;
                case -764307226: goto L_0x0028;
                case 1097821469: goto L_0x001e;
                case 1233251315: goto L_0x0014;
                case 1919780198: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x003c
        L_0x000a:
            java.lang.String r0 = "peekEnabled"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003c
            r0 = 2
            goto L_0x003d
        L_0x0014:
            java.lang.String r0 = "initialPage"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003c
            r0 = 0
            goto L_0x003d
        L_0x001e:
            java.lang.String r0 = "pageMargin"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003c
            r0 = 1
            goto L_0x003d
        L_0x0028:
            java.lang.String r0 = "keyboardDismissMode"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003c
            r0 = 3
            goto L_0x003d
        L_0x0032:
            java.lang.String r0 = "scrollEnabled"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x003c
            r0 = 4
            goto L_0x003d
        L_0x003c:
            r0 = -1
        L_0x003d:
            switch(r0) {
                case 0: goto L_0x0081;
                case 1: goto L_0x0070;
                case 2: goto L_0x005f;
                case 3: goto L_0x0055;
                case 4: goto L_0x0044;
                default: goto L_0x0040;
            }
        L_0x0040:
            super.setProperty(r4, r5, r6)
            goto L_0x0091
        L_0x0044:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface) r5
            if (r6 != 0) goto L_0x004b
            goto L_0x0051
        L_0x004b:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x0051:
            r5.setScrollEnabled(r4, r1)
            goto L_0x0091
        L_0x0055:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface) r5
            java.lang.String r6 = (java.lang.String) r6
            r5.setKeyboardDismissMode(r4, r6)
            goto L_0x0091
        L_0x005f:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface) r5
            if (r6 != 0) goto L_0x0066
            goto L_0x006c
        L_0x0066:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r2 = r6.booleanValue()
        L_0x006c:
            r5.setPeekEnabled(r4, r2)
            goto L_0x0091
        L_0x0070:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface) r5
            if (r6 != 0) goto L_0x0077
            goto L_0x007d
        L_0x0077:
            java.lang.Double r6 = (java.lang.Double) r6
            int r2 = r6.intValue()
        L_0x007d:
            r5.setPageMargin(r4, r2)
            goto L_0x0091
        L_0x0081:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface) r5
            if (r6 != 0) goto L_0x0088
            goto L_0x008e
        L_0x0088:
            java.lang.Double r6 = (java.lang.Double) r6
            int r2 = r6.intValue()
        L_0x008e:
            r5.setInitialPage(r4, r2)
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.AndroidViewPagerManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveCommand(com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface<T> r4, T r5, java.lang.String r6, com.facebook.react.bridge.ReadableArray r7) {
        /*
            r3 = this;
            int r0 = r6.hashCode()
            r1 = -445763635(0xffffffffe56e2fcd, float:-7.030031E22)
            r2 = 0
            if (r0 == r1) goto L_0x001a
            r1 = 1984860689(0x764e9211, float:1.0474372E33)
            if (r0 == r1) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "setPage"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0024
            r6 = 0
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "setPageWithoutAnimation"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0024
            r6 = 1
            goto L_0x0025
        L_0x0024:
            r6 = -1
        L_0x0025:
            switch(r6) {
                case 0: goto L_0x0031;
                case 1: goto L_0x0029;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x0038
        L_0x0029:
            int r6 = r7.getInt(r2)
            r4.setPageWithoutAnimation(r5, r6)
            goto L_0x0038
        L_0x0031:
            int r6 = r7.getInt(r2)
            r4.setPage(r5, r6)
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.AndroidViewPagerManagerDelegate.receiveCommand(com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface, android.view.View, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }
}
