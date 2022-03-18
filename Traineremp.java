import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Traineremp extends JFrame implements ActionListener
{ 
Color c2=new Color(44,27,36);
Color c1=new Color(117,70,96);
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l10,l9;
JTextField t1,t2,t3,t4,t5,t6;
JButton b1,b2,b3;
ImageIcon img1;
JPanel p1,p2;
JRadioButton r1,r2;
JComboBox cm1,cm2,cm3;
int tid;
Container c;
Font f1=new Font("Old English Text MT",Font.BOLD,50);
Font f2=new Font("Old English Text MT",Font.BOLD,15);
Font f3=new Font("Times New Roman",Font.BOLD,15);
Font f7=new Font("Colonna MT",Font.BOLD,50);
Connection con;
Statement stmt;
ResultSet rs;

public Traineremp()
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
p2.add(t2);


l7=new JLabel("Qualified in");
l7.setForeground(c2);
l7.setBounds(500,50,200,20);
l7.setFont(f3);
p2.add(l7);

cm1=new JComboBox();
cm1.setBounds(700,50,100,20);
cm1.addItem("Yoga");
cm1.addItem("Meditation");
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
cm2.setBounds(250,110,200,20);
cm2.addItem("routine_management");
p2.add(cm2); 


JLabel l11=new JLabel("Employee Id");
l11.setForeground(c2);
l11.setBounds(500,110,200,20);
l11.setFont(f3);
p2.add(l11);

cm3=new JComboBox();
cm3.setBounds(700,110,100,20);
//cm3.addItem(230);
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


b2=new JButton("Reset");
b2.setBounds(450,250,150,25);
b2.addActionListener(this);
p2.add(b2);

b3=new JButton("Home");
b3.setBounds(650,250,150,25);
b3.addActionListener(this);
p2.add(b3);


	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:Fitness_Center");
		System.out.println("Connection Established");
		stmt=con.createStatement();
		String sql="Select * from Employee_Table";
        	rs=stmt.executeQuery(sql);
		while(rs.next())
		{
		cm3.addItem(rs.getString(1));
			
		}con.close();
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



public void actionPerformed(ActionEvent ae)
{
	
	if(ae.getSource()==b1)
	{ 
	System.out.println(123);	
	int eid=(Integer)cm3.getSelectedItem();
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
	/*System.out.println(tid);
	System.out.println(tname);
	System.out.println(tshift);
	System.out.println(temail);
	System.out.println(tskills);
	System.out.println(texp);
	System.out.println(tquali);
	System.out.println(tgender);
	System.out.println(eid);
	*/




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
	if(ae.getSource()==b2)
	{ 
	t1.setText("");
	t2.setText("");
	t3.setText("");
	t4.setText("");
	t5.setText("");
	t6.setText("");
	}

}
public static void main(String a[])
{
new Traineremp();
}
}