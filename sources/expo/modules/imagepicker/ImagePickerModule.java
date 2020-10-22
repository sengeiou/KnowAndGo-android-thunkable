package expo.modules.imagepicker;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.RNFetchBlob.RNFetchBlobConst;
import com.google.android.exoplayer2.extractor.p012ts.TsExtractor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.p032io.IOUtils;
import org.unimodules.core.ExportedModule;
import org.unimodules.core.ModuleRegistry;
import org.unimodules.core.Promise;
import org.unimodules.core.interfaces.ActivityEventListener;
import org.unimodules.core.interfaces.ActivityProvider;
import org.unimodules.core.interfaces.ExpoMethod;
import org.unimodules.core.interfaces.services.UIManager;
import org.unimodules.interfaces.imageloader.ImageLoader;
import org.unimodules.interfaces.permissions.Permissions;
import org.unimodules.interfaces.permissions.PermissionsResponse;
import org.unimodules.interfaces.permissions.PermissionsResponseListener;
import org.unimodules.interfaces.permissions.PermissionsStatus;

public class ImagePickerModule extends ExportedModule implements ActivityEventListener {
    private static final String CAN_NOT_DEDUCE_TYPE_MESSAGE = "Can not deduce type of the returned file.";
    private static final int DEFAULT_QUALITY = 100;
    private static final String ERR_CAN_NOT_DEDUCE_TYPE = "ERR_CAN_NOT_DEDUCE_TYPE";
    private static final String ERR_MISSING_ACTIVITY = "ERR_MISSING_ACTIVITY";
    private static final String MISSING_ACTIVITY_MESSAGE = "Activity which was provided during module initialization is no longer available";
    static final int REQUEST_LAUNCH_CAMERA = 1;
    static final int REQUEST_LAUNCH_IMAGE_LIBRARY = 2;
    public static final String TAG = "ExponentImagePicker";
    public static final String[][] exifTags;
    final String OPTION_ALLOWS_EDITING = "allowsEditing";
    final String OPTION_ASPECT = "aspect";
    final String OPTION_BASE64 = RNFetchBlobConst.RNFB_RESPONSE_BASE64;
    final String OPTION_EXIF = "exif";
    final String OPTION_MEDIA_TYPES = "mediaTypes";
    final String OPTION_QUALITY = "quality";
    /* access modifiers changed from: private */
    public Boolean allowsEditing = false;
    /* access modifiers changed from: private */
    public Boolean base64 = false;
    /* access modifiers changed from: private */
    public Boolean exif = false;
    /* access modifiers changed from: private */
    public ArrayList<Object> forceAspect = null;
    /* access modifiers changed from: private */
    public Uri mCameraCaptureURI;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public Bundle mExifData = null;
    private WeakReference<Activity> mExperienceActivity;
    /* access modifiers changed from: private */
    public ImageLoader mImageLoader;
    private boolean mInitialized = false;
    /* access modifiers changed from: private */
    public Boolean mLaunchedCropper = false;
    private ModuleRegistry mModuleRegistry;
    /* access modifiers changed from: private */
    public Promise mPromise;
    private String mediaTypes = null;
    /* access modifiers changed from: private */
    public Integer quality = null;

    public String getName() {
        return TAG;
    }

    public void onNewIntent(Intent intent) {
    }

