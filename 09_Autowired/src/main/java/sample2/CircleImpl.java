package sample2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myCircleImpl") //CircleImpl myCircleImpl = new CircleImpl()
public class CircleImpl implements Circle{
	
	@Autowired
	@Qualifier("PointX") //여러 객체 중 PointX 객체가 적합(참조변수 이름 써야 함)
	Shape pointx; // = new PointX();
	int x;
	int y;
	
	public CircleImpl() {
		System.out.println("CircleImpl() 생성자");
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
