package pro.sky.jdbs.lesson.dao;

import java.sql.SQLException;
import pro.sky.jdbs.lesson.city.City;

public interface CityDAO {

  City getCityByID(int id) throws SQLException;

  int getCityIDByName(String name) throws SQLException;
}