    static {
        String[][] strArr = new String[TsExtractor.TS_STREAM_TYPE_AC3][];
        strArr[0] = new String[]{"string", ExifInterface.TAG_ARTIST};
        strArr[1] = new String[]{"int", ExifInterface.TAG_BITS_PER_SAMPLE};
        strArr[2] = new String[]{"int", ExifInterface.TAG_COMPRESSION};
        strArr[3] = new String[]{"string", ExifInterface.TAG_COPYRIGHT};
        strArr[4] = new String[]{"string", ExifInterface.TAG_DATETIME};
        strArr[5] = new String[]{"string", ExifInterface.TAG_IMAGE_DESCRIPTION};
        strArr[6] = new String[]{"int", ExifInterface.TAG_IMAGE_LENGTH};
        strArr[7] = new String[]{"int", ExifInterface.TAG_IMAGE_WIDTH};
        strArr[8] = new String[]{"int", ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT};
        strArr[9] = new String[]{"int", ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH};
        strArr[10] = new String[]{"string", ExifInterface.TAG_MAKE};
        strArr[11] = new String[]{"string", ExifInterface.TAG_MODEL};
        strArr[12] = new String[]{"int", ExifInterface.TAG_ORIENTATION};
        strArr[13] = new String[]{"int", ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION};
        strArr[14] = new String[]{"int", ExifInterface.TAG_PLANAR_CONFIGURATION};
        strArr[15] = new String[]{"double", ExifInterface.TAG_PRIMARY_CHROMATICITIES};
        strArr[16] = new String[]{"double", ExifInterface.TAG_REFERENCE_BLACK_WHITE};
        strArr[17] = new String[]{"int", ExifInterface.TAG_RESOLUTION_UNIT};
        strArr[18] = new String[]{"int", ExifInterface.TAG_ROWS_PER_STRIP};
        strArr[19] = new String[]{"int", ExifInterface.TAG_SAMPLES_PER_PIXEL};
        strArr[20] = new String[]{"string", ExifInterface.TAG_SOFTWARE};
        strArr[21] = new String[]{"int", ExifInterface.TAG_STRIP_BYTE_COUNTS};
        strArr[22] = new String[]{"int", ExifInterface.TAG_STRIP_OFFSETS};
        strArr[23] = new String[]{"int", ExifInterface.TAG_TRANSFER_FUNCTION};
        strArr[24] = new String[]{"double", ExifInterface.TAG_WHITE_POINT};
        strArr[25] = new String[]{"double", ExifInterface.TAG_X_RESOLUTION};
        strArr[26] = new String[]{"double", ExifInterface.TAG_Y_CB_CR_COEFFICIENTS};
        strArr[27] = new String[]{"int", ExifInterface.TAG_Y_CB_CR_POSITIONING};
        strArr[28] = new String[]{"int", ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING};
        strArr[29] = new String[]{"double", ExifInterface.TAG_Y_RESOLUTION};
        strArr[30] = new String[]{"double", ExifInterface.TAG_APERTURE_VALUE};
        strArr[31] = new String[]{"double", ExifInterface.TAG_BRIGHTNESS_VALUE};
        strArr[32] = new String[]{"string", ExifInterface.TAG_CFA_PATTERN};
        strArr[33] = new String[]{"int", ExifInterface.TAG_COLOR_SPACE};
        strArr[34] = new String[]{"string", ExifInterface.TAG_COMPONENTS_CONFIGURATION};
        strArr[35] = new String[]{"double", ExifInterface.TAG_COMPRESSED_BITS_PER_PIXEL};
        strArr[36] = new String[]{"int", ExifInterface.TAG_CONTRAST};
        strArr[37] = new String[]{"int", ExifInterface.TAG_CUSTOM_RENDERED};
        strArr[38] = new String[]{"string", ExifInterface.TAG_DATETIME_DIGITIZED};
        strArr[39] = new String[]{"string", ExifInterface.TAG_DATETIME_ORIGINAL};
        strArr[40] = new String[]{"string", ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION};
        strArr[41] = new String[]{"double", ExifInterface.TAG_DIGITAL_ZOOM_RATIO};
        strArr[42] = new String[]{"string", ExifInterface.TAG_EXIF_VERSION};
        strArr[43] = new String[]{"double", ExifInterface.TAG_EXPOSURE_BIAS_VALUE};
        strArr[44] = new String[]{"double", ExifInterface.TAG_EXPOSURE_INDEX};
        strArr[45] = new String[]{"int", ExifInterface.TAG_EXPOSURE_MODE};
        strArr[46] = new String[]{"int", ExifInterface.TAG_EXPOSURE_PROGRAM};
        strArr[47] = new String[]{"double", ExifInterface.TAG_EXPOSURE_TIME};
        strArr[48] = new String[]{"double", ExifInterface.TAG_F_NUMBER};
        strArr[49] = new String[]{"string", ExifInterface.TAG_FILE_SOURCE};
        strArr[50] = new String[]{"int", ExifInterface.TAG_FLASH};
        strArr[51] = new String[]{"double", ExifInterface.TAG_FLASH_ENERGY};
        strArr[52] = new String[]{"string", ExifInterface.TAG_FLASHPIX_VERSION};
        strArr[53] = new String[]{"double", ExifInterface.TAG_FOCAL_LENGTH};
        strArr[54] = new String[]{"int", ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM};
        strArr[55] = new String[]{"int", ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT};
        strArr[56] = new String[]{"double", ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION};
        strArr[57] = new String[]{"double", ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION};
        strArr[58] = new String[]{"int", ExifInterface.TAG_GAIN_CONTROL};
        strArr[59] = new String[]{"int", ExifInterface.TAG_ISO_SPEED_RATINGS};
        strArr[60] = new String[]{"string", ExifInterface.TAG_IMAGE_UNIQUE_ID};
        strArr[61] = new String[]{"int", ExifInterface.TAG_LIGHT_SOURCE};
        strArr[62] = new String[]{"string", ExifInterface.TAG_MAKER_NOTE};
        strArr[63] = new String[]{"double", ExifInterface.TAG_MAX_APERTURE_VALUE};
        strArr[64] = new String[]{"int", ExifInterface.TAG_METERING_MODE};
        strArr[65] = new String[]{"int", ExifInterface.TAG_NEW_SUBFILE_TYPE};
        strArr[66] = new String[]{"string", ExifInterface.TAG_OECF};
        strArr[67] = new String[]{"int", ExifInterface.TAG_PIXEL_X_DIMENSION};
        strArr[68] = new String[]{"int", ExifInterface.TAG_PIXEL_Y_DIMENSION};
        strArr[69] = new String[]{"string", ExifInterface.TAG_RELATED_SOUND_FILE};
        strArr[70] = new String[]{"int", ExifInterface.TAG_SATURATION};
        strArr[71] = new String[]{"int", ExifInterface.TAG_SCENE_CAPTURE_TYPE};
        strArr[72] = new String[]{"string", ExifInterface.TAG_SCENE_TYPE};
        strArr[73] = new String[]{"int", ExifInterface.TAG_SENSING_METHOD};
        strArr[74] = new String[]{"int", ExifInterface.TAG_SHARPNESS};
        strArr[75] = new String[]{"double", ExifInterface.TAG_SHUTTER_SPEED_VALUE};
        strArr[76] = new String[]{"string", ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE};
        strArr[77] = new String[]{"string", ExifInterface.TAG_SPECTRAL_SENSITIVITY};
        strArr[78] = new String[]{"int", ExifInterface.TAG_SUBFILE_TYPE};
        strArr[79] = new String[]{"string", ExifInterface.TAG_SUBSEC_TIME};
        strArr[80] = new String[]{"string", ExifInterface.TAG_SUBSEC_TIME_DIGITIZED};
        strArr[81] = new String[]{"string", ExifInterface.TAG_SUBSEC_TIME_ORIGINAL};
        strArr[82] = new String[]{"int", ExifInterface.TAG_SUBJECT_AREA};
        strArr[83] = new String[]{"double", ExifInterface.TAG_SUBJECT_DISTANCE};
        strArr[84] = new String[]{"int", ExifInterface.TAG_SUBJECT_DISTANCE_RANGE};
        strArr[85] = new String[]{"int", ExifInterface.TAG_SUBJECT_LOCATION};
        strArr[86] = new String[]{"string", ExifInterface.TAG_USER_COMMENT};
        strArr[87] = new String[]{"int", ExifInterface.TAG_WHITE_BALANCE};
        strArr[88] = new String[]{"int", ExifInterface.TAG_GPS_ALTITUDE_REF};
        strArr[89] = new String[]{"string", ExifInterface.TAG_GPS_AREA_INFORMATION};
        strArr[90] = new String[]{"double", ExifInterface.TAG_GPS_DOP};
        strArr[91] = new String[]{"string", ExifInterface.TAG_GPS_DATESTAMP};
        strArr[92] = new String[]{"double", ExifInterface.TAG_GPS_DEST_BEARING};
        strArr[93] = new String[]{"string", ExifInterface.TAG_GPS_DEST_BEARING_REF};
        strArr[94] = new String[]{"double", ExifInterface.TAG_GPS_DEST_DISTANCE};
        strArr[95] = new String[]{"string", ExifInterface.TAG_GPS_DEST_DISTANCE_REF};
        strArr[96] = new String[]{"double", ExifInterface.TAG_GPS_DEST_LATITUDE};
        strArr[97] = new String[]{"string", ExifInterface.TAG_GPS_DEST_LATITUDE_REF};
        strArr[98] = new String[]{"double", ExifInterface.TAG_GPS_DEST_LONGITUDE};
        strArr[99] = new String[]{"string", ExifInterface.TAG_GPS_DEST_LONGITUDE_REF};
        strArr[100] = new String[]{"int", ExifInterface.TAG_GPS_DIFFERENTIAL};
        strArr[101] = new String[]{"double", ExifInterface.TAG_GPS_IMG_DIRECTION};
        strArr[102] = new String[]{"string", ExifInterface.TAG_GPS_IMG_DIRECTION_REF};
        strArr[103] = new String[]{"string", ExifInterface.TAG_GPS_LATITUDE_REF};
        strArr[104] = new String[]{"string", ExifInterface.TAG_GPS_LONGITUDE_REF};
        strArr[105] = new String[]{"string", ExifInterface.TAG_GPS_MAP_DATUM};
        strArr[106] = new String[]{"string", ExifInterface.TAG_GPS_MEASURE_MODE};
        strArr[107] = new String[]{"string", ExifInterface.TAG_GPS_PROCESSING_METHOD};
        strArr[108] = new String[]{"string", ExifInterface.TAG_GPS_SATELLITES};
        strArr[109] = new String[]{"double", ExifInterface.TAG_GPS_SPEED};
        strArr[110] = new String[]{"string", ExifInterface.TAG_GPS_SPEED_REF};
        strArr[111] = new String[]{"string", ExifInterface.TAG_GPS_STATUS};
        strArr[112] = new String[]{"string", ExifInterface.TAG_GPS_TIMESTAMP};
        strArr[113] = new String[]{"double", ExifInterface.TAG_GPS_TRACK};
        strArr[114] = new String[]{"string", ExifInterface.TAG_GPS_TRACK_REF};
        strArr[115] = new String[]{"string", ExifInterface.TAG_GPS_VERSION_ID};
        strArr[116] = new String[]{"string", ExifInterface.TAG_INTEROPERABILITY_INDEX};
        strArr[117] = new String[]{"int", ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH};
        strArr[118] = new String[]{"int", ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH};
        strArr[119] = new String[]{"int", ExifInterface.TAG_DNG_VERSION};
        strArr[120] = new String[]{"int", ExifInterface.TAG_DEFAULT_CROP_SIZE};
        strArr[121] = new String[]{"int", ExifInterface.TAG_ORF_PREVIEW_IMAGE_START};
        strArr[122] = new String[]{"int", ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH};
        strArr[123] = new String[]{"int", ExifInterface.TAG_ORF_ASPECT_FRAME};
        strArr[124] = new String[]{"int", ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER};
        strArr[125] = new String[]{"int", ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER};
        strArr[126] = new String[]{"int", ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER};
        strArr[127] = new String[]{"int", ExifInterface.TAG_RW2_SENSOR_TOP_BORDER};
        strArr[128] = new String[]{"int", ExifInterface.TAG_RW2_ISO};
        exifTags = strArr;
    }

