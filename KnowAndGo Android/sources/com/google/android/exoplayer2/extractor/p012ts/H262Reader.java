package com.google.android.exoplayer2.extractor.p012ts;

import android.util.Pair;
import com.google.android.exoplayer2.C1470C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p012ts.TsPayloadReader;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;
import kotlin.UByte;

/* renamed from: com.google.android.exoplayer2.extractor.ts.H262Reader */
public final class H262Reader implements ElementaryStreamReader {
    private static final double[] FRAME_RATE_VALUES = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private static final int START_EXTENSION = 181;
    private static final int START_GROUP = 184;
    private static final int START_PICTURE = 0;
    private static final int START_SEQUENCE_HEADER = 179;
    private static final int START_USER_DATA = 178;
    private final CsdBuffer csdBuffer;
    private String formatId;
    private long frameDurationUs;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final boolean[] prefixFlags;
    private boolean sampleHasPicture;
    private boolean sampleIsKeyframe;
    private long samplePosition;
    private long sampleTimeUs;
    private boolean startedFirstSample;
    private long totalBytesWritten;
    private final NalUnitTargetBuffer userData;
    private final ParsableByteArray userDataParsable;
    private final UserDataReader userDataReader;

    public void packetFinished() {
    }

    public H262Reader() {
        this((UserDataReader) null);
    }

    public H262Reader(UserDataReader userDataReader2) {
        this.userDataReader = userDataReader2;
        this.prefixFlags = new boolean[4];
        this.csdBuffer = new CsdBuffer(128);
        if (userDataReader2 != null) {
            this.userData = new NalUnitTargetBuffer(START_USER_DATA, 128);
            this.userDataParsable = new ParsableByteArray();
            return;
        }
        this.userData = null;
        this.userDataParsable = null;
    }

