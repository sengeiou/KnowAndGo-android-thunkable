package com.uxcam.internals;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.uxcam.internals.bl */
public final class C2985bl {

    /* renamed from: A */
    public static final C2985bl f1440A = m1252a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA");

    /* renamed from: B */
    public static final C2985bl f1441B = m1252a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");

    /* renamed from: C */
    public static final C2985bl f1442C = m1252a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5");

    /* renamed from: D */
    public static final C2985bl f1443D = m1252a("TLS_RSA_WITH_AES_128_CBC_SHA");

    /* renamed from: E */
    public static final C2985bl f1444E = m1252a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA");

    /* renamed from: F */
    public static final C2985bl f1445F = m1252a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA");

    /* renamed from: G */
    public static final C2985bl f1446G = m1252a("TLS_DH_anon_WITH_AES_128_CBC_SHA");

    /* renamed from: H */
    public static final C2985bl f1447H = m1252a("TLS_RSA_WITH_AES_256_CBC_SHA");

    /* renamed from: I */
    public static final C2985bl f1448I = m1252a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA");

    /* renamed from: J */
    public static final C2985bl f1449J = m1252a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA");

    /* renamed from: K */
    public static final C2985bl f1450K = m1252a("TLS_DH_anon_WITH_AES_256_CBC_SHA");

    /* renamed from: L */
    public static final C2985bl f1451L = m1252a("TLS_RSA_WITH_NULL_SHA256");

    /* renamed from: M */
    public static final C2985bl f1452M = m1252a("TLS_RSA_WITH_AES_128_CBC_SHA256");

    /* renamed from: N */
    public static final C2985bl f1453N = m1252a("TLS_RSA_WITH_AES_256_CBC_SHA256");

    /* renamed from: O */
    public static final C2985bl f1454O = m1252a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");

    /* renamed from: P */
    public static final C2985bl f1455P = m1252a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");

    /* renamed from: Q */
    public static final C2985bl f1456Q = m1252a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");

    /* renamed from: R */
    public static final C2985bl f1457R = m1252a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");

    /* renamed from: S */
    public static final C2985bl f1458S = m1252a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");

    /* renamed from: T */
    public static final C2985bl f1459T = m1252a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");

    /* renamed from: U */
    public static final C2985bl f1460U = m1252a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");

    /* renamed from: V */
    public static final C2985bl f1461V = m1252a("TLS_DH_anon_WITH_AES_128_CBC_SHA256");

    /* renamed from: W */
    public static final C2985bl f1462W = m1252a("TLS_DH_anon_WITH_AES_256_CBC_SHA256");

    /* renamed from: X */
    public static final C2985bl f1463X = m1252a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");

    /* renamed from: Y */
    public static final C2985bl f1464Y = m1252a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");

    /* renamed from: Z */
    public static final C2985bl f1465Z = m1252a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");

    /* renamed from: a */
    public static final C2985bl f1466a = m1252a("SSL_RSA_WITH_NULL_MD5");

    /* renamed from: aA */
    public static final C2985bl f1467aA = m1252a("TLS_ECDH_RSA_WITH_RC4_128_SHA");

    /* renamed from: aB */
    public static final C2985bl f1468aB = m1252a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");

    /* renamed from: aC */
    public static final C2985bl f1469aC = m1252a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");

    /* renamed from: aD */
    public static final C2985bl f1470aD = m1252a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");

    /* renamed from: aE */
    public static final C2985bl f1471aE = m1252a("TLS_ECDHE_RSA_WITH_NULL_SHA");

    /* renamed from: aF */
    public static final C2985bl f1472aF = m1252a("TLS_ECDHE_RSA_WITH_RC4_128_SHA");

    /* renamed from: aG */
    public static final C2985bl f1473aG = m1252a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");

    /* renamed from: aH */
    public static final C2985bl f1474aH = m1252a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");

    /* renamed from: aI */
    public static final C2985bl f1475aI = m1252a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");

    /* renamed from: aJ */
    public static final C2985bl f1476aJ = m1252a("TLS_ECDH_anon_WITH_NULL_SHA");

    /* renamed from: aK */
    public static final C2985bl f1477aK = m1252a("TLS_ECDH_anon_WITH_RC4_128_SHA");

