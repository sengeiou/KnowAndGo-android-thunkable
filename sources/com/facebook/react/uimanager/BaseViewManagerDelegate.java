package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerInterface;

public abstract class BaseViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T>> implements ViewManagerDelegate<T> {
    protected final U mViewManager;

    public BaseViewManagerDelegate(U u) {
        this.mViewManager = u;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: boolean} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, @androidx.annotation.Nullable java.lang.Object r7) {
        /*
            r4 = this;
            int r0 = r6.hashCode()
            r1 = 0
            switch(r0) {
                case -1721943862: goto L_0x011b;
                case -1721943861: goto L_0x0110;
                case -1267206133: goto L_0x0105;
                case -1228066334: goto L_0x00fa;
                case -908189618: goto L_0x00ef;
                case -908189617: goto L_0x00e4;
                case -877170387: goto L_0x00d9;
                case -731417480: goto L_0x00cd;
                case -101663499: goto L_0x00c3;
                case -101359900: goto L_0x00b8;
                case -80891667: goto L_0x00ac;
                case -40300674: goto L_0x00a0;
                case -4379043: goto L_0x0094;
                case 36255470: goto L_0x0089;
                case 333432965: goto L_0x007d;
                case 581268560: goto L_0x0071;
                case 588239831: goto L_0x0065;
                case 746986311: goto L_0x0059;
                case 1052666732: goto L_0x004d;
                case 1146842694: goto L_0x0042;
                case 1153872867: goto L_0x0037;
                case 1287124693: goto L_0x002c;
                case 1349188574: goto L_0x0021;
                case 1505602511: goto L_0x0016;
                case 2045685618: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0126
        L_0x000a:
            java.lang.String r0 = "nativeID"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 14
            goto L_0x0127
        L_0x0016:
            java.lang.String r0 = "accessibilityActions"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 0
            goto L_0x0127
        L_0x0021:
            java.lang.String r0 = "borderRadius"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 7
            goto L_0x0127
        L_0x002c:
            java.lang.String r0 = "backgroundColor"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 6
            goto L_0x0127
        L_0x0037:
            java.lang.String r0 = "accessibilityState"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 5
            goto L_0x0127
        L_0x0042:
            java.lang.String r0 = "accessibilityLabel"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 2
            goto L_0x0127
        L_0x004d:
            java.lang.String r0 = "transform"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 21
            goto L_0x0127
        L_0x0059:
            java.lang.String r0 = "importantForAccessibility"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 13
            goto L_0x0127
        L_0x0065:
            java.lang.String r0 = "borderBottomRightRadius"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 9
            goto L_0x0127
        L_0x0071:
            java.lang.String r0 = "borderBottomLeftRadius"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 8
            goto L_0x0127
        L_0x007d:
            java.lang.String r0 = "borderTopRightRadius"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 11
            goto L_0x0127
        L_0x0089:
            java.lang.String r0 = "accessibilityLiveRegion"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 3
            goto L_0x0127
        L_0x0094:
            java.lang.String r0 = "elevation"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 12
            goto L_0x0127
        L_0x00a0:
            java.lang.String r0 = "rotation"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 17
            goto L_0x0127
        L_0x00ac:
            java.lang.String r0 = "renderToHardwareTextureAndroid"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 16
            goto L_0x0127
        L_0x00b8:
            java.lang.String r0 = "accessibilityRole"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 4
            goto L_0x0127
        L_0x00c3:
            java.lang.String r0 = "accessibilityHint"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 1
            goto L_0x0127
        L_0x00cd:
            java.lang.String r0 = "zIndex"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 24
            goto L_0x0127
        L_0x00d9:
            java.lang.String r0 = "testID"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 20
            goto L_0x0127
        L_0x00e4:
            java.lang.String r0 = "scaleY"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 19
            goto L_0x0127
        L_0x00ef:
            java.lang.String r0 = "scaleX"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 18
            goto L_0x0127
        L_0x00fa:
            java.lang.String r0 = "borderTopLeftRadius"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 10
            goto L_0x0127
        L_0x0105:
            java.lang.String r0 = "opacity"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 15
            goto L_0x0127
        L_0x0110:
            java.lang.String r0 = "translateY"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 23
            goto L_0x0127
        L_0x011b:
            java.lang.String r0 = "translateX"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0126
            r6 = 22
            goto L_0x0127
        L_0x0126:
            r6 = -1
        L_0x0127:
            r0 = 1065353216(0x3f800000, float:1.0)
            r2 = 0
            r3 = 2143289344(0x7fc00000, float:NaN)
            switch(r6) {
                case 0: goto L_0x0269;
                case 1: goto L_0x0261;
                case 2: goto L_0x0259;
                case 3: goto L_0x0251;
                case 4: goto L_0x0249;
                case 5: goto L_0x0241;
                case 6: goto L_0x0232;
                case 7: goto L_0x0223;
                case 8: goto L_0x0214;
                case 9: goto L_0x0205;
                case 10: goto L_0x01f5;
                case 11: goto L_0x01e5;
                case 12: goto L_0x01d5;
                case 13: goto L_0x01cc;
                case 14: goto L_0x01c3;
                case 15: goto L_0x01b3;
                case 16: goto L_0x01a3;
                case 17: goto L_0x0193;
                case 18: goto L_0x0183;
                case 19: goto L_0x0173;
                case 20: goto L_0x016a;
                case 21: goto L_0x0161;
                case 22: goto L_0x0151;
                case 23: goto L_0x0141;
                case 24: goto L_0x0131;
                default: goto L_0x012f;
            }
        L_0x012f:
            goto L_0x0270
        L_0x0131:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0136
            goto L_0x013c
        L_0x0136:
            java.lang.Double r7 = (java.lang.Double) r7
            float r2 = r7.floatValue()
        L_0x013c:
            r6.setZIndex(r5, r2)
            goto L_0x0270
        L_0x0141:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0146
            goto L_0x014c
        L_0x0146:
            java.lang.Double r7 = (java.lang.Double) r7
            float r2 = r7.floatValue()
        L_0x014c:
            r6.setTranslateY(r5, r2)
            goto L_0x0270
        L_0x0151:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0156
            goto L_0x015c
        L_0x0156:
            java.lang.Double r7 = (java.lang.Double) r7
            float r2 = r7.floatValue()
        L_0x015c:
            r6.setTranslateX(r5, r2)
            goto L_0x0270
        L_0x0161:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setTransform(r5, r7)
            goto L_0x0270
        L_0x016a:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setTestId(r5, r7)
            goto L_0x0270
        L_0x0173:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0178
            goto L_0x017e
        L_0x0178:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x017e:
            r6.setScaleY(r5, r0)
            goto L_0x0270
        L_0x0183:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0188
            goto L_0x018e
        L_0x0188:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x018e:
            r6.setScaleX(r5, r0)
            goto L_0x0270
        L_0x0193:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0198
            goto L_0x019e
        L_0x0198:
            java.lang.Double r7 = (java.lang.Double) r7
            float r2 = r7.floatValue()
        L_0x019e:
            r6.setRotation(r5, r2)
            goto L_0x0270
        L_0x01a3:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01a8
            goto L_0x01ae
        L_0x01a8:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x01ae:
            r6.setRenderToHardwareTexture(r5, r1)
            goto L_0x0270
        L_0x01b3:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01b8
            goto L_0x01be
        L_0x01b8:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x01be:
            r6.setOpacity(r5, r0)
            goto L_0x0270
        L_0x01c3:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setNativeId(r5, r7)
            goto L_0x0270
        L_0x01cc:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setImportantForAccessibility(r5, r7)
            goto L_0x0270
        L_0x01d5:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01da
            goto L_0x01e0
        L_0x01da:
            java.lang.Double r7 = (java.lang.Double) r7
            float r2 = r7.floatValue()
        L_0x01e0:
            r6.setElevation(r5, r2)
            goto L_0x0270
        L_0x01e5:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01ea
            goto L_0x01f0
        L_0x01ea:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x01f0:
            r6.setBorderTopRightRadius(r5, r3)
            goto L_0x0270
        L_0x01f5:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01fa
            goto L_0x0200
        L_0x01fa:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x0200:
            r6.setBorderTopLeftRadius(r5, r3)
            goto L_0x0270
        L_0x0205:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x020a
            goto L_0x0210
        L_0x020a:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x0210:
            r6.setBorderBottomRightRadius(r5, r3)
            goto L_0x0270
        L_0x0214:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0219
            goto L_0x021f
        L_0x0219:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x021f:
            r6.setBorderBottomLeftRadius(r5, r3)
            goto L_0x0270
        L_0x0223:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0228
            goto L_0x022e
        L_0x0228:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x022e:
            r6.setBorderRadius(r5, r3)
            goto L_0x0270
        L_0x0232:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0237
            goto L_0x023d
        L_0x0237:
            java.lang.Double r7 = (java.lang.Double) r7
            int r1 = r7.intValue()
        L_0x023d:
            r6.setBackgroundColor(r5, r1)
            goto L_0x0270
        L_0x0241:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableMap r7 = (com.facebook.react.bridge.ReadableMap) r7
            r6.setViewState(r5, r7)
            goto L_0x0270
        L_0x0249:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityRole(r5, r7)
            goto L_0x0270
        L_0x0251:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityLiveRegion(r5, r7)
            goto L_0x0270
        L_0x0259:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityLabel(r5, r7)
            goto L_0x0270
        L_0x0261:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityHint(r5, r7)
            goto L_0x0270
        L_0x0269:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setAccessibilityActions(r5, r7)
        L_0x0270:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
