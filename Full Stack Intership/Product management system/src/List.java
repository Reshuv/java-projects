//import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class List extends JFrame implements ActionListener {
	JFrame l;
	JButton prev,next;
	static JTextField t1,t2,t3,t4,t5;
	JLabel pid1,name,price,qty,company;
	static int r=0;
	static String rows[][] = new String [100][5];

	static int row=0;
	public List()
	{
		l=new JFrame("List");
		
		pid1=new JLabel("Product ID ");
		pid1.setBounds(10, 10, 70, 15);
		
		name=new JLabel("Product Name ");
		name.setBounds(10, 25, 90, 25);
		
		price = new JLabel("Price ");
		price.setBounds(10, 45, 60, 25);
		
		qty = new JLabel("Quantity ");
		qty.setBounds(10, 55, 60, 40);
		
		company =  new JLabel("Company ");
		company.setBounds(10, 65, 60, 60);
		
		t1=new JTextField();
		t1.setBounds(100, 10, 80, 20);
		
		t2=new JTextField();
		t2.setBounds(100, 30, 80, 20);
		
		t3=new JTextField();
		t3.setBounds(100, 50, 80, 20);
		
		t4=new JTextField();
		t4.setBounds(100, 70, 80, 20);
		
		t5=new JTextField();
		t5.setBounds(100, 90, 80, 20);
		

		
		prev = new JButton("prev");
		prev.setBounds(10,130,80,30);
		prev.addActionListener(this);
		
		next = new JButton("next");
		next.setBounds(105,130,80,30);
		next.addActionListener(this);
		
		l.add(pid1);
		l.add(name);
		l.add(price);
		l.add(qty);
		l.add(company);
		
		l.add(t1);
		l.add(t2);
		l.add(t3);
		l.add(t4);
		l.add(t5);
		
		l.add(prev);
		l.add(next);
		
		l.setSize(200,200);
		l.setLayout(null);
		l.setLocationRelativeTo(null);
		l.setVisible(true);
		l.setResizable(false);
		
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
		    t1.setText(rows[0][0]);
		    t2.setText(rows[0][1]);
		    t3.setText(rows[0][2]);
		    t4.setText(rows[0][3]);
		    t5.setText(rows[0][4]);
		    
		    
		  }
		
		  catch(Exception e)
		  {
			System.out.println(e);
		  }
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		
		if(obj==next)
		{
			if(r==row-1)
			{
				JOptionPane.showMessageDialog(null,"Last Record Found!!!");
			}
			else
			{
			r++;
			
		    t1.setText(rows[r][0]);
		    t2.setText(rows[r][1]);
		    t3.setText(rows[r][2]);
		    t4.setText(rows[r][3]);
		    t5.setText(rows[r][4]);
			}
			
			
			
		}
		else if(obj==prev)
		{
			if(r==0)
			{
				JOptionPane.showMessageDialog(null,"First Record Found!!!");
			}
			else{
			r--;
			t1.setText(rows[r][0]);
		    t2.setText(rows[r][1]);
		    t3.setText(rows[r][2]);
		    t4.setText(rows[r][3]);
		    t5.setText(rows[r][4]);
			}		    
		}
	}
	
	public static void main(String args[])
	{
		
		new List();
	}
}
