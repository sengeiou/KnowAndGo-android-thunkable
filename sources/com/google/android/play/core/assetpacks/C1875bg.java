package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import com.google.android.play.core.assetpacks.model.AssetPackStorageMethod;

/* renamed from: com.google.android.play.core.assetpacks.bg */
final class C1875bg extends AssetPackLocation {

    /* renamed from: a */
    private final int f409a;

    /* renamed from: b */
    private final String f410b;

    /* renamed from: c */
    private final String f411c;

    C1875bg(int i, @Nullable String str, @Nullable String str2) {
        this.f409a = i;
        this.f410b = str;
        this.f411c = str2;
    }

    @Nullable
    public final String assetsPath() {
        return this.f411c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        r1 = r4.f411c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r1 = r4.f410b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.play.core.assetpacks.AssetPackLocation
            r2 = 0
            if (r1 == 0) goto L_0x003f
            com.google.android.play.core.assetpacks.AssetPackLocation r5 = (com.google.android.play.core.assetpacks.AssetPackLocation) r5
            int r1 = r4.f409a
            int r3 = r5.packStorageMethod()
            if (r1 != r3) goto L_0x003f
            java.lang.String r1 = r4.f410b
            if (r1 != 0) goto L_0x001e
            java.lang.String r1 = r5.path()
            if (r1 != 0) goto L_0x003f
            goto L_0x0028
        L_0x001e:
            java.lang.String r3 = r5.path()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x003f
        L_0x0028:
            java.lang.String r1 = r4.f411c
            if (r1 != 0) goto L_0x0033
            java.lang.String r5 = r5.assetsPath()
            if (r5 != 0) goto L_0x003f
            goto L_0x003e
        L_0x0033:
            java.lang.String r5 = r5.assetsPath()
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            return r0
        L_0x003f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C1875bg.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i = (this.f409a ^ 1000003) * 1000003;
        String str = this.f410b;
        int i2 = 0;
        int hashCode = (i ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f411c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode ^ i2;
    }

    @AssetPackStorageMethod
    public final int packStorageMethod() {
        return this.f409a;
    }

    @Nullable
    public final String path() {
        return this.f410b;
    }

    public final String toString() {
        int i = this.f409a;
        String str = this.f410b;
        String str2 = this.f411c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str2).length());
        sb.append("AssetPackLocation{packStorageMethod=");
        sb.append(i);
        sb.append(", path=");
        sb.append(str);
        sb.append(", assetsPath=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
