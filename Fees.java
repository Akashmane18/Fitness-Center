import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Fees extends JFrame implements ActionListener
{
Color c2=new Color(41,32,10);
Color c1=new Color(121,94,28);
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
JButton b1,b2,b3,b4,b5;
ImageIcon img1;
JPanel p1,p2;
JRadioButton r1,r2,r3,r4;
JComboBox cm1,cm2,cm3;
Container c;
Connection con;
Statement stmt;
ResultSet rs;

Font f1=new Font("Old English Text MT",Font.BOLD,50);
Font f2=new Font("Old English Text MT",Font.BOLD,15);
Font f3=new Font("Cambria",Font.BOLD,15);
public Fees(int packid,String mname,int memid,String mship,int offer,int nutrition)
{
         setSize(2000,2000);
	 setLayout(null);
	 setVisible(true);
	show();
	c=getContentPane();
	c.setBackground(c2);

//img1=new ImageIcon("E:/Java/jdk1.5.0/bin/Fitness Center/images/focus.jpg");
//JLabel IL=new JLabel(img1);
//IL.setBounds();
 
p1=new JPanel();
p1.setLayout(null);
p1.setBounds(10,10,1500,200);
l1=new JLabel("          Member Fees Details");
p1.setBackground(c1);
l1.setForeground(c2);
l1.setFont(f1);

l1.setBounds(0,0,800,200);
p1.add(l1);
add(p1);

//second panel
p2=new JPanel();
p2.setBounds(350,250,650,400);
add(p2);
p2.setBackground(c1);
p2.setLayout(null);


l9=new JLabel("Fees Id");
l9.setForeground(c2);
l9.setBounds(10,20,200,20);
l9.setFont(f3);
p2.add(l9);

t6=new JTextField(20);
t6.setBounds(110,20,200,20);
t6.setFont(f3);
p2.add(t6);

l5=new JLabel("Package ID");
l5.setForeground(c2);
l5.setBounds(10,50,200,20);
l5.setFont(f3);
p2.add(l5);


t8=new JTextField(20);
t8.setBounds(110,50,200,20);
t8.setText(String.valueOf(packid));
t8.setFont(f3);
p2.add(t8);

cm3=new JComboBox();
cm3.setBounds(110,50,200,20);

try
    		{
   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   		 System.out.println("Connection Done\n"); 
    		con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    		System.out.println("Driver Loaded\n"); 
   		stmt=con.createStatement();
  		String	 str="select * from Package_Table";
		rs=stmt.executeQuery(str);
   		while(rs.next())
		{
		
		cm3.addItem(rs.getString(5));
		}
		con.close();
		}catch(ClassNotFoundException e)
 		 {
  		 System.out.println(e);	  
  		}
  
  		catch(SQLException e)
  		{
   		System.out.println(e);	  
  		}
  
p2.add(cm3);
cm3.addItemListener(this);


l2=new JLabel("Member Name");
l2.setForeground(c2);
l2.setBounds(330,20,200,20);
l2.setFont(f3);
p2.add(l2);

t1=new JTextField(20);
t1.setBounds(440,20,200,20);
t1.setText(mname);
t1.setFont(f3);

p2.add(t1);

l3=new JLabel("Member Id");
l3.setForeground(c2);
l3.setBounds(330,50,200,20);
l3.setFont(f3);
p2.add(l3);

t4=new JTextField(20);
t4.setBounds(440,50,200,20);
t4.setText(String.valueOf(memid));
t4.setFont(f3);

p2.add(t4);


//Fees panel
JPanel p4=new JPanel();
p4.setBounds(10,100,600,280);
add(p4);
p4.setBackground(c2);
p4.setLayout(null);
p2.add(p4);

l4=new JLabel("Memership Type");
l4.setForeground(c1);
l4.setBounds(100,20,200,20);
l4.setFont(f3);
p4.add(l4);

t3=new JTextField(20);
t3.setBounds(100,50,490,20);
t3.setText(mship);
t3.setFont(f3);
p4.add(t3);

l6=new JLabel("MemberShip offer-fees");
l6.setForeground(c1);
l6.setBounds(100,80,450,20);
l6.setFont(f3);
p4.add(l6);

t2=new JTextField(20);
t2.setBounds(300,80,200,20);
t2.setText(String.valueOf(offer));
t2.setFont(f3);
p4.add(t2);

l7=new JLabel("Nutrition-fees");
l7.setForeground(c1);
l7.setBounds(100,110,450,20);
l7.setFont(f3);
p4.add(l7);

t7=new JTextField(20);
t7.setBounds(300,110,200,20);
t7.setText(String.valueOf(nutrition));
t7.setFont(f3);
p4.add(t7);

l8=new JLabel("Total-fees");
l8.setForeground(c1);
l8.setBounds(100,140,450,20);
l8.setFont(f3);
p4.add(l8);

t5=new JTextField(20);
t5.setBounds(300,140,200,20);
t5.setFont(f3);
p4.add(t5);



b1=new JButton("Submit");
b1.setBounds(50,210,150,25);
b1.addActionListener(this);
b1.setFont(f3);
p4.add(b1);

b2=new JButton("Reset");
b2.setBounds(50,250,150,25);
b2.addActionListener(this);
b2.setFont(f3);
p4.add(b2);

b3=new JButton("Home");
b3.setBounds(250,210,150,25);
b3.addActionListener(this);
b3.setFont(f3);
p4.add(b3);

b4=new JButton("Fee Receipt");
b4.setBounds(250,250,150,25);
b4.addActionListener(this);
b4.setFont(f3);
p4.add(b4);

b5=new JButton("Search");
b5.setBounds(420,210,150,25);
b5.addActionListener(this);
b5.setFont(f3);
p4.add(b5);
try
			{int mid=0;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Fees_Id) from Fees_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			mid=Integer.parseInt(rs.getString(1));
			}
			
			t6.setText(String.valueOf(mid));
			t6.setEditable(false);
			
			con.close();
		}catch(ClassNotFoundException e)
 		 {
  		 System.out.println(e);	  
  		}
  
  		catch(SQLException e)
  		{
   		System.out.println(e);	  
  		}
			

