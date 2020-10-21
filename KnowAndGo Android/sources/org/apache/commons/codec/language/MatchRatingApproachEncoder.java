package org.apache.commons.codec.language;

import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class MatchRatingApproachEncoder implements StringEncoder {
    private static final String[] DOUBLE_CONSONANT = {"BB", "CC", "DD", "FF", "GG", "HH", "JJ", "KK", "LL", "MM", "NN", "PP", "QQ", "RR", "SS", "TT", "VV", "WW", "XX", "YY", "ZZ"};
    private static final int EIGHT = 8;
    private static final int ELEVEN = 11;
    private static final String EMPTY = "";
    private static final int FIVE = 5;
    private static final int FOUR = 4;
    private static final int ONE = 1;
    private static final String PLAIN_ASCII = "AaEeIiOoUuAaEeIiOoUuYyAaEeIiOoUuYyAaOoNnAaEeIiOoUuYyAaCcOoUu";
    private static final int SEVEN = 7;
    private static final int SIX = 6;
    private static final String SPACE = " ";
    private static final int THREE = 3;
    private static final int TWELVE = 12;
    private static final int TWO = 2;
    private static final String UNICODE = "ÀàÈèÌìÒòÙùÁáÉéÍíÓóÚúÝýÂâÊêÎîÔôÛûŶŷÃãÕõÑñÄäËëÏïÖöÜüŸÿÅåÇçŐőŰű";

    /* access modifiers changed from: package-private */
    public int getMinRating(int i) {
        if (i <= 4) {
            return 5;
        }
        if (i >= 5 && i <= 7) {
            return 4;
        }
        if (i < 8 || i > 11) {
            return i == 12 ? 2 : 1;
        }
        return 3;
    }

    /* access modifiers changed from: package-private */
    public String cleanName(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        for (String replaceAll : new String[]{"\\-", "[&]", "\\'", "\\.", "[\\,]"}) {
            upperCase = upperCase.replaceAll(replaceAll, "");
        }
        return removeAccents(upperCase).replaceAll("\\s+", "");
    }

    public final Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("Parameter supplied to Match Rating Approach encoder is not of type java.lang.String");
    }

    public final String encode(String str) {
        return (str == null || "".equalsIgnoreCase(str) || " ".equalsIgnoreCase(str) || str.length() == 1) ? "" : getFirst3Last3(removeDoubleConsonants(removeVowels(cleanName(str))));
    }

    /* access modifiers changed from: package-private */
    public String getFirst3Last3(String str) {
        int length = str.length();
        if (length <= 6) {
            return str;
        }
        String substring = str.substring(0, 3);
        String substring2 = str.substring(length - 3, length);
        return substring + substring2;
    }

    public boolean isEncodeEquals(String str, String str2) {
        if (str == null || "".equalsIgnoreCase(str) || " ".equalsIgnoreCase(str) || str2 == null || "".equalsIgnoreCase(str2) || " ".equalsIgnoreCase(str2) || str.length() == 1 || str2.length() == 1) {
            return false;
        }
        if (str.equalsIgnoreCase(str2)) {
            return true;
        }
        String cleanName = cleanName(str);
        String cleanName2 = cleanName(str2);
        String removeVowels = removeVowels(cleanName);
        String removeVowels2 = removeVowels(cleanName2);
        String removeDoubleConsonants = removeDoubleConsonants(removeVowels);
        String removeDoubleConsonants2 = removeDoubleConsonants(removeVowels2);
        String first3Last3 = getFirst3Last3(removeDoubleConsonants);
        String first3Last32 = getFirst3Last3(removeDoubleConsonants2);
        if (Math.abs(first3Last3.length() - first3Last32.length()) < 3 && leftToRightThenRightToLeftProcessing(first3Last3, first3Last32) >= getMinRating(Math.abs(first3Last3.length() + first3Last32.length()))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isVowel(String str) {
        return str.equalsIgnoreCase(ExifInterface.LONGITUDE_EAST) || str.equalsIgnoreCase(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) || str.equalsIgnoreCase("O") || str.equalsIgnoreCase("I") || str.equalsIgnoreCase("U");
    }

    /* access modifiers changed from: package-private */
    public int leftToRightThenRightToLeftProcessing(String str, String str2) {
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        int i = 0;
        while (i < charArray.length && i <= length2) {
            int i2 = i + 1;
            String substring = str.substring(i, i2);
            int i3 = length - i;
            String substring2 = str.substring(i3, i3 + 1);
            String substring3 = str2.substring(i, i2);
            int i4 = length2 - i;
            String substring4 = str2.substring(i4, i4 + 1);
            if (substring.equals(substring3)) {
                charArray[i] = ' ';
                charArray2[i] = ' ';
            }
            if (substring2.equals(substring4)) {
                charArray[i3] = ' ';
                charArray2[i4] = ' ';
            }
            i = i2;
        }
        String replaceAll = new String(charArray).replaceAll("\\s+", "");
        String replaceAll2 = new String(charArray2).replaceAll("\\s+", "");
        if (replaceAll.length() > replaceAll2.length()) {
            return Math.abs(6 - replaceAll.length());
        }
        return Math.abs(6 - replaceAll2.length());
    }

    /* access modifiers changed from: package-private */
    public String removeAccents(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            int indexOf = UNICODE.indexOf(charAt);
            if (indexOf > -1) {
                sb.append(PLAIN_ASCII.charAt(indexOf));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public String removeDoubleConsonants(String str) {
        String upperCase = str.toUpperCase();
        String str2 = upperCase;
        for (String str3 : DOUBLE_CONSONANT) {
            if (str2.contains(str3)) {
                str2 = str2.replace(str3, str3.substring(0, 1));
            }
        }
        return str2;
    }

    /* access modifiers changed from: package-private */
    public String removeVowels(String str) {
        String substring = str.substring(0, 1);
        String replaceAll = str.replaceAll(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "").replaceAll(ExifInterface.LONGITUDE_EAST, "").replaceAll("I", "").replaceAll("O", "").replaceAll("U", "").replaceAll("\\s{2,}\\b", " ");
        if (!isVowel(substring)) {
            return replaceAll;
        }
        return substring + replaceAll;
    }
}
