package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface;

public class AndroidProgressBarManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidProgressBarManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidProgressBarManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, @androidx.annotation.Nullable java.lang.Object r7) {
        /*
            r4 = this;
            int r0 = r6.hashCode()
            r1 = 0
            r2 = 1
            switch(r0) {
                case -1001078227: goto L_0x0047;
                case -877170387: goto L_0x003d;
                case -676876213: goto L_0x0032;
                case 94842723: goto L_0x0028;
                case 633138363: goto L_0x001e;
                case 1118509918: goto L_0x0014;
                case 1804741442: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0051
        L_0x000a:
            java.lang.String r0 = "styleAttr"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0051
            r0 = 0
            goto L_0x0052
        L_0x0014:
            java.lang.String r0 = "animating"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0051
            r0 = 4
            goto L_0x0052
        L_0x001e:
            java.lang.String r0 = "indeterminate"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0051
            r0 = 2
            goto L_0x0052
        L_0x0028:
            java.lang.String r0 = "color"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0051
            r0 = 5
            goto L_0x0052
        L_0x0032:
            java.lang.String r0 = "typeAttr"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0051
            r0 = 1
            goto L_0x0052
        L_0x003d:
            java.lang.String r0 = "testID"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0051
            r0 = 6
            goto L_0x0052
        L_0x0047:
            java.lang.String r0 = "progress"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0051
            r0 = 3
            goto L_0x0052
        L_0x0051:
            r0 = -1
        L_0x0052:
            r3 = 0
            switch(r0) {
                case 0: goto L_0x00c3;
                case 1: goto L_0x00b5;
                case 2: goto L_0x00a4;
                case 3: goto L_0x0091;
                case 4: goto L_0x0080;
                case 5: goto L_0x006b;
                case 6: goto L_0x005b;
                default: goto L_0x0056;
            }
        L_0x0056:
            super.setProperty(r5, r6, r7)
            goto L_0x00d0
        L_0x005b:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface) r6
            if (r7 != 0) goto L_0x0064
            java.lang.String r7 = ""
            goto L_0x0066
        L_0x0064:
            java.lang.String r7 = (java.lang.String) r7
        L_0x0066:
            r6.setTestID(r5, r7)
            goto L_0x00d0
        L_0x006b:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface) r6
            if (r7 != 0) goto L_0x0072
            goto L_0x007c
        L_0x0072:
            java.lang.Double r7 = (java.lang.Double) r7
            int r7 = r7.intValue()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
        L_0x007c:
            r6.setColor(r5, r3)
            goto L_0x00d0
        L_0x0080:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface) r6
            if (r7 != 0) goto L_0x0087
            goto L_0x008d
        L_0x0087:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x008d:
            r6.setAnimating(r5, r2)
            goto L_0x00d0
        L_0x0091:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface) r6
            if (r7 != 0) goto L_0x009a
            r0 = 0
            goto L_0x00a0
        L_0x009a:
            java.lang.Double r7 = (java.lang.Double) r7
            double r0 = r7.doubleValue()
        L_0x00a0:
            r6.setProgress(r5, r0)
            goto L_0x00d0
        L_0x00a4:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface) r6
            if (r7 != 0) goto L_0x00ab
            goto L_0x00b1
        L_0x00ab:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x00b1:
            r6.setIndeterminate(r5, r1)
            goto L_0x00d0
        L_0x00b5:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface) r6
            if (r7 != 0) goto L_0x00bc
            goto L_0x00bf
        L_0x00bc:
            r3 = r7
            java.lang.String r3 = (java.lang.String) r3
        L_0x00bf:
            r6.setTypeAttr(r5, r3)
            goto L_0x00d0
        L_0x00c3:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface) r6
            if (r7 != 0) goto L_0x00ca
            goto L_0x00cd
        L_0x00ca:
            r3 = r7
            java.lang.String r3 = (java.lang.String) r3
        L_0x00cd:
            r6.setStyleAttr(r5, r3)
        L_0x00d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.AndroidProgressBarManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
