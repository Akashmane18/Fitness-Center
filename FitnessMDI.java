import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FitnessMDI extends JFrame implements ActionListener
{
JPanel p1;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l10;
JTextField t1,t2,t3,t4,t5,t6,t7;
JButton b1,b2,b3,b4,b5;
ImageIcon img1;
     Color c1=new Color(0,0,0);
     Font f1=new Font("Lucida console",Font.BOLD,20);
     Font f2=new Font("Times New Romen",Font.BOLD,20); 
      Font f3=new Font("Lucida console",Font.BOLD,13);
JMenu reg,enq,mem,prof,comp,employee,exit1,report;
JMenuItem member,manager,emp,dietician,trainer,enquiry,profile,pack,batch,fees,feerec,routine,diet,progress,complaint,feedback,salary,memreport,trainerreport,complaintreport,profilereport,feesreport;
JMenuBar mb;
 public FitnessMDI()
     { 
	mb=new JMenuBar();
	
	enq=new JMenu("Enquiry");
	enquiry=new JMenuItem("Make Enquiry");
	mb.add(enq);
	enq.add(enquiry);
	enquiry.addActionListener(this);

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




	mem=new JMenu("Member");
	profile=new JMenuItem("Profile");
	pack=new JMenuItem("Package");
	batch=new JMenuItem("Batch");
	fees=new JMenuItem("Fees");
	feerec=new JMenuItem("Fees Receipt");
	mb.add(mem);
	
	mem.add(profile);
	mem.add(pack);
	mem.add(batch);
	mem.add(fees);
	mem.add(feerec);
	setJMenuBar(mb);
	profile.addActionListener(this);
	pack.addActionListener(this);
	batch.addActionListener(this);
	fees.addActionListener(this);
	feerec.addActionListener(this);


	prof=new JMenu("Profile");
	routine=new JMenuItem("Routine");
	diet=new JMenuItem("Diet");
	progress=new JMenuItem("Progress Card");
	
	mb.add(prof);
	
	prof.add(routine);
	prof.add(diet);
	prof.add(progress);
	setJMenuBar(mb);
	routine.addActionListener(this);
	diet.addActionListener(this);
	progress.addActionListener(this);
	
	comp=new JMenu("Complaint");
	complaint=new JMenuItem("Register Complaint");
	feedback=new JMenuItem("Complaint Feedback");
	
	mb.add(comp);
	
	comp.add(complaint);
	comp.add(feedback);
	setJMenuBar(mb);
	complaint.addActionListener(this);
	feedback.addActionListener(this);
	
	
      	employee=new JMenu("Employee");
	salary=new JMenuItem("Salary");
	
	mb.add(employee);
	
	employee.add(salary);
	
	setJMenuBar(mb);
	salary.addActionListener(this);
	

	report=new JMenu("Reports");
	memreport=new JMenuItem("Member Report");
	trainerreport=new JMenuItem("Trainer Report");
	complaintreport=new JMenuItem("Complaint Report");
	profilereport=new JMenuItem("Profile Report");
	feesreport=new JMenuItem("Fees Report");
	mb.add(report);
	
	report.add(memreport);
	report.add(trainerreport);
	report.add(complaintreport);
	report.add(profilereport);
	report.add(feesreport);
	setJMenuBar(mb);
	memreport.addActionListener(this);
	trainerreport.addActionListener(this);
	complaintreport.addActionListener(this);
	profilereport.addActionListener(this);
	feesreport.addActionListener(this);


	exit1=new JMenu("Exit");
	
	mb.add(exit1);
	
	setJMenuBar(mb);
	exit1.addActionListener(this);

setSize(1400,800);
      setLayout(null);
      setVisible(true);
      p1=new JPanel();
         p1.setLayout(null);
         p1.setBounds(0,0,1900,800);
         p1.setBackground(c1);
     add(p1);  

        
    img1=new ImageIcon("E:/Java/jdk1.5.0/bin/Fitness Center/images/index2.jpg");
	l10=new JLabel(img1);
	l10.setBounds(0,0,1500,1000);
	p1.add(l10);

}

public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==enquiry)
		{
			
		Enquiry ob=new Enquiry();
		
		
		}

		if(ae.getSource()==member)
		{
			
		Registration ob=new Registration();
		
		
		}
		if(ae.getSource()==manager)
		{
			
		Manager ob=new Manager();
		
		
		}

		if (ae.getSource()==trainer)
		{
		Trainer ob=new Trainer();
		}
		if(ae.getSource()==emp)
		{
			
		Employee ob=new Employee();
		
		
		}if(ae.getSource()==dietician)
		{
			
		Dietician ob=new Dietician();
		
		
		}
		
		if(ae.getSource()==profile)
		{
			
		Profile ob=new Profile();
		
		
		}
		if(ae.getSource()==pack)
		{
			
		Package ob=new Package();
		
		
		}if(ae.getSource()==batch)
		{
			
		Batch ob=new Batch();
		
		
		}if(ae.getSource()==routine)
		{
			
		Routine ob=new Routine();
		
		
		}

		/*

		if(ae.getSource()==fees)
		{
			
		Fees ob=new Fees();
		
		
		}

		if(ae.getSource()==feerec)
		{
			
		FeeReceipt ob=new FeeReceipt();
		
		
		}
		*/

		if(ae.getSource()==routine)
		{
			
		Routine ob=new Routine();
		
		
		}if(ae.getSource()==diet)
		{
			
		Diet ob=new Diet();
		
		
		}
	if(ae.getSource()==progress)
		{
			
		Trainer ob=new Trainer();
		
		
		}
		if(ae.getSource()==complaint)
		{
			
		Complaint ob=new Complaint();
		
		
		}if(ae.getSource()==feedback)
		{
			
		Feedback ob=new Feedback();
		
		
		}if(ae.getSource()==salary)
		{
			
		Salary ob=new Salary();
		
		
		}
		if(ae.getSource()==exit1)
		{
			System.exit(0);
		
		}
		if(ae.getSource()==memreport)
		{
		RegistrationReport ob=new RegistrationReport();
		
		}if(ae.getSource()==trainerreport)
		{
		TrainerReport ob=new TrainerReport();
		
		}if(ae.getSource()==feesreport)
		{
		ReceiptReport ob=new ReceiptReport();
		
		
		}if(ae.getSource()==complaintreport)
		{
		ComplaintReport ob=new ComplaintReport();
		
		
		}if(ae.getSource()==profilereport)
		{
		ProfileReport ob=new ProfileReport();
		
		
		}
	}
public static void main(String arg[])
   {
     new FitnessMDI();
   }
}    