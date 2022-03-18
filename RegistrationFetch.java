import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationFetch extends JFrame implements ItemListener
{
    
     	JLabel l1,l2,l3,l4,l5,l6,l7;
     	JTextField t1,t2,t3,t4,t5;
    	ImageIcon img1;                                                                                                                                                                                                             
     	JPanel p1,p2,p3,p4,p5;
     	JComboBox c1;
	JButton b1,b2; 	
     	Font f1=new Font("Lucida console",Font.BOLD,20);
     	Font f2=new Font("Times New Roman",Font.BOLD,20); 
     	Font f3=new Font("Cambria",Font.BOLD,15);
	ResultSet rs;
  	Container c;
                   Connection cn;
                   Statement s;
	String str="";
	 int mid;
  	String mname,madd,mtype,emid;

	Color col=new Color(251,248,117);

	public RegistrationFetch()
     	{ 
        		img1=new ImageIcon("aaa.jpg");
         		setSize(1380,776);
         		setLayout(null);
         		setVisible(true);
         		show();
	                  c=getContentPane();

         		p1=new JPanel();
         		p1.setLayout(null);
         		p1.setBounds(0,0,1380,776);
			

 	                  l7=new JLabel(img1);
        		l7.setLayout(null);
        		l7.setBounds(0,0,1380,776);
                                                                                                                          
 	
         p5=new JPanel();
         p5.setLayout(null);
       //  p5.setBounds(400,210,490,350);
	  p5.setBounds(10,50,550,350);
           
       p5.setBackground(col);
  
 
        l1=new JLabel("Member ID");
         l1.setForeground(Color.black);
         l1.setFont(f2);
         l1.setBounds(10,40,200,30);
         
c1=new JComboBox();
  c1.setBounds(250,40,150,30);
	//jcombo box 
		 try
    		{
   		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   		 System.out.println("Connection Done\n"); 
    		cn=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    		System.out.println("Driver Loaded\n"); 
   		s=cn.createStatement();
  			 str="select * from Registration_Table";
		rs=s.executeQuery(str);
   		while(rs.next())
		{
		c1.addItem(rs.getString(2));
		}
		cn.close();
		}catch(ClassNotFoundException e)
 		 {
  		 System.out.println(e);	  
  		}
  
  		catch(SQLException e)
  		{
   		System.out.println(e);	  
  		}
         p5.add(l1);
         p5.add(c1);
      c1.addItemListener(this);
         l2=new JLabel("Member Name");
         l2.setForeground(Color.black);
         l2.setFont(f2);
         l2.setBounds(10,80,200,30);
         t2=new JTextField(20);
         t2.setFont(f2);
         t2.setBounds(250,80,150,30);
         p5.add(t2);
         p5.add(l2);
     
   
         l3=new JLabel("Member Contact No");
         l3.setForeground(Color.black);
         l3.setFont(f2);
         l3.setBounds(10,120,200,30);
         t3=new JTextField(20);
         t3.setFont(f2);
         t3.setBounds(250,120,150,30);
         p5.add(t3);
         p5.add(l3);
       

         l4=new JLabel("Member Type");
         l4.setForeground(Color.black);
         l4.setFont(f2);
         l4.setBounds(10,150,200,30);
         t4=new JTextField(20);
         t4.setFont(f2);
         t4.setBounds(250,160,150,30);
         p5.add(t4);
         p5.add(l4);
     
     
  
         l5=new JLabel("Member Email Id:");
         l5.setForeground(Color.black);
         l5.setFont(f2);
         l5.setBounds(10,200,200,30);
         t5=new JTextField(20);
         t5.setFont(f2);
         t5.setBounds(250,200,150,30);
         p5.add(t5);
         p5.add(l5);
         

        b1=new JButton("Save");
        b1.setBounds(90,250,90,30);
        b2=new JButton("Clear");
        b2.setBounds(200,250,90,30);
        //p5.add(b1); 
        //p5.add(b2);
        

          l6=new JLabel("Member Registration");
         l6.setForeground(Color.black);
         l6.setFont(f3);
         //l6.setBounds(400,110,500,50);
       l6.setBounds(10,10,500,50);
       
      	p1.add(l7);
      	add(p1);
      	l7.add(p5);
      	l7.add(l6); 
	//b1.addActionListener(this);
           }
public void itemStateChanged(ItemEvent ae)
{
 
    mid=Integer.parseInt((String)ae.getItem());
    mname=t2.getText();
	 System.out.println(mid);
    try
    {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    System.out.println("Connection Done\n"); 
    cn=DriverManager.getConnection("Jdbc:Odbc:Fitness_Center");
    System.out.println("Driver Loaded\n"); 
   s=cn.createStatement();
   str="select * from Registration_Table where M_Id="+mid+"";
     rs=s.executeQuery(str);

while(rs.next())
{
	
	t2.setText(rs.getString(3));
    	t3.setText(rs.getString(4));
    	t4.setText(rs.getString(7));
    	t5.setText(rs.getString(5));
   
}
 cn.close();
}catch(ClassNotFoundException e)
  {
   System.out.println(e);	  
  }
  
	  catch(SQLException e)
  {
   System.out.println(e);	  
  }
}
  public static void main(String args[])
  {
    new RegistrationFetch();
  }
} 