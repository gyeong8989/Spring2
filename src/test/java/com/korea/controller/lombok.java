package com.korea.controller;

import org.junit.Test;
import org.korea.sample.Person;


public class lombok {

	@Test
	public void test() {
		Person hong = new Person("홍길동","44","대구");
		System.out.println(hong.toString());
		
		
		
		Person obj1 = Person.builder()
						.age("55")
						.name("남길동")
						.addr("울산")
						.build();
		
		System.out.println(obj1.toString());
	}

}
