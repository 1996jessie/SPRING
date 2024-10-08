package sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class CircleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		double radius = 10.0;
		PointImpl point = new PointImpl();
		
		point.setXpos(3.0);
		point.setYpos(4.0);
		
		CircleImpl circle = new CircleImpl(radius, point);
		circle.display();
		*/
		
		//이 부분 안 쓰면 객체 안 만들어짐
		Resource resource = new ClassPathResource("applicationContext.xml"); //이 경로로 가서 필요한 자원이 있는지 검토
		
		BeanFactory factory = new XmlBeanFactory(resource); //bean 공장에서 bean울 2개 만들었음
		Circle circle = (Circle) factory.getBean("circle"); //circle이라는 아이디로 설정한 bean을 가져와라 //Object 리턴 >> 다운캐스팅
		circle.display();
		
		System.out.println("-----------------------------");
		
		Point point = (Point) factory.getBean("point");
		
		System.out.println("xpos : " + point.getXpos());
		System.out.println("ypos : " + point.getYpos());
		
	}

}

/*
 * IoC(Inversion of Control) : 제어의 역전 : 이전까지 개발자의 역할을 spring controller가 하게 함
 */