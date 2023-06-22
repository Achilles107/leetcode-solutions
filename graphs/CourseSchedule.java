package graphs;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> schedule = new HashMap<>();
        Arrays.sort(prerequisites, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i=0; i<numCourses; i++){
            schedule.put(i, new ArrayList<>());
        }
        for (int[] n: prerequisites){
            schedule.get(n[0]).add(n[1]);
        }
        boolean visited[] = new boolean[numCourses];
        boolean seen[] = new boolean[numCourses];
        for (int i =0; i<numCourses; i++){
            if (dfs(i, schedule, visited, seen))
                return false;
        }
        return true;
    }

    private boolean dfs(int currNode, HashMap<Integer, List<Integer>> children, boolean[] visited, boolean seen[]) {
        if (visited[currNode])
            return true;
        if (seen[currNode])
            return false;
        seen[currNode] = true;
        visited[currNode] = true;
        for (int i =0; i<children.get(currNode).size(); i++){
            if (dfs(children.get(currNode).get(i), children, visited, seen))
                return true;
        }
        visited[currNode] = false;
        return false;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        //[1,0],[0,2],[2,1]
        int arr[][] = {{1,0},{0,2},{2,1}};
        System.out.println(courseSchedule.canFinish(3, arr));
    }
}
