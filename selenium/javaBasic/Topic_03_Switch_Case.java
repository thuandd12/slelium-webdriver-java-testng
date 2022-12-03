package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_03_Switch_Case {
	WebDriver  driver;
	Scanner runScanner = new Scanner(System.in) ;
	@Test
	public void TC_01() {
		int month = runScanner.nextInt();
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
		case 4:
		case 6:	
		case 9:
		case 11:
			System.out.println("Thang " + month + " co 30 ngay");
			break;
		case 2:	
			System.out.println("Thang " + month + " co 28 hoac 29 ngay");
			break;

		default:
			System.out.println("Vui long nhap thang tu 1 ->12");
			break;
		}
		
	}

}
