package clase2.proyInt;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;


public class Laboratorio2 {
	String url = "http://www.automationpractice.pl/";
	Faker faker;
	
	@Test
	public void lab2_dosPuntoUno() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement searchInput = driver.findElement(By.xpath("//*[@id='search_query_top']"));
		searchInput.sendKeys("dress");
		searchInput.sendKeys(Keys.ENTER);
		
	    Thread.sleep(3000);
		
		driver.close();
	}
	@Test
	public void lab2_E1() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		faker = new Faker();
		
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement loginBtn = driver.findElement(By.className("login"));
		loginBtn.click();
		
	    Wait<WebDriver> emailCreateWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement emailCreateInput = emailCreateWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_create"))));
	    String emailAddress = faker.internet().emailAddress();
	    
	    System.out.println(emailAddress);
	    
	    emailCreateInput.sendKeys(emailAddress);
		
	    Wait<WebDriver> createAnAccountWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement createAnAccountBtn = createAnAccountWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("SubmitCreate"))));
	    createAnAccountBtn.click();
	    
	    
	    Wait<WebDriver> mrsGenderWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement mrsRadioButton = mrsGenderWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'uniform-id_gender2')]")));
		mrsRadioButton.click();
	    
	    Thread.sleep(3000);
	    
		driver.close();
	}
}
