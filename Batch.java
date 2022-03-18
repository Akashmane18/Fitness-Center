import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Batch extends JFrame implements ActionListener,ItemListener
{
Color c2=new Color(54,5,13);
Color c1=new Color(174,19,43);
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
JButton b1,b2,b3,b4;
ImageIcon img1;
JPanel p1,p2;
JRadioButton r1,r2,r3,r4;
JComboBox cm1,cm2,cm3,cm4,cm5,cm6;
Container c;
Connection con;
Statement stmt;
ResultSet rs;

Font f1=new Font("Old English Text MT",Font.BOLD,50);
Font f2=new Font("Old English Text MT",Font.BOLD,15);
Font f3=new Font("Cambria",Font.BOLD,15);
Font f7=new Font("Colonna MT",Font.BOLD,50);
public Batch()
{
         setSize(2000,2000);
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
l1=new JLabel("          Batch Details");
p1.setBackground(c1);
l1.setForeground(c2);
l1.setFont(f7);

l1.setBounds(400,0,800,200);
p1.add(l1);
add(p1);

//second panel
p2=new JPanel();
p2.setBounds(350,250,650,400);
add(p2);
p2.setBackground(c1);
p2.setLayout(null);

l2=new JLabel("Batch-ID");
l2.setForeground(c2);
l2.setBounds(10,20,200,20);
l2.setFont(f3);
p2.add(l2);

t1=new JTextField(20);
t1.setBounds(110,20,200,20);
t1.setFont(f3);
p2.add(t1);

l5=new JLabel("Package ID");
l5.setForeground(c2);
l5.setBounds(330,20,200,20);
l5.setFont(f3);
p2.add(l5);

cm1=new JComboBox();
cm1.setBounds(440,20,200,20);
cm1.addItem("--Select--");

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
		
		cm1.addItem(rs.getString(5));
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
  

cm1.addItemListener(this);
p2.add(cm1);


l3=new JLabel("Batch-Shift");
l3.setForeground(c2);
l3.setBounds(330,50,200,20);
l3.setFont(f3);
p2.add(l3);

t2=new JTextField(20);
t2.setBounds(440,50,200,20);
t2.setFont(f3);
p2.add(t2);


//Batch panel
JPanel p4=new JPanel();
p4.setBounds(10,100,600,280);
add(p4);
p4.setBackground(c2);
p4.setLayout(null);
p2.add(p4);

l4=new JLabel("Trainer Name");
l4.setForeground(c1);
l4.setBounds(100,20,200,20);
l4.setFont(f3);
p4.add(l4);

cm2=new JComboBox();
cm2.setBounds(300,20,200,20);
cm2.addItem("--Select--");

try
    		{
   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   		 System.out.println("Connection Done\n"); 
    		con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    		System.out.println("Driver Loaded\n"); 
   		stmt=con.createStatement();
  		String	 str="select * from Trainer_Table";
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

l6=new JLabel("Dietician Name");
l6.setForeground(c1);
l6.setBounds(100,50,450,20);
l6.setFont(f3);
p4.add(l6);

cm3=new JComboBox();
cm3.setBounds(300,50,200,20);
cm3.addItem("--Select--");

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
		
		cm3.addItem(rs.getString(2));
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
  


p4.add(cm3);



l7=new JLabel("Routine-Id");
l7.setForeground(c1);
l7.setBounds(100,80,450,20);
l7.setFont(f3);
p4.add(l7);

cm4=new JComboBox();
cm4.setBounds(300,80,200,20);
cm4.addItem("--Select--");

try
    		{
   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   		 System.out.println("Connection Done\n"); 
    		con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    		System.out.println("Driver Loaded\n"); 
   		stmt=con.createStatement();
  		String	 str="select * from Routine_Table";
		rs=stmt.executeQuery(str);
   		while(rs.next())
		{
		
		cm4.addItem(rs.getString(1));
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
  
p4.add(cm4);
cm4.addItemListener(this);


l8=new JLabel("No_of_weeks");
l8.setForeground(c1);
l8.setBounds(100,110,450,20);
l8.setFont(f3);
p4.add(l8);

t3=new JTextField(20);
t3.setBounds(300,110,200,20);
t3.setFont(f3);
p4.add(t3);

l9=new JLabel("Batch Shift");
l9.setForeground(c1);
l9.setBounds(100,140,450,20);
l9.setFont(f3);
p4.add(l9);


t4=new JTextField(20);
t4.setBounds(300,140,100,20);
t4.setFont(f3);
p4.add(t4);

l10=new JLabel("to");
l10.setForeground(c1);
l10.setBounds(420,140,100,20);
l10.setFont(f3);
p4.add(l10);


t5=new JTextField(20);
t5.setBounds(450,140,100,20);
t5.setFont(f3);
p4.add(t5);


b1=new JButton("Submit");
b1.setBounds(100,210,150,25);
b1.addActionListener(this);
b1.setFont(f3);
p4.add(b1);

b2=new JButton("Reset");
b2.setBounds(100,240,150,25);
b2.addActionListener(this);
b2.setFont(f3);
p4.add(b2);

b3=new JButton("Home");
b3.setBounds(300,210,150,25);
b3.addActionListener(this);
b3.setFont(f3);
p4.add(b3);


b4=new JButton("Search");
b4.setBounds(300,240,150,25);
b4.addActionListener(this);
b4.setFont(f3);
p4.add(b4);

try
			{int mid=0;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Batch_Id) from Batch_Table";
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
		

		//cnt++;
		if(s1.equals("")||s2.equals("")||s3.equals(""))
		{
		//flag=0;
	JOptionPane.showMessageDialog(null,"All fields are mandatory","Batch",JOptionPane.INFORMATION_MESSAGE);
		 
		
		}
	else
	{


	
	
	int bid=Integer.parseInt(t1.getText());
	int now=Integer.parseInt(t3.getText());
	
	String from=t4.getText();
	String to=t5.getText();
	
	String bshift=from+"to"+to;
	int pid=Integer.parseInt((String)cm1.getSelectedItem());
	String tname=(String)cm2.getSelectedItem();
	String dname=(String)cm3.getSelectedItem();
	int rid=Integer.parseInt((String)cm4.getSelectedItem());
	
	


	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:Fitness_Center");
		System.out.println("Connection Established");
		stmt=con.createStatement();
	
		
		String sql="insert into Batch_Table values ("+ bid + "," + pid + ",'" + tname + "','" +dname + "'," + rid + "," + now + ",'" +bshift+"')";
        	int i=stmt.executeUpdate(sql);
		if(i>0)
		JOptionPane.showMessageDialog(null,"Batch Record is Submited","Batch",JOptionPane.INFORMATION_MESSAGE);
		else
		JOptionPane.showMessageDialog(null,"Record submission unsucessfull","Batch",JOptionPane.ERROR_MESSAGE);
				
		
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
			String sql="select max(Batch_Id) from Batch_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			
			ttid=Integer.parseInt(rs.getString(1));
			}
			ttid++;
			t1.setText(String.valueOf(ttid));

			
			
			
			t3.setText("");
			t4.setText("");
			t5.setText("");
			
			}
			catch(ClassNotFoundException e){System.out.println("Driver Error..."+e);}
			catch(SQLException e){System.out.println("SQL Error"+e);} 			
	 	}	

		if(ae.getSource()==b4)
		{
		BatchFetch ob=new BatchFetch();
		}

		if(ae.getSource()==b3)
		{
		FitnessMDI ob=new FitnessMDI();
		}



}


public void itemStateChanged(ItemEvent ae)
{
 if(ae.getSource()==cm4)
{
   System.out.println("abc");
int rid=Integer.parseInt((String)ae.getItem());
	
    try
    {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    System.out.println("Connection Done\n"); 
    con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    System.out.println("Driver Loaded\n"); 
   stmt=con.createStatement();
  String str="select * from Routine_Table where Routine_Id="+rid+"";
     rs=stmt.executeQuery(str);
	System.out.println(rid);

while(rs.next())
{
	
	
    	t3.setText(rs.getString(4));
   
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
}

public static void main(String a[])
{
new Batch();
}}



