package sample1;

import org.springframework.stereotype.Component;

@Component("myRectangleImpl")
public class RectangleImpl implements Rectangle{

	Shape pointy;
	int x;
	int y;
	
	public RectangleImpl() {
		System.out.println("RectangleImpl() »ý¼ºÀÚ");
	}
	
	public void setPointy(Shape px) {
		//Shape px = new Shape(Pointy)
		this.pointy = px;
	}
	
	public Shape getPointx() {
		return pointy;
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
		return pointy.make();
	}

}
