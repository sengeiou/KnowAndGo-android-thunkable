package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.SliderManagerInterface;

public class SliderManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & SliderManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public SliderManagerDelegate(U u) {
        super(u);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r7, java.lang.String r8, @androidx.annotation.Nullable java.lang.Object r9) {
        /*
            r6 = this;
            int r0 = r8.hashCode()
            r1 = 0
            r2 = 1
            switch(r0) {
                case -1900655011: goto L_0x0098;
                case -1736983259: goto L_0x008d;
                case -1609594047: goto L_0x0083;
                case -1021497397: goto L_0x0079;
                case -981448432: goto L_0x006f;
                case -877170387: goto L_0x0064;
                case 3540684: goto L_0x0059;
                case 111972721: goto L_0x004d;
                case 270940796: goto L_0x0043;
                case 718061361: goto L_0x0039;
                case 1139400400: goto L_0x002d;
                case 1192487427: goto L_0x0022;
                case 1333596542: goto L_0x0017;
                case 1912319986: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x00a2
        L_0x000b:
            java.lang.String r0 = "thumbTintColor"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 11
            goto L_0x00a3
        L_0x0017:
            java.lang.String r0 = "minimumTrackImage"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 5
            goto L_0x00a3
        L_0x0022:
            java.lang.String r0 = "minimumValue"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 7
            goto L_0x00a3
        L_0x002d:
            java.lang.String r0 = "trackImage"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 12
            goto L_0x00a3
        L_0x0039:
            java.lang.String r0 = "maximumValue"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 4
            goto L_0x00a3
        L_0x0043:
            java.lang.String r0 = "disabled"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 0
            goto L_0x00a3
        L_0x004d:
            java.lang.String r0 = "value"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 13
            goto L_0x00a3
        L_0x0059:
            java.lang.String r0 = "step"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 8
            goto L_0x00a3
        L_0x0064:
            java.lang.String r0 = "testID"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 9
            goto L_0x00a3
        L_0x006f:
            java.lang.String r0 = "maximumTrackImage"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 2
            goto L_0x00a3
        L_0x0079:
            java.lang.String r0 = "minimumTrackTintColor"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 6
            goto L_0x00a3
        L_0x0083:
            java.lang.String r0 = "enabled"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 1
            goto L_0x00a3
        L_0x008d:
            java.lang.String r0 = "thumbImage"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 10
            goto L_0x00a3
        L_0x0098:
            java.lang.String r0 = "maximumTrackTintColor"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 3
            goto L_0x00a3
        L_0x00a2:
            r0 = -1
        L_0x00a3:
            r3 = 0
            r5 = 0
            switch(r0) {
                case 0: goto L_0x0182;
                case 1: goto L_0x0171;
                case 2: goto L_0x0167;
                case 3: goto L_0x0152;
                case 4: goto L_0x013f;
                case 5: goto L_0x0135;
                case 6: goto L_0x0120;
                case 7: goto L_0x010e;
                case 8: goto L_0x00fc;
                case 9: goto L_0x00ec;
                case 10: goto L_0x00e1;
                case 11: goto L_0x00cb;
                case 12: goto L_0x00c0;
                case 13: goto L_0x00ae;
                default: goto L_0x00a9;
            }
        L_0x00a9:
            super.setProperty(r7, r8, r9)
            goto L_0x0192
        L_0x00ae:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r8 = (com.facebook.react.viewmanagers.SliderManagerInterface) r8
            if (r9 != 0) goto L_0x00b5
            goto L_0x00bb
        L_0x00b5:
            java.lang.Double r9 = (java.lang.Double) r9
            double r3 = r9.doubleValue()
        L_0x00bb:
            r8.setValue(r7, r3)
            goto L_0x0192
        L_0x00c0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r8 = (com.facebook.react.viewmanagers.SliderManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setTrackImage(r7, r9)
            goto L_0x0192
        L_0x00cb:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r8 = (com.facebook.react.viewmanagers.SliderManagerInterface) r8
            if (r9 != 0) goto L_0x00d2
            goto L_0x00dc
        L_0x00d2:
            java.lang.Double r9 = (java.lang.Double) r9
            int r9 = r9.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
        L_0x00dc:
            r8.setThumbTintColor(r7, r5)
            goto L_0x0192
        L_0x00e1:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r8 = (com.facebook.react.viewmanagers.SliderManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setThumbImage(r7, r9)
            goto L_0x0192
        L_0x00ec:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r8 = (com.facebook.react.viewmanagers.SliderManagerInterface) r8
            if (r9 != 0) goto L_0x00f5
            java.lang.String r9 = ""
            goto L_0x00f7
        L_0x00f5:
            java.lang.String r9 = (java.lang.String) r9
        L_0x00f7:
            r8.setTestID(r7, r9)
            goto L_0x0192
        L_0x00fc:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r8 = (com.facebook.react.viewmanagers.SliderManagerInterface) r8
            if (r9 != 0) goto L_0x0103
            goto L_0x0109
        L_0x0103:
            java.lang.Double r9 = (java.lang.Double) r9
            double r3 = r9.doubleValue()
        L_0x0109:
            r8.setStep(r7, r3)
            goto L_0x0192
        L_0x010e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r8 = (com.facebook.react.viewmanagers.SliderManagerInterface) r8
            if (r9 != 0) goto L_0x0115
            goto L_0x011b
        L_0x0115:
            java.lang.Double r9 = (java.lang.Double) r9
            double r3 = r9.doubleValue()
        L_0x011b:
            r8.setMinimumValue(r7, r3)
            goto L_0x0192
        L_0x0120:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r8 = (com.facebook.react.viewmanagers.SliderManagerInterface) r8
            if (r9 != 0) goto L_0x0127
            goto L_0x0131
        L_0x0127:
            java.lang.Double r9 = (java.lang.Double) r9
            int r9 = r9.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
        L_0x0131:
            r8.setMinimumTrackTintColor(r7, r5)
            goto L_0x0192
        L_0x0135:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r8 = (com.facebook.react.viewmanagers.SliderManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setMinimumTrackImage(r7, r9)
            goto L_0x0192
        L_0x013f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r8 = (com.facebook.react.viewmanagers.SliderManagerInterface) r8
            if (r9 != 0) goto L_0x0148
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L_0x014e
        L_0x0148:
            java.lang.Double r9 = (java.lang.Double) r9
            double r0 = r9.doubleValue()
        L_0x014e:
            r8.setMaximumValue(r7, r0)
            goto L_0x0192
        L_0x0152:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r8 = (com.facebook.react.viewmanagers.SliderManagerInterface) r8
            if (r9 != 0) goto L_0x0159
            goto L_0x0163
        L_0x0159:
            java.lang.Double r9 = (java.lang.Double) r9
            int r9 = r9.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
        L_0x0163:
            r8.setMaximumTrackTintColor(r7, r5)
            goto L_0x0192
        L_0x0167:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r8 = (com.facebook.react.viewmanagers.SliderManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setMaximumTrackImage(r7, r9)
            goto L_0x0192
        L_0x0171:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r8 = (com.facebook.react.viewmanagers.SliderManagerInterface) r8
            if (r9 != 0) goto L_0x0178
            goto L_0x017e
        L_0x0178:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x017e:
            r8.setEnabled(r7, r2)
            goto L_0x0192
        L_0x0182:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r8 = (com.facebook.react.viewmanagers.SliderManagerInterface) r8
            if (r9 != 0) goto L_0x0189
            goto L_0x018f
        L_0x0189:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r1 = r9.booleanValue()
        L_0x018f:
            r8.setDisabled(r7, r1)
        L_0x0192:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.SliderManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
