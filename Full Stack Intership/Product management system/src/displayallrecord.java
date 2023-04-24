import java.io.*;
import java.sql.*;

public class displayallrecord
{
	static String rows[][] = new String [100][5];

	static int row=0;
	public static void display() 
	{	   	
	 try
	  {
		DAO db=new DAO();
		Connection conn=db.getConnection();
				
	    String selectQuery = "select * from  product_management";
	    	    	    
	    PreparedStatement preparedStatement = 
	    	conn.prepareStatement(selectQuery);

	    ResultSet result = preparedStatement.executeQuery();
	      	      
	    while (result.next())
        {	    	
			for (int i = 0; i < 5; i++)
				rows[row][i] =result.getString((i+1));
			
			row++;
			
	    }
	    DisplayRecord.populateArray(rows);
	  }
	  catch(Exception e)
	  {
		System.out.println(e);
	  }
	  
    }
	public static void main(String[] args) throws Exception 
	{
		displayallrecord.display();
	}
}