    public ImagePickerModule(Context context) {
        super(context);
        this.mContext = context;
    }

    private boolean readOptions(Map<String, Object> map, Promise promise) {
        if (map.containsKey("quality")) {
            this.quality = Integer.valueOf((int) (((Double) map.get("quality")).doubleValue() * 100.0d));
        }
        boolean z = false;
        this.allowsEditing = Boolean.valueOf(map.containsKey("allowsEditing") && ((Boolean) map.get("allowsEditing")).booleanValue());
        if (map.containsKey("mediaTypes")) {
            this.mediaTypes = (String) map.get("mediaTypes");
        } else {
            this.mediaTypes = "Images";
        }
        if (map.containsKey("aspect")) {
            this.forceAspect = (ArrayList) map.get("aspect");
            if (this.forceAspect.size() != 2 || !(this.forceAspect.get(0) instanceof Number) || !(this.forceAspect.get(1) instanceof Number)) {
                promise.reject(new IllegalArgumentException("'aspect option must be of form [Number, Number]"));
                return false;
            }
        } else {
            this.forceAspect = null;
        }
        this.base64 = Boolean.valueOf(map.containsKey(RNFetchBlobConst.RNFB_RESPONSE_BASE64) && ((Boolean) map.get(RNFetchBlobConst.RNFB_RESPONSE_BASE64)).booleanValue());
        if (map.containsKey("exif") && ((Boolean) map.get("exif")).booleanValue()) {
            z = true;
        }
        this.exif = Boolean.valueOf(z);
        return true;
    }

