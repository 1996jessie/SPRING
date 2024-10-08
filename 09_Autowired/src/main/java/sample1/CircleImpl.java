package sample1;

public class CircleImpl implements Circle{

	Shape pointx;
	int x;
	int y;
	
	public CircleImpl() {
		System.out.println("CircleImpl() »ý¼ºÀÚ");
	}
	
	public void setPointx(Shape px) {
		//Shape py = new Shape(Pointx)
		this.pointx = px;
	}
	
	public Shape getPointx() {
		return pointx;
	}
	
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public String make() {
		// TODO Auto-generated method stub
		return pointx.make();
	}

}
