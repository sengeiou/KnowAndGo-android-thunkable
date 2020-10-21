package com.facebook.yoga;

public enum YogaOverflow {
    VISIBLE(0),
    HIDDEN(1),
    SCROLL(2);
    
    private final int mIntValue;

    private YogaOverflow(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaOverflow fromInt(int i) {
        switch (i) {
            case 0:
                return VISIBLE;
            case 1:
                return HIDDEN;
            case 2:
                return SCROLL;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i);
        }
    }
}
