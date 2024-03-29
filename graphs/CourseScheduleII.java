package graphs;

import java.util.*;

public class CourseScheduleII {
    boolean cycle = false;
    List<Integer> schedule = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> courses = new HashMap<>();
        for (int i =0; i<numCourses; i++){
            courses.put(i, new ArrayList<>());
        }
        if (prerequisites.length == 0){
            int res[] = new int[numCourses];
            for (int i =0; i<numCourses; i++){
                res[i] = i;
            }
            return res;
        }
        for (int n[]: prerequisites){
            if (n.length == 2)
                courses.get(n[0]).add(n[1]);
        }
        boolean visited[] = new boolean[numCourses];
        for (int i =0; i<numCourses; i++){
            if (cycle)
                return new int[]{};
            dfs(i, courses, visited);
        }
        if (cycle)
            return new int[]{};
        int result[] = new int[numCourses];
        for (int i=0; i<schedule.size(); i++){
            result[i] = schedule.get(i);
        }
        return result;
    }

    private void dfs(int currNode, HashMap<Integer, List<Integer>> courses, boolean[] visited) {
        if (schedule.contains(currNode))
            return;
        if (courses.containsKey(currNode) && courses.get(currNode).isEmpty()){
            schedule.add(currNode);
            return;
        }
        if (visited[currNode]){
            cycle = true;
            return;
        }
        visited[currNode] = true;
        List<Integer> children = courses.get(currNode);
        for (Integer child: children){
            dfs(child, courses, visited);
        }
        if (!schedule.contains(currNode)){
            schedule.add(currNode);
        }
        visited[currNode] = false;
    }

    public static void main(String[] args) {
        //testcase
        int[][] prerequisites = {{}};//{{0,4}, {0,6}, {1,3},{2,3},{4,7},{5,4},{6,8}};
        int numCourses = 1;
        int res[] = new CourseScheduleII().findOrder(numCourses, prerequisites);
        for (int i: res)
            System.out.print(" "+i);
    }
}
