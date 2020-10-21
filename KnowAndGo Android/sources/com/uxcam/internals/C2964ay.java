package com.uxcam.internals;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.internal.ImagesContract;
import com.uxcam.internals.C3008bz;
import com.uxcam.internals.C3011ca;
import com.uxcam.internals.C3017cd;
import com.uxcam.internals.C3184fz;
import com.uxcam.service.HttpPostService;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import p022fi.iki.elonen.NanoHTTPD;

/* renamed from: com.uxcam.internals.ay */
public final class C2964ay {

    /* renamed from: a */
    Context f1380a;

    /* renamed from: b */
    public File f1381b;

    /* renamed from: c */
    public JSONObject f1382c;

    /* renamed from: d */
    public boolean f1383d = false;

    /* renamed from: a */
    static /* synthetic */ void m1222a(C2964ay ayVar, File file, String str) {
        C2970bc.m1233a("AmazonUploader");
        StringBuilder sb = new StringBuilder(" UPLOAD TO S3 Failed: ");
        sb.append(file.getAbsolutePath());
        sb.append(" size : ");
        sb.append(file.length());
        sb.append(" Response : ");
        sb.append(str);
        HttpPostService.m2433c(file);
        C2928ab.m1140g();
        HashMap hashMap = new HashMap();
        hashMap.put(UriUtil.LOCAL_FILE_SCHEME, file.getName().replace("$", "/"));
        hashMap.put("response", str);
        hashMap.put("offline", Boolean.valueOf(ayVar.f1383d));
        C3171fo.m1998a(C3183fy.m2030a(), "amazonUploadFailed", hashMap);
    }

    /* renamed from: a */
    private boolean m1223a() {
        boolean b = C3169fm.m1994b(this.f1380a);
        boolean c = C3169fm.m1995c(this.f1380a);
        int d = new C3175fs(this.f1380a).mo38473d("current_month");
        int i = Calendar.getInstance().get(2) + 1;
        if (d != i) {
            new C3175fs(this.f1380a).mo38465a("current_month", i);
            new C3175fs(this.f1380a).mo38474d();
            C2970bc.m1233a("AmazonUploader");
            StringBuilder sb = new StringBuilder("New Month ");
            sb.append(i);
            sb.append(", resetting quota");
        }
        if (c && C2952an.f1325i > 0) {
            long d2 = C3183fy.m2044d(this.f1381b.getParentFile());
            long j = (long) (C2952an.f1325i * 1024 * 1024);
            long e = new C3175fs(this.f1380a).mo38475e();
            C2970bc.m1233a("AmazonUploader");
            if (d2 <= j - e) {
                return true;
            }
            C2970bc.m1233a("AmazonUploader");
            StringBuilder sb2 = new StringBuilder("Could not upload session data due to monthly mobile data limit which is set to ");
            sb2.append(j);
            sb2.append(" kb");
            return false;
        } else if (b) {
            return true;
        } else {
            C2970bc.m1233a("AmazonUploader");
            return false;
        }
    }

    /* renamed from: c */
    private void m1224c(Context context, File file) {
        this.f1380a = context;
        if (file.exists()) {
            this.f1381b = file;
            if (this.f1382c == null) {
                this.f1382c = C2952an.f1327k;
            }
            boolean c = C3169fm.m1995c(context);
            boolean c2 = new C3175fs(context).mo38472c(file.getParentFile().getName());
            if (c && c2) {
                mo38062a(false);
            } else if (c && C2952an.f1326j) {
                mo38062a(true);
            } else if (m1223a()) {
                mo38062a(false);
            }
        }
    }

    /* renamed from: a */
    public final void mo38061a(Context context, File file) {
        HttpPostService.m2432b(file);
        m1224c(context, file);
    }

