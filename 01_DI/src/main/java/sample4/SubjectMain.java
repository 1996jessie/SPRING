package sample4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import sample3.Circle;

public class SubjectMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		SubjectImpl sub = new SubjectImpl(70, 80, 90);
		sub.display();
		*/
		
		Resource resource = new ClassPathResource("applicationContext2.xml");
		
		BeanFactory factory = new XmlBeanFactory(resource);
		Subject subject = (Subject) factory.getBean("subject");
		subject.display();
	}

}
