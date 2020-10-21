package org.apache.commons.lang3.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.p032io.IOUtils;

public class FastDateParser implements DateParser, Serializable {
    private static final Strategy ABBREVIATED_YEAR_STRATEGY = new NumberStrategy(1) {
        /* access modifiers changed from: package-private */
        public int modify(FastDateParser fastDateParser, int i) {
            return i < 100 ? fastDateParser.adjustYear(i) : i;
        }
    };
    private static final Strategy DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
    private static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
    private static final Strategy DAY_OF_WEEK_STRATEGY = new NumberStrategy(7) {
        /* access modifiers changed from: package-private */
        public int modify(FastDateParser fastDateParser, int i) {
            if (i == 7) {
                return 1;
            }
            return 1 + i;
        }
    };
    private static final Strategy DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
    private static final Strategy HOUR12_STRATEGY = new NumberStrategy(10) {
        /* access modifiers changed from: package-private */
        public int modify(FastDateParser fastDateParser, int i) {
            if (i == 12) {
                return 0;
            }
            return i;
        }
    };
    private static final Strategy HOUR24_OF_DAY_STRATEGY = new NumberStrategy(11) {
        /* access modifiers changed from: package-private */
        public int modify(FastDateParser fastDateParser, int i) {
            if (i == 24) {
                return 0;
            }
            return i;
        }
    };
    private static final Strategy HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
    private static final Strategy HOUR_STRATEGY = new NumberStrategy(10);
    static final Locale JAPANESE_IMPERIAL = new Locale("ja", "JP", "JP");
    private static final Strategy LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
    /* access modifiers changed from: private */
    public static final Comparator<String> LONGER_FIRST_LOWERCASE = new Comparator<String>() {
        public int compare(String str, String str2) {
            return str2.compareTo(str);
        }
    };
    private static final Strategy MILLISECOND_STRATEGY = new NumberStrategy(14);
    private static final Strategy MINUTE_STRATEGY = new NumberStrategy(12);
    private static final Strategy NUMBER_MONTH_STRATEGY = new NumberStrategy(2) {
        /* access modifiers changed from: package-private */
        public int modify(FastDateParser fastDateParser, int i) {
            return i - 1;
        }
    };
    private static final Strategy SECOND_STRATEGY = new NumberStrategy(13);
    private static final Strategy WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
    private static final Strategy WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
    private static final ConcurrentMap<Locale, Strategy>[] caches = new ConcurrentMap[17];
    private static final long serialVersionUID = 3;
    private final int century;
    private final Locale locale;
    /* access modifiers changed from: private */
    public final String pattern;
    private transient List<StrategyAndWidth> patterns;
    private final int startYear;
    private final TimeZone timeZone;

    /* access modifiers changed from: private */
    public static boolean isFormatLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    protected FastDateParser(String str, TimeZone timeZone2, Locale locale2) {
        this(str, timeZone2, locale2, (Date) null);
    }

    protected FastDateParser(String str, TimeZone timeZone2, Locale locale2, Date date) {
        int i;
        this.pattern = str;
        this.timeZone = timeZone2;
        this.locale = locale2;
        Calendar instance = Calendar.getInstance(timeZone2, locale2);
        if (date != null) {
            instance.setTime(date);
            i = instance.get(1);
        } else if (locale2.equals(JAPANESE_IMPERIAL)) {
            i = 0;
        } else {
            instance.setTime(new Date());
            i = instance.get(1) - 80;
        }
        this.century = (i / 100) * 100;
        this.startYear = i - this.century;
        init(instance);
    }

    private void init(Calendar calendar) {
        this.patterns = new ArrayList();
        StrategyParser strategyParser = new StrategyParser(calendar);
        while (true) {
            StrategyAndWidth nextStrategy = strategyParser.getNextStrategy();
            if (nextStrategy != null) {
                this.patterns.add(nextStrategy);
            } else {
                return;
            }
        }
    }

    private static class StrategyAndWidth {
        final Strategy strategy;
        final int width;

        StrategyAndWidth(Strategy strategy2, int i) {
            this.strategy = strategy2;
            this.width = i;
        }

        /* access modifiers changed from: package-private */
        public int getMaxWidth(ListIterator<StrategyAndWidth> listIterator) {
            if (!this.strategy.isNumber() || !listIterator.hasNext()) {
                return 0;
            }
            Strategy strategy2 = listIterator.next().strategy;
            listIterator.previous();
            if (strategy2.isNumber()) {
                return this.width;
            }
            return 0;
        }
    }