    /* renamed from: aL */
    public static final C2985bl f1478aL = m1252a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");

    /* renamed from: aM */
    public static final C2985bl f1479aM = m1252a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA");

    /* renamed from: aN */
    public static final C2985bl f1480aN = m1252a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA");

    /* renamed from: aO */
    public static final C2985bl f1481aO = m1252a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");

    /* renamed from: aP */
    public static final C2985bl f1482aP = m1252a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");

    /* renamed from: aQ */
    public static final C2985bl f1483aQ = m1252a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");

    /* renamed from: aR */
    public static final C2985bl f1484aR = m1252a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");

    /* renamed from: aS */
    public static final C2985bl f1485aS = m1252a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");

    /* renamed from: aT */
    public static final C2985bl f1486aT = m1252a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");

    /* renamed from: aU */
    public static final C2985bl f1487aU = m1252a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");

    /* renamed from: aV */
    public static final C2985bl f1488aV = m1252a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");

    /* renamed from: aW */
    public static final C2985bl f1489aW = m1252a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");

    /* renamed from: aX */
    public static final C2985bl f1490aX = m1252a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");

    /* renamed from: aY */
    public static final C2985bl f1491aY = m1252a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");

    /* renamed from: aZ */
    public static final C2985bl f1492aZ = m1252a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");

    /* renamed from: aa */
    public static final C2985bl f1493aa = m1252a("TLS_PSK_WITH_RC4_128_SHA");

    /* renamed from: ab */
    public static final C2985bl f1494ab = m1252a("TLS_PSK_WITH_3DES_EDE_CBC_SHA");

    /* renamed from: ac */
    public static final C2985bl f1495ac = m1252a("TLS_PSK_WITH_AES_128_CBC_SHA");

    /* renamed from: ad */
    public static final C2985bl f1496ad = m1252a("TLS_PSK_WITH_AES_256_CBC_SHA");

    /* renamed from: ae */
    public static final C2985bl f1497ae = m1252a("TLS_RSA_WITH_SEED_CBC_SHA");

    /* renamed from: af */
    public static final C2985bl f1498af = m1252a("TLS_RSA_WITH_AES_128_GCM_SHA256");

    /* renamed from: ag */
    public static final C2985bl f1499ag = m1252a("TLS_RSA_WITH_AES_256_GCM_SHA384");

    /* renamed from: ah */
    public static final C2985bl f1500ah = m1252a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");

    /* renamed from: ai */
    public static final C2985bl f1501ai = m1252a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");

    /* renamed from: aj */
    public static final C2985bl f1502aj = m1252a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");

    /* renamed from: ak */
    public static final C2985bl f1503ak = m1252a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");

    /* renamed from: al */
    public static final C2985bl f1504al = m1252a("TLS_DH_anon_WITH_AES_128_GCM_SHA256");

    /* renamed from: am */
    public static final C2985bl f1505am = m1252a("TLS_DH_anon_WITH_AES_256_GCM_SHA384");

    /* renamed from: an */
    public static final C2985bl f1506an = m1252a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV");

    /* renamed from: ao */
    public static final C2985bl f1507ao = m1252a("TLS_FALLBACK_SCSV");

    /* renamed from: ap */
    public static final C2985bl f1508ap = m1252a("TLS_ECDH_ECDSA_WITH_NULL_SHA");

    /* renamed from: aq */
    public static final C2985bl f1509aq = m1252a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA");

    /* renamed from: ar */
    public static final C2985bl f1510ar = m1252a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");

    /* renamed from: as */
    public static final C2985bl f1511as = m1252a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");

    /* renamed from: at */
    public static final C2985bl f1512at = m1252a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");

    /* renamed from: au */
    public static final C2985bl f1513au = m1252a("TLS_ECDHE_ECDSA_WITH_NULL_SHA");

    /* renamed from: av */
    public static final C2985bl f1514av = m1252a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");

    /* renamed from: aw */
    public static final C2985bl f1515aw = m1252a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");

    /* renamed from: ax */
    public static final C2985bl f1516ax = m1252a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");

    /* renamed from: ay */
    public static final C2985bl f1517ay = m1252a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");

    /* renamed from: az */
    public static final C2985bl f1518az = m1252a("TLS_ECDH_RSA_WITH_NULL_SHA");

