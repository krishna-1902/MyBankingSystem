package atm_new;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Calendar;
import java.io.*;

class MyFrame extends JFrame implements ActionListener{

	JPanel panel1,panel2,subpanel2,subpanel3,subpanel4,subpanel5,mainpanel,panel3,panel4,subPanelpin,subPanelpin1,subPanelpin2,panel5,panel6;
	CardLayout cl;
	Container cont;
	JButton ministatement,withdrawl,bal,other,pin,fastcash,ret;
	JTextField pw2,accountnotxt,pw3;
	JPasswordField pw1,pass1;
	Timer t1;
	Calendar cal=Calendar.getInstance();
	int point=0,checkmini=0,checkpinreset=0;
	String str11;


//***************************************************************************************************************************************************************************

	class inner implements ActionListener				/******************************* INNER CLASS FOR TIMER ****************************/
	{
			int x;

			public inner(int counter)
			{
				x=counter;
			}

			public void actionPerformed(ActionEvent e)
			{
				x--;
				
				if(x<1)
				{
					if(point==2 && checkpinreset==1)
					{
						System.out.println("***************************************************************************************************\nMESSAGE FROM MyBank :\n");
						System.out.println("YOUR REQUEST FOR RE-SETTING THE PIN OF YOUR CREDIT/DEBIT CARD IS DENIED !!!"); 
						System.out.println("\n***************************************************************************************************");
						checkpinreset=0;
					}
					if(point==1 && checkmini==1)
					{
						try
						{
							new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
						}
						catch(Exception exc)
						{
							System.out.println(exc);
						}
						System.out.println("***************************************************************************************************\n------------------------------- MESSAGE FROM MyBank -------------------------------\n");
						System.out.println("TRANSACTION DETAILS"); 
						System.out.println("\n***************************************************************************************************");
						checkmini=0;
					}
					
					cl.show(cont,"0");
					t1.stop();
				}

			}

		}

//***************************************************************************************************************************************************************************

	MyFrame()
	{
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		cl=new CardLayout();
		this.setLayout(cl);
		cont=this.getContentPane();			//Getting The Containt pain of Frame	

		ImageIcon i1=new ImageIcon("lion.jpg");		//Adding Image
		this.setIconImage(i1.getImage());
		this.setTitle("Connected With All Banks");

		addTo(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);

	}

//***************************************************************************************************************************************************************************

	public void addToPanel1(JPanel p1)				/******************** SETTING WINDOW OF ATM *************************/
	{
		//Adding Labels To Panel
		ImageIcon i=new ImageIcon("atm.jfif");

		JLabel lc1=new JLabel("Welcome To My Bank");
		lc1.setForeground(Color.YELLOW);
		Font font1=new Font("Southern",Font.BOLD,35);
		lc1.setFont(font1);
		lc1.setBounds(250,0,400,50);
		p1.add(lc1);
		
		JLabel lc=new JLabel("SELECT TRANSACTION");
		lc.setForeground(Color.YELLOW);
		Font font2=new Font("Arial",Font.PLAIN,22);
		lc.setFont(font2);
		lc.setBounds(300,70,400,50);
		p1.add(lc);

		JLabel l=new JLabel(i);
		l.setSize(800,600);
		p1.add(l);

		//Adding Buttons
		ministatement=new JButton("Mini Statement");	//Adding Mini Statement
		ministatement.setBounds(20,150,200,50);
		Font font3=new Font("Arial",Font.BOLD,18);
		ministatement.setFont(font3);
		p1.add(ministatement);
		ministatement.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				point=1;
				cl.show(cont,"2");
			}
		});

		pin=new JButton("Pin Change");			//Adding Pin Change
		pin.setBounds(20,300,200,50);
		pin.setFont(font3);
		p1.add(pin);
		pin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				point=2;
				cl.show(cont,"2");
			}
		});

		bal=new JButton("Balance Enquiry");		//Adding Balance Enquiry
		bal.setBounds(20,450,200,50);
		bal.setFont(font3);
		p1.add(bal);
		bal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				point=3;
				cl.show(cont,"2");
				/*cl.show(cont,"7");
				int counter=5;
				inner in=new inner(counter);
				t1=new Timer(1000,in);			
				t1.start();*/
			}
		});

		fastcash=new JButton("Fast Cash");		//Adding Fast Cash
		fastcash.setBounds(580,150,200,50);
		fastcash.setFont(font3);
		p1.add(fastcash);
		fastcash.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				point=4;
				cl.show(cont,"2");
			}
		});

		withdrawl=new JButton("Withdrawl Cash");	//Adding WithDrawl Cash
		withdrawl.setBounds(580,300,200,50);
		withdrawl.setFont(font3);
		p1.add(withdrawl);
		withdrawl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				point=5;
				cl.show(cont,"2");
			}
		});

		other=new JButton("Other");			//Adding Other
		other.setBounds(580,450,200,50);
		other.setFont(font3);
		p1.add(other);
		other.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cl.show(cont,"8");
			}
		});

		ret=new JButton();	//Adding WithDrawl Cash
		ret.setBounds(20,550,760,10);
		ret.setBackground(Color.YELLOW);
		p1.add(ret);
		ret.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cl.show(cont,"0");
			}
		});
		

	}

