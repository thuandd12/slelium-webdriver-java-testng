package javaBasic;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_07_String {
	WebDriver driver;
	@Test
	public void TC_01() {
		String information = "Dinh Duc Thuan 19 04 1997";
		char replaceIfm [] = information.toCharArray();
		int uperCase = 0;
		int lowerCase = 0;
		int number = 0;
		
		for (char character : replaceIfm) {
			if (character<='Z' && character>='A') {
				uperCase ++;
			}
			if (character<='z' && character>='a') {
				lowerCase ++;
			}
			if (character<='9' && character>='0') {
				number ++;
			}
		}
		System.out.println("So ki tu viet hoa la " + uperCase);
		System.out.println("So ki tu viet thuong la " + lowerCase);
		System.out.println("Co tong la " + number + " so");
		
	}
	@Test
	public void TC_02() {
		String information = "Dinh Duc Thuan 19 04 1997";
		
		char replaceIfm[] = information.toCharArray();
		int totalA = 0;
		for (char c : replaceIfm) {
			if (c == 'a') {
				totalA++;
			}
		}
		System.out.println(totalA);
		 
		//kiem tra chua text
		System.out.println(information.contains("Duc"));
		
		//Kiem tra tu dau tien cua chuoi
		System.out.println(information.startsWith("Dinh"));
		
		//Kiem tra tu cuoi cua chuoi
		System.out.println(information.endsWith("1997"));
		
		//Lay vi tri cua tu Thuan
		System.out.println(information.indexOf("Thuan"));
		
		//Thay the "19" bang "09"
		System.out.println(information.replace("19", "09"));
		
	}

}
