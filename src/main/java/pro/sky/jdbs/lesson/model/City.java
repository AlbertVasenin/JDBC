package pro.sky.jdbs.lesson.model;

import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "city")
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "city_id")
  private Integer cityId;
  @Column(name = "city_name")
  private String cityName;
  @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
  private List<Employee> employees;

  @Override
  public String toString() {
    return "City{" +
        "cityId=" + cityId +
        ", cityName='" + cityName + '\'' +
        ", employees=" + employees +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    City city = (City) o;
    return Objects.equals(cityId, city.cityId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cityId);
  }
}


