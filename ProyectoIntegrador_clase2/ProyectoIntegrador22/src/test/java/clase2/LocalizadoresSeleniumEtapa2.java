package clase2;


import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*******************************************************
*  XPATH                                               *
* "//ElementoHTML[@propiedad='Valor']"                 *
* "//ElementoHTML[contains(text(),'Texto a buscar')]"  *
* "//ElementHTML[contains(@atributo,'Parte del Valor')]*
* "//ElementoHTML[text()='Texto a Buscar']             *
* //       : Posicion sobre el nodo actual.            *
* Tagname  : Tagname del nodo.                         *
* @        : Atributo a elegir.                        *
* Attribute: Nombre del atributo del nodo.             *
* Value    : Valor del atributo.                       *
* https://www.guru99.com/xpath-selenium.html           *
*******************************************************/


public class LocalizadoresSeleniumEtapa2 {
	WebDriver driver;
	String url = "https://seleniumjavalocators.neocities.org/";
	@Test
	public void locatorNameClassNameTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		
		List<WebElement> contenidoSectionList = driver.findElements(By.className("contenido-section"));
		System.out.println("Cantidad de elementos contenido-section: " + contenidoSectionList.size());
		
		//WebElement contenidoSectionSegundo = contenidoSectionList.get(1);
		//System.out.println(contenidoSectionSegundo.getText());
		
		WebElement loginLink = driver.findElement(By.id("loginLink"));
		loginLink.click();
		
		WebElement usernameInput = driver.findElement(By.name("username"));
		usernameInput.sendKeys("NombreCompleto");
		
		WebElement passwordInput = driver.findElement(By.name("passwd"));
		passwordInput.sendKeys("321Password123");
		
		WebElement mostrarMensajeBtn = driver.findElement(By.id("iniciarSesionBtn"));
		mostrarMensajeBtn.click();
		
		WebElement mensajeInicioSesion = driver.findElement(By.className("mensaje"));
		System.out.println(mensajeInicioSesion.getText());
				
		driver.close();
		
	}
	@Test
	public void locatorLinkTextTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		
		/*
		 * <a class="nav-link" href="./pages/registro.html">Registro</a>
		 * 
		 * */
		
		WebElement registroLink = driver.findElement(By.linkText("Registro"));
		registroLink.click();
		
		WebElement titulo = driver.findElement(By.id("titulo"));
		System.out.println(titulo.getText());
				
		driver.close();
		
	}
	@Test
	public void locatorPartialLinkTextTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		
		/*
		 * <a class="nav-link" href="https://productsapi-six.vercel.app/">Catalogo de Productos</a>
		 * 
		 * */
		
		WebElement catalogoLink = driver.findElement(By.partialLinkText("Catalogo"));
		catalogoLink.click();
		
		WebElement titulo = driver.findElement(By.tagName("h1"));
		System.out.println(titulo.getText());
				
		driver.close();
		
	}
	
	@Test
	public void xpathTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		
	
		WebElement linksUtilesLink = driver.findElement(By.xpath("//a[@href='https://seleniumjavalocators.neocities.org/pages/linksutiles']"));
		linksUtilesLink.click();
		
		WebElement titulo = driver.findElement(By.tagName("h1"));
		System.out.println(titulo.getText());
				
		driver.close();
		
	}
	@Test
	public void xpathContainsTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		
		WebElement seccionTitulo = driver.findElement(By.xpath("//*[contains(text(),'Sección 1.10.32')]"));
		String secciontTituloText = seccionTitulo.getText();
		System.out.println(secciontTituloText);
	    
		
		WebElement catalogoLink = driver.findElement(By.xpath("//*[contains(@href,'products')]"));
		catalogoLink.click();
		
		WebElement titulo = driver.findElement(By.tagName("h1"));
		System.out.println(titulo.getText());
				
		driver.close();
		
	}
	@Test
	public void xpathOrAndTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		
		List<WebElement> imagenesBckWhtList = driver.findElements(By.xpath("//img[@src='https://picsum.photos/id/41/320/240' or @alt ='third']"));
		System.out.println("XPATH OR ejemplo cantidad de elementos: " + imagenesBckWhtList.size());
		
		WebElement loginLinkXpathBtn = driver.findElement(By.xpath("//a[@class='nav-link' and @id='loginLink']"));
		System.out.println("XPATH AND ejemplo: " + loginLinkXpathBtn.getText());
						
		driver.close();
		
	}
	@Test
	public void xpathTextTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		
		WebElement seleniumLocatorPractice = driver.findElement(By.xpath("//*[text()='Selenium Locator Practice']"));
		System.out.println(seleniumLocatorPractice.getText());
		
						
		driver.close();
		
	}
	@Test
	public void cssSelectorTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		
		WebElement loginLinkByCss = driver.findElement(By.cssSelector("#loginLink"));
		System.out.println(loginLinkByCss.getText());
		
		WebElement navBar = driver.findElement(By.cssSelector("nav.navbar.navbar-expand-lg.bg-body-tertiary"));
		System.out.println(navBar.getText());
		
		WebElement linksUtilesLink = driver.findElement(By.cssSelector("a[href='https://seleniumjavalocators.neocities.org/pages/linksutiles']"));
		linksUtilesLink.click();
		
		WebElement titulo = driver.findElement(By.tagName("h1"));
		System.out.println(titulo.getText());
				
		driver.close();
		
	}
}