//***************************************************************************************************************************************************************************

	public void addToPanel2(JPanel p2)			/*************************** SETTING PIN WINDOW *************************/
	{
		JPanel p=new JPanel();
		//p.setLocation(450,80);
		GridLayout gr=new GridLayout(4,3);
		p.setLayout(gr);
		gr.setVgap(5);
		gr.setHgap(5);
		//p.setBackground(Color.LIGHT_GRAY);
		//p.setSize(300,400);
		p.setBounds(450,10,330,540);
		JButton b1=new JButton("1");
		JButton b2=new JButton("2");
		JButton b3=new JButton("3");
		JButton b4=new JButton("4");
		JButton b5=new JButton("5");
		JButton b6=new JButton("6");
		JButton b7=new JButton("7");
		JButton b8=new JButton("8");
		JButton b9=new JButton("9");
		JButton bcl=new JButton("CLEAR");
		JButton b0=new JButton("0");
		JButton ben=new JButton("ENTER");

		bcl.setBackground(Color.RED);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(Color.GREEN);
		ben.setFont(new Font("Ariel",Font.PLAIN,18));
		b1.setFont(new Font("Ariel",Font.PLAIN,18));
		b2.setFont(new Font("Ariel",Font.PLAIN,18));
		b3.setFont(new Font("Ariel",Font.PLAIN,18));
		b4.setFont(new Font("Ariel",Font.PLAIN,18));
		b5.setFont(new Font("Ariel",Font.PLAIN,18));
		b6.setFont(new Font("Ariel",Font.PLAIN,18));
		b7.setFont(new Font("Ariel",Font.PLAIN,18));
		b8.setFont(new Font("Ariel",Font.PLAIN,18));
		b9.setFont(new Font("Ariel",Font.PLAIN,18));
		b0.setFont(new Font("Ariel",Font.PLAIN,18));

		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(bcl);
		p.add(b0);
		p.add(ben);

		p2.add(p);

		JPanel p5=new JPanel();
		p5.setBounds(10,10,430,540);
		p5.setLayout(null);
		//p5.setBackground(new Color(50,50,255));
		p5.setBackground(Color.WHITE);
		
		//Adding Labels and TextField To p5

		ImageIcon icon=new ImageIcon("atm.jfif");
	
		JLabel lb=new JLabel("ENTER 4 DIGIT PIN");
		lb.setFont(new Font("southern",Font.BOLD,28));
		lb.setForeground(Color.BLACK);
		lb.setBounds(90,100,280,50);
		p5.add(lb);

		pw1=new JPasswordField();
		pw1.setBounds(130,200,190,110);
		pw1.setFont(new Font("southern",Font.BOLD,115));
		pw1.setEditable(false);
		//pw1.setBackground(new Color(50,50,255));
		//pw1.setBackground(Color.BLACK);
		pw1.setForeground(Color.BLACK);
		pw1.setEchoChar('*');
		p5.add(pw1);

		
		JLabel lb1=new JLabel(icon);
		lb1.setBounds(190,320,icon.getIconWidth(),icon.getIconHeight());
		p5.add(lb1);

		/*************** IMPLEMENTING BUTTONS ******************/

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw1.setText(pw1.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw1.setText(pw1.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw1.setText(pw1.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw1.setText(pw1.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw1.setText(pw1.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw1.setText(pw1.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw1.setText(pw1.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw1.setText(pw1.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw1.setText(pw1.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw1.setText(pw1.getText()+"0");
			}	
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw1.setText("");
			}	
		});

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String get=pw1.getText();
				if(get.length()==4)
				{							//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
					if(point==5)
					{
						cl.show(cont,"3");
					}
					else if(point==3)
					{
						cl.show(cont,"7");
						int counter=5;
						inner in=new inner(counter);
						t1=new Timer(1000,in);			
						t1.start();
					}
					else if(point==2)
					{
						checkpinreset=1;
						try
						{
							new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
						}
						catch(Exception exc)
						{
							System.out.println(exc);
						}
						System.out.println("***************************************************************************************************\nMESSAGE FROM MyBank :\n");
						str11=CreateOTP.gen();
						System.out.println("YOU REQUESTED TO SET THE PIN OF YOUR CREDIT/DEBIT CARD,\nFOR THIS PURPOSE THE OTP IS : "+str11+".\nIF THIS WAS NOT DONE BY YOU THEN VISIT NEAREST BRANCH OF MyBANK."); 
						System.out.println("\n***************************************************************************************************");
						cl.show(cont,"10");
						
						//////////////////////////////////////////////////////////////////////////////////////////////////////////
						int counter=10;
						inner in=new inner(counter);
						t1=new Timer(1000,in);
						t1.start();	
					}
					else if(point==1)
					{
						checkmini=1;
						cl.show(cont,"12");
						int counter=5;
						inner in=new inner(counter);
						t1=new Timer(1000,in);
						t1.start();
						
					}
					else if(point==4)
					{
						cl.show(cont,"11");
					}
				}
				else
				{
					cl.show(cont,"4");

					int counter=5;
					inner in=new inner(counter);
					t1=new Timer(1000,in);
					t1.start();

				}
				pw1.setText("");

			}
		});

		
		/***************  		     ******************/		

		p2.add(p5);

	}


//***************************************************************************************************************************************************************************

	public void subaddToPanel2(JPanel p2)	/********************** SETTING CASH WINDOW ******************************/
	{
		JPanel p=new JPanel();
		//p.setLocation(450,80);
		GridLayout gr=new GridLayout(4,3);
		p.setLayout(gr);
		gr.setVgap(5);
		gr.setHgap(5);
		//p.setBackground(Color.LIGHT_GRAY);
		//p.setSize(300,400);
		p.setBounds(450,10,330,540);
		JButton b1=new JButton("1");
		JButton b2=new JButton("2");
		JButton b3=new JButton("3");
		JButton b4=new JButton("4");
		JButton b5=new JButton("5");
		JButton b6=new JButton("6");
		JButton b7=new JButton("7");
		JButton b8=new JButton("8");
		JButton b9=new JButton("9");
		JButton bcl=new JButton("CLEAR");
		JButton b0=new JButton("0");
		JButton ben=new JButton("ENTER");

		bcl.setBackground(Color.RED);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(Color.GREEN);
		ben.setFont(new Font("Ariel",Font.PLAIN,18));
		b1.setFont(new Font("Ariel",Font.PLAIN,18));
		b2.setFont(new Font("Ariel",Font.PLAIN,18));
		b3.setFont(new Font("Ariel",Font.PLAIN,18));
		b4.setFont(new Font("Ariel",Font.PLAIN,18));
		b5.setFont(new Font("Ariel",Font.PLAIN,18));
		b6.setFont(new Font("Ariel",Font.PLAIN,18));
		b7.setFont(new Font("Ariel",Font.PLAIN,18));
		b8.setFont(new Font("Ariel",Font.PLAIN,18));
		b9.setFont(new Font("Ariel",Font.PLAIN,18));
		b0.setFont(new Font("Ariel",Font.PLAIN,18));

		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(bcl);
		p.add(b0);
		p.add(ben);

		p2.add(p);

		JPanel p5=new JPanel();
		p5.setBounds(10,10,430,540);
		p5.setLayout(null);
		//p5.setBackground(new Color(50,50,255));
		p5.setBackground(Color.WHITE);
		
		//Adding Labels and TextField To p5

		ImageIcon icon=new ImageIcon("atm.jfif");
	
		JLabel lb=new JLabel("ENTER AMOUNT");
		lb.setFont(new Font("southern",Font.BOLD,28));
		lb.setForeground(Color.BLACK);
		lb.setBounds(100,100,400,50);
		p5.add(lb);

		pw2=new JTextField();
		pw2.setBounds(80,200,260,110);
		pw2.setHorizontalAlignment(JTextField.CENTER);
		pw2.setFont(new Font("southern",Font.BOLD,70));
		pw2.setEditable(false);
		pw2.setForeground(Color.BLACK);
		p5.add(pw2);

		
		JLabel lb1=new JLabel(icon);
		lb1.setBounds(190,320,icon.getIconWidth(),icon.getIconHeight());
		p5.add(lb1);

		/*************** IMPLEMENTING BUTTONS ******************/

		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw2.setText(pw2.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw2.setText(pw2.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw2.setText(pw2.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw2.setText(pw2.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw2.setText(pw2.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw2.setText(pw2.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw2.setText(pw2.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw2.setText(pw2.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw2.setText(pw2.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw2.setText(pw2.getText()+"0");
			}	
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw2.setText("");
			}	
		});

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String str=pw2.getText();
				if(str.length()>4)
				{
					cl.show(cont,"6");
					int counter=5;
					inner in=new inner(counter);
					t1=new Timer(1000,in);
					t1.start();
				}
				else
				{
					cl.show(cont,"5");
					try{
						new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
					}
					catch(Exception exc)
					{
						System.out.println(exc);
					}
					System.out.println("***************************************************************************************************\nMESSAGE FROM MyBank :\n");
					System.out.println("YOUR ACCOUNT NUMBER: "+"......XXXX IS DEBITED WITH \n"+"Rs "+pw2.getText()+" ON "+ cal.getTime() +" TOWARDS ATM CASH WITHDRAWL\nIF THIS WAS NOT DONE BY YOU THEN VISIT NEAREST BRANCH OF MyBANK."); 
					System.out.println("\n***************************************************************************************************");
				}
				pw2.setText("");
			}
			
				
		});

		/***************  		     ******************/		

		p2.add(p5);

	}

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//***************************************************************************************************************************************************************************

	public void addTosubPanelpin1(JPanel p2)	/********************** SETTING TYPE OTP WINDOW ******************************/
	{
		JPanel p=new JPanel();
		//p.setLocation(450,80);
		GridLayout gr=new GridLayout(4,3);
		p.setLayout(gr);
		gr.setVgap(5);
		gr.setHgap(5);
		//p.setBackground(Color.LIGHT_GRAY);
		//p.setSize(300,400);
		p.setBounds(450,10,330,540);
		JButton b1=new JButton("1");
		JButton b2=new JButton("2");
		JButton b3=new JButton("3");
		JButton b4=new JButton("4");
		JButton b5=new JButton("5");
		JButton b6=new JButton("6");
		JButton b7=new JButton("7");
		JButton b8=new JButton("8");
		JButton b9=new JButton("9");
		JButton bcl=new JButton("CLEAR");
		JButton b0=new JButton("0");
		JButton ben=new JButton("ENTER");

		bcl.setBackground(Color.RED);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(Color.GREEN);
		ben.setFont(new Font("Ariel",Font.PLAIN,18));
		b1.setFont(new Font("Ariel",Font.PLAIN,18));
		b2.setFont(new Font("Ariel",Font.PLAIN,18));
		b3.setFont(new Font("Ariel",Font.PLAIN,18));
		b4.setFont(new Font("Ariel",Font.PLAIN,18));
		b5.setFont(new Font("Ariel",Font.PLAIN,18));
		b6.setFont(new Font("Ariel",Font.PLAIN,18));
		b7.setFont(new Font("Ariel",Font.PLAIN,18));
		b8.setFont(new Font("Ariel",Font.PLAIN,18));
		b9.setFont(new Font("Ariel",Font.PLAIN,18));
		b0.setFont(new Font("Ariel",Font.PLAIN,18));

		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(bcl);
		p.add(b0);
		p.add(ben);

		p2.add(p);

		JPanel p5=new JPanel();
		p5.setBounds(10,10,430,540);
		p5.setLayout(null);
		//p5.setBackground(new Color(50,50,255));
		p5.setBackground(Color.WHITE);
		
		//Adding Labels and TextField To p5

		ImageIcon icon=new ImageIcon("atm.jfif");
	
		JLabel lb=new JLabel("ENTER OTP");
		lb.setFont(new Font("southern",Font.BOLD,28));
		lb.setForeground(Color.BLACK);
		lb.setBounds(140,100,400,50);
		p5.add(lb);

		JLabel lbx=new JLabel("*ENTER OTP WITHIN 10 SECONDS.");
		lbx.setFont(new Font("southern",Font.BOLD,18));	
		lbx.setForeground(Color.RED);
		lbx.setBounds(55,30,400,50);
		p5.add(lbx);

		pw3=new JTextField();
		pw3.setBounds(80,200,260,110);
		pw3.setHorizontalAlignment(JTextField.CENTER);
		pw3.setFont(new Font("southern",Font.BOLD,70));
		pw3.setEditable(false);
		pw3.setForeground(Color.BLACK);
		p5.add(pw3);

		
		JLabel lb1=new JLabel(icon);
		lb1.setBounds(190,320,icon.getIconWidth(),icon.getIconHeight());
		p5.add(lb1);

		/*************** IMPLEMENTING BUTTONS ******************/

		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw3.setText(pw3.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw3.setText(pw3.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw3.setText(pw3.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw3.setText(pw3.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw3.setText(pw3.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw3.setText(pw3.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw3.setText(pw3.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw3.setText(pw3.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw3.setText(pw3.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw3.setText(pw3.getText()+"0");
			}	
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pw3.setText("");
			}	
		});

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				t1.stop();
				String strget=pw3.getText();
				if(str11.equalsIgnoreCase(strget))
				{
					cl.show(cont,"13");
				}
				else
				{
					cl.show(cont,"9");
					int counter=5;
					inner in=new inner(counter);
					t1=new Timer(1000,in);
					t1.start();
				}
				pw3.setText("");
			}
			
				
		});

		/***************  		     ******************/		

		p2.add(p5);

	}

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	//***************************************************************************************************************************************************************************

	public void addTosubPanelpin2(JPanel p2)			/*************************** SETTING PIN-RESET WINDOW *************************/
	{
		JPanel p=new JPanel();
		//p.setLocation(450,80);
		GridLayout gr=new GridLayout(4,3);
		p.setLayout(gr);
		gr.setVgap(5);
		gr.setHgap(5);
		//p.setBackground(Color.LIGHT_GRAY);
		//p.setSize(300,400);
		p.setBounds(450,10,330,540);
		JButton b1=new JButton("1");
		JButton b2=new JButton("2");
		JButton b3=new JButton("3");
		JButton b4=new JButton("4");
		JButton b5=new JButton("5");
		JButton b6=new JButton("6");
		JButton b7=new JButton("7");
		JButton b8=new JButton("8");
		JButton b9=new JButton("9");
		JButton bcl=new JButton("CLEAR");
		JButton b0=new JButton("0");
		JButton ben=new JButton("ENTER");

		bcl.setBackground(Color.RED);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(Color.GREEN);
		ben.setFont(new Font("Ariel",Font.PLAIN,18));
		b1.setFont(new Font("Ariel",Font.PLAIN,18));
		b2.setFont(new Font("Ariel",Font.PLAIN,18));
		b3.setFont(new Font("Ariel",Font.PLAIN,18));
		b4.setFont(new Font("Ariel",Font.PLAIN,18));
		b5.setFont(new Font("Ariel",Font.PLAIN,18));
		b6.setFont(new Font("Ariel",Font.PLAIN,18));
		b7.setFont(new Font("Ariel",Font.PLAIN,18));
		b8.setFont(new Font("Ariel",Font.PLAIN,18));
		b9.setFont(new Font("Ariel",Font.PLAIN,18));
		b0.setFont(new Font("Ariel",Font.PLAIN,18));

		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(bcl);
		p.add(b0);
		p.add(ben);

		p2.add(p);

		JPanel p5=new JPanel();
		p5.setBounds(10,10,430,540);
		p5.setLayout(null);
		//p5.setBackground(new Color(50,50,255));
		p5.setBackground(Color.WHITE);
		
		//Adding Labels and TextField To p5

		ImageIcon icon=new ImageIcon("atm.jfif");
	
		JLabel lb=new JLabel("SET NEW 4 DIGIT PIN");
		lb.setFont(new Font("southern",Font.BOLD,28));
		lb.setForeground(Color.BLACK);
		lb.setBounds(80,100,350,50);
		p5.add(lb);

		pass1=new JPasswordField();
		pass1.setBounds(130,200,190,110);
		pass1.setFont(new Font("southern",Font.BOLD,115));
		pass1.setEditable(false);
		//pw1.setBackground(new Color(50,50,255));
		//pw1.setBackground(Color.BLACK);
		pass1.setForeground(Color.BLACK);
		pass1.setEchoChar('*');
		p5.add(pass1);

		JLabel leb=new JLabel("*PIN MUST BE OF FOUR DIGIT");
		leb.setBounds(70,20,350,50);
		leb.setFont(new Font("Ariel",Font.PLAIN,20));
		leb.setForeground(Color.RED);
		p2.add(leb);
		leb.setVisible(false);
		
		JLabel lb1=new JLabel(icon);
		lb1.setBounds(190,320,icon.getIconWidth(),icon.getIconHeight());
		p5.add(lb1);

		/*************** IMPLEMENTING BUTTONS ******************/

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pass1.setText(pass1.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pass1.setText(pass1.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pass1.setText(pass1.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pass1.setText(pass1.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pass1.setText(pass1.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pass1.setText(pass1.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pass1.setText(pass1.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pass1.setText(pass1.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pass1.setText(pass1.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pass1.setText(pass1.getText()+"0");
			}	
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				pass1.setText("");
			}	
		});

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String get=pass1.getText();
				if(get.length()==4)
				{							
					System.out.println("\n***************************************************************************************************\nMESSAGE FROM MyBank :\n");
					System.out.println("YOUR ATM PIN IS CHANGED SUCCESSFULLY.\nIF THIS WAS NOT DONE BY YOU THEN VISIT NEAREST BRANCH OF MyBANK."); 
					System.out.println("\n***************************************************************************************************");
					cl.show(cont,"0");
					leb.setVisible(false);
				}
				else
				{
					leb.setVisible(true);
					pass1.setText("");
				}
				pass1.setText("");
			}
		});

		
		/***************  		     ******************/		

		p2.add(p5);

	}


//***************************************************************************************************************************************************************************

	public void subaddToPanel3(JPanel p)				/************** SETTING TRANSACTION FAILED WINDOW FOR ICORRECT PIN ***********************/
	{
		p.setBackground(Color.WHITE);
		ImageIcon icon=new ImageIcon("warning1.png");
		JLabel lb=new JLabel(icon);
		lb.setBounds(300,50,200,180);
		p.add(lb);

		JLabel inst=new JLabel("INCORRECT PIN !!!");
		inst.setBounds(160,250,500,100);
		inst.setForeground(Color.RED);
		inst.setFont(new Font("Ariel",Font.BOLD,50));
		p.add(inst);

		JLabel inst1=new JLabel("TRANSACTION FAILED");
		inst1.setBounds(230,320,500,100);
		inst1.setForeground(Color.BLACK);
		inst1.setFont(new Font("Ariel",Font.BOLD,30));
		p.add(inst1);

	}

//***************************************************************************************************************************************************************************

	public void subaddToPanel4(JPanel p)					/************************* COLLECT CASH WINDOW ************/
	{
		ImageIcon icon=new ImageIcon("atm1.jpg");
		JLabel bg=new JLabel(icon);
		bg.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		
		JLabel lb=new JLabel("PLEASE COLLECT YOUR CASH");
		lb.setBounds(20,20,800,100);
		lb.setFont(new Font("southern",Font.BOLD,40));
		lb.setForeground(Color.GREEN);
		p.add(lb);

		JLabel lb1=new JLabel("THANKS FOR USING MYBANK ATM");	
		lb1.setBounds(20,80,800,100);
		lb1.setFont(new Font("southern",Font.BOLD,30));
		lb1.setForeground(Color.WHITE);
		p.add(lb1);

		JLabel lb2=new JLabel("*REMEMBER TO REMOVE YOUR DEBIT/CREDIT CARD BEFORE LEAVING");	
		lb2.setBounds(20,520,800,50);
		lb2.setFont(new Font("southern",Font.PLAIN,18));
		lb2.setForeground(Color.RED);
		p.add(lb2);

		JButton enter=new JButton("NO");
		enter.setBounds(200,420,100,50);
		enter.setBackground(Color.RED);
		enter.setFont(new Font("Arial",Font.BOLD,20));		
		p.add(enter);

		JButton enter1=new JButton("YES");
		enter1.setBounds(20,420,100,50);
		enter1.setBackground(Color.GREEN);
		enter1.setFont(new Font("Arial",Font.BOLD,20));		
		p.add(enter1);

		JLabel lb3=new JLabel("DO YOU WANT TO SEE AVAILABLE BALANCE?");	
		lb3.setBounds(20,180,800,50);
		lb3.setFont(new Font("southern",Font.BOLD,22));
		lb3.setForeground(Color.YELLOW);
		p.add(lb3);

		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cl.show(cont,"0");
			}
		});

		enter1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cl.show(cont,"7");
				int counter=5;
				inner in=new inner(counter);
				t1=new Timer(1000,in);			
				t1.start();
			}
		});

		p.add(bg);
	}

//***************************************************************************************************************************************************************************

	public void addToMainPanel(JPanel p)					/********************* SETTING MAIN PANEL *********************/
	{
		ImageIcon ic=new ImageIcon("atmcardswap.jpg");
		JLabel bg=new JLabel(ic);
		bg.setBounds(0,0,ic.getIconWidth(),ic.getIconHeight());

		JLabel l1=new JLabel("ENTER ACCOUNT NUMBER");
		l1.setBounds(570,60,200,30);
		l1.setForeground(Color.WHITE);
		p.add(l1);
	
		accountnotxt=new JTextField();
		accountnotxt.setBounds(570,100,200,30);
		accountnotxt.setFont(new Font("Ariel",Font.PLAIN,25));
		accountnotxt.setBackground(Color.LIGHT_GRAY);

		p.add(accountnotxt);

		JLabel l2=new JLabel("NO SUCH ACCOUNT EXIST!!!");
		l2.setBounds(530,140,250,30);
		l2.setForeground(Color.RED);
		l2.setFont(new Font("Ariel",Font.BOLD,18));
		l2.setVisible(false);
		p.add(l2);
		
		JButton swap=new JButton("SWAP");
		swap.setBounds(0,500,400,80);
		
		swap.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String str=accountnotxt.getText();
				if(str.length()>=3)			//Condition to match account number
				{
					cl.show(cont,"1");
					accountnotxt.setText("");
					l2.setVisible(false);
				}
				else
				{
					l2.setVisible(true);
					accountnotxt.setText("");
				}
			}
		});		

		swap.setFont(new Font("Arial",Font.BOLD,20));		
		p.add(swap);

		JButton cancel=new JButton("CANCEL");
		cancel.setBounds(400,500,400,80);
		cancel.setBackground(Color.RED);
		cancel.setFont(new Font("Arial",Font.BOLD,20));		
		p.add(cancel);

		p.add(bg);

	}

