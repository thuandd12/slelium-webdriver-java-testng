package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Textbox_Textarea {
	WebDriver driver;
	String emailAdd,userId,Password,idCustomer;
	//UI(New Customer/Edit Customer)
			By nameTexbox = By.name("name");
			By dobTexbox = By.name("dob"); 
			By addrTexbox = By.name("addr");
			By cityTexbox = By.name("city");
			By stateTexbox = By.name("state");
			By pinnoTexbox = By.name("pinno");
			By telephonenoTexbox = By.name("telephoneno");
			By emailidTexbox = By.name("emailid");
			By passwordTexbox = By.name("password");
	//Customer
			String name,dob,addr,city,state,pinno,telephoneno,emailEdit,addrEdit,cityEdit,stateEdit,pinnoEdit,telephonenoEdit;
			
	
	@BeforeClass
	public void BeforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		emailAdd = "dthuan" + randomVarible();
		//Customer
		name = "dthuan";
		dob = "1999-02-02";
		addr = "123 New Yasy";
		city = "Ohaio";
		state = "New York";
		pinno = "100000";
		telephoneno = "0972134569";
		//Edit Customer
		addrEdit = "929 Javs De Stin";
		cityEdit = "Kosovo";
		stateEdit = "Woa Sing Ton";
		pinnoEdit = "200000";
		telephonenoEdit = "0928348588";
		emailEdit = "Atonn" + randomVarible();

		
	}
	@Test
	public void TC_01_Register() {
		driver.get("https://demo.guru99.com/v4/");
		driver.findElement(By.xpath("//a[text()='here']")).click();
		sleepInsecond(2);
		driver.findElement(By.name("emailid")).sendKeys(emailAdd);
		driver.findElement(By.name("btnLogin")).click();
		userId = driver.findElement(By.xpath("//td[text()='User ID :']//following-sibling::td")).getText();
		Password = driver.findElement(By.xpath("//td[text()='Password :']//following-sibling::td")).getText();
	}

	@Test
	public void TC_02_Login() {
		driver.get("https://demo.guru99.com/v4/");
		driver.findElement(By.name("uid")).sendKeys(userId);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.name("btnLogin")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//marquee[@class='heading3']")).getText(), "Welcome To Manager's Page of Guru99 Bank");
		
	}
	
	@Test
	public void TC_03_New_Customer() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		sleepInsecond(2);
		driver.findElement(nameTexbox).sendKeys(name);
		driver.findElement(dobTexbox).sendKeys(dob);
		driver.findElement(addrTexbox).sendKeys(addr);
		driver.findElement(cityTexbox).sendKeys(city);
		driver.findElement(stateTexbox).sendKeys(state);
		driver.findElement(pinnoTexbox).sendKeys(pinno);
		driver.findElement(telephonenoTexbox).sendKeys(telephoneno);
		driver.findElement(emailidTexbox).sendKeys(emailAdd);
		driver.findElement(passwordTexbox).sendKeys(Password);
		driver.findElement(By.name("sub")).click();
		sleepInsecond(2);
		idCustomer = driver.findElement(By.xpath("//td[text()='Customer ID']//following-sibling::td")).getText();
		
		Assert.assertEquals(driver.findElement(By.xpath("//p[@class='heading3']")).getText(), "Customer Registered Successfully!!!");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']//following-sibling::td")).getText(), name);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']//following-sibling::td")).getText(),dob);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']//following-sibling::td")).getText(),addr );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']//following-sibling::td")).getText(),city );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']//following-sibling::td")).getText(),state );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']//following-sibling::td")).getText(),pinno );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']//following-sibling::td")).getText(),telephoneno );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']//following-sibling::td")).getText(),emailAdd );
		
		
		
		
	}
	@Test
	public void TC_04_Edit_Customer() {
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
		driver.findElement(By.name("cusid")).sendKeys(idCustomer);
		driver.findElement(By.name("AccSubmit")).click();
		sleepInsecond(2);
		Assert.assertTrue(driver.findElement(nameTexbox).isDisplayed());
		Assert.assertTrue(driver.findElement(dobTexbox).isDisplayed());
		driver.findElement(addrTexbox).clear();
		driver.findElement(addrTexbox).sendKeys(addrEdit);
		driver.findElement(cityTexbox).clear();
		driver.findElement(cityTexbox).sendKeys(cityEdit);
		driver.findElement(stateTexbox).clear();
		driver.findElement(stateTexbox).sendKeys(stateEdit);
		driver.findElement(pinnoTexbox).clear();
		driver.findElement(pinnoTexbox).sendKeys(pinnoEdit);
		driver.findElement(telephonenoTexbox).clear();
		driver.findElement(telephonenoTexbox).sendKeys(telephonenoEdit);
		driver.findElement(By.xpath("//td[text()='E-mail']//following-sibling::td//input")).clear();
		driver.findElement(By.xpath("//td[text()='E-mail']//following-sibling::td//input")).sendKeys(emailEdit);
		
		//driver.findElement(By.name("sub")).click();
		sleepInsecond(2);
		
		
	
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	public String randomVarible() {
		Random rand = new Random();
		return rand.nextInt(9999) + "@hotmail.com";
				
		
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

