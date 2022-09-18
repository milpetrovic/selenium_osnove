package d16_09_2022;

import java.io.File;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {

//      Napisati program koji ima:
//      Podesava:
//      implicitno cekanje za trazenje elemenata od 10s
//      implicitno cekanje za ucitavanje stranice od 10s
//      eksplicitno cekanje podeseno na 10s
//      Podaci:
//      Potrebno je u projektu ukljuciti 4 slike.
//              Imenovanje slika neka bude po pravilu pozicija_ime_prezime_polaznika.ekstenzija
//      Npr: front_milan_jovanovic.jpg, left_milan_jovanovic.jpg …
//      Koraci:
//      Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//      Maksimizuje prozor
//      Selektuje Image - Front klikom na tu karticu u dnu ekrana
//      Klik na add photo iz levog navigacionog menia
//      Upload slike. Upload preko File objekta koristeci getAbsolutePath
//      Sacekati da broj prikazanih slika u donjem uglu navigacije bude za 1 veca
//      Kliknuti na poslednje dodatu sliku kako bi bila izabrana za postavljanje
//      Ceka da dijalog bude vidljiv
//      Klik na Use One Side Only dugme
//      Ceka da se pojavi dijalog sa slikom
//      Klik na Done
//      Ponoviti proces za Left, Right i Back
//      Zatim iz desnog gornjeg ugla izabrati random jedan od ponudjenih konfeta
//      Kliknuti na Add To Cart dugme
//      Verifikovati postojanje greske Oops! It looks like you`ve not added an text to this field, please add one before continuing.
//      Xpath: //*[@action='error']
//      Zatvorite pretrazivac


		System.setProperty("webdriver.chrome.driver",  "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      driver.navigate().to("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");

      driver.findElement(By.xpath("//img[@alt='image 1']")).click();
      driver.findElement(By.xpath("//img[contains(@alt, '+ Add photo')]")).click();
      driver.findElement(By.id("imageUpload"))
              .sendKeys(new File("img/front_milica_petrovic.jpg").getAbsolutePath());
      Thread.sleep(2000);
      driver.findElement(By.xpath("//div[contains(@class, 'fqhTDx')]/div[1]")).click();
      wait.until(ExpectedConditions
              .visibilityOfElementLocated(By.xpath("//div[contains(@class, 'gMENHs')]")));
      driver.findElement(By.xpath("//button[contains(text(), 'Use One Side Only')]")).click();
      wait.until(ExpectedConditions
              .visibilityOfElementLocated(By.xpath("//div[contains(@class, 'cropper-modal')]")));
      driver.findElement(By.xpath("//button[text()='Done']")).click();

      driver.findElement(By.xpath("//img[@alt='image 2']")).click();
      driver.findElement(By.xpath("//img[contains(@alt, '+ Add photo')]")).click();
      driver.findElement(By.id("imageUpload"))
              .sendKeys(new File("img/left_milica_petrovic.png").getAbsolutePath());
      Thread.sleep(2000);
      driver.findElement(By.xpath("//div[contains(@class, 'fqhTDx')]/div[1]")).click();
      wait.until(ExpectedConditions
              .visibilityOfElementLocated(By.xpath("//div[contains(@class, 'gMENHs')]")));
      driver.findElement(By.xpath("//button[contains(text(), 'Use One Side Only')]")).click();
      wait.until(ExpectedConditions
              .visibilityOfElementLocated(By.xpath("//div[contains(@class, 'cropper-modal')]")));
      driver.findElement(By.xpath("//button[text()='Done']")).click();

      driver.findElement(By.xpath("//img[@alt='image 3']")).click();
      driver.findElement(By.xpath("//img[contains(@alt, '+ Add photo')]")).click();
      driver.findElement(By.id("imageUpload"))
              .sendKeys(new File("img/back_milica_petrovic.jpg").getAbsolutePath());
      Thread.sleep(2000);
      driver.findElement(By.xpath("//div[contains(@class, 'fqhTDx')]/div[1]")).click();
      wait.until(ExpectedConditions
              .visibilityOfElementLocated(By.xpath("//div[contains(@class, 'gMENHs')]")));
      driver.findElement(By.xpath("//button[contains(text(), 'Use One Side Only')]")).click();
      wait.until(ExpectedConditions
              .visibilityOfElementLocated(By.xpath("//div[contains(@class, 'cropper-modal')]")));
      driver.findElement(By.xpath("//button[text()='Done']")).click();

      driver.findElement(By.xpath("//img[@alt='image 4']")).click();
      driver.findElement(By.xpath("//img[contains(@alt, '+ Add photo')]")).click();
      driver.findElement(By.id("imageUpload"))
              .sendKeys(new File("img/right_milica_petrovic.jpg").getAbsolutePath());
      Thread.sleep(2000);
      driver.findElement(By.xpath("//div[contains(@class, 'fqhTDx')]/div[1]")).click();
      wait.until(ExpectedConditions
              .visibilityOfElementLocated(By.xpath("//div[contains(@class, 'gMENHs')]")));
      driver.findElement(By.xpath("//button[contains(text(), 'Use One Side Only')]")).click();
      wait.until(ExpectedConditions
              .visibilityOfElementLocated(By.xpath("//div[contains(@class, 'cropper-modal')]")));
      driver.findElement(By.xpath("//button[text()='Done']")).click();

      Random random = new Random();
      driver.findElement(By.xpath("//div[@name=" + random.nextInt(4) + "]")).click();
      driver.findElement(By.xpath("//button[contains(@class, 'gNSlAh')]")).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@action='error']")));

      driver.quit();


		
		
	}

}
