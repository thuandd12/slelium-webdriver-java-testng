	package webdriver;
	import java.io.IOException;
import java.util.List;
import java.util.Set;
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

	public class Topic_15_UpLoad_File_By_AutoIT_And_RobotJv {
		WebDriver driver;
		WebDriverWait exlicityWait;
		String projectPath = System.getProperty("user.dir");
		String oto1Name = "oto1.jpg";
		String oto2Name = "oto2.jpg";
		String oto3Name = "oto3.jpg";
		String oto1FilePath = projectPath + "\\uploadFile\\" + oto1Name;
		String oto2FilePath = projectPath + "\\uploadFile\\" + oto2Name;
		String oto3FilePath = projectPath + "\\uploadFile\\" + oto3Name;
		
		String ChormOneTimeAutoIT = projectPath + "\\upLoad File By AutoIT\\chromeUploadOneTime.exe";
		String fireFoxOneTimeAutoIT = projectPath + "\\upLoad File By AutoIT\\firefoxUploadOneTime.exe";
		
		String ChormMutipleTimeAutoIT = projectPath + "\\upLoad File By AutoIT\\chromeUploadMultiple.exe";
		String fireFoxMuntipleTimeAutoIT = projectPath + "\\upLoad File By AutoIT\\firefoxUploadMultiple.exe";
		@BeforeClass
		public void beforeClass() {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			exlicityWait = new WebDriverWait(driver, 15);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		@Test
		public void TC_01_upLoad_One_File() throws IOException {
			driver.get("https://blueimp.github.io/jQuery-File-Upload/");
			
			driver.findElement(By.cssSelector(".btn-success")).click();
			sleepInsecond(2);
			Runtime.getRuntime().exec(new String[] {ChormOneTimeAutoIT,oto2FilePath});
			
			//Assert.assertTrue(driver.findElement(By.xpath("//p[text()='oto1.jpg']")).isDisplayed());
			driver.findElement(By.cssSelector(".template-upload .start")).click();
			sleepInsecond(3);
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a")).isDisplayed());
			
		}

		@Test
		public void TC_02_upLoad_Muntiple_File() throws IOException {
			driver.get("https://blueimp.github.io/jQuery-File-Upload/");
			driver.findElement(By.cssSelector(".btn-success")).click();
			sleepInsecond(2);
			Runtime.getRuntime().exec(new String[] {ChormMutipleTimeAutoIT,oto2FilePath,oto3FilePath,oto1FilePath});
			
			sleepInsecond(7);
			//Assert.assertTrue(driver.findElement(By.xpath("//p[text()='oto1.jpg']")).isDisplayed());
			//Assert.assertTrue(driver.findElement(By.xpath("//p[text()='oto2.jpg']")).isDisplayed());
			//Assert.assertTrue(driver.findElement(By.xpath("//p[text()='oto3.jpg']")).isDisplayed());
			List<WebElement> openStarts = driver.findElements(By.xpath("//tr[@class='template-upload fade image in']//button[@class='btn btn-primary start']"));
			for (WebElement openStart : openStarts) {
				openStart.click();
			}
			sleepInsecond(2);
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='oto1.jpg']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='oto2.jpg']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='oto3.jpg']")).isDisplayed());
		}

		@Test
		public void TC_03_() {
			driver.get("https://gofile.io/?t=uploadFiles");
			driver.findElement(By.xpath("//input[@type='file']")).sendKeys(oto1FilePath + "\n" + oto2FilePath + "\n" + oto3FilePath);
			sleepInsecond(10);
	        driver.findElement(By.xpath("//a[@id='rowUploadSuccess-downloadPage']")).click();
	        String parentId = driver.getWindowHandle();
	        Set<String> windownTaps = driver.getWindowHandles();
	        for (String windownTap : windownTaps) {
				if(!driver.switchTo().window(windownTap).equals(parentId));
				
			}
	        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='contentName' and text()='oto1.jpg']")).isDisplayed());
	        
	        

		}
		
		

		@AfterClass
		public void afterClass() {
			//driver.quit();
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