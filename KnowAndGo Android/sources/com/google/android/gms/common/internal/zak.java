package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.C1618Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

final class zak implements PendingResultUtil.ResultConverter<R, T> {
    private final /* synthetic */ C1618Response zaoz;

    zak(C1618Response response) {
        this.zaoz = response;
    }

    public final /* synthetic */ Object convert(Result result) {
        this.zaoz.setResult(result);
        return this.zaoz;
    }
}
