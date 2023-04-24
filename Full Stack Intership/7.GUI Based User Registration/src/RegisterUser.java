import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.applet.*;

public class RegisterUser implements ActionListener
{
	private JPanel jpInfo = new JPanel();

	private JLabel lbNo, lbName, lbPass;
	private JTextField txtNo, txtName, txtPass;
	private JButton btnSave, btnCancel;

	static JFrame frame=new JFrame();

	RegisterUser ()
	{
		frame.setTitle("Registration System");
		frame.setSize (574, 240);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		jpInfo.setBounds (0, 0, 500, 115);
		jpInfo.setLayout (null);

		lbNo = new JLabel ("User_No:");
		lbNo.setForeground (Color.black);
		lbNo.setBounds (265, 30, 90, 25);

        lbName = new JLabel ("User Name:");
		lbName.setForeground (Color.black);
        lbName.setBounds (265, 70, 90, 25);

		lbPass = new JLabel ("Password:");
		lbPass.setForeground (Color.black);
		lbPass.setBounds (265, 110, 90, 25);

		txtNo = new JTextField ();
		txtNo.setHorizontalAlignment (JTextField.RIGHT);
		txtNo.setBounds (355, 30, 205, 25);

		txtName = new JTextField ();
		txtName.setHorizontalAlignment (JTextField.RIGHT);
		txtName.setBounds (355, 70, 205, 25);

		txtPass = new JTextField ();
		txtPass.setHorizontalAlignment (JTextField.RIGHT);
		txtPass.setBounds (355, 110, 205, 25);

		btnSave = new JButton ("Save");
		btnSave.setBounds (275, 150, 135, 35);
		btnSave.addActionListener (this);

		btnCancel = new JButton ("Cancel");
		btnCancel.setBounds (415, 150, 135, 35);
		btnCancel.addActionListener (this);

		txtNo.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (!((Character.isDigit (c) || (c == KeyEvent.VK_BACK_SPACE))))
				{
					frame.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);

		txtName.addKeyListener (new KeyAdapter()
		{
			public void keyTyped (KeyEvent ke)
			{
				char c = ke.getKeyChar ();
				if (Character.isDigit (c))// || (c == KeyEvent.VK_BACK_SPACE))))
				{
					frame.getToolkit().beep ();
					ke.consume ();
      			}
    		}
  		}
		);

		JPanel panel = new JPanel ();
        JLabel label = new JLabel();
        panel.setBounds(0,5,260,230);
        label.setIcon(new ImageIcon("./reg.jpg"));// your image here
        panel.add(label);

		//Adding the All the Controls to Panel.
		jpInfo.add (lbNo);
		jpInfo.add (txtNo);

		jpInfo.add (lbName);
		jpInfo.add (txtName);

		jpInfo.add (lbPass);
		jpInfo.add (txtPass);
		jpInfo.add (btnSave);
		jpInfo.add (btnCancel);
		jpInfo.add (panel);

		frame.getContentPane().add (jpInfo);
		frame.setVisible (true);
		frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
}

		public void actionPerformed (ActionEvent ae)
		{
		  Object obj = ae.getSource();

		  if(obj == btnSave)
		  {
			if (txtNo.getText().equals(""))
			{
				JOptionPane.showMessageDialog
				  (frame, "Please! Provide User number.",
				                "Registration System - EmptyField",
				                JOptionPane.PLAIN_MESSAGE);

				txtNo.requestFocus();
			}
			else if (txtName.getText().equals(""))
			{
				JOptionPane.showMessageDialog (frame,
				                 "Please! Provide User Name.",
				                 "Registration System - EmptyField",
				                 JOptionPane.PLAIN_MESSAGE);

			    txtName.requestFocus ();
			}
			else if (txtPass.getText().equals(""))
			{
				JOptionPane.showMessageDialog (frame,
				                           "Please! Provide Password.",
				                            "Registration System - EmptyField",
				                            JOptionPane.PLAIN_MESSAGE);
				txtNo.requestFocus ();
			}
			else
			{
				String id=txtNo.getText().trim();
				String name=txtName.getText().trim();
				String pass=txtPass.getText().trim();
				InsertIntoDatabase.insert(id, name, pass);
				txtClear ();
			}
		}
		if (obj == btnCancel)
		{
			frame.setVisible (false);   frame.dispose();     System.exit(0);
		}
	}
	void txtClear ()
	{
		txtNo.setText ("");    txtName.setText ("");  txtPass.setText ("");
		txtNo.requestFocus ();
	}
	public static void main(String args[])
	{
		RegisterUser rt=new RegisterUser();
	}
}