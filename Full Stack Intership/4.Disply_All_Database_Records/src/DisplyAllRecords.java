import java.io.*;
import java.sql.*;

public class DisplyAllRecords
{
	public static void main(String[] args)
	{
	 try
	  {
		DAO db=new DAO();
		Connection conn=db.getConnection();

	    String selectQuery = "select * from  registration";

	    PreparedStatement preparedStatement =
	                  conn.prepareStatement(selectQuery);

	    ResultSet result = preparedStatement.executeQuery();

	    while (result.next())
        {
	    	System.out.print("Id= "+result.getString(1));
	    	System.out.print("  Name= "+result.getString(2));
	    	System.out.print("  Password= "+result.getString(3));
	    	System.out.println();
	    }
	  }
	  catch(Exception e)
	  {
		System.out.println(e);
	  }
    }
}
