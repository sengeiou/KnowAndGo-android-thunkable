package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.exoplayer2.C1470C;
import com.google.android.gms.internal.vision.zzac;
import com.google.android.gms.internal.vision.zzw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
public class TextBlock implements Text {
    private Point[] cornerPoints;
    private zzac[] zzea;
    private List<Line> zzeb;
    private String zzec;
    private Rect zzed;

    TextBlock(SparseArray<zzac> sparseArray) {
        this.zzea = new zzac[sparseArray.size()];
        for (int i = 0; i < this.zzea.length; i++) {
            this.zzea[i] = sparseArray.valueAt(i);
        }
    }

    public String getLanguage() {
        if (this.zzec != null) {
            return this.zzec;
        }
        HashMap hashMap = new HashMap();
        for (zzac zzac : this.zzea) {
            hashMap.put(zzac.zzec, Integer.valueOf((hashMap.containsKey(zzac.zzec) ? ((Integer) hashMap.get(zzac.zzec)).intValue() : 0) + 1));
        }
        this.zzec = (String) ((Map.Entry) Collections.max(hashMap.entrySet(), new zza(this))).getKey();
        if (this.zzec == null || this.zzec.isEmpty()) {
            this.zzec = C1470C.LANGUAGE_UNDETERMINED;
        }
        return this.zzec;
    }

    public String getValue() {
        if (this.zzea.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(this.zzea[0].zzel);
        for (int i = 1; i < this.zzea.length; i++) {
            sb.append("\n");
            sb.append(this.zzea[i].zzel);
        }
        return sb.toString();
    }

    public Point[] getCornerPoints() {
        if (this.cornerPoints == null) {
            char c = 0;
            if (this.zzea.length == 0) {
                this.cornerPoints = new Point[0];
            } else {
                int i = Integer.MAX_VALUE;
                int i2 = 0;
                int i3 = Integer.MAX_VALUE;
                int i4 = Integer.MIN_VALUE;
                int i5 = Integer.MIN_VALUE;
                while (i2 < this.zzea.length) {
                    zzw zzw = this.zzea[i2].zzei;
                    zzw zzw2 = this.zzea[c].zzei;
                    double sin = Math.sin(Math.toRadians((double) zzw2.zzeg));
                    double cos = Math.cos(Math.toRadians((double) zzw2.zzeg));
                    Point[] pointArr = new Point[4];
                    int i6 = i5;
                    pointArr[0] = new Point(zzw.left, zzw.top);
                    pointArr[0].offset(-zzw2.left, -zzw2.top);
                    int i7 = (int) ((((double) pointArr[0].x) * cos) + (((double) pointArr[0].y) * sin));
                    int i8 = (int) ((((double) (-pointArr[0].x)) * sin) + (((double) pointArr[0].y) * cos));
                    pointArr[0].x = i7;
                    pointArr[0].y = i8;
                    pointArr[1] = new Point(zzw.width + i7, i8);
                    pointArr[2] = new Point(zzw.width + i7, zzw.height + i8);
                    pointArr[3] = new Point(i7, i8 + zzw.height);
                    i5 = i6;
                    i = i;
                    for (int i9 = 0; i9 < 4; i9++) {
                        Point point = pointArr[i9];
                        i = Math.min(i, point.x);
                        i4 = Math.max(i4, point.x);
                        i3 = Math.min(i3, point.y);
                        i5 = Math.max(i5, point.y);
                    }
                    i2++;
                    c = 0;
                }
                int i10 = i;
                int i11 = i5;
                zzw zzw3 = this.zzea[0].zzei;
                int i12 = zzw3.left;
                int i13 = zzw3.top;
                double sin2 = Math.sin(Math.toRadians((double) zzw3.zzeg));
                double cos2 = Math.cos(Math.toRadians((double) zzw3.zzeg));
                int i14 = i10;
                int i15 = i11;
                Point[] pointArr2 = {new Point(i14, i3), new Point(i4, i3), new Point(i4, i15), new Point(i14, i15)};
                for (int i16 = 0; i16 < 4; i16++) {
                    pointArr2[i16].x = (int) ((((double) pointArr2[i16].x) * cos2) - (((double) pointArr2[i16].y) * sin2));
                    pointArr2[i16].y = (int) ((((double) pointArr2[i16].x) * sin2) + (((double) pointArr2[i16].y) * cos2));
                    i12 = i12;
                    pointArr2[i16].offset(i12, i13);
                }
                this.cornerPoints = pointArr2;
            }
        }
        return this.cornerPoints;
    }

    public List<? extends Text> getComponents() {
        if (this.zzea.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzeb == null) {
            this.zzeb = new ArrayList(this.zzea.length);
            for (zzac line : this.zzea) {
                this.zzeb.add(new Line(line));
            }
        }
        return this.zzeb;
    }

    public Rect getBoundingBox() {
        if (this.zzed == null) {
            this.zzed = zzc.zza((Text) this);
        }
        return this.zzed;
    }
}
