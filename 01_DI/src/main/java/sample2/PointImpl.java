package sample2;

public class PointImpl implements Point{ //반드시 완성해야 하는 메서드를 모두 제대로 완성하도록 인터페이스 상속
	private double xpos;
	private double ypos;
	
	public double getXpos() {
		return xpos;
	}
	public void setXpos(double xpos) {
		this.xpos = xpos;
	}
	public double getYpos() {
		return ypos;
	}
	public void setYpos(double ypos) {
		this.ypos = ypos;
	}
	
	//인터페이스 통해 의존관계를 느슨하게(약화) 할 수 있음
}

//setter 통해 값을 주입(injection)
//인터페이스 통해 의존관계(dependency) 약화
//DI : Dependency Injection