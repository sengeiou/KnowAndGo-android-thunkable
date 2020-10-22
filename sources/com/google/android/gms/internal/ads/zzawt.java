package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import javax.annotation.concurrent.GuardedBy;

@zzard
public final class zzawt {
    @GuardedBy("this")
    private String zzdlo = "0";
    @GuardedBy("this")
    private BigInteger zzdun = BigInteger.ONE;

    public final synchronized String zzvg() {
        String bigInteger;
        bigInteger = this.zzdun.toString();
        this.zzdun = this.zzdun.add(BigInteger.ONE);
        this.zzdlo = bigInteger;
        return bigInteger;
    }

    public final synchronized String zzvh() {
        return this.zzdlo;
    }
}
