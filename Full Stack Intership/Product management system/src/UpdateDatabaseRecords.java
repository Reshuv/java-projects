import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


public class UpdateDatabaseRecords {
	public static void update(String pid,String pname,String price,String qty,String company)
	{
		try{
			DAO db = new DAO();
			Connection conn = db.getConnection();
			
			String selectQuery="update product_management set pname=? , price=? , qty=? , company=? where pid=?";
			
			
			
			PreparedStatement pstmt=null;
			
			pstmt =conn.prepareStatement(selectQuery);
			
			pstmt.setString(1,pname);
			
			pstmt.setString(2,price);
			
			pstmt.setString(3,qty+"");
			
			pstmt.setString(4,company+"");
			
			pstmt.setString(5,pid+"");
			
			int count=pstmt.executeUpdate();
			
			if(count == 0)
			{
				JOptionPane.showMessageDialog(null, "No record found with ID = "+pid+"!!","ERROR",JOptionPane.ERROR_MESSAGE);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Product ID: "+pid+" Data successsfully Updated!");			
			}
		}
	
		catch(Exception e){
			System.out.println(e);
		}
	}
}
