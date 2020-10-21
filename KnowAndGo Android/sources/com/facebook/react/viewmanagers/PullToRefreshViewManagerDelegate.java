package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface;

public class PullToRefreshViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & PullToRefreshViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public PullToRefreshViewManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r4, java.lang.String r5, @androidx.annotation.Nullable java.lang.Object r6) {
        /*
            r3 = this;
            int r0 = r5.hashCode()
            r1 = -1799367701(0xffffffff94bfd3eb, float:-1.9369658E-26)
            r2 = 0
            if (r0 == r1) goto L_0x0038
            r1 = -321826009(0xffffffffecd15327, float:-2.0244654E27)
            if (r0 == r1) goto L_0x002e
            r1 = 110371416(0x6942258, float:5.5721876E-35)
            if (r0 == r1) goto L_0x0024
            r1 = 1327599912(0x4f219128, float:2.71064474E9)
            if (r0 == r1) goto L_0x001a
            goto L_0x0042
        L_0x001a:
            java.lang.String r0 = "tintColor"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0042
            r0 = 0
            goto L_0x0043
        L_0x0024:
            java.lang.String r0 = "title"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0042
            r0 = 2
            goto L_0x0043
        L_0x002e:
            java.lang.String r0 = "refreshing"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0042
            r0 = 3
            goto L_0x0043
        L_0x0038:
            java.lang.String r0 = "titleColor"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0042
            r0 = 1
            goto L_0x0043
        L_0x0042:
            r0 = -1
        L_0x0043:
            r1 = 0
            switch(r0) {
                case 0: goto L_0x007f;
                case 1: goto L_0x006a;
                case 2: goto L_0x005c;
                case 3: goto L_0x004b;
                default: goto L_0x0047;
            }
        L_0x0047:
            super.setProperty(r4, r5, r6)
            goto L_0x0093
        L_0x004b:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface r5 = (com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface) r5
            if (r6 != 0) goto L_0x0052
            goto L_0x0058
        L_0x0052:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r2 = r6.booleanValue()
        L_0x0058:
            r5.setRefreshing(r4, r2)
            goto L_0x0093
        L_0x005c:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface r5 = (com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface) r5
            if (r6 != 0) goto L_0x0063
            goto L_0x0066
        L_0x0063:
            r1 = r6
            java.lang.String r1 = (java.lang.String) r1
        L_0x0066:
            r5.setTitle(r4, r1)
            goto L_0x0093
        L_0x006a:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface r5 = (com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface) r5
            if (r6 != 0) goto L_0x0071
            goto L_0x007b
        L_0x0071:
            java.lang.Double r6 = (java.lang.Double) r6
            int r6 = r6.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
        L_0x007b:
            r5.setTitleColor(r4, r1)
            goto L_0x0093
        L_0x007f:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface r5 = (com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface) r5
            if (r6 != 0) goto L_0x0086
            goto L_0x0090
        L_0x0086:
            java.lang.Double r6 = (java.lang.Double) r6
            int r6 = r6.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
        L_0x0090:
            r5.setTintColor(r4, r1)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.PullToRefreshViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }

    public void receiveCommand(PullToRefreshViewManagerInterface<T> pullToRefreshViewManagerInterface, T t, String str, ReadableArray readableArray) {
        if (((str.hashCode() == 513968928 && str.equals("setNativeRefreshing")) ? (char) 0 : 65535) == 0) {
            pullToRefreshViewManagerInterface.setNativeRefreshing(t, readableArray.getBoolean(0));
        }
    }
}
