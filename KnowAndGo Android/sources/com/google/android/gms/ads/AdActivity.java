package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaqg;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzyt;

@KeepForSdkWithMembers
public class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzaqg zzaah;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzaah = zzyt.zzpb().zzb((Activity) this);
        if (this.zzaah == null) {
            zzbad.zze("#007 Could not call remote method.", (Throwable) null);
            finish();
            return;
        }
        try {
            this.zzaah.onCreate(bundle);
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        try {
            if (this.zzaah != null) {
                this.zzaah.onRestart();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        try {
            if (this.zzaah != null) {
                this.zzaah.onStart();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        try {
            if (this.zzaah != null) {
                this.zzaah.onResume();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            if (this.zzaah != null) {
                this.zzaah.onPause();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.zzaah != null) {
                this.zzaah.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            if (this.zzaah != null) {
                this.zzaah.onStop();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.zzaah != null) {
                this.zzaah.onDestroy();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    private final void zzdd() {
        if (this.zzaah != null) {
            try {
                this.zzaah.zzdd();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public void setContentView(int i) {
        super.setContentView(i);
        zzdd();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        zzdd();
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zzdd();
    }

    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.zzaah != null) {
                z = this.zzaah.zztg();
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.zzaah.onActivityResult(i, i2, intent);
        } catch (Exception e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.zzaah.zzac(ObjectWrapper.wrap(configuration));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
