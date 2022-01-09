package atm_new;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.time.*;
import java.util.Scanner;

public class MyPay extends JFrame
{
	private JFrame f;
	private JProgressBar progress,progress1;
	private JButton bknotexist,bkexist,xxx;
	private Container cont;
	private JWindow w;
	private Timer t1,tim,tk,tim1,blinking_screen;
	private JPanel billrechargeamount,chkbillupi,billpayed,searchph,billing,userinfopanel,phone,scanpay,otpphone,start,bankdetails,card,setupi,linked,checkbal,checkupipin,gatheringbal,compkyc,transfertomywallet,activewal,wallettoppedup,showwallet,notaddedyet,bktosearch,bhimchk,balchktotransfer,outputfund,outputfund1,forhistory;
	private CardLayout cl;
	private String varify,mobile,atm_num,reciever_acc,reciever_nm,recheckbal,reciever_mob,strtoset,number_to_recieve,patil;
	private int watch,vision=0;
	private JLabel dynamicforcheckbal,mypaymoney,dynamic1,heading,dynamichis1,lmob,lname,parth1,parth2,parth3,dynamicbilling;
	private JRadioButton acc_info,acc_info1,settingmypaywallet;
	private JTextField fund1,fund2,fund3,fund4,fundforwal,fundlast1,fundlast2;
	private JTextArea area;
	private int alexa=0,king=1;
	private JComboBox moboperator,dishoperator;
	private ButtonGroup grp;
	

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	class lap implements ActionListener
	{
		int x;

		lap(int counter)
		{
			x=counter;
		}

		public void actionPerformed(ActionEvent e)
		{
			x--;
			if(x==0)
			{
				w.dispose();
				f.setVisible(true);
				t1.stop();
			}

		}

	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/


	MyPay()
	{
		this.setSize(600,1000);
		cl=new CardLayout();
		this.setLayout(cl);
		this.setLocationRelativeTo(null);
		f=this;
		cont=this.getContentPane();

		showWindow();					//To add app opening window
		addComponent();					//To add component
		
		ImageIcon i1=new ImageIcon("symbol2.jpg");		//Adding Image
		this.setIconImage(i1.getImage());
		this.setTitle("MyPAY");
		this.setResizable(false);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/


	public void addComponent()
	{
		/************** Adding for enter phone number *****************/
		
		phone = new JPanel();
		phone.setLayout(null);
		phone.setBackground(Color.WHITE);
		phone.setBounds(0,0,600,1000);
		this.add(phone,"1");
		addToPhone(phone);

		/************** Adding for verify phone number otp *****************/
		
		otpphone = new JPanel();
		otpphone.setLayout(null);
		otpphone.setBackground(Color.WHITE);
		otpphone.setBounds(0,0,600,1000);
		addToOTPPhone(otpphone);
		this.add(otpphone,"2");

		/************** Adding Main Screen For MyPay *****************/
		
		start = new JPanel();
		start.setLayout(null);
		//start.setBackground(Color.WHITE);
		start.setBounds(0,0,600,1000);
		addToStart(start);
		this.add(start,"3");

		/************** Adding Fetching bankdetails *****************/
		
		bankdetails = new JPanel();
		bankdetails.setLayout(null);
		bankdetails.setBackground(Color.WHITE);
		bankdetails.setBounds(0,0,600,1000);
		addTobankdetails(bankdetails);
		this.add(bankdetails,"4");

		/************** Adding Fill Card Detail *****************/
		
		card = new JPanel();
		card.setLayout(null);
		card.setBackground(Color.WHITE);
		card.setBounds(0,0,600,1000);
		addTocard(card);
		this.add(card,"5");

		/************** Adding Set UPI *****************/
		
		setupi = new JPanel();
		setupi.setLayout(null);
		setupi.setBackground(Color.WHITE);
		setupi.setBounds(0,0,600,1000);
		addTosetupi(setupi);
		this.add(setupi,"6");

		/************** Adding Account Linked *****************/
		
		linked= new JPanel();
		linked.setLayout(null);
		linked.setBackground(Color.WHITE);
		linked.setBounds(0,0,600,1000);
		addTolinked(linked);
		this.add(linked,"7");

		/************** Adding CheckBalance *****************/
		
		checkbal= new JPanel();
		checkbal.setLayout(null);
		//checkbal.setBackground(Color.WHITE);
		checkbal.setBounds(0,0,600,1000);
		addTocheckbal(checkbal);
		this.add(checkbal,"8");

		/************** Adding CheckUPIPIN *****************/
		
		checkupipin= new JPanel();
		checkupipin.setLayout(null);
		checkupipin.setBackground(Color.WHITE);
		checkupipin.setBounds(0,0,600,1000);
		addTocheckupipin(checkupipin);
		this.add(checkupipin,"9");

		/************** Adding GTHERING BANK BALANCE *****************/
		
		gatheringbal= new JPanel();
		gatheringbal.setLayout(null);
		gatheringbal.setBackground(Color.WHITE);
		gatheringbal.setBounds(0,0,600,1000);
		addTogatheringbal(gatheringbal);
		this.add(gatheringbal,"10");

		/************** Adding Complete KYC *****************/
		
		compkyc= new JPanel();
		compkyc.setLayout(null);
		compkyc.setBackground(Color.WHITE);
		compkyc.setBounds(0,0,600,1000);
		addTocompkyc(compkyc);
		this.add(compkyc,"11");

		/************** Adding Wallet Activated *****************/
		
		activewal= new JPanel();
		activewal.setLayout(null);
		activewal.setBackground(Color.WHITE);
		activewal.setBounds(0,0,600,1000);
		addToactivewal(activewal);
		this.add(activewal,"12");

		/************** Show wallet balance *****************/
		
		showwallet= new JPanel();
		showwallet.setLayout(null);
		//showwallet.setBackground(Color.WHITE);
		showwallet.setBounds(0,0,600,1000);
		addToshowwallet(showwallet);
		this.add(showwallet,"13");

		/************** bank account is not added yet *****************/
		
		notaddedyet= new JPanel();
		notaddedyet.setLayout(null);
		notaddedyet.setBounds(0,0,600,1000);
		addTonotaddedyet(notaddedyet);
		this.add(notaddedyet,"14");

		/************** Enter Bank account to search *****************/
		
		bktosearch= new JPanel();
		bktosearch.setLayout(null);
		bktosearch.setBounds(0,0,600,1000);
		bktosearch.setBackground(Color.WHITE);
		addTobktosearch(bktosearch);
		this.add(bktosearch,"15");

		/************** Checking balance to transfer *****************/
		
		balchktotransfer= new JPanel();
		balchktotransfer.setLayout(null);
		balchktotransfer.setBounds(0,0,600,1000);
		balchktotransfer.setBackground(Color.WHITE);
		addTobalchktotransfer(balchktotransfer);
		this.add(balchktotransfer,"16");

		/************** Cheking BHIM UPI for MOney transfer *****************/
		
		bhimchk= new JPanel();
		bhimchk.setLayout(null);
		bhimchk.setBounds(0,0,600,1000);
		bhimchk.setBackground(Color.WHITE);
		addTobhimchk(bhimchk);
		this.add(bhimchk,"17");

		/************** Adding Output Fund For success *****************/
		
		outputfund= new JPanel();
		outputfund.setLayout(null);
		outputfund.setBounds(0,0,600,1000);
		outputfund.setBackground(Color.WHITE);
		addTooutputfund(outputfund);
		this.add(outputfund,"18");

		/************** Adding Output Fund for failure *****************/
		
		outputfund1= new JPanel();
		outputfund1.setLayout(null);
		outputfund1.setBounds(0,0,600,1000);
		outputfund1.setBackground(Color.WHITE);
		addTooutputfund1(outputfund1);
		this.add(outputfund1,"19");
		
		/************** Adding Panel for history *****************/
		
		forhistory= new JPanel();
		forhistory.setLayout(null);
		forhistory.setBounds(0,0,600,1000);
		//forhistory.setBackground(Color.WHITE);
		addToforhistory(forhistory);
		this.add(forhistory,"20");

		/************** Adding Panel for transfer to mywallet *****************/
		
		transfertomywallet= new JPanel();
		transfertomywallet.setLayout(null);
		transfertomywallet.setBounds(0,0,600,1000);
		transfertomywallet.setBackground(Color.WHITE);
		addTotransfertomywallet(transfertomywallet);
		this.add(transfertomywallet,"21");

		/************** wallet topped up successfully *****************/
		
		wallettoppedup= new JPanel();
		wallettoppedup.setLayout(null);
		wallettoppedup.setBounds(0,0,600,1000);
		wallettoppedup.setBackground(Color.WHITE);
		addTowallettoppedup(wallettoppedup);
		this.add(wallettoppedup,"22");

		/************** setting user info panel *****************/
		
		userinfopanel= new JPanel();
		userinfopanel.setLayout(null);
		userinfopanel.setBounds(0,0,600,1000);
		//userinfopanel.setBackground(Color.WHITE);
		addTouserinfopanel(userinfopanel);
		this.add(userinfopanel,"23");

		/************** search phone number for money transfer *****************/
		
		searchph= new JPanel();
		searchph.setLayout(null);
		searchph.setBounds(0,0,600,1000);
		searchph.setBackground(Color.WHITE);
		addTosearchph(searchph);
		this.add(searchph,"24");

		/************** scanpay for money transfer *****************/
		
		scanpay= new JPanel();
		scanpay.setLayout(null);
		scanpay.setBounds(0,0,600,1000);
		scanpay.setBackground(Color.WHITE);
		addToscanpay(scanpay);
		this.add(scanpay,"25");

		/************** recharge and billing for money transfer *****************/
		
		billing= new JPanel();
		billing.setLayout(null);
		billing.setBounds(0,0,600,1000);
		billing.setBackground(Color.WHITE);
		addTobilling(billing);
		this.add(billing,"26");

		/************** enter amount for recharge and billing *****************/
		
		billrechargeamount= new JPanel();
		billrechargeamount.setLayout(null);
		billrechargeamount.setBounds(0,0,600,1000);
		billrechargeamount.setBackground(Color.WHITE);
		addTobillrechargeamount(billrechargeamount);
		this.add(billrechargeamount,"27");


		/************** checking upi pin for recharge and billing *****************/
		
		chkbillupi= new JPanel();
		chkbillupi.setLayout(null);
		chkbillupi.setBounds(0,0,600,1000);
		chkbillupi.setBackground(Color.WHITE);
		addTochkbillupi(chkbillupi);
		this.add(chkbillupi,"28");

		/************** Bill Payed for recharge *****************/
		
		billpayed= new JPanel();
		billpayed.setLayout(null);
		billpayed.setBounds(0,0,600,1000);
		billpayed.setBackground(Color.WHITE);
		addTobillpayed(billpayed);
		this.add(billpayed,"29");



	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addToPhone(JPanel p)				//********************* SETTING ADD PHONE NUMBER ***********************//
	{
		JTextField txtf=new JTextField();
		txtf.setBounds(100,200,400,50);
		txtf.setFont(new Font("Ariel",Font.BOLD,30));
		txtf.setHorizontalAlignment(JTextField.CENTER);
		txtf.setEditable(false);
		txtf.setBackground(Color.WHITE);
		p.add(txtf);

		JPanel winu=new JPanel();
		winu.setLayout(null);
		winu.setBounds(0,1,599,50);
		winu.setBackground(new Color(100,50,255));
		p.add(winu);

		JLabel lb1=new JLabel("ENTER MOBILE NUMBER");
		lb1.setBounds(100,120,400,30);
		lb1.setFont(new Font("Ariel",Font.BOLD,20));
		p.add(lb1);

		JTextArea lb2=new JTextArea("TO USE BHIM UPI, PLEASE ENTER THE MOBILE\n NUMBER LINKED WITH YOUR BANK ACCOUNT");
		lb2.setBounds(100,155,400,50);
		lb2.setFont(new Font("Ariel",Font.BOLD,12));
		lb2.setEditable(false);
		p.add(lb2);

		/********** Adding Buttons *********/

		JPanel px=new JPanel();
		//p.setLocation(450,80);
		px.setBounds(30,400,540,500);
		GridLayout gr=new GridLayout(4,3);
		px.setLayout(gr);
		gr.setVgap(10);
		gr.setHgap(10);
		px.setBackground(Color.WHITE);
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
		JButton bcl=new JButton("X");
		JButton b0=new JButton("0");
		JButton ben=new JButton(">>>>");

		bcl.setBackground(Color.WHITE);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(Color.WHITE);
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

		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b0.setBackground(Color.WHITE);

		px.add(b1);
		px.add(b2);
		px.add(b3);
		px.add(b4);
		px.add(b5);
		px.add(b6);
		px.add(b7);
		px.add(b8);
		px.add(b9);
		px.add(bcl);
		px.add(b0);
		px.add(ben);

		/******* IMPLIMENTING BUTTONS *********/

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"0");
			}	
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText("");
			}	
		});

		JLabel warn=new JLabel("*PHONE NUMBER MUST BE OF 10 DIGITS");
		warn.setBounds(100,260,400,30);
		warn.setFont(new Font("Ariel",Font.BOLD,12));
		warn.setForeground(Color.RED);
		warn.setVisible(false);
		p.add(warn);

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String get=txtf.getText();
				if(get.length()==10)
				{
					System.out.println(get);
					varify=""+CreateOTP.gen();
					mobile=txtf.getText();
					
					try
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
						String q="SELECT * FROM mypay WHERE phone_number=?";
						PreparedStatement st=con.prepareStatement(q);
						st.setString(1,mobile);
						ResultSet set=st.executeQuery();
						if(set.next())
						{
							txtf.setText("");
							warn.setVisible(false);
							cl.show(cont,"3");
						}
						else
						{
							txtf.setText("");
							warn.setVisible(false);
							cl.show(cont,"2");
							JOptionPane.showMessageDialog(f,varify+" IS YOUR OTP TO VARIFY YOUR NUMBER FOR MyPAY.","MESSAGE FROM MyPAY",JOptionPane.PLAIN_MESSAGE);
				
						}
						con.close();
					}
					catch(Exception y)
					{
						System.out.println(y);
					}

					try
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
						String q="SELECT * FROM accountant WHERE ph_no=?";
						PreparedStatement st=con.prepareStatement(q);
						st.setString(1,mobile);
						ResultSet set=st.executeQuery();
						if(set.next())
						{
							dynamic1.setText(set.getString(3));
							dynamichis1.setText(set.getString(3));
							lmob.setText(mobile);
							lname.setText(set.getString(3));
						}
						else
						{
							dynamic1.setText("******"+mobile.substring(6,10));
							dynamichis1.setText("******"+mobile.substring(6,10));
							lmob.setText(mobile);
							lname.setText("******"+mobile.substring(6,10));
						}
						con.close();

					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
					blinking_screen.start();

				}
				else	
				{
					warn.setVisible(true);
					txtf.setText("");
				}

			}
		});

		p.add(px);
	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/
	
	public void addToOTPPhone(JPanel p)			//Phone number verification with otp
	{

		JTextField txtf=new JTextField();
		txtf.setBounds(200,200,200,100);
		txtf.setFont(new Font("Ariel",Font.BOLD,50));
		txtf.setHorizontalAlignment(JTextField.CENTER);
		txtf.setEditable(false);
		txtf.setBackground(Color.WHITE);
		p.add(txtf);

		/*JPanel winu=new JPanel();
		winu.setLayout(null);
		winu.setBounds(0,1,599,50);
		winu.setBackground(new Color(100,50,255));
		p.add(winu);*/

		JLabel lb1=new JLabel("ENTER OTP");
		lb1.setHorizontalAlignment(JTextField.CENTER);
		lb1.setBounds(100,120,400,30);
		lb1.setFont(new Font("Ariel",Font.BOLD,20));
		p.add(lb1);

		JTextArea lb2=new JTextArea("\n                                       OTP IS SENT TO YOUR MOBILE NUMBER");
		lb2.setBounds(0,1,599,50);
		lb2.setBackground(new Color(100,50,255));
		lb2.setForeground(Color.WHITE);
		
		lb2.setFont(new Font("Ariel",Font.BOLD,15));
		lb2.setEditable(false);
		p.add(lb2);

		/********** Adding Buttons *********/

		JPanel px=new JPanel();
		//p.setLocation(450,80);
		px.setBounds(30,400,540,500);
		GridLayout gr=new GridLayout(4,3);
		px.setLayout(gr);
		gr.setVgap(10);
		gr.setHgap(10);
		px.setBackground(Color.WHITE);
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
		JButton bcl=new JButton("X");
		JButton b0=new JButton("0");
		JButton ben=new JButton(">>>>");

		bcl.setBackground(Color.WHITE);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(Color.WHITE);
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

		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b0.setBackground(Color.WHITE);

		px.add(b1);
		px.add(b2);
		px.add(b3);
		px.add(b4);
		px.add(b5);
		px.add(b6);
		px.add(b7);
		px.add(b8);
		px.add(b9);
		px.add(bcl);
		px.add(b0);
		px.add(ben);

		/******* IMPLIMENTING BUTTONS *********/

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"0");
			}	
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText("");
			}	
		});

		JLabel warn=new JLabel("*INCORRECT OTP");
		warn.setBounds(100,300,400,30);
		warn.setFont(new Font("Ariel",Font.BOLD,12));
		warn.setHorizontalAlignment(JTextField.CENTER);
		warn.setForeground(Color.RED);
		warn.setVisible(false);
		p.add(warn);
		
		JButton resend=new JButton("RESEND OTP");
		resend.setBounds(450,300,130,40);
		resend.setFont(new Font("Ariel",Font.BOLD,12));
		resend.setBackground(Color.WHITE);
		resend.setForeground(Color.BLUE);
		resend.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		resend.setVisible(false);
		p.add(resend);

		resend.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				varify=""+CreateOTP.gen();
				txtf.setText("");
				resend.setVisible(false);
				warn.setVisible(false);
				JOptionPane.showMessageDialog(f,varify+" IS YOUR OTP TO VARIFY YOUR NUMBER FOR MyPAY.","MESSAGE FROM MyPAY",JOptionPane.PLAIN_MESSAGE);
			}
		});


		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String get=txtf.getText();
				if(get.equalsIgnoreCase(varify))
				{
					System.out.println("Varified");
					txtf.setText("");
					warn.setVisible(false);
					cl.show(cont,"3");
					
					Connection con=null;
					try
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
						String q="INSERT INTO mypay (phone_number) VALUES (?)";
						PreparedStatement st=con.prepareStatement(q);
						st.setString(1,mobile);
						st.executeUpdate();
						con.close();
					}
					catch(Exception y)
					{
						System.out.println(y);
						try
						{
							con.close();
						}
						catch(Exception k)
						{
							System.out.println(k);
						}
					}

				}
				else	
				{
					warn.setVisible(true);
					txtf.setText("");
					resend.setVisible(true);
				}

			}
		});

		
		p.add(px);
	}


