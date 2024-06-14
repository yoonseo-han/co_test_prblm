//https://school.programmers.co.kr/learn/courses/30/lessons/176962#

import java.util.*;

class Solution {
    public int Minutes(String time) {
        String[] curStore = time.split(":");
        int timeHour = Integer.parseInt(curStore[0]);
        int timeMin = Integer.parseInt(curStore[1]);
        return timeHour * 60 + timeMin;
    }

    public String addTime(String time, String duration) {
        String[] curStore = time.split(":");
        int timeHour = Integer.parseInt(curStore[0]);
        int timeMin = Integer.parseInt(curStore[1]);
        int addMin = Integer.parseInt(duration);

        timeHour = (timeHour + (timeMin + addMin) / 60) % 24;
        timeMin = (timeMin + addMin) % 60;

        return String.format("%02d:%02d", timeHour, timeMin);
    }

    public String subtractTime(String time1, String time2) {
        int totalMin1 = Minutes(time1);
        int totalMin2 = Minutes(time2);
        int diffMin = totalMin1 - totalMin2;
        if (diffMin < 0) diffMin += 24 * 60;  // Handle negative differences for different days

        int newHour = diffMin / 60;
        int newMin = diffMin % 60;

        return String.format("%02d:%02d", newHour, newMin);
    }

    public int compareTime(String time1, String time2) {
        String[] curStore = time1.split(":");
        int timeHour = Integer.parseInt(curStore[0]);
        int timeMin = Integer.parseInt(curStore[1]);
        String[] nextStore = time2.split(":");
        int nextTimeHour = Integer.parseInt(nextStore[0]);
        int nextTimeMin = Integer.parseInt(nextStore[1]);

        if (timeHour != nextTimeHour) {
            return Integer.compare(timeHour, nextTimeHour);
        } else {
            return Integer.compare(timeMin, nextTimeMin);
        }
    }

    public String[] solution(String[][] plans) {
        ArrayList<String> tempStore = new ArrayList<>();
        Stack<String[]> orderStore = new Stack<>();
        int N = plans.length;

        // Sort 2D array in terms of start time
        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return compareTime(o1[1], o2[1]);
            }
        });

        String curTime = plans[0][1];

        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                tempStore.add(plans[i][0]);
                break;
            }
            String nextStartTime = plans[i + 1][1];
            String endTime = addTime(plans[i][1], plans[i][2]);

            // If curTime is greater than nextStartTime
            if (compareTime(endTime, nextStartTime) > 0) {
                orderStore.add(plans[i]);
                // Adjust the current task duration to fit the available time before the next task starts
                plans[i][2] = String.valueOf(Minutes(subtractTime(endTime, nextStartTime)));
                //int difference = Minutes(subtractTime(endTime, nextStartTime));
            } else {
                // Add current task to processed tasks
                tempStore.add(plans[i][0]);
                curTime = endTime;
                // Get tasks stored in the stack and process them
                while (!orderStore.isEmpty()) {
                    String[] task = orderStore.pop();
                    endTime = addTime(curTime, task[2]);
                    if (compareTime(endTime, nextStartTime) > 0) {
                        task[2] = String.valueOf(Minutes(subtractTime(endTime, nextStartTime)));
                        orderStore.add(task);
                        break;
                    } else {
                        tempStore.add(task[0]);
                        curTime = endTime;
                    }
                }
            }
        }

        while (!orderStore.isEmpty()) {
            String[] task = orderStore.pop();
            tempStore.add(task[0]);
        }

        String[] answer = tempStore.toArray(new String[0]);
        return answer;
    }
}