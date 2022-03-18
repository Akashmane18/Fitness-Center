import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Diet extends JFrame implements ActionListener,ItemListener
{
Color c2=new Color(10,24,4);
Color c1=new Color(54,120,31);
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
JButton b1,b2,b3;
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
Font f7=new Font("Colonna MT",Font.BOLD,50);
public Diet()
{
         setSize(1600,900);
	 setLayout(null);
	 setVisible(true);
	show();
	c=getContentPane();
	c.setBackground(c2);

//img1=new ImageIcon("D:/suru Ty/project6/Fitness Center/index3.jpg");
//JLabel IL=new JLabel(img1);
//IL.setBounds();
 
p1=new JPanel();
p1.setLayout(null);
p1.setBounds(10,10,1500,200);
l1=new JLabel("Member Diet Details");
p1.setBackground(c1);
l1.setForeground(c2);
l1.setFont(f7);

l1.setBounds(400,0,800,200);
p1.add(l1);
add(p1);

//second panel
p2=new JPanel();
p2.setBounds(10,250,1500,400);
add(p2);
p2.setBackground(c1);
p2.setLayout(null);


l5=new JLabel("Diet ID");
l5.setForeground(c2);
l5.setBounds(10,20,200,20);
l5.setFont(f3);
p2.add(l5);

t1=new JTextField();
t1.setBounds(110,20,200,20);
t1.setFont(f3);
p2.add(t1);

l2=new JLabel("Member Name");
l2.setForeground(c2);
l2.setBounds(330,20,200,20);
l2.setFont(f3);
p2.add(l2);


t11=new JTextField(20);
t11.setBounds(440,20,200,20);
t11.setFont(f3);
p2.add(t11);

cm1=new JComboBox();
cm1.setBounds(440,20,200,20);
try
    		{
   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   		 System.out.println("Connection Done\n"); 
    		con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    		System.out.println("Driver Loaded\n"); 
   		stmt=con.createStatement();
  		String	 str="select * from Registration_Table";
		rs=stmt.executeQuery(str);
   		while(rs.next())
		{
		
		cm1.addItem(rs.getString(3));
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
  
p2.add(cm1);

l13=new JLabel("Profile Id");
l13.setForeground(c2);
l13.setBounds(10,50,200,20);
l13.setFont(f3);
p2.add(l13);

cm3=new JComboBox();
cm3.setBounds(110,50,200,20);

try
    		{
   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   		 System.out.println("Connection Done\n"); 
    		con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    		System.out.println("Driver Loaded\n"); 
   		stmt=con.createStatement();
  		String	 str="select * from Profile_Table";
		rs=stmt.executeQuery(str);
   		while(rs.next())
		{
		
		cm3.addItem(rs.getString(1));
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



l3=new JLabel("Member Id");
l3.setForeground(c2);
l3.setBounds(330,50,200,20);
l3.setFont(f3);
p2.add(l3);

t2=new JTextField(20);
t2.setBounds(440,50,200,20);
t2.setFont(f3);
p2.add(t2);


//morning panel
JPanel p4=new JPanel();
p4.setBounds(10,100,600,280);
add(p4);
p4.setBackground(c2);
p4.setLayout(null);
p2.add(p4);

l4=new JLabel("Dietician Name");
l4.setForeground(c1);
l4.setBounds(100,20,200,20);
l4.setFont(f3);
p4.add(l4);

cm2=new JComboBox();
cm2.setBounds(300,20,200,20);
try
    		{
   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   		 System.out.println("Connection Done\n"); 
    		con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    		System.out.println("Driver Loaded\n"); 
   		stmt=con.createStatement();
  		String	 str="select * from Dietician_Table";
		rs=stmt.executeQuery(str);
   		while(rs.next())
		{
		
		cm2.addItem(rs.getString(2));
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
  
p4.add(cm2);

l5=new JLabel("Early Morning:");
l5.setForeground(c1);
l5.setBounds(100,50,450,20);
l5.setFont(f3);
p4.add(l5);

t3=new JTextField(20);
t3.setBounds(100,80,450,20);
t3.setFont(f3);
p4.add(t3);

l6=new JLabel("Mid-Morning");
l6.setForeground(c1);
l6.setBounds(100,110,450,20);
l6.setFont(f3);
p4.add(l6);



t4=new JTextField(20);
t4.setBounds(100,140,450,20);
t4.setFont(f3);
p4.add(t4);

l7=new JLabel("Pre-lunch");
l7.setForeground(c1);
l7.setBounds(100,160,450,20);
l7.setFont(f3);
p4.add(l7);



t5=new JTextField(20);
t5.setBounds(100,190,450,20);
t5.setFont(f3);
p4.add(t5);


//evening panel
JPanel p5=new JPanel();
p5.setBounds(750,20,600,350);
add(p5);
p5.setBackground(c2);
p5.setLayout(null);
p2.add(p5);


l8=new JLabel("Lunch:");
l8.setForeground(c1);
l8.setBounds(100,20,450,20);
l8.setFont(f3);
p5.add(l8);

t6=new JTextField(20);
t6.setBounds(100,50,450,20);
t6.setFont(f3);
p5.add(t6);

l9=new JLabel("Post-Lunch");
l9.setForeground(c1);
l9.setBounds(100,80,450,20);
l9.setFont(f3);
p5.add(l9);



t7=new JTextField(20);
t7.setBounds(100,110,450,20);
t7.setFont(f3);
p5.add(t7);

l10=new JLabel("Evening-Snack");
l10.setForeground(c1);
l10.setBounds(100,140,450,20);
l10.setFont(f3);
p5.add(l10);



t8=new JTextField(20);
t8.setBounds(100,170,450,20);
t8.setFont(f3);
p5.add(t8);


l11=new JLabel("Dinner");
l11.setForeground(c1);
l11.setBounds(100,200,450,20);
l11.setFont(f3);
p5.add(l11);



t9=new JTextField(20);
t9.setBounds(100,240,450,20);
t9.setFont(f3);
p5.add(t9);

l12=new JLabel("Post-Dinner");
l12.setForeground(c1);
l12.setBounds(100,270,450,20);
l12.setFont(f3);
p5.add(l12);



t10=new JTextField(20);
t10.setBounds(100,300,450,20);
t10.setFont(f3);
p5.add(t10);




b1=new JButton("Submit");
b1.setBounds(100,220,150,25);
b1.addActionListener(this);
b1.setFont(f3);
p4.add(b1);

b2=new JButton("Reset");
b2.setBounds(200,250,150,25);
b2.addActionListener(this);
b2.setFont(f3);
p4.add(b2);

b3=new JButton("Home");
b3.setBounds(300,220,150,25);
b3.addActionListener(this);
b3.setFont(f3);
p4.add(b3);

try
			{int mid=0;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Diet_Id) from Diet_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			mid=Integer.parseInt(rs.getString(1));
			}
			
			t1.setText(String.valueOf(mid));
			t1.setEditable(false);
			
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
public void actionPerformed(ActionEvent ae)
{
	
	if(ae.getSource()==b1)
	{ 
	
	String s1=t3.getText();
	String s2=t4.getText();
	String s3=t5.getText();
	String s4=t6.getText();
	String s5=t7.getText();
	String s6=t8.getText();
	String s7=t9.getText();
	String s8=t2.getText();
	String s9=t10.getText();
			


		//cnt++;
		if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")||s7.equals("")||s8.equals("")||s9.equals(""))
		{
		//flag=0;
	JOptionPane.showMessageDialog(null,"All fields are mandatory","Diet",JOptionPane.INFORMATION_MESSAGE);
		 
		
		}
	else
	{

	int did=Integer.parseInt(t1.getText());
	
	String mname=t11.getText();
	int mid=Integer.parseInt(t2.getText());
	String dname=(String)cm2.getSelectedItem();
	int pid=Integer.parseInt((String)cm3.getSelectedItem());
	
	
	String em=t3.getText();
	String mm=t4.getText();
	String plu=t5.getText();
	String lu=t6.getText();
	String polu=t7.getText();
	String eve=t8.getText();
	String din=t9.getText();
	String podin=t10.getText();
		



	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:Fitness_Center");
		System.out.println("Connection Established");
		stmt=con.createStatement();
	
		
		String sql="insert into Diet_Table values ("+ did + "," + pid + ",'" + mname + "'," + mid + ",'" + dname + "','" + em + "','" + mm + "','" + plu + "','" + lu + "','" + polu + "','" + eve + "','" + din + "','" + podin + "')";
        	int i=stmt.executeUpdate(sql);
		if(i>0)
		JOptionPane.showMessageDialog(null,"Diet Record is Submited","Diet",JOptionPane.INFORMATION_MESSAGE);
		else
		JOptionPane.showMessageDialog(null,"Record submission unsucessfull","Registration",JOptionPane.ERROR_MESSAGE);
				
		
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
			String sql="select max(Diet_Id) from Diet_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			
			ttid=Integer.parseInt(rs.getString(1));
			}
			ttid++;
			t1.setText(String.valueOf(ttid));

			
			
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			
			}
			catch(ClassNotFoundException e){System.out.println("Driver Error..."+e);}
			catch(SQLException e){System.out.println("SQL Error"+e);} 			
	 	}	

	if(ae.getSource()==b3)
		{
		FitnessMDI ob=new FitnessMDI();
		}



}

public void itemStateChanged(ItemEvent ae)
{
 
   
   int mname=Integer.parseInt((String)ae.getItem());
	
    try
    {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    System.out.println("Connection Done\n"); 
    con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    System.out.println("Driver Loaded\n"); 
   stmt=con.createStatement();
  String str="select * from Profile_Table where P_Id="+mname+"";
     rs=stmt.executeQuery(str);


while(rs.next())
{
	
	t11.setText(rs.getString(2));
    	t2.setText(rs.getString(3));
   
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
new Diet();
}}



