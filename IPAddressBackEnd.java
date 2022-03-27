import java.util.Scanner;
public class IPAddressBackEnd
{
	static String IPv4var ="";   //IPv4var ="";error=0;int f1,f2,f3,f4=0;type="";snm="";j=0,max=12;
	static int error=0;
	static String fill1="";
	static String fill2="";
	static String fill3="";
	static String fill4="";
	static int f1,f2,f3,f4;
	static String type="";
	static String snm="";
	static int j=0,max=12;
	static boolean notNumber=false;
	static String arr[]=new String[max];
	static String IPv4;
	
	public static void main(String arg [])
	{
		System.out.println("This is the checker");
		checker(IPv4var);
		defaultInitializer();
	}
	
	static void checker(String IPv4var)
	{
		//Scanner sc=new Scanner(System.in);
		System.out.println("IP address checker");
		//System.out.println("Enter the IPv4:");
		//String IPv4=sc.next();
		
		IPv4=IPv4var;                                 //alteration requirement
		
		System.out.println("U entered :"+IPv4);
		int len=IPv4.length();
		
		numberChecker(IPv4);             //calling the functions
		if(notNumber==false)
		{
			dotChecker(IPv4);
			ipDivider(IPv4);
			emptyFillChecker();
			startNumberZero();
			addressGenerator();
			if(fill1!="" && fill2!="" && fill3!="" && fill4!="")
			rangeChecker();
			if(fill1!="")
				ipClassType();
			output();
		}
		
	}

//-----------------------------------------------------------------------------------
	public static void numberChecker(String IPv4)        //numberChecker
	{
		int a=error;
		for(int i=0; i<IPv4.length();i++)
		{
			if(IPv4.charAt(i)=='.'|| IPv4.charAt(i)>='0' && IPv4.charAt(i)<='9')
			{}    // or just ; can be used
			else
			{
				System.out.println("Error:number not present at the address fill");
				notNumber=true;
				error++;
				arr[j]="Non-numeric charecter found:correct this to proceed!";
				j++;
				break;
			}
		}
		if(a==error)
			System.out.println("Number checker passed !");
	}
	
	public static void dotChecker(String IPv4)            //Dot Checker
	{
		int dotC=0;
		for(int i=0; i<IPv4.length();i++)
		{
			if(IPv4.charAt(i)=='.')
			dotC++;
		}
		if(dotC!=3)
			{
			System.out.println("Less/More no. of host/network addresses");
			error++;
			arr[j]="Less/More no. of host/network addresses (more/less than 3 dots)";
			j++;
			}
		else
			System.out.println("Dot count filter passed !");
	}
	
	public static void ipDivider(String IPv4)           //ipDivider : generates fills in "String form"
	{
		
		int dotC=0;
		for(int i=0; i<IPv4.length();i++)
		{
			if(IPv4.charAt(i)!='.')
			{
				if(dotC==0)
					fill1=fill1+IPv4.charAt(i);
				else if(dotC==1)
					fill2=fill2+IPv4.charAt(i);
				else if(dotC==2)
					fill3=fill3+IPv4.charAt(i);
				else if(dotC==3)
					fill4=fill4+IPv4.charAt(i);
			}
			else
				dotC++;
		}
		System.out.println("FILLS ARE :-");
		System.out.println("fill1="+fill1);
		System.out.println("fill2="+fill2);
		System.out.println("fill3="+fill3);
		System.out.println("fill4="+fill4);
		
	}
	                                                       //emptyFillChecker
	public static void emptyFillChecker()
	{
		if(fill1==null||fill2==null||fill3==null||fill4==null)
		{
			System.out.println("Empty fill found");
			error++;
			arr[j]="Empty fill found";
			j++;
		}
		else
			System.out.println("Empty fill filter passed !");
	}
	                                                      //statrNumberZero
	public static void startNumberZero()
	{
		if((fill1.length()!=0 &&  fill1.charAt(0)=='0'&&fill1.length()>1) || ( fill2.length()!=0 &&fill2.charAt(0)=='0'&&fill2.length()>1 ) ||( fill3.length()!=0 &&fill3.charAt(0)=='0'&&fill3.length()>1 ) || ( fill4.length()!=0 && fill4.charAt(0)=='0'&&fill4.length()>1))
			{
				System.out.println("0 at first position found of one of the fills");
				error++;
				arr[j]="0 as MSD in 2/3 digit number";
				j++;
			}
		else
			System.out.println("0@first filter passed !");
	}
	
	public static void addressGenerator()                //addressGenerator
	{
		if( fill1.length()!=0)
			f1=Integer.parseInt(fill1);
		else
		{
			System.out.println("1st fill is empty");
			f1=-1;
			error++;
			arr[j]="1st fill is empty";
			j++;
		}
		if( fill2.length()!=0)
			f2=Integer.parseInt(fill2);
		else
		{
			System.out.println("2nd fill is empty");
			f2=-1;
			error++;
			arr[j]="2nd fill is empty";
			j++;
		}
		
		if( fill3.length()!=0)
			f3=Integer.parseInt(fill3);
		else
		{
			System.out.println("3rd fill is empty");
			f3=-1;
			error++;
			arr[j]="3rd fill is empty";
			j++;
		}
		
		if( fill4.length()!=0)
			f4=Integer.parseInt(fill4);
		else
		{
			System.out.println("4th fill is empty");
			f4=-1;
			error++;
			arr[j]="4th fill is empty";
			j++;
		}
	
	}
	
	public static void rangeChecker()                   //rangeChecker
	{
		if((0<=f2 && f2<=255) && (0<=f3 && f3<=255) && (0<=f4 && f4<=255))
		{
			System.out.println("fill 2,3,4 filter passed !");
		}
		else
		{
			System.out.println("Invalid range for fill 2/3/4");
			error++;
			arr[j]="Invalid range for fill 2/3/4";
			j++;
		}
	}
	
	public static void ipClassType()                   //ipClassType
	{
		if(f1>=0 && f1<=127)
		{
			type="Class A";
			snm="255.0.0.0";
		}
		else if(f1>=128 && f1<=191)
		{
			type="Class B";
			snm="255.255.0.0";
		}
		else if(f1>=192 && f1<=223)
		{
			type="Class C";
			snm="255.255.255.0";
		}
		else if(f1>=224 && f1<=239)
		{
			type="Class D";
		}
		else if(f1>=240 && f1<=255)
		{
			type="Class E";
		}
		else
		{
			System.out.println("fill1 number greater than the range");
        	error++;
        	arr[j]="Fill 1's number greater than the range";
        	j++;
		}
	}
	
	static void output()                      //output
	{
		//Printing the result
		System.out.println("\nNumber of errors:"+error+"\n");
		System.out.println("---------------------------------------------\n");
		System.out.println("\t   RESULT :");
		if(error>0)
		{
			System.out.println("\nErrors in IP:\n");
			max=j;
			for(int i=0;i<max;i++)
			{
				System.out.println((i+1)+"."+arr[i]);
			}
		}
		else
		{
			System.out.println("\nIP address "+IPv4+" is valid");
			System.out.println("Class :"+type);
			if(snm!="")
			System.out.println("Subnet Mask :"+snm);
		}
		System.out.println("j="+j);
		System.out.println("---------------------------------------------");
	}
	static void defaultInitializer()
	{
		fill1="";
		fill2="";
		fill3="";
		fill4="";
		type="";
		snm="";
		IPv4var ="";
		error=0;
		notNumber=false;
		int f1,f2,f3,f4=0;
		j=0;
		max=12;
		IPv4var ="";
	}
	
	
}
