package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Web_Browner_Excecise {
	WebDriver driver;
	@BeforeClass
	public void BeforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@Test
	public void TC_01_Verify_Url() {
		//Step 01-Truy cap vao trang "http://live.techpanda.org/"
		driver.get("http://live.techpanda.org/");
		sleepInsecond(2);
		//Step 02-Click "MY ACCOUNT" link tai footer
		driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
		sleepInsecond(2);
		//Step 03-Verify url cua Login Page
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		//Step 04-Click "CREATE AN ACCOUNT" button
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		sleepInsecond(2);
		//Step 05-Verify url cua "REGISTER PAGE"
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
		
				
	}

	@Test
	public void TC_02_Verify_Title() {
		//Step 01-Truy cap vao trang "http://live.techpanda.org/"
		driver.get("http://live.techpanda.org/");
		sleepInsecond(2);
		//Step 02-Click "MY ACCOUNT" link tai footer
		driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
		sleepInsecond(2);
		//Step 03-Verify title cua login page="Customer Login"
		Assert.assertEquals(driver.getTitle(), "Customer Login");
		//Step 04-Click "CREATE AN ACCOUNT" button
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		sleepInsecond(2);
		//Step 05-Verify title cua "Register Page"="Create New Customer Account"		
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
		
	}
	
	@Test
	public void TC_03_Navigate_function() {
		 //Step 01-Truy cap vao trang "http://live.techpanda.org/"
		 driver.get("http://live.techpanda.org/");
		 sleepInsecond(2);
		 //Step 02-Click "MY ACCOUNT" link tai footer
		 driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
		 sleepInsecond(2);
		//Step 03-Click "CREATE AN ACCOUNT" button
		 driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		 sleepInsecond(2);
		 //Step 04-Verify url cua page
		 Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
		 sleepInsecond(2);
		 //Step 05-Back lai trang "Login Page"
		 driver.navigate().back();
		 //Step 06-Verify url cua Page
		 Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		 //Step 07-Forward toi trang"http://live.techpanda.org/index.php/customer/account/create/"
		 driver.navigate().forward();
		 //Step 08-Verify title
		 Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
		 
		
		
		
	}
	@Test
	public void TC_04_Get_Page_Source_Code() {
		//Step 01-Truy cap vao trang "http://live.techpanda.org/"
		 driver.get("http://live.techpanda.org/");
		 sleepInsecond(2);
		//Step 02-Click "MY ACCOUNT" link tai footer
		 driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
		 sleepInsecond(2);
		 //Step 03-Verify Login Page chua text "Login or Create an Account"
		String currenPageSource = driver.getPageSource();
		Assert.assertTrue(currenPageSource.contains("Login or Create an Account"));
		//Step 04-Click "CREATE AN ACCOUNT" button`	
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		sleepInsecond(2);
		//Step 05-Verify Login Page chua text "Create an Account"
		Assert.assertTrue(currenPageSource.contains("Create an Account"));
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