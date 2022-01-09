package atm_new;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class BankTable extends JFrame
{
	BankTable()
	{
		this.setSize(1900,1000);
		Container c=this.getContentPane();
		this.setLocationRelativeTo(null);
		ImageIcon i1=new ImageIcon("lion.jpg");		//Adding Image
		this.setIconImage(i1.getImage());
		this.setTitle("Accountant's Information Of MyBANK");

		Object[][] data={};
		String [] column={"Account Number","Name","Phone Number","Balance","Pan","DOB","Address","Account Type","Gender","Atm Pin","Atm Card Number","cvv"};
		DefaultTableModel model=new DefaultTableModel(data,column);
		JTable tbl=new JTable(model);
		this.add(new JScrollPane(tbl));

		Connection con=null;

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
			String q="select * from accountant";
			Statement st=con.createStatement();
			ResultSet set=st.executeQuery(q);

			while(set.next())
			{
				String acc_num=set.getString(1);
				String ph=set.getString(2);
				String name=set.getString(3);
				String bal=set.getString(4);
				String pan=set.getString(5);
				String dob=set.getString(6);
				String add=set.getString(7);
				String type=set.getString(8);
				String gen=set.getString(9);
				String pin=set.getString(10);
				String atm_num=set.getString(11);
				String cvv_num=set.getString(12);

				Object[] row={acc_num,name,ph,bal,pan,dob,add,type,gen,pin,atm_num,cvv_num};
				model.addRow(row);
				
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		validate();	
	}
	

	/*public static void main(String []argc)
	{
		new BankTable();
	}*/

}