package com.uxcam.internals;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* renamed from: com.uxcam.internals.jx */
public final class C3316jx {

    /* renamed from: com.uxcam.internals.jx$aa */
    public static class C3317aa {

        /* renamed from: a */
        public Object f2856a;

        /* renamed from: b */
        public Object f2857b;

        public C3317aa(Object obj, Object obj2) {
            this.f2856a = obj;
            this.f2857b = obj2;
        }
    }

    /* renamed from: a */
    public static C3317aa m2362a(List list, C3240hj hjVar, long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ListIterator listIterator = list.listIterator();
        long j2 = 0;
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            C3268ii iiVar = (C3268ii) listIterator.next();
            if (iiVar.f2639a + j2 > j) {
                long j3 = (long) ((int) (j - j2));
                int i = (int) ((((long) hjVar.f2537a) * j3) / ((long) hjVar.f2538b));
                C3268ii iiVar2 = new C3268ii(j3, iiVar.f2640b);
                C3268ii iiVar3 = new C3268ii(iiVar.f2639a - j3, ((long) i) + iiVar.f2640b);
                listIterator.remove();
                if (iiVar2.f2639a > 0) {
                    listIterator.add(iiVar2);
                    arrayList.add(iiVar2);
                }
                if (iiVar3.f2639a > 0) {
                    listIterator.add(iiVar3);
                    arrayList2.add(iiVar3);
                }
            } else {
                arrayList.add(iiVar);
                j2 += iiVar.f2639a;
            }
        }
        while (listIterator.hasNext()) {
            arrayList2.add(listIterator.next());
        }
        return new C3317aa(arrayList, arrayList2);
    }
}
