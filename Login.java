//LOGIN PAGE//

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Login extends Applet implements ActionListener
{
	int cnt;
	Label l1,l2,l3,l4,l5,l6,l7,l8;
	TextField tf1,tf2;
	Button b1,b2;

	public void paint(Graphics g)
	{
		g.drawImage(getImage(getCodeBase(),"img.jpg"),0,0,this);
	}
	public void init()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:odbc:dsn");
			Statement st=conn.createStatement();
			st.execute("Create table Registration_Details(SrNo int AUTO_INCREMENT primary key,FirstName text,LastName text,UserName text,PassWord text)");
			st.execute("Create table Summary_Table(SrNo int AUTO_INCREMENT primary key,FirstName text,LastName text,UserName text,Choice text,Equations text,Solution text)");
			conn.close();
			st.close();
		}
		catch(Exception ie)
		{}
		setLayout(null);
		l1=new Label("WELCOME TO THE POLYNOMIAL SOLVER");
		l2=new Label("USERNAME : ");
		l3=new Label("PASSWORD : ");
		l4=new Label("Let's Get Started...");
		l5=new Label("USERNAME OR PASSWORD SHOULD NOT BE NULL");
		l6=new Label("PASSWORD SHOULD BE OF MINIMUM 8 CHARACTERS");
		l7=new Label("USERNAME OR PASSWORD IS NOT MATCHED,PLEASE ENTER CORRECT ONE");
		l8=new Label("IF YOU ARE NEW USER,THEN DO REGISTER FIRST");
		tf1=new TextField();
		tf2=new TextField();
		b1=new Button("LOGIN");
		b2=new Button("REGISTER");
		Font Font1 = new Font("Courier",Font.BOLD,28);
		l1.setFont(Font1);
		Font Font2 = new Font("Courier",Font.BOLD,20);
		l2.setFont(Font2);
		l3.setFont(Font2);
		l4.setFont(Font1);
		l5.setFont(Font2);
		l6.setFont(Font2);
		l7.setFont(Font2);
		l8.setFont(Font2);
		tf1.setFont(Font2);
		tf2.setFont(Font2);
		tf2.setEchoChar('*');
		b1.setFont(Font2);
		b2.setFont(Font2);
		l1.setBounds(100,100,560,50);
		l2.setBounds(100,250,120,30);
		l3.setBounds(100,300,120,30);
		l4.setBounds(100,200,350,30);
		l5.setBounds(100,430,500,30);
		l6.setBounds(100,430,550,30);
		l7.setBounds(100,430,730,30);
		l8.setBounds(100,480,520,30);
		tf1.setBounds(250,250,250,30);
		tf2.setBounds(250,300,250,30);
		b1.setBounds(120,360,120,40);
		b2.setBounds(300,360,120,40);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(tf1);
		add(tf2);
		add(b1);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		l5.setVisible(false);
		l6.setVisible(false);
		l7.setVisible(false);
		l8.setVisible(false);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			String p = tf1.getText();
			String q = tf2.getText();
			if(p.length()!=0 && q.length()>=8)
			{
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
					Connection conn = DriverManager.getConnection("jdbc:odbc:dsn");
					PreparedStatement pst1 = conn.prepareStatement("select * from Registration_Details");
					ResultSet rs = pst1.executeQuery();


					while(rs.next())
					{
						if(p.equals(rs.getString("UserName")) && q.equals(rs.getString("PassWord")))
						{
							String r=rs.getString("FirstName");
							String s=rs.getString("LastName");

							PreparedStatement pst2 = conn.prepareStatement("insert into Summary_Table(FirstName,LastName,UserName) values(?,?,?)");
							pst2.setString(1,r);
							pst2.setString(2,s);
							pst2.setString(3,p);
							pst2.executeUpdate();
							pst2.close();

							l5.setVisible(false);
							l6.setVisible(false);
							l7.setVisible(false);
							l8.setVisible(false);

							Welcome a = new Welcome();
							a.start1();
						}
						else
						{
							l5.setVisible(false);
							l6.setVisible(false);
							l7.setVisible(true);
							l8.setVisible(true);
						}
					}
					pst1.executeUpdate();
					pst1.close();
					conn.close();
				}
				catch(Exception ie)
				{}
			}
			else if(p.length()==0 || q.length()==0)
			{
				l6.setVisible(false);
				l7.setVisible(false);
				l8.setVisible(false);
				l5.setVisible(true);
			}
			else if(q.length()<8)
			{
				l5.setVisible(false);
				l7.setVisible(false);
				l8.setVisible(false);
				l6.setVisible(true);
			}
		}
		if(e.getSource()==b2)
		{
			l5.setVisible(false);
			l6.setVisible(false);
			l7.setVisible(false);
			l8.setVisible(false);

			RegForm r = new RegForm();
			r.start2();
		}
	}
	public void Insert()
	{
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
			PreparedStatement pst2 = conn.prepareStatement("select * from Summary_Table where SrNo = '"+cnt+"'");
			ResultSet rs1 = pst2.executeQuery();
			if(rs1.next())
			{
				String a=rs1.getString("FirstName");
				String b=rs1.getString("LastName");
				String c=rs1.getString("UserName");
				PreparedStatement pst =conn.prepareStatement("insert into Summary_Table(FirstName,LastName,UserName) values(?,?,?)");
				pst.setString(1,a);
				pst.setString(2,b);
				pst.setString(3,c);
				pst.executeUpdate();
				pst.close();
			}
			pst1.executeUpdate();
			pst1.close();
			pst2.executeUpdate();
			pst2.close();
			conn.close();
		}
		catch(Exception ie)
		{}
	}
}






