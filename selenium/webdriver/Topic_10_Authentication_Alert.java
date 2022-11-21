	package webdriver;

	import java.util.concurrent.TimeUnit;


	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class Topic_10_Authentication_Alert {
		WebDriver driver;
		WebDriverWait exlicitiWait;
		JavascriptExecutor jsExecutor;
		String projectPath = System.getProperty("user.dir");
		Alert alert;
		
		@BeforeClass
		public void beforeClass() {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			jsExecutor = (JavascriptExecutor) driver;
			exlicitiWait = new WebDriverWait(driver, 20);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		@Test
		public void TC_01_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();;
		//Cho alert xuat hien
		alert = exlicitiWait.until(ExpectedConditions.alertIsPresent());
		sleepInsecond(4);
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		alert.accept();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked an alert successfully");
		}

		@Test
		public void TC_02_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");	
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		alert = exlicitiWait.until(ExpectedConditions.alertIsPresent());
		sleepInsecond(2);
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		alert.dismiss();
		sleepInsecond(2);
		driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked: Cancel");
		}

		@Test
		public void TC_03_Prompt_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		alert = exlicitiWait.until(ExpectedConditions.alertIsPresent());
		sleepInsecond(2);
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		String textPrompt = "ducthuan69";
		alert.sendKeys(textPrompt);
		sleepInsecond(2);
		alert.accept();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),"You entered: " + textPrompt);
		
		
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
