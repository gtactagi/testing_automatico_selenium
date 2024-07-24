package clase1.proyInt;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio1 {
	String url = "http://www.automationpractice.pl/";
	
	@Test
	public void  lab1_test() {
		System.out.println("¡Hola Mundo de Automatización!");
		
	}
	
	@Test
	public void lab1_E1(){
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
	}
	@Test
	public void lab1_E2(){
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
	}
	@Test
	public void lab1_E3() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement searchInput = driver.findElement(By.id("search_query_top"));
		searchInput.sendKeys("dress");
		searchInput.sendKeys(Keys.ENTER);
		
		//espera para que se visualice que el navegador busco correctamente
		
		Thread.sleep(3000);
		
		driver.close();
		
	}
}
