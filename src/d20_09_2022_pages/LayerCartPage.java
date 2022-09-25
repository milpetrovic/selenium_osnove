package d20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LayerCartPage {
	
	private WebDriver driver;
    private WebDriverWait wait;
    
    
	public LayerCartPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getContinueShoppingButton () {
		return driver.findElement(By.xpath("//span[@title = 'Continue shopping']"));
 }
	
	public WebElement getProceedToCheckoutButton () {
		return driver.findElement(By.xpath("//a[@title = 'Proceed to checkout']"));
 }
	
	public WebElement getProductAttributes () {
		return driver.findElement(By.id("layer_cart_product_title"));
 }
	
	public WebElement getProductQuantity () {
		return driver.findElement(By.id("layer_cart_product_quantity"));
 }
	
	public WebElement getProductTotalPrice () {
		return driver.findElement(By.id("layer_cart_product_price"));
 }
	
	public void waitForDialogToBeVisible() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("layer_cart")));
        
}
	
	public void waitForDialogToBeInvisible() {
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.id("layer_cart")));
        
}
	
	
	
	
	
}	
