package d15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		
		
//
//2.Zadatak
//Napisati program koji ucitava stranicu https://geodata.solutions/
//Bira Country, State i City po vasoj zelji
//Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//Izabrerit Country, State i City tako da imate podatke da selektujete!
		
		System.setProperty("webdriver.chrome.driver",  "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
				
		
		driver.navigate().to("https://www.plus2net.com/jquery/msg-demo/dropdown3.php");

        driver.findElement(By.id("country_code")).click();
        driver.findElement(By.xpath("//select[@id='country_code']/option[@value='AUS']"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.id("state_id")).click();
        driver.findElement(By.xpath("//select[@id='state_id']/option[@value='49']"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.id("city_id")).click();
        driver.findElement(By.xpath("//select[@id='city_id']/option[@value='131']"))
                .click();

        driver.quit();





	}

}
