import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


public class SearchFromDatabase {
	static String pname,price,company;
	static int qty;
	public static void search(String pid)
	{
		try{
			DAO db = new DAO();
			Connection conn=db.getConnection();
		
			String searchQuery="select * from product_management where pid = ?";
			
			PreparedStatement ptstmt;
			ptstmt = conn.prepareStatement(searchQuery);
			ptstmt.setString(1,pid+"");
			
			ResultSet result=ptstmt.executeQuery();
			
			if(result.next()==true)
			{
				
				pname=result.getString(2);
				price=result.getString(3);
				qty=Integer.parseInt(result.getString(4));
				company=result.getString(5);
				
//				System.out.println("pid = "+result.getString(1));
//				System.out.println("pname = "+result.getString(2));
//				System.out.println("price = "+result.getString(3));
//				System.out.println("qty = "+result.getString(4));
//				System.out.println("company = "+result.getString(5));
//				System.out.println();
				JOptionPane.showMessageDialog(null,"Search  Successfull !!!");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please enter valid product ID","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
			
		}
	}
}
