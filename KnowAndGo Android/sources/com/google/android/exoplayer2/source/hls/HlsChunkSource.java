package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C1470C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

class HlsChunkSource {
    private final DataSource encryptionDataSource;
    private byte[] encryptionIv;
    private String encryptionIvString;
    private byte[] encryptionKey;
    private Uri encryptionKeyUri;
    private HlsMasterPlaylist.HlsUrl expectedPlaylistUrl;
    private final HlsExtractorFactory extractorFactory;
    private IOException fatalError;
    private boolean independentSegments;
    private boolean isTimestampMaster;
    private long liveEdgeInPeriodTimeUs = C1470C.TIME_UNSET;
    private final DataSource mediaDataSource;
    private final List<Format> muxedCaptionFormats;
    private final HlsPlaylistTracker playlistTracker;
    private byte[] scratchSpace;
    private boolean seenExpectedPlaylistError;
    private final TimestampAdjusterProvider timestampAdjusterProvider;
    private final TrackGroup trackGroup;
    private TrackSelection trackSelection;
    private final HlsMasterPlaylist.HlsUrl[] variants;

    public static final class HlsChunkHolder {
        public Chunk chunk;
        public boolean endOfStream;
        public HlsMasterPlaylist.HlsUrl playlist;

        public HlsChunkHolder() {
            clear();
        }

        public void clear() {
            this.chunk = null;
            this.endOfStream = false;
            this.playlist = null;
        }
    }

    public HlsChunkSource(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsMasterPlaylist.HlsUrl[] hlsUrlArr, HlsDataSourceFactory hlsDataSourceFactory, @Nullable TransferListener transferListener, TimestampAdjusterProvider timestampAdjusterProvider2, List<Format> list) {
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.variants = hlsUrlArr;
        this.timestampAdjusterProvider = timestampAdjusterProvider2;
        this.muxedCaptionFormats = list;
        Format[] formatArr = new Format[hlsUrlArr.length];
        int[] iArr = new int[hlsUrlArr.length];
        for (int i = 0; i < hlsUrlArr.length; i++) {
            formatArr[i] = hlsUrlArr[i].format;
            iArr[i] = i;
        }
        this.mediaDataSource = hlsDataSourceFactory.createDataSource(1);
        if (transferListener != null) {
            this.mediaDataSource.addTransferListener(transferListener);
        }
        this.encryptionDataSource = hlsDataSourceFactory.createDataSource(3);
        this.trackGroup = new TrackGroup(formatArr);
        this.trackSelection = new InitializationTrackSelection(this.trackGroup, iArr);
    }

    public void maybeThrowError() throws IOException {
        if (this.fatalError != null) {
            throw this.fatalError;
        } else if (this.expectedPlaylistUrl != null && this.seenExpectedPlaylistError) {
            this.playlistTracker.maybeThrowPlaylistRefreshError(this.expectedPlaylistUrl);
        }
    }

    public TrackGroup getTrackGroup() {
        return this.trackGroup;
    }

    public void selectTracks(TrackSelection trackSelection2) {
        this.trackSelection = trackSelection2;
    }

    public TrackSelection getTrackSelection() {
        return this.trackSelection;
    }

    public void reset() {
        this.fatalError = null;
    }