/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addToStart(JPanel p)					//*************** Adding Start main window **********************//
	{
		JTextArea lb2=new JTextArea();
		lb2.setBounds(0,1,599,100);
		lb2.setBackground(new Color(100,50,255));
		lb2.setForeground(Color.WHITE);
		lb2.setFont(new Font("Ariel",Font.BOLD,15));
		lb2.setEditable(false);

		dynamic1=new JLabel("GUEST");
		dynamic1.setBounds(80,40,170,30);
		dynamic1.setForeground(Color.WHITE);
		//dynamic1.setBackground(new Color(100,50,255));
		//dynamic1.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		//dynamic1.setEditable(false);
		//dynamic1.setHorizontalAlignment(JTextField.LEFT);
		dynamic1.setFont(new Font("Ariel",Font.BOLD,20));
		p.add(dynamic1);

		JButton logout=new JButton("@LOGOUT");
		logout.setBounds(450,40,150,30);
		logout.setFont(new Font("Ariel",Font.BOLD,18));
		logout.setForeground(Color.WHITE);
		logout.setBackground(new Color(100,50,255));
		logout.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		p.add(logout);
		logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				dynamic1.setText("GUEST");
				blinking_screen.stop();
				cl.show(cont,"1");	
			}
		});

		JLabel leb=new JLabel("BANK ACCOUNT IS ALREADY ADDED");
		leb.setVisible(false);
		leb.setBounds(200,280,210,30);
		leb.setForeground(Color.RED);
		p.add(leb);

		JButton addBankAccount=new JButton("ADD BANK ACCOUNT");
		addBankAccount.setBounds(200,245,200,30);
		addBankAccount.setFont(new Font("Ariel",Font.BOLD,15));
		addBankAccount.setForeground(Color.BLACK);
		addBankAccount.setBackground(Color.WHITE);
		addBankAccount.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(addBankAccount);
		addBankAccount.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay";
					Statement pr=con.createStatement();
					ResultSet r=pr.executeQuery(q);
					int pointon=0;
					while(r.next())
					{
						if((r.getString(1).equalsIgnoreCase(mobile)) && (r.getString(5)==null))
						{
							pointon=1;
							cl.show(cont,"4");
							tim.start();
						}
					}
					if(pointon==0)
					{
						
						leb.setVisible(true);
						watch=3;
						tk=new Timer(1000,new ActionListener(){
							
							public void actionPerformed(ActionEvent e)
							{
								if(watch==0)
								{
									leb.setVisible(false);
									tk.stop();	
								}
								else
								{
									watch--;
								}
							}
						});
						tk.start();
					}
					con.close();

				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
			}
		});

		JTextArea lb3=new JTextArea();
		lb3.setBounds(0,322,599,27);
		lb3.setBackground(new Color(100,50,255));
		lb3.setForeground(Color.WHITE);
		lb3.setText("     Transfer Money");
		lb3.setFont(new Font("Ariel",Font.BOLD,18));
		lb3.setEditable(false);

		Icon i2=new ImageIcon("tocontact.png");
		JLabel ly1=new JLabel("TO CONTACT");
		ly1.setBounds(15,450,110,20);
		ly1.setFont(new Font("Ariel",Font.BOLD,15));
		ly1.setForeground(Color.BLACK);
		p.add(ly1);
		JButton by1=new JButton(i2);
		by1.setBounds(35,386,i2.getIconWidth(),i2.getIconHeight());
		by1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(by1);
		by1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("To contact");
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet r=pr.executeQuery();
					if(r.next())
					{
						if(r.getString(5)==null)
						{
							cl.show(cont,"14");
						}
						else
						{
							System.out.println("search account");
							cl.show(cont,"24");
						}
					}
					con.close();
				}
				catch(Exception ex)	
				{
					System.out.println(ex);
				}
			}
		});

		Icon i3=new ImageIcon("toaccount.png");
		JLabel lz1=new JLabel("TO ACCOUNT");
		lz1.setBounds(170,450,110,20);
		lz1.setFont(new Font("Ariel",Font.BOLD,15));
		lz1.setForeground(Color.BLACK);
		p.add(lz1);
		JButton bz1=new JButton(i3);
		bz1.setBounds(195,386,i3.getIconWidth(),i3.getIconHeight());
		bz1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(bz1);
		bz1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("To account");
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet r=pr.executeQuery();
					if(r.next())
					{
						if(r.getString(5)==null)
						{
							cl.show(cont,"14");
						}
						else
						{
							System.out.println("search account");
							cl.show(cont,"15");
						}
					}
					con.close();
				}
				catch(Exception ex)	
				{
					System.out.println(ex);
				}
			
			}
		});

		Icon i4=new ImageIcon("toself.png");
		JLabel lw1=new JLabel("TO WALLET");
		lw1.setBounds(330,450,110,20);
		lw1.setFont(new Font("Ariel",Font.BOLD,15));
		lw1.setForeground(Color.BLACK);
		p.add(lw1);
		JButton bw1=new JButton(i4);
		bw1.setBounds(342,389,i4.getIconWidth(),i4.getIconHeight());
		bw1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(bw1);
		bw1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("To Self");
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet r=pr.executeQuery();
					if(r.next())
					{
						if(r.getString(5)==null)
						{
							cl.show(cont,"14");
						}
						else if(r.getString(6)==null)
						{
							cl.show(cont,"11");
						}
						else
						{
							vision=3;
							try
							{
								Class.forName("com.mysql.cj.jdbc.Driver");
								Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
								String q1="select * from accountant where ph_no=?";
								PreparedStatement pr1=con1.prepareStatement(q1);
								pr1.setString(1,mobile);
								ResultSet r1=pr1.executeQuery();
								if(r1.next())
								{
									acc_info.setText("MyBank - XXXX"+r1.getString(1).substring(4,8));
								}
								con1.close();
							}
							catch(Exception expt)	
							{
								System.out.println(expt);
							}
							cl.show(cont,"16");
						}
					}
					con.close();
				}
				catch(Exception ex)	
				{
					System.out.println(ex);
				}
			}
		});

		Icon i1=new ImageIcon("bankbalance.png");
		JLabel lx1=new JLabel("BANK BALANCE");
		lx1.setBounds(460,450,150,20);
		lx1.setFont(new Font("Ariel",Font.BOLD,15));
		lx1.setForeground(Color.BLACK);
		p.add(lx1);
		JButton bx1=new JButton(i1);
		bx1.setBounds(490,389,i1.getIconWidth(),i1.getIconHeight());
		bx1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(bx1);
		bx1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try												
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet rs=pr.executeQuery();
					int pointer=0;
					while(rs.next())
					{
						if(rs.getString(1).equalsIgnoreCase(mobile) && rs.getString(5)==null)
						{
							pointer=1;
							dynamicforcheckbal.setText("ADD BANK A/C TO MAKE TRANSACTIONS via. UPI");
							bknotexist.setVisible(true);
							bkexist.setVisible(false);
							break;
						}	

					}
					if(pointer==0)
					{
						dynamicforcheckbal.setText("BHIM UPI BANK ACCOUNT");
						bknotexist.setVisible(false);
						bkexist.setVisible(true);
						String acc_numb=null;
						try												
						{
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
							String q1="select * from accountant where ph_no=?";
							PreparedStatement prs=con1.prepareStatement(q1);
							prs.setString(1,mobile);
							ResultSet set=prs.executeQuery();
							if(set.next())
							{
								acc_numb=set.getString(1);
							}
							bkexist.setText("MyBank - XXXX"+acc_numb.substring(4,8));
							con1.close();
						}
						catch(Exception xx)
						{
							System.out.println(xx);
						}
						
					}
					con.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}					
				System.out.println("Fetching Account Balance");
				cl.show(cont,"8");
			}
		});

		Icon ico=new ImageIcon("userlogo.png");
		JButton but=new JButton(ico);
		but.setSize(ico.getIconWidth(),ico.getIconHeight());
		but.setLocation(10,20);
		but.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		p.add(but);
		but.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("user");
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet rs=pr.executeQuery();
					if(rs.next())
					{
						if(rs.getString(6)==null)
						{
							xxx.setVisible(true);
							parth1.setVisible(false);
							//parth2.setText("PAN CARD - "+rs.getString(6).substring(0,4)+" XXXX XXXX");
							parth2.setVisible(false);
						}
						else	
						{
							parth1.setVisible(true);
							parth2.setText("PAN CARD - "+rs.getString(6).substring(0,4)+" XXXX XXXX");
							parth2.setVisible(true);
							xxx.setVisible(false);
						}

						if(rs.getString(5)==null)
						{
							//nothing to do
						}
						else
						{
							parth3.setText(rs.getString(4));
						}
					}
					
					con.close();
				}
				catch(Exception ex)	
				{
					System.out.println(ex);
				}
				cl.show(cont,"23");
			}
		});
		
		ImageIcon ic1=new ImageIcon("symbol1.jpg");
		JLabel label1=new JLabel(ic1);
		label1.setBounds(250,130,ic1.getIconWidth(),ic1.getIconHeight());
		p.add(label1);

		p.add(lb3);
		p.add(lb2);

		JLabel lxyz1=new JLabel("SCAN & PAY");
		lxyz1.setBounds(27,592,110,20);
		lxyz1.setFont(new Font("Ariel",Font.BOLD,15));
		lxyz1.setForeground(Color.BLACK);
		p.add(lxyz1);
		Icon ixyz1=new ImageIcon("scanpay.png");
		JButton bxyz1=new JButton(ixyz1);
		bxyz1.setBounds(50,542,ixyz1.getIconWidth(),ixyz1.getIconHeight());
		bxyz1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bxyz1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet r=pr.executeQuery();
					if(r.next())
					{
						if(r.getString(5)==null)
						{
							cl.show(cont,"14");
						}
						else
						{
							cl.show(cont,"25");	
						}
					}
					con.close();
				}
				catch(Exception ex)	
				{
					System.out.println(ex);
				}
			}
		});
		p.add(bxyz1);

		JLabel lxyz2=new JLabel(" RECHARGE");
		lxyz2.setBounds(170,592,110,20);
		lxyz2.setFont(new Font("Ariel",Font.BOLD,15));
		lxyz2.setForeground(Color.BLACK);
		p.add(lxyz2);
		Icon ixyz2=new ImageIcon("cellphone.png");
		JButton bxyz2=new JButton(ixyz2);
		bxyz2.setBounds(195,535,ixyz2.getIconWidth(),ixyz2.getIconHeight());
		bxyz2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bxyz2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet r=pr.executeQuery();
					if(r.next())
					{
						if(r.getString(5)==null)
						{
							cl.show(cont,"14");
						}
						else
						{
							alexa=2;
							moboperator.setVisible(true);
							dishoperator.setVisible(false);
							dynamicbilling.setText("ENTER MOBILE NUMBER TO RECHARGE");
							cl.show(cont,"26");	
						}
					}
					con.close();
				}
				catch(Exception ex)	
				{
					System.out.println(ex);
				}
			}
		});
		p.add(bxyz2);

		JLabel lxyz3=new JLabel("    DTH");
		lxyz3.setBounds(330,592,110,20);
		lxyz3.setFont(new Font("Ariel",Font.BOLD,15));
		lxyz3.setForeground(Color.BLACK);
		p.add(lxyz3);
		Icon ixyz3=new ImageIcon("dish.png");
		JButton bxyz3=new JButton(ixyz3);
		bxyz3.setBounds(342,540,ixyz3.getIconWidth(),ixyz3.getIconHeight());
		bxyz3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bxyz3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet r=pr.executeQuery();
					if(r.next())
					{
						if(r.getString(5)==null)
						{
							cl.show(cont,"14");
						}
						else
						{
							alexa=3;
							dishoperator.setVisible(true);
							moboperator.setVisible(false);
							dynamicbilling.setText("ENTER CUSTOMER ID");
							cl.show(cont,"26");	
						}
					}
					con.close();
				}
				catch(Exception ex)	
				{
					System.out.println(ex);
				}
			}
		});
		p.add(bxyz3);

		JLabel lxyz4=new JLabel(" ELECTRICITY");
		lxyz4.setBounds(460,592,110,20);
		lxyz4.setFont(new Font("Ariel",Font.BOLD,15));
		lxyz4.setForeground(Color.BLACK);
		p.add(lxyz4);
		Icon ixyz4=new ImageIcon("electricity.png");
		JButton bxyz4=new JButton(ixyz4);
		bxyz4.setBounds(490,540,ixyz4.getIconWidth(),ixyz4.getIconHeight());
		bxyz4.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bxyz4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet r=pr.executeQuery();
					if(r.next())
					{
						if(r.getString(5)==null)
						{
							cl.show(cont,"14");
						}
						else
						{
							alexa=4;
							dishoperator.setVisible(false);
							moboperator.setVisible(false);
							dynamicbilling.setText("ENTER ELECTRICITY BILL CONSUMER NUMBER");
							cl.show(cont,"26");	
						}
					}
					con.close();
				}
				catch(Exception ex)	
				{
					System.out.println(ex);
				}
			}
		});
		p.add(bxyz4);

		JPanel jpanel1=new JPanel();
		jpanel1.setBounds(-5,361,610,130);
		jpanel1.setBackground(Color.WHITE);
		p.add(jpanel1);

		JPanel jpanel2=new JPanel();
		jpanel2.setBounds(-5,110,610,200);
		jpanel2.setBackground(Color.WHITE);
		p.add(jpanel2);

		JPanel jpanel3=new JPanel();
		jpanel3.setBounds(-5,506,610,130);
		jpanel3.setBackground(Color.WHITE);
		p.add(jpanel3);

		JPanel jpanel4=new JPanel();
		jpanel4.setBounds(10,651,570,130);
		jpanel4.setBackground(new Color(127,50,235));

		JLabel label13=new JLabel("KYC Is Completed");
		label13.setForeground(Color.WHITE);
		label13.setFont(new Font("southern",Font.BOLD,18));
		label13.setVisible(false);
		label13.setBounds(155,740,400,30);
		p.add(label13);

		ImageIcon mobic=new ImageIcon("handmob.png");
		JLabel mobleb=new JLabel(mobic);
		mobleb.setVisible(false);
		mobleb.setBounds(25,680,mobic.getIconWidth(),mobic.getIconHeight()-5);
		p.add(mobleb);

		JTextArea label15=new JTextArea("Make Payments Online, Maintain Social Distance,\n	    Stay Safe");
		label15.setForeground(Color.WHITE);
		label15.setEditable(false);
		label15.setBackground(new Color(77,50,235));
		label15.setBorder(BorderFactory.createLineBorder(new Color(77,50,235)));
		label15.setFont(new Font("southern",Font.BOLD,18));
		label15.setBounds(145,690,430,60);
		label15.setVisible(false);
		p.add(label15);
		
		Icon cust=new ImageIcon("kyccustomer.png");
		JButton complete=new JButton(cust);
		complete.setBounds(15,651,cust.getIconWidth(),cust.getIconHeight()-5);
		complete.setBackground(new Color(127,50,235));
		complete.setBorder(BorderFactory.createLineBorder(new Color(127,50,235)));
		complete.setVisible(true);
		complete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent eve)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet rs=pr.executeQuery();
					if(rs.next())
					{
						if(rs.getString(6)==null)
						{
							cl.show(cont,"11");
						}
						else	
						{
							label13.setVisible(true);
						}
					}
					
					con.close();
				}
				catch(Exception ex)	
				{
					System.out.println(ex);
				}
			}
		});
		p.add(complete);

		JLabel label11=new JLabel("Complete KYC To Activate MyPay-Wallet");
		label11.setForeground(Color.WHITE);
		label11.setFont(new Font("southern",Font.BOLD,18));
		label11.setBounds(155,700,400,30);
		p.add(label11);

		JLabel label12=new JLabel("Know Your Customer");
		label12.setForeground(Color.WHITE);
		label12.setFont(new Font("southern",Font.BOLD,23));
		label12.setBounds(155,660,400,30);
		p.add(label12);

		blinking_screen=new Timer(5000,new ActionListener(){
		
			int x=0;		

			public void actionPerformed(ActionEvent e)
			{
				x++;
				if(x==0)
				{
					complete.setVisible(true);
					label11.setVisible(true);
					label12.setVisible(true);
					mobleb.setVisible(false);
					label15.setVisible(false);
					jpanel4.setBackground(new Color(127,50,235));
				}
				else
				{
					complete.setVisible(false);
					label13.setVisible(false);	
					label11.setVisible(false);
					label12.setVisible(false);
					label15.setVisible(true);
					mobleb.setVisible(true);
					jpanel4.setBackground(new Color(77,50,235));
					x=-1;
				}

			}
		});
		p.add(jpanel4);

		JPanel jpanel5=new JPanel();
		jpanel5.setBounds(-5,796,610,150);
		jpanel5.setBackground(Color.WHITE);
		jpanel5.setLayout(null);

		JTextField toggle=new JTextField("                     Home Screen              Transaction History");
		toggle.setEditable(false);
		toggle.setBounds(0,900,600,30);
		//toggle.setHorizontalAlignment(JTextField.CENTER);
		toggle.setFont(new Font("Ariel",Font.BOLD,20));
		toggle.setBackground(Color.WHITE);
		toggle.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(toggle);
		
		Icon home=new ImageIcon("home.png");
		JButton jhome=new JButton(home);
		jhome.setBounds(110,810,home.getIconWidth(),home.getIconHeight());
		jhome.setBackground(Color.WHITE);
		jhome.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(jhome);

		Icon his=new ImageIcon("history.png");
		JButton jhis=new JButton(his);
		jhis.setBounds(320,811,his.getIconWidth(),his.getIconHeight());
		jhis.setBackground(Color.WHITE);
		jhis.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(jhis);
		jhis.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cl.show(cont,"20");
				
				strtoset="";
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conection2=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String query2="select * from mypay_transaction where ph_no=?";
					PreparedStatement prep2=conection2.prepareStatement(query2,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					prep2.setString(1,mobile);
					ResultSet set1=prep2.executeQuery();
					//set1.afterLast();
					while(set1.next())
					{
						strtoset=strtoset+" "+set1.getString(2)+"\n "+set1.getString(3)+"\n\n";
					}
					conection2.close();
				}
				catch(Exception excep)
				{
					System.out.println(excep);
				}

				area.setText(strtoset);
		
			}
		});

		ImageIcon homehis=new ImageIcon("homehis.png");
		JLabel jhomehis=new JLabel(homehis);
		jhomehis.setBounds(272,836,homehis.getIconWidth(),homehis.getIconHeight());
		p.add(jhomehis);

		p.add(jpanel5);

	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTobankdetails(JPanel p)				//********************* SETTING FETCHING BANK DETAILS ***********************//
	{
		JTextArea lb2=new JTextArea("\n	ADDING BANK ACCOUNT");
		lb2.setBounds(0,1,599,100);
		lb2.setBackground(new Color(100,50,255));
		lb2.setForeground(Color.WHITE);
		lb2.setFont(new Font("Ariel",Font.BOLD,25));
		lb2.setEditable(false);

		JLabel l1=new JLabel(" FETCHING YOUR BANK DETAILS.....");
		l1.setBounds(30,400,540,50);
		l1.setFont(new Font("southern",Font.BOLD,30));
		l1.setForeground(new Color(100,50,255));
		p.add(l1);

		ImageIcon i=new ImageIcon("symbol2.jpg");
		JLabel l5=new JLabel(i);
		l5.setBounds(220,170,i.getIconWidth(),i.getIconHeight());
		p.add(l5);

		JLabel l2=new JLabel(" @ SECURED");
		l2.setBounds(200,300,200,50);
		l2.setFont(new Font("southern",Font.BOLD,30));
		l2.setForeground(Color.BLACK);
		p.add(l2);

		JTextArea ta=new JTextArea();
		ta.setBounds(10,400,580,100);
		ta.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		ta.setEditable(false);
		ta.setForeground(new Color(100,50,255));
		ta.setFont(new Font("southern",Font.BOLD,30));
		ta.setText(" BANK ACCOUNT FOUND ASSOCIATED \n              WITH PHONE NUMBER");
		ta.setVisible(false);
		p.add(ta);

		JButton proceed=new JButton("PROCEED");
		proceed.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		proceed.setBackground(new Color(100,50,255));
		proceed.setFont(new Font("southern",Font.BOLD,20));
		proceed.setForeground(Color.WHITE);
		proceed.setBounds(240,800,120,50);
		proceed.setVisible(false);
		p.add(proceed);
		proceed.addActionListener(new ActionListener(){						//what after clicking on proceed
			public void actionPerformed(ActionEvent ae)
			{
				proceed.setVisible(false);
				ta.setVisible(false);
				l1.setVisible(true);
				progress.setValue(0);
				cl.show(cont,"5");
			}
		});

		JTextArea tb=new JTextArea();
		tb.setBounds(10,400,580,100);
		tb.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		tb.setEditable(false);
		tb.setForeground(Color.BLACK);
		tb.setFont(new Font("southern",Font.BOLD,30));
		tb.setText(" NO BANK ACCOUNT IS LINKED WITH \n              GIVEN MOBILE NUMBER");
		tb.setVisible(false);
		p.add(tb);

		JButton cancel=new JButton("CANCEL");
		cancel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,20));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(240,800,120,50);
		cancel.setVisible(false);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						//what after clicking on CANCEL
			public void actionPerformed(ActionEvent ae)
			{
				cancel.setVisible(false);
				tb.setVisible(false);
				l1.setVisible(true);
				progress.setValue(0);
				cl.show(cont,"3");
			}
		});

		
		progress=new JProgressBar(0,100);
		progress.setBounds(0,900,600,30);
		progress.setBackground(Color.WHITE);
		progress.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		progress.setForeground(new Color(100,50,255));
		p.add(progress);

		tim=new Timer(100,new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				int x=progress.getValue();
				if(x==100)					//fetching completed
				{
					tim.stop();
					try
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
						String q="SELECT * FROM accountant WHERE ph_no=?";
						PreparedStatement st=con.prepareStatement(q);
						st.setString(1,mobile);
						ResultSet set=st.executeQuery();
						if(set.next())
						{
							proceed.setVisible(true);
							ta.setVisible(true);
							l1.setVisible(false);
							atm_num=set.getString(11);
						}
						else
						{
							cancel.setVisible(true);
							tb.setVisible(true);
							l1.setVisible(false);
						}
						con.close();
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
				}
				else
				{
					progress.setValue(x+7);
				}
			}

		});
		
		JButton back=new JButton("<<<");
		back.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		back.setBackground(new Color(100,50,255));
		back.setFont(new Font("southern",Font.BOLD,38));
		back.setForeground(Color.WHITE);
		back.setBounds(10,25,120,50);
		p.add(back);
		back.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
				proceed.setVisible(false);
				ta.setVisible(false);
				l1.setVisible(true);
				tb.setVisible(false);
				progress.setValue(0);
				cl.show(cont,"3");
			}
		});

		
		p.add(lb2);

	}


