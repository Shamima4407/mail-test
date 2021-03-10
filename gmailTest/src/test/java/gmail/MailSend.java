package gmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MailSend{
	public static WebDriver driver ;
	public static WebElement sendMail;
	WebDriverWait wait;
	@BeforeClass
	public void browser_opening() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\HP-NPC\\\\Downloads\\\\chromedriver_win32 (2)\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void login_into_gmail1() throws InterruptedException{
		//for email
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("sha090Akter1@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
		
		//for password
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Akter090@RiTu123");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button")).click();
		//Thread.sleep(15000);
	}
	@Test(priority=2)
	public void mail_sending() throws InterruptedException{
		driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("shuchi090.jahan@gmail.com");
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Wanted to start conversation");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='Ar Au']//div")).sendKeys("Hi, Ishrat Jahan Shuchi");
		driver.findElement(By.xpath("//div[@class='J-J5-Ji btA']/child::div[@class='dC']")).click();
		Thread.sleep(9000);
	}
	@AfterClass
	public void browser_closing() {
		driver.findElement(By.xpath("//div[@class='gb_Oa gb_cd gb_ng gb_i gb_Bf']/div/a")).click();
		driver.findElement(By.xpath("//a[@id='gb_71' and contains(text(),'Sign out')]")).click();
		
		
	}
	

}