    /* renamed from: a */
    public final void mo38062a(boolean z) {
        String str;
        JSONObject jSONObject;
        String string;
        JSONObject jSONObject2;
        try {
            File[] listFiles = this.f1381b.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                final String name = this.f1381b.getName();
                boolean startsWith = name.startsWith("data");
                if (!z || startsWith) {
                    if (name.startsWith(MimeTypes.BASE_TYPE_VIDEO)) {
                        str = MimeTypes.VIDEO_MP4;
                        jSONObject = this.f1382c.getJSONObject(MimeTypes.BASE_TYPE_VIDEO).getJSONObject(TtmlNode.TAG_BODY);
                        string = this.f1382c.getJSONObject(MimeTypes.BASE_TYPE_VIDEO).getString(ImagesContract.URL);
                        jSONObject2 = this.f1382c.getJSONObject(MimeTypes.BASE_TYPE_VIDEO).getJSONObject(TtmlNode.TAG_BODY);
                    } else if (name.startsWith("data")) {
                        str = NanoHTTPD.MIME_PLAINTEXT;
                        jSONObject = this.f1382c.getJSONObject("data").getJSONObject(TtmlNode.TAG_BODY);
                        string = this.f1382c.getJSONObject("data").getString(ImagesContract.URL);
                        jSONObject2 = this.f1382c.getJSONObject("data").getJSONObject(TtmlNode.TAG_BODY);
                    } else if (!name.startsWith("icon")) {
                        return;
                    } else {
                        if (!this.f1382c.has("icon")) {
                            C2970bc.m1233a("AmazonUploader");
                            this.f1381b.delete();
                            return;
                        }
                        str = "image/png";
                        jSONObject = this.f1382c.getJSONObject("icon").getJSONObject(TtmlNode.TAG_BODY);
                        string = this.f1382c.getJSONObject("icon").getString(ImagesContract.URL);
                        jSONObject2 = this.f1382c.getJSONObject("icon").getJSONObject(TtmlNode.TAG_BODY);
                    }
                    final String string2 = jSONObject2.getString("success_action_status");
                    jSONObject.remove(UriUtil.LOCAL_FILE_SCHEME);
                    jSONObject.put("key", C2958as.m1197a(jSONObject.optString("key"), C2958as.m1200b(this.f1381b.getName())));
                    C2970bc.m1233a("AmazonUploader");
                    new StringBuilder(" start uploading file ").append(this.f1381b.getAbsolutePath());
                    HashMap hashMap = new HashMap();
                    hashMap.put(UriUtil.LOCAL_FILE_SCHEME, name);
                    hashMap.put("size", Long.valueOf(this.f1381b.length()));
                    hashMap.put("offline", Boolean.valueOf(this.f1383d));
                    C3171fo.m1998a(C3183fy.m2030a(), "amazonUploadStarted", hashMap);
                    C3011ca b = new C3011ca.C3013aa().mo38155a((C3005bx) new C2969bb()).mo38156a(TimeUnit.MILLISECONDS).mo38159c(TimeUnit.MILLISECONDS).mo38157b(TimeUnit.MILLISECONDS).mo38158b();
                    C3007by a = C3007by.m1329a(str);
                    C3008bz.C3009aa a2 = new C3008bz.C3009aa().mo38142a(C3008bz.f1642e);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        a2.mo38143a(next, jSONObject.getString(next));
                    }
                    a2.mo38144a(UriUtil.LOCAL_FILE_SCHEME, "X", C3019ce.m1374a(a, this.f1381b));
                    C3017cd a3 = new C3017cd.C3018aa().mo38170a(string).mo38171a("POST", (C3019ce) a2.mo38145a()).mo38173a();
                    final String a4 = C3174fr.m2007a(this.f1381b);
                    b.mo38146a(a3).mo38077a(new C2981bj() {
                        /* renamed from: a */
                        public final void mo38064a(C3022cf cfVar) {
                            if (!cfVar.mo38176a() || Integer.parseInt(string2) != cfVar.f1742c) {
                                C2964ay.m1222a(C2964ay.this, C2964ay.this.f1381b, cfVar.f1743d);
                            } else {
                                C2970bc.m1233a("AmazonUploader");
                                StringBuilder sb = new StringBuilder(" UPLOAD TO S3 success: ");
                                sb.append(name);
                                sb.append(" size : ");
                                sb.append(C2964ay.this.f1381b.length());
                                HttpPostService.m2433c(C2964ay.this.f1381b);
                                if (cfVar.mo38178b("ETag").contains(a4)) {
                                    if (C3169fm.m1995c(C2964ay.this.f1380a)) {
                                        C3175fs fsVar = new C3175fs(C2964ay.this.f1380a);
                                        long length = C2964ay.this.f1381b.length();
                                        fsVar.f2294a.edit().putLong("mobile_data_used_size", fsVar.f2294a.getLong("mobile_data_used_size", 0) + length).apply();
                                    }
                                    C2964ay.this.f1381b.delete();
                                    C2964ay ayVar = C2964ay.this;
                                    File parentFile = ayVar.f1381b.getParentFile();
                                    File[] listFiles = parentFile.listFiles();
                                    if (listFiles != null && listFiles.length == 1) {
                                        String name = listFiles[0].getName();
                                        if (name.endsWith(".usid")) {
                                            String str = name.split(".usid")[0];
                                            C3175fs fsVar2 = new C3175fs(ayVar.f1380a);
                                            SharedPreferences.Editor edit = fsVar2.f2294a.edit();
                                            edit.remove(str);
                                            edit.apply();
                                            fsVar2.f2294a.edit().remove("override_mobile_data_data_only_setting_".concat(String.valueOf(parentFile.getName()))).apply();
                                            C2970bc.m1233a("AmazonUploader");
                                        }
                                        listFiles[0].delete();
                                        parentFile.delete();
                                        C2970bc.m1233a("AmazonUploader");
                                        new StringBuilder("Deleting session folder ").append(parentFile.getName());
                                    }
                                }
                                C2928ab.m1140g();
                                HashMap hashMap = new HashMap();
                                hashMap.put(UriUtil.LOCAL_FILE_SCHEME, C2964ay.this.f1381b.getName().replace("$", "/"));
                                hashMap.put("offline", Boolean.valueOf(C2964ay.this.f1383d));
                                C3171fo.m1998a(C3183fy.m2030a(), "amazonUploadSuccess", hashMap);
                            }
                            cfVar.f1746g.close();
                        }

                        /* renamed from: a */
                        public final void mo38065a(IOException iOException) {
                            try {
                                C2970bc.m1233a("AmazonUploader");
                                C2964ay.m1222a(C2964ay.this, C2964ay.this.f1381b, iOException.getMessage());
                            } catch (Exception unused) {
                                C2970bc.m1233a("AmazonUploader");
                            }
                        }
                    });
                    return;
                }
                HttpPostService.m2433c(this.f1381b);
                return;
            }
            for (File c : listFiles) {
                C2964ay ayVar = new C2964ay();
                ayVar.f1383d = this.f1383d;
                ayVar.f1382c = this.f1382c;
                ayVar.m1224c(this.f1380a, c);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public final void mo38063b(Context context, File file) {
        this.f1380a = context;
        this.f1381b = file;
        if (file.exists()) {
            C3184fz fzVar = new C3184fz(context);
            C3184fz.C31872 r4 = new C2981bj(this) {

                /* renamed from: a */
                final /* synthetic */ C2964ay f2327a;

                {
                    this.f2327a = r2;
                }

                /* renamed from: a */
                public final void mo38064a(C3022cf cfVar) {
                    if (!cfVar.mo38176a() || 200 != cfVar.f1742c) {
                        C2928ab.m1105a().f1232e = false;
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(cfVar.f1746g.mo38191d());
                        if (jSONObject.optBoolean("status", true)) {
                            String string = jSONObject.optJSONObject("data").getString("sessionId");
                            C3184fz.this.m2064a(this.f2327a.f1381b, string);
                            C3184fz.this.m2065a(string);
                            C2970bc.m1233a(C3184fz.f2321a);
                            new StringBuilder("sessionId is ").append(jSONObject.optJSONObject("data").getString("sessionId"));
                            this.f2327a.f1382c = jSONObject.optJSONObject("data").getJSONObject("s3");
                            this.f2327a.mo38062a(false);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                /* renamed from: a */
                public final void mo38065a(IOException iOException) {
                    C2970bc.m1233a("okhttp");
                    new StringBuilder("onFailure ").append(iOException.getMessage());
                    HashMap hashMap = new HashMap();
                    hashMap.put("reason", iOException.getMessage());
                    C3171fo.m1998a(C3184fz.this.f2322b, "verifyAndUploadFailure", hashMap);
                }
            };
            File[] listFiles = this.f1381b.listFiles(new FilenameFilter() {
                public final boolean accept(File file, String str) {
                    return str.endsWith(".usid");
                }
            });
            String str = null;
            if (listFiles != null && listFiles.length > 0) {
                str = listFiles[0].getName().split("\\.")[0];
            }
            fzVar.mo38481a(C2928ab.f1215a, (C2981bj) r4, str);
        }
    }
}
