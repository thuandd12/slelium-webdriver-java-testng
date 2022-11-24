package webdriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Frame_Iframe_Windown_P2 {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	Select select;
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Iframe_Frame() {
		driver.get("https://kyna.vn/");

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='fanpage ']//iframe")).isDisplayed());
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='fanpage ']//iframe")));
		sleepInsecond(1);
		String numberOfLike = driver.findElement(By.xpath("//div[@class='_1drq']")).getText();
		System.out.println(numberOfLike);
		Assert.assertEquals(numberOfLike, "165K likes");
		driver.switchTo().defaultContent();

		jsExecutor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//iframe[@id='cs_chat_iframe']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='cs_chat_iframe']")));
		driver.findElement(By.xpath("//div[contains(@class,'BorderOverlay')]")).click();
		sleepInsecond(1);
		driver.findElement(By.xpath("//input[contains(@class,'input_name')]")).sendKeys("Jonh Nguyen");
		driver.findElement(By.xpath("//input[contains(@class,'input_phone')]")).sendKeys("0982839299");
		sleepInsecond(2);
		driver.findElement(By.xpath("//select[@id='serviceSelect']")).click();
		sleepInsecond(2);
		driver.findElement(By.xpath("//select[@id='serviceSelect']//option[text()='TƯ VẤN TUYỂN SINH']")).click();;
		sleepInsecond(2);
		driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys("inb for me");
		
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//i[@class='far fa-search']")).click();
	    driver.findElement(By.xpath("//input[@id='m-live-search-bar']")).sendKeys("Excel");
	    driver.findElement(By.xpath("//input[@id='m-live-search-bar']")).submit();
		sleepInsecond(1);
		driver.findElement(By.xpath("//i[@class='far fa-search']")).click();
		sleepInsecond(2);
		List<WebElement> excelKey = driver.findElements(By.xpath("//section//li//a[@class=\"link-wrap\"]"));
		for (WebElement excel : excelKey) {
			Assert.assertTrue(excel.getAttribute("href").toLowerCase().contains("excel"));
		}
			

	}

	@Test
	public void TC_02_Windown_Tap() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		String parentID = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		String googleID = driver.getWindowHandle();
		sleepInsecond(2);
		switchToWindowById(parentID);
		Assert.assertEquals(driver.getTitle(), "Google");
		switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");
		sleepInsecond(2);
		
		
		
		jsExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",driver.findElement(By.xpath("//a[text()='FACEBOOK']")));
		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
		sleepInsecond(2);
		switchToWindowByTitle("Facebook – log in or sign up");
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
		switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");
		
		jsExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",driver.findElement(By.xpath("//a[text()='TIKI']")));
		driver.findElement(By.xpath("//a[text()='TIKI']")).click();
		sleepInsecond(2);
		switchToWindowByTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
		Assert.assertEquals(driver.getTitle(), "Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
		switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");
		 
		closeAllWdWithoutParent(parentID);
		switchToWindowByTitle("SELENIUM WEBDRIVER FORM DEMO");
	}

	@Test
	public void TC_03_() {

	}

	@AfterClass
	public void afterClass() {
		 driver.quit();
	}
	public void switchToWindowById(String parenID) {
		//dung cho 2 Tap/Window
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parenID)) {
				driver.switchTo().window(window);
				break;
			}
			
		}
	}
	public void switchToWindowByTitle(String title) {
		Set<String> allTitles = driver.getWindowHandles();
		for (String tapTitle : allTitles) {
			driver.switchTo().window(tapTitle);
			String expecterTitle = driver.getTitle();
			if(expecterTitle.equals(title)) {
		    break;
			}
		}
	}
	public void closeAllWdWithoutParent(String parentID) {
		Set<String> allTaps = driver.getWindowHandles();
		for (String tapWd : allTaps) {
			if(!tapWd.equals(parentID)) {
				driver.switchTo().window(tapWd);
				driver.close();
			}
	}
		driver.switchTo().window(parentID);
	}	

	public void selectItemCustomDropDow(String parentXpath, String childXpath, String expectedItem) {
		driver.findElement(By.xpath(parentXpath)).click();

		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));

		// Duyet qua tung item
		for (WebElement item : allItems) {
			// get text va ktra xem co bang item mong muon ko
			// item can chon no hien thi
			if (item.getText().trim().equals(expectedItem)) {
				if (item.isDisplayed()) {
					item.click();
				} else {
					// scoll den item do > click item
					jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
					sleepInsecond(1);
					item.click();
					break;
				}
			}

		}

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
