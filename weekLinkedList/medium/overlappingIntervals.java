package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given two lists of intervals, find their overlapping intervals, e.g.
//l1: [1,5], [7,10], [12,18], [22,24]
//l2: [3,8], [13,15], [16,17], [18,21], [22,23]
//returns [3,5],[7,8],[13,15],[16,17],[18,18],[22,23] 

public class overlappingIntervals {

	public List<Interval> overlapping(List<Interval> L1, List<Interval> L2) {
        List<Interval> res = new ArrayList<Interval>();
        L1.addAll(L2);
        int size = L1.size();
        int[] starts = new int[size];
        int[] ends = new int[size];
        
        for (int i = 0; i < size; i++) {
        	starts[i] = L1.get(i).start;
            ends[i] = L1.get(i).end;
        }
                              //    i
        Arrays.sort(starts);  // 1  3  7  12  13  16  18  18  22  22
        Arrays.sort(ends);   //  5  8 10  15  17  18  18  21  23  24
        					//  i-1 
        for (int i = 1; i < size; i++) {
        	if (starts[i] <= ends[i - 1]) {
        		if (res.contains(new Interval(starts[i], ends[i - 1]))) continue;
        		res.add(new Interval(starts[i], ends[i - 1]));
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		
	}

}