//***************************************************************************************************************************************************************************

	public void subaddToPanel5(JPanel p)				/************** SETTING TRANSACTION FAILED WINDOW FOR INSUFFISIENT CASH ***********************/
	{
		p.setBackground(Color.WHITE);
		ImageIcon icon=new ImageIcon("warning1.png");
		JLabel lb=new JLabel(icon);
		lb.setBounds(300,50,200,180);
		p.add(lb);
	
		JLabel inst=new JLabel("INSUFFICIENT CASH !!!");
		inst.setBounds(100,250,600,100);
		inst.setForeground(Color.RED);
		inst.setFont(new Font("Ariel",Font.BOLD,50));
		p.add(inst);

		JLabel inst1=new JLabel("TRANSACTION FAILED");
		inst1.setBounds(230,320,500,100);
		inst1.setForeground(Color.BLACK);
		inst1.setFont(new Font("Ariel",Font.BOLD,30));
		p.add(inst1);
	}

//***************************************************************************************************************************************************************************

	public void addTosubPanelpin(JPanel p)				/************** SETTING WINDOW FOR INCORRECT OTP ***********************/
	{
		p.setBackground(Color.WHITE);
		ImageIcon icon=new ImageIcon("warning1.png");
		JLabel lb=new JLabel(icon);
		lb.setBounds(300,50,200,180);
		p.add(lb);
	
		JLabel inst=new JLabel("INCORRECT OTP !!!");
		inst.setBounds(150,250,600,100);
		inst.setForeground(Color.RED);
		inst.setFont(new Font("Ariel",Font.BOLD,50));
		p.add(inst);

		JLabel inst1=new JLabel("TRANSACTION FAILED");
		inst1.setBounds(230,320,500,100);
		inst1.setForeground(Color.BLACK);
		inst1.setFont(new Font("Ariel",Font.BOLD,30));
		p.add(inst1);
	}


