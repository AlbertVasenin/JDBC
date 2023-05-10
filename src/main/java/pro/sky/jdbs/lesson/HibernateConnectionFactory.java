package pro.sky.jdbs.lesson;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pro.sky.jdbs.lesson.model.City;
import pro.sky.jdbs.lesson.model.Employee;

public class HibernateConnectionFactory {
  private static SessionFactory sessionFactory;

  private HibernateConnectionFactory() {
  }

  public static SessionFactory getSession() {
    if (sessionFactory == null) {
      try {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(City.class);
        configuration.addAnnotatedClass(Employee.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(
            configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return sessionFactory;
  }
}
