package pro.sky.jdbs.lesson.dao;

import java.util.List;
import pro.sky.jdbs.lesson.model.City;

public interface CityDAO {

  City getCityById(int id);

  Integer add(City city);

  List<City> getAllCity();

  City updateCity(City city);
}