/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTocard(JPanel p)				//********************* SETTING FILL CARD DETAIL ***********************//
	{
		JTextField txtf=new JTextField();
		txtf.setBounds(100,200,400,50);
		txtf.setFont(new Font("Ariel",Font.BOLD,30));
		txtf.setHorizontalAlignment(JTextField.CENTER);
		txtf.setEditable(false);
		txtf.setBackground(Color.WHITE);
		p.add(txtf);

		JPanel winu=new JPanel();
		winu.setLayout(null);
		winu.setBounds(0,1,599,50);
		winu.setBackground(new Color(100,50,255));
		p.add(winu);

		JLabel lb1=new JLabel("MyBANK ATM-CARD");
		lb1.setBounds(100,120,400,30);
		lb1.setFont(new Font("Ariel",Font.BOLD,20));
		p.add(lb1);

		JLabel lb2=new JLabel("ENTER ATM-CARD NUMBER");
		lb2.setBounds(100,175,400,30);
		lb2.setFont(new Font("Ariel",Font.BOLD,12));
		p.add(lb2);

		/********** Adding Buttons *********/

		JPanel px=new JPanel();
		//p.setLocation(450,80);
		px.setBounds(30,400,540,500);
		GridLayout gr=new GridLayout(4,3);
		px.setLayout(gr);
		gr.setVgap(10);
		gr.setHgap(10);
		px.setBackground(Color.WHITE);
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
		JButton bcl=new JButton("X");
		JButton b0=new JButton("0");
		JButton ben=new JButton(">>>>");

		bcl.setBackground(Color.WHITE);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(Color.WHITE);
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

		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b0.setBackground(Color.WHITE);

		px.add(b1);
		px.add(b2);
		px.add(b3);
		px.add(b4);
		px.add(b5);
		px.add(b6);
		px.add(b7);
		px.add(b8);
		px.add(b9);
		px.add(bcl);
		px.add(b0);
		px.add(ben);

		/******* IMPLIMENTING BUTTONS *********/

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"0");
			}	
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText("");
			}	
		});

		JLabel warn=new JLabel("*INCORRECT ATM-CARD NUMBER");
		warn.setBounds(100,260,400,30);
		warn.setFont(new Font("Ariel",Font.BOLD,12));
		warn.setForeground(Color.RED);
		warn.setVisible(false);
		p.add(warn);

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String get=txtf.getText();
				if(get.equalsIgnoreCase(atm_num))
				{
					warn.setVisible(false);
					txtf.setText("");	
					cl.show(cont,"6");
				}
				else	
				{
					warn.setVisible(true);
					txtf.setText("");
				}

			}
		});

		JPanel bg=new JPanel();
		bg.setLayout(null);
		bg.setBounds(20,100,550,250);
		p.add(bg);

		p.add(px);
	}


