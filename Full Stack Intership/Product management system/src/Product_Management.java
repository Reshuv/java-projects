import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Product_Management extends JFrame implements ActionListener {
	
	private static final JButton JButton = null;
	JFrame p;
	JButton add,remove,update,search,list,execute,cancel,display;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t5;
	JComboBox listcb;
	int count=0;
	public Product_Management()
	{
		p=new JFrame("Product Management System");
		
		l1=new JLabel("Product ID ");
		l1.setBounds(100, 25, 70, 80);
		
		l2=new JLabel("Product Name ");
		l2.setBounds(100, 55, 90, 80);
		
		l3= new JLabel("Price ");
		l3.setBounds(100, 85, 60, 80);
		
		l4= new JLabel("Quantity ");
		l4.setBounds(100, 115, 60, 80);
		
		l5=  new JLabel("Company ");
		l5.setBounds(100, 145, 60, 80);
		
		add=new JButton("Add");
		add.setBounds(10, 10, 80, 30);
		add.addActionListener(this);
		
		remove=new JButton("Remove");
		remove.setBounds(100, 10, 80, 30);
		remove.addActionListener(this);
		
		update=new JButton("Update");
		update.setBounds(190, 10, 80, 30);
		update.addActionListener(this);
		
		search=new JButton("Search");
		search.setBounds(280, 10, 80, 30);
		search.addActionListener(this);
		
		list=new JButton("One by One");
		list.setBounds(370, 10, 120, 30);
		list.addActionListener(this);
		
		display=new JButton("Display ALL");
		display.setBounds(80, 210, 120, 30);
		display.addActionListener(this);
		
		execute=new JButton("Execute");
		execute.setBounds(210, 210, 80, 30);
		execute.addActionListener(this);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(300, 210, 80, 30);
		cancel.addActionListener(this);
		
		
		
		
		t1=new JTextField();
		t1.setBounds(220, 55, 120, 20);
		
		t2=new JTextField();
		t2.setBounds(220, 85, 120, 20);
		
		t3=new JTextField();
		t3.setBounds(220, 115, 120, 20);
		
		Vector v = new Vector();
		for(int i=1;i<=30;i++)
		{
			v.add(i);
		}
		
		listcb=new JComboBox(v);
		listcb.setBounds(220,145,40,20);
		
		t5=new JTextField();
		t5.setBounds(220, 175, 120, 20);
		
		disabled();
		
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(l4);
		p.add(l5);
		
		p.add(add);
		p.add(remove);
		p.add(update);
		p.add(search);
		p.add(list);
		p.add(execute);
		p.add(cancel);
		p.add(display);
		
		
		p.add(t1);
		p.add(t2);
		p.add(t3);
		p.add(listcb);
		p.add(t5);
		
		p.setLayout(null);
		p.setResizable(false);
		p.setSize(510,280);
		p.setVisible(true);
		p.setLocationRelativeTo(null);
		
	}
	void disabled()
	{
		t1.disable();
		t2.disable();
		t3.disable();
		listcb.disable();
		t5.disable();
	}
	void enabled()
	{
		t1.enable();
		t2.enable();
		t3.enable();
		t5.enable();
		listcb.enable();
	}
	
	void txtclear()
	{
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t5.setText("");
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		
		if(obj==add)
		{
			enabled();
			count=1;
		
		}
		else if(obj==remove)
		{
			t1.enable();
			count=2;
			
		}
		else if(obj==update)
		{
			enabled();
			count=3;
		}
		else if(obj==search)
		{
			t1.enable();
			count=4;
		}
		else if(obj==list)
		{
			List l1 = new List();
			//t1.enable();
			//count=5;
			//displayallrecord.display();
		}
		else if(obj==display){
			displayallrecord.display();
		}
		else if(obj==execute)
		{
			if(count == 1)
			{
				String pid=t1.getText().trim();
				String pname=t2.getText().trim();
				String price=t3.getText().trim();
				String qty=listcb.getItemAt(listcb.getSelectedIndex())+"";
				String company=t5.getText().trim();
				
				InsertIntoDatabase.insert(pid, pname, price,qty,company);
				txtclear();
				disabled();
			}
			else if(count == 2)
			{
				String pid=t1.getText().trim();
				DeleteFromDatabase.delete(pid);
				txtclear();
				disabled();
			}
			else if(count == 3)
			{
				String pid=t1.getText().trim();
				String pname=t2.getText().trim();
				String price=t3.getText().trim();
				String qty=listcb.getItemAt(listcb.getSelectedIndex())+"";
				String company=t5.getText().trim();
				
				UpdateDatabaseRecords.update(pid, pname, price,qty,company);
				txtclear();
				disabled();
			}
			else if(count == 4)
			{
				String pid=t1.getText().trim();
				SearchFromDatabase.search(pid);
				t2.setText(SearchFromDatabase.pname);
				t3.setText(SearchFromDatabase.price);
				listcb.setSelectedIndex(SearchFromDatabase.qty);
//				listcb.getComponent(SearchFromDatabase.qty);
				//t4.setText(SearchFromDatabase.pname);
				t5.setText(SearchFromDatabase.company);
				
//				txtclear();
//				disabled();
			}
			else if(count==5)
			{
				String pid=t1.getText().trim();
				new List();
				
				
			}
		}
		else if(obj==cancel)
		{
			System.exit(0);
		}	
	}
	public static void main(String[] args) {
		
		new Product_Management();
	}
}
