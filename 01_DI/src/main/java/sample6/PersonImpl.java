package sample6;

public class PersonImpl implements Person{
	
	private String name;
	private int age;
	private double height;
	private String hobby;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public PersonImpl(String name, int age, double height, String hobby) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.hobby = hobby;
	}
	
	
}
