package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_RadioButton_Checkbox_ {
	WebDriver driver;
	String projecPath = System.getProperty("user.dir");
	JavascriptExecutor jsExecutor;
	
	
	
	
	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", projecPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	//@Test
	public void TC_01_RadioButton_Default() {

		driver.get("https://www.fahasa.com/customer/account/create");
		driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();
		sleepInsecond(2);
		//verify button 'Dang Nhap' la disable
		Assert.assertFalse(driver.findElement(By.xpath("//button[@class='fhs-btn-login']")).isEnabled());
		
		driver.findElement(By.xpath("//input[@id='login_username']")).sendKeys("0982871828");
		driver.findElement(By.xpath("//input[@placeholder='Nhập mật khẩu']")).sendKeys("123456");
		//verify button 'Dang Nhap' la enable
		Assert.assertTrue(driver.findElement(By.xpath("//button[@class='fhs-btn-login']")).isEnabled());
		
		//Remove attribute disable
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();
		jsExecutor.executeScript("arguments[0].removeAttribute('disable')", driver.findElement(By.xpath("//button[@class='fhs-btn-login']")));
		
		driver.findElement(By.xpath("//button[@class='fhs-btn-login']")).click();
		sleepInsecond(2);
		
		 
		 
				
	}

	//@Test
	public void TC_02_Checkbox_Default() {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		sleepInsecond(2);
		checkOnCheckBox(By.xpath("//label[contains(text(),'conditioning')]"));
		equalCheckBoxAndRadioSelect(By.xpath("//label[contains(text(),'conditioning')]//preceding-sibling::input"));
		sleepInsecond(2);

		checkOutCheckBox(By.xpath("//label[contains(text(),'conditioning')]//preceding-sibling::input"));
		equalCheckBoxAndRadioUnSelect(By.xpath("//label[contains(text(),'conditioning')]//preceding-sibling::input"));
		
		
		
		
		driver.get("http://demos.telerik.com/kendo-ui/styling/radios");
		sleepInsecond(2);
		checkOnCheckBox(By.xpath("//input[@id=\"engine3\"]"));
		equalCheckBoxAndRadioSelect(By.xpath("//input[@id=\"engine3\"]"));
		
		
		
	}
	
	@Test
	public void TC_03_Customer_Checkbox_And_radioButton() {
		// driver.get("https://material.angular.io/components/radio/examples");
		// sleepInsecond(2);
		// checkOnCheckBox(By.xpath("//label[contains(text(),'
		// Summer')]//preceding-sibling::div"));
		// equalCheckBoxAndRadioSelect(By.xpath("//label[contains(text(),'
		// Summer')]//preceding-sibling::div"));
		
		
		driver.get("https://material.angular.io/components/checkbox/examples");
		sleepInsecond(2);
		
		checkOnCheckBox(By.xpath("//label[text()='Checked']"));
		sleepInsecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Checked']//parent::div//input[@aria-checked=\"true\"]")).isSelected());
		sleepInsecond(2);
		//String condition = driver.findElement(By.xpath("//label[text()='Checked']//parent::div//input[@aria-checked=\"true\"]")).getAttribute("aria-checked");
		//System.out.println(condition);
		
		checkOnCheckBox(By.xpath("//label[text()='Indeterminate']"));
		sleepInsecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Indeterminate']//parent::div//input[@aria-checked=\"true\"]")).isSelected());
		
		checkOutCheckBox(By.xpath("//label[text()='Checked']//parent::div//input[@aria-checked=\"true\"]"));
		sleepInsecond(2);
		checkOutCheckBox(By.xpath("//label[text()='Indeterminate']//parent::div//input[@aria-checked=\"true\"]"));
		sleepInsecond(2);
		
		String checker = driver.findElement(By.xpath("//label[text()='Checked']//parent::div//input")).getAttribute("aria-checked");
		System.out.println(checker);
		Assert.assertEquals(checker, "false");
		
		String indeterminate = driver.findElement(By.xpath("//label[text()='Indeterminate']//parent::div//input")).getAttribute("aria-checked");
		System.out.println(indeterminate);
		Assert.assertEquals(indeterminate, "false");
	}
	@Test
	public void TC_04_Customer_Checkbox_Or_radioButton() {
		
	}
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	public void checkOnCheckBox (By by) {
		WebElement checkBox = driver.findElement(by);
		if (!checkBox.isSelected())  {
			checkBox.click();
		}
	}
	public void checkOutCheckBox (By by) {
		WebElement unCheckBox = driver.findElement(by);
		if (unCheckBox.isSelected());
		unCheckBox.click();
	}
	public void equalCheckBoxAndRadioSelect (By by) {
		Assert.assertTrue(driver.findElement(by).isSelected());
	}
	public void equalCheckBoxAndRadioUnSelect (By by) {
		Assert.assertFalse(driver.findElement(by).isSelected());
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