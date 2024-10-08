package sample2;

public class CircleImpl implements Circle{
	private double radius;
	/*
	private double xpos; 
	private double ypos;
	*/
	private PointImpl point; //포함관계
	
	public CircleImpl(double radius, PointImpl point) {
		super();
		this.radius = radius;
		this.point = point;
	}
	
	public void display() {
		System.out.println("원의 중심 좌표 : " + point.getXpos() + ", " + point.getYpos());
		System.out.println("원의 면적 : " + Math.PI * Math.pow(radius,  2.0));
		
	}
}

//생성자 통해서 값으로 주입(injection)