package sample5;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CalcBeanImpl calc1 = new CalcBeanImpl(33);
		calc1.setSu1(100);
		calc1.calculate();
		
		MessageBeanImpl mes1 = new MessageBeanImpl("À±¾Æ");
		mes1.setGreeting("Hello");
		mes1.sayHello();
		
		System.out.println("-------------");
		
		Resource resource = new ClassPathResource("applicationContext3.xml");
		
		BeanFactory factory = new XmlBeanFactory(resource);
		
		CalcBean calc2 = (CalcBean) factory.getBean("calc");
		calc2.calculate();
		
		MessageBean mes2 = (MessageBean) factory.getBean("mes");
		mes2.sayHello();
		
	}
	
	
	
		

}
