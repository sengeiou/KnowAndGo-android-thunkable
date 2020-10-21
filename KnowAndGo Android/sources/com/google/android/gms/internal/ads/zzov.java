package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.exoplayer2.C1470C;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.gms.internal.ads.zzpo;

final class zzov {
    private static final int zzbev = zzsy.zzay("nam");
    private static final int zzbew = zzsy.zzay("trk");
    private static final int zzbex = zzsy.zzay("cmt");
    private static final int zzbey = zzsy.zzay("day");
    private static final int zzbez = zzsy.zzay("ART");
    private static final int zzbfa = zzsy.zzay("too");
    private static final int zzbfb = zzsy.zzay("alb");
    private static final int zzbfc = zzsy.zzay("com");
    private static final int zzbfd = zzsy.zzay("wrt");
    private static final int zzbfe = zzsy.zzay("lyr");
    private static final int zzbff = zzsy.zzay("gen");
    private static final int zzbfg = zzsy.zzay("covr");
    private static final int zzbfh = zzsy.zzay("gnre");
    private static final int zzbfi = zzsy.zzay("grp");
    private static final int zzbfj = zzsy.zzay("disk");
    private static final int zzbfk = zzsy.zzay("trkn");
    private static final int zzbfl = zzsy.zzay("tmpo");
    private static final int zzbfm = zzsy.zzay("cpil");
    private static final int zzbfn = zzsy.zzay("aART");
    private static final int zzbfo = zzsy.zzay("sonm");
    private static final int zzbfp = zzsy.zzay("soal");
    private static final int zzbfq = zzsy.zzay("soar");
    private static final int zzbfr = zzsy.zzay("soaa");
    private static final int zzbfs = zzsy.zzay("soco");
    private static final int zzbft = zzsy.zzay("rtng");
    private static final int zzbfu = zzsy.zzay("pgap");
    private static final int zzbfv = zzsy.zzay("sosn");
    private static final int zzbfw = zzsy.zzay("tvsh");
    private static final int zzbfx = zzsy.zzay(InternalFrame.f147ID);
    private static final String[] zzbfy = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static zzpo.zza zzd(zzst zzst) {
        zzpw zzpw;
        int position = zzst.getPosition() + zzst.readInt();
        int readInt = zzst.readInt();
        int i = readInt >>> 24;
        zzpo.zza zza = null;
        if (i == 169 || i == 65533) {
            int i2 = 16777215 & readInt;
            if (i2 == zzbex) {
                int readInt2 = zzst.readInt();
                if (zzst.readInt() == zzoj.zzbdp) {
                    zzst.zzac(8);
                    String zzbp = zzst.zzbp(readInt2 - 16);
                    zza = new zzps(C1470C.LANGUAGE_UNDETERMINED, zzbp, zzbp);
                } else {
                    String valueOf = String.valueOf(zzoj.zzu(readInt));
                    Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
                }
                zzst.setPosition(position);
                return zza;
            }
            if (i2 != zzbev) {
                if (i2 != zzbew) {
                    if (i2 != zzbfc) {
                        if (i2 != zzbfd) {
                            if (i2 == zzbey) {
                                zzpw zza2 = zza(readInt, "TDRC", zzst);
                                zzst.setPosition(position);
                                return zza2;
                            } else if (i2 == zzbez) {
                                zzpw zza3 = zza(readInt, "TPE1", zzst);
                                zzst.setPosition(position);
                                return zza3;
                            } else if (i2 == zzbfa) {
                                zzpw zza4 = zza(readInt, "TSSE", zzst);
                                zzst.setPosition(position);
                                return zza4;
                            } else if (i2 == zzbfb) {
                                zzpw zza5 = zza(readInt, "TALB", zzst);
                                zzst.setPosition(position);
                                return zza5;
                            } else if (i2 == zzbfe) {
                                zzpw zza6 = zza(readInt, "USLT", zzst);
                                zzst.setPosition(position);
                                return zza6;
                            } else if (i2 == zzbff) {
                                zzpw zza7 = zza(readInt, "TCON", zzst);
                                zzst.setPosition(position);
                                return zza7;
                            } else if (i2 == zzbfi) {
                                zzpw zza8 = zza(readInt, "TIT1", zzst);
                                zzst.setPosition(position);
                                return zza8;
                            }
                        }
                    }
                    zzpw zza9 = zza(readInt, "TCOM", zzst);
                    zzst.setPosition(position);
                    return zza9;
                }
            }
            zzpw zza10 = zza(readInt, "TIT2", zzst);
            zzst.setPosition(position);
            return zza10;
        }
        try {
            if (readInt == zzbfh) {
                int zze = zze(zzst);
                String str = (zze <= 0 || zze > zzbfy.length) ? null : zzbfy[zze - 1];
                if (str != null) {
                    zzpw = new zzpw("TCON", (String) null, str);
                } else {
                    Log.w("MetadataUtil", "Failed to parse standard genre code");
                    zzpw = null;
                }
                return zzpw;
            } else if (readInt == zzbfj) {
                zzpw zzb = zzb(readInt, "TPOS", zzst);
                zzst.setPosition(position);
                return zzb;
            } else if (readInt == zzbfk) {
                zzpw zzb2 = zzb(readInt, "TRCK", zzst);
                zzst.setPosition(position);
                return zzb2;
            } else if (readInt == zzbfl) {
                zzpv zza11 = zza(readInt, "TBPM", zzst, true, false);
                zzst.setPosition(position);
                return zza11;
            } else if (readInt == zzbfm) {
                zzpv zza12 = zza(readInt, "TCMP", zzst, true, true);
                zzst.setPosition(position);
                return zza12;
            } else if (readInt == zzbfg) {
                int readInt3 = zzst.readInt();
                if (zzst.readInt() == zzoj.zzbdp) {
                    int zzax = zzoj.zzax(zzst.readInt());
                    String str2 = zzax == 13 ? "image/jpeg" : zzax == 14 ? "image/png" : null;
                    if (str2 == null) {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append("Unrecognized cover art flags: ");
                        sb.append(zzax);
                        Log.w("MetadataUtil", sb.toString());
                    } else {
                        zzst.zzac(4);
                        byte[] bArr = new byte[(readInt3 - 16)];
                        zzst.zzb(bArr, 0, bArr.length);
                        zza = new zzpq(str2, (String) null, 3, bArr);
                    }
                } else {
                    Log.w("MetadataUtil", "Failed to parse cover art attribute");
                }
                zzst.setPosition(position);
                return zza;
            } else if (readInt == zzbfn) {
                zzpw zza13 = zza(readInt, "TPE2", zzst);
                zzst.setPosition(position);
                return zza13;
            } else if (readInt == zzbfo) {
                zzpw zza14 = zza(readInt, "TSOT", zzst);
                zzst.setPosition(position);
                return zza14;
            } else if (readInt == zzbfp) {
                zzpw zza15 = zza(readInt, "TSO2", zzst);
                zzst.setPosition(position);
                return zza15;
            } else if (readInt == zzbfq) {
                zzpw zza16 = zza(readInt, "TSOA", zzst);
                zzst.setPosition(position);
                return zza16;
            } else if (readInt == zzbfr) {
                zzpw zza17 = zza(readInt, "TSOP", zzst);
                zzst.setPosition(position);
                return zza17;
            } else if (readInt == zzbfs) {
                zzpw zza18 = zza(readInt, "TSOC", zzst);
                zzst.setPosition(position);
                return zza18;
            } else if (readInt == zzbft) {
                zzpv zza19 = zza(readInt, "ITUNESADVISORY", zzst, false, false);
                zzst.setPosition(position);
                return zza19;
            } else if (readInt == zzbfu) {
                zzpv zza20 = zza(readInt, "ITUNESGAPLESS", zzst, false, true);
                zzst.setPosition(position);
                return zza20;
            } else if (readInt == zzbfv) {
                zzpw zza21 = zza(readInt, "TVSHOWSORT", zzst);
                zzst.setPosition(position);
                return zza21;
            } else if (readInt == zzbfw) {
                zzpw zza22 = zza(readInt, "TVSHOW", zzst);
                zzst.setPosition(position);
                return zza22;
            } else if (readInt == zzbfx) {
                String str3 = null;
                String str4 = null;
                int i3 = -1;
                int i4 = -1;
                while (zzst.getPosition() < position) {
                    int position2 = zzst.getPosition();
                    int readInt4 = zzst.readInt();
                    int readInt5 = zzst.readInt();
                    zzst.zzac(4);
                    if (readInt5 == zzoj.zzbdn) {
                        str3 = zzst.zzbp(readInt4 - 12);
                    } else if (readInt5 == zzoj.zzbdo) {
                        str4 = zzst.zzbp(readInt4 - 12);
                    } else {
                        if (readInt5 == zzoj.zzbdp) {
                            i3 = position2;
                            i4 = readInt4;
                        }
                        zzst.zzac(readInt4 - 12);
                    }
                }
                if ("com.apple.iTunes".equals(str3) && "iTunSMPB".equals(str4)) {
                    if (i3 != -1) {
                        zzst.setPosition(i3);
                        zzst.zzac(16);
                        zza = new zzps(C1470C.LANGUAGE_UNDETERMINED, str4, zzst.zzbp(i4 - 16));
                    }
                }
                zzst.setPosition(position);
                return zza;
            }
        } finally {
            zzst.setPosition(position);
        }
        String valueOf2 = String.valueOf(zzoj.zzu(readInt));
        Log.d("MetadataUtil", valueOf2.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf2) : new String("Skipped unknown metadata entry: "));
        zzst.setPosition(position);
        return null;
    }

    private static zzpw zza(int i, String str, zzst zzst) {
        int readInt = zzst.readInt();
        if (zzst.readInt() == zzoj.zzbdp) {
            zzst.zzac(8);
            return new zzpw(str, (String) null, zzst.zzbp(readInt - 16));
        }
        String valueOf = String.valueOf(zzoj.zzu(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static zzpv zza(int i, String str, zzst zzst, boolean z, boolean z2) {
        int zze = zze(zzst);
        if (z2) {
            zze = Math.min(1, zze);
        }
        if (zze < 0) {
            String valueOf = String.valueOf(zzoj.zzu(i));
            Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
            return null;
        } else if (z) {
            return new zzpw(str, (String) null, Integer.toString(zze));
        } else {
            return new zzps(C1470C.LANGUAGE_UNDETERMINED, str, Integer.toString(zze));
        }
    }

    private static zzpw zzb(int i, String str, zzst zzst) {
        int readInt = zzst.readInt();
        if (zzst.readInt() == zzoj.zzbdp && readInt >= 22) {
            zzst.zzac(10);
            int readUnsignedShort = zzst.readUnsignedShort();
            if (readUnsignedShort > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(readUnsignedShort);
                String sb2 = sb.toString();
                int readUnsignedShort2 = zzst.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(readUnsignedShort2);
                    sb2 = sb3.toString();
                }
                return new zzpw(str, (String) null, sb2);
            }
        }
        String valueOf2 = String.valueOf(zzoj.zzu(i));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    private static int zze(zzst zzst) {
        zzst.zzac(4);
        if (zzst.readInt() == zzoj.zzbdp) {
            zzst.zzac(8);
            return zzst.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
