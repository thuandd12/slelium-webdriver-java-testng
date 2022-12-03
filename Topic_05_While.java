package javaBasic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_05_While {
	WebDriver driver;
	@Test
	public void TC_01() {
		int i = 1;
		while (i<10) {
			System.out.println(i);
			i++;
			
		}
		
	}
	@Test
	public void TC_02() {
		int i = 1;
		do {
			System.out.println(i);
			i++;
			
		} while (i<10);
		
	}

}
