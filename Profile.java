import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Profile extends JFrame implements ActionListener,ItemListener,KeyListener
{
Color c2=new Color(33,28,7);
Color c1=new Color(189,114,13);
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t16;
JTextArea t14,t15;
JButton b1,b2,b3,b4,b5,b6;
ImageIcon img1;
JPanel p1,p2;
JRadioButton r1,r2,r3,r4;
JComboBox cm1,cm2,cm3;
Container c;
Connection con;
Statement stmt;
ResultSet rs;
int pid;

Font f1=new Font("Old English Text MT",Font.BOLD,50);
Font f2=new Font("Old English Text MT",Font.BOLD,15);
Font f3=new Font("Cambria",Font.BOLD,15);
Font f7=new Font("Colonna MT",Font.BOLD,50);
public Profile()
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
l1=new JLabel("Member Profile Details");
p1.setBackground(c1);
l1.setForeground(c2);
l1.setFont(f7);

l1.setBounds(400,0,800,200);
p1.add(l1);
add(p1);

//second panel
p2=new JPanel();
p2.setBounds(10,250,650,400);
add(p2);
p2.setBackground(c1);
p2.setLayout(null);

l2=new JLabel("Member Name");
l2.setForeground(c2);
l2.setBounds(10,20,200,20);
l2.setFont(f3);
p2.add(l2);

cm1=new JComboBox();
cm1.setBounds(120,20,200,20);
cm1.addItem("--Select");
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
l3.setBounds(10,50,200,20);
l3.setFont(f3);
p2.add(l3);

t2=new JTextField(20);
t2.setBounds(120,50,200,20);
t2.setFont(f3);
p2.add(t2);


l18=new JLabel("M_Age");
l18.setForeground(c2);
l18.setBounds(350,20,200,20);
l18.setFont(f3);
p2.add(l18);

t1=new JTextField(20);
t1.setBounds(430,20,200,20);
t1.setFont(f3);
p2.add(t1);



l19=new JLabel("M_Gender");
l19.setForeground(c2);
l19.setBounds(350,50,200,20);
l19.setFont(f3);
p2.add(l19);

t9=new JTextField(20);
t9.setBounds(430,50,200,20);
t9.setFont(f3);
p2.add(t9);

//profile panel
JPanel p4=new JPanel();
p4.setBounds(10,100,600,280);
add(p4);
p4.setBackground(c2);
p4.setLayout(null);
p2.add(p4);

l4=new JLabel("Height[m]");
l4.setForeground(c1);
l4.setBounds(100,20,200,20);
l4.setFont(f3);
p4.add(l4);

t3=new JTextField(20);
t3.setBounds(240,20,50,20);
t3.addKeyListener(this);
t3.setFont(f3);
p4.add(t3);


l5=new JLabel("Weight[kg]");
l5.setForeground(c1);
l5.setBounds(100,50,200,20);
l5.setFont(f3);
p4.add(l5);

t4=new JTextField(20);
t4.setBounds(240,50,50,20);
t4.addKeyListener(this);
t4.setFont(f3);

p4.add(t4);


l7=new JLabel("Stomach[cm]");
l7.setForeground(c1);
l7.setBounds(100,80,200,20);
l7.setFont(f3);
p4.add(l7);

t6=new JTextField(20);
t6.setBounds(240,80,50,20);
t6.addKeyListener(this);
t6.setFont(f3);

p4.add(t6);

l8=new JLabel("Neck[cm]");
l8.setForeground(c1);
l8.setBounds(100,110,200,20);
l8.setFont(f3);
p4.add(l8);

t7=new JTextField(20);
t7.setBounds(240,110,50,20);
t7.addKeyListener(this);
t7.setFont(f3);
p4.add(t7);

l9=new JLabel("BFP[in%]");
l9.setForeground(c1);
l9.setBounds(100,140,200,20);
l9.setFont(f3);
p4.add(l9);

t8=new JTextField(20);
t8.setBounds(240,140,50,20);
t8.addKeyListener(this);
t8.setFont(f3);
p4.add(t8);

l6=new JLabel("BMI[kg/ft]");
l6.setForeground(c1);
l6.setBounds(350,20,200,20);
l6.setFont(f3);
p4.add(l6);

t5=new JTextField(20);
t5.setBounds(490,20,100,20);
t5.addKeyListener(this);
t5.setFont(f3);
p4.add(t5);

l12=new JLabel("Waist[cm]");
l12.setForeground(c1);
l12.setBounds(350,50,200,20);
l12.setFont(f3);
p4.add(l12);

t10=new JTextField(20);
t10.setBounds(490,50,50,20);
t10.addKeyListener(this);
t10.setFont(f3);
p4.add(t10);

l13=new JLabel("Lower Waist[cm]");
l13.setForeground(c1);
l13.setBounds(350,80,200,20);
l13.setFont(f3);
p4.add(l13);

t11=new JTextField(20);
t11.setBounds(490,80,50,20);
t11.addKeyListener(this);
t11.setFont(f3);
p4.add(t11);

l14=new JLabel("Biceps[cm]");
l14.setForeground(c1);
l14.setBounds(350,110,200,20);
l14.setFont(f3);
p4.add(l14);

t12=new JTextField(20);
t12.setBounds(490,110,50,20);
t12.addKeyListener(this);
t12.setFont(f3);
p4.add(t12);

l15=new JLabel("Shoulders[cm]");
l15.setForeground(c1);
l15.setBounds(350,140,200,20);
l15.setFont(f3);
p4.add(l15);

t13=new JTextField(20);
t13.setBounds(490,140,50,20);
t13.addKeyListener(this);
t13.setFont(f3);
p4.add(t13);

//fitness panel
JPanel p3=new JPanel();
p3.setBounds(700,250,650,400);
add(p3);
p3.setBackground(c1);
p3.setLayout(null);



l19=new JLabel("Profile ID");
l19.setForeground(c2);
l19.setBounds(100,20,450,20);
l19.setFont(f3);
p3.add(l19);

t16=new JTextField(20);
t16.setBounds(250,20,200,20);
t16.setFont(f3);
p3.add(t16);

l10=new JLabel("Stress Test/Fitness Checkup");
l10.setForeground(c2);
l10.setBounds(100,50,200,20);
l10.setFont(f3);
p3.add(l10);

r1 = new JRadioButton("Yes");
r2 = new JRadioButton("No");
r1.setBounds(350,80,100,20);
r2.setBounds(500,80,100,20);
p3.add(r1);
p3.add(r2);

l11=new JLabel("Is yes(Mention the certification course and Doctor name below):");
l11.setForeground(c2);
l11.setBounds(100,110,450,20);
l11.setFont(f3);
p3.add(l11);

t15=new JTextArea();
t15.setBounds(100,140,450,40);
t15.setFont(f3);
p3.add(t15);


l16=new JLabel("Any Disease/Health Issues");
l16.setForeground(c2);
l16.setBounds(100,200,200,20);
l16.setFont(f3);
p3.add(l16);

r3 = new JRadioButton("Yes");
r4 = new JRadioButton("No");
r3.setBounds(350,200,100,20);
r4.setBounds(500,200,100,20);
p3.add(r3);
p3.add(r4);

l17=new JLabel("Is yes(Mention in detail with the treatment below):");
l17.setForeground(c2);
l17.setBounds(100,230,450,20);
l17.setFont(f3);
p3.add(l17);

t14=new JTextArea();
t14.setBounds(100,260,450,40);
t14.setFont(f3);
p3.add(t14);










b1=new JButton("Submit");
b1.setBounds(100,180,150,25);
b1.addActionListener(this);
b1.setFont(f3);
p4.add(b1);

b2=new JButton("New Profile");
b2.setBounds(300,180,150,25);
b2.addActionListener(this);
b2.setFont(f3);
p4.add(b2);

b3=new JButton("Home");
b3.setBounds(100,210,150,25);
b3.addActionListener(this);
b3.setFont(f3);
p4.add(b3);

b4=new JButton("Progress Card");
b4.setBounds(300,210,150,25);
b4.addActionListener(this);
b4.setFont(f3);
p4.add(b4);

b5=new JButton("Search");
b5.setBounds(100,240,150,25);
b5.addActionListener(this);
b5.setFont(f3);
p4.add(b5);

b6=new JButton("Select Package");
b6.setBounds(300,240,150,25);
b6.addActionListener(this);
b6.setFont(f3);
p4.add(b6);

try
			{int mid=0;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(P_ID) from Profile_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			mid=Integer.parseInt(rs.getString(1));
			}
			
			t16.setText(String.valueOf(mid));
			t16.setEditable(false);
			
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

		String s1=t1.getText();
		String s2=String.valueOf(cm1.getSelectedItem());
        	
		String s3=t2.getText();
		
		String s4=t3.getText();
		String s5=t4.getText();
	
		String s7=t6.getText();
String s8=t7.getText();

String s10=t10.getText();
String s11=t11.getText();
String s12=t12.getText();
String s13=t13.getText();
String s14=t14.getText();
String s15=t15.getText();
String s16=t16.getText();




		//cnt++;
		if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s7.equals("")||s8.equals("")||s10.equals("")||s11.equals("")||s12.equals("")||s13.equals("")||s14.equals("")||s15.equals("")||s16.equals(""))
		{
	
	JOptionPane.showMessageDialog(null,"Some Fields Are Empty","NewUser",JOptionPane.INFORMATION_MESSAGE);
		 
		
		}
