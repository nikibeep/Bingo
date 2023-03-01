import java.util.*;
// abstract class Account {
 class Account {
    String custname;
    static int acc;
     int accno;
    float balance;
    // final public String bankName = "SBI BANK";
    // abstract float CalculateInterest();
    Account() {
        acc++;
       custname = "Default";
        accno = acc;

    }

    public static void disp(){
        System.out.println(acc);
        System.out.println("yo I'm static method");

    }
    Account(String custname) {
        this.custname = custname;
    }

    Account(String custname, int accno) {
        this(custname); // constructor chaining
        this.accno = accno;
    }

    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Enter the customer name: ");
        custname = sc.nextLine();
        System.out.println("\n Enter the account number: ");
        accno = sc.nextInt();
        System.out.println("\n Enter the account balance: ");
        balance = sc.nextFloat();
        // sc.close();
    }

    public void display() {
        System.out.println("\n customer name: " + custname);
        System.out.println(" the account number: " + accno);
        System.out.println(" the account balance: " + balance);
    }

}

// final class LoanAccount extends Account {
class LoanAccount extends Account {
    float intRate;
    int amountSanc;

    public LoanAccount() {
        super();
        intRate = (float) 0.0;
        amountSanc = 0;
    }

    public LoanAccount(String custname, int accno, float intRate, int amount) {
        super(custname, accno);
        this.intRate = intRate;
        amountSanc = amount;
    }

//    final public void read() {
    public void read() {
        super.read();
        Scanner rr = new Scanner(System.in);
        System.out.println("Enter the Amount sanctioned: ");
        amountSanc = rr.nextInt();
        System.out.println("Enter the Interest rate: ");
        intRate = rr.nextFloat();
        //rr.close();
    }

    public void display() {
        super.display();

        System.out.println(" Interest rate : " + intRate);
        //System.out.println(" Account number : " + accno);
        System.out.println(" Amount sanctioned: " + amountSanc);
    }

}

class CarLoan extends LoanAccount {
    String carcompany, carmodel;
    int carcost;

    CarLoan(String custname, int accno, float intRate, int amount, String comp, String model, int cost) {
        super(custname, accno, intRate, amount);
        carcompany = comp;
        carmodel = model;
        carcost = cost;
    }

    public void read() {
        Scanner cc = new Scanner(System.in);
        super.read();
        System.out.println(" Enter the car company: ");
        carcompany = cc.nextLine();
        System.out.println("Enter the Car Model: ");
        carmodel = cc.nextLine();
        System.out.print(" Enter the car cost: ");
        carcost = cc.nextInt();
        //cc.close();
    }

    public void display() {
        super.display();
        System.out.println(" the car company: " + carcompany);
        System.out.println("Enter the Car Model: " + carmodel);
        System.out.print(" Enter the car cost: " + carcost);
    }
}

public class Feb11 {
    static{
        System.out.println("********************************");
        System.out.println("*** Hello, I'm Static.!! ***");
        System.out.println("********************************");
    }
    public static void main(String[] args){
        //LoanAccount obj = new LoanAccount();
        //LoanAccount obj = new LoanAccount("Aryan", 100, (float) 5.05, 999);
        // CarLoan obj = new CarLoan("Aryan",100, (float) 5.09,999, "Ford", "Mustang", 8900);
        //obj.read();
        //  Account ob = new LoanAccount();
        // Account bb = new Account();
        // System.out.println(bb.bankName);
        //ob.display();
        //bb.display();
        //Account.disp();
        //ob.read();
        //Scanner sc = new Scanner(System.in);
        //sc.close();
    }
}
