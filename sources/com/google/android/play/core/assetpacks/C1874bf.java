package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.bf */
final class C1874bf extends AssetLocation {

    /* renamed from: a */
    private final String f406a;

    /* renamed from: b */
    private final long f407b;

    /* renamed from: c */
    private final long f408c;

    C1874bf(String str, long j, long j2) {
        if (str != null) {
            this.f406a = str;
            this.f407b = j;
            this.f408c = j2;
            return;
        }
        throw new NullPointerException("Null path");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetLocation) {
            AssetLocation assetLocation = (AssetLocation) obj;
            return this.f406a.equals(assetLocation.path()) && this.f407b == assetLocation.offset() && this.f408c == assetLocation.size();
        }
    }

    public final int hashCode() {
        int hashCode = this.f406a.hashCode();
        long j = this.f407b;
        long j2 = this.f408c;
        return ((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2));
    }

    public final long offset() {
        return this.f407b;
    }

    public final String path() {
        return this.f406a;
    }

    public final long size() {
        return this.f408c;
    }

    public final String toString() {
        String str = this.f406a;
        long j = this.f407b;
        long j2 = this.f408c;
        StringBuilder sb = new StringBuilder(str.length() + 76);
        sb.append("AssetLocation{path=");
        sb.append(str);
        sb.append(", offset=");
        sb.append(j);
        sb.append(", size=");
        sb.append(j2);
        sb.append("}");
        return sb.toString();
    }
}
