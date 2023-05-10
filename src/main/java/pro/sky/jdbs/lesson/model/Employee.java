package pro.sky.jdbs.lesson.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "gender")
  private String gender;
  @Column(name = "age")
  private int age;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "city_id")
  private City city;

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", gender='" + gender + '\'' +
        ", age=" + age +
        ", city=" + city +
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
    Employee employee = (Employee) o;
    return id == employee.id && age == employee.age && Objects.equals(firstName,
        employee.firstName) && Objects.equals(lastName, employee.lastName)
        && Objects.equals(gender, employee.gender) && Objects.equals(city,
        employee.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, gender, age, city);
  }
}
