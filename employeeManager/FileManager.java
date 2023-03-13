package employeeManager;
import employeeManager.positions.development.DevelopmentPositions;
import employeeManager.positions.hr.HrPositions;

import java.io.*;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class FileManager {
    private List<Employee> staff = new LinkedList<>();

    private final String filePath = "employeeManager/employees.data";

    public FileManager(){
        readEmployees();
    }

    public void readEmployees(){
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            staff = (LinkedList<Employee>) objectInputStream.readObject();
        } catch (FileNotFoundException e){
            System.out.println("Файл не найден! Список сотрудников не будет загружен "+e);
        } catch (IOException e) {
            System.out.println("Неопознанная ошибка при чтении данных из файла "+e);
        } catch (ClassNotFoundException e) {
            System.out.println("Не удалось преобразовать данные из файла в нужный формат "+e);
        }catch (ClassCastException e){
            System.out.println("Проблема в привидении типов "+e);
        }
    }

    public void writeEmployees(){
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStreamStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStreamStream.writeObject(staff);
        } catch (FileNotFoundException e){
            System.out.println("Файл не найден и невозможно создать! Данные не будут сохранены "+e);
        } catch (IOException e) {
            System.out.println("Неопознанная ошибка при записи данных в файл "+e);
        }
    }

    public void addEmployee(Employee employee){
        staff.add(employee);
        writeEmployees();
    }

    public void removeEmployee(Employee employee){
        staff.remove(employee);
        writeEmployees();
    }

    private void fillStaff(){
        try {
            staff.add(new Employee("Вадим", "Космачёв", 1, DevelopmentPositions.TEAMLEAD.getPosition(), new BigDecimal(7000)));
            staff.add(new Employee("Иван", "Сидоренко", 2, DevelopmentPositions.MIDDLE.getPosition(), new BigDecimal(1600)));
            staff.add(new Employee("Екатерина", "Петрова", 3, HrPositions.MANAGER.getPosition(), new BigDecimal(790)));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Employee> getStaff() {
        return staff;
    }

    public int getNextStaffID(){
        return staff.size()+1;
    }
}