//***************************************************************************************************************************************************************************

	public void addTopanel3(JPanel p)				/************** SETTING BALANCE ENQUIRY WINDOW ***********************/
	{
		ImageIcon icon=new ImageIcon("balance.png");
		JLabel lb=new JLabel(icon);
		lb.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		
		JLabel inst=new JLabel("AVAILABLE BALANCE : "+"Rs 10000");
		inst.setBounds(50,230,800,100);
		inst.setForeground(Color.WHITE);
		inst.setFont(new Font("Ariel",Font.BOLD,40));
		p.add(inst);

		JLabel inst1=new JLabel("MyATM - MAKING BANKING EASY");
		inst1.setBounds(50,20,800,100);
		inst1.setForeground(Color.YELLOW);
		inst1.setFont(new Font("Ariel",Font.BOLD,25));
		p.add(inst1);

		JLabel inst2=new JLabel("@ TOTALLY SECURED");
		inst2.setBounds(530,480,800,100);
		inst2.setForeground(Color.YELLOW);
		inst2.setFont(new Font("Ariel",Font.BOLD,20));
		p.add(inst2);

		p.add(lb);

	}

//***************************************************************************************************************************************************************************

	public void addTopanel4(JPanel p)		/************** SETTING OTHER WINDOW ***********************/
	{
		JTextArea tf=new JTextArea();
		tf.setLineWrap(true);
		tf.setBounds(0,0,790,500);
		tf.setBackground(new Color(50,50,255));
		tf.setFont(new Font("Ariel",Font.BOLD,23));
		tf.setForeground(Color.WHITE);
		tf.setText("	              WELCOME TO MyBANK SERVICES\n\n	MyBANK PROVIDES VARIOUS SERVICES REALATED TO    EASE IN BANKING. CREATING BANK-ACCOUNT, HOW TO USE ATM      MACHINE, HOW  TO USE CDM MACHINE  ARE THE MAIN  GOALS  OF    THIS PROJECT.\n\n\n\n\n\n\n\n		            THANKS FOR CONNECTING WITH,\n			    MyBANK SERVICES");
		tf.setEditable(false);

		JButton cancel=new JButton("BACK");
		cancel.setBounds(350,510,100,40);
		cancel.setFont(new Font("Arial",Font.BOLD,20));		
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent even)
			{
				cl.show(cont,"0");
			}
		});

		p.add(tf);

	}

