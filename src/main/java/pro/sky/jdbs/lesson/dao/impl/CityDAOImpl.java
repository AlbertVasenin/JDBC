package pro.sky.jdbs.lesson.dao.impl;

import static pro.sky.jdbs.lesson.HibernateConnectionFactory.getSession;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pro.sky.jdbs.lesson.dao.CityDAO;
import pro.sky.jdbs.lesson.model.City;

public class CityDAOImpl implements CityDAO {

  @Override
  public City getCityById(int id) {
    try (Session session = getSession().openSession()) {
      City city = session.get(City.class, id);
      if (city == null) {
        throw new RuntimeException("Не существует в базе");
      } else {
        return city;
      }
    }
  }

  @Override
  public Integer add(City city) {
    Integer id;
    try (Session session = getSession().openSession()) {
      Transaction transaction = session.beginTransaction();
      id = (Integer) session.save(city);
      transaction.commit();
    }
    return id;
  }

  @Override
  public List<City> getAllCity() {
    try (Session session = getSession().openSession()) {
      return session.createQuery("From City", City.class).list();
    }
  }

  @Override
  public City updateCity(City city) {
    City newCity;
    try (Session session = getSession().openSession()) {
      Transaction transaction = session.beginTransaction();
      newCity = (City) session.merge(city);
      transaction.commit();
    }
    return newCity;
  }
}


