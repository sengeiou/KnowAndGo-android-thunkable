package com.uxcam.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.uxcam.internals.C2923aa;
import com.uxcam.internals.C2952an;
import com.uxcam.internals.C2966az;
import com.uxcam.internals.C2970bc;
import com.uxcam.internals.C3177fu;
import com.uxcam.internals.C3183fy;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HttpPostService extends Service {

    /* renamed from: a */
    public static final String f2928a = "HttpPostService";

    /* renamed from: b */
    public static boolean f2929b = false;

    /* renamed from: c */
    public static List f2930c = Collections.synchronizedList(new ArrayList());

    /* renamed from: com.uxcam.service.HttpPostService$aa */
    final class C3348aa extends Handler {
        public C3348aa(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            String string = message.getData().getString("arg_which_service");
            C2970bc.m1233a(HttpPostService.f2928a);
            StringBuilder sb = new StringBuilder("service started msg : ");
            sb.append(string);
            sb.append(" start id : ");
            sb.append(message.arg1);
            if (string.equals("value_stop_uxcam")) {
                C2923aa.m1096a().mo37983a(C3183fy.m2030a(), "");
            } else if (string.equals("send_offline_data")) {
                C3177fu fuVar = new C3177fu(C3183fy.m2030a());
                if (C2952an.f1332p) {
                    try {
                        fuVar.mo38476a(false);
                    } catch (Exception unused) {
                        C2970bc.m1238c();
                    }
                }
            } else if (string.equals("stop_foreground")) {
                C2970bc.m1233a(HttpPostService.f2928a);
            } else if (string.equals("screen_upload")) {
                try {
                    new C2966az(C3183fy.m2030a()).mo38066a();
                } catch (Exception unused2) {
                    C2970bc.m1233a(HttpPostService.f2928a);
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m2431a(File file) {
        for (String equals : f2930c) {
            if (file.getAbsolutePath().equals(equals)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static void m2432b(File file) {
        for (String equals : f2930c) {
            if (file.getAbsolutePath().equals(equals)) {
                return;
            }
        }
        f2930c.add(file.getAbsolutePath());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        m2433c(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0029 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m2433c(java.io.File r4) {
        /*
            java.lang.Class<com.uxcam.service.HttpPostService> r0 = com.uxcam.service.HttpPostService.class
            monitor-enter(r0)
            java.util.List r1 = f2930c     // Catch:{ ConcurrentModificationException -> 0x0029 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ ConcurrentModificationException -> 0x0029 }
        L_0x0009:
            boolean r2 = r1.hasNext()     // Catch:{ ConcurrentModificationException -> 0x0029 }
            if (r2 == 0) goto L_0x0025
            java.lang.Object r2 = r1.next()     // Catch:{ ConcurrentModificationException -> 0x0029 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ ConcurrentModificationException -> 0x0029 }
            java.lang.String r3 = r4.getAbsolutePath()     // Catch:{ ConcurrentModificationException -> 0x0029 }
            boolean r3 = r3.equals(r2)     // Catch:{ ConcurrentModificationException -> 0x0029 }
            if (r3 == 0) goto L_0x0009
            java.util.List r3 = f2930c     // Catch:{ ConcurrentModificationException -> 0x0029 }
            r3.remove(r2)     // Catch:{ ConcurrentModificationException -> 0x0029 }
            goto L_0x0009
        L_0x0025:
            monitor-exit(r0)
            return
        L_0x0027:
            r4 = move-exception
            goto L_0x002e
        L_0x0029:
            m2433c(r4)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)
            return
        L_0x002e:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.service.HttpPostService.m2433c(java.io.File):void");
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        f2929b = false;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (!(intent == null || intent.getExtras() == null)) {
            f2929b = true;
            String string = intent.getExtras().getString("arg_which_service");
            if (string != null && !string.equalsIgnoreCase("stop_foreground")) {
                HandlerThread handlerThread = new HandlerThread("ServiceStartArguments", 10);
                handlerThread.start();
                C3348aa aaVar = new C3348aa(handlerThread.getLooper());
                Message obtainMessage = aaVar.obtainMessage();
                obtainMessage.arg1 = i2;
                obtainMessage.setData(intent.getExtras());
                aaVar.sendMessage(obtainMessage);
            }
        }
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
        stopSelf();
    }
}
