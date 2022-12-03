package javaBasic;

import java.util.Iterator;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_04_For {
	WebDriver driver;
	Scanner runScanner = new Scanner(System.in) ;
	@Test
	public void TC_01() {
		String[] nameCitys = {"Ha Noi","Hai Phong","Nam Dinh","Nghe An","Binh Duong","Da Nang"};
		for (String city : nameCitys) {
			System.out.println(city);
			
		}
	}
	@Test
	public void TC_02() {
		int x = runScanner.nextInt();
		for (int i = x ; i < 100; i++) {
			if (i%2==0) {
				System.out.println(i + " la so chan");
				
			} else {
				System.out.println(i + " la so le");

			}
			break;
			
		}
	}

	

}
