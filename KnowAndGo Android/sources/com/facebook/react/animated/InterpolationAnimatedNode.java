package com.facebook.react.animated;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InterpolationAnimatedNode extends ValueAnimatedNode {
    public static final String EXTRAPOLATE_TYPE_CLAMP = "clamp";
    public static final String EXTRAPOLATE_TYPE_EXTEND = "extend";
    public static final String EXTRAPOLATE_TYPE_IDENTITY = "identity";
    private static final Pattern fpPattern = Pattern.compile(fpRegex);
    private static final String fpRegex = "[+-]?(\\d+\\.?\\d*|\\.\\d+)([eE][+-]?\\d+)?";
    private final String mExtrapolateLeft;
    private final String mExtrapolateRight;
    private final boolean mHasStringOutput;
    private final double[] mInputRange;
    private int mNumVals;
    private final double[] mOutputRange;
    private double[][] mOutputs;
    @Nullable
    private ValueAnimatedNode mParent;
    private String mPattern;
    private final Matcher mSOutputMatcher;
    private boolean mShouldRound;

    private static double[] fromDoubleArray(ReadableArray readableArray) {
        double[] dArr = new double[readableArray.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = readableArray.getDouble(i);
        }
        return dArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b0 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double interpolate(double r14, double r16, double r18, double r20, double r22, java.lang.String r24, java.lang.String r25) {
        /*
            r5 = r24
            r6 = r25
            r10 = 94742715(0x5a5a8bb, float:1.5578507E-35)
            r7 = -135761730(0xfffffffff7e870be, float:-9.428903E33)
            r8 = -1289044198(0xffffffffb32abf1a, float:-3.9755015E-8)
            r11 = -1
            int r12 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r12 >= 0) goto L_0x005f
            int r9 = r24.hashCode()
            if (r9 == r8) goto L_0x0031
            if (r9 == r7) goto L_0x0027
            if (r9 == r10) goto L_0x001d
            goto L_0x003b
        L_0x001d:
            java.lang.String r9 = "clamp"
            boolean r9 = r5.equals(r9)
            if (r9 == 0) goto L_0x003b
            r9 = 1
            goto L_0x003c
        L_0x0027:
            java.lang.String r9 = "identity"
            boolean r9 = r5.equals(r9)
            if (r9 == 0) goto L_0x003b
            r9 = 0
            goto L_0x003c
        L_0x0031:
            java.lang.String r9 = "extend"
            boolean r9 = r5.equals(r9)
            if (r9 == 0) goto L_0x003b
            r9 = 2
            goto L_0x003c
        L_0x003b:
            r9 = -1
        L_0x003c:
            switch(r9) {
                case 0: goto L_0x005e;
                case 1: goto L_0x005b;
                case 2: goto L_0x005f;
                default: goto L_0x003f;
            }
        L_0x003f:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r0 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid extrapolation type "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = "for left extrapolation"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x005b:
            r0 = r16
            goto L_0x0060
        L_0x005e:
            return r14
        L_0x005f:
            r0 = r14
        L_0x0060:
            int r5 = (r0 > r18 ? 1 : (r0 == r18 ? 0 : -1))
            if (r5 <= 0) goto L_0x00b1
            int r5 = r25.hashCode()
            if (r5 == r8) goto L_0x0083
            if (r5 == r7) goto L_0x0079
            if (r5 == r10) goto L_0x006f
            goto L_0x008d
        L_0x006f:
            java.lang.String r5 = "clamp"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x008d
            r13 = 1
            goto L_0x008e
        L_0x0079:
            java.lang.String r5 = "identity"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x008d
            r13 = 0
            goto L_0x008e
        L_0x0083:
            java.lang.String r5 = "extend"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x008d
            r13 = 2
            goto L_0x008e
        L_0x008d:
            r13 = -1
        L_0x008e:
            switch(r13) {
                case 0: goto L_0x00b0;
                case 1: goto L_0x00ad;
                case 2: goto L_0x00b1;
                default: goto L_0x0091;
            }
        L_0x0091:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r0 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid extrapolation type "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = "for right extrapolation"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00ad:
            r0 = r18
            goto L_0x00b1
        L_0x00b0:
            return r0
        L_0x00b1:
            int r5 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r5 != 0) goto L_0x00b6
            return r20
        L_0x00b6:
            int r5 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r5 != 0) goto L_0x00be
            if (r12 > 0) goto L_0x00bd
            return r20
        L_0x00bd:
            return r22
        L_0x00be:
            r5 = 0
            double r3 = r22 - r20
            double r0 = r0 - r16
            double r3 = r3 * r0
            double r0 = r18 - r16
            double r3 = r3 / r0
            double r0 = r20 + r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.InterpolationAnimatedNode.interpolate(double, double, double, double, double, java.lang.String, java.lang.String):double");
    }

    static double interpolate(double d, double[] dArr, double[] dArr2, String str, String str2) {
        int findRangeIndex = findRangeIndex(d, dArr);
        int i = findRangeIndex + 1;
        return interpolate(d, dArr[findRangeIndex], dArr[i], dArr2[findRangeIndex], dArr2[i], str, str2);
    }

    private static int findRangeIndex(double d, double[] dArr) {
        int i = 1;
        while (i < dArr.length - 1 && dArr[i] < d) {
            i++;
        }
        return i - 1;
    }

    public InterpolationAnimatedNode(ReadableMap readableMap) {
        this.mInputRange = fromDoubleArray(readableMap.getArray("inputRange"));
        ReadableArray array = readableMap.getArray("outputRange");
        this.mHasStringOutput = array.getType(0) == ReadableType.String;
        if (this.mHasStringOutput) {
            int size = array.size();
            this.mOutputRange = new double[size];
            this.mPattern = array.getString(0);
            this.mShouldRound = this.mPattern.startsWith("rgb");
            this.mSOutputMatcher = fpPattern.matcher(this.mPattern);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                Matcher matcher = fpPattern.matcher(array.getString(i));
                ArrayList arrayList2 = new ArrayList();
                arrayList.add(arrayList2);
                while (matcher.find()) {
                    arrayList2.add(Double.valueOf(Double.parseDouble(matcher.group())));
                }
                this.mOutputRange[i] = ((Double) arrayList2.get(0)).doubleValue();
            }
            this.mNumVals = ((ArrayList) arrayList.get(0)).size();
            this.mOutputs = new double[this.mNumVals][];
            for (int i2 = 0; i2 < this.mNumVals; i2++) {
                double[] dArr = new double[size];
                this.mOutputs[i2] = dArr;
                for (int i3 = 0; i3 < size; i3++) {
                    dArr[i3] = ((Double) ((ArrayList) arrayList.get(i3)).get(i2)).doubleValue();
                }
            }
        } else {
            this.mOutputRange = fromDoubleArray(array);
            this.mSOutputMatcher = null;
        }
        this.mExtrapolateLeft = readableMap.getString("extrapolateLeft");
        this.mExtrapolateRight = readableMap.getString("extrapolateRight");
    }

    public void onAttachedToNode(AnimatedNode animatedNode) {
        if (this.mParent != null) {
            throw new IllegalStateException("Parent already attached");
        } else if (animatedNode instanceof ValueAnimatedNode) {
            this.mParent = (ValueAnimatedNode) animatedNode;
        } else {
            throw new IllegalArgumentException("Parent is of an invalid type");
        }
    }

    public void onDetachedFromNode(AnimatedNode animatedNode) {
        if (animatedNode == this.mParent) {
            this.mParent = null;
            return;
        }
        throw new IllegalArgumentException("Invalid parent node provided");
    }

    public void update() {
        if (this.mParent != null) {
            double value = this.mParent.getValue();
            this.mValue = interpolate(value, this.mInputRange, this.mOutputRange, this.mExtrapolateLeft, this.mExtrapolateRight);
            if (!this.mHasStringOutput) {
                return;
            }
            if (this.mNumVals > 1) {
                StringBuffer stringBuffer = new StringBuffer(this.mPattern.length());
                this.mSOutputMatcher.reset();
                int i = 0;
                while (this.mSOutputMatcher.find()) {
                    int i2 = i + 1;
                    double interpolate = interpolate(value, this.mInputRange, this.mOutputs[i], this.mExtrapolateLeft, this.mExtrapolateRight);
                    if (this.mShouldRound) {
                        boolean z = i2 == 4;
                        if (z) {
                            interpolate *= 1000.0d;
                        }
                        int round = (int) Math.round(interpolate);
                        this.mSOutputMatcher.appendReplacement(stringBuffer, z ? Double.toString(((double) round) / 1000.0d) : Integer.toString(round));
                    } else {
                        int i3 = (int) interpolate;
                        this.mSOutputMatcher.appendReplacement(stringBuffer, ((double) i3) != interpolate ? Double.toString(interpolate) : Integer.toString(i3));
                    }
                    i = i2;
                }
                this.mSOutputMatcher.appendTail(stringBuffer);
                this.mAnimatedObject = stringBuffer.toString();
                return;
            }
            this.mAnimatedObject = this.mSOutputMatcher.replaceFirst(String.valueOf(this.mValue));
        }
    }
}