//***************************************************************************************************************************************************************************

	public void addTopanel5(JPanel p)		/************** SETTING FAST-CASH WINDOW ***********************/
	{
		ImageIcon icon=new ImageIcon("balance.png");
		JLabel lb=new JLabel(icon);
		lb.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		
		JRadioButton b1=new JRadioButton("5000");
		b1.setBounds(80,270,150,50);
		b1.setForeground(Color.RED);
		b1.setFont(new Font("Arial",Font.BOLD,30));
		b1.setBackground(Color.BLACK);
		p.add(b1);

		JRadioButton b2=new JRadioButton("10000");
		b2.setBounds(570,270,150,50);
		b2.setForeground(Color.RED);
		b2.setFont(new Font("Arial",Font.BOLD,30));
		b2.setBackground(Color.BLACK);
		p.add(b2);

		JRadioButton b3=new JRadioButton("15000");
		b3.setBounds(80,340,150,50);
		b3.setForeground(Color.RED);
		b3.setFont(new Font("Arial",Font.BOLD,30));
		b3.setBackground(Color.BLACK);
		p.add(b3);

		JRadioButton b4=new JRadioButton("20000");
		b4.setBounds(570,340,150,50);
		b4.setForeground(Color.RED);
		b4.setFont(new Font("Arial",Font.BOLD,30));
		b4.setBackground(Color.BLACK);
		p.add(b4);

		JRadioButton b5=new JRadioButton("100");
		b5.setSelected(true);
		b5.setBounds(80,130,150,50);
		b5.setForeground(Color.RED);
		b5.setFont(new Font("Arial",Font.BOLD,30));
		b5.setBackground(Color.BLACK);
		p.add(b5);

		JRadioButton b6=new JRadioButton("500");
		b6.setBounds(570,130,150,50);
		b6.setForeground(Color.RED);
		b6.setFont(new Font("Arial",Font.BOLD,30));
		b6.setBackground(Color.BLACK);
		p.add(b6);

		JRadioButton b7=new JRadioButton("1000");
		b7.setBounds(80,200,150,50);
		b7.setForeground(Color.RED);
		b7.setFont(new Font("Arial",Font.BOLD,30));
		b7.setBackground(Color.BLACK);
		p.add(b7);

		JRadioButton b8=new JRadioButton("2000");
		b8.setBounds(570,200,150,50);
		b8.setForeground(Color.RED);
		b8.setFont(new Font("Arial",Font.BOLD,30));
		b8.setBackground(Color.BLACK);
		p.add(b8);
		
		ButtonGroup gr=new ButtonGroup();
		gr.add(b1);
		gr.add(b2);
		gr.add(b3);
		gr.add(b4);
		gr.add(b5);
		gr.add(b6);
		gr.add(b7);
		gr.add(b8);

		JButton enter=new JButton("CANCEL");
		enter.setBounds(430,450,150,50);
		enter.setBackground(Color.RED);
		enter.setFont(new Font("Arial",Font.BOLD,20));		
		p.add(enter);

		JButton enter1=new JButton("WITHDRAW");
		enter1.setBounds(220,450,150,50);
		enter1.setBackground(Color.GREEN);
		enter1.setFont(new Font("Arial",Font.BOLD,20));		
		p.add(enter1);

		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cl.show(cont,"0");
			}
		});

		enter1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cl.show(cont,"5");
				int x=0;
				if(b1.isSelected())
				{
					x=5000;
				}
				else if(b2.isSelected())
				{
					x=10000;
				}
				else if(b3.isSelected())
				{
					x=15000;
				}
				else if(b4.isSelected())
				{
					x=20000;
				}
				else if(b5.isSelected())
				{
					x=100;
				}
				else if(b6.isSelected())
				{
					x=500;
				}
				else if(b7.isSelected())
				{
					x=1000;
				}
				else if(b8.isSelected())
				{
					x=2000;
				}


				try{
					new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
				}
				catch(Exception exc)
				{
					System.out.println(exc);
				}
				System.out.println("***************************************************************************************************\nMESSAGE FROM MyBank :\n");
				System.out.println("YOUR ACCOUNT NUMBER: "+"......XXXX IS DEBITED WITH \n"+"Rs "+ x +" ON "+ cal.getTime() +" TOWARDS ATM CASH WITHDRAWL\nIF THIS WAS NOT DONE BY YOU THEN VISIT NEAREST BRANCH OF MyBANK."); 
				System.out.println("\n***************************************************************************************************");
				b5.setSelected(true);
			
			}
		});

		JLabel inst=new JLabel("SELECT THE AMOUNT");
		inst.setBounds(220,15,800,100);
		inst.setForeground(Color.WHITE);
		inst.setFont(new Font("Ariel",Font.BOLD,35));
		p.add(inst);

		ImageIcon ix=new ImageIcon("atm.jfif");
		JLabel l=new JLabel(ix);
		l.setBounds(280,150,ix.getIconWidth(),ix.getIconHeight());
		p.add(l);
	
		p.add(lb);
	}

