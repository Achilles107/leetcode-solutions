package graphs;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> prereqs = new HashMap<>();
        for (int i=0; i<numCourses; i++){
            prereqs.put(i, new ArrayList<>());
        }
        for (int i =0; i<prerequisites.length; i++){
            prereqs.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        boolean cycle[] = new boolean[numCourses];
        boolean seen[] = new boolean[numCourses];

        for (Integer course: prereqs.keySet()){
            if (dfs(course, prereqs, cycle, seen)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int currNode, HashMap<Integer, List<Integer>> prereqs, boolean[] visited, boolean seen[]) {
        if (visited[currNode])
            return true;
        if (seen[currNode])
            return false;
        visited[currNode] = true;
        seen[currNode] = true;
        for (int i=0;i<prereqs.get(currNode).size(); i++){
            if (dfs(prereqs.get(currNode).get(i), prereqs, visited, seen)){
                return true;
            }
        }
        visited[currNode] = false;
        return false;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        //[1,0],[0,2],[2,1]
        int arr[][] = {{1,0},{0,2},{2,4},{2,3},{5,2}};
        System.out.println(courseSchedule.canFinish(6, arr));
    }
}