    @ExpoMethod
    public void requestCameraRollPermissionsAsync(Promise promise) {
        Permissions.CC.askForPermissionsWithPermissionsManager((Permissions) this.mModuleRegistry.getModule(Permissions.class), promise, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
    }

    @ExpoMethod
    public void getCameraRollPermissionsAsync(Promise promise) {
        Permissions.CC.getPermissionsWithPermissionsManager((Permissions) this.mModuleRegistry.getModule(Permissions.class), promise, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
    }

    @ExpoMethod
    public void requestCameraPermissionsAsync(Promise promise) {
        Permissions.CC.askForPermissionsWithPermissionsManager((Permissions) this.mModuleRegistry.getModule(Permissions.class), promise, "android.permission.CAMERA");
    }

    @ExpoMethod
    public void getCameraPermissionsAsync(Promise promise) {
        Permissions.CC.getPermissionsWithPermissionsManager((Permissions) this.mModuleRegistry.getModule(Permissions.class), promise, "android.permission.CAMERA");
    }

    @ExpoMethod
    public void launchCameraAsync(Map<String, Object> map, Promise promise) {
        if (readOptions(map, promise)) {
            if (getExperienceActivity() == null) {
                promise.reject(ERR_MISSING_ACTIVITY, MISSING_ACTIVITY_MESSAGE);
                return;
            }
            Intent intent = new Intent(this.mediaTypes.equals("Videos") ? "android.media.action.VIDEO_CAPTURE" : "android.media.action.IMAGE_CAPTURE");
            if (intent.resolveActivity(getApplication((Promise) null).getPackageManager()) == null) {
                promise.reject(new IllegalStateException("Error resolving activity"));
                return;
            }
            Permissions permissions = (Permissions) this.mModuleRegistry.getModule(Permissions.class);
            if (permissions == null) {
                promise.reject("E_NO_PERMISSIONS", "Permissions module is null. Are you sure all the installed Expo modules are properly linked?");
            } else {
                permissions.askForPermissions(new PermissionsResponseListener(promise, intent) {
                    private final /* synthetic */ Promise f$1;
                    private final /* synthetic */ Intent f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onResult(Map map) {
                        ImagePickerModule.lambda$launchCameraAsync$0(ImagePickerModule.this, this.f$1, this.f$2, map);
                    }
                }, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA");
            }
        }
    }

    public static /* synthetic */ void lambda$launchCameraAsync$0(ImagePickerModule imagePickerModule, Promise promise, Intent intent, Map map) {
        if (((PermissionsResponse) map.get("android.permission.WRITE_EXTERNAL_STORAGE")).getStatus() == PermissionsStatus.GRANTED && ((PermissionsResponse) map.get("android.permission.CAMERA")).getStatus() == PermissionsStatus.GRANTED) {
            imagePickerModule.launchCameraWithPermissionsGranted(promise, intent);
        } else {
            promise.reject(new SecurityException("User rejected permissions"));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void launchCameraWithPermissionsGranted(org.unimodules.core.Promise r10, android.content.Intent r11) {
        /*
            r9 = this;
            r0 = 0
            r1 = 1
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x0045 }
            android.content.Context r3 = r9.mContext     // Catch:{ IOException -> 0x0045 }
            java.io.File r3 = r3.getCacheDir()     // Catch:{ IOException -> 0x0045 }
            java.lang.String r4 = "ImagePicker"
            java.lang.String r5 = r9.mediaTypes     // Catch:{ IOException -> 0x0045 }
            java.lang.String r6 = "Videos"
            boolean r5 = r5.equals(r6)     // Catch:{ IOException -> 0x0045 }
            if (r5 == 0) goto L_0x0019
            java.lang.String r5 = ".mp4"
            goto L_0x001b
        L_0x0019:
            java.lang.String r5 = ".jpg"
        L_0x001b:
            java.lang.String r3 = expo.modules.imagepicker.ImagePickerFileUtils.generateOutputPath(r3, r4, r5)     // Catch:{ IOException -> 0x0045 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0045 }
            boolean r3 = r2.createNewFile()     // Catch:{ IOException -> 0x0040 }
            r3 = r3 ^ r1
            if (r3 == 0) goto L_0x004b
            java.lang.String r3 = r9.getName()     // Catch:{ IOException -> 0x0040 }
            java.lang.String r4 = "File %s already exists."
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ IOException -> 0x0040 }
            r6 = 0
            java.lang.String r7 = r2.getAbsolutePath()     // Catch:{ IOException -> 0x0040 }
            r5[r6] = r7     // Catch:{ IOException -> 0x0040 }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ IOException -> 0x0040 }
            android.util.Log.w(r3, r4)     // Catch:{ IOException -> 0x0040 }
            goto L_0x004b
        L_0x0040:
            r3 = move-exception
            r8 = r3
            r3 = r2
            r2 = r8
            goto L_0x0047
        L_0x0045:
            r2 = move-exception
            r3 = r0
        L_0x0047:
            r2.printStackTrace()
            r2 = r3
        L_0x004b:
            if (r2 != 0) goto L_0x0058
            java.io.IOException r11 = new java.io.IOException
            java.lang.String r0 = "Could not create image file."
            r11.<init>(r0)
            r10.reject(r11)
            return
        L_0x0058:
            android.net.Uri r3 = expo.modules.imagepicker.ImagePickerFileUtils.uriFromFile(r2)
            r9.mCameraCaptureURI = r3
            android.app.Activity r3 = r9.getExperienceActivity()
            if (r3 != 0) goto L_0x006c
            java.lang.String r11 = "ERR_MISSING_ACTIVITY"
            java.lang.String r0 = "Activity which was provided during module initialization is no longer available"
            r10.reject((java.lang.String) r11, (java.lang.String) r0)
            return
        L_0x006c:
            android.app.Activity r3 = r9.getExperienceActivity()
            android.app.Application r3 = r3.getApplication()
            android.content.pm.PackageManager r4 = r3.getPackageManager()
            r5 = 65536(0x10000, float:9.18355E-41)
            java.util.List r4 = r4.queryIntentActivities(r11, r5)
            java.util.Iterator r4 = r4.iterator()
        L_0x0082:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0099
            java.lang.Object r5 = r4.next()
            android.content.pm.ResolveInfo r5 = (android.content.pm.ResolveInfo) r5
            android.content.pm.ActivityInfo r5 = r5.activityInfo
            java.lang.String r5 = r5.packageName
            android.net.Uri r6 = r9.mCameraCaptureURI
            r7 = 3
            r3.grantUriPermission(r5, r6, r7)
            goto L_0x0082
        L_0x0099:
            r9.mPromise = r10
            java.lang.String r3 = "output"
            android.app.Application r0 = r9.getApplication(r0)
            android.net.Uri r0 = expo.modules.imagepicker.ImagePickerFileUtils.contentUriFromFile(r2, r0)
            r11.putExtra(r3, r0)
            r9.startActivityOnResult(r11, r1, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.ImagePickerModule.launchCameraWithPermissionsGranted(org.unimodules.core.Promise, android.content.Intent):void");
    }

    @ExpoMethod
    public void launchImageLibraryAsync(Map<String, Object> map, Promise promise) {
        if (readOptions(map, promise)) {
            Intent intent = new Intent();
            if (this.mediaTypes.equals("Images")) {
                intent.setType("image/*");
            } else if (this.mediaTypes.equals("Videos")) {
                intent.setType("video/*");
            } else if (this.mediaTypes.equals("All")) {
                intent.setType("*/*");
                intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            }
            this.mPromise = promise;
            intent.setAction("android.intent.action.GET_CONTENT");
            startActivityOnResult(intent, 2, promise);
        }
    }

    public void onActivityResult(final int i, int i2, final Intent intent) {
        if (i == 203) {
            if (this.mLaunchedCropper.booleanValue()) {
                this.mLaunchedCropper = false;
                Promise promise = this.mPromise;
                this.mPromise = null;
                Bundle bundle = this.mExifData;
                this.mExifData = null;
                if (promise != null) {
                    if (i2 != -1) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putBoolean("cancelled", true);
                        promise.resolve(bundle2);
                        return;
                    }
                    handleCropperResult(intent, promise, bundle);
                }
            }
        } else if (this.mPromise == null) {
        } else {
            if (this.mCameraCaptureURI != null || i != 1) {
                if (i == 1 || i == 2) {
                    final Promise promise2 = this.mPromise;
                    this.mPromise = null;
                    if (i2 != -1) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putBoolean("cancelled", true);
                        if (i == 1) {
                            revokeUriPermissionForCamera();
                        }
                        promise2.resolve(bundle3);
                        return;
                    }
                    AsyncTask.execute(new Runnable() {
                        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                        /* JADX WARNING: Missing exception handler attribute for start block: B:92:0x02a1 */
                        /* JADX WARNING: Removed duplicated region for block: B:40:0x00c4 A[Catch:{ Exception -> 0x02c6 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:41:0x00c9 A[Catch:{ Exception -> 0x02c6 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:44:0x00dd A[Catch:{ Exception -> 0x02c6 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:45:0x00df A[Catch:{ Exception -> 0x02c6 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:48:0x00f6 A[Catch:{ Exception -> 0x02c6 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:56:0x016d A[Catch:{ Exception -> 0x02c6 }] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                                r15 = this;
                                int r0 = r5     // Catch:{ Exception -> 0x02c6 }
                                r1 = 1
                                if (r0 != r1) goto L_0x000c
                                expo.modules.imagepicker.ImagePickerModule r0 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                android.net.Uri r0 = r0.mCameraCaptureURI     // Catch:{ Exception -> 0x02c6 }
                                goto L_0x0012
                            L_0x000c:
                                android.content.Intent r0 = r7     // Catch:{ Exception -> 0x02c6 }
                                android.net.Uri r0 = r0.getData()     // Catch:{ Exception -> 0x02c6 }
                            L_0x0012:
                                r7 = r0
                                expo.modules.imagepicker.ImagePickerModule r0 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                java.lang.Boolean r0 = r0.exif     // Catch:{ Exception -> 0x02c6 }
                                boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x02c6 }
                                r2 = 0
                                if (r0 == 0) goto L_0x002a
                                expo.modules.imagepicker.ImagePickerModule r0 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                org.unimodules.core.Promise r3 = r3     // Catch:{ Exception -> 0x02c6 }
                                android.os.Bundle r0 = r0.readExif(r7, r3)     // Catch:{ Exception -> 0x02c6 }
                                r9 = r0
                                goto L_0x002b
                            L_0x002a:
                                r9 = r2
                            L_0x002b:
                                expo.modules.imagepicker.ImagePickerModule r0 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                android.app.Activity r0 = r0.getExperienceActivity()     // Catch:{ Exception -> 0x02c6 }
                                if (r0 != 0) goto L_0x003d
                                org.unimodules.core.Promise r0 = r3     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r1 = "ERR_MISSING_ACTIVITY"
                                java.lang.String r2 = "Activity which was provided during module initialization is no longer available"
                                r0.reject((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x02c6 }
                                return
                            L_0x003d:
                                expo.modules.imagepicker.ImagePickerModule r0 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                android.app.Activity r0 = r0.getExperienceActivity()     // Catch:{ Exception -> 0x02c6 }
                                android.app.Application r0 = r0.getApplication()     // Catch:{ Exception -> 0x02c6 }
                                android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r0 = expo.modules.imagepicker.ImagePickerFileUtils.getType(r0, r7)     // Catch:{ Exception -> 0x02c6 }
                                if (r0 != 0) goto L_0x005b
                                org.unimodules.core.Promise r0 = r3     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r1 = "ERR_CAN_NOT_DEDUCE_TYPE"
                                java.lang.String r2 = "Can not deduce type of the returned file."
                                r0.reject((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x02c6 }
                                return
                            L_0x005b:
                                java.lang.String r3 = "image"
                                boolean r3 = r0.contains(r3)     // Catch:{ Exception -> 0x02c6 }
                                r4 = 0
                                if (r3 == 0) goto L_0x021d
                                java.lang.String r3 = ".jpg"
                                android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r6 = "png"
                                boolean r6 = r0.contains(r6)     // Catch:{ Exception -> 0x02c6 }
                                if (r6 == 0) goto L_0x0076
                                android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r3 = ".png"
                            L_0x0074:
                                r5 = r0
                                goto L_0x00c0
                            L_0x0076:
                                java.lang.String r6 = "gif"
                                boolean r6 = r0.contains(r6)     // Catch:{ Exception -> 0x02c6 }
                                if (r6 == 0) goto L_0x0092
                                expo.modules.imagepicker.ImagePickerModule r0 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                java.lang.Boolean r0 = r0.allowsEditing     // Catch:{ Exception -> 0x02c6 }
                                boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x02c6 }
                                if (r0 == 0) goto L_0x008f
                                java.lang.String r3 = ".png"
                                android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x02c6 }
                                goto L_0x0074
                            L_0x008f:
                                java.lang.String r3 = ".gif"
                                goto L_0x00c0
                            L_0x0092:
                                java.lang.String r6 = "bmp"
                                boolean r6 = r0.contains(r6)     // Catch:{ Exception -> 0x02c6 }
                                if (r6 == 0) goto L_0x00af
                                expo.modules.imagepicker.ImagePickerModule r0 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                java.lang.Boolean r0 = r0.allowsEditing     // Catch:{ Exception -> 0x02c6 }
                                boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x02c6 }
                                if (r0 == 0) goto L_0x00ab
                                java.lang.String r3 = ".png"
                                android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x02c6 }
                                goto L_0x0074
                            L_0x00ab:
                                java.lang.String r3 = ".bmp"
                                r5 = r2
                                goto L_0x00c0
                            L_0x00af:
                                java.lang.String r6 = "jpeg"
                                boolean r0 = r0.contains(r6)     // Catch:{ Exception -> 0x02c6 }
                                if (r0 != 0) goto L_0x00c0
                                java.io.PrintStream r0 = java.lang.System.out     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r3 = "ExponentImagePicker Image type not supported. Falling back to JPEG instead."
                                r0.println(r3)     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r3 = ".jpg"
                            L_0x00c0:
                                int r0 = r5     // Catch:{ Exception -> 0x02c6 }
                                if (r0 != r1) goto L_0x00c9
                                java.lang.String r0 = r7.getPath()     // Catch:{ Exception -> 0x02c6 }
                                goto L_0x00d9
                            L_0x00c9:
                                expo.modules.imagepicker.ImagePickerModule r0 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                android.content.Context r0 = r0.mContext     // Catch:{ Exception -> 0x02c6 }
                                java.io.File r0 = r0.getCacheDir()     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r6 = "ImagePicker"
                                java.lang.String r0 = expo.modules.imagepicker.ImagePickerFileUtils.generateOutputPath(r0, r6, r3)     // Catch:{ Exception -> 0x02c6 }
                            L_0x00d9:
                                int r3 = r5     // Catch:{ Exception -> 0x02c6 }
                                if (r3 != r1) goto L_0x00df
                                r3 = r7
                                goto L_0x00e8
                            L_0x00df:
                                java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x02c6 }
                                r3.<init>(r0)     // Catch:{ Exception -> 0x02c6 }
                                android.net.Uri r3 = android.net.Uri.fromFile(r3)     // Catch:{ Exception -> 0x02c6 }
                            L_0x00e8:
                                expo.modules.imagepicker.ImagePickerModule r6 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                java.lang.Boolean r6 = r6.allowsEditing     // Catch:{ Exception -> 0x02c6 }
                                boolean r6 = r6.booleanValue()     // Catch:{ Exception -> 0x02c6 }
                                r8 = 100
                                if (r6 == 0) goto L_0x016d
                                expo.modules.imagepicker.ImagePickerModule r0 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x02c6 }
                                java.lang.Boolean unused = r0.mLaunchedCropper = r2     // Catch:{ Exception -> 0x02c6 }
                                expo.modules.imagepicker.ImagePickerModule r0 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                org.unimodules.core.Promise r2 = r3     // Catch:{ Exception -> 0x02c6 }
                                org.unimodules.core.Promise unused = r0.mPromise = r2     // Catch:{ Exception -> 0x02c6 }
                                expo.modules.imagepicker.ImagePickerModule r0 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                android.os.Bundle unused = r0.mExifData = r9     // Catch:{ Exception -> 0x02c6 }
                                com.theartofdev.edmodo.cropper.CropImage$ActivityBuilder r0 = com.theartofdev.edmodo.cropper.CropImage.activity(r7)     // Catch:{ Exception -> 0x02c6 }
                                expo.modules.imagepicker.ImagePickerModule r2 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                java.util.ArrayList r2 = r2.forceAspect     // Catch:{ Exception -> 0x02c6 }
                                if (r2 == 0) goto L_0x0143
                                expo.modules.imagepicker.ImagePickerModule r2 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                java.util.ArrayList r2 = r2.forceAspect     // Catch:{ Exception -> 0x02c6 }
                                java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x02c6 }
                                java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ Exception -> 0x02c6 }
                                int r2 = r2.intValue()     // Catch:{ Exception -> 0x02c6 }
                                expo.modules.imagepicker.ImagePickerModule r4 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                java.util.ArrayList r4 = r4.forceAspect     // Catch:{ Exception -> 0x02c6 }
                                java.lang.Object r4 = r4.get(r1)     // Catch:{ Exception -> 0x02c6 }
                                java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ Exception -> 0x02c6 }
                                int r4 = r4.intValue()     // Catch:{ Exception -> 0x02c6 }
                                com.theartofdev.edmodo.cropper.CropImage$ActivityBuilder r2 = r0.setAspectRatio(r2, r4)     // Catch:{ Exception -> 0x02c6 }
                                com.theartofdev.edmodo.cropper.CropImage$ActivityBuilder r1 = r2.setFixAspectRatio(r1)     // Catch:{ Exception -> 0x02c6 }
                                r2 = 0
                                r1.setInitialCropWindowPaddingRatio(r2)     // Catch:{ Exception -> 0x02c6 }
                            L_0x0143:
                                com.theartofdev.edmodo.cropper.CropImage$ActivityBuilder r0 = r0.setOutputUri(r3)     // Catch:{ Exception -> 0x02c6 }
                                com.theartofdev.edmodo.cropper.CropImage$ActivityBuilder r0 = r0.setOutputCompressFormat(r5)     // Catch:{ Exception -> 0x02c6 }
                                expo.modules.imagepicker.ImagePickerModule r1 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                java.lang.Integer r1 = r1.quality     // Catch:{ Exception -> 0x02c6 }
                                if (r1 != 0) goto L_0x0154
                                goto L_0x015e
                            L_0x0154:
                                expo.modules.imagepicker.ImagePickerModule r1 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                java.lang.Integer r1 = r1.quality     // Catch:{ Exception -> 0x02c6 }
                                int r8 = r1.intValue()     // Catch:{ Exception -> 0x02c6 }
                            L_0x015e:
                                com.theartofdev.edmodo.cropper.CropImage$ActivityBuilder r0 = r0.setOutputCompressQuality(r8)     // Catch:{ Exception -> 0x02c6 }
                                expo.modules.imagepicker.ImagePickerModule r1 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                android.app.Activity r1 = r1.getExperienceActivity()     // Catch:{ Exception -> 0x02c6 }
                                r0.start(r1)     // Catch:{ Exception -> 0x02c6 }
                                goto L_0x02ca
                            L_0x016d:
                                expo.modules.imagepicker.ImagePickerModule r3 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                java.lang.Integer r3 = r3.quality     // Catch:{ Exception -> 0x02c6 }
                                if (r3 == 0) goto L_0x019a
                                expo.modules.imagepicker.ImagePickerModule r3 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                java.lang.Integer r3 = r3.quality     // Catch:{ Exception -> 0x02c6 }
                                int r3 = r3.intValue()     // Catch:{ Exception -> 0x02c6 }
                                if (r3 != r8) goto L_0x0182
                                goto L_0x019a
                            L_0x0182:
                                expo.modules.imagepicker.ImagePickerModule r1 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                org.unimodules.interfaces.imageloader.ImageLoader r1 = r1.mImageLoader     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r8 = r7.toString()     // Catch:{ Exception -> 0x02c6 }
                                expo.modules.imagepicker.ImagePickerModule$1$1 r10 = new expo.modules.imagepicker.ImagePickerModule$1$1     // Catch:{ Exception -> 0x02c6 }
                                r2 = r10
                                r3 = r15
                                r4 = r0
                                r6 = r9
                                r2.<init>(r4, r5, r6, r7)     // Catch:{ Exception -> 0x02c6 }
                                r1.loadImageForManipulationFromURL(r8, r10)     // Catch:{ Exception -> 0x02c6 }
                                goto L_0x02ca
                            L_0x019a:
                                expo.modules.imagepicker.ImagePickerModule r3 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ IOException -> 0x01f6 }
                                java.lang.Boolean r3 = r3.base64     // Catch:{ IOException -> 0x01f6 }
                                boolean r3 = r3.booleanValue()     // Catch:{ IOException -> 0x01f6 }
                                if (r3 == 0) goto L_0x01ac
                                java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x01f6 }
                                r3.<init>()     // Catch:{ IOException -> 0x01f6 }
                                goto L_0x01ad
                            L_0x01ac:
                                r3 = r2
                            L_0x01ad:
                                java.io.File r4 = new java.io.File     // Catch:{ Throwable -> 0x01e2 }
                                r4.<init>(r0)     // Catch:{ Throwable -> 0x01e2 }
                                expo.modules.imagepicker.ImagePickerModule r0 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Throwable -> 0x01e2 }
                                r0.copyImage(r7, r4, r3)     // Catch:{ Throwable -> 0x01e2 }
                                android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options     // Catch:{ Throwable -> 0x01e2 }
                                r0.<init>()     // Catch:{ Throwable -> 0x01e2 }
                                r0.inJustDecodeBounds = r1     // Catch:{ Throwable -> 0x01e2 }
                                java.lang.String r1 = r4.getAbsolutePath()     // Catch:{ Throwable -> 0x01e2 }
                                android.graphics.BitmapFactory.decodeFile(r1, r0)     // Catch:{ Throwable -> 0x01e2 }
                                expo.modules.imagepicker.ImagePickerModule r8 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Throwable -> 0x01e2 }
                                java.net.URI r1 = r4.toURI()     // Catch:{ Throwable -> 0x01e2 }
                                java.lang.String r10 = r1.toString()     // Catch:{ Throwable -> 0x01e2 }
                                int r11 = r0.outWidth     // Catch:{ Throwable -> 0x01e2 }
                                int r12 = r0.outHeight     // Catch:{ Throwable -> 0x01e2 }
                                org.unimodules.core.Promise r14 = r3     // Catch:{ Throwable -> 0x01e2 }
                                r13 = r3
                                r8.returnImageResult(r9, r10, r11, r12, r13, r14)     // Catch:{ Throwable -> 0x01e2 }
                                if (r3 == 0) goto L_0x02ca
                                r3.close()     // Catch:{ IOException -> 0x01f6 }
                                goto L_0x02ca
                            L_0x01e0:
                                r0 = move-exception
                                goto L_0x01e5
                            L_0x01e2:
                                r0 = move-exception
                                r2 = r0
                                throw r2     // Catch:{ all -> 0x01e0 }
                            L_0x01e5:
                                if (r3 == 0) goto L_0x01f5
                                if (r2 == 0) goto L_0x01f2
                                r3.close()     // Catch:{ Throwable -> 0x01ed }
                                goto L_0x01f5
                            L_0x01ed:
                                r1 = move-exception
                                r2.addSuppressed(r1)     // Catch:{ IOException -> 0x01f6 }
                                goto L_0x01f5
                            L_0x01f2:
                                r3.close()     // Catch:{ IOException -> 0x01f6 }
                            L_0x01f5:
                                throw r0     // Catch:{ IOException -> 0x01f6 }
                            L_0x01f6:
                                r0 = move-exception
                                org.unimodules.core.Promise r1 = r3     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r2 = "E_COPY_ERR"
                                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c6 }
                                r3.<init>()     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r4 = "Could not copy image from "
                                r3.append(r4)     // Catch:{ Exception -> 0x02c6 }
                                r3.append(r7)     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r4 = ": "
                                r3.append(r4)     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r4 = r0.getMessage()     // Catch:{ Exception -> 0x02c6 }
                                r3.append(r4)     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02c6 }
                                r1.reject(r2, r3, r0)     // Catch:{ Exception -> 0x02c6 }
                                goto L_0x02ca
                            L_0x021d:
                                android.os.Bundle r0 = new android.os.Bundle     // Catch:{ Exception -> 0x02c6 }
                                r0.<init>()     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r1 = "uri"
                                java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x02c6 }
                                expo.modules.imagepicker.ImagePickerModule r3 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r3 = r3.writeVideo(r7)     // Catch:{ Exception -> 0x02c6 }
                                r2.<init>(r3)     // Catch:{ Exception -> 0x02c6 }
                                android.net.Uri r2 = android.net.Uri.fromFile(r2)     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x02c6 }
                                r0.putString(r1, r2)     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r1 = "cancelled"
                                r0.putBoolean(r1, r4)     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r1 = "type"
                                java.lang.String r2 = "video"
                                r0.putString(r1, r2)     // Catch:{ Exception -> 0x02c6 }
                                android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever     // Catch:{ Exception -> 0x02c6 }
                                r1.<init>()     // Catch:{ Exception -> 0x02c6 }
                                expo.modules.imagepicker.ImagePickerModule r2 = expo.modules.imagepicker.ImagePickerModule.this     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                android.content.Context r2 = r2.mContext     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                r1.setDataSource(r2, r7)     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                java.lang.String r2 = "width"
                                r3 = 18
                                java.lang.String r3 = r1.extractMetadata(r3)     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                int r3 = r3.intValue()     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                r0.putInt(r2, r3)     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                java.lang.String r2 = "height"
                                r3 = 19
                                java.lang.String r3 = r1.extractMetadata(r3)     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                int r3 = r3.intValue()     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                r0.putInt(r2, r3)     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                java.lang.String r2 = "rotation"
                                r3 = 24
                                java.lang.String r3 = r1.extractMetadata(r3)     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                int r3 = r3.intValue()     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                r0.putInt(r2, r3)     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                java.lang.String r2 = "duration"
                                r3 = 9
                                java.lang.String r1 = r1.extractMetadata(r3)     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                int r1 = r1.intValue()     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                r0.putInt(r2, r1)     // Catch:{ IllegalArgumentException | SecurityException -> 0x02a1 }
                                goto L_0x02c0
                            L_0x02a1:
                                java.io.PrintStream r1 = java.lang.System.out     // Catch:{ Exception -> 0x02c6 }
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02c6 }
                                r2.<init>()     // Catch:{ Exception -> 0x02c6 }
                                java.lang.Class<expo.modules.imagepicker.ImagePickerModule> r3 = expo.modules.imagepicker.ImagePickerModule.class
                                java.lang.String r3 = r3.getSimpleName()     // Catch:{ Exception -> 0x02c6 }
                                r2.append(r3)     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r3 = " Could not read metadata from video: "
                                r2.append(r3)     // Catch:{ Exception -> 0x02c6 }
                                r2.append(r7)     // Catch:{ Exception -> 0x02c6 }
                                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x02c6 }
                                r1.println(r2)     // Catch:{ Exception -> 0x02c6 }
                            L_0x02c0:
                                org.unimodules.core.Promise r1 = r3     // Catch:{ Exception -> 0x02c6 }
                                r1.resolve(r0)     // Catch:{ Exception -> 0x02c6 }
                                goto L_0x02ca
                            L_0x02c6:
                                r0 = move-exception
                                r0.printStackTrace()
                            L_0x02ca:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.ImagePickerModule.C34811.run():void");
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void saveImage(Bitmap bitmap, Bitmap.CompressFormat compressFormat, File file, ByteArrayOutputStream byteArrayOutputStream) {
        writeImage(bitmap, file.getPath(), compressFormat);
        if (this.base64.booleanValue()) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, this.quality.intValue(), byteArrayOutputStream);
        }
    }

    /* access modifiers changed from: private */
    public void copyImage(Uri uri, File file, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        FileOutputStream fileOutputStream;
        Throwable th;
        Throwable th2;
        Throwable th3;
        InputStream inputStream = (InputStream) Objects.requireNonNull(this.mContext.getApplicationContext().getContentResolver().openInputStream(uri));
        if (byteArrayOutputStream != null) {
            try {
                IOUtils.copy(inputStream, (OutputStream) byteArrayOutputStream);
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
        }
        if (uri.compareTo(Uri.fromFile(file)) != 0) {
            fileOutputStream = new FileOutputStream(file);
            if (byteArrayOutputStream != null) {
                try {
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                } catch (Throwable th5) {
                    Throwable th6 = th5;
                    th = th;
                    th2 = th6;
                }
            } else {
                IOUtils.copy(inputStream, (OutputStream) fileOutputStream);
            }
            fileOutputStream.close();
        }
        if (inputStream != null) {
            inputStream.close();
            return;
        }
        return;
        throw th;
        throw th2;
        if (th != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable th7) {
                th.addSuppressed(th7);
            }
        } else {
            fileOutputStream.close();
        }
        throw th2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006a, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006e, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006f, code lost:
        r10 = r14;
        r14 = r12;
        r12 = r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleCropperResult(android.content.Intent r12, org.unimodules.core.Promise r13, android.os.Bundle r14) {
        /*
            r11 = this;
            com.theartofdev.edmodo.cropper.CropImage$ActivityResult r12 = com.theartofdev.edmodo.cropper.CropImage.getActivityResult(r12)
            int r0 = r12.getRotation()
            int r0 = r0 % 360
            if (r0 >= 0) goto L_0x000e
            int r0 = r0 + 360
        L_0x000e:
            if (r0 == 0) goto L_0x0026
            r1 = 180(0xb4, float:2.52E-43)
            if (r0 != r1) goto L_0x0015
            goto L_0x0026
        L_0x0015:
            android.graphics.Rect r0 = r12.getCropRect()
            int r0 = r0.height()
            android.graphics.Rect r1 = r12.getCropRect()
            int r1 = r1.width()
            goto L_0x0036
        L_0x0026:
            android.graphics.Rect r0 = r12.getCropRect()
            int r0 = r0.width()
            android.graphics.Rect r1 = r12.getCropRect()
            int r1 = r1.height()
        L_0x0036:
            r5 = r0
            r6 = r1
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00a8 }
            android.net.Uri r1 = r12.getUri()     // Catch:{ IOException -> 0x00a8 }
            java.lang.String r1 = r1.getPath()     // Catch:{ IOException -> 0x00a8 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x00a8 }
            r1 = 0
            java.lang.Boolean r2 = r11.base64     // Catch:{ Throwable -> 0x0096 }
            boolean r2 = r2.booleanValue()     // Catch:{ Throwable -> 0x0096 }
            if (r2 == 0) goto L_0x0081
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x0096 }
            r9.<init>()     // Catch:{ Throwable -> 0x0096 }
            org.apache.commons.p032io.IOUtils.copy((java.io.InputStream) r0, (java.io.OutputStream) r9)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            android.net.Uri r12 = r12.getUri()     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            java.lang.String r4 = r12.toString()     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r2 = r11
            r3 = r14
            r7 = r9
            r8 = r13
            r2.returnImageResult(r3, r4, r5, r6, r7, r8)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r9.close()     // Catch:{ Throwable -> 0x0096 }
            goto L_0x0090
        L_0x0069:
            r12 = move-exception
            r14 = r1
            goto L_0x0072
        L_0x006c:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x006e }
        L_0x006e:
            r14 = move-exception
            r10 = r14
            r14 = r12
            r12 = r10
        L_0x0072:
            if (r14 == 0) goto L_0x007d
            r9.close()     // Catch:{ Throwable -> 0x0078 }
            goto L_0x0080
        L_0x0078:
            r2 = move-exception
            r14.addSuppressed(r2)     // Catch:{ Throwable -> 0x0096 }
            goto L_0x0080
        L_0x007d:
            r9.close()     // Catch:{ Throwable -> 0x0096 }
        L_0x0080:
            throw r12     // Catch:{ Throwable -> 0x0096 }
        L_0x0081:
            android.net.Uri r12 = r12.getUri()     // Catch:{ Throwable -> 0x0096 }
            java.lang.String r4 = r12.toString()     // Catch:{ Throwable -> 0x0096 }
            r7 = 0
            r2 = r11
            r3 = r14
            r8 = r13
            r2.returnImageResult(r3, r4, r5, r6, r7, r8)     // Catch:{ Throwable -> 0x0096 }
        L_0x0090:
            r0.close()     // Catch:{ IOException -> 0x00a8 }
            goto L_0x00ac
        L_0x0094:
            r12 = move-exception
            goto L_0x0099
        L_0x0096:
            r12 = move-exception
            r1 = r12
            throw r1     // Catch:{ all -> 0x0094 }
        L_0x0099:
            if (r1 == 0) goto L_0x00a4
            r0.close()     // Catch:{ Throwable -> 0x009f }
            goto L_0x00a7
        L_0x009f:
            r14 = move-exception
            r1.addSuppressed(r14)     // Catch:{ IOException -> 0x00a8 }
            goto L_0x00a7
        L_0x00a4:
            r0.close()     // Catch:{ IOException -> 0x00a8 }
        L_0x00a7:
            throw r12     // Catch:{ IOException -> 0x00a8 }
        L_0x00a8:
            r12 = move-exception
            r13.reject(r12)
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.ImagePickerModule.handleCropperResult(android.content.Intent, org.unimodules.core.Promise, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public void returnImageResult(Bundle bundle, String str, int i, int i2, ByteArrayOutputStream byteArrayOutputStream, Promise promise) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("uri", str);
        if (this.base64.booleanValue()) {
            bundle2.putString(RNFetchBlobConst.RNFB_RESPONSE_BASE64, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
        }
        bundle2.putInt("width", i);
        bundle2.putInt("height", i2);
        if (bundle != null) {
            bundle2.putBundle("exif", bundle);
        }
        bundle2.putBoolean("cancelled", false);
        bundle2.putString("type", "image");
        promise.resolve(bundle2);
    }

    private void writeImage(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        FileOutputStream fileOutputStream;
        Throwable th;
        try {
            fileOutputStream = new FileOutputStream(str);
            bitmap.compress(compressFormat, this.quality.intValue(), fileOutputStream);
            fileOutputStream.close();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
        r6 = r4;
        r4 = r3;
        r3 = r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String writeVideo(android.net.Uri r8) {
        /*
            r7 = this;
            r0 = 0
            org.unimodules.core.Promise r1 = r7.mPromise     // Catch:{ IOException -> 0x0076 }
            android.app.Application r1 = r7.getApplication(r1)     // Catch:{ IOException -> 0x0076 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ IOException -> 0x0076 }
            java.io.InputStream r8 = r1.openInputStream(r8)     // Catch:{ IOException -> 0x0076 }
            java.lang.Object r8 = java.util.Objects.requireNonNull(r8)     // Catch:{ IOException -> 0x0076 }
            java.io.InputStream r8 = (java.io.InputStream) r8     // Catch:{ IOException -> 0x0076 }
            android.content.Context r1 = r7.mContext     // Catch:{ Throwable -> 0x005d, all -> 0x005a }
            java.io.File r1 = r1.getCacheDir()     // Catch:{ Throwable -> 0x005d, all -> 0x005a }
            java.lang.String r2 = "ImagePicker"
            java.lang.String r3 = ".mp4"
            java.lang.String r1 = expo.modules.imagepicker.ImagePickerFileUtils.generateOutputPath(r1, r2, r3)     // Catch:{ Throwable -> 0x005d, all -> 0x005a }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Throwable -> 0x0058 }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x0058 }
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x0043, all -> 0x0040 }
        L_0x002c:
            int r4 = r8.read(r3)     // Catch:{ Throwable -> 0x0043, all -> 0x0040 }
            if (r4 <= 0) goto L_0x0037
            r5 = 0
            r2.write(r3, r5, r4)     // Catch:{ Throwable -> 0x0043, all -> 0x0040 }
            goto L_0x002c
        L_0x0037:
            r2.close()     // Catch:{ Throwable -> 0x0058 }
            if (r8 == 0) goto L_0x007b
            r8.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x007b
        L_0x0040:
            r3 = move-exception
            r4 = r0
            goto L_0x0049
        L_0x0043:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r4 = move-exception
            r6 = r4
            r4 = r3
            r3 = r6
        L_0x0049:
            if (r4 == 0) goto L_0x0054
            r2.close()     // Catch:{ Throwable -> 0x004f }
            goto L_0x0057
        L_0x004f:
            r2 = move-exception
            r4.addSuppressed(r2)     // Catch:{ Throwable -> 0x0058 }
            goto L_0x0057
        L_0x0054:
            r2.close()     // Catch:{ Throwable -> 0x0058 }
        L_0x0057:
            throw r3     // Catch:{ Throwable -> 0x0058 }
        L_0x0058:
            r0 = move-exception
            goto L_0x0061
        L_0x005a:
            r2 = move-exception
            r1 = r0
            goto L_0x0063
        L_0x005d:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L_0x0061:
            throw r0     // Catch:{ all -> 0x0062 }
        L_0x0062:
            r2 = move-exception
        L_0x0063:
            if (r8 == 0) goto L_0x0073
            if (r0 == 0) goto L_0x0070
            r8.close()     // Catch:{ Throwable -> 0x006b }
            goto L_0x0073
        L_0x006b:
            r8 = move-exception
            r0.addSuppressed(r8)     // Catch:{ IOException -> 0x0074 }
            goto L_0x0073
        L_0x0070:
            r8.close()     // Catch:{ IOException -> 0x0074 }
        L_0x0073:
            throw r2     // Catch:{ IOException -> 0x0074 }
        L_0x0074:
            r8 = move-exception
            goto L_0x0078
        L_0x0076:
            r8 = move-exception
            r1 = r0
        L_0x0078:
            r8.printStackTrace()
        L_0x007b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.ImagePickerModule.writeVideo(android.net.Uri):java.lang.String");
    }

    /* access modifiers changed from: private */
    public Bundle readExif(Uri uri, Promise promise) throws IOException {
        InputStream inputStream;
        Throwable th;
        Throwable th2;
        Throwable th3;
        Application application = getApplication(promise);
        if (application == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        inputStream = (InputStream) Objects.requireNonNull(application.getContentResolver().openInputStream(uri));
        try {
            ExifInterface exifInterface = new ExifInterface(inputStream);
            for (String[] strArr : exifTags) {
                String str = strArr[1];
                if (exifInterface.getAttribute(str) != null) {
                    String str2 = strArr[0];
                    char c = 65535;
                    int hashCode = str2.hashCode();
                    if (hashCode != -1325958191) {
                        if (hashCode != -891985903) {
                            if (hashCode == 104431) {
                                if (str2.equals("int")) {
                                    c = 1;
                                }
                            }
                        } else if (str2.equals("string")) {
                            c = 0;
                        }
                    } else if (str2.equals("double")) {
                        c = 2;
                    }
                    switch (c) {
                        case 0:
                            bundle.putString(str, exifInterface.getAttribute(str));
                            break;
                        case 1:
                            bundle.putInt(str, exifInterface.getAttributeInt(str, 0));
                            break;
                        case 2:
                            bundle.putDouble(str, exifInterface.getAttributeDouble(str, 0.0d));
                            break;
                    }
                }
            }
            double[] latLong = exifInterface.getLatLong();
            if (latLong != null) {
                bundle.putDouble(ExifInterface.TAG_GPS_LATITUDE, latLong[0]);
                bundle.putDouble(ExifInterface.TAG_GPS_LONGITUDE, latLong[1]);
                bundle.putDouble(ExifInterface.TAG_GPS_ALTITUDE, exifInterface.getAltitude(0.0d));
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return bundle;
        } catch (Throwable th4) {
            th = th3;
            th2 = th4;
        }
        if (inputStream != null) {
            if (th != null) {
                try {
                    inputStream.close();
                } catch (Throwable th5) {
                    th.addSuppressed(th5);
                }
            } else {
                inputStream.close();
            }
        }
        throw th2;
        throw th2;
    }

    /* access modifiers changed from: private */
    public void revokeUriPermissionForCamera() {
        if (getApplication((Promise) null) != null) {
            getApplication((Promise) null).revokeUriPermission(this.mCameraCaptureURI, 3);
        }
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        this.mModuleRegistry = moduleRegistry;
        this.mImageLoader = (ImageLoader) moduleRegistry.getModule(ImageLoader.class);
    }

    /* access modifiers changed from: private */
    public Activity getExperienceActivity() {
        if (!this.mInitialized) {
            this.mInitialized = true;
            this.mExperienceActivity = new WeakReference<>(((ActivityProvider) this.mModuleRegistry.getModule(ActivityProvider.class)).getCurrentActivity());
            ((UIManager) this.mModuleRegistry.getModule(UIManager.class)).registerActivityEventListener(this);
        }
        return (Activity) this.mExperienceActivity.get();
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (getExperienceActivity() != null && activity == getExperienceActivity()) {
            onActivityResult(i, i2, intent);
        }
    }

    private void startActivityOnResult(Intent intent, int i, Promise promise) {
        if (getExperienceActivity() != null) {
            getExperienceActivity().startActivityForResult(intent, i);
        } else {
            promise.reject(ERR_MISSING_ACTIVITY, MISSING_ACTIVITY_MESSAGE);
        }
    }

    private Application getApplication(Promise promise) {
        if (getExperienceActivity() != null) {
            return getExperienceActivity().getApplication();
        }
        if (promise == null) {
            return null;
        }
        promise.reject(ERR_MISSING_ACTIVITY, MISSING_ACTIVITY_MESSAGE);
        return null;
    }
}