    public void setIsTimestampMaster(boolean z) {
        this.isTimestampMaster = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getNextChunk(long r40, long r42, java.util.List<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r44, com.google.android.exoplayer2.source.hls.HlsChunkSource.HlsChunkHolder r45) {
        /*
            r39 = this;
            r8 = r39
            r6 = r42
            r9 = r45
            boolean r0 = r44.isEmpty()
            r11 = 1
            if (r0 == 0) goto L_0x0011
            r1 = r44
            r4 = 0
            goto L_0x001f
        L_0x0011:
            int r0 = r44.size()
            int r0 = r0 - r11
            r1 = r44
            java.lang.Object r0 = r1.get(r0)
            com.google.android.exoplayer2.source.hls.HlsMediaChunk r0 = (com.google.android.exoplayer2.source.hls.HlsMediaChunk) r0
            r4 = r0
        L_0x001f:
            if (r4 != 0) goto L_0x0024
            r0 = -1
            r5 = -1
            goto L_0x002d
        L_0x0024:
            com.google.android.exoplayer2.source.TrackGroup r0 = r8.trackGroup
            com.google.android.exoplayer2.Format r2 = r4.trackFormat
            int r0 = r0.indexOf(r2)
            r5 = r0
        L_0x002d:
            r0 = 0
            long r12 = r6 - r40
            long r14 = r39.resolveTimeToLiveEdgeUs(r40)
            if (r4 == 0) goto L_0x0058
            boolean r0 = r8.independentSegments
            if (r0 != 0) goto L_0x0058
            long r16 = r4.getDurationUs()
            long r12 = r12 - r16
            r10 = 0
            long r12 = java.lang.Math.max(r10, r12)
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x0058
            long r14 = r14 - r16
            long r10 = java.lang.Math.max(r10, r14)
            r17 = r10
            goto L_0x005a
        L_0x0058:
            r17 = r14
        L_0x005a:
            r15 = r12
            com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] r20 = r8.createMediaChunkIterators(r4, r6)
            com.google.android.exoplayer2.trackselection.TrackSelection r12 = r8.trackSelection
            r13 = r40
            r19 = r44
            r12.updateSelectedTrack(r13, r15, r17, r19, r20)
            com.google.android.exoplayer2.trackselection.TrackSelection r0 = r8.trackSelection
            int r10 = r0.getSelectedIndexInTrackGroup()
            r11 = 0
            if (r5 == r10) goto L_0x0073
            r12 = 1
            goto L_0x0074
        L_0x0073:
            r12 = 0
        L_0x0074:
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$HlsUrl[] r0 = r8.variants
            r13 = r0[r10]
            com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker r0 = r8.playlistTracker
            boolean r0 = r0.isSnapshotValid(r13)
            if (r0 != 0) goto L_0x008f
            r9.playlist = r13
            boolean r0 = r8.seenExpectedPlaylistError
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$HlsUrl r1 = r8.expectedPlaylistUrl
            if (r1 != r13) goto L_0x0089
            r11 = 1
        L_0x0089:
            r0 = r0 & r11
            r8.seenExpectedPlaylistError = r0
            r8.expectedPlaylistUrl = r13
            return
        L_0x008f:
            com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker r0 = r8.playlistTracker
            r1 = 1
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist r14 = r0.getPlaylistSnapshot(r13, r1)
            boolean r0 = r14.hasIndependentSegments
            r8.independentSegments = r0
            r8.updateLiveEdgeTimeUs(r14)
            long r0 = r14.startTimeUs
            com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker r2 = r8.playlistTracker
            long r2 = r2.getInitialStartTimeUs()
            long r15 = r0 - r2
            r0 = r39
            r1 = r4
            r2 = r12
            r3 = r14
            r31 = r4
            r17 = r5
            r4 = r15
            r6 = r42
            long r0 = r0.getChunkMediaSequence(r1, r2, r3, r4, r6)
            long r2 = r14.mediaSequence
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x00e7
            if (r31 == 0) goto L_0x00df
            if (r12 == 0) goto L_0x00df
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$HlsUrl[] r0 = r8.variants
            r0 = r0[r17]
            com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker r1 = r8.playlistTracker
            r2 = 1
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist r14 = r1.getPlaylistSnapshot(r0, r2)
            long r1 = r14.startTimeUs
            com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker r3 = r8.playlistTracker
            long r3 = r3.getInitialStartTimeUs()
            long r15 = r1 - r3
            long r1 = r31.getNextChunkIndex()
            r25 = r1
            r3 = r17
            goto L_0x00eb
        L_0x00df:
            com.google.android.exoplayer2.source.BehindLiveWindowException r0 = new com.google.android.exoplayer2.source.BehindLiveWindowException
            r0.<init>()
            r8.fatalError = r0
            return
        L_0x00e7:
            r25 = r0
            r3 = r10
            r0 = r13
        L_0x00eb:
            long r1 = r14.mediaSequence
            long r1 = r25 - r1
            int r1 = (int) r1
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment> r2 = r14.segments
            int r2 = r2.size()
            if (r1 < r2) goto L_0x0111
            boolean r1 = r14.hasEndTag
            if (r1 == 0) goto L_0x0100
            r1 = 1
            r9.endOfStream = r1
            goto L_0x0110
        L_0x0100:
            r1 = 1
            r9.playlist = r0
            boolean r2 = r8.seenExpectedPlaylistError
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$HlsUrl r3 = r8.expectedPlaylistUrl
            if (r3 != r0) goto L_0x010a
            r11 = 1
        L_0x010a:
            r1 = r2 & r11
            r8.seenExpectedPlaylistError = r1
            r8.expectedPlaylistUrl = r0
        L_0x0110:
            return
        L_0x0111:
            r8.seenExpectedPlaylistError = r11
            r2 = 0
            r8.expectedPlaylistUrl = r2
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment> r4 = r14.segments
            java.lang.Object r1 = r4.get(r1)
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment r1 = (com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment) r1
            java.lang.String r4 = r1.fullSegmentEncryptionKeyUri
            if (r4 == 0) goto L_0x015e
            java.lang.String r4 = r14.baseUri
            java.lang.String r5 = r1.fullSegmentEncryptionKeyUri
            android.net.Uri r4 = com.google.android.exoplayer2.util.UriUtil.resolveToUri(r4, r5)
            android.net.Uri r5 = r8.encryptionKeyUri
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x014c
            java.lang.String r2 = r1.encryptionIV
            com.google.android.exoplayer2.trackselection.TrackSelection r0 = r8.trackSelection
            int r5 = r0.getSelectionReason()
            com.google.android.exoplayer2.trackselection.TrackSelection r0 = r8.trackSelection
            java.lang.Object r6 = r0.getSelectionData()
            r0 = r39
            r1 = r4
            r4 = r5
            r5 = r6
            com.google.android.exoplayer2.source.hls.HlsChunkSource$EncryptionKeyChunk r0 = r0.newEncryptionKeyChunk(r1, r2, r3, r4, r5)
            r9.chunk = r0
            return
        L_0x014c:
            java.lang.String r3 = r1.encryptionIV
            java.lang.String r5 = r8.encryptionIvString
            boolean r3 = com.google.android.exoplayer2.util.Util.areEqual(r3, r5)
            if (r3 != 0) goto L_0x0161
            java.lang.String r3 = r1.encryptionIV
            byte[] r5 = r8.encryptionKey
            r8.setEncryptionData(r4, r3, r5)
            goto L_0x0161
        L_0x015e:
            r39.clearEncryptionData()
        L_0x0161:
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment r3 = r1.initializationSegment
            if (r3 == 0) goto L_0x017e
            java.lang.String r2 = r14.baseUri
            java.lang.String r4 = r3.url
            android.net.Uri r18 = com.google.android.exoplayer2.util.UriUtil.resolveToUri(r2, r4)
            com.google.android.exoplayer2.upstream.DataSpec r2 = new com.google.android.exoplayer2.upstream.DataSpec
            long r4 = r3.byterangeOffset
            long r6 = r3.byterangeLength
            r23 = 0
            r17 = r2
            r19 = r4
            r21 = r6
            r17.<init>(r18, r19, r21, r23)
        L_0x017e:
            long r3 = r1.relativeStartTimeUs
            long r3 = r3 + r15
            r21 = r3
            int r5 = r14.discontinuitySequence
            int r6 = r1.relativeDiscontinuitySequence
            int r5 = r5 + r6
            r27 = r5
            com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider r6 = r8.timestampAdjusterProvider
            com.google.android.exoplayer2.util.TimestampAdjuster r30 = r6.getAdjuster(r5)
            java.lang.String r5 = r14.baseUri
            java.lang.String r6 = r1.url
            android.net.Uri r33 = com.google.android.exoplayer2.util.UriUtil.resolveToUri(r5, r6)
            com.google.android.exoplayer2.upstream.DataSpec r32 = new com.google.android.exoplayer2.upstream.DataSpec
            r15 = r32
            long r5 = r1.byterangeOffset
            long r10 = r1.byterangeLength
            r38 = 0
            r34 = r5
            r36 = r10
            r32.<init>(r33, r34, r36, r38)
            com.google.android.exoplayer2.source.hls.HlsMediaChunk r5 = new com.google.android.exoplayer2.source.hls.HlsMediaChunk
            r12 = r5
            com.google.android.exoplayer2.source.hls.HlsExtractorFactory r13 = r8.extractorFactory
            com.google.android.exoplayer2.upstream.DataSource r14 = r8.mediaDataSource
            java.util.List<com.google.android.exoplayer2.Format> r6 = r8.muxedCaptionFormats
            r18 = r6
            com.google.android.exoplayer2.trackselection.TrackSelection r6 = r8.trackSelection
            int r19 = r6.getSelectionReason()
            com.google.android.exoplayer2.trackselection.TrackSelection r6 = r8.trackSelection
            java.lang.Object r20 = r6.getSelectionData()
            long r6 = r1.durationUs
            long r23 = r3 + r6
            boolean r3 = r1.hasGapTag
            r28 = r3
            boolean r3 = r8.isTimestampMaster
            r29 = r3
            com.google.android.exoplayer2.drm.DrmInitData r1 = r1.drmInitData
            r32 = r1
            byte[] r1 = r8.encryptionKey
            r33 = r1
            byte[] r1 = r8.encryptionIv
            r34 = r1
            r16 = r2
            r17 = r0
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r25, r27, r28, r29, r30, r31, r32, r33, r34)
            r9.chunk = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsChunkSource.getNextChunk(long, long, java.util.List, com.google.android.exoplayer2.source.hls.HlsChunkSource$HlsChunkHolder):void");
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        if (chunk instanceof EncryptionKeyChunk) {
            EncryptionKeyChunk encryptionKeyChunk = (EncryptionKeyChunk) chunk;
            this.scratchSpace = encryptionKeyChunk.getDataHolder();
            setEncryptionData(encryptionKeyChunk.dataSpec.uri, encryptionKeyChunk.f158iv, encryptionKeyChunk.getResult());
        }
    }

    public boolean maybeBlacklistTrack(Chunk chunk, long j) {
        return this.trackSelection.blacklist(this.trackSelection.indexOf(this.trackGroup.indexOf(chunk.trackFormat)), j);
    }

    public boolean onPlaylistError(HlsMasterPlaylist.HlsUrl hlsUrl, long j) {
        int indexOf;
        int indexOf2 = this.trackGroup.indexOf(hlsUrl.format);
        if (indexOf2 == -1 || (indexOf = this.trackSelection.indexOf(indexOf2)) == -1) {
            return true;
        }
        this.seenExpectedPlaylistError = (this.expectedPlaylistUrl == hlsUrl) | this.seenExpectedPlaylistError;
        if (j == C1470C.TIME_UNSET || this.trackSelection.blacklist(indexOf, j)) {
            return true;
        }
        return false;
    }

    public MediaChunkIterator[] createMediaChunkIterators(@Nullable HlsMediaChunk hlsMediaChunk, long j) {
        int i;
        HlsMediaChunk hlsMediaChunk2 = hlsMediaChunk;
        if (hlsMediaChunk2 == null) {
            i = -1;
        } else {
            i = this.trackGroup.indexOf(hlsMediaChunk2.trackFormat);
        }
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[this.trackSelection.length()];
        for (int i2 = 0; i2 < mediaChunkIteratorArr.length; i2++) {
            int indexInTrackGroup = this.trackSelection.getIndexInTrackGroup(i2);
            HlsMasterPlaylist.HlsUrl hlsUrl = this.variants[indexInTrackGroup];
            if (!this.playlistTracker.isSnapshotValid(hlsUrl)) {
                mediaChunkIteratorArr[i2] = MediaChunkIterator.EMPTY;
            } else {
                HlsMediaPlaylist playlistSnapshot = this.playlistTracker.getPlaylistSnapshot(hlsUrl, false);
                long initialStartTimeUs = playlistSnapshot.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
                long j2 = initialStartTimeUs;
                long chunkMediaSequence = getChunkMediaSequence(hlsMediaChunk, indexInTrackGroup != i, playlistSnapshot, initialStartTimeUs, j);
                if (chunkMediaSequence < playlistSnapshot.mediaSequence) {
                    mediaChunkIteratorArr[i2] = MediaChunkIterator.EMPTY;
                } else {
                    mediaChunkIteratorArr[i2] = new HlsMediaPlaylistSegmentIterator(playlistSnapshot, j2, (int) (chunkMediaSequence - playlistSnapshot.mediaSequence));
                }
            }
        }
        return mediaChunkIteratorArr;
    }

    private long getChunkMediaSequence(@Nullable HlsMediaChunk hlsMediaChunk, boolean z, HlsMediaPlaylist hlsMediaPlaylist, long j, long j2) {
        if (hlsMediaChunk != null && !z) {
            return hlsMediaChunk.getNextChunkIndex();
        }
        long j3 = hlsMediaPlaylist.durationUs + j;
        if (hlsMediaChunk != null && !this.independentSegments) {
            j2 = hlsMediaChunk.startTimeUs;
        }
        if (!hlsMediaPlaylist.hasEndTag && j2 >= j3) {
            return hlsMediaPlaylist.mediaSequence + ((long) hlsMediaPlaylist.segments.size());
        }
        return ((long) Util.binarySearchFloor(hlsMediaPlaylist.segments, Long.valueOf(j2 - j), true, !this.playlistTracker.isLive() || hlsMediaChunk == null)) + hlsMediaPlaylist.mediaSequence;
    }

    private long resolveTimeToLiveEdgeUs(long j) {
        if (this.liveEdgeInPeriodTimeUs != C1470C.TIME_UNSET) {
            return this.liveEdgeInPeriodTimeUs - j;
        }
        return C1470C.TIME_UNSET;
    }

    private void updateLiveEdgeTimeUs(HlsMediaPlaylist hlsMediaPlaylist) {
        long j;
        if (hlsMediaPlaylist.hasEndTag) {
            j = C1470C.TIME_UNSET;
        } else {
            j = hlsMediaPlaylist.getEndTimeUs() - this.playlistTracker.getInitialStartTimeUs();
        }
        this.liveEdgeInPeriodTimeUs = j;
    }

    private EncryptionKeyChunk newEncryptionKeyChunk(Uri uri, String str, int i, int i2, Object obj) {
        return new EncryptionKeyChunk(this.encryptionDataSource, new DataSpec(uri, 0, -1, (String) null, 1), this.variants[i].format, i2, obj, this.scratchSpace, str);
    }

    private void setEncryptionData(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(Util.toLowerInvariant(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (bArr2.length - byteArray.length) + length, byteArray.length - length);
        this.encryptionKeyUri = uri;
        this.encryptionKey = bArr;
        this.encryptionIvString = str;
        this.encryptionIv = bArr2;
    }

    private void clearEncryptionData() {
        this.encryptionKeyUri = null;
        this.encryptionKey = null;
        this.encryptionIvString = null;
        this.encryptionIv = null;
    }

    private static final class InitializationTrackSelection extends BaseTrackSelection {
        private int selectedIndex;

        public Object getSelectionData() {
            return null;
        }

        public int getSelectionReason() {
            return 0;
        }

        public InitializationTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.selectedIndex = indexOf(trackGroup.getFormat(0));
        }

        public void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (isBlacklisted(this.selectedIndex, elapsedRealtime)) {
                for (int i = this.length - 1; i >= 0; i--) {
                    if (!isBlacklisted(i, elapsedRealtime)) {
                        this.selectedIndex = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        public int getSelectedIndex() {
            return this.selectedIndex;
        }
    }

    private static final class EncryptionKeyChunk extends DataChunk {

        /* renamed from: iv */
        public final String f158iv;
        private byte[] result;

        public EncryptionKeyChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, byte[] bArr, String str) {
            super(dataSource, dataSpec, 3, format, i, obj, bArr);
            this.f158iv = str;
        }

        /* access modifiers changed from: protected */
        public void consume(byte[] bArr, int i) throws IOException {
            this.result = Arrays.copyOf(bArr, i);
        }

        public byte[] getResult() {
            return this.result;
        }
    }

