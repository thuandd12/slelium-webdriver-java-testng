package webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	public class Topic_16_Element_Status_Wait {
		WebDriver driver;
		WebDriverWait explicititWait;
		String projectPath = System.getProperty("user.dir");
		
		@BeforeClass
		public void beforeClass() {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			explicititWait = new WebDriverWait(driver, 15);
			
		}

		@Test
		public void TC_01_Visible_Display() {
			//element hien thi tren UI va co trong DOM
		driver.get("https://www.facebook.com/");
		explicititWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='email']")).isDisplayed());
		}

		@Test
		public void TC_02_Invisible_Undisplayed() {
			
	    driver.get("https://www.facebook.com/");	
	    explicititWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-testid='open-registration-form-button']")));
	    driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
	    
	    //verify element ko co tren UI nhung van xuat hien trong DOM
	    explicititWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@name='reg_email_confirmation__']")));
			
		explicititWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Sign Up']//parent::div//parent::div/img")));
		driver.findElement(By.xpath("//div[text()='Sign Up']//parent::div//parent::div/img")).click();
		
		//verify element ko co tren UI nhung van xuat hien trong DOM
		explicititWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@name='lastname']")));
		
		}

		@Test
		public void TC_03_Presence() {
	    driver.get("https://www.facebook.com/");
		//Hien thi tren UI va co trong DOM
		explicititWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-testid='open-registration-form-button']")));
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
			
		//Ko hien thu tren UI va co trong DOM
		explicititWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='reg_email_confirmation__']")));
		explicititWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Sign Up']//parent::div//parent::div/img")));
		driver.findElement(By.xpath("//div[text()='Sign Up']//parent::div//parent::div/img")).click();
		
		}
		@Test
		public void TC_04_staleness() {
		driver.get("https://www.facebook.com/");
		//Ko co tren UI va ko co trong DOM
		WebElement stalenessElement = driver.findElement(By.xpath("//input[@id='email']"));
		
		
		explicititWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='login']")));
		driver.findElement(By.xpath("//button[@name='login']")).click();
		explicititWait.until(ExpectedConditions.stalenessOf(stalenessElement));
		}
		
		

		@AfterClass
		public void afterClass() {
			//driver.quit();
		}

		}
