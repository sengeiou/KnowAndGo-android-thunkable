package expo.modules.updates.loader;

import android.util.Base64;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import okhttp3.C3873Response;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;

public class Crypto {
    private static String PUBLIC_KEY_URL = "https://exp.host/--/manifest-public-key";

    public interface RSASignatureListener {
        void onCompleted(boolean z);

        void onError(Exception exc, boolean z);
    }

    public static void verifyPublicRSASignature(String str, String str2, RSASignatureListener rSASignatureListener) {
        fetchPublicKeyAndVerifyPublicRSASignature(true, str, str2, rSASignatureListener);
    }

    /* access modifiers changed from: private */
    public static void fetchPublicKeyAndVerifyPublicRSASignature(final boolean z, final String str, final String str2, final RSASignatureListener rSASignatureListener) {
        FileDownloader.downloadData(new Request.Builder().url(PUBLIC_KEY_URL).cacheControl(z ? CacheControl.FORCE_CACHE : CacheControl.FORCE_NETWORK).build(), new Callback() {
            public void onFailure(Call call, IOException iOException) {
                rSASignatureListener.onError(iOException, true);
            }

            public void onResponse(Call call, C3873Response response) throws IOException {
                try {
                    rSASignatureListener.onCompleted(Crypto.verifyPublicRSASignature(response.body().string(), str, str2));
                } catch (Exception e) {
                    if (z) {
                        Crypto.fetchPublicKeyAndVerifyPublicRSASignature(false, str, str2, rSASignatureListener);
                    } else {
                        rSASignatureListener.onError(e, false);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static boolean verifyPublicRSASignature(String str, String str2, String str3) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        String str4 = "";
        for (String str5 : str.split("\\r?\\n")) {
            if (!str5.contains("PUBLIC KEY-----")) {
                str4 = str4 + str5 + "\n";
            }
        }
        Signature instance = Signature.getInstance("SHA256withRSA");
        instance.initVerify(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str4, 0))));
        instance.update(str2.getBytes());
        return instance.verify(Base64.decode(str3, 0));
    }
}
