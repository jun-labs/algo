package etc.저축;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Solution {

    public static int[] solution(String s, String[] times) {
        LocalDateTime start = getStartDay(s);

        LocalDateTime current = start;
        boolean success = true;
        int lastDay = start.getDayOfYear();

        for (String time : times) {
            int days = Integer.parseInt(time.substring(0, 2));
            int hours = Integer.parseInt(time.substring(3, 5));
            int minutes = Integer.parseInt(time.substring(6, 8));
            int seconds = Integer.parseInt(time.substring(9));

            current = calculateDay(current, days, hours, minutes, seconds);
            if (current.getDayOfYear() - lastDay > 1) {
                success = false;
            }
            lastDay = current.getDayOfYear();
        }

        int totalDays = current.getDayOfYear() - start.getDayOfYear() + 1;
        return new int[]{success ? 1 : 0, totalDays};
    }

    private static LocalDateTime calculateDay(
        LocalDateTime current,
        int days,
        int hours,
        int minutes,
        int seconds
    ) {
        current = current.plusDays(days)
            .plusHours(hours)
            .plusMinutes(minutes)
            .plusSeconds(seconds);
        return current;
    }

    private static LocalDateTime getStartDay(String s) {
        return LocalDateTime.of(
            Integer.parseInt(s.substring(0, 4)),
            Integer.parseInt(s.substring(5, 7)),
            Integer.parseInt(s.substring(8, 10)),
            Integer.parseInt(s.substring(11, 13)),
            Integer.parseInt(s.substring(14, 16)),
            Integer.parseInt(s.substring(17))
        );
    }

    public static void main(String[] args) {
        String s1 = "2021:04:12:16:08:35";
        String[] times1 = {"01:06:30:00", "01:04:12:00"};
        System.out.println(Arrays.toString(solution(s1, times1)));

        String s2 = "2021:04:12:16:08:35";
        String[] times2 = {"01:06:30:00", "00:01:12:00"};
        int[] result2 = solution(s2, times2);
        System.out.println(Arrays.toString(result2));

        String s3 = "2021:04:12:16:10:42";
        String[] times3 = {"01:06:30:00"};
        System.out.println(Arrays.toString(solution(s3, times3)));

        String s4 = "2021:04:12:16:08:35";
        String[] times4 = {"01:06:30:00", "01:01:12:00", "00:00:09:25"};
        System.out.println(Arrays.toString(solution(s4, times4)));
    }
}
