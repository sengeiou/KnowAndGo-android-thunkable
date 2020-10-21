package com.theartofdev.edmodo.cropper;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.imagepipeline.common.RotationOptions;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import org.apache.commons.p032io.IOUtils;

final class BitmapUtils {
    static final Rect EMPTY_RECT = new Rect();
    static final RectF EMPTY_RECT_F = new RectF();
    static final float[] POINTS = new float[6];
    static final float[] POINTS2 = new float[6];
    static final RectF RECT = new RectF();
    private static int mMaxTextureSize;
    static Pair<String, WeakReference<Bitmap>> mStateBitmap;

    BitmapUtils() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.theartofdev.edmodo.cropper.BitmapUtils.RotateBitmapResult rotateBitmapByExif(android.graphics.Bitmap r1, android.content.Context r2, android.net.Uri r3) {
        /*
            r0 = 0
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ Exception -> 0x0014 }
            java.io.InputStream r2 = r2.openInputStream(r3)     // Catch:{ Exception -> 0x0014 }
            if (r2 == 0) goto L_0x0014
            androidx.exifinterface.media.ExifInterface r3 = new androidx.exifinterface.media.ExifInterface     // Catch:{ Exception -> 0x0014 }
            r3.<init>((java.io.InputStream) r2)     // Catch:{ Exception -> 0x0014 }
            r2.close()     // Catch:{ Exception -> 0x0015 }
            goto L_0x0015
        L_0x0014:
            r3 = r0
        L_0x0015:
            if (r3 == 0) goto L_0x001c
            com.theartofdev.edmodo.cropper.BitmapUtils$RotateBitmapResult r1 = rotateBitmapByExif(r1, r3)
            goto L_0x0023
        L_0x001c:
            com.theartofdev.edmodo.cropper.BitmapUtils$RotateBitmapResult r2 = new com.theartofdev.edmodo.cropper.BitmapUtils$RotateBitmapResult
            r3 = 0
            r2.<init>(r1, r3)
            r1 = r2
        L_0x0023:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.BitmapUtils.rotateBitmapByExif(android.graphics.Bitmap, android.content.Context, android.net.Uri):com.theartofdev.edmodo.cropper.BitmapUtils$RotateBitmapResult");
    }

    static RotateBitmapResult rotateBitmapByExif(Bitmap bitmap, ExifInterface exifInterface) {
        int attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        return new RotateBitmapResult(bitmap, attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : RotationOptions.ROTATE_180);
    }

    static BitmapSampled decodeSampledBitmap(Context context, Uri uri, int i, int i2) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            BitmapFactory.Options decodeImageForOption = decodeImageForOption(contentResolver, uri);
            decodeImageForOption.inSampleSize = Math.max(calculateInSampleSizeByReqestedSize(decodeImageForOption.outWidth, decodeImageForOption.outHeight, i, i2), calculateInSampleSizeByMaxTextureSize(decodeImageForOption.outWidth, decodeImageForOption.outHeight));
            return new BitmapSampled(decodeImage(contentResolver, uri, decodeImageForOption), decodeImageForOption.inSampleSize);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load sampled bitmap: " + uri + IOUtils.LINE_SEPARATOR_WINDOWS + e.getMessage(), e);
        }
    }

    static BitmapSampled cropBitmapObjectHandleOOM(Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, boolean z2, boolean z3) {
        int i4 = 1;
        do {
            try {
                return new BitmapSampled(cropBitmapObjectWithScale(bitmap, fArr, i, z, i2, i3, 1.0f / ((float) i4), z2, z3), i4);
            } catch (OutOfMemoryError e) {
                i4 *= 2;
                if (i4 > 8) {
                    throw e;
                }
            }
        } while (i4 > 8);
        throw e;
    }

    private static Bitmap cropBitmapObjectWithScale(Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, float f, boolean z2, boolean z3) {
        Bitmap bitmap2 = bitmap;
        int i4 = i;
        float f2 = f;
        Rect rectFromPoints = getRectFromPoints(fArr, bitmap.getWidth(), bitmap.getHeight(), z, i2, i3);
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i4, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        float f3 = z2 ? -f2 : f2;
        if (z3) {
            f2 = -f2;
        }
        matrix.postScale(f3, f2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, rectFromPoints.left, rectFromPoints.top, rectFromPoints.width(), rectFromPoints.height(), matrix, true);
        if (createBitmap == bitmap2) {
            createBitmap = bitmap.copy(bitmap.getConfig(), false);
        }
        return i4 % 90 != 0 ? cropForRotatedImage(createBitmap, fArr, rectFromPoints, i, z, i2, i3) : createBitmap;
    }

    static BitmapSampled cropBitmap(Context context, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3) {
        OutOfMemoryError outOfMemoryError;
        int i8 = 1;
        do {
            try {
                return cropBitmap(context, uri, fArr, i, i2, i3, z, i4, i5, i6, i7, z2, z3, i8);
            } catch (OutOfMemoryError e) {
                outOfMemoryError = e;
                i8 *= 2;
                if (i8 > 16) {
                    throw new RuntimeException("Failed to handle OOM by sampling (" + i8 + "): " + uri + IOUtils.LINE_SEPARATOR_WINDOWS + outOfMemoryError.getMessage(), outOfMemoryError);
                }
            }
        } while (i8 > 16);
        throw new RuntimeException("Failed to handle OOM by sampling (" + i8 + "): " + uri + IOUtils.LINE_SEPARATOR_WINDOWS + outOfMemoryError.getMessage(), outOfMemoryError);
    }

    static float getRectLeft(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    static float getRectTop(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    static float getRectRight(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    static float getRectBottom(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    static float getRectWidth(float[] fArr) {
        return getRectRight(fArr) - getRectLeft(fArr);
    }

    static float getRectHeight(float[] fArr) {
        return getRectBottom(fArr) - getRectTop(fArr);
    }

    static float getRectCenterX(float[] fArr) {
        return (getRectRight(fArr) + getRectLeft(fArr)) / 2.0f;
    }

    static float getRectCenterY(float[] fArr) {
        return (getRectBottom(fArr) + getRectTop(fArr)) / 2.0f;
    }

    static Rect getRectFromPoints(float[] fArr, int i, int i2, boolean z, int i3, int i4) {
        Rect rect = new Rect(Math.round(Math.max(0.0f, getRectLeft(fArr))), Math.round(Math.max(0.0f, getRectTop(fArr))), Math.round(Math.min((float) i, getRectRight(fArr))), Math.round(Math.min((float) i2, getRectBottom(fArr))));
        if (z) {
            fixRectForAspectRatio(rect, i3, i4);
        }
        return rect;
    }

    private static void fixRectForAspectRatio(Rect rect, int i, int i2) {
        if (i == i2 && rect.width() != rect.height()) {
            if (rect.height() > rect.width()) {
                rect.bottom -= rect.height() - rect.width();
            } else {
                rect.right -= rect.width() - rect.height();
            }
        }
    }

    static Uri writeTempStateStoreBitmap(Context context, Bitmap bitmap, Uri uri) {
        boolean z = true;
        if (uri == null) {
            try {
                uri = Uri.fromFile(File.createTempFile("aic_state_store_temp", ".jpg", context.getCacheDir()));
            } catch (Exception e) {
                Log.w("AIC", "Failed to write bitmap to temp file for image-cropper save instance state", e);
                return null;
            }
        } else if (new File(uri.getPath()).exists()) {
            z = false;
        }
        if (z) {
            writeBitmapToUri(context, bitmap, uri, Bitmap.CompressFormat.JPEG, 95);
        }
        return uri;
    }

    static void writeBitmapToUri(Context context, Bitmap bitmap, Uri uri, Bitmap.CompressFormat compressFormat, int i) throws FileNotFoundException {
        OutputStream outputStream = null;
        try {
            OutputStream openOutputStream = context.getContentResolver().openOutputStream(uri);
            try {
                bitmap.compress(compressFormat, i, openOutputStream);
                closeSafe(openOutputStream);
            } catch (Throwable th) {
                th = th;
                outputStream = openOutputStream;
                closeSafe(outputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeSafe(outputStream);
            throw th;
        }
    }

    static Bitmap resizeBitmap(Bitmap bitmap, int i, int i2, CropImageView.RequestSizeOptions requestSizeOptions) {
        if (i > 0 && i2 > 0) {
            try {
                if (requestSizeOptions == CropImageView.RequestSizeOptions.RESIZE_FIT || requestSizeOptions == CropImageView.RequestSizeOptions.RESIZE_INSIDE || requestSizeOptions == CropImageView.RequestSizeOptions.RESIZE_EXACT) {
                    Bitmap bitmap2 = null;
                    if (requestSizeOptions == CropImageView.RequestSizeOptions.RESIZE_EXACT) {
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                    } else {
                        float width = (float) bitmap.getWidth();
                        float height = (float) bitmap.getHeight();
                        float max = Math.max(width / ((float) i), height / ((float) i2));
                        if (max > 1.0f || requestSizeOptions == CropImageView.RequestSizeOptions.RESIZE_FIT) {
                            bitmap2 = Bitmap.createScaledBitmap(bitmap, (int) (width / max), (int) (height / max), false);
                        }
                    }
                    if (bitmap2 != null) {
                        if (bitmap2 != bitmap) {
                            bitmap.recycle();
                        }
                        return bitmap2;
                    }
                }
            } catch (Exception e) {
                Log.w("AIC", "Failed to resize cropped image, return bitmap before resize", e);
            }
        }
        return bitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.theartofdev.edmodo.cropper.BitmapUtils.BitmapSampled cropBitmap(android.content.Context r14, android.net.Uri r15, float[] r16, int r17, int r18, int r19, boolean r20, int r21, int r22, int r23, int r24, boolean r25, boolean r26, int r27) {
        /*
            r0 = r17
            r1 = r16
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            android.graphics.Rect r9 = getRectFromPoints(r1, r2, r3, r4, r5, r6)
            if (r23 <= 0) goto L_0x0017
            r10 = r23
            goto L_0x001c
        L_0x0017:
            int r1 = r9.width()
            r10 = r1
        L_0x001c:
            if (r24 <= 0) goto L_0x0021
            r11 = r24
            goto L_0x0026
        L_0x0021:
            int r1 = r9.height()
            r11 = r1
        L_0x0026:
            r1 = 0
            r8 = 1
            r2 = r14
            r3 = r15
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r27
            com.theartofdev.edmodo.cropper.BitmapUtils$BitmapSampled r2 = decodeSampledBitmapRegion(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0039 }
            android.graphics.Bitmap r3 = r2.bitmap     // Catch:{ Exception -> 0x0039 }
            int r1 = r2.sampleSize     // Catch:{ Exception -> 0x003a }
            r8 = r1
            goto L_0x003a
        L_0x0039:
            r3 = r1
        L_0x003a:
            if (r3 == 0) goto L_0x0069
            r12 = r25
            r13 = r26
            android.graphics.Bitmap r10 = rotateAndFlipBitmapInt(r3, r0, r12, r13)     // Catch:{ OutOfMemoryError -> 0x0061 }
            int r1 = r0 % 90
            if (r1 == 0) goto L_0x0059
            r1 = r10
            r2 = r16
            r3 = r9
            r4 = r17
            r5 = r20
            r6 = r21
            r7 = r22
            android.graphics.Bitmap r0 = cropForRotatedImage(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ OutOfMemoryError -> 0x005f }
            r10 = r0
        L_0x0059:
            com.theartofdev.edmodo.cropper.BitmapUtils$BitmapSampled r0 = new com.theartofdev.edmodo.cropper.BitmapUtils$BitmapSampled
            r0.<init>(r10, r8)
            return r0
        L_0x005f:
            r0 = move-exception
            goto L_0x0063
        L_0x0061:
            r0 = move-exception
            r10 = r3
        L_0x0063:
            if (r10 == 0) goto L_0x0068
            r10.recycle()
        L_0x0068:
            throw r0
        L_0x0069:
            r12 = r25
            r13 = r26
            r1 = r14
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r27
            com.theartofdev.edmodo.cropper.BitmapUtils$BitmapSampled r0 = cropBitmap((android.content.Context) r1, (android.net.Uri) r2, (float[]) r3, (int) r4, (boolean) r5, (int) r6, (int) r7, (int) r8, (android.graphics.Rect) r9, (int) r10, (int) r11, (boolean) r12, (boolean) r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.BitmapUtils.cropBitmap(android.content.Context, android.net.Uri, float[], int, int, int, boolean, int, int, int, int, boolean, boolean, int):com.theartofdev.edmodo.cropper.BitmapUtils$BitmapSampled");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0057, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008b, code lost:
        throw new java.lang.RuntimeException("Failed to load sampled bitmap: " + r1 + org.apache.commons.p032io.IOUtils.LINE_SEPARATOR_WINDOWS + r0.getMessage(), r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068 A[ExcHandler: Exception (r0v3 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.theartofdev.edmodo.cropper.BitmapUtils.BitmapSampled cropBitmap(android.content.Context r15, android.net.Uri r16, float[] r17, int r18, boolean r19, int r20, int r21, int r22, android.graphics.Rect r23, int r24, int r25, boolean r26, boolean r27) {
        /*
            r1 = r16
            r0 = r17
            r2 = 0
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
            r3.<init>()     // Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
            int r4 = r23.width()     // Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
            int r5 = r23.height()     // Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
            r6 = r24
            r7 = r25
            int r4 = calculateInSampleSizeByReqestedSize(r4, r5, r6, r7)     // Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
            int r4 = r4 * r22
            r3.inSampleSize = r4     // Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
            android.content.ContentResolver r5 = r15.getContentResolver()     // Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
            android.graphics.Bitmap r5 = decodeImage(r5, r1, r3)     // Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
            if (r5 == 0) goto L_0x0061
            int r6 = r0.length     // Catch:{ all -> 0x005a }
            float[] r7 = new float[r6]     // Catch:{ all -> 0x005a }
            int r6 = r0.length     // Catch:{ all -> 0x005a }
            r8 = 0
            java.lang.System.arraycopy(r0, r8, r7, r8, r6)     // Catch:{ all -> 0x005a }
        L_0x0030:
            int r0 = r7.length     // Catch:{ all -> 0x005a }
            if (r8 >= r0) goto L_0x003e
            r0 = r7[r8]     // Catch:{ all -> 0x005a }
            int r6 = r3.inSampleSize     // Catch:{ all -> 0x005a }
            float r6 = (float) r6     // Catch:{ all -> 0x005a }
            float r0 = r0 / r6
            r7[r8] = r0     // Catch:{ all -> 0x005a }
            int r8 = r8 + 1
            goto L_0x0030
        L_0x003e:
            r12 = 1065353216(0x3f800000, float:1.0)
            r6 = r5
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            r13 = r26
            r14 = r27
            android.graphics.Bitmap r3 = cropBitmapObjectWithScale(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x005a }
            if (r3 == r5) goto L_0x0062
            r5.recycle()     // Catch:{ OutOfMemoryError -> 0x0057, Exception -> 0x0068 }
            goto L_0x0062
        L_0x0057:
            r0 = move-exception
            r2 = r3
            goto L_0x008d
        L_0x005a:
            r0 = move-exception
            if (r5 == 0) goto L_0x0060
            r5.recycle()     // Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
        L_0x0060:
            throw r0     // Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
        L_0x0061:
            r3 = r2
        L_0x0062:
            com.theartofdev.edmodo.cropper.BitmapUtils$BitmapSampled r0 = new com.theartofdev.edmodo.cropper.BitmapUtils$BitmapSampled
            r0.<init>(r3, r4)
            return r0
        L_0x0068:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to load sampled bitmap: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = "\r\n"
            r3.append(r1)
            java.lang.String r1 = r0.getMessage()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1, r0)
            throw r2
        L_0x008c:
            r0 = move-exception
        L_0x008d:
            if (r2 == 0) goto L_0x0092
            r2.recycle()
        L_0x0092:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.BitmapUtils.cropBitmap(android.content.Context, android.net.Uri, float[], int, boolean, int, int, int, android.graphics.Rect, int, int, boolean, boolean):com.theartofdev.edmodo.cropper.BitmapUtils$BitmapSampled");
    }

    private static BitmapFactory.Options decodeImageForOption(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        InputStream inputStream;
        try {
            inputStream = contentResolver.openInputStream(uri);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStream, EMPTY_RECT, options);
                options.inJustDecodeBounds = false;
                closeSafe(inputStream);
                return options;
            } catch (Throwable th) {
                th = th;
                closeSafe(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            closeSafe(inputStream);
            throw th;
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0016 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0026 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap decodeImage(android.content.ContentResolver r2, android.net.Uri r3, android.graphics.BitmapFactory.Options r4) throws java.io.FileNotFoundException {
        /*
        L_0x0000:
            r0 = 0
            java.io.InputStream r1 = r2.openInputStream(r3)     // Catch:{ OutOfMemoryError -> 0x0016 }
            android.graphics.Rect r0 = EMPTY_RECT     // Catch:{ OutOfMemoryError -> 0x0012, all -> 0x000f }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r1, r0, r4)     // Catch:{ OutOfMemoryError -> 0x0012, all -> 0x000f }
            closeSafe(r1)
            return r0
        L_0x000f:
            r2 = move-exception
            r0 = r1
            goto L_0x003d
        L_0x0012:
            r0 = r1
            goto L_0x0016
        L_0x0014:
            r2 = move-exception
            goto L_0x003d
        L_0x0016:
            int r1 = r4.inSampleSize     // Catch:{ all -> 0x0014 }
            int r1 = r1 * 2
            r4.inSampleSize = r1     // Catch:{ all -> 0x0014 }
            closeSafe(r0)
            int r0 = r4.inSampleSize
            r1 = 512(0x200, float:7.175E-43)
            if (r0 > r1) goto L_0x0026
            goto L_0x0000
        L_0x0026:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Failed to decode image: "
            r4.append(r0)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r2.<init>(r3)
            throw r2
        L_0x003d:
            closeSafe(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.BitmapUtils.decodeImage(android.content.ContentResolver, android.net.Uri, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        r7.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        closeSafe(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        if (r7 == null) goto L_0x0036;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003b */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.theartofdev.edmodo.cropper.BitmapUtils.BitmapSampled decodeSampledBitmapRegion(android.content.Context r4, android.net.Uri r5, android.graphics.Rect r6, int r7, int r8, int r9) {
        /*
            r0 = 0
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            r1.<init>()     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            int r2 = r6.width()     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            int r3 = r6.height()     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            int r7 = calculateInSampleSizeByReqestedSize(r2, r3, r7, r8)     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            int r9 = r9 * r7
            r1.inSampleSize = r9     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            java.io.InputStream r4 = r4.openInputStream(r5)     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            r7 = 0
            android.graphics.BitmapRegionDecoder r7 = android.graphics.BitmapRegionDecoder.newInstance(r4, r7)     // Catch:{ Exception -> 0x005a, all -> 0x0056 }
        L_0x0023:
            com.theartofdev.edmodo.cropper.BitmapUtils$BitmapSampled r8 = new com.theartofdev.edmodo.cropper.BitmapUtils$BitmapSampled     // Catch:{ OutOfMemoryError -> 0x003b }
            android.graphics.Bitmap r9 = r7.decodeRegion(r6, r1)     // Catch:{ OutOfMemoryError -> 0x003b }
            int r2 = r1.inSampleSize     // Catch:{ OutOfMemoryError -> 0x003b }
            r8.<init>(r9, r2)     // Catch:{ OutOfMemoryError -> 0x003b }
            closeSafe(r4)
            if (r7 == 0) goto L_0x0036
            r7.recycle()
        L_0x0036:
            return r8
        L_0x0037:
            r5 = move-exception
            goto L_0x0058
        L_0x0039:
            r6 = move-exception
            goto L_0x005c
        L_0x003b:
            int r8 = r1.inSampleSize     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
            int r8 = r8 * 2
            r1.inSampleSize = r8     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
            int r8 = r1.inSampleSize     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
            r9 = 512(0x200, float:7.175E-43)
            if (r8 <= r9) goto L_0x0023
            closeSafe(r4)
            if (r7 == 0) goto L_0x004f
            r7.recycle()
        L_0x004f:
            com.theartofdev.edmodo.cropper.BitmapUtils$BitmapSampled r4 = new com.theartofdev.edmodo.cropper.BitmapUtils$BitmapSampled
            r5 = 1
            r4.<init>(r0, r5)
            return r4
        L_0x0056:
            r5 = move-exception
            r7 = r0
        L_0x0058:
            r0 = r4
            goto L_0x0087
        L_0x005a:
            r6 = move-exception
            r7 = r0
        L_0x005c:
            r0 = r4
            goto L_0x0063
        L_0x005e:
            r5 = move-exception
            r7 = r0
            goto L_0x0087
        L_0x0061:
            r6 = move-exception
            r7 = r0
        L_0x0063:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ all -> 0x0086 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            r8.<init>()     // Catch:{ all -> 0x0086 }
            java.lang.String r9 = "Failed to load sampled bitmap: "
            r8.append(r9)     // Catch:{ all -> 0x0086 }
            r8.append(r5)     // Catch:{ all -> 0x0086 }
            java.lang.String r5 = "\r\n"
            r8.append(r5)     // Catch:{ all -> 0x0086 }
            java.lang.String r5 = r6.getMessage()     // Catch:{ all -> 0x0086 }
            r8.append(r5)     // Catch:{ all -> 0x0086 }
            java.lang.String r5 = r8.toString()     // Catch:{ all -> 0x0086 }
            r4.<init>(r5, r6)     // Catch:{ all -> 0x0086 }
            throw r4     // Catch:{ all -> 0x0086 }
        L_0x0086:
            r5 = move-exception
        L_0x0087:
            closeSafe(r0)
            if (r7 == 0) goto L_0x008f
            r7.recycle()
        L_0x008f:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.BitmapUtils.decodeSampledBitmapRegion(android.content.Context, android.net.Uri, android.graphics.Rect, int, int, int):com.theartofdev.edmodo.cropper.BitmapUtils$BitmapSampled");
    }

    private static Bitmap cropForRotatedImage(Bitmap bitmap, float[] fArr, Rect rect, int i, boolean z, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        if (i % 90 == 0) {
            return bitmap;
        }
        double radians = Math.toRadians((double) i);
        int i7 = (i < 90 || (i > 180 && i < 270)) ? rect.left : rect.right;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i9 < fArr.length) {
                if (fArr[i9] >= ((float) (i7 - 1)) && fArr[i9] <= ((float) (i7 + 1))) {
                    int i10 = i9 + 1;
                    i8 = (int) Math.abs(Math.sin(radians) * ((double) (((float) rect.bottom) - fArr[i10])));
                    i5 = (int) Math.abs(Math.cos(radians) * ((double) (fArr[i10] - ((float) rect.top))));
                    i6 = (int) Math.abs(((double) (fArr[i10] - ((float) rect.top))) / Math.sin(radians));
                    i4 = (int) Math.abs(((double) (((float) rect.bottom) - fArr[i10])) / Math.cos(radians));
                    break;
                }
                i9 += 2;
            } else {
                i4 = 0;
                i5 = 0;
                i6 = 0;
                break;
            }
        }
        rect.set(i8, i5, i6 + i8, i4 + i5);
        if (z) {
            fixRectForAspectRatio(rect, i2, i3);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height());
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    private static int calculateInSampleSizeByReqestedSize(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            while ((i2 / 2) / i5 > i4 && (i / 2) / i5 > i3) {
                i5 *= 2;
            }
        }
        return i5;
    }

    private static int calculateInSampleSizeByMaxTextureSize(int i, int i2) {
        if (mMaxTextureSize == 0) {
            mMaxTextureSize = getMaxTextureSize();
        }
        int i3 = 1;
        if (mMaxTextureSize > 0) {
            while (true) {
                if (i2 / i3 <= mMaxTextureSize && i / i3 <= mMaxTextureSize) {
                    break;
                }
                i3 *= 2;
            }
        }
        return i3;
    }

    private static Bitmap rotateAndFlipBitmapInt(Bitmap bitmap, int i, boolean z, boolean z2) {
        if (i <= 0 && !z && !z2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i);
        float f = 1.0f;
        float f2 = z ? -1.0f : 1.0f;
        if (z2) {
            f = -1.0f;
        }
        matrix.postScale(f2, f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    private static int getMaxTextureSize() {
        try {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            int[] iArr = new int[1];
            egl10.eglGetConfigs(eglGetDisplay, (EGLConfig[]) null, 0, iArr);
            EGLConfig[] eGLConfigArr = new EGLConfig[iArr[0]];
            egl10.eglGetConfigs(eglGetDisplay, eGLConfigArr, iArr[0], iArr);
            int[] iArr2 = new int[1];
            int i = 0;
            for (int i2 = 0; i2 < iArr[0]; i2++) {
                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i2], 12332, iArr2);
                if (i < iArr2[0]) {
                    i = iArr2[0];
                }
            }
            egl10.eglTerminate(eglGetDisplay);
            return Math.max(i, 2048);
        } catch (Exception unused) {
            return 2048;
        }
    }

    private static void closeSafe(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    static final class BitmapSampled {
        public final Bitmap bitmap;
        final int sampleSize;

        BitmapSampled(Bitmap bitmap2, int i) {
            this.bitmap = bitmap2;
            this.sampleSize = i;
        }
    }

    static final class RotateBitmapResult {
        public final Bitmap bitmap;
        final int degrees;

        RotateBitmapResult(Bitmap bitmap2, int i) {
            this.bitmap = bitmap2;
            this.degrees = i;
        }
    }
}
