package webdriver;

import java.util.concurrent.TimeUnit;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.Click;

import java.awt.print.Printable;
import java.security.Principal;
import java.util.UUID;

public class Topic_02_Xpath_and_CSS_Part2 {
	WebDriver driver;
	String email = UUID.randomUUID().toString();
	String firstName = "automation08";

	@BeforeClass
	public void BeforeClass() {
		String projecPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projecPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	//@Test
	public void TC_01_Register_success_to_system() {
		 //Open Web Site 'http://live.techpanda.org/'
		driver.get("http://live.techpanda.org/");
		// Click 'ACCOUNT' menu
		driver.findElement(By.xpath("//a[contains(@class,'account')]//span[@class='label']")).click();
		// Click 'REGISTER'
		driver.findElement(By.xpath("//a[@title='Register']")).click();
		sleepInsecond(3);
		// Input all valid data
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("FC");

		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(email + "@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123123");
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123123");
		// Click 'REGISTER' button
		driver.findElement(By.xpath("//p[@class='back-link']/following-sibling::button")).click();
		// Verify text displayed after registering with Main Website Store 'Thank you
		// for registering with Main Website Store.'
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),
				"Thank you for registering with Main Website Store.");

	}
	//@Test
	public void TC_02_Verify_user_imformation_is_correct_after_registered_successfully() {
		//Open Web Site 'http://live.techpanda.org/'
		driver.get("http://live.techpanda.org/");
		// Click 'ACCOUNT' menu
		driver.findElement(By.xpath("//a[contains(@class,'account')]//span[@class='label']")).click();
		sleepInsecond(3);
		//Click 'MY ACCOUNT'
		driver.findElement(By.xpath("//div[@id='header-account']//a[@title='My Account']")).click();
		sleepInsecond(3);
		//Click 'ACCOUNT IMFORMATION'
		driver.findElement(By.xpath("//a[text()='Account Information']")).click();
		//Verify data in Fisrtname and Email
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='firstname']")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='lastname']")).getAttribute("value"), "FC");
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"), email + "@gmail.com");
		//Click 'ACCOUNT' menu
		driver.findElement(By.xpath("//a[contains(@class,'account')]//span[@class='label']")).click();
		sleepInsecond(3);
		//Click 'LOGOUT'
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();
		
		
	}

	//@Test
	public void TC_03_() {
		//click on 'ACCOUNT' menu
		driver.findElement(By.xpath("//a[contains(@class,'skip-account')]//span[@class='label']")).click();
		sleepInsecond(3);
		//Choose 'LOG IN' link
		driver.findElement(By.xpath("//a[@title='Log In']")).click();
		sleepInsecond(3);
		//Input all valid data
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email + "@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123");
		//Click on 'LOG IN'
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		//Verify dashboard header text dispayed :'My Dashboard' and 'Hello, Automation00 FC!'
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText(), "MY DASHBOARD");
		Assert.assertEquals(driver.findElement(By.xpath("//p[@class='hello']/strong")).getText(), "Hello, " + firstName + " FC!");
		
				
	}

	//@Test
	public void TC_04_verify_the_cost_and_details_page_are_equal(){
		// Open Web Site 'http://live.techpanda.org/'
		driver.get("http://live.techpanda.org/");
		sleepInsecond(3);
		// click on 'Mobile' menu
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		sleepInsecond(3);
		//In the list of all mobiles,get cost of Sony Xperia mobile
		String costSonyXperia1 = driver.findElement(By.xpath("//a[@title='Sony Xperia']//parent::h2//following-sibling::div[@class='price-box']//span[@class='price']")).getText();
		//Click on 'Sony Xperia mobile' from detail page
		driver.findElement(By.xpath("//a[@title='Sony Xperia']")).click();
		//Get cost Sony Xperia to cart
		String costSonyXperia2 = driver.findElement(By.xpath("//span[@class='price']")).getText();
		//Compare value Step3 and 5
		Assert.assertEquals(costSonyXperia1, costSonyXperia2);
	}

	//@Test
	public void TC_05_Verify_discount_coupon_works_correctly() {
		// Open Web Site 'http://live.techpanda.org/'
		driver.get("http://live.techpanda.org/");
		sleepInsecond(3);
		// Click on 'Mobile' menu
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		sleepInsecond(3);
		//Add Sony Xperia to cart
		driver.findElement(By.xpath("//a[@title='Sony Xperia']//parent::h2//following-sibling::div[@class='actions']//button")).click();
		sleepInsecond(3);
		//Enter 'Coupon cod'
		driver.findElement(By.xpath("//input[@id='coupon_code']")).sendKeys("GURU50");
		//Click 'APPLY'
		driver.findElement(By.xpath("//button[@value='Apply']")).click();
		sleepInsecond(3);
		//Verify the discount coupon
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "Coupon code \"GURU50\" was applied.");
		

	}
	//@Test
	public void TC_06_Verify_that_you_can_not_add_more_500_items_of_product() {
		//Open Web Site 'http://live.techpanda.org/'
		driver.get("http://live.techpanda.org/");
		// Click on 'Mobile' menu
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		sleepInsecond(3);
		//In the list of all mobiles, click on 'ADD TO CART' for Sony Xoeria mobile
		driver.findElement(By.xpath("//a[@title='Sony Xperia']//parent::h2//following-sibling::div[@class='actions']//button")).click();
		sleepInsecond(3);
		//Change'QTY' value to 501 and click 'UPDATE' button
		driver.findElement(By.xpath("//input[@class='input-text qty']")).sendKeys("501");
		driver.findElement(By.xpath("//button[@title='Update']")).click();
		//Verify the results
		Assert.assertEquals(driver.findElement(By.xpath("//p[@class='item-msg error']")).getText(), "* The maximum quantity allowed for purchase is 500.");
		
	}
	@Test
	public void TC_07_Verify_that_you_are_able_to_compare_two_products() {
		//Open Web Site 'http://live.techpanda.org/'
		driver.get("http://live.techpanda.org/");
		// Click on 'Mobile' menu
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		sleepInsecond(3);
		//ADD TO COMPARE for Sony Xperia 
		driver.findElement(By.xpath("//a[@title='Sony Xperia']/parent::h2//following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
		sleepInsecond(2);
		//Verify message results of the Sony Xperia mobile
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "The product Sony Xperia has been added to comparison list.");
		//ADD TO COMPARE for Iphone
		driver.findElement(By.xpath("//img[@alt='IPhone']/parent::a/following-sibling::div//div[@class='actions']//a[@class='link-compare']")).click();
		sleepInsecond(2);
		//Verify message results of the Iphone
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "The product IPhone has been added to comparison list.");
		//Click on 'COMPARE' button 
		driver.findElement(By.xpath("//a[text()='Clear All']//preceding-sibling::button")).click();
		sleepInsecond(3);
		//Verify the popup window and check that products are reflected in it Heading 'COMPARE PRODUCTS' 
		//Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page-title title-buttons']/h1")).getText(), "Compare Products");
		//Close the Popup Window
		
		
	
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void sleepInsecond(long timeoutInsecond) {
		try {
			Thread.sleep(timeoutInsecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
