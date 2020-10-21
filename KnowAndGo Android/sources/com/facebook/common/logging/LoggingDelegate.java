package com.facebook.common.logging;

import com.facebook.infer.annotation.NullsafeStrict;

@NullsafeStrict
public interface LoggingDelegate {
    /* renamed from: d */
    void mo12707d(String str, String str2);

    /* renamed from: d */
    void mo12708d(String str, String str2, Throwable th);

    /* renamed from: e */
    void mo12709e(String str, String str2);

    /* renamed from: e */
    void mo12710e(String str, String str2, Throwable th);

    int getMinimumLoggingLevel();

    /* renamed from: i */
    void mo12712i(String str, String str2);

    /* renamed from: i */
    void mo12713i(String str, String str2, Throwable th);

    boolean isLoggable(int i);

    void log(int i, String str, String str2);

    void setMinimumLoggingLevel(int i);

    /* renamed from: v */
    void mo12718v(String str, String str2);

    /* renamed from: v */
    void mo12719v(String str, String str2, Throwable th);

    /* renamed from: w */
    void mo12720w(String str, String str2);

    /* renamed from: w */
    void mo12721w(String str, String str2, Throwable th);

    void wtf(String str, String str2);

    void wtf(String str, String str2, Throwable th);
}
