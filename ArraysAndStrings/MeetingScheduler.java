package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingScheduler {

    //https://leetcode.com/problems/meeting-scheduler
    //
    // approach 1: two pointers
    //   time: O(Mlog M+N logN).
    //   space: O(1)
    //
    // approach 2: heap
    //   time: O((M+N)log(M+N))
    //   space: O(M+N)

    //     approach 1: two pointers
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);


        int pointer1 = 0, pointer2 = 0;
        while (pointer1 < slots1.length && pointer2 < slots2.length) {
            int intersectLeft = Math.max(slots1[pointer1][0], slots2[pointer2][0]);
            int intersectRight = Math.min(slots1[pointer1][1], slots2[pointer2][1]);
            if (intersectRight - intersectLeft >= duration) {
                return new ArrayList<Integer>(Arrays.asList(intersectLeft, intersectLeft + duration));
            }
            // always move the one that ends earlier
            if (slots1[pointer1][1] < slots2[pointer2][1]) {
                pointer1++;
            } else {
                pointer2++;
            }
        }
        return new ArrayList<Integer>();
    }


    // approach 2: heap
    public List<Integer> minAvailableDurationSecond(int[][] slots1, int[][] slots2, int duration) {

        PriorityQueue<int[]> timeslots = new PriorityQueue<>((slot1, slot2) -> slot1[0] - slot2[0]);

        for (int[] slot : slots1) {
            if (slot[1] - slot[0] >= duration) timeslots.offer(slot);
        }

        for (int[] slot : slots2) {
            if (slot[1] - slot[0] >= duration) timeslots.offer(slot);
        }

        while (timeslots.size() > 1) {
            int[] slot1 = timeslots.poll();
            int[] slot2 = timeslots.peek();
            if (slot1[1] >= slot2[0] + duration) {
                return new ArrayList<Integer>(Arrays.asList(slot2[0], slot2[0] + duration));
            }
        }
        return new ArrayList<Integer>();
    }
}

