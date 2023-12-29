import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class book_insert {

	public static void main(String[] args) {
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE","razannael","Razan_11");       
              PreparedStatement psmt = conn.prepareStatement("insert into books values(?,?,?,?,?)");
		      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		      while (true) {
		    	  System.out.print("Enter book ID :");
		    	  int bookId = Integer.parseInt(br.readLine());
		    	  
		    	  System.out.print("Enter book Title :");
		    	  String bookTitle = br.readLine();
		    	  
		    	  System.out.print("Enter book Auther :");
		    	  String bookAuther = br.readLine();
		    	  
		    	  System.out.print("Enter book Quantity :");
		    	  int bookQuantity = Integer.parseInt(br.readLine());
		    	  
		    	  System.out.print("Enter book Price :");
		    	  double bookPrice = Double.parseDouble(br.readLine());
		    	  
		    	  psmt.setInt(1, bookId);
		    	  psmt.setString(2, bookTitle);
		    	  psmt.setString(3, bookAuther);
		    	  psmt.setInt(4, bookQuantity);
		    	  psmt.setDouble(5, bookPrice);
		    	  
		    	  int count = psmt.executeUpdate();
		    	  
		    	  if(count>0)
		    		  System.out.println(count + "record inserted");
		    	  else
		    		  System.out.println("no record inserted");
		    	  
		    	  System.out.println("Do you want more records[yes/no]?");
		    	  
		    	  String ch = br.readLine();
		    	  if(ch.equalsIgnoreCase("no"));
		    	     break;
		      }
		}catch(Exception e) {
			System.out.print(e);
		}


	}

}

