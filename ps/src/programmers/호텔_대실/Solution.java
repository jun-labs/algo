package programmers.호텔_대실;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import static java.util.Comparator.comparing;

public class Solution {

    public int solution(String[][] book_time) {
        List<Reservation> guests = new ArrayList<>();
        PriorityQueue<Reservation> reservations = new PriorityQueue<>(comparing(reservation -> reservation.end));

        for (String[] temp : book_time) {
            String startTime = temp[0];
            String endTime = temp[1];
            guests.add(new Reservation(startTime, endTime));
        }

        Collections.sort(guests);

        int answer = 0;

        for (Reservation guest : guests) {
            if (!reservations.isEmpty() && guest.start >= reservations.peek().end) {
                reservations.poll();
            } else {
                answer++;
            }
            reservations.add(guest);
        }
        return answer;
    }

    static class Reservation implements Comparable<Reservation> {
        private static int CLEAN_TIME = 10;
        int start;
        int end;

        public Reservation(String start, String end) {
            this.start = calculateTime(start);
            this.end = calculateTime(end) + CLEAN_TIME;
        }

        private int calculateTime(String time) {
            String[] temp = time.split(":");
            int hour = Integer.parseInt(temp[0]);
            int minute = Integer.parseInt(temp[1]);
            return hour * 60 + minute;
        }

        @Override
        public int compareTo(Reservation o) {
            return this.start - o.start;
        }
    }
}