/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTosetupi(JPanel p)				//********************* SETTING SET UPI ***********************//
	{
		JPasswordField txtf=new JPasswordField();
		txtf.setBounds(100,170,400,80);
		txtf.setFont(new Font("Ariel",Font.BOLD,50));
		txtf.setHorizontalAlignment(JTextField.CENTER);
		txtf.setEditable(false);
		char pass=txtf.getEchoChar();
		txtf.setBackground(Color.WHITE);
		p.add(txtf);

		JPanel winu=new JPanel();
		winu.setLayout(null);
		winu.setBounds(0,1,599,50);
		winu.setBackground(new Color(100,50,255));
		p.add(winu);

		JLabel lb1=new JLabel("CREATE 6 DIGIT UPI PIN");
		lb1.setBounds(100,120,400,30);
		lb1.setFont(new Font("Ariel",Font.BOLD,20));
		p.add(lb1);

		/********** Adding Buttons *********/

		JPanel px=new JPanel();
		//p.setLocation(450,80);
		px.setBounds(30,400,540,500);
		GridLayout gr=new GridLayout(4,3);
		px.setLayout(gr);
		gr.setVgap(10);
		gr.setHgap(10);
		px.setBackground(Color.WHITE);
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
		JButton bcl=new JButton("X");
		JButton b0=new JButton("0");
		JButton ben=new JButton(">>>>");

		bcl.setBackground(Color.WHITE);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(Color.WHITE);
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

		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b0.setBackground(Color.WHITE);

		px.add(b1);
		px.add(b2);
		px.add(b3);
		px.add(b4);
		px.add(b5);
		px.add(b6);
		px.add(b7);
		px.add(b8);
		px.add(b9);
		px.add(bcl);
		px.add(b0);
		px.add(ben);

		/******* IMPLIMENTING BUTTONS *********/

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"0");
			}	
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText("");
			}	
		});

		JLabel warn=new JLabel("*UPI PIN MUST BE OF 6 DIGIT");
		warn.setBounds(100,260,400,30);
		warn.setFont(new Font("Ariel",Font.BOLD,12));
		warn.setForeground(Color.RED);
		warn.setVisible(false);
		p.add(warn);

		JButton bshow=new JButton("SHOW");
		bshow.setBounds(530,180,50,25);
		bshow.setBackground(Color.WHITE);
		bshow.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bshow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setEchoChar((char)0);
			}
		});
		p.add(bshow);

		JButton bhide=new JButton("HIDE");
		bhide.setBounds(530,210,50,25);
		bhide.setBackground(Color.WHITE);
		bhide.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bhide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setEchoChar(pass);
			}
		});
		p.add(bhide);

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String get=txtf.getText();
				if(get.length()==6)
				{
					System.out.println("UPI PIN SETTED");
					try
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
						String q="UPDATE mypay SET upi_pin=?, upi_id=?, linked=? where phone_number=?";
						PreparedStatement pr=con.prepareStatement(q);
						pr.setString(1,get);
						pr.setString(2,mobile+"@mybnk");
						pr.setString(3,"YES");
						pr.setString(4,mobile);
						pr.executeUpdate();
						con.close();
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
					warn.setVisible(false);
					txtf.setText("");
					cl.show(cont,"7");	
				}
				else	
				{
					warn.setVisible(true);
					txtf.setText("");
				}
				txtf.setEchoChar(pass);

			}
		});

		p.add(px);
	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTolinked(JPanel p)				//********************* SETTING ACCOUNT LINKED ***********************//
	{
		JTextArea lb2=new JTextArea("\n	BANK ACCOUNT ADDED");
		lb2.setBounds(0,1,599,100);
		lb2.setBackground(new Color(100,50,255));
		lb2.setForeground(Color.WHITE);
		lb2.setFont(new Font("Ariel",Font.BOLD,25));
		lb2.setEditable(false);

		ImageIcon i=new ImageIcon("symbol2.jpg");
		JLabel l5=new JLabel(i);
		l5.setBounds(220,170,i.getIconWidth(),i.getIconHeight());
		p.add(l5);

		JLabel l2=new JLabel(" @ SECURED");
		l2.setBounds(200,300,200,50);
		l2.setFont(new Font("southern",Font.BOLD,30));
		l2.setForeground(Color.BLACK);
		p.add(l2);

		JTextArea ta=new JTextArea();
		ta.setBounds(10,400,580,150);
		ta.setLineWrap(true);
		ta.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		ta.setEditable(false);
		ta.setForeground(Color.BLACK);
		ta.setFont(new Font("southern",Font.BOLD,30));
		ta.setText(" BANK ACCOUNT IS ADDED TO MyPAY\n     NOW YOU CAN MAKE PAYMENT'S\n                     USING UPI-PIN");
		p.add(ta);

		JButton cancel=new JButton("OK");
		cancel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,20));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(240,800,120,50);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
				//cancel.setVisible(false);
				cl.show(cont,"3");
			}
		});

		
		JTextField prog=new JTextField();
		prog.setEditable(false);
		prog.setBounds(0,900,600,30);
		prog.setBackground(new Color(100,50,255));
		prog.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		prog.setForeground(new Color(100,50,255));
		p.add(prog);

		
		p.add(lb2);

	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTocheckbal(JPanel p)				//********************* SETTING CHECK BALANCE ***********************//
	{

		JPanel pane=new JPanel();
		pane.setBounds(0,1,599,100);
		pane.setBackground(new Color(100,50,255));

		JLabel cleb=new JLabel("CHECK BALANCE");
		cleb.setFont(new Font("Ariel",Font.BOLD,25));
		cleb.setForeground(Color.WHITE);
		cleb.setBounds(210,30,300,50);
		p.add(cleb);

		ImageIcon i=new ImageIcon("symbol2.jpg");
		JLabel l5=new JLabel(i);
		l5.setBounds(220,170,i.getIconWidth(),i.getIconHeight());
		p.add(l5);

		JLabel l2=new JLabel(" @ SECURED");
		l2.setBounds(200,300,200,50);
		l2.setFont(new Font("southern",Font.BOLD,30));
		l2.setForeground(Color.BLACK);
		p.add(l2);

		JPanel pk1=new JPanel();
		pk1.setBounds(10,390,570,120);
		pk1.setBackground(Color.WHITE);
		pk1.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		dynamicforcheckbal = new JLabel("BHIM UPI BANK ACCOUNT");
		dynamicforcheckbal.setBounds(20,410,580,30);
		dynamicforcheckbal.setFont(new Font("Ariel",Font.BOLD,18));
		dynamicforcheckbal.setForeground(Color.BLACK);
		p.add(dynamicforcheckbal);

		bkexist=new JButton("MyBank - XXXX0001");
		bkexist.setBounds(70,460,200,30);
		bkexist.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bkexist.setHorizontalTextPosition(SwingConstants.LEFT);
		bkexist.setBackground(Color.WHITE);
		bkexist.setFont(new Font("southern",Font.BOLD,16));
		bkexist.setForeground(Color.BLACK);
		bkexist.setVisible(false);
		bkexist.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cl.show(cont,"9");	
			}
		});
		p.add(bkexist);

		bknotexist=new JButton("Add Bank Account");
		bknotexist.setBounds(70,460,200,30);
		bknotexist.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bknotexist.setHorizontalTextPosition(SwingConstants.LEFT);
		bknotexist.setBackground(Color.WHITE);
		bknotexist.setFont(new Font("southern",Font.BOLD,16));
		bknotexist.setVisible(false);
		bknotexist.setForeground(Color.BLACK);
		bknotexist.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet r=pr.executeQuery();
					if(r.next())
					{
							cl.show(cont,"4");
							tim.start();
					}
					con.close();

				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
			}
		});
		p.add(bknotexist);

		JLabel wall=new JLabel("Wallet");
		wall.setBounds(20,550,580,30);
		wall.setFont(new Font("Ariel",Font.BOLD,18));
		wall.setForeground(Color.BLACK);
		p.add(wall);

		ImageIcon ic12=new ImageIcon("symbol3.png");
		JLabel sym=new JLabel(ic12);
		sym.setBounds(20,450,ic12.getIconWidth(),ic12.getIconHeight());
		p.add(sym);

		ImageIcon ic13=new ImageIcon("symbol4.png");
		JLabel sym1=new JLabel(ic13);
		sym1.setBounds(20,590,ic13.getIconWidth(),ic13.getIconHeight());
		p.add(sym1);

		JButton mywal=new JButton("MyPay Wallet");
		mywal.setBounds(70,600,170,30);
		mywal.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		mywal.setHorizontalTextPosition(SwingConstants.LEFT);
		mywal.setBackground(Color.WHITE);
		mywal.setFont(new Font("southern",Font.BOLD,16));
		mywal.setForeground(Color.BLACK);
		mywal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent eve)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet rs=pr.executeQuery();
					if(rs.next())
					{
						if(rs.getString(6)==null)
						{
							System.out.println("Complete kyc");
							cl.show(cont,"11");
						}
						else
						{
							System.out.println("show wallet");
							mypaymoney.setText(rs.getString(2));
							cl.show(cont,"13");
						}

					}
					con.close();

				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}

			}

		});
		p.add(mywal);
		
		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,38));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(10,25,120,50);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
				cl.show(cont,"3");
			}
		});

		
		JTextField prog=new JTextField();
		prog.setEditable(false);
		prog.setBounds(-2,900,610,30);
		prog.setBackground(new Color(100,50,255));
		prog.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		prog.setForeground(new Color(100,50,255));
		p.add(prog);

		JPanel pk2=new JPanel();
		pk2.setBounds(10,120,570,247);
		pk2.setBackground(Color.WHITE);
		pk2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(pk2);

		JPanel pk3=new JPanel();
		pk3.setBounds(10,530,570,120);
		pk3.setBackground(Color.WHITE);
		pk3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(pk3);

		p.add(pk1);
		p.add(pane);

	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTocheckupipin(JPanel p)				//********************* Check UPI PIN for fetching bank ***********************//
	{
		JPasswordField txtf=new JPasswordField();
		txtf.setBounds(100,170,400,80);
		txtf.setFont(new Font("Ariel",Font.BOLD,50));
		txtf.setHorizontalAlignment(JTextField.CENTER);
		txtf.setEditable(false);
		char pass=txtf.getEchoChar();
		txtf.setBackground(Color.WHITE);
		p.add(txtf);

		JPanel winu=new JPanel();
		winu.setLayout(null);
		winu.setBounds(0,1,599,50);
		winu.setBackground(new Color(100,50,255));

		JLabel lb1=new JLabel("ENTER UPI PIN");
		lb1.setBounds(100,120,400,30);
		lb1.setFont(new Font("Ariel",Font.BOLD,20));
		p.add(lb1);

		/********** Adding Buttons *********/

		JPanel px=new JPanel();
		//p.setLocation(450,80);
		px.setBounds(30,400,540,500);
		GridLayout gr=new GridLayout(4,3);
		px.setLayout(gr);
		gr.setVgap(10);
		gr.setHgap(10);
		px.setBackground(Color.WHITE);
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
		JButton bcl=new JButton("X");
		JButton b0=new JButton("0");
		JButton ben=new JButton(">>>>");

		bcl.setBackground(Color.WHITE);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(Color.WHITE);
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

		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b0.setBackground(Color.WHITE);

		px.add(b1);
		px.add(b2);
		px.add(b3);
		px.add(b4);
		px.add(b5);
		px.add(b6);
		px.add(b7);
		px.add(b8);
		px.add(b9);
		px.add(bcl);
		px.add(b0);
		px.add(ben);

		/******* IMPLIMENTING BUTTONS *********/

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"0");
			}	
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText("");
			}	
		});

		JLabel warn=new JLabel("*INCORRECT UPI PIN");
		warn.setBounds(100,260,400,30);
		warn.setFont(new Font("Ariel",Font.BOLD,12));
		warn.setForeground(Color.RED);
		warn.setVisible(false);
		p.add(warn);

		JButton bshow=new JButton("SHOW");
		bshow.setBounds(530,180,50,25);
		bshow.setBackground(Color.WHITE);
		bshow.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bshow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setEchoChar((char)0);
			}
		});
		p.add(bshow);

		JButton bhide=new JButton("HIDE");
		bhide.setBounds(530,210,50,25);
		bhide.setBackground(Color.WHITE);
		bhide.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bhide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setEchoChar(pass);
			}
		});
		p.add(bhide);

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String get=txtf.getText();
				String comp=null;
				try														
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet rs=pr.executeQuery();
					if(rs.next())
					{
						comp=rs.getString(3);
					}
					con.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}


				if(get.equalsIgnoreCase(comp))
				{
					System.out.println("UPI PIN MATCHED");
					warn.setVisible(false);
					txtf.setText("");
					cl.show(cont,"10");
					progress1.setValue(0);
					tim1.start();	
				}
				else	
				{
					warn.setVisible(true);
					txtf.setText("");
				}
				txtf.setEchoChar(pass);

			}
		});

		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,25));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(5,6,120,40);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
				cl.show(cont,"8");
				warn.setVisible(false);
				txtf.setText("");
			}
		});

		p.add(winu);
		p.add(px);
	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTogatheringbal(JPanel p)				//********************* GTHERING BALANCE ***********************//
	{

		JPanel pane=new JPanel();
		pane.setBounds(0,1,599,70);
		pane.setBackground(new Color(100,50,255));
		
		JLabel cleb=new JLabel("BANK BALANCE");
		cleb.setFont(new Font("Ariel",Font.BOLD,25));
		cleb.setForeground(Color.WHITE);
		//cleb.setVisible(false);
		cleb.setBounds(210,10,300,50);
		p.add(cleb);

		ImageIcon i=new ImageIcon("symbol5.png");
		JLabel l5=new JLabel(i);
		l5.setBounds(230,350,i.getIconWidth(),i.getIconHeight());
		l5.setVisible(false);
		p.add(l5);

		JLabel l4=new JLabel("     FETCHING BANK BALANCE.....");
		l4.setBounds(30,400,540,50);
		l4.setFont(new Font("southern",Font.BOLD,30));
		l4.setForeground(new Color(100,50,255));
		p.add(l4);

		JTextField l1=new JTextField("Account Balance Fetched Successfully");
		l1.setBounds(0,500,600,30);
		l1.setHorizontalAlignment(JTextField.CENTER);
		l1.setFont(new Font("southern",Font.BOLD,20));
		l1.setForeground(Color.BLACK);
		l1.setBackground(Color.WHITE);
		l1.setEditable(false);
		l1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		l1.setVisible(false);
		p.add(l1);

		JTextField l2=new JTextField("MyBank - XXXX0001");
		l2.setHorizontalAlignment(JTextField.CENTER);
		l2.setBounds(0,540,600,30);
		l2.setFont(new Font("southern",Font.BOLD,20));
		l2.setBackground(Color.WHITE);
		l2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		l2.setForeground(Color.BLACK);
		l2.setEditable(false);
		l2.setVisible(false);
		p.add(l2);

		JTextField l3=new JTextField("Rs. 50000");
		l3.setHorizontalAlignment(JTextField.CENTER);
		l3.setBounds(0,580,600,30);
		l3.setFont(new Font("southern",Font.BOLD,20));
		l3.setBackground(Color.WHITE);
		l3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		l3.setForeground(Color.BLACK);
		l3.setEditable(false);
		l3.setVisible(false);
		p.add(l3);

		progress1=new JProgressBar(0,100);
		progress1.setBounds(-1,900,602,30);
		progress1.setBackground(Color.WHITE);
		progress1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		progress1.setForeground(new Color(100,50,255));
		p.add(progress1);

		JButton bdone=new JButton("DONE");
		bdone.setBounds(265,840,70,30);
		bdone.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bdone.setBackground(Color.GREEN);
		bdone.setFont(new Font("southern",Font.BOLD,20));
		bdone.setForeground(Color.WHITE);
		bdone.setVisible(false);
		bdone.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cl.show(cont,"3");
				l1.setVisible(false);
				l2.setVisible(false);
				l3.setVisible(false);
				l5.setVisible(false);
				l4.setVisible(true);
				bdone.setVisible(false);
				pane.setBackground(new Color(100,50,255));
				progress1.setForeground(new Color(100,50,255));	
			}
		});
		p.add(bdone);


		tim1=new Timer(100,new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				int x=progress1.getValue();
				if(x==100)					//fetching completed
				{
					tim1.stop();
					try
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
						String q="SELECT * FROM accountant WHERE ph_no=?";
						PreparedStatement st=con.prepareStatement(q);
						st.setString(1,mobile);
						ResultSet set=st.executeQuery();
						if(set.next())
						{
							l3.setText("Rs. "+set.getString(4));
							l2.setText("MyBank - XXXX"+(set.getString(1)).substring(4,8));
							l1.setVisible(true);
							l2.setVisible(true);
							l3.setVisible(true);
							l4.setVisible(false);
							l5.setVisible(true);
							bdone.setVisible(true);
							pane.setBackground(Color.GREEN);
							progress1.setForeground(Color.GREEN);
						}
						con.close();
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
				}
				else
				{
					progress1.setValue(x+10);
				}
			}

		});

		
		p.add(pane);

	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTocompkyc(JPanel p)				//********************* Complete KYC ***********************//
	{
		JTextField txtf=new JTextField();
		txtf.setBounds(100,200,400,50);
		txtf.setFont(new Font("Ariel",Font.BOLD,30));
		txtf.setHorizontalAlignment(JTextField.CENTER);
		txtf.setEditable(false);
		txtf.setBackground(Color.WHITE);
		p.add(txtf);

		JLabel warn=new JLabel("*INCORRECT PAN-CARD NUMBER / PAN-CARD IS NOT LINKED WITH BANK A/C");
		warn.setBounds(100,260,600,30);
		warn.setFont(new Font("Ariel",Font.BOLD,12));
		warn.setForeground(Color.RED);
		warn.setVisible(false);
		p.add(warn);

		JLabel info=new JLabel("                      Complete KYC To Activate MyPay Wallet");
		info.setBounds(0,1,599,50);
		info.setForeground(Color.WHITE);
		info.setFont(new Font("Ariel",Font.BOLD,20));
		p.add(info);

		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,25));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(10,2,120,40);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
				//cl.show(cont,"8");
				cl.show(cont,"3");
				warn.setVisible(false);
				txtf.setText("");
			}
		});

		JPanel winu=new JPanel();
		winu.setLayout(null);
		winu.setBounds(0,1,599,50);
		winu.setBackground(new Color(100,50,255));
		p.add(winu);

		JLabel lb1=new JLabel("PAN-CARD");
		lb1.setBounds(100,120,400,30);
		lb1.setFont(new Font("Ariel",Font.BOLD,20));
		p.add(lb1);

		JLabel lb2=new JLabel("ENTER PAN-CARD NUMBER");
		lb2.setBounds(100,175,400,30);
		lb2.setFont(new Font("Ariel",Font.BOLD,12));
		p.add(lb2);

		/********** Adding Buttons *********/

		JPanel px=new JPanel();
		//p.setLocation(450,80);
		px.setBounds(30,400,540,500);
		GridLayout gr=new GridLayout(4,3);
		px.setLayout(gr);
		gr.setVgap(10);
		gr.setHgap(10);
		px.setBackground(Color.WHITE);
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
		JButton bcl=new JButton("X");
		JButton b0=new JButton("0");
		JButton ben=new JButton(">>>>");

		bcl.setBackground(Color.WHITE);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(Color.WHITE);
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

		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b0.setBackground(Color.WHITE);

		px.add(b1);
		px.add(b2);
		px.add(b3);
		px.add(b4);
		px.add(b5);
		px.add(b6);
		px.add(b7);
		px.add(b8);
		px.add(b9);
		px.add(bcl);
		px.add(b0);
		px.add(ben);

		/******* IMPLIMENTING BUTTONS *********/

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"0");
			}	
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText("");
			}	
		});

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String get=txtf.getText();
				String pancard=null;
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="SELECT * FROM accountant WHERE ph_no=?";
					PreparedStatement st=con.prepareStatement(q);
					st.setString(1,mobile);
					ResultSet set=st.executeQuery();
					if(set.next())
					{
						pancard=set.getString(5);
						if(get.equalsIgnoreCase(pancard))
						{
							warn.setVisible(false);
							txtf.setText("");	
							cl.show(cont,"12");
							try
							{
								Class.forName("com.mysql.cj.jdbc.Driver");
								Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
								String q1="UPDATE mypay SET mypay_wallet=? , pan=? WHERE phone_number=?";
								PreparedStatement st1=con.prepareStatement(q1);
								st1.setString(1,"10");
								st1.setString(2,pancard);
								st1.setString(3,mobile);
								st1.executeUpdate();
								con1.close();
							}
							catch(Exception ep)
							{
								System.out.println(ep);
							}

							LocalDate ld=LocalDate.now();
							LocalTime lt=LocalTime.now();
							String ldt=ld+"  "+lt;

							try
							{
								Class.forName("com.mysql.cj.jdbc.Driver");
								Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
								String q1="INSERT INTO mypay_transaction VALUES (?,?,?)";
								PreparedStatement st1=con.prepareStatement(q1);
								st1.setString(1,mobile);
								st1.setString(2,ldt);
								st1.setString(3,"Rs. 10 Added To MyPay Wallet For Completing KYC");
								st1.executeUpdate();
								con1.close();
							}
							catch(Exception ep)
							{
								System.out.println(ep);
							}
						}
						else	
						{
							warn.setVisible(true);
							txtf.setText("");
						}
					}
					else
					{
						warn.setVisible(true);
						txtf.setText("");
					}
					con.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});

		JPanel bg=new JPanel();
		bg.setLayout(null);
		bg.setBounds(20,100,550,250);
		p.add(bg);

		p.add(px);
	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addToactivewal(JPanel p)				//********************* Wallet Activated ***********************//
	{
		JPanel pane=new JPanel();
		pane.setBounds(0,1,599,70);
		pane.setBackground(new Color(100,50,255));

		ImageIcon img=new ImageIcon("wallet.png");
		JLabel l1=new JLabel(img);
		l1.setBounds(210,400,img.getIconWidth(),img.getIconHeight());
		p.add(l1);

		ImageIcon i=new ImageIcon("symbol2.jpg");
		JLabel l5=new JLabel(i);
		l5.setBounds(220,100,i.getIconWidth(),i.getIconHeight());
		p.add(l5);

		JLabel l4=new JLabel(" @ SECURED");
		l4.setBounds(200,230,200,50);
		l4.setFont(new Font("southern",Font.BOLD,30));
		l4.setForeground(Color.BLACK);
		p.add(l4);

		JButton bdone=new JButton("DONE");
		bdone.setBounds(240,830,120,50);
		bdone.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bdone.setBackground(new Color(100,50,255));
		bdone.setFont(new Font("southern",Font.BOLD,20));
		bdone.setForeground(Color.WHITE);
		bdone.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cl.show(cont,"3");
			}
		});
		p.add(bdone);

		JTextField l2=new JTextField("Your MyPay Wallet Is Activated");
		l2.setBounds(0,320,600,50);
		l2.setFont(new Font("Ariel",Font.BOLD,25));
		l2.setEditable(false);
		l2.setForeground(Color.BLACK);
		l2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		l2.setHorizontalAlignment(JTextField.CENTER);
		l2.setBackground(Color.WHITE);
		p.add(l2);

		JTextField l3=new JTextField("You Can Make Payments Using MyPay Wallet");
		l3.setBounds(0,550,600,50);
		l3.setFont(new Font("Ariel",Font.BOLD,25));
		l3.setForeground(Color.BLACK);
		l3.setEditable(false);
		l3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		l3.setHorizontalAlignment(JTextField.CENTER);
		l3.setBackground(Color.WHITE);
		p.add(l3);

		JTextField prog=new JTextField();
		prog.setEditable(false);
		prog.setBounds(-2,900,610,30);
		prog.setBackground(new Color(100,50,255));
		prog.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		prog.setForeground(new Color(100,50,255));
		p.add(prog);
		
		p.add(pane);
	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addToshowwallet(JPanel p)				//********************* Show wallet balance ***********************//
	{

		JPanel pane=new JPanel();
		pane.setBounds(0,1,599,100);
		pane.setBackground(new Color(100,50,255));

		JLabel cleb=new JLabel("MyPay Wallet");
		cleb.setFont(new Font("Ariel",Font.BOLD,25));
		cleb.setForeground(Color.WHITE);
		cleb.setBounds(210,30,300,50);
		p.add(cleb);

		ImageIcon i=new ImageIcon("symbol2.jpg");
		JLabel l5=new JLabel(i);
		l5.setBounds(220,170,i.getIconWidth(),i.getIconHeight());
		p.add(l5);

		JLabel l2=new JLabel(" @ SECURED");
		l2.setBounds(200,300,200,50);
		l2.setFont(new Font("southern",Font.BOLD,30));
		l2.setForeground(Color.BLACK);
		p.add(l2);

		JPanel pk1=new JPanel();
		pk1.setBounds(10,390,570,120);
		pk1.setBackground(Color.WHITE);
		pk1.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		JLabel wall=new JLabel("MyPay Balance");
		wall.setBounds(20,410,580,30);
		wall.setFont(new Font("Ariel",Font.BOLD,18));
		wall.setForeground(Color.BLACK);
		p.add(wall);

		mypaymoney=new JLabel();
		mypaymoney.setBounds(140,455,400,30);
		mypaymoney.setFont(new Font("Ariel",Font.BOLD,18));
		mypaymoney.setForeground(Color.BLACK);
		p.add(mypaymoney);

		JLabel wallbal=new JLabel(" Rs. ");
		wallbal.setBounds(100,455,400,30);
		wallbal.setFont(new Font("Ariel",Font.BOLD,18));
		wallbal.setForeground(Color.BLACK);
		p.add(wallbal);

		ImageIcon ic13=new ImageIcon("symbol4.png");
		JLabel sym1=new JLabel(ic13);
		sym1.setBounds(20,450,ic13.getIconWidth(),ic13.getIconHeight());
		p.add(sym1);
		
		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,38));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(10,25,120,50);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
				cl.show(cont,"3");
			}
		});

		
		JTextField prog=new JTextField();
		prog.setEditable(false);
		prog.setBounds(-2,900,610,30);
		prog.setBackground(new Color(100,50,255));
		prog.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		prog.setForeground(new Color(100,50,255));
		p.add(prog);

		JPanel pk2=new JPanel();
		pk2.setBounds(10,120,570,247);
		pk2.setBackground(Color.WHITE);
		pk2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(pk2);

		/*JPanel pk3=new JPanel();
		pk3.setBounds(10,530,570,120);
		pk3.setBackground(Color.WHITE);
		pk3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(pk3);*/

		p.add(pk1);
		p.add(pane);

	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTonotaddedyet(JPanel p)				//********************* BANK ACCOUNT IS NOT ADDED YET ***********************//
	{

		JPanel pane=new JPanel();
		pane.setBounds(0,1,599,100);
		pane.setBackground(new Color(100,50,255));

		JLabel cleb=new JLabel("Bank Account Is Not Added Yet");
		cleb.setFont(new Font("Ariel",Font.BOLD,20));
		cleb.setForeground(Color.WHITE);
		cleb.setBounds(180,30,500,50);
		p.add(cleb);

		ImageIcon i=new ImageIcon("symbol2.jpg");
		JLabel l5=new JLabel(i);
		l5.setBounds(220,170,i.getIconWidth(),i.getIconHeight());
		p.add(l5);

		JLabel l2=new JLabel(" @ SECURED");
		l2.setBounds(200,300,200,50);
		l2.setFont(new Font("southern",Font.BOLD,30));
		l2.setForeground(Color.BLACK);
		p.add(l2);

		JPanel pk1=new JPanel();
		pk1.setBounds(10,390,570,120);
		pk1.setBackground(Color.WHITE);
		pk1.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		JButton notexist=new JButton("Add Bank Account");
		notexist.setBounds(70,460,200,30);
		notexist.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		notexist.setHorizontalTextPosition(SwingConstants.LEFT);
		notexist.setBackground(Color.WHITE);
		notexist.setFont(new Font("southern",Font.BOLD,16));
		notexist.setForeground(Color.BLACK);
		notexist.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet r=pr.executeQuery();
					if(r.next())
					{
							cl.show(cont,"4");
							tim.start();
					}
					con.close();

				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
			}
		});
		p.add(notexist);

		ImageIcon ic12=new ImageIcon("symbol3.png");
		JLabel sym=new JLabel(ic12);
		sym.setBounds(20,450,ic12.getIconWidth(),ic12.getIconHeight());
		p.add(sym);

		JLabel checkbal = new JLabel("ADD BANK A/C TO MAKE TRANSACTIONS via. UPI");
		checkbal.setBounds(20,410,580,30);
		checkbal.setFont(new Font("Ariel",Font.BOLD,18));
		checkbal.setForeground(Color.BLACK);
		p.add(checkbal);
		
		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,38));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(10,25,120,50);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
				cl.show(cont,"3");
			}
		});

		
		JTextField prog=new JTextField();
		prog.setEditable(false);
		prog.setBounds(-2,900,610,30);
		prog.setBackground(new Color(100,50,255));
		prog.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		prog.setForeground(new Color(100,50,255));
		p.add(prog);

		JPanel pk2=new JPanel();
		pk2.setBounds(10,120,570,247);
		pk2.setBackground(Color.WHITE);
		pk2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(pk2);

		/*JPanel pk3=new JPanel();
		pk3.setBounds(10,530,570,120);
		pk3.setBackground(Color.WHITE);
		pk3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(pk3);*/

		p.add(pk1);
		p.add(pane);

	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTobktosearch(JPanel p)				//********************* Search bank account number ***********************//
	{
		JTextField txtf=new JTextField();
		txtf.setBounds(100,110,400,60);
		txtf.setFont(new Font("Ariel",Font.BOLD,40));
		txtf.setHorizontalAlignment(JTextField.CENTER);
		txtf.setEditable(false);
		txtf.setBackground(Color.WHITE);
		p.add(txtf);

		JTextArea txtf1=new JTextArea("Bank Account Found\nAccountant Name : Krishna Patil");
		txtf1.setBounds(100,270,400,60);
		txtf1.setFont(new Font("Ariel",Font.BOLD,18));
		//txtf1.setHorizontalAlignment(JTextField.CENTER);
		txtf1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		txtf1.setEditable(false);
		txtf1.setBackground(Color.WHITE);
		txtf1.setVisible(false);
		p.add(txtf1);

		JPanel winu=new JPanel();
		winu.setLayout(null);
		winu.setBounds(0,1,599,50);
		winu.setBackground(new Color(100,50,255));

		JLabel lb1=new JLabel("ENTER ACCOUNT NUMBER TO SEND MONEY");
		lb1.setBounds(100,70,500,30);
		lb1.setFont(new Font("Ariel",Font.BOLD,15));
		p.add(lb1);

		/********** Adding Buttons *********/

		JPanel px=new JPanel();
		//p.setLocation(450,80);
		px.setBounds(30,400,540,500);
		GridLayout gr=new GridLayout(4,3);
		px.setLayout(gr);
		gr.setVgap(10);
		gr.setHgap(10);
		px.setBackground(Color.WHITE);
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
		JButton bcl=new JButton("X");
		JButton b0=new JButton("0");
		JButton ben=new JButton("PROCEED");

		bcl.setBackground(Color.WHITE);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(new Color(100,50,255));
		ben.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setForeground(Color.WHITE);
		ben.setVisible(false);
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

		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b0.setBackground(Color.WHITE);

		px.add(b1);
		px.add(b2);
		px.add(b3);
		px.add(b4);
		px.add(b5);
		px.add(b6);
		px.add(b7);
		px.add(b8);
		px.add(b9);
		px.add(bcl);
		px.add(b0);
		px.add(ben);

		/******* IMPLIMENTING BUTTONS *********/

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"0");
			}	
		});

		JTextField warn=new JTextField("*NO SUCH ACCOUNT EXIST!!!");
		warn.setBounds(0,270,600,30);
		warn.setFont(new Font("Ariel",Font.BOLD,15));
		warn.setForeground(Color.RED);
		warn.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		warn.setVisible(false);
		warn.setHorizontalAlignment(JTextField.CENTER);
		warn.setEditable(false);
		warn.setBackground(Color.WHITE);
		p.add(warn);

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cl.show(cont,"16");	
				ben.setVisible(false);
				warn.setVisible(false);
				txtf1.setVisible(false);
				vision=2;

				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from accountant where ph_no=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet rs=pr.executeQuery();
					if(rs.next())
					{
						acc_info.setText("MyBank - XXXX"+rs.getString(1).substring(4,8));
					}
					con.close();

				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}

				txtf.setText("");	
				heading.setText("Transfering To "+ reciever_nm);
			}
		});

		JLabel cleb=new JLabel("SEARCH BANK ACCOUNT");
		cleb.setFont(new Font("Ariel",Font.BOLD,20));
		cleb.setForeground(Color.WHITE);
		cleb.setBounds(200,10,300,40);
		p.add(cleb);

		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,38));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(10,5,120,45);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
				txtf.setText("");
				txtf1.setVisible(false);
				warn.setVisible(false);
				ben.setVisible(false);
				cl.show(cont,"3");
			}
		});

		JButton search=new JButton("SEARCH");
		search.setBounds(240,190,120,30);
		search.setForeground(Color.WHITE);
		search.setBackground(new Color(100,50,255));
		search.setFont(new Font("Ariel",Font.BOLD,18));
		search.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{															//#########################################
				try														//#########################################
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from accountant where account_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,txtf.getText());
					ResultSet rs=pr.executeQuery();
					if(rs.next())
					{
						ben.setVisible(true);
						txtf1.setVisible(true);
						txtf1.setText("Bank Account Found\nAccountant Name : "+rs.getString(3));
						reciever_nm=rs.getString(3);
						reciever_mob=rs.getString(2);
						System.out.println(reciever_nm);
						reciever_acc=txtf.getText();
					}
					else
					{
						warn.setVisible(true);
						txtf.setText("");
					}					

					con.close();

				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText("");
				txtf1.setVisible(false);
				warn.setVisible(false);
				ben.setVisible(false);
			}	
		});
		p.add(search);

		p.add(winu);
		p.add(px);
	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTobhimchk(JPanel p)				//********************* Check bhim upi for money transfer ***********************//
	{
		JPasswordField txtf=new JPasswordField();
		txtf.setBounds(100,170,400,80);
		txtf.setFont(new Font("Ariel",Font.BOLD,50));
		txtf.setHorizontalAlignment(JTextField.CENTER);
		txtf.setEditable(false);
		char pass=txtf.getEchoChar();
		txtf.setBackground(Color.WHITE);
		p.add(txtf);

		JPanel winu=new JPanel();
		winu.setLayout(null);
		winu.setBounds(0,1,599,50);
		winu.setBackground(new Color(100,50,255));

		heading=new JLabel();
		heading.setFont(new Font("Ariel",Font.BOLD,20));
		heading.setForeground(Color.WHITE);
		heading.setBounds(180,10,420,40);
		p.add(heading);


		JLabel lb1=new JLabel("ENTER UPI PIN");
		lb1.setBounds(100,120,400,30);
		lb1.setFont(new Font("Ariel",Font.BOLD,20));
		p.add(lb1);

		/********** Adding Buttons *********/

		JPanel px=new JPanel();
		//p.setLocation(450,80);
		px.setBounds(30,400,540,500);
		GridLayout gr=new GridLayout(4,3);
		px.setLayout(gr);
		gr.setVgap(10);
		gr.setHgap(10);
		px.setBackground(Color.WHITE);
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
		JButton bcl=new JButton("X");
		JButton b0=new JButton("0");
		JButton ben=new JButton(">>>>");

		bcl.setBackground(Color.WHITE);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(Color.WHITE);
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

		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b0.setBackground(Color.WHITE);

		px.add(b1);
		px.add(b2);
		px.add(b3);
		px.add(b4);
		px.add(b5);
		px.add(b6);
		px.add(b7);
		px.add(b8);
		px.add(b9);
		px.add(bcl);
		px.add(b0);
		px.add(ben);

		/******* IMPLIMENTING BUTTONS *********/

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"0");
			}	
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText("");
			}	
		});

		JLabel warn=new JLabel("*INCORRECT UPI PIN");
		warn.setBounds(100,260,400,30);
		warn.setFont(new Font("Ariel",Font.BOLD,12));
		warn.setForeground(Color.RED);
		warn.setVisible(false);
		p.add(warn);

		JButton bshow=new JButton("SHOW");
		bshow.setBounds(530,180,50,25);
		bshow.setBackground(Color.WHITE);
		bshow.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bshow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setEchoChar((char)0);
			}
		});
		p.add(bshow);

		JButton bhide=new JButton("HIDE");
		bhide.setBounds(530,210,50,25);
		bhide.setBackground(Color.WHITE);
		bhide.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bhide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setEchoChar(pass);
			}
		});
		p.add(bhide);

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String get=txtf.getText();
				String comp=null;
				try														
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet rs=pr.executeQuery();
					if(rs.next())
					{
						comp=rs.getString(3);
					}
					con.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}


				if(get.equalsIgnoreCase(comp))					
				{
					System.out.println("UPI PIN MATCHED");
					warn.setVisible(false);
					txtf.setText("");
					System.out.println(recheckbal);
					try														
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
						String q2="select * from accountant where ph_no=?";
						PreparedStatement pr2=con.prepareStatement(q2);
						pr2.setString(1,mobile);
						ResultSet rs2=pr2.executeQuery();
						if(rs2.next())
						{
							if(Long.parseLong(rs2.getString(4))<Long.parseLong(recheckbal))
							{
								cl.show(cont,"19");
							}	
							else
							{
								cl.show(cont,"18");
								fund1.setText("Transaction ID : "+CreateOTP.genAtmNumber());
								fund2.setText("Transfered To : XXXX"+reciever_acc.substring(4,8));
								fund3.setText("Amount Rs. "+recheckbal);
								fund4.setText("Recieved By : "+reciever_nm);
		//_________________________________________________________________________________________________________________________________________________________________
								
							
								try														
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection conection1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String query1="update accountant set balance=? where ph_no=?";
									PreparedStatement prep1=conection1.prepareStatement(query1);
									prep1.setString(1,""+(Long.parseLong(rs2.getString(4))-Long.parseLong(recheckbal)));
									prep1.setString(2,mobile);
									prep1.executeUpdate();
									conection1.close();
								}
								catch(Exception exep)
								{
									System.out.println(exep);
								}


		//_________________________________________________________________________________________________________________________________________________________________-
				//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ADDING TRANSACTION DETAILS TO DATABASE @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

					
								LocalDate ld=LocalDate.now();
								LocalTime lt=LocalTime.now();
								String ldt=ld+"  "+lt;
								String myaccountnumber=null;
								String sendersname=mobile;
					
								try						//@@@@@@@@@@@@@@@ adding to senders transaction detail @@@@@@@@@@@@@
								{
									try
									{
										Class.forName("com.mysql.cj.jdbc.Driver");
										Connection coni=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
										String qi="select * from accountant where ph_no=?";
										PreparedStatement pri=coni.prepareStatement(qi);
										pri.setString(1,mobile);						
										ResultSet rsi=pri.executeQuery();
										if(rsi.next())
										{	myaccountnumber=rsi.getString(1);  sendersname=rsi.getString(3);	}
										coni.close();
									}
									catch(Exception except)
									{
										System.out.println(except);
									}
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection conx=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String qx="INSERT INTO transaction VALUES (?,?,?)";
									PreparedStatement prx=conx.prepareStatement(qx);
									prx.setString(1,myaccountnumber);						//add account number
									prx.setString(2,ldt);
									prx.setString(3,"Rs "+recheckbal+" is debited via. MyPay App");		//add withdrawl amount
									prx.executeUpdate();
									conx.close();
									System.out.println("Data Added");
								}
								catch(Exception exx)
								{
									System.out.println("Error");
									System.out.println(exx);
								}		

								try						//@@@@@@@@@@@@@@@ adding to recievers transaction detail @@@@@@@@@@@@@
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection cony=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String qy="INSERT INTO transaction VALUES (?,?,?)";
									PreparedStatement pry=cony.prepareStatement(qy);
									pry.setString(1,reciever_acc);						//add account number
									pry.setString(2,ldt);
									pry.setString(3,"Rs "+recheckbal+" is credited via. UPI");		//add withdrawl amount
									pry.executeUpdate();
									cony.close();
									System.out.println("Data Added");
								}
								catch(Exception exx1)
								{
									System.out.println("Error");
									System.out.println(exx1);
								}	

								try						//@@@@@@@@@@@@@@@ adding to recievers mypay_transaction detail @@@@@@@@@@@@@
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection concony=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String qqy="INSERT INTO mypay_transaction VALUES (?,?,?)";
									PreparedStatement prpy=concony.prepareStatement(qqy);
									prpy.setString(1,reciever_mob);						//add mobile number
									prpy.setString(2,ldt);
									prpy.setString(3,"Rs "+recheckbal+" Recieved From "+sendersname);		//add  amount
									prpy.executeUpdate();
									concony.close();
									System.out.println("Data Added");
								}
								catch(Exception exxy1)
								{
									System.out.println("Error");
									System.out.println(exxy1);
								}	

								try						//@@@@@@@@@@@@@@@ adding to senders mypay_transaction detail @@@@@@@@@@@@@
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection conconqy=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String qqqy="INSERT INTO mypay_transaction VALUES (?,?,?)";
									PreparedStatement prpqy=conconqy.prepareStatement(qqqy);
									prpqy.setString(1,mobile);						//add mobile number
									prpqy.setString(2,ldt);
									prpqy.setString(3,"Rs "+recheckbal+" Transfered To "+reciever_nm);		//add amount
									prpqy.executeUpdate();
									conconqy.close();
									System.out.println("Data Added");
								}
								catch(Exception exxqy1)
								{
									System.out.println("Error");
									System.out.println(exxqy1);
								}		
	

		//_________________________________________________________________________________________________________________________________________________________________
												
								long recivers_existing_bal=0;

								try														
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection conection3=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String query3="select * from accountant where account_number=?";
									PreparedStatement prep3=conection3.prepareStatement(query3);
									prep3.setString(1,reciever_acc);
									ResultSet rset=prep3.executeQuery();
									if(rset.next())
									{
										recivers_existing_bal=Long.parseLong(rset.getString(4));
									}
									conection3.close();
								}
								catch(Exception exep2)
								{
									System.out.println(exep2);
								}
							
								try														
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection conection2=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String query2="update accountant set balance=? where account_number=?";
									PreparedStatement prep2=conection2.prepareStatement(query2);
									prep2.setString(1,""+(recivers_existing_bal+Long.parseLong(recheckbal)));
									prep2.setString(2,reciever_acc);
									prep2.executeUpdate();
									conection2.close();
								}
								catch(Exception exep1)
								{
									System.out.println(exep1);
								}


		//_________________________________________________________________________________________________________________________________________________________________-
			
							}
						}
						con.close();
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
				}
				else	
				{
					warn.setVisible(true);
					txtf.setText("");
				}
				txtf.setEchoChar(pass);

			}
		});

		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,38));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(5,6,120,40);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
				cl.show(cont,"3");
				warn.setVisible(false);
				txtf.setText("");
			}
		});

		p.add(winu);
		p.add(px);
	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTobalchktotransfer(JPanel p)				//********************* CHECK BALANCE TO TRANSFER ***********************//
	{
		JTextField txtf=new JTextField();
		txtf.setBounds(100,170,400,80);
		txtf.setFont(new Font("Ariel",Font.BOLD,50));
		txtf.setHorizontalAlignment(JTextField.CENTER);
		txtf.setEditable(false);
		txtf.setForeground(Color.GREEN);
		txtf.setBackground(Color.WHITE);
		p.add(txtf);									//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ marked one @@@@@@@@@@@@@

		ImageIcon imgic=new ImageIcon("rupees.png");
		JLabel rupees=new JLabel(imgic);
		rupees.setBounds(45,180,imgic.getIconWidth(),imgic.getIconHeight());
		p.add(rupees);

		JPanel winu=new JPanel();
		winu.setLayout(null);
		winu.setBounds(0,1,599,50);
		winu.setBackground(new Color(100,50,255));

		JLabel warn=new JLabel("*Please Select The Bank Account");
		warn.setBounds(100,330,400,30);
		warn.setFont(new Font("Ariel",Font.BOLD,15));
		warn.setForeground(Color.RED);
		warn.setVisible(false);
		p.add(warn);

		JLabel head=new JLabel("SEND MONEY");
		head.setFont(new Font("Ariel",Font.BOLD,20));
		head.setForeground(Color.WHITE);
		head.setBounds(240,10,400,40);
		p.add(head);

		acc_info=new JRadioButton();
		acc_info.setBounds(100,280,400,50);
		acc_info.setSelected(false);
		acc_info.setFont(new Font("Ariel",Font.BOLD,18));
		acc_info.setBackground(Color.WHITE);
		p.add(acc_info);


		JLabel lb1=new JLabel("ENTER AMOUNT");
		lb1.setBounds(100,120,400,30);
		lb1.setFont(new Font("Ariel",Font.BOLD,20));
		p.add(lb1);

		/********** Adding Buttons *********/

		JPanel px=new JPanel();
		px.setBounds(30,400,540,500);
		GridLayout gr=new GridLayout(4,3);
		px.setLayout(gr);
		gr.setVgap(10);
		gr.setHgap(10);
		px.setBackground(Color.WHITE);
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
		JButton bcl=new JButton("X");
		JButton b0=new JButton("0");
		JButton ben=new JButton(">>>>");

		bcl.setBackground(Color.WHITE);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(Color.WHITE);
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

		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b0.setBackground(Color.WHITE);

		px.add(b1);
		px.add(b2);
		px.add(b3);
		px.add(b4);
		px.add(b5);
		px.add(b6);
		px.add(b7);
		px.add(b8);
		px.add(b9);
		px.add(bcl);
		px.add(b0);
		px.add(ben);

		/******* IMPLIMENTING BUTTONS *********/

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"0");
			}	
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText("");
			}	
		});

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(acc_info.isSelected())	
				{
					recheckbal=txtf.getText();
					if(recheckbal.equalsIgnoreCase("") || recheckbal==null)
					{
						recheckbal="0";
					}

					if(vision==2)
					{
						cl.show(cont,"17");
					}
					else if(vision==3)
					{
						System.out.println("for mywallet");
						cl.show(cont,"21");
					}
					txtf.setText("");
					acc_info.setSelected(false);
					warn.setVisible(false);
				}
				else
				{
					warn.setVisible(true);
				}
			}
		});

		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,38));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(5,6,120,40);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
					cl.show(cont,"3");
					txtf.setText("");
					warn.setVisible(false);
					acc_info.setSelected(false);
			}
		});

		p.add(winu);
		p.add(px);
	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTooutputfund(JPanel p)				//********************* Output fund for Success window ***********************//
	{

		JPanel pane=new JPanel();
		pane.setBounds(0,1,599,70);
		pane.setBackground(Color.YELLOW);
		
		JLabel cleb=new JLabel("TRANSACTION DETAIL");		
		cleb.setFont(new Font("Ariel",Font.BOLD,25));
		cleb.setForeground(Color.BLACK);
		cleb.setBounds(180,10,300,50);
		p.add(cleb);

		ImageIcon i=new ImageIcon("right1.png");
		JLabel l5=new JLabel(i);
		l5.setBounds(230,300,i.getIconWidth(),i.getIconHeight());
		l5.setVisible(true);
		p.add(l5);

		fund2=new JTextField("Transfered To : MyBank - XXXX0001");
		fund2.setHorizontalAlignment(JTextField.CENTER);
		fund2.setBounds(0,540,600,30);
		fund2.setFont(new Font("southern",Font.BOLD,20));
		fund2.setBackground(Color.WHITE);
		fund2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		fund2.setForeground(Color.BLACK);
		fund2.setEditable(false);
		fund2.setVisible(true);
		p.add(fund2);

		JTextField l4=new JTextField("Transaction Status : "+"Success");
		l4.setHorizontalAlignment(JTextField.CENTER);
		l4.setBounds(0,200,600,30);
		l4.setFont(new Font("southern",Font.BOLD,20));
		l4.setBackground(Color.WHITE);
		l4.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		l4.setForeground(Color.BLACK);
		l4.setEditable(false);
		l4.setVisible(true);
		p.add(l4);

		fund1=new JTextField("Transaction ID : "+CreateOTP.genAtmNumber());
		fund1.setHorizontalAlignment(JTextField.CENTER);
		fund1.setBounds(0,500,600,30);
		fund1.setFont(new Font("southern",Font.BOLD,20));
		fund1.setBackground(Color.WHITE);
		fund1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		fund1.setForeground(Color.BLACK);
		fund1.setEditable(false);
		fund1.setVisible(true);
		p.add(fund1);

		fund3=new JTextField();
		fund3.setHorizontalAlignment(JTextField.CENTER);
		fund3.setBounds(0,580,600,30);
		fund3.setFont(new Font("southern",Font.BOLD,20));
		fund3.setBackground(Color.WHITE);
		fund3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		fund3.setForeground(Color.BLACK);
		fund3.setEditable(false);
		fund3.setVisible(true);
		p.add(fund3);

		fund4=new JTextField("Rs. 50000");
		fund4.setHorizontalAlignment(JTextField.CENTER);
		fund4.setBounds(0,620,600,30);
		fund4.setFont(new Font("southern",Font.BOLD,20));
		fund4.setBackground(Color.WHITE);
		fund4.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		fund4.setForeground(Color.BLACK);
		fund4.setEditable(false);
		fund4.setVisible(true);
		p.add(fund4);

		JTextField prog=new JTextField();
		prog.setBounds(-1,900,602,30);
		prog.setBackground(Color.YELLOW);
		prog.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		prog.setForeground(Color.YELLOW);
		prog.setEditable(false);
		p.add(prog);

		JLabel sec=new JLabel("@SECURED");
		sec.setBounds(440,850,170,30);
		sec.setFont(new Font("southern",Font.BOLD,20));
		sec.setForeground(Color.BLACK);
		p.add(sec);

		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
		cancel.setBackground(Color.YELLOW);
		cancel.setFont(new Font("southern",Font.BOLD,38));
		cancel.setForeground(Color.BLACK);
		cancel.setBounds(5,12,120,40);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
					cl.show(cont,"3");
			}
		});


		p.add(pane);

	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTooutputfund1(JPanel p)				//********************* Output fund for failuer window ***********************//
	{

		JPanel pane=new JPanel();
		pane.setBounds(0,1,599,70);
		pane.setBackground(Color.RED);
		
		JLabel cleb=new JLabel("TRANSACTION DETAIL");		
		cleb.setFont(new Font("Ariel",Font.BOLD,25));
		cleb.setForeground(Color.BLACK);
		cleb.setBounds(180,10,300,50);
		p.add(cleb);

		ImageIcon i1=new ImageIcon("wrong1.png");
		JLabel l0=new JLabel(i1);
		l0.setBounds(230,300,i1.getIconWidth(),i1.getIconHeight());
		l0.setVisible(true);
		p.add(l0);

		JTextField l4=new JTextField("Transaction Status : "+"Failure");
		l4.setHorizontalAlignment(JTextField.CENTER);
		l4.setBounds(0,200,600,30);
		l4.setFont(new Font("southern",Font.BOLD,20));
		l4.setBackground(Color.WHITE);
		l4.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		l4.setForeground(Color.BLACK);
		l4.setEditable(false);
		l4.setVisible(true);
		p.add(l4);

		JTextField l7=new JTextField("Low Balance!!");
		l7.setHorizontalAlignment(JTextField.CENTER);
		l7.setBounds(0,500,600,30);
		l7.setFont(new Font("southern",Font.BOLD,20));
		l7.setBackground(Color.WHITE);
		l7.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		l7.setForeground(Color.BLACK);
		l7.setEditable(false);
		l7.setVisible(true);
		p.add(l7);

		JTextField l8=new JTextField("Failed To Transfer");
		l8.setHorizontalAlignment(JTextField.CENTER);
		l8.setBounds(0,540,600,30);
		l8.setFont(new Font("southern",Font.BOLD,20));
		l8.setBackground(Color.WHITE);
		l8.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		l8.setForeground(Color.BLACK);
		l8.setEditable(false);
		l8.setVisible(true);
		p.add(l8);

		JTextField l9=new JTextField("Request Declined");
		l9.setHorizontalAlignment(JTextField.CENTER);
		l9.setBounds(0,580,600,30);
		l9.setFont(new Font("southern",Font.BOLD,20));
		l9.setBackground(Color.WHITE);
		l9.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		l9.setForeground(Color.BLACK);
		l9.setEditable(false);
		l9.setVisible(true);
		p.add(l9);

		JTextField prog=new JTextField();
		prog.setBounds(-1,900,602,30);
		prog.setBackground(Color.RED);
		prog.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		prog.setForeground(Color.RED);
		prog.setEditable(false);
		p.add(prog);

		JLabel sec=new JLabel("@SECURED");
		sec.setBounds(440,850,170,30);
		sec.setFont(new Font("southern",Font.BOLD,20));
		sec.setForeground(Color.BLACK);
		p.add(sec);

		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(Color.RED));
		cancel.setBackground(Color.RED);
		cancel.setFont(new Font("southern",Font.BOLD,38));
		cancel.setForeground(Color.BLACK);
		cancel.setBounds(5,12,120,40);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
					cl.show(cont,"3");
			}
		});


		p.add(pane);

	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addToforhistory(JPanel p)					//*************** Adding panel for trans history **********************//
	{
		JTextArea lb2=new JTextArea();
		lb2.setBounds(0,1,599,100);
		lb2.setBackground(new Color(100,50,255));
		lb2.setForeground(Color.WHITE);
		lb2.setFont(new Font("Ariel",Font.BOLD,15));
		lb2.setEditable(false);

		dynamichis1=new JLabel("GUEST");
		dynamichis1.setBounds(80,40,170,30);
		dynamichis1.setForeground(Color.WHITE);
		dynamichis1.setFont(new Font("Ariel",Font.BOLD,20));
		p.add(dynamichis1);

		JButton logout=new JButton("@LOGOUT");
		logout.setBounds(450,40,150,30);
		logout.setFont(new Font("Ariel",Font.BOLD,18));
		logout.setForeground(Color.WHITE);
		logout.setBackground(new Color(100,50,255));
		logout.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		p.add(logout);
		logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				dynamic1.setText("GUEST");
				blinking_screen.stop();
				cl.show(cont,"1");	
			}
		});

		Icon ico=new ImageIcon("userlogo.png");
		JButton but=new JButton(ico);
		but.setSize(ico.getIconWidth(),ico.getIconHeight());
		but.setLocation(10,20);
		but.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		p.add(but);
		but.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet rs=pr.executeQuery();
					if(rs.next())
					{
						if(rs.getString(6)==null)
						{
							xxx.setVisible(true);
							parth1.setVisible(false);
							//parth2.setText("PAN CARD - "+rs.getString(6).substring(0,4)+"XXXXXXXX");
							parth2.setVisible(false);
						}
						else	
						{
							parth1.setVisible(true);
							parth2.setText("PAN CARD - "+rs.getString(6).substring(0,4)+"XXXXXXXX");
							parth2.setVisible(true);
							xxx.setVisible(false);
						}
						
						if(rs.getString(5)==null)
						{
							//nothing to do
						}
						else
						{
							parth3.setText(rs.getString(4));
						}

					}
					
					con.close();
				}
				catch(Exception ex)	
				{
					System.out.println(ex);
				}
				cl.show(cont,"23");
			}
		});
		
		p.add(lb2);

		JPanel jpanel2=new JPanel(new BorderLayout());
		jpanel2.setBounds(10,170,577,605);
		jpanel2.setBackground(Color.WHITE);
		
		JTextField togglehis=new JTextField("Transaction History");
		togglehis.setEditable(false);
		togglehis.setBounds(0,120,600,30);
		togglehis.setFont(new Font("Ariel",Font.BOLD,20));
		togglehis.setBackground(Color.WHITE);
		togglehis.setHorizontalAlignment(JTextField.CENTER);
		togglehis.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(togglehis);

		area=new JTextArea();
		area.setBackground(Color.WHITE);
		area.setLineWrap(true);	
		area.setEditable(false);
		area.setFont(new Font("southern",Font.PLAIN,18));
		JScrollPane sc=new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);		
		jpanel2.add(sc);

		JPanel jpanel5=new JPanel();
		jpanel5.setBounds(-5,796,610,150);
		jpanel5.setBackground(Color.WHITE);
		jpanel5.setLayout(null);

		JTextField toggle=new JTextField("                     Home Screen              Transaction History");
		toggle.setEditable(false);
		toggle.setBounds(0,900,600,30);
		toggle.setFont(new Font("Ariel",Font.BOLD,20));
		toggle.setBackground(Color.WHITE);
		toggle.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(toggle);
		
		Icon home=new ImageIcon("home.png");
		JButton jhome=new JButton(home);
		jhome.setBounds(110,810,home.getIconWidth(),home.getIconHeight());
		jhome.setBackground(Color.WHITE);
		jhome.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		jhome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cl.show(cont,"3");
			}
		});
		p.add(jhome);

		Icon his=new ImageIcon("history.png");
		JButton jhis=new JButton(his);
		jhis.setBounds(320,811,his.getIconWidth(),his.getIconHeight());
		jhis.setBackground(Color.WHITE);
		jhis.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		p.add(jhis);

		ImageIcon homehis=new ImageIcon("homehis.png");
		JLabel jhomehis=new JLabel(homehis);
		jhomehis.setBounds(272,836,homehis.getIconWidth(),homehis.getIconHeight());
		p.add(jhomehis);

		p.add(jpanel5);
		p.add(jpanel2);

	}


