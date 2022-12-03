package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_04_For {
	WebDriver driver;
	Scanner runScanner = new Scanner(System.in) ;
	@Test
	public void TC_01() {
		int number;
		number = runScanner.nextInt();
		for (number = 1;number < 11;number++) {
			System.out.println(number);
		}
		
	}
	@Test
	public void TC_02() {
		int a = 4;
		int b = a + 5;
		for (a = 4; a <= b; a++) {
			System.out.println(a);
		}
		
	}
	@Test
	public void TC_03() {
		
	}
	@Test
	public void TC_04() {
		
	}

}
