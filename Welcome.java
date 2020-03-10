//WELCOME PAGE//

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
public class Welcome
{
	int cnt;
	JFrame frame;
	JLabel l1,l2,l3,l4,l5,l6;
	JButton b1,b2,b3;

	public void start1()
	{
			frame = new JFrame("WELCOME PAGE");
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			frame.setSize(screenSize.width,screenSize.height);
			frame.setVisible(true);
			frame.setLayout(null);

			frame.getContentPane().setBackground(Color.GREEN);

			l1 = new JLabel("CONGRATULATIONS,YOU HAVE SUCCESSFULLY LOGGED IN ...");
			l1.setBounds(100,100,1000,50);
			Font Font1 = new Font("Courier",Font.BOLD,20);
			Font Font2 = new Font("Courier",Font.BOLD,24);
			l1.setFont(Font2);

			l2 = new JLabel("CHOOSE THE TYPE OF EQUATION THAT YOU WANT TO SOLVE :-");
			l2.setBounds(100,200,800,50);
			l2.setFont(Font2);

			l3 = new JLabel("Like, (a1X + b1Y = c1) and (a2X + b2Y = c2)");
			l3.setBounds(130,330,800,30);
			l3.setFont(Font1);

			l4 = new JLabel("Like, (aX^2 + bX + c = 0) ");
			l4.setBounds(130,430,500,30);
			l4.setFont(Font1);

			l5 = new JLabel("1.");
			l5.setBounds(100,300,30,30);
			l5.setFont(Font1);

			l6 = new JLabel("2.");
			l6.setBounds(100,400,30,30);
			l6.setFont(Font1);

			b1 = new JButton("LINEAR EQUATIONS");
			b1.setBounds(130,300,300,30);
			b1.setFont(Font1);

			b2 = new JButton("QUADRATIC EQUATIONS");
			b2.setBounds(130,400,300,30);
			b2.setFont(Font1);

			b3 = new JButton("BACK");
			b3.setBounds(1300,80,150,50);
			Font Font3 = new Font("Courier",Font.BOLD,26);
			b3.setFont(Font3);

			frame.getContentPane().add(l1);
			frame.getContentPane().add(l2);
			frame.getContentPane().add(l3);
			frame.getContentPane().add(l4);
			frame.getContentPane().add(l5);
			frame.getContentPane().add(l6);
			frame.getContentPane().add(b1);
			frame.getContentPane().add(b2);
			frame.getContentPane().add(b3);

			b1.addActionListener(new ActionListener()
			{

				public void actionPerformed(ActionEvent e)
				{
					int cnt=0;
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
						System.out.println(cnt);

						PreparedStatement pst =conn.prepareStatement("update Summary_Table set Choice=? where SrNo='"+cnt+"'");
						pst.setString(1,"Linear Equations");
						pst.executeUpdate();
						pst1.executeUpdate();
						pst.close();
						pst1.close();
						conn.close();
					}
					catch(Exception ie)
					{}

					Linear l = new Linear();
					l.start3();
					frame.setVisible(false);
				}
			});
			b2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int cnt=0;
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

						PreparedStatement pst =conn.prepareStatement("update Summary_Table set Choice=? where SrNo='"+cnt+"'");
						pst.setString(1,"Quadratic Equations");
						pst.executeUpdate();
						pst1.executeUpdate();
						pst.close();
						pst1.close();
						conn.close();
					}
					catch(Exception ie)
					{}
					Quadratic q = new Quadratic();
					q.start4();
					frame.setVisible(false);
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