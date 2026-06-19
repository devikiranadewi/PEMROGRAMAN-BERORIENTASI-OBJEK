import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/pbo";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection getConnection() {

        Connection con = null;

        try {

            con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (SQLException e) {

            System.out.println(
                    "Koneksi gagal : "
                            + e.getMessage()
            );
        }

        return con;
    }
}