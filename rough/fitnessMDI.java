import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class fitnessMDI extends JFrame implements ActionListener
{
JPanel p1;
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
JTextField t1,t2,t3,t4,t5,t6,t7;
JButton b1,b2,b3,b4,b5;
ImageIcon img1=new ImageIcon("nm.jpg");
     Color c1=new Color(66,176,171);
     Font f1=new Font("Lucida console",Font.BOLD,20);
     Font f2=new Font("Times New Romen",Font.BOLD,20); 
      Font f3=new Font("Lucida console",Font.BOLD,13);
JMenu reg;
JMenuItem member,manager,emp,dietician,trainer;
JMenuBar mb;
 public fitnessMDI()
     { 
	mb=new JMenuBar();
	
	reg=new JMenu("Registration");
	member=new JMenuItem("Member");
	manager=new JMenuItem("Manager");
	emp=new JMenuItem("Employee");
	dietician=new JMenuItem("Dietician");
	trainer=new JMenuItem("Trainer");
	mb.add(reg);
	
	reg.add(member);
	reg.add(manager);
	reg.add(emp);
	reg.add(dietician);
	reg.add(trainer);
	setJMenuBar(mb);
	member.addActionListener(this);
	manager.addActionListener(this);
	emp.addActionListener(this);
	dietician.addActionListener(this);
	trainer.addActionListener(this);





      setSize(1400,800);
      setLayout(null);
      setVisible(true);
      p1=new JPanel();
         p1.setLayout(null);
         p1.setBounds(0,0,1400,800);
         p1.setBackground(c1);
     add(p1);  

        
        
}

public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==member)
		{
			
		Registration ob=new Registration();
		
		
		}
		if(ae.getSource()==manager)
		{
			
		Manager ob=new Manager();
		
		
		}if(ae.getSource()==emp)
		{
			
		Employee ob=new Employee();
		
		
		}if(ae.getSource()==dietician)
		{
			
		Dietician ob=new Dietician();
		
		
		}
		
		if(ae.getSource()==trainer)
		{
			
		Trainer ob=new Trainer();
		
		
		}
	}
public static void main(String arg[])
   {
     new fitnessMDI();
   }
}    