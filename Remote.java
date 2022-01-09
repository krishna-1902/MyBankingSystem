package atm_new;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.time.*;
import java.util.Scanner;

public class Remote extends JFrame
{

	private JFrame f;
	private Container cont;
	private CardLayout cl;
	private JPanel main;

	Remote()
	{
		this.setSize(300,400);
		cl=new CardLayout();
		this.setLayout(cl);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		f=this;
		cont=this.getContentPane();

		addTo();

		
		
		ImageIcon i1=new ImageIcon("symbol2.jpg");		//Adding Image
		this.setIconImage(i1.getImage());
		this.setTitle("Remote");
		//cont.setBackground(Color.YELLOW);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		validate();
	}

	public void addTomain(JPanel p)
	{
		JButton emp=new JButton();
		emp.setBounds(27,20,240,5);
		emp.setFont(new Font("Ariel",Font.BOLD,18));
		emp.setForeground(Color.BLACK);
		emp.setBackground(new Color(231,231,231));
		emp.setBorder(BorderFactory.createLineBorder(new Color(54,54,54)));
		p.add(emp);
		
		JButton addacc=new JButton("Add Accountant");
		addacc.setBounds(55,60,180,40);
		addacc.setFont(new Font("Ariel",Font.BOLD,18));
		addacc.setForeground(Color.BLACK);
		addacc.setBackground(new Color(248,66,66));
		addacc.setBorder(BorderFactory.createLineBorder(new Color(248,66,66)));
		p.add(addacc);
		addacc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				new Admin();	
			}
		});

		JButton showacc=new JButton("Show Accountant");
		showacc.setBounds(55,130,180,40);
		showacc.setFont(new Font("Ariel",Font.BOLD,18));
		showacc.setForeground(Color.BLACK);
		showacc.setBackground(new Color(67,250,79));
		showacc.setBorder(BorderFactory.createLineBorder(new Color(134,255,103)));
		p.add(showacc);
		showacc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				new BankTable();	
			}
		});


		JButton mypayapp=new JButton("MyPay");
		mypayapp.setBounds(55,200,180,40);
		mypayapp.setFont(new Font("Ariel",Font.BOLD,18));
		mypayapp.setForeground(Color.BLACK);
		mypayapp.setBackground(new Color(253,173,0));
		mypayapp.setBorder(BorderFactory.createLineBorder(new Color(253,173,0)));
		p.add(mypayapp);
		mypayapp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				new MyPay();	
			}
		});

		JButton atm=new JButton("ATM");
		atm.setBounds(55,270,180,40);
		atm.setFont(new Font("Ariel",Font.BOLD,18));
		atm.setForeground(Color.BLACK);
		atm.setBackground(new Color(108,97,253));
		atm.setBorder(BorderFactory.createLineBorder(new Color(108,97,253)));
		p.add(atm);
		atm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				new MyFrame();	
			}
		});
		

	}

	public void addTo()
	{

		main = new JPanel();
		main.setLayout(null);
		main.setBackground(new Color(207,208,226));
		main.setBounds(0,0,300,800);
		this.add(main,"1");
		addTomain(main);

	}

	public static void main(String argc[])
	{
		new Remote();
	}
}

