package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface;

public class AndroidSwipeRefreshLayoutManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidSwipeRefreshLayoutManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidSwipeRefreshLayoutManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: boolean} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r4, java.lang.String r5, @androidx.annotation.Nullable java.lang.Object r6) {
        /*
            r3 = this;
            int r0 = r5.hashCode()
            r1 = 0
            r2 = 1
            switch(r0) {
                case -1609594047: goto L_0x003c;
                case -1354842768: goto L_0x0032;
                case -885150488: goto L_0x0028;
                case -416037467: goto L_0x001e;
                case -321826009: goto L_0x0014;
                case 3530753: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0046
        L_0x000a:
            java.lang.String r0 = "size"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0046
            r0 = 3
            goto L_0x0047
        L_0x0014:
            java.lang.String r0 = "refreshing"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0046
            r0 = 5
            goto L_0x0047
        L_0x001e:
            java.lang.String r0 = "progressViewOffset"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0046
            r0 = 4
            goto L_0x0047
        L_0x0028:
            java.lang.String r0 = "progressBackgroundColor"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0046
            r0 = 2
            goto L_0x0047
        L_0x0032:
            java.lang.String r0 = "colors"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0046
            r0 = 1
            goto L_0x0047
        L_0x003c:
            java.lang.String r0 = "enabled"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0046
            r0 = 0
            goto L_0x0047
        L_0x0046:
            r0 = -1
        L_0x0047:
            switch(r0) {
                case 0: goto L_0x00a3;
                case 1: goto L_0x0099;
                case 2: goto L_0x0083;
                case 3: goto L_0x0072;
                case 4: goto L_0x0060;
                case 5: goto L_0x004f;
                default: goto L_0x004a;
            }
        L_0x004a:
            super.setProperty(r4, r5, r6)
            goto L_0x00b3
        L_0x004f:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r5
            if (r6 != 0) goto L_0x0056
            goto L_0x005c
        L_0x0056:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x005c:
            r5.setRefreshing(r4, r1)
            goto L_0x00b3
        L_0x0060:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r5
            if (r6 != 0) goto L_0x0068
            r6 = 0
            goto L_0x006e
        L_0x0068:
            java.lang.Double r6 = (java.lang.Double) r6
            float r6 = r6.floatValue()
        L_0x006e:
            r5.setProgressViewOffset(r4, r6)
            goto L_0x00b3
        L_0x0072:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r5
            if (r6 != 0) goto L_0x0079
            goto L_0x007f
        L_0x0079:
            java.lang.Double r6 = (java.lang.Double) r6
            int r2 = r6.intValue()
        L_0x007f:
            r5.setSize(r4, r2)
            goto L_0x00b3
        L_0x0083:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r5
            if (r6 != 0) goto L_0x008b
            r6 = 0
            goto L_0x0095
        L_0x008b:
            java.lang.Double r6 = (java.lang.Double) r6
            int r6 = r6.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
        L_0x0095:
            r5.setProgressBackgroundColor(r4, r6)
            goto L_0x00b3
        L_0x0099:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r5
            com.facebook.react.bridge.ReadableArray r6 = (com.facebook.react.bridge.ReadableArray) r6
            r5.setColors(r4, r6)
            goto L_0x00b3
        L_0x00a3:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface) r5
            if (r6 != 0) goto L_0x00aa
            goto L_0x00b0
        L_0x00aa:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r2 = r6.booleanValue()
        L_0x00b0:
            r5.setEnabled(r4, r2)
        L_0x00b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }

    public void receiveCommand(AndroidSwipeRefreshLayoutManagerInterface<T> androidSwipeRefreshLayoutManagerInterface, T t, String str, ReadableArray readableArray) {
        if (((str.hashCode() == 513968928 && str.equals("setNativeRefreshing")) ? (char) 0 : 65535) == 0) {
            androidSwipeRefreshLayoutManagerInterface.setNativeRefreshing(t, readableArray.getBoolean(0));
        }
    }
}
