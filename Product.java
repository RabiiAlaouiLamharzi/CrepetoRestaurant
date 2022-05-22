import java.sql.*;

public class Product {

    public static void main(String args[]) {
        String url = "jdbc:postgresql://localhost/lamharzialaouir";
        String uid = "lamharzialaouir";
        String pw = "postrabii";

        try ( Connection conn = DriverManager.getConnection(url, uid, pw); // Setup connection with DB
              Statement stmt = conn.createStatement() )  // Statements allow to issue SQL queries to the DB
        {
            // Result set get the result of the SQL query
            ResultSet rst = stmt.executeQuery("SELECT product_id, product_name, product_quantity FROM Product;");

            System.out.println("Product Code *** Product Name *** Product Quantity");

            while (rst.next())
                System.out.println(rst.getString("product_id") + " *** " +
                                   rst.getString("product_name") + " *** " +
                                   rst.getDouble("product_quantity"));
        }
        catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }
}
