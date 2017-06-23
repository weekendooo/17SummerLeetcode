package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No210CourseSchedule2 {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[][] matrix = new int[n][n];
        int[] indegree = new int[n];
        int[] res = new int[n];
        
        for (int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int ready = prerequisites[i][0];
            if (matrix[pre][ready] == 0) indegree[ready]++; //duplicate case ?? 
            matrix[pre][ready] = 1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);    //把刚开始入度为0的数都放进去
        }
        
        int index = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int preCourse = queue.poll();
            res[index++] = preCourse;
            count++;
           
            for (int i = 0; i < n; i++) {
                if (matrix[preCourse][i] != 0) {
                    if (--indegree[i] == 0) {  //产生新的入度为0的数
                        queue.offer(i);
                    }
                }
            }
        }
        
        if (count == n) return res;   // test case  n = 2  int[][] == { [0, 1], [1, 0] }, expect [] 
        else return new int[0];
    }
	
	
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		l1.add(1); l1.add(2);
		System.out.println(l1);
		l2.add(3);
		l1.addAll(l2);
		System.out.println(l1);
		
		int room = 0;
		int[] rooms = new int[3];
		rooms[0] = room++;
		System.out.println(rooms[0]);
	}

}
