import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class book_select {

	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE","razannael","Razan_11");    
		    Statement smt = conn.createStatement();
		    ResultSet rs = smt.executeQuery("select * from books");
		    while(rs.next()) {
		    	int bid = rs.getInt(1);
		    	String btitle = rs.getString(2);
		    	String bauther = rs.getNString(3);
		    	int bqty = rs.getInt(4);
		    	double bprice = rs.getDouble(5);
		    	
		    	System.out.println("Book ID : " +bid);
		    	System.out.println("Book Title : " +btitle);
		    	System.out.println("Book Auther : " +bauther);
		    	System.out.println("Book Quantity : " +bqty);
		    	System.out.println("Book Price : " +bprice);
		    	System.out.println("\n");
		    	
		    }   
		      
	 	}catch(Exception e) {
			System.out.print(e);
		} 

	}

}
