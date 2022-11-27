package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.OaIdl.EXCEPINFO;

	public class Topic_17_Explicit_Wait {
		WebDriver driver;
		WebDriverWait explicitWait;
		String projectPath = System.getProperty("user.dir");
		@BeforeClass
		public void beforeClass() {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			explicitWait = new WebDriverWait(driver, 15);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		//@Test
		public void TC_01_() {
			driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='contentWrapper']")));
			System.out.println(driver.findElement(By.cssSelector("span.label")).getText());
			explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='27']")));
			driver.findElement(By.xpath("//td[@class='rcWeekend']//a[text()='27']")).click();
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@style,'absolute')]//div[@class='raDiv']")));
			explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='27']")));
			System.out.println(driver.findElement(By.cssSelector("span.label")).getText());
			Assert.assertEquals(driver.findElement(By.cssSelector("span.label")).getText(), "Sunday, November 27, 2022");
		
		}

		@AfterClass
		public void afterClass() {
			driver.quit();
		}

		}
