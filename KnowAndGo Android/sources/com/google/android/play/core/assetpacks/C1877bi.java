package com.google.android.play.core.assetpacks;

import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.bi */
final class C1877bi extends AssetPackStates {

    /* renamed from: a */
    private final long f418a;

    /* renamed from: b */
    private final Map<String, AssetPackState> f419b;

    C1877bi(long j, Map<String, AssetPackState> map) {
        this.f418a = j;
        this.f419b = map;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackStates) {
            AssetPackStates assetPackStates = (AssetPackStates) obj;
            return this.f418a == assetPackStates.totalBytes() && this.f419b.equals(assetPackStates.packStates());
        }
    }

    public final int hashCode() {
        long j = this.f418a;
        return ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f419b.hashCode();
    }

    public final Map<String, AssetPackState> packStates() {
        return this.f419b;
    }

    public final String toString() {
        long j = this.f418a;
        String valueOf = String.valueOf(this.f419b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61);
        sb.append("AssetPackStates{totalBytes=");
        sb.append(j);
        sb.append(", packStates=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytes() {
        return this.f418a;
    }
}