    public void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.csdBuffer.reset();
        if (this.userDataReader != null) {
            this.userData.reset();
        }
        this.totalBytesWritten = 0;
        this.startedFirstSample = false;
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        if (this.userDataReader != null) {
            this.userDataReader.createTracks(extractorOutput, trackIdGenerator);
        }
    }

    public void packetStarted(long j, boolean z) {
        this.pesTimeUs = j;
    }

    public void consume(ParsableByteArray parsableByteArray) {
        int i;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] bArr = parsableByteArray2.data;
        this.totalBytesWritten += (long) parsableByteArray.bytesLeft();
        this.output.sampleData(parsableByteArray2, parsableByteArray.bytesLeft());
        while (true) {
            int findNalUnit = NalUnitUtil.findNalUnit(bArr, position, limit, this.prefixFlags);
            if (findNalUnit == limit) {
                break;
            }
            int i2 = findNalUnit + 3;
            byte b = parsableByteArray2.data[i2] & UByte.MAX_VALUE;
            int i3 = findNalUnit - position;
            boolean z = false;
            if (!this.hasOutputFormat) {
                if (i3 > 0) {
                    this.csdBuffer.onData(bArr, position, findNalUnit);
                }
                if (this.csdBuffer.onStartCode(b, i3 < 0 ? -i3 : 0)) {
                    Pair<Format, Long> parseCsdBuffer = parseCsdBuffer(this.csdBuffer, this.formatId);
                    this.output.format((Format) parseCsdBuffer.first);
                    this.frameDurationUs = ((Long) parseCsdBuffer.second).longValue();
                    this.hasOutputFormat = true;
                }
            }
            if (this.userDataReader != null) {
                if (i3 > 0) {
                    this.userData.appendToNalUnit(bArr, position, findNalUnit);
                    i = 0;
                } else {
                    i = -i3;
                }
                if (this.userData.endNalUnit(i)) {
                    this.userDataParsable.reset(this.userData.nalData, NalUnitUtil.unescapeStream(this.userData.nalData, this.userData.nalLength));
                    this.userDataReader.consume(this.sampleTimeUs, this.userDataParsable);
                }
                if (b == START_USER_DATA && parsableByteArray2.data[findNalUnit + 2] == 1) {
                    this.userData.startNalUnit(b);
                }
            }
            if (b == 0 || b == START_SEQUENCE_HEADER) {
                int i4 = limit - findNalUnit;
                if (this.startedFirstSample && this.sampleHasPicture && this.hasOutputFormat) {
                    this.output.sampleMetadata(this.sampleTimeUs, this.sampleIsKeyframe ? 1 : 0, ((int) (this.totalBytesWritten - this.samplePosition)) - i4, i4, (TrackOutput.CryptoData) null);
                }
                if (!this.startedFirstSample || this.sampleHasPicture) {
                    this.samplePosition = this.totalBytesWritten - ((long) i4);
                    this.sampleTimeUs = this.pesTimeUs != C1470C.TIME_UNSET ? this.pesTimeUs : this.startedFirstSample ? this.sampleTimeUs + this.frameDurationUs : 0;
                    this.sampleIsKeyframe = false;
                    this.pesTimeUs = C1470C.TIME_UNSET;
                    this.startedFirstSample = true;
                }
                if (b == 0) {
                    z = true;
                }
                this.sampleHasPicture = z;
            } else if (b == START_GROUP) {
                this.sampleIsKeyframe = true;
            }
            position = i2;
        }
        if (!this.hasOutputFormat) {
            this.csdBuffer.onData(bArr, position, limit);
        }
        if (this.userDataReader != null) {
            this.userData.appendToNalUnit(bArr, position, limit);
        }
    }

    private static Pair<Format, Long> parseCsdBuffer(CsdBuffer csdBuffer2, String str) {
        float f;
        float f2;
        CsdBuffer csdBuffer3 = csdBuffer2;
        byte[] copyOf = Arrays.copyOf(csdBuffer3.data, csdBuffer3.length);
        byte b = copyOf[4] & UByte.MAX_VALUE;
        byte b2 = copyOf[5] & UByte.MAX_VALUE;
        int i = (b << 4) | (b2 >> 4);
        byte b3 = ((b2 & 15) << 8) | (copyOf[6] & UByte.MAX_VALUE);
        switch ((copyOf[7] & 240) >> 4) {
            case 2:
                f2 = ((float) (b3 * 4)) / ((float) (i * 3));
                break;
            case 3:
                f2 = ((float) (b3 * 16)) / ((float) (i * 9));
                break;
            case 4:
                f2 = ((float) (b3 * 121)) / ((float) (i * 100));
                break;
            default:
                f = 1.0f;
                break;
        }
        f = f2;
        Format createVideoSampleFormat = Format.createVideoSampleFormat(str, MimeTypes.VIDEO_MPEG2, (String) null, -1, -1, i, b3, -1.0f, Collections.singletonList(copyOf), -1, f, (DrmInitData) null);
        long j = 0;
        int i2 = (copyOf[7] & 15) - 1;
        if (i2 >= 0 && i2 < FRAME_RATE_VALUES.length) {
            double d = FRAME_RATE_VALUES[i2];
            int i3 = csdBuffer3.sequenceExtensionPosition + 9;
            int i4 = (copyOf[i3] & 96) >> 5;
            byte b4 = copyOf[i3] & 31;
            if (i4 != b4) {
                d *= (((double) i4) + 1.0d) / ((double) (b4 + 1));
            }
            j = (long) (1000000.0d / d);
        }
        return Pair.create(createVideoSampleFormat, Long.valueOf(j));
    }

    /* renamed from: com.google.android.exoplayer2.extractor.ts.H262Reader$CsdBuffer */
    private static final class CsdBuffer {
        private static final byte[] START_CODE = {0, 0, 1};
        public byte[] data;
        private boolean isFilling;
        public int length;
        public int sequenceExtensionPosition;

        public CsdBuffer(int i) {
            this.data = new byte[i];
        }

        public void reset() {
            this.isFilling = false;
            this.length = 0;
            this.sequenceExtensionPosition = 0;
        }

        public boolean onStartCode(int i, int i2) {
            if (this.isFilling) {
                this.length -= i2;
                if (this.sequenceExtensionPosition == 0 && i == H262Reader.START_EXTENSION) {
                    this.sequenceExtensionPosition = this.length;
                } else {
                    this.isFilling = false;
                    return true;
                }
            } else if (i == H262Reader.START_SEQUENCE_HEADER) {
                this.isFilling = true;
            }
            onData(START_CODE, 0, START_CODE.length);
            return false;
        }

        public void onData(byte[] bArr, int i, int i2) {
            if (this.isFilling) {
                int i3 = i2 - i;
                if (this.data.length < this.length + i3) {
                    this.data = Arrays.copyOf(this.data, (this.length + i3) * 2);
                }
                System.arraycopy(bArr, i, this.data, this.length, i3);
                this.length += i3;
            }
        }
    }
}
