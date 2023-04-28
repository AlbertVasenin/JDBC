package pro.sky.jdbs.lesson.city;

public class City {
  private final Integer cityId;
  private final String cityName;

  public City(Integer cityId, String cityName) {
    this.cityId = cityId;
    this.cityName = cityName;
  }

  public Integer getCityId() {
    return cityId;
  }

  public String getCityName() {
    return cityName;
  }

  @Override
  public String toString() {
    return cityName;
  }
}
