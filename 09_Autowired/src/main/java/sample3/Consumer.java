package sample3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("Consumer")
public class Consumer implements Person {


	private String name;
	private int age;
	
	@Autowired
	@Qualifier("Morning")
	private Car car;
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setAge(int age) {
		// TODO Auto-generated method stub
		this.age = age;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}

	@Override
	public String personDrive() {
		// TODO Auto-generated method stub
		return car.drive();
	}

}
