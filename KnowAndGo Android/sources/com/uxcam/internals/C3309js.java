package com.uxcam.internals;

import androidx.core.view.InputDeviceCompat;
import com.facebook.common.statfs.StatFsHelper;
import com.theartofdev.edmodo.cropper.CropImage;

/* renamed from: com.uxcam.internals.js */
public enum C3309js {
    f2772a(-1),
    Unused(0),
    UseCoordinates(100),
    Left(1),
    Right(2),
    Center(3),
    LFEScreen(4),
    LeftSurround(5),
    RightSurround(6),
    LeftCenter(7),
    RightCenter(8),
    CenterSurround(9),
    LeftSurroundDirect(10),
    RightSurroundDirect(11),
    TopCenterSurround(12),
    VerticalHeightLeft(13),
    VerticalHeightCenter(14),
    VerticalHeightRight(15),
    TopBackLeft(16),
    TopBackCenter(17),
    TopBackRight(18),
    RearSurroundLeft(33),
    RearSurroundRight(34),
    LeftWide(35),
    RightWide(36),
    LFE2(37),
    LeftTotal(38),
    RightTotal(39),
    HearingImpaired(40),
    Narration(41),
    Mono(42),
    DialogCentricMix(43),
    CenterSurroundDirect(44),
    Ambisonic_W(200),
    Ambisonic_X(CropImage.PICK_IMAGE_PERMISSIONS_REQUEST_CODE),
    Ambisonic_Y(202),
    Ambisonic_Z(CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE),
    MS_Mid(CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE),
    MS_Side(205),
    XY_X(206),
    XY_Y(207),
    HeadphonesLeft(301),
    HeadphonesRight(302),
    ClickTrack(304),
    ForeignLanguage(305),
    Discrete(StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB),
    Discrete_0(65536),
    Discrete_1(65537),
    Discrete_2(65538),
    Discrete_3(65539),
    Discrete_4(InputDeviceCompat.SOURCE_TRACKBALL),
    Discrete_5(65541),
    Discrete_6(65542),
    Discrete_7(65543),
    Discrete_8(65544),
    Discrete_9(65545),
    Discrete_10(65546),
    Discrete_11(65547),
    Discrete_12(65548),
    Discrete_13(65549),
    Discrete_14(65550),
    Discrete_15(65551),
    Discrete_65535(131071);
    

    /* renamed from: al */
    final int f2810al;

    /* renamed from: am */
    final long f2811am;

    private C3309js(int i) {
        this.f2810al = i;
        this.f2811am = (this.f2810al > 18 || this.f2810al <= 0) ? 0 : (long) (1 << (this.f2810al - 1));
    }
}
