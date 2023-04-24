import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DeleteFromDatabase {
	public static void delete(String pid)
	{
		try 
		{
			DAO db=new DAO();
			Connection conn = db.getConnection();
		
			String deleteQuery="delete from product_management where pid=?";
		
			PreparedStatement preparedStatement;
		
			preparedStatement = conn.prepareStatement(deleteQuery);
			
			preparedStatement.setString(1,pid+"");
			
			int count = preparedStatement.executeUpdate();
			
			if(count == 0)
			{
				JOptionPane.showMessageDialog(null,"No Record Found","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Record Deleted Successfully");
			}
			}catch(Exception e){
			System.out.println(e);
		}
		
		
	}
}
