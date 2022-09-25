package d19_09_2022;

import java.util.List;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Zadatak1 {
//
//	1.Zadatak
//	Kreirati BootstrapTableTests klasu koja ima:
//	Base url: https://s.bootsnipp.com
//	Test #1: Edit Row
//	Podaci:
//	First Name: ime polaznika
//	Last Name: prezime polaznika
//	Middle Name: srednje ime polanzika
//	Koraci:
//	Ucitati stranu /iframe/K5yrx
//	Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//	Klik na Edit dugme prvog reda
//	Sacekati da dijalog za Editovanje bude vidljiv
//	Popuniti formu podacima. 
//	Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji,
//	za to se koristi metoda clear. Koristan link
//	Klik na Update dugme
//	Sacekati da dijalog za Editovanje postane nevidljiv
//	Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//	Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//	Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//	Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//	Test #2: Delete Row
//	Podaci:
//	First Name: ime polaznika
//	Last Name: prezime polaznika
//	Middle Name: srednje ime polanzika
//	Koraci:
//	Ucitati stranu /iframe/K5yrx
//	Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//	Klik na Delete dugme prvog reda
//	Sacekati da dijalog za brisanje bude vidljiv
//	Klik na Delete dugme iz dijaloga 
//	Sacekati da dijalog za Editovanje postane nevidljiv
//	Verifikovati da je broj redova u tabeli za jedan manji
//	Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//	Test #3: Take a Screenshot
//	Koraci:
//	Ucitati stranu  /iframe/K5yrx
//	Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//	Kreirati screenshot stranice.
//	Koristan link https://www.guru99.com/take-screenshot-selenium-webdriver.html
//	Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg.
//	Na putanji: src/paket_za_domaci/nazivslike.png
		
		public class BootstrapTableTests {
			private String imePolaznika;
			private String prezimePolaznika;
			private String srednjeIme;
			private WebDriver driver;
	        private WebDriverWait wait;
			private String baseUrl = "https://s.bootsnipp.com";
		
		
		@BeforeClass
		public void setup () {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
						
		}

		

		@BeforeMethod
		public void beforeMethod() {
			driver.get(baseUrl);
			
		}
		
		@Test(priority = 100)
		public void editRaw() {
			
		    imePolaznika = "Ana";
		    prezimePolaznika = "Ristic";
		    srednjeIme = "Sava";
			driver.get(baseUrl + "/iframe/K5yrx");
			
			Assert.assertEquals(driver.getTitle(),  
					"Table with Edit and Update Data - Bootsnipp.com", "ERROR:Unexpected title");
			driver.findElement(By.xpath("(//button[contains(@class, 'update')])[1]"))
					.click();
			
			wait.until(ExpectedConditions.visibilityOf(driver
					.findElement(By.xpath("//h4[text()='Update Data']"))));
	
			WebElement p = driver.findElement(By.id("fn"));
			p.clear();
			p.sendKeys("Ana");
			WebElement c = driver.findElement(By.id("ln"));
			c.clear();
			c.sendKeys("Ristic");
			WebElement k = driver.findElement(By.id("mn"));
			k.clear();
			k.sendKeys("Sava");
			
			
			
			driver.findElement(By.id("up")).click();
			
			wait.until(ExpectedConditions.invisibilityOf(driver
					.findElement(By.xpath("//h4[text()='Update Data']"))));
			
			Assert.assertEquals(driver.findElement(By.id("f1")).getText(),   
					"Ana", "First names didn't mach");
			Assert.assertEquals(driver.findElement(By.id("l1")).getText(),   
					"Ristic", "Last names didn't match");
			Assert.assertEquals(driver.findElement(By.id("m1")).getText(),   
					"Sava", "Middle names didn't match");
		}
		
		
		@Test(priority = 200)
		public void deleteRow() {
			 imePolaznika = "Ana";
			 prezimePolaznika = "Ristic";
			 srednjeIme = "Sava";
			 
			driver.get(baseUrl + "/iframe/K5yrx");
			
			Assert.assertEquals(driver.getTitle(),  
					"Table with Edit and Update Data - Bootsnipp.com",
					"ERROR:Unexpected title");
			
			Integer velicinaTabeleStara = driver.findElements(By
					.xpath("//table[contains(@class, 'table')]//tr")).size();
			
			driver.findElement(By.xpath("(//button[contains(@class, 'delete')])[1]")).click();
			wait.until(ExpectedConditions.visibilityOf(driver
					.findElement(By.xpath("//h4[text()='Delete Data']"))));

			driver.findElement(By.id("del")).click();
			wait.until(ExpectedConditions.invisibilityOf(driver
					.findElement(By.xpath("//h4[text()='Delete Data']"))));
			
			Integer velicinaTabeleNova = driver.findElements(By
					.xpath("//table[contains(@class, 'table')]//tr")).size();
			
			Assert.assertNotSame(velicinaTabeleStara, velicinaTabeleNova,
					"Tables were of equal size");
			
		}
		
		@Test(priority = 300)
		public void takeAScreenshot() {
			driver.get(baseUrl + "/iframe/K5yrx");
			Assert.assertEquals(driver.getTitle(),  
					"Table with Edit and Update Data - Bootsnipp.com",
					"ERROR:Unexpected title");
			TakesScreenshot scrShot = (TakesScreenshot)driver;
			File SrcFile= scrShot.getScreenshotAs(OutputType.FILE);
			//File DestFile = new File("img");
			try {
				FileHandler.copy(SrcFile,
						new File("C:\\Users\\p\\eclipse-workspace\\selenium_osnove\\src\\d19_09_2022\\slika1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

		@AfterMethod
		public void afterMethod() {
			System.out.println("After Method");
		}
		
		@AfterClass
		public void afterClass() {
			driver.quit();
		}
	}


}
