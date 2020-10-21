package com.theartofdev.edmodo.cropper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.io.File;
import java.io.IOException;

public class CropImageActivity extends AppCompatActivity implements CropImageView.OnSetImageUriCompleteListener, CropImageView.OnCropImageCompleteListener {
    private Uri mCropImageUri;
    private CropImageView mCropImageView;
    private CropImageOptions mOptions;

    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        CharSequence charSequence;
        super.onCreate(bundle);
        setContentView(C2900R.layout.crop_image_activity);
        this.mCropImageView = (CropImageView) findViewById(C2900R.C2903id.cropImageView);
        Bundle bundleExtra = getIntent().getBundleExtra(CropImage.CROP_IMAGE_EXTRA_BUNDLE);
        this.mCropImageUri = (Uri) bundleExtra.getParcelable(CropImage.CROP_IMAGE_EXTRA_SOURCE);
        this.mOptions = (CropImageOptions) bundleExtra.getParcelable(CropImage.CROP_IMAGE_EXTRA_OPTIONS);
        if (bundle == null) {
            if (this.mCropImageUri == null || this.mCropImageUri.equals(Uri.EMPTY)) {
                if (CropImage.isExplicitCameraPermissionRequired(this)) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, 2011);
                } else {
                    CropImage.startPickImageActivity(this);
                }
            } else if (CropImage.isReadExternalStoragePermissionsRequired(this, this.mCropImageUri)) {
                requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, CropImage.PICK_IMAGE_PERMISSIONS_REQUEST_CODE);
            } else {
                this.mCropImageView.setImageUriAsync(this.mCropImageUri);
            }
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            if (this.mOptions == null || this.mOptions.activityTitle == null || this.mOptions.activityTitle.length() <= 0) {
                charSequence = getResources().getString(C2900R.string.crop_image_activity_title);
            } else {
                charSequence = this.mOptions.activityTitle;
            }
            supportActionBar.setTitle(charSequence);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mCropImageView.setOnSetImageUriCompleteListener(this);
        this.mCropImageView.setOnCropImageCompleteListener(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mCropImageView.setOnSetImageUriCompleteListener((CropImageView.OnSetImageUriCompleteListener) null);
        this.mCropImageView.setOnCropImageCompleteListener((CropImageView.OnCropImageCompleteListener) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onCreateOptionsMenu(android.view.Menu r7) {
        /*
            r6 = this;
            android.view.MenuInflater r0 = r6.getMenuInflater()
            int r1 = com.theartofdev.edmodo.cropper.C2900R.C2904menu.crop_image_menu
            r0.inflate(r1, r7)
            com.theartofdev.edmodo.cropper.CropImageOptions r0 = r6.mOptions
            boolean r0 = r0.allowRotation
            r1 = 1
            if (r0 != 0) goto L_0x001b
            int r0 = com.theartofdev.edmodo.cropper.C2900R.C2903id.crop_image_menu_rotate_left
            r7.removeItem(r0)
            int r0 = com.theartofdev.edmodo.cropper.C2900R.C2903id.crop_image_menu_rotate_right
            r7.removeItem(r0)
            goto L_0x002a
        L_0x001b:
            com.theartofdev.edmodo.cropper.CropImageOptions r0 = r6.mOptions
            boolean r0 = r0.allowCounterRotation
            if (r0 == 0) goto L_0x002a
            int r0 = com.theartofdev.edmodo.cropper.C2900R.C2903id.crop_image_menu_rotate_left
            android.view.MenuItem r0 = r7.findItem(r0)
            r0.setVisible(r1)
        L_0x002a:
            com.theartofdev.edmodo.cropper.CropImageOptions r0 = r6.mOptions
            boolean r0 = r0.allowFlipping
            if (r0 != 0) goto L_0x0035
            int r0 = com.theartofdev.edmodo.cropper.C2900R.C2903id.crop_image_menu_flip
            r7.removeItem(r0)
        L_0x0035:
            com.theartofdev.edmodo.cropper.CropImageOptions r0 = r6.mOptions
            java.lang.CharSequence r0 = r0.cropMenuCropButtonTitle
            if (r0 == 0) goto L_0x0048
            int r0 = com.theartofdev.edmodo.cropper.C2900R.C2903id.crop_image_menu_crop
            android.view.MenuItem r0 = r7.findItem(r0)
            com.theartofdev.edmodo.cropper.CropImageOptions r2 = r6.mOptions
            java.lang.CharSequence r2 = r2.cropMenuCropButtonTitle
            r0.setTitle(r2)
        L_0x0048:
            r0 = 0
            com.theartofdev.edmodo.cropper.CropImageOptions r2 = r6.mOptions     // Catch:{ Exception -> 0x0067 }
            int r2 = r2.cropMenuCropButtonIcon     // Catch:{ Exception -> 0x0067 }
            if (r2 == 0) goto L_0x006f
            com.theartofdev.edmodo.cropper.CropImageOptions r2 = r6.mOptions     // Catch:{ Exception -> 0x0067 }
            int r2 = r2.cropMenuCropButtonIcon     // Catch:{ Exception -> 0x0067 }
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r6, r2)     // Catch:{ Exception -> 0x0067 }
            int r0 = com.theartofdev.edmodo.cropper.C2900R.C2903id.crop_image_menu_crop     // Catch:{ Exception -> 0x0062 }
            android.view.MenuItem r0 = r7.findItem(r0)     // Catch:{ Exception -> 0x0062 }
            r0.setIcon(r2)     // Catch:{ Exception -> 0x0062 }
            r0 = r2
            goto L_0x006f
        L_0x0062:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x0068
        L_0x0067:
            r2 = move-exception
        L_0x0068:
            java.lang.String r3 = "AIC"
            java.lang.String r4 = "Failed to read menu crop drawable"
            android.util.Log.w(r3, r4, r2)
        L_0x006f:
            com.theartofdev.edmodo.cropper.CropImageOptions r2 = r6.mOptions
            int r2 = r2.activityMenuIconColor
            if (r2 == 0) goto L_0x009b
            int r2 = com.theartofdev.edmodo.cropper.C2900R.C2903id.crop_image_menu_rotate_left
            com.theartofdev.edmodo.cropper.CropImageOptions r3 = r6.mOptions
            int r3 = r3.activityMenuIconColor
            r6.updateMenuItemIconColor(r7, r2, r3)
            int r2 = com.theartofdev.edmodo.cropper.C2900R.C2903id.crop_image_menu_rotate_right
            com.theartofdev.edmodo.cropper.CropImageOptions r3 = r6.mOptions
            int r3 = r3.activityMenuIconColor
            r6.updateMenuItemIconColor(r7, r2, r3)
            int r2 = com.theartofdev.edmodo.cropper.C2900R.C2903id.crop_image_menu_flip
            com.theartofdev.edmodo.cropper.CropImageOptions r3 = r6.mOptions
            int r3 = r3.activityMenuIconColor
            r6.updateMenuItemIconColor(r7, r2, r3)
            if (r0 == 0) goto L_0x009b
            int r0 = com.theartofdev.edmodo.cropper.C2900R.C2903id.crop_image_menu_crop
            com.theartofdev.edmodo.cropper.CropImageOptions r2 = r6.mOptions
            int r2 = r2.activityMenuIconColor
            r6.updateMenuItemIconColor(r7, r0, r2)
        L_0x009b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.CropImageActivity.onCreateOptionsMenu(android.view.Menu):boolean");
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == C2900R.C2903id.crop_image_menu_crop) {
            cropImage();
            return true;
        } else if (menuItem.getItemId() == C2900R.C2903id.crop_image_menu_rotate_left) {
            rotateImage(-this.mOptions.rotationDegrees);
            return true;
        } else if (menuItem.getItemId() == C2900R.C2903id.crop_image_menu_rotate_right) {
            rotateImage(this.mOptions.rotationDegrees);
            return true;
        } else if (menuItem.getItemId() == C2900R.C2903id.crop_image_menu_flip_horizontally) {
            this.mCropImageView.flipImageHorizontally();
            return true;
        } else if (menuItem.getItemId() == C2900R.C2903id.crop_image_menu_flip_vertically) {
            this.mCropImageView.flipImageVertically();
            return true;
        } else if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            setResultCancel();
            return true;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        setResultCancel();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 200) {
            if (i2 == 0) {
                setResultCancel();
            }
            if (i2 == -1) {
                this.mCropImageUri = CropImage.getPickImageResultUri(this, intent);
                if (CropImage.isReadExternalStoragePermissionsRequired(this, this.mCropImageUri)) {
                    requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, CropImage.PICK_IMAGE_PERMISSIONS_REQUEST_CODE);
                } else {
                    this.mCropImageView.setImageUriAsync(this.mCropImageUri);
                }
            }
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 201) {
            if (this.mCropImageUri == null || iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, C2900R.string.crop_image_activity_no_permissions, 1).show();
                setResultCancel();
            } else {
                this.mCropImageView.setImageUriAsync(this.mCropImageUri);
            }
        }
        if (i == 2011) {
            CropImage.startPickImageActivity(this);
        }
    }

    public void onSetImageUriComplete(CropImageView cropImageView, Uri uri, Exception exc) {
        if (exc == null) {
            if (this.mOptions.initialCropWindowRectangle != null) {
                this.mCropImageView.setCropRect(this.mOptions.initialCropWindowRectangle);
            }
            if (this.mOptions.initialRotation > -1) {
                this.mCropImageView.setRotatedDegrees(this.mOptions.initialRotation);
                return;
            }
            return;
        }
        setResult((Uri) null, exc, 1);
    }

    public void onCropImageComplete(CropImageView cropImageView, CropImageView.CropResult cropResult) {
        setResult(cropResult.getUri(), cropResult.getError(), cropResult.getSampleSize());
    }

    /* access modifiers changed from: protected */
    public void cropImage() {
        if (this.mOptions.noOutputImage) {
            setResult((Uri) null, (Exception) null, 1);
            return;
        }
        this.mCropImageView.saveCroppedImageAsync(getOutputUri(), this.mOptions.outputCompressFormat, this.mOptions.outputCompressQuality, this.mOptions.outputRequestWidth, this.mOptions.outputRequestHeight, this.mOptions.outputRequestSizeOptions);
    }

    /* access modifiers changed from: protected */
    public void rotateImage(int i) {
        this.mCropImageView.rotateImage(i);
    }

    /* access modifiers changed from: protected */
    public Uri getOutputUri() {
        Uri uri = this.mOptions.outputUri;
        if (uri != null && !uri.equals(Uri.EMPTY)) {
            return uri;
        }
        try {
            return Uri.fromFile(File.createTempFile("cropped", this.mOptions.outputCompressFormat == Bitmap.CompressFormat.JPEG ? ".jpg" : this.mOptions.outputCompressFormat == Bitmap.CompressFormat.PNG ? ".png" : ".webp", getCacheDir()));
        } catch (IOException e) {
            throw new RuntimeException("Failed to create temp file for output image", e);
        }
    }

    /* access modifiers changed from: protected */
    public void setResult(Uri uri, Exception exc, int i) {
        setResult(exc == null ? -1 : CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE, getResultIntent(uri, exc, i));
        finish();
    }

    /* access modifiers changed from: protected */
    public void setResultCancel() {
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public Intent getResultIntent(Uri uri, Exception exc, int i) {
        CropImage.ActivityResult activityResult = new CropImage.ActivityResult(this.mCropImageView.getImageUri(), uri, exc, this.mCropImageView.getCropPoints(), this.mCropImageView.getCropRect(), this.mCropImageView.getRotatedDegrees(), this.mCropImageView.getWholeImageRect(), i);
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        intent.putExtra(CropImage.CROP_IMAGE_EXTRA_RESULT, activityResult);
        return intent;
    }

    private void updateMenuItemIconColor(Menu menu, int i, int i2) {
        Drawable icon;
        MenuItem findItem = menu.findItem(i);
        if (findItem != null && (icon = findItem.getIcon()) != null) {
            try {
                icon.mutate();
                icon.setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
                findItem.setIcon(icon);
            } catch (Exception e) {
                Log.w("AIC", "Failed to update menu item color", e);
            }
        }
    }
}
