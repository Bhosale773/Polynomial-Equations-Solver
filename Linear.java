//SOLUTION FOR LINEAR EQUATIONS//

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Linear
{
	int cnt;
	JFrame frame;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
	JButton b1,b2,b3,b4;
	public void start3()
	{
		frame=new JFrame("SOLUTION FOR LINEAR EQUATIONS");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width,screenSize.height);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);

		l1 = new JLabel("YOU HAVE SELECTED LINEAR EQUATIONS");
		l1.setBounds(100,100,800,30);
		Font Font1 = new Font("Courier",Font.BOLD,20);
		l1.setFont(Font1);

		l2 = new JLabel("Like, (a1X + b1Y = c1) and (a2X + b2Y = c2)");
		l2.setBounds(100,130,800,30);
		l2.setFont(Font1);

		l3 = new JLabel("ENTER THE VALUES OF COEFFICIENTS :");
		l3.setBounds(100,200,800,30);
		l3.setFont(Font1);

		l4 = new JLabel("a1 =");
		l4.setBounds(100,250,50,30);
		l4.setFont(Font1);

		l5 = new JLabel("b1 =");
		l5.setBounds(100,290,50,30);
		l5.setFont(Font1);

		l6 = new JLabel("c1 =");
		l6.setBounds(100,330,50,30);
		l6.setFont(Font1);

		l7 = new JLabel("a2 =");
		l7.setBounds(400,250,50,30);
		l7.setFont(Font1);

		l8 = new JLabel("b2 =");
		l8.setBounds(400,290,50,30);
		l8.setFont(Font1);

		l9 = new JLabel("c2 =");
		l9.setBounds(400,330,50,30);
		l9.setFont(Font1);

		l10 = new JLabel("SOLUTION IS :-");
		l10.setBounds(100,430,500,40);
		l10.setFont(Font1);
		l10.setVisible(false);

		l11 = new JLabel("x =");
		l11.setBounds(100,480,50,30);
		l11.setFont(Font1);
		l11.setVisible(false);

		l12 = new JLabel("y =");
		l12.setBounds(100,520,50,30);
		l12.setFont(Font1);
		l12.setVisible(false);

		l13 = new JLabel("THANK YOU ,VISIT AGAIN...");
		l13.setBounds(100,640,400,40);
		Font Font2 = new Font("Courier",Font.BOLD,26);
		l13.setFont(Font2);
		l13.setVisible(false);

		l14 = new JLabel("PLEASE ENTER ALL VALUES OF COEFFICIENTS");
		l14.setBounds(100,430,500,40);
		l14.setFont(Font1);
		l14.setVisible(false);


		tf1 = new JTextField();
		tf1.setBounds(200,250,150,30);
		tf1.setFont(Font1);

 		tf2 = new JTextField();
		tf2.setBounds(200,290,150,30);
		tf2.setFont(Font1);

		tf3 = new JTextField();
		tf3.setBounds(200,330,150,30);
		tf3.setFont(Font1);

		tf4 = new JTextField();
		tf4.setBounds(500,250,150,30);
		tf4.setFont(Font1);

		tf5 = new JTextField();
		tf5.setBounds(500,290,150,30);
		tf5.setFont(Font1);

		tf6 = new JTextField();
		tf6.setBounds(500,330,150,30);
		tf6.setFont(Font1);

		tf7 = new JTextField();
		tf7.setBounds(150,480,300,30);
		tf7.setFont(Font1);
		tf7.setVisible(false);

 		tf8 = new JTextField();
		tf8.setBounds(150,520,300,30);
		tf8.setFont(Font1);
		tf8.setVisible(false);

		b1 = new JButton("SOLVE");
		b1.setBounds(100,380,150,40);
		b1.setFont(Font1);

		b2 = new JButton("BACK");
		b2.setBounds(1300,80,150,50);
		b2.setFont(Font2);

		b3 = new JButton("CLEAR");
		b3.setBounds(100,570,150,40);
		b3.setFont(Font1);
		b3.setVisible(false);

		b4 = new JButton("CLICK HERE, TO GO LOGIN PAGE");
		b4.setBounds(100,700,400,40);
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
		frame.getContentPane().add(l13);
		frame.getContentPane().add(l14);
		frame.getContentPane().add(tf1);
		frame.getContentPane().add(tf2);
		frame.getContentPane().add(tf3);
		frame.getContentPane().add(tf4);
		frame.getContentPane().add(tf5);
		frame.getContentPane().add(tf6);
		frame.getContentPane().add(tf7);
		frame.getContentPane().add(tf8);
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
				String s = tf4.getText();
				String t = tf5.getText();
				String u = tf6.getText();
				if(p.length()==0 || q.length()==0 || r.length()==0 || s.length()==0 || t.length()==0 || u.length()==0)
				{
					l10.setVisible(false);
					l11.setVisible(false);
					l12.setVisible(false);
					l13.setVisible(false);
					tf7.setVisible(false);
					tf8.setVisible(false);
					b3.setVisible(false);
					b4.setVisible(false);
					l14.setVisible(true);
				}
				else
				{
					l14.setVisible(false);
					l10.setVisible(true);
					l11.setVisible(true);
					l12.setVisible(true);
					l13.setVisible(true);
					tf7.setVisible(true);
					tf8.setVisible(true);
					b3.setVisible(true);
					b4.setVisible(true);
					double a1 = Double.parseDouble(tf1.getText());
					double b1 = Double.parseDouble(tf2.getText());
					double c1 = Double.parseDouble(tf3.getText());
					double a2 = Double.parseDouble(tf4.getText());
					double b2 = Double.parseDouble(tf5.getText());
					double c2 = Double.parseDouble(tf6.getText());
					double a3 = a1*a2;
					double b3 = b1*a2;
					double c3 = c1*a2;
					double a4 = a2*a1;
					double b4 = b2*a1;
					double c4 = c2*a1;
					double a = a3-a4;
					double b = b3-b4;
					double c = c3-c4;
					double y = c/b;
					double x = (c1-((b1*c)/b))/a1;
					tf7.setText(Double.toString(x));
					tf8.setText(Double.toString(y));

					String m = p+"X + "+q+"Y = "+r+" and "+s+"X + "+t+"Y = "+u;
					String n = "X = "+x+" and Y = "+y;

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
				start3();
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