package com.airbnb.lottie.utils;

public class MeanCalculator {

    /* renamed from: n */
    private int f48n;
    private float sum;

    public void add(float f) {
        this.sum += f;
        this.f48n++;
        if (this.f48n == Integer.MAX_VALUE) {
            this.sum /= 2.0f;
            this.f48n /= 2;
        }
    }

    public float getMean() {
        if (this.f48n == 0) {
            return 0.0f;
        }
        return this.sum / ((float) this.f48n);
    }
}
