import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Enquiry extends JFrame implements ActionListener,KeyListener
{
Color c1=new Color(9,51,4);
Color c2=new Color(86,181,17);
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l12,l9,l10,l14,l13,l15;
JTextField t1,t2,t3,t4,t6;
JTextArea t5,t10;
JButton b1,b2,b3;
ImageIcon img1,img2,img3,img4,img5,img6,img7;
JPanel p1,p2;
JRadioButton r1,r2;
JComboBox cm1;
Container c;
Connection con;
Statement stmt;
ResultSet rs;
Font f1=new Font("Arial Rounded MT",Font.BOLD,16);
Font f2=new Font("Old English Text MT",Font.BOLD,15);
Font f3=new Font("Cambria",Font.BOLD,15);
Font f4=new Font("Cambria",Font.BOLD,25);
Font f5=new Font("Century Schoolbook",Font.BOLD,50);
Font f6=new Font("Fixedsys",Font.BOLD,50);
Font f7=new Font("Colonna MT",Font.BOLD,50);
public Enquiry()
{
         setSize(300,300);
	 setLayout(null);
	 setVisible(true);
	show();
	c=getContentPane();
	c.setBackground(c2);

p1=new JPanel();
p1.setLayout(null);
p1.setBounds(10,10,1500,200);
l1=new JLabel("Member Enquiry Form");
p1.setBackground(c1);
l1.setForeground(c2);
l1.setFont(f7);

l1.setBounds(450,0,800,200);
p1.add(l1);
add(p1);


	/*img1=new ImageIcon("images/MAIN.png");
	l15=new JLabel(img1);
	l15.setBounds(40,10,500,190);
	p1.add(l15);*/

//second panel
p2=new JPanel();
p2.setBounds(10,250,1500,400);
add(p2);
p2.setBackground(c1);
p2.setLayout(null);
//img1=new ImageIcon("D:/suru Ty/project6/Fitness Center/5.gif");
l2=new JLabel("Enquiry Id");
l2.setForeground(c2);
l2.setBounds(100,20,200,20);
l2.setFont(f3);
p2.add(l2);

t1=new JTextField(20);
t1.setBounds(250,20,200,20);
t1.setFont(f3);
p2.add(t1);

l3=new JLabel("Name");
l3.setForeground(c2);
l3.setBounds(100,50,200,20);
l3.setFont(f3);
p2.add(l3);

t2=new JTextField(20);
t2.addKeyListener(this);
t2.setBounds(250,50,200,20);
t2.setFont(f3);
p2.add(t2);

l4=new JLabel("Contact");
l4.setForeground(c2);
l4.setBounds(100,80,200,20);
l4.setFont(f3);
p2.add(l4);

t3=new JTextField(20);
t3.setBounds(250,80,200,20);
t3.setFont(f3);
t3.addKeyListener(this);
p2.add(t3);

l5=new JLabel("Email ID");
l5.setForeground(c2);
l5.setBounds(100,110,200,20);
l5.setFont(f3);
p2.add(l5);

t4=new JTextField(20);
t4.setBounds(250,110,500,20);
t4.setFont(f3);
p2.add(t4);


l6=new JLabel("Gender");
l6.setForeground(c2);
l6.setBounds(100,140,200,20);
l6.setFont(f3);
p2.add(l6);

r1 = new JRadioButton("Male");
r2 = new JRadioButton("Female");
r1.setBounds(250,140,100,20);
r2.setBounds(400,140,100,20);
p2.add(r1);
p2.add(r2);

l7=new JLabel("Enquiry About");
l7.setForeground(c2);
l7.setBounds(100,170,200,20);
l7.setFont(f3);
p2.add(l7);

cm1=new JComboBox();
cm1.addItem("--Select--");
cm1.setBounds(250,170,250,20);
cm1.addItem("Fitness batches");
cm1.addItem("Personal batches");
cm1.addItem("Dance batches");

p2.add(cm1); 

l8=new JLabel("Requirements");
l8.setForeground(c2);
l8.setBounds(100,200,200,20);
l8.setFont(f3);
p2.add(l8);

t5=new JTextArea();
t5.setBounds(250,200,500,100);
t5.setFont(f3);
p2.add(t5);

l14=new JLabel("Address");
l14.setForeground(c2);
l14.setBounds(800,200,200,20);
l14.setFont(f3);
p2.add(l14);

t10=new JTextArea();
t10.setBounds(900,200,400,100);
t10.setFont(f3);
p2.add(t10);


l13=new JLabel("Reference From");
l13.setForeground(c2);
l13.setBounds(100,320,200,20);
l13.setFont(f3);
p2.add(l13);

t6=new JTextField(20);
t6.setBounds(250,320,500,20);
t6.setFont(f3);
p2.add(t6);

b1=new JButton("Submit");
b1.setBounds(250,350,150,25);
b1.addActionListener(this);
b1.setFont(f3);
p2.add(b1);

b2=new JButton("New Enquiry");
b2.setBounds(430,350,170,25);
b2.addActionListener(this);
b2.setFont(f3);
p2.add(b2);

b3=new JButton("Home");
b3.setBounds(650,350,150,25);
b3.addActionListener(this);
b3.setFont(f3);
p2.add(b3);

try
			{int mid=0;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Enquiry_Id) from Enquiry_Table";
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
int eid;
	String ename,eaddr,eemail,eabt,ereq,eref,egender;
	if(ae.getSource()==b1)
	{ 
	int flag=1;
		String s3=t3.getText();
		String s4=t4.getText();
		if(s3.length()>10)
		{
				JOptionPane.showMessageDialog(null,"Length of phone no. is very large ","NewUser",JOptionPane.INFORMATION_MESSAGE);
				t3.setText("");
				flag=0;
		}
		int l=s4.indexOf("@");

		if(l==-1)
		{
				JOptionPane.showMessageDialog(null,"Email address should have @ ","NewUser",JOptionPane.INFORMATION_MESSAGE);
				t4.setText("");
				flag=0;
		}

		if(flag==1)
		{
		

		String s1=t2.getText();
		String s2=String.valueOf(cm1.getSelectedItem());
        	
		String s5=t4.getText();
		
		String s6=t5.getText();
		String s7=t6.getText();
		String s8=t1.getText();
	

		//cnt++;
		if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")||s7.equals("")||s8.equals(""))
		{
		flag=0;
	JOptionPane.showMessageDialog(null,"Some Fields Are Empty","NewUser",JOptionPane.INFORMATION_MESSAGE);
		 
		
		}
else
{

	
	String mmid=t1.getText();	
	eid=Integer.parseInt(mmid);
	ename=t2.getText();
	eaddr=t3.getText();
	eemail=t4.getText();
	eabt=(String)cm1.getSelectedItem();

	
	String eadd=t10.getText();
	ereq=t5.getText();
	eref=t6.getText();
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
		String sql="insert into Enquiry_Table values ("+ eid + ",'" + ename + "','" +eaddr +"','" + eemail+ "','" +egender+"','"+eabt+"','" + ereq +"','"+ eref + "','" + eadd +"')";
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
}
}
	
	if(ae.getSource()==b2)
		{int eeid=0;
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Enquiry_Id) from Enquiry_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			
			eeid=Integer.parseInt(rs.getString(1));
			}
			eeid++;
			t1.setText(String.valueOf(eeid));

			
			
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
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
if(e.getSource()==t3)
	{
	char ch=e.getKeyChar();
	if(ch>=65)
		{
		JOptionPane.showMessageDialog(null,"Characters are not allowed","NewUser",JOptionPane.INFORMATION_MESSAGE);
		t3.setText("");
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
new Enquiry();
}


}




























