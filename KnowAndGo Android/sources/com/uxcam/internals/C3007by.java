package com.uxcam.internals;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.uxcam.internals.by */
public final class C3007by {

    /* renamed from: c */
    private static final Pattern f1632c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: d */
    private static final Pattern f1633d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a */
    final String f1634a;

    /* renamed from: b */
    final String f1635b;

    /* renamed from: e */
    private final String f1636e;

    /* renamed from: f */
    private final String f1637f;

    private C3007by(String str, String str2, String str3, String str4) {
        this.f1636e = str;
        this.f1634a = str2;
        this.f1637f = str3;
        this.f1635b = str4;
    }

    /* renamed from: a */
    public static C3007by m1329a(String str) {
        Matcher matcher = f1632c.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f1633d.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                String group2 = matcher2.group(2);
                if (group2 == null) {
                    group2 = matcher2.group(3);
                } else if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                    group2 = group2.substring(1, group2.length() - 1);
                }
                if (str2 == null || group2.equalsIgnoreCase(str2)) {
                    str2 = group2;
                } else {
                    throw new IllegalArgumentException("Multiple different charsets: ".concat(String.valueOf(str)));
                }
            }
        }
        return new C3007by(str, lowerCase, lowerCase2, str2);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C3007by) && ((C3007by) obj).f1636e.equals(this.f1636e);
    }

    public final int hashCode() {
        return this.f1636e.hashCode();
    }

    public final String toString() {
        return this.f1636e;
    }
}
