import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Trainer extends JFrame implements ActionListener,KeyListener
{ 
Color c2=new Color(44,27,36);
Color c1=new Color(117,70,96);
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l10,l9;
JTextField t1,t2,t3,t4,t5,t6;
JButton b1,b2,b3,b4,b5;
ImageIcon img1;
JPanel p1,p2;
JRadioButton r1,r2;
JComboBox cm1,cm2,cm3;
int tid;
Container c;
Font f1=new Font("Old English Text MT",Font.BOLD,50);
Font f2=new Font("Old English Text MT",Font.BOLD,15);
Font f3=new Font("Cambria",Font.BOLD,15);
Font f7=new Font("Colonna MT",Font.BOLD,50);
Connection con;
Statement stmt;
ResultSet rs;

public Trainer()
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
l1=new JLabel("Trainer Details");
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

l2=new JLabel("Trainer Id");
l2.setForeground(c2);
l2.setBounds(100,20,200,20);
l2.setFont(f3);
p2.add(l2);

t1=new JTextField(20);
t1.setBounds(250,20,200,20);
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

l3=new JLabel("Trainer Name");
l3.setForeground(c2);
l3.setBounds(100,50,200,20);
l3.setFont(f3);
p2.add(l3);


t2=new JTextField(20);
t2.setBounds(250,50,200,20);
t2.addKeyListener(this);
p2.add(t2);


l7=new JLabel("Qualified in");
l7.setForeground(c2);
l7.setBounds(500,50,200,20);
l7.setFont(f3);
p2.add(l7);

cm1=new JComboBox();
cm1.setBounds(700,50,400,20);
cm1.addItem("--Select--");

cm1.addItem("Medical excercise Specialist");
cm1.addItem("Fitness Assessment");
cm1.addItem("Personal Training");
cm1.addItem("Group Fitness Instructor");
cm1.addItem("Health and Stress Handling Coach");
cm1.addItem("None of these ");
p2.add(cm1);

l8=new JLabel("Experience");
l8.setForeground(c2);
l8.setBounds(500,80,200,20);
l8.setFont(f3);
p2.add(l8);



t5=new JTextField(20);
t5.setBounds(700,80,200,20);
p2.add(t5);

l10=new JLabel("[in yrs]");
l10.setForeground(c2);
l10.setBounds(950,80,200,20);
l10.setFont(f3);
p2.add(l10);


l4=new JLabel("Trainer Shift");
l4.setForeground(c2);
l4.setBounds(100,80,200,20);
l4.setFont(f3);
p2.add(l4);

t3=new JTextField(20);
t3.setBounds(250,80,200,20);
p2.add(t3);



l5=new JLabel("Skills & Certification");
l5.setForeground(c2);
l5.setBounds(100,110,200,20);
l5.setFont(f3);
p2.add(l5);


cm2=new JComboBox();
cm2.setBounds(250,110,400,20);
cm2.addItem("--Select--");
cm2.addItem("Fitness /Exercise therapy Certification");
cm2.addItem("Strength and Conditions Certification");
cm2.addItem("Youth Fitness Certification");
cm2.addItem("Hands on CDR and AED(Automic External Defibrillators)Certification");
cm2.addItem("None of these ");
p2.add(cm2); 


JLabel l11=new JLabel("Employee Id");
l11.setForeground(c2);
l11.setBounds(700,110,200,20);
l11.setFont(f3);
p2.add(l11);

cm3=new JComboBox();
cm3.addItem("--Select--");

cm3.setBounds(900,110,100,20);
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

l9=new JLabel("Email-ID ");
l9.setForeground(c2);
l9.setBounds(100,140,200,20);
l9.setFont(f3);
p2.add(l9);

t4=new JTextField(20);
t4.setBounds(250,140,500,20);
p2.add(t4);

b1=new JButton("Submit");
b1.setBounds(250,250,150,25);
b1.addActionListener(this);
p2.add(b1);


b2=new JButton("New Trainer");
b2.setBounds(450,250,150,25);
b2.addActionListener(this);
p2.add(b2);

b3=new JButton("Home");
b3.setBounds(650,250,150,25);
b3.addActionListener(this);
p2.add(b3);


b4=new JButton("Search");
b4.setBounds(850,250,150,25);
b4.addActionListener(this);
p2.add(b4);

b5=new JButton("Set Routine");
b5.setBounds(1050,250,150,25);
b5.addActionListener(this);
p2.add(b5);


try
			{int mid=0;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Trainer_Id) from Trainer_Table";
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
		String s2=String.valueOf(cm1.getSelectedItem());
        	String s7=String.valueOf(cm2.getSelectedItem());
		String s3=t3.getText();
		
		
		String s6=t5.getText();
		
		String s8=t1.getText();
	

		//cnt++;
		if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s6.equals("")||s7.equals("")||s8.equals(""))
		{
		//flag=0;
	JOptionPane.showMessageDialog(null,"Some Fields Are Empty","NewUser",JOptionPane.INFORMATION_MESSAGE);
		 
		
		}
	else
	{

		
	int eid=Integer.parseInt((String)cm3.getSelectedItem());
	//String ttid=t1.getText();	
	int tid=Integer.parseInt(t1.getText());
	String tname=t2.getText();
	String tshift=t3.getText();
	String temail=t4.getText();
	String tskills=(String)cm2.getSelectedItem();
	String tquali=(String)cm1.getSelectedItem();
	String texpp=t5.getText();
	int texp=Integer.parseInt(texpp);
	
	
	String tgender="";
	if(r1.isSelected()==true)
	tgender="Male";
	else
	tgender="Female";





	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:Fitness_Center");
		System.out.println("Connection Established");
		stmt=con.createStatement();
	
		
		String sql="insert into Trainer_Table values ("+ tid + ",'" + tname + "','" + tshift + "','" +tskills +"','" + temail+ "','" +tgender+"','"+tquali+"'," + texp +","+eid+")";
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
			String sql="select max(Trainer_Id) from Trainer_Table";
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


	if(ae.getSource()==b4)
		{
		TrainerFetch ob=new TrainerFetch();
		}
	if(ae.getSource()==b5)
		{
		Routine ob=new Routine();
		}
		if(ae.getSource()==b3)
		{
		FitnessMDI ob=new FitnessMDI();
		}


}
public void keyTyped(KeyEvent e){
}
public void keyPressed(KeyEvent e){


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
new Trainer();
}
}