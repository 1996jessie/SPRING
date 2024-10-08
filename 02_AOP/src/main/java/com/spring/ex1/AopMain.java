package com.spring.ex1;

public class AopMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board myboard = new Board();
		myboard.board();
		
		System.out.println("------------");
		
		Order myorder = new Order();
		myorder.order();
	}

}
