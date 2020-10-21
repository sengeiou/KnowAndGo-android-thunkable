package com.google.android.gms.internal.ads;

import androidx.core.view.PointerIconCompat;
import com.google.android.gms.internal.ads.zzdob;
import p024io.nlopez.smartlocation.activity.providers.ActivityGooglePlayServicesProvider;
import p024io.nlopez.smartlocation.geofencing.providers.GeofencingGooglePlayServicesProvider;
import p024io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesProvider;

public final class zzwl {

    public static final class zza extends zzdob<zza, C4388zza> implements zzdpm {
        /* access modifiers changed from: private */
        public static final zza zzbxn = new zza();
        private static volatile zzdpv<zza> zzdv;

        public enum zzb implements zzdoe {
            UNKNOWN_EVENT_TYPE(0),
            AD_REQUEST(1),
            AD_LOADED(2),
            AD_IMPRESSION(5),
            AD_FIRST_CLICK(6),
            AD_SUBSEQUENT_CLICK(7),
            REQUEST_WILL_START(8),
            REQUEST_DID_END(9),
            REQUEST_WILL_UPDATE_SIGNALS(10),
            REQUEST_DID_UPDATE_SIGNALS(11),
            REQUEST_WILL_BUILD_URL(12),
            REQUEST_DID_BUILD_URL(13),
            REQUEST_WILL_MAKE_NETWORK_REQUEST(14),
            REQUEST_DID_RECEIVE_NETWORK_RESPONSE(15),
            REQUEST_WILL_PROCESS_RESPONSE(16),
            REQUEST_DID_PROCESS_RESPONSE(17),
            REQUEST_WILL_RENDER(18),
            REQUEST_DID_RENDER(19),
            AD_FAILED_TO_LOAD(3),
            AD_FAILED_TO_LOAD_NO_FILL(4),
            AD_FAILED_TO_LOAD_INVALID_REQUEST(100),
            AD_FAILED_TO_LOAD_NETWORK_ERROR(101),
            AD_FAILED_TO_LOAD_TIMEOUT(102),
            AD_FAILED_TO_LOAD_CANCELLED(103),
            AD_FAILED_TO_LOAD_NO_ERROR(104),
            AD_FAILED_TO_LOAD_NOT_FOUND(105),
            REQUEST_WILL_UPDATE_GMS_SIGNALS(1000),
            REQUEST_DID_UPDATE_GMS_SIGNALS(1001),
            REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS(1002),
            REQUEST_FAILED_TO_BUILD_URL(PointerIconCompat.TYPE_HELP),
            REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST(PointerIconCompat.TYPE_WAIT),
            REQUEST_FAILED_TO_PROCESS_RESPONSE(1005),
            REQUEST_FAILED_TO_UPDATE_SIGNALS(PointerIconCompat.TYPE_CELL),
            REQUEST_FAILED_TO_RENDER(PointerIconCompat.TYPE_CROSSHAIR),
            BANNER_SIZE_INVALID(10000),
            BANNER_SIZE_VALID(LocationGooglePlayServicesProvider.REQUEST_START_LOCATION_FIX),
            ANDROID_WEBVIEW_CRASH(ActivityGooglePlayServicesProvider.RESULT_CODE),
            OFFLINE_UPLOAD(GeofencingGooglePlayServicesProvider.RESULT_CODE);
            
            private static final zzdof<zzb> zzeg = null;
            private final int value;

            public final int zzac() {
                return this.value;
            }

            private zzb(int i) {
                this.value = i;
            }

            static {
                zzeg = new zzwn();
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzwl$zza$zza  reason: collision with other inner class name */
        public static final class C4388zza extends zzdob.zza<zza, C4388zza> implements zzdpm {
            private C4388zza() {
                super(zza.zzbxn);
            }

            /* synthetic */ C4388zza(zzwm zzwm) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwm.zzdi[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C4388zza((zzwm) null);
                case 3:
                    return zza((zzdpk) zzbxn, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zzbxn;
                case 5:
                    zzdpv<zza> zzdpv = zzdv;
                    if (zzdpv == null) {
                        synchronized (zza.class) {
                            zzdpv = zzdv;
                            if (zzdpv == null) {
                                zzdpv = new zzdob.zzb<>(zzbxn);
                                zzdv = zzdpv;
                            }
                        }
                    }
                    return zzdpv;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzdob.zza(zza.class, zzbxn);
        }
    }
}
