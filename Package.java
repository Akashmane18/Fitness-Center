import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Package extends JFrame implements ItemListener,ActionListener
{
Color c2=new Color(38,6,38);
Color c1=new Color(166,28,166);
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21;
JButton b1,b2,b3,b4,b5,b6,b7;
ImageIcon img1;
JPanel p1,p2;
JRadioButton r1,r2,r3,r4;
JComboBox cm1,cm2,cm3,cm4;
Container c;
Connection con;
Statement stmt;
ResultSet rs;
JPanel p4;
String ptype;
Font f1=new Font("Old English Text MT",Font.BOLD,45);
Font f2=new Font("Old English Text MT",Font.BOLD,15);
Font f3=new Font("Cambria",Font.BOLD,15);
Font f7=new Font("Colonna MT",Font.BOLD,50);
public Package()
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
l1=new JLabel("Package Details");
p1.setBackground(c1);
l1.setForeground(c2);
l1.setFont(f7);

l1.setBounds(400,0,800,200);
p1.add(l1);
add(p1);

//Member panel
p2=new JPanel();
p2.setBounds(10,250,650,400);
add(p2);
p2.setBackground(c1);
p2.setLayout(null);

l2=new JLabel("Profile Id");
l2.setForeground(c2);
l2.setBounds(100,10,200,20);
l2.setFont(f3);
p2.add(l2);

cm1=new JComboBox();
cm1.setBounds(250,10,200,20);
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
		
		cm1.addItem(rs.getString(1));
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

l3=new JLabel("Member Name");
l3.setForeground(c2);
l3.setBounds(100,40,200,20);
l3.setFont(f3);
p2.add(l3);

t4=new JTextField(20);
t4.setBounds(250,40,200,20);
t4.setFont(f3);
p2.add(t4);


l19=new JLabel("Member Id");
l19.setForeground(c2);
l19.setBounds(100,70,200,20);
l3.setFont(f3);
p2.add(l19);

t19=new JTextField(20);
t19.setBounds(250,70,200,20);
t19.setFont(f3);
p2.add(t19);

//Package panel
p4=new JPanel();
p4.setBounds(10,100,600,290);
add(p4);
p4.setBackground(c2);
p4.setLayout(null);
p2.add(p4);

l4=new JLabel("Package Type");
l4.setForeground(c1);
l4.setBounds(100,20,200,20);
l4.setFont(f3);
p4.add(l4);

b4=new JButton("Individual Package");
b4.setBounds(320,20,150,25);
b4.addActionListener(this);
b4.setFont(f3);
p4.add(b4);

b5=new JButton("Combo Package");
b5.setBounds(320,50,150,25);
b5.addActionListener(this);
b5.setFont(f3);
p4.add(b5);

cm2=new JComboBox();
cm2.setBounds(320,20,200,20);
cm2.addItem("Individual Package");
cm2.addItem("Combo Package");
cm2.addItemListener(this);
p4.add(cm2);

l5=new JLabel("Package_Id:");
l5.setForeground(c1);
l5.setBounds(100,80,200,20);
l5.setFont(f3);
p4.add(l5);

t3=new JTextField();
t3.setBounds(320,80,200,20);
t3.setFont(f3);
p4.add(t3);


	l6=new JLabel("Select Membership:");
l6.setForeground(c1);
l6.setBounds(100,110,450,20);
l6.setFont(f3);
p4.add(l6);

cm3=new JComboBox();
cm3.setBounds(100,140,450,20);



l10=new JLabel("Duration of package[in months]");
l10.setForeground(c1);
l10.setBounds(100,170,350,20);
l10.setFont(f3);
p4.add(l10);

t5=new JTextField(20);
t5.setBounds(320,170,200,20);
t5.setFont(f3);
p4.add(t5);

l20=new JLabel("Batch-Shift");
l20.setForeground(c1);
l20.setBounds(100,200,200,20);
l20.setFont(f3);
p4.add(l20);

cm4=new JComboBox();
cm4.setBounds(320,200,200,20);


try
    		{
   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   		 System.out.println("Connection Done\n"); 
    		con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    		System.out.println("Driver Loaded\n"); 
   		stmt=con.createStatement();
  		String	 str="select * from Batch_Table";
		rs=stmt.executeQuery(str);
   		while(rs.next())
		{
		
		cm4.addItem(rs.getString(7));
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


l21=new JLabel("Batch-Id");
l21.setForeground(c1);
l21.setBounds(100,230,200,20);
l21.setFont(f3);
p4.add(l21);

t21=new JTextField(20);
t21.setBounds(320,230,200,20);
t21.setFont(f3);
p4.add(t21);


//Fees panel
JPanel p3=new JPanel();
p3.setBounds(700,250,650,400);
add(p3);
p3.setBackground(c1);
p3.setLayout(null);




l11=new JLabel("Fees");
l11.setForeground(c2);
l11.setBounds(100,80,200,20);
l11.setFont(f3);
p3.add(l11);

t15=new JTextField(20);
t15.setBounds(350,80,200,20);
t15.setFont(f3);
p3.add(t15);


l16=new JLabel("RFID");
l16.setForeground(c2);
l16.setBounds(100,110,200,20);
l16.setFont(f3);
p3.add(l16);


t14=new JTextField(20);
t14.setBounds(350,110,200,20);
t14.setFont(f3);
p3.add(t14);

JLabel l17=new JLabel("Offer_Rate");
l17.setForeground(c2);
l17.setBounds(100,140,200,20);
l17.setFont(f3);
p3.add(l17);


t16=new JTextField(20);
t16.setBounds(350,140,200,20);
t16.setFont(f3);
p3.add(t16);

l18=new JLabel("Nutrition Session");
l18.setForeground(c2);
l18.setBounds(100,170,200,20);
l18.setFont(f3);
p3.add(l18);


t17=new JTextField(20);
t17.setBounds(350,170,200,20);
t17.setFont(f3);
p3.add(t17);



l18=new JLabel("Nutrition-Fees");
l18.setForeground(c2);
l18.setBounds(100,200,200,20);
l18.setFont(f3);
p3.add(l18);


t18=new JTextField(20);
t18.setBounds(350,200,200,20);
t18.setFont(f3);
p3.add(t18);











b1=new JButton("Submit");
b1.setBounds(100,270,150,25);
b1.addActionListener(this);
b1.setFont(f3);
p3.add(b1);

b2=new JButton("Reset");
b2.setBounds(100,300,150,25);
b2.addActionListener(this);
b2.setFont(f3);
p3.add(b2);

b3=new JButton("Home");
b3.setBounds(300,270,150,25);
b3.addActionListener(this);
b3.setFont(f3);
p3.add(b3);

b6=new JButton("Fees");
b6.setBounds(300,300,150,25);
b6.addActionListener(this);
b6.setFont(f3);
p3.add(b6);

b7=new JButton("Search");
b7.setBounds(180,330,150,25);
b7.addActionListener(this);
b7.setFont(f3);
p3.add(b7);

try
			{int mid=0;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Package_Id) from Package_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			mid=Integer.parseInt(rs.getString(1));
			}
			
			t3.setText(String.valueOf(mid));
			t3.setEditable(false);
			
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

if(ae.getSource()==b5)   
	{
System.out.println("abc");

   ptype=(String)b5.getText();
	
    try
    {
    	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	System.out.println("Connection Done\n"); 
    	con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    	System.out.println("Driver Loaded\n"); 
   	stmt=con.createStatement();
  	if(ptype.equals("Combo Package"))
	{
	System.out.println(ptype);

	String	 str="select * from Combo_Package";
     rs=stmt.executeQuery(str);
	System.out.println(ptype);

while(rs.next())
{
	
	
    	cm3.addItem(rs.getString(2));
	

}

con.close();
}//if close


}catch(ClassNotFoundException e)
  {
   System.out.println(e);	  
  }
  
	  catch(SQLException e)
  {
   System.out.println(e);	  
  }

p4.add(cm3);
cm3.addItemListener(this);

}

if(ae.getSource()==b4)   
	{
System.out.println("pqr");
ptype=(String)b4.getText();
	
    try
    {
    	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	System.out.println("Connection Done\n"); 
    	con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    	System.out.println("Driver Loaded\n"); 
   	stmt=con.createStatement();
  
	String	 str="select * from Individual_Package";
     rs=stmt.executeQuery(str);
	System.out.println(ptype);

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
cm3.addItemListener(this);

}

	
	if(ae.getSource()==b1)
	{ 
		String s1=t4.getText();
		String s3=t5.getText();
		String s5=t21.getText();
		
		
		String s6=t15.getText();
		String s7=t16.getText();
		
		String s8=t17.getText();
		String s9=t18.getText();
		

		//cnt++;
		if(s1.equals("")||s3.equals("")||s5.equals("")||s6.equals("")||s7.equals("")||s8.equals("")||s9.equals(""))
		{
		//flag=0;
	JOptionPane.showMessageDialog(null,"Some Fields Are Empty","NewUser",JOptionPane.INFORMATION_MESSAGE);
		 
		
		}
	else
	{

	
	int pid=Integer.parseInt((String)cm1.getSelectedItem());
	String mname=t4.getText();
	int mid=Integer.parseInt(t19.getText());
	//String ptype
	int packid=Integer.parseInt(t3.getText());
	
	String mship =(String)cm3.getSelectedItem();
	int dur=Integer.parseInt(t5.getText());
	String shift =(String)cm4.getSelectedItem();
	int bid=Integer.parseInt(t21.getText());
	int fees=Integer.parseInt(t15.getText());
	int rfid=Integer.parseInt(t14.getText());
	int offer=Integer.parseInt(t16.getText());
	String nsession=t17.getText();
	int nutrition=Integer.parseInt(t18.getText());
	

	
	

	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:Fitness_Center");
		System.out.println("Connection Established");
		stmt=con.createStatement();
	
		
		String sql="insert into Package_Table values ("+ packid + ",'" +mname +"'," + mid + ",'" + ptype + "'," +pid +",'" + mship + "'," +dur+ ",'" +shift + "'," + bid + "," + fees + "," + rfid + "," + offer + ",'"+ nsession + "'," + nutrition + ")";
        	int i=stmt.executeUpdate(sql);
		if(i>0)
		JOptionPane.showMessageDialog(null,"Record is Submited","Trainer",JOptionPane.INFORMATION_MESSAGE);
		Fees ob=new Fees(packid,mname,mid,mship,offer,nutrition);		
		
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
			String sql="select max(Package_Id) from Package_Table";
			rs=stmt.executeQuery(sql);

			while(rs.next())
			{
			ttid=Integer.parseInt(rs.getString(1));
			}
			ttid++;
			t3.setText(String.valueOf(ttid));
			
			
			
			
			t4.setText("");
			t5.setText("");
			
			}
			catch(ClassNotFoundException e){System.out.println("Driver Error..."+e);}
			catch(SQLException e){System.out.println("SQL Error"+e);} 			
	 	}	

	if(ae.getSource()==b7)
		{
		PackageFetch ob=new PackageFetch();
		}
	/*if(ae.getSource()==b6)
		{
		Fees ob=new Fees();
		}
*/
	if(ae.getSource()==b3)
		{
		FitnessMDI ob=new FitnessMDI();
		}


}

public void itemStateChanged(ItemEvent ae)
{

if(ae.getSource()==cm1)   
	{




   int pid=Integer.parseInt((String)ae.getItem());
	
    try
    {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    System.out.println("Connection Done\n"); 
    con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    System.out.println("Driver Loaded\n"); 
   stmt=con.createStatement();
  String str="select * from Profile_Table where P_Id="+pid+"";
     rs=stmt.executeQuery(str);
	System.out.println(pid);

while(rs.next())
{
	
	
    	t4.setText(rs.getString(2));
    	t19.setText(rs.getString(3));   
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

if(ae.getSource()==cm3)   
	{
System.out.println(ptype);

   String mship=(String)ae.getItem();
	String str;
    try
    {
    	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	System.out.println("Connection Done\n"); 
    	con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    	System.out.println("Driver Loaded\n"); 
   	stmt=con.createStatement();
  	if(ptype.equals("Combo Package"))
	str="select * from Combo_Package where Membership='"+ mship +"'";
     	else
	 str="select * from Individual_Package where Membership='"+ mship +"'";
     	
	rs=stmt.executeQuery(str);
	System.out.println(mship);

while(rs.next())
{
	

    	t3.setText(rs.getString(1));
    	t5.setText(rs.getString(3));  	
    	t15.setText(rs.getString(4));
	t14.setText(rs.getString(5));
	t16.setText(rs.getString(6));
	t17.setText(rs.getString(7));
	t18.setText(rs.getString(8));
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

if(ae.getSource()==cm4)   
	{
   String shift=(String)ae.getItem();
	
    try
    {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    System.out.println("Connection Done\n"); 
    con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    System.out.println("Driver Loaded\n"); 
   stmt=con.createStatement();
  String str="select * from Batch_Table where Batch_Shift='"+shift+"'";
     rs=stmt.executeQuery(str);
	System.out.println(shift);

while(rs.next())
{
	
	
    	t21.setText(rs.getString(1));
      
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
new Package();
}}



