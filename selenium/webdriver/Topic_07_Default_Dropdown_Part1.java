package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_07_Default_Dropdown_Part1 {
	WebDriver driver;
	Select select;
	JavascriptExecutor jsExecutor;
	String firtName,lastName,dOD,email,companyName,passWord,confimrPassword,dOM,dOY;
	@BeforeClass
	public void BeforeClass() {
		String projecPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projecPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		firtName = "Thuan";
		lastName = "Dinh";
		dOD = "3";
		dOM= "August";
		dOY = "1997";
		email = "dthuan" + randomVarible();
		companyName = "Vn Ind";
		passWord = "123456";
		confimrPassword = "123456";
		
	}
	@Test
	public void TC_01_Register_and_check_the_results() {
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		sleepInsecond(3);
		driver.findElement(By.name("FirstName")).sendKeys(firtName);
		driver.findElement(By.name("LastName")).sendKeys(lastName);
		
		 select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		 select.selectByVisibleText(dOD);
		 Assert.assertEquals(select.getFirstSelectedOption().getText(), dOD);
		 sleepInsecond(2);

		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		select.selectByVisibleText(dOM);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), dOM);
		
		
		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		select.selectByVisibleText(dOY);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), dOY);
		
		driver.findElement(By.name("Email")).sendKeys(email);
		driver.findElement(By.name("Company")).sendKeys(companyName);
		driver.findElement(By.name("Password")).sendKeys(passWord);
		driver.findElement(By.name("ConfirmPassword")).sendKeys(confimrPassword);
		clickJs(By.xpath("//button[@id='register-button']"));
		sleepInsecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");
		driver.findElement(By.xpath("//a[@class='ico-account']")).click();
		sleepInsecond(2);
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firtName);
		Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), dOD);
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), dOM);
		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), dOY);
		Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), email);
		Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"), companyName);
		
		
				
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	
	}
	@Test
	public void clickJs(By by) {
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(by));
		
	}
	@Test
	public String randomVarible() {
		Random rand = new Random();
		return rand.nextInt(9999) + "@hotmail.com";
				
		
	}
	
	@Test
	public void sleepInsecond(long timeoutInsecond){
		try {
			Thread.sleep(timeoutInsecond *1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}