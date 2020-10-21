package com.facebook.yoga;

public enum YogaNodeType {
    DEFAULT(0),
    TEXT(1);
    
    private final int mIntValue;

    private YogaNodeType(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaNodeType fromInt(int i) {
        switch (i) {
            case 0:
                return DEFAULT;
            case 1:
                return TEXT;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i);
        }
    }
}
