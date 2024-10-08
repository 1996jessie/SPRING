package sample6;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import sample5.CalcBean;
import sample5.MessageBean;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonImpl per = new PersonImpl("À±¾Æ", 30, 170.0, "µ¶¼­");
		StudentImpl stu = new StudentImpl();
		stu.setKor(80);
		stu.setEng(90);
		stu.setPer(per);
		
		MyInfo info1 = new MyInfo();
		info1.setStu(stu);
		info1.setPer(per);
		
		info1.personPrint();
		System.out.println();
		info1.studentPrint();
		
		System.out.println("---------------------");
		
		/*
		Resource resource = new ClassPathResource("applicationContext4.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		*/
		
		/*
		ApplicationContext factory = new FileSystemXmlApplicationContext("classpath:applicationContext4.xml");
		*/
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext4.xml");
		
		MyInfo info2 = (MyInfo) factory.getBean("info");
		info2.personPrint();
		System.out.println();
		info2.studentPrint();
	}

}
