package atm_new;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.time.*;

class Admin extends JFrame implements ActionListener{


	Admin()
	{
		
		JFrame f=new JFrame();
		ImageIcon ic=new ImageIcon("atm.jfif");
		ImageIcon icon=new ImageIcon("formicon.jpg");

		f.setIconImage(ic.getImage());
		f.setLocation(500,100);
		f.setSize(1000,830);
		f.setTitle("MY BANK");
		f.setResizable(false);
		Container cnt=f.getContentPane();
		//cnt.setBackground(Color.YELLOW);
		f.setLayout(null);

		addTo(f);

		JLabel back=new JLabel(icon);
		back.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		f.add(back);

		f.setVisible(true);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addTo(JFrame f)
	{

		 JLabel lname,ladd,laadhar,lph,lmsg,lgender,ldob,lacc,lbal;
		 JTextField tname,taadhar,tph,tadd,tbal;
		 JComboBox cdate,cmonth,cyear;
		 JButton bsubmit;
		 JRadioButton rbmale,rbfemale,rbother,rbsaving,rbcurrent;


		//Adding Labeles
		lmsg =new JLabel("ACCOUNT OPENING FORM");
		lmsg.setFont(new Font("Ariel",Font.BOLD,25));
		lmsg.setForeground(Color.YELLOW);
		lmsg.setBounds(300,0,400,50);
		f.add(lmsg);

		lname =new JLabel("Accountant's Name : ");
		lname.setFont(new Font("Ariel",Font.BOLD,20));
		lname.setForeground(Color.WHITE);
		lname.setBounds(20,100,300,50);
		f.add(lname);

		laadhar =new JLabel("Accountant's PAN : ");
		laadhar.setForeground(Color.WHITE);
		laadhar.setFont(new Font("Ariel",Font.BOLD,20));
		laadhar.setBounds(20,170,300,50);
		f.add(laadhar);

		ldob =new JLabel("Accountant's DOB : ");
		ldob.setForeground(Color.WHITE);
		ldob.setFont(new Font("Ariel",Font.BOLD,20));
		ldob.setBounds(20,380,300,50);
		f.add(ldob);

		lph =new JLabel("Accountant's Mobile NO. : ");
		lph.setForeground(Color.WHITE);
		lph.setFont(new Font("Ariel",Font.BOLD,20));
		lph.setBounds(20,240,300,50);
		f.add(lph);

		lgender =new JLabel("Accountant's Gender : ");
		lgender.setForeground(Color.WHITE);
		lgender.setFont(new Font("Ariel",Font.BOLD,20));
		lgender.setBounds(20,310,300,50);
		f.add(lgender);

		ladd =new JLabel("Accountant's Address : ");
		ladd.setForeground(Color.WHITE);
		ladd.setFont(new Font("Ariel",Font.BOLD,20));
		ladd.setBounds(20,450,300,50);
		f.add(ladd);

		lacc =new JLabel("Accountant To Create : ");
		lacc.setForeground(Color.WHITE);
		lacc.setFont(new Font("Ariel",Font.BOLD,20));
		lacc.setBounds(20,520,300,50);
		f.add(lacc);

		//Adding Radio button
		rbmale=new JRadioButton("Male");
		rbmale.setSelected(true);
		rbmale.setFont(new Font("Ariel",Font.BOLD,20));
		rbmale.setBounds(320,320,100,30);
		f.add(rbmale);

		rbfemale=new JRadioButton("Female");
		rbfemale.setFont(new Font("Ariel",Font.BOLD,20));
		rbfemale.setBounds(490,320,100,30);
		f.add(rbfemale);

		rbother=new JRadioButton("Other");
		rbother.setFont(new Font("Ariel",Font.BOLD,20));
		rbother.setBounds(660,320,100,30);
		f.add(rbother);

		ButtonGroup group=new ButtonGroup();
		group.add(rbmale);
		group.add(rbfemale);
		group.add(rbother);

		rbsaving=new JRadioButton("Saving");
		rbsaving.setSelected(true);
		rbsaving.setFont(new Font("Ariel",Font.BOLD,20));
		rbsaving.setBounds(320,520,100,30);
		f.add(rbsaving);

		rbcurrent=new JRadioButton("Current");
		rbcurrent.setFont(new Font("Ariel",Font.BOLD,20));
		rbcurrent.setBounds(490,520,100,30);
		f.add(rbcurrent);

		ButtonGroup grp=new ButtonGroup();
		grp.add(rbsaving);
		grp.add(rbcurrent);
	
		ladd =new JLabel("Account Opening Balance : ");
		ladd.setForeground(Color.WHITE);
		ladd.setFont(new Font("Ariel",Font.BOLD,20));
		ladd.setBounds(20,590,300,50);
		f.add(ladd);

		//Adding ComboBox
		String dt[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		cdate=new JComboBox(dt);
		cdate.setSelectedItem("1");
		cdate.setFont(new Font("Ariel",Font.BOLD,20));
		cdate.setBounds(320,390,50,30);
		f.add(cdate);

		String mt[]={"JAN","FEB","MARCH","APRIL","MAY","JUNE","JULY","AUG","SEP","OCT","NOV","DEC"};
		cmonth=new JComboBox(mt);
		cmonth.setSelectedItem("JAN");
		cmonth.setFont(new Font("Ariel",Font.BOLD,20));
		cmonth.setBounds(400,390,100,30);
		f.add(cmonth);

		String yr[]={"1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021"};
		cyear=new JComboBox(yr);
		cyear.setSelectedItem("1999");
		cyear.setFont(new Font("Ariel",Font.BOLD,20));
		cyear.setBounds(530,390,80,30);
		f.add(cyear);

		//Adding TestField
		tname=new JTextField();
		tname.setFont(new Font("Ariel",Font.BOLD,20));
		tname.setBounds(320,110,300,30);
		f.add(tname);

		taadhar=new JTextField();
		taadhar.setFont(new Font("Ariel",Font.BOLD,20));
		taadhar.setBounds(320,180,300,30);
		f.add(taadhar);

		tph=new JTextField();
		tph.setFont(new Font("Ariel",Font.BOLD,20));
		tph.setBounds(320,250,300,30);
		f.add(tph);

		tadd=new JTextField();
		tadd.setFont(new Font("Ariel",Font.BOLD,20));
		tadd.setBounds(320,460,300,30);
		f.add(tadd);

		tbal=new JTextField();
		tbal.setFont(new Font("Ariel",Font.BOLD,20));
		tbal.setBounds(320,590,300,30);
		f.add(tbal);

		JLabel lwar1=new JLabel("*PHONE NUMBER MUST BE 10 DIGIT");
		lwar1.setVisible(false);
		lwar1.setFont(new Font("Ariel",Font.BOLD,19));
		lwar1.setForeground(Color.RED);
		lwar1.setBounds(650,250,400,30);
		f.add(lwar1);

		JLabel lwar2=new JLabel("*MINIMUM BALANCE 3000");
		lwar2.setVisible(false);
		lwar2.setFont(new Font("Ariel",Font.BOLD,20));
		lwar2.setForeground(Color.RED);
		lwar2.setBounds(650,590,400,30);
		

		//Adding Submit button
		bsubmit=new JButton("Submit");
		bsubmit.setBounds(400,670,150,50);
		//bsubmit.setBackground(Color.YELLOW);
		bsubmit.setFont(new Font("Ariel",Font.BOLD,20));
		f.add(bsubmit);
		bsubmit.addActionListener(this);

		bsubmit.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				int len=tph.getText().length();
				if(len!=10)
				{
					tph.setText("");
					lwar1.setVisible(true);
				}
				else
				{
				
				int x=0;
				if(tbal.getText().equalsIgnoreCase(""))
				{
					x=0;
				}
				else
				{
					x=Integer.parseInt(tbal.getText());
				}
				
				if(x<3000)
				{
					tbal.setText("");
					lwar2.setVisible(true);
				}		
				else
				{
					boolean let=false;
					Connection con=null;	
					Connection con1=null;
					long ll=10000000;
					String acc=null;
					String birth=cdate.getSelectedItem()+"/"+cmonth.getSelectedItem()+"/"+cyear.getSelectedItem();
					String gen;
					String pin=""+CreateOTP.gen1();
					String atm_no=CreateOTP.genAtmNumber();
					String cvv=""+CreateOTP.genCvv();
					if(rbmale.isSelected())
					{
						gen="Male";
					}
					else if(rbfemale.isSelected())
					{
						gen="Female";
					}
					else
					{
						gen="Other";
					}
			
					String type;
					if(rbcurrent.isSelected())
					{
						type="Current";
					}
					else
					{
						type="Saving";
					}
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
						con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
						String query="SELECT * FROM accountant";
						Statement stmt=con1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
						ResultSet rs=stmt.executeQuery(query);
						rs.last();
						ll=Long.parseLong(rs.getString(1))+1;
						con1.close();

					}
					catch(SQLException s)
					{
						System.out.println(s);
						try{
							con1.close();
						}
						catch(Exception k)
						{	
							System.out.println(k);
						}
						
					}
					catch(Exception exc)
					{
						System.out.println("Connection Lost");
						try{
						con1.close();}catch(Exception k){System.out.println(k);}
					}

					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
						String query="INSERT INTO accountant (account_number,name,ph_no,balance,dob,aadhar,address,account_type,gender,atm_pin,atm_number,cvv) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement pr=con.prepareStatement(query);
						acc=""+ll;
						pr.setString(1,acc);
						pr.setString(2,tname.getText());
						pr.setString(3,tph.getText());
						pr.setString(4,tbal.getText());
						pr.setString(5,birth);
						pr.setString(6,taadhar.getText());
						pr.setString(7,tadd.getText());
						pr.setString(8,type);
						pr.setString(9,gen);
						pr.setString(10,pin);
						pr.setString(11,atm_no);
						pr.setString(12,cvv);
						pr.executeUpdate();
						con.close();
						let=true;

						LocalDate ld=LocalDate.now();
						LocalTime lt=LocalTime.now();
						String ldt=ld+"  "+lt;
		
						try
						{
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
							String q="INSERT INTO transaction VALUES (?,?,?)";
							PreparedStatement prp=conn.prepareStatement(q);
							prp.setString(1,acc);
							prp.setString(2,ldt);
							prp.setString(3,"Rs "+tbal.getText()+" credited as A/C opening balance");
							prp.executeUpdate();
					
							conn.close();
							System.out.println("Data Added");
	
						}
						catch(Exception ex)
						{
							System.out.println("Error");
							System.out.println(ex);
						}

					}
					catch(SQLException s)
					{
						System.out.println(s);
						JOptionPane.showMessageDialog(f,"Phone Number Is Already Linked With Other Account","ERROR",JOptionPane.ERROR_MESSAGE);
						try{
							con.close();
						}
						catch(Exception k)
						{	
							System.out.println(k);
						}
						
					}
					catch(Exception exc)
					{
						System.out.println(e);
						try{
							con.close();
						}
						catch(Exception k)
						{	
							System.out.println(k);
						}
					}
					
					
					tph.setText("");tname.setText("");taadhar.setText("");tadd.setText("");tbal.setText("");
					rbmale.setSelected(true);
					rbsaving.setSelected(true);
					cdate.setSelectedItem("1");
					cmonth.setSelectedItem("JAN");
					cyear.setSelectedItem("1999");	
					lwar1.setVisible(false);
					lwar2.setVisible(false);			

					f.dispose();
					if(let)
					{
						JOptionPane.showMessageDialog(f,"Accountant Is Added","SUCCESS",JOptionPane.PLAIN_MESSAGE);
						JOptionPane.showMessageDialog(f,"Account Number : "+acc+"\nATM CARD NUMBER : "+atm_no+"\nATM PIN : "+pin+"\nCVV : "+cvv,"KEEP CONFEDENTIAL",JOptionPane.PLAIN_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(f,"Account Is Not Created","FAILUER",JOptionPane.WARNING_MESSAGE);
					}
					
				}
				}//end of else outer
			}

		});
		
		f.add(lwar2);

	}

	/*public static void main(String argc[])
	{
		while(true)
		{
			System.out.println("1. Add Accountant\n2. Show Accountant");
			System.out.print("Enter The Choice : ");
			java.util.Scanner sc=new java.util.Scanner(System.in);
			int k=sc.nextInt();
			sc.nextLine();

			switch(k)
			{
				case 1 : new Admin();
					 break;

				case 2 : new BankTable();
					 break;

				default : System.exit(0);
			}

		}
		
	}*/

	public void actionPerformed(ActionEvent e)
	{
		
	}




}