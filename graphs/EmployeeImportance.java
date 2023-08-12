package graphs;

// 17:06 - 17:29
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
public class EmployeeImportance {


    private int importance = 0;
    private void calculateImportance(int currEmployeeId, Map<Integer, Employee> heirarchy) {
        Employee currEmployee = heirarchy.get(currEmployeeId);
        importance += currEmployee.importance;
        List<Integer> subordinates = currEmployee.subordinates;
        for (int subordinateId: subordinates) {
            calculateImportance(subordinateId, heirarchy);
        }
    }
    private Map<Integer, Employee> createHeirarchy(List<Employee> employees) {
        Map<Integer, Employee> heirarchy = new HashMap<>();
        for (Employee employee: employees) {
            heirarchy.put(employee.id, employee);
        }
        return heirarchy;
    }
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> heirarchy = createHeirarchy(employees); // O(n)
        calculateImportance(id, heirarchy); // O(n)
        return importance;
    }

    public static void main(String[] args) {

    }
}
