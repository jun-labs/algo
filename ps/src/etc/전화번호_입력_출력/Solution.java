package etc.전화번호_입력_출력;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    private static final String DELIMETER = "-";
    private static final String KOREA_COUNTRY_NUMBER = "+82";
    private static final StringBuilder sb = new StringBuilder();
    private static final Pattern pattern = Pattern.compile("(\\d{3})(\\d{3,4})(\\d{4})");

    public String getPhoneNumberV1(String phoneNumber) {
        initStringBuilder();
        Matcher matcher = getMatch().matcher(phoneNumber);

        if (isLength(11, phoneNumber) && matcher.find()) {
            return sb.append(matcher.group(1))
                    .append(DELIMETER)
                    .append(matcher.group(2), 0, 4)
                    .append(DELIMETER)
                    .append(matcher.group(3))
                    .toString();
        }
        if (isLength(10, phoneNumber) && matcher.find()) {
            return sb.append(matcher.group(1))
                    .append(DELIMETER)
                    .append(matcher.group(2), 0, 3)
                    .append(DELIMETER)
                    .append(matcher.group(3))
                    .toString();
        }
        throw new IllegalArgumentException("올바른 전화번호를 입력해주세요.");
    }

    public String getPhoneNumberV2(String phoneNumber) {
        initStringBuilder();
        Matcher matcher = getMatch().matcher(phoneNumber);

        if (isLength(11, phoneNumber) && matcher.find()) {
            return sb.append(KOREA_COUNTRY_NUMBER)
                    .append(DELIMETER)
                    .append(matcher.group(1), 1, 3)
                    .append(DELIMETER)
                    .append(matcher.group(2), 0, 4)
                    .append(DELIMETER)
                    .append(matcher.group(3))
                    .toString();
        }
        if (isLength(10, phoneNumber) && matcher.find()) {
            return sb.append(KOREA_COUNTRY_NUMBER)
                    .append(DELIMETER)
                    .append(matcher.group(1), 1, 3)
                    .append(DELIMETER)
                    .append(matcher.group(2), 0, 3)
                    .append(DELIMETER)
                    .append(matcher.group(3))
                    .toString();
        }
        throw new IllegalArgumentException("올바른 전화번호를 입력해주세요.");
    }

    private static void initStringBuilder() {
        sb.setLength(0);
    }

    private boolean isLength(int length, String phoneNumber) {
        return phoneNumber.length() == length;
    }

    private static Pattern getMatch() {
        return pattern;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String phoneNumberA = "01011112222";
        String phoneNumberB = "0101112222";
        System.out.println(solution.getPhoneNumberV1(phoneNumberA));
        System.out.println(solution.getPhoneNumberV2(phoneNumberA));

        System.out.println(solution.getPhoneNumberV1(phoneNumberB));
        System.out.println(solution.getPhoneNumberV2(phoneNumberB));
    }
}
