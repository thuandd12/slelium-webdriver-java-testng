package webdriver;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Authentication_Alert_P2 {
	WebDriver driver;
	WebDriverWait exlicitiWait;
	String projectPath = System.getProperty("user.dir");
	JavascriptExecutor JsExcutor;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		exlicitiWait = new WebDriverWait(driver, 10);
		JsExcutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	//@Test
	public void TC_01_By_Link() {
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		//http://+Username+:+Password+@+hreflink neu User or Pass chua ki tu dac biet thi vao day https://www.urlencoder.org/
		Assert.assertEquals(driver.findElement(By.xpath("//h3[text()='Basic Auth']//following-sibling::p")).getText(), "Congratulations! You must have the proper credentials.");
	
	}

	@Test
	public void TC_02_By_Link_2() {
		driver.get("http://the-internet.herokuapp.com/");
		String hrefValue = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
		passValueTourl(hrefValue, "admin", "admin");
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='Basic Auth']//following-sibling::p")).isDisplayed());
		
	}
	public void passValueTourl (String url,String username,String passsword) {
		String[] hrefValue = url.split("//");
		url = hrefValue[0] + "//" + username + ":" + passsword + "@" + hrefValue[1];
		driver.get(url);
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
