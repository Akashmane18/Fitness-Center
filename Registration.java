import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Registration extends JFrame implements ActionListener,KeyListener
{
ButtonGroup bg;
Color c1=new Color(43,0,0);
Color c2=new Color(185,122,87);
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l14;
JTextField t1,t2,t3,t4,t5;
JButton b1,b2,b3,b4,b5;
ImageIcon img1,img2;
JPanel p1,p2,p3;
JRadioButton r1,r2;
JComboBox cm1,cm2;
JTextArea t6,t10;
Container c;
Font f1=new Font("Old English Text MT",Font.BOLD,50);
Font f2=new Font("Old English Text MT",Font.BOLD,15);
Font f3=new Font("Cambria",Font.BOLD,15);
Font f7=new Font("Colonna MT",Font.BOLD,50);
Connection con;
Statement stmt;
ResultSet rs;

public Registration()
{
	 ImageIcon img2=new ImageIcon("tk1.jpg");
         setSize(1300,700);
         setLayout(null);
         setVisible(true);
         show();
        
         c=getContentPane();
	c.setBackground(c2);
        
        //JLabel l12=new JLabel(img2);
        //l12.setBounds(0,0,1400,800);
        
          

//img1=new ImageIcon("D:/suru Ty/project6/Fitness Center/index3.jpg");
//JLabel IL=new JLabel(img1);
//IL.setBounds(0,300,2500,300);



p1=new JPanel();
p1.setLayout(null);
p1.setBounds(10,10,1500,200);
l1=new JLabel("            Member Registration");
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

//img1=new ImageIcon("D:/suru Ty/project6/Fitness Center/index1.jpg");
//JLabel li=new JLabel(img1);
//li.setBounds(10,10,1000,200);
//p2.add(li);

l2=new JLabel("Member Id");
l2.setForeground(c2);
l2.setBounds(100,20,200,20);
l2.setFont(f3);
p2.add(l2);

t1=new JTextField(20);
t1.setBounds(250,20,200,20);
p2.add(t1);



l11=new JLabel("Employee Id");
l11.setForeground(c2);
l11.setBounds(500,20,200,20);
l11.setFont(f3);
p2.add(l11);

cm2=new JComboBox();
cm2.setBounds(600,20,100,20);
cm2.addItem("--Select--");
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
		
		cm2.addItem(rs.getString(1));
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
  
p2.add(cm2);





l3=new JLabel("Member Name");
l3.setForeground(c2);
l3.setBounds(100,50,200,20);
l3.setFont(f3);
p2.add(l3);

t2=new JTextField(20);
t2.setBounds(250,50,200,20);
t2.addKeyListener(this);
p2.add(t2);

l14=new JLabel("Address");
l14.setForeground(c2);
l14.setBounds(750,50,200,20);
l14.setFont(f3);
p2.add(l14);

t10=new JTextArea();
t10.setBounds(850,50,400,100);
p2.add(t10);



l4=new JLabel("Member Contact");
l4.setForeground(c2);
l4.setBounds(100,80,200,20);
l4.setFont(f3);
p2.add(l4);

t3=new JTextField(20);
t3.setBounds(250,80,200,20);
t3.addKeyListener(this);
p2.add(t3);

l5=new JLabel("Member Email ID");
l5.setForeground(c2);
l5.setBounds(100,110,200,20);
l5.setFont(f3);
p2.add(l5);

t4=new JTextField(20);
t4.setBounds(250,110,500,20);
p2.add(t4);


l6=new JLabel("Gender");
l6.setForeground(c2);
l6.setBounds(100,140,200,20);
l6.setFont(f3);
p2.add(l6);
bg=new ButtonGroup();
r1 = new JRadioButton("Male");
r2 = new JRadioButton("Female");
r1.setBounds(250,140,100,20);
r2.setBounds(400,140,100,20);
p2.add(r1);
p2.add(r2);
bg.add(r1);
bg.add(r2);


l7=new JLabel("Type");
l7.setForeground(c2);
l7.setBounds(100,170,200,20);
l7.setFont(f3);
p2.add(l7);

cm1=new JComboBox();
cm1.setBounds(250,170,300,20);
cm1.addItem("--Select--");
cm1.addItem("Fitness Assessment with Diet");
cm1.addItem("Personal training with Diet");
cm1.addItem("Toning and strength");
cm1.addItem("Zumba or Aerobics");
p2.add(cm1);


l8=new JLabel("Member Age");
l8.setForeground(c2);
l8.setBounds(100,210,200,20);
l8.setFont(f3);
p2.add(l8);

l10=new JLabel("[in years]");
l10.setForeground(c2);
l10.setBounds(470,210,200,20);
l10.setFont(f3);
p2.add(l10);

t5=new JTextField(20);
t5.setBounds(250,210,200,20);
p2.add(t5);


l9=new JLabel("Description(Problems)");
l9.setForeground(c2);
l9.setBounds(100,240,200,20);
l9.setFont(f3);
p2.add(l9);

t6=new JTextArea();
t6.setBounds(250,240,500,90);
p2.add(t6);



b1=new JButton("Submit");
b1.setBounds(250,350,150,25);
b1.addActionListener(this);
p2.add(b1);

b2=new JButton("New Registration");
b2.setBounds(450,350,150,25);
p2.add(b2);
b2.addActionListener(this);

b3=new JButton("Home");
b3.setBounds(650,350,150,25);
p2.add(b3);
b3.addActionListener(this);

b4=new JButton("Search");
b4.setBounds(850,350,150,25);
p2.add(b4);
b4.addActionListener(this);

b5=new JButton("Set Profile");
b5.setBounds(1050,350,150,25);
p2.add(b5);
b5.addActionListener(this);
try
			{int mid=0;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(M_ID) from Registration_Table";
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
			


//add(l12);
}

public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b1)
	{ 

	int flag=1;
	String s3=t3.getText();
	String s4=t4.getText();
		if(s3.length()>10)
		{
				JOptionPane.showMessageDialog(null,"Contact number should be 10 or less ","Registration",JOptionPane.INFORMATION_MESSAGE);
				t3.setText("");
				flag=0;
		}
		int l=s4.indexOf("@");

		if(l==-1)
		{
				JOptionPane.showMessageDialog(null,"Email address should have @ ","Registration",JOptionPane.INFORMATION_MESSAGE);
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
		
		JOptionPane.showMessageDialog(null,"Some Fields Are Empty","NewUser",JOptionPane.INFORMATION_MESSAGE);
		 
		
		}
	else
	{


	int eid=Integer.parseInt((String)cm2.getSelectedItem());
	
		
	int mid=Integer.parseInt(t1.getText());
	String mname=t2.getText();
	String mcont=t3.getText();
	String memail=t4.getText();
	String mtype=(String)cm1.getSelectedItem();
	String eadd=t3.getText();
	
	int mage=Integer.parseInt(t5.getText());
	String mdesc=t6.getText();
	String mgender="";
	if(r1.isSelected()==true)
	mgender="Male";
	else
	mgender="Female";
	





	
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:Fitness_Center");
		System.out.println("Connection Established");
		stmt=con.createStatement();
		String sql="insert into Registration_Table values ("+ eid + "," + mid + ",'" + mname + "','" +mcont +"','" + memail+ "','" +mgender+"','" + mtype + "'," + mage +",'" + mdesc + "','" + eadd + "')";
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
		{int mid=0;
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(M_ID) from Registration_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			mid=Integer.parseInt(rs.getString(1));
			}
			mid++;
			t1.setText(String.valueOf(mid));

			
			
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			}
			catch(ClassNotFoundException e){System.out.println("Driver Error..."+e);}
			catch(SQLException e){System.out.println("SQL Error"+e);} 			
	 	}	
	if(ae.getSource()==b4)
		{
		RegistrationFetch ob=new RegistrationFetch();
		}
		if(ae.getSource()==b5)
		{
		Profile ob=new Profile();
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
new Registration();
}}




