//***************************************************************************************************************************************************************************

	public void addTopanel6(JPanel p)		/************** SETTING MINI_STATEMENT WINDOW ***********************/
	{

		ImageIcon icon=new ImageIcon("balance.png");
		JLabel lb=new JLabel(icon);
		lb.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		
		JLabel inst=new JLabel("TRANSACTION IS IN PROGRESS");
		inst.setBounds(60,230,800,100);
		inst.setForeground(Color.WHITE);
		inst.setFont(new Font("Ariel",Font.BOLD,40));
		p.add(inst);

		JLabel inst1=new JLabel("MyATM - MAKING BANKING EASY");
		inst1.setBounds(50,20,800,100);
		inst1.setForeground(Color.YELLOW);
		inst1.setFont(new Font("Ariel",Font.BOLD,25));
		p.add(inst1);

		JLabel inst2=new JLabel("@ TOTALLY SECURED");
		inst2.setBounds(530,480,800,100);
		inst2.setForeground(Color.YELLOW);
		inst2.setFont(new Font("Ariel",Font.BOLD,20));
		p.add(inst2);

		JLabel inst3=new JLabel("WAIT.....");
		inst3.setBounds(340,125,200,100);
		inst3.setForeground(Color.WHITE);
		inst3.setFont(new Font("Ariel",Font.BOLD,40));
		p.add(inst3);
		
		
		p.add(lb);	

	}


