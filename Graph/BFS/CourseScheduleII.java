package Graph.BFS;

import java.util.*;

// https://leetcode.com/problems/course-schedule-ii/
// bfs (topological sort)
//

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses == 0) {
            return null;
        }

        if (prerequisites == null || prerequisites.length == 0) {
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }

        // convert to adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int v = 0; v < numCourses; v++) graph.add(new ArrayList<>());
        for(int[] edge : prerequisites){
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]] += 1; // count indegree for each node
        }

        // bfs
        int[] result = new int[numCourses];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int v = 0; v < numCourses; v++) {
            if(indegree[v] == 0) {
                queue.offer(v);
            }
        }

        while (queue.size() > 0) {
            int v = queue.poll();
            result[count++] = v;

            // for each of its neighbors
            for (int w : graph.get(v)) {
                --indegree[w];
                if (indegree[w] == 0) {
                    queue.offer(w);
                }
            }
        }

        // check if there is topological sort
        if (count == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}
