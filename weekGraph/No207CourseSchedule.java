package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class No207CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[][] matrix = new int[n][n];
        int[] indegree = new int[n];
        
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
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            int preCourse = queue.poll();
            count++;
            
            for (int i = 0; i < n; i++) {
                if (matrix[preCourse][i] != 0) {
                    if (--indegree[i] == 0) {  //产生新的入度为0的数
                        queue.offer(i);
                    }
                }
            }
        }
        return count == n;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
