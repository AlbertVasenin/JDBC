package pro.sky.jdbs.lesson.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pro.sky.jdbs.lesson.Application;
import pro.sky.jdbs.lesson.dao.EmployeeDAO;
import pro.sky.jdbs.lesson.employee.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

  CityDAOImpl cityDAOImpl = new CityDAOImpl();

  @Override
  public void createEmployee(Employee employee) throws SQLException {
    int cityIDByName = cityDAOImpl.getCityIDByName(employee.getCityName());
    String query = "INSERT INTO employee (first_name, last_name, gender, age, city_id)\n"
        + "VALUES (?, ?, ?, ?, ?)";
    try (Connection connection = Application.getConnection(); PreparedStatement statement = connection.prepareStatement(
        query)) {
      statement.setString(1, employee.getFirstName());
      statement.setString(2, employee.getLastName());
      statement.setString(3, employee.getGender());
      statement.setInt(4, employee.getAge());
      statement.setInt(5, cityIDByName);
      statement.executeUpdate();
    }
  }

  @Override
  public Employee getEmployeeByID(int id) throws SQLException {
    try (final Connection connection = Application.getConnection(); PreparedStatement statement = connection.prepareStatement(
        "SELECT * FROM employee WHERE id = ?")) {
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();
      resultSet.next();
      return new Employee(resultSet.getInt("id"), resultSet.getString("first_name"),
          resultSet.getString("last_name"), resultSet.getString("gender"), resultSet.getInt("age"),
          cityDAOImpl.getCityByID(resultSet.getInt("city_id")).getCityName());
    }
  }

  @Override
  public List<Employee> readAll() throws SQLException {
    List<Employee> employeeList = new ArrayList<>();
    try (final Connection connection = Application.getConnection(); PreparedStatement statement = connection.prepareStatement(
        "SELECT * FROM employee INNER JOIN city ON employee.city_id = city.city_id")) {
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        String gender = resultSet.getString("gender");
        int age = resultSet.getInt("age");
        String cityName = resultSet.getString("city_name");
        Employee employee = new Employee(id, firstName, lastName, gender, age, cityName);
        employeeList.add(employee);
      }
    }
    return employeeList;
  }

  @Override
  public void updateEmployeeById(Employee employee, int id) throws SQLException {
    int cityIDByName = cityDAOImpl.getCityIDByName(employee.getCityName());
    String query =
        "UPDATE employee SET first_name = ?, last_name = ?, gender = ?, age = ?, city_id = ? " +
            "WHERE id= ?;";
    try (final Connection connection = Application.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setInt(6, id);
      statement.setString(1, employee.getFirstName());
      statement.setString(2, employee.getLastName());
      statement.setString(3, employee.getGender());
      statement.setInt(4, employee.getAge());
      statement.setInt(5, cityIDByName);
      statement.executeUpdate();
    }
  }

  @Override
  public void deleteEmployeeById(int id) throws SQLException {
    try (final Connection connection = Application.getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "DELETE FROM employee WHERE id=(?)")) {
      statement.setInt(1, id);
      statement.executeUpdate();
    }
  }
}
