package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class Topic_05_Web_Element_Excercise_part1 {
	WebDriver driver;
	By EmailTexbox = By.id("mail");
	By AgeUnder18 = By.id("under_18");
	By Education = By.id("edu");
	By Image = By.xpath("//img[@alt='User Avatar 05']");
	By javaCheckbox = By.id("java");
	
   
    
	@BeforeClass
	public void BeforeClass() {
		String projecPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projecPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		 
	}
	@Test
	public void TC_01_Ckeck_the_displayed_section() {
		//Access to website
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Check the elements displayed on the page and senkey/click
		if (isElementDisplayed(EmailTexbox)){
		   sendkeyToElement(EmailTexbox, "iducthuan@gmail.com");
		}
		if (isElementDisplayed(AgeUnder18)) {
			clickElement(AgeUnder18);
			
		}
		if (isElementDisplayed(Education)){
			sendkeyToElement(Education, "Utt");
		}
	
		//Check for elements that are not visible on the page
		if (isElementDisplayed(Image)){
		}

	}
	@Test

	public void TC_02_Check_elements_are_enable() {
		//Access to website
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Check the elements are enabled/disable on the page
		if(isElementEnable(EmailTexbox));{
		sendkeyToElement(EmailTexbox, "iducthuan@gmail.com");
		}
		if(isElementEnable(AgeUnder18));{
		clickElement(AgeUnder18);
		}
		if (isElementEnable(Education)){
			sendkeyToElement(Education, "Utt");
		}
		
	}
	@Test
	public void TC_03_check_the_elements_are_selected() {
		//Access to website
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Click and check that the clicked the elements are selected
		clickElement(AgeUnder18);
		if(isElementSelected(AgeUnder18));{
		}
		clickElement(javaCheckbox);
		if(isElementSelected(javaCheckbox));{
		}
		//Click to deselect "jave and under18"
		clickElement(AgeUnder18);
		clickElement(javaCheckbox);
		//Check "jave and under18" are deselected
		Assert.assertTrue(isElementSelected(AgeUnder18));
		Assert.assertFalse(isElementSelected(javaCheckbox));
		
		

		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	//lenh random
	public String randomVarible() {
		Random rand = new Random();
		return rand.nextInt(9999) + "";
				
		
	}
	public boolean isElementDisplayed(By by) {
		if(driver.findElement(by).isDisplayed()) {
			System.out.println(by + " is displayed");
			return true;
		} else {
			System.out.println(by + " is not displayed");
			return false;
		}
	}
	public void sendkeyToElement(By by, String value) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
	}
	public void clickElement(By by) {
		driver.findElement(by).click();
	}
	public boolean isElementEnable(By by) {
		if(driver.findElement(by).isEnabled()) {
			System.out.println(by + " is enable");
			return true;
		} else {
			System.out.println(by + " is not enable");
			return false;
		}
	}
	public boolean isElementSelected(By by) {
		if(driver.findElement(by).isSelected()) {
			System.out.println(by + " is selected");
			return true;
		}else {
			System.out.println(by + " is not selected");
			return false;
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