/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTotransfertomywallet(JPanel p)				//********************* Transfer to mypay wallet ***********************//
	{
		JPasswordField txtf=new JPasswordField();
		txtf.setBounds(100,170,400,80);
		txtf.setFont(new Font("Ariel",Font.BOLD,50));
		txtf.setHorizontalAlignment(JTextField.CENTER);
		txtf.setEditable(false);
		char pass=txtf.getEchoChar();
		txtf.setBackground(Color.WHITE);
		p.add(txtf);

		JPanel winu=new JPanel();
		winu.setLayout(null);
		winu.setBounds(0,1,599,50);
		winu.setBackground(new Color(100,50,255));

		JLabel head1=new JLabel("Top Up Wallet");
		head1.setFont(new Font("Ariel",Font.BOLD,20));
		head1.setForeground(Color.WHITE);
		head1.setBounds(230,10,420,40);
		p.add(head1);


		JLabel lb1=new JLabel("ENTER UPI PIN");
		lb1.setBounds(100,120,400,30);
		lb1.setFont(new Font("Ariel",Font.BOLD,20));
		p.add(lb1);

		/********** Adding Buttons *********/

		JPanel px=new JPanel();
		//p.setLocation(450,80);
		px.setBounds(30,400,540,500);
		GridLayout gr=new GridLayout(4,3);
		px.setLayout(gr);
		gr.setVgap(10);
		gr.setHgap(10);
		px.setBackground(Color.WHITE);
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
		JButton bcl=new JButton("X");
		JButton b0=new JButton("0");
		JButton ben=new JButton(">>>>");

		bcl.setBackground(Color.WHITE);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(Color.WHITE);
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

		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b0.setBackground(Color.WHITE);

		px.add(b1);
		px.add(b2);
		px.add(b3);
		px.add(b4);
		px.add(b5);
		px.add(b6);
		px.add(b7);
		px.add(b8);
		px.add(b9);
		px.add(bcl);
		px.add(b0);
		px.add(ben);

		/******* IMPLIMENTING BUTTONS *********/

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"0");
			}	
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText("");
			}	
		});

		JLabel warn=new JLabel("*INCORRECT UPI PIN");
		warn.setBounds(100,260,400,30);
		warn.setFont(new Font("Ariel",Font.BOLD,12));
		warn.setForeground(Color.RED);
		warn.setVisible(false);
		p.add(warn);

		JButton bshow=new JButton("SHOW");
		bshow.setBounds(530,180,50,25);
		bshow.setBackground(Color.WHITE);
		bshow.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bshow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setEchoChar((char)0);
			}
		});
		p.add(bshow);

		JButton bhide=new JButton("HIDE");
		bhide.setBounds(530,210,50,25);
		bhide.setBackground(Color.WHITE);
		bhide.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bhide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setEchoChar(pass);
			}
		});
		p.add(bhide);

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String get=txtf.getText();
				String comp=null;
				try														
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet rs=pr.executeQuery();
					if(rs.next())
					{
						comp=rs.getString(3);
					}
					con.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}


				if(get.equalsIgnoreCase(comp))					//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ work in progress @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
				{
					System.out.println("UPI PIN MATCHED");
					warn.setVisible(false);
					txtf.setText("");
					System.out.println(recheckbal);
					try														
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
						String q2="select * from accountant where ph_no=?";
						PreparedStatement pr2=con.prepareStatement(q2);
						pr2.setString(1,mobile);
						ResultSet rs2=pr2.executeQuery();
						if(rs2.next())
						{
							if(Long.parseLong(rs2.getString(4))<Long.parseLong(recheckbal))				// CHCEKING AVAIBLITY OF BALANCE
							{
								cl.show(cont,"19");
							}	
							else
							{
								cl.show(cont,"22");
								fundforwal.setText("Rs. "+recheckbal);
		//_________________________________________________________________________________________________________________________________________________________________
								
							
								try														
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection conection1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String query1="update accountant set balance=? where ph_no=?";
									PreparedStatement prep1=conection1.prepareStatement(query1);
									prep1.setString(1,""+(Long.parseLong(rs2.getString(4))-Long.parseLong(recheckbal)));
									prep1.setString(2,mobile);
									prep1.executeUpdate();
									conection1.close();
								}
								catch(Exception exep)
								{
									System.out.println(exep);
								}


								long oldbal=0;
								try
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection coni=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String qi="select * from mypay where phone_number=?";
									PreparedStatement pri=coni.prepareStatement(qi);
									pri.setString(1,mobile);						
									ResultSet rsi=pri.executeQuery();
									if(rsi.next())
									{	
										oldbal=Long.parseLong(rsi.getString(2));
									}
									coni.close();
								}
								catch(Exception except)
								{
									System.out.println(except);
								}

								try						//@@@@@@@@@@@@@@@ adding amount to senders mypay_wallet @@@@@@@@@@@@@
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection conection1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String query1="update mypay set mypay_wallet=? where phone_number=?";
									PreparedStatement prep1=conection1.prepareStatement(query1);
									prep1.setString(1,""+(oldbal+Long.parseLong(recheckbal)));
									prep1.setString(2,mobile);
									prep1.executeUpdate();
									conection1.close();
								}
								catch(Exception exxqy1)
								{
									System.out.println("Error");
									System.out.println(exxqy1);
								}	


		//_________________________________________________________________________________________________________________________________________________________________-
				//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ADDING TRANSACTION DETAILS TO DATABASE @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

					
								LocalDate ld=LocalDate.now();
								LocalTime lt=LocalTime.now();
								String ldt=ld+"  "+lt;
								String myaccountnumber=null;
								String sendersname=mobile;
					
								try						//@@@@@@@@@@@@@@@ adding to senders transaction detail @@@@@@@@@@@@@
								{
									try
									{
										Class.forName("com.mysql.cj.jdbc.Driver");
										Connection coni=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
										String qi="select * from accountant where ph_no=?";
										PreparedStatement pri=coni.prepareStatement(qi);
										pri.setString(1,mobile);						
										ResultSet rsi=pri.executeQuery();
										if(rsi.next())
										{	myaccountnumber=rsi.getString(1);  sendersname=rsi.getString(3);	}
										coni.close();
									}
									catch(Exception except)
									{
										System.out.println(except);
									}
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection conx=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String qx="INSERT INTO transaction VALUES (?,?,?)";
									PreparedStatement prx=conx.prepareStatement(qx);
									prx.setString(1,myaccountnumber);						//add account number
									prx.setString(2,ldt);
									prx.setString(3,"Rs "+recheckbal+" Is Transfered To MyPay App");		//add transferd amount
									prx.executeUpdate();
									conx.close();
									System.out.println("Data Added");
								}
								catch(Exception exx)
								{
									System.out.println("Error");
									System.out.println(exx);
								}


								try						//@@@@@@@@@@@@@@@ adding to senders mypay_transaction detail @@@@@@@@@@@@@
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection conconqy=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String qqqy="INSERT INTO mypay_transaction VALUES (?,?,?)";
									PreparedStatement prpqy=conconqy.prepareStatement(qqqy);
									prpqy.setString(1,mobile);						//add mobile number
									prpqy.setString(2,ldt);
									prpqy.setString(3,"Rs "+recheckbal+" Transfered To MyPay Wallet");		//add amount
									prpqy.executeUpdate();
									conconqy.close();
									System.out.println("Data Added");
								}
								catch(Exception exxqy1)
								{
									System.out.println("Error");
									System.out.println(exxqy1);
								}			

								try						//@@@@@@@@@@@@@@@ adding to recievers mypay_transaction detail @@@@@@@@@@@@@
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection concony=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String qqy="INSERT INTO mypay_transaction VALUES (?,?,?)";
									PreparedStatement prpy=concony.prepareStatement(qqy);
									prpy.setString(1,mobile);						//add mobile number
									prpy.setString(2,ldt);
									prpy.setString(3,"Wallet Is Topped Up With Rs "+recheckbal);		//add  amount
									prpy.executeUpdate();
									concony.close();
									System.out.println("Data Added");
								}
								catch(Exception exxy1)
								{
									System.out.println("Error");
									System.out.println(exxy1);
								}	
	

		//_________________________________________________________________________________________________________________________________________________________________
												
							}//end of else
						}
						con.close();
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
				}
				else	
				{
					warn.setVisible(true);
					txtf.setText("");
				}
				txtf.setEchoChar(pass);

			}
		});

		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,38));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(5,6,120,40);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
				cl.show(cont,"3");
				warn.setVisible(false);
				txtf.setText("");
			}
		});

		p.add(winu);
		p.add(px);
	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTowallettoppedup(JPanel p)				//********************* topup successfully ***********************//
	{

		JPanel pane=new JPanel();
		pane.setBounds(0,1,599,70);
		pane.setBackground(Color.GREEN);
		
		JLabel cleb=new JLabel("TRANSACTION DETAIL");		
		cleb.setFont(new Font("Ariel",Font.BOLD,25));
		cleb.setForeground(Color.BLACK);
		cleb.setBounds(180,10,300,50);
		p.add(cleb);

		ImageIcon i1=new ImageIcon("topup.png");
		JLabel l0=new JLabel(i1);
		l0.setBounds(230,300,i1.getIconWidth(),i1.getIconHeight());
		l0.setVisible(true);
		p.add(l0);

		JTextField l4=new JTextField("Transaction Status : "+"Success");
		l4.setHorizontalAlignment(JTextField.CENTER);
		l4.setBounds(0,200,600,30);
		l4.setFont(new Font("southern",Font.BOLD,20));
		l4.setBackground(Color.WHITE);
		l4.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		l4.setForeground(Color.BLACK);
		l4.setEditable(false);
		l4.setVisible(true);
		p.add(l4);

		JTextField l7=new JTextField("MyPay Wallet Is Topped Up With");
		l7.setHorizontalAlignment(JTextField.CENTER);
		l7.setBounds(0,500,600,30);
		l7.setFont(new Font("southern",Font.BOLD,20));
		l7.setBackground(Color.WHITE);
		l7.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		l7.setForeground(Color.BLACK);
		l7.setEditable(false);
		l7.setVisible(true);
		p.add(l7);

		fundforwal=new JTextField();
		fundforwal.setHorizontalAlignment(JTextField.CENTER);
		fundforwal.setBounds(0,540,600,30);
		fundforwal.setFont(new Font("southern",Font.BOLD,20));
		fundforwal.setBackground(Color.WHITE);
		fundforwal.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		fundforwal.setForeground(Color.BLACK);
		fundforwal.setEditable(false);
		fundforwal.setVisible(true);
		p.add(fundforwal);

		JTextField prog=new JTextField();
		prog.setBounds(-1,900,602,30);
		prog.setBackground(Color.GREEN);
		prog.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		prog.setForeground(Color.RED);
		prog.setEditable(false);
		p.add(prog);

		JLabel sec=new JLabel("@SECURED");
		sec.setBounds(440,850,170,30);
		sec.setFont(new Font("southern",Font.BOLD,20));
		sec.setForeground(Color.BLACK);
		p.add(sec);

		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		cancel.setBackground(Color.GREEN);
		cancel.setFont(new Font("southern",Font.BOLD,38));
		cancel.setForeground(Color.BLACK);
		cancel.setBounds(5,12,120,40);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
					cl.show(cont,"3");
			}
		});


		p.add(pane);

	}


