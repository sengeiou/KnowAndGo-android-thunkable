package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C1470C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefaultDashChunkSource implements DashChunkSource {
    private final int[] adaptationSetIndices;
    private final DataSource dataSource;
    private final long elapsedRealtimeOffsetMs;
    private IOException fatalError;
    private long liveEdgeTimeUs = C1470C.TIME_UNSET;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final int maxSegmentsPerLoad;
    private boolean missingLastSegment;
    private int periodIndex;
    @Nullable
    private final PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler;
    protected final RepresentationHolder[] representationHolders;
    private final TrackSelection trackSelection;
    private final int trackType;

    public static final class Factory implements DashChunkSource.Factory {
        private final DataSource.Factory dataSourceFactory;
        private final int maxSegmentsPerLoad;

        public Factory(DataSource.Factory factory) {
            this(factory, 1);
        }

        public Factory(DataSource.Factory factory, int i) {
            this.dataSourceFactory = factory;
            this.maxSegmentsPerLoad = i;
        }

        public DashChunkSource createDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i, int[] iArr, TrackSelection trackSelection, int i2, long j, boolean z, boolean z2, @Nullable PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, @Nullable TransferListener transferListener) {
            TransferListener transferListener2 = transferListener;
            DataSource createDataSource = this.dataSourceFactory.createDataSource();
            if (transferListener2 != null) {
                createDataSource.addTransferListener(transferListener2);
            }
            return new DefaultDashChunkSource(loaderErrorThrower, dashManifest, i, iArr, trackSelection, i2, createDataSource, j, this.maxSegmentsPerLoad, z, z2, playerTrackEmsgHandler);
        }
    }

    public DefaultDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i, int[] iArr, TrackSelection trackSelection2, int i2, DataSource dataSource2, long j, int i3, boolean z, boolean z2, @Nullable PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2) {
        TrackSelection trackSelection3 = trackSelection2;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = dashManifest;
        this.adaptationSetIndices = iArr;
        this.trackSelection = trackSelection3;
        this.trackType = i2;
        this.dataSource = dataSource2;
        this.periodIndex = i;
        this.elapsedRealtimeOffsetMs = j;
        this.maxSegmentsPerLoad = i3;
        this.playerTrackEmsgHandler = playerTrackEmsgHandler2;
        long periodDurationUs = dashManifest.getPeriodDurationUs(i);
        ArrayList<Representation> representations = getRepresentations();
        this.representationHolders = new RepresentationHolder[trackSelection2.length()];
        for (int i4 = 0; i4 < this.representationHolders.length; i4++) {
            this.representationHolders[i4] = new RepresentationHolder(periodDurationUs, i2, representations.get(trackSelection3.getIndexInTrackGroup(i4)), z, z2, playerTrackEmsgHandler2);
        }
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        for (RepresentationHolder representationHolder : this.representationHolders) {
            if (representationHolder.segmentIndex != null) {
                long segmentNum = representationHolder.getSegmentNum(j);
                long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(segmentNum);
                return Util.resolveSeekPositionUs(j, seekParameters, segmentStartTimeUs, (segmentStartTimeUs >= j || segmentNum >= ((long) (representationHolder.getSegmentCount() + -1))) ? segmentStartTimeUs : representationHolder.getSegmentStartTimeUs(segmentNum + 1));
            }
        }
        return j;
    }

    public void updateManifest(DashManifest dashManifest, int i) {
        try {
            this.manifest = dashManifest;
            this.periodIndex = i;
            long periodDurationUs = this.manifest.getPeriodDurationUs(this.periodIndex);
            ArrayList<Representation> representations = getRepresentations();
            for (int i2 = 0; i2 < this.representationHolders.length; i2++) {
                this.representationHolders[i2] = this.representationHolders[i2].copyWithNewRepresentation(periodDurationUs, representations.get(this.trackSelection.getIndexInTrackGroup(i2)));
            }
        } catch (BehindLiveWindowException e) {
            this.fatalError = e;
        }
    }

    public void maybeThrowError() throws IOException {
        if (this.fatalError == null) {
            this.manifestLoaderErrorThrower.maybeThrowError();
            return;
        }
        throw this.fatalError;
    }

    public int getPreferredQueueSize(long j, List<? extends MediaChunk> list) {
        if (this.fatalError != null || this.trackSelection.length() < 2) {
            return list.size();
        }
        return this.trackSelection.evaluateQueueSize(j, list);
    }

    public void getNextChunk(long j, long j2, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        MediaChunk mediaChunk;
        long j3;
        MediaChunkIterator[] mediaChunkIteratorArr;
        int i;
        ChunkHolder chunkHolder2 = chunkHolder;
        if (this.fatalError == null) {
            long j4 = j2 - j;
            long resolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(j);
            long msToUs = C1470C.msToUs(this.manifest.availabilityStartTimeMs) + C1470C.msToUs(this.manifest.getPeriod(this.periodIndex).startMs) + j2;
            if (this.playerTrackEmsgHandler == null || !this.playerTrackEmsgHandler.maybeRefreshManifestBeforeLoadingNextChunk(msToUs)) {
                long nowUnixTimeUs = getNowUnixTimeUs();
                RangedUri rangedUri = null;
                if (list.isEmpty()) {
                    List<? extends MediaChunk> list2 = list;
                    mediaChunk = null;
                } else {
                    mediaChunk = (MediaChunk) list.get(list.size() - 1);
                }
                MediaChunkIterator[] mediaChunkIteratorArr2 = new MediaChunkIterator[this.trackSelection.length()];
                int i2 = 0;
                while (i2 < mediaChunkIteratorArr2.length) {
                    RepresentationHolder representationHolder = this.representationHolders[i2];
                    if (representationHolder.segmentIndex == null) {
                        mediaChunkIteratorArr2[i2] = MediaChunkIterator.EMPTY;
                        i = i2;
                        mediaChunkIteratorArr = mediaChunkIteratorArr2;
                        j3 = nowUnixTimeUs;
                    } else {
                        long firstAvailableSegmentNum = representationHolder.getFirstAvailableSegmentNum(this.manifest, this.periodIndex, nowUnixTimeUs);
                        long lastAvailableSegmentNum = representationHolder.getLastAvailableSegmentNum(this.manifest, this.periodIndex, nowUnixTimeUs);
                        i = i2;
                        RepresentationHolder representationHolder2 = representationHolder;
                        mediaChunkIteratorArr = mediaChunkIteratorArr2;
                        j3 = nowUnixTimeUs;
                        long segmentNum = getSegmentNum(representationHolder, mediaChunk, j2, firstAvailableSegmentNum, lastAvailableSegmentNum);
                        if (segmentNum < firstAvailableSegmentNum) {
                            mediaChunkIteratorArr[i] = MediaChunkIterator.EMPTY;
                        } else {
                            mediaChunkIteratorArr[i] = new RepresentationSegmentIterator(representationHolder2, segmentNum, lastAvailableSegmentNum);
                        }
                    }
                    i2 = i + 1;
                    List<? extends MediaChunk> list3 = list;
                    mediaChunkIteratorArr2 = mediaChunkIteratorArr;
                    nowUnixTimeUs = j3;
                }
                long j5 = nowUnixTimeUs;
                this.trackSelection.updateSelectedTrack(j, j4, resolveTimeToLiveEdgeUs, list, mediaChunkIteratorArr2);
                RepresentationHolder representationHolder3 = this.representationHolders[this.trackSelection.getSelectedIndex()];
                if (representationHolder3.extractorWrapper != null) {
                    Representation representation = representationHolder3.representation;
                    RangedUri initializationUri = representationHolder3.extractorWrapper.getSampleFormats() == null ? representation.getInitializationUri() : null;
                    if (representationHolder3.segmentIndex == null) {
                        rangedUri = representation.getIndexUri();
                    }
                    if (!(initializationUri == null && rangedUri == null)) {
                        chunkHolder2.chunk = newInitializationChunk(representationHolder3, this.dataSource, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), initializationUri, rangedUri);
                        return;
                    }
                }
                long access$000 = representationHolder3.periodDurationUs;
                int i3 = (access$000 > C1470C.TIME_UNSET ? 1 : (access$000 == C1470C.TIME_UNSET ? 0 : -1));
                boolean z = i3 != 0;
                if (representationHolder3.getSegmentCount() == 0) {
                    chunkHolder2.endOfStream = z;
                    return;
                }
                long j6 = j5;
                long firstAvailableSegmentNum2 = representationHolder3.getFirstAvailableSegmentNum(this.manifest, this.periodIndex, j6);
                long lastAvailableSegmentNum2 = representationHolder3.getLastAvailableSegmentNum(this.manifest, this.periodIndex, j6);
                updateLiveEdgeTimeUs(representationHolder3, lastAvailableSegmentNum2);
                long j7 = lastAvailableSegmentNum2;
                boolean z2 = z;
                long segmentNum2 = getSegmentNum(representationHolder3, mediaChunk, j2, firstAvailableSegmentNum2, j7);
                if (segmentNum2 < firstAvailableSegmentNum2) {
                    this.fatalError = new BehindLiveWindowException();
                    return;
                }
                int i4 = (segmentNum2 > j7 ? 1 : (segmentNum2 == j7 ? 0 : -1));
                if (i4 > 0 || (this.missingLastSegment && i4 >= 0)) {
                    chunkHolder2.endOfStream = z2;
                } else if (!z2 || representationHolder3.getSegmentStartTimeUs(segmentNum2) < access$000) {
                    int min = (int) Math.min((long) this.maxSegmentsPerLoad, (j7 - segmentNum2) + 1);
                    if (i3 != 0) {
                        while (min > 1 && representationHolder3.getSegmentStartTimeUs((((long) min) + segmentNum2) - 1) >= access$000) {
                            min--;
                        }
                    }
                    chunkHolder2.chunk = newMediaChunk(representationHolder3, this.dataSource, this.trackType, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), segmentNum2, min, list.isEmpty() ? j2 : -9223372036854775807L);
                } else {
                    chunkHolder2.endOfStream = true;
                }
            }
        }
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        SeekMap seekMap;
        if (chunk instanceof InitializationChunk) {
            int indexOf = this.trackSelection.indexOf(((InitializationChunk) chunk).trackFormat);
            RepresentationHolder representationHolder = this.representationHolders[indexOf];
            if (representationHolder.segmentIndex == null && (seekMap = representationHolder.extractorWrapper.getSeekMap()) != null) {
                this.representationHolders[indexOf] = representationHolder.copyWithNewSegmentIndex(new DashWrappingSegmentIndex((ChunkIndex) seekMap, representationHolder.representation.presentationTimeOffsetUs));
            }
        }
        if (this.playerTrackEmsgHandler != null) {
            this.playerTrackEmsgHandler.onChunkLoadCompleted(chunk);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        r6 = r4.representationHolders[r4.trackSelection.indexOf(r5.trackFormat)];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onChunkLoadError(com.google.android.exoplayer2.source.chunk.Chunk r5, boolean r6, java.lang.Exception r7, long r8) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.google.android.exoplayer2.source.dash.PlayerEmsgHandler$PlayerTrackEmsgHandler r6 = r4.playerTrackEmsgHandler
            r1 = 1
            if (r6 == 0) goto L_0x0012
            com.google.android.exoplayer2.source.dash.PlayerEmsgHandler$PlayerTrackEmsgHandler r6 = r4.playerTrackEmsgHandler
            boolean r6 = r6.maybeRefreshManifestOnLoadingError(r5)
            if (r6 == 0) goto L_0x0012
            return r1
        L_0x0012:
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r6 = r4.manifest
            boolean r6 = r6.dynamic
            if (r6 != 0) goto L_0x0054
            boolean r6 = r5 instanceof com.google.android.exoplayer2.source.chunk.MediaChunk
            if (r6 == 0) goto L_0x0054
            boolean r6 = r7 instanceof com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException
            if (r6 == 0) goto L_0x0054
            com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException r7 = (com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException) r7
            int r6 = r7.responseCode
            r7 = 404(0x194, float:5.66E-43)
            if (r6 != r7) goto L_0x0054
            com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$RepresentationHolder[] r6 = r4.representationHolders
            com.google.android.exoplayer2.trackselection.TrackSelection r7 = r4.trackSelection
            com.google.android.exoplayer2.Format r2 = r5.trackFormat
            int r7 = r7.indexOf((com.google.android.exoplayer2.Format) r2)
            r6 = r6[r7]
            int r7 = r6.getSegmentCount()
            r2 = -1
            if (r7 == r2) goto L_0x0054
            if (r7 == 0) goto L_0x0054
            long r2 = r6.getFirstSegmentNum()
            long r6 = (long) r7
            long r2 = r2 + r6
            r6 = 1
            long r2 = r2 - r6
            r6 = r5
            com.google.android.exoplayer2.source.chunk.MediaChunk r6 = (com.google.android.exoplayer2.source.chunk.MediaChunk) r6
            long r6 = r6.getNextChunkIndex()
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x0054
            r4.missingLastSegment = r1
            return r1
        L_0x0054:
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x006e
            com.google.android.exoplayer2.trackselection.TrackSelection r6 = r4.trackSelection
            com.google.android.exoplayer2.trackselection.TrackSelection r7 = r4.trackSelection
            com.google.android.exoplayer2.Format r5 = r5.trackFormat
            int r5 = r7.indexOf((com.google.android.exoplayer2.Format) r5)
            boolean r5 = r6.blacklist(r5, r8)
            if (r5 == 0) goto L_0x006e
            r0 = 1
        L_0x006e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.onChunkLoadError(com.google.android.exoplayer2.source.chunk.Chunk, boolean, java.lang.Exception, long):boolean");
    }

    private long getSegmentNum(RepresentationHolder representationHolder, @Nullable MediaChunk mediaChunk, long j, long j2, long j3) {
        if (mediaChunk != null) {
            return mediaChunk.getNextChunkIndex();
        }
        return Util.constrainValue(representationHolder.getSegmentNum(j), j2, j3);
    }

    private ArrayList<Representation> getRepresentations() {
        List<AdaptationSet> list = this.manifest.getPeriod(this.periodIndex).adaptationSets;
        ArrayList<Representation> arrayList = new ArrayList<>();
        for (int i : this.adaptationSetIndices) {
            arrayList.addAll(list.get(i).representations);
        }
        return arrayList;
    }

    private void updateLiveEdgeTimeUs(RepresentationHolder representationHolder, long j) {
        this.liveEdgeTimeUs = this.manifest.dynamic ? representationHolder.getSegmentEndTimeUs(j) : C1470C.TIME_UNSET;
    }

    private long getNowUnixTimeUs() {
        if (this.elapsedRealtimeOffsetMs != 0) {
            return (SystemClock.elapsedRealtime() + this.elapsedRealtimeOffsetMs) * 1000;
        }
        return System.currentTimeMillis() * 1000;
    }

    private long resolveTimeToLiveEdgeUs(long j) {
        if (this.manifest.dynamic && this.liveEdgeTimeUs != C1470C.TIME_UNSET) {
            return this.liveEdgeTimeUs - j;
        }
        return C1470C.TIME_UNSET;
    }

    /* access modifiers changed from: protected */
    public Chunk newInitializationChunk(RepresentationHolder representationHolder, DataSource dataSource2, Format format, int i, Object obj, RangedUri rangedUri, RangedUri rangedUri2) {
        String str = representationHolder.representation.baseUrl;
        if (rangedUri != null && (rangedUri2 = rangedUri.attemptMerge(rangedUri2, str)) == null) {
            rangedUri2 = rangedUri;
        }
        return new InitializationChunk(dataSource2, new DataSpec(rangedUri2.resolveUri(str), rangedUri2.start, rangedUri2.length, representationHolder.representation.getCacheKey()), format, i, obj, representationHolder.extractorWrapper);
    }

    /* access modifiers changed from: protected */
    public Chunk newMediaChunk(RepresentationHolder representationHolder, DataSource dataSource2, int i, Format format, int i2, Object obj, long j, int i3, long j2) {
        RepresentationHolder representationHolder2 = representationHolder;
        long j3 = j;
        Representation representation = representationHolder2.representation;
        long segmentStartTimeUs = representationHolder2.getSegmentStartTimeUs(j3);
        RangedUri segmentUrl = representationHolder2.getSegmentUrl(j3);
        String str = representation.baseUrl;
        if (representationHolder2.extractorWrapper == null) {
            return new SingleSampleMediaChunk(dataSource2, new DataSpec(segmentUrl.resolveUri(str), segmentUrl.start, segmentUrl.length, representation.getCacheKey()), format, i2, obj, segmentStartTimeUs, representationHolder2.getSegmentEndTimeUs(j3), j, i, format);
        }
        int i4 = 1;
        RangedUri rangedUri = segmentUrl;
        int i5 = 1;
        int i6 = i3;
        while (i4 < i6) {
            RangedUri attemptMerge = rangedUri.attemptMerge(representationHolder2.getSegmentUrl(((long) i4) + j3), str);
            if (attemptMerge == null) {
                break;
            }
            i5++;
            i4++;
            rangedUri = attemptMerge;
        }
        long segmentEndTimeUs = representationHolder2.getSegmentEndTimeUs((((long) i5) + j3) - 1);
        long access$000 = representationHolder.periodDurationUs;
        long j4 = (access$000 == C1470C.TIME_UNSET || access$000 > segmentEndTimeUs) ? -9223372036854775807L : access$000;
        DataSpec dataSpec = r18;
        DataSpec dataSpec2 = new DataSpec(rangedUri.resolveUri(str), rangedUri.start, rangedUri.length, representation.getCacheKey());
        ChunkExtractorWrapper chunkExtractorWrapper = representationHolder2.extractorWrapper;
        return new ContainerMediaChunk(dataSource2, dataSpec, format, i2, obj, segmentStartTimeUs, segmentEndTimeUs, j2, j4, j, i5, -representation.presentationTimeOffsetUs, chunkExtractorWrapper);
    }

    protected static final class RepresentationSegmentIterator extends BaseMediaChunkIterator {
        private final RepresentationHolder representationHolder;

        public RepresentationSegmentIterator(RepresentationHolder representationHolder2, long j, long j2) {
            super(j, j2);
            this.representationHolder = representationHolder2;
        }

        public DataSpec getDataSpec() {
            checkInBounds();
            Representation representation = this.representationHolder.representation;
            RangedUri segmentUrl = this.representationHolder.getSegmentUrl(getCurrentIndex());
            return new DataSpec(segmentUrl.resolveUri(representation.baseUrl), segmentUrl.start, segmentUrl.length, representation.getCacheKey());
        }

        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.representationHolder.getSegmentStartTimeUs(getCurrentIndex());
        }

        public long getChunkEndTimeUs() {
            checkInBounds();
            return this.representationHolder.getSegmentEndTimeUs(getCurrentIndex());
        }
    }

    protected static final class RepresentationHolder {
        @Nullable
        final ChunkExtractorWrapper extractorWrapper;
        /* access modifiers changed from: private */
        public final long periodDurationUs;
        public final Representation representation;
        @Nullable
        public final DashSegmentIndex segmentIndex;
        private final long segmentNumShift;

        RepresentationHolder(long j, int i, Representation representation2, boolean z, boolean z2, TrackOutput trackOutput) {
            this(j, representation2, createExtractorWrapper(i, representation2, z, z2, trackOutput), 0, representation2.getIndex());
        }

        private RepresentationHolder(long j, Representation representation2, @Nullable ChunkExtractorWrapper chunkExtractorWrapper, long j2, @Nullable DashSegmentIndex dashSegmentIndex) {
            this.periodDurationUs = j;
            this.representation = representation2;
            this.segmentNumShift = j2;
            this.extractorWrapper = chunkExtractorWrapper;
            this.segmentIndex = dashSegmentIndex;
        }

        /* access modifiers changed from: package-private */
        @CheckResult
        public RepresentationHolder copyWithNewRepresentation(long j, Representation representation2) throws BehindLiveWindowException {
            long j2;
            long j3 = j;
            DashSegmentIndex index = this.representation.getIndex();
            DashSegmentIndex index2 = representation2.getIndex();
            if (index == null) {
                return new RepresentationHolder(j, representation2, this.extractorWrapper, this.segmentNumShift, index);
            } else if (!index.isExplicit()) {
                return new RepresentationHolder(j, representation2, this.extractorWrapper, this.segmentNumShift, index2);
            } else {
                int segmentCount = index.getSegmentCount(j3);
                if (segmentCount == 0) {
                    return new RepresentationHolder(j, representation2, this.extractorWrapper, this.segmentNumShift, index2);
                }
                long firstSegmentNum = (index.getFirstSegmentNum() + ((long) segmentCount)) - 1;
                long timeUs = index.getTimeUs(firstSegmentNum) + index.getDurationUs(firstSegmentNum, j3);
                long firstSegmentNum2 = index2.getFirstSegmentNum();
                long timeUs2 = index2.getTimeUs(firstSegmentNum2);
                long j4 = this.segmentNumShift;
                int i = (timeUs > timeUs2 ? 1 : (timeUs == timeUs2 ? 0 : -1));
                if (i == 0) {
                    j2 = j4 + ((firstSegmentNum + 1) - firstSegmentNum2);
                } else if (i >= 0) {
                    j2 = j4 + (index.getSegmentNum(timeUs2, j3) - firstSegmentNum2);
                } else {
                    throw new BehindLiveWindowException();
                }
                return new RepresentationHolder(j, representation2, this.extractorWrapper, j2, index2);
            }
        }

        /* access modifiers changed from: package-private */
        @CheckResult
        public RepresentationHolder copyWithNewSegmentIndex(DashSegmentIndex dashSegmentIndex) {
            return new RepresentationHolder(this.periodDurationUs, this.representation, this.extractorWrapper, this.segmentNumShift, dashSegmentIndex);
        }

        public long getFirstSegmentNum() {
            return this.segmentIndex.getFirstSegmentNum() + this.segmentNumShift;
        }

        public int getSegmentCount() {
            return this.segmentIndex.getSegmentCount(this.periodDurationUs);
        }

        public long getSegmentStartTimeUs(long j) {
            return this.segmentIndex.getTimeUs(j - this.segmentNumShift);
        }

        public long getSegmentEndTimeUs(long j) {
            return getSegmentStartTimeUs(j) + this.segmentIndex.getDurationUs(j - this.segmentNumShift, this.periodDurationUs);
        }

        public long getSegmentNum(long j) {
            return this.segmentIndex.getSegmentNum(j, this.periodDurationUs) + this.segmentNumShift;
        }

        public RangedUri getSegmentUrl(long j) {
            return this.segmentIndex.getSegmentUrl(j - this.segmentNumShift);
        }

        public long getFirstAvailableSegmentNum(DashManifest dashManifest, int i, long j) {
            if (getSegmentCount() != -1 || dashManifest.timeShiftBufferDepthMs == C1470C.TIME_UNSET) {
                return getFirstSegmentNum();
            }
            return Math.max(getFirstSegmentNum(), getSegmentNum(((j - C1470C.msToUs(dashManifest.availabilityStartTimeMs)) - C1470C.msToUs(dashManifest.getPeriod(i).startMs)) - C1470C.msToUs(dashManifest.timeShiftBufferDepthMs)));
        }

        public long getLastAvailableSegmentNum(DashManifest dashManifest, int i, long j) {
            int segmentCount = getSegmentCount();
            if (segmentCount == -1) {
                return getSegmentNum((j - C1470C.msToUs(dashManifest.availabilityStartTimeMs)) - C1470C.msToUs(dashManifest.getPeriod(i).startMs)) - 1;
            }
            return (getFirstSegmentNum() + ((long) segmentCount)) - 1;
        }

        private static boolean mimeTypeIsWebm(String str) {
            return str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM) || str.startsWith(MimeTypes.APPLICATION_WEBM);
        }

        private static boolean mimeTypeIsRawText(String str) {
            return MimeTypes.isText(str) || MimeTypes.APPLICATION_TTML.equals(str);
        }

        /* JADX WARNING: type inference failed for: r12v9, types: [com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor] */
        /* JADX WARNING: type inference failed for: r12v10, types: [com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor] */
        /* JADX WARNING: Multi-variable type inference failed */
        @androidx.annotation.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper createExtractorWrapper(int r10, com.google.android.exoplayer2.source.dash.manifest.Representation r11, boolean r12, boolean r13, com.google.android.exoplayer2.extractor.TrackOutput r14) {
            /*
                com.google.android.exoplayer2.Format r0 = r11.format
                java.lang.String r0 = r0.containerMimeType
                boolean r1 = mimeTypeIsRawText(r0)
                r2 = 0
                if (r1 == 0) goto L_0x000c
                return r2
            L_0x000c:
                java.lang.String r1 = "application/x-rawcc"
                boolean r1 = r1.equals(r0)
                if (r1 == 0) goto L_0x001c
                com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor r12 = new com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor
                com.google.android.exoplayer2.Format r13 = r11.format
                r12.<init>(r13)
                goto L_0x004d
            L_0x001c:
                boolean r0 = mimeTypeIsWebm(r0)
                if (r0 == 0) goto L_0x0029
                com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor r12 = new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor
                r13 = 1
                r12.<init>(r13)
                goto L_0x004d
            L_0x0029:
                r0 = 0
                if (r12 == 0) goto L_0x002f
                r12 = 4
                r4 = 4
                goto L_0x0030
            L_0x002f:
                r4 = 0
            L_0x0030:
                if (r13 == 0) goto L_0x003e
                java.lang.String r12 = "application/cea-608"
                com.google.android.exoplayer2.Format r12 = com.google.android.exoplayer2.Format.createTextSampleFormat(r2, r12, r0, r2)
                java.util.List r12 = java.util.Collections.singletonList(r12)
            L_0x003c:
                r8 = r12
                goto L_0x0043
            L_0x003e:
                java.util.List r12 = java.util.Collections.emptyList()
                goto L_0x003c
            L_0x0043:
                com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor r12 = new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor
                r5 = 0
                r6 = 0
                r7 = 0
                r3 = r12
                r9 = r14
                r3.<init>(r4, r5, r6, r7, r8, r9)
            L_0x004d:
                com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper r13 = new com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper
                com.google.android.exoplayer2.Format r11 = r11.format
                r13.<init>(r12, r10, r11)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder.createExtractorWrapper(int, com.google.android.exoplayer2.source.dash.manifest.Representation, boolean, boolean, com.google.android.exoplayer2.extractor.TrackOutput):com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper");
        }
    }
}
