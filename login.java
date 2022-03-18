import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class InvalidPasswordException extends Exception
{
}


public class Login extends JFrame implements ActionListener
{
Font f1=new Font("Cambria",Font.BOLD,25);
Font f2=new Font("Century Schoolbook",Font.BOLD,50);
Font f3=new Font("Fixedsys",Font.BOLD,50);
Font f4=new Font("Colonna MT",Font.BOLD,50);

Color c1=new Color(168,208,208);
Color c2=new Color(0,0,0);
Color c3=new Color(255,19,19);
Color c4=new Color(0,255,0);
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
JTextField t1,t2;
JButton b1,b2,b3;
ImageIcon img1,img2,img3,img4;
JPanel p1,p2,p3,p4,p5;
Container c;

int attempt=0;
public Login()

{
         setSize(300,300);
	 setLayout(null);
	 setVisible(true);
	show();
	c=getContentPane();
	c.setBackground(c2);

    
    // pannel one

    p1=new JPanel();
	p1.setBounds(20,10,1500,140);
	p1.setLayout(null);
	p1.setBackground(c1);
	add(p1);
   

    l1=new JLabel("FITNESS CENTER");
	l1.setBounds(500,20,800,60);
	l1.setFont(f3);
	l1.setForeground(c3);
	p1.add(l1);

	img1=new ImageIcon("images/My.png");
	l2=new JLabel(img1);
	l2.setBounds(20,10,500,120);
	p1.add(l2);

    //pannel two



    p2=new JPanel();
	p2.setBounds(20,160,1500,630);
	p2.setLayout(null);
	p2.setBackground(c1);
	add(p2);
/*
    img2=new ImageIcon("E:/Java/jdk1.5.0/bin/New folder/Fitness Center/images/profile.jpg");
	l3=new JLabel(img2);
	l3.setBounds(0,0,1500,630);
	p2.add(l3);
   */
    JPanel p4=new JPanel();
    p4.setBounds(400,70,700,400);
    add(p4);
    p4.setBackground(c2);
    p4.setLayout(null);
    p2.add(p4);

   


    l3=new JLabel("Login Form");
	l3.setBounds(240,10,800,80);
	l3.setFont(f4);
	l3.setForeground(c4);
	p4.add(l3);


	l4=new JLabel("User ID");
	l4.setBounds(230,100,500,80);
	l4.setFont(f1);
	l4.setForeground(c3);
	p4.add(l4);

	t1=new JTextField(20);
    t1.setBounds(335,125,200,25);
    t1.setFont(f1);
    p4.add(t1);

    l5=new JLabel("Password");
	l5.setBounds(220,143,500,80);
	l5.setFont(f1);
	l5.setForeground(c3);
	p4.add(l5);

	t2=new JTextField(20);
    t2.setBounds(335,170,200,25);
    t2.setFont(f1);
    p4.add(t2);

   


    b1=new JButton("Login");
    b1.setBounds(220,230,150,30);
    b1.addActionListener(this);
    b1.setFont(f1);
    p4.add(b1);

    b2=new JButton("Reset");
    b2.setBounds(400,230,150,30);
    b2.addActionListener(this);
    b2.setFont (f1);
    p4.add(b2);




}
        public void actionPerformed(ActionEvent ae)
        {
              
                if(ae.getSource()==b1)
                {
		int flag=1;
		String s1=t1.getText();
		String s2=t2.getText();
		if(s1.equals(""))
		{
		
		JOptionPane.showMessageDialog(null,"Username Cannot be empty","Login",JOptionPane.INFORMATION_MESSAGE);
		 
		flag=0;
		}

		if(flag==1)
		{
	
			if(s2.equals(""))
			{
		
			JOptionPane.showMessageDialog(null,"Password Cannot be empty","Login",JOptionPane.INFORMATION_MESSAGE);
		 
		
			}
			else if(s2.length()<8)
			{
			JOptionPane.showMessageDialog(null,"Password Cannot be less than 8 digit ","Login",JOptionPane.INFORMATION_MESSAGE);
			t2.setText("");
			
			}
			

	

		
		
		else
		{


	
                        try
                        {
                                String user = t1.getText();
                                String pass = t2.getText();
                                if((user.compareTo("Fitness Center")==0)&&pass.compareTo("abcd1234")==0)
                                {
                                        JOptionPane.showMessageDialog(null,"Login Successful");
                                    	
		
					FitnessMDI ob=new FitnessMDI();
		

                                }
                                else
                                {
                                        throw new InvalidPasswordException();
                                }
                        }
                        catch(Exception e)
                        {
                                attempt++;
                                JOptionPane.showMessageDialog(null,"Login Failed","Login",JOptionPane.ERROR_MESSAGE);
                                t1.setText("");
                                t2.setText("");
                                t1.requestFocus();
                                if(attempt == 3)
                                {
                                        JOptionPane.showMessageDialog(null,"3 Attempts Over","Login",JOptionPane.ERROR_MESSAGE);
                                        System.exit(0);
                                }
                        }
                }
        }

	}

if(ae.getSource()==b2)
              {
t1.setText("");
t2.setText("");
t1.requestFocus();

}
}
public static void main(String a[])
{
new Login();
}}




