else
{

	
int pid=Integer.parseInt(t16.getText());

String mname=(String)cm1.getSelectedItem();	
int mid=Integer.parseInt(t2.getText());
int mage=Integer.parseInt(t1.getText());
String mgender=t9.getText();
float mht=Float.parseFloat(t3.getText());	
float mwt=Float.parseFloat(t4.getText());
float mstmch=Float.parseFloat(t6.getText());
float mneck=Float.parseFloat(t7.getText());
float mBMI=mwt/((mht)*(mht));
	t5.setText(String.valueOf(mBMI));
double n=1.20*(mBMI);
double m=0.23*(mage);
double mBFP=(n+m);
System.out.println(mBFP);
	t8.setText(String.valueOf(mBFP));
	
float mwaist=Float.parseFloat(t10.getText());
float mlwrwaist=Float.parseFloat(t11.getText());
float mbic=Float.parseFloat(t12.getText());
float msh=Float.parseFloat(t13.getText());
String mcerti=t15.getText();
String mtreatdetails=t14.getText();
	

	
	String mstress="";
	if(r1.isSelected()==true)
	mstress="Yes";
	else
	mstress="No";

	
	String mtreat="";	
	if(r3.isSelected()==true)
	mtreat="Yes";
	else
	mtreat="No";

	







	
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:Fitness_Center");
		System.out.println("Connection Established");
		stmt=con.createStatement();
		String sql="insert into Profile_Table values (" + pid + ",'" + mname + "'," + mid + "," + mage + ",'" + mgender +"'," + mht + "," + mwt + "," + mstmch + "," + mneck + "," + mBFP + "," + mBMI + "," + mwaist + "," + mlwrwaist + ","+ mbic + "," + msh + ",'" + mstress + "','" + mcerti + "','" + mtreat + "','" + mtreatdetails + "')";
		int i=stmt.executeUpdate(sql);
		if(i>0)
		JOptionPane.showMessageDialog(null,"Record is Submited","Registration",JOptionPane.INFORMATION_MESSAGE);
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
		{ 
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(P_ID) from Profile_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			pid=Integer.parseInt(rs.getString(1));
			t16.setText(String.valueOf(pid));
			}
			
			pid++;
			t16.setText(String.valueOf(pid));

			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			t8.setText("");
			t9.setText("");
			t10.setText("");
			t11.setText("");
			t12.setText("");
			t13.setText("");
			t14.setText("");
			t15.setText("");
			


			
			}
			catch(ClassNotFoundException e){System.out.println("Driver Error..."+e);}
			catch(SQLException e){System.out.println("SQL Error"+e);} 			
	 	}	
		if(ae.getSource()==b5)
		{
		ProfileFetch ob=new ProfileFetch();
		}
	if(ae.getSource()==b6)
		{
		Package ob=new Package();
		}
		if(ae.getSource()==b3)
		{
		FitnessMDI ob=new FitnessMDI();
		}
		if(ae.getSource()==b4)
		{
			PieChart ob=new PieChart();
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
	
	
    	t2.setText(rs.getString(2));
   	t9.setText(rs.getString(6));
	t1.setText(rs.getString(8));
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
		JOptionPane.showMessageDialog(null,"Only Numerical value","Profile",JOptionPane.INFORMATION_MESSAGE);
		t3.setText("");
		}
	}

