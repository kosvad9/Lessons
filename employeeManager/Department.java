package employeeManager;

public enum Department {
    MARKETING("Marketing"), HR("Human Resources"), DEVELOPMENT("Development");

    private String name;
    private Department(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
