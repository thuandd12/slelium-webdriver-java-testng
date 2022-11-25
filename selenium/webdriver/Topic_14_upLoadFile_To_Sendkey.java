	package webdriver;

	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class Topic_14_upLoadFile_To_Sendkey {
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");
		String oto1Name = "oto1.jpg";
		String oto2Name = "oto2.jpg";
		String oto3Name = "oto3.jpg";
		String oto1FilePath = projectPath + "//uploadFile//" + oto1Name;
		String oto2FilePath = projectPath + "//uploadFile//" + oto2Name;
		String oto3FilePath = projectPath + "//uploadFile//" + oto3Name;
		
		@BeforeClass
		public void beforeClass() {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		//@Test
		public void TC_01_upLoad_One_File() {
			driver.get("https://blueimp.github.io/jQuery-File-Upload/");
			driver.findElement(By.xpath("//input[@type='file']")).sendKeys(oto1FilePath);
			Assert.assertTrue(driver.findElement(By.xpath("//p[text()='oto1.jpg']")).isDisplayed());
			driver.findElement(By.cssSelector(".template-upload .start")).click();
			sleepInsecond(3);
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a")).isDisplayed());
			
		}

		@Test
		public void TC_02_upLoad_Muntiple_File() {
			driver.get("https://blueimp.github.io/jQuery-File-Upload/");
			driver.findElement(By.xpath("//input[@type='file']")).sendKeys(oto1FilePath + "\n" + oto2FilePath + "\n" + oto3FilePath );
			sleepInsecond(2);
			Assert.assertTrue(driver.findElement(By.xpath("//p[text()='oto1.jpg']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//p[text()='oto2.jpg']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//p[text()='oto3.jpg']")).isDisplayed());
			sleepInsecond(2);
			driver.findElement(By.xpath("//span[text()='Start upload']")).click();
			sleepInsecond(2);
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='oto1.jpg']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='oto2.jpg']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='oto3.jpg']")).isDisplayed());
		}

		@Test
		public void TC_03_() {
			
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