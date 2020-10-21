package com.bugsnag.android;

class Intrinsics {
    Intrinsics() {
    }

    static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
