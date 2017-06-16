package Sort;

import java.util.Arrays;

public class No253MeetingRooms2 {

	public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length ==0) return 0;
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for (int i =0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        int room = 0;
        int endIndex = 0;
        
        for (int i =0; i < start.length; i++) {    // [2,  7,  7]
            if (start[i] < end[endIndex]) {       //  [4, 10,  15]
                room++;
            }
            else {
                endIndex++;
            }
        }
        
        return room;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
