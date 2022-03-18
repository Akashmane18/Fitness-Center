import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FeeReceipt extends JFrame implements ActionListener,KeyListener
{
Color c2=new Color(35,18,7);
Color c1=new Color(137,72,29);
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
JButton b1,b2,b3,b4;
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
public FeeReceipt(int feesid,String mname,int memid,int total)
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
l1=new JLabel("         Member Fee Receipt Details");
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

l2=new JLabel("Receipt ID");
l2.setForeground(c2);
l2.setBounds(10,20,200,20);
l2.setFont(f3);
p2.add(l2);

t1=new JTextField(20);
t1.setBounds(110,20,200,20);
t1.setFont(f3);
p2.add(t1);



l6=new JLabel("Member Id");
l6.setForeground(c2);
l6.setBounds(10,50,200,20);
l6.setFont(f3);
p2.add(l6);

t3=new JTextField(20);
t3.setBounds(110,50,200,20);
t3.setText(String.valueOf(memid));
t3.setFont(f3);
p2.add(t3);


l5=new JLabel("Fees ID");
l5.setForeground(c2);
l5.setBounds(330,20,200,20);
l5.setFont(f3);
p2.add(l5);

t8=new JTextField(20);
t8.setBounds(440,20,200,20);
t8.setText(String.valueOf(feesid));
t8.setfont(f3);
p2.add(t8);

cm1=new JComboBox();
cm1.setBounds(440,20,200,20);

try
    		{
   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   		 System.out.println("Connection Done\n"); 
    		con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    		System.out.println("Driver Loaded\n"); 
   		stmt=con.createStatement();
  		String	 str="select * from Fees_Table";
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
l3.setBounds(330,50,200,20);
l3.setFont(f3);
p2.add(l3);

t2=new JTextField(20);
t2.setBounds(440,50,200,20);
t2.setText(String.valueOf(mname));
t2.setFont(f3);
p2.add(t2);


//Batch panel
JPanel p4=new JPanel();
p4.setBounds(10,100,600,360);
add(p4);
p4.setBackground(c2);
p4.setLayout(null);
p2.add(p4);

l4=new JLabel("Receipt Date");
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


l7=new JLabel("Total Fees");
l7.setForeground(c1);
l7.setBounds(100,80,450,20);
l7.setFont(f3);
p4.add(l7);

t4=new JTextField(20);
t4.setBounds(300,80,200,20);
t4.setText(String.valueOf(total));
t4.setFont(f3);
p4.add(t4);


l8=new JLabel("Any Deductions(discount)");
l8.setForeground(c1);
l8.setBounds(100,110,450,20);
l8.setFont(f3);
p4.add(l8);

t5=new JTextField(20);
t5.setBounds(300,110,200,20);
t5.addKeyListener(this);
t5.setFont(f3);
p4.add(t5);


l9=new JLabel("Total Receipt");
l9.setForeground(c1);
l9.setBounds(100,140,450,20);
l9.setFont(f3);
p4.add(l9);

t6=new JTextField(20);
t6.setBounds(300,140,200,20);
t6.setFont(f3);
p4.add(t6);

b1=new JButton("Submit");
b1.setBounds(100,270,150,25);
b1.addActionListener(this);
b1.setFont(f3);
p4.add(b1);

b2=new JButton("Reset");
b2.setBounds(100,300,150,25);
b2.addActionListener(this);
b2.setFont(f3);
p4.add(b2);

b3=new JButton("Home");
b3.setBounds(300,270,150,25);
b3.addActionListener(this);
b3.setFont(f3);
p4.add(b3);

b4=new JButton("Search");
b4.setBounds(300,300,150,25);
b4.addActionListener(this);
b4.setFont(f3);
p4.add(b4);
/*try
			{int mid=0;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Receipt_Id) from Receipt_Table";
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
			




}*/
int ttid=0;
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Connection Done");
			con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
			System.out.println("Driver Loaded");
			stmt=con.createStatement();
			String sql="select max(Fees_Id) from Fees_Table";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			
			ttid=Integer.parseInt(rs.getString(1));
			}
			ttid++;
			t1.setText(String.valueOf(ttid));
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

public void actionPerformed(ActionEvent ae)
{
	
	if(ae.getSource()==b1)
	{ 
		

	int flag=1;
		String s1=t5.getText();
		
		String s2=t2.getText();
		
		String s3=t4.getText();
		
		String s5=t3.getText();
		
	

		//cnt++;
		if(s1.equals("")||s2.equals("")||s3.equals("")||s5.equals(""))
		{
		flag=0;
	JOptionPane.showMessageDialog(null,"Some Fields Are Empty","NewUser",JOptionPane.INFORMATION_MESSAGE);
		 
		
		}
		
	Integer.parseInt(t4.getText()
	if((n)-(Integer.parseInt(t4.getText()))<0))
	{
	t6.setText(String.valueOf(totalreceipt));
	}
	else
	{
	JOptionPane.showMessageDialog(null,"Enter Deductions less than total fees","NewUser",JOptionPane.INFORMATION_MESSAGE);
	flag=0;
	}
	if(flag==1)
		{
		int s4=Integer.parseInt(t5.getText());
		if((s4<10)||(s4>10000000))
		{
				JOptionPane.showMessageDialog(null,"Deductions cannot be negative or excessive","NewUser",JOptionPane.INFORMATION_MESSAGE);
				t5.setText("");
				//flag=0;
		}

		else
		{




	
	int rid=Integer.parseInt(t1.getText());
	int fid=Integer.parseInt(t8.getText());
	int mid=Integer.parseInt(t3.getText());
	String mname=t2.getText();
	String rday=(String)cm3.getSelectedItem();
	String rmonth=(String)cm4.getSelectedItem();
	String ryr=(String)cm5.getSelectedItem();
	
	String rdate=rday+"-"+rmonth+"-"+ryr;
	
	
	int total=Integer.parseInt(t4.getText());
	int ded=Integer.parseInt(t5.getText());
	int totalreceipt=total-ded;
	t6.setText(String.valueOf(totalreceipt));
	
	

	
	

	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:Fitness_Center");
		System.out.println("Connection Established");
		stmt=con.createStatement();
	
		
		String sql="insert into Receipt_Table values ("+ rid + "," +fid +"," + mid + ",'" + mname + "','" +rdate +"'," + total + "," +ded+ "," +totalreceipt+ ")";
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
			String sql="select max(Receipt_Id) from Receipt_Table";
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
		ReceiptFetch ob=new ReceiptFetch();
		}


}

public void itemStateChanged(ItemEvent ae)
{
 
   
   int fid=Integer.parseInt((String)ae.getItem());
	
    try
    {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    System.out.println("Connection Done\n"); 
    con=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    System.out.println("Driver Loaded\n"); 
   stmt=con.createStatement();
  String str="select * from Fees_Table where Fees_Id="+fid+"";
     rs=stmt.executeQuery(str);
	System.out.println(fid);

while(rs.next())
{
	
	
    	t3.setText(rs.getString(4));
   	t2.setText(rs.getString(3));
   	t4.setText(rs.getString(8));
   	
   
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
		JOptionPane.showMessageDialog(null,"Only Numerical value","Salary",JOptionPane.INFORMATION_MESSAGE);
		t5.setText("");
		}
	}
}
public void keyReleased(KeyEvent e){
}

public static void main(String a[])
{
new FeeReceipt();
}
}



