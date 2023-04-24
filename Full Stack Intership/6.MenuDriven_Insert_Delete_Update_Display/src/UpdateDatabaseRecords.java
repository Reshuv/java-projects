import java.io.*;
import java.sql.*;

public class UpdateDatabaseRecords 
{
	public static void update() 
	{	   	
	 try
	  {
		DAO db=new DAO();
		Connection conn=db.getConnection();
				
 	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   
	    System.out.println("Enter User Id to modify");
	    int id=Integer.parseInt(br.readLine());

 	    System.out.println("Enter new User Name");
	    String user=br.readLine();
	   	   
	    System.out.println("Enter new Password");
	    String pass=br.readLine();
	   	   
		String selectquery = "update registration set name=?,pass=? where id=?";

		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(selectquery);

		pstmt.setString(1, user);
		
		pstmt.setString(2,pass);

		pstmt.setString(3,id+"");
				
		int count = pstmt.executeUpdate();
		
		if(count==0)		
   		   System.out.println("No Recored Found with ID= "+id);
		else
			System.out.println("Record Id "+id+ " Data Successfully Updated !!!");
	 }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
  }
}
