package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class Topic_01_If_Else {
	WebDriver  driver;
	Scanner runScanner = new Scanner(System.in) ;
	@Test
	public void  Tc_01() {
		//Cac cau lenh thuc hien khi bieu thuc dieu kien la true
	   String numberStudents = "20";
		if(numberStudents.equals("20")) {
			System.out.println("Lop di hoc du");
			
		}
	}
    @Test
    public void Tc_02() {
    	int a,b;
    	a=10;
    	b=20;
    	if(a>b) {
    		System.out.println("a lon hon b");
    	}else {
    		System.out.println("b lon hon a");
    	}

    }
    @Test
    public void Tc_03() {
    	int age;
    	System.out.println("Enter age");
    	age = runScanner.nextInt();
    	if(age<13) {
    		System.out.println("tre em");
    	}else if (age>13 && age<19) {
    		System.out.println("tre vi thanh nien");
    		
    	}else {
    		System.out.println("nguoi truong thanh");
    	}
    	
    }
    
    
    
}

