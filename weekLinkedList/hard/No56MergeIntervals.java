package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No56MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        int size = intervals.size();
        int[] starts = new int[size];
        int[] ends = new int[size];
        
        for (int i = 0; i < size; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        
        Arrays.sort(starts);   //  1            2         5          15
        Arrays.sort(ends);    //   3            6         10         18
        int eachStart = 0;  //1st eachStart               i
                            //2nd                               eachStart & i
        
        for (int i = 0; i < size; i++) {
            if (i == size - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[eachStart], ends[i]));
                eachStart = i + 1;
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
