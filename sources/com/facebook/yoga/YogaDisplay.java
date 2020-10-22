package com.facebook.yoga;

public enum YogaDisplay {
    FLEX(0),
    NONE(1);
    
    private final int mIntValue;

    private YogaDisplay(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaDisplay fromInt(int i) {
        switch (i) {
            case 0:
                return FLEX;
            case 1:
                return NONE;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i);
        }
    }
}
