package sample2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myRectangleImpl")
public class RectangleImpl implements Rectangle{

	@Autowired
	@Qualifier("PointY") //참조변수
	Shape pointy; // new PointY
	int x;
	int y;
	
	public RectangleImpl() {
		System.out.println("RectangleImpl() 생성자");
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
