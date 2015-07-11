package practiceJava;

public class Faculty extends Employee {
	public static void main(String[] args) {
		Faculty f = new Faculty();
		Faculty g = new Faculty("Mark", 22);
		//Faculty g = new Faculty("Mark", -1);//test exception
		g.printFacultyInfo();
		System.out.println(g);
		printInfo(new Object());
		printInfo(new Person());
		printInfo(new Employee());
		printInfo(new Faculty());
	}
	public Faculty() {
		System.out.println("construct a Faculty.");
	}
	public Faculty(String name, int age){
		this();//call the constructor without parameters.
		setAge(age);// setAge(age), this.setAge(age) or super.setAge(age) are all OK.
		//because Faculty has inherited the setAge method from Employee.
		this.setName(name);
//		super(name, age);
	}
	public void printFacultyInfo(){
		System.out.println(String.format("name is %s, age is %d", this.getName(), this.getAge()));
	}
	public String toString(){
		//overriding
		//call the overrided method with "super" keyword
		return "a Facutly is " + super.toString();
	}
	public static void printInfo(Object o){
		System.out.println(o.toString());
	}
}

class Employee extends Person {
	public Employee() {
		System.out.println("construct an Emplyee.");
	}
	public Employee(String name, int age){
		super(name, age);
	}
	public double getSalary(){
		return salary;
	}
	public void setSalary(double salary){
		this.salary = salary;
	}
	public String toString(){
		return "an Employee";
	}
	private double salary;
}

class Person {
	public Person() {
		System.out.println("construct a Person.");
	}
	public Person(String name, int age){
		setName(name);
		setAge(age);
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age) throws IllegalArgumentException{
		if(age < 0){
			throw new IllegalArgumentException("age should not be negative number.");
		}
		this.age = age;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String toString(){
		return "a Person";
	}
	private int age;
	private String name;
}
