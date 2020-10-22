package com.imagepicker;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Patterns;
import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.RNFetchBlob.RNFetchBlobConst;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionListener;
import com.google.android.exoplayer2.util.MimeTypes;
import com.imagepicker.media.ImageConfig;
import com.imagepicker.utils.C2314UI;
import com.imagepicker.utils.MediaUtils;
import com.imagepicker.utils.ReadableMapUtils;
import com.imagepicker.utils.RealPathUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@ReactModule(name = "ImagePickerManager")
public class ImagePickerModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    public static final int DEFAULT_EXPLAINING_PERMISSION_DIALIOG_THEME = C2307R.style.DefaultExplainingPermissionsTheme;
    public static final String NAME = "ImagePickerManager";
    public static final int REQUEST_LAUNCH_IMAGE_CAPTURE = 13001;
    public static final int REQUEST_LAUNCH_IMAGE_LIBRARY = 13002;
    public static final int REQUEST_LAUNCH_VIDEO_CAPTURE = 13004;
    public static final int REQUEST_LAUNCH_VIDEO_LIBRARY = 13003;
    public static final int REQUEST_PERMISSIONS_FOR_CAMERA = 14001;
    public static final int REQUEST_PERMISSIONS_FOR_LIBRARY = 14002;
    protected Callback callback;
    protected Uri cameraCaptureURI;
    private final int dialogThemeId;
    private ImageConfig imageConfig;
    private PermissionListener listener;
    private Boolean noData;
    /* access modifiers changed from: private */
    public ReadableMap options;
    /* access modifiers changed from: private */
    public Callback permissionRequestCallback;
    private Boolean pickBoth;
    private Boolean pickVideo;
    private final ReactApplicationContext reactContext;
    /* access modifiers changed from: private */
    public ResponseHelper responseHelper;
    @Deprecated
    private int videoDurationLimit;
    @Deprecated
    private int videoQuality;

    public String getName() {
        return NAME;
    }

    public void onNewIntent(Intent intent) {
    }

    public ImagePickerModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, DEFAULT_EXPLAINING_PERMISSION_DIALIOG_THEME);
    }

    public ImagePickerModule(ReactApplicationContext reactApplicationContext, @StyleRes int i) {
        super(reactApplicationContext);
        this.noData = false;
        this.pickVideo = false;
        this.pickBoth = false;
        this.imageConfig = new ImageConfig((File) null, (File) null, 0, 0, 100, 0, false);
        this.videoQuality = 1;
        this.videoDurationLimit = 0;
        this.responseHelper = new ResponseHelper();
        this.listener = new PermissionListener() {
            public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                boolean z = true;
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    z = z && (iArr[i2] == 0);
                }
                if (ImagePickerModule.this.callback == null || ImagePickerModule.this.options == null) {
                    return false;
                }
                if (!z) {
                    ImagePickerModule.this.responseHelper.invokeError(ImagePickerModule.this.permissionRequestCallback, "Permissions weren't granted");
                    return false;
                }
                switch (i) {
                    case ImagePickerModule.REQUEST_PERMISSIONS_FOR_CAMERA /*14001*/:
                        ImagePickerModule.this.launchCamera(ImagePickerModule.this.options, ImagePickerModule.this.permissionRequestCallback);
                        break;
                    case ImagePickerModule.REQUEST_PERMISSIONS_FOR_LIBRARY /*14002*/:
                        ImagePickerModule.this.launchImageLibrary(ImagePickerModule.this.options, ImagePickerModule.this.permissionRequestCallback);
                        break;
                }
                return true;
            }
        };
        this.dialogThemeId = i;
        this.reactContext = reactApplicationContext;
        this.reactContext.addActivityEventListener(this);
    }

    @ReactMethod
    public void showImagePicker(ReadableMap readableMap, Callback callback2) {
        if (getCurrentActivity() == null) {
            this.responseHelper.invokeError(callback2, "can't find current Activity");
            return;
        }
        this.callback = callback2;
        this.options = readableMap;
        this.imageConfig = new ImageConfig((File) null, (File) null, 0, 0, 100, 0, false);
        C2314UI.chooseDialog(this, readableMap, new C2314UI.OnAction() {
            public void onTakePhoto(@NonNull ImagePickerModule imagePickerModule) {
                if (imagePickerModule != null) {
                    imagePickerModule.launchCamera();
                }
            }

            public void onUseLibrary(@NonNull ImagePickerModule imagePickerModule) {
                if (imagePickerModule != null) {
                    imagePickerModule.launchImageLibrary();
                }
            }

            public void onCancel(@NonNull ImagePickerModule imagePickerModule) {
                if (imagePickerModule != null) {
                    imagePickerModule.doOnCancel();
                }
            }

            public void onCustomButton(@NonNull ImagePickerModule imagePickerModule, @NonNull String str) {
                if (imagePickerModule != null) {
                    imagePickerModule.invokeCustomButton(str);
                }
            }
        }).show();
    }

    public void doOnCancel() {
        if (this.callback != null) {
            this.responseHelper.invokeCancel(this.callback);
            this.callback = null;
        }
    }

    public void launchCamera() {
        launchCamera(this.options, this.callback);
    }

    @ReactMethod
    public void launchCamera(ReadableMap readableMap, Callback callback2) {
        int i;
        Intent intent;
        this.permissionRequestCallback = callback2;
        if (!isCameraAvailable()) {
            this.responseHelper.invokeError(callback2, "Camera not available");
            return;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            this.responseHelper.invokeError(callback2, "can't find current Activity");
            return;
        }
        this.callback = callback2;
        this.options = readableMap;
        if (permissionsCheck(currentActivity, callback2, REQUEST_PERMISSIONS_FOR_CAMERA)) {
            parseOptions(this.options);
            if (this.pickVideo.booleanValue()) {
                i = REQUEST_LAUNCH_VIDEO_CAPTURE;
                intent = new Intent("android.media.action.VIDEO_CAPTURE");
                intent.putExtra("android.intent.extra.videoQuality", this.videoQuality);
                if (this.videoDurationLimit > 0) {
                    intent.putExtra("android.intent.extra.durationLimit", this.videoDurationLimit);
                }
            } else {
                i = REQUEST_LAUNCH_IMAGE_CAPTURE;
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                this.imageConfig = this.imageConfig.withOriginalFile(MediaUtils.createNewFile(this.reactContext, this.options, false));
                if (this.imageConfig.original != null) {
                    this.cameraCaptureURI = RealPathUtil.compatUriFromFile(this.reactContext, this.imageConfig.original);
                    if (this.cameraCaptureURI == null) {
                        this.responseHelper.invokeError(callback2, "Couldn't get file path for photo");
                        return;
                    }
                    intent.putExtra("output", this.cameraCaptureURI);
                } else {
                    this.responseHelper.invokeError(callback2, "Couldn't get file path for photo");
                    return;
                }
            }
            if (intent.resolveActivity(this.reactContext.getPackageManager()) == null) {
                this.responseHelper.invokeError(callback2, "Cannot launch camera");
                return;
            }
            if (Build.VERSION.SDK_INT <= 19) {
                for (ResolveInfo resolveInfo : this.reactContext.getPackageManager().queryIntentActivities(intent, 65536)) {
                    this.reactContext.grantUriPermission(resolveInfo.activityInfo.packageName, this.cameraCaptureURI, 3);
                }
            }
            try {
                currentActivity.startActivityForResult(intent, i);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                this.responseHelper.invokeError(callback2, "Cannot launch camera");
            }
        }
    }

    public void launchImageLibrary() {
        launchImageLibrary(this.options, this.callback);
    }

    @ReactMethod
    public void launchImageLibrary(ReadableMap readableMap, Callback callback2) {
        Intent intent;
        int i;
        this.permissionRequestCallback = callback2;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            this.responseHelper.invokeError(callback2, "can't find current Activity");
            return;
        }
        this.callback = callback2;
        this.options = readableMap;
        if (permissionsCheck(currentActivity, callback2, REQUEST_PERMISSIONS_FOR_LIBRARY)) {
            parseOptions(this.options);
            if (this.pickVideo.booleanValue()) {
                i = REQUEST_LAUNCH_VIDEO_LIBRARY;
                intent = new Intent("android.intent.action.PICK");
                intent.setType("video/*");
            } else {
                i = REQUEST_LAUNCH_IMAGE_LIBRARY;
                intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if (this.pickBoth.booleanValue()) {
                    intent.setType("image/* video/*");
                }
            }
            if (intent.resolveActivity(this.reactContext.getPackageManager()) == null) {
                this.responseHelper.invokeError(callback2, "Cannot launch photo library");
                return;
            }
            String str = null;
            try {
                if (ReadableMapUtils.hasAndNotEmptyString(readableMap, "chooseWhichLibraryTitle")) {
                    str = readableMap.getString("chooseWhichLibraryTitle");
                }
                currentActivity.startActivityForResult(Intent.createChooser(intent, str), i);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                this.responseHelper.invokeError(callback2, "Cannot launch photo library");
            }
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        Uri uri;
        if (!passResult(i)) {
            this.responseHelper.cleanResponse();
            if (i2 != -1) {
                MediaUtils.removeUselessFiles(i, this.imageConfig);
                this.responseHelper.invokeCancel(this.callback);
                this.callback = null;
                return;
            }
            switch (i) {
                case REQUEST_LAUNCH_IMAGE_CAPTURE /*13001*/:
                    uri = this.cameraCaptureURI;
                    break;
                case REQUEST_LAUNCH_IMAGE_LIBRARY /*13002*/:
                    uri = intent.getData();
                    String realPathFromURI = getRealPathFromURI(uri);
                    boolean z = !TextUtils.isEmpty(realPathFromURI) && Patterns.WEB_URL.matcher(realPathFromURI).matches();
                    if (realPathFromURI == null || z) {
                        try {
                            File createFileFromURI = createFileFromURI(uri);
                            String absolutePath = createFileFromURI.getAbsolutePath();
                            uri = Uri.fromFile(createFileFromURI);
                            realPathFromURI = absolutePath;
                        } catch (Exception unused) {
                            this.responseHelper.putString("error", "Could not read photo");
                            this.responseHelper.putString("uri", uri.toString());
                            this.responseHelper.invokeResponse(this.callback);
                            this.callback = null;
                            return;
                        }
                    }
                    this.imageConfig = this.imageConfig.withOriginalFile(new File(realPathFromURI));
                    break;
                case REQUEST_LAUNCH_VIDEO_LIBRARY /*13003*/:
                    this.responseHelper.putString("uri", intent.getData().toString());
                    this.responseHelper.putString(RNFetchBlobConst.RNFB_RESPONSE_PATH, getRealPathFromURI(intent.getData()));
                    this.responseHelper.invokeResponse(this.callback);
                    this.callback = null;
                    return;
                case REQUEST_LAUNCH_VIDEO_CAPTURE /*13004*/:
                    String realPathFromURI2 = getRealPathFromURI(intent.getData());
                    this.responseHelper.putString("uri", intent.getData().toString());
                    this.responseHelper.putString(RNFetchBlobConst.RNFB_RESPONSE_PATH, realPathFromURI2);
                    MediaUtils.fileScan(this.reactContext, realPathFromURI2);
                    this.responseHelper.invokeResponse(this.callback);
                    this.callback = null;
                    return;
                default:
                    uri = null;
                    break;
            }
            MediaUtils.ReadExifResult readExifInterface = MediaUtils.readExifInterface(this.responseHelper, this.imageConfig);
            if (readExifInterface.error != null) {
                MediaUtils.removeUselessFiles(i, this.imageConfig);
                this.responseHelper.invokeError(this.callback, readExifInterface.error.getMessage());
                this.callback = null;
                return;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(this.imageConfig.original.getAbsolutePath(), options2);
            int i3 = options2.outWidth;
            int i4 = options2.outHeight;
            updatedResultResponse(uri, this.imageConfig.original.getAbsolutePath());
            if (this.imageConfig.useOriginal(i3, i4, readExifInterface.currentRotation)) {
                this.responseHelper.putInt("width", i3);
                this.responseHelper.putInt("height", i4);
                MediaUtils.fileScan(this.reactContext, this.imageConfig.original.getAbsolutePath());
            } else {
                this.imageConfig = MediaUtils.getResizedImage(this.reactContext, this.options, this.imageConfig, i3, i4, i);
                if (this.imageConfig.resized == null) {
                    MediaUtils.removeUselessFiles(i, this.imageConfig);
                    this.responseHelper.putString("error", "Can't resize the image");
                } else {
                    Uri fromFile = Uri.fromFile(this.imageConfig.resized);
                    BitmapFactory.decodeFile(this.imageConfig.resized.getAbsolutePath(), options2);
                    this.responseHelper.putInt("width", options2.outWidth);
                    this.responseHelper.putInt("height", options2.outHeight);
                    updatedResultResponse(fromFile, this.imageConfig.resized.getAbsolutePath());
                    MediaUtils.fileScan(this.reactContext, this.imageConfig.resized.getAbsolutePath());
                }
            }
            if (this.imageConfig.saveToCameraRoll && i == 13001) {
                MediaUtils.RolloutPhotoResult rolloutPhotoFromCamera = MediaUtils.rolloutPhotoFromCamera(this.imageConfig);
                if (rolloutPhotoFromCamera.error == null) {
                    this.imageConfig = rolloutPhotoFromCamera.imageConfig;
                    updatedResultResponse(Uri.fromFile(this.imageConfig.getActualFile()), this.imageConfig.getActualFile().getAbsolutePath());
                } else {
                    MediaUtils.removeUselessFiles(i, this.imageConfig);
                    this.responseHelper.putString("error", "Error moving image to camera roll: " + rolloutPhotoFromCamera.error.getMessage());
                    return;
                }
            }
            this.responseHelper.invokeResponse(this.callback);
            this.callback = null;
            this.options = null;
        }
    }

    public void invokeCustomButton(@NonNull String str) {
        this.responseHelper.invokeCustomButton(this.callback, str);
    }

    public Context getContext() {
        return getReactApplicationContext();
    }

    @StyleRes
    public int getDialogThemeId() {
        return this.dialogThemeId;
    }

    @NonNull
    public Activity getActivity() {
        return getCurrentActivity();
    }

    private boolean passResult(int i) {
        return this.callback == null || (this.cameraCaptureURI == null && i == 13001) || !(i == 13001 || i == 13002 || i == 13003 || i == 13004);
    }

    private void updatedResultResponse(@Nullable Uri uri, @NonNull String str) {
        this.responseHelper.putString("uri", uri.toString());
        this.responseHelper.putString(RNFetchBlobConst.RNFB_RESPONSE_PATH, str);
        if (!this.noData.booleanValue()) {
            this.responseHelper.putString("data", getBase64StringFromFile(str));
        }
        putExtraFileInfo(str, this.responseHelper);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale(r4, "android.permission.CAMERA") == false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
        if (java.lang.Boolean.valueOf(r1).booleanValue() == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        r4 = com.imagepicker.permissions.PermissionUtils.explainingDialog(r3, r3.options, new com.imagepicker.ImagePickerModule.C23063(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        if (r4 == null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        r4.show();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004a, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        switch(r6) {
            case com.imagepicker.ImagePickerModule.REQUEST_PERMISSIONS_FOR_CAMERA :int: goto L_0x0058;
            case com.imagepicker.ImagePickerModule.REQUEST_PERMISSIONS_FOR_LIBRARY :int: goto L_0x0051;
            default: goto L_0x004e;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        r5 = new java.lang.String[0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        r5 = new java.lang.String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        r5 = new java.lang.String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        if ((r4 instanceof com.facebook.react.ReactActivity) == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0064, code lost:
        ((com.facebook.react.ReactActivity) r4).requestPermissions(r5, r6, r3.listener);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006e, code lost:
        if ((r4 instanceof com.facebook.react.modules.core.PermissionAwareActivity) == false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0070, code lost:
        ((com.facebook.react.modules.core.PermissionAwareActivity) r4).requestPermissions(r5, r6, r3.listener);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007a, code lost:
        if ((r4 instanceof com.imagepicker.permissions.OnImagePickerPermissionsCallback) == false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007c, code lost:
        ((com.imagepicker.permissions.OnImagePickerPermissionsCallback) r4).setPermissionListener(r3.listener);
        androidx.core.app.ActivityCompat.requestPermissions(r4, r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0087, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ba, code lost:
        throw new java.lang.UnsupportedOperationException(r4.getClass().getSimpleName() + " must implement " + com.imagepicker.permissions.OnImagePickerPermissionsCallback.class.getSimpleName() + " or " + com.facebook.react.modules.core.PermissionAwareActivity.class.getSimpleName());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bb, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
        if (r5 == 0) goto L_0x0015;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        if (r5 == 0) goto L_0x0015;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r5 != false) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale(r4, "android.permission.WRITE_EXTERNAL_STORAGE") == false) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean permissionsCheck(@androidx.annotation.NonNull android.app.Activity r4, @androidx.annotation.NonNull com.facebook.react.bridge.Callback r5, @androidx.annotation.NonNull int r6) {
        /*
            r3 = this;
            java.lang.String r5 = "android.permission.WRITE_EXTERNAL_STORAGE"
            int r5 = androidx.core.app.ActivityCompat.checkSelfPermission(r4, r5)
            java.lang.String r0 = "android.permission.CAMERA"
            int r0 = androidx.core.app.ActivityCompat.checkSelfPermission(r4, r0)
            r1 = 1
            r2 = 0
            switch(r6) {
                case 14001: goto L_0x0017;
                case 14002: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            r5 = 0
            goto L_0x001c
        L_0x0013:
            if (r5 != 0) goto L_0x0011
        L_0x0015:
            r5 = 1
            goto L_0x001c
        L_0x0017:
            if (r0 != 0) goto L_0x0011
            if (r5 != 0) goto L_0x0011
            goto L_0x0015
        L_0x001c:
            if (r5 != 0) goto L_0x00bb
            java.lang.String r5 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r5 = androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale(r4, r5)
            if (r5 == 0) goto L_0x002f
            java.lang.String r5 = "android.permission.CAMERA"
            boolean r5 = androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale(r4, r5)
            if (r5 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r1 = 0
        L_0x0030:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x004b
            com.facebook.react.bridge.ReadableMap r4 = r3.options
            com.imagepicker.ImagePickerModule$3 r5 = new com.imagepicker.ImagePickerModule$3
            r5.<init>()
            androidx.appcompat.app.AlertDialog r4 = com.imagepicker.permissions.PermissionUtils.explainingDialog(r3, r4, r5)
            if (r4 == 0) goto L_0x004a
            r4.show()
        L_0x004a:
            return r2
        L_0x004b:
            switch(r6) {
                case 14001: goto L_0x0058;
                case 14002: goto L_0x0051;
                default: goto L_0x004e;
            }
        L_0x004e:
            java.lang.String[] r5 = new java.lang.String[r2]
            goto L_0x0060
        L_0x0051:
            java.lang.String r5 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            goto L_0x0060
        L_0x0058:
            java.lang.String r5 = "android.permission.CAMERA"
            java.lang.String r0 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String[] r5 = new java.lang.String[]{r5, r0}
        L_0x0060:
            boolean r0 = r4 instanceof com.facebook.react.ReactActivity
            if (r0 == 0) goto L_0x006c
            com.facebook.react.ReactActivity r4 = (com.facebook.react.ReactActivity) r4
            com.facebook.react.modules.core.PermissionListener r0 = r3.listener
            r4.requestPermissions(r5, r6, r0)
            goto L_0x0087
        L_0x006c:
            boolean r0 = r4 instanceof com.facebook.react.modules.core.PermissionAwareActivity
            if (r0 == 0) goto L_0x0078
            com.facebook.react.modules.core.PermissionAwareActivity r4 = (com.facebook.react.modules.core.PermissionAwareActivity) r4
            com.facebook.react.modules.core.PermissionListener r0 = r3.listener
            r4.requestPermissions(r5, r6, r0)
            goto L_0x0087
        L_0x0078:
            boolean r0 = r4 instanceof com.imagepicker.permissions.OnImagePickerPermissionsCallback
            if (r0 == 0) goto L_0x0088
            r0 = r4
            com.imagepicker.permissions.OnImagePickerPermissionsCallback r0 = (com.imagepicker.permissions.OnImagePickerPermissionsCallback) r0
            com.facebook.react.modules.core.PermissionListener r1 = r3.listener
            r0.setPermissionListener(r1)
            androidx.core.app.ActivityCompat.requestPermissions(r4, r5, r6)
        L_0x0087:
            return r2
        L_0x0088:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getSimpleName()
            r5.<init>(r4)
            java.lang.String r4 = " must implement "
            r5.append(r4)
            java.lang.Class<com.imagepicker.permissions.OnImagePickerPermissionsCallback> r4 = com.imagepicker.permissions.OnImagePickerPermissionsCallback.class
            java.lang.String r4 = r4.getSimpleName()
            r5.append(r4)
            java.lang.String r4 = " or "
            r5.append(r4)
            java.lang.Class<com.facebook.react.modules.core.PermissionAwareActivity> r4 = com.facebook.react.modules.core.PermissionAwareActivity.class
            java.lang.String r4 = r4.getSimpleName()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.UnsupportedOperationException r5 = new java.lang.UnsupportedOperationException
            r5.<init>(r4)
            throw r5
        L_0x00bb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.imagepicker.ImagePickerModule.permissionsCheck(android.app.Activity, com.facebook.react.bridge.Callback, int):boolean");
    }

    private boolean isCameraAvailable() {
        return this.reactContext.getPackageManager().hasSystemFeature("android.hardware.camera") || this.reactContext.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    @NonNull
    private String getRealPathFromURI(@NonNull Uri uri) {
        return RealPathUtil.getRealPathFromURI(this.reactContext, uri);
    }

    private File createFileFromURI(Uri uri) throws Exception {
        File externalCacheDir = this.reactContext.getExternalCacheDir();
        File file = new File(externalCacheDir, "photo-" + uri.getLastPathSegment());
        InputStream openInputStream = this.reactContext.getContentResolver().openInputStream(uri);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = openInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    return file;
                }
            }
        } finally {
            fileOutputStream.close();
            openInputStream.close();
        }
    }

    private String getBase64StringFromFile(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileInputStream = null;
        }
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    private void putExtraFileInfo(@NonNull String str, @NonNull ResponseHelper responseHelper2) {
        try {
            File file = new File(str);
            responseHelper2.putDouble("fileSize", (double) file.length());
            responseHelper2.putString("fileName", file.getName());
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
            String name = file.getName();
            if (fileExtensionFromUrl != "") {
                responseHelper2.putString("type", MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl));
                return;
            }
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0) {
                responseHelper2.putString("type", MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(lastIndexOf + 1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseOptions(ReadableMap readableMap) {
        this.noData = false;
        if (readableMap.hasKey("noData")) {
            this.noData = Boolean.valueOf(readableMap.getBoolean("noData"));
        }
        this.imageConfig = this.imageConfig.updateFromOptions(readableMap);
        this.pickVideo = false;
        this.pickBoth = false;
        if (readableMap.hasKey("mediaType") && readableMap.getString("mediaType").equals("mixed")) {
            this.pickBoth = true;
        }
        if (readableMap.hasKey("mediaType") && readableMap.getString("mediaType").equals(MimeTypes.BASE_TYPE_VIDEO)) {
            this.pickVideo = true;
        }
        this.videoQuality = 1;
        if (readableMap.hasKey("videoQuality") && readableMap.getString("videoQuality").equals("low")) {
            this.videoQuality = 0;
        }
        this.videoDurationLimit = 0;
        if (readableMap.hasKey("durationLimit")) {
            this.videoDurationLimit = readableMap.getInt("durationLimit");
        }
    }
}
