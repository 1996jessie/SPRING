package sample2;

import org.springframework.stereotype.Component;

@Component("PointY")
public class PointY implements Shape{

	@Override
	public String make() {
		// TODO Auto-generated method stub
		return "Y를 만들다";
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return "Y를 지우다";
	}

}