if(e.getSource()==t4)
	{
	char ch=e.getKeyChar();
	if(ch>=65)
		{
		JOptionPane.showMessageDialog(null,"Only Numerical value","Profile",JOptionPane.INFORMATION_MESSAGE);
		t4.setText("");
		}
	}
if(e.getSource()==t5)
	{
	char ch=e.getKeyChar();
	if(ch>=65)
		{
		JOptionPane.showMessageDialog(null,"Only Numerical value","Profile",JOptionPane.INFORMATION_MESSAGE);
		t5.setText("");
		}
	}
if(e.getSource()==t6)
	{
	char ch=e.getKeyChar();
	if(ch>=65)
		{
		JOptionPane.showMessageDialog(null,"Only Numerical value","Profile",JOptionPane.INFORMATION_MESSAGE);
		t6.setText("");
		}
	}
if(e.getSource()==t7)
	{
	char ch=e.getKeyChar();
	if(ch>=65)
		{
		JOptionPane.showMessageDialog(null,"Only Numerical value","Profile",JOptionPane.INFORMATION_MESSAGE);
		t7.setText("");
		}
	}
if(e.getSource()==t8)
	{
	char ch=e.getKeyChar();
	if(ch>=65)
		{
		JOptionPane.showMessageDialog(null,"Only Numerical value","Profile",JOptionPane.INFORMATION_MESSAGE);
		t8.setText("");
		}
	}
if(e.getSource()==t10)
	{
	char ch=e.getKeyChar();
	if(ch>=65)
		{
		JOptionPane.showMessageDialog(null,"Only Numerical value","Profile",JOptionPane.INFORMATION_MESSAGE);
		t10.setText("");
		}
	}
if(e.getSource()==t11)
	{
	char ch=e.getKeyChar();
	if(ch>=65)
		{
		JOptionPane.showMessageDialog(null,"Only Numerical value","Profile",JOptionPane.INFORMATION_MESSAGE);
		t11.setText("");
		}
	}
if(e.getSource()==t12)
	{
	char ch=e.getKeyChar();
	if(ch>=65)
		{
		JOptionPane.showMessageDialog(null,"Only Numerical value","Profile",JOptionPane.INFORMATION_MESSAGE);
		t12.setText("");
		}
	}
if(e.getSource()==t13)
	{
	char ch=e.getKeyChar();
	if(ch>=65)
		{
		JOptionPane.showMessageDialog(null,"Only Numerical value","Profile",JOptionPane.INFORMATION_MESSAGE);
		t13.setText("");
		}
	}

}


public void keyReleased(KeyEvent e){
}




public static void main(String a[])
{
new Profile();
}}




























