package javaBasic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_05_While {
	WebDriver driver;
	
	@Test
	public void TC_01() {
		int i=0;
		while (i<=5) {
			//Khối lênh đc lặp lại cho đến khi điều kiện là sai
			System.out.println(i);
			i++;
		}
	}
	@Test
	public void TC_012() {
		int i = 0;
		do {
			System.out.println(i);
			i++;
		} while (i<=5);
	}

}
