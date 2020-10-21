package com.google.android.play.core.review;

import android.app.PendingIntent;

/* renamed from: com.google.android.play.core.review.a */
final class C2072a extends ReviewInfo {

    /* renamed from: a */
    private final PendingIntent f806a;

    C2072a(PendingIntent pendingIntent) {
        if (pendingIntent != null) {
            this.f806a = pendingIntent;
            return;
        }
        throw new NullPointerException("Null pendingIntent");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final PendingIntent mo33669a() {
        return this.f806a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReviewInfo) {
            return this.f806a.equals(((ReviewInfo) obj).mo33669a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f806a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f806a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
        sb.append("ReviewInfo{pendingIntent=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }
}
