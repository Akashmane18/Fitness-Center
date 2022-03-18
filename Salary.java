import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Salary extends JFrame implements ActionListener,ItemListener,KeyListener
{
Color c2=new Color(46,43,18);
Color c1=new Color(133,123,52);
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17;
JButton b1,b2,b3;
ImageIcon img1;
JPanel p1,p2;
JRadioButton r1,r2,r3,r4;
JComboBox cm1,cm2,cm3,cm4,cm5;
Container c;
Connection con;
Statement stmt;
ResultSet rs;

Font f1=new Font("Old English Text MT",Font.BOLD,50);
Font f2=new Font("Old English Text MT",Font.BOLD,15);
Font f3=new Font("Cambria",Font.BOLD,15);
Font f7=new Font("Colonna MT",Font.BOLD,50);
public Salary()
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
l1=new JLabel("Employee Salary Details");
p1.setBackground(c1);
l1.setForeground(c2);
l1.setFont(f7);

l1.setBounds(400,0,800,200);
p1.add(l1);
add(p1);

//second panel
p2=new JPanel();
p2.setBounds(10,250,680,400);
add(p2);
p2.setBackground(c1);
p2.setLayout(null);

l2=new JLabel("Employee Name");
l2.setForeground(c2);
l2.setBounds(10,20,200,20);
l2.setFont(f3);
p2.add(l2);

cm1=new JComboBox();
cm1.setBounds(130,20,170,20);
cm1.addItem("--Select--");
try
    		{
   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   		 System.out.println("Connection Done\n"); 
    		con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    		System.out.println("Driver Loaded\n"); 
   		stmt=con.createStatement();
  		String	 str="select * from Employee_Table";
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


l3=new JLabel("Employee Id");
l3.setForeground(c2);
l3.setBounds(10,50,200,20);
l3.setFont(f3);
p2.add(l3);


t2=new JTextField(20);
t2.setBounds(130,50,170,20);
t2.setFont(f3);
p2.add(t2);


//labels for salary
l18=new JLabel("Salary Id");
l18.setForeground(c2);
l18.setBounds(310,20,170,20);
l18.setFont(f3);
p2.add(l18);

t14=new JTextField(20);
t14.setBounds(460,20,200,20);
t14.setFont(f3);
p2.add(t14);

l19=new JLabel("Employee Designation");
l19.setForeground(c2);
l19.setBounds(310,50,170,20);
l19.setFont(f3);
p2.add(l19);

t15=new JTextField(20);
t15.setBounds(460,50,200,20);
t15.setFont(f3);
p2.add(t15);

//salary panel
JPanel p4=new JPanel();
p4.setBounds(10,100,600,280);
add(p4);
p4.setBackground(c2);
p4.setLayout(null);
p2.add(p4);


l5=new JLabel("Number of leaves");
l5.setForeground(c1);
l5.setBounds(100,50,200,20);
l5.setFont(f3);
p4.add(l5);


t3=new JTextField(20);
t3.setBounds(240,50,50,20);
t3.addKeyListener(this);
t3.setFont(f3);
p4.add(t3);


l7=new JLabel("Basic Salary");
l7.setForeground(c1);
l7.setBounds(100,80,200,20);
l7.setFont(f3);
p4.add(l7);


t4=new JTextField(20);
t4.setBounds(240,80,50,20);
t4.addKeyListener(this);
t4.setFont(f3);
p4.add(t4);

l8=new JLabel("HRA[0.32%]");
l8.setForeground(c1);
l8.setBounds(100,110,200,20);
l8.setFont(f3);
p4.add(l8);

t5=new JTextField(20);
t5.setBounds(240,110,50,20);
t5.setFont(f3);
p4.add(t5);

l9=new JLabel("DA[0.28%]");
l9.setForeground(c1);
l9.setBounds(100,140,200,20);
l9.setFont(f3);
p4.add(l9);

t6=new JTextField(20);
t6.setBounds(240,140,50,20);
t6.setFont(f3);
p4.add(t6);


l15=new JLabel("MA[0.2%]");
l15.setForeground(c1);
l15.setBounds(100,170,200,20);
l15.setFont(f3);
p4.add(l15);

t13=new JTextField(20);
t13.setBounds(240,170,50,20);
t13.setFont(f3);
p4.add(t13);


l12=new JLabel("Deduction for leaves");
l12.setForeground(c1);
l12.setBounds(350,50,200,20);
l12.setFont(f3);
p4.add(l12);

t10=new JTextField(20);
t10.setBounds(490,50,50,20);
t10.setFont(f3);
p4.add(t10);

l6=new JLabel("Tax[0.1%]");
l6.setForeground(c1);
l6.setBounds(350,110,200,20);
l6.setFont(f3);
p4.add(l6);

t7=new JTextField(20);
t7.setBounds(490,110,50,20);
t7.setFont(f3);
p4.add(t7);

l13=new JLabel("PF[0.20%]");
l13.setForeground(c1);
l13.setBounds(350,140,200,20);
l13.setFont(f3);
p4.add(l13);

t11=new JTextField(20);
t11.setBounds(490,140,50,20);
t11.setFont(f3);
p4.add(t11);

l14=new JLabel("PT[0.1%]");
l14.setForeground(c1);
l14.setBounds(350,170,200,20);
l14.setFont(f3);
p4.add(l14);

t12=new JTextField(20);
t12.setBounds(490,170,50,20);
t12.setFont(f3);
p4.add(t12);


//Date panel
JPanel p3=new JPanel();
p3.setBounds(700,250,650,400);
add(p3);
p3.setBackground(c1);
p3.setLayout(null);

l4=new JLabel("Salary Date");
l4.setForeground(c2);
l4.setBounds(100,50,200,20);
l4.setFont(f3);
p3.add(l4);


cm3=new JComboBox();
cm3.setBounds(250,50,40,20);
for(int i=1;i<=31;i++)
cm3.addItem(String.valueOf(i));
p3.add(cm3);

cm4=new JComboBox();
cm4.setBounds(330,50,60,20);
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
p3.add(cm4);




cm5=new JComboBox();
cm5.setBounds(400,50,70,20);

for(int i=1970;i<2000;i++)
cm5.addItem(String.valueOf(i));
p3.add(cm5);



l10=new JLabel("Gross Salary");
l10.setForeground(c2);
l10.setBounds(100,80,200,20);
l10.setFont(f3);
p3.add(l10);

t16=new JTextField(20);
t16.setBounds(250,80,200,20);
t16.setFont(f3);
p3.add(t16);


l11=new JLabel("Net Salary");
l11.setForeground(c2);
l11.setBounds(100,120,450,20);
l11.setFont(f3);
p3.add(l11);

t17=new JTextField(20);
t17.setBounds(250,120,200,20);
t17.setFont(f3);
p3.add(t17);








b1=new JButton("Submit");
b1.setBounds(100,210,150,25);
b1.addActionListener(this);
b1.setFont(f3);
p3.add(b1);

b2=new JButton("New Salary");
b2.setBounds(200,240,150,25);
b2.addActionListener(this);
b2.setFont(f3);
p3.add(b2);

b3=new JButton("Home");
b3.setBounds(300,210,150,25);
b3.addActionListener(this);
b3.setFont(f3);
p3.add(b3);

try
			{int mid=0;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Salary_Id) from Salary_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			mid=Integer.parseInt(rs.getString(1));
			}
			
			t14.setText(String.valueOf(mid));
			t14.setEditable(false);
			
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
		String s1=t14.getText();
		String s3=t15.getText();
		
		String s4=t3.getText();
		String s5=t4.getText();
	












		//cnt++;
		if(s1.equals("")||s3.equals("")||s4.equals("")||s5.equals(""))
		{
	
	JOptionPane.showMessageDialog(null,"Some Fields Are Empty","NewUser",JOptionPane.INFORMATION_MESSAGE);
		 
		
		}
else
{

	String ename=(String)cm1.getSelectedItem();
	int eid=Integer.parseInt(t2.getText());	
	int sid=Integer.parseInt(t14.getText());
	int leaves=Integer.parseInt(t3.getText());
	int ded=leaves*100;
	t10.setText(String.valueOf(ded));
	float bs=Float.parseFloat(t4.getText());
	
	float hra=bs*32/100;
	t5.setText(String.valueOf(hra));
	float da=bs*28/100;
	t6.setText(String.valueOf(da));
	float ma=bs*20/100;
	t13.setText(String.valueOf(ma));
	float gs=hra+da+ma;
	t16.setText(String.valueOf(gs));	

 	
	
	
	float tax=bs*10/100;
	t7.setText(String.valueOf(tax));
	float pf=bs*20/100;
	t11.setText(String.valueOf(pf));
	float pt=bs*10/100;
	t12.setText(String.valueOf(pt));
	float ns=gs-(tax+pf+pt);
	t17.setText(String.valueOf(ns));
 	
	
	
	
	String sday=(String)cm3.getSelectedItem();
	String smonth=(String)cm4.getSelectedItem();
	String syr=(String)cm5.getSelectedItem();
	
	String sdate=sday+"-"+smonth+"-"+syr;
	System.out.println(sdate);




	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:Fitness_Center");
		System.out.println("Connection Established");
		stmt=con.createStatement();
	
		
		String sql="insert into Salary_Table values ("+ sid + ",'" + sdate + "'," + eid + ",'" +ename +"'," + leaves+ "," + ded +"," + bs + "," + hra +"," + da + "," + ma + "," + gs +"," + tax + "," + pf + "," + pt + "," + ns +")";
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
}	if(ae.getSource()==b2)
		{int ttid=0;
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Salary_Id) from Salary_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			
			ttid=Integer.parseInt(rs.getString(1));
			}
			ttid++;
			t14.setText(String.valueOf(ttid));

			
			
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
 
   
   String ename=(String)ae.getItem();
	
    try
    {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    System.out.println("Connection Done\n"); 
    con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    System.out.println("Driver Loaded\n"); 
   stmt=con.createStatement();
  String str="select * from Employee_Table where E_Name='"+ename+"'";
     rs=stmt.executeQuery(str);
	System.out.println(ename);

while(rs.next())
{
	
	
    	t2.setText(rs.getString(1));
   	t15.setText(rs.getString(3));
	
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
if(e.getSource()==t3)
	{
	char ch=e.getKeyChar();
	if(ch>=65)
		{
		JOptionPane.showMessageDialog(null,"Only Numerical value","Salary",JOptionPane.INFORMATION_MESSAGE);
		t3.setText("");
		}
	}

if(e.getSource()==t4)
	{
	char ch=e.getKeyChar();
	if(ch>=65)
		{
		JOptionPane.showMessageDialog(null,"Only Numerical value","Salary",JOptionPane.INFORMATION_MESSAGE);
		t4.setText("");
		}
	}
}
public void keyReleased(KeyEvent e){
}


public static void main(String a[])
{
new Salary();
}}




























