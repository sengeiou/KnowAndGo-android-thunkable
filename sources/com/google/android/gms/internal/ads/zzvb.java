package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzard
public final class zzvb {
    private final int zzbvw;
    private final int zzbvx;
    private final int zzbvy;
    private final zzva zzbvz = new zzvf();

    public zzvb(int i) {
        this.zzbvx = i;
        this.zzbvw = 6;
        this.zzbvy = 0;
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            sb.append(((String) obj).toLowerCase(Locale.US));
            sb.append(10);
        }
        return zzbm(sb.toString());
    }

    @VisibleForTesting
    private final String zzbm(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zzvd zzvd = new zzvd();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzbvx, new zzvc(this));
        for (String zzg : split) {
            String[] zzg2 = zzve.zzg(zzg, false);
            if (zzg2.length != 0) {
                zzvh.zza(zzg2, this.zzbvx, this.zzbvw, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzvd.write(this.zzbvz.zzbl(((zzvi) it.next()).zzbwd));
            } catch (IOException e) {
                zzawz.zzc("Error while writing hash to byteStream", e);
            }
        }
        return zzvd.toString();
    }
}
