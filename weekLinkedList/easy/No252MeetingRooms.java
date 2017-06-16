package Sort;

import java.util.Arrays;
import java.util.Comparator;

//given [[0, 30],[5, 10],[15, 20]]
//start [0, 5, 15]
//end   [30, 10, 20]

class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	 }

public class No252MeetingRooms {

	public boolean canAttendMeetings(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval I1, Interval I2) {
                if (I1.start != I2.start) {
                    return Integer.compare(I1.start, I2.start);
                }
                else return Integer.compare(I1.end, I2.end);
            }
        });
        
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
            
            if (i >= 1) {                 // not while
                if (start[i] == start[i - 1] || start[i] < end[i - 1]) 
                    return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