int ttid=0;
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Fees_Id) from Fees_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			
			ttid=Integer.parseInt(rs.getString(1));
			}
			ttid++;
			t6.setText(String.valueOf(ttid));
			con.close();
		}
		catch(ClassNotFoundException e)
		{
		e.printStackTrace();
		System.out.println("Driver Error"+e.toString());
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		System.out.println("Query Error"+e.toString());
		}

}

public void actionPerformed(ActionEvent ae)
{
	
	if(ae.getSource()==b1)
	{ 
		
	
		String s1=t1.getText();
		String s2=t4.getText();
		String s3=t3.getText();
		
		String s4=t2.getText();
		String s5=t7.getText();
	
	



		//cnt++;
		if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals(""))
		{
	
	JOptionPane.showMessageDialog(null,"Some Fields Are Empty","NewUser",JOptionPane.INFORMATION_MESSAGE);
		 
		
		}
else
{

	
	int fid=Integer.parseInt(t6.getText());
	int pid=Integer.parseInt(t8.getText());
	String mname=t1.getText();
	int mid=Integer.parseInt(t4.getText());
	String mtype=t3.getText();
	int offer=Integer.parseInt(t2.getText());
	int nutrition=Integer.parseInt(t7.getText());
	int total=offer+nutrition;
	t5.setText(String.valueOf(total));
	
	

	
	

	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:Fitness_Center");
		System.out.println("Connection Established");
		stmt=con.createStatement();
	
		
		String sql="insert into Fees_Table values ("+ fid + "," +pid +",'" + mname + "'," + mid + ",'" +mtype +"'," + offer + "," +nutrition+ "," +total+ ")";
        	int i=stmt.executeUpdate(sql);
		if(i>0)
		JOptionPane.showMessageDialog(null,"Record is Submited","Trainer",JOptionPane.INFORMATION_MESSAGE);
		FeeReceipt ob=new FeeReceipt(fid,mname,mid,total);		
				
		
		con.close();
		}
		catch(ClassNotFoundException e)
		{
		e.printStackTrace();
		System.out.println("Driver Error"+e.toString());
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		System.out.println("Query Error"+e.toString());
		}
	}
}	if(ae.getSource()==b2)
		{int ttid=0;
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Fees_Id) from Fees_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			
			ttid=Integer.parseInt(rs.getString(1));
			}
			ttid++;
			t6.setText(String.valueOf(ttid));

			
			
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			
			}
			catch(ClassNotFoundException e){System.out.println("Driver Error..."+e);}
			catch(SQLException e){System.out.println("SQL Error"+e);} 			
	 	}	


		if(ae.getSource()==b5)
		{
		FeesFetch ob=new FeesFetch();
		}

		
		if(ae.getSource()==b4)
		{
		FeeReceipt ob=new FeeReceipt();
		}

}

public void itemStateChanged(ItemEvent ae)
{
 
   
   int pid=Integer.parseInt((String)ae.getItem());
	
    try
    {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    System.out.println("Connection Done\n"); 
    con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    System.out.println("Driver Loaded\n"); 
   stmt=con.createStatement();
  String str="select * from Package_Table where Package_Id="+pid+"";
     rs=stmt.executeQuery(str);
	System.out.println(pid);

while(rs.next())
{
	
	
    	t1.setText(rs.getString(2));
   	t4.setText(rs.getString(3));
   	t3.setText(rs.getString(6));
   	t2.setText(rs.getString(12));
   	t7.setText(rs.getString(14));
   
}
 con.close();
}catch(ClassNotFoundException e)
  {
   System.out.println(e);	  
  }
  
	  catch(SQLException e)
  {
   System.out.println(e);	  
  }
}




public static void main(String a[])
{
new Fees();
}}



