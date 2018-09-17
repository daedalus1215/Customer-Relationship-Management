
import com.larry.github.Customer.ValueObject.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        makeJDBCconnection();
        System.out.print("\n Printing through the main.");
    }


    private static void makeJDBCconnection() {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class);
        Session session = configuration.buildSessionFactory().openSession();



        session.beginTransaction();

        Customer customerDTO = new Customer();
        customerDTO.setEmail("AHam@yahoo.com");
        customerDTO.setFirstName("Alexander");
        customerDTO.setLastName("Hamilton");
        session.save(customerDTO);

        session.getTransaction().commit();

        Query q = session.createQuery("from Customer order by lastName");

        List<Customer> customerList = q.list();

        System.out.println("\n customerLIst size: " + customerList.size());

    }
}
