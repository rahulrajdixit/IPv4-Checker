import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class IPv4GUI extends IPAddressBackEnd implements ActionListener
{
	JFrame f1;
	JFrame f2;
	JButton b1;
	JButton b2;
	JTextField txt;
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel labelArray[]=new JLabel[12];           //array of labels
	
	int n=10;
	
	public static void main(String[] args)
	{
		try
		{
			IPv4GUI obj=new IPv4GUI();
			obj.frame1();
			obj.frame2();
		}
		catch(Exception e)
		{
			System.out.println("Unexpected error..!");
		}
	}
	void frame1()
	{
		//declaring
		l1=new JLabel("IPv4 Checker");
		l2=new JLabel("Enter the IP address (version 4) here:");
		txt=new JTextField(20);
		b1=new JButton("Check =>");
		b1.addActionListener(this);//-----------------------------
		b1.setBounds(600-600/4,400-400/4,100,25);
		
		//set component positions
		txt.setBounds(600/2-110/2,180,110,25);
		l1.setBounds(600/2-77/2,30,77,25);
		l2.setBounds(600/2-218/2,140,218,25);
		b1.setBounds(600-600/4,400-400/4,100,25);
		
		//default frame stats
		f1=new JFrame("Frame1");
		f1.setLayout(null);
		f1.setSize(600,400);
		f1.setVisible(true);
		
		//adding
		f1.add(l1);
		f1.add(l2);
		f1.add(txt);
		f1.add(b1);
		
	}
	
	void frame2()
	{
		//declaring
		l3=new JLabel("Result Page");
		f2=new JFrame("Frame2");
		b2=new JButton("<= Go Back");
		
		//set component positions
		l3.setBounds(600/2-80/2,30,80,25);
		b2.setBounds(600-600/4,400-400/4,100,25);
		
		b2.addActionListener(this);//---------------------------------
		
		//adding
		f2.add(l3);
		f2.add(b2);
		for(int i=0;i<n;i++)
		{
			labelArray[i]=new JLabel("");
			labelArray[i].setBounds(100,100+(i*20),400,30);
			f2.add(labelArray[i]);
		}
		//default frame stats
		f2.setSize(600,400);
		f2.setLayout(null);
		
	}
	
	void resultGeneration()
	{
		IPv4var=txt.getText();
		checker(IPv4var);                                 //calling the checker mth
		System.out.println("no. of labels ="+error);
			
			
			int n=3;
			
			if(error==0)
			{
				labelArray[0].setText("IP address "+IPv4+" is valid");
				labelArray[1].setText("Class : "+type);
				if(snm!="")
				{
					labelArray[2].setText("Subnet Mask :"+snm);
				}
				else
				{	//n = 2;
					labelArray[2].setText("");
				}
				for(int i=3;i<=9;i++)
					labelArray[i].setText("");
			}
			else if(error!=0)
			{
				for(int i=0;i<=9;i++)
	   			{
	   				labelArray[i].setText("");
	   			}
				n=error;
		   			for(int i=0;i<n;i++)
		   			{
		   				labelArray[i].setText((i+1)+". "+arr[i]);
		   			}
			}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			
			System.out.println("button pressed");
			f1.setVisible(false);
			
   			resultGeneration();                               //generating the result
   			
			f2.setVisible(true);
			defaultInitializer();                             //initializing default values
		}
		
		else if(e.getSource()==b2)
		{
			System.out.println("back button pressed");
			
			f2.setVisible(false);
			f1.setVisible(true);
			
		}
	}
}