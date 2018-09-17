import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDatabaseConnection {

    public static void main(String[] args) {
        makeJDBCconnection();
        System.out.print("\n Printing through the main.");
    }


    private static void makeJDBCconnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("\n Mysql JDBC Driver is Registered");

            Connection webcustomerConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_customer_tracker", "root", "root");

            if (webcustomerConnection != null) {
                System.out.println("\n MySQL connection is successful.");
            } else {
                throw new Exception("MySQL connection failed.");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
