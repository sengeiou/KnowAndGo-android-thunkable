package expo.modules.barcodescanner.scanners;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.RGBLuminanceSource;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.unimodules.interfaces.barcodescanner.BarCodeScannerResult;
import org.unimodules.interfaces.barcodescanner.BarCodeScannerSettings;

public class ZxingBarCodeScanner extends ExpoBarCodeScanner {
    private static final Map<BarcodeFormat, Integer> GMV_FROM_ZXING = Collections.unmodifiableMap(new HashMap<BarcodeFormat, Integer>() {
        {
            put(BarcodeFormat.AZTEC, 4096);
            put(BarcodeFormat.EAN_13, 32);
            put(BarcodeFormat.EAN_8, 64);
            put(BarcodeFormat.QR_CODE, 256);
            put(BarcodeFormat.PDF_417, 2048);
            put(BarcodeFormat.UPC_E, 1024);
            put(BarcodeFormat.DATA_MATRIX, 16);
            put(BarcodeFormat.CODE_39, 2);
            put(BarcodeFormat.CODE_93, 4);
            put(BarcodeFormat.ITF, 128);
            put(BarcodeFormat.CODABAR, 8);
            put(BarcodeFormat.CODE_128, 1);
            put(BarcodeFormat.UPC_A, 512);
        }
    });
    private static final Map<Integer, String> VALID_BARCODE_TYPES = Collections.unmodifiableMap(new HashMap<Integer, String>() {
        {
            put(4096, BarcodeFormat.AZTEC.toString());
            put(32, BarcodeFormat.EAN_13.toString());
            put(64, BarcodeFormat.EAN_8.toString());
            put(256, BarcodeFormat.QR_CODE.toString());
            put(2048, BarcodeFormat.PDF_417.toString());
            put(1024, BarcodeFormat.UPC_E.toString());
            put(16, BarcodeFormat.DATA_MATRIX.toString());
            put(2, BarcodeFormat.CODE_39.toString());
            put(4, BarcodeFormat.CODE_93.toString());
            put(128, BarcodeFormat.ITF.toString());
            put(8, BarcodeFormat.CODABAR.toString());
            put(1, BarcodeFormat.CODE_128.toString());
            put(512, BarcodeFormat.UPC_A.toString());
        }
    });
    private final MultiFormatReader mMultiFormatReader = new MultiFormatReader();

    public boolean isAvailable() {
        return true;
    }

    public ZxingBarCodeScanner(Context context) {
        super(context);
    }

    public List<BarCodeScannerResult> scanMultiple(Bitmap bitmap) {
        int[] iArr = new int[(bitmap.getWidth() * bitmap.getHeight())];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        BarCodeScannerResult scan = scan(new RGBLuminanceSource(bitmap.getWidth(), bitmap.getHeight(), iArr));
        return scan == null ? Collections.emptyList() : Collections.singletonList(scan);
    }

    public BarCodeScannerResult scan(byte[] bArr, int i, int i2, int i3) {
        if (i3 == 0) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i4 = 0; i4 < i2; i4++) {
                for (int i5 = 0; i5 < i; i5++) {
                    bArr2[(((i5 * i2) + i2) - i4) - 1] = bArr[(i4 * i) + i5];
                }
            }
            int i6 = i + i2;
            i2 = i6 - i2;
            i = i6 - i2;
            bArr = bArr2;
        }
        return scan(generateSourceFromImageData(bArr, i, i2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x001e A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.unimodules.interfaces.barcodescanner.BarCodeScannerResult scan(com.google.zxing.LuminanceSource r9) {
        /*
            r8 = this;
            r0 = 0
            com.google.zxing.BinaryBitmap r1 = new com.google.zxing.BinaryBitmap     // Catch:{ NotFoundException -> 0x001a, Throwable -> 0x0014 }
            com.google.zxing.common.HybridBinarizer r2 = new com.google.zxing.common.HybridBinarizer     // Catch:{ NotFoundException -> 0x001a, Throwable -> 0x0014 }
            r2.<init>(r9)     // Catch:{ NotFoundException -> 0x001a, Throwable -> 0x0014 }
            r1.<init>(r2)     // Catch:{ NotFoundException -> 0x001a, Throwable -> 0x0014 }
            com.google.zxing.MultiFormatReader r9 = r8.mMultiFormatReader     // Catch:{ NotFoundException -> 0x001b, Throwable -> 0x0012 }
            com.google.zxing.Result r9 = r9.decodeWithState(r1)     // Catch:{ NotFoundException -> 0x001b, Throwable -> 0x0012 }
            goto L_0x001c
        L_0x0012:
            r9 = move-exception
            goto L_0x0016
        L_0x0014:
            r9 = move-exception
            r1 = r0
        L_0x0016:
            r9.printStackTrace()
            goto L_0x001b
        L_0x001a:
            r1 = r0
        L_0x001b:
            r9 = r0
        L_0x001c:
            if (r1 == 0) goto L_0x0049
            if (r9 != 0) goto L_0x0021
            goto L_0x0049
        L_0x0021:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            org.unimodules.interfaces.barcodescanner.BarCodeScannerResult r0 = new org.unimodules.interfaces.barcodescanner.BarCodeScannerResult
            java.util.Map<com.google.zxing.BarcodeFormat, java.lang.Integer> r2 = GMV_FROM_ZXING
            com.google.zxing.BarcodeFormat r3 = r9.getBarcodeFormat()
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r3 = r2.intValue()
            java.lang.String r4 = r9.getText()
            int r6 = r1.getHeight()
            int r7 = r1.getWidth()
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x0049:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.barcodescanner.scanners.ZxingBarCodeScanner.scan(com.google.zxing.LuminanceSource):org.unimodules.interfaces.barcodescanner.BarCodeScannerResult");
    }

    public void setSettings(BarCodeScannerSettings barCodeScannerSettings) {
        if (!areNewAndOldBarCodeTypesEqual(parseBarCodeTypesFromSettings(barCodeScannerSettings))) {
            EnumMap enumMap = new EnumMap(DecodeHintType.class);
            EnumSet<E> noneOf = EnumSet.noneOf(BarcodeFormat.class);
            if (this.mBarCodeTypes != null) {
                for (Integer intValue : this.mBarCodeTypes) {
                    String str = VALID_BARCODE_TYPES.get(Integer.valueOf(intValue.intValue()));
                    if (str != null) {
                        noneOf.add(BarcodeFormat.valueOf(str));
                    }
                }
            }
            enumMap.put(DecodeHintType.POSSIBLE_FORMATS, noneOf);
            this.mMultiFormatReader.setHints(enumMap);
        }
    }

    private LuminanceSource generateSourceFromImageData(byte[] bArr, int i, int i2) {
        return new PlanarYUVLuminanceSource(bArr, i, i2, 0, 0, i, i2, false);
    }
}
