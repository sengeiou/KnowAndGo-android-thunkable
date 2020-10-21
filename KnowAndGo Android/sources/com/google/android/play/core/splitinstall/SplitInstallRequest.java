package com.google.android.play.core.splitinstall;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SplitInstallRequest {

    /* renamed from: a */
    private final List<String> f855a;

    /* renamed from: b */
    private final List<Locale> f856b;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final List<String> f857a = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final List<Locale> f858b = new ArrayList();

        private Builder() {
        }

        /* synthetic */ Builder(byte[] bArr) {
        }

        @NonNull
        public Builder addLanguage(@Nullable Locale locale) {
            this.f858b.add(locale);
            return this;
        }

        public Builder addModule(String str) {
            this.f857a.add(str);
            return this;
        }

        @NonNull
        public SplitInstallRequest build() {
            return new SplitInstallRequest(this);
        }
    }

    /* synthetic */ SplitInstallRequest(Builder builder) {
        this.f855a = new ArrayList(builder.f857a);
        this.f856b = new ArrayList(builder.f858b);
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder((byte[]) null);
    }

    public List<Locale> getLanguages() {
        return this.f856b;
    }

    public List<String> getModuleNames() {
        return this.f855a;
    }

    public String toString() {
        return String.format("SplitInstallRequest{modulesNames=%s,languages=%s}", new Object[]{this.f855a, this.f856b});
    }
}
