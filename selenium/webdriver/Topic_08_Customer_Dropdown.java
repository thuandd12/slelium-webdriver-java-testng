package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class Topic_08_Customer_Dropdown {
	WebDriver driver;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	@BeforeClass
	public void BeforeClass() {
		String projecPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projecPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		explicitWait = new WebDriverWait(driver, 20);
		jsExecutor = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@Test
	public void TC_01_jQuery() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		selectItemCustomerDropdown("//span[@id='number-button']/span[contains(@class,'ui-selectmenu-icon')]", "//ul[@id='number-menu']//div", "5");
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='5']")).isDisplayed());
		sleepInsecond(2);
		
		selectItemCustomerDropdown("//span[@id='number-button']/span[contains(@class,'ui-selectmenu-icon')]", "//ul[@id='number-menu']//div", "16");
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='16']")).isDisplayed());
		sleepInsecond(2);
		
		selectItemCustomerDropdown("//span[@id='number-button']/span[contains(@class,'ui-selectmenu-icon')]", "//ul[@id='number-menu']//div", "7");
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='7']")).isDisplayed());
		sleepInsecond(2);		
	}

	@Test
	public void TC_03_React() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		
		selectItemCustomerDropdown("//i[@class='dropdown icon']", "//div[@class='visible menu transition']//span", "Christian");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='divider text']/img")).isDisplayed());
		sleepInsecond(2);
		
		selectItemCustomerDropdown("//i[@class='dropdown icon']", "//div[@class='visible menu transition']//span", "Justen Kitsune");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='divider text']/img")).isDisplayed());
		sleepInsecond(2);
		
		selectItemCustomerDropdown("//i[@class='dropdown icon']", "//div[@class='visible menu transition']//span", "Elliot Fu");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='divider text']/img")).isDisplayed());
		sleepInsecond(2);
	}
	@Test
	public void TC_04_mikerodham() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		
		selectItemCustomerDropdown("//span[@class='caret']", "//ul[@class='dropdown-menu']//a", "First Option");
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).isDisplayed());
		sleepInsecond(2);
		
		selectItemCustomerDropdown("//span[@class='caret']", "//ul[@class='dropdown-menu']//a", "Second Option");
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).isDisplayed());
		sleepInsecond(2);
		
		selectItemCustomerDropdown("//span[@class='caret']", "//ul[@class='dropdown-menu']//a", "Third Option");
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).isDisplayed());
		sleepInsecond(2);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public void selectItemCustomerDropdown (String parentXpath , String childXpath, String expectedItem ) {
		//click vao element de cho xo het cac item trong dropDown hien het ra -> parent element
		driver.findElement(By.xpath(parentXpath)).click();
		//Cho cho tat ca cac elements dc load ra thanh cong -> child element
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
		//Duyet qua tung item
		for (WebElement item : allItems) {
			//Get text cua item do ra va kiem tra co dung voi item mong muon ko
			if (item.getText().trim().equals(expectedItem)) {
				if (!item.isDisplayed()) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInsecond(1);
			}
				item.click();
				break;
			}
		}
		
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