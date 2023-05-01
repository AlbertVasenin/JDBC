package pro.sky.jdbs.lesson.dao;
import java.util.List;
import pro.sky.jdbs.lesson.model.Employee;

public interface EmployeeDAO {

  Integer addEmployee(Employee employee);

  Employee getEmployeeByID(int id);

  List<Employee> readAll();

  void updateEmployeeById(Employee employee, int id);

  void deleteEmployeeById(int id);
}
