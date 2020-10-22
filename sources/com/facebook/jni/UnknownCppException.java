package com.facebook.jni;

import com.facebook.jni.annotations.DoNotStrip;
import com.polidea.multiplatformbleadapter.utils.Constants;

@DoNotStrip
public class UnknownCppException extends CppException {
    @DoNotStrip
    public UnknownCppException() {
        super(Constants.BluetoothState.UNKNOWN);
    }

    @DoNotStrip
    public UnknownCppException(String str) {
        super(str);
    }
}
