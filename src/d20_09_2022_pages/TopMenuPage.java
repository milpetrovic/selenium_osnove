package d20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenuPage {
	
	private WebDriver driver;
    private WebDriverWait wait;
    
    
	public TopMenuPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getWomenButton () {
		return driver.findElement(By.xpath("//a[@title = 'Women']"));
 }
	
	public WebElement getDressesButton () {
		return driver.findElement(By.xpath("//a[@title = 'Dresses']"));
}
	
	public void getTshirtsButton () {
		new Actions(driver)
        .moveToElement(driver.findElement(By.xpath("//a[@title= 'T-shirts']")))
        .perform();
 }
	
	public void getMenuForWomenButton () {
		 new Actions(driver)
         .moveToElement(driver.findElement(By.xpath("//a[@title = 'Women']")))
         .perform();
 }
	
	public void getMenuForDressesButton () {
		 new Actions(driver)
         .moveToElement(driver.findElement(By.xpath("(//a[@title = 'Dresses'])[1]")))
         .perform();
 }
 
    
    

}
