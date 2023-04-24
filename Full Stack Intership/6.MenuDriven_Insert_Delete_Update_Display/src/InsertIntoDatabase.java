import java.io.*;
import java.sql.*;

public class InsertIntoDatabase 
{
	public static void insert() 
	{	   	
	 try
	  {
		DAO db=new DAO();
		Connection conn=db.getConnection();
				
 	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   
	    System.out.println("Enter User Id");
	    int id=Integer.parseInt(br.readLine());

 	    System.out.println("Enter User Name");
	    String user=br.readLine();
	   	   
	    System.out.println("Enter Password");
	    String pass=br.readLine();
	   	   
	    String insertQuery = "insert into registration values(?,?,?)";
	    PreparedStatement preparedStatement;
		
	    preparedStatement = conn.prepareStatement(insertQuery);
	    preparedStatement.setString(1,id+"");
	    preparedStatement.setString(2,user);
	    preparedStatement.setString(3,pass);
			
	    preparedStatement.executeUpdate();
	    System.out.println("Data  Successfully Inserted !!!");
	 }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
  }
}
