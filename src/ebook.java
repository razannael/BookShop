import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class ebook {

	public static void main(String[] args) {
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE","razannael","Razan_11");       
		      Statement smt = conn.createStatement();
		      smt.executeUpdate("create table books(id number , title VARCHAR(50), auther VARCHAR(50) , qty number)");
		      System.out.print("Table created successfully");
		      conn.close();
		}catch(Exception e) {
			System.out.print(e);
		}

	}

}
