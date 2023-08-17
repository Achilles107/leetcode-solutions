package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleIV {

    private boolean cycle = false;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        if (prerequisites.length == 0){
            for (int i = 0; i < queries.length; i++) {
                result.add(false);
            }
            return result;
        }
        Map<Integer, List<Integer>> prereqs = createRelations(prerequisites, numCourses);
        boolean visited[];
        for (int query[]: queries) {
            visited = new boolean[numCourses];
            int prereq = query[0];
            int course = query[1];
            cycle = false;
            if (isPrereq(prereq, course, prereqs, visited) && !cycle) {
                result.add(true);
            }
            else {
                result.add(false);
            }
        }
        return result;
    }

    private boolean isPrereq(int currCourse, int course, Map<Integer, List<Integer>> prereqs, boolean visited[]) {
        if (visited[currCourse]) {
            cycle = true;
            return false;
        }
        visited[currCourse] = true;
        List<Integer> courses = prereqs.get(currCourse);
        for (int childCourse: courses) {
            if (isPrereq(childCourse, course, prereqs, visited)) {
                return true;
            }
        }
        if (currCourse == course)
            return true;
        visited[currCourse] = false;
        return false;
    }

    private Map<Integer, List<Integer>> createRelations(int[][] prerequisites, int numCourses) {
        Map<Integer, List<Integer>> relations = new HashMap<>();
        for (int courseId =0; courseId < numCourses; courseId++) {
            relations.put(courseId, new ArrayList<>());
        }

        for (int[] prereq: prerequisites) {
            relations.get(prereq[0]).add(prereq[1]);
        }
        return relations;
    }
    public static void main(String[] args) {

    }
}
