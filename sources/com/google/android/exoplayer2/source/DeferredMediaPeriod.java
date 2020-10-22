package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C1470C;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import java.io.IOException;

public final class DeferredMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private final Allocator allocator;
    private MediaPeriod.Callback callback;

    /* renamed from: id */
    public final MediaSource.MediaPeriodId f152id;
    @Nullable
    private PrepareErrorListener listener;
    private MediaPeriod mediaPeriod;
    public final MediaSource mediaSource;
    private boolean notifiedPrepareError;
    private long preparePositionOverrideUs = C1470C.TIME_UNSET;
    private long preparePositionUs;

    public interface PrepareErrorListener {
        void onPrepareError(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException);
    }

    public DeferredMediaPeriod(MediaSource mediaSource2, MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator2) {
        this.f152id = mediaPeriodId;
        this.allocator = allocator2;
        this.mediaSource = mediaSource2;
    }

    public void setPrepareErrorListener(PrepareErrorListener prepareErrorListener) {
        this.listener = prepareErrorListener;
    }

    public long getPreparePositionUs() {
        return this.preparePositionUs;
    }

    public void overridePreparePositionUs(long j) {
        this.preparePositionOverrideUs = j;
    }

    public void createPeriod(MediaSource.MediaPeriodId mediaPeriodId) {
        this.mediaPeriod = this.mediaSource.createPeriod(mediaPeriodId, this.allocator);
        if (this.callback != null) {
            this.mediaPeriod.prepare(this, this.preparePositionOverrideUs != C1470C.TIME_UNSET ? this.preparePositionOverrideUs : this.preparePositionUs);
        }
    }

    public void releasePeriod() {
        if (this.mediaPeriod != null) {
            this.mediaSource.releasePeriod(this.mediaPeriod);
        }
    }

    public void prepare(MediaPeriod.Callback callback2, long j) {
        this.callback = callback2;
        this.preparePositionUs = j;
        if (this.mediaPeriod != null) {
            this.mediaPeriod.prepare(this, j);
        }
    }

    public void maybeThrowPrepareError() throws IOException {
        try {
            if (this.mediaPeriod != null) {
                this.mediaPeriod.maybeThrowPrepareError();
            } else {
                this.mediaSource.maybeThrowSourceInfoRefreshError();
            }
        } catch (IOException e) {
            if (this.listener == null) {
                throw e;
            } else if (!this.notifiedPrepareError) {
                this.notifiedPrepareError = true;
                this.listener.onPrepareError(this.f152id, e);
            }
        }
    }

    public TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        if (this.preparePositionOverrideUs == C1470C.TIME_UNSET || j != this.preparePositionUs) {
            j2 = j;
        } else {
            long j3 = this.preparePositionOverrideUs;
            this.preparePositionOverrideUs = C1470C.TIME_UNSET;
            j2 = j3;
        }
        return this.mediaPeriod.selectTracks(trackSelectionArr, zArr, sampleStreamArr, zArr2, j2);
    }

    public void discardBuffer(long j, boolean z) {
        this.mediaPeriod.discardBuffer(j, z);
    }

    public long readDiscontinuity() {
        return this.mediaPeriod.readDiscontinuity();
    }

    public long getBufferedPositionUs() {
        return this.mediaPeriod.getBufferedPositionUs();
    }

    public long seekToUs(long j) {
        return this.mediaPeriod.seekToUs(j);
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        return this.mediaPeriod.getAdjustedSeekPositionUs(j, seekParameters);
    }

    public long getNextLoadPositionUs() {
        return this.mediaPeriod.getNextLoadPositionUs();
    }

    public void reevaluateBuffer(long j) {
        this.mediaPeriod.reevaluateBuffer(j);
    }

    public boolean continueLoading(long j) {
        return this.mediaPeriod != null && this.mediaPeriod.continueLoading(j);
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod2) {
        this.callback.onContinueLoadingRequested(this);
    }

    public void onPrepared(MediaPeriod mediaPeriod2) {
        this.callback.onPrepared(this);
    }
}