    private class StrategyParser {
        private int currentIdx;
        private final Calendar definingCalendar;

        StrategyParser(Calendar calendar) {
            this.definingCalendar = calendar;
        }

        /* access modifiers changed from: package-private */
        public StrategyAndWidth getNextStrategy() {
            if (this.currentIdx >= FastDateParser.this.pattern.length()) {
                return null;
            }
            char charAt = FastDateParser.this.pattern.charAt(this.currentIdx);
            if (FastDateParser.isFormatLetter(charAt)) {
                return letterPattern(charAt);
            }
            return literal();
        }

        private StrategyAndWidth letterPattern(char c) {
            int i = this.currentIdx;
            do {
                int i2 = this.currentIdx + 1;
                this.currentIdx = i2;
                if (i2 >= FastDateParser.this.pattern.length() || FastDateParser.this.pattern.charAt(this.currentIdx) != c) {
                    int i3 = this.currentIdx - i;
                }
                int i22 = this.currentIdx + 1;
                this.currentIdx = i22;
                break;
            } while (FastDateParser.this.pattern.charAt(this.currentIdx) != c);
            int i32 = this.currentIdx - i;
            return new StrategyAndWidth(FastDateParser.this.getStrategy(c, i32, this.definingCalendar), i32);
        }

        private StrategyAndWidth literal() {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            while (this.currentIdx < FastDateParser.this.pattern.length()) {
                char charAt = FastDateParser.this.pattern.charAt(this.currentIdx);
                if (!z && FastDateParser.isFormatLetter(charAt)) {
                    break;
                }
                if (charAt == '\'') {
                    int i = this.currentIdx + 1;
                    this.currentIdx = i;
                    if (i == FastDateParser.this.pattern.length() || FastDateParser.this.pattern.charAt(this.currentIdx) != '\'') {
                        z = !z;
                    }
                }
                this.currentIdx++;
                sb.append(charAt);
            }
            if (!z) {
                String sb2 = sb.toString();
                return new StrategyAndWidth(new CopyQuotedStrategy(sb2), sb2.length());
            }
            throw new IllegalArgumentException("Unterminated quote");
        }
    }

