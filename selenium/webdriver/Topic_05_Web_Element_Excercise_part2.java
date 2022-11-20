package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.ClearElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Element_Excercise_part2 {
	WebDriver driver;
	
	@BeforeClass
	public void BeforeClass() {
		String projecPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projecPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
	}
	@Test
	public void TC_01_Register_function() {
		//Asscess to website
		driver.get("https://login.mailchimp.com/signup/");
		sleepInsecond(2);
		//Nhap du lieu hop le vao "Emai va Username"
		By Email = By.xpath("//input[@id='email']");
		sendkeyToElement(Email, "ducthuan" + randomVarible());
		sendkeyToElement(By.xpath("//input[@id='new_username']"), "thuan" + randomVarible());
		//Nhap du lieu voi cac tieu chi khac nhau va kiem tra validate cua truong password
		By Password = By.xpath("//input[@id='new_password']");
		//Nhap so
		sendkeyToElement(Password, "1");
		Assert.assertTrue(driver.findElement(By.cssSelector("#new_password")).isDisplayed());
		//Nhap chu thuong
		sendkeyToElement(Password, "n");
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'lowercase')]")).isDisplayed());
		//Nhap chu viet hoa
		sendkeyToElement(Password, "L");
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'uppercase')]")).isDisplayed());
		//Nhap ki tu dac biet
		sendkeyToElement(Password, "@");
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'special')]")).isDisplayed());
		//Lon hon 8 ki tu
		sendkeyToElement(Password, "12345678");
		Assert.assertTrue(driver.findElement(By.cssSelector("#new_password")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']/span")).isDisplayed());
				
	}
	
	@AfterClass
	
	public void afterClass() {
		
	driver.quit();
	}
	public void sendkeyToElement(By by,String value) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
		
	}
	public String randomVarible() {
		Random rand = new Random();
		return rand.nextInt(9999) + "@gmail.com";
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
