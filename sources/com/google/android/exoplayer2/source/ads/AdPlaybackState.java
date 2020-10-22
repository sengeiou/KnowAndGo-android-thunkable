package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import androidx.annotation.CheckResult;
import com.google.android.exoplayer2.C1470C;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public final class AdPlaybackState {
    public static final int AD_STATE_AVAILABLE = 1;
    public static final int AD_STATE_ERROR = 4;
    public static final int AD_STATE_PLAYED = 3;
    public static final int AD_STATE_SKIPPED = 2;
    public static final int AD_STATE_UNAVAILABLE = 0;
    public static final AdPlaybackState NONE = new AdPlaybackState(new long[0]);
    public final int adGroupCount;
    public final long[] adGroupTimesUs;
    public final AdGroup[] adGroups;
    public final long adResumePositionUs;
    public final long contentDurationUs;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdState {
    }

    public static final class AdGroup {
        public final int count;
        public final long[] durationsUs;
        public final int[] states;
        public final Uri[] uris;

        public AdGroup() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        private AdGroup(int i, int[] iArr, Uri[] uriArr, long[] jArr) {
            Assertions.checkArgument(iArr.length == uriArr.length);
            this.count = i;
            this.states = iArr;
            this.uris = uriArr;
            this.durationsUs = jArr;
        }

        public int getFirstAdIndexToPlay() {
            return getNextAdIndexToPlay(-1);
        }

        public int getNextAdIndexToPlay(int i) {
            int i2 = i + 1;
            while (i2 < this.states.length && this.states[i2] != 0 && this.states[i2] != 1) {
                i2++;
            }
            return i2;
        }

        public boolean hasUnplayedAds() {
            return this.count == -1 || getFirstAdIndexToPlay() < this.count;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AdGroup adGroup = (AdGroup) obj;
            if (this.count != adGroup.count || !Arrays.equals(this.uris, adGroup.uris) || !Arrays.equals(this.states, adGroup.states) || !Arrays.equals(this.durationsUs, adGroup.durationsUs)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((((this.count * 31) + Arrays.hashCode(this.uris)) * 31) + Arrays.hashCode(this.states)) * 31) + Arrays.hashCode(this.durationsUs);
        }

        @CheckResult
        public AdGroup withAdCount(int i) {
            Assertions.checkArgument(this.count == -1 && this.states.length <= i);
            return new AdGroup(i, copyStatesWithSpaceForAdCount(this.states, i), (Uri[]) Arrays.copyOf(this.uris, i), copyDurationsUsWithSpaceForAdCount(this.durationsUs, i));
        }

        @CheckResult
        public AdGroup withAdUri(Uri uri, int i) {
            long[] jArr;
            boolean z = false;
            Assertions.checkArgument(this.count == -1 || i < this.count);
            int[] copyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, i + 1);
            if (copyStatesWithSpaceForAdCount[i] == 0) {
                z = true;
            }
            Assertions.checkArgument(z);
            if (this.durationsUs.length == copyStatesWithSpaceForAdCount.length) {
                jArr = this.durationsUs;
            } else {
                jArr = copyDurationsUsWithSpaceForAdCount(this.durationsUs, copyStatesWithSpaceForAdCount.length);
            }
            Uri[] uriArr = (Uri[]) Arrays.copyOf(this.uris, copyStatesWithSpaceForAdCount.length);
            uriArr[i] = uri;
            copyStatesWithSpaceForAdCount[i] = 1;
            return new AdGroup(this.count, copyStatesWithSpaceForAdCount, uriArr, jArr);
        }

        @CheckResult
        public AdGroup withAdState(int i, int i2) {
            long[] jArr;
            Uri[] uriArr;
            boolean z = false;
            Assertions.checkArgument(this.count == -1 || i2 < this.count);
            int[] copyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, i2 + 1);
            if (copyStatesWithSpaceForAdCount[i2] == 0 || copyStatesWithSpaceForAdCount[i2] == 1 || copyStatesWithSpaceForAdCount[i2] == i) {
                z = true;
            }
            Assertions.checkArgument(z);
            if (this.durationsUs.length == copyStatesWithSpaceForAdCount.length) {
                jArr = this.durationsUs;
            } else {
                jArr = copyDurationsUsWithSpaceForAdCount(this.durationsUs, copyStatesWithSpaceForAdCount.length);
            }
            if (this.uris.length == copyStatesWithSpaceForAdCount.length) {
                uriArr = this.uris;
            } else {
                uriArr = (Uri[]) Arrays.copyOf(this.uris, copyStatesWithSpaceForAdCount.length);
            }
            copyStatesWithSpaceForAdCount[i2] = i;
            return new AdGroup(this.count, copyStatesWithSpaceForAdCount, uriArr, jArr);
        }

        @CheckResult
        public AdGroup withAdDurationsUs(long[] jArr) {
            Assertions.checkArgument(this.count == -1 || jArr.length <= this.uris.length);
            if (jArr.length < this.uris.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, this.uris.length);
            }
            return new AdGroup(this.count, this.states, this.uris, jArr);
        }

        @CheckResult
        public AdGroup withAllAdsSkipped() {
            if (this.count == -1) {
                return new AdGroup(0, new int[0], new Uri[0], new long[0]);
            }
            int length = this.states.length;
            int[] copyOf = Arrays.copyOf(this.states, length);
            for (int i = 0; i < length; i++) {
                if (copyOf[i] == 1 || copyOf[i] == 0) {
                    copyOf[i] = 2;
                }
            }
            return new AdGroup(length, copyOf, this.uris, this.durationsUs);
        }

        @CheckResult
        private static int[] copyStatesWithSpaceForAdCount(int[] iArr, int i) {
            int length = iArr.length;
            int max = Math.max(i, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        @CheckResult
        private static long[] copyDurationsUsWithSpaceForAdCount(long[] jArr, int i) {
            int length = jArr.length;
            int max = Math.max(i, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, C1470C.TIME_UNSET);
            return copyOf;
        }
    }

    public AdPlaybackState(long... jArr) {
        int length = jArr.length;
        this.adGroupCount = length;
        this.adGroupTimesUs = Arrays.copyOf(jArr, length);
        this.adGroups = new AdGroup[length];
        for (int i = 0; i < length; i++) {
            this.adGroups[i] = new AdGroup();
        }
        this.adResumePositionUs = 0;
        this.contentDurationUs = C1470C.TIME_UNSET;
    }

    private AdPlaybackState(long[] jArr, AdGroup[] adGroupArr, long j, long j2) {
        this.adGroupCount = adGroupArr.length;
        this.adGroupTimesUs = jArr;
        this.adGroups = adGroupArr;
        this.adResumePositionUs = j;
        this.contentDurationUs = j2;
    }

    public int getAdGroupIndexForPositionUs(long j) {
        int length = this.adGroupTimesUs.length - 1;
        while (length >= 0 && isPositionBeforeAdGroup(j, length)) {
            length--;
        }
        if (length < 0 || !this.adGroups[length].hasUnplayedAds()) {
            return -1;
        }
        return length;
    }

    public int getAdGroupIndexAfterPositionUs(long j) {
        int i = 0;
        while (i < this.adGroupTimesUs.length && this.adGroupTimesUs[i] != Long.MIN_VALUE && (j >= this.adGroupTimesUs[i] || !this.adGroups[i].hasUnplayedAds())) {
            i++;
        }
        if (i < this.adGroupTimesUs.length) {
            return i;
        }
        return -1;
    }

    @CheckResult
    public AdPlaybackState withAdCount(int i, int i2) {
        Assertions.checkArgument(i2 > 0);
        if (this.adGroups[i].count == i2) {
            return this;
        }
        AdGroup[] adGroupArr = (AdGroup[]) Arrays.copyOf(this.adGroups, this.adGroups.length);
        adGroupArr[i] = this.adGroups[i].withAdCount(i2);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withAdUri(int i, int i2, Uri uri) {
        AdGroup[] adGroupArr = (AdGroup[]) Arrays.copyOf(this.adGroups, this.adGroups.length);
        adGroupArr[i] = adGroupArr[i].withAdUri(uri, i2);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withPlayedAd(int i, int i2) {
        AdGroup[] adGroupArr = (AdGroup[]) Arrays.copyOf(this.adGroups, this.adGroups.length);
        adGroupArr[i] = adGroupArr[i].withAdState(3, i2);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withSkippedAd(int i, int i2) {
        AdGroup[] adGroupArr = (AdGroup[]) Arrays.copyOf(this.adGroups, this.adGroups.length);
        adGroupArr[i] = adGroupArr[i].withAdState(2, i2);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withAdLoadError(int i, int i2) {
        AdGroup[] adGroupArr = (AdGroup[]) Arrays.copyOf(this.adGroups, this.adGroups.length);
        adGroupArr[i] = adGroupArr[i].withAdState(4, i2);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withSkippedAdGroup(int i) {
        AdGroup[] adGroupArr = (AdGroup[]) Arrays.copyOf(this.adGroups, this.adGroups.length);
        adGroupArr[i] = adGroupArr[i].withAllAdsSkipped();
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withAdDurationsUs(long[][] jArr) {
        AdGroup[] adGroupArr = (AdGroup[]) Arrays.copyOf(this.adGroups, this.adGroups.length);
        for (int i = 0; i < this.adGroupCount; i++) {
            adGroupArr[i] = adGroupArr[i].withAdDurationsUs(jArr[i]);
        }
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withAdResumePositionUs(long j) {
        if (this.adResumePositionUs == j) {
            return this;
        }
        return new AdPlaybackState(this.adGroupTimesUs, this.adGroups, j, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withContentDurationUs(long j) {
        if (this.contentDurationUs == j) {
            return this;
        }
        return new AdPlaybackState(this.adGroupTimesUs, this.adGroups, this.adResumePositionUs, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdPlaybackState adPlaybackState = (AdPlaybackState) obj;
        if (this.adGroupCount == adPlaybackState.adGroupCount && this.adResumePositionUs == adPlaybackState.adResumePositionUs && this.contentDurationUs == adPlaybackState.contentDurationUs && Arrays.equals(this.adGroupTimesUs, adPlaybackState.adGroupTimesUs) && Arrays.equals(this.adGroups, adPlaybackState.adGroups)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.adGroupCount * 31) + ((int) this.adResumePositionUs)) * 31) + ((int) this.contentDurationUs)) * 31) + Arrays.hashCode(this.adGroupTimesUs)) * 31) + Arrays.hashCode(this.adGroups);
    }

    private boolean isPositionBeforeAdGroup(long j, int i) {
        long j2 = this.adGroupTimesUs[i];
        if (j2 == Long.MIN_VALUE) {
            if (this.contentDurationUs == C1470C.TIME_UNSET || j < this.contentDurationUs) {
                return true;
            }
            return false;
        } else if (j < j2) {
            return true;
        } else {
            return false;
        }
    }
}
