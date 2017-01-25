/* ======== DOES NOT WORK =========

package library;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 23/12/2016.
 */
public class IMS{

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL ="jdbc:mysql://localhost/library";;

    private static final String USER = "username";
    private static final String PASS = "password";

    private Connection connection;
    private Statement stmt = null;

    IMS(){

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = connection.createStatement();
            String sql = "INSERT INTO CUSTOMERS VALUES( 1, 'ALEX', '13-08-1995')";
            stmt.executeUpdate(sql);

            System.out.println("Item added...!");
        } catch (ClassNotFoundException|SQLException e){
            System.out.println("Error Creating DB");
        }
    }



    void close(){
        try{
            if(stmt!=null) stmt.close();
            if(connection!=null) connection.close();
        } catch (SQLException e){
            System.out.println("Closing failed");
        }
    }
}
*/