import java.util.*;

class Meeting {
    int start, end, index;

    Meeting(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

public class MeetingScheduler {
    public static void maxMeetings(int[] start, int[] end) {
        int n = start.length;
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }

        // Sort meetings based on end time
        meetings.sort((a, b) -> a.end - b.end);

        List<Integer> result = new ArrayList<>();
        int lastEndTime = 0;

        for (Meeting m : meetings) {
            if (m.start > lastEndTime) {
                result.add(m.index);
                lastEndTime = m.end;
            }
        }

        // Print the result
        for (int idx : result) {
            System.out.print(idx + " ");
        }
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 5, 7, 9, 9};

        maxMeetings(start, end);
    }
}
