package sample1;

public class Circle {
	private double radius;
	/*
	private double xpos; 
	private double ypos;
	*/
	private Point point; //포함관계
	
	public Circle(double radius, Point point) {
		super();
		this.radius = radius;
		this.point = point;
	}
	
	public void display() {
		System.out.println("원의 중심 좌표 : " + point.getXpos() + ", " + point.getYpos());
		System.out.println("원의 면적 : " + Math.PI * Math.pow(radius,  2.0));
		
	}
}