    /* renamed from: b */
    public static final C2985bl f1519b = m1252a("SSL_RSA_WITH_NULL_SHA");

    /* renamed from: ba */
    public static final C2985bl f1520ba = m1252a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");

    /* renamed from: bb */
    public static final C2985bl f1521bb = m1252a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");

    /* renamed from: bc */
    public static final C2985bl f1522bc = m1252a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");

    /* renamed from: bd */
    public static final C2985bl f1523bd = m1252a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");

    /* renamed from: be */
    public static final C2985bl f1524be = m1252a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");

    /* renamed from: bf */
    public static final C2985bl f1525bf = m1252a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");

    /* renamed from: bg */
    public static final C2985bl f1526bg = m1252a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");

    /* renamed from: bh */
    public static final C2985bl f1527bh = m1252a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");

    /* renamed from: bj */
    private static final ConcurrentMap f1528bj = new ConcurrentHashMap();

    /* renamed from: c */
    public static final C2985bl f1529c = m1252a("SSL_RSA_EXPORT_WITH_RC4_40_MD5");

    /* renamed from: d */
    public static final C2985bl f1530d = m1252a("SSL_RSA_WITH_RC4_128_MD5");

    /* renamed from: e */
    public static final C2985bl f1531e = m1252a("SSL_RSA_WITH_RC4_128_SHA");

    /* renamed from: f */
    public static final C2985bl f1532f = m1252a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");

    /* renamed from: g */
    public static final C2985bl f1533g = m1252a("SSL_RSA_WITH_DES_CBC_SHA");

    /* renamed from: h */
    public static final C2985bl f1534h = m1252a("SSL_RSA_WITH_3DES_EDE_CBC_SHA");

    /* renamed from: i */
    public static final C2985bl f1535i = m1252a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");

    /* renamed from: j */
    public static final C2985bl f1536j = m1252a("SSL_DHE_DSS_WITH_DES_CBC_SHA");

    /* renamed from: k */
    public static final C2985bl f1537k = m1252a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");

    /* renamed from: l */
    public static final C2985bl f1538l = m1252a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");

    /* renamed from: m */
    public static final C2985bl f1539m = m1252a("SSL_DHE_RSA_WITH_DES_CBC_SHA");

    /* renamed from: n */
    public static final C2985bl f1540n = m1252a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");

    /* renamed from: o */
    public static final C2985bl f1541o = m1252a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");

    /* renamed from: p */
    public static final C2985bl f1542p = m1252a("SSL_DH_anon_WITH_RC4_128_MD5");

    /* renamed from: q */
    public static final C2985bl f1543q = m1252a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");

    /* renamed from: r */
    public static final C2985bl f1544r = m1252a("SSL_DH_anon_WITH_DES_CBC_SHA");

    /* renamed from: s */
    public static final C2985bl f1545s = m1252a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");

    /* renamed from: t */
    public static final C2985bl f1546t = m1252a("TLS_KRB5_WITH_DES_CBC_SHA");

    /* renamed from: u */
    public static final C2985bl f1547u = m1252a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA");

    /* renamed from: v */
    public static final C2985bl f1548v = m1252a("TLS_KRB5_WITH_RC4_128_SHA");

    /* renamed from: w */
    public static final C2985bl f1549w = m1252a("TLS_KRB5_WITH_DES_CBC_MD5");

    /* renamed from: x */
    public static final C2985bl f1550x = m1252a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5");

    /* renamed from: y */
    public static final C2985bl f1551y = m1252a("TLS_KRB5_WITH_RC4_128_MD5");

    /* renamed from: z */
    public static final C2985bl f1552z = m1252a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");

    /* renamed from: bi */
    final String f1553bi;

    private C2985bl(String str) {
        if (str != null) {
            this.f1553bi = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static C2985bl m1252a(String str) {
        C2985bl blVar = (C2985bl) f1528bj.get(str);
        if (blVar != null) {
            return blVar;
        }
        C2985bl blVar2 = new C2985bl(str);
        C2985bl blVar3 = (C2985bl) f1528bj.putIfAbsent(str, blVar2);
        return blVar3 == null ? blVar2 : blVar3;
    }

    public final String toString() {
        return this.f1553bi;
    }
}
