package com.google.maps.android.heatmaps;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.collection.LongSparseArray;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.quadtree.PointQuadTree;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT = new Gradient(DEFAULT_GRADIENT_COLORS, DEFAULT_GRADIENT_START_POINTS);
    private static final int[] DEFAULT_GRADIENT_COLORS = {Color.rgb(102, JfifUtil.MARKER_APP1, 0), Color.rgb(255, 0, 0)};
    private static final float[] DEFAULT_GRADIENT_START_POINTS = {0.2f, 1.0f};
    private static final int DEFAULT_MAX_ZOOM = 11;
    private static final int DEFAULT_MIN_ZOOM = 5;
    public static final double DEFAULT_OPACITY = 0.7d;
    public static final int DEFAULT_RADIUS = 20;
    private static final int MAX_RADIUS = 50;
    private static final int MAX_ZOOM_LEVEL = 22;
    private static final int MIN_RADIUS = 10;
    private static final int SCREEN_SIZE = 1280;
    private static final int TILE_DIM = 512;
    static final double WORLD_WIDTH = 1.0d;
    private Bounds mBounds;
    private int[] mColorMap;
    private Collection<WeightedLatLng> mData;
    private Gradient mGradient;
    private double[] mKernel;
    private double[] mMaxIntensity;
    private double mOpacity;
    private int mRadius;
    private PointQuadTree<WeightedLatLng> mTree;

    public static class Builder {
        /* access modifiers changed from: private */
        public Collection<WeightedLatLng> data;
        /* access modifiers changed from: private */
        public Gradient gradient = HeatmapTileProvider.DEFAULT_GRADIENT;
        /* access modifiers changed from: private */
        public double opacity = 0.7d;
        /* access modifiers changed from: private */
        public int radius = 20;

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.wrapData(collection));
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.data = collection;
            if (!this.data.isEmpty()) {
                return this;
            }
            throw new IllegalArgumentException("No input points.");
        }

        public Builder radius(int i) {
            this.radius = i;
            if (this.radius >= 10 && this.radius <= 50) {
                return this;
            }
            throw new IllegalArgumentException("Radius not within bounds.");
        }

        public Builder gradient(Gradient gradient2) {
            this.gradient = gradient2;
            return this;
        }

        public Builder opacity(double d) {
            this.opacity = d;
            if (this.opacity >= 0.0d && this.opacity <= 1.0d) {
                return this;
            }
            throw new IllegalArgumentException("Opacity must be in range [0, 1]");
        }

        public HeatmapTileProvider build() {
            if (this.data != null) {
                return new HeatmapTileProvider(this);
            }
            throw new IllegalStateException("No input data: you must use either .data or .weightedData before building");
        }
    }

    private HeatmapTileProvider(Builder builder) {
        this.mData = builder.data;
        this.mRadius = builder.radius;
        this.mGradient = builder.gradient;
        this.mOpacity = builder.opacity;
        this.mKernel = generateKernel(this.mRadius, ((double) this.mRadius) / 3.0d);
        setGradient(this.mGradient);
        setWeightedData(this.mData);
    }

    public void setWeightedData(Collection<WeightedLatLng> collection) {
        this.mData = collection;
        if (!this.mData.isEmpty()) {
            this.mBounds = getBounds(this.mData);
            this.mTree = new PointQuadTree<>(this.mBounds);
            for (WeightedLatLng add : this.mData) {
                this.mTree.add(add);
            }
            this.mMaxIntensity = getMaxIntensities(this.mRadius);
            return;
        }
        throw new IllegalArgumentException("No input points.");
    }

    public void setData(Collection<LatLng> collection) {
        setWeightedData(wrapData(collection));
    }

    /* access modifiers changed from: private */
    public static Collection<WeightedLatLng> wrapData(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng weightedLatLng : collection) {
            arrayList.add(new WeightedLatLng(weightedLatLng));
        }
        return arrayList;
    }

    public Tile getTile(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        double d = 1.0d;
        double pow = 1.0d / Math.pow(2.0d, (double) i6);
        double d2 = (((double) this.mRadius) * pow) / 512.0d;
        double d3 = ((2.0d * d2) + pow) / ((double) ((this.mRadius * 2) + 512));
        double d4 = (((double) i4) * pow) - d2;
        double d5 = (((double) (i4 + 1)) * pow) + d2;
        double d6 = (((double) i5) * pow) - d2;
        double d7 = (((double) (i5 + 1)) * pow) + d2;
        Collection<WeightedLatLng> arrayList = new ArrayList<>();
        if (d4 < 0.0d) {
            d = -1.0d;
            arrayList = this.mTree.search(new Bounds(d4 + 1.0d, 1.0d, d6, d7));
        } else if (d5 > 1.0d) {
            arrayList = this.mTree.search(new Bounds(0.0d, d5 - 1.0d, d6, d7));
        } else {
            d = 0.0d;
        }
        Bounds bounds = new Bounds(d4, d5, d6, d7);
        if (!bounds.intersects(new Bounds(this.mBounds.minX - d2, this.mBounds.maxX + d2, this.mBounds.minY - d2, this.mBounds.maxY + d2))) {
            return TileProvider.NO_TILE;
        }
        Collection<WeightedLatLng> search = this.mTree.search(bounds);
        if (search.isEmpty()) {
            return TileProvider.NO_TILE;
        }
        double[][] dArr = (double[][]) Array.newInstance(double.class, new int[]{(this.mRadius * 2) + 512, (this.mRadius * 2) + 512});
        for (WeightedLatLng next : search) {
            Point point = next.getPoint();
            int i7 = (int) ((point.f1043x - d4) / d3);
            int i8 = (int) ((point.f1044y - d6) / d3);
            double[] dArr2 = dArr[i7];
            dArr2[i8] = dArr2[i8] + next.getIntensity();
        }
        for (WeightedLatLng next2 : arrayList) {
            Point point2 = next2.getPoint();
            int i9 = (int) ((point2.f1044y - d6) / d3);
            double[] dArr3 = dArr[(int) (((point2.f1043x + d) - d4) / d3)];
            dArr3[i9] = dArr3[i9] + next2.getIntensity();
        }
        return convertBitmap(colorize(convolve(dArr, this.mKernel), this.mColorMap, this.mMaxIntensity[i6]));
    }

    public void setGradient(Gradient gradient) {
        this.mGradient = gradient;
        this.mColorMap = gradient.generateColorMap(this.mOpacity);
    }

    public void setRadius(int i) {
        this.mRadius = i;
        this.mKernel = generateKernel(this.mRadius, ((double) this.mRadius) / 3.0d);
        this.mMaxIntensity = getMaxIntensities(this.mRadius);
    }

    public void setOpacity(double d) {
        this.mOpacity = d;
        setGradient(this.mGradient);
    }

    private double[] getMaxIntensities(int i) {
        int i2;
        double[] dArr = new double[22];
        int i3 = 5;
        while (true) {
            if (i3 >= 11) {
                break;
            }
            dArr[i3] = getMaxValue(this.mData, this.mBounds, i, (int) (Math.pow(2.0d, (double) (i3 - 3)) * 1280.0d));
            if (i3 == 5) {
                for (int i4 = 0; i4 < i3; i4++) {
                    dArr[i4] = dArr[i3];
                }
            }
            i3++;
        }
        for (i2 = 11; i2 < 22; i2++) {
            dArr[i2] = dArr[10];
        }
        return dArr;
    }

    private static Tile convertBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new Tile(512, 512, byteArrayOutputStream.toByteArray());
    }

    static Bounds getBounds(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d = next.getPoint().f1043x;
        double d2 = next.getPoint().f1043x;
        double d3 = d;
        double d4 = d2;
        double d5 = next.getPoint().f1044y;
        double d6 = next.getPoint().f1044y;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d7 = next2.getPoint().f1043x;
            double d8 = next2.getPoint().f1044y;
            if (d7 < d3) {
                d3 = d7;
            }
            if (d7 > d4) {
                d4 = d7;
            }
            if (d8 < d5) {
                d5 = d8;
            }
            if (d8 > d6) {
                d6 = d8;
            }
        }
        return new Bounds(d3, d4, d5, d6);
    }

    static double[] generateKernel(int i, double d) {
        double[] dArr = new double[((i * 2) + 1)];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = Math.exp(((double) ((-i2) * i2)) / ((2.0d * d) * d));
        }
        return dArr;
    }

    static double[][] convolve(double[][] dArr, double[] dArr2) {
        double[][] dArr3 = dArr;
        double[] dArr4 = dArr2;
        int floor = (int) Math.floor(((double) dArr4.length) / 2.0d);
        int length = dArr3.length;
        int i = length - (floor * 2);
        int i2 = (floor + i) - 1;
        double[][] dArr5 = (double[][]) Array.newInstance(double.class, new int[]{length, length});
        for (int i3 = 0; i3 < length; i3++) {
            for (int i4 = 0; i4 < length; i4++) {
                double d = dArr3[i3][i4];
                if (d != 0.0d) {
                    int i5 = i3 + floor;
                    if (i2 < i5) {
                        i5 = i2;
                    }
                    int i6 = i5 + 1;
                    int i7 = i3 - floor;
                    for (int i8 = floor > i7 ? floor : i7; i8 < i6; i8++) {
                        double[] dArr6 = dArr5[i8];
                        dArr6[i4] = dArr6[i4] + (dArr4[i8 - i7] * d);
                    }
                }
            }
        }
        double[][] dArr7 = (double[][]) Array.newInstance(double.class, new int[]{i, i});
        for (int i9 = floor; i9 < i2 + 1; i9++) {
            for (int i10 = 0; i10 < length; i10++) {
                double d2 = dArr5[i9][i10];
                if (d2 != 0.0d) {
                    int i11 = i10 + floor;
                    if (i2 < i11) {
                        i11 = i2;
                    }
                    int i12 = i11 + 1;
                    int i13 = i10 - floor;
                    for (int i14 = floor > i13 ? floor : i13; i14 < i12; i14++) {
                        double[] dArr8 = dArr7[i9 - floor];
                        int i15 = i14 - floor;
                        dArr8[i15] = dArr8[i15] + (dArr4[i14 - i13] * d2);
                    }
                }
            }
        }
        return dArr7;
    }

    static Bitmap colorize(double[][] dArr, int[] iArr, double d) {
        double[][] dArr2 = dArr;
        int[] iArr2 = iArr;
        int i = iArr2[iArr2.length - 1];
        double length = ((double) (iArr2.length - 1)) / d;
        int length2 = dArr2.length;
        int[] iArr3 = new int[(length2 * length2)];
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < length2; i3++) {
                double d2 = dArr2[i3][i2];
                int i4 = (i2 * length2) + i3;
                int i5 = (int) (d2 * length);
                if (d2 == 0.0d) {
                    iArr3[i4] = 0;
                } else if (i5 < iArr2.length) {
                    iArr3[i4] = iArr2[i5];
                } else {
                    iArr3[i4] = i;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr3, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    static double getMaxValue(Collection<WeightedLatLng> collection, Bounds bounds, int i, int i2) {
        Bounds bounds2 = bounds;
        double d = bounds2.minX;
        double d2 = bounds2.maxX;
        double d3 = bounds2.minY;
        double d4 = d2 - d;
        double d5 = bounds2.maxY - d3;
        if (d4 <= d5) {
            d4 = d5;
        }
        double d6 = ((double) ((int) (((double) (i2 / (i * 2))) + 0.5d))) / d4;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d7 = 0.0d;
        for (WeightedLatLng next : collection) {
            double d8 = next.getPoint().f1043x;
            int i3 = (int) ((next.getPoint().f1044y - d3) * d6);
            long j = (long) ((int) ((d8 - d) * d6));
            LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j);
            if (longSparseArray2 == null) {
                longSparseArray2 = new LongSparseArray();
                longSparseArray.put(j, longSparseArray2);
            }
            long j2 = (long) i3;
            Double d9 = (Double) longSparseArray2.get(j2);
            if (d9 == null) {
                d9 = Double.valueOf(0.0d);
            }
            Double valueOf = Double.valueOf(d9.doubleValue() + next.getIntensity());
            longSparseArray2.put(j2, valueOf);
            if (valueOf.doubleValue() > d7) {
                d7 = valueOf.doubleValue();
            }
        }
        return d7;
    }
}
