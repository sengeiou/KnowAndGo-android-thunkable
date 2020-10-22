package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.C1470C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public class DashManifestParser extends DefaultHandler implements ParsingLoadable.Parser<DashManifest> {
    private static final Pattern CEA_608_ACCESSIBILITY_PATTERN = Pattern.compile("CC([1-4])=.*");
    private static final Pattern CEA_708_ACCESSIBILITY_PATTERN = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    private static final Pattern FRAME_RATE_PATTERN = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private static final String TAG = "MpdParser";
    private final String contentId;
    private final XmlPullParserFactory xmlParserFactory;

    public DashManifestParser() {
        this((String) null);
    }

    public DashManifestParser(String str) {
        this.contentId = str;
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    public DashManifest parse(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            newPullParser.setInput(inputStream, (String) null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return parseMediaPresentationDescription(newPullParser, uri.toString());
            }
            throw new ParserException("inputStream does not contain a valid media presentation description");
        } catch (XmlPullParserException e) {
            throw new ParserException((Throwable) e);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0182 A[LOOP:0: B:20:0x006c->B:66:0x0182, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0140 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.manifest.DashManifest parseMediaPresentationDescription(org.xmlpull.v1.XmlPullParser r35, java.lang.String r36) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r34 = this;
            r0 = r35
            java.lang.String r1 = "availabilityStartTime"
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r5 = parseDateTime(r0, r1, r2)
            java.lang.String r1 = "mediaPresentationDuration"
            long r7 = parseDuration(r0, r1, r2)
            java.lang.String r1 = "minBufferTime"
            long r9 = parseDuration(r0, r1, r2)
            java.lang.String r1 = "type"
            r4 = 0
            java.lang.String r1 = r0.getAttributeValue(r4, r1)
            r12 = 0
            if (r1 == 0) goto L_0x002e
            java.lang.String r13 = "dynamic"
            boolean r1 = r13.equals(r1)
            if (r1 == 0) goto L_0x002e
            r1 = 1
            goto L_0x002f
        L_0x002e:
            r1 = 0
        L_0x002f:
            if (r1 == 0) goto L_0x0038
            java.lang.String r13 = "minimumUpdatePeriod"
            long r13 = parseDuration(r0, r13, r2)
            goto L_0x0039
        L_0x0038:
            r13 = r2
        L_0x0039:
            if (r1 == 0) goto L_0x0042
            java.lang.String r15 = "timeShiftBufferDepth"
            long r15 = parseDuration(r0, r15, r2)
            goto L_0x0043
        L_0x0042:
            r15 = r2
        L_0x0043:
            if (r1 == 0) goto L_0x004c
            java.lang.String r4 = "suggestedPresentationDelay"
            long r17 = parseDuration(r0, r4, r2)
            goto L_0x004e
        L_0x004c:
            r17 = r2
        L_0x004e:
            java.lang.String r4 = "publishTime"
            long r19 = parseDateTime(r0, r4, r2)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            if (r1 == 0) goto L_0x005e
            r21 = r2
            goto L_0x0060
        L_0x005e:
            r21 = 0
        L_0x0060:
            r11 = r36
            r2 = r21
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
        L_0x006c:
            r35.next()
            r27 = r15
            java.lang.String r15 = "BaseURL"
            boolean r15 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r0, r15)
            if (r15 == 0) goto L_0x008c
            if (r12 != 0) goto L_0x0084
            java.lang.String r11 = parseBaseUrl(r0, r11)
            r32 = r13
            r12 = 1
            goto L_0x0138
        L_0x0084:
            r30 = r2
            r29 = r12
            r32 = r13
            goto L_0x0134
        L_0x008c:
            java.lang.String r15 = "ProgramInformation"
            boolean r15 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r0, r15)
            if (r15 == 0) goto L_0x009e
            com.google.android.exoplayer2.source.dash.manifest.ProgramInformation r15 = r34.parseProgramInformation(r35)
            r32 = r13
            r24 = r15
            goto L_0x0138
        L_0x009e:
            java.lang.String r15 = "UTCTiming"
            boolean r15 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r0, r15)
            if (r15 == 0) goto L_0x00b0
            com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement r15 = r34.parseUtcTiming(r35)
            r32 = r13
            r22 = r15
            goto L_0x0138
        L_0x00b0:
            java.lang.String r15 = "Location"
            boolean r15 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r0, r15)
            if (r15 == 0) goto L_0x00c6
            java.lang.String r15 = r35.nextText()
            android.net.Uri r15 = android.net.Uri.parse(r15)
            r32 = r13
            r23 = r15
            goto L_0x0138
        L_0x00c6:
            java.lang.String r15 = "Period"
            boolean r15 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r0, r15)
            if (r15 == 0) goto L_0x012b
            if (r21 != 0) goto L_0x012b
            r15 = r34
            r29 = r12
            android.util.Pair r12 = r15.parsePeriod(r0, r11, r2)
            r30 = r2
            java.lang.Object r2 = r12.first
            com.google.android.exoplayer2.source.dash.manifest.Period r2 = (com.google.android.exoplayer2.source.dash.manifest.Period) r2
            r32 = r13
            long r13 = r2.startMs
            r25 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r13 > r25 ? 1 : (r13 == r25 ? 0 : -1))
            if (r3 != 0) goto L_0x010b
            if (r1 == 0) goto L_0x00f0
            r21 = 1
            goto L_0x0134
        L_0x00f0:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to determine start of period "
            r1.append(r2)
            int r2 = r4.size()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x010b:
            java.lang.Object r3 = r12.second
            java.lang.Long r3 = (java.lang.Long) r3
            long r12 = r3.longValue()
            r25 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r12 > r25 ? 1 : (r12 == r25 ? 0 : -1))
            if (r3 != 0) goto L_0x0122
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0125
        L_0x0122:
            long r14 = r2.startMs
            long r12 = r12 + r14
        L_0x0125:
            r4.add(r2)
            r30 = r12
            goto L_0x0134
        L_0x012b:
            r30 = r2
            r29 = r12
            r32 = r13
            maybeSkipTag(r35)
        L_0x0134:
            r12 = r29
            r2 = r30
        L_0x0138:
            java.lang.String r13 = "MPD"
            boolean r13 = com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(r0, r13)
            if (r13 == 0) goto L_0x0182
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x015a
            int r0 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x014f
            r7 = r2
            goto L_0x015a
        L_0x014f:
            if (r1 == 0) goto L_0x0152
            goto L_0x015a
        L_0x0152:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            java.lang.String r1 = "Unable to determine duration of static manifest."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x015a:
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto L_0x017a
            r25 = r4
            r4 = r34
            r11 = r1
            r12 = r32
            r14 = r27
            r16 = r17
            r18 = r19
            r20 = r24
            r21 = r22
            r22 = r23
            r23 = r25
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r0 = r4.buildMediaPresentationDescription(r5, r7, r9, r11, r12, r14, r16, r18, r20, r21, r22, r23)
            return r0
        L_0x017a:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            java.lang.String r1 = "No periods found."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0182:
            r15 = r27
            r13 = r32
            goto L_0x006c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseMediaPresentationDescription(org.xmlpull.v1.XmlPullParser, java.lang.String):com.google.android.exoplayer2.source.dash.manifest.DashManifest");
    }

    /* access modifiers changed from: protected */
    public DashManifest buildMediaPresentationDescription(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, ProgramInformation programInformation, UtcTimingElement utcTimingElement, Uri uri, List<Period> list) {
        return new DashManifest(j, j2, j3, z, j4, j5, j6, j7, programInformation, utcTimingElement, uri, list);
    }

    /* access modifiers changed from: protected */
    public UtcTimingElement parseUtcTiming(XmlPullParser xmlPullParser) {
        return buildUtcTimingElement(xmlPullParser.getAttributeValue((String) null, "schemeIdUri"), xmlPullParser.getAttributeValue((String) null, "value"));
    }

    /* access modifiers changed from: protected */
    public UtcTimingElement buildUtcTimingElement(String str, String str2) {
        return new UtcTimingElement(str, str2);
    }

    /* access modifiers changed from: protected */
    public Pair<Period, Long> parsePeriod(XmlPullParser xmlPullParser, String str, long j) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "id");
        long parseDuration = parseDuration(xmlPullParser, "start", j);
        long parseDuration2 = parseDuration(xmlPullParser, "duration", C1470C.TIME_UNSET);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z = false;
        SegmentBase segmentBase = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (!z) {
                    str = parseBaseUrl(xmlPullParser, str);
                    z = true;
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "AdaptationSet")) {
                arrayList.add(parseAdaptationSet(xmlPullParser, str, segmentBase));
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "EventStream")) {
                arrayList2.add(parseEventStream(xmlPullParser));
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentBase")) {
                segmentBase = parseSegmentBase(xmlPullParser, (SegmentBase.SingleSegmentBase) null);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentList")) {
                segmentBase = parseSegmentList(xmlPullParser, (SegmentBase.SegmentList) null);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTemplate")) {
                segmentBase = parseSegmentTemplate(xmlPullParser, (SegmentBase.SegmentTemplate) null);
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "Period"));
        return Pair.create(buildPeriod(attributeValue, parseDuration, arrayList, arrayList2), Long.valueOf(parseDuration2));
    }

    /* access modifiers changed from: protected */
    public Period buildPeriod(String str, long j, List<AdaptationSet> list, List<EventStream> list2) {
        return new Period(str, j, list, list2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v5, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x023d A[LOOP:0: B:1:0x006a->B:59:0x023d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0204 A[EDGE_INSN: B:60:0x0204->B:53:0x0204 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.manifest.AdaptationSet parseAdaptationSet(org.xmlpull.v1.XmlPullParser r40, java.lang.String r41, com.google.android.exoplayer2.source.dash.manifest.SegmentBase r42) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r39 = this;
            r15 = r39
            r14 = r40
            java.lang.String r0 = "id"
            r1 = -1
            int r16 = parseInt(r14, r0, r1)
            int r0 = r39.parseContentType(r40)
            java.lang.String r2 = "mimeType"
            r13 = 0
            java.lang.String r17 = r14.getAttributeValue(r13, r2)
            java.lang.String r2 = "codecs"
            java.lang.String r18 = r14.getAttributeValue(r13, r2)
            java.lang.String r2 = "width"
            int r19 = parseInt(r14, r2, r1)
            java.lang.String r2 = "height"
            int r20 = parseInt(r14, r2, r1)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r21 = parseFrameRate(r14, r2)
            java.lang.String r2 = "audioSamplingRate"
            int r22 = parseInt(r14, r2, r1)
            java.lang.String r2 = "lang"
            java.lang.String r2 = r14.getAttributeValue(r13, r2)
            java.lang.String r3 = "label"
            java.lang.String r23 = r14.getAttributeValue(r13, r3)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r24 = 0
            r7 = r41
            r28 = r42
            r5 = r0
            r6 = r2
            r29 = r13
            r25 = 0
            r26 = 0
            r27 = -1
        L_0x006a:
            r40.next()
            java.lang.String r0 = "BaseURL"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x00a2
            if (r25 != 0) goto L_0x0090
            java.lang.String r0 = parseBaseUrl(r14, r7)
            r1 = 1
            r32 = r0
            r31 = r6
            r6 = r8
            r34 = r9
            r35 = r10
            r7 = r11
            r37 = r12
            r38 = r13
            r1 = r14
            r25 = 1
        L_0x008d:
            r8 = r5
            goto L_0x01fc
        L_0x0090:
            r2 = r5
            r31 = r6
            r32 = r7
            r6 = r8
            r34 = r9
            r35 = r10
            r7 = r11
            r37 = r12
            r38 = r13
            r1 = r14
            goto L_0x01fb
        L_0x00a2:
            java.lang.String r0 = "ContentProtection"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x00d1
            android.util.Pair r0 = r39.parseContentProtection(r40)
            java.lang.Object r1 = r0.first
            if (r1 == 0) goto L_0x00b8
            java.lang.Object r1 = r0.first
            r29 = r1
            java.lang.String r29 = (java.lang.String) r29
        L_0x00b8:
            java.lang.Object r1 = r0.second
            if (r1 == 0) goto L_0x00c1
            java.lang.Object r0 = r0.second
            r12.add(r0)
        L_0x00c1:
            r31 = r6
            r32 = r7
            r6 = r8
            r34 = r9
            r35 = r10
            r7 = r11
            r37 = r12
            r38 = r13
            r1 = r14
            goto L_0x008d
        L_0x00d1:
            java.lang.String r0 = "ContentComponent"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x00fd
            java.lang.String r0 = "lang"
            java.lang.String r0 = r14.getAttributeValue(r13, r0)
            java.lang.String r6 = checkLanguageConsistency(r6, r0)
            int r0 = r39.parseContentType(r40)
            int r0 = checkContentTypeConsistency(r5, r0)
            r31 = r6
            r32 = r7
            r6 = r8
            r34 = r9
            r35 = r10
            r7 = r11
            r37 = r12
            r38 = r13
            r1 = r14
            r8 = r0
            goto L_0x01fc
        L_0x00fd:
            java.lang.String r0 = "Role"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x010c
            int r0 = r39.parseRole(r40)
            r26 = r26 | r0
            goto L_0x00c1
        L_0x010c:
            java.lang.String r0 = "AudioChannelConfiguration"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x0119
            int r27 = r39.parseAudioChannelConfiguration(r40)
            goto L_0x00c1
        L_0x0119:
            java.lang.String r0 = "Accessibility"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x012c
            java.lang.String r0 = "Accessibility"
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r0 = parseDescriptor(r14, r0)
            r10.add(r0)
            goto L_0x0090
        L_0x012c:
            java.lang.String r0 = "SupplementalProperty"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x013f
            java.lang.String r0 = "SupplementalProperty"
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r0 = parseDescriptor(r14, r0)
            r9.add(r0)
            goto L_0x0090
        L_0x013f:
            java.lang.String r0 = "Representation"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x0192
            r0 = r39
            r1 = r40
            r2 = r7
            r3 = r23
            r4 = r17
            r30 = r5
            r5 = r18
            r31 = r6
            r6 = r19
            r32 = r7
            r7 = r20
            r33 = r8
            r8 = r21
            r34 = r9
            r9 = r27
            r35 = r10
            r10 = r22
            r36 = r11
            r11 = r31
            r37 = r12
            r12 = r26
            r38 = r13
            r13 = r35
            r14 = r28
            com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo r0 = r0.parseRepresentation(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            com.google.android.exoplayer2.Format r1 = r0.format
            int r1 = r15.getContentType(r1)
            r2 = r30
            int r1 = checkContentTypeConsistency(r2, r1)
            r6 = r33
            r6.add(r0)
            r8 = r1
            r7 = r36
            r1 = r40
            goto L_0x01fc
        L_0x0192:
            r2 = r5
            r31 = r6
            r32 = r7
            r6 = r8
            r34 = r9
            r35 = r10
            r36 = r11
            r37 = r12
            r38 = r13
            java.lang.String r0 = "SegmentBase"
            r1 = r40
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r1, r0)
            if (r0 == 0) goto L_0x01ba
            r0 = r28
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r0 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase) r0
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r0 = r15.parseSegmentBase(r1, r0)
        L_0x01b4:
            r28 = r0
            r8 = r2
            r7 = r36
            goto L_0x01fc
        L_0x01ba:
            java.lang.String r0 = "SegmentList"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r1, r0)
            if (r0 == 0) goto L_0x01cb
            r0 = r28
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r0 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList) r0
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r0 = r15.parseSegmentList(r1, r0)
            goto L_0x01b4
        L_0x01cb:
            java.lang.String r0 = "SegmentTemplate"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r1, r0)
            if (r0 == 0) goto L_0x01dc
            r0 = r28
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r0 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate) r0
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r0 = r15.parseSegmentTemplate(r1, r0)
            goto L_0x01b4
        L_0x01dc:
            java.lang.String r0 = "InbandEventStream"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r1, r0)
            if (r0 == 0) goto L_0x01f0
            java.lang.String r0 = "InbandEventStream"
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r0 = parseDescriptor(r1, r0)
            r7 = r36
            r7.add(r0)
            goto L_0x01fb
        L_0x01f0:
            r7 = r36
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r40)
            if (r0 == 0) goto L_0x01fb
            r39.parseAdaptationSetChild(r40)
        L_0x01fb:
            r8 = r2
        L_0x01fc:
            java.lang.String r0 = "AdaptationSet"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(r1, r0)
            if (r0 == 0) goto L_0x023d
            java.util.ArrayList r9 = new java.util.ArrayList
            int r0 = r6.size()
            r9.<init>(r0)
            r10 = 0
        L_0x020e:
            int r0 = r6.size()
            if (r10 >= r0) goto L_0x022e
            java.lang.Object r0 = r6.get(r10)
            r1 = r0
            com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo r1 = (com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo) r1
            java.lang.String r2 = r15.contentId
            r0 = r39
            r3 = r29
            r4 = r37
            r5 = r7
            com.google.android.exoplayer2.source.dash.manifest.Representation r0 = r0.buildRepresentation(r1, r2, r3, r4, r5)
            r9.add(r0)
            int r10 = r10 + 1
            goto L_0x020e
        L_0x022e:
            r0 = r39
            r1 = r16
            r2 = r8
            r3 = r9
            r4 = r35
            r5 = r34
            com.google.android.exoplayer2.source.dash.manifest.AdaptationSet r0 = r0.buildAdaptationSet(r1, r2, r3, r4, r5)
            return r0
        L_0x023d:
            r14 = r1
            r11 = r7
            r5 = r8
            r7 = r32
            r9 = r34
            r10 = r35
            r12 = r37
            r13 = r38
            r8 = r6
            r6 = r31
            goto L_0x006a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseAdaptationSet(org.xmlpull.v1.XmlPullParser, java.lang.String, com.google.android.exoplayer2.source.dash.manifest.SegmentBase):com.google.android.exoplayer2.source.dash.manifest.AdaptationSet");
    }

    /* access modifiers changed from: protected */
    public AdaptationSet buildAdaptationSet(int i, int i2, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3) {
        return new AdaptationSet(i, i2, list, list2, list3);
    }

    /* access modifiers changed from: protected */
    public int parseContentType(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if (MimeTypes.BASE_TYPE_AUDIO.equals(attributeValue)) {
            return 1;
        }
        if (MimeTypes.BASE_TYPE_VIDEO.equals(attributeValue)) {
            return 2;
        }
        if ("text".equals(attributeValue)) {
            return 3;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public int getContentType(Format format) {
        String str = format.sampleMimeType;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (MimeTypes.isVideo(str)) {
            return 2;
        }
        if (MimeTypes.isAudio(str)) {
            return 1;
        }
        if (mimeTypeIsRawText(str)) {
            return 3;
        }
        return -1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        r5 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0142 A[LOOP:1: B:35:0x009e->B:75:0x0142, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0130 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData.SchemeData> parseContentProtection(org.xmlpull.v1.XmlPullParser r17) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "schemeIdUri"
            r2 = 0
            java.lang.String r1 = r0.getAttributeValue(r2, r1)
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0099
            java.lang.String r1 = com.google.android.exoplayer2.util.Util.toLowerInvariant(r1)
            r5 = -1
            int r6 = r1.hashCode()
            r7 = 489446379(0x1d2c5beb, float:2.281153E-21)
            if (r6 == r7) goto L_0x003c
            r7 = 755418770(0x2d06c692, float:7.66111E-12)
            if (r6 == r7) goto L_0x0031
            r7 = 1812765994(0x6c0c9d2a, float:6.799672E26)
            if (r6 == r7) goto L_0x0026
            goto L_0x0047
        L_0x0026:
            java.lang.String r6 = "urn:mpeg:dash:mp4protection:2011"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x0047
            r1 = 0
            goto L_0x0048
        L_0x0031:
            java.lang.String r6 = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x0047
            r1 = 2
            goto L_0x0048
        L_0x003c:
            java.lang.String r6 = "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x0047
            r1 = 1
            goto L_0x0048
        L_0x0047:
            r1 = -1
        L_0x0048:
            switch(r1) {
                case 0: goto L_0x0053;
                case 1: goto L_0x004f;
                case 2: goto L_0x004c;
                default: goto L_0x004b;
            }
        L_0x004b:
            goto L_0x0099
        L_0x004c:
            java.util.UUID r1 = com.google.android.exoplayer2.C1470C.WIDEVINE_UUID
            goto L_0x0051
        L_0x004f:
            java.util.UUID r1 = com.google.android.exoplayer2.C1470C.PLAYREADY_UUID
        L_0x0051:
            r5 = r2
            goto L_0x009b
        L_0x0053:
            java.lang.String r1 = "value"
            java.lang.String r1 = r0.getAttributeValue(r2, r1)
            java.lang.String r5 = "default_KID"
            java.lang.String r5 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValueIgnorePrefix(r0, r5)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0094
            java.lang.String r6 = "00000000-0000-0000-0000-000000000000"
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto L_0x0094
            java.lang.String r6 = "\\s+"
            java.lang.String[] r5 = r5.split(r6)
            int r6 = r5.length
            java.util.UUID[] r6 = new java.util.UUID[r6]
            r7 = 0
        L_0x0078:
            int r8 = r5.length
            if (r7 >= r8) goto L_0x0086
            r8 = r5[r7]
            java.util.UUID r8 = java.util.UUID.fromString(r8)
            r6[r7] = r8
            int r7 = r7 + 1
            goto L_0x0078
        L_0x0086:
            java.util.UUID r5 = com.google.android.exoplayer2.C1470C.COMMON_PSSH_UUID
            byte[] r5 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.buildPsshAtom(r5, r6, r2)
            java.util.UUID r6 = com.google.android.exoplayer2.C1470C.COMMON_PSSH_UUID
            r7 = r2
            r8 = 0
            r15 = r6
            r6 = r1
            r1 = r15
            goto L_0x009e
        L_0x0094:
            r6 = r1
            r1 = r2
            r5 = r1
            r7 = r5
            goto L_0x009d
        L_0x0099:
            r1 = r2
            r5 = r1
        L_0x009b:
            r6 = r5
            r7 = r6
        L_0x009d:
            r8 = 0
        L_0x009e:
            r17.next()
            java.lang.String r9 = "ms:laurl"
            boolean r9 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r0, r9)
            if (r9 == 0) goto L_0x00b5
            java.lang.String r7 = "licenseUrl"
            java.lang.String r7 = r0.getAttributeValue(r2, r7)
        L_0x00af:
            r10 = r1
            r13 = r5
        L_0x00b1:
            r11 = r7
            r14 = r8
            goto L_0x0128
        L_0x00b5:
            java.lang.String r9 = "widevine:license"
            boolean r9 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r0, r9)
            if (r9 == 0) goto L_0x00d2
            java.lang.String r8 = "robustness_level"
            java.lang.String r8 = r0.getAttributeValue(r2, r8)
            if (r8 == 0) goto L_0x00d0
            java.lang.String r9 = "HW"
            boolean r8 = r8.startsWith(r9)
            if (r8 == 0) goto L_0x00d0
            r8 = 1
            goto L_0x00af
        L_0x00d0:
            r8 = 0
            goto L_0x00af
        L_0x00d2:
            r9 = 4
            if (r5 != 0) goto L_0x00fd
            java.lang.String r10 = "pssh"
            boolean r10 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTagIgnorePrefix(r0, r10)
            if (r10 == 0) goto L_0x00fd
            int r10 = r17.next()
            if (r10 != r9) goto L_0x00fd
            java.lang.String r1 = r17.getText()
            byte[] r1 = android.util.Base64.decode(r1, r4)
            java.util.UUID r5 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.parseUuid(r1)
            if (r5 != 0) goto L_0x00fa
            java.lang.String r1 = "MpdParser"
            java.lang.String r9 = "Skipping malformed cenc:pssh data"
            com.google.android.exoplayer2.util.Log.m157w(r1, r9)
            r13 = r2
            goto L_0x00fb
        L_0x00fa:
            r13 = r1
        L_0x00fb:
            r10 = r5
            goto L_0x00b1
        L_0x00fd:
            if (r5 != 0) goto L_0x0124
            java.util.UUID r10 = com.google.android.exoplayer2.C1470C.PLAYREADY_UUID
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x0124
            java.lang.String r10 = "mspr:pro"
            boolean r10 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r0, r10)
            if (r10 == 0) goto L_0x0124
            int r10 = r17.next()
            if (r10 != r9) goto L_0x0124
            java.util.UUID r5 = com.google.android.exoplayer2.C1470C.PLAYREADY_UUID
            java.lang.String r9 = r17.getText()
            byte[] r9 = android.util.Base64.decode(r9, r4)
            byte[] r5 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.buildPsshAtom(r5, r9)
            goto L_0x00af
        L_0x0124:
            maybeSkipTag(r17)
            goto L_0x00af
        L_0x0128:
            java.lang.String r1 = "ContentProtection"
            boolean r1 = com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(r0, r1)
            if (r1 == 0) goto L_0x0142
            if (r10 == 0) goto L_0x013c
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r0 = new com.google.android.exoplayer2.drm.DrmInitData$SchemeData
            java.lang.String r12 = "video/mp4"
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14)
            goto L_0x013d
        L_0x013c:
            r0 = r2
        L_0x013d:
            android.util.Pair r0 = android.util.Pair.create(r6, r0)
            return r0
        L_0x0142:
            r1 = r10
            r7 = r11
            r5 = r13
            r8 = r14
            goto L_0x009e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseContentProtection(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    /* access modifiers changed from: protected */
    public int parseRole(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String parseString = parseString(xmlPullParser, "schemeIdUri", (String) null);
        String parseString2 = parseString(xmlPullParser, "value", (String) null);
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "Role"));
        return (!"urn:mpeg:dash:role:2011".equals(parseString) || !"main".equals(parseString2)) ? 0 : 1;
    }

    /* access modifiers changed from: protected */
    public void parseAdaptationSetChild(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        maybeSkipTag(xmlPullParser);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v8, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0143 A[LOOP:0: B:1:0x0059->B:40:0x0143, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0107 A[EDGE_INSN: B:41:0x0107->B:35:0x0107 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo parseRepresentation(org.xmlpull.v1.XmlPullParser r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, int r30, int r31, float r32, int r33, int r34, java.lang.String r35, int r36, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> r37, com.google.android.exoplayer2.source.dash.manifest.SegmentBase r38) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r24 = this;
            r15 = r24
            r0 = r25
            java.lang.String r1 = "id"
            r2 = 0
            java.lang.String r1 = r0.getAttributeValue(r2, r1)
            java.lang.String r3 = "bandwidth"
            r4 = -1
            int r9 = parseInt(r0, r3, r4)
            java.lang.String r3 = "mimeType"
            r4 = r28
            java.lang.String r3 = parseString(r0, r3, r4)
            java.lang.String r4 = "codecs"
            r5 = r29
            java.lang.String r13 = parseString(r0, r4, r5)
            java.lang.String r4 = "width"
            r5 = r30
            int r4 = parseInt(r0, r4, r5)
            java.lang.String r5 = "height"
            r6 = r31
            int r5 = parseInt(r0, r5, r6)
            r6 = r32
            float r6 = parseFrameRate(r0, r6)
            java.lang.String r7 = "audioSamplingRate"
            r8 = r34
            int r8 = parseInt(r0, r7, r8)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r7 = 0
            r16 = r33
            r10 = r38
            r17 = r2
            r2 = r26
        L_0x0059:
            r25.next()
            r18 = r13
            java.lang.String r13 = "BaseURL"
            boolean r13 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r0, r13)
            if (r13 == 0) goto L_0x0071
            if (r7 != 0) goto L_0x006d
            java.lang.String r2 = parseBaseUrl(r0, r2)
            r7 = 1
        L_0x006d:
            r19 = r2
            goto L_0x00fb
        L_0x0071:
            java.lang.String r13 = "AudioChannelConfiguration"
            boolean r13 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r0, r13)
            if (r13 == 0) goto L_0x0083
            int r13 = r24.parseAudioChannelConfiguration(r25)
            r19 = r2
            r16 = r13
            goto L_0x00fb
        L_0x0083:
            java.lang.String r13 = "SegmentBase"
            boolean r13 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r0, r13)
            if (r13 == 0) goto L_0x0092
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r10 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase) r10
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r10 = r15.parseSegmentBase(r0, r10)
            goto L_0x006d
        L_0x0092:
            java.lang.String r13 = "SegmentList"
            boolean r13 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r0, r13)
            if (r13 == 0) goto L_0x00a1
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r10 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList) r10
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r10 = r15.parseSegmentList(r0, r10)
            goto L_0x006d
        L_0x00a1:
            java.lang.String r13 = "SegmentTemplate"
            boolean r13 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r0, r13)
            if (r13 == 0) goto L_0x00b0
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r10 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate) r10
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r10 = r15.parseSegmentTemplate(r0, r10)
            goto L_0x006d
        L_0x00b0:
            java.lang.String r13 = "ContentProtection"
            boolean r13 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r0, r13)
            if (r13 == 0) goto L_0x00d2
            android.util.Pair r13 = r24.parseContentProtection(r25)
            r19 = r2
            java.lang.Object r2 = r13.first
            if (r2 == 0) goto L_0x00c8
            java.lang.Object r2 = r13.first
            r17 = r2
            java.lang.String r17 = (java.lang.String) r17
        L_0x00c8:
            java.lang.Object r2 = r13.second
            if (r2 == 0) goto L_0x00fb
            java.lang.Object r2 = r13.second
            r14.add(r2)
            goto L_0x00fb
        L_0x00d2:
            r19 = r2
            java.lang.String r2 = "InbandEventStream"
            boolean r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r0, r2)
            if (r2 == 0) goto L_0x00e6
            java.lang.String r2 = "InbandEventStream"
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r2 = parseDescriptor(r0, r2)
            r12.add(r2)
            goto L_0x00fb
        L_0x00e6:
            java.lang.String r2 = "SupplementalProperty"
            boolean r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r0, r2)
            if (r2 == 0) goto L_0x00f8
            java.lang.String r2 = "SupplementalProperty"
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r2 = parseDescriptor(r0, r2)
            r11.add(r2)
            goto L_0x00fb
        L_0x00f8:
            maybeSkipTag(r25)
        L_0x00fb:
            r20 = r17
            r17 = r10
            java.lang.String r2 = "Representation"
            boolean r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(r0, r2)
            if (r2 == 0) goto L_0x0143
            r0 = r24
            r2 = r27
            r7 = r16
            r10 = r35
            r21 = r11
            r11 = r36
            r22 = r12
            r12 = r37
            r13 = r18
            r23 = r14
            r14 = r21
            com.google.android.exoplayer2.Format r0 = r0.buildFormat(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            if (r17 == 0) goto L_0x0124
            goto L_0x012b
        L_0x0124:
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r1 = new com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase
            r1.<init>()
            r17 = r1
        L_0x012b:
            com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo r1 = new com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo
            r2 = -1
            r25 = r1
            r26 = r0
            r27 = r19
            r28 = r17
            r29 = r20
            r30 = r23
            r31 = r22
            r32 = r2
            r25.<init>(r26, r27, r28, r29, r30, r31, r32)
            return r1
        L_0x0143:
            r10 = r17
            r13 = r18
            r2 = r19
            r17 = r20
            goto L_0x0059
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseRepresentation(org.xmlpull.v1.XmlPullParser, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, int, java.util.List, com.google.android.exoplayer2.source.dash.manifest.SegmentBase):com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo");
    }

    /* access modifiers changed from: protected */
    public Format buildFormat(String str, String str2, String str3, int i, int i2, float f, int i3, int i4, int i5, String str4, int i6, List<Descriptor> list, String str5, List<Descriptor> list2) {
        String str6;
        int i7;
        int parseCea708AccessibilityChannel;
        String str7 = str3;
        String sampleMimeType = getSampleMimeType(str3, str5);
        if (sampleMimeType != null) {
            if (MimeTypes.AUDIO_E_AC3.equals(sampleMimeType)) {
                sampleMimeType = parseEac3SupplementalProperties(list2);
            }
            str6 = sampleMimeType;
            if (MimeTypes.isVideo(str6)) {
                return Format.createVideoContainerFormat(str, str2, str3, str6, str5, i5, i, i2, f, (List<byte[]>) null, i6);
            }
            if (MimeTypes.isAudio(str6)) {
                return Format.createAudioContainerFormat(str, str2, str3, str6, str5, i5, i3, i4, (List<byte[]>) null, i6, str4);
            }
            if (mimeTypeIsRawText(str6)) {
                if (MimeTypes.APPLICATION_CEA608.equals(str6)) {
                    parseCea708AccessibilityChannel = parseCea608AccessibilityChannel(list);
                } else if (MimeTypes.APPLICATION_CEA708.equals(str6)) {
                    parseCea708AccessibilityChannel = parseCea708AccessibilityChannel(list);
                } else {
                    i7 = -1;
                    return Format.createTextContainerFormat(str, str2, str3, str6, str5, i5, i6, str4, i7);
                }
                i7 = parseCea708AccessibilityChannel;
                return Format.createTextContainerFormat(str, str2, str3, str6, str5, i5, i6, str4, i7);
            }
        } else {
            str6 = sampleMimeType;
        }
        return Format.createContainerFormat(str, str2, str3, str6, str5, i5, i6, str4);
    }

    /* access modifiers changed from: protected */
    public Representation buildRepresentation(RepresentationInfo representationInfo, String str, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2) {
        Format format = representationInfo.format;
        if (representationInfo.drmSchemeType != null) {
            str2 = representationInfo.drmSchemeType;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = representationInfo.drmSchemeDatas;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            filterRedundantIncompleteSchemeDatas(arrayList3);
            format = format.copyWithDrmInitData(new DrmInitData(str2, (List<DrmInitData.SchemeData>) arrayList3));
        }
        ArrayList<Descriptor> arrayList4 = representationInfo.inbandEventStreams;
        arrayList4.addAll(arrayList2);
        return Representation.newInstance(str, representationInfo.revisionId, format, representationInfo.baseUrl, representationInfo.segmentBase, arrayList4);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SingleSegmentBase parseSegmentBase(XmlPullParser xmlPullParser, SegmentBase.SingleSegmentBase singleSegmentBase) throws XmlPullParserException, IOException {
        long j;
        long j2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SingleSegmentBase singleSegmentBase2 = singleSegmentBase;
        long parseLong = parseLong(xmlPullParser2, "timescale", singleSegmentBase2 != null ? singleSegmentBase2.timescale : 1);
        long j3 = 0;
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", singleSegmentBase2 != null ? singleSegmentBase2.presentationTimeOffset : 0);
        long j4 = singleSegmentBase2 != null ? singleSegmentBase2.indexStart : 0;
        if (singleSegmentBase2 != null) {
            j3 = singleSegmentBase2.indexLength;
        }
        RangedUri rangedUri = null;
        String attributeValue = xmlPullParser2.getAttributeValue((String) null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            j2 = Long.parseLong(split[0]);
            j = (Long.parseLong(split[1]) - j2) + 1;
        } else {
            j = j3;
            j2 = j4;
        }
        if (singleSegmentBase2 != null) {
            rangedUri = singleSegmentBase2.initialization;
        }
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentBase"));
        return buildSingleSegmentBase(rangedUri, parseLong, parseLong2, j2, j);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SingleSegmentBase buildSingleSegmentBase(RangedUri rangedUri, long j, long j2, long j3, long j4) {
        return new SegmentBase.SingleSegmentBase(rangedUri, j, j2, j3, j4);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentList parseSegmentList(XmlPullParser xmlPullParser, SegmentBase.SegmentList segmentList) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SegmentList segmentList2 = segmentList;
        long j = 1;
        long parseLong = parseLong(xmlPullParser2, "timescale", segmentList2 != null ? segmentList2.timescale : 1);
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", segmentList2 != null ? segmentList2.presentationTimeOffset : 0);
        long parseLong3 = parseLong(xmlPullParser2, "duration", segmentList2 != null ? segmentList2.duration : C1470C.TIME_UNSET);
        if (segmentList2 != null) {
            j = segmentList2.startNumber;
        }
        long parseLong4 = parseLong(xmlPullParser2, "startNumber", j);
        List list = null;
        RangedUri rangedUri = null;
        List<SegmentBase.SegmentTimelineElement> list2 = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTimeline")) {
                list2 = parseSegmentTimeline(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentURL")) {
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(parseSegmentUrl(xmlPullParser));
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentList"));
        if (segmentList2 != null) {
            if (rangedUri == null) {
                rangedUri = segmentList2.initialization;
            }
            if (list2 == null) {
                list2 = segmentList2.segmentTimeline;
            }
            if (list == null) {
                list = segmentList2.mediaSegments;
            }
        }
        return buildSegmentList(rangedUri, parseLong, parseLong2, parseLong4, parseLong3, list2, list);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentList buildSegmentList(RangedUri rangedUri, long j, long j2, long j3, long j4, List<SegmentBase.SegmentTimelineElement> list, List<RangedUri> list2) {
        return new SegmentBase.SegmentList(rangedUri, j, j2, j3, j4, list, list2);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentTemplate parseSegmentTemplate(XmlPullParser xmlPullParser, SegmentBase.SegmentTemplate segmentTemplate) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SegmentTemplate segmentTemplate2 = segmentTemplate;
        long j = 1;
        long parseLong = parseLong(xmlPullParser2, "timescale", segmentTemplate2 != null ? segmentTemplate2.timescale : 1);
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", segmentTemplate2 != null ? segmentTemplate2.presentationTimeOffset : 0);
        long parseLong3 = parseLong(xmlPullParser2, "duration", segmentTemplate2 != null ? segmentTemplate2.duration : C1470C.TIME_UNSET);
        if (segmentTemplate2 != null) {
            j = segmentTemplate2.startNumber;
        }
        long parseLong4 = parseLong(xmlPullParser2, "startNumber", j);
        RangedUri rangedUri = null;
        UrlTemplate parseUrlTemplate = parseUrlTemplate(xmlPullParser2, "media", segmentTemplate2 != null ? segmentTemplate2.mediaTemplate : null);
        UrlTemplate parseUrlTemplate2 = parseUrlTemplate(xmlPullParser2, "initialization", segmentTemplate2 != null ? segmentTemplate2.initializationTemplate : null);
        List<SegmentBase.SegmentTimelineElement> list = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTimeline")) {
                list = parseSegmentTimeline(xmlPullParser);
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentTemplate"));
        if (segmentTemplate2 != null) {
            if (rangedUri == null) {
                rangedUri = segmentTemplate2.initialization;
            }
            if (list == null) {
                list = segmentTemplate2.segmentTimeline;
            }
        }
        return buildSegmentTemplate(rangedUri, parseLong, parseLong2, parseLong4, parseLong3, list, parseUrlTemplate2, parseUrlTemplate);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentTemplate buildSegmentTemplate(RangedUri rangedUri, long j, long j2, long j3, long j4, List<SegmentBase.SegmentTimelineElement> list, UrlTemplate urlTemplate, UrlTemplate urlTemplate2) {
        return new SegmentBase.SegmentTemplate(rangedUri, j, j2, j3, j4, list, urlTemplate, urlTemplate2);
    }

    /* access modifiers changed from: protected */
    public EventStream parseEventStream(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String parseString = parseString(xmlPullParser, "schemeIdUri", "");
        String parseString2 = parseString(xmlPullParser, "value", "");
        long parseLong = parseLong(xmlPullParser, "timescale", 1);
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Event")) {
                arrayList.add(parseEvent(xmlPullParser, parseString, parseString2, parseLong, byteArrayOutputStream));
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "EventStream"));
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            EventMessage eventMessage = (EventMessage) arrayList.get(i);
            jArr[i] = eventMessage.presentationTimeUs;
            eventMessageArr[i] = eventMessage;
        }
        return buildEventStream(parseString, parseString2, parseLong, jArr, eventMessageArr);
    }

    /* access modifiers changed from: protected */
    public EventStream buildEventStream(String str, String str2, long j, long[] jArr, EventMessage[] eventMessageArr) {
        return new EventStream(str, str2, j, jArr, eventMessageArr);
    }

    /* access modifiers changed from: protected */
    public EventMessage parseEvent(XmlPullParser xmlPullParser, String str, String str2, long j, ByteArrayOutputStream byteArrayOutputStream) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long parseLong = parseLong(xmlPullParser2, "id", 0);
        long parseLong2 = parseLong(xmlPullParser2, "duration", C1470C.TIME_UNSET);
        long parseLong3 = parseLong(xmlPullParser2, "presentationTime", 0);
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(parseLong2, 1000, j);
        long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(parseLong3, 1000000, j);
        String parseString = parseString(xmlPullParser2, "messageData", (String) null);
        byte[] parseEventObject = parseEventObject(xmlPullParser2, byteArrayOutputStream);
        if (parseString != null) {
            parseEventObject = Util.getUtf8Bytes(parseString);
        }
        return buildEvent(str, str2, parseLong, scaleLargeTimestamp, parseEventObject, scaleLargeTimestamp2);
    }

    /* access modifiers changed from: protected */
    public byte[] parseEventObject(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, "UTF-8");
        xmlPullParser.nextToken();
        while (!XmlPullParserUtil.isEndTag(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    newSerializer.startDocument((String) null, false);
                    break;
                case 1:
                    newSerializer.endDocument();
                    break;
                case 2:
                    newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                        newSerializer.attribute(xmlPullParser.getAttributeNamespace(i), xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
                    }
                    break;
                case 3:
                    newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    newSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    newSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    newSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    newSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    newSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    newSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    newSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        newSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* access modifiers changed from: protected */
    public EventMessage buildEvent(String str, String str2, long j, long j2, byte[] bArr, long j3) {
        return new EventMessage(str, str2, j2, j, bArr, j3);
    }

    /* access modifiers changed from: protected */
    public List<SegmentBase.SegmentTimelineElement> parseSegmentTimeline(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long j = 0;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, ExifInterface.LATITUDE_SOUTH)) {
                j = parseLong(xmlPullParser, "t", j);
                long parseLong = parseLong(xmlPullParser, "d", C1470C.TIME_UNSET);
                int parseInt = parseInt(xmlPullParser, "r", 0) + 1;
                for (int i = 0; i < parseInt; i++) {
                    arrayList.add(buildSegmentTimelineElement(j, parseLong));
                    j += parseLong;
                }
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentTimeline"));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentTimelineElement buildSegmentTimelineElement(long j, long j2) {
        return new SegmentBase.SegmentTimelineElement(j, j2);
    }

    /* access modifiers changed from: protected */
    public UrlTemplate parseUrlTemplate(XmlPullParser xmlPullParser, String str, UrlTemplate urlTemplate) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue != null ? UrlTemplate.compile(attributeValue) : urlTemplate;
    }

    /* access modifiers changed from: protected */
    public RangedUri parseInitialization(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "sourceURL", "range");
    }

    /* access modifiers changed from: protected */
    public RangedUri parseSegmentUrl(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "media", "mediaRange");
    }

    /* access modifiers changed from: protected */
    public RangedUri parseRangedUrl(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j2 = Long.parseLong(split[0]);
            if (split.length == 2) {
                j = (Long.parseLong(split[1]) - j2) + 1;
                return buildRangedUri(attributeValue, j2, j);
            }
        } else {
            j2 = 0;
        }
        j = -1;
        return buildRangedUri(attributeValue, j2, j);
    }

    /* access modifiers changed from: protected */
    public RangedUri buildRangedUri(String str, long j, long j2) {
        return new RangedUri(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public ProgramInformation parseProgramInformation(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String str = null;
        String parseString = parseString(xmlPullParser, "moreInformationURL", (String) null);
        String parseString2 = parseString(xmlPullParser, "lang", (String) null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, ExifInterface.TAG_COPYRIGHT)) {
                str3 = xmlPullParser.nextText();
            } else {
                maybeSkipTag(xmlPullParser);
            }
            String str4 = str3;
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "ProgramInformation")) {
                return new ProgramInformation(str, str2, str4, parseString, parseString2);
            }
            str3 = str4;
        }
    }

    /* access modifiers changed from: protected */
    public int parseAudioChannelConfiguration(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String parseString = parseString(xmlPullParser, "schemeIdUri", (String) null);
        int i = -1;
        if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(parseString)) {
            i = parseInt(xmlPullParser, "value", -1);
        } else if ("tag:dolby.com,2014:dash:audio_channel_configuration:2011".equals(parseString)) {
            i = parseDolbyChannelConfiguration(xmlPullParser);
        }
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "AudioChannelConfiguration"));
        return i;
    }

    public static void maybeSkipTag(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
            int i = 1;
            while (i != 0) {
                xmlPullParser.next();
                if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
                    i++;
                } else if (XmlPullParserUtil.isEndTag(xmlPullParser)) {
                    i--;
                }
            }
        }
    }

    private static void filterRedundantIncompleteSchemeDatas(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.hasData()) {
                int i = 0;
                while (true) {
                    if (i >= arrayList.size()) {
                        break;
                    } else if (arrayList.get(i).canReplace(schemeData)) {
                        arrayList.remove(size);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
    }

    private static String getSampleMimeType(String str, String str2) {
        if (MimeTypes.isAudio(str)) {
            return MimeTypes.getAudioMediaMimeType(str2);
        }
        if (MimeTypes.isVideo(str)) {
            return MimeTypes.getVideoMediaMimeType(str2);
        }
        if (mimeTypeIsRawText(str)) {
            return str;
        }
        if (!MimeTypes.APPLICATION_MP4.equals(str)) {
            if (MimeTypes.APPLICATION_RAWCC.equals(str) && str2 != null) {
                if (str2.contains("cea708")) {
                    return MimeTypes.APPLICATION_CEA708;
                }
                if (str2.contains("eia608") || str2.contains("cea608")) {
                    return MimeTypes.APPLICATION_CEA608;
                }
            }
            return null;
        } else if (str2 != null) {
            if (str2.startsWith("stpp")) {
                return MimeTypes.APPLICATION_TTML;
            }
            if (str2.startsWith("wvtt")) {
                return MimeTypes.APPLICATION_MP4VTT;
            }
        }
        return null;
    }

    private static boolean mimeTypeIsRawText(String str) {
        return MimeTypes.isText(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_CEA608.equals(str);
    }

    private static String checkLanguageConsistency(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        Assertions.checkState(str.equals(str2));
        return str;
    }

    private static int checkContentTypeConsistency(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        Assertions.checkState(i == i2);
        return i;
    }

    protected static Descriptor parseDescriptor(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String parseString = parseString(xmlPullParser, "schemeIdUri", "");
        String parseString2 = parseString(xmlPullParser, "value", (String) null);
        String parseString3 = parseString(xmlPullParser, "id", (String) null);
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, str));
        return new Descriptor(parseString, parseString2, parseString3);
    }

    protected static int parseCea608AccessibilityChannel(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri) && descriptor.value != null) {
                Matcher matcher = CEA_608_ACCESSIBILITY_PATTERN.matcher(descriptor.value);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.m157w(TAG, "Unable to parse CEA-608 channel number from: " + descriptor.value);
            }
        }
        return -1;
    }

    protected static int parseCea708AccessibilityChannel(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.schemeIdUri) && descriptor.value != null) {
                Matcher matcher = CEA_708_ACCESSIBILITY_PATTERN.matcher(descriptor.value);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.m157w(TAG, "Unable to parse CEA-708 service block number from: " + descriptor.value);
            }
        }
        return -1;
    }

    protected static String parseEac3SupplementalProperties(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = list.get(i);
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(descriptor.schemeIdUri) && "ec+3".equals(descriptor.value)) {
                return MimeTypes.AUDIO_E_AC3_JOC;
            }
        }
        return MimeTypes.AUDIO_E_AC3;
    }

    protected static float parseFrameRate(XmlPullParser xmlPullParser, float f) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "frameRate");
        if (attributeValue == null) {
            return f;
        }
        Matcher matcher = FRAME_RATE_PATTERN.matcher(attributeValue);
        if (!matcher.matches()) {
            return f;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        String group = matcher.group(2);
        return !TextUtils.isEmpty(group) ? ((float) parseInt) / ((float) Integer.parseInt(group)) : (float) parseInt;
    }

    protected static long parseDuration(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return j;
        }
        return Util.parseXsDuration(attributeValue);
    }

    protected static long parseDateTime(XmlPullParser xmlPullParser, String str, long j) throws ParserException {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return j;
        }
        return Util.parseXsDateTime(attributeValue);
    }

    protected static String parseBaseUrl(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        xmlPullParser.next();
        return UriUtil.resolve(str, xmlPullParser.getText());
    }

    protected static int parseInt(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    protected static long parseLong(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? j : Long.parseLong(attributeValue);
    }

    protected static String parseString(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0058 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static int parseDolbyChannelConfiguration(org.xmlpull.v1.XmlPullParser r5) {
        /*
            java.lang.String r0 = "value"
            r1 = 0
            java.lang.String r5 = r5.getAttributeValue(r1, r0)
            java.lang.String r5 = com.google.android.exoplayer2.util.Util.toLowerInvariant(r5)
            r0 = -1
            if (r5 != 0) goto L_0x0010
            return r0
        L_0x0010:
            int r1 = r5.hashCode()
            r2 = 1596796(0x185d7c, float:2.237588E-39)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x0049
            r2 = 2937391(0x2cd22f, float:4.116161E-39)
            if (r1 == r2) goto L_0x003f
            r2 = 3094035(0x2f3613, float:4.335666E-39)
            if (r1 == r2) goto L_0x0035
            r2 = 3133436(0x2fcffc, float:4.390879E-39)
            if (r1 == r2) goto L_0x002b
            goto L_0x0053
        L_0x002b:
            java.lang.String r1 = "fa01"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x0053
            r5 = 3
            goto L_0x0054
        L_0x0035:
            java.lang.String r1 = "f801"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x0053
            r5 = 2
            goto L_0x0054
        L_0x003f:
            java.lang.String r1 = "a000"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x0053
            r5 = 1
            goto L_0x0054
        L_0x0049:
            java.lang.String r1 = "4000"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x0053
            r5 = 0
            goto L_0x0054
        L_0x0053:
            r5 = -1
        L_0x0054:
            switch(r5) {
                case 0: goto L_0x005e;
                case 1: goto L_0x005d;
                case 2: goto L_0x005b;
                case 3: goto L_0x0058;
                default: goto L_0x0057;
            }
        L_0x0057:
            return r0
        L_0x0058:
            r5 = 8
            return r5
        L_0x005b:
            r5 = 6
            return r5
        L_0x005d:
            return r3
        L_0x005e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseDolbyChannelConfiguration(org.xmlpull.v1.XmlPullParser):int");
    }

    protected static final class RepresentationInfo {
        public final String baseUrl;
        public final ArrayList<DrmInitData.SchemeData> drmSchemeDatas;
        public final String drmSchemeType;
        public final Format format;
        public final ArrayList<Descriptor> inbandEventStreams;
        public final long revisionId;
        public final SegmentBase segmentBase;

        public RepresentationInfo(Format format2, String str, SegmentBase segmentBase2, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2, long j) {
            this.format = format2;
            this.baseUrl = str;
            this.segmentBase = segmentBase2;
            this.drmSchemeType = str2;
            this.drmSchemeDatas = arrayList;
            this.inbandEventStreams = arrayList2;
            this.revisionId = j;
        }
    }
}
