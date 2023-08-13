package programmers.광고_삽입;

import java.util.Arrays;

class Solution {
    private static final int HOUR = 0;
    private static final int MINUTE = 1;
    private static final int SECONDS = 2;
    private static int[] times = new int[360_000];

    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = convertToInt(play_time);
        int advTime = convertToInt(adv_time);

        for (String log : logs) {
            String[] timeArray = log.split("-");
            int startTime = convertToInt(timeArray[0]);
            int endTime = convertToInt(timeArray[1]);
            for (int index = startTime; index < endTime; index++) {
                times[index]++;
            }
        }

        int maxIndex = 0;
        long totalTime = 0;
        for (int index = 0; index < advTime; index++) {
            totalTime += times[index];
        }

        long maxTotalTime = totalTime;
        for (int index = advTime; index < playTime; index++) {
            totalTime += times[index] - times[index - advTime];
            if (totalTime > maxTotalTime) {
                maxTotalTime = totalTime;
                maxIndex = index - advTime + 1;
            }
        }
        return convertToString(maxIndex);
    }

    private int convertToInt(String time) {
        int[] timeArray = Arrays.stream(time.split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return 3600 * timeArray[HOUR] + 60 * timeArray[MINUTE] + timeArray[SECONDS];
    }

    private String convertToString(int time) {
        int hour = time / 3600;
        int minute = (time - 3600 * hour) / 60;
        int seconds = (time - 3600 * hour - 60 * minute);
        String strHour = hour < 10 ? "0" + hour : "" + hour;
        String strMinute = minute < 10 ? "0" + minute : "" + minute;
        String strSeconds = seconds < 10 ? "0" + seconds : "" + seconds;
        return String.format("%s:%s:%s", strHour, strMinute, strSeconds);
    }
}
