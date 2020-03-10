//SOLUTION FOR QUADRATIC EQUATIONS//

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.lang.Math;

class Quadratic
{
	int cnt;
	JFrame frame;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField tf1,tf2,tf3,tf4,tf5;
	JButton b1,b2,b3,b4;
	public void start4()
	{
		frame=new JFrame("SOLUTION FOR QUADRATIC EQUATIONS");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width,screenSize.height);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);

		l1 = new JLabel("YOU HAVE SELECTED QUADRATIC EQUATIONS");
		l1.setBounds(100,100,800,30);
		Font Font1 = new Font("Courier",Font.BOLD,20);
		l1.setFont(Font1);

		l2 = new JLabel("Like, (aX^2 + bX + c = 0) ");
		l2.setBounds(100,130,800,30);
		l2.setFont(Font1);

		l3 = new JLabel("ENTER THE VALUES OF COEFFICIENTS :");
		l3.setBounds(100,200,800,30);
		l3.setFont(Font1);

		l4 = new JLabel("a =");
		l4.setBounds(100,250,50,30);
		l4.setFont(Font1);

		l5 = new JLabel("b =");
		l5.setBounds(100,290,50,30);
		l5.setFont(Font1);

		l6 = new JLabel("c =");
		l6.setBounds(100,330,50,30);
		l6.setFont(Font1);

		l7 = new JLabel("SOLUTION IS :-");
		l7.setBounds(100,430,500,40);
		l7.setFont(Font1);
		l7.setVisible(false);

		l8 = new JLabel("x1 =");
		l8.setBounds(100,480,50,30);
		l8.setFont(Font1);
		l8.setVisible(false);

		l9 = new JLabel("x2 =");
		l9.setBounds(100,520,50,30);
		l9.setFont(Font1);
		l9.setVisible(false);

		l10 = new JLabel("ERROR - INVALID QUADRATIC EQUATION");
		l10.setBounds(280,580,500,30);
		l10.setFont(Font1);
		l10.setVisible(false);

		l11 = new JLabel("THANK YOU ,VISIT AGAIN...");
		l11.setBounds(100,650,400,40);
		Font Font2 = new Font("Courier",Font.BOLD,26);
		l11.setFont(Font2);
		l11.setVisible(false);

		l12 = new JLabel("PLEASE ENTER ALL VALUES OF COEFFICIENTS");
		l12.setBounds(100,430,500,40);
		l12.setFont(Font1);
		l12.setVisible(false);

		tf1 = new JTextField();
		tf1.setBounds(180,250,150,30);
		tf1.setFont(Font1);

 		tf2 = new JTextField();
		tf2.setBounds(180,290,150,30);
		tf2.setFont(Font1);

		tf3 = new JTextField();
		tf3.setBounds(180,330,150,30);
		tf3.setFont(Font1);

		tf4 = new JTextField();
		tf4.setBounds(180,480,300,30);
		tf4.setFont(Font1);
		tf4.setVisible(false);

 		tf5 = new JTextField();
		tf5.setBounds(180,520,300,30);
		tf5.setFont(Font1);
		tf5.setVisible(false);

		b1 = new JButton("SOLVE");
		b1.setBounds(100,380,150,40);
		b1.setFont(Font1);

		b2 = new JButton("BACK");
		b2.setBounds(1300,80,150,50);
		b2.setFont(Font2);

		b3 = new JButton("CLEAR");
		b3.setBounds(100,580,150,40);
		b3.setFont(Font1);
		b3.setVisible(false);

		b4 = new JButton("CLICK HERE, TO GO LOGIN PAGE");
		b4.setBounds(100,710,400,40);
		b4.setFont(Font1);
		b4.setVisible(false);


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
		frame.getContentPane().add(b4);

		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String p = tf1.getText();
				String q = tf2.getText();
				String r = tf3.getText();
				if(p.length()==0 || q.length()==0 || r.length()==0)
				{
					l7.setVisible(false);
					l8.setVisible(false);
					l9.setVisible(false);
					tf4.setVisible(false);
					tf5.setVisible(false);
					b3.setVisible(false);
					l10.setVisible(false);
					l11.setVisible(false);
					b4.setVisible(false);
					l12.setVisible(true);
				}
				else
				{
					l12.setVisible(false);
					l7.setVisible(true);
					l8.setVisible(true);
					l9.setVisible(true);
					tf4.setVisible(true);
					tf5.setVisible(true);
					b3.setVisible(true);
					double a = Double.parseDouble(tf1.getText());
					double b = Double.parseDouble(tf2.getText());
					double c = Double.parseDouble(tf3.getText());
					double d = (b*b-4*a*c);
					double x1 = ((-b-(Math.sqrt(d)))/(2*a));
					double x2 = ((-b+(Math.sqrt(d)))/(2*a));
					tf4.setText(Double.toString(x1));
					tf5.setText(Double.toString(x2));

					String m = p+"X^2 + "+q+"X + "+r+" = 0";
					String n = "X1 = "+x1+" and X2 = "+x2;


					try
					{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection conn = DriverManager.getConnection("jdbc:odbc:dsn");
						PreparedStatement pst1 = conn.prepareStatement("select * from Summary_Table");
						ResultSet rs = pst1.executeQuery();
						while(rs.next())
						{
							cnt++;
						}
						PreparedStatement pst =conn.prepareStatement("update Summary_Table set Equations=?,Solution=? where SrNo = '"+cnt+"'");
						pst.setString(1,m);
						pst.setString(2,n);
						pst.executeUpdate();
						pst1.executeUpdate();
						pst.close();
						pst1.close();
						conn.close();
					}
					catch(Exception ie)
					{}

					if(d<0)
					{
						l10.setVisible(true);
						l11.setVisible(true);
						b4.setVisible(true);
					}
					else
					{
						l10.setVisible(false);
						l11.setVisible(true);
						b4.setVisible(true);
					}
				}
			}
		});

		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Login r = new Login();
				r.Insert();
				Welcome a = new Welcome();
				a.start1();
				frame.setVisible(false);
			}
		});

		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Login r = new Login();
				r.Insert();
				frame.setVisible(false);
				start4();
			}
		});

		b4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
				Login p = new Login();
				p.init();
			}
		});
	}
}