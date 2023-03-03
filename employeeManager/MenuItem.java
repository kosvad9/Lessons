package employeeManager;

public enum MenuItem {
    PRINTSTAFF("Распечатать список сотрудников"), EXIT("Выход");

    private String name;

    MenuItem(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
