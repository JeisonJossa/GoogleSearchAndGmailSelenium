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

public class GoogleSearch {

	// variables

	private WebDriver driver;

	private static final String Tipo_Driver = "webdriver.chrome.driver";

	private static final String Path_Driver = "src/test/resources/chromedriver.exe";

	private String URL = "https://www.google.com";

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
		WebElement searchbox = driver.findElement(By.name("q"));
		// Limpiamos lo que haya en esa pagina primero
		searchbox.clear();
		// Ingresamos lo que queremos buscar
		searchbox.sendKeys("Probando selenium desde java papuuu");
		// Le decimos que busque
		searchbox.submit();
		// Se le añade un tiempo de espera para dale tiempo a la busqueda de google
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		String titulo = driver.getTitle();

		// assert.assertTrue("VALIDE EL TITULO",titulo.contains(textEnviado));

	}

	@After

	public void tearDown() {

		driver.quit();

	}

	@AfterClass

	public static void tearDownAfterClass() {

		System.out.println("FINALIZAR EL TEST");

	}

}
