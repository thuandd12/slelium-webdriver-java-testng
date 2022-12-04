package javaBasic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Array {
WebDriver driver;
	
	@Test
	public void TC_01() {
	    //Mảng 1 chiều
		int[]numbers = {1,2,3,4,5};
		System.out.println(numbers[3]);
		
		int number[] = {1,2,3,4,5};
		System.out.println(number[3]);
		
		int[] a = new int[6];
		a[0] = 5;
		
		int [] b = new int[]{1,2,3,4,5};
		
		
	}
	@Test
	public void TC_02() {
		//Mang 2 chieu
		int [][] a = {
				{3,5,7,8},
				{3,4,2,5,5},
				{4,12,6,8},
				{-1,-3,-5,3},};
		
	}
	@Test
	public void TC_03() {
		//Tim so lon nhat
		int[] number = {2,76,45,3,7};
		int x = 0;
		for (int i = 0; i < number.length; i++) {
			if (x<number[i]) {
				x=number[i];
			}
		}
		System.out.println(x + " la so lon nhat");
	}
	@Test
	public void TC_04() {
		//Tim so chan
		int [] y = {2,43,21,60,78,3};
		for (int i = 0; i < y.length; i++) {
			if (y[i]%2==0) {
				System.out.println(y[i] + " la so chan");
			}
		}
	}
	@Test
	public void TC_05() {
		//Lay ra so le va lon hon 0
		int m [] = {3,-7,2,5,9,-6,10,12};
		for (int i = 0; i < m.length; i++) {
			if (m[i]>0 && m[i]%2>0) {
				System.out.println(m[i]);
			}
		}
	}
	@Test
	public void TC_06() {
		//Lay ra so lon hon bang 0 va nho hon bang 10
		int u[] = {-1,9,40,-67,3,0}; 
		for (int i = 0; i < u.length; i++) {
			if (u[i]>=0 && u[i]<=10) {
				System.out.println(u[i]);
			}
		}
		
	}
	@Test
	public void TC_07() {
		//Tinh tong cac so va tong trung binh cong cac so
		int[] k = {21,-4,2,94,10,-43,2};
		float sum = 0;
		for (int i = 0; i < k.length; i++) {
			sum = sum + k[i];
		}
		System.out.println("Tong cac so la " + sum);
		System.out.println("Tong trung binh cong cac so la " + sum/k.length);
	}
}
