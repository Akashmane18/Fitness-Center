import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Employee extends JFrame implements ActionListener,KeyListener
{
Color c2=new Color(55,54,9);
Color c1=new Color(197,182,80);
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l10,l11,l12,l13;
JTextField t1,t2,t3,t4,t5,t6t7,t8,t9;
JButton b1,b2,b3;
ImageIcon img1;
JPanel p1,p2;
JRadioButton r1,r2;
JComboBox cm1,cm2,cm3,cm4,cm5;
Container c;
Connection con;
Statement stmt;
ResultSet rs;

Font f1=new Font("Old English Text MT",Font.BOLD,50);
Font f2=new Font("Old English Text MT",Font.BOLD,15);
Font f3=new Font("Cambria",Font.BOLD,15);
Font f7=new Font("Colonna MT",Font.BOLD,50);
public Employee()
{
         setSize(300,300);
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
l1=new JLabel("            Employee Details");
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

l2=new JLabel("Employee Id");
l2.setForeground(c2);
l2.setBounds(100,20,200,20);
l2.setFont(f3);
p2.add(l2);

t1=new JTextField(20);
t1.setBounds(250,20,200,20);
t1.setFont(f3);
p2.add(t1);


l6=new JLabel("Gender");
l6.setForeground(c2);
l6.setBounds(500,20,200,20);
l6.setFont(f3);
p2.add(l6);

ButtonGroup bg=new ButtonGroup();
r1 = new JRadioButton("Male");
r2 = new JRadioButton("Female");
r1.setBounds(700,20,100,20);
r2.setBounds(850,20,100,20);
p2.add(r1);
p2.add(r2);
bg.add(r1);
bg.add(r2);

l3=new JLabel("Employee Name");
l3.setForeground(c2);
l3.setBounds(100,50,200,20);
l3.setFont(f3);
p2.add(l3);


t2=new JTextField(20);
t2.setBounds(250,50,200,20);
t2.addKeyListener(this);
t2.setFont(f3);
p2.add(t2);


l7=new JLabel("Birth Date:");
l7.setForeground(c2);
l7.setBounds(500,50,200,20);
l7.setFont(f3);
p2.add(l7);

cm1=new JComboBox();
cm1.setBounds(700,50,50,20);
for(int i=1;i<=31;i++)
cm1.addItem(String.valueOf(i));
p2.add(cm1);

cm2=new JComboBox();
cm2.setBounds(770,50,60,20);
cm2.addItem("Jan");
cm2.addItem("Feb");
cm2.addItem("Mar");
cm2.addItem("Apr");
cm2.addItem("May");
cm2.addItem("Jun");
cm2.addItem("Jul");
cm2.addItem("Aug");
cm2.addItem("Sep");
cm2.addItem("Oct");
cm2.addItem("Nov");
cm2.addItem("Dec");
p2.add(cm2);

cm3=new JComboBox();
cm3.setBounds(840,50,80,20);
for(int i=1970;i<2000;i++)
cm3.addItem(String.valueOf(i));

p2.add(cm3);


l8=new JLabel("Experience");
l8.setForeground(c2);
l8.setBounds(500,80,200,20);
l8.setFont(f3);
p2.add(l8);



t5=new JTextField(20);
t5.setBounds(700,80,200,20);
t5.addKeyListener(this);
t5.setFont(f3);
p2.add(t5);

l10=new JLabel("[in yrs]");
l10.setForeground(c2);
l10.setBounds(950,80,200,20);
l10.setFont(f3);
p2.add(l10);

l11=new JLabel("Manager ID");
l11.setForeground(c2);
l11.setBounds(600,110,200,20);
l11.setFont(f3);
p2.add(l11);



cm5=new JComboBox();
cm5.setBounds(800,110,200,20);
cm5.addItem("--Select--");

p2.add(cm5);

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
		
		cm5.addItem(rs.getString(1));
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
  

l4=new JLabel("Employee Designation");
l4.setForeground(c2);
l4.setBounds(100,80,200,20);
l4.setFont(f3);
p2.add(l4);

t3=new JTextField(20);
t3.setBounds(250,80,200,20);
t3.setFont(f3);
p2.add(t3);



l5=new JLabel("Skills & Certification");
l5.setForeground(c2);
l5.setBounds(100,110,200,20);
l5.setFont(f3);
p2.add(l5);


cm4=new JComboBox();
cm4.setBounds(250,110,300,20);
cm4.addItem("--Select--");
cm4.addItem("Certification in Biochemistry or Physiology");
cm4.addItem("Degree in dietics/nutrition or related");
cm4.addItem("Experiance as Fitness Support Personality");
cm4.addItem("Knowledge of fitness Assessment");
cm4.addItem("None of these");

p2.add(cm4); 

l7=new JLabel("Email-ID ");
l7.setForeground(c2);
l7.setBounds(100,140,200,20);
l7.setFont(f3);
p2.add(l7);

t4=new JTextField(20);
t4.setBounds(250,140,500,20);
t4.setFont(f3);
p2.add(t4);


b1=new JButton("Submit");
b1.addActionListener(this);
b1.setBounds(250,250,150,25);
b1.setFont(f3);
p2.add(b1);

b2=new JButton("Reset");
b2.addActionListener(this);
b2.setBounds(450,250,150,25);
b2.setFont(f3);
p2.add(b2);

b3=new JButton("Home");
b3.addActionListener(this);
b3.setBounds(650,250,150,25);
b3.setFont(f3);
p2.add(b3);

try
			{int mid=0;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Employee_Id) from Employee_Table";
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
		String s4=t4.getText();
		
		int l=s4.indexOf("@");
		int d=s4.indexOf(".");

		if((l==-1)||(d==-1))
		{
				JOptionPane.showMessageDialog(null,"Email address should have @ and . symbol ","NewUser",JOptionPane.INFORMATION_MESSAGE);
				t4.setText("");
				flag=0;
		}

	if(flag==1)
		{
		

		String s1=t2.getText();
		String s3=t5.getText();
		String s6=t3.getText();
		
		String s7=t4.getText();
		

		//cnt++;
		if(s1.equals("")||s3.equals("")||s6.equals("")||s7.equals(""))
		{
		//flag=0;
	JOptionPane.showMessageDialog(null,"Some Fields Are Empty","NewUser",JOptionPane.INFORMATION_MESSAGE);
		 
		
		}
else
{
	
	
	int eid=Integer.parseInt(t1.getText());
	
	String ename=t2.getText();
	
	String eday=(String)cm1.getSelectedItem();
	String emonth=(String)cm2.getSelectedItem();
	String eyr=(String)cm3.getSelectedItem();
	
	String edate=eday+"-"+emonth+"-"+eyr;
	int eexp=Integer.parseInt(t5.getText());

	String edes=t3.getText();
	String eemail=t4.getText();
	String eskill=(String)cm4.getSelectedItem();
	int emid=Integer.parseInt((String)cm5.getSelectedItem());
	
	
	
	String egender="";
	if(r1.isSelected()==true)
	egender="Male";
	else
	egender="Female";





	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:Fitness_Center");
		System.out.println("Connection Established");
		stmt=con.createStatement();
	
		
		String sql="insert into Employee_Table values ("+ eid + ",'" + ename + "','" + edes + "','" +eskill +"','" + eemail+ "','" +egender+"','"+edate+"'," + eexp +"," + emid + ")";
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
			String sql="select max(Employee_Id) from Employee_Table";
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

public void keyTyped(KeyEvent e){
}
public void keyPressed(KeyEvent e){

	if(e.getSource()==t5)
	{
	char ch=e.getKeyChar();
	if(ch>=65)
		{
		JOptionPane.showMessageDialog(null,"Characters are not allowed","NewUser",JOptionPane.INFORMATION_MESSAGE);
		t5.setText("");
		}
	} 
 if(e.getSource()==t2)
	{
	char ch=e.getKeyChar();
	if(ch>=48 && ch<=57)
		{
		JOptionPane.showMessageDialog(null,"Numbers are not allowed","NewUser",JOptionPane.INFORMATION_MESSAGE);
		t2.setText("");
		}
	}

	}
public void keyReleased(KeyEvent e){
}

public static void main(String a[])
{
new Employee();
}}




