    public String getPattern() {
        return this.pattern;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateParser)) {
            return false;
        }
        FastDateParser fastDateParser = (FastDateParser) obj;
        if (!this.pattern.equals(fastDateParser.pattern) || !this.timeZone.equals(fastDateParser.timeZone) || !this.locale.equals(fastDateParser.locale)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.pattern.hashCode() + ((this.timeZone.hashCode() + (this.locale.hashCode() * 13)) * 13);
    }

    public String toString() {
        return "FastDateParser[" + this.pattern + "," + this.locale + "," + this.timeZone.getID() + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(Calendar.getInstance(this.timeZone, this.locale));
    }

    public Object parseObject(String str) throws ParseException {
        return parse(str);
    }

    public Date parse(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = parse(str, parsePosition);
        if (parse != null) {
            return parse;
        }
        if (this.locale.equals(JAPANESE_IMPERIAL)) {
            throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\nUnparseable date: \"" + str, parsePosition.getErrorIndex());
        }
        throw new ParseException("Unparseable date: " + str, parsePosition.getErrorIndex());
    }

    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    public Date parse(String str, ParsePosition parsePosition) {
        Calendar instance = Calendar.getInstance(this.timeZone, this.locale);
        instance.clear();
        if (parse(str, parsePosition, instance)) {
            return instance.getTime();
        }
        return null;
    }

    public boolean parse(String str, ParsePosition parsePosition, Calendar calendar) {
        ListIterator<StrategyAndWidth> listIterator = this.patterns.listIterator();
        while (listIterator.hasNext()) {
            StrategyAndWidth next = listIterator.next();
            if (!next.strategy.parse(this, calendar, str, parsePosition, next.getMaxWidth(listIterator))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static StringBuilder simpleQuote(StringBuilder sb, String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '$':
                case '(':
                case ')':
                case '*':
                case '+':
                case '.':
                case '?':
                case '[':
                case '\\':
                case '^':
                case '{':
                case '|':
                    sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                    break;
            }
            sb.append(charAt);
        }
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.append('?');
        }
        return sb;
    }

    /* access modifiers changed from: private */
    public static Map<String, Integer> appendDisplayNames(Calendar calendar, Locale locale2, int i, StringBuilder sb) {
        HashMap hashMap = new HashMap();
        Map<String, Integer> displayNames = calendar.getDisplayNames(i, 0, locale2);
        TreeSet treeSet = new TreeSet(LONGER_FIRST_LOWERCASE);
        for (Map.Entry next : displayNames.entrySet()) {
            String lowerCase = ((String) next.getKey()).toLowerCase(locale2);
            if (treeSet.add(lowerCase)) {
                hashMap.put(lowerCase, (Integer) next.getValue());
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            simpleQuote(sb, (String) it.next()).append('|');
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public int adjustYear(int i) {
        int i2 = this.century + i;
        return i >= this.startYear ? i2 : i2 + 100;
    }

    private static abstract class Strategy {
        /* access modifiers changed from: package-private */
        public boolean isNumber() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i);

        private Strategy() {
        }
    }

    private static abstract class PatternStrategy extends Strategy {
        private Pattern pattern;

        /* access modifiers changed from: package-private */
        public boolean isNumber() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str);

        private PatternStrategy() {
            super();
        }

        /* access modifiers changed from: package-private */
        public void createPattern(StringBuilder sb) {
            createPattern(sb.toString());
        }

        /* access modifiers changed from: package-private */
        public void createPattern(String str) {
            this.pattern = Pattern.compile(str);
        }

        /* access modifiers changed from: package-private */
        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i) {
            Matcher matcher = this.pattern.matcher(str.substring(parsePosition.getIndex()));
            if (!matcher.lookingAt()) {
                parsePosition.setErrorIndex(parsePosition.getIndex());
                return false;
            }
            parsePosition.setIndex(parsePosition.getIndex() + matcher.end(1));
            setCalendar(fastDateParser, calendar, matcher.group(1));
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0063, code lost:
        return getLocaleSpecificStrategy(15, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0064, code lost:
        if (r3 <= 2) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return ABBREVIATED_YEAR_STRATEGY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return LITERAL_YEAR_STRATEGY;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.commons.lang3.time.FastDateParser.Strategy getStrategy(char r2, int r3, java.util.Calendar r4) {
        /*
            r1 = this;
            switch(r2) {
                case 68: goto L_0x0086;
                case 69: goto L_0x0080;
                case 70: goto L_0x007d;
                case 71: goto L_0x0077;
                case 72: goto L_0x0074;
                default: goto L_0x0003;
            }
        L_0x0003:
            r0 = 2
            switch(r2) {
                case 87: goto L_0x0071;
                case 88: goto L_0x006c;
                case 89: goto L_0x0064;
                case 90: goto L_0x0056;
                default: goto L_0x0007;
            }
        L_0x0007:
            switch(r2) {
                case 121: goto L_0x0064;
                case 122: goto L_0x005d;
                default: goto L_0x000a;
            }
        L_0x000a:
            switch(r2) {
                case 75: goto L_0x0053;
                case 77: goto L_0x0048;
                case 83: goto L_0x0045;
                case 97: goto L_0x003e;
                case 100: goto L_0x003b;
                case 104: goto L_0x0038;
                case 107: goto L_0x0035;
                case 109: goto L_0x0032;
                case 115: goto L_0x002f;
                case 117: goto L_0x002c;
                case 119: goto L_0x0029;
                default: goto L_0x000d;
            }
        L_0x000d:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Format '"
            r4.append(r0)
            r4.append(r2)
            java.lang.String r2 = "' not supported"
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2)
            throw r3
        L_0x0029:
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = WEEK_OF_YEAR_STRATEGY
            return r2
        L_0x002c:
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = DAY_OF_WEEK_STRATEGY
            return r2
        L_0x002f:
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = SECOND_STRATEGY
            return r2
        L_0x0032:
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = MINUTE_STRATEGY
            return r2
        L_0x0035:
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = HOUR24_OF_DAY_STRATEGY
            return r2
        L_0x0038:
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = HOUR12_STRATEGY
            return r2
        L_0x003b:
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = DAY_OF_MONTH_STRATEGY
            return r2
        L_0x003e:
            r2 = 9
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = r1.getLocaleSpecificStrategy(r2, r4)
            return r2
        L_0x0045:
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = MILLISECOND_STRATEGY
            return r2
        L_0x0048:
            r2 = 3
            if (r3 < r2) goto L_0x0050
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = r1.getLocaleSpecificStrategy(r0, r4)
            goto L_0x0052
        L_0x0050:
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = NUMBER_MONTH_STRATEGY
        L_0x0052:
            return r2
        L_0x0053:
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = HOUR_STRATEGY
            return r2
        L_0x0056:
            if (r3 != r0) goto L_0x005d
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = org.apache.commons.lang3.time.FastDateParser.ISO8601TimeZoneStrategy.ISO_8601_3_STRATEGY
            return r2
        L_0x005d:
            r2 = 15
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = r1.getLocaleSpecificStrategy(r2, r4)
            return r2
        L_0x0064:
            if (r3 <= r0) goto L_0x0069
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = LITERAL_YEAR_STRATEGY
            goto L_0x006b
        L_0x0069:
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = ABBREVIATED_YEAR_STRATEGY
        L_0x006b:
            return r2
        L_0x006c:
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = org.apache.commons.lang3.time.FastDateParser.ISO8601TimeZoneStrategy.getStrategy(r3)
            return r2
        L_0x0071:
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = WEEK_OF_MONTH_STRATEGY
            return r2
        L_0x0074:
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = HOUR_OF_DAY_STRATEGY
            return r2
        L_0x0077:
            r2 = 0
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = r1.getLocaleSpecificStrategy(r2, r4)
            return r2
        L_0x007d:
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = DAY_OF_WEEK_IN_MONTH_STRATEGY
            return r2
        L_0x0080:
            r2 = 7
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = r1.getLocaleSpecificStrategy(r2, r4)
            return r2
        L_0x0086:
            org.apache.commons.lang3.time.FastDateParser$Strategy r2 = DAY_OF_YEAR_STRATEGY
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.FastDateParser.getStrategy(char, int, java.util.Calendar):org.apache.commons.lang3.time.FastDateParser$Strategy");
    }

    private static ConcurrentMap<Locale, Strategy> getCache(int i) {
        ConcurrentMap<Locale, Strategy> concurrentMap;
        synchronized (caches) {
            if (caches[i] == null) {
                caches[i] = new ConcurrentHashMap(3);
            }
            concurrentMap = caches[i];
        }
        return concurrentMap;
    }

    private Strategy getLocaleSpecificStrategy(int i, Calendar calendar) {
        ConcurrentMap<Locale, Strategy> cache = getCache(i);
        Strategy strategy = (Strategy) cache.get(this.locale);
        if (strategy == null) {
            if (i == 15) {
                strategy = new TimeZoneStrategy(this.locale);
            } else {
                strategy = new CaseInsensitiveTextStrategy(i, calendar, this.locale);
            }
            Strategy putIfAbsent = cache.putIfAbsent(this.locale, strategy);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
        }
        return strategy;
    }

    private static class CopyQuotedStrategy extends Strategy {
        private final String formatField;

        /* access modifiers changed from: package-private */
        public boolean isNumber() {
            return false;
        }

        CopyQuotedStrategy(String str) {
            super();
            this.formatField = str;
        }

        /* access modifiers changed from: package-private */
        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i) {
            int i2 = 0;
            while (i2 < this.formatField.length()) {
                int index = parsePosition.getIndex() + i2;
                if (index == str.length()) {
                    parsePosition.setErrorIndex(index);
                    return false;
                } else if (this.formatField.charAt(i2) != str.charAt(index)) {
                    parsePosition.setErrorIndex(index);
                    return false;
                } else {
                    i2++;
                }
            }
            parsePosition.setIndex(this.formatField.length() + parsePosition.getIndex());
            return true;
        }
    }

    private static class CaseInsensitiveTextStrategy extends PatternStrategy {
        private final int field;
        private final Map<String, Integer> lKeyValues;
        final Locale locale;

        CaseInsensitiveTextStrategy(int i, Calendar calendar, Locale locale2) {
            super();
            this.field = i;
            this.locale = locale2;
            StringBuilder sb = new StringBuilder();
            sb.append("((?iu)");
            this.lKeyValues = FastDateParser.appendDisplayNames(calendar, locale2, i, sb);
            sb.setLength(sb.length() - 1);
            sb.append(")");
            createPattern(sb);
        }

        /* access modifiers changed from: package-private */
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            String lowerCase = str.toLowerCase(this.locale);
            Integer num = this.lKeyValues.get(lowerCase);
            if (num == null) {
                Map<String, Integer> map = this.lKeyValues;
                num = map.get(lowerCase + '.');
            }
            calendar.set(this.field, num.intValue());
        }
    }

    private static class NumberStrategy extends Strategy {
        private final int field;

        /* access modifiers changed from: package-private */
        public boolean isNumber() {
            return true;
        }

        /* access modifiers changed from: package-private */
        public int modify(FastDateParser fastDateParser, int i) {
            return i;
        }

        NumberStrategy(int i) {
            super();
            this.field = i;
        }

        /* access modifiers changed from: package-private */
        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i) {
            int index = parsePosition.getIndex();
            int length = str.length();
            if (i == 0) {
                while (index < length && Character.isWhitespace(str.charAt(index))) {
                    index++;
                }
                parsePosition.setIndex(index);
            } else {
                int i2 = i + index;
                if (length > i2) {
                    length = i2;
                }
            }
            while (index < length && Character.isDigit(str.charAt(index))) {
                index++;
            }
            if (parsePosition.getIndex() == index) {
                parsePosition.setErrorIndex(index);
                return false;
            }
            int parseInt = Integer.parseInt(str.substring(parsePosition.getIndex(), index));
            parsePosition.setIndex(index);
            calendar.set(this.field, modify(fastDateParser, parseInt));
            return true;
        }
    }

    static class TimeZoneStrategy extends PatternStrategy {
        private static final String GMT_OPTION = "GMT[+-]\\d{1,2}:\\d{2}";

        /* renamed from: ID */
        private static final int f3043ID = 0;
        private static final String RFC_822_TIME_ZONE = "[+-]\\d{4}";
        private final Locale locale;
        private final Map<String, TzInfo> tzNames = new HashMap();

        private static class TzInfo {
            int dstOffset;
            TimeZone zone;

            TzInfo(TimeZone timeZone, boolean z) {
                this.zone = timeZone;
                this.dstOffset = z ? timeZone.getDSTSavings() : 0;
            }
        }

        TimeZoneStrategy(Locale locale2) {
            super();
            this.locale = locale2;
            StringBuilder sb = new StringBuilder();
            sb.append("((?iu)[+-]\\d{4}|GMT[+-]\\d{1,2}:\\d{2}");
            TreeSet<String> treeSet = new TreeSet<>(FastDateParser.LONGER_FIRST_LOWERCASE);
            for (String[] strArr : DateFormatSymbols.getInstance(locale2).getZoneStrings()) {
                String str = strArr[0];
                if (!str.equalsIgnoreCase(TimeZones.GMT_ID)) {
                    TimeZone timeZone = TimeZone.getTimeZone(str);
                    TzInfo tzInfo = new TzInfo(timeZone, false);
                    TzInfo tzInfo2 = tzInfo;
                    for (int i = 1; i < strArr.length; i++) {
                        if (i == 3) {
                            tzInfo2 = new TzInfo(timeZone, true);
                        } else if (i == 5) {
                            tzInfo2 = tzInfo;
                        }
                        if (strArr[i] != null) {
                            String lowerCase = strArr[i].toLowerCase(locale2);
                            if (treeSet.add(lowerCase)) {
                                this.tzNames.put(lowerCase, tzInfo2);
                            }
                        }
                    }
                }
            }
            for (String access$900 : treeSet) {
                sb.append('|');
                StringBuilder unused = FastDateParser.simpleQuote(sb, access$900);
            }
            sb.append(")");
            createPattern(sb);
        }

        /* access modifiers changed from: package-private */
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            TimeZone gmtTimeZone = FastTimeZone.getGmtTimeZone(str);
            if (gmtTimeZone != null) {
                calendar.setTimeZone(gmtTimeZone);
                return;
            }
            String lowerCase = str.toLowerCase(this.locale);
            TzInfo tzInfo = this.tzNames.get(lowerCase);
            if (tzInfo == null) {
                Map<String, TzInfo> map = this.tzNames;
                tzInfo = map.get(lowerCase + '.');
            }
            calendar.set(16, tzInfo.dstOffset);
            calendar.set(15, tzInfo.zone.getRawOffset());
        }
    }

    private static class ISO8601TimeZoneStrategy extends PatternStrategy {
        private static final Strategy ISO_8601_1_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}))");
        private static final Strategy ISO_8601_2_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}\\d{2}))");
        /* access modifiers changed from: private */
        public static final Strategy ISO_8601_3_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");

        ISO8601TimeZoneStrategy(String str) {
            super();
            createPattern(str);
        }

        /* access modifiers changed from: package-private */
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            calendar.setTimeZone(FastTimeZone.getGmtTimeZone(str));
        }

        static Strategy getStrategy(int i) {
            switch (i) {
                case 1:
                    return ISO_8601_1_STRATEGY;
                case 2:
                    return ISO_8601_2_STRATEGY;
                case 3:
                    return ISO_8601_3_STRATEGY;
                default:
                    throw new IllegalArgumentException("invalid number of X");
            }
        }
    }
}
