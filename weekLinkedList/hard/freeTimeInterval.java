package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//每个员工有若干个interval表示在这段时间是忙碌的。求所有员工都不忙的intervals。(这题参考 https://leetcode.com/problems/merge-intervals )
//举例： [
//   [[1, 3], [6, 7]],
//   [[2, 4]],
//   [[2, 3], [9, 12]]. 
//]
//返回 [[4, 6], [7, 9]]
		
public class freeTimeInterval {

	public List<Interval> freeTimeInterval(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();
        int size = intervals.size();
        int[] starts = new int[size];
        int[] ends = new int[size];
        
        for (int i = 0; i < size; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        
        Arrays.sort(starts);       //   1   2   2   6   9
        Arrays.sort(ends);        //    3   3   4   7   12
        
        for (int i = 1; i < size; i++) {
        	if (starts[i] > ends[i - 1]) {
        		res.add(new Interval(ends[i - 1], starts[i]));
        	}
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
