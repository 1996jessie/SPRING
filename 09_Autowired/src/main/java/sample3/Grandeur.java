package sample3;

import org.springframework.stereotype.Component;

@Component("Grandeur")
public class Grandeur implements Car {

	public Grandeur() {
		System.out.println("Grandeur()");
	}
	@Override
	public String drive() {
		// TODO Auto-generated method stub
		return "Grandeur-drive";
	}
	
	

}
