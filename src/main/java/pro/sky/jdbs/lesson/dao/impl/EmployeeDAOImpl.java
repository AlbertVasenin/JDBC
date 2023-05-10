package pro.sky.jdbs.lesson.dao.impl;

import static pro.sky.jdbs.lesson.HibernateConnectionFactory.getSession;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pro.sky.jdbs.lesson.dao.EmployeeDAO;
import pro.sky.jdbs.lesson.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {


  @Override
  public Integer addEmployee(Employee employee) {
    Integer id;
    try (Session session = getSession().openSession()) {
      Transaction transaction = session.beginTransaction();
      id = (Integer) session.save(employee);
      transaction.commit();
    }
    return id;
  }

  @Override
  public Employee getEmployeeByID(int id) {
    try (Session session = getSession().openSession()) {
      return session.get(Employee.class, id);
    }
  }

  @Override
  public List<Employee> readAll() {
    try (Session session = getSession().openSession()) {
      List<Employee> employees = session
          .createQuery("From Employee", Employee.class)
          .list();
      if (employees.isEmpty()) {
        throw new RuntimeException("Не существует в базе");
      } else {
        return employees;
      }
    }
  }

  public void updateEmployeeById(Employee employee, int id) {
    try (Session session = getSession().openSession()) {
      Transaction transaction = session.beginTransaction();
      employee.setId(id);
      session.merge(employee);
      transaction.commit();
    }
  }


  @Override
  public void deleteEmployeeById(int id) {
    try (Session session = getSession().openSession()) {
      Employee deletedEmployee = session.get(Employee.class, id);
      if (deletedEmployee == null) {
        throw new RuntimeException("Не существует в базе");
      } else {
        Transaction transaction = session.beginTransaction();
        session.remove(deletedEmployee);
        transaction.commit();
      }
    }
  }
}
