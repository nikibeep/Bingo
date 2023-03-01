import java.util.Scanner;
//EVERY CLASS IN JAVA BY DEFAULT INHERITS FROM THE CLASS 'OBJECT'
class Account{
	private String cname;	//different access specifiers have different scopes.
	int anum; //remember no specifier means default specifier. there is no keyword default.
	static int acc;	//static keyword retains it value even when its scope is over. multiple objects of this class will share the static value and ops.
	//static vars are given only 1 mem space in code area which all the objects share. new assignments in ob2 will repllace old value in ob1. ops in ob1 will change value for ob2 also. thus it it not prefereable to use static variables just like that. 
	private float bal;	//private members are not inheritable. they can be accessed via super and with public methods but not directly in the child classes. 
	//if the data members are public all the access is possible and there will be no errors.
	final public String bankName = "Bank Bank";	//final now means cannot change this memeber value. other class can inherit it but no  one can change it anywhere. 
	public Account(){
		acc++; cname=""; anum=-1;anum=acc;
	}
	public Account(String name){
		this.cname=name;
	}
	public Account(String name, int num){
		this(name);	//constructor chaining
		this.anum=num;
	}
	static{System.out.println("Hello");}	//static block. will always be autocalled as long as an object of class exists
	public static void statdisp(){	//static function
		System.out.println(acc);
		//System.out.println(anum);	//non static cannot be accessed inside static fn.
//variable created within static fn like in main are considered static.
	}
	public void read(){
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter customer name");
		cname= sc.nextLine();
		System.out.println("Enter account number:");
		anum = sc.nextInt();
		System.out.println("Enter account balance");
		bal = sc.nextFloat();
		sc.close();
	}
	public void display(){
		System.out.println("Name:"+cname+"\nAccNum:"+anum+"\nBalance:"+ bal);
	}
}
class LoanAcc extends Account{	//if we make the class final, then carLoan should not happen so error:"Cannot inherit from final class". 
	float intRate;
	int amnSanc;	//thus this class will have these attributes + the 3 inherited attributes
	public LoanAcc(){
		super();	//super=immediate parent class.
		intRate=(float)0.0;
		amnSanc=0;
	}
	public LoanAcc(String name,int ano, float ir, int amnt){
		super(name,ano);
		this.intRate=ir; 
		amnSanc=amnt;
	}
	public void read(){				//if we make this final, error"Cannot override function" (this happens in carLoan, but with final is not allowed). the super read does not matter here since final is applied to this and not super.read(). 
		super.read();
		try{
		Scanner sc=new Scanner(System.in);
		super.read();
		System.out.println("Enter interest rate:");
		intRate=sc.nextFloat();
		System.out.println("Enter max amnt sanctioned:");
		amnSanc = sc.nextInt();
		sc.close();
		}
		catch(Exception e){System.out.println(e.toString());}  //try catch exception handling example. not rly needed in this code
	}
	public void display(){
		super.display();
		System.out.println("\nInterest Rate:"+intRate+"\nSanctioned amount:"+amnSanc);
	}
}
class CarLoan extends LoanAcc{	//will have both the inherited class attributes and methods.
	String company;
	String model;
	int cost;
	public CarLoan(String name, int num, float ir, int amnt, String co, String mn, int c){
		super(name,num,ir,amnt);
		company=co;	model=mn; cost=c;
	}
	public void read(){
		super.read();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter company name:");
		company = sc.nextLine();
		System.out.println("Enter model name:");
		model = sc.nextLine();
		System.out.println("Enter model cost:");
		cost = sc.nextInt();
		sc.close();
	}
	public void display(){
		super.display();
		System.out.println("\nCompany:"+company+"\nModel:"+model+"\nCost:"+cost);
	}
}
public class Inheritance{	//since each parent-child is 1-1, this is all single inheritance. but it is multiLEVEL inheritance
	static{System.out.println("RunningMain");}	//since this is the root class this static will be autocalled and display at runtime even if main is empty.
//static blocks offer advantage of being like a preload thing which will always be executed first even before obj creation in the main.
	public static void main(String[] args){	//because main is static it can be auto called via just calling the class with java <classname>
		//Account.statdisp();//static fn can be accessed w/o obj. can directly be used with the class name.
		//Account o1 = new Account(); o1.display();
		//o1.statdisp();
		Account a1 = new Account();	
		//a1.read();					//whether a1 is Account/LoanAcc/CarLoan the read function can be called since each class has its own read fn.
		a1.bankName = "newname";	//will show error "Cannot assign value to final variable.
		//Account o2 = new Account(); o2.display();	//acc/anum will show as 2 because static retains the value across the scopes. 
		//LoanAcc l1 = new LoanAcc("name",234,(float)8.8,3333);
		//o1.read();
		//o1.display();
		// l1.read();
		//l1.display();
		//CarLoan cl1 = new CarLoan("CustName",223,(float)6.8,1000,"Company","Model",10000);
		//cl1.display();
		//System.out.println(o1.cname);
		
	}
	//if one tries to instatiate an abstract class, error:"Cannot be instantiated".
}
//types of inheritance: single, multiple, multilevel, hierarchical, hybrid.
//the various read functions in each class are examples of function overriding.
//the various constructors in each class are examples of function (specificaly constructor) overloading.
//in the above, if the reads had different names, the super would not be necessary to call them in the child classes. there is no overriding.
//protected- only within class and children. public- everywhere. default-anaywhere inside the package
//public and protected have no difference within the package.
//simply put - public protected and default are p much the same inside the package. only when another package tries to access is there a difference.