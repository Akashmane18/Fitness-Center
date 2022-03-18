import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Complaint extends JFrame implements ActionListener,ItemListener
{
Color c2=new Color(3,33,24);
Color c1=new Color(17,168,122);
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
JTextField t1,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
JTextArea t2;

JButton b1,b2,b3,b4;
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
public Complaint()
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
l1=new JLabel("Member Complaint Details");
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


l5=new JLabel("Complaint ID");
l5.setForeground(c2);
l5.setBounds(10,20,200,20);
l5.setFont(f3);
p2.add(l5);

t5=new JTextField(20);
t5.setBounds(110,20,200,20);
t5.setFont(f3);
p2.add(t5);

l2=new JLabel("Member Name");
l2.setForeground(c2);
l2.setBounds(330,20,200,20);
l2.setFont(f3);
p2.add(l2);

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
cm1.addItemListener(this);


l3=new JLabel("Member Id");
l3.setForeground(c2);
l3.setBounds(330,50,200,20);
l3.setFont(f3);
p2.add(l3);

t4=new JTextField(20);
t4.setBounds(440,50,200,20);
t4.setFont(f3);
p2.add(t4);


//profile panel
JPanel p4=new JPanel();
p4.setBounds(10,100,600,280);
add(p4);
p4.setBackground(c2);
p4.setLayout(null);
p2.add(p4);

l4=new JLabel("Complaint type");
l4.setForeground(c1);
l4.setBounds(100,20,200,20);
l4.setFont(f3);
p4.add(l4);

cm2=new JComboBox();
cm2.setBounds(300,20,250,20);
cm2.addItem("--Select--");
cm2.addItem("Geting exhausted with Routine");
cm2.addItem("Having problem with following Diet");
cm2.addItem("Not able to handle with equipments");
cm2.addItem("Not getting proper Training");
cm2.addItem("Finding no progress");
cm2.addItem("--None of these--");
p4.add(cm2);


l5=new JLabel("Any other(Mention here):");
l5.setForeground(c1);
l5.setBounds(100,50,450,20);
l5.setFont(f3);
p4.add(l5);



t3=new JTextField(20);
t3.setBounds(300,50,200,20);
t3.setFont(f3);
p4.add(t3);

l6=new JLabel("Complaint Description:");
l6.setForeground(c1);
l6.setBounds(100,80,450,20);
l6.setFont(f3);
p4.add(l6);

t2=new JTextArea();
t2.setBounds(100,110,450,80);
t2.setFont(f3);
p4.add(t2);


b1=new JButton("Submit");
b1.setBounds(100,210,150,25);
b1.addActionListener(this);
b1.setFont(f3);
p4.add(b1);

b2=new JButton("New Complaint");
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
			String sql="select max(Complaint_Id) from Complaint_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			mid=Integer.parseInt(rs.getString(1));
			}
			
			t5.setText(String.valueOf(mid));
			t5.setEditable(false);
			
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
		String s1=t2.getText();
		String s2=String.valueOf(cm1.getSelectedItem());
        	String s3=String.valueOf(cm2.getSelectedItem());
        	
		String s5=t4.getText();
		
		String s6=t5.getText();
		String s7=t3.getText();
		
	

		//cnt++;
		if(s1.equals("")||s2.equals("")||s3.equals("")||s5.equals("")||s6.equals("")||s7.equals(""))
		{
		//flag=0;
		JOptionPane.showMessageDialog(null,"All fields are mandatory","Complaint",JOptionPane.INFORMATION_MESSAGE);
		 
		
		}
		else
		{
	
	
	
	int cid=Integer.parseInt(t5.getText());
	int mid=Integer.parseInt(t4.getText());
	
	String cany=t3.getText();
	String cdesc=t2.getText();
	String ctype=(String)cm2.getSelectedItem();
	String mname=(String)cm1.getSelectedItem();
	
	
	






	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:Fitness_Center");
		System.out.println("Connection Established");
		stmt=con.createStatement();
	
		
		String sql="insert into Complaint_Table values ("+ cid + ",'" + mname + "'," + mid + ",'" +ctype +"','" + cany+ "','" +cdesc+"')";
        	int i=stmt.executeUpdate(sql);
		if(i>0)
		JOptionPane.showMessageDialog(null,"Complaint record is Submited","Complaint",JOptionPane.INFORMATION_MESSAGE);
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
}
if(ae.getSource()==b2)
		{int ttid=0;
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Complaint_Id) from Complaint_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			
			ttid=Integer.parseInt(rs.getString(1));
			}
			ttid++;
			t5.setText(String.valueOf(ttid));

			
			
			t2.setText("");
			t3.setText("");
			t4.setText("");
			
			}
			catch(ClassNotFoundException e){System.out.println("Driver Error..."+e);}
			catch(SQLException e){System.out.println("SQL Error"+e);} 			
	 	}	

		if(ae.getSource()==b4)
		{
		ComplaintFetch ob=new ComplaintFetch();
		}
		if(ae.getSource()==b3)
		{
		FitnessMDI ob=new FitnessMDI();
		}



}

public void itemStateChanged(ItemEvent ae)
{
 
   
   String mname=(String)ae.getItem();
	
    try
    {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    System.out.println("Connection Done\n"); 
    con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    System.out.println("Driver Loaded\n"); 
   stmt=con.createStatement();
  String str="select * from Registration_Table where M_Name='"+mname+"'";
     rs=stmt.executeQuery(str);
	System.out.println(mname);

while(rs.next())
{
	
	
    	t4.setText(rs.getString(2));
   
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
new Complaint();
}}



