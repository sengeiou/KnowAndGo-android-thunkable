package com.facebook.soloader.nativeloader;

public class SystemDelegate implements NativeLoaderDelegate {
    public boolean loadLibrary(String str) {
        System.loadLibrary(str);
        return true;
    }
}
