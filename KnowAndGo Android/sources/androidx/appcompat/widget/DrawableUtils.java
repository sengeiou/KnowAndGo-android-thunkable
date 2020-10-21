package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.WrappedDrawable;

@SuppressLint({"RestrictedAPI"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int[] EMPTY_STATE_SET = new int[0];
    public static final Rect INSETS_NONE = new Rect();
    private static final String TAG = "DrawableUtils";
    private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
    private static Class<?> sInsetsClazz;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                sInsetsClazz = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    private DrawableUtils() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0098 A[Catch:{ Exception -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0099 A[Catch:{ Exception -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a0 A[Catch:{ Exception -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a7 A[Catch:{ Exception -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ae A[Catch:{ Exception -> 0x00b8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Rect getOpticalBounds(android.graphics.drawable.Drawable r10) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto L_0x0020
            android.graphics.Insets r10 = r10.getOpticalInsets()
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            int r1 = r10.left
            r0.left = r1
            int r1 = r10.right
            r0.right = r1
            int r1 = r10.top
            r0.top = r1
            int r10 = r10.bottom
            r0.bottom = r10
            return r0
        L_0x0020:
            java.lang.Class<?> r0 = sInsetsClazz
            if (r0 == 0) goto L_0x00bf
            android.graphics.drawable.Drawable r10 = androidx.core.graphics.drawable.DrawableCompat.unwrap(r10)     // Catch:{ Exception -> 0x00b8 }
            java.lang.Class r0 = r10.getClass()     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r1 = "getOpticalInsets"
            r2 = 0
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x00b8 }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r3)     // Catch:{ Exception -> 0x00b8 }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00b8 }
            java.lang.Object r10 = r0.invoke(r10, r1)     // Catch:{ Exception -> 0x00b8 }
            if (r10 == 0) goto L_0x00bf
            android.graphics.Rect r0 = new android.graphics.Rect     // Catch:{ Exception -> 0x00b8 }
            r0.<init>()     // Catch:{ Exception -> 0x00b8 }
            java.lang.Class<?> r1 = sInsetsClazz     // Catch:{ Exception -> 0x00b8 }
            java.lang.reflect.Field[] r1 = r1.getFields()     // Catch:{ Exception -> 0x00b8 }
            int r3 = r1.length     // Catch:{ Exception -> 0x00b8 }
            r4 = 0
        L_0x004a:
            if (r4 >= r3) goto L_0x00b7
            r5 = r1[r4]     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r6 = r5.getName()     // Catch:{ Exception -> 0x00b8 }
            r7 = -1
            int r8 = r6.hashCode()     // Catch:{ Exception -> 0x00b8 }
            r9 = -1383228885(0xffffffffad8d9a2b, float:-1.6098308E-11)
            if (r8 == r9) goto L_0x008a
            r9 = 115029(0x1c155, float:1.6119E-40)
            if (r8 == r9) goto L_0x0080
            r9 = 3317767(0x32a007, float:4.649182E-39)
            if (r8 == r9) goto L_0x0076
            r9 = 108511772(0x677c21c, float:4.6598146E-35)
            if (r8 == r9) goto L_0x006c
            goto L_0x0094
        L_0x006c:
            java.lang.String r8 = "right"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x00b8 }
            if (r6 == 0) goto L_0x0094
            r6 = 2
            goto L_0x0095
        L_0x0076:
            java.lang.String r8 = "left"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x00b8 }
            if (r6 == 0) goto L_0x0094
            r6 = 0
            goto L_0x0095
        L_0x0080:
            java.lang.String r8 = "top"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x00b8 }
            if (r6 == 0) goto L_0x0094
            r6 = 1
            goto L_0x0095
        L_0x008a:
            java.lang.String r8 = "bottom"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x00b8 }
            if (r6 == 0) goto L_0x0094
            r6 = 3
            goto L_0x0095
        L_0x0094:
            r6 = -1
        L_0x0095:
            switch(r6) {
                case 0: goto L_0x00ae;
                case 1: goto L_0x00a7;
                case 2: goto L_0x00a0;
                case 3: goto L_0x0099;
                default: goto L_0x0098;
            }     // Catch:{ Exception -> 0x00b8 }
        L_0x0098:
            goto L_0x00b4
        L_0x0099:
            int r5 = r5.getInt(r10)     // Catch:{ Exception -> 0x00b8 }
            r0.bottom = r5     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00b4
        L_0x00a0:
            int r5 = r5.getInt(r10)     // Catch:{ Exception -> 0x00b8 }
            r0.right = r5     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00b4
        L_0x00a7:
            int r5 = r5.getInt(r10)     // Catch:{ Exception -> 0x00b8 }
            r0.top = r5     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00b4
        L_0x00ae:
            int r5 = r5.getInt(r10)     // Catch:{ Exception -> 0x00b8 }
            r0.left = r5     // Catch:{ Exception -> 0x00b8 }
        L_0x00b4:
            int r4 = r4 + 1
            goto L_0x004a
        L_0x00b7:
            return r0
        L_0x00b8:
            java.lang.String r10 = "DrawableUtils"
            java.lang.String r0 = "Couldn't obtain the optical insets. Ignoring."
            android.util.Log.e(r10, r0)
        L_0x00bf:
            android.graphics.Rect r10 = INSETS_NONE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DrawableUtils.getOpticalBounds(android.graphics.drawable.Drawable):android.graphics.Rect");
    }

    static void fixDrawable(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && VECTOR_DRAWABLE_CLAZZ_NAME.equals(drawable.getClass().getName())) {
            fixVectorDrawableTinting(drawable);
        }
    }

    public static boolean canSafelyMutateDrawable(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
                return true;
            }
            for (Drawable canSafelyMutateDrawable : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                if (!canSafelyMutateDrawable(canSafelyMutateDrawable)) {
                    return false;
                }
            }
            return true;
        } else if (drawable instanceof WrappedDrawable) {
            return canSafelyMutateDrawable(((WrappedDrawable) drawable).getWrappedDrawable());
        } else {
            if (drawable instanceof DrawableWrapper) {
                return canSafelyMutateDrawable(((DrawableWrapper) drawable).getWrappedDrawable());
            }
            if (drawable instanceof ScaleDrawable) {
                return canSafelyMutateDrawable(((ScaleDrawable) drawable).getDrawable());
            }
            return true;
        }
    }

    private static void fixVectorDrawableTinting(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(CHECKED_STATE_SET);
        } else {
            drawable.setState(EMPTY_STATE_SET);
        }
        drawable.setState(state);
    }

    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
