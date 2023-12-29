import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class book_delete {

	public static void main(String[] args) {
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE","razannael","Razan_11");       
		      Statement smt = conn.createStatement();
		      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		      while (true) {
		    	  System.out.print("Enter Deletion book ID :");
		    	  int bookId = Integer.parseInt(br.readLine());
		    	  
		    	 
		    	  
		    	  int count = smt.executeUpdate("delete from books where id = "+bookId);
		    	  
		    	  if(count==1)
		    		  System.out.println(count + "record deleted");
		    	  else
		    		  System.out.println("no record deleted");
		    	  
		    	  System.out.println("Do you want to delete more records[yes/no]?");
		    	  
		    	  String ch = br.readLine();
		    	  if(ch.equalsIgnoreCase("no"));
		    	     break;
		      }
		}catch(Exception e) {
			System.out.print(e);
		}

	}

}
