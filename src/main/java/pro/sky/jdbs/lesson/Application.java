package pro.sky.jdbs.lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import pro.sky.jdbs.lesson.dao.EmployeeDAO;
import pro.sky.jdbs.lesson.dao.impl.EmployeeDAOImpl;
import pro.sky.jdbs.lesson.employee.Employee;

public class Application {

  private static final EmployeeDAO employeeDAO = new EmployeeDAOImpl();

  public static void main(String[] args) throws SQLException {
    employeeDAO.createEmployee(new Employee("Arina", "Rubcova", "f", 28, "Samara"));
    System.out.println(employeeDAO.getEmployeeByID(9));
    employeeDAO.updateEmployeeById(new Employee(8, "Ruslan", "Kozak", "m", 32, "Kirov"), 8);
    System.out.println(employeeDAO.readAll());
    employeeDAO.deleteEmployeeById(4);
    System.out.println(employeeDAO.readAll());
  }

  public static Connection getConnection() throws SQLException {
    final String url = "jdbc:postgresql://localhost:1987/skypro";
    final String user = "postgres";
    final String password = "3848";
    return DriverManager.getConnection(url, user, password);
  }
}
