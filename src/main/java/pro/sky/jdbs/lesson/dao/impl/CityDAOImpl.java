package pro.sky.jdbs.lesson.dao.impl;
import static pro.sky.jdbs.lesson.HibernateConnectionFactory.getSession;
import org.hibernate.Session;
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
}


