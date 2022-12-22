package co.edu.ucompensar.controller;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//powered by YEISON JAHIR JOSSA MORA
public class AppMain {

	// variables

	private WebDriver driver;

	private static final String Tipo_Driver = "webdriver.chrome.driver";

	private static final String Path_Driver = "src/test/resources/chromedriver.exe";

	private String URL = "https://accounts.google.com";

	@BeforeClass

	public static void setUpBeforeClass() {

		System.out.println("INICIO DEL TEST");

		System.setProperty(Tipo_Driver, Path_Driver);

	}

	@Before

	public void setUp() {

		driver = new ChromeDriver();

		driver.get(URL);

	}

	@Test

	public void TestSourch() {

		// Buscamos el elemento de la pagina
		WebElement searchbox = driver.findElement(By.name("identifier"));
		// Limpiamos lo que haya en esa pagina primero
		searchbox.clear();
		// Ingresamos lo que queremos buscar Hwd12345.
		searchbox.sendKeys("pruebasoftware2ucompensar@gmail.com");

		WebElement SignInButton = driver.findElement(By.xpath("//*[@id=\'identifierNext\']/div/button/span"));
		SignInButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Buscamos el elemento de la pagina
		WebElement searchbox2 = driver.findElement(By.name("Passwd"));
		// Limpiamos lo que haya en esa pagina primero
		searchbox2.clear();
		// Ingresamos lo que queremos buscar .
		searchbox2.sendKeys("Hwd12345.");

		WebElement SignInButton2 = driver.findElement(By.xpath("//*[@id=\'passwordNext\']/div/button/span"));
		SignInButton2.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@After

	public void tearDown() {

		// driver.quit();

	}

	@AfterClass

	public static void tearDownAfterClass() {

		System.out.println("FINALIZAR EL TEST");

	}

}
