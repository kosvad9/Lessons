package employeeManager;

public enum MenuItem {
    PRINT_STAFF("Распечатать список сотрудников"), CREATE_EMPLOYEE("Добавить сотрудника"),
    REMOVE_EMPLOYEE("Уволить сотрудника"), CHANGE_DEPT("Изменить отдел"),
    CHANGE_SALARY("Изменить ЗП"), RAISE_POS("Повысить сотрудника в должности"),
    LOWER_POS("Понизить сотрудника в должности"), EXIT("Выход");

    private final String name;

    MenuItem(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
