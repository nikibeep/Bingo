package pack1;		//when we compile this as javac -d. <name> it will auto create a directory as package name and place the compiled class file there.
abstract class Employee{	//this is default which is accessible anywhere in package. thus manager can access it. thus main can access thru manager.
	private String empname;		//this class is not directly accessible to mainclass outside the package
	private int empid;
	abstract void display();
}