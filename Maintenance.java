import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Maintenance extends JFrame implements ActionListener,ItemListener,KeyListener
{
Color c2=new Color(14,31,29);
Color c1=new Color(50,116,109);
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
JButton b1,b2,b3;
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
public Maintenance()
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
l1=new JLabel("         Maintenance Details");
p1.setBackground(c1);
l1.setForeground(c2);
l1.setFont(f1);

l1.setBounds(0,0,1200,200);
p1.add(l1);
add(p1);

//second panel
p2=new JPanel();
p2.setBounds(350,220,650,480);
add(p2);
p2.setBackground(c1);
p2.setLayout(null);

l2=new JLabel("Maintenance ID");
l2.setForeground(c2);
l2.setBounds(10,20,200,20);
l2.setFont(f3);
p2.add(l2);

t1=new JTextField(20);
t1.setBounds(120,20,200,20);
t1.setFont(f3);
p2.add(t1);




l5=new JLabel("Manager Name");
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
  		String	 str="select * from Manager_Table";
		rs=stmt.executeQuery(str);
   		while(rs.next())
		{
		
		cm1.addItem(rs.getString(2));
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





l3=new JLabel("Manager Id");
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
p4.setBounds(10,100,600,360);
add(p4);
p4.setBackground(c2);
p4.setLayout(null);
p2.add(p4);

l4=new JLabel("Maintenance Date");
l4.setForeground(c1);
l4.setBounds(100,20,200,20);
l4.setFont(f3);
p4.add(l4);

cm3=new JComboBox();
cm3.setBounds(300,20,40,20);
for(int i=1;i<=31;i++)
cm3.addItem(String.valueOf(i));
p4.add(cm3);


cm4=new JComboBox();
cm4.setBounds(380,20,50,20);
cm4.addItem("Jan");
cm4.addItem("Feb");
cm4.addItem("Mar");
cm4.addItem("Apr");
cm4.addItem("May");
cm4.addItem("Jun");
cm4.addItem("Jul");
cm4.addItem("Aug");
cm4.addItem("Sep");
cm4.addItem("Oct");
cm4.addItem("Nov");
cm4.addItem("Dec");
p4.add(cm4);



cm5=new JComboBox();
cm5.setBounds(450,20,50,20);
for(int i=1970;i<2000;i++)
cm5.addItem(String.valueOf(i));
p4.add(cm5);


l7=new JLabel("Equipment type");
l7.setForeground(c1);
l7.setBounds(100,80,450,20);
l7.setFont(f3);
p4.add(l7);

t4=new JTextField(20);
t4.setBounds(300,80,200,20);
t4.setFont(f3);
p4.add(t4);


l8=new JLabel("Number of Equipments");
l8.setForeground(c1);
l8.setBounds(100,110,450,20);
l8.setFont(f3);
p4.add(l8);

t5=new JTextField(20);
t5.setBounds(300,110,200,20);
t5.addKeyListener(this);
t5.setFont(f3);
p4.add(t5);


l9=new JLabel("Reason for Maintenance");
l9.setForeground(c1);
l9.setBounds(100,140,450,20);
l9.setFont(f3);
p4.add(l9);

t6=new JTextField(20);
t6.setBounds(300,140,200,20);
t6.setFont(f3);
p4.add(t6);


l6=new JLabel("Cost of Maintenance");
l6.setForeground(c1);
l6.setBounds(100,170,200,20);
l6.setFont(f3);
p4.add(l6);

t3=new JTextField(20);
t3.setBounds(300,170,200,20);
t3.addKeyListener(this);
t3.setFont(f3);
p4.add(t3);



b1=new JButton("Submit");
b1.setBounds(100,270,150,25);
b1.addActionListener(this);
b1.setFont(f3);
p4.add(b1);

b2=new JButton("New Maintenance");
b2.setBounds(200,300,150,25);
b2.addActionListener(this);
b2.setFont(f3);
p4.add(b2);

b3=new JButton("Home");
b3.setBounds(300,270,150,25);
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
			String sql="select max(Maintenance_Id) from Maintenance_Table";
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
		
	int flag=1;
		String s1=t5.getText();
		
		String s2=t2.getText();
		
		String s3=t4.getText();
		
		String s7=t3.getText();
		
		String s6=t6.getText();
		

		//cnt++;
		if(s1.equals("")||s2.equals("")||s3.equals("")||s7.equals("")||s6.equals(""))
		{
		flag=0;
	JOptionPane.showMessageDialog(null,"Some Fields Are Empty","NewUser",JOptionPane.INFORMATION_MESSAGE);
		 
		
		}

	if(flag==1)
		{
		
		int s4=Integer.parseInt(t5.getText());
		int s5=Integer.parseInt(t3.getText());
		if((s4<10)||(s4>100000))
		{
				JOptionPane.showMessageDialog(null,"Quantity cannot be negative or excessive","NewUser",JOptionPane.INFORMATION_MESSAGE);
				t5.setText("");
				//flag=0;
		}
		else if((s5<10)||(s5>100000))
		{
				JOptionPane.showMessageDialog(null,"Cost cannot be negative or excessive","NewUser",JOptionPane.INFORMATION_MESSAGE);
				t3.setText("");
				//flag=0;
		}
		else
		{




	
	int mid=Integer.parseInt(t1.getText());
	String mname=(String)cm1.getSelectedItem();
	int mnid=Integer.parseInt(t2.getText());
	String rday=(String)cm3.getSelectedItem();
	String rmonth=(String)cm4.getSelectedItem();
	String ryr=(String)cm5.getSelectedItem();
	
	String mdate=rday+"-"+rmonth+"-"+ryr;
	
	
	String etype=t4.getText();
	int no=Integer.parseInt(t5.getText());
	int cost=Integer.parseInt(t3.getText());
	
	String reason=t6.getText();
	t6.setText(String.valueOf(totalreceipt));
	
	

	
	

	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:Fitness_Center");
		System.out.println("Connection Established");
		stmt=con.createStatement();
	
		
		String sql="insert into Maintenance_Table values ("+ mid + "," +mnid +",'" + mname + "','" +mdate +"','" + etype + "'," +no+ ",'" +reason+ "'," + cost + ")";
        	int i=stmt.executeUpdate(sql);
		if(i>0)
		JOptionPane.showMessageDialog(null,"Record is Submited","Trainer",JOptionPane.INFORMATION_MESSAGE);
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
}	if(ae.getSource()==b2)
		{int ttid=0;
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Maintenance_Id) from Maintenance_Table";
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
 
   
   String fid=(String)ae.getItem();
	
    try
    {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    System.out.println("Connection Done\n"); 
    con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    System.out.println("Driver Loaded\n"); 
   stmt=con.createStatement();
  String str="select * from Manager_Table where M_Name='"+fid+"'";
     rs=stmt.executeQuery(str);
	

while(rs.next())
{
	
	
    	t2.setText(rs.getString(1));
   	
   
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

public void keyTyped(KeyEvent e){
}
public void keyPressed(KeyEvent e){
if(e.getSource()==t5)
	{
	char ch=e.getKeyChar();
	if(ch>=65)
		{
		JOptionPane.showMessageDialog(null,"Only Numerical value","Maintenance",JOptionPane.INFORMATION_MESSAGE);
		t5.setText("");
		}
	}
	if(e.getSource()==t3)
	{
	char ch=e.getKeyChar();
	if(ch>=65)
		{
		JOptionPane.showMessageDialog(null,"Only Numerical value","Maintenance",JOptionPane.INFORMATION_MESSAGE);
		t3.setText("");
		}
	}
}
public void keyReleased(KeyEvent e){
}

public static void main(String a[])
{
new Maintenance();
}}