//***************************************************************************************************************************************************************************

	public void addTo(JFrame f)
	{

	/************* Main Panel ***************/

		mainpanel=new JPanel();
		mainpanel.setSize(800,600);
		mainpanel.setLayout(null);
		addToMainPanel(mainpanel);		//Adding Elements To Panel2

	/************ Panel1 For Withdrawl ***********/

		panel1=new JPanel();
		panel1.setSize(800,600);
		panel1.setLayout(null);
		Color cr=new Color(50,50,255);
 		panel1.setBackground(cr);
		addToPanel1(panel1);		//Adding Elements To Panel1
		
	/************ Panel2 For Withdrawl ***********/

		panel2=new JPanel();
		panel2.setSize(800,600);
		panel2.setLayout(null);
		addToPanel2(panel2);		//Adding Elements To Panel2

	/************ Sub-Panel2 For Withdrawl ***********/

		subpanel2=new JPanel();
		subpanel2.setSize(800,600);
		subpanel2.setLayout(null);
		subaddToPanel2(subpanel2);		//Adding Elements To Sub-Panel2

	/************ Sub-Panel3 For Withdrawl ***********/

		subpanel3=new JPanel();
		subpanel3.setSize(800,600);
		subpanel3.setLayout(null);
		subaddToPanel3(subpanel3);		//Adding Elements To Sub-Panel3

	/************ Sub-Panel4 For Withdrawl ***********/

		subpanel4=new JPanel();
		subpanel4.setSize(800,600);
		subpanel4.setLayout(null);
		subaddToPanel4(subpanel4);		//Adding Elements To Sub-Panel4

	/************ Sub-Panel5 For Withdrawl ***********/

		subpanel5=new JPanel();
		subpanel5.setSize(800,600);
		subpanel5.setLayout(null);
		subaddToPanel5(subpanel5);		//Adding Elements To Sub-Panel4

	/************ Panel3 For Balance Enquiry ***********/

		panel3=new JPanel();
		panel3.setSize(800,600);
		panel3.setLayout(null);
		addTopanel3(panel3);		//Adding Elements To Panel3

	/************ Panel4 For OTHER ***********/

		panel4=new JPanel();
		panel4.setSize(800,600);
		panel4.setLayout(null);
		addTopanel4(panel4);		//Adding Elements To Panel4

	/************ subPanelpin For Pin change ***********/

		subPanelpin=new JPanel();
		subPanelpin.setSize(800,600);
		subPanelpin.setLayout(null);
		addTosubPanelpin(subPanelpin);		//Adding Elements To subPanelpin

	/************ subPanelpin1 For Pin change ***********/

		subPanelpin1=new JPanel();
		subPanelpin1.setSize(800,600);
		subPanelpin1.setLayout(null);
		addTosubPanelpin1(subPanelpin1);		//Adding Elements To subPanelpin1

	/************ subPanelpin2 For Pin change ***********/

		subPanelpin2=new JPanel();
		subPanelpin2.setSize(800,600);
		subPanelpin2.setLayout(null);
		addTosubPanelpin2(subPanelpin2);		//Adding Elements To subPanelpin2

	/************ Panel5 For FAST CASH ***********/

		panel5=new JPanel();
		panel5.setSize(800,600);
		panel5.setLayout(null);
		addTopanel5(panel5);		//Adding Elements To Panel6

	/************ Panel6 For MINI_STATEMENT ***********/

		panel6=new JPanel();
		panel6.setSize(800,600);
		panel6.setLayout(null);
		addTopanel6(panel6);		//Adding Elements To Panel6


	//####################################### Adding Panels To Frame ########################################################
	
		f.add(mainpanel,"0");		//atm-main panel
		f.add(panel1,"1");		//atm-main window

	//####################################### WITHDRAWL- WINDOW ########################################################
	
		f.add(panel2,"2");		//withdrawl-pin type window
		f.add(subpanel2,"3");		//withdrawl-type balance window
		f.add(subpanel3,"4");		//withdrawl-transaction failed window for incorrect pin
		f.add(subpanel4,"5");		//withdrawl-collect cash window
		f.add(subpanel5,"6");		//withdrawl-transaction failed window for insufficient cash

	//####################################### BALANCE ENQUIRY- WINDOW ########################################################
	
		f.add(panel3,"7");		//Balance Enquiry Window

	//####################################### OTHER - WINDOW ########################################################
	
		f.add(panel4,"8");		//OTHER Window

	//####################################### PIN CHANGE - WINDOW ########################################################
	
		f.add(subPanelpin,"9");		//pin-change failed due to incorrect OTP
		f.add(subPanelpin1,"10");	//Type OTP window for pin change
		f.add(subPanelpin2,"13");	//Re-set pin window for pin change

	//####################################### FAST CASH - WINDOW ########################################################
	
		f.add(panel5,"11");		//fast-cash window

	//####################################### FAST CASH - WINDOW ########################################################
	
		f.add(panel6,"12");		//ministatement window
	}

//***************************************************************************************************************************************************************************

	public void actionPerformed(ActionEvent ae)
	{

	}
	
}

//***************************************************************************************************************************************************************************

class Swings{

	public static void main(String argc[])
	{
		
		MyFrame f=new MyFrame();

	}

}