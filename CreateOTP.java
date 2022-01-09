package atm_new;
import java.util.*;

public class CreateOTP{

	public static String s1;

	public static String gen()
	{
		Random rand=new Random();
		int i=0;
		s1="";
		while(i<5)
		{
			int x=rand.nextInt(9);
			s1=s1+x;
			i++;
		}
		return s1;
	}

	public static String gen1()
	{
		Random rand=new Random();
		int i=0;
		s1="";
		while(i<4)
		{
			int x=rand.nextInt(9);
			s1=s1+x;
			i++;
		}
		return s1;
	}

	public static String genAtmNumber()
	{
		Random rand=new Random();
		int i=0;
		s1="";
		while(i<8)
		{
			int x=rand.nextInt(9);
			s1=s1+x;
			i++;
		}
		return s1;
	}

	public static String genCvv()
	{
		Random rand=new Random();
		int i=0;
		s1="";
		while(i<3)
		{
			int x=rand.nextInt(9);
			s1=s1+x;
			i++;
		}
		return s1;
	}

}