/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTouserinfopanel(JPanel p)					//*************** Adding user info panel **********************//
	{
		JPanel lb2=new JPanel();
		lb2.setBounds(0,1,599,100);
		lb2.setBackground(new Color(100,50,255));

		JPanel jpanel2=new JPanel();
		jpanel2.setBounds(-5,110,610,200);
		jpanel2.setBackground(Color.WHITE);

		lmob=new JLabel("9021070533");
		lmob.setBounds(250,130,350,50);
		lmob.setFont(new Font("southern",Font.BOLD,38));
		//lmob.set
		p.add(lmob);

		lname=new JLabel("krishna patil");
		lname.setBounds(250,190,350,50);
		lname.setFont(new Font("southern",Font.BOLD,30));
		//lmob.set
		p.add(lname);

		JButton bkacc=new JButton("*Add Bank A/C To Create QR Code");
		bkacc.setBounds(0,680,600,50);
		//bkacc.setHorizontalAlignment(JTextField.CENTER);
		bkacc.setFont(new Font("Ariel",Font.PLAIN,18));
		bkacc.setBackground(Color.WHITE);
		bkacc.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bkacc.setForeground(Color.RED);
		//bkacc.setEditable(false);
		bkacc.setVisible(false);
		p.add(bkacc);
		
		ImageIcon ic=new ImageIcon("userlogo1.jpg");
		JLabel j1=new JLabel(ic);
		j1.setBounds(10,115,ic.getIconWidth(),ic.getIconHeight());
		p.add(j1);	

		ImageIcon qr=new ImageIcon("qr.png");
		JLabel j2=new JLabel(qr);
		j2.setBounds(350,420,qr.getIconWidth(),qr.getIconHeight());
		j2.setVisible(false);	
		p.add(j2);

		JLabel ij=new JLabel("$ ACCOUNT INFO $");
		ij.setBounds(180,350,300,50);
		ij.setFont(new Font("southern",Font.BOLD,25));
		p.add(ij);

		JLabel jl=new JLabel("# MY QR CODE");
		jl.setBounds(15,450,200,30);
		jl.setFont(new Font("southern",Font.BOLD,25));
		p.add(jl);

		JLabel jl1=new JLabel("@ MY BHIM UPI ID");
		jl1.setBounds(15,580,300,33);
		jl1.setFont(new Font("southern",Font.BOLD,25));
		p.add(jl1);

		parth3=new JLabel("9021070533@mybnk");
		parth3.setBounds(300,590,300,35);
		parth3.setFont(new Font("southern",Font.BOLD,25));
		parth3.setVisible(false);
		p.add(parth3);

		JPanel jpanel1=new JPanel();
		jpanel1.setBounds(-5,331,610,420);
		jpanel1.setBackground(Color.WHITE);

		JPanel jpanelx=new JPanel();
		jpanelx.setBounds(0,760,600,25);
		jpanelx.setBackground(new Color(100,50,255));
		p.add(jpanelx);
		

		JPanel jpanel5=new JPanel();
		jpanel5.setBounds(-5,796,610,200);
		jpanel5.setBackground(Color.WHITE);
		jpanel5.setLayout(null);

		JLabel jlh=new JLabel("MyPay Account");
		jlh.setBounds(180,28,400,50);
		jlh.setFont(new Font("southern",Font.BOLD,35));
		jlh.setForeground(Color.WHITE);
		p.add(jlh);

		JLabel jlh1=new JLabel("KYC Detail");
		jlh1.setBounds(20,795,400,50);
		jlh1.setFont(new Font("southern",Font.BOLD,20));
		jlh1.setForeground(Color.BLACK);
		p.add(jlh1);

		Icon pn=new ImageIcon("pancard.png");
		parth1=new JLabel(pn);
		parth1.setBounds(25,875,pn.getIconWidth(),pn.getIconHeight());
		parth1.setVisible(false);
		p.add(parth1);

		parth2=new JLabel("PAN CARD - XXXXXXXXXXXX");
		parth2.setBounds(135,875,400,50);
		parth2.setFont(new Font("southern",Font.BOLD,20));
		parth2.setForeground(Color.BLACK);
		parth2.setVisible(false);
		p.add(parth2);

		Icon icc=new ImageIcon("accinfokyc.png");
		xxx=new JButton(icc);
		xxx.setBounds(20,840,icc.getIconWidth(),icc.getIconHeight());
		xxx.setBackground(Color.WHITE);
		xxx.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		xxx.setVisible(false);
		p.add(xxx);

		JButton showqr=new JButton("SHOW QR CODE");
		showqr.setBounds(15,480,170,50);
		showqr.setBackground(Color.WHITE);
		showqr.setForeground(new Color(100,50,255));
		showqr.setFont(new Font("southern",Font.BOLD,16));
		showqr.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		showqr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection coni=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String qi="select * from mypay where phone_number=?";
					PreparedStatement pri=coni.prepareStatement(qi);
					pri.setString(1,mobile);						
					ResultSet rsi=pri.executeQuery();
					if(rsi.next())
					{
						if(rsi.getString(5)==null)
						{	
							bkacc.setVisible(true);	
						}
						else
						{
							j2.setVisible(true);
						}
					}
					
					coni.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
					
			}
		});
		p.add(showqr);

		JButton showqr1=new JButton("SHOW UPI ID");
		showqr1.setBounds(15,613,170,50);
		showqr1.setBackground(Color.WHITE);
		showqr1.setForeground(new Color(100,50,255));
		showqr1.setFont(new Font("southern",Font.BOLD,16));
		showqr1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		showqr1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection coni=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String qi="select * from mypay where phone_number=?";
					PreparedStatement pri=coni.prepareStatement(qi);
					pri.setString(1,mobile);						
					ResultSet rsi=pri.executeQuery();
					if(rsi.next())
					{
						if(rsi.getString(5)==null)
						{	
							bkacc.setVisible(true);	
						}
						else
						{
							parth3.setVisible(true);
						}
					}
					
					coni.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}	
			}
		});
		p.add(showqr1);

		//****************************** Implimenting Action Listener *****************************8

		bkacc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				cl.show(cont,"14");
				j2.setVisible(false);
				parth3.setVisible(false);
				bkacc.setVisible(false);
				xxx.setVisible(false);	
				parth1.setVisible(false);
				parth2.setVisible(false);
			}
		});

		xxx.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cl.show(cont,"11");
				j2.setVisible(false);
				parth3.setVisible(false);
				bkacc.setVisible(false);
				xxx.setVisible(false);	
				parth1.setVisible(false);
				parth2.setVisible(false);
			}
		});
		
		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,50));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(5,25,150,50);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
					cl.show(cont,"3");
					j2.setVisible(false);
					parth3.setVisible(false);
					bkacc.setVisible(false);
					xxx.setVisible(false);	
					parth1.setVisible(false);
					parth2.setVisible(false);
			}
		});

		p.add(jpanel2);
		p.add(jpanel1);
		p.add(jpanel5);
		p.add(lb2);

	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTosearchph(JPanel p)				//********************* Search phone number ***********************//
	{
		JTextField txtf=new JTextField();
		txtf.setBounds(100,110,400,60);
		txtf.setFont(new Font("Ariel",Font.BOLD,40));
		txtf.setHorizontalAlignment(JTextField.CENTER);
		txtf.setEditable(false);
		txtf.setBackground(Color.WHITE);
		p.add(txtf);

		JTextArea txtf1=new JTextArea("Bank Account Found With Respective Phone No.\nAccountant Name : Krishna Patil");
		txtf1.setBounds(100,270,500,60);
		txtf1.setFont(new Font("Ariel",Font.BOLD,18));
		//txtf1.setHorizontalAlignment(JTextField.CENTER);
		txtf1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		txtf1.setEditable(false);
		txtf1.setBackground(Color.WHITE);
		txtf1.setVisible(false);
		p.add(txtf1);

		JPanel winu=new JPanel();
		winu.setLayout(null);
		winu.setBounds(0,1,599,50);
		winu.setBackground(new Color(100,50,255));

		JLabel lb1=new JLabel("ENTER PHONE NUMBER TO SEND MONEY");
		lb1.setBounds(100,70,500,30);
		lb1.setFont(new Font("Ariel",Font.BOLD,15));
		p.add(lb1);

		/********** Adding Buttons *********/

		JPanel px=new JPanel();
		//p.setLocation(450,80);
		px.setBounds(30,400,540,500);
		GridLayout gr=new GridLayout(4,3);
		px.setLayout(gr);
		gr.setVgap(10);
		gr.setHgap(10);
		px.setBackground(Color.WHITE);
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
		JButton bcl=new JButton("X");
		JButton b0=new JButton("0");
		JButton ben=new JButton("PROCEED");

		bcl.setBackground(Color.WHITE);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(new Color(100,50,255));
		ben.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setForeground(Color.WHITE);
		ben.setVisible(false);
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

		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b0.setBackground(Color.WHITE);

		px.add(b1);
		px.add(b2);
		px.add(b3);
		px.add(b4);
		px.add(b5);
		px.add(b6);
		px.add(b7);
		px.add(b8);
		px.add(b9);
		px.add(bcl);
		px.add(b0);
		px.add(ben);

		/******* IMPLIMENTING BUTTONS *********/

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"0");
			}	
		});

		JTextField warn=new JTextField("*BANK ACCOUNT IS NOT LINKED/ THIS PHONE NUMBER IS NOT ON MyPay");
		warn.setBounds(0,270,600,30);
		warn.setFont(new Font("Ariel",Font.BOLD,15));
		warn.setForeground(Color.RED);
		warn.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		warn.setVisible(false);
		warn.setHorizontalAlignment(JTextField.CENTER);
		warn.setEditable(false);
		warn.setBackground(Color.WHITE);
		p.add(warn);

		JTextField lbl=new JTextField("*Phone Number Must Be Of 10 Digit");
		lbl.setBounds(0,225,600,20);
		lbl.setForeground(Color.RED);
		lbl.setHorizontalAlignment(JTextField.CENTER);
		lbl.setFont(new Font("Ariel",Font.BOLD,15));
		lbl.setVisible(false);
		lbl.setBackground(Color.WHITE);
		lbl.setBorder(BorderFactory.createLineBorder(Color.WHITE));	
		p.add(lbl);

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cl.show(cont,"16");	
				ben.setVisible(false);
				warn.setVisible(false);
				txtf1.setVisible(false);
				lbl.setVisible(false);
				vision=2;

				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from accountant where ph_no=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet rs=pr.executeQuery();
					if(rs.next())
					{
						acc_info.setText("MyBank - XXXX"+rs.getString(1).substring(4,8));
					}
					con.close();

				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}

				txtf.setText("");	
				heading.setText("Transfering To "+ reciever_nm);
			}
		});

		JLabel cleb=new JLabel("SEARCH PHONE NUMBER");
		cleb.setFont(new Font("Ariel",Font.BOLD,20));
		cleb.setForeground(Color.WHITE);
		cleb.setBounds(200,10,300,40);
		p.add(cleb);

		JButton invite=new JButton("INVITE");
		invite.setBounds(240,330,120,30);
		//invite.setForeground(Color.WHITE);
		invite.setBackground(Color.GREEN);
		invite.setVisible(false);
		invite.setFont(new Font("Ariel",Font.BOLD,18));
		invite.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
				invite.setVisible(false);
				txtf.setText("");
				txtf1.setVisible(false);
				warn.setVisible(false);
				ben.setVisible(false);
				lbl.setVisible(false);
				JOptionPane.showMessageDialog(f,"Invitation Is Sent To "+number_to_recieve,"MESSAGE FROM MyPAY",JOptionPane.PLAIN_MESSAGE);
			}
		});
		p.add(invite);

		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,38));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(10,5,120,45);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
				txtf.setText("");
				txtf1.setVisible(false);
				warn.setVisible(false);
				ben.setVisible(false);
				invite.setVisible(false);
				lbl.setVisible(false);
				cl.show(cont,"3");
			}
		});


		JButton search=new JButton("SEARCH");
		search.setBounds(240,190,120,30);
		search.setForeground(Color.WHITE);
		search.setBackground(new Color(100,50,255));
		search.setFont(new Font("Ariel",Font.BOLD,18));
		search.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
				lbl.setVisible(false);
				warn.setVisible(false);
				invite.setVisible(false);
				if(txtf.getText()==null)
				{
					txtf.setText("");
				}

				if(txtf.getText().length()==10)
				{

				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from accountant where ph_no=?";
					number_to_recieve=txtf.getText();
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,txtf.getText());
					ResultSet rs=pr.executeQuery();
					if(rs.next())
					{
						ben.setVisible(true);
						txtf1.setVisible(true);
						txtf1.setText("Bank Account Found For Respective Phone No.\nAccountant Name : "+rs.getString(3));
						reciever_nm=rs.getString(3);
						reciever_mob=rs.getString(2);
						System.out.println(reciever_nm);
						reciever_acc=rs.getString(1);
					}
					else
					{
						warn.setVisible(true);
						JOptionPane.showMessageDialog(f,"This UPI ID is not linked to any bank account.\nPlease try after the reciever links a bank account to this ID.","MESSAGE FROM MyPAY",JOptionPane.ERROR_MESSAGE);
						txtf.setText("");
						invite.setVisible(true);
					}					

					con.close();

				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}

				}
				else
				{
					lbl.setVisible(true);
				}
			}
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText("");
				txtf1.setVisible(false);
				warn.setVisible(false);
				ben.setVisible(false);
				invite.setVisible(false);
				lbl.setVisible(false);
			}	
		});
		p.add(search);

		p.add(winu);
		p.add(px);
	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addToscanpay(JPanel p)				//********************* Scan And Pay ***********************//
	{
		JTextField txtf=new JTextField("");
		txtf.setBounds(100,120,400,60);
		txtf.setFont(new Font("Ariel",Font.BOLD,35));
		txtf.setHorizontalAlignment(JTextField.CENTER);
		txtf.setEditable(false);
		txtf.setBackground(Color.WHITE);
		p.add(txtf);

		JLabel cleb=new JLabel("PAYMENTS & BILLING");
		cleb.setFont(new Font("Ariel",Font.BOLD,20));
		cleb.setForeground(Color.WHITE);
		cleb.setBounds(200,10,300,40);
		p.add(cleb);

		JPanel winu=new JPanel();
		winu.setLayout(null);
		winu.setBounds(0,1,599,50);
		winu.setBackground(new Color(100,50,255));

		JLabel lb1=new JLabel("ENTER UPI ID");
		lb1.setBounds(100,80,500,30);
		lb1.setFont(new Font("Ariel",Font.BOLD,18));
		p.add(lb1);

		/********** Adding Buttons *********/

		JPanel px=new JPanel();
		//p.setLocation(450,80);
		px.setBounds(30,400,540,500);
		GridLayout gr=new GridLayout(4,3);
		px.setLayout(gr);
		gr.setVgap(10);
		gr.setHgap(10);
		px.setBackground(Color.WHITE);
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
		JButton bcl=new JButton("X");
		JButton b0=new JButton("0");
		JButton ben=new JButton("PROCEED");

		bcl.setBackground(Color.WHITE);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(new Color(100,50,255));
		ben.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setForeground(Color.WHITE);
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

		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b0.setBackground(Color.WHITE);

		px.add(b1);
		px.add(b2);
		px.add(b3);
		px.add(b4);
		px.add(b5);
		px.add(b6);
		px.add(b7);
		px.add(b8);
		px.add(b9);
		px.add(bcl);
		px.add(b0);
		px.add(ben);

		/******* IMPLIMENTING BUTTONS *********/

		JButton bhim1=new JButton("@mybnk");
		bhim1.setFont(new Font("Ariel",Font.PLAIN,20));
		bhim1.setBounds(30,340,540,50);
		bhim1.setBackground(Color.WHITE);
		bhim1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"@mybnk");
			}	
		});
		p.add(bhim1);

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"0");
			}	
		});

		JTextField lbl=new JTextField("*Invalid UPI ID");
		lbl.setBounds(0,225,600,20);
		lbl.setForeground(Color.RED);
		lbl.setHorizontalAlignment(JTextField.CENTER);
		lbl.setFont(new Font("Ariel",Font.BOLD,15));
		lbl.setVisible(false);
		lbl.setBackground(Color.WHITE);
		lbl.setBorder(BorderFactory.createLineBorder(Color.WHITE));	
		p.add(lbl);

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				lbl.setVisible(false);
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where upi_id=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,txtf.getText());
					ResultSet rs=pr.executeQuery();
					if(rs.next())
					{
						if(rs.getString(4)==null)
						{
							lbl.setVisible(true);
						}
						else
						{
							vision=2;
//_-------------------------------------------------------------------------------------------------- retriving data from accountant for reciever
							try
							{
								Class.forName("com.mysql.cj.jdbc.Driver");
								Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
								String q1="select * from accountant where ph_no=?";
								PreparedStatement pr1=con1.prepareStatement(q1);
								pr1.setString(1,txtf.getText().substring(0,10));
								System.out.println(txtf.getText().substring(0,10));
								ResultSet rs1=pr1.executeQuery();
								if(rs1.next())
								{
									reciever_nm=rs1.getString(3);		//retriving name of reciever	
									//System.out.println(rs1.getString(1));
									reciever_acc=rs1.getString(1);		//retriving account-number of reciever
									reciever_mob=rs1.getString(2);
								}
								con1.close();
								
							}
							catch(Exception ex1)
							{
								System.out.println(ex1);
							}

//_-------------------------------------------------------------------------------------------------- retriving account_number from accountant for sender
							try
							{
								Class.forName("com.mysql.cj.jdbc.Driver");
								Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
								String q1="select * from accountant where ph_no=?";
								PreparedStatement pr1=con1.prepareStatement(q1);
								pr1.setString(1,mobile);
								ResultSet rs1=pr1.executeQuery();
								if(rs1.next())
								{
									
									//System.out.println(rs1.getString(3));		//retriving name of sender	
									//System.out.println(rs1.getString(1));	
									acc_info.setText("MyBank - XXXX"+rs1.getString(1).substring(4,8));	//retriving account-number of sender
								}
								con1.close();
								
							}
							catch(Exception ex1)
							{
								System.out.println(ex1);
							}

							cl.show(cont,"16");
						}	
					}
					else
					{
						lbl.setVisible(true);
					}
					con.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}

				txtf.setText("");	
				heading.setText("Transfering To "+ reciever_nm);
			}
		});

		
		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,38));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(10,5,120,45);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
				txtf.setText("");
				lbl.setVisible(false);
				cl.show(cont,"3");
			}
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText("");
				lbl.setVisible(false);
			}	
		});

		p.add(winu);
		p.add(px);
	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTobilling(JPanel p)				//********************* Recharge and billing ***********************//
	{
		JTextField txtf=new JTextField("");
		txtf.setBounds(100,120,400,60);
		txtf.setFont(new Font("Ariel",Font.BOLD,35));
		txtf.setHorizontalAlignment(JTextField.CENTER);
		txtf.setEditable(false);
		txtf.setBackground(Color.WHITE);
		p.add(txtf);

		JLabel cleb=new JLabel("PAYMENTS & BILLING");
		cleb.setFont(new Font("Ariel",Font.BOLD,20));
		cleb.setForeground(Color.WHITE);
		cleb.setBounds(200,10,300,40);
		p.add(cleb);

		JPanel winu=new JPanel();
		winu.setLayout(null);
		winu.setBounds(0,1,599,50);
		winu.setBackground(new Color(100,50,255));

		/********** Adding Buttons *********/

		JPanel px=new JPanel();
		//p.setLocation(450,80);
		px.setBounds(30,400,540,500);
		GridLayout gr=new GridLayout(4,3);
		px.setLayout(gr);
		gr.setVgap(10);
		gr.setHgap(10);
		px.setBackground(Color.WHITE);
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
		JButton bcl=new JButton("X");
		JButton b0=new JButton("0");
		JButton ben=new JButton("PROCEED");

		bcl.setBackground(Color.WHITE);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(new Color(100,50,255));
		ben.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setForeground(Color.WHITE);
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

		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b0.setBackground(Color.WHITE);

		px.add(b1);
		px.add(b2);
		px.add(b3);
		px.add(b4);
		px.add(b5);
		px.add(b6);
		px.add(b7);
		px.add(b8);
		px.add(b9);
		px.add(bcl);
		px.add(b0);
		px.add(ben);

		/******* IMPLIMENTING BUTTONS *********/

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"0");
			}	
		});

		dynamicbilling=new JLabel("");
		dynamicbilling.setBounds(100,80,500,30);
		dynamicbilling.setFont(new Font("Ariel",Font.BOLD,18));
		p.add(dynamicbilling);

		String arr1[]={"Jio","Airtel","BSNL","Vodafone","Idea"};
		moboperator=new JComboBox(arr1);
		moboperator.setVisible(false);
		moboperator.setBounds(230,235,140,40);
		moboperator.setFont(new Font("southern",Font.BOLD,18));
		moboperator.setBackground(Color.WHITE);
		p.add(moboperator);

		String arr2[]={"Videocon D2H","Tata Sky","SUN DIRECT","Airtel Digital"};
		dishoperator=new JComboBox(arr2);
		dishoperator.setVisible(false);
		dishoperator.setBounds(220,235,160,40);
		dishoperator.setFont(new Font("southern",Font.BOLD,18));
		dishoperator.setBackground(Color.WHITE);
		p.add(dishoperator);

		JTextField lbl=new JTextField("*PHONE NUMBER MUST BE OF 10 DIGIT");
		lbl.setBounds(0,200,600,20);
		lbl.setForeground(Color.RED);
		lbl.setHorizontalAlignment(JTextField.CENTER);
		lbl.setFont(new Font("Ariel",Font.BOLD,15));
		lbl.setVisible(false);
		lbl.setBackground(Color.WHITE);
		lbl.setBorder(BorderFactory.createLineBorder(Color.WHITE));	
		p.add(lbl);

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				lbl.setVisible(false);
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q1="select * from accountant where ph_no=?";
					PreparedStatement pr1=con1.prepareStatement(q1);
					pr1.setString(1,mobile);
					ResultSet rs1=pr1.executeQuery();
					if(rs1.next())
					{
						acc_info1.setText(" MyBank - XXXX"+rs1.getString(1).substring(4,8));
					}
					con1.close();

				}
				catch(Exception exc)
				{
					System.out.println(exc);
				}

				if(alexa==2)
				{
					if((txtf.getText()).length()==10)
					{
						patil=txtf.getText();
						System.out.println("Next Screen");
						moboperator.setVisible(false);
						cl.show(cont,"27");
					}
					else
					{
						lbl.setVisible(true);
					}
				}
				else
				{
					if(alexa==3)
					{
						patil=txtf.getText();
						dishoperator.setVisible(false);
						cl.show(cont,"27");
					}
					else if(alexa==4)
					{
						patil=txtf.getText();
						cl.show(cont,"27");
					}
				}
				txtf.setText("");	
			}
		});

		
		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,38));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(10,5,120,45);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
				txtf.setText("");
				lbl.setVisible(false);
				moboperator.setVisible(false);
				dishoperator.setVisible(false);
				cl.show(cont,"3");
			}
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText("");
				lbl.setVisible(false);
			}	
		});

		p.add(winu);
		p.add(px);
	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTobillrechargeamount(JPanel p)				//********************* CHECK BALANCE TO DO RECHARGE AND BILLS ***********************//
	{
		JTextField txtf=new JTextField();
		txtf.setBounds(100,170,400,80);
		txtf.setFont(new Font("Ariel",Font.BOLD,50));
		txtf.setHorizontalAlignment(JTextField.CENTER);
		txtf.setEditable(false);
		txtf.setForeground(Color.GREEN);
		txtf.setBackground(Color.WHITE);
		p.add(txtf);									//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ marked one @@@@@@@@@@@@@

		ImageIcon imgic=new ImageIcon("rupees.png");
		JLabel rupees=new JLabel(imgic);
		rupees.setBounds(45,180,imgic.getIconWidth(),imgic.getIconHeight());
		p.add(rupees);

		JPanel winu=new JPanel();
		winu.setLayout(null);
		winu.setBounds(0,1,599,50);
		winu.setBackground(new Color(100,50,255));

		JLabel warn=new JLabel("  *Please Select Payment Option");
		warn.setBounds(100,360,400,30);
		warn.setFont(new Font("Ariel",Font.BOLD,15));
		warn.setForeground(Color.RED);
		warn.setVisible(false);
		p.add(warn);

		JLabel head=new JLabel("PAY RECHARGE/BILLS");
		head.setFont(new Font("Ariel",Font.BOLD,20));
		head.setForeground(Color.WHITE);
		head.setBounds(200,10,400,40);
		p.add(head);

		acc_info1=new JRadioButton();
		acc_info1.setBounds(100,270,400,50);
		acc_info1.setSelected(false);
		acc_info1.setFont(new Font("Ariel",Font.BOLD,18));
		acc_info1.setBackground(Color.WHITE);
		acc_info1.setSelected(false);
		p.add(acc_info1);

		settingmypaywallet=new JRadioButton(" MyPay Wallet");
		settingmypaywallet.setBounds(100,320,200,50);
		settingmypaywallet.setSelected(false);
		settingmypaywallet.setFont(new Font("Ariel",Font.BOLD,18));
		settingmypaywallet.setBackground(Color.WHITE);
		settingmypaywallet.setSelected(false);
		p.add(settingmypaywallet);

		JButton warn1=new JButton(" *Please Complete KYC");
		warn1.setBounds(320,340,300,30);
		warn1.setFont(new Font("Ariel",Font.BOLD,15));
		warn1.setBackground(Color.WHITE);
		warn1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		warn1.setForeground(Color.RED);
		warn1.setVisible(false);
		warn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText("");
				cl.show(cont,"11");
				warn.setVisible(false);
				warn1.setVisible(false);
			}	
		});
		p.add(warn1);

		grp=new ButtonGroup();
		grp.add(acc_info1);
		grp.add(settingmypaywallet);


		JLabel lb1=new JLabel("ENTER AMOUNT");
		lb1.setBounds(100,120,400,30);
		lb1.setFont(new Font("Ariel",Font.BOLD,20));
		p.add(lb1);

		/********** Adding Buttons *********/

		JPanel px=new JPanel();
		px.setBounds(30,400,540,500);
		GridLayout gr=new GridLayout(4,3);
		px.setLayout(gr);
		gr.setVgap(10);
		gr.setHgap(10);
		px.setBackground(Color.WHITE);
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
		JButton bcl=new JButton("X");
		JButton b0=new JButton("0");
		JButton ben=new JButton(">>>>");

		bcl.setBackground(Color.WHITE);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(Color.WHITE);
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

		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b0.setBackground(Color.WHITE);

		px.add(b1);
		px.add(b2);
		px.add(b3);
		px.add(b4);
		px.add(b5);
		px.add(b6);
		px.add(b7);
		px.add(b8);
		px.add(b9);
		px.add(bcl);
		px.add(b0);
		px.add(ben);

		/******* IMPLIMENTING BUTTONS *********/

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"0");
			}	
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText("");
				warn1.setVisible(false);
				warn.setVisible(false);
			}	
		});


		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				warn1.setVisible(false);

				if(alexa==2)
				{
					fundlast1.setText(moboperator.getSelectedItem()+" No. "+patil+" Recharged With Rs "+txtf.getText());
				}
				else if(alexa==3)
				{
					fundlast1.setText("Topup Of Rs "+txtf.getText()+" Is Done For "+dishoperator.getSelectedItem()+" ID : "+patil);		
				}
				else if(alexa==4)
				{
					fundlast1.setText("Rs "+txtf.getText()+" Electricity Bill Paid For Consumer : "+patil);
				}


				if(acc_info1.isSelected())	
				{
					king=1;
					recheckbal=txtf.getText();
					if(recheckbal.equalsIgnoreCase("") || recheckbal==null)
					{
						recheckbal="0";
					}

					cl.show(cont,"28");
					txtf.setText("");
					acc_info1.setSelected(false);
					settingmypaywallet.setSelected(false);
					warn.setVisible(false);
				}
				else if(settingmypaywallet.isSelected())
				{
					king=2;
					try
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
						String q1="select * from mypay where phone_number=?";
						PreparedStatement pr1=con1.prepareStatement(q1);
						pr1.setString(1,mobile);
						ResultSet rs1=pr1.executeQuery();
						if(rs1.next())
						{
							if(rs1.getString(6)==null)
							{
								System.out.println("Complete kyc");
								warn1.setVisible(true);
								warn.setVisible(false);
							}
							else
							{
								recheckbal=txtf.getText();
								if(recheckbal.equalsIgnoreCase("") || recheckbal==null)
								{
									recheckbal="0";
								}
		
								cl.show(cont,"28");
								txtf.setText("");
								acc_info1.setSelected(false);
								settingmypaywallet.setSelected(false);
								warn.setVisible(false);
							}
						}
						con1.close();
					}
					catch(Exception exc)
					{
						System.out.println(exc);
					}					

				}
				else
				{
					warn.setVisible(true);
				}
			}
		});

		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,38));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(5,6,120,40);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
					cl.show(cont,"3");
					txtf.setText("");
					warn.setVisible(false);
					acc_info1.setSelected(false);
					settingmypaywallet.setSelected(false);
					warn1.setVisible(false);
			}
		});

		p.add(winu);
		p.add(px);
	}


