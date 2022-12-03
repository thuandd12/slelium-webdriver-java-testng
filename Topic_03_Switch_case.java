package javaBasic;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_03_Switch_case {
	WebDriver driver;
	Scanner runScanner = new Scanner(System.in) ;
	@Test
	public void TC_01() {
		int month;
		month = runScanner.nextInt();
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:	
		case 8:
		case 10:
		case 12:
			System.out.println("Thang " + month + " co 31 ngay");
			break;
		case 2:
			System.out.println("Thang " + month + " co 28 hoac 29 ngay");
			break;
		case 4:	
		case 6:
		case 9:	
		case 11:
			System.err.println("Thang " + month + " co 30 ngay");
			break;
		default:
			System.out.println("Vui long nhap thang 1->12");
			break;
		}
		
	}
	@Test
	public void TC_02() {
		int number ;
		number = runScanner.nextInt();
		switch (number) {
		case 1:
			System.out.println("one");
			break;
		case 2:
			System.out.println("two");
			break;
		case 3:
			System.out.println("three");
			break;
		case 4:
			System.out.println("four");
			break;
		case 5:
			System.out.println("five");
			break;
		case 6:
			System.out.println("six");
			break;
		case 7:
			System.out.println("seven");
			break;
		case 8:
			System.out.println("eight");
			break;
		case 9:
			System.out.println("nine");
			break;
		case 10:
			System.out.println("ten");
			break;
			

		default:
			System.out.println("vui long nhap so tu 1->10");
			break;
		}
		
	}
	
}
