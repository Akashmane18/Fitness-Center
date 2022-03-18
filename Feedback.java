import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Feedback extends JFrame implements ActionListener,ItemListener
{
Color c2=new Color(38,6,38);
Color c1=new Color(166,28,166);
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
JTextField t1,t2,t5,t6,t7,t8,t9,t10,t11,t12,t13;
JTextArea t4,t3,t14,t15;
JButton b1,b2,b3,b4;
ImageIcon img1;
JPanel p1,p2;
JRadioButton r1,r2,r3,r4;
JComboBox cm1,cm2,cm3;
Container c;
Connection con;
Statement stmt;
ResultSet rs;

Font f1=new Font("Old English Text MT",Font.BOLD,45);
Font f2=new Font("Old English Text MT",Font.BOLD,15);
Font f3=new Font("Cambria",Font.BOLD,15);
Font f7=new Font("Colonna MT",Font.BOLD,50);
public Feedback()
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
l1=new JLabel("Member Complaint Feedback Details");
p1.setBackground(c1);
l1.setForeground(c2);
l1.setFont(f7);

l1.setBounds(300,0,900,200);
p1.add(l1);
add(p1);

//solution panel
p2=new JPanel();
p2.setBounds(10,250,650,400);
add(p2);
p2.setBackground(c1);
p2.setLayout(null);



l12=new JLabel("Feedback ID");
l12.setForeground(c2);
l12.setBounds(10,20,200,20);
l12.setFont(f3);
p2.add(l12);

t6=new JTextField();
t6.setBounds(110,20,200,20);
t6.setFont(f3);
p2.add(t6);

l2=new JLabel("Member Name");
l2.setForeground(c2);
l2.setBounds(330,20,200,20);
l2.setFont(f3);
p2.add(l2);

t1=new JTextField(20);
t1.setBounds(440,20,200,20);
t1.setFont(f3);
p2.add(t1);



l3=new JLabel("Member Id");
l3.setForeground(c2);
l3.setBounds(330,50,200,20);
l3.setFont(f3);
p2.add(l3);

t2=new JTextField(20);
t2.setBounds(440,50,200,20);
t2.setFont(f3);
p2.add(t2);


//profile panel
JPanel p4=new JPanel();
p4.setBounds(10,100,600,290);
add(p4);
p4.setBackground(c2);
p4.setLayout(null);
p2.add(p4);

l4=new JLabel("Complaint Id");
l4.setForeground(c1);
l4.setBounds(100,20,200,20);
l4.setFont(f3);
p4.add(l4);

cm2=new JComboBox();
cm2.setBounds(300,20,200,20);

try
    		{
   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   		 System.out.println("Connection Done\n"); 
    		con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    		System.out.println("Driver Loaded\n"); 
   		stmt=con.createStatement();
  		String	 str="select * from Complaint_Table";
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
  
p4.add(cm2);
cm2.addItemListener(this);



l5=new JLabel("Requirements:");
l5.setForeground(c1);
l5.setBounds(100,50,450,20);
l5.setFont(f3);
p4.add(l5);

t3=new JTextArea();
t3.setBounds(100,70,450,40);
t3.setFont(f3);
p4.add(t3);


l6=new JLabel("Solution Description:");
l6.setForeground(c1);
l6.setBounds(100,120,450,20);
l6.setFont(f3);
p4.add(l6);

t4=new JTextArea();
t4.setBounds(100,150,450,40);
t4.setFont(f3);
p4.add(t4);

//time panel
JPanel p3=new JPanel();
p3.setBounds(700,250,650,400);
add(p3);
p3.setBackground(c1);
p3.setLayout(null);


l10=new JLabel("Time Constraint");
l10.setForeground(c2);
l10.setBounds(100,20,200,20);
l10.setFont(f3);
p3.add(l10);

t5=new JTextField(20);
t5.setBounds(250,20,200,20);
t5.setFont(f3);
p3.add(t5);

l10=new JLabel("Complaint Status");
l10.setForeground(c2);
l10.setBounds(100,50,200,20);
l10.setFont(f3);
p3.add(l10);


r1 = new JRadioButton("Feasible");
r2 = new JRadioButton("Non-Feasible");
r1.setBounds(250,50,100,20);
r2.setBounds(400,50,100,20);
p3.add(r1);
p3.add(r2);

l11=new JLabel("If Non-Feasible(Mention the reason below):");
l11.setForeground(c2);
l11.setBounds(100,80,450,20);
l11.setFont(f3);
p3.add(l11);

t15=new JTextArea();
t15.setBounds(100,110,450,60);
t15.setFont(f3);
p3.add(t15);


l16=new JLabel("If Feasible(mention the actions that will be taken below:)");
l16.setForeground(c2);
l16.setBounds(100,180,450,20);
l16.setFont(f3);
p3.add(l16);


t14=new JTextArea();
t14.setBounds(100,210,450,60);
t14.setFont(f3);
p3.add(t14);













b1=new JButton("Submit");
b1.setBounds(100,210,150,25);
b1.addActionListener(this);
b1.setFont(f3);
p4.add(b1);

b2=new JButton("New Feedback");
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
			String sql="select max(Feedback_Id) from Feedback_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			mid=Integer.parseInt(rs.getString(1));
			}
			
			t6.setText(String.valueOf(mid));
			t6.setEditable(false);
			
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
		String s2=String.valueOf(cm2.getSelectedItem());
        	
		String s3=t3.getText();
		
		String s4=t4.getText();
		String s5=t5.getText();
		String s6=t1.getText();
		String s7=t6.getText();
		String s10=t15.getText();
		//String s11=t17.getText();

		//cnt++;
		if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")||s7.equals(""))
		{
		//flag=0;
	JOptionPane.showMessageDialog(null,"Some Fields Are Empty","NewUser",JOptionPane.INFORMATION_MESSAGE);
		 
		
		}
else
{

	int cid=Integer.parseInt((String)cm2.getSelectedItem());
	int fid=Integer.parseInt(t6.getText());	
	int mid=Integer.parseInt(t2.getText());
	String mname=t1.getText();
	String creq=t3.getText();
	String csol=t4.getText();
	String ctime=t5.getText();
	
	String creason=t15.getText();
	String caction=t14.getText();
	
	
	
	String cstatus="";
	if(r1.isSelected()==true)
	cstatus="Feasible";
	else
	cstatus="Non-Feasible";

	




	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:Fitness_Center");
		System.out.println("Connection Established");
		stmt=con.createStatement();
	
		
		String sql="insert into Feedback_Table values ("+ fid + ",'" + mname + "'," + mid + "," +cid +",'" + creq+ "','" + csol +"','"+ctime+"','" + cstatus +"','" + creason + "','" + caction + "')";
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
if(ae.getSource()==b2)
		{int ttid=0;
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Feedback_Id) from Feedback_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			
			ttid=Integer.parseInt(rs.getString(1));
			}
			ttid++;
			t6.setText(String.valueOf(ttid));

			
			
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



		if(ae.getSource()==b4)
		{
		FeedbackFetch ob=new FeedbackFetch();
		}



}

public void itemStateChanged(ItemEvent ae)
{
 
   
   int cid=Integer.parseInt((String)ae.getItem());
	
    try
    {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    System.out.println("Connection Done\n"); 
    con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    System.out.println("Driver Loaded\n"); 
   stmt=con.createStatement();
  String str="select * from Complaint_Table where Complaint_Id="+cid+"";
     rs=stmt.executeQuery(str);
	System.out.println(cid);

while(rs.next())
{
	
	
    	t1.setText(rs.getString(2));
   	t2.setText(rs.getString(3));
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
new Feedback();
}}