/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTochkbillupi(JPanel p)				//********************* Check bhim upi for recharge and billings ***********************//
	{
		JPasswordField txtf=new JPasswordField("");
		txtf.setBounds(100,170,400,80);
		txtf.setFont(new Font("Ariel",Font.BOLD,50));
		txtf.setHorizontalAlignment(JTextField.CENTER);
		txtf.setEditable(false);
		char pass=txtf.getEchoChar();
		txtf.setBackground(Color.WHITE);
		p.add(txtf);

		JPanel winu=new JPanel();
		winu.setLayout(null);
		winu.setBounds(0,1,599,50);
		winu.setBackground(new Color(100,50,255));

		JLabel head=new JLabel("PAY RECHARGE/BILLS");
		head.setFont(new Font("Ariel",Font.BOLD,20));
		head.setForeground(Color.WHITE);
		head.setBounds(180,10,420,40);
		p.add(head);


		JLabel lb1=new JLabel("ENTER UPI PIN");
		lb1.setBounds(100,120,400,30);
		lb1.setFont(new Font("Ariel",Font.BOLD,20));
		p.add(lb1);

		/********** Adding Buttons *********/

		JPanel px=new JPanel();
		//p.setLocation(450,80);
		px.setBounds(30,400,540,500);
		GridLayout gr=new GridLayout(4,3);
		px.setLayout(gr);
		gr.setVgap(10);
		gr.setHgap(10);
		px.setBackground(Color.WHITE);
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
		JButton bcl=new JButton("X");
		JButton b0=new JButton("0");
		JButton ben=new JButton(">>>>");

		bcl.setBackground(Color.WHITE);
		bcl.setFont(new Font("Ariel",Font.PLAIN,18));
		ben.setBackground(Color.WHITE);
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

		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b0.setBackground(Color.WHITE);

		px.add(b1);
		px.add(b2);
		px.add(b3);
		px.add(b4);
		px.add(b5);
		px.add(b6);
		px.add(b7);
		px.add(b8);
		px.add(b9);
		px.add(bcl);
		px.add(b0);
		px.add(ben);

		/******* IMPLIMENTING BUTTONS *********/

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"1");
			}	
		});

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"2");
			}	
		});

		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"3");
			}	
		});

		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"4");
			}	
		});

		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"5");
			}	
		});

		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"6");
			}	
		});

		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"7");
			}	
		});

		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"8");
			}	
		});

		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"9");
			}	
		});

		b0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText(txtf.getText()+"0");
			}	
		});

		bcl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setText("");
			}	
		});

		JLabel warn=new JLabel("*INCORRECT UPI PIN");
		warn.setBounds(100,260,400,30);
		warn.setFont(new Font("Ariel",Font.BOLD,12));
		warn.setForeground(Color.RED);
		warn.setVisible(false);
		p.add(warn);

		JButton bshow=new JButton("SHOW");
		bshow.setBounds(530,180,50,25);
		bshow.setBackground(Color.WHITE);
		bshow.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bshow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setEchoChar((char)0);
			}
		});
		p.add(bshow);

		JButton bhide=new JButton("HIDE");
		bhide.setBounds(530,210,50,25);
		bhide.setBackground(Color.WHITE);
		bhide.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		bhide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				txtf.setEchoChar(pass);
			}
		});
		p.add(bhide);

		ben.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String get=txtf.getText();
				String comp=null;
				try														
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
					String q="select * from mypay where phone_number=?";
					PreparedStatement pr=con.prepareStatement(q);
					pr.setString(1,mobile);
					ResultSet rs=pr.executeQuery();
					if(rs.next())
					{
						comp=rs.getString(3);
					}
					con.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}


				if(get.equalsIgnoreCase(comp))					
				{
					fundlast2.setText("Transaction ID : "+CreateOTP.genAtmNumber());
					System.out.println("UPI PIN MATCHED");
					warn.setVisible(false);
					txtf.setText("");
					System.out.println(recheckbal);
					if(king==1)
					{
						System.out.println("Paying from bank account");
						try														
						{
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
							String q2="select * from accountant where ph_no=?";
							PreparedStatement pr2=con.prepareStatement(q2);
							pr2.setString(1,mobile);
							ResultSet rs2=pr2.executeQuery();
							if(rs2.next())
							{
								if(Long.parseLong(rs2.getString(4))<Long.parseLong(recheckbal))
								{
									cl.show(cont,"19");
								}	
								else
								{
									cl.show(cont,"29");

									LocalDate ld=LocalDate.now();
									LocalTime lt=LocalTime.now();
									String ldt=ld+"  "+lt;
									String myaccountnumber=null;

									try					//Debiting from logined customer													
									{
										Class.forName("com.mysql.cj.jdbc.Driver");
										Connection conection1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
										String query1="update accountant set balance=? where ph_no=?";
										PreparedStatement prep1=conection1.prepareStatement(query1);
										prep1.setString(1,""+(Long.parseLong(rs2.getString(4))-Long.parseLong(recheckbal)));
										prep1.setString(2,mobile);
										prep1.executeUpdate();
										conection1.close();
									}
									catch(Exception exep)
									{
										System.out.println(exep);
									}
				
									try						//@@@@@@@@@@@@@@@ adding to senders mypay_transaction detail @@@@@@@@@@@@@
									{
										Class.forName("com.mysql.cj.jdbc.Driver");
										Connection conconqy=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
										String qqqy="INSERT INTO mypay_transaction VALUES (?,?,?)";
										PreparedStatement prpqy=conconqy.prepareStatement(qqqy);
										prpqy.setString(1,mobile);						//add mobile number
										prpqy.setString(2,ldt);
										prpqy.setString(3,"Rs. "+recheckbal+" Debited for Recharge/Bill Payment");		//add amount
										prpqy.executeUpdate();
										conconqy.close();
										System.out.println("Data Added");
									}
									catch(Exception exxqy1)
									{
										System.out.println("Error");
										System.out.println(exxqy1);
									}

									try						//@@@@@@@@@@@@@@@ adding to senders transaction detail @@@@@@@@@@@@@
									{
										try
										{
											Class.forName("com.mysql.cj.jdbc.Driver");
											Connection coni=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
											String qi="select * from accountant where ph_no=?";
											PreparedStatement pri=coni.prepareStatement(qi);
											pri.setString(1,mobile);						
											ResultSet rsi=pri.executeQuery();
											if(rsi.next())
											{	
												myaccountnumber=rsi.getString(1);	
											}
											coni.close();
										}
										catch(Exception except)
										{
											System.out.println(except);
										}
										Class.forName("com.mysql.cj.jdbc.Driver");
										Connection conx=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
										String qx="INSERT INTO transaction VALUES (?,?,?)";
										PreparedStatement prx=conx.prepareStatement(qx);
										prx.setString(1,myaccountnumber);						//add account number
										prx.setString(2,ldt);
										prx.setString(3,"Rs. "+recheckbal+" Debited for Recharge/Bill Payment");		//add withdrawl amount
										prx.executeUpdate();
										conx.close();
										System.out.println("Data Added");
									}
									catch(Exception exx)
									{
										System.out.println("Error");
										System.out.println(exx);
									}		

								}//end of inner else

							}//end of if

							con.close();

						}//end of try
						catch(Exception ex)
						{
							System.out.println(ex);
						}
						
					}
					else if(king==2)
					{
						System.out.println("Paying from mypay wallet");
						try														
						{
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
							String q2="select * from mypay where phone_number=?";
							PreparedStatement pr2=con.prepareStatement(q2);
							pr2.setString(1,mobile);
							ResultSet rs2=pr2.executeQuery();
							if(rs2.next())
							{
								if(Long.parseLong(rs2.getString(2))<Long.parseLong(recheckbal))
								{
									cl.show(cont,"19");
								}	
								else
								{
									cl.show(cont,"29");
									LocalDate ld=LocalDate.now();
									LocalTime lt=LocalTime.now();
									String ldt=ld+"  "+lt;
									String myaccountnumber=null;

									try					//Debiting from logined customer's mypay_wallet													
									{
										Class.forName("com.mysql.cj.jdbc.Driver");
										Connection conection1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
										String query1="update mypay set mypay_wallet=? where phone_number=?";
										PreparedStatement prep1=conection1.prepareStatement(query1);
										prep1.setString(1,""+(Long.parseLong(rs2.getString(2))-Long.parseLong(recheckbal)));
										prep1.setString(2,mobile);
										prep1.executeUpdate();
										conection1.close();
									}
									catch(Exception exep)
									{
										System.out.println(exep);
									}

									try						//@@@@@@@@@@@@@@@ adding to senders mypay_transaction detail @@@@@@@@@@@@@
									{
										Class.forName("com.mysql.cj.jdbc.Driver");
										Connection conconqy=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
										String qqqy="INSERT INTO mypay_transaction VALUES (?,?,?)";
										PreparedStatement prpqy=conconqy.prepareStatement(qqqy);
										prpqy.setString(1,mobile);						//add mobile number
										prpqy.setString(2,ldt);
										prpqy.setString(3,"Rs "+recheckbal+" Debited for Bill Payment from Wallet");		//add amount
										prpqy.executeUpdate();
										conconqy.close();
										System.out.println("Data Added");
									}
									catch(Exception exxqy1)
									{
										System.out.println("Error");
										System.out.println(exxqy1);
									}

								}//end of else

							}//end of if

							con.close();
						}//end of try
						catch(Exception ex)
						{
							System.out.println(ex);
						}
					}
					/*try														
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
						String q2="select * from accountant where ph_no=?";
						PreparedStatement pr2=con.prepareStatement(q2);
						pr2.setString(1,mobile);
						ResultSet rs2=pr2.executeQuery();
						if(rs2.next())
						{
							if(Long.parseLong(rs2.getString(4))<Long.parseLong(recheckbal))
							{
								cl.show(cont,"19");
							}	
							else
							{
								cl.show(cont,"18");
								fund1.setText("Transaction ID : "+CreateOTP.genAtmNumber());
								fund2.setText("Transfered To : XXXX"+reciever_acc.substring(4,8));
								fund3.setText("Amount Rs. "+recheckbal);
								fund4.setText("Recieved By : "+reciever_nm);
		//_________________________________________________________________________________________________________________________________________________________________
								
							
								try														
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection conection1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String query1="update accountant set balance=? where ph_no=?";
									PreparedStatement prep1=conection1.prepareStatement(query1);
									prep1.setString(1,""+(Long.parseLong(rs2.getString(4))-Long.parseLong(recheckbal)));
									prep1.setString(2,mobile);
									prep1.executeUpdate();
									conection1.close();
								}
								catch(Exception exep)
								{
									System.out.println(exep);
								}


		//_________________________________________________________________________________________________________________________________________________________________-
				//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ADDING TRANSACTION DETAILS TO DATABASE @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

					
								LocalDate ld=LocalDate.now();
								LocalTime lt=LocalTime.now();
								String ldt=ld+"  "+lt;
								String myaccountnumber=null;
								String sendersname=mobile;
					
								try						//@@@@@@@@@@@@@@@ adding to senders transaction detail @@@@@@@@@@@@@
								{
									try
									{
										Class.forName("com.mysql.cj.jdbc.Driver");
										Connection coni=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
										String qi="select * from accountant where ph_no=?";
										PreparedStatement pri=coni.prepareStatement(qi);
										pri.setString(1,mobile);						
										ResultSet rsi=pri.executeQuery();
										if(rsi.next())
										{	myaccountnumber=rsi.getString(1);  sendersname=rsi.getString(3);	}
										coni.close();
									}
									catch(Exception except)
									{
										System.out.println(except);
									}
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection conx=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String qx="INSERT INTO transaction VALUES (?,?,?)";
									PreparedStatement prx=conx.prepareStatement(qx);
									prx.setString(1,myaccountnumber);						//add account number
									prx.setString(2,ldt);
									prx.setString(3,"Rs "+recheckbal+" is debited via. MyPay App");		//add withdrawl amount
									prx.executeUpdate();
									conx.close();
									System.out.println("Data Added");
								}
								catch(Exception exx)
								{
									System.out.println("Error");
									System.out.println(exx);
								}		

								try						//@@@@@@@@@@@@@@@ adding to recievers transaction detail @@@@@@@@@@@@@
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection cony=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String qy="INSERT INTO transaction VALUES (?,?,?)";
									PreparedStatement pry=cony.prepareStatement(qy);
									pry.setString(1,reciever_acc);						//add account number
									pry.setString(2,ldt);
									pry.setString(3,"Rs "+recheckbal+" is credited via. UPI");		//add withdrawl amount
									pry.executeUpdate();
									cony.close();
									System.out.println("Data Added");
								}
								catch(Exception exx1)
								{
									System.out.println("Error");
									System.out.println(exx1);
								}	

								try						//@@@@@@@@@@@@@@@ adding to recievers mypay_transaction detail @@@@@@@@@@@@@
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection concony=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String qqy="INSERT INTO mypay_transaction VALUES (?,?,?)";
									PreparedStatement prpy=concony.prepareStatement(qqy);
									prpy.setString(1,reciever_mob);						//add mobile number
									prpy.setString(2,ldt);
									prpy.setString(3,"Rs "+recheckbal+" Recieved From "+sendersname);		//add  amount
									prpy.executeUpdate();
									concony.close();
									System.out.println("Data Added");
								}
								catch(Exception exxy1)
								{
									System.out.println("Error");
									System.out.println(exxy1);
								}	

								try						//@@@@@@@@@@@@@@@ adding to senders mypay_transaction detail @@@@@@@@@@@@@
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection conconqy=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String qqqy="INSERT INTO mypay_transaction VALUES (?,?,?)";
									PreparedStatement prpqy=conconqy.prepareStatement(qqqy);
									prpqy.setString(1,mobile);						//add mobile number
									prpqy.setString(2,ldt);
									prpqy.setString(3,"Rs "+recheckbal+" Transfered To "+reciever_nm);		//add amount
									prpqy.executeUpdate();
									conconqy.close();
									System.out.println("Data Added");
								}
								catch(Exception exxqy1)
								{
									System.out.println("Error");
									System.out.println(exxqy1);
								}		
	

		//_________________________________________________________________________________________________________________________________________________________________
												
								long recivers_existing_bal=0;

								try														
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection conection3=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String query3="select * from accountant where account_number=?";
									PreparedStatement prep3=conection3.prepareStatement(query3);
									prep3.setString(1,reciever_acc);
									ResultSet rset=prep3.executeQuery();
									if(rset.next())
									{
										recivers_existing_bal=Long.parseLong(rset.getString(4));
									}
									conection3.close();
								}
								catch(Exception exep2)
								{
									System.out.println(exep2);
								}
							
								try														
								{
									Class.forName("com.mysql.cj.jdbc.Driver");
									Connection conection2=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
									String query2="update accountant set balance=? where account_number=?";
									PreparedStatement prep2=conection2.prepareStatement(query2);
									prep2.setString(1,""+(recivers_existing_bal+Long.parseLong(recheckbal)));
									prep2.setString(2,reciever_acc);
									prep2.executeUpdate();
									conection2.close();
								}
								catch(Exception exep1)
								{
									System.out.println(exep1);
								}


		//_________________________________________________________________________________________________________________________________________________________________-
			
							}
						}
						con.close();
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}*/
				}
				else	
				{
					warn.setVisible(true);
					txtf.setText("");
				}
				txtf.setEchoChar(pass);

			}
		});

		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(new Color(100,50,255)));
		cancel.setBackground(new Color(100,50,255));
		cancel.setFont(new Font("southern",Font.BOLD,38));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(5,6,120,40);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
				cl.show(cont,"3");
				warn.setVisible(false);
				txtf.setText("");
			}
		});

		p.add(winu);
		p.add(px);
	}

