package employeeManager;

import employeeManager.positions.development.DevelopmentPositions;
import employeeManager.positions.hr.HrPositions;
import employeeManager.positions.marketing.MarketingPositions;

import java.util.InputMismatchException;

public class DepartmentManager {

    private Accounting accounting;

    public DepartmentManager(Accounting accounting){
        this.accounting = accounting == null ? new Accounting() : accounting;
    }

    public void changeDepartment(Employee employee){
        System.out.println("Выберите отдел:");
        Department department = (Department) EnumUtil.choiceEnum(employee.getPosition().getDepartment().getDeptExceptCurr());
        Position position = EmployeeManager.definePositionFromDept(department);
        employee.setPosition(position);
    }

    public void raisePosition(Employee employee){
        Department department = employee.getPosition().getDepartment();
        Position newPosition = switch (department){
            case HR -> HrPositions.getNextPosition(employee.getPosition());
            case DEVELOPMENT -> DevelopmentPositions.getNextPosition(employee.getPosition());
            case MARKETING -> MarketingPositions.getNextPosition(employee.getPosition());
        };
        if (newPosition == null){
            System.out.println("Сотрудник уже на самой высокой должности!");
            return;
        }
        setPositionAndSalary(employee,newPosition);
    }

    public void lowerPosition(Employee employee){
        Department department = employee.getPosition().getDepartment();
        Position newPosition = switch (department){
            case HR -> HrPositions.getPrevPosition(employee.getPosition());
            case DEVELOPMENT -> DevelopmentPositions.getPrevPosition(employee.getPosition());
            case MARKETING -> MarketingPositions.getPrevPosition(employee.getPosition());
        };
        if (newPosition == null){
            System.out.println("Сотрудник на самой низкой должности, он будет уволен!");
            FileManager.removeEmployee(employee);
            return;
        }
        setPositionAndSalary(employee,newPosition);
    }

    private void setPositionAndSalary(Employee employee, Position position){
        try{
            employee.setPosition(position);
            System.out.printf("Введите размер ЗП (мин = %s, макс = %s): ", position.getMinSalary(), position.getMaxSalary());
            accounting.changeSalary(employee,EmployeeManager.sc.nextBigDecimal());
        }catch (IndexOutOfBoundsException e){
            System.out.println("Выбран неверный индекс! Повторите попытку.");
        }catch (InputMismatchException e){
            System.out.println("Введены некорректные данные! Повторите попытку.");
            EmployeeManager.sc.nextLine();
        }catch (Exception e){
            System.out.println("Возникла ошибка "+e);
        }
    }
}
