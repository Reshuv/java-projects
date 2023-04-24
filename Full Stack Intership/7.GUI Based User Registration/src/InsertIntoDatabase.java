import java.io.*;
import java.sql.*;

import javax.swing.JOptionPane;

public class InsertIntoDatabase 
{
	public static void insert(String id,String name,String pass) 
	{	   	
	 try
	  {
		DAO db=new DAO();
		Connection conn=db.getConnection();
				   
	    String insertQuery = "insert into registration values(?,?,?)";
	    PreparedStatement preparedStatement;
		
	    preparedStatement = conn.prepareStatement(insertQuery);
	    preparedStatement.setString(1,id);
	    preparedStatement.setString(2,name);
	    preparedStatement.setString(3,pass);
			
	    preparedStatement.executeUpdate();
	    System.out.println("Data  Successfully Inserted !!!");
	    JOptionPane.showMessageDialog(null,"Data  Successfully Inserted !!!");
	  }
	 catch(Exception e)
	 {
		 System.out.println(e);
		 JOptionPane.showMessageDialog(null, "User Already Register with given Id","",JOptionPane.ERROR_MESSAGE);	 
	 }
  }
}
