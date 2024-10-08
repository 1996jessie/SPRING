package sample3;

import org.springframework.stereotype.Component;

@Component("Morning")
public class Morning implements Car {

	public Morning() {
		System.out.println("Morning()");
	}
	
	@Override
	public String drive() {
		// TODO Auto-generated method stub
		return "Morning-drive";
	}

}
