package com.google.android.play.core.splitinstall;

import android.util.Log;
import androidx.annotation.Nullable;
import com.amplitude.api.Constants;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.google.android.play.core.splitinstall.az */
final class C2124az {

    /* renamed from: a */
    private final XmlPullParser f906a;

    /* renamed from: b */
    private final C2130g f907b = new C2130g();

    C2124az(XmlPullParser xmlPullParser) {
        this.f906a = xmlPullParser;
    }

    @Nullable
    /* renamed from: a */
    private final String m972a(String str) {
        for (int i = 0; i < this.f906a.getAttributeCount(); i++) {
            if (this.f906a.getAttributeName(i).equals(str)) {
                return this.f906a.getAttributeValue(i);
            }
        }
        return null;
    }

    /* renamed from: b */
    private final void m973b() throws IOException, XmlPullParserException {
        int i = 1;
        while (i != 0) {
            switch (this.f906a.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public final C2131h mo33754a() {
        String a;
        while (this.f906a.next() != 1) {
            try {
                if (this.f906a.getEventType() == 2) {
                    if (this.f906a.getName().equals("splits")) {
                        while (this.f906a.next() != 3) {
                            if (this.f906a.getEventType() == 2) {
                                if (!this.f906a.getName().equals("module") || (a = m972a("name")) == null) {
                                    m973b();
                                } else {
                                    while (this.f906a.next() != 3) {
                                        if (this.f906a.getEventType() == 2) {
                                            if (this.f906a.getName().equals(Constants.AMP_TRACKING_OPTION_LANGUAGE)) {
                                                while (this.f906a.next() != 3) {
                                                    if (this.f906a.getEventType() == 2) {
                                                        if (this.f906a.getName().equals("entry")) {
                                                            String a2 = m972a("key");
                                                            String a3 = m972a("split");
                                                            m973b();
                                                            if (!(a2 == null || a3 == null)) {
                                                                this.f907b.mo33764a(a, a2, a3);
                                                            }
                                                        } else {
                                                            m973b();
                                                        }
                                                    }
                                                }
                                            } else {
                                                m973b();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        m973b();
                    }
                }
            } catch (IOException | IllegalStateException | XmlPullParserException e) {
                Log.e("SplitInstall", "Error while parsing splits.xml", e);
                return null;
            }
        }
        return this.f907b.mo33763a();
    }
}