/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/

	public void addTobillpayed(JPanel p)				//********************* Output fund for Success window ***********************//
	{

		JPanel pane=new JPanel();
		pane.setBounds(0,1,599,70);
		pane.setBackground(Color.YELLOW);
		
		JLabel cleb=new JLabel("TRANSACTION DETAIL");		
		cleb.setFont(new Font("Ariel",Font.BOLD,25));
		cleb.setForeground(Color.BLACK);
		cleb.setBounds(180,10,300,50);
		p.add(cleb);

		ImageIcon i=new ImageIcon("right1.png");
		JLabel l5=new JLabel(i);
		l5.setBounds(230,300,i.getIconWidth(),i.getIconHeight());
		l5.setVisible(true);
		p.add(l5);

		JTextField l4=new JTextField("Transaction Status : "+"Success");
		l4.setHorizontalAlignment(JTextField.CENTER);
		l4.setBounds(0,200,600,30);
		l4.setFont(new Font("southern",Font.BOLD,20));
		l4.setBackground(Color.WHITE);
		l4.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		l4.setForeground(Color.BLACK);
		l4.setEditable(false);
		l4.setVisible(true);
		p.add(l4);

		fundlast2=new JTextField("Transaction ID : "+CreateOTP.genAtmNumber());
		fundlast2.setHorizontalAlignment(JTextField.CENTER);
		fundlast2.setBounds(0,500,600,30);
		fundlast2.setFont(new Font("southern",Font.BOLD,20));
		fundlast2.setBackground(Color.WHITE);
		fundlast2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		fundlast2.setForeground(Color.BLACK);
		fundlast2.setEditable(false);
		fundlast2.setVisible(true);
		p.add(fundlast2);

		fundlast1=new JTextField();
		fundlast1.setHorizontalAlignment(JTextField.CENTER);
		fundlast1.setBounds(0,540,600,30);
		fundlast1.setFont(new Font("southern",Font.BOLD,20));
		fundlast1.setBackground(Color.WHITE);
		fundlast1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		fundlast1.setForeground(Color.BLACK);
		fundlast1.setEditable(false);
		fundlast1.setVisible(true);
		p.add(fundlast1);

		JTextField prog=new JTextField();
		prog.setBounds(-1,900,602,30);
		prog.setBackground(Color.YELLOW);
		prog.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		prog.setForeground(Color.YELLOW);
		prog.setEditable(false);
		p.add(prog);

		JLabel sec=new JLabel("@SECURED");
		sec.setBounds(440,850,170,30);
		sec.setFont(new Font("southern",Font.BOLD,20));
		sec.setForeground(Color.BLACK);
		p.add(sec);

		JButton cancel=new JButton("<<<");
		cancel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
		cancel.setBackground(Color.YELLOW);
		cancel.setFont(new Font("southern",Font.BOLD,38));
		cancel.setForeground(Color.BLACK);
		cancel.setBounds(5,12,120,40);
		p.add(cancel);
		cancel.addActionListener(new ActionListener(){						
			public void actionPerformed(ActionEvent ae)
			{
					cl.show(cont,"3");
			}
		});


		p.add(pane);

	}


/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/


	public void showWindow()				//Adding App Opening Window
	{
		w=new JWindow(this);
		w.setSize(600,1000);
		w.setLayout(null);
		w.setLocationRelativeTo(null);
	
		JPanel winu=new JPanel();
		winu.setLayout(null);
		winu.setBounds(1,1,598,50);
		winu.setBackground(new Color(100,50,255));

		JLabel tit1=new JLabel("APPLICATION BY MyBANK");
		tit1.setFont(new Font("southern",Font.BOLD,20));
		tit1.setBounds(190,5,400,40);
		tit1.setForeground(Color.WHITE);
		winu.add(tit1);
		
		JPanel wind=new JPanel();
		wind.setLayout(null);
		wind.setBounds(0,0,600,1000);
		wind.setBackground(Color.WHITE);
		wind.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		ImageIcon icon=new ImageIcon("lion.jpg");
		JLabel img=new JLabel(icon);
		img.setBounds(120,250,icon.getIconWidth()-80,icon.getIconHeight());

		JLabel tit=new JLabel("MyPAY");
		tit.setFont(new Font("southern",Font.BOLD,50));
		tit.setBounds(230,150,200,70);
		tit.setForeground(Color.BLACK);
		wind.add(tit);	

		JLabel tit3=new JLabel("@TOTALLY SECURED");
		tit3.setFont(new Font("southern",Font.BOLD,20));
		tit3.setBounds(350,900,250,70);
		tit3.setForeground(Color.BLACK);
		wind.add(tit3);	

		ImageIcon icon1=new ImageIcon("upi2.png");
		JLabel img1=new JLabel(icon1);
		img1.setBounds(160,720,icon1.getIconWidth(),icon1.getIconHeight());
		
		wind.add(img);
		wind.add(img1);
		w.add(winu);	
		w.add(wind);		

		w.setVisible(true);

		t1=new Timer(1000,new lap(5));
		t1.start();
		

	}
	
/****************************************************************************************************************************************************************************************
****************************************************************************************************************************************************************************************/


	/*public static void main(String argc[])
	{
		int i;
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1. MyPay");
			System.out.print("Enter The Choice : ");
			i=sc.nextInt();
			switch(i)
			{
				case 1 : new MyPay();
					 break;
			}


		}
	}*/
}