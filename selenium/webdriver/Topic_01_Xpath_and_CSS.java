package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Xpath_and_CSS {
	WebDriver driver;
	@BeforeClass
	public void BeforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	@Test
	public void TC_01() {
				//Step 01-Visit the website 'https://alada.vn/tai-khoan/dang-ky.html'
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		sleepInsecond(3);
		//Step 02-Click button "ĐĂNG KÝ"
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Step 03-Check for error messages
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys();
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtFirstname-error']")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(), "Vui lòng nhập email");
		
	}

	@Test
	public void TC_02() {
		//Step 01-Visit the website 'https://alada.vn/tai-khoan/dang-ky.html'
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		//Step 02-Nhap du lieu hop le vao cac field tru Email va Confirm Email
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Dinh Duc Thuan");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("123321");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("32123");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123thuan");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123thuan");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("09342974022");
		//Step 03-Click button 'ĐĂNG KÝ'
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Step 04-Kiem tra cac error messages hien thi tai Email va Confirm Email
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");
		
	}
	
	@Test
	public void TC_03() {
		//Step 01-Visit the website 'https://alada.vn/tai-khoan/dang-ky.html'
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		//Step 02-Nhap du lieu hop le ngoai tru Confirm Email
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Dinh Duc Thuan");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("ducthuan@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("ducthuan@gmail.net");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123thuan");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123thuan");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("09342974022");
		//Step 03-Click button 'ĐĂNG KÝ'
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Step 04-Kiem tra cac error messages hien thi tai Confirm Email
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");
		
	}
	@Test
	public void TC_04() {
		//Step 01-Visit the website 'https://alada.vn/tai-khoan/dang-ky.html'
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		//Step 02-Nhap du lieu hop le ngoai tru Password va Confirm Password
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Dinh Duc Thuan");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("ducthuan@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("ducthuan@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("09342974022");
		//Step 03-Click button 'ĐĂNG KÝ'
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Step 04-Kiem tra cac error messages hien thi tai Password va Confirm Password
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
	}
		@Test
		public void TC_05() {
			//Step 01-Visit the website 'https://alada.vn/tai-khoan/dang-ky.html'
			driver.get("https://alada.vn/tai-khoan/dang-ky.html");
			//Step 02-Nhap du lieu hop le ngoai tru Confirm Password
			driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Dinh Duc Thuan");
			driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("ducthuan@gmail.com");
			driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("ducthuan@gmail.com");
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123thuan");
			driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("thuan123");
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("09342974022");
			//Step 03-Click button 'ĐĂNG KÝ'
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			//Step 04-Kiem tra cac error messages hien thi tai Confirm Password
			Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu bạn nhập không khớp");
			
		}
		@Test
		public void TC_06() {
			//Step 01-Visit the website 'https://alada.vn/tai-khoan/dang-ky.html'
			driver.get("https://alada.vn/tai-khoan/dang-ky.html");
			//Step 02-Nhap du lieu hop le ngoai tru Phone number
			driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Dinh Duc Thuan");
			driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("ducthuan@gmail.com");
			driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("ducthuan@gmail.com");
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123thuan");
			driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123thuan");
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("093429");
			//Step 03-Click button 'ĐĂNG KÝ'
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			//Step 04-Kiem tra cac error messages hien thi tai Phone Number
			Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại phải từ 10-11 số.");
		}
		
		
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void sleepInsecond(long timeoutInsecond){
		try {
			Thread.sleep(timeoutInsecond *1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
