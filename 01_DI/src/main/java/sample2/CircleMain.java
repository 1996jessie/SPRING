package sample2;

public class CircleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double radius = 10.0;
		PointImpl point = new PointImpl();
		
		point.setXpos(3.0);
		point.setYpos(4.0);
		
		CircleImpl circle = new CircleImpl(radius, point);
		circle.display();
		
	}

}
