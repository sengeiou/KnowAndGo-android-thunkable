package com.facebook.yoga;

public enum YogaDimension {
    WIDTH(0),
    HEIGHT(1);
    
    private final int mIntValue;

    private YogaDimension(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaDimension fromInt(int i) {
        switch (i) {
            case 0:
                return WIDTH;
            case 1:
                return HEIGHT;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i);
        }
    }
}
