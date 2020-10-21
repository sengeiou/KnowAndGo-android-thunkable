package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdha;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzdcf {
    private static final Logger logger = Logger.getLogger(zzdcf.class.getName());
    private static final ConcurrentMap<String, zzdbs> zzgpp = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> zzgpq = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzdbk> zzgpr = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzdcc<?>> zzgps = new ConcurrentHashMap();

    public static synchronized void zza(String str, zzdbk<?> zzdbk) throws GeneralSecurityException {
        synchronized (zzdcf.class) {
            if (!zzgpr.containsKey(str.toLowerCase()) || zzdbk.getClass().equals(((zzdbk) zzgpr.get(str.toLowerCase())).getClass())) {
                zzgpr.put(str.toLowerCase(), zzdbk);
            } else {
                Logger logger2 = logger;
                Level level = Level.WARNING;
                String valueOf = String.valueOf(str);
                logger2.logp(level, "com.google.crypto.tink.Registry", "addCatalogue", valueOf.length() != 0 ? "Attempted overwrite of a catalogueName catalogue for name ".concat(valueOf) : new String("Attempted overwrite of a catalogueName catalogue for name "));
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 47);
                sb.append("catalogue for name ");
                sb.append(str);
                sb.append(" has been already registered");
                throw new GeneralSecurityException(sb.toString());
            }
        }
    }

    public static zzdbk<?> zzgi(String str) throws GeneralSecurityException {
        if (str != null) {
            zzdbk<?> zzdbk = (zzdbk) zzgpr.get(str.toLowerCase());
            if (zzdbk != null) {
                return zzdbk;
            }
            String format = String.format("no catalogue found for %s. ", new Object[]{str});
            if (str.toLowerCase().startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (str.toLowerCase().startsWith("tinkdeterministicaead")) {
                format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkstreamingaead")) {
                format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkhybriddecrypt") || str.toLowerCase().startsWith("tinkhybridencrypt")) {
                format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkmac")) {
                format = String.valueOf(format).concat("Maybe call MacConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkpublickeysign") || str.toLowerCase().startsWith("tinkpublickeyverify")) {
                format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
            } else if (str.toLowerCase().startsWith("tink")) {
                format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
            }
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    private static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static synchronized <P> void zza(zzdbs<P> zzdbs) throws GeneralSecurityException {
        synchronized (zzdcf.class) {
            zza(zzdbs, true);
        }
    }

    public static synchronized <P> void zza(zzdbs<P> zzdbs, boolean z) throws GeneralSecurityException {
        synchronized (zzdcf.class) {
            if (zzdbs != null) {
                String keyType = zzdbs.getKeyType();
                if (zzgpp.containsKey(keyType)) {
                    zzdbs zza = zza(keyType, (Class) null);
                    boolean booleanValue = ((Boolean) zzgpq.get(keyType)).booleanValue();
                    if (!zzdbs.getClass().equals(zza.getClass()) || (!booleanValue && z)) {
                        Logger logger2 = logger;
                        Level level = Level.WARNING;
                        String valueOf = String.valueOf(keyType);
                        logger2.logp(level, "com.google.crypto.tink.Registry", "registerKeyManager", valueOf.length() != 0 ? "Attempted overwrite of a registered key manager for key type ".concat(valueOf) : new String("Attempted overwrite of a registered key manager for key type "));
                        throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{keyType, zza.getClass().getName(), zzdbs.getClass().getName()}));
                    }
                }
                zzgpp.put(keyType, zzdbs);
                zzgpq.put(keyType, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <P> void zza(zzdcc<P> zzdcc) throws GeneralSecurityException {
        synchronized (zzdcf.class) {
            if (zzdcc != null) {
                Class<P> zzanr = zzdcc.zzanr();
                if (zzgps.containsKey(zzanr)) {
                    zzdcc zzdcc2 = (zzdcc) zzgps.get(zzanr);
                    if (!zzdcc.getClass().equals(zzdcc2.getClass())) {
                        Logger logger2 = logger;
                        Level level = Level.WARNING;
                        String valueOf = String.valueOf(zzanr.toString());
                        logger2.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", valueOf.length() != 0 ? "Attempted overwrite of a registered SetWrapper for type ".concat(valueOf) : new String("Attempted overwrite of a registered SetWrapper for type "));
                        throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", new Object[]{zzanr.getName(), zzdcc2.getClass().getName(), zzdcc.getClass().getName()}));
                    }
                }
                zzgps.put(zzanr, zzdcc);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    private static <P> zzdbs<P> zza(String str, Class<P> cls) throws GeneralSecurityException {
        zzdbs<P> zzdbs = (zzdbs) zzgpp.get(str);
        if (zzdbs == null) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
            sb.append("No key manager found for key type: ");
            sb.append(str);
            sb.append(".  Check the configuration of the registry.");
            throw new GeneralSecurityException(sb.toString());
        } else if (cls == null || zzdbs.zzanr().equals(cls)) {
            return zzdbs;
        } else {
            String name = zzdbs.zzanr().getName();
            String name2 = cls.getName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(name).length() + 80 + String.valueOf(str).length() + String.valueOf(name2).length());
            sb2.append("Primitive type ");
            sb2.append(name);
            sb2.append(" of keymanager for type ");
            sb2.append(str);
            sb2.append(" does not match requested primitive type ");
            sb2.append(name2);
            throw new GeneralSecurityException(sb2.toString());
        }
    }

    public static synchronized zzdgr zza(zzdgw zzdgw) throws GeneralSecurityException {
        zzdgr zzr;
        synchronized (zzdcf.class) {
            zzdbs zza = zza(zzdgw.zzart(), (Class) null);
            if (((Boolean) zzgpq.get(zzdgw.zzart())).booleanValue()) {
                zzr = zza.zzr(zzdgw.zzaru());
            } else {
                String valueOf = String.valueOf(zzdgw.zzart());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzr;
    }

    public static synchronized zzdpk zzb(zzdgw zzdgw) throws GeneralSecurityException {
        zzdpk zzq;
        synchronized (zzdcf.class) {
            zzdbs zza = zza(zzdgw.zzart(), (Class) null);
            if (((Boolean) zzgpq.get(zzdgw.zzart())).booleanValue()) {
                zzq = zza.zzq(zzdgw.zzaru());
            } else {
                String valueOf = String.valueOf(zzdgw.zzart());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzq;
    }

    public static synchronized zzdpk zza(String str, zzdpk zzdpk) throws GeneralSecurityException {
        zzdpk zzb;
        synchronized (zzdcf.class) {
            zzdbs zza = zza(str, (Class) null);
            if (((Boolean) zzgpq.get(str)).booleanValue()) {
                zzb = zza.zzb(zzdpk);
            } else {
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzb;
    }

    public static <P> P zza(String str, zzdpk zzdpk, Class<P> cls) throws GeneralSecurityException {
        return zza(str, (Class) checkNotNull(cls)).zza(zzdpk);
    }

    private static <P> P zza(String str, zzdmr zzdmr, Class<P> cls) throws GeneralSecurityException {
        return zza(str, cls).zzp(zzdmr);
    }

    public static <P> P zza(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return zza(str, zzdmr.zzz(bArr), (Class) checkNotNull(cls));
    }

    public static <P> zzdca<P> zza(zzdbu zzdbu, zzdbs<P> zzdbs, Class<P> cls) throws GeneralSecurityException {
        Class cls2 = (Class) checkNotNull(cls);
        zzdch.zzd(zzdbu.zzant());
        zzdca<P> zza = zzdca.zza(cls2);
        for (zzdha.zzb next : zzdbu.zzant().zzasi()) {
            if (next.zzaso() == zzdgu.ENABLED) {
                zzdcb<P> zza2 = zza.zza(zza(next.zzasn().zzart(), next.zzasn().zzaru(), cls2), next);
                if (next.zzasp() == zzdbu.zzant().zzash()) {
                    zza.zza(zza2);
                }
            }
        }
        return zza;
    }

    public static <P> P zza(zzdca<P> zzdca) throws GeneralSecurityException {
        zzdcc zzdcc = (zzdcc) zzgps.get(zzdca.zzanr());
        if (zzdcc != null) {
            return zzdcc.zza(zzdca);
        }
        String valueOf = String.valueOf(zzdca.zzanr().getName());
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No wrapper found for ".concat(valueOf) : new String("No wrapper found for "));
    }
}
