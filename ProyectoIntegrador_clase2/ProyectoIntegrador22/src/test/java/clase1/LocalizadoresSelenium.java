package clase1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LocalizadoresSelenium {
	@Test
	public void idLocator()  {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://seleniumjavalocators.neocities.org/");//va a la url indicada por parametro
		driver.manage().window().maximize();//maximiza la pantalla
		
		//id
		WebElement loginLink = driver.findElement(By.id("loginLink"));
		String loginLinkText = loginLink.getText();
		String loginLinkTagName = loginLink.getTagName();
		
		System.out.println("Texto: " + loginLinkText);
		System.out.println("Etiqueta HTML: " + loginLinkTagName);

		loginLink.click();
		
		WebElement titulo = driver.findElement(By.id("titulo"));
		System.out.println(titulo.getText());
		
		WebElement usernameInput = driver.findElement(By.id("username_id"));
		usernameInput.sendKeys("JuanPablo1092");
		
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys("pepe32003");
		
		WebElement inicioSesionBtn = driver.findElement(By.id("iniciarSesionBtn"));
		//inicioSesionBtn.click();
		inicioSesionBtn.sendKeys(Keys.ENTER);
		
		WebElement mensajeInicioSesion = driver.findElement(By.id("mensajeInicioSesion"));
		System.out.println(mensajeInicioSesion.getText());
		
		usernameInput.clear();
		passwordInput.clear();
		
		usernameInput.sendKeys("JuanSanchez31");
		passwordInput.sendKeys("Juani1123");
		
		inicioSesionBtn.click();
		
		WebElement mensajeInicioSesionDespuesDeClear = driver.findElement(By.id("mensajeInicioSesion"));
		System.out.println(">>> " + mensajeInicioSesionDespuesDeClear.getText());
		
		driver.close();
	}
}