    private static final class HlsMediaPlaylistSegmentIterator extends BaseMediaChunkIterator {
        private final HlsMediaPlaylist playlist;
        private final long startOfPlaylistInPeriodUs;

        public HlsMediaPlaylistSegmentIterator(HlsMediaPlaylist hlsMediaPlaylist, long j, int i) {
            super((long) i, (long) (hlsMediaPlaylist.segments.size() - 1));
            this.playlist = hlsMediaPlaylist;
            this.startOfPlaylistInPeriodUs = j;
        }

        public DataSpec getDataSpec() {
            checkInBounds();
            HlsMediaPlaylist.Segment segment = this.playlist.segments.get((int) getCurrentIndex());
            return new DataSpec(UriUtil.resolveToUri(this.playlist.baseUri, segment.url), segment.byterangeOffset, segment.byterangeLength, (String) null);
        }

        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.startOfPlaylistInPeriodUs + this.playlist.segments.get((int) getCurrentIndex()).relativeStartTimeUs;
        }

        public long getChunkEndTimeUs() {
            checkInBounds();
            HlsMediaPlaylist.Segment segment = this.playlist.segments.get((int) getCurrentIndex());
            return this.startOfPlaylistInPeriodUs + segment.relativeStartTimeUs + segment.durationUs;
        }
    }
}
