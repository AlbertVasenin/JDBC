package pro.sky.jdbs.lesson.employee;

public class Employee {

  private int id;
  private final String firstName;
  private final String lastName;
  private final String gender;
  private final int age;
  private final String cityName;

  public Employee(int id, String firstName, String lastName, String gender, int age,
      String cityName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.age = age;
    this.cityName = cityName;
  }

  public Employee(String firstName, String lastName, String gender, int age, String cityName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.age = age;
    this.cityName = cityName;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getGender() {
    return gender;
  }

  public int getAge() {
    return age;
  }

  public String getCityName() {
    return cityName;
  }

  @Override
  public String toString() {
    return "Employee: " +
        " id: " + id +
        ", firstName: " + firstName +
        ", lastName: " + lastName +
        ", gender: " + gender +
        ", age: " + age +
        ", cityName: " + cityName +
        "\n";
  }
}
