package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		Shape px = new PointX();
		Shape py = new PointY();
		
		CircleImpl circle = new CircleImpl();
		circle.setPointx(px);
		System.out.println(circle.make());
		
		System.out.println("-------------");
		RectangleImpl rec = new RectangleImpl();
		rec.setPointy(py);
		System.out.println(rec.make());
		*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/sample2/appContext.xml");
		
		Circle circle = (Circle) context.getBean("myCircleImpl");
		System.out.println(circle.make());
		
		Rectangle rec = (Rectangle) context.getBean("myRectangleImpl");
		System.out.println(rec.make());
		
	}

}
