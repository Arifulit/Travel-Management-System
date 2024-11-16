package travel.management.system;

import java.sql.*;

public class Conn implements AutoCloseable {
    Connection c;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagmentsystem", "root", "ariful&&15");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (c != null) {
            c.close();
        }
    }

    class s {

        static ResultSet executeQuery(String displayCustomersql) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public s() {
        }
    }
}
