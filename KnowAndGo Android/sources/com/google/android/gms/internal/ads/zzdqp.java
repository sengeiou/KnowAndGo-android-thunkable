package com.google.android.gms.internal.ads;

import org.apache.commons.p032io.IOUtils;

final class zzdqp {
    static String zzdc(zzdmr zzdmr) {
        zzdqq zzdqq = new zzdqq(zzdmr);
        StringBuilder sb = new StringBuilder(zzdqq.size());
        for (int i = 0; i < zzdqq.size(); i++) {
            byte zzfm = zzdqq.zzfm(i);
            if (zzfm == 34) {
                sb.append("\\\"");
            } else if (zzfm == 39) {
                sb.append("\\'");
            } else if (zzfm != 92) {
                switch (zzfm) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (zzfm >= 32 && zzfm <= 126) {
                            sb.append((char) zzfm);
                            break;
                        } else {
                            sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                            sb.append((char) (((zzfm >>> 6) & 3) + 48));
                            sb.append((char) (((zzfm >>> 3) & 7) + 48));
                            sb.append((char) ((zzfm & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
