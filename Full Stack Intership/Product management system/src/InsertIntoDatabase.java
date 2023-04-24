import java.io.*;
import java.sql.*;

import javax.swing.JOptionPane;

public class InsertIntoDatabase 
{
	public static void insert(String pid,String pname,String price,String qty,String company) 
	{	   	
	 try
	  {
		DAO db=new DAO();
		Connection conn=db.getConnection();
				   
	    String insertQuery = "insert into product_management values(?,?,?,?,?)";
	    PreparedStatement preparedStatement;
		
	    preparedStatement = conn.prepareStatement(insertQuery);
	    preparedStatement.setString(1,pid);
	    preparedStatement.setString(2,pname);
	    preparedStatement.setString(3,price);
	    preparedStatement.setString(4,qty);
	    preparedStatement.setString(5,company);
	    
			
	    preparedStatement.executeUpdate();
	    JOptionPane.showMessageDialog(null,"Data  Successfully Inserted !!!");
	  }
	 catch(Exception e)
	 {
		 //System.out.println(e);
		 JOptionPane.showMessageDialog(null, "User Already Register with given Id","ERROR",JOptionPane.ERROR_MESSAGE);	 
	 }
  }
}
