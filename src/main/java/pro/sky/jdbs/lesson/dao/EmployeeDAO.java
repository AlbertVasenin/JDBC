package pro.sky.jdbs.lesson.dao;

import java.sql.SQLException;
import java.util.List;
import pro.sky.jdbs.lesson.employee.Employee;

public interface EmployeeDAO {

  void createEmployee(Employee employee) throws SQLException;

  Employee getEmployeeByID(int id) throws SQLException;

  List<Employee> readAll() throws SQLException;

  void updateEmployeeById(Employee employee, int id) throws SQLException;

  void deleteEmployeeById(int id) throws SQLException;
}
