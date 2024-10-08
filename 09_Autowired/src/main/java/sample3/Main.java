package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ApplicationContext context = new ClassPathXmlApplicationContext("/sample3/appContext2.xml");
		AbstractApplicationContext context = new GenericXmlApplicationContext("appContext2.xml");
		//현재 패키지에 넣었으면 현재 패키지명/파일명 써야 함
		//resources에 넣었으면 파일명만 써도 됨
		
		//Person person = (Person) context.getBean("Consumer");
		//Consumer person = (Consumer) context.getBean("Consumer");
		//Person person = (Consumer) context.getBean("Consumer");
		Person person = context.getBean("Consumer", Person.class);
		
		person.setName("웬디");
		person.setAge(30);
		person.personDrive();
		System.out.println(person.getName());
		System.out.println(person.getAge());
		System.out.println(person.personDrive());
	
	}

}
