package pro.sky.jdbs.lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {

  public static void main(String[] args) throws SQLException {
//    String query = "SELECT * FROM employee WHERE id = ?";
//    try (Connection connection = getConnection();
//        PreparedStatement statement = connection.prepareStatement(
//        query)) {
//
//      statement.setInt(1, 1);
//      statement.execute();
//
//      try (ResultSet resultSet = statement.getResultSet()) {
//
//        while (resultSet.next()) {
//          int id = resultSet.getInt(1);
//          System.out.print(" id: " + id);
//          String name = resultSet.getString(2);
//          System.out.print(" name: " + name);
//          String lastName = resultSet.getString(3);
//          System.out.print(" lastName: " + lastName);
//        }
//      }
//    }
    getEmployeeById(5);
  }

  private static Connection getConnection() throws SQLException {
    final String url = "jdbc:postgresql://localhost:1987/skypro";
    final String user = "postgres";
    final String password = "3848";
    return DriverManager.getConnection(url, user, password);
  }

  public static void getEmployeeById(int id) throws SQLException {
    try (final Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(
        "SELECT * FROM employee WHERE id = ?")) {

      statement.setInt(1, id);

      ResultSet resultSet = statement.executeQuery();
      resultSet.next();

      System.out.println((resultSet.getInt("id") + " " + resultSet.getString("first_name") + " "
          + resultSet.getString("last_name") + " " + resultSet.getString("gender") + " "
          + resultSet.getInt("age")));
    }
  }
}
