package employeeManager;

public enum Department{
    MARKETING("Marketing"), HR("Human Resources"), DEVELOPMENT("Development");

    private final String name;
    Department(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Department[] getDeptExceptCurr(){
        Department[] values = Department.values();
        Department[] departments = new Department[values.length-1];
        for (int i = 0, j = 0; i < values.length; i++, j++){
            if (values[i] != this)
                departments[j] = values[i];
            else j--;
        }
        return departments;
    }
}
