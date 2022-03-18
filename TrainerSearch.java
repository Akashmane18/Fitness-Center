import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class TrainerSearch extends JFrame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6,l7;
JButton b1,b2,b3;
JTextField t1;
JComboBox cm1;
JPanel p1,p2,p3;
Container c;
Connection con;
Statement stmt;
ResultSet rs;
JScrollPane JSP;
Font f1=new Font("Arial",Font.BOLD,45);
Font f2=new Font("Times New Roman",Font.BOLD,20);
Font f7=new Font("Colonna MT",Font.BOLD,50);

public TrainerSearch()
{
c=getContentPane();
setSize(1500,1500);
c.setLayout(null);
show();
c.setVisible(true);
Color c1=new Color(31,149,239);
Color c2=new Color(165,210,248);
Color c3=new Color(12,91,156);
c.setBackground(c1);
p1=new JPanel();
p1.setBounds(15,25,1200,50);
p1.setBackground(c3);
p1.setForeground(Color.white);
l1=new JLabel("Trainer Details are:");
l1.setFont(f7);
p1.setLayout(new FlowLayout());
p1.add(l1);
c.add(p1);

p2=new JPanel();
p2.setBounds(50,100,1200,600);
p2.setBackground(c3);
c.add(p2);
p2.setLayout(null);
l2=new JLabel("Date");
java.util.Date d=new java.util.Date();
l2.setForeground(Color.white);
l2.setBounds(400,20,150,50);
l2.setFont(f2);
t1=new JTextField(String.valueOf(d));
t1.setBounds(600,20,100,30);
p2.add(t1);
p2.add(l2);

l3=new JLabel("All Trainer details are:");
l3.setForeground(Color.white);
l3.setBounds(400,50,200,50);
l3.setFont(f2);
cm1=new JComboBox();
cm1.setBounds(600,80,100,30);
p2.add(cm1);
p2.add(l3);

b1=new JButton("Show");
b1.setBackground(Color.white);
b1.setBackground(Color.black);
b1.setFont(f2);

b1.setBounds(500,120,100,40);
p2.add(b1);
b1.addActionListener(this);

b2=new JButton("Hide");
b2.setBackground(Color.white);
b2.setBackground(Color.black);
b2.setFont(f2);

b2.setBounds(800,120,100,40);
p2.add(b2);
b2.addActionListener(this);


	try
	{
	doConnect();
	System.out.println("in before query");
	String sql="select * from Trainer_Table";
	rs=stmt.executeQuery(sql);
	System.out.println("query fired");
	while(rs.next())
	{
	cm1.addItem(rs.getString(1));
	}
	con.close();

	}catch(Exception e)
	{
	System.out.println("Sql Error:"+e);
	}
}

public void doConnect()
{
try
{
System.out.println("Connect method");
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:Fitness_Center");
		System.out.println("Connection Established");
		 stmt=con.createStatement();
}		catch(ClassNotFoundException e)
		{
		
		System.out.println("Driver Error"+e);
		}
		catch(SQLException e)
		{
		
		System.out.println("Query Error"+e.toString());
		}


}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
	try{
	String t=(String)cm1.getSelectedItem();
	int sid=Integer.parseInt(t);
	System.out.println(sid);
	doConnect();
	String sql="select * from Trainer_Table where Trainer_ID="+sid+"";
	rs=stmt.executeQuery(sql);
	final String[] cols={"TID","TNAME","TSHIFT","TSKILLCERTIFICATE"};
	final Object rows[][]=new Object[15][8];
	final String ss[][]=new String[15][8];
	int i=0;
	System.out.println("Result Fetch");
	while(rs.next())
	{
	System.out.println("in loop");
	String s1=rs.getString(1);
	String s2=rs.getString(2);
	String s3=rs.getString(3);
	String s4=rs.getString(4);
	
	rows[i][0]=(Object)s1;
	rows[i][1]=(Object)s2;
	rows[i][2]=(Object)s3;
	rows[i][3]=(Object)s4;
	}
	
	JTable table1=new JTable(rows,cols);
	JSP=new JScrollPane(table1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	Container c=getContentPane();
	c.add(JSP);
	
	JSP.setBounds(500,300,500,250);
	JSP.setBackground(Color.white);
	JSP.setVisible(true);
	con.close();	


	}catch(Exception e){ System.out.println(e);}

}
	if(ae.getSource()==b2)
	{
	hide();
	}

}
	public static void main(String a[])
	{
	new RegistrationSearch();
	}

}