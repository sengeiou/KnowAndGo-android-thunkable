package com.google.maps.android;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class PolyUtil {
    private static final double DEFAULT_TOLERANCE = 0.1d;

    private PolyUtil() {
    }

    private static double tanLatGC(double d, double d2, double d3, double d4) {
        return ((Math.tan(d) * Math.sin(d3 - d4)) + (Math.tan(d2) * Math.sin(d4))) / Math.sin(d3);
    }

    private static double mercatorLatRhumb(double d, double d2, double d3, double d4) {
        return ((MathUtil.mercator(d) * (d3 - d4)) + (MathUtil.mercator(d2) * d4)) / d3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean intersects(double r17, double r19, double r21, double r23, double r25, boolean r27) {
        /*
            r8 = 0
            r10 = 0
            int r11 = (r25 > r8 ? 1 : (r25 == r8 ? 0 : -1))
            if (r11 < 0) goto L_0x000b
            int r11 = (r25 > r21 ? 1 : (r25 == r21 ? 0 : -1))
            if (r11 >= 0) goto L_0x0013
        L_0x000b:
            int r11 = (r25 > r8 ? 1 : (r25 == r8 ? 0 : -1))
            if (r11 >= 0) goto L_0x0014
            int r11 = (r25 > r21 ? 1 : (r25 == r21 ? 0 : -1))
            if (r11 >= 0) goto L_0x0014
        L_0x0013:
            return r10
        L_0x0014:
            r11 = -4613618979930100456(0xbff921fb54442d18, double:-1.5707963267948966)
            int r13 = (r23 > r11 ? 1 : (r23 == r11 ? 0 : -1))
            if (r13 > 0) goto L_0x001e
            return r10
        L_0x001e:
            int r13 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x0096
            int r11 = (r19 > r11 ? 1 : (r19 == r11 ? 0 : -1))
            if (r11 <= 0) goto L_0x0096
            r11 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            int r13 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0096
            int r13 = (r19 > r11 ? 1 : (r19 == r11 ? 0 : -1))
            if (r13 < 0) goto L_0x0034
            goto L_0x0096
        L_0x0034:
            r13 = -4609115380302729960(0xc00921fb54442d18, double:-3.141592653589793)
            int r13 = (r21 > r13 ? 1 : (r21 == r13 ? 0 : -1))
            if (r13 > 0) goto L_0x003e
            return r10
        L_0x003e:
            r13 = 0
            double r13 = r21 - r25
            double r13 = r13 * r17
            double r15 = r19 * r25
            double r13 = r13 + r15
            double r13 = r13 / r21
            int r15 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r15 < 0) goto L_0x0055
            int r15 = (r19 > r8 ? 1 : (r19 == r8 ? 0 : -1))
            if (r15 < 0) goto L_0x0055
            int r15 = (r23 > r13 ? 1 : (r23 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x0055
            return r10
        L_0x0055:
            r15 = 1
            int r16 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r16 > 0) goto L_0x0063
            int r8 = (r19 > r8 ? 1 : (r19 == r8 ? 0 : -1))
            if (r8 > 0) goto L_0x0063
            int r8 = (r23 > r13 ? 1 : (r23 == r13 ? 0 : -1))
            if (r8 < 0) goto L_0x0063
            return r15
        L_0x0063:
            int r8 = (r23 > r11 ? 1 : (r23 == r11 ? 0 : -1))
            if (r8 < 0) goto L_0x0068
            return r15
        L_0x0068:
            if (r27 == 0) goto L_0x0080
            double r8 = java.lang.Math.tan(r23)
            r0 = r17
            r2 = r19
            r4 = r21
            r6 = r25
            double r0 = tanLatGC(r0, r2, r4, r6)
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x0095
        L_0x007e:
            r10 = 1
            goto L_0x0095
        L_0x0080:
            double r8 = com.google.maps.android.MathUtil.mercator(r23)
            r0 = r17
            r2 = r19
            r4 = r21
            r6 = r25
            double r0 = mercatorLatRhumb(r0, r2, r4, r6)
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x0095
            goto L_0x007e
        L_0x0095:
            return r10
        L_0x0096:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.PolyUtil.intersects(double, double, double, double, double, boolean):boolean");
    }

    public static boolean containsLocation(LatLng latLng, List<LatLng> list, boolean z) {
        return containsLocation(latLng.latitude, latLng.longitude, list, z);
    }

    public static boolean containsLocation(double d, double d2, List<LatLng> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return false;
        }
        double radians = Math.toRadians(d);
        double radians2 = Math.toRadians(d2);
        LatLng latLng = list.get(size - 1);
        double radians3 = Math.toRadians(latLng.latitude);
        double radians4 = Math.toRadians(latLng.longitude);
        double d3 = radians3;
        int i = 0;
        for (LatLng next : list) {
            double wrap = MathUtil.wrap(radians2 - radians4, -3.141592653589793d, 3.141592653589793d);
            if (radians == d3 && wrap == 0.0d) {
                return true;
            }
            double radians5 = Math.toRadians(next.latitude);
            double radians6 = Math.toRadians(next.longitude);
            if (intersects(d3, radians5, MathUtil.wrap(radians6 - radians4, -3.141592653589793d, 3.141592653589793d), radians, wrap, z)) {
                i++;
            }
            d3 = radians5;
            radians4 = radians6;
        }
        if ((i & 1) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isLocationOnEdge(LatLng latLng, List<LatLng> list, boolean z, double d) {
        return isLocationOnEdgeOrPath(latLng, list, true, z, d);
    }

    public static boolean isLocationOnEdge(LatLng latLng, List<LatLng> list, boolean z) {
        return isLocationOnEdge(latLng, list, z, DEFAULT_TOLERANCE);
    }

    public static boolean isLocationOnPath(LatLng latLng, List<LatLng> list, boolean z, double d) {
        return isLocationOnEdgeOrPath(latLng, list, false, z, d);
    }

    public static boolean isLocationOnPath(LatLng latLng, List<LatLng> list, boolean z) {
        return isLocationOnPath(latLng, list, z, DEFAULT_TOLERANCE);
    }

    private static boolean isLocationOnEdgeOrPath(LatLng latLng, List<LatLng> list, boolean z, boolean z2, double d) {
        int i;
        List<LatLng> list2;
        LatLng latLng2 = latLng;
        int size = list.size();
        if (size == 0) {
            return false;
        }
        double d2 = d / 6371009.0d;
        double hav = MathUtil.hav(d2);
        double radians = Math.toRadians(latLng2.latitude);
        double radians2 = Math.toRadians(latLng2.longitude);
        if (z) {
            i = size - 1;
            list2 = list;
        } else {
            list2 = list;
            i = 0;
        }
        LatLng latLng3 = list2.get(i);
        double radians3 = Math.toRadians(latLng3.latitude);
        double radians4 = Math.toRadians(latLng3.longitude);
        if (z2) {
            double d3 = radians3;
            double d4 = radians4;
            for (LatLng next : list) {
                double radians5 = Math.toRadians(next.latitude);
                double radians6 = Math.toRadians(next.longitude);
                if (isOnSegmentGC(d3, d4, radians5, radians6, radians, radians2, hav)) {
                    return true;
                }
                d4 = radians6;
                d3 = radians5;
            }
            return false;
        }
        double d5 = radians - d2;
        double d6 = radians + d2;
        double mercator = MathUtil.mercator(radians3);
        double mercator2 = MathUtil.mercator(radians);
        double[] dArr = new double[3];
        Iterator<LatLng> it = list.iterator();
        while (it.hasNext()) {
            LatLng next2 = it.next();
            double d7 = d6;
            double radians7 = Math.toRadians(next2.latitude);
            double mercator3 = MathUtil.mercator(radians7);
            Iterator<LatLng> it2 = it;
            double radians8 = Math.toRadians(next2.longitude);
            if (Math.max(radians3, radians7) >= d5 && Math.min(radians3, radians7) <= d7) {
                double wrap = MathUtil.wrap(radians8 - radians4, -3.141592653589793d, 3.141592653589793d);
                double wrap2 = MathUtil.wrap(radians2 - radians4, -3.141592653589793d, 3.141592653589793d);
                dArr[0] = wrap2;
                dArr[1] = wrap2 + 6.283185307179586d;
                dArr[2] = wrap2 - 6.283185307179586d;
                for (double d8 : dArr) {
                    double d9 = mercator3 - mercator;
                    double d10 = (wrap * wrap) + (d9 * d9);
                    double d11 = 0.0d;
                    if (d10 > 0.0d) {
                        d11 = MathUtil.clamp(((d8 * wrap) + ((mercator2 - mercator) * d9)) / d10, 0.0d, 1.0d);
                    }
                    if (MathUtil.havDistance(radians, MathUtil.inverseMercator(mercator + (d11 * d9)), d8 - (d11 * wrap)) < hav) {
                        return true;
                    }
                }
                continue;
            }
            radians4 = radians8;
            radians3 = radians7;
            mercator = mercator3;
            d6 = d7;
            it = it2;
        }
        return false;
    }

    private static double sinDeltaBearing(double d, double d2, double d3, double d4, double d5, double d6) {
        double sin = Math.sin(d);
        double cos = Math.cos(d3);
        double cos2 = Math.cos(d5);
        double d7 = d6 - d2;
        double d8 = d4 - d2;
        double sin2 = Math.sin(d7) * cos2;
        double sin3 = Math.sin(d8) * cos;
        double d9 = sin * 2.0d;
        double sin4 = Math.sin(d5 - d) + (cos2 * d9 * MathUtil.hav(d7));
        double sin5 = Math.sin(d3 - d) + (d9 * cos * MathUtil.hav(d8));
        double d10 = ((sin2 * sin2) + (sin4 * sin4)) * ((sin3 * sin3) + (sin5 * sin5));
        if (d10 <= 0.0d) {
            return 1.0d;
        }
        return ((sin2 * sin5) - (sin4 * sin3)) / Math.sqrt(d10);
    }

    private static boolean isOnSegmentGC(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        double havDistance = MathUtil.havDistance(d, d5, d2 - d6);
        if (havDistance <= d7) {
            return true;
        }
        double havDistance2 = MathUtil.havDistance(d3, d5, d4 - d6);
        if (havDistance2 <= d7) {
            return true;
        }
        double havFromSin = MathUtil.havFromSin(MathUtil.sinFromHav(havDistance) * sinDeltaBearing(d, d2, d3, d4, d5, d6));
        if (havFromSin > d7) {
            return false;
        }
        double havDistance3 = MathUtil.havDistance(d, d3, d2 - d4);
        double d8 = ((1.0d - (havDistance3 * 2.0d)) * havFromSin) + havDistance3;
        if (havDistance > d8 || havDistance2 > d8) {
            return false;
        }
        if (havDistance3 < 0.74d) {
            return true;
        }
        double d9 = 1.0d - (2.0d * havFromSin);
        if (MathUtil.sinSumFromHav((havDistance - havFromSin) / d9, (havDistance2 - havFromSin) / d9) > 0.0d) {
            return true;
        }
        return false;
    }

    public static List<LatLng> simplify(List<LatLng> list, double d) {
        List<LatLng> list2 = list;
        int size = list.size();
        if (size >= 1) {
            double d2 = 0.0d;
            if (d > 0.0d) {
                boolean isClosedPolygon = isClosedPolygon(list);
                LatLng latLng = null;
                if (isClosedPolygon) {
                    latLng = list2.get(list.size() - 1);
                    list2.remove(list.size() - 1);
                    list2.add(new LatLng(latLng.latitude + 1.0E-11d, latLng.longitude + 1.0E-11d));
                }
                Stack stack = new Stack();
                double[] dArr = new double[size];
                char c = 0;
                dArr[0] = 1.0d;
                int i = size - 1;
                dArr[i] = 1.0d;
                if (size > 2) {
                    stack.push(new int[]{0, i});
                    int i2 = 0;
                    while (stack.size() > 0) {
                        int[] iArr = (int[]) stack.pop();
                        int i3 = iArr[c] + 1;
                        double d3 = d2;
                        while (i3 < iArr[1]) {
                            double distanceToLine = distanceToLine(list2.get(i3), list2.get(iArr[c]), list2.get(iArr[1]));
                            if (distanceToLine > d3) {
                                d3 = distanceToLine;
                                i2 = i3;
                            }
                            i3++;
                            c = 0;
                        }
                        if (d3 > d) {
                            dArr[i2] = d3;
                            stack.push(new int[]{iArr[0], i2});
                            stack.push(new int[]{i2, iArr[1]});
                        }
                        d2 = 0.0d;
                        c = 0;
                    }
                }
                int i4 = 0;
                if (isClosedPolygon) {
                    list2.remove(list.size() - 1);
                    list2.add(latLng);
                }
                ArrayList arrayList = new ArrayList();
                for (LatLng next : list) {
                    if (dArr[i4] != 0.0d) {
                        arrayList.add(next);
                    }
                    i4++;
                }
                return arrayList;
            }
            throw new IllegalArgumentException("Tolerance must be greater than zero");
        }
        throw new IllegalArgumentException("Polyline must have at least 1 point");
    }

    public static boolean isClosedPolygon(List<LatLng> list) {
        if (list.get(0).equals(list.get(list.size() - 1))) {
            return true;
        }
        return false;
    }

    public static double distanceToLine(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng2.equals(latLng3)) {
            return SphericalUtil.computeDistanceBetween(latLng3, latLng);
        }
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        double radians3 = Math.toRadians(latLng2.latitude);
        double radians4 = Math.toRadians(latLng2.longitude);
        double radians5 = Math.toRadians(latLng3.latitude) - radians3;
        double radians6 = Math.toRadians(latLng3.longitude) - radians4;
        double d = (((radians - radians3) * radians5) + ((radians2 - radians4) * radians6)) / ((radians5 * radians5) + (radians6 * radians6));
        if (d <= 0.0d) {
            return SphericalUtil.computeDistanceBetween(latLng, latLng2);
        }
        if (d >= 1.0d) {
            return SphericalUtil.computeDistanceBetween(latLng, latLng3);
        }
        return SphericalUtil.computeDistanceBetween(new LatLng(latLng.latitude - latLng2.latitude, latLng.longitude - latLng2.longitude), new LatLng((latLng3.latitude - latLng2.latitude) * d, d * (latLng3.longitude - latLng2.longitude)));
    }

    public static List<LatLng> decode(String str) {
        int i;
        int i2;
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            int i6 = 1;
            int i7 = 0;
            while (true) {
                i = i3 + 1;
                int charAt = (str.charAt(i3) - '?') - 1;
                i6 += charAt << i7;
                i7 += 5;
                if (charAt < 31) {
                    break;
                }
                i3 = i;
            }
            int i8 = ((i6 & 1) != 0 ? ~(i6 >> 1) : i6 >> 1) + i4;
            int i9 = 1;
            int i10 = 0;
            while (true) {
                i2 = i + 1;
                int charAt2 = (str.charAt(i) - '?') - 1;
                i9 += charAt2 << i10;
                i10 += 5;
                if (charAt2 < 31) {
                    break;
                }
                i = i2;
            }
            i5 += (i9 & 1) != 0 ? ~(i9 >> 1) : i9 >> 1;
            arrayList.add(new LatLng(((double) i8) * 1.0E-5d, ((double) i5) * 1.0E-5d));
            i4 = i8;
            i3 = i2;
        }
        return arrayList;
    }

    public static String encode(List<LatLng> list) {
        StringBuffer stringBuffer = new StringBuffer();
        long j = 0;
        long j2 = 0;
        for (LatLng next : list) {
            long round = Math.round(next.latitude * 100000.0d);
            long round2 = Math.round(next.longitude * 100000.0d);
            encode(round - j, stringBuffer);
            encode(round2 - j2, stringBuffer);
            j = round;
            j2 = round2;
        }
        return stringBuffer.toString();
    }

    private static void encode(long j, StringBuffer stringBuffer) {
        long j2 = j < 0 ? ~(j << 1) : j << 1;
        while (j2 >= 32) {
            stringBuffer.append(Character.toChars((int) ((32 | (31 & j2)) + 63)));
            j2 >>= 5;
        }
        stringBuffer.append(Character.toChars((int) (j2 + 63)));
    }
}
