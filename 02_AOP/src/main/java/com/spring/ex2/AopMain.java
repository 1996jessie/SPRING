package com.spring.ex2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.*;

public class AopMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		BoardImpl myBoard = new BoardImpl();
		OrderImpl myOrder = new OrderImpl();
		Dao dao = new Dao();
		
		Login.login();
		myBoard.board();
		dao.dao();
		Logout.logout();
		
		System.out.println("----------");
		
		Login.login();
		myOrder.order();
		dao.dao();
		Logout.logout();
		
		*/
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("aopExam.xml");

		Order myOrderImpl = (Order) factory.getBean("myOrderImpl");
		myOrderImpl.order();
		
		System.out.println("----------");
		
		Board myBoardImpl = (Board) factory.getBean("myBoardImpl");
		myBoardImpl.board();
	}

}

/*
AOP(Aspect Oriented Programming) : 관점 지향 프로그래밍(공통과 핵심을 나누어 프로그래밍)
.. : 파라미터 0개 이상

*/