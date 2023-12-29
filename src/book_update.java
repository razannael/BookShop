import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class book_update {

    public static void main(String[] args) {
        int bid;
        String btitle, bauthor;
        int bqty;
        double bprice;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE", "razannael", "Razan_11");

            // Use PreparedStatement to avoid SQL injection
            String updateQuery = "UPDATE book SET title=?, author=?, qty=?, price=? WHERE id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter book ID: ");
            bid = Integer.parseInt(br.readLine());

            System.out.print("Enter book Title: ");
            btitle = br.readLine();

            System.out.print("Enter book Author: ");
            bauthor = br.readLine();

            System.out.print("Enter book Quantity: ");
            bqty = Integer.parseInt(br.readLine());

            System.out.print("Enter book Price: ");
            bprice = Double.parseDouble(br.readLine());

            // Set parameters for the PreparedStatement
            preparedStatement.setString(1, btitle);
            preparedStatement.setString(2, bauthor);
            preparedStatement.setInt(3, bqty);
            preparedStatement.setDouble(4, bprice);
            preparedStatement.setInt(5, bid);

            // Execute the update
            int count = preparedStatement.executeUpdate();

            if (count > 0)
                System.out.println(count + " rows updated");
            else
                System.out.println("No records updated");

            // Close resources
            preparedStatement.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException | NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}
