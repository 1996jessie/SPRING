package com.spring.ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = new GenericXmlApplicationContext("aopExam.xml");

		Student myStudentImpl = (Student) factory.getBean("myStudentImpl");
		myStudentImpl.getStudentInfo();
		
		System.out.println("----------");
		
		Worker myWorkerImpl = (Worker) factory.getBean("myWorkerImpl");
		myWorkerImpl.getWorkerInfo();

	}

}
