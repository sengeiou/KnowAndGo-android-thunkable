package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.ModalHostViewManagerInterface;

public class ModalHostViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & ModalHostViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public ModalHostViewManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: boolean} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r3, java.lang.String r4, @androidx.annotation.Nullable java.lang.Object r5) {
        /*
            r2 = this;
            int r0 = r4.hashCode()
            r1 = 0
            switch(r0) {
                case -1851617609: goto L_0x004f;
                case -1850124175: goto L_0x0045;
                case -1726194350: goto L_0x003b;
                case -1618432855: goto L_0x0031;
                case -1156137512: goto L_0x0027;
                case -795203165: goto L_0x001d;
                case 1195991583: goto L_0x0013;
                case 2031205598: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0059
        L_0x0009:
            java.lang.String r0 = "animationType"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0059
            r0 = 0
            goto L_0x005a
        L_0x0013:
            java.lang.String r0 = "hardwareAccelerated"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0059
            r0 = 4
            goto L_0x005a
        L_0x001d:
            java.lang.String r0 = "animated"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0059
            r0 = 5
            goto L_0x005a
        L_0x0027:
            java.lang.String r0 = "statusBarTranslucent"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0059
            r0 = 3
            goto L_0x005a
        L_0x0031:
            java.lang.String r0 = "identifier"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0059
            r0 = 7
            goto L_0x005a
        L_0x003b:
            java.lang.String r0 = "transparent"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0059
            r0 = 2
            goto L_0x005a
        L_0x0045:
            java.lang.String r0 = "supportedOrientations"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0059
            r0 = 6
            goto L_0x005a
        L_0x004f:
            java.lang.String r0 = "presentationStyle"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0059
            r0 = 1
            goto L_0x005a
        L_0x0059:
            r0 = -1
        L_0x005a:
            switch(r0) {
                case 0: goto L_0x00cb;
                case 1: goto L_0x00c1;
                case 2: goto L_0x00b0;
                case 3: goto L_0x009f;
                case 4: goto L_0x008e;
                case 5: goto L_0x007d;
                case 6: goto L_0x0073;
                case 7: goto L_0x0062;
                default: goto L_0x005d;
            }
        L_0x005d:
            super.setProperty(r3, r4, r5)
            goto L_0x00d4
        L_0x0062:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            if (r5 != 0) goto L_0x0069
            goto L_0x006f
        L_0x0069:
            java.lang.Double r5 = (java.lang.Double) r5
            int r1 = r5.intValue()
        L_0x006f:
            r4.setIdentifier(r3, r1)
            goto L_0x00d4
        L_0x0073:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            com.facebook.react.bridge.ReadableArray r5 = (com.facebook.react.bridge.ReadableArray) r5
            r4.setSupportedOrientations(r3, r5)
            goto L_0x00d4
        L_0x007d:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            if (r5 != 0) goto L_0x0084
            goto L_0x008a
        L_0x0084:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r1 = r5.booleanValue()
        L_0x008a:
            r4.setAnimated(r3, r1)
            goto L_0x00d4
        L_0x008e:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            if (r5 != 0) goto L_0x0095
            goto L_0x009b
        L_0x0095:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r1 = r5.booleanValue()
        L_0x009b:
            r4.setHardwareAccelerated(r3, r1)
            goto L_0x00d4
        L_0x009f:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            if (r5 != 0) goto L_0x00a6
            goto L_0x00ac
        L_0x00a6:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r1 = r5.booleanValue()
        L_0x00ac:
            r4.setStatusBarTranslucent(r3, r1)
            goto L_0x00d4
        L_0x00b0:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            if (r5 != 0) goto L_0x00b7
            goto L_0x00bd
        L_0x00b7:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r1 = r5.booleanValue()
        L_0x00bd:
            r4.setTransparent(r3, r1)
            goto L_0x00d4
        L_0x00c1:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            java.lang.String r5 = (java.lang.String) r5
            r4.setPresentationStyle(r3, r5)
            goto L_0x00d4
        L_0x00cb:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            java.lang.String r5 = (java.lang.String) r5
            r4.setAnimationType(r3, r5)
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.ModalHostViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
