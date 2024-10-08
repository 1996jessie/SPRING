package sample1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape px = new PointX();
		Shape py = new PointY();
		
		CircleImpl circle = new CircleImpl();
		circle.setPointx(px);
		System.out.println(circle.make());
		
		System.out.println("-------------");
		RectangleImpl rec = new RectangleImpl();
		rec.setPointy(py);
		System.out.println(rec.make());
	}

}
