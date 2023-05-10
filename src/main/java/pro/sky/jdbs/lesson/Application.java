package pro.sky.jdbs.lesson;

import pro.sky.jdbs.lesson.dao.CityDAO;
import pro.sky.jdbs.lesson.dao.EmployeeDAO;
import pro.sky.jdbs.lesson.dao.impl.CityDAOImpl;
import pro.sky.jdbs.lesson.dao.impl.EmployeeDAOImpl;
import pro.sky.jdbs.lesson.model.City;
import pro.sky.jdbs.lesson.model.Employee;

public class Application {

  public static void main(String[] args) {
    City saratov = City.builder().cityName("Saratov").build();
    CityDAO cityDAO = new CityDAOImpl();
    cityDAO.add(saratov);
    System.out.println(cityDAO.getAllCity().contains(saratov));
    Employee employee = Employee.builder().id(12).firstName("Vasya").lastName("Petrov").gender("m")
        .age(30).city(saratov).build();
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    employeeDAO.addEmployee(employee);
    System.out.println(employeeDAO.readAll().contains(employee));

  }
}
