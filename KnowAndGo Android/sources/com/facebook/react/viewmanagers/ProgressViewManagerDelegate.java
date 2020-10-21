package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.ProgressViewManagerInterface;

public class ProgressViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & ProgressViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public ProgressViewManagerDelegate(U u) {
        super(u);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r3, java.lang.String r4, @androidx.annotation.Nullable java.lang.Object r5) {
        /*
            r2 = this;
            int r0 = r4.hashCode()
            switch(r0) {
                case -1948954017: goto L_0x003a;
                case -1001078227: goto L_0x0030;
                case -287374307: goto L_0x0026;
                case 760630062: goto L_0x001c;
                case 962728315: goto L_0x0012;
                case 1139400400: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0044
        L_0x0008:
            java.lang.String r0 = "trackImage"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 5
            goto L_0x0045
        L_0x0012:
            java.lang.String r0 = "progressTintColor"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 2
            goto L_0x0045
        L_0x001c:
            java.lang.String r0 = "progressImage"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 4
            goto L_0x0045
        L_0x0026:
            java.lang.String r0 = "trackTintColor"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 3
            goto L_0x0045
        L_0x0030:
            java.lang.String r0 = "progress"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 1
            goto L_0x0045
        L_0x003a:
            java.lang.String r0 = "progressViewStyle"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0044
            r0 = 0
            goto L_0x0045
        L_0x0044:
            r0 = -1
        L_0x0045:
            r1 = 0
            switch(r0) {
                case 0: goto L_0x009d;
                case 1: goto L_0x008b;
                case 2: goto L_0x0076;
                case 3: goto L_0x0061;
                case 4: goto L_0x0057;
                case 5: goto L_0x004d;
                default: goto L_0x0049;
            }
        L_0x0049:
            super.setProperty(r3, r4, r5)
            goto L_0x00a6
        L_0x004d:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ProgressViewManagerInterface r4 = (com.facebook.react.viewmanagers.ProgressViewManagerInterface) r4
            com.facebook.react.bridge.ReadableMap r5 = (com.facebook.react.bridge.ReadableMap) r5
            r4.setTrackImage(r3, r5)
            goto L_0x00a6
        L_0x0057:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ProgressViewManagerInterface r4 = (com.facebook.react.viewmanagers.ProgressViewManagerInterface) r4
            com.facebook.react.bridge.ReadableMap r5 = (com.facebook.react.bridge.ReadableMap) r5
            r4.setProgressImage(r3, r5)
            goto L_0x00a6
        L_0x0061:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ProgressViewManagerInterface r4 = (com.facebook.react.viewmanagers.ProgressViewManagerInterface) r4
            if (r5 != 0) goto L_0x0068
            goto L_0x0072
        L_0x0068:
            java.lang.Double r5 = (java.lang.Double) r5
            int r5 = r5.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
        L_0x0072:
            r4.setTrackTintColor(r3, r1)
            goto L_0x00a6
        L_0x0076:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ProgressViewManagerInterface r4 = (com.facebook.react.viewmanagers.ProgressViewManagerInterface) r4
            if (r5 != 0) goto L_0x007d
            goto L_0x0087
        L_0x007d:
            java.lang.Double r5 = (java.lang.Double) r5
            int r5 = r5.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
        L_0x0087:
            r4.setProgressTintColor(r3, r1)
            goto L_0x00a6
        L_0x008b:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ProgressViewManagerInterface r4 = (com.facebook.react.viewmanagers.ProgressViewManagerInterface) r4
            if (r5 != 0) goto L_0x0093
            r5 = 0
            goto L_0x0099
        L_0x0093:
            java.lang.Double r5 = (java.lang.Double) r5
            float r5 = r5.floatValue()
        L_0x0099:
            r4.setProgress(r3, r5)
            goto L_0x00a6
        L_0x009d:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ProgressViewManagerInterface r4 = (com.facebook.react.viewmanagers.ProgressViewManagerInterface) r4
            java.lang.String r5 = (java.lang.String) r5
            r4.setProgressViewStyle(r3, r5)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.ProgressViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
