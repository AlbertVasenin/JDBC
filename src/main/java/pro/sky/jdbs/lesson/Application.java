package pro.sky.jdbs.lesson;

import pro.sky.jdbs.lesson.dao.EmployeeDAO;
import pro.sky.jdbs.lesson.dao.impl.EmployeeDAOImpl;
import pro.sky.jdbs.lesson.model.Employee;

public class Application {

  public static void main(String[] args) {
    Employee employee = new Employee(10, "Petr", "Sidorov", "m", 40, 1);
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    employeeDAO.readAll().forEach(System.out::println);
    employeeDAO.updateEmployeeById(employee,10);
    System.out.println(employeeDAO.getEmployeeByID(10));
    employeeDAO.deleteEmployeeById(10);
    employeeDAO.readAll().forEach(System.out::println);
  }
}
