package employeeManager;

public class DepartmentManager {
    public static void changeDepartment(Employee employee){
        System.out.println("Выберите отдел:");
        Department department = (Department) EmployeeManager.choiceEnum(Department.getDeptExceptCurr(employee.getPosition().getDepartment()));
        Position position = EmployeeManager.definePositionFromDept(department);
        employee.setPosition(position);
    }
}
