//REGISTRATION FORM//

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
public class RegForm
{
	JFrame frame;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField tf1,tf2,tf3;
	JPasswordField tf4,tf5;
	JButton b1,b2,b3;

 	public void start2()
 	{
		frame=new JFrame("REGISTRATION FORM");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width,screenSize.height);
		frame.setVisible(true);
		frame.setLayout(null);

		frame.getContentPane().setBackground(Color.CYAN);

		l1 = new JLabel("FOLLOW THE BELOW STEPS TO REGISTER YOURSELF :-");
		l1.setBounds(100,100,800,50);
		Font Font1 = new Font("Courier",Font.BOLD,28);
		l1.setFont(Font1);

		l2 = new JLabel("FIRST NAME :");
		l2.setBounds(100,200,220,30);
		Font Font2 = new Font("Courier",Font.BOLD,20);
		l2.setFont(Font2);

		l3 = new JLabel("LAST NAME :");
		l3.setBounds(100,250,220,30);
		l3.setFont(Font2);

		l4 = new JLabel("CREATE USERNAME :");
		l4.setBounds(100,300,220,30);
		l4.setFont(Font2);

		l5 = new JLabel("CREATE PASSWORD :");
		l5.setBounds(100,350,220,30);
		l5.setFont(Font2);

		l10 = new JLabel("CONFIRM PASSWORD :");
		l10.setBounds(100,400,220,30);
		l10.setFont(Font2);

		l6 = new JLabel("YOU HAVE REGISTERED SUCCESSFULLY, BACK TO LOGIN PAGE");
		l6.setBounds(100,550,800,30);
		l6.setFont(Font2);
		l6.setVisible(false);

		l7 = new JLabel("(minimum 8 characters required)");
		l7.setBounds(650,350,450,30);
		l7.setFont(Font2);

		l12 = new JLabel("(minimum 8 characters required)");
		l12.setBounds(650,400,450,30);
		l12.setFont(Font2);

		l8 = new JLabel("ERROR - ALL FIELDS SHOULD BE COMPULSORY FILLED");
		l8.setBounds(100,550,800,30);
		l8.setFont(Font2);
		l8.setVisible(false);

		l9 = new JLabel("ERROR - PASSWORD SHOULD BE OF MINIMUM 8 CHARACTERS");
		l9.setBounds(100,550,800,30);
		l9.setFont(Font2);
		l9.setVisible(false);

		l11 = new JLabel("ERROR - PASSWORD FIELDS NOT MATCHED");
		l11.setBounds(100,550,800,30);
		l11.setFont(Font2);
		l11.setVisible(false);

		tf1 = new JTextField();
		tf1.setBounds(350,200,300,30);
		tf1.setFont(Font2);

 		tf2 = new JTextField();
		tf2.setBounds(350,250,300,30);
		tf2.setFont(Font2);

		tf3 = new JTextField();
		tf3.setBounds(350,300,300,30);
		tf3.setFont(Font2);

		tf4 = new JPasswordField();
		tf4.setBounds(350,350,300,30);
		tf4.setFont(Font2);
		tf4.setEchoChar('*');

		tf5 = new JPasswordField();
		tf5.setBounds(350,400,300,30);
		tf5.setFont(Font2);
		tf5.setEchoChar('*');

		b1 = new JButton("SUBMIT");
		b1.setBounds(200,475,150,40);
		b1.setFont(Font2);

		b2 = new JButton("CLEAR");
		b2.setBounds(400,475,150,40);
		b2.setFont(Font2);

		b3 = new JButton("BACK");
		b3.setBounds(1300,80,150,50);
		Font Font3 = new Font("Courier",Font.BOLD,25);
		b3.setFont(Font3);

		frame.getContentPane().add(l1);
		frame.getContentPane().add(l2);
		frame.getContentPane().add(l3);
		frame.getContentPane().add(l4);
		frame.getContentPane().add(l5);
		frame.getContentPane().add(l6);
		frame.getContentPane().add(l7);
		frame.getContentPane().add(l8);
		frame.getContentPane().add(l9);
		frame.getContentPane().add(l10);
		frame.getContentPane().add(l11);
		frame.getContentPane().add(l12);
		frame.getContentPane().add(tf1);
		frame.getContentPane().add(tf2);
		frame.getContentPane().add(tf3);
		frame.getContentPane().add(tf4);
		frame.getContentPane().add(tf5);
		frame.getContentPane().add(b1);
		frame.getContentPane().add(b2);
		frame.getContentPane().add(b3);

		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String a=tf1.getText();
				String b=tf2.getText();
				String c=tf3.getText();
				String d=tf4.getText();
				String f=tf5.getText();
				if((a.length()==0) || (b.length()==0) || (c.length()==0)  || (d.length()==0) || f.length()==0)
				{
					l6.setVisible(false);
					l9.setVisible(false);
					l11.setVisible(false);
					l8.setVisible(true);
				}
				else if(d.length()<8 || f.length()<8)
				{
					l6.setVisible(false);
					l8.setVisible(false);
					l9.setVisible(true);
					l11.setVisible(false);
				}
				else if(d.equals(f)==false)
				{
					l6.setVisible(false);
					l8.setVisible(false);
					l9.setVisible(false);
					l11.setVisible(true);
				}
				else
				{
					l8.setVisible(false);
					l9.setVisible(false);
					l11.setVisible(false);
					l6.setVisible(true);
					try
					{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection conn = DriverManager.getConnection("jdbc:odbc:dsn");
						PreparedStatement pst =conn.prepareStatement("insert into Registration_Details(FirstName,LastName,UserName,PassWord) values(?,?,?,?)");
						pst.setString(1,a);
						pst.setString(2,b);
						pst.setString(3,c);
						pst.setString(4,d);
						pst.executeUpdate();
						pst.close();
						conn.close();
					}
					catch(Exception ie)
					{}

				}
			}
		});
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
					frame.setVisible(false);
					start2();
			}
		});
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
					Login a = new Login();
					a.init();
					frame.setVisible(false);
			}
		});
 	}
}