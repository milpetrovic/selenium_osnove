package d20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyBoxPage {
	
	private WebDriver driver;
    private WebDriverWait wait;
    
	public BuyBoxPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	
	 public WebElement getQuantityInput () {
			return driver.findElement(By.id("quantity_wanted"));
	 }
	 
	
	 
	 public void getSizeInput (String size) {
		    driver.findElement(By.id("group_1")).click();
		   wait.until(ExpectedConditions.visibilityOf(driver
				   .findElement(By.xpath("//option[@title = '" + size + "']")))).click();
	 }
	 
	 public WebElement getAddToCartButton () {
			return driver.findElement(By.id("add_to_cart"));
	 }
	 
		 		 		 
	 public WebElement getAddToWishlistButton () {
			return driver.findElement(By.id("wishlist_button"));
	 }
	 
	 public WebElement getColourButton (String colour) {
		 return driver.findElement(By.xpath("//a[@title = '" + colour + "']"));
	 }
	 
	 public void scrollToBuyBox() {
		 Actions actions = new Actions(driver);
		 actions.moveToElement(driver.findElement(By.className("box-info-product")));
		 actions.perform();
	 }
    
    

}
