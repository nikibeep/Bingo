package pack1;	//note that from now on in order to ensure the class file reaches the other directory we should -d. all the time.
//if it is to be in the same folder no need for -d.
public class Manager extends Employee {	//as long as this is public it can be used outside of the package. via things like mainclass.
	private int empid=100;
	String name ="sss";
	String dept = "cs";
	public void display() {
		System.out.println("ID:"+empid+"\nName:"+name+"\nDept:"+dept);
	}
